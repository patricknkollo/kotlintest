package com.kotlinmvn.ktl.services

import com.kotlinmvn.ktl.entities.Person
import com.kotlinmvn.ktl.repositories.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody


@Service
class PersonService (@Autowired private val repository: PersonRepository){


    @GetMapping("")
    fun getAllUsers(): List<Person> =
        repository.findAll().toList()

    @PostMapping("")
    fun createUser(@RequestBody person: Person): ResponseEntity<Person> {
        val createdUser = repository.save(person)
        return ResponseEntity(createdUser, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable("id") userId: Long): ResponseEntity<Person> {
        val user = repository.findById(userId).orElse(null)
        return if (user != null) ResponseEntity(user, HttpStatus.OK)
        else ResponseEntity(HttpStatus.NOT_FOUND)
    }
}