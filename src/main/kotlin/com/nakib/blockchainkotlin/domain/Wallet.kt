package com.nakib.blockchainkotlin.domain

import com.nakib.blockchainkotlin.services.BlockChain
import java.security.KeyPairGenerator
import java.security.PrivateKey
import java.security.PublicKey

data class Wallet(
        val publicKey: PublicKey,
        val privateKey: PrivateKey,
        val blockChain: BlockChain
)   {

    companion object    {
        fun create(blockChain: BlockChain) : Wallet {
            val generator = KeyPairGenerator.getInstance("RSA")
            generator.initialize(2048)
            val keyPair = generator.genKeyPair()

            return Wallet(keyPair.public, keyPair.private, blockChain)
        }
    }

}
