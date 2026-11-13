package com.example.pertemuan9pam.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tblSiswa")
data class Siswa(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var nama: String,
    var alamat: String,
    var telpon: String
)