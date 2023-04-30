package com.eaggle.posdetection.helpers

import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy

class FrameAnalyzer: ImageAnalysis.Analyzer {
    override fun analyze(image: ImageProxy) {
        println("work, work, work, work, work")
        image.close()
    }
}