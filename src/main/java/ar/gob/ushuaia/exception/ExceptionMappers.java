package ar.gob.ushuaia.exception;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

public class ExceptionMappers {

    @Inject
    Logger auditor;

    @ServerExceptionMapper
    public Response mapHttpBadRequestException(HttpBadResquestException x) {
        return Response.status(Response.Status.BAD_REQUEST).header("Warning", x.getMessage()).build();
    }

    @ServerExceptionMapper
    public Response mapHttpConflictException(HttpConflictException x) {
        return Response.status(Response.Status.CONFLICT).header("Warning", x.getMessage()).build();
    }

    @ServerExceptionMapper
    public Response mapHttpNoContentException(HttpNoContentException x) {
        auditor.debug("mapHttpNoContentException");
        return Response.noContent().build();
    }

    @ServerExceptionMapper
    public Response mapHttpNotFoundException(HttpNotFoundException x) {
        auditor.debug("mapHttpNotFoundException: " + x.getMessage());
        return Response.status(Response.Status.NOT_FOUND).header("Warning",x.getMessage()).build();
    }



}
