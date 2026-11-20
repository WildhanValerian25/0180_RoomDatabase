<div align="center">

# 📚 Data Siswa — Room Database (CRUD)

**Praktikum Pemrograman Aplikasi Mobile — Activity 8 (Room DB Part 2)**

Aplikasi Android untuk mengelola data siswa secara lokal menggunakan **Room Database**,
dibangun dengan **Kotlin** dan **Jetpack Compose** dengan arsitektur **MVVM**.
Melanjutkan Activity sebelumnya dengan fitur lengkap **Create, Read, Update, dan Delete**.

![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)
![Room](https://img.shields.io/badge/Room%20Database-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Material 3](https://img.shields.io/badge/Material%203-757575?style=for-the-badge&logo=materialdesign&logoColor=white)

</div>

---

## 📱 Hasil Running — Semua Operasi

### 1️⃣ Create & Read

<div align="center">

| Halaman Utama (Kosong) | Tambah Siswa (Create) | Daftar Siswa (Read) |
|:---:|:---:|:---:|
| <img width="230" alt="Halaman kosong" src="https://github.com/user-attachments/assets/f8487edc-9a03-44ff-b63c-4e0b85557d15" /> | <img width="230" alt="Form tambah siswa" src="https://github.com/user-attachments/assets/0af3d91e-e366-44d7-b308-6a317da4edeb" /> | <img width="230" alt="Daftar siswa" src="https://github.com/user-attachments/assets/80d2889b-c5bf-4471-a218-90ea580106ba" /> |
| Pesan informasi saat belum ada data | Input nama, alamat, dan telepon dengan validasi | Data tersimpan dan tampil terurut A–Z |

</div>

### 2️⃣ Detail & Update

<div align="center">

| Detail Siswa | Edit Siswa (Update) |
|:---:|:---:|
| <img width="260" alt="Detail siswa" src="https://github.com/user-attachments/assets/b832acd7-a38c-48c6-b8dd-55340fb2aa33" /> | <img width="260" alt="Edit siswa" src="https://github.com/user-attachments/assets/0aceb6b7-3c17-4d80-bfaf-90d3cd2e8f22" /> |
| Klik card siswa untuk melihat detail data | Tekan tombol ✏️ untuk mengubah data, lalu *Submit* |

</div>

### 3️⃣ Delete

<div align="center">

| Konfirmasi Hapus | Setelah Data Dihapus |
|:---:|:---:|
| <img width="230" alt="Konfirmasi hapus" src="screenshots/hapus_konfirmasi.png" /> | <img width="230" alt="Setelah dihapus" src="screenshots/hapus_setelah.png" /> |
| Tekan **Hapus** → muncul dialog *"Apakah anda yakin menghapus ini?"* → pilih **Ya** | Data terhapus dari database dan kembali ke halaman utama |

</div>

---

## ✨ Fitur

| Operasi | Keterangan |
|---|---|
| ➕ **Create** | Menambah data siswa (nama, alamat, telepon) dengan validasi input |
| 📋 **Read** | Menampilkan daftar siswa dalam card, terurut berdasarkan nama |
| 🔍 **Detail** | Menampilkan detail satu siswa yang dipilih |
| ✏️ **Update** | Mengubah data siswa melalui halaman Edit |
| 🗑️ **Delete** | Menghapus data siswa dengan dialog konfirmasi |

Fitur pendukung:
- 💾 Data tersimpan permanen di database lokal (Room)
- 🔄 Tampilan otomatis diperbarui berkat `Flow` + `StateFlow`
- 🧭 Navigasi antar halaman dengan Navigation Compose (mengirim `id` siswa sebagai argumen)

---

## 🧭 Alur Navigasi

```
Home (Daftar Siswa) ──[ + ]──────────▶ Entry (Tambah Siswa)
        │
        └──[ klik card ]──▶ Detail Siswa ──[ ✏️ ]──▶ Edit Siswa
                                 │
                                 └──[ Hapus ]──▶ Konfirmasi ──▶ kembali ke Home
```

---

## 🏗️ Arsitektur

Aplikasi menerapkan pola **MVVM (Model–View–ViewModel)** dengan Repository Pattern dan *manual dependency injection* melalui container.

```
┌──────────────────────┐
│   View (Compose UI)  │  HalamanHome, HalamanEntry, HalamanDetailSiswa, HalamanEdit
└──────────┬───────────┘
           │ observe state / kirim event
┌──────────▼───────────┐
│      ViewModel       │  Home, Entry, Detail, Edit ViewModel
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
│   ├── Siswa.kt                 # Entity tabel tblSiswa
│   ├── SiswaDao.kt              # Query insert, update, delete, select
│   └── DatabaseSiswa.kt         # Instance Room Database (singleton)
├── repositori/
│   ├── RepositorySiswa.kt       # Interface & implementasi repository
│   └── ContainerApp.kt          # Container dependency
├── viewmodel/
│   ├── EntryViewModel.kt        # State form tambah, validasi, simpan
│   ├── HomeViewModel.kt         # State daftar siswa
│   ├── DetailViewModel.kt       # State detail & hapus siswa
│   ├── EditViewModel.kt         # State form edit & update siswa
│   └── PenyediaViewModel.kt     # Factory semua ViewModel
├── uicontroller/
│   ├── DestinasiNavigasi.kt     # Interface rute navigasi
│   └── PetaNavigasi.kt          # NavHost seluruh halaman & TopAppBar
├── view/
│   ├── HalamanHome.kt           # Halaman daftar siswa
│   ├── HalamanEntry.kt          # Halaman tambah siswa
│   ├── HalamanDetailSiswa.kt    # Halaman detail + hapus
│   └── HalamanEdit.kt           # Halaman edit siswa
├── AplikasiSiswa.kt             # Application class
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
| Navigation Compose | Navigasi antar halaman dengan argumen |
| Kotlin Coroutines & Flow | Operasi database asynchronous |

---

## 🚀 Cara Menjalankan

1. Clone repository ini
   ```bash
   git clone https://github.com/<username>/<NIM>_RoomDatabase.git
   ```
2. Buka folder project di **Android Studio**
3. Tunggu proses **Gradle Sync** selesai
4. Jalankan di emulator atau perangkat Android (minimal **Android 7.0 / API 24**)
