package tugasrancangpbo;

import com.tugasrancang.models.Model_Menu;
import javax.swing.Icon;

public class main {

    public static void main(String[] args) {
        Model_Menu menu = new Model_Menu("1", "Dashboard", Model_Menu.MenuType.MENU);
        
        Icon icon = menu.toIcon();

        if (icon != null) {
            System.out.println("Ikon berhasil dimuat.");
        } else {
            System.out.println("Ikon tidak ditemukan.");
        }
    }
}
