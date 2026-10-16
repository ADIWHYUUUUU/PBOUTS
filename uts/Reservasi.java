public abstract class Reservasi {
    private final String kode;
    private final int jumlahMalam;
    private Tamu tamu;

    protected Reservasi(String kode, int jumlahMalam) {
        if (kode == null || kode.trim().isEmpty()) {
            throw new IllegalArgumentException("Kode reservasi tidak boleh kosong.");
        }
        if (jumlahMalam <= 0) {
            throw new IllegalArgumentException("Jumlah malam harus lebih dari 0.");
        }
        this.kode = kode;
        this.jumlahMalam = jumlahMalam;
    }

    public String getKode() {
        return kode;
    }

    public int getJumlahMalam() {
        return jumlahMalam;
    }

    public Tamu getTamu() {
        return tamu;
    }

    public void setTamu(Tamu tamu) {
        if (tamu == null) {
            throw new IllegalArgumentException("Tamu tidak boleh null.");
        }
        this.tamu = tamu;
    }

    public int hitungTotal(int tarifPerMalam) {
        return tarifPerMalam * jumlahMalam;
    }

    public int hitungTotal(int tarifPerMalam, boolean extraBed) {
        return hitungTotal(tarifPerMalam) + (extraBed ? 300_000 : 0);
    }

    public abstract String getJenis();
}
