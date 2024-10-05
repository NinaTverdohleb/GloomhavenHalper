package com.rumpilstilstkin.gloomhavenhelper.domain.usecase.characters.goods

import com.rumpilstilstkin.gloomhavenhelper.data.CharacterRepository
import javax.inject.Inject

class AddGoodForCharacterUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) {

    suspend operator fun invoke(goodIds: List<Int>, characterId: Int) {
        goodIds.forEach { goodId -> characterRepository.addCharacterGood(
            characterId = characterId,
            goodId = goodId
        )}
    }

}