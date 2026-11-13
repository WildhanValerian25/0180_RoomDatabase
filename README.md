<div align="center">

# 📚 Data Siswa — Room Database

**Praktikum Pemrograman Aplikasi Mobile (PAM) — Pertemuan 9**

Aplikasi Android sederhana untuk mencatat data siswa secara lokal menggunakan **Room Database**,
dibangun dengan **Kotlin** dan **Jetpack Compose** dengan arsitektur **MVVM**.

![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)
![Room](https://img.shields.io/badge/Room%20Database-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Material 3](https://img.shields.io/badge/Material%203-757575?style=for-the-badge&logo=materialdesign&logoColor=white)

</div>

---

## 📱 Tampilan Aplikasi

<div align="center">

| Halaman Utama (Kosong) | Form Tambah Siswa | Daftar Data Siswa |
|:---:|:---:|:---:|
| <img width="240" alt="Halaman kosong" src="https://github.com/user-attachments/assets/f8487edc-9a03-44ff-b63c-4e0b85557d15" /> | <img width="240" alt="Form tambah siswa" src="https://github.com/user-attachments/assets/0af3d91e-e366-44d7-b308-6a317da4edeb" /> | <img width="240" alt="Daftar siswa" src="https://github.com/user-attachments/assets/80d2889b-c5bf-4471-a218-90ea580106ba" /> |
| Pesan informasi saat belum ada data | Input nama, alamat, dan telepon dengan validasi | Data tersimpan dan tampil terurut A–Z |

</div>

---

## ✨ Fitur

- ➕ **Tambah data siswa**: nama, alamat, dan nomor telepon
- ✅ **Validasi input**: tombol *Submit* aktif hanya jika semua field terisi
- 📋 **Daftar siswa** ditampilkan dalam bentuk card, terurut berdasarkan nama (A–Z)
- 💾 **Penyimpanan lokal permanen** dengan Room: data tetap ada walau aplikasi ditutup
- 🔄 **Update otomatis**: daftar langsung diperbarui berkat `Flow` + `StateFlow`
- 🧭 **Navigasi antar halaman** dengan Navigation Compose

---

## 🏗️ Arsitektur

Aplikasi menerapkan pola **MVVM (Model–View–ViewModel)** dengan Repository Pattern dan *manual dependency injection* melalui container.

```
┌──────────────────────┐
│   View (Compose UI)  │  HalamanHome, HalamanEntry
└──────────┬───────────┘
           │ observe state / kirim event
┌──────────▼───────────┐
│      ViewModel       │  HomeViewModel, EntryViewModel
└──────────┬───────────┘
           │
┌──────────▼───────────┐
│      Repository      │  RepositoriSiswa → OfflineRepositoriSiswa
└──────────┬───────────┘
           │
┌──────────▼───────────┐
│    Room Database     │  DatabaseSiswa → SiswaDao → tblSiswa
└──────────────────────┘
```

---

## 📂 Struktur Project

```
com.example.pertemuan9pam
├── room/
│   ├── Siswa.kt               # Entity tabel tblSiswa
│   ├── SiswaDao.kt            # Query insert & select
│   └── DatabaseSiswa.kt       # Instance Room Database (singleton)
├── repositori/
│   ├── RepositorySiswa.kt     # Interface & implementasi repository
│   └── ContainerApp.kt        # Container dependency
├── viewmodel/
│   ├── EntryViewModel.kt      # State form, validasi, simpan data
│   ├── HomeViewModel.kt       # State daftar siswa (StateFlow)
│   └── PenyediaViewModel.kt   # Factory ViewModel
├── uicontroller/
│   ├── DestinasiNavigasi.kt   # Interface rute navigasi
│   └── PetaNavigasi.kt        # NavHost & TopAppBar
├── view/
│   ├── HalamanHome.kt         # Halaman daftar siswa
│   └── HalamanEntry.kt        # Halaman form tambah siswa
├── AplikasiSiswa.kt           # Application class
└── MainActivity.kt
```

---

## 🗃️ Struktur Tabel `tblSiswa`

| Kolom    | Tipe    | Keterangan                    |
|----------|---------|-------------------------------|
| `id`     | Int     | Primary key, auto increment   |
| `nama`   | String  | Nama siswa                    |
| `alamat` | String  | Alamat siswa                  |
| `telpon` | String  | Nomor telepon siswa           |

---

## 🛠️ Teknologi

| Teknologi | Kegunaan |
|---|---|
| Kotlin | Bahasa pemrograman |
| Jetpack Compose + Material 3 | Antarmuka pengguna |
| Room (2.8.4) + KSP | Database lokal SQLite |
| ViewModel & StateFlow | Manajemen state UI |
| Navigation Compose | Navigasi antar halaman |
| Kotlin Coroutines & Flow | Operasi database asynchronous |

---

## 🚀 Cara Menjalankan

1. Clone repository ini
   ```bash
   git clone https://github.com/<username>/<nama-repo>.git
   ```
2. Buka folder project di **Android Studio**
3. Tunggu proses **Gradle Sync** selesai
4. Jalankan di emulator atau perangkat Android (minimal **Android 7.0 / API 24**)

---

## 👤 Identitas

| | |
|---|---|
| **Nama** | Nazwa Hafidzah |
| **NIM** | `<isi NIM>` |
| **Mata Kuliah** | Pemrograman Aplikasi Mobile (PAM) |
