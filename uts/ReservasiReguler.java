public class ReservasiReguler extends Reservasi {
    public ReservasiReguler(String kode, int jumlahMalam) {
        super(kode, jumlahMalam);
    }

    @Override
    public int hitungTotal(int tarifPerMalam) {
        return super.hitungTotal(tarifPerMalam);
    }

    @Override
    public String getJenis() {
        return "Reguler";
    }
}
