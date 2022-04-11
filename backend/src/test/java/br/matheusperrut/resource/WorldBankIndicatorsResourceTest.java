package br.matheusperrut.resource;

import br.matheusperrut.service.client.WorldBankClient;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.ws.rs.WebApplicationException;
import java.util.*;

import static io.restassured.RestAssured.given;

@QuarkusTest
@TestHTTPEndpoint(WorldBankIndicatorsResource.class)
public class WorldBankIndicatorsResourceTest {

    @InjectMock
    @RestClient
    WorldBankClient worldBankClient;

    @Test
    public void shouldNotFoundInvalidResource() {
        given().when().get("/hello")
          .then().statusCode(404);
    }

    @Test
    public void shouldFailWhenServiceIsDown() {
        Mockito.when(worldBankClient.getPovertyHeadcountRatio(Mockito.anyString(), Mockito.isNull(), Mockito.isNull(), Mockito.anyString()))
                        .thenThrow(new WebApplicationException());

        given().when().get("/poverty/BRA").then().statusCode(500);
    }

    @Test
    public void shouldFailWhenInvalidCountryCodeIsProvided() {
        final String invalidCode = "INV";
        List<Object> errorList = new ArrayList<>();
        Map<Object, Object> errorMessage = new HashMap<>();
        Map<Object, Object> errorMessageDescription = new HashMap<>();
        errorMessageDescription.put("id", "123");
        errorMessageDescription.put("key", "Invalid value");
        errorMessageDescription.put("value","The provided parameter value is not valid");
        errorMessage.put("message", Arrays.asList(errorMessageDescription));
        errorList.add(errorMessage);

        Mockito.when(worldBankClient.getPovertyHeadcountRatio(Mockito.anyString(), Mockito.isNull(), Mockito.isNull(), Mockito.eq(invalidCode)))
                .thenReturn(errorList);

        given().when().get("/poverty/"+invalidCode).then().statusCode(400);
    }

    @Test
    public void shouldReturnResultsSuccessfullyWhenValidCountryCodeIsProvided() {
        final String validCode = "BRA";
        List<Object> resultList = new ArrayList<>();
        Map<Object, Object> pagination = new HashMap<>();
        pagination.put("page", 1);
        pagination.put("pages", 3);
        pagination.put("per_page", 25);
        pagination.put("total", 61);
        pagination.put("sourceid", "2");
        pagination.put("sourcename", "World Development Indicators");
        pagination.put("lastupdated", "2022-04-08");
        List<Object> resultData = new ArrayList<>();
        resultList.add(pagination);
        resultList.add(resultData);

        Mockito.when(worldBankClient.getPovertyHeadcountRatio(Mockito.anyString(), Mockito.isNull(), Mockito.isNull(), Mockito.eq(validCode)))
                .thenReturn(resultList);

        given().when().get("/poverty/"+validCode).then().statusCode(200);
    }
}