package br.matheusperrut.service;

import br.matheusperrut.domain.*;
import br.matheusperrut.service.client.WorldBankClient;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpStatus;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.core.Response;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Singleton
public class WorldBankService {

    private static final String format = "json";

    @Inject
    @RestClient
    WorldBankClient worldBankClient;

    public Response getPovertyHeadcountRatio(String page, String perPage, String country) {
        List<Object> resultList = worldBankClient.getPovertyHeadcountRatio(format, page, perPage, country);
        Map jsonResult = (Map) resultList.get(0);
        Gson gson = new Gson();
        String paginationKeyIdentifier = "page";
        String errorMessageKeyIdentifier = "message";

        // Esta lógica é necessária apenas para garantir que o objeto das respostas do servidor
        // bate com os objetos da documentação do Swagger
        if (Objects.nonNull(jsonResult.get(paginationKeyIdentifier))) {
            Pagination pagination = gson.fromJson(gson.toJson(jsonResult), Pagination.class);
            List jsonPovertyIndicatorList = (List) resultList.get(1);

            Type listType = new TypeToken<ArrayList<PovertyIndicator>>(){}.getType();
            List<PovertyIndicator> povertyIndicatorList = gson.fromJson(gson.toJson(jsonPovertyIndicatorList), listType);

            return Response.ok(new SearchResults(pagination, povertyIndicatorList)).build();
        } else if (Objects.nonNull(jsonResult.get(errorMessageKeyIdentifier))) {
            ErrorMessage errorMessage = gson.fromJson(gson.toJson(jsonResult), ErrorMessage.class);

            return Response.status(HttpStatus.SC_BAD_REQUEST).entity(errorMessage).build();
        }

        return Response.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).build();
    }
}
