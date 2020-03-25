package br.com.ws.rest.example1;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("restws")
public class MyFirstRESTWebService {
    @SuppressWarnings("unused")
    @Context
    private UriInfo context;

    /**
     * Default constructor. 
     */
    public MyFirstRESTWebService() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Retrieves representation of an instance of MyFirstRESTWebService
     * @return an instance of String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getXml() {
        // TODO return proper representation object
        return "meuPrimeiroTestRest";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("sayOla/{nome}")
    public String sayOla(@PathParam(value="nome")String nome) {
        // TODO return proper representation object
        return "Olá "+nome;
    }

    /**
     * PUT method for updating or creating an instance of MyFirstRESTWebService
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }

}