import io.restassured.builder.ResponseBuilder;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * 签署协议集中展示
 */
public class SignAgreementTest {
    String custid="1100009671";
    //封装原有filter方法，实现将返回body从html转换为json
    public static Filter myFilter=new Filter() {
        public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
            Response response = ctx.next(requestSpec, responseSpec);

            String content = new String(response.getBody().asString());
            Response Response2 = new ResponseBuilder().clone(response).setContentType(ContentType.JSON).setBody(content).build();
            return Response2;
        }
    };

    @Test
    void test160202(){
        //客户签署流水记录
        given()
                .log().all()
                .filter(myFilter)
                .queryParam("login_test", 1)
                .queryParam("funcNo", "160202")
                .queryParam("custid", custid)
                .queryParam("ywmc", "交易权限")
                .queryParam("xymc", "《适当性匹配意见及投资者确认书》")
                .queryParam("bbh", "1")
                .queryParam("xylx", "1")
                .when()
                .get("url")
                .then().log().all()
                .statusCode(200);
    }

    @Test
    void test160203(){
        //客户签署流水查询
        given()
                .log().all()
                .filter(myFilter)
                .queryParam("login_test", 1)
                .queryParam("funcNo", "160203")
                .queryParam("custid", custid)
        .when()
                .get("url")
        .then()
                .log().all()
                .statusCode(200).body("error_no",equalTo("0"));
//        String err_no=response.jsonPath().get("error_no");
//        assertThat(err_no, equalTo("0"));
    }
}
