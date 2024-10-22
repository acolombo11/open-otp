package ml.dev.kotlin.openotp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.text.input.EditCommand
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import dev.icerock.moko.resources.compose.stringResource
import `in`.procyk.compose.camera.permission.CameraPermission.Denied
import `in`.procyk.compose.camera.permission.CameraPermission.Granted
import `in`.procyk.compose.camera.permission.rememberCameraPermissionState
import ml.dev.kotlin.openotp.component.LinkedAccountsSyncState
import ml.dev.kotlin.openotp.component.MainComponent
import ml.dev.kotlin.openotp.otp.OtpData
import ml.dev.kotlin.openotp.otp.PresentedOtpCodeData
import ml.dev.kotlin.openotp.shared.OpenOtpResources
import ml.dev.kotlin.openotp.ui.component.*

@Composable
internal fun MainScreen(mainComponent: MainComponent) {
    SnackScaffold { padding ->
        val cameraPermissionState = rememberCameraPermissionState()
        val navigateToScanQRCodeWhenCameraPermissionChanged by mainComponent.navigateToScanQRCodeWhenCameraPermissionChanged.subscribeAsState()

        val isGranted = cameraPermissionState.permission.isGranted
        LaunchedEffect(isGranted) {
            if (isGranted && navigateToScanQRCodeWhenCameraPermissionChanged) {
                mainComponent.onScanQRCodeClick()
            }
        }

        val codeData by mainComponent.codeData.subscribeAsState()
        val timestamp by mainComponent.timestamp.subscribeAsState()
        val confirmOtpDataDelete by mainComponent.confirmOtpDataDelete.subscribeAsState()
        val isSearchActive by mainComponent.isSearchActive.subscribeAsState()
        val syncState by mainComponent.linkedAccountsSyncState.subscribeAsState()
        FilteredOtpCodeItems(
            padding = padding,
            codeData = codeData,
            timestamp = timestamp,
            confirmCodeDismiss = confirmOtpDataDelete,
            isSearchActive = isSearchActive,
            syncState = syncState,
            onOtpCodeDataDismiss = mainComponent::onOtpCodeDataRemove,
            onOtpCodeDataEdit = mainComponent::onOtpCodeDataEdit,
            onSearchBarActiveChange = mainComponent::onSearchBarActiveChange,
            onRestartCode = mainComponent::onOtpCodeDataRestart,
            onMoveCode = mainComponent::onOtpCodeDataReordered,
            copyOtpCode = mainComponent::copyOtpCode,
            onSettingsIconClick = mainComponent::onSettingsClick,
            onCloudBackupClick = mainComponent::onRefresh
        )

        val listState = rememberLazyListState()
        val dragDropState = rememberDragDropState(listState, mainComponent::onOtpCodeDataReordered)
        val isDragAndDropEnabled by mainComponent.isDragAndDropEnabled.subscribeAsState()
        val showSortedGroupsHeaders by mainComponent.showSortedGroupsHeaders.subscribeAsState()
        AllOtpCodeItems(
            padding = padding,
            codeData = codeData,
            timestamp = timestamp,
            confirmCodeDismiss = confirmOtpDataDelete,
            isDragAndDropEnabled = isDragAndDropEnabled,
            showSortedGroupsHeaders = showSortedGroupsHeaders,
            onOtpCodeDataDismiss = mainComponent::onOtpCodeDataRemove,
            onOtpCodeDataEdit = mainComponent::onOtpCodeDataEdit,
            onRestartCode = mainComponent::onOtpCodeDataRestart,
            copyOtpCode = mainComponent::copyOtpCode,
            dragDropState = dragDropState,
            syncState = syncState,
            onRefresh = mainComponent::onRefresh,
        )
        AddActionButton(
            modifier = Modifier.padding(padding),
            dragDropState = dragDropState,
            visible = !isSearchActive,
            onScanQRCodeClick = {
                when (cameraPermissionState.permission) {
                    Granted -> mainComponent.onScanQRCodeClick()
                    Denied -> {
                        mainComponent.onRequestedCameraPermission()
                        cameraPermissionState.launchRequest()
                    }
                }
            }.takeIf { cameraPermissionState.isAvailable },
            onAddWithTextClick = mainComponent::onAddProviderClick,
        )
    }
}

@Composable
private fun AllOtpCodeItems(
    padding: PaddingValues,
    codeData: PresentedOtpCodeData,
    timestamp: Long,
    confirmCodeDismiss: Boolean,
    isDragAndDropEnabled: Boolean,
    showSortedGroupsHeaders: Boolean,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    onOtpCodeDataDismiss: (OtpData) -> Boolean,
    onOtpCodeDataEdit: (OtpData) -> Unit,
    onRestartCode: (OtpData) -> Unit,
    dragDropState: DragDropState,
    copyOtpCode: ClipboardManager.(item: OtpData, timestamp: Long) -> Unit,
    syncState: LinkedAccountsSyncState,
    onRefresh: () -> Unit,
) {
    val state = rememberPullRefreshState(syncState.isRefreshing, onRefresh, refreshingOffset = 68.dp)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .run { if (syncState.isSyncAvailable) pullRefresh(state) else this },
        contentAlignment = Alignment.TopCenter,
    ) {
        val paddingTop = padding.calculateTopPadding() + SearchBarVerticalPadding
        Box(
            modifier = Modifier
                .padding(top = paddingTop)
                .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            val contentPaddingTop = SearchBarStandardHeight + SearchBarVerticalPadding
            val bottom = padding.calculateBottomPadding() + MultiFabStandardHeight + OtpCodeItemVerticalSpacing
            if (!codeData.isEmpty) {
                OtpCodeItems(
                    contentPadding = PaddingValues(top = contentPaddingTop, bottom = bottom),
                    codeData = codeData,
                    timestamp = timestamp,
                    confirmCodeDismiss = confirmCodeDismiss,
                    isDragAndDropEnabled = isDragAndDropEnabled,
                    showSortedGroupsHeaders = showSortedGroupsHeaders,
                    onOtpCodeDataDismiss = onOtpCodeDataDismiss,
                    onOtpCodeDataEdit = onOtpCodeDataEdit,
                    onRestartCode = onRestartCode,
                    dragDropState = dragDropState,
                    copyOtpCode = copyOtpCode,
                )
            } else {
                Text(
                    modifier = Modifier.padding(top = contentPaddingTop, bottom = bottom),
                    text = stringResource(OpenOtpResources.strings.add_new_keys),
                )
            }
        }
        Column(
            modifier = Modifier
                .padding(top = paddingTop)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(SearchBarStandardHeight)
                    .background(
                        Brush.verticalGradient(
                            listOf(backgroundColor, Color.Transparent)
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(padding.calculateBottomPadding())
                    .background(
                        Brush.verticalGradient(
                            listOf(Color.Transparent, backgroundColor)
                        ),
                    ),
            )
        }
        if (syncState.isSyncAvailable) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(Modifier.height(SearchBarStandardHeight))
                PullRefreshIndicator(syncState.isRefreshing, state)
            }
        }
    }
}
