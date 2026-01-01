package com.yoon6.nanocharts.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.toColorInt
import com.yoon6.nanocharts.model.BarPrices

class NanoChart(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {
    private var bars = listOf<BarPrices>()

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

    fun setBars(bars: List<BarPrices>) {
        this.bars = bars
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val candleWidth = 30f
        val spacing = 50f
        val startX = 100f

        bars.forEachIndexed { index, candle ->
            val x = startX + index * spacing

            // 가격을 Y좌표로 변환 (임시로 고정 비율)
            val scale = 3f
            val baseY = height / 2f

            val highY = baseY - candle.high * scale
            val lowY = baseY - candle.low * scale
            val openY = baseY - candle.open * scale
            val closeY = baseY - candle.close * scale

            // Wick 그리기
            canvas.drawLine(x, highY, x, lowY, wickPaint)

            // Body 그리기
            val bodyTop = minOf(openY, closeY)
            val bodyBottom = maxOf(openY, closeY)
            val isRising = candle.close >= candle.open

            canvas.drawRect(
                x - candleWidth / 2,
                bodyTop,
                x + candleWidth / 2,
                bodyBottom,
                if (isRising) bullishPaint else bearishPaint
            )
        }
    }

}