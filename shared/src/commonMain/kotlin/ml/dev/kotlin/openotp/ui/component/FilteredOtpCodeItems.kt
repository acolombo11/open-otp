package ml.dev.kotlin.openotp.ui.component

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.CloudDone
import androidx.compose.material.icons.outlined.CloudOff
import androidx.compose.material.icons.outlined.CloudUpload
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import dev.icerock.moko.resources.compose.stringResource
import ml.dev.kotlin.openotp.component.LinkedAccountsSyncState
import ml.dev.kotlin.openotp.component.LinkedAccountsSyncState.*
import ml.dev.kotlin.openotp.otp.OtpData
import ml.dev.kotlin.openotp.otp.PresentedOtpCodeData
import ml.dev.kotlin.openotp.shared.OpenOtpResources
import ml.dev.kotlin.openotp.ui.component.DragDropListData.Companion.emptyDragDropListData

@Composable
internal fun FilteredOtpCodeItems(
    padding: PaddingValues,
    codeData: PresentedOtpCodeData,
    timestamp: Long,
    confirmCodeDismiss: Boolean,
    isSearchActive: Boolean,
    syncState: LinkedAccountsSyncState,
    onOtpCodeDataDismiss: (OtpData) -> Boolean,
    onSearchBarActiveChange: (Boolean) -> Unit,
    onRestartCode: (OtpData) -> Unit,
    onMoveCode: (Int, Int) -> Unit,
    onSettingsIconClick: () -> Unit,
    onCloudBackupClick: () -> Unit,
    copyOtpCode: ClipboardManager.(item: OtpData, timestamp: Long) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = padding.calculateTopPadding())
            .semantics { isTraversalGroup = true }
            .zIndex(1f),
        contentAlignment = Alignment.TopCenter,
    ) {
        var searchQuery by rememberSaveable { mutableStateOf("") }
        val filteredCodeData = remember(searchQuery, codeData) filtered@{
            if (searchQuery.isEmpty()) emptyDragDropListData() else codeData.filter {
                it.accountName?.contains(searchQuery, ignoreCase = true) == true ||
                        it.issuer?.contains(searchQuery, ignoreCase = true) == true
            }
        }
        val interactionSource = remember { MutableInteractionSource() }
        SearchBar(
            query = searchQuery,
            onQueryChange = { searchQuery = it },
            active = isSearchActive,
            onActiveChange = onSearchBarActiveChange,
            placeholder = {
                Text(
                    text = stringResource(OpenOtpResources.strings.search_field),
                    style = searchBarTextStyle(enabled = false, interactionSource)
                )
            },
            leadingIcon = {
                when (isSearchActive) {
                    false -> Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = stringResource(OpenOtpResources.strings.search_icon_name),
                    )

                    true -> IconButton(
                        onClick = {
                            onSearchBarActiveChange(false)
                            searchQuery = ""
                        },
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(OpenOtpResources.strings.back_icon_name)
                        )
                    }
                }
            },
            trailingIcon = {
                if (isSearchActive && searchQuery.isNotEmpty()) {
                    IconButton(onClick = { searchQuery = "" }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = stringResource(OpenOtpResources.strings.remove_icon_name),
                        )
                    }
                } else if (!isSearchActive) {
                    Row {
                        when (syncState) {
                            Synced -> Icons.Outlined.CloudDone
                            Refreshing -> Icons.Outlined.CloudUpload
                            NotSynced -> Icons.Outlined.CloudOff
                            NothingToSync -> null
                        }?.let { imageVector ->
                            IconButton(
                                onClick = onCloudBackupClick,
                                modifier = Modifier.offset(x = 12.dp),
                            ) {
                                Icon(
                                    imageVector = imageVector,
                                    contentDescription = stringResource(OpenOtpResources.strings.backups_state),
                                )
                            }
                        }
                        IconButton(onSettingsIconClick) {
                            Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = stringResource(OpenOtpResources.strings.settings_name),
                            )
                        }
                    }
                }
            },
            interactionSource = interactionSource,
        ) {
            val listState = rememberLazyListState()
            val dragDropState = rememberDragDropState(listState, onMoveCode)
            OtpCodeItems(
                codeData = filteredCodeData,
                timestamp = timestamp,
                confirmCodeDismiss = confirmCodeDismiss,
                isDragAndDropEnabled = false,
                showSortedGroupsHeaders = false,
                onOtpCodeDataDismiss = onOtpCodeDataDismiss,
                onRestartCode = onRestartCode,
                copyOtpCode = copyOtpCode,
                dragDropState = dragDropState,
                contentPadding = PaddingValues(
                    bottom = padding.calculateBottomPadding(),
                    top = OtpCodeItemVerticalSpacing,
                )
            )
        }
    }
}
