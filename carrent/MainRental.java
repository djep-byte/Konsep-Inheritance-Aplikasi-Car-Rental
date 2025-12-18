import java.util.ArrayList;
import java.util.List;

public class MainRental {
    private List<Kendaraan> daftarKendaraan;

    public MainRental() {
        this.daftarKendaraan = new ArrayList<>();
    }

    public void tambahKendaraan(Kendaraan kendaraan) {
        this.daftarKendaraan.add(kendaraan);
        System.out.println("INFO: " + kendaraan.merk + " " + kendaraan.model + " ditambahkan ke sistem.");
    }

    public Kendaraan cariKendaraan(String merk, String model) {
        for (Kendaraan k : this.daftarKendaraan) {
            if (k.merk.equalsIgnoreCase(merk) && k.model.equalsIgnoreCase(model)) {
                return k;
            }
        }
        return null;
    }

    public void tampilkanListKendaraanTersedia() {
        System.out.println("\n--- DAFTAR KENDARAAN TERSEDIA ---");
        boolean adaYangTersedia = false;
        for (Kendaraan k : this.daftarKendaraan) {
            if (k.status.equals("Tersedia")) {
                System.out.println(k.tampilkanInfo());
                System.out.println("--------------------");
                adaYangTersedia = true;
            }
        }
        if (!adaYangTersedia) {
            System.out.println("Semua kendaraan sedang disewa.");
        }
    }

    public void tampilkanListPenyewa() {
        System.out.println("\n--- DAFTAR PENYEWA AKTIF ---");
        boolean adaPenyewa = false;
        for (Kendaraan k : this.daftarKendaraan) {
            if (k.status.equals("Disewa")) {
                System.out.println("Penyewa: **" + k.penyewa.getNama() + "** (HP: " + k.penyewa.getNoTelepon() + ")");
                System.out.println(k.tampilkanInfo());
                System.out.println("--------------------");
                adaPenyewa = true;
            }
        }
        if (!adaPenyewa) {
            System.out.println("Belum ada kendaraan yang disewa.");
        }
    }

    public static void main(String[] args) {
        MainRental sistem = new MainRental();

        sistem.tambahKendaraan(new Mobil("Toyota", "Avanza", 2021));
        sistem.tambahKendaraan(new Mobil("Daihatsu", "Xenia", 2022));
        sistem.tambahKendaraan(new Motor("Honda", "Vario 150", 2023));
        sistem.tambahKendaraan(new Sepeda("Polygon", "Strattos S5", 2022, "Balap"));

        sistem.tampilkanListKendaraanTersedia();

        Penyewa penyewa1 = new Penyewa("Budi Hartono", "0812345678");
        Penyewa penyewa2 = new Penyewa("Citra Lestari", "0898765432");

        System.out.println("\n--- PROSES SEWA ---");
        Kendaraan avanza = sistem.cariKendaraan("Toyota", "Avanza");
        if (avanza != null) {
            avanza.sewa(penyewa1);
        }
        Kendaraan vario = sistem.cariKendaraan("Honda", "Vario 150");
        if (vario != null) {
            vario.sewa(penyewa2);
        }

        sistem.tampilkanListPenyewa();
        sistem.tampilkanListKendaraanTersedia();

        System.out.println("\n--- PROSES PENGEMBALIAN ---");
        if (avanza != null) {
            avanza.kembalikan();
        }

        sistem.tampilkanListPenyewa();
        sistem.tampilkanListKendaraanTersedia();
    }
}