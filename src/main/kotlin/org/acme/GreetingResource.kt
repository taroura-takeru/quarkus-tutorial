package org.acme

import jakarta.inject.Inject
import jakarta.transaction.Transactional
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.QueryParam
import jakarta.ws.rs.core.MediaType
import java.util.stream.Collectors

@Path("/hello")
class GreetingResource {

    @Inject
    var greetingRepository: GreetingRepository? = null

    @GET
    @Transactional
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(@QueryParam("name") name: String): String {
        val greeting = Greeting()
        greeting.name = name
        greeting.persist()
        return "Hello $name"
    }

    @GET
    @Path("names")
    @Produces(MediaType.TEXT_PLAIN)
    fun names(): String {
        val greetings: List<Greeting> = greetingRepository!!.listAll()
        val names = greetings.stream()
                .map { g: Greeting -> g.name }
                .collect(Collectors.joining(", "))
        return "I've said hello to $names"
    }
}