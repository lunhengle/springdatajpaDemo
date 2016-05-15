import com.lhl.springjpa.bean.Person;
import com.lhl.springjpa.service.iface.PersonServiceIface;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by lunhengle on 2015/8/16.
 */
public class TestPersonService {
    private ApplicationContext applicationContext;
    private PersonServiceIface personServiceIface;

    @Before
    public void before() {
        String[] configLocation = new String[]{"applicationContext.xml"};
        applicationContext = new ClassPathXmlApplicationContext(configLocation);
        personServiceIface = (PersonServiceIface) applicationContext.getBean("personServiceIface");
    }

    @Test
    public void testAdd() {
        Person person = new Person();
        person.setName("lhl");
        person.setAge(44);
        this.getPersonServiceIface().add(person);
    }

    @Test
    public void testUpdate() {
        Person person = new Person();
        person.setId(1);
        person.setName("伦恒乐");
        this.getPersonServiceIface().update(person);
    }

    @Test
    public void testfindOne() {
        Person person = this.getPersonServiceIface().findOne(1);
        System.out.println("name :" + person.getName() + " age:" + person.getAge());
    }

    @Test
    public void testDeletePerson() {
        Person person = new Person();
        person.setId(15);
        this.getPersonServiceIface().delete(person);
    }

    @Test
    public void testAddOrUpdatePerson() {
        Person person = new Person();
        //person.setId(5);
        person.setName("论语");
        person.setAge(88);
        this.getPersonServiceIface().addOrUpdate(person);
    }

    @Test
    public void testFindAll() {
        List<Person> list = this.getPersonServiceIface().findAll();
        for (Person person : list) {
            System.out.println(" name: " + person.getName() + " age:" + person.getAge());
        }
    }

    @Test
    public void tranAddOrUpdate() {
        Person person = new Person();
        person.setName("测试事务66");
        person.setAge(8888);
        this.getPersonServiceIface().tranAddOrUpdate(person);
    }

    public PersonServiceIface getPersonServiceIface() {
        return personServiceIface;
    }

    public void setPersonServiceIface(PersonServiceIface personServiceIface) {
        this.personServiceIface = personServiceIface;
    }
}
