import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * 权限办理-科创板权限开通
 */
public class STARMarketTest {

    String custid="1100001235";
    String secuid="A122338917";
    @Test
    void test160506(){
        //科创板权限开通-第一步
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie2())
                .formParam("funcNo", "160506")
                .formParam("trade_no", custid)
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"));
    }

    @Test
    void test130001(){
        //科创板权限开通-查询客户是否为合规状态，是否个人客户，是否做风险测评，测评是否过期
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie2())
                .formParam("funcNo", "130001")
                .formParam("custid", custid)
                .formParam("orgid", "0012")
                .formParam("fundid", custid)
                .formParam("crm_client_type", "0")
                .formParam("riskkind", "3")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"));
    }

    @Test
    void test160501(){
        //科创板权限开通-开通条件判断
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie2())
                .formParam("funcNo", "160501")
                .formParam("trade_no", custid)
                .formParam("trade_account", custid)
                .formParam("branch_no", "0012")
                .formParam("professional_investor", "%E5%90%A6")//是；否
                .formParam("source", "2")
                .formParam("net_addr", "9.9.9.9")
                .formParam("xyzqzh", "")
                .formParam("sh_a", secuid)
                .formParam("sh_a_xy", "0")
                .formParam("isktxya", "0")
                .formParam("sh_trdacct", secuid)
                .formParam("isktpta", "0")
                .formParam("kcblx", "0")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"));
    }

    @Test
    void test160505(){
        //科创板权限开通-记录流水：调用后面测评/开通接口的前置
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie2())
                .formParam("funcNo", "160505")
                .formParam("xyzqzh", "")
                .formParam("sh_a", secuid)
                .formParam("sh_a_xy", "0")
                .formParam("isktxya", "0")
                .formParam("source", "2")
                .formParam("mac", "")
                .formParam("trading_expr", "9996")
                .formParam("QTFlag", "1")
                .formParam("professional_investor", "%E5%90%A6")
                .formParam("wswts", "20")//是；否
                .formParam("SHFlag", "0")
                .formParam("sfdz", "1")
                .formParam("lcFlag", "true")
                .formParam("branchno", "00127")
                .formParam("total_asset", "2646268.12")
                .formParam("trade_account", custid)
                .formParam("ip", "9.9.9.9")
                .formParam("gnpd", "1")
                .formParam("sh_trdacct", secuid)
                .formParam("isWsw", "0")
                .formParam("isktpta", "0")
                .formParam("risk_level", "%E7%9B%B8%E5%AF%B9%E7%A7%AF%E6%9E%81%E5%9E%8B")
                .formParam("isExe", "1")
                .formParam("isjjys", "1")
                .formParam("custid", custid)
                .formParam("tm", "0")
                .formParam("zt", "0")
                .formParam("isTime", "0")
                .formParam("kcblx", "0")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("results[0].flag", equalTo("1"));
    }

    @Test
    void test160503(){
        //科创板权限开通-观看完视频更新流水
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie2())
                .formParam("funcNo", "160503")
                .formParam("trade_no", custid)
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("results[0].flag", equalTo("1"));
    }

    @Test
    void test160507(){
        //科创板权限开通-取知识测评题目：题目顺序随机，如何传答案入参？
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie2())
                .formParam("funcNo", "160507")
                .formParam("trade_no", custid)
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"));
    }

    @Test
    void test160502(){
        //科创板权限开通-知识测评答题
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie2())
                .formParam("funcNo", "160502")
                .formParam("trade_no", custid)
                .formParam("jsondata", "3%7C10%7C%7CA%2C4%7C10%7C%7CC%2C6%7C10%7C%7CD%2C7%7C10%7C%7CB%2C8%7C10%7C%7CA%2C9%7C10%7C%7CC%2C13%7C10%7C%7CA%2C14%7C10%7C%7CA%2C29%7C5%7C%7CA%2C32%7C5%7C%7CA%2C33%7C5%7C%7CA%2C34%7C5%7C%7CA")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("results[0].tips", equalTo("知识测评不通过"));
    }
}
