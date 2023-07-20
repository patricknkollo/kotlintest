package com.kotlinmvn.ktl

import org.springframework.boot.fromApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.with

@TestConfiguration(proxyBeanMethods = false)
class TestKtlApplication

fun main(args: Array<String>) {
	fromApplication<KtlApplication>().with(TestKtlApplication::class).run(*args)
}
