package com.example;

	import jakarta.ws.rs.GET;
	import jakarta.ws.rs.Path;
	import jakarta.ws.rs.Produces;
	import jakarta.ws.rs.core.MediaType;

	@Path("myresource")
	public class Resource {


	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage() {

	return "Hi Venki";
	}
	}

