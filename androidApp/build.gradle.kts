import com.android.build.api.dsl.ApplicationExtension
import java.lang.System.getenv

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    jvmToolchain(libs.versions.java.get().toInt())
}

extensions.configure<ApplicationExtension> {
    compileSdk = libs.versions.android.targetSdk.get().toInt()
    namespace = "ml.dev.kotlin.openotp"

    defaultConfig {
        applicationId = "ml.dev.kotlin.openotp.OpenOtp"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = getAndBumpVersionCode()
        versionName = getenv()["VERSION"] ?: "1.0.0"
    }
    compileOptions {
        val javaVersion = JavaVersion.toVersion(libs.versions.java.get().toInt())
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    packaging {
        resources {
            excludes += "META-INF/versions/**"
        }
        jniLibs {
            // Force legacy packaging (compression) for native libraries.
            // This is a workaround for third-party libraries (like ML Kit) that are not yet
            // 16 KB page-aligned. When compressed, the Android OS extracts and aligns them
            // correctly at install time on 16 KB devices.
            useLegacyPackaging = true
        }
    }
}

dependencies {
    implementation(projects.shared)
}

fun getAndBumpVersionCode(): Int {
    val code = libs.versions.versionCode.get().toInt()
    val bump = getenv()["BUMP_FILE_VERSION_CODE"]?.toBooleanStrictOrNull() ?: false
    if (!bump) return code

    val file = File("gradle/libs.versions.toml")
    val updatedFile = file.readLines().map { line ->
        if (!line.startsWith("versionCode")) return@map line

        val currentVersionCode = line
            .dropWhile { it != '"' }
            .removePrefix("\"")
            .takeWhile { it != '"' }
            .toInt()
        if (currentVersionCode != code) throw IllegalStateException("Two different version codes: $code vs $currentVersionCode")

        """versionCode = "${currentVersionCode + 1}""""
    }.joinToString(separator = "\n")
    file.writeText(updatedFile)
    return code
}
