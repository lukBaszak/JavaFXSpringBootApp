import com.lubaszak.model.Menu;
import com.lubaszak.service.MenuService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MenuRepositoryTest {

    @Autowired
    MenuService menuService;

    @Test
    public void saveMenu() {
        menuService.save(new Menu());
    }


}
