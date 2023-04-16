package com.eaggle.posdetection.cameraFeature

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import com.eaggle.posdetection.R

class ScanCamaraActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activivty_camera)
    }
}