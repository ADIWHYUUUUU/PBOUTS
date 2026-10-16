public class ReservasiMember extends Reservasi {
    private final String nomorMember;

    public ReservasiMember(String kode, int jumlahMalam, String nomorMember) {
        super(kode, jumlahMalam);
        if (nomorMember == null || nomorMember.trim().isEmpty()) {
            throw new IllegalArgumentException("Nomor member tidak boleh kosong.");
        }
        this.nomorMember = nomorMember;
    }

    public String getNomorMember() {
        return nomorMember;
    }

    @Override
    public int hitungTotal(int tarifPerMalam) {
        int subtotal = super.hitungTotal(tarifPerMalam);
        return subtotal - subtotal * 15 / 100;
    }

    @Override
    public String getJenis() {
        return "Member";
    }
}
