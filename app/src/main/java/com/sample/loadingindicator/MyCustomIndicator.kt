package com.sample.loadingindicator

import android.animation.ValueAnimator
import android.graphics.Canvas
import android.graphics.Paint
import com.loadingindicator.Indicator
import kotlin.math.min

class MyCustomIndicator : Indicator() {

    //scale x ,y
    private val scaleFloats = floatArrayOf(
        SCALE,
        SCALE,
        SCALE,
        SCALE,
        SCALE
    )


    override fun draw(canvas: Canvas, paint: Paint) {
        val circleSpacing = 4f
        val radius = ((min(width.toDouble(), height.toDouble()) - circleSpacing * 2) / 12).toFloat()
        val x = width / 2 - (radius * 2 + circleSpacing)
        val y = (height / 2).toFloat()
        for (i in 0..3) {
            canvas.save()
            val translateX = x + radius * 2 * i + circleSpacing * i
            canvas.translate(translateX, y)
            canvas.scale(scaleFloats[i], scaleFloats[i])
            canvas.drawCircle(0f, 0f, radius, paint)
            canvas.restore()
        }
    }

    override fun onCreateAnimators(): ArrayList<ValueAnimator> {
        val animators = ArrayList<ValueAnimator>()
        val delays = intArrayOf(120, 240, 360, 480)
        (0..3).forEach { i ->

            val scaleAnim = ValueAnimator.ofFloat(1f, 0.3f, 1f)

            scaleAnim.setDuration(750)
            scaleAnim.repeatCount = -1
            scaleAnim.startDelay = delays[i].toLong()

            addUpdateListener(
                scaleAnim
            ) { animation ->
                scaleFloats[i] = animation.animatedValue as Float
                postInvalidate()
            }
            animators.add(scaleAnim)
        }
        return animators
    }


    companion object {
        const val SCALE: Float = 1.0f
    }
}
