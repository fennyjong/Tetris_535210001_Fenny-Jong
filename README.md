# Tetris Game

**Deskripsi:**
Proyek ini adalah implementasi game Tetris menggunakan bahasa pemrograman Java. Tetris adalah permainan puzzle klasik yang menciptakan tantangan dengan menjatuhkan bentuk-bentuk yang berbeda ke dalam bidang permainan untuk membentuk garis horizontal penuh. Setiap kali garis terbentuk, itu akan menghilang dan memberikan pemain poin.

## Fitur Utama
- **Desain Antarmuka Grafis Sederhana**
- **Menampilkan Tetrimino Selanjutnya**
- **Kontrol Mudah:** Menggunakan tombol panah kiri dan kanan untuk menggerakkan, panah atas untuk memutar tetrimino, dan space untuk menjatuhkan tetrimino.
- **Menampilkan Total Lines:** Setiap kali pemain berhasil mengisi 1 baris penuh dengan tetrimino.
- **Skor dan Level:** Pemain dapat melihat skor mereka dan tingkat kesulitan saat bermain. Skor dihitung dengan mengalikan setiap baris tetrimino yang berhasil diisi (Total Line) dengan 150, yang berarti setiap kali pemain berhasil mengisi satu baris, mereka mendapatkan 150 poin.
  - Jika total skor berada di antara 500 dan 999, level diatur menjadi 2.
  - Jika total skor berada di antara 1000 dan 1999, level diatur menjadi 3.
  - Jika total skor berada di antara 2000 dan 4999, level diatur menjadi 4.
  - Jika total skor 5000 atau lebih, level diatur menjadi 5.
- **Menampilkan Game Over**

## Cara Menjalankan Proyek
1. Pastikan Anda memiliki Java Development Kit (JDK) terinstall.
2. Clone repositori ini.
    ```sh
    git clone https://github.com/username/Tetris-Java.git
    ```
3. Jalankan class Tetris.java untuk memulai permainan.

## Screenshots
![Tetris UI](https://github.com/fennyjong/Tetris_535210001_Fenny-Jong/assets/89572393/d7bfc785-eb03-44d6-8173-f21acfdae758)
