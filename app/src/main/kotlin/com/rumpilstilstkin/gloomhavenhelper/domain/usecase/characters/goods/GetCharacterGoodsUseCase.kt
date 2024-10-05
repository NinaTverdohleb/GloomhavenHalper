package com.rumpilstilstkin.gloomhavenhelper.domain.usecase.characters.goods

import com.rumpilstilstkin.gloomhavenhelper.data.CharacterRepository
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.Good
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharacterGoodsUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) {

    operator fun invoke(characterId: Int): Flow<List<Good>> {
        return characterRepository.getCharacterGoodsFlow(characterId)
    }
}