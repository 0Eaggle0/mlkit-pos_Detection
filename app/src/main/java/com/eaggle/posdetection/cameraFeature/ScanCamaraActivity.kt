package com.eaggle.posdetection.cameraFeature

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.content.ContextCompat
import com.eaggle.posdetection.R
import com.eaggle.posdetection.helpers.FrameAnalyzer
import com.google.common.util.concurrent.ListenableFuture

class ScanCamaraActivity: AppCompatActivity() {
    private lateinit var cameraFuture: ListenableFuture<ProcessCameraProvider>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activivty_camera)

        cameraFuture = ProcessCameraProvider.getInstance(this)
        cameraFuture.addListener({
            val provider = cameraFuture.get()
            cameraSettings(provider)
        }, ContextCompat.getMainExecutor(this))
    }

    private fun cameraSettings(cameraProvider: ProcessCameraProvider){
        val cameraSelector = CameraSelector.Builder()
            .requireLensFacing(CameraSelector.LENS_FACING_BACK)
            .build()
        val preview = Preview.Builder().build()
        val previewCam = findViewById<PreviewView>(R.id.cameraPreview)
        preview.setSurfaceProvider(previewCam.surfaceProvider)

        val imageAnalysis = ImageAnalysis.Builder()
            .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
            .build()
        imageAnalysis.setAnalyzer(mainExecutor, FrameAnalyzer())

        cameraProvider.bindToLifecycle(this, cameraSelector, preview, imageAnalysis)
    }
}