package ar.gob.ushuaia.recurso;

import ar.gob.ushuaia.servicio.ServiciosMovimientosTAD;
import ar.gob.ushuaia.transferible.ConsultaTADDTO;
import io.vertx.core.json.JsonObject;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.jboss.logging.Logger;

@ApplicationScoped
@Path("/movimientos")
public class RecursoMovimientos {

    /**
     * Auditor
     */
    private static final Logger auditor = Logger.getLogger(RecursoMovimientos.class);
    /**
     *
     */


    @Inject
    ServiciosMovimientosTAD serviciosMovimientosTAD;


//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    @Operation(summary = "Obtener movimientos de expediente")
//    @APIResponse(
//            responseCode = "200",
//            description = "Movimientos recuperados con exito.",
//            content = @Content(schema = @Schema(implementation = Object.class)) //nose q poner aca
//    )
//    @APIResponse(
//            responseCode = "2000004",
//            description = "Falta definirrrrrrrrrrrrrrrrrrrrr."
//    ) //falta definir tipo de errores segun servicio de logeo o argumentos fallidos
//    @POST
//    public Response obtenerMovimientos(@RequestBody ConsultaTADDTO tadDTO) {
//        System.out.println("soy validdd");
//        return serviciosMovimientosTAD.obtenerMovimientos(tadDTO);
//    }

    @GET
    public Object obtenerMovimientos() {
        System.out.println("soy validdd");
        return serviciosMovimientosTAD.obtenerMovimientos();
    }
}

//        -----------
//        excepciones
//        -----------
//        recurso
//
//        servicios               manejadorExcepciones(transorfma excepcion en un Response)
//
//        acceso
//
//        ------------
//        persistencia
//        ------------
//
//        Panache
//
//        Hibernate
//
//        JPA