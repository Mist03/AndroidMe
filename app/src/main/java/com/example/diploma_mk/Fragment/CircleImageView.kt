package com.example.diploma_mk.Fragment

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

class CircleImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    private val path = Path()

    override fun onDraw(canvas: Canvas?) {
        if (canvas == null) return

        val radius = width.coerceAtMost(height) / 2f
        path.reset()
        path.addCircle(width / 2f, height / 2f, radius, Path.Direction.CW)
        canvas.clipPath(path)
        super.onDraw(canvas)
    }
}
