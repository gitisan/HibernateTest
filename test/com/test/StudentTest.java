package com.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hibernate.po.Grade;
import com.hibernate.po.Student;

public class StudentTest {
	
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	@Before
	public void init() {
		// 创建配置对象
		Configuration config = new Configuration().configure();
		// 创建服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//创建回话工厂对象
		sessionFactory = config.buildSessionFactory(serviceRegistry);
		//会话对象
		session = sessionFactory.openSession();
		//开启事务
		transaction = session.beginTransaction();
	}
	
	@After
	public void destory() {
		//提交事务
		transaction.commit();
		//关闭会话
		session.close();
		// 关闭会话工厂
		sessionFactory.close();
	}
	
	@Test
	public void testSaveStudent() {
		//生成学生对象
		Student student = new Student();
		student.setSid(2);
		student.setSname("张三1");
		student.setBirthday(new Date());
		student.setAddress("上海道");
		//保存对象进入数据库
		session.save(student);
	}
	
	@Test
	public void testSaveGrade() {
		Grade grade = new Grade("高三一班1");
		Student s = new Student("张三23", new Date(), "wwww");
		grade.getStudent().add(s);
		s.setGrade(grade);
		session.save(grade);
		session.save(s);
	}
	
	@Test
	public void testfindGrade() {
		//生成学生对象
		Grade g =(Grade)session.get(Grade.class, 4);
		System.out.println(g);
	}

}
