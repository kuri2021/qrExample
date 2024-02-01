package com.example.qrexample

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.qrexample.databinding.ActivityScanQrBinding
import com.google.zxing.integration.android.IntentIntegrator


class ScanQR : AppCompatActivity() {

    lateinit var binding : ActivityScanQrBinding
    lateinit var qrScan : IntentIntegrator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScanQrBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        IntentIntegrator(this).initiateScan()
        qrScan = IntentIntegrator(this)

        qrScan.captureActivity = CaptureForm::class.java
        qrScan.setOrientationLocked(false)
        qrScan.setPrompt("Sample Text!")
        qrScan.initiateScan()
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(result.contents))
                startActivity(intent)
                finish()
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}