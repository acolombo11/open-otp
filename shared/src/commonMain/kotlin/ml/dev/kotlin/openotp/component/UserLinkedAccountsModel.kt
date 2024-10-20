package ml.dev.kotlin.openotp.component

import androidx.compose.ui.graphics.vector.ImageVector
import dev.icerock.moko.resources.StringResource
import kotlinx.serialization.Serializable
import ml.dev.kotlin.openotp.backup.*
import ml.dev.kotlin.openotp.shared.OpenOtpResources
import ml.dev.kotlin.openotp.ui.OtpIcons
import ml.dev.kotlin.openotp.ui.icons.Dropbox
import ml.dev.kotlin.openotp.ui.icons.OneDrive

@Serializable
data class UserLinkedAccountsModel(
    val dropbox: DropboxRefreshableAccessData? = null,
    val onedrive: OneDriveRefreshableAccessData? = null,
)

enum class UserLinkedAccountType(
    val icon: ImageVector,
    val res: StringResource,
    val reset: (UserLinkedAccountsModel) -> UserLinkedAccountsModel,
    val isLinked: (UserLinkedAccountsModel) -> Boolean,
    val createService: () -> OAuth2AccountService.Initialized,
    val createAuthenticatedService: (UserLinkedAccountsModel) -> OAuth2AccountService.Authenticated?,
) {
    Dropbox(
        icon = OtpIcons.Dropbox,
        res = OpenOtpResources.strings.dropbox_name,
        reset = { it.copy(dropbox = null) },
        isLinked = { it.dropbox != null },
        createService = { DropboxService.Initialized },
        createAuthenticatedService = { it.dropbox?.let(DropboxService::Authenticated) },
    ),
    OneDrive(
        icon = OtpIcons.OneDrive,
        res = OpenOtpResources.strings.onedrive_name,
        reset = { it.copy(onedrive = null) },
        isLinked = { it.onedrive != null },
        createService = { OneDriveService.Initialized },
        createAuthenticatedService = { it.onedrive?.let(OneDriveService::Authenticated) },
    ),
}