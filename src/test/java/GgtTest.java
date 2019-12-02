import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * 权限办理-港股通权限开通
 */
public class GgtTest {

    //testOrder:104902-104901-104903-104905-104906-104910-104907-104909
    static Integer current_step;

    @Test
    void test104901(){
        //港股通权限开通-获取current_step，判断当前进行到哪一步
        Response response= given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie2())
                .formParam("funcNo", "104901")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("error_info", equalTo("操作成功"))
                .extract().response();
        String s=(response.jsonPath().get("results[0].current_step"));
        current_step=Integer.parseInt(s);

        System.out.println(current_step);
    }

    @Test
    void test104902(){
        //港股通权限开通-选择市场，生成流水，港股通权限开通的前置动作
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie2())
                .formParam("funcNo", "104902")
                .formParam("sh_a", "1")
                .formParam("sz_a", "1")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("error_info", equalTo("操作成功"));
    }

    @Test
    void test104903(){
        //港股通权限开通-观看视频更新流水
        test104901();
        if (current_step==1){
            given()
                    .log().all()
                    .filter(SignAgreementTest.myFilter)
                    .header("Cookie" , GetCookie.getCookie2())
                    .formParam("funcNo", "104903")
                    .formParam("investortype", "0")
                    .when()
                    .post("url")
                    .then().log().all()
                    .statusCode(200).body("error_no", equalTo("0"))
                    .body("error_info", equalTo("操作成功"));
        } else {
            System.out.println("current_step is not eualto 1");
        }
    }

    @Test
    void test104904(){
        //港股通权限开通-港股通风险承受能力测评
        test104901();
        if (current_step==1){
            given()
                    .log().all()
                    .filter(SignAgreementTest.myFilter)
                    .header("Cookie" , GetCookie.getCookie2())
                    .formParam("funcNo", "104904")
                    .formParam("investortype", "0")
                    .when()
                    .post("url")
                    .then().log().all()
                    .statusCode(200).body("error_no", equalTo("0"))
                    .body("error_info", equalTo("操作成功"));
        } else {
            System.out.println("current_step is not eualto 1");
        }

    }

    @Test
    void test104905(){
        //港股通权限开通-港股通风险承受能力测评
        test104901();
        if (current_step==2){
            given()
                    .log().all()
                    .filter(SignAgreementTest.myFilter)
                    .header("Cookie" , GetCookie.getCookie2())
                    .formParam("funcNo", "104905")
                    .formParam("answer", "%7B%221%22%3A%222%22%2C%222%22%3A%223%22%2C%223%22%3A%222%22%2C%224%22%3A%224%22%2C%225%22%3A%223%22%2C%226%22%3A%221%22%2C%227%22%3A%222%22%2C%228%22%3A%223%22%2C%229%22%3A%223%22%2C%2210%22%3A%223%22%2C%2211%22%3A%222%22%2C%2212%22%3A%222%22%2C%2213%22%3A%222%22%2C%2214%22%3A%222%22%2C%2215%22%3A%222%22%2C%2216%22%3A%222%22%2C%2217%22%3A%22%22%2C%2218%22%3A%222%22%2C%2219%22%3A%22%22%2C%2220%22%3A%222%22%2C%2221%22%3A%223%22%7D")
                    .when()
                    .post("url")
                    .then().log().all()
                    .statusCode(200).body("error_no", equalTo("0"))
                    .body("error_info", equalTo("操作成功"));
        }
        else {
            System.out.println("current_step is not eualto 2");
        }
    }

    @Test
    void test104906(){
//        港股通权限开通--知识测评
        test104901();
        if (current_step==3){
            given()
                    .log().all()
                    .filter(SignAgreementTest.myFilter)
                    .header("Cookie" , GetCookie.getCookie2())
                    .formParam("funcNo", "104906")
                    .formParam("answer", "A%2CC%2CA%2CD%2CA%2CD%2CB%2CC%2CD%2CA%2C1%2C0%2C0%2C1%2C1%2C1%2C0%2C1%2C1%2C0")
                    .when()
                    .post("url")
                    .then().log().all()
                    .statusCode(200).body("error_no", equalTo("0"))
                    .body("error_info", equalTo("评估通过"));
        } else{
            System.out.println("current_step is not eualto 3");
        }

    }

    @Test
    void test104910(){
        //记录客户签署不适当确认协议
        test104901();
        if (current_step==4){
            given()
                    .log().all()
                    .filter(SignAgreementTest.myFilter)
                    .header("Cookie" , GetCookie.getCookie2())
                    .formParam("funcNo", "104910")
                    .formParam("no_match_biz_deal", "")
                    .formParam("match_biz_deal", "1")
                    .when()
                    .post("url")
                    .then().log().all()
                    .statusCode(200).body("error_no", equalTo("0"))
                    .body("error_info", equalTo("设置不适当确认签署标识成功"));
        }else{
            System.out.println("current_step is not eualto 4");
        }
    }

    @Test
    void test104907(){
        //港股通权限开通-判断客户是否能开通双市场交易权限
        test104901();
        if (current_step==4){
            given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie2())
                .formParam("funcNo", "104907")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("error_info", equalTo("操作成功"))
                .body("results[0].is_pop", equalTo("0"));
        }else{
            System.out.println("current_step is not eualto 4");
        }
    }

    @Test
    void test104909(){
        //港股通权限开通-权限开通
        //todo:未开通权限，后续跟踪页面完善
        test104901();
        if (current_step==4){
            given()
                    .log().all()
                    .filter(SignAgreementTest.myFilter)
                    .header("Cookie" , GetCookie.getCookie2())
                    .formParam("funcNo", "104909")
                    .when()
                    .post("url")
                    .then().log().all()
                    .statusCode(200).body("error_no", equalTo("0"))
                    .body("error_info", equalTo("操作成功"));
        }else{
            System.out.println("current_step is not eualto 4");
        }
    }
}
