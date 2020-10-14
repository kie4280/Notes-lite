package com.kie.noteslite

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class PDFView : View {

    private var ZoomLevel: Double = 75.0
    private var MaxZoom: Double = 10000.0
    private var MinZoom: Double = 5.0
    private val pagePadding: Double = 10.0
    private val backgroundPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply { color = Color.GRAY }
    private val backgroundRect: Rect = Rect(0, 0, width, height)
    private val blankPage: Bitmap =
        BitmapFactory.decodeResource(resources, R.drawable.ic_launcher_background)

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    @Override
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val newwidth = measuredWidth.toDouble() * ZoomLevel;
        val newHeight = measuredHeight.toDouble() * ZoomLevel
        backgroundRect.set(0, 0, width, height)
        canvas!!.drawRect(backgroundRect, backgroundPaint)
        canvas.
    }

    @Override
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    @Override
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)
    }

}