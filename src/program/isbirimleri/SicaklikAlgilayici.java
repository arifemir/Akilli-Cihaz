package program.isbirimleri;

import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayiciObserver {

    @Override
    public int sicaklikOku() {
        Random rnd = new Random();
        int sayi = rnd.nextInt(80);
        return sayi;
    }

    @Override
    public int sicaklikGonder() {
        System.out.println("Sicaklik: "+sicaklikOku());
        return sicaklikOku();
    }
}
