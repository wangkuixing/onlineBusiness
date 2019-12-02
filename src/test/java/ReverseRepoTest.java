import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * 债券逆回购
 */
public class ReverseRepoTest {

    String custid="1300022253";
    String fundid="1300022253";
    @Test
    void test160201(){

        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .queryParam("login_test", 1)
                .queryParam("funcNo", "160201")
                .queryParam("trade_no", custid)
                .queryParam("trade_account", fundid)
                .queryParam("branch_no", "0013")
                .when()
                .get("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("results.isYZ[0]",equalTo("true"));
    }

}
