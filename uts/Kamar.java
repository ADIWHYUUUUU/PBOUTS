public class Kamar {
    private final int nomor;
    private final String tipe;
    private final int tarif;
    private Reservasi reservasi;

    public Kamar(int nomor, String tipe, int tarif) {
        if (nomor <= 0 || tipe == null || tipe.trim().isEmpty() || tarif <= 0) {
            throw new IllegalArgumentException("Data kamar tidak valid.");
        }
        this.nomor = nomor;
        this.tipe = tipe;
        this.tarif = tarif;
    }

    public int getNomor() {
        return nomor;
    }

    public String getTipe() {
        return tipe;
    }

    public int getTarif() {
        return tarif;
    }

    public Reservasi getReservasi() {
        return reservasi;
    }

    public boolean isi(Reservasi reservasi) {
        if (!isiKosong() || reservasi == null) {
            return false;
        }
        this.reservasi = reservasi;
        return true;
    }

    public boolean isiKosong() {
        return reservasi == null;
    }
}
