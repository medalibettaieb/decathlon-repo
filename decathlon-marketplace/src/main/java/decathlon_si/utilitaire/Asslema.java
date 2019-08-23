package decathlon_si.utilitaire;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/asslema")
public class Asslema {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String hello(){
		return "Asslema daly";
	}
}
