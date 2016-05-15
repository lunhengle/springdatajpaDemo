import com.lhl.springjpa.bean.User;
import com.lhl.springjpa.service.iface.UserServiceIface;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lunhengle on 2015/8/14.
 */
public class TestUserService {
    private ApplicationContext applicationContext;
    private UserServiceIface userServiceIface;

    @Before
    public void before() {
        String[] configLocation = new String[]{"applicationContext.xml"};
        applicationContext = new ClassPathXmlApplicationContext(configLocation);
        userServiceIface = (UserServiceIface) applicationContext.getBean("userServiceIface");
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setName("伦恒乐");
        user.setPassword("3456789");
        user.setPhone("456789");
        userServiceIface.insertUser(user);
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setId(1);
        user.setName("论语");
        userServiceIface.updateUser(user);
    }

    @Test
    public void deleteUser() {
        userServiceIface.deleteUser(1);
    }

    @Test
    public void getListUser() {
        List<User> list = userServiceIface.getListUser();
        for (User user : list) {
            System.out.println("name: " + user.getName() + "  password: " + user.getPassword() + " phone: " + user.getPhone());
        }
    }

    @Test
    public void getUser() {
        User user = userServiceIface.getUser(2);
        System.out.println("name: " + user.getName() + "  password: " + user.getPassword() + " phone: " + user.getPhone());
    }

    @Test
    public void getUserByNameAndPhone() {
        List<User> list = userServiceIface.getListUserByNameAndPhone("伦", "45");
        for (User user : list) {
            System.out.println(" id: "+user.getId()+"name: " + user.getName() + "  password: " + user.getPassword() + " phone: " + user.getPhone());
        }
    }

    @Test
    public void getUserByNameAndPhoneSort() {
        //三种方式排序
        //List<User> list = userServiceIface.getListUserByNameAndPhone("伦","45",new Sort(Sort.Direction.DESC,"id"));

        //Sort.Order order = new Sort.Order(Sort.Direction.ASC, "id");
        //List<User> list = userServiceIface.getListUserByNameAndPhone("伦", "45", new Sort(order));

        List<Sort.Order> orderList = new ArrayList<Sort.Order>();
        orderList.add(new Sort.Order(Sort.Direction.ASC, "id"));
        orderList.add(new Sort.Order(Sort.Direction.DESC, "name"));
        List<User> list = userServiceIface.getListUserByNameAndPhone("伦", "45", new Sort(orderList));

        for (User user : list) {
            System.out.println("id: " + user.getId() + " name: " + user.getName() + "  password: " + user.getPassword() + " phone: " + user.getPhone());
        }
    }

    @Test
    public void getUserByNameAndPhonePage() {
        Page<User> userPage = userServiceIface.getListUserByNameAndPhone("伦", "45", new PageRequest(0, 2,new Sort(Sort.Direction.DESC,"id")));
        printPageInfo(userPage);
        List<User> userList = userPage.getContent();
        for (User user : userList) {
            System.out.println("id: " + user.getId() + " name: " + user.getName() + "  password: " + user.getPassword() + " phone: " + user.getPhone());
        }
    }

    public void printPageInfo(Page pageInfo) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("当前页是第几页：" + pageInfo.getNumber()).append("\n");
        stringBuffer.append("当前页查询得到记录数：" + pageInfo.getTotalElements()).append("\n");
        stringBuffer.append("每页需要查询的记录数：" + pageInfo.getSize()).append("\n");
        stringBuffer.append("总共符合条数记录数：" + pageInfo.getTotalElements()).append("\n");
        stringBuffer.append("总共的页数是：" + pageInfo.getTotalPages()).append("\n");
        System.out.println(stringBuffer.toString());

    }
}
