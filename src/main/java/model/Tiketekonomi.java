package model;

public class Tiketekonomi extends Tiket {

    private int bagasiKg;

    public Tiketekonomi(String idTiket, Penumpang penumpang, Penerbangan penerbangan) {
        super(idTiket, penumpang, penerbangan);
        this.bagasiKg = 20;
    }

    @Override
    public String getNamaKelas() {
        return "Ekonomi";
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("-----------------------------------");
        System.out.println("[KATEGORI: TIKET EKONOMI]");
        super.tampilkanInfo();
        System.out.println("Bagasi           : " + bagasiKg + " kg");
        System.out.println("-----------------------------------");
    }
}