package program.merkeziislem;

import program.arayuz.Arayuz;
import program.arayuz.IArayuz;

public class MerkeziIslemBirimi implements IMerkeziIslemBirimi {
    IArayuz arayuz = new Arayuz();
    @Override
    public boolean arayuzeGiris() {
        return arayuz.kullaniciGiris();
    }
    // arayuze giris yapildiysa islem secimini tutuyor
    @Override
    public int arayuzIleIslemSecimi() {
        if(arayuzeGiris()){
            return arayuz.islemSecimi();
        }else{
            return 0;
        }
    }
    // islemimize gore metodu cagiriyor
    @Override
    public void islemYap() {
        int islem = arayuzIleIslemSecimi();
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
    }

    @Override
    public void sicaklikGoster() {
        arayuz.sicaklik();
    }

    @Override
    public void sogutucuAc() {
        arayuz.sogutucuAc();

    }

    @Override
    public void sogutucuKapat() {
        arayuz.sogutucuKapat();
    }

    @Override
    public void Cikis() {
        arayuz.Cikis();
    }

}
