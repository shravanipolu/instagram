package com.instacontrollers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.instapojos.InstaPojo;
import com.instavaidation.InstaValidater;
import com.iregisterDao.IRegisterDao;

import RegisterDao.RegisterDaoImpl;

@Controller
public class RegisterCustomerController {

	//@Autowired
	//IRegisterDao dao;
	@RequestMapping(value = "/registerCustomer")
	public String register(InstaPojo pojo, Model model) {
		System.out.println("register Controller triggered");
		System.out.println("register user name is" +pojo.getName());

		InstaValidater validater = new InstaValidater();
		boolean mail = validater.isValidMail(pojo.getMail());
		if (!mail) {
			System.out.println("please enter valid email");
			model.addAttribute("invalidmail", "please enter valid mail");
			return "Register";
		}

		boolean isvalidmobile = validater.isValid(pojo.getMob());

		if (!isvalidmobile) {
			System.out.println("please enter valid mobile");
			model.addAttribute("invalidmail", "please enter valid mobile");
			return "Register";
		}
		System.out.println("registration success");
	
		RegisterDaoImpl dao= new RegisterDaoImpl();
		dao.register(pojo);
		/*SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		 
		session.save(pojo);
		session.beginTransaction().commit();
		session.close();
		*/
		return "login";
	}
}
