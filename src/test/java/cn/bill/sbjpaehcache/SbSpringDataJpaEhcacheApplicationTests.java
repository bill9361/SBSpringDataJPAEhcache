package cn.bill.sbjpaehcache;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import cn.bill.sbjpaehcache.entity.Person;
import cn.bill.sbjpaehcache.service.PersonService;
import cn.bill.sbjpaehcache.util.TimeUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SbSpringDataJpaEhcacheApplicationTests {

	@Autowired
	private PersonService personService;

	@Test
	public void contextLoads() {
	}
	
	/**
	 * 新增或更新人员信息
	 * @throws Exception 
	 */
	@Test
	public void addOrupdateTest() throws Exception
	{
		Person p = new Person();
		//p.setId(UUID.randomUUID().toString());
		p.setId("01b01f75-a39b-45fd-8d91-fed3b3a37108");
		p.setName("张三丰CC");
		p.setPhoneNo("123456789");
		p.setAge(25);
		//p.setCreateTime(TimeUtil.getCurrentTime());
		p.setUpdateTime(TimeUtil.getCurrentTime());
		//保存或更新
		personService.addOrUpdate(p);
		System.out.println("添加或更新成功");
	}
	
	/**
	 * 新增或更新人员信息
	 * @throws Exception 
	 */
	@Test
	public void addOrupdateAllTest() throws Exception
	{
		List<Person> pList = new ArrayList<>();
		for (int i = 0; i < 3; i++)
		{
			Person p = new Person();
			p.setId(UUID.randomUUID().toString());
			//p.setId("c0d61f21-963d-498e-8720-390c6bdbfaa5");
			p.setName("陈"+i);
			p.setPhoneNo("123456789");
			p.setAge(20);
			p.setCreateTime(TimeUtil.getCurrentTime());
			pList.add(p);
		}
		//保存或更新
		personService.addOrUpdateAll(pList);
		System.out.println("添加或更新成功");
	}
	/**
	 * 根据Id删除
	 * @throws Exception
	 */
	@Test
	public void deleteTest() throws Exception
	{
		personService.deleteById("c0d61f21-963d-498e-8720-390c6bdbfaa5");
		System.out.println("删除成功");
	}
	
	/**
	 * 根据name模糊查询人员信息
	 * @throws Exception
	 */
	@Test
	public void findByName() throws Exception
	{
		List<Person> personList = personService.findByNameLike("%张%");
		System.out.println(personList);
	}

	/**
	 * 根据name模糊查询人员信息
	 * @throws Exception
	 */
	@Test
	public void queryByName() throws Exception
	{
		List<Person> personList = personService.findByNameAndAge("%张%",20);
		System.out.println(personList);
	}
	
	/**
	 * 根据name模糊查询人员信息+分页
	 * @throws Exception
	 */
	@Test
	public void queryByNameLike() throws Exception
	{
		//第1页，取3条
		//Pageable pageable = PageRequest.of(0, 3);
		//第4页，取3条
		Pageable pageable = PageRequest.of(3, 3);
		Page<Person> personPage = personService.findByNameLike("%张%", pageable);
		for (Person person : personPage.getContent())
		{
			System.out.println(person);
		}
	}

}
