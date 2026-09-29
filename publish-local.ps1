<#
.SYNOPSIS
    Publishes cameraK and qrScannerPlugin to Maven Local for local development use.
.DESCRIPTION
    Builds and publishes the KBA-adapted Kamera artifacts (Android release/debug AAR,
    Desktop JVM JAR, KMP metadata) to ~/.m2/repository without requiring GPG signing
    or Dokka documentation generation.

    iOS targets (iosArm64, iosX64, iosSimulatorArm64) are skipped automatically on
    non-macOS machines — run on macOS + Xcode to include iOS KLIBs.
.EXAMPLE
    .\publish-local.ps1
#>

$ErrorActionPreference = "Stop"

Set-Location -Path $PSScriptRoot

Write-Host "Publishing cameraK and qrScannerPlugin to Maven Local..." -ForegroundColor Cyan

& "$PSScriptRoot/gradlew" --no-daemon `
    :cameraK:publishToMavenLocal `
    :qrScannerPlugin:publishToMavenLocal `
    -x dokkaGeneratePublicationHtml `
    -x dokkaGenerateModuleHtml `
    @args

if ($LASTEXITCODE -eq 0) {
    Write-Host "`nSuccessfully published Kamera KBA artifacts to Maven Local!" -ForegroundColor Green
    Write-Host "  io.github.kashif-mehmood-km:camerak:1.2" -ForegroundColor Gray
    Write-Host "  io.github.kashif-mehmood-km:qr_scanner_plugin:1.2" -ForegroundColor Gray
} else {
    Write-Host "`nFailed to publish (Exit code: $LASTEXITCODE)." -ForegroundColor Red
    exit $LASTEXITCODE
}
