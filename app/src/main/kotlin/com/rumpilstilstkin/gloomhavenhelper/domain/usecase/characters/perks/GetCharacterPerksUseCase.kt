package com.rumpilstilstkin.gloomhavenhelper.domain.usecase.characters.perks

import com.rumpilstilstkin.gloomhavenhelper.data.CharacterRepository
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.Perk
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharacterPerksUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) {

    operator fun invoke(characterId: Int): Flow<List<Perk>> {
        return characterRepository.getCharacterPerksFlow(characterId)
    }
}