package com.yoon6.nanochartexample

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.yoon6.nanocharts.model.BarPrices
import com.yoon6.nanocharts.view.NanoChart

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bars = listOf(
            BarPrices(100f, 130f, 0f, 120f),
            BarPrices(120f, 125f, 105f, 110f),
            BarPrices(110f, 135f, 108f, 130f),
            BarPrices(130f, 140f, 120f, 125f),
            BarPrices(125f, 145f, 122f, 140f)
        )

        val chart = findViewById<NanoChart>(R.id.main_chart)
        chart.setBars(bars)

    }
}