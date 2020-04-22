package program.arayuz;

import program.isbirimleri.IEyleyiciObserver;
import program.isbirimleri.ISicaklikAlgilayiciObserver;
import veritabani.IKullaniciVeriTabaniServisi;
import veritabani.postgreSQL.KullaniciPostgreSQLSurucusu;


import java.util.Scanner;

public class Arayuz implements IArayuzSubject {
    Scanner input = new Scanner(System.in);

    @Override
    public boolean kullaniciGiris() {
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
        } else {
            return false;
        }
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
    public void sicaklik(ISicaklikAlgilayiciObserver observer) {
        observer.sicaklikGonder();
    }

    @Override
    public void sogutucuAc(IEyleyiciObserver observer) {
        observer.sogutucuAc();
    }

    @Override
    public void sogutucuKapat(IEyleyiciObserver observer) {
        observer.sogutucuKapat();
    }


    @Override
    public void Cikis() {
        System.out.println("Arayüzden çıkış yapılıyor...");
    }
}
