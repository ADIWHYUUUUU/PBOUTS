import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hotel {
    private final String nama;
    private final List<Kamar> kamar;
    private Manajer manajer;

    public Hotel(String nama, int jumlahKamar) {
        if (nama == null || nama.trim().isEmpty() || jumlahKamar <= 0) {
            throw new IllegalArgumentException("Nama hotel dan jumlah kamar harus valid.");
        }
        this.nama = nama;
        this.kamar = new ArrayList<>();
        for (int nomor = 1; nomor <= jumlahKamar; nomor++) {
            if (nomor == 1) {
                kamar.add(new Kamar(nomor, "Deluxe", 750_000));
            } else if (nomor == 3) {
                kamar.add(new Kamar(nomor, "Standard", 550_000));
            } else {
                kamar.add(new Kamar(nomor, "Superior", 650_000));
            }
        }
    }

    public String getNama() {
        return nama;
    }

    public List<Kamar> getKamar() {
        return Collections.unmodifiableList(kamar);
    }

    public void setManajer(Manajer manajer) {
        if (manajer == null) {
            throw new IllegalArgumentException("Manajer tidak boleh null.");
        }
        this.manajer = manajer;
    }

    public Manajer getManajer() {
        return manajer;
    }

    public void checkin(Reservasi reservasi) {
        for (Kamar kandidat : kamar) {
            if (kandidat.getTipe().equals("Standard") && kandidat.isiKosong()) {
                checkin(reservasi, kandidat.getNomor());
                return;
            }
        }
        throw new IllegalStateException("Tidak ada kamar Standard yang tersedia.");
    }

    public void checkin(Reservasi reservasi, int nomorKamar) {
        if (reservasi == null) {
            throw new IllegalArgumentException("Reservasi tidak boleh null.");
        }
        if (reservasi.getTamu() == null) {
            throw new IllegalStateException("Reservasi harus memiliki tamu sebelum check-in.");
        }
        Kamar kamarTujuan = getKamar(nomorKamar);
        if (!kamarTujuan.isi(reservasi)) {
            throw new IllegalStateException("Kamar " + nomorKamar + " sedang terisi.");
        }
    }

    public Kamar getKamar(int nomor) {
        for (Kamar item : kamar) {
            if (item.getNomor() == nomor) {
                return item;
            }
        }
        throw new IllegalArgumentException("Kamar " + nomor + " tidak ditemukan.");
    }

    public void tampilInfo() {
        System.out.println("Hotel: " + nama);
        System.out.println("Manajer: " + (manajer == null ? "Belum ditentukan" : manajer.getNama()));
        for (Kamar item : kamar) {
            System.out.println("Kamar " + item.getNomor() + " (" + item.getTipe() + "): "
                    + (item.isiKosong() ? "Kosong" : "Terisi"));
        }
    }
}
