package org.acme

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.core.StringContains.containsString
import org.junit.jupiter.api.Test
import java.util.*


@QuarkusTest
class GreetingResourceTest {

    @Test
    fun testHelloEndpoint() {
        given().`when`()["/hello?name=Bloom"]
            .then()
            .statusCode(200)
            .body(containsString("Hello"))
    }

}