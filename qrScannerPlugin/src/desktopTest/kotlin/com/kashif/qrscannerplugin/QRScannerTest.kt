package com.kashif.qrscannerplugin

import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
import com.google.zxing.client.j2se.MatrixToImageWriter
import java.awt.image.BufferedImage
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class QRScannerTest {

    @Test
    fun scanImage_decodesQrImageText() {
        val qrImage =
            MatrixToImageWriter.toBufferedImage(
                QRCodeWriter().encode("kamera-kba-baseline", BarcodeFormat.QR_CODE, 200, 200),
            )

        assertEquals("kamera-kba-baseline", QRScanner().scanImage(qrImage))
    }

    @Test
    fun scanImage_returnsNullForImageWithoutQrCode() {
        val blankImage = BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB)

        assertNull(QRScanner().scanImage(blankImage))
    }
}
