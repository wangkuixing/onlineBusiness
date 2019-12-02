import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * 我的持仓
 */
public class MyHoldTest {

    String custid="1300022253";

    @Test
    void test100909(){
        //我的持仓
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie())
                .formParam("funcNo", "100909")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("DataSet[0].stkcode", equalTo("000001"));
    }

    @Test
    void test100914(){
        //我的服务产品
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie())
                .formParam("funcNo", "100914")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"));
    }

    @Test
    void test100919(){
        //我的服务产品
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie())
                .formParam("funcNo", "100919")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"));
    }

    @Test
    void test100918(){
        //服务产品明细
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie())
                .formParam("funcNo", "100918")
                .formParam("qsrq", "20190726")
                .formParam("zzrq", "20190726")
                .formParam("zt", "1")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"));
    }

    @Test
    void test100929(){
        //服务产品明细
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie())
                .formParam("funcNo", "100929")
                .formParam("strdate", "20190726")
                .formParam("enddate", "20191026")
                .formParam("qryflag", "1")
                .formParam("printflag", "0")
                .formParam("count", "1000")
                .formParam("poststr", "")
                .formParam("curPage", "1")
                .formParam("numPerPage", "15")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"));
    }

    @Test
    void test100925(){
        //协议查询（三方存管）
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie())
                .formParam("funcNo", "100925")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("results[0].ext_org", equalTo("2003"));
    }

    @Test
    void test101110(){
        //查询客户电子合同签约情况
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie())
                .formParam("funcNo", "101110")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("error_info", equalTo("查询客户电子合同签约情况成功!"));
    }

    @Test
    void test160210(){
        //查询客户电子合同签约情况
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie())
                .formParam("funcNo", "160210")
                .formParam("custid", custid)
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("results[0].openDate", equalTo("20140924"));
    }
}
