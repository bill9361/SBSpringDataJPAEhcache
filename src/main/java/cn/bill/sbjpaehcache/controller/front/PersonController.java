package cn.bill.sbjpaehcache.controller.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.bill.sbjpaehcache.entity.Person;
import cn.bill.sbjpaehcache.service.PersonService;
import cn.bill.sbjpaehcache.util.TimeUtil;

/**
 * Description: <br/>
 * Date:2018年8月7日 上午11:57:09 <br/>
 *
 * @author fengminbiao@126.com
 * @version
 */
@RequestMapping("/person")
@Controller
public class PersonController
{
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/person.do")
	public String intoPersonPage()
	{
		return "front/person";
	}
	
	@RequestMapping("/findByNameLike.do")
	public String findByNameLike(String name,Model model)
	{
		System.out.println("PersonController...findByNameLike():name:"+name);
		List<Person> personList = personService.findByNameLike(name);
		model.addAttribute("personList", personList);
		return "front/person";
	}
	
	@RequestMapping("/findByNameAndAge.do")
	public String findByNameAndAge(String name,Integer age, Model model)
	{
		System.out.println("PersonController...findByNameAndAge():name:"+name);
		List<Person> personList = personService.findByNameAndAge(name, age);
		model.addAttribute("personList", personList);
		return "front/person";
	}


	@RequestMapping("/addOrUpdate.do")
	public String addOrUpdate(Model model) throws Exception
	{
		System.out.println("PersonController...save():name");
		Person p = new Person();
		//p.setId(UUID.randomUUID().toString());
		p.setId("01b01f75-a39b-45fd-8d91-fed3b3a37108");
		p.setName("张三丰WWWQQ");
		p.setPhoneNo("123456789");
		p.setAge(25);
		//p.setCreateTime(TimeUtil.getCurrentTime());
		p.setUpdateTime(TimeUtil.getCurrentTime());
		//保存或更新
		personService.addOrUpdate(p);
		model.addAttribute("person", p);
		return "front/person";
	}
}
