package com.example.demojpa2.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demojpa2.entity.DeptEntity;
import com.example.demojpa2.entity.EmployeeEntity;
import com.example.demojpa2.models.EmployeeModel;
import com.example.demojpa2.repo.DeptRepo;
import com.example.demojpa2.repo.EmployeeRepo;

@RestController
@RequestMapping("/employee")
public class HomeContoller {

	@Autowired
	EmployeeRepo repo;
	
	@Autowired
	DeptRepo deptRepo;
	
	//use the GET All the data 
	@GetMapping("/")
	public List<EmployeeEntity> showEmpoyee()
	{
		//return all the value from the tables
		return repo.findAll();
		
	}
	@GetMapping("/demo")
	public ResponseEntity<EmployeeModel> helloHttps()
	{
		//Integer res=10;
		/*List<String> ls=new ArrayList<String>();
		ls.add("Ravinder");
		ls.add("kumar");
		ls.add("priya");
		*/
		EmployeeModel emp=new EmployeeModel(1001, "Ravinder", "Trainer"); 
		
		return new ResponseEntity<EmployeeModel>(emp,HttpStatus.OK);
	}
	
	//POST request
	   //each time it will create a new data request
	   //will send the data with body
	@PostMapping("/")
	public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity  emp)
	{
		System.out.println("dept  "+emp.getDept());
		
		DeptEntity entity=deptRepo.findById(emp.getDept().getId()).get();
		
		System.err.println("dept id"+entity);
		
		emp.setDept(entity);
		System.err.println(emp);
		repo.save(emp);
		System.err.println(emp);
		return emp;
	}
	
	//it is use to update the resource on the server
	
	@PutMapping("/")
	public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity  emp)
	{
	
		
		repo.save(emp);
		System.err.println(emp);
		return emp;
	}
	
	
	//delete : it is used to delete the resource on the server
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable("id") int id)
	{
		System.err.println("deleted id is : "+id);
		repo.deleteById(id);
		return "Record Has been deleted !";
	}
	
	
	
}
