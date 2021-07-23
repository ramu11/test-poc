package ch.medidata.demo.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * The only purpose of this rest resource is to trigger cxf rest client to call a demo rest service
 */

@Path("/democlient")
public interface DemoRestApi {

   @GET
   @Produces(MediaType.APPLICATION_JSON)
   String get();

}
