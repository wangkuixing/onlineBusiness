import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * 交易权限开通
 */
public class PermissionTest {

    String custid="1100001235";
    String secuid="A122338917";
    @Test
    void test102013(){
        //查询客户证券账户
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie())
                .formParam("funcNo", "102013")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("error_info", equalTo("查询用户账户成功"))
                .body("aaccountList[0].stock_account", equalTo("0128208140"));
    }

    @Test
    void test100912(){
        //查询客户创业板转签状态，0-没有创业板权限；1-有
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie())
                .formParam("funcNo", "100912")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("results[0].cybAgmtExist", equalTo("1"));
    }

    @Test
    void test100921(){
        //查询客户现有交易权限
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie2())
                .formParam("funcNo", "100921")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"));
    }

    @Test
    void test101801(){
        //查询客户现有交易权限
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie2())
                .formParam("funcNo", "101801")
                .formParam("market","1")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("error_info", equalTo("证券账号权限查询成功"));
    }

    @Test
    void test102011(){
        //电子签名约定书-根据协议类别查询电子协议
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie2())
                .formParam("funcNo", "102011")
                .formParam("agree_ename","entrust")
                .formParam("type_code","ygt_zqaccountprotcl")
                .formParam("agree_no","5005")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("error_info", equalTo("调用成功"));
    }

    @Test
    void test100926(){
        //修改操作方式operway,开通移动交易权限01345efgdhij
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie2())
                .formParam("funcNo", "100926")
                .formParam("operway","01345efgdhij")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("results[0].msgok", equalTo("修改操作方式成功"));
    }

    @Test
    void test100927(){
        //记录交易权限开通流水
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie2())
                .formParam("funcNo", "100927")
                .formParam("power","hij")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("error_info", equalTo("调用成功"));
    }

    @Test
    void test101805(){
        //查询客户现有交易权限
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie2())
                .formParam("funcNo", "101805")
                .formParam("secuid",secuid)
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("error_info", equalTo("2"));
    }

    @Test
    void test100904(){
        //查询客户风险等级
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie2())
                .formParam("funcNo", "100904")
                .formParam("riskkind","3")
                .formParam("trade_no",custid)
                .formParam("branch_no","0012")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"));
    }

    @Test
    void test101802(){
        //查询客户现有交易权限
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie2())
                .formParam("funcNo", "101802")
                .formParam("market","1")
                .formParam("secuid",secuid)
                .formParam("powertype","4")
                .formParam("fundasset","")
                .formParam("is_check","%E5%B7%B2%E7%AD%BE%E7%BD%B2")
                .formParam("is_warning","%E5%B7%B2%E7%AD%BE%E7%BD%B2")
                .formParam("rating_name","%E7%9B%B8%E5%AF%B9%E7%A7%AF%E6%9E%81%E5%9E%8B")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("error_info", equalTo("权限开通成功"));
    }
}
