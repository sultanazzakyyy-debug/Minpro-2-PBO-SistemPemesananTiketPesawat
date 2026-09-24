# Minpro 2 PBO - Sistem Pemesanan Tiket Pesawat

Nama : Muhammad Nadhir Sultan Azzaky

NIM : 2509116080

Kelas : Sistem Informasi 25'B

## 1. Deskripsi Singkat Program

Program ini adalah lanjutan dari Mini Project 1, berupa aplikasi berbasis *console* memakai Java untuk mengelola pemesanan tiket pesawat. Data yang dikelola ada tiga: data penumpang, data penerbangan, dan data tiket.

Setiap objek `Tiket` menyimpan langsung referensi ke objek `Penumpang` dan `Penerbangan` di dalamnya, jadi satu tiket selalu jelas terhubung ke penumpang dan penerbangan yang mana tanpa perlu ID penghubung terpisah.

Program menyediakan fitur tambah data penerbangan, lihat jadwal penerbangan, pesan tiket (dengan pilihan kelas kursi), lihat seluruh tiket, ubah status tiket, dan batalkan tiket. Program ini menerapkan konsep OOP seperti *encapsulation*, *inheritance*, dan *polymorphism*, serta disusun memakai struktur MVC (Model-View-Controller).

## 2. Penjelasan Alur Program

Program dimulai dari `SistemPemesananTiketPesawat.java` (package `main`), yang membuat objek `Controller` dan `View`. Setelah itu `Controller` memanggil `isiDataAwal()` untuk menyiapkan `ArrayList` dan mengisi satu data dummy (satu penerbangan dan satu tiket) sebagai data awal. Program lalu menampilkan menu utama dengan 7 pilihan: tambah penerbangan, lihat jadwal, pesan tiket, lihat semua tiket, update status, batalkan tiket, dan keluar.

1. Menu Awal

   <img width="204" height="111" alt="Menu awal" src="https://github.com/user-attachments/assets/ef6f94bd-6c9f-49cb-8d5d-4207a6678872" />

   Begitu program dijalankan, menu utama tampil dengan 7 pilihan. User tinggal mengetik angka di baris Pilih menu: untuk masuk ke fitur yang diinginkan. Data dummy dari isiDataAwal() sudah tersedia di belakang layar sejak awal, meski baru kelihatan setelah user membuka menu 2 atau 4.

2. **Tambah Data Penerbangan**

   <img width="198" height="111" alt="Menu 1" src="https://github.com/user-attachments/assets/0ac956b1-3bb1-4ed0-93f4-fce66752a79c" />
   
   User memasukkan kode penerbangan, kota asal, kota tujuan, jam keberangkatan, harga dasar, dan jumlah kursi. Setiap input divalidasi (kode nggak boleh kosong, harga & kursi harus lebih dari 0) sebelum data dikirim ke      Controller.tambahPenerbangan() dan dimasukkan ke ArrayList<Penerbangan>. Setelah berhasil, muncul pesan "Data penerbangan berhasil ditambahkan!".

3. **Lihat Jadwal Penerbangan**

   <img width="207" height="190" alt="Menu 2" src="https://github.com/user-attachments/assets/4e69b9df-c189-4a0b-8cc8-d2399c0ab5aa" />

   Program mengambil seluruh isi ArrayList<Penerbangan> dan menampilkannya lewat View, lengkap dengan kode, rute, jam, harga dasar, dan sisa kursi tiap penerbangan termasuk data yang baru saja ditambahkan di menu 1.

4. **Pesan Tiket**
  
   <img width="358" height="206" alt="Menu 3 bisnis" src="https://github.com/user-attachments/assets/10c80694-0442-4f72-81f4-1b8cb4fd7fbf" />
   <img width="350" height="207" alt="Menu 3 ekonomi" src="https://github.com/user-attachments/assets/985e9997-197e-4297-85ed-5de30f83c6a1" />

   User memilih nomor penerbangan dari daftar ringkas yang ditampilkan. Program mengecek dulu apakah kursi penerbangan itu masih tersedia kalau sudah habis, program menolak dan tidak lanjut ke input tiket. Jika masih ada, user mengisi ID tiket dan data penumpang, lalu memilih kelas kursi (1 = Ekonomi, 2 = Bisnis). Berdasarkan pilihan itu, Controller.pesanTiket() membuat objek Tiketekonomi atau Tiketbisnis, memasukkannya ke ArrayList<Tiket>, dan mengurangi kursi penerbangan terkait lewat kurangiKursi(). Total harga tiket bisnis otomatis lebih besar (dikali 1.5) dibanding tiket ekonomi.

5. **Lihat Semua Tiket**
   
   <img width="960" height="540" alt="Menu 4" src="https://github.com/user-attachments/assets/e48a7f13-35bc-4ce8-b46c-8d36d0a436ad" />

   Program menampilkan detail seluruh tiket yang ada di ArrayList<Tiket>, termasuk data penumpang, data penerbangan, kelas kursi, total harga, dan status tiket. Tiket ekonomi dan bisnis tampil dengan label kategori serta info bagasi yang berbeda.

6. **Update Status Tiket**
   
   <img width="259" height="107" alt="Menu 5 Lunas" src="https://github.com/user-attachments/assets/953c1c20-293b-48da-8108-a7857d53015c" />
   
   User memasukkan ID tiket yang ingin diubah statusnya. Program mencarinya lewat Controller.cariTiket(). Jika ditemukan, user memasukkan status baru (harus salah satu dari "Dipesan", "Lunas", "Dibatalkan"), lalu status tiket diperbarui dan muncul pesan "Status tiket berhasil diubah!".
   
7. **Batalkan Tiket**
   
   <img width="237" height="98" alt="Menu 6" src="https://github.com/user-attachments/assets/574acbb4-232d-4fa7-a16a-cb72f9491d5e" />

   User memasukkan ID tiket yang ingin dibatalkan. Jika ditemukan, tiket dihapus dari ArrayList<Tiket> lewat Controller.batalkanTiket(), dan kursi penerbangan yang terkait dikembalikan lewat tambahKursi() — kelihatan dari sisa kursi yang bertambah 1 dibanding sebelumnya.

8. **Keluar**

   <img width="375" height="98" alt="Menu 7" src="https://github.com/user-attachments/assets/71f93bd1-c19a-4bda-9e0b-c63356ac18b7" />

   User memilih menu 7, program mencetak pesan penutup "Terima kasih telah menggunakan sistem ini!", perulangan menu dihentikan, dan program selesai dijalankan.

Selama proses input di semua menu, program melakukan validasi untuk memastikan data yang dimasukkan sesuai ketentuan. Jika input tidak sesuai, pengguna diminta memasukkan kembali data tersebut (penjelasan lebih lengkap ada di bagian Validasi Input).
   
## 3. Penjelasan Penerapan Encapsulation, Inheritance, Validasi Input, dan Dummy Data

### Struktur Class

| Class | Package | Peran |
|---|---|---|
| `Penumpang` | `model` | Menyimpan data diri penumpang |
| `Penerbangan` | `model` | Menyimpan data jadwal, harga, dan kursi penerbangan |
| `Tiket` | `model` | Superclass yang menggabungkan data penumpang dan penerbangan jadi satu tiket |
| `Tiketekonomi` | `model` | Subclass dari `Tiket` untuk tiket kelas Ekonomi |
| `Tiketbisnis` | `model` | Subclass dari `Tiket` untuk tiket kelas Bisnis |
| `View` | `view` | Menampilkan menu dan pesan ke layar |
| `Controller` | `controller` | Mengatur proses pengolahan data |
| `SistemPemesananTiketPesawat` | `main` | Menjalankan program |

### Encapsulation

Encapsulation diterapkan dengan menjadikan atribut di dalam class bertipe `private` (khusus `Tiket` pakai `protected` supaya bisa langsung diwariskan ke subclass-nya).

Contoh pada `model/Penerbangan.java`:

<img width="263" height="112" alt="Encapsulation" src="https://github.com/user-attachments/assets/a439a523-a3f7-439c-82cb-cca5235a1c16" />

Atribut tersebut tidak bisa diakses langsung dari luar class, harus lewat getter dan setter. Khusus `setHarga()`, ada validasi tambahan supaya harga yang tersimpan nggak pernah 0 atau negatif:

<img width="224" height="124" alt="Getter   Setter" src="https://github.com/user-attachments/assets/5d9e6ef8-e5a8-4dbf-9aa7-de1c56d018cc" />

Encapsulation dengan pola yang sama juga diterapkan pada class `Penumpang`, `Tiket`, `Tiketekonomi`, dan `Tiketbisnis`. Khusus jumlah kursi, program sengaja tidak menyediakan setter bebas — perubahannya hanya boleh lewat method `kurangiKursi()` dan `tambahKursi()`.

### Inheritance

Inheritance diterapkan dengan menjadikan `Tiket` sebagai superclass, dan `Tiketekonomi` beserta `Tiketbisnis` sebagai subclass-nya.

Struktur inheritance:

```text
Tiket
├── Tiketekonomi
└── Tiketbisnis
```

Pada `model/Tiketbisnis.java`, inheritance diterapkan pakai `extends`, dan constructor-nya memanggil `super(...)` untuk mengisi bagian data yang diwarisi dari `Tiket`:

<img width="526" height="103" alt="tiketbisnis" src="https://github.com/user-attachments/assets/d6202556-6ac8-4165-a511-6d40c51aab85" />

Sedangkan `Tiketekonomi` juga mewarisi `Tiket` dengan cara yang sama:

<img width="541" height="101" alt="tiketekonomi" src="https://github.com/user-attachments/assets/2f8c5bfa-b462-4bc2-84e3-99cfad270fcb" />

Kedua subclass mewarisi atribut (`idTiket`, `penumpang`, `penerbangan`, `statusTiket`) dan method dari `Tiket`, lalu menambahkan atribut sendiri berupa `bagasiKg` (20 kg untuk Ekonomi, 30 kg untuk Bisnis). Keduanya juga meng-*override* `getNamaKelas()` dan `tampilkanInfo()`, sedangkan `hitungTotalHarga()` hanya di-*override* oleh `Tiketbisnis` untuk mengalikan harga dasar 1.5.

### Dummy Data Awal

Dummy data awal diterapkan pada `controller/Controller.java`, lewat method `isiDataAwal()`.

Saat `Controller` dibuat dan method ini dipanggil di `main`, program langsung memasukkan satu data penerbangan dan satu data tiket ke dalam `ArrayList`.

Contohnya:

<img width="642" height="126" alt="dummy data" src="https://github.com/user-attachments/assets/ba0f9b42-2288-4dc7-b66f-362a7525671a" />

Dengan adanya dummy data ini, pengguna bisa langsung melihat data ketika menjalankan menu "Lihat Jadwal Penerbangan" dan "Lihat Semua Tiket" tanpa perlu menambah data dulu, sekaligus memudahkan menguji fitur update dan pembatalan tiket sejak awal.

### Validasi Input

Validasi input diterapkan pada bagian pembacaan input di `main/SistemPemesananTiketPesawat.java`, memakai pola perulangan `do-while`.

Validasi digunakan untuk memastikan input yang dimasukkan sesuai kebutuhan program. Jika input tidak sesuai, pengguna diminta memasukkan kembali data tersebut.

Validasi diterapkan pada input seperti kode penerbangan, harga dasar, jumlah kursi, nomor penerbangan yang dipilih, ID tiket, nama penumpang, pilihan kelas kursi, dan status tiket.

Contohnya, validasi supaya harga dasar tidak boleh 0 atau kurang:

<img width="189" height="23" alt="Validasi 2" src="https://github.com/user-attachments/assets/56a18248-efe3-435f-8d4e-64b9757e6cc7" />

## 4. Penjelasan Letak Penerapan Nilai Tambah

### Struktur MVC (Model-View-Controller)

Program disusun memakai struktur MVC dengan membagi class ke beberapa package.

Struktur package yang dipakai pada project:

<img width="253" height="191" alt="MVC" src="https://github.com/user-attachments/assets/f202c75f-5b3f-4f86-8447-bc0e46051291" />
    
- **Model** menyimpan class yang berhubungan dengan data program: `Penumpang`, `Penerbangan`, `Tiket`, `Tiketekonomi`, `Tiketbisnis`.
- **View** menampilkan menu dan pesan ke pengguna lewat class `View`.
- **Controller** mengatur proses pengolahan data lewat class `Controller`, seperti menambah, mencari, mengubah, dan menghapus data.
- **Main** menjalankan program lewat `SistemPemesananTiketPesawat.java`.

### Polymorphism - Method Overriding

Polymorphism diterapkan lewat method overriding pada `tampilkanInfo()`.

Method `tampilkanInfo()` yang terdapat pada class `Tiket` dioverride pada class `Tiketbisnis` dan `Tiketekonomi`.

Contoh pada `model/Tiketbisnis.java`:

<img width="399" height="107" alt="overriding" src="https://github.com/user-attachments/assets/db8ac071-e88b-49f0-bdac-67606b353bfe" />

Sedangkan pada `Tiketekonomi`, method `tampilkanInfo()` yang sama dipakai untuk menampilkan label kategori dan info bagasi yang berbeda dari `Tiketbisnis`.
Dengan menggunakan overriding, method tampilkanInfo() bisa memberikan tampilan yang berbeda sesuai dengan jenis objek yang digunakan.

### Siklus Status Tiket

Program menyediakan menu khusus untuk mengubah status tiket antara `"Dipesan"`, `"Lunas"`, dan `"Dibatalkan"`, lengkap dengan validasi supaya status yang dimasukkan tidak sembarangan (harus salah satu dari tiga nilai tersebut).

### Method Overloading

Ada dua contoh *overloading* pada program ini: `View.tampilkanPesan(String)` versus `View.tampilkanPesan(String label, String pesan)` untuk format pesan validasi, dan `Tiket.tampilkanInfo()` versus `Tiket.tampilkanInfo(boolean ringkas)` untuk memilih tampilan lengkap atau ringkas.

<img width="352" height="97" alt="overloading" src="https://github.com/user-attachments/assets/82fa1143-620a-417f-bebc-3ade4c06ec02" />
<img width="690" height="291" alt="overloading1" src="https://github.com/user-attachments/assets/3c3e2d27-df72-430e-bec2-3a412895489b" />
