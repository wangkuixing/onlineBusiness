import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * 合约展期
 */
public class ContractRenewalTest {
    String creditAccount = "1290000019";
    String custid = "1100003755";
    static String error_no = "";
    static String dbbl = "";

    @Test
    void test106003() {
        //判断是否为两融客户
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie", GetCookie.getCookie4())
                .queryParam("funcNo", "106003")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("results[0].flag", equalTo("true"));
    }

    @Test
    void test106030() {
        //查询客户最近一次签署两融相关协议
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie", GetCookie.getCookie4())
                .queryParam("funcNo", "106030")
                .queryParam("rating_lvl", "3")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("results[0].is_warn", equalTo("0"));
    }

    @Test
    void test106031() {
        //记录客户签署的两融相关协议
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie", GetCookie.getCookie4())
                .queryParam("funcNo", "106031")
                .queryParam("rating_lvl", "3")
                .queryParam("rating_name", "%E7%A8%B3%E5%81%A5%E5%9E%8B")
                .queryParam("is_warn", "1")
                .queryParam("is_conf", "")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"));
    }

    @Test
    void test106011() {
        //客户合约查询
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie", GetCookie.getCookie4())
                .queryParam("funcNo", "106011")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("results[0].sno", equalTo("11"));
    }

    @Test
    void test106015() {
        //客户合约查询
        Response response = given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie", GetCookie.getCookie4())
                .queryParam("funcNo", "106015")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200)
                .extract().response();

        error_no = response.jsonPath().get("error_no");
    }

    @Test
    void test106016() {
        //查询客户信用账户是否满足最低维保比例,条件:dbbl_user>dbbl_conf
        Response response=given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie", GetCookie.getCookie4())
                .queryParam("funcNo", "106016")
                .queryParam("moneytype", "0")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("results[0].dbbl", equalTo("1"))
                .extract().response();

        dbbl = response.jsonPath().get("results[0].dbbl");
    }

    @Test
    void test106050() {
        test106015();
        test106016();
        if (error_no.equals("0") && dbbl.equals("1")) {
            given()
                    .log().all()
                    .filter(SignAgreementTest.myFilter)
                    .header("Cookie", GetCookie.getCookie4())
                    .queryParam("funcNo", "106050")
                    .queryParam("jsondata", "5")
                    .queryParam("findavl", "6666")
                    .when()
                    .post("url")
                    .then().log().all()
                    .statusCode(200).body("error_no", equalTo("0"))
                    .body("results[0]", equalTo("true"));
        } else {
            System.out.println("无可展期的合约或客户不满足最低维保比例");
        }
    }
}
