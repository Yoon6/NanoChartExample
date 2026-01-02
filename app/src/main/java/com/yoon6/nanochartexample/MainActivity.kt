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
        val candles = listOf(
            BarPrices(open = 102.42f, high = 110.34f, low = 93.17f, close = 104.52f),
            BarPrices(open = 103.08f, high = 112.79f, low = 95.45f, close = 105.29f),
            BarPrices(open = 105.73f, high = 114.40f, low = 99.04f, close = 109.51f),
            BarPrices(open = 105.15f, high = 115.60f, low = 98.86f, close = 106.28f),
            BarPrices(open = 110.73f, high = 120.27f, low = 103.40f, close = 112.94f),
            BarPrices(open = 106.35f, high = 118.70f, low = 99.35f, close = 109.18f),
            BarPrices(open = 111.42f, high = 121.69f, low = 104.68f, close = 114.68f),
            BarPrices(open = 113.46f, high = 123.45f, low = 107.78f, close = 116.47f),
            BarPrices(open = 112.70f, high = 123.88f, low = 105.08f, close = 116.94f),
            BarPrices(open = 117.83f, high = 127.33f, low = 111.38f, close = 121.31f),
            BarPrices(open = 119.83f, high = 129.42f, low = 113.61f, close = 124.58f),
            BarPrices(open = 123.78f, high = 131.72f, low = 115.44f, close = 125.42f),
            BarPrices(open = 120.49f, high = 131.94f, low = 112.75f, close = 123.83f),
            BarPrices(open = 124.70f, high = 135.14f, low = 117.73f, close = 129.66f),
            BarPrices(open = 127.49f, high = 138.35f, low = 121.25f, close = 131.84f),
            BarPrices(open = 129.13f, high = 140.67f, low = 122.98f, close = 132.88f),
            BarPrices(open = 135.40f, high = 144.51f, low = 129.08f, close = 139.93f),
            BarPrices(open = 132.26f, high = 145.41f, low = 125.53f, close = 135.51f),
            BarPrices(open = 139.50f, high = 149.27f, low = 132.70f, close = 143.28f),
            BarPrices(open = 136.78f, high = 148.06f, low = 128.92f, close = 141.16f),
            BarPrices(open = 142.62f, high = 151.18f, low = 136.23f, close = 144.10f),
            BarPrices(open = 144.84f, high = 154.10f, low = 138.72f, close = 148.67f),
            BarPrices(open = 146.14f, high = 156.90f, low = 139.18f, close = 148.87f),
            BarPrices(open = 144.69f, high = 157.96f, low = 137.51f, close = 148.11f),
            BarPrices(open = 152.07f, high = 162.36f, low = 145.14f, close = 155.41f),
            BarPrices(open = 153.43f, high = 163.24f, low = 147.08f, close = 156.54f),
            BarPrices(open = 154.84f, high = 165.42f, low = 147.88f, close = 158.93f),
            BarPrices(open = 155.47f, high = 166.95f, low = 148.26f, close = 158.82f),
            BarPrices(open = 157.01f, high = 169.15f, low = 150.53f, close = 161.33f),
            BarPrices(open = 161.39f, high = 172.14f, low = 154.65f, close = 165.91f),
            BarPrices(open = 165.05f, high = 174.43f, low = 158.21f, close = 168.83f),
            BarPrices(open = 163.44f, high = 175.51f, low = 156.12f, close = 167.57f),
            BarPrices(open = 167.67f, high = 179.59f, low = 160.51f, close = 172.48f),
            BarPrices(open = 169.05f, high = 181.03f, low = 161.89f, close = 172.62f),
            BarPrices(open = 167.57f, high = 181.53f, low = 160.02f, close = 171.15f),
            BarPrices(open = 172.84f, high = 184.27f, low = 165.76f, close = 176.52f),
            BarPrices(open = 171.68f, high = 185.80f, low = 164.19f, close = 176.21f),
            BarPrices(open = 177.53f, high = 189.09f, low = 170.21f, close = 181.25f),
            BarPrices(open = 180.82f, high = 191.47f, low = 173.78f, close = 184.98f),
            BarPrices(open = 183.64f, high = 193.94f, low = 176.71f, close = 187.44f),
            BarPrices(open = 182.77f, high = 195.20f, low = 175.39f, close = 186.86f),
            BarPrices(open = 184.34f, high = 197.52f, low = 177.16f, close = 188.79f),
            BarPrices(open = 189.46f, high = 200.66f, low = 182.48f, close = 193.29f),
            BarPrices(open = 191.97f, high = 202.86f, low = 185.13f, close = 195.62f),
            BarPrices(open = 192.25f, high = 204.55f, low = 185.02f, close = 196.69f),
            BarPrices(open = 194.82f, high = 207.12f, low = 187.86f, close = 198.42f),
            BarPrices(open = 196.76f, high = 209.18f, low = 189.78f, close = 200.90f),
            BarPrices(open = 196.20f, high = 210.45f, low = 188.89f, close = 200.77f),
            BarPrices(open = 200.85f, high = 213.20f, low = 193.76f, close = 204.78f),
            BarPrices(open = 202.91f, high = 215.31f, low = 195.86f, close = 207.16f),
            BarPrices(open = 206.14f, high = 217.47f, low = 199.21f, close = 210.16f),
            BarPrices(open = 204.76f, high = 218.90f, low = 197.51f, close = 208.95f),
            BarPrices(open = 207.84f, high = 221.03f, low = 200.84f, close = 211.76f),
            BarPrices(open = 209.84f, high = 223.21f, low = 202.92f, close = 214.17f),
            BarPrices(open = 213.27f, high = 225.42f, low = 206.51f, close = 217.04f),
            BarPrices(open = 214.82f, high = 227.66f, low = 208.08f, close = 218.93f),
            BarPrices(open = 216.59f, high = 229.86f, low = 209.95f, close = 220.60f),
            BarPrices(open = 217.03f, high = 231.06f, low = 210.08f, close = 221.49f),
            BarPrices(open = 221.46f, high = 233.28f, low = 214.74f, close = 225.28f),
            BarPrices(open = 220.33f, high = 234.80f, low = 213.27f, close = 224.81f),
            BarPrices(open = 224.97f, high = 237.09f, low = 218.11f, close = 228.89f),
            BarPrices(open = 223.42f, high = 238.41f, low = 216.23f, close = 227.75f),
            BarPrices(open = 227.67f, high = 240.63f, low = 220.74f, close = 231.65f),
            BarPrices(open = 229.20f, high = 242.83f, low = 222.33f, close = 233.48f),
            BarPrices(open = 232.10f, high = 245.03f, low = 225.34f, close = 236.13f),
            BarPrices(open = 232.76f, high = 247.23f, low = 225.77f, close = 237.15f),
            BarPrices(open = 237.64f, high = 249.45f, low = 230.89f, close = 241.48f),
            BarPrices(open = 235.30f, high = 250.67f, low = 228.21f, close = 239.84f),
            BarPrices(open = 239.96f, high = 252.88f, low = 233.14f, close = 243.84f),
            BarPrices(open = 241.22f, high = 255.10f, low = 234.49f, close = 245.35f),
            BarPrices(open = 244.28f, high = 257.31f, low = 237.71f, close = 248.23f),
            BarPrices(open = 245.59f, high = 259.53f, low = 239.13f, close = 249.43f),
            BarPrices(open = 246.48f, high = 261.75f, low = 239.89f, close = 250.91f),
            BarPrices(open = 251.05f, high = 263.96f, low = 244.68f, close = 254.91f),
            BarPrices(open = 249.67f, high = 266.18f, low = 242.96f, close = 254.18f),
            BarPrices(open = 254.39f, high = 268.40f, low = 247.86f, close = 258.35f),
            BarPrices(open = 255.33f, high = 270.61f, low = 248.90f, close = 259.67f),
            BarPrices(open = 259.76f, high = 272.83f, low = 253.52f, close = 263.72f),
            BarPrices(open = 258.44f, high = 275.05f, low = 251.87f, close = 262.97f),
            BarPrices(open = 262.51f, high = 277.26f, low = 256.15f, close = 266.54f),
            BarPrices(open = 262.89f, high = 279.48f, low = 256.39f, close = 267.31f),
            BarPrices(open = 267.63f, high = 281.70f, low = 261.33f, close = 271.64f),
            BarPrices(open = 268.99f, high = 283.91f, low = 262.80f, close = 272.92f),
            BarPrices(open = 269.32f, high = 286.13f, low = 263.00f, close = 273.76f),
            BarPrices(open = 273.72f, high = 288.35f, low = 267.61f, close = 277.76f),
            BarPrices(open = 273.93f, high = 290.56f, low = 267.69f, close = 278.40f),
            BarPrices(open = 278.83f, high = 292.78f, low = 272.80f, close = 282.83f),
            BarPrices(open = 278.18f, high = 295.00f, low = 272.03f, close = 282.66f),
            BarPrices(open = 282.82f, high = 297.21f, low = 276.88f, close = 286.84f),
            BarPrices(open = 283.28f, high = 299.43f, low = 277.22f, close = 287.72f),
            BarPrices(open = 287.49f, high = 301.65f, low = 281.65f, close = 291.54f),
            BarPrices(open = 287.80f, high = 303.86f, low = 281.84f, close = 292.28f),
            BarPrices(open = 291.42f, high = 306.08f, low = 285.67f, close = 295.48f),
            BarPrices(open = 293.34f, high = 308.30f, low = 287.70f, close = 297.37f),
            BarPrices(open = 295.11f, high = 310.51f, low = 289.59f, close = 299.17f),
            BarPrices(open = 297.58f, high = 312.73f, low = 292.18f, close = 301.61f),
            BarPrices(open = 298.86f, high = 314.95f, low = 293.57f, close = 302.92f),
            BarPrices(open = 301.70f, high = 317.16f, low = 296.54f, close = 305.74f)
        )
        val bars = listOf(
            BarPrices(100f, 130f, 90f, 120f),
            BarPrices(120f, 125f, 105f, 110f),
            BarPrices(110f, 135f, 108f, 130f),
            BarPrices(130f, 140f, 120f, 125f),
            BarPrices(125f, 145f, 122f, 140f)
        )

        val chart = findViewById<NanoChart>(R.id.main_chart)
        chart.setBars(candles)

    }
}