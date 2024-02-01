package com.example.qrexample

import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult

class QRCodeScan(private val act: MainActivity) {

    fun startQRScan(){
        val intentIntegrator = IntentIntegrator(act)
        intentIntegrator.setPrompt("안내선 안에 QR코드를 맞추면 자동으로 인식됩니다.")
        intentIntegrator.setOrientationLocked(true)
        intentIntegrator.setBeepEnabled(true)
        activityResult.launch(intentIntegrator.createScanIntent())
    }
    private val activityResult = act.registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result->
        val data = result.data

        val intentResult: IntentResult? = IntentIntegrator.parseActivityResult(result.resultCode,data)
        if (intentResult !=null){
            if (intentResult.contents !=null){
                Toast.makeText(act, "인식된 QR-data: ${intentResult.contents}", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(act, "인식된 QR-data가 없습니다.", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(act, "QR스캔에 실패했습니다.", Toast.LENGTH_SHORT).show()
        }
    }
}