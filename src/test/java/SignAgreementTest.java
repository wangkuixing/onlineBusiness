import io.restassured.RestAssured;
import io.restassured.builder.ResponseBuilder;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class SignAgreementTest {

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

        given()
                .log().all()
                .filter(myFilter)
                .queryParam("login_test", 1)
                .queryParam("funcNo", "160202")
                .queryParam("custid", "1100009671")
                .queryParam("ywmc", "交易权限")
                .queryParam("xymc", "《适当性匹配意见及投资者确认书》")
                .queryParam("bbh", "1")
                .queryParam("xylx", "1")
                .when()
                .get("http://t0st.ytzq.com:8443/web/bus/json")
                .then().log().all()
                .statusCode(200);
    }

    @Test
    void test160203(){

        given()
                .log().all()
                .filter(myFilter)
                .queryParam("login_test", 1)
                .queryParam("funcNo", "160203")
                .queryParam("custid", "1100009671")
        .when()
                .get("http://t0st.ytzq.com:8443/web/bus/json")
        .then()
                .log().all()
                .statusCode(200).body("error_no",equalTo("0"));
//        String err_no=response.jsonPath().get("error_no");
//        assertThat(err_no, equalTo("0"));
    }
}
