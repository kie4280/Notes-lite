package com.kie.noteslite

import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val pdfPageCount: Int = 0) :
    RecyclerView.Adapter<RecyclerAdapter.PdfPageHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PdfPageHolder {
        val newView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.pdf_recycler_item, parent, false)
        newView.findViewById<ImageView>(R.id.pdfCanvas)
            .setImageResource(R.drawable.ic_launcher_background)
        return PdfPageHolder(newView)
    }

    override fun onBindViewHolder(holder: PdfPageHolder, position: Int) {
        val pdfCanvas = holder.itemView.findViewById<ImageView>(R.id.pdfCanvas)
        pdfCanvas.setImageResource(R.drawable.ic_launcher_background)
    }

    override fun getItemCount(): Int {
        return pdfPageCount
    }


    class PdfPageHolder(private val pageView: View) : RecyclerView.ViewHolder(pageView) {

    }
}

class RecyclerTouchHandler() : RecyclerView.OnItemTouchListener {
    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        return false
    }

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {

    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {

    }


}