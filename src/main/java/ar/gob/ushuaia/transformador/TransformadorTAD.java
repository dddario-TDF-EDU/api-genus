package ar.gob.ushuaia.transformador;

import ar.gob.ushuaia.transferible.ConsultaFinalTADDTO;
import ar.gob.ushuaia.transferible.ConsultaTADDTO;
import jakarta.enterprise.context.ApplicationScoped;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper()
public interface TransformadorTAD {

    @Mapping(target = "appId", constant = "L56pWB4pbn87v4")
    @Mapping(target = "accion", constant = "getMovimientos")
    ConsultaFinalTADDTO convertirAConsultaFinal(ConsultaTADDTO consultaTADDTO);
}
