public class Kendaraan {
    protected String merk;
    protected String model;
    protected int tahunProduksi;
    protected String status;
    protected Penyewa penyewa;

    public Kendaraan(String merk, String model, int tahun) {
        this.merk = merk;
        this.model = model;
        this.tahunProduksi = tahun;
        this.status = "Tersedia";
        this.penyewa = null;
    }

    public boolean sewa(Penyewa penyewa) {
        if (this.status.equals("Tersedia")) {
            this.status = "Disewa";
            this.penyewa = penyewa;
            System.out.println("BERHASIL: " + this.merk + " " + this.model + " disewa oleh " + penyewa.getNama() + ".");
            return true;
        } else {
            System.out.println("GAGAL: " + this.merk + " " + this.model + " sudah disewa oleh " + this.penyewa.getNama() + ".");
            return false;
        }
    }

    public void kembalikan() {
        if (this.status.equals("Disewa")) {
            System.out.println("INFO: " + this.merk + " " + this.model + " telah dikembalikan oleh " + this.penyewa.getNama() + ".");
            this.status = "Tersedia";
            this.penyewa = null;
        } else {
            System.out.println("INFO: " + this.merk + " " + this.model + " memang sedang tersedia.");
        }
    }

    public String tampilkanInfo() {
        String info = "Merk: " + this.merk + ", Model: " + this.model + ", Tahun: " + this.tahunProduksi;
        info += "\nStatus: " + this.status;
        if (this.penyewa != null) {
            info += ", Penyewa: " + this.penyewa.getNama();
        }
        return info;
    }
}