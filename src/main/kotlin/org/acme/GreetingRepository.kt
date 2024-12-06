package org.acme

import io.quarkus.hibernate.orm.panache.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class GreetingRepository: PanacheRepository<Greeting> {
}