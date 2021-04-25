package br.tec.email.emailapp.rest.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

@ApplicationPath("/rest")
public class BaseApplication extends Application {

	public BaseApplication() {
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setTitle("emailapp API");
		beanConfig.setDescription("");
		beanConfig.setVersion("0.0.1");
		beanConfig.setHost("localhost:8080");
		beanConfig.setBasePath("/emailapp/rest");
		beanConfig.setSchemes(new String[] { "http" });
		beanConfig.setResourcePackage("br.tec.email.emailapp");
		beanConfig.setScan(true);
	}

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet<>();

		// classes do swagger...
		resources.add(ApiListingResource.class);
		resources.add(SwaggerSerializers.class);

		return super.getClasses();
	}
}
