package com.github.eltonsandre.sample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReactiveResilience4jCircuitbreakApplication

fun main(args: Array<String>) {
	runApplication<ReactiveResilience4jCircuitbreakApplication>(*args)
}
