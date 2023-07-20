package com.kotlinmvn.ktl.controllers

import com.kotlinmvn.ktl.entities.Person
import com.kotlinmvn.ktl.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/api/users")
class PersonController (@Autowired private val  service: PersonService) {

    @GetMapping("/users")
    @ResponseBody
    fun getAllUsers(): List<Person> =
        service.getAllUsers().toList()

    @PostMapping("/save/user")
    fun createUser(@RequestBody person: Person): ResponseEntity<Person> { return service.createUser(person) }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable("id") userId: Long): ResponseEntity<Person> {
        return service.getUserById(userId)
    }
}