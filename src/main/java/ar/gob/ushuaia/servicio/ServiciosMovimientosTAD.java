package ar.gob.ushuaia.servicio;

import ar.gob.ushuaia.servicio.rest.GenusResource;
import ar.gob.ushuaia.transferible.ConsultaFinalTADDTO;
import ar.gob.ushuaia.transferible.ConsultaTADDTO;
import ar.gob.ushuaia.transformador.TransformadorTAD;
import io.vertx.core.json.JsonObject;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;


@ApplicationScoped
@Transactional
public class ServiciosMovimientosTAD {

    //por que no es solo un string? esta bien dejarlo escrito como cuando se usa dentro del metodo? o lo traemos desde app properties?.
//    @Resource(lookup = "java:global/url-webservice-genus")
//    private String urlWebServiceGenus;

//    @Inject
//    TransformadorTAD transformadorTAD;



    @Inject
    @RestClient
    GenusResource genusResource;


    private static final Logger auditor = Logger.getLogger(ServiciosMovimientosTAD.class);



//    public Response obtenerMovimientos(@Valid ConsultaTADDTO tadDTO) {
//        consultaFinalTADDTO.setAno(tadDTO.getAno());
//        consultaFinalTADDTO.setNumero(tadDTO.getNumero());
//        consultaFinalTADDTO.setTipo(tadDTO.getTipo());
//        consultaFinalTADDTO.setAccion("getMovimientos");
//        consultaFinalTADDTO.setAppId("L56pWB4pbn87v4");
//        System.out.println("aaaa");
//        Response response = genusResource.obtenerMovimientos(consultaFinalTADDTO);
////        Response response = genusResource.obtenerMovimientos(transformadorTAD.convertirAConsultaFinal(tadDTO));
//        System.out.println(response + "aaaa");
//        return response;
//    }

    public Response obtenerMovimientos() {
        ConsultaFinalTADDTO consultaFinalTADDTO = new ConsultaFinalTADDTO();
        consultaFinalTADDTO.setAno(2024);
        consultaFinalTADDTO.setNumero(1);
        consultaFinalTADDTO.setTipo("E");
        consultaFinalTADDTO.setAccion("getMovimientos");
        consultaFinalTADDTO.setAppId("L56pWB4pbn87v4");
        System.out.println("aaaa");
        try {

            Response response = genusResource.obtenerMovimientos(consultaFinalTADDTO);
//            Object jsonObject = response.getEntity();
            System.out.println(response + "aaaa");
            return response;
        } catch (Exception e) {
            System.out.println("Error " + e);
            return null;
        }

//        Response response = genusResource.obtenerMovimientos(transformadorTAD.convertirAConsultaFinal(tadDTO));

    }




}
