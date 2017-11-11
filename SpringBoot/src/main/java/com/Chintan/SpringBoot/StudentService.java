package com.Chintan.SpringBoot;

import java.util.HashMap;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/student")
public class StudentService {
	
	@RequestMapping(value="/getStudents",method=RequestMethod.GET)
	public HashMap<Long,Student> getAllStudents(){
		return Application.studentmap;
	}
	
	@RequestMapping(value="/getStudent/{id}",method=RequestMethod.GET)
	public Student getStudent(@PathVariable long id) throws Exception{
		if(Application.studentmap.containsKey(new Long(id))) {
			return Application.studentmap.get(id);
			
		}
		
		else {
			throw new Exception("Student "+id+" does not exist");
		}
		
		
	}
	
	@RequestMapping(value="/addStudent",method=RequestMethod.POST)
	public Student addStudent(@RequestParam(value="id",required=true)long id, 
			@RequestParam(value="name",defaultValue="demoUser") String name) {
		Student student2Add= new Student(id,name);
		Application.studentmap.put(new Long(student2Add.getId()), student2Add);
		return student2Add;
	}
	
	@RequestMapping(value="/updateStudent",method=RequestMethod.PUT)
	public Student updateStudent(@RequestBody Student updatedStudent) throws Exception {
		if(Application.studentmap.containsKey(new Long(updatedStudent.getId())))
		{
			Application.studentmap.put(new Long(updatedStudent.getId()), updatedStudent);
			
		}
		
		else {
			throw new Exception("Student "+updatedStudent.getId()+" does not exist");
		}
		return updatedStudent;
	}
	
	@RequestMapping(value="/deleteStudent/{id}",method=RequestMethod.DELETE)
	public String deletStudent(@PathVariable long id) throws Exception {
		if(Application.studentmap.containsKey(new Long(id))) {
			Application.studentmap.remove(new Long(id));
			
		}
		
		else {
			throw new Exception("Student "+id+" does not exist");
		}
		
		return "Student "+id+" deleted";
	}
}

