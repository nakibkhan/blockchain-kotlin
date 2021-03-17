package com.nakib.blockchainkotlin.services

import com.nakib.blockchainkotlin.domain.Block

class BlockChain    {
    private var blocks: MutableList<Block> = mutableListOf()

    fun add(block: Block) : Block {
        val minedBlock = if(block.isMined())    {
            return block
        } else  {
            mine(block)
        }

        blocks.add(minedBlock)
        return minedBlock
    }

    private fun mine(block: Block): Block {
        println("Mining $block")

        var minedBlock = block.copy()
        while(!minedBlock.isMined()) {
            minedBlock = minedBlock.copy(nonce = minedBlock.nonce + 1)
        }

        println("Mined : $minedBlock")

        return minedBlock
    }

    fun isValid() :Boolean  {
        if(this.blocks.size == 0) {
            println("BlockChain is empty")
            return true
        }

        if(this.blocks.size == 1) {
            println("BlockChain has only one item")
            return blocks[0].hash == blocks[0].calculateHash()
        }

        for (i in 1 until blocks.size) {
            val previousBlock = blocks[i - 1]
            val currentBlock = blocks[i]

            when {
                currentBlock.hash != currentBlock.calculateHash() -> return false
                previousBlock.hash != previousBlock.calculateHash() -> return false
                !(previousBlock.isMined() && currentBlock.isMined()) -> return false
            }
        }

        println("The Block Chain is Valid")
        return true
    }
}
