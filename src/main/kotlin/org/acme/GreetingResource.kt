package org.acme

import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import org.acme.getting.started.GreetingService


@Path("/hello")
class GreetingResource {

    @Inject
    var service: GreetingService? = null

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    fun greeting(name: String?): String {
        return service!!.greeting(name!!)
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = "Hello from Quarkus REST"
}