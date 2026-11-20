package com.example.myroomsiswa.view.route


import com.example.pertemuan9_pam.R
import com.example.pertemuan9pam.route.DestinasiNavigasi

object DestinasiDetailSiswa : DestinasiNavigasi {
    override val route = "detail_siswa"
    override val titleRes = R.string.detail_siswa
    const val itemIdArg = "idSiswa"
    val routeWithArgs = "$route/{$itemIdArg}"
}