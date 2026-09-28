
rootProject.name = "CameraCompose"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        maven("https://mirrors.tencent.com/nexus/repository/maven-tencent")
        maven("https://mirrors.tencent.com/nexus/repository/maven-public")
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
                includeGroupByRegex("android.*")
            }
        }
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        maven("https://mirrors.tencent.com/nexus/repository/maven-tencent")
        maven("https://mirrors.tencent.com/nexus/repository/maven-public")
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
                includeGroupByRegex("android.*")
            }
        }
        mavenCentral()
    }
}
includeBuild("convention-plugins")
include(":cameraK")
include(":Sample")
include(":ImageSaverPlugin")
include(":qrScannerPlugin")
include(":analyzerPlugin")

include("ocrPlugin")
include(":videoRecorderPlugin")
