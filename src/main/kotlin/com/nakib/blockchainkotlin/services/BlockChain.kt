package com.nakib.blockchainkotlin.services

import com.nakib.blockchainkotlin.domain.Block

class BlockChain    {
    private var blocks: MutableList<Block> = mutableListOf()

    fun add(block: Block) : Block {
        val minedBlock = if(block.isMined()) return block else mine(block)
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
}
