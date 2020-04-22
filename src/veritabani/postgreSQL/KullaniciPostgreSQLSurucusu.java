package veritabani.postgreSQL;

import veritabani.IKullaniciVeriTabaniServisi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//singleton
public class KullaniciPostgreSQLSurucusu implements IKullaniciVeriTabaniServisi {
    public static KullaniciPostgreSQLSurucusu nesne;

    private KullaniciPostgreSQLSurucusu() {
    }

    public static KullaniciPostgreSQLSurucusu Nesne() {
        if (nesne == null) {
            nesne = new KullaniciPostgreSQLSurucusu();
        }
        return nesne;
    }

    // kullanici bilgilerini veritabanindan alinip dogrulama yapiliyor eger dogruysa true donuyor
    @Override
    public boolean kullaniciDogrulama(String kullaniciAdi, String parola) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/akilli_cihaz", "postgres", "159852arife");
            if (conn != null) {
                String KullaniciSql = "SELECT * FROM public.\"Kullanici\"";
                Statement stmt = conn.createStatement();
                ResultSet result = stmt.executeQuery(KullaniciSql);
                conn.close();
                String _kullaniciAdi = "";
                String _parola = "";
                while (result.next()) {
                    _kullaniciAdi = result.getString("kullanici_adi");
                    _parola = result.getString("parola");
                }
                if (_kullaniciAdi.equals(kullaniciAdi) && _parola.equals(parola)) {
                    System.out.println("-----BAŞARILI Arayüzü kullanabilirsiniz-----");
                    return true;
                } else {
                    System.out.println("-----BAŞARISIZ Arayüzü kullanamazsınız-----");
                    return false;
                }
            } else {
                System.out.println("PostgreSQL Veritabanina Baglanilamadi");
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }
}
