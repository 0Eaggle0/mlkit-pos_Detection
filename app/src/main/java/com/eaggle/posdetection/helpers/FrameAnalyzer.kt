package com.eaggle.posdetection.helpers

import android.util.Size
import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.eaggle.posdetection.cameraFeature.LandMarkView
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.pose.PoseDetection
import com.google.mlkit.vision.pose.PoseDetector
import com.google.mlkit.vision.pose.defaults.PoseDetectorOptions
import java.lang.Integer.max
import kotlin.math.min

@ExperimentalGetImage
class FrameAnalyzer(
    private val viewPoint: LandMarkView
): ImageAnalysis.Analyzer {
    private val options = PoseDetectorOptions.Builder()
        .setDetectorMode(PoseDetectorOptions.STREAM_MODE)
        .build()
    private val detector = PoseDetection.getClient(options)
    override fun analyze(image: ImageProxy) {
        val mediaImage = image.image
        if (mediaImage != null){
            val imageForDetector = InputImage.fromMediaImage(mediaImage, image.imageInfo.rotationDegrees)
            detector.process(imageForDetector)
                .addOnSuccessListener { resultPose ->
                    val size = Size(
                        min(image.width, image.height),
                        max(image.width, image.height)
                    )
                    viewPoint.setParams(resultPose, size)
                    image.close()
                }
                .addOnFailureListener {
                    println("image fail")
                    image.close()
                }
        }
    }
}