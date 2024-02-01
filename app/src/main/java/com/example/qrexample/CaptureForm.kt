package com.example.qrexample

import android.R
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.journeyapps.barcodescanner.CaptureActivity


class CaptureForm : CaptureActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val params = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        /* TextVeiw를 설정하고 마지막엔 this.addContentView ! */
        val textView = TextView(this)
        textView.layoutParams =
            LinearLayout.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT
            )
        textView.setTextColor(Color.parseColor("#ABCDEF"))
        textView.text = "바코드 / QR 코드 입력화면"
        textView.gravity = Gravity.CENTER_HORIZONTAL


        /* imagaeVeiw를 설정하고 마지막엔 this.addContentView ! */
//        val imageView = ImageView(this)
//        imageView.layoutParams =
//            LinearLayout.LayoutParams(
//                WindowManager.LayoutParams.MATCH_PARENT,
//                WindowManager.LayoutParams.WRAP_CONTENT
//            )
//        imageView.setImageDrawable(resources.getDrawable(R.drawable.checkbox_off_background))

        /* this.addContentView ! */
        addContentView(textView, params)
//        addContentView(imageView, params)
    }
}