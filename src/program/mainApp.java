package program;

import program.merkeziislem.IMerkeziIslemBirimi;
import program.merkeziislem.MerkeziIslemBirimi;

public class mainApp {
    public static void main(String[] args) {
        IMerkeziIslemBirimi merkeziIslemBirimi = new MerkeziIslemBirimi();
        merkeziIslemBirimi.islemYap();
    }
}
