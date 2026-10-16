public class Resepsionis {
    private String nama;

    public Resepsionis(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void cetakInvoice(Kamar kamar) {
        if (kamar == null || kamar.isiKosong()) {
            throw new IllegalArgumentException("Kamar harus terisi untuk mencetak invoice.");
        }
        Reservasi reservasi = kamar.getReservasi();
        if (reservasi.getTamu() == null) {
            throw new IllegalStateException("Reservasi belum memiliki data tamu.");
        }
        int total = reservasi.hitungTotal(kamar.getTarif());
        System.out.println("Invoice Kamar " + kamar.getNomor() + " (" + kamar.getTipe() + ") - "
                + reservasi.getKode() + " " + reservasi.getTamu().getNama() + " ["
                + reservasi.getJenis() + "] " + reservasi.getJumlahMalam()
                + " malam : " + total);
    }
}
