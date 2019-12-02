import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.*;
import static io.restassured.RestAssured.given;

/**
 * 机主身份验证
 */
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
                .get("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("results.isYZ[0]",equalTo("true"));
    }
}
