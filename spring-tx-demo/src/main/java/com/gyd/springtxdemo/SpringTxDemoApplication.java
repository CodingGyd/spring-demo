package com.gyd.springtxdemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringTxDemoApplication {

	public static void main(String[] args) {
		//加载配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-annotation.xml");
		//获取userDao实例
		UserDao userDao = (UserDao)applicationContext.getBean("userDao");

		User user = new User();
		user.setAge(20);
		user.setName("test");
		user.setId(3);
		userDao.insert(user);
		System.out.println("插入数据成功！"+user);

		List<User> userList = userDao.findAll(3);
		System.out.println("查询数据成功！"+userList);

	}

}
