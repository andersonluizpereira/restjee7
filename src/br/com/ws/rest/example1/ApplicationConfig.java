package br.com.ws.rest.example1;

import java.util.Set;

import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath ("webservice")
public class ApplicationConfig extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new java.util.HashSet<>();
		addRestResourceClasses(resources);
		return resources;
	}

	private void addRestResourceClasses(Set<Class<?>> resources) {
		// TODO Auto-generated method stub
		resources.add(MyFirstRESTWebService.class);
		resources.add(CepRestWS.class);
	}
}
