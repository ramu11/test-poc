package ch.medidata.demo.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/demoservice")
public interface RestServiceApi {

   @GET
   @Produces(MediaType.APPLICATION_JSON)
   Response get();

}
