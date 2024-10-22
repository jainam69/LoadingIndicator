package com.sample.loadingindicator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.sample.loadingindicator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val layoutManager = GridLayoutManager(this, 4)
        binding.recyclerView.setLayoutManager(layoutManager)
        binding.recyclerView.adapter = IndicatorAdapter(this, indicators)
    }

    private val indicators = arrayListOf(
        "BallPulseIndicator",
        "BallGridPulseIndicator",
        "BallClipRotateIndicator",
        "BallClipRotatePulseIndicator",
        "SquareSpinIndicator",
        "BallClipRotateMultipleIndicator",
        "BallPulseRiseIndicator",
        "BallRotateIndicator",
        "CubeTransitionIndicator",
        "BallZigZagIndicator",
        "BallZigZagDeflectIndicator",
        "BallTrianglePathIndicator",
        "BallScaleIndicator",
        "LineScaleIndicator",
        "LineScalePartyIndicator",
        "BallScaleMultipleIndicator",
        "BallPulseSyncIndicator",
        "BallBeatIndicator",
        "LineScalePulseOutIndicator",
        "LineScalePulseOutRapidIndicator",
        "BallScaleRippleIndicator",
        "BallScaleRippleMultipleIndicator",
        "BallSpinFadeLoaderIndicator",
        "LineSpinFadeLoaderIndicator",
        "TriangleSkewSpinIndicator",
        "PacmanIndicator",
        "BallGridBeatIndicator",
        "SemiCircleSpinIndicator",
        "com.sample.loadingindicator.MyCustomIndicator"
    )
}