package program.merkeziislem;

import program.arayuz.Arayuz;
import program.arayuz.IArayuz;
import program.isbirimleri.Eyleyici;
import program.isbirimleri.IEyleyici;
import program.isbirimleri.ISicaklikAlgilayici;
import program.isbirimleri.SicaklikAlgilayici;

public class MerkeziIslemBirimi implements IMerkeziIslemBirimi {
    IArayuz arayuz = new Arayuz();
    ISicaklikAlgilayici sicaklikAlgilayici = new SicaklikAlgilayici();
    IEyleyici eyleyici = new Eyleyici();
    @Override
    public boolean arayuzeGiris() {
        return arayuz.kullaniciGiris();
    }
    // arayuze giris yapildiysa islem secimini tutuyor
    @Override
    public int arayuzIleIslemSecimi() {
        return arayuz.islemSecimi();
    }
    // islemimize gore metodu cagiriyor
    @Override
    public void islemYap() {
        if (arayuzeGiris()){
            int islem=0;
            do{
                islem = arayuzIleIslemSecimi();
                switch (islem){
                    case 1:
                        sicaklikGoster();
                        break;
                    case 2:
                        sogutucuAc();
                        break;
                    case 3:
                        sogutucuKapat();
                        break;
                    case 4:
                        Cikis();
                        break;
                    default:
                        System.out.println("DOGRU GİRİŞ YAPIN");
                        break;
                }
            }while(islem!=4);
        }else {
            System.out.println("ARAYUZE GIRMEDEN ISLEM YAPAMAZSINIZ");
        }
    }

    @Override
    public void sicaklikGoster() {
        arayuz.sicaklik(sicaklikAlgilayici);
    }

    @Override
    public void sogutucuAc() {
        arayuz.sogutucuAc(eyleyici);

    }

    @Override
    public void sogutucuKapat() {
        arayuz.sogutucuKapat(eyleyici);
    }

    @Override
    public void Cikis() {
        arayuz.Cikis();
    }

}
