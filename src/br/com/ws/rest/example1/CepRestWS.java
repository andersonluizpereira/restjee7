package br.com.ws.rest.example1;

import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

@Path("ceprest")
public class CepRestWS {

	
    @Context
    private UriInfo context;

    public CepRestWS() {
	}
    

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getCep/{cep}")
    public Cep getCep(@PathParam("cep") String cep) {
    	Cep toReturn = new Cep();
    	toReturn.setCep(cep);
    	toReturn.setBairro("Bairro "+new Random().nextInt());
    	toReturn.setNumero(new Random().nextInt());
    	toReturn.setRua("Rua que sempre "+new Random().nextInt());
    	toReturn.setUf("PR");
    	return toReturn;
    }

    @GET
  //  @Produces(MediaType.TEXT_XML)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getCeps/{cep}")
    public Webservicecep getCeps(@PathParam("cep") String cep) throws JAXBException, MalformedURLException {
		  JAXBContext jc = JAXBContext.newInstance(Webservicecep.class);
			
	       Unmarshaller u = jc.createUnmarshaller();
	       URL url = new URL( "http://cep.republicavirtual.com.br/web_cep.php?cep="+cep+"&formato=xml" );
	       Webservicecep wCep = (Webservicecep) u.unmarshal( url );
	       
	       return wCep;
    }
	
}
