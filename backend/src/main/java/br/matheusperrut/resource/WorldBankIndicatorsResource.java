package br.matheusperrut.resource;

import br.matheusperrut.domain.ErrorMessage;
import br.matheusperrut.domain.SearchResults;
import br.matheusperrut.service.WorldBankService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/indicators")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WorldBankIndicatorsResource {

    @Inject
    WorldBankService worldBankService;

    @GET
    @Path("poverty/{country}")
    @Operation(summary = "Gets poverty headcount ratio at $1.90 a day (% of population) of a given country.")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Success",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = SearchResults.class))),
            @APIResponse(responseCode = "400", description = "Invalid country code",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorMessage.class))),
            @APIResponse(responseCode = "500", description = "Internal server error")
    })
    public Response getPovertyHeadcountRatio(
            @PathParam("country") @Parameter(example = "BRA") String country,
            @QueryParam("page") @Parameter(example = "1") String page,
            @QueryParam("per_page") @Parameter(example = "20") String perPage
    ) {
        return worldBankService.getPovertyHeadcountRatio(page, perPage, country);
    }
}