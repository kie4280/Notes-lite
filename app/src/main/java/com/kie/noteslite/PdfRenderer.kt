package com.kie.noteslite

import android.graphics.Bitmap
import android.graphics.pdf.PdfRenderer
import android.os.ParcelFileDescriptor
import java.io.File

class PdfRenderer(val dest: File) {

    @Suppress("DEPRECATION")
    private val fileDesc = ParcelFileDescriptor.open(dest, ParcelFileDescriptor.MODE_READ_ONLY)
    private val pdfrend = android.graphics.pdf.PdfRenderer(fileDesc)

    fun getPage(page: Int, screenWidth: Int, screenHeight: Int): Bitmap {
        val p = pdfrend.openPage(page)
        val bitmap = Bitmap.createBitmap(
            screenWidth,
            (screenWidth.toFloat() * p.height / p.width).toInt(),
            Bitmap.Config.ARGB_8888
        )
        p.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)
        p.close()

        return bitmap

    }

    fun getPageCount(): Int {
        return pdfrend.pageCount
    }

    fun close() {
        pdfrend.close()
    }
}