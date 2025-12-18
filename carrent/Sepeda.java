public class Sepeda extends Kendaraan {
    private String jenisSepeda;

    public Sepeda(String merk, String model, int tahun, String jenisSepeda) {
        super(merk, model, tahun);
        this.jenisSepeda = jenisSepeda;
    }

    @Override
    public String tampilkanInfo() {
        String infoDasar = super.tampilkanInfo();
        return "[SEPEDA]\n" + infoDasar + "\nJenis Sepeda: " + this.jenisSepeda;
    }
}