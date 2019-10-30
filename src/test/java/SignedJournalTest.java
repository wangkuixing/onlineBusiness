import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SignedJournalTest {

    @Test
    void testQuery(){

        given()
                .log().all()
                .queryParam("funcNo", "160210")
//                .queryParam("custid", "1300052059")
                .queryParam("custid", "1100009671")
                .queryParam("login_test", 1)
//                .header("Host","t0st.ytzq.com:8443")
//                .header("Cache-Control", "max-age=0")
//                .header("Upgrade-Insecure-Requests","1")
//                .header("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36")
//                .header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
//                .header("Accept-Language","zh-CN,zh;q=0.9")
////                .header("Connection","Keep-Alive")
//                .header("Accept-Encoding","gzip,deflate")
//                .header("Cookie", "Hm_lvt_9e03021ce3af82443836664867b17568=1562546083,1562809092,1563152407,1563585248; tpeGXMgf0ccK871=KndUeoT67VigJbiON5cuDplUXGUOk.bqhyZPf0lUlEAtQaqOAu77KsUqlbJ4.PF7atskPA984SR45ds6izbIePVUTQpuHxDPHFJ6U_FXsmJNq")
        .when()
                .get("http://t0st.ytzq.com:8443/web/bus/json")
        .then().log().all()
                .statusCode(200);
    }

    @Test
    void testSignRecord(){

        given()
                .log().all()
                .queryParam("funcNo", "160203")
//                .queryParam("custid", "1300052059")
                .queryParam("custid", "1100009671")
                .queryParam("login_test", 1)
//                .header("Host","t0st.ytzq.com:8443")
                .header("Cache-Control", "max-age=0")
                .header("Upgrade-Insecure-Requests","1")
                .header("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36")
                .header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                .header("Accept-Language","zh-CN,zh;q=0.9")
//                .header("Connection","Keep-Alive")
                .header("Accept-Encoding","gzip,deflate")
//                .header("Cookie", "Hm_lvt_9e03021ce3af82443836664867b17568=1562546083,1562809092,1563152407,1563585248; tpeGXMgf0ccK871=KndUeoT67VigJbiON5cuDplUXGUOk.bqhyZPf0lUlEAtQaqOAu77KsUqlbJ4.PF7atskPA984SR45ds6izbIePVUTQpuHxDPHFJ6U_FXsmJNq")
                .when()
                .get("http://t0st.ytzq.com:8443/web/bus/json")
                .then().log().all()
                .statusCode(200);
    }

    @Test
    void testSummary(){

        given()
                .log().all()
                .queryParam("funcNo", "160101")
                .queryParam("trade_no", "1100009671")
                .queryParam("login_test", 1)
//                .header("Host","t0st.ytzq.com:8443")
//                .header("Cache-Control", "max-age=0")
//                .header("Upgrade-Insecure-Requests","1")
//                .header("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36")
//                .header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
//                .header("Accept-Language","zh-CN,zh;q=0.9")
////                .header("Connection","Keep-Alive")
//                .header("Accept-Encoding","gzip,deflate")
//                .header("Cookie", "Hm_lvt_9e03021ce3af82443836664867b17568=1562546083,1562809092,1563152407,1563585248; tpeGXMgf0ccK871=KndUeoT67VigJbiON5cuDplUXGUOk.bqhyZPf0lUlEAtQaqOAu77KsUqlbJ4.PF7atskPA984SR45ds6izbIePVUTQpuHxDPHFJ6U_FXsmJNq")
                .when()
                .get("http://t0st.ytzq.com:8443/web/bus/json")
                .then().log().all()
                .statusCode(200);
    }

    @Test
    void testLogin(){

        given()
                .log().all()
                .queryParam("funcNo", "100201")
                .queryParam("login_name", "1300052059")
                .queryParam("login_password","88f7c7a3df1edd06dbbf8ada09b3472430f0b7d4f08e02102a96e3a51948b2ec8590418806b840e7eda708c603f9959de2e349e04a90e4b33b685590e74eafa2b6632b4c2fb18e657f434de54edc16609b5fc8a336be1b0031e7549cccddb4fc9ff05670d0d7ed55ce31fbb74cc362f1ec01481a7bd1f6d94a26b17812a368ea")
                .queryParam("img_ticket","8888")
                .queryParam("password_encrypt_type","normal")
                .queryParam("safe_type","1")
                .queryParam("dynamic_code","")
                .queryParam("user_mac","")
                .queryParam("user_disk_id","")
                .queryParam("user_ip","")
                .queryParam("user_agent","")
                .queryParam("")
//                .header("Host","t0st.ytzq.com:8443")
//                .header("Cache-Control", "max-age=0")
//                .header("Upgrade-Insecure-Requests","1")
//                .header("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36")
//                .header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
//                .header("Accept-Language","zh-CN,zh;q=0.9")
////                .header("Connection","Keep-Alive")
//                .header("Accept-Encoding","gzip,deflate")
//                .header("Cookie", "Hm_lvt_9e03021ce3af82443836664867b17568=1562546083,1562809092,1563152407,1563585248; tpeGXMgf0ccK871=KndUeoT67VigJbiON5cuDplUXGUOk.bqhyZPf0lUlEAtQaqOAu77KsUqlbJ4.PF7atskPA984SR45ds6izbIePVUTQpuHxDPHFJ6U_FXsmJNq")
                .when()
                .get("http://t0st.ytzq.com:8443/web/bus/json")
                .then().log().all()
                .statusCode(200);
    }
}
