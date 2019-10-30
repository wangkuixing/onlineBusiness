import io.restassured.builder.ResponseBuilder;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.*;

import static io.restassured.RestAssured.given;

public class UserAuthenticationTest {

    String custid="1300022253";
    String fundid="1300022253";
    @Test
    void test100970(){

        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .queryParam("login_test", 1)
                .queryParam("funcNo", "100970")
                .queryParam("custid", custid)
                .queryParam("fundid", fundid)
                .when()
                .get("http://t0st.ytzq.com:8443/web/bus/json")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("results.isYZ[0]",equalTo("true"));
    }
}
