package ar.gob.ushuaia.servicio.rest;

import ar.gob.ushuaia.transferible.ConsultaFinalTADDTO;
import ar.gob.ushuaia.transferible.ConsultaTADDTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@ApplicationPath("webService")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RegisterRestClient
public interface GenusResource {

    @POST
    Response obtenerMovimientos(@RequestBody ConsultaFinalTADDTO consultaFinalTADDTO);


}
