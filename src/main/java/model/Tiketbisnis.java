package model;

public class Tiketbisnis extends Tiket {

    private int bagasiKg;

    public Tiketbisnis(String idTiket, Penumpang penumpang, Penerbangan penerbangan) {
        super(idTiket, penumpang, penerbangan);
        this.bagasiKg = 30;
    }

    @Override
    public String getNamaKelas() {
        return "Bisnis";
    }

    @Override
    public double hitungTotalHarga() {
        return getPenerbangan().getHarga() * 1.5;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("-----------------------------------");
        System.out.println("[KATEGORI: TIKET BISNIS]");
        super.tampilkanInfo();
        System.out.println("Bagasi           : " + bagasiKg + " kg");
        System.out.println("-----------------------------------");
    }
}