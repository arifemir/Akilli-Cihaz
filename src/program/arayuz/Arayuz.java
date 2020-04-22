package program.arayuz;

import program.isbirimleri.IEyleyici;
import program.isbirimleri.ISicaklikAlgilayici;
import program.observer.IObserver;
import veritabani.IKullaniciVeriTabaniServisi;
import veritabani.postgreSQL.KullaniciPostgreSQLSurucusu;


import java.util.Scanner;

public class Arayuz implements IArayuz, IObserver {
    Scanner input = new Scanner(System.in);
    //3 deneme hakki olan kullanici girisi
    @Override
    public boolean kullaniciGiris() {
        int hak = 0;
        do{
            hak++;
            System.out.println("---ARAYUZ---");
            IKullaniciVeriTabaniServisi kulllanici = KullaniciPostgreSQLSurucusu.Nesne();
            String kullaniciAdi = "";
            String parola = "";
            System.out.println("----İslem yapabilmek icin bilgilerinizi girin----");
            System.out.println("Kullanıcı Adı: ");
            kullaniciAdi = input.next();
            System.out.println("Parola: ");
            parola = input.next();
            boolean sonuc = kulllanici.kullaniciDogrulama(kullaniciAdi, parola);
            if (sonuc) {
                return true;
            }
        }while(hak!=3);
        return false;
    }

    @Override
    public int islemSecimi() {
        int islem = 0;
        System.out.println("-------İŞLEMLER-------");
        System.out.println("| 1-Sıcaklık göster  |");
        System.out.println("| 2-Soğutucu aç      |");
        System.out.println("| 3-Soğutucu kapat   |");
        System.out.println("| 4-Çıkış            |");
        System.out.println("----------------------");
        islem = input.nextInt();
        if (islem == 0) {
            System.out.println("İslem seçilemedi");
        } else {
            System.out.println("Seçilen işlem: " + islem);
        }
        return islem;
    }

    @Override
    public void sicaklik(ISicaklikAlgilayici sicaklikAlgilayici) {
        sicaklikAlgilayici.sicaklikGonder();
    }

    @Override
    public void sogutucuAc(IEyleyici eyleyici) {
        eyleyici.sogutucuAc();
    }

    @Override
    public void sogutucuKapat(IEyleyici eyleyici) {
        eyleyici.sogutucuKapat();
    }


    @Override
    public void Cikis() {
        System.out.println("Arayüzden çıkış yapılıyor...");
    }

    @Override
    public void guncelle(int sicaklik) {
        System.out.println("Sicaklik degisimi guncellendi");
    }
}
