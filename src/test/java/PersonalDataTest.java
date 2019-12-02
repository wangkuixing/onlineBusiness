import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * 个人资料修改
 */
public class PersonalDataTest {
    String custid="1300022253";
    String fundid="1300022253";
    String addr="%E4%B8%8A%E6%B5%B7%E5%B8%82%E6%9D%A8%E6%B5%A6%E5%8C%BA%E6%B5%8B%E8%AF%95%E8%A1%97%E9%81%931024%E5%8F%B7";
    String detail_addr="%E6%B5%8B%E8%AF%95%E8%A1%97%E9%81%931024%E5%8F%B7"; //测试街道1024号
//    String cookie="Hm_lvt_9e03021ce3af82443836664867b17568=1570517396,1571029945,1571116068,1571618900; JSESSIONID=abcnPwF33ZkbM79RdLa4w; sso_cookie=3o%2F%2BqYJWo0hM8VKiISsYJw%2F5EGb%2F620D3bEGvP6xIc6QI%2F%2BX3d3YqmmHW6U8oHXvVFSqoJ3iRB4v%0A0d%2BAix9QHY68IgW0GQSYSP3slL8lz9pvdOeCsh0%2FWqpeMOF9qQlAkieY5riItZRcLvvvCVzBm2Rs%0Al0dq9%2B%2Fg47NF0TJqEHhCs9QIT2AYsTCY3pqjEVWlqmhHKRzQBvZZFCKxaE%2By0c6nLgUaJOdMwh%2Fw%0AYsJp1m4ecutJZLTcKofE1oOKOVe5%2FOEYwGZLSqkoAkhOq0t1%2FK8n46paJUz9WgtvQzu%2Bn0t9zo0H%0Aq%2FumDR2yxMDr7PSAmkcTmx9i2haEzF5T9axrG5gLYB7DNogHOIHwfYyJ4B4eyU2ysYKwUSfQyChU%0AFuDPuW3QgQo7mnSp4QHbAuus2PewPxAsjwIX4bXK61tHlrKNVv1xY4mHesi8KwmWg59PDpdVDbUy%0AWFUGsxQbsDB3s6hf1L7HcB7UFfnbGlhOK2nRm%2F07qzYpiCrWI%2BwGO3nmhtl1LBirhJ4r%2B18mBnoV%0AmLEnbuf0YEOAjVzKXAo2A3d%2BkqjBZBl%2F%2BC9BIQMT9TKuSWfshenEIqlFc7OdcpwaMsJwrv1POKvL%0A0OJRPbPIx0mdRQEh9Ct8BrqvF9yaz6aricx%2FWRpzhgWBVJcp8g05Os%2Bu0koIV5apvGeg0tYV7Sj9%0AsncShcvq64UzDP5tT3ptqWhTS9INyEE5IzmIpKAIJZPPa14iC4JZDTveML%2BBBCCZJHBJ0oburBOH%0AVYjYG6sK5ojIXGG%2BhtfTuV14VOut3w5HkJaK8lCW2Vx0s6XZIJIpW4DMe%2F5AtFbJGQTg%2FgR2IQBS%0ACRkzrBIx1obQ46cMtidfVCBDAFfHN4yNaE0Q0ycF8twh%2FmAD3HhuI3cGtgSLQ7trir5tECNcTPTd%0AUejZEdM3K5nUZrFag7r8J1AHb5RkbJdHavfv4Pr5vLjPy5Ih1OxC22mNLf96n%2BgLS02gPxvVbxZU%0AE%2BjRp9SFP8Tt6dFm7NeN4owv4SnK%2For61oR%2BmClTBV3%2F%2FLrz%2BtEzdAh6jZxwtFNbWhpclo5QukRl%0AnZ5HFwrG%2F9GKyQ2InZiyOh4AmWrOljV5hMkEUWKywNyqb9K8FFK%2F06PJ; info=%7B%22sfbd%22:%221%22,%22rzrq_creditAccount%22:%221390000235%22,%22net_addr%22:%22113.106.86.142%22,%22crm_name%22:%22%E9%99%88%E8%BE%89%22,%22trade_account%22:%221300022253%22,%22crm_no%22:%226423083%22,%22trade_name%22:%22%E9%99%88%E8%BE%89%22,%22branch_no%22:%220013%22,%22device_info%22:%22Mozilla/5.0%20(Windows%20NT%2010.0@#@%20Win64@#@%20x64)%20AppleWebKit/537.36%20(KHTML,%20like%20Gecko)%20Chrome/77.0.3865.120%20Safari/537.36%22,%22crm_client_type%22:%220%22,%22identity_exp_date%22:%2220260812%22,%22branch_name%22:%22%E4%B8%8A%E6%B5%B7%E5%98%89%E5%96%84%E8%B7%AF%E8%AF%81%E5%88%B8%E8%90%A5%E4%B8%9A%E9%83%A8%22,%22trade_no%22:%221300022253%22,%22wealth_product%22:%22%22,%22wealth_level%22:%220%22,%22identity_idno%22:%22310230197711013718%22%7D; loginFlag=true; change_type=1; codetime_userid=13793; tradeAccount=1300022253; indexFlag=mdfFundPwd; investor=%7B%22risklevelvaliddate%22:%2220211010%22,%22investmentperiod%22:%222%22,%22lowriskflag%22:%220%22,%22investmenttype%22:%2201%22,%22exincometype%22:%22%22,%22risklevel%22:%223%22,%22trdprofvaliddate%22:%223000/12/31%22,%22investortype%22:%220%22,%22riskpropright%22:%224%22%7D";

    @Test
    void test104801(){
        //个人风险测评过期提示
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie())
                .formParam("login_test", 1)
                .formParam("funcNo", "104801")
                .formParam("trade_no", custid)
                .formParam("kind", "1")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"));
    }

    @Test
    void test105019(){
        //查询身份证是否过期
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .formParam("login_test", 1)
                .formParam("funcNo", "105019")
                .formParam("trade_no", custid)
                .formParam("branch_no", "0013")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("results[0].isOutTime",equalTo("false"));
    }

    @Test
    void test100905(){
        //个人资料修改
        given()
//                .proxy(8888)
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie())
                .formParam("login_test", 1)
                .formParam("funcNo", "100905")
                .formParam("trade_no", custid)
                .formParam("branch_no", "0013")
                .formParam("user_name", "%E9%99%88%E8%BE%89")//陈辉
                .formParam("email", "158215867@qq.com")
                .formParam("addr", addr)
                .formParam("province", "%E4%B8%8A%E6%B5%B7%E5%B8%82")//上海市
                .formParam("city", "%E6%9D%A8%E6%B5%A6%E5%8C%BA")//杨浦区
                .formParam("country", "")
                .formParam("detail_add", detail_addr)
                .formParam("card_type", "00")
                .formParam("card_no", "310230197711013718")
                .formParam("sex", "0")
                .formParam("trade_password", "a42e39a8dbeac126dc1d7b43e571f4e0b4d232255bb4d7b8bf75755873ee531cc8cbdb42406f1cc972bbe30110aed8a0886dc8a76e7ee6f7d82b32c870bf53c7363164a3d431d910bae4683fecf2e229ec670350f7bb7b21aac48eba62b97d296d11cff3862d847a19f143e7b3ab94e952b03e40c1fc45da1d960d32027b4876")
                .formParam("encrypt_type", "normal")
                .formParam("occ_type", "C")
                .formParam("workplace", "%E9%93%B6%E8%A1%8C")//银行
                .formParam("position", "3")
                .formParam("education", "2")
                .formParam("occu_type", "02")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0")).body("error_info", equalTo("更改信息成功"));
    }

    @Test
    void test100968(){

        //个人资料修改-备用联系人
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie())
                .formParam("login_test", 1)
                .formParam("funcNo", "100968")
                .formParam("user_name", "%E9%99%88%E8%BE%89")
                .formParam("linkman_name", "tony")
                .formParam("encrypt_type", "normal")
                .formParam("trade_password", "9a145ad64f68b7311f1edb7283f6e28541ec087037abf28b7d381c76d2dbe111985c67969d2f6e1fdd2792432710e478a424089a8b60784375107d3e10a52a5aacb9353884b2a8122290d250ee1d75b5f53ece476c6bf146254f08cabd885e41dafdc405bda40ee8a83bd6629d18c4e4eb4bd6cecf0f99423bdce387979ed579")
                .formParam("linkman_no", "1")
                .formParam("linkman_tel", "13823342796")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"));
    }


}
