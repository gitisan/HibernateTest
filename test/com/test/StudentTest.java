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

import com.hibernate.po.Student;

public class StudentTest {
	
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	@Before
	public void init() {
		// �������ö���
		Configuration config = new Configuration().configure();
		// ��������ע�����
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//�����ػ���������
		sessionFactory = config.buildSessionFactory(serviceRegistry);
		//�Ự����
		session = sessionFactory.openSession();
		//��������
		transaction = session.beginTransaction();
	}
	
	@After
	public void destory() {
		//�ύ����
		transaction.commit();
		//�رջỰ
		session.close();
		// �رջỰ����
		sessionFactory.close();
	}
	
	@Test
	public void testSaveStudent() {
		//����ѧ������
		Student student = new Student();
		student.setSid(1);
		student.setSname("����");
		student.setBirthday(new Date());
		student.setAddress("�Ϻ���");
		//�������������ݿ�
		session.save(student);
	}

}
