package com.example.pertemuan9pam

import android.app.Application
import com.example.pertemuan9pam.repositori.ContainerApp
import com.example.pertemuan9pam.repositori.ContainerDataApp

class AplikasiSiswa : Application() {
    lateinit var containerApp: ContainerApp

    //
    override fun onCreate() {
        super.onCreate()
        containerApp = ContainerDataApp(this)
    }
}
