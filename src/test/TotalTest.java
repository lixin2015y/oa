import com.lee.MainApplication;
import com.lee.dao.UserDao;
import com.lee.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class TotalTest {

    @Autowired
    UserDao userDao;

    @Test
    public void test1() {
        User user = userDao.selectUserByTicket("b50c6c61-e195-4599-9");
        System.out.println(user);
    }



}
