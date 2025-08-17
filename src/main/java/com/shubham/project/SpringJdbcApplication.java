package com.shubham.project;

import com.shubham.project.model.Student;
import com.shubham.project.repo.StudentRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);
		Student s = context.getBean(Student.class);
		s.setId(7);
		s.setAge(23);
		s.setName("palak");

		StudentRepo sRepo = context.getBean(StudentRepo.class);

		sRepo.save(s);
		System.out.println(sRepo.findAll());

	}


}
