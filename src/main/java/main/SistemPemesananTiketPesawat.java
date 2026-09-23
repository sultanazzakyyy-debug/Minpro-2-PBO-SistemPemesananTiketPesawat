package main;

import model.Penerbangan;
import model.Penumpang;
import model.Tiket;
import view.View;
import controller.Controller;
import java.util.Scanner;

public class SistemPemesananTiketPesawat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Controller controller = new Controller();
        View view = new View();

        controller.isiDataAwal();

        int pilihan;

        do {
            view.tampilkanMenu();
            pilihan = Integer.parseInt(input.nextLine());

            switch (pilihan) {
                case 1 -> {
                    System.out.println("=== TAMBAH DATA PENERBANGAN ===");

                    String kodePenerbangan;
                    do {
                        System.out.print("Kode Penerbangan: ");
                        kodePenerbangan = input.nextLine();
                        if (kodePenerbangan.equals("")) {
                            view.tampilkanPesan("VALIDASI", "Kode penerbangan tidak boleh kosong!");
                        }
                    } while (kodePenerbangan.equals(""));

                    System.out.print("Kota Asal: ");
                    String asal = input.nextLine();

                    System.out.print("Kota Tujuan: ");
                    String tujuan = input.nextLine();

                    System.out.print("Jam Keberangkatan: ");
                    String jam = input.nextLine();

                    double harga;
                    do {
                        System.out.print("Harga Dasar: ");
                        harga = Double.parseDouble(input.nextLine());
                        if (harga <= 0) {
                            view.tampilkanPesan("VALIDASI", "Harga harus lebih dari 0!");
                        }
                    } while (harga <= 0);

                    int kursi;
                    do {
                        System.out.print("Jumlah Kursi: ");
                        kursi = Integer.parseInt(input.nextLine());
                        if (kursi <= 0) {
                            view.tampilkanPesan("VALIDASI", "Jumlah kursi harus lebih dari 0!");
                        }
                    } while (kursi <= 0);

                    controller.tambahPenerbangan(kodePenerbangan, asal, tujuan, jam, harga, kursi);
                    view.tampilkanPesan("Data penerbangan berhasil ditambahkan!");
                }
                case 2 -> {
                    System.out.println("=== JADWAL PENERBANGAN ===");
                    view.tampilkanJadwalPenerbangan(controller.getDaftarPenerbangan());
                }
                case 3 -> {
                    System.out.println("=== PESAN TIKET ===");

                    if (controller.getDaftarPenerbangan().size() == 0) {
                        view.tampilkanPesan("Belum ada penerbangan yang bisa dipesan.");
                    } else {
                        System.out.println("Daftar penerbangan yang tersedia:");
                        view.tampilkanDaftarPenerbanganRingkas(controller.getDaftarPenerbangan());

                        int nomor;
                        do {
                            System.out.print("Pilih nomor penerbangan: ");
                            nomor = Integer.parseInt(input.nextLine());
                            if (controller.ambilPenerbangan(nomor) == null) {
                                view.tampilkanPesan("VALIDASI", "Nomor penerbangan tidak tersedia!");
                            }
                        } while (controller.ambilPenerbangan(nomor) == null);

                        Penerbangan penerbanganDipilih = controller.ambilPenerbangan(nomor);

                        if (penerbanganDipilih.getKursiTersedia() == 0) {
                            view.tampilkanPesan("Maaf, kursi untuk penerbangan ini sudah habis.");
                        } else {
                            String idTiket;
                            do {
                                System.out.print("ID Tiket: ");
                                idTiket = input.nextLine();
                                if (idTiket.equals("")) {
                                    view.tampilkanPesan("VALIDASI", "ID Tiket tidak boleh kosong!");
                                }
                            } while (idTiket.equals(""));

                            String nama;
                            do {
                                System.out.print("Nama Penumpang: ");
                                nama = input.nextLine();
                                if (nama.equals("")) {
                                    view.tampilkanPesan("VALIDASI", "Nama tidak boleh kosong!");
                                }
                            } while (nama.equals(""));

                            System.out.print("No KTP: ");
                            String noKTP = input.nextLine();

                            System.out.print("No Telepon: ");
                            String noTelepon = input.nextLine();

                            Penumpang penumpang = new Penumpang(nama, noKTP, noTelepon);

                            int pilihKelas;
                            do {
                                System.out.println("Pilih kelas kursi:");
                                System.out.println("1. Ekonomi");
                                System.out.println("2. Bisnis");
                                System.out.print("Pilihan: ");
                                pilihKelas = Integer.parseInt(input.nextLine());
                                if (pilihKelas != 1 && pilihKelas != 2) {
                                    view.tampilkanPesan("VALIDASI", "Pilihan kelas tidak tersedia!");
                                }
                            } while (pilihKelas != 1 && pilihKelas != 2);

                            Tiket tiket = controller.pesanTiket(penerbanganDipilih, idTiket, penumpang, pilihKelas);

                            view.tampilkanPesan("Tiket berhasil dipesan!");
                            System.out.println("Total harga: Rp" + tiket.hitungTotalHarga());
                            System.out.println("Sisa kursi penerbangan " + penerbanganDipilih.getKodePenerbangan()
                                    + " sekarang: " + penerbanganDipilih.getKursiTersedia());
                        }
                    }
                }
                case 4 -> {
                    System.out.println("=== DAFTAR TIKET ===");
                    view.tampilkanDaftarTiket(controller.getDaftarTiket());
                }
                case 5 -> {
                    System.out.println("Daftar tiket saat ini:");
                    view.tampilkanDaftarTiketRingkas(controller.getDaftarTiket());

                    System.out.print("Masukkan ID Tiket yang ingin diubah statusnya: ");
                    String idUbah = input.nextLine();
                    Tiket tiketUbah = controller.cariTiket(idUbah);

                    if (tiketUbah != null) {
                        System.out.println("Status saat ini: " + tiketUbah.getStatusTiket());

                        String statusBaru;
                        do {
                            System.out.print("Status Baru (Dipesan/Lunas/Dibatalkan): ");
                            statusBaru = input.nextLine();
                            if (!statusBaru.equals("Dipesan") && !statusBaru.equals("Lunas") && !statusBaru.equals("Dibatalkan")) {
                                view.tampilkanPesan("VALIDASI", "Status tidak dikenali!");
                            }
                        } while (!statusBaru.equals("Dipesan") && !statusBaru.equals("Lunas") && !statusBaru.equals("Dibatalkan"));

                        controller.updateStatusTiket(idUbah, statusBaru);
                        view.tampilkanPesan("Status tiket berhasil diubah!");
                    } else {
                        view.tampilkanPesan("Tiket tidak ditemukan.");
                    }
                }
                case 6 -> {
                    System.out.println("Daftar tiket saat ini:");
                    view.tampilkanDaftarTiketRingkas(controller.getDaftarTiket());

                    System.out.print("Masukkan ID Tiket yang ingin dibatalkan: ");
                    String idHapus = input.nextLine();
                    Tiket tiketHapus = controller.cariTiket(idHapus);

                    if (tiketHapus != null) {
                        String kodeTerkait = tiketHapus.getPenerbangan().getKodePenerbangan();
                        controller.batalkanTiket(idHapus);

                        view.tampilkanPesan("Tiket berhasil dibatalkan.");
                        System.out.println("Sisa kursi penerbangan " + kodeTerkait
                                + " sekarang: " + tiketHapus.getPenerbangan().getKursiTersedia());
                    } else {
                        view.tampilkanPesan("Tiket tidak ditemukan.");
                    }
                }
                case 7 -> view.tampilkanPesan("Terima kasih telah menggunakan sistem ini!");
                default -> view.tampilkanPesan("Pilihan tidak tersedia!");
            }

        } while (pilihan != 7);
    }
}