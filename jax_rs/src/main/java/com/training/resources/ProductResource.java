package com.training.resources;

import java.util.List;
import java.util.Optional;

//import com.example.demo.services.ProductService;
import com.example.entity.Product;
import com.example.model.Student;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/products")
public class ProductResource {

	private static ProductService service = new ProductService();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> findAll(){
		
		return service.findAll();
	}
	
	@GET
	@Path("/srch/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("id") int id) {
		
		try {
		
		Product ent= service.findById(id).orElseThrow(()->new RuntimeException("Id not found"));
		return  Response.ok(ent).build();
		
	}catch(RuntimeException e) {
		
		e.printStackTrace();
		
		return Response.ok("Id not found").status(400,e.getMessage()).build();
	}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response add(Product entity) {
		
	int result= service.addProduct(entity);
	if(result>0) 
	{
		return Response.ok(entity).status(201).build();
	}else
	{
		return Response.status(400, "Not Created").build();
	}
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response remove(@PathParam("id") int id) {
		
		int result = service.deleteById(id);
		if(result>0) {
			return Response.ok("id delete aairuchu").build();
		}else {
			return Response.status(400, "not deleted").build();
		}
		
	}
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateById(@PathParam("id") int id , Product product)
	{
	int result= service.updateTable(product.getProductName(),id);
	if(result!=0) {
		return Response.ok(product).build();
	}else {
		return Response.status(400, "Not Updated").build();
	}
	
	}
	
	
	
	
	
}
