package com.Chintan.SpringBoot;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static HashMap<Long,Student> studentmap=null; 
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		studentmap=new HashMap<>();
		Student s1= new Student(12,"Chintan");
		Student s2= new Student(13,"Pandya");
		studentmap.put(new Long(s1.getId()),s1);
		studentmap.put(new Long(s2.getId()),s2);
		
	}
}
