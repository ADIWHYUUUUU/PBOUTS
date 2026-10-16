public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Hotel Tugu", 5);
        hotel.setManajer(new Manajer("Ibu Ratna"));

        Tamu bima = new Tamu("3273010101010001", "Bima");
        Tamu citra = new Tamu("3273010202020002", "Citra");

        ReservasiReguler r1 = new ReservasiReguler("RSV-01", 2);
        r1.setTamu(bima);
        ReservasiMember r2 = new ReservasiMember("RSV-02", 3, "MBR");
        r2.setTamu(citra);

        hotel.checkin(r1);
        hotel.checkin(r2, 1);

        Resepsionis resepsionis = new Resepsionis("Dewi");
        resepsionis.cetakInvoice(hotel.getKamar(3));
        resepsionis.cetakInvoice(hotel.getKamar(1));
        System.out.println("Total RSV-01 dengan extra bed : "
                + r1.hitungTotal(hotel.getKamar(3).getTarif(), true));

        Reservasi r = new ReservasiMember("RSV-09", 2, "MBR-01");
        System.out.println("Total RSV-09 : " + r.hitungTotal(500_000));
    }
}
