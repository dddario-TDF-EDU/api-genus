package ar.gob.ushuaia.servicio;

import ar.gob.ushuaia.transferible.ConsultaTADDTO;
import io.vertx.core.json.JsonObject;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;


@RequestScoped // @ApplicationScoped
@Transactional
public class ServiciosMovimientosTAD {

    //por que no es solo un string? esta bien dejarlo escrito como cuando se usa dentro del metodo? o lo traemos desde app properties?.
    @Resource(lookup = "java:global/url-webservice-genus")
    private String urlWebServiceGenus;


    private static final Logger auditor = Logger.getLogger(ServiciosMovimientosTAD.class);


    public Response obtenerMovimientos(@Valid ConsultaTADDTO tadDTO) throws URISyntaxException, IOException, InterruptedException {

        auditor.debug("obtenerMovimientos - expediente: {} - {} - {}" + tadDTO.getTipo() + tadDTO.getNumero() + tadDTO.getAno());
        try {
            //basarse en la api de libros q consume numbers
            HttpClient client = HttpClient.newHttpClient();
            String URL = "https://expedientes.ushuaia.gob.ar/vub/webService";


            JsonObject jsonBody = new JsonObject();
            jsonBody.put("appId", "L56pWB4pbn87v4");
            jsonBody.put("accion", "getMovimientos");
            jsonBody.put("tipoPA", tadDTO.getTipo());
            jsonBody.put("numeroPA", tadDTO.getNumero());
            jsonBody.put("anioPA", tadDTO.getAno());

            auditor.debug("body del post: " + jsonBody);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody.toString(), StandardCharsets.UTF_8))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Respuesta del POST: " + response.body());

            return Response.status(response.statusCode())
                    .entity(response.body())
                    .build();
        }
        catch(Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al procesar la solicitud")
                    .build();

        }
    }

//    @Path("https://expedientes.ushuaia.gob.ar/vub/webService")
//    @POST
//    private Response response() {
//        return null;
//    }

//    @Path("https://expedientes.ushuaia.gob.ar/vub/webService")
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response obtenerMovimientos(String tipo, Integer numero, Integer ano) {
//        String appId = ;
//        String accion = "getMovimientos";
//        String urlWeb = "https://expedientes.ushuaia.gob.ar/vub/webService";
//
//
//
//        return null;
//    }


}
