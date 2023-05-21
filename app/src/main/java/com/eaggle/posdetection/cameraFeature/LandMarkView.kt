package com.eaggle.posdetection.cameraFeature

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.graphics.PointF
import android.util.AttributeSet
import android.util.Size
import android.view.View
import androidx.core.graphics.green
import com.google.mlkit.vision.common.PointF3D
import com.google.mlkit.vision.pose.Pose
import com.google.mlkit.vision.pose.PoseLandmark

class LandMarkView(
    context: Context,
    attributes: AttributeSet
): View(context, attributes) {
    private var viewSize = Size(0, 0)
    private val mainPaint = Paint(ANTI_ALIAS_FLAG)
    private var poseDetected: Pose? = null
    private var sizeSource = Size(0, 0)
    init {
        mainPaint.color = Color.GREEN
        mainPaint.strokeWidth = 15.0F
        mainPaint.style = Paint.Style.FILL
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        viewSize = Size(w, h)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawPoints(canvas)
        drawLines(canvas)
    }
    fun setParams(pose: Pose, sourceSize: Size){
        poseDetected = pose
        sizeSource = sourceSize
        invalidate()
    }

    private fun drawLandmark(landMark: PoseLandmark, drawCanvas: Canvas?){
        val position = convertPoint(landMark.position3D)
        drawCanvas?.drawCircle(position.x, position.y, 20f, mainPaint)
    }

    private fun convertPoint(targetPos: PointF3D, ):PointF{
        val x1 = targetPos.x
        val y1 = targetPos.y
        val w1 = sizeSource.width
        val h1 = sizeSource.height
        val w2 = viewSize.width
        val h2 = viewSize.height

        val x2 = x1 * w2 / w1
        val y2 = y1 * h2 / h1

        return PointF(x2, y2)
    }

    private fun drawPoints(canvas: Canvas?){
        var landMark = poseDetected?.getPoseLandmark(PoseLandmark.NOSE)
        if (landMark != null) {
            drawLandmark(landMark, canvas)
        }
        landMark = poseDetected?.getPoseLandmark(PoseLandmark.LEFT_EYE_INNER)
        if (landMark != null) {
            drawLandmark(landMark, canvas)
        }
        landMark = poseDetected?.getPoseLandmark(PoseLandmark.LEFT_EYE_OUTER)
        landMark?.let { //this is if
            drawLandmark(it, canvas)
        }
        landMark = poseDetected?.getPoseLandmark(PoseLandmark.LEFT_EYE)
        landMark?.let { //this is if
            drawLandmark(it, canvas)
        }
        landMark = poseDetected?.getPoseLandmark(PoseLandmark.RIGHT_EYE_INNER)
        if (landMark != null) {
            drawLandmark(landMark, canvas)
        }
        landMark = poseDetected?.getPoseLandmark(PoseLandmark.RIGHT_EYE_OUTER)
        landMark?.let { //this is if
            drawLandmark(it, canvas)
        }
        landMark = poseDetected?.getPoseLandmark(PoseLandmark.RIGHT_EYE)
        landMark?.let { //this is if
            drawLandmark(it, canvas)
        }
        landMark = poseDetected?.getPoseLandmark(PoseLandmark.LEFT_MOUTH)
        landMark?.let { //this is if
            drawLandmark(it, canvas)
        }
        landMark = poseDetected?.getPoseLandmark(PoseLandmark.RIGHT_MOUTH)
        landMark?.let { //this is if
            drawLandmark(it, canvas)
        }
        landMark = poseDetected?.getPoseLandmark(PoseLandmark.RIGHT_EAR)
        landMark?.let { //this is if
            drawLandmark(it, canvas)
        }
        landMark = poseDetected?.getPoseLandmark(PoseLandmark.LEFT_EAR)
        landMark?.let { //this is if
            drawLandmark(it, canvas)
        }
        landMark = poseDetected?.getPoseLandmark(PoseLandmark.LEFT_SHOULDER)
        landMark?.let { //this is if
            drawLandmark(it, canvas)
        }
        landMark = poseDetected?.getPoseLandmark(PoseLandmark.RIGHT_SHOULDER)
        landMark?.let { //this is if
            drawLandmark(it, canvas)
        }
        landMark = poseDetected?.getPoseLandmark(PoseLandmark.RIGHT_KNEE)
        landMark?.let { //this is if
            drawLandmark(it, canvas)
        }
        landMark = poseDetected?.getPoseLandmark(PoseLandmark.LEFT_KNEE)
        landMark?.let { //this is if
            drawLandmark(it, canvas)
        }
        landMark = poseDetected?.getPoseLandmark(PoseLandmark.RIGHT_INDEX)
        landMark?.let { //this is if
            drawLandmark(it, canvas)
        }
        landMark = poseDetected?.getPoseLandmark(PoseLandmark.LEFT_INDEX)
        landMark?.let { //this is if
            drawLandmark(it, canvas)
        }
        landMark = poseDetected?.getPoseLandmark(PoseLandmark.LEFT_ANKLE)
        landMark?.let { //this is if
            drawLandmark(it, canvas)
        }
        landMark = poseDetected?.getPoseLandmark(PoseLandmark.RIGHT_ANKLE)
        landMark?.let { //this is if
            drawLandmark(it, canvas)
        }
        landMark = poseDetected?.getPoseLandmark(PoseLandmark.RIGHT_HEEL)
        landMark?.let { //this is if
            drawLandmark(it, canvas)
        }
        landMark = poseDetected?.getPoseLandmark(PoseLandmark.LEFT_HEEL)
        landMark?.let { //this is if
            drawLandmark(it, canvas)
        }
        landMark = poseDetected?.getPoseLandmark(PoseLandmark.LEFT_FOOT_INDEX)
        landMark?.let { //this is if
            drawLandmark(it, canvas)
        }
        landMark = poseDetected?.getPoseLandmark(PoseLandmark.RIGHT_FOOT_INDEX)
        landMark?.let { //this is if
            drawLandmark(it, canvas)
        }
        landMark = poseDetected?.getPoseLandmark(PoseLandmark.LEFT_ELBOW)
        landMark?.let { //this is if
            drawLandmark(it, canvas)
        }
        landMark = poseDetected?.getPoseLandmark(PoseLandmark.RIGHT_ELBOW)
        landMark?.let { //this is if
            drawLandmark(it, canvas)
        }
    }

    private fun drawLines(canvas: Canvas?){
        var firstLandMark = poseDetected?.getPoseLandmark(PoseLandmark.LEFT_MOUTH)
        var secondLandMark = poseDetected?.getPoseLandmark(PoseLandmark.RIGHT_MOUTH)
        if (firstLandMark != null && secondLandMark != null){
            drawSingleLine(firstLandMark, secondLandMark, canvas)
        }
        firstLandMark = poseDetected?.getPoseLandmark(PoseLandmark.LEFT_SHOULDER)
        secondLandMark = poseDetected?.getPoseLandmark(PoseLandmark.LEFT_ELBOW)
        if (firstLandMark != null && secondLandMark != null){
            drawSingleLine(firstLandMark, secondLandMark, canvas)
        }
        firstLandMark = poseDetected?.getPoseLandmark(PoseLandmark.RIGHT_SHOULDER)
        secondLandMark = poseDetected?.getPoseLandmark(PoseLandmark.RIGHT_ELBOW)
        if (firstLandMark != null && secondLandMark != null){
            drawSingleLine(firstLandMark, secondLandMark, canvas)
        }
        firstLandMark = poseDetected?.getPoseLandmark(PoseLandmark.RIGHT_SHOULDER)
        secondLandMark = poseDetected?.getPoseLandmark(PoseLandmark.LEFT_SHOULDER)
        if (firstLandMark != null && secondLandMark != null){
            drawSingleLine(firstLandMark, secondLandMark, canvas)
        }
        firstLandMark = poseDetected?.getPoseLandmark(PoseLandmark.LEFT_INDEX)
        secondLandMark = poseDetected?.getPoseLandmark(PoseLandmark.LEFT_ELBOW)
        if (firstLandMark != null && secondLandMark != null){
            drawSingleLine(firstLandMark, secondLandMark, canvas)
        }
        firstLandMark = poseDetected?.getPoseLandmark(PoseLandmark.RIGHT_INDEX)
        secondLandMark = poseDetected?.getPoseLandmark(PoseLandmark.RIGHT_ELBOW)
        if (firstLandMark != null && secondLandMark != null){
            drawSingleLine(firstLandMark, secondLandMark, canvas)
        }
    }

    private fun drawSingleLine(firstPoint: PoseLandmark, secondPoint: PoseLandmark, canvas: Canvas?){
        val startPoint = convertPoint(firstPoint.position3D)
        val endPoint = convertPoint(secondPoint.position3D)
        canvas?.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y, mainPaint)
    }
}