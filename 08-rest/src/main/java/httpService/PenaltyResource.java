package httpService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.xml.bind.JAXBElement;

@Path("/penalty")
public class PenaltyResource {
	
	private static Map<Integer, DamageDetail> details = new HashMap<Integer, DamageDetail>();
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/{detailId}")
	public Response putDetail(@PathParam("detailId") String detailId, JAXBElement<DamageDetail> detail) {
		Integer id;
		try {
			id = Integer.parseInt(detailId);
		} catch (NumberFormatException ex) {
			return Response.status(Response.Status.NOT_ACCEPTABLE).entity("Not valid ID").build();
		}
		details.put(id, detail.getValue());
		return Response.status(Response.Status.ACCEPTED).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<DamageDetail> getDetails() {
		List<DamageDetail> detailsContacts = new ArrayList<DamageDetail>();
		detailsContacts.addAll( details.values() );
	    return detailsContacts;
	}
	
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<DamageDetail> getFiltred(JAXBElement<DamageDetail> detailModelElem) {
		List<DamageDetail> detailsContacts = new ArrayList<DamageDetail>();
		detailsContacts.addAll( details.values() );
		var detailModel = detailModelElem.getValue();
		if (detailModel.getDesc() != null) {
			detailsContacts = detailsContacts.stream().filter(it -> it.getDesc().contains(detailModel.getDesc())).toList();
		}
		if (detailModel.getType() != null) {
			detailsContacts = detailsContacts.stream().filter(it -> it.getType() == detailModel.getType()).toList();
		}
		if (detailModel.getDate() != null) {
			detailsContacts = detailsContacts.stream().filter(it -> it.getDate().equals(detailModel.getDate())).toList();
		}
	    return detailsContacts;
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/{detailId}")
	public Response deleteDetail(@PathParam("detailId") String detailId) {
		Integer id;
		try {
			id = Integer.parseInt(detailId);
		} catch (NumberFormatException ex) {
			return Response.status(Response.Status.NOT_ACCEPTABLE).entity("Not valid ID").build();
		}
		details.remove(id);
		return Response.status(Response.Status.ACCEPTED).build();
	}
}
