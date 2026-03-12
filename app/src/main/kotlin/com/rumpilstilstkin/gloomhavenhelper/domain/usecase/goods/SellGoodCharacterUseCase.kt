package com.rumpilstilstkin.gloomhavenhelper.domain.usecase.goods

import com.rumpilstilstkin.gloomhavenhelper.data.CharacterRepository
import com.rumpilstilstkin.gloomhavenhelper.data.GoodsRepository
import javax.inject.Inject

class SellGoodCharacterUseCase @Inject constructor(
    private val characterRepository: CharacterRepository,
    private val goodsRepository: GoodsRepository,
    private val deleteCharacterGoodsUseCase: DeleteCharacterGoodsUseCase,
) {

    suspend operator fun invoke(goodId: Int, characterId: Int): Result<Unit> {
        return characterRepository.getCharacterById(characterId)?.let { character ->
            val good = goodsRepository.getGood(goodId) ?: return Result.failure(Exception())
            deleteCharacterGoodsUseCase(
                goodId = goodId,
                characterId = characterId
            )
            characterRepository.updateGold(characterId, character.goldCount + good.cost.div(2))
            Result.success(Unit)
        } ?: return Result.failure(Exception())
    }
}