import com.lhl.springjpa.bean.Person;
import com.lhl.springjpa.service.iface.PersonQueryServiceIface;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by lunhengle on 2015/8/26.
 */
public class TestPersonQueryService {
    private ApplicationContext applicationContext;
    private PersonQueryServiceIface personQueryServiceIface;

    @Before
    public void before() {
        String[] configLocation = new String[]{"applicationContext.xml"};
        applicationContext = new ClassPathXmlApplicationContext(configLocation);
        personQueryServiceIface = (PersonQueryServiceIface) applicationContext.getBean("personQueryServiceIface");
    }

    @Test
    public void getPerson() {
        List<Person> list = personQueryServiceIface.getPerson();
        for (Person p : list) {
            System.out.println(p.getName());
        }
    }

    @Test
    public void selectSinglePerson() {
        Person person = personQueryServiceIface.selectSinglePerson(1);
        System.out.println(person.getName());
    }

    @Test
    public void selectSinglePerson1() {
        Person person = personQueryServiceIface.selectSinglePerson1(1);
        System.out.println(person.getName());
    }

    @Test
    public void updatePerson() {
        personQueryServiceIface.updatePerson("伦恒乐1", 1);
    }

    @Test
    public void updatePerson1() {
        personQueryServiceIface.updatePerson1("伦恒乐2", 1);
    }

    @Test
    public void insertPerson() {
        personQueryServiceIface.insertPerson("测试", 11, "南宁市");
    }

}
