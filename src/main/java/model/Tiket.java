package model;

public class Tiket {

    private final String idTiket;
    protected Penumpang penumpang;
    protected Penerbangan penerbangan;
    protected String statusTiket;

    public Tiket(String idTiket, Penumpang penumpang, Penerbangan penerbangan) {
        this.idTiket = idTiket;
        this.penumpang = penumpang;
        setPenerbangan(penerbangan);
        this.statusTiket = "Dipesan";
    }

    public String getIdTiket() {
        return idTiket;
    }

    public Penerbangan getPenerbangan() {
        return penerbangan;
    }

    public void setPenerbangan(Penerbangan penerbangan) {
        this.penerbangan = penerbangan;
    }

    public String getStatusTiket() {
        return statusTiket;
    }

    public void setStatusTiket(String statusTiket) {
        this.statusTiket = statusTiket;
    }

    public String getNamaKelas() {
        return "Ekonomi";
    }

    public double hitungTotalHarga() {
        return penerbangan.getHarga();
    }

    public void tampilkanInfo() {
        System.out.println("ID Tiket         : " + idTiket);
        System.out.println("Nama Penumpang   : " + penumpang.getNama());
        System.out.println("No KTP           : " + penumpang.getNoKTP());
        System.out.println("No Telepon       : " + penumpang.getNoTelepon());
        System.out.println("Kode Penerbangan : " + penerbangan.getKodePenerbangan());
        System.out.println("Asal             : " + penerbangan.getAsal());
        System.out.println("Tujuan           : " + penerbangan.getTujuan());
        System.out.println("Jam Keberangkatan: " + penerbangan.getJamKeberangkatan());
        System.out.println("Kelas Kursi      : " + getNamaKelas());
        System.out.println("Total Harga      : Rp" + hitungTotalHarga());
        System.out.println("Status Tiket     : " + statusTiket);
    }

    // OVERLOADING - versi ringkas satu baris, dipakai buat nampilin daftar singkat
    public void tampilkanInfo(boolean ringkas) {
        if (ringkas) {
            System.out.println(idTiket + " - " + penumpang.getNama() + " (" + getNamaKelas() + ") - " + statusTiket);
        } else {
            tampilkanInfo();
        }
    }
}