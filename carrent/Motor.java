public class Motor extends Kendaraan {
    private int jumlahRoda;

    public Motor(String merk, String model, int tahun) {
        this(merk, model, tahun, 2);
    }

    public Motor(String merk, String model, int tahun, int jumlahRoda) {
        super(merk, model, tahun);
        this.jumlahRoda = jumlahRoda;
    }

    @Override
    public String tampilkanInfo() {
        String infoDasar = super.tampilkanInfo();
        return "[MOTOR]\n" + infoDasar + "\nJumlah Roda: " + this.jumlahRoda;
    }
}