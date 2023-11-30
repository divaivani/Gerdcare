package com.example.gerdcare

import android.R.layout
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import android.widget.Button
import android.widget.RelativeLayout
import com.example.gerdcare.R
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
//    lateinit var popupWindow: PopupWindow

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        // Inisialisasi tampilan popup
//        val view = LayoutInflater.from(this).inflate(R.layout.conditionpopup, null)
//
//        // Inisialisasi popup window
//        popupWindow = PopupWindow(
//            view,
//            RelativeLayout.LayoutParams.MATCH_PARENT,
//            RelativeLayout.LayoutParams.WRAP_CONTENT,
//            true
//        )
//
//        // Atur background sehingga popup dapat ditutup saat diklik di luar popup
//        popupWindow.setBackgroundDrawable(resources.getDrawable(android.R.color.transparent))
//
//        // Temukan tombol "got it" pada popup
//        val gotItButton: Button = view.findViewById(R.id.gotItButton)
//
//        // Atur tindakan saat tombol "got it" diklik
//        gotItButton.setOnClickListener {
//            // Tutup popup saat tombol diklik
//            popupWindow.dismiss()
//        }
//
//        // Tampilkan popup saat aktivitas dimulai
//        showPopup()
//    }
//
//    private fun showPopup() {
//        // Temukan tampilan utama
//        val mainLayout = findViewById<RelativeLayout>(R.id.mainLayout)
//
//        // Atur lokasi popup, di tengah layar
//        popupWindow.showAtLocation(mainLayout, 0, 0, 0)
 }
}
