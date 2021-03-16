package com.nakib.blockchainkotlin.domain

import com.nakib.blockchainkotlin.extensions.hash
import java.time.Instant

data class Block(val previousHash: String,
                 val data: String,
                 val timestamp: Long = Instant.now().toEpochMilli(),
                 var hash: String = "") {
    init {
        hash = calculateHash()
    }

    fun calculateHash(): String {
        return "$previousHash$data$timestamp".hash()
    }

    companion object    {
        fun create(previousHash: String, data: String ) : Block = Block(previousHash, data)
    }
}