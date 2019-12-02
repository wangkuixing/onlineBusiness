import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * 业务办理建议
 */
public class BuProposalTest {
    String creditAccount = "1290000019";
    String branch_no="0012";
    String custid = "1100003755";
    String identity_idno="440921196001151215";

    @Test
    void test160101() {
        //建议办理业务-查询各种信息
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie", GetCookie.getCookie4())
                .queryParam("funcNo", "160101")
                .queryParam("trade_no", custid)
                .queryParam("branch_no", branch_no)
                .queryParam("net_addr", "text%252Fhtml%253B%2520charset%253DUTF-8")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("results[0].isEighteenBit", equalTo("true"));
    }

    @Test
    void test160102() {
        //建议办理业务-查询风险测评
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie", GetCookie.getCookie4())
                .queryParam("funcNo", "160102")
                .queryParam("kind", "0")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("results[0].isOneOutTime", equalTo("false"));
    }

    @Test
    void test110001() {
        //建议办理业务-查询客户是否做过电子签名约定书
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie", GetCookie.getCookie4())
                .queryParam("funcNo", "110001")
                .queryParam("trade_no", custid)
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"));
    }

    @Test
    void test160109() {
        //建议办理业务-查询证券账户
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie", GetCookie.getCookie4())
                .queryParam("funcNo", "160109")
                .queryParam("trade_no", custid)
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("results[0].isha", equalTo("1"));
    }

    @Test
    void test160103() {
        //建议办理业务-中登业务
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie", GetCookie.getCookie4())
                .queryParam("funcNo", "160103")
                .queryParam("trade_no", custid)
                .queryParam("identity_idno", identity_idno)
                .queryParam("user_name", "%E7%BD%97%E6%BA%90%E5%BE%B7")
                .queryParam("branch_no", branch_no)
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("results[0].relation_status", equalTo("0"));
    }

    @Test
    void test160107() {
        //建议办理业务-创业板权限
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie", GetCookie.getCookie4())
                .queryParam("funcNo", "160107")
                .queryParam("trade_no", custid)
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("results[0].isTs", equalTo("1"));
    }

    @Test
    void test160108() {
        //建议办理业务-港股通权限
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie", GetCookie.getCookie4())
                .queryParam("funcNo", "160108")
                .queryParam("trade_no", custid)
                .queryParam("trade_account", custid)
                .queryParam("branch_no", branch_no)
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("results[0].ishqx", equalTo("1"));
    }

    @Test
    void test160104() {
        //建议办理业务-两融权限
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie", GetCookie.getCookie4())
                .queryParam("funcNo", "160104")
                .queryParam("trade_no", custid)
                .queryParam("rzrq_creditAccount", creditAccount)
                .queryParam("branch_no", branch_no)
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("results[0].isLr", equalTo("1"));
    }

    @Test
    void test160105() {
        //建议办理业务-两融权限
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie", GetCookie.getCookie4())
                .queryParam("funcNo", "160105")
                .queryParam("trade_no", custid)
                .queryParam("rzrq_creditAccount", creditAccount)
                .queryParam("branch_no", branch_no)
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("results[0].isHaving", equalTo("1"));
    }

    @Test
    void test160106() {
        //建议办理业务-期权
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie", GetCookie.getCookie4())
                .queryParam("funcNo", "160106")
                .queryParam("trade_no", custid)
                .queryParam("rzrq_creditAccount", creditAccount)
                .queryParam("branch_no", branch_no)
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"));
    }
}
