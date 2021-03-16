package com.nakib.blockchainkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BlockchainKotlinApplication

fun main(args: Array<String>) {
	runApplication<BlockchainKotlinApplication>(*args)
}
