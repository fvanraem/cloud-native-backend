package me.snowdrop.cloudnative.backend;

import java.net.URL;

import com.jayway.restassured.RestAssured;
import org.arquillian.cube.openshift.impl.enricher.AwaitRoute;
import org.arquillian.cube.openshift.impl.enricher.RouteURL;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class OpenShiftIT extends AbstractBoosterApplicationTest {

    @AwaitRoute(path = "/health")
    @RouteURL("${app.name}")
    private URL baseURL;

    @Before
    public void setup() throws Exception {
        RestAssured.baseURI = baseURL + "api/greeting";
    }

}
