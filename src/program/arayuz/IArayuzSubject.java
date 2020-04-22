package program.arayuz;

import program.isbirimleri.IEyleyici;
import program.isbirimleri.ISicaklikAlgilayici;

//observer
public interface IArayuzSubject {
    public boolean kullaniciGiris();
    public int islemSecimi();
    public void sicaklik(ISicaklikAlgilayici sicaklikAlgilayici);
    public void sogutucuAc(IEyleyici eyleyici);
    public void sogutucuKapat(IEyleyici eyleyici);
    public void Cikis();
}
