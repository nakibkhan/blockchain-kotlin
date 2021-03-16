package com.nakib.blockchainkotlin

import com.nakib.blockchainkotlin.domain.Block
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BlockchainKotlinApplication: CommandLineRunner {
	override fun run(vararg args: String?) {
		println("Starting Kotlin Blockchain Example")

		val genesisBlock = Block.create(previousHash = "0", data = "I'm the first")
		val secondBlock = Block.create(genesisBlock.hash, "I'm the second")
		val thirdBlock = Block.create(secondBlock.hash, "I'm the third")

		println(genesisBlock)
		println(secondBlock)
		println(thirdBlock)
	}
}

fun main(args: Array<String>) {
	runApplication<BlockchainKotlinApplication>(*args)
}
