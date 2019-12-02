import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * 资金密码修改
 */
public class PasswdChangeTest {
    String custid="1300022253";

    @Test
    void test103003(){
        //修改资金密码，456654-->123321
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie())
                .formParam("login_test", 1)
                .formParam("funcNo", "103003")
                .formParam("oldpwd", "encrypt_rsa%3A7c7c33f5d56040d62c63c69eb29c358fd9015f31e3f5dd483005f11b5ec7e4b5d54e9ea2097b300add0cd442cef4968db3d47336d3cdfbbdaea6e64ddaf6bb18ce7a029259ae4ca6e892b79c67de8f5ac873316786c292fb6eaf7ccb0b931ac305806d9978117553a27a1f059be688c14d7535e207937f926b5bd305b587de00")
                .formParam("newpwd1", "encrypt_rsa%3A6266be2d409acfe0b08d582c88c43fc27d9b5fb9340e7ea8d9f247b2bae63566d69708f49eb5ec86cc9e54c8914cdc6086847eca5182a0d10e3bd94e1c4c490706bcb0e9b853d41d0a17602bbec31a28e69bd9ea9285ae440604603d778fb5ee6e1104f789e211c900275acb9ba2f695772ad90c3cd92d95bac8a9e8f388a012")
                .formParam("confirmpwd", "encrypt_rsa%3A39a841a37312972870c48970fcc9c4bb79923e0fff24d9af08158ca073ad15d9e41889e51f238025c8c7db1d9fc537789bddd01e7ce06e22b4697b0228169e5316248b11ef2273c3ed34fc8eee4c12b133d9a729ad112fb0d5528da1852243969e33072dedaffbc20fc162a8e3320f5944ef9adea369650255ebbbdb55565eba")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"));
//                .body("results[0].isOutTime",equalTo("false"));
    }
}
