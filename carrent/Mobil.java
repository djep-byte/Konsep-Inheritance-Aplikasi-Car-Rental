public class Mobil extends Kendaraan {
    private int jumlahRoda;

    public Mobil(String merk, String model, int tahun) {
        this(merk, model, tahun, 4);
    }

    public Mobil(String merk, String model, int tahun, int jumlahRoda) {
        super(merk, model, tahun);
        this.jumlahRoda = jumlahRoda;
    }

    @Override
    public String tampilkanInfo() {
        String infoDasar = super.tampilkanInfo();
        return "[MOBIL]\n" + infoDasar + "\nJumlah Roda: " + this.jumlahRoda;
    }
}