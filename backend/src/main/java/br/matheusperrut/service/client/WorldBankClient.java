package br.matheusperrut.service.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RegisterRestClient(configKey="worldbank-api")
public interface WorldBankClient {

    @GET
    @Path("{countryCode}/indicator/SI.POV.DDAY")
    @Produces(MediaType.APPLICATION_JSON)
    List<Object> getPovertyHeadcountRatio(
            @QueryParam("format") String format,
            @QueryParam("page") String page,
            @QueryParam("per_page") String perPage,
            @PathParam("countryCode") String countryCode);
}
