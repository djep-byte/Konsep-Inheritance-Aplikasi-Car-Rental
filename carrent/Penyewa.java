public class Penyewa {
    private String nama;
    private String noTelepon;

    public Penyewa(String nama, String noTelepon) {
        this.nama = nama;
        this.noTelepon = noTelepon;
    }

    public String getNama() {
        return this.nama;
    }

    public String getNoTelepon() {
        return this.noTelepon;
    }

    @Override
    public String toString() {
        return this.nama + " (HP: " + this.noTelepon + ")";
    }
}