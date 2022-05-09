package com.example.resources;

import java.util.List;

import org.glassfish.grizzly.http.util.HttpStatus;

import com.example.model.Student;
import com.example.services.StudentService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/student")
public class StudentResource {

	private static StudentService service= new StudentService();
	
	public StudentResource() {
		super();
		//this.service=new StudentService();
	}

//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public Student getMessage() {
//		
//		Student student = new Student(1001, "Venki", 100);
//		return student;
//		
//	}
//	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAllStudent() {
		return service.getAll();
	}
	@GET
	@Path("/{rollNumber}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("rollNumber") int id) {
		try {
			
			Student entity= service.findById(id).orElseThrow(()->new RuntimeException("ID not found"));
			return Response.ok(entity).build();	
		}catch (RuntimeException e) {
			e.printStackTrace();
			return Response.ok("ID not found").status(400,e.getMessage()).build();
		}
		
	}
	
	@DELETE
	@Path("/{rollNumber}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response remove(@PathParam("rollNumber") int id) {
		
		boolean result = service.remove(id);
		if(result) {
			return Response.ok(id).status(204).build();
		}else {
			return Response.status(400, "not deleted").build();
		}
		
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response add(Student student) {
		
	boolean result= service.add(student);
	if(result) 
	{
		return Response.ok(student).status(201).build();
	}else
	{
		return Response.status(400, "Not Created").build();
	}
	}
	
	@PUT
	@Path("/{rollNumber}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student updateById(@PathParam("rollNumber") int id , Student newStudent)
	{
	return service.update(id,newStudent);
	}

	

	
}
