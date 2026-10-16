public class Tamu {
    private final String nik;
    private String nama;

    public Tamu(String nik, String nama) {
        if (nik == null || nik.trim().isEmpty() || nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("NIK dan nama tamu harus diisi.");
        }
        this.nik = nik;
        this.nama = nama;
    }

    public String getNik() {
        return nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
