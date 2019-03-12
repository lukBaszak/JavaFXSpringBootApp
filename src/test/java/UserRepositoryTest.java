import com.lubaszak.model.user.User;
import com.lubaszak.repository.UserRepository;
import com.lubaszak.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void saveUser() {
        userRepository.save(new User("lol", "hey"));
    }
}
