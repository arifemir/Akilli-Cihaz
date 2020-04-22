package program.isbirimleri;
//subject
public class Eyleyici implements IEyleyici {
    @Override
    public void sogutucuAc() {
        System.out.println("Soğutucu Açılıyor...");
    }

    @Override
    public void sogutucuKapat() {
        System.out.println("Soğutucu kapatılıyor...");
    }
}
