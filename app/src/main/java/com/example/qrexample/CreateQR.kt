package com.example.qrexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.qrexample.databinding.ActivityCreateQrBinding
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.journeyapps.barcodescanner.BarcodeEncoder


class CreateQR : AppCompatActivity() {

    lateinit var binding :ActivityCreateQrBinding
    private lateinit var text: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateQrBinding.inflate(layoutInflater)
        setContentView(binding.root)

        text = "https://park-duck.tistory.com"

        val multiFormatWriter = MultiFormatWriter()

        try {
            val bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.QR_CODE, 200, 200)
            val barcodeEncoder = BarcodeEncoder()
            val bitmap = barcodeEncoder.createBitmap(bitMatrix)
            binding.qrcode.setImageBitmap(bitmap)
        } catch (e: Exception) {
        }
    }
}