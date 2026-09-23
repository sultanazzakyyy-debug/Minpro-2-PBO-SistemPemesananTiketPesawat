package controller;

import model.Penerbangan;
import model.Penumpang;
import model.Tiket;
import model.Tiketekonomi;
import model.Tiketbisnis;
import java.util.ArrayList;

public class Controller {

    private ArrayList<Penerbangan> daftarPenerbangan;
    private ArrayList<Tiket> daftarTiket;

    public Controller() {
        daftarPenerbangan = new ArrayList<>();
        daftarTiket = new ArrayList<>();
    }

    // DUMMY DATA AWAL - supaya menu Lihat langsung ada isinya
    public void isiDataAwal() {
        Penerbangan penerbanganAwal = new Penerbangan("GA401", "Balikpapan", "Jakarta", "08.00", 1500000, 10);
        daftarPenerbangan.add(penerbanganAwal);

        Penumpang penumpangAwal = new Penumpang("Sultan", "1234567890", "081234567890");
        Tiket tiketAwal = new Tiketekonomi("T001", penumpangAwal, penerbanganAwal);
        daftarTiket.add(tiketAwal);
        penerbanganAwal.kurangiKursi();
    }

    public ArrayList<Penerbangan> getDaftarPenerbangan() {
        return daftarPenerbangan;
    }

    public ArrayList<Tiket> getDaftarTiket() {
        return daftarTiket;
    }

    public void tambahPenerbangan(String kode, String asal, String tujuan, String jam, double harga, int kursi) {
        Penerbangan penerbangan = new Penerbangan(kode, asal, tujuan, jam, harga, kursi);
        daftarPenerbangan.add(penerbangan);
    }

    public Penerbangan ambilPenerbangan(int nomor) {
        if (nomor < 1 || nomor > daftarPenerbangan.size()) {
            return null;
        }
        return daftarPenerbangan.get(nomor - 1);
    }

    public Tiket pesanTiket(Penerbangan penerbangan, String idTiket, Penumpang penumpang, int pilihKelas) {
        Tiket tiket;

        if (pilihKelas == 2) {
            tiket = new Tiketbisnis(idTiket, penumpang, penerbangan);
        } else {
            tiket = new Tiketekonomi(idTiket, penumpang, penerbangan);
        }

        daftarTiket.add(tiket);
        penerbangan.kurangiKursi();
        return tiket;
    }

    public Tiket cariTiket(String idTiket) {
        for (Tiket t : daftarTiket) {
            if (t.getIdTiket().equals(idTiket)) {
                return t;
            }
        }
        return null;
    }

    public boolean updateStatusTiket(String idTiket, String statusBaru) {
        Tiket t = cariTiket(idTiket);
        if (t == null) {
            return false;
        }
        t.setStatusTiket(statusBaru);
        return true;
    }

    public boolean batalkanTiket(String idTiket) {
        Tiket t = cariTiket(idTiket);
        if (t == null) {
            return false;
        }
        t.getPenerbangan().tambahKursi();
        daftarTiket.remove(t);
        return true;
    }
}