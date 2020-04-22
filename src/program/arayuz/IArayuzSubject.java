package program.arayuz;

import program.isbirimleri.IEyleyiciObserver;
import program.isbirimleri.ISicaklikAlgilayiciObserver;

//observer
public interface IArayuzSubject {
    public boolean kullaniciGiris();
    public int islemSecimi();
    public void sicaklik(ISicaklikAlgilayiciObserver observer);
    public void sogutucuAc(IEyleyiciObserver observer);
    public void sogutucuKapat(IEyleyiciObserver observer);
    public void Cikis();
}
