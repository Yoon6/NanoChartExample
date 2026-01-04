package com.yoon6.nanocharts.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View
import androidx.core.graphics.toColorInt
import com.yoon6.nanocharts.model.BarPrices

class NanoChart(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {
    private var bars = listOf<BarPrices>()
    private var barSpacing = 20f
    private var scrollOffset = 0f
    private var lastTouchX = 0f
    private val scaleDetector = ScaleGestureDetector(context, ScaleListener())

    private val wickPaint = Paint().apply {
        color = Color.BLACK
        strokeWidth = 2f
    }

    private val bullishPaint = Paint().apply {
        color = "#26A69A".toColorInt() // 녹색
        style = Paint.Style.FILL
    }

    private val bearishPaint = Paint().apply {
        color = "#EF5350".toColorInt() // 빨강
        style = Paint.Style.FILL
    }

    private inner class ScaleListener : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector): Boolean {
            barSpacing = (barSpacing * detector.scaleFactor)
                .coerceIn(5f, 100f)

            invalidate()
            return true
        }
    }

    // Visible range만 계산
    private fun getVisibleRange(): Pair<Int, Int> {
        val startIndex = (scrollOffset / barSpacing).toInt()
            .coerceIn(0, bars.size - 20)

        val visibleCount = (width / barSpacing).toInt() + 2
        val endIndex = (startIndex + visibleCount)
            .coerceAtMost(bars.size - 1)

        return startIndex to endIndex
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        scaleDetector.onTouchEvent(event)

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                lastTouchX = event.x
            }

            MotionEvent.ACTION_MOVE -> {
                if (!scaleDetector.isInProgress) {
                    // Pan
                    val dx = event.x - lastTouchX
                    val maxX = (barSpacing * bars.size - width).coerceAtLeast(0f)
                    scrollOffset = (scrollOffset - dx).coerceIn(0f, maxX)

                    invalidate()
                    lastTouchX = event.x
                }
            }
        }

        return true
    }


    // 좌표 변환 함수
    private fun priceToY(price: Float, minPrice: Float, maxPrice: Float): Float {
        val priceRange = maxPrice - minPrice
        val ratio = (price - minPrice) / priceRange
        return height * (1f - ratio) // 위쪽이 높은 가격
    }

    fun setBars(bars: List<BarPrices>) {
        this.bars = bars
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (bars.isEmpty()) return


        val (startIndex, endIndex) = getVisibleRange()
        val visibleBars = bars.subList(startIndex, endIndex)


        val minPrice = visibleBars.minOf { minOf(it.low, it.open, it.close) }
        val maxPrice = visibleBars.maxOf { maxOf(it.high, it.open, it.close) }


        visibleBars.forEachIndexed { index, candle ->

            val x = index * barSpacing + barSpacing / 2

            val highY = priceToY(candle.high, minPrice, maxPrice)
            val lowY = priceToY(candle.low, minPrice, maxPrice)
            val openY = priceToY(candle.open, minPrice, maxPrice)
            val closeY = priceToY(candle.close, minPrice, maxPrice)

            // Wick 그리기
            canvas.drawLine(x, highY, x, lowY, wickPaint)

            // Body 그리기
            val barWidth = (barSpacing * 0.7f).coerceIn(1f, 50f)
            val bodyTop = minOf(openY, closeY)
            val bodyBottom = maxOf(openY, closeY)
            val isRising = candle.close >= candle.open

            canvas.drawRect(
                x - barWidth / 2,
                bodyTop,
                x + barWidth / 2,
                bodyBottom,
                if (isRising) bullishPaint else bearishPaint
            )
        }
    }

}