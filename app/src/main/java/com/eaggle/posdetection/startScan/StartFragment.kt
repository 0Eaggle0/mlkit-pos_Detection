package com.eaggle.posdetection.startScan

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.eaggle.posdetection.R
import com.eaggle.posdetection.cameraFeature.ScanCamaraActivity

class StartFragment: Fragment() {
    private val permissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission(),
    )   { isGranted:Boolean ->
            if (isGranted) {
                startScan()
            } else {
                // homework: сделать так чтобы при отказе скрыть кнопку и показать сообщение
            }
        }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_scan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val startButton = view.findViewById<Button>(R.id.scan_button)
//        startButton.isVisible (homework)
        startButton.setOnClickListener {
            val permission =  ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.CAMERA)
            when (permission) {
                PackageManager.PERMISSION_GRANTED -> startScan()
                else -> permissionLauncher.launch(Manifest.permission.CAMERA)
            }
        }
    }

    private fun startScan(){
        val saveIntent = Intent(requireContext(), ScanCamaraActivity::class.java)
            startActivity(saveIntent)
    }
}