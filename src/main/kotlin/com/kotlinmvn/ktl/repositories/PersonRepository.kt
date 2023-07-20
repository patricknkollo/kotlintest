package com.kotlinmvn.ktl.repositories

import com.kotlinmvn.ktl.entities.Person
import org.springframework.data.repository.CrudRepository

interface PersonRepository : CrudRepository<Person, Long>{
}