@file:Suppress("ClassName", "ClassName", "ClassName")

package com.example.pdfviewer

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.pdf.PdfRenderer
import android.os.Bundle
import android.os.ParcelFileDescriptor
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.barteksc.pdfviewer.PDFView
import java.io.*


class act1 : AppCompatActivity() {
    var pdf: ImageView? = null
    var renderPage:PdfRenderer.Page?=null
    private var pdfRenderer: PdfRenderer? = null
    val book:String="Heart-of-Darkness.pdf"
    var sum = 0
    var sum_1:Int?=null
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act1)
        supportActionBar?.hide()
        val b1:Button=findViewById(R.id.button)
        val b2:Button=findViewById(R.id.button2)
        val pdf_1: PDFView = findViewById(R.id.pdfView)
        pdf = findViewById(R.id.pd)
        pdf!!.visibility = View.INVISIBLE
        pdf_1.visibility=View.INVISIBLE

        b1.setOnClickListener {
            pdf_1.visibility=View.INVISIBLE
            pdf!!.visibility=View.VISIBLE
            openPDF(sum)
            try {
                pdf!!.setOnClickListener {
                    sum += 1
                    openPDF(sum)
                }
                pdf!!.setOnLongClickListener {
                    val a = true
                    if (sum > 0) {
                        sum -= 1
                        openPDF(sum)
                    } else {
                        sum = 0
                        openPDF(sum)
                    }
                    true
                }
            } catch (e: IOException) {
                e.printStackTrace()
                Toast.makeText(
                    this,
                    "Something Wrong: $e",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        fun vertical() {
            pdf!!.visibility = View.INVISIBLE
            pdf_1.visibility = View.VISIBLE
            pdf_1.fromAsset(book).pages(0, 2, 1, 3, 3, 3) // all pages are displayed by default
                // all pages are displayed by default
                .enableSwipe(true) // allows to block changing pages using swipe
                .enableDoubletap(true)
                .defaultPage(0)
                .enableAnnotationRendering(true) // render annotations (such as comments, colors or forms)
                .password(null)
                .scrollHandle(null)
                .enableAntialiasing(false) // improve rendering a little bit on low-res screens
                // spacing between pages in dp. To define spacing color, set view background
                .spacing(10)
                .load()
        }
        vertical()
        b2.setOnClickListener{
            vertical()
            if(sum>0)
            {
                sum_1=sum

            }
        }

    }
    private fun openPDF(sum:Int) {
        val a= this.assets.open(book)
        val fileCopy = File(cacheDir,"temp.pdf")
        val b:FileOutputStream = FileOutputStream(fileCopy)
        copyFile(a, b)
        var fileDescriptor: ParcelFileDescriptor? = null
        fileDescriptor = ParcelFileDescriptor.open(
                fileCopy, ParcelFileDescriptor.MODE_READ_ONLY)
        pdfRenderer = PdfRenderer(fileDescriptor)
        val pageCount: Int = pdfRenderer!!.pageCount
        Toast.makeText(this,
                "pageCount = $pageCount",
                Toast.LENGTH_LONG).show()
        sum_1=sum
        val rendererPage: PdfRenderer.Page = pdfRenderer!!.openPage(sum)
        val rendererPageWidth = rendererPage.width
        val rendererPageHeight = rendererPage.height
        val bitmap: Bitmap = Bitmap.createBitmap(
                rendererPageWidth,
                rendererPageHeight,
                Bitmap.Config.ARGB_8888)
        rendererPage.render(bitmap, null, null,
                PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)
        pdf!!.setImageBitmap(bitmap)
        rendererPage.close()
        pdfRenderer!!.close()
        fileDescriptor.close()
    }
    private fun copyFile(`in`: InputStream, out: OutputStream?) {
        val buffer = ByteArray(1024)
        var read: Int
        while (`in`.read(buffer).also { read = it } != -1) {
            out!!.write(buffer, 0, read)
        }
    }


}
