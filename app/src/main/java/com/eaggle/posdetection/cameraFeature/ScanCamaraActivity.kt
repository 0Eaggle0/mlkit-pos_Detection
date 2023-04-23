package com.eaggle.posdetection.cameraFeature

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import com.eaggle.posdetection.R
import com.google.common.util.concurrent.ListenableFuture

class ScanCamaraActivity: AppCompatActivity() {
    private lateinit var cameraFuture: ListenableFuture<ProcessCameraProvider>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activivty_camera)

        cameraFuture = ProcessCameraProvider.getInstance(this)
        cameraFuture.addListener({



        }, ContextCompat.getMainExecutor(this))
    }
}