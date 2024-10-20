package ml.dev.kotlin.openotp.ui.component

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import dev.icerock.moko.resources.compose.stringResource
import ml.dev.kotlin.openotp.shared.OpenOtpResources

@Composable
fun TopBar(
    text: String? = null,
    center: Boolean = false,
    accent: Color = MaterialTheme.colorScheme.primary,
    onIconClick: (() -> Unit)? = null,
) {
    val title: @Composable () -> Unit = {
        Text(
            text = text.orEmpty(),
            style = MaterialTheme.typography.titleLarge,
        )
    }

    val navigationIcon: @Composable () -> Unit = onIconClick?.let {
        {
            IconButton(onClick = it) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(OpenOtpResources.strings.back_icon_name),
                    tint = contentColorFor(accent),
                )
            }
        }
    } ?: { }

    if (center) {
        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = accent,
                scrolledContainerColor = accent,
                titleContentColor = contentColorFor(accent),
                navigationIconContentColor = contentColorFor(accent),
            ),
            title = title,
            windowInsets = WindowInsets.statusBars,
            navigationIcon = navigationIcon,
        )
    } else {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = accent,
                scrolledContainerColor = accent,
                titleContentColor = contentColorFor(accent),
                navigationIconContentColor = contentColorFor(accent),
            ),
            title = title,
            windowInsets = WindowInsets.statusBars,
            navigationIcon = navigationIcon,
        )
    }
}