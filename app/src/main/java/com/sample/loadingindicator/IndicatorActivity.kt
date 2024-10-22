package com.sample.loadingindicator

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sample.loadingindicator.databinding.ActivityIndicatorBinding

class IndicatorActivity : AppCompatActivity() {

    companion object {
        fun launchActivity(activity: Context, indicator: String) {
            val intent = Intent(activity, IndicatorActivity::class.java)
            intent.putExtra("indicator", indicator)
            activity.startActivity(intent)
        }
    }

    private val binding: ActivityIndicatorBinding by lazy {
        ActivityIndicatorBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initView()
        actionListener()
    }

    private fun initView() {
        val indicator = intent.getStringExtra("indicator")
        binding.avi.setIndicator(indicator)
    }

    private fun actionListener() {

        binding.btnHide.setOnClickListener {
            binding.avi.hide()
            // or avi.smoothToHide();
        }

        binding.btnShow.setOnClickListener {
            binding.avi.show()
            // or avi.smoothToShow();
        }
    }
}
