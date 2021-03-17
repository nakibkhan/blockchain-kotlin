package com.nakib.blockchainkotlin

import com.nakib.blockchainkotlin.configurations.BlockChainProperties
import com.nakib.blockchainkotlin.domain.Block
import com.nakib.blockchainkotlin.services.BlockChain
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(BlockChainProperties::class)
class BlockchainKotlinApplication: CommandLineRunner {
	override fun run(vararg args: String?) {
		println("Starting Kotlin Blockchain Example")

		val blockChain = BlockChain()

		val genesisBlock = Block.create(previousHash = "0", data = "I'm the first")
		blockChain.add(genesisBlock)

		val secondBlock = Block.create(genesisBlock.hash, "I'm the second")
		blockChain.add(secondBlock)

		val thirdBlock = Block.create(secondBlock.hash, "I'm the third")
		blockChain.add(thirdBlock)

		blockChain.isValid()
	}
}

fun main(args: Array<String>) {
	runApplication<BlockchainKotlinApplication>(*args)
}
