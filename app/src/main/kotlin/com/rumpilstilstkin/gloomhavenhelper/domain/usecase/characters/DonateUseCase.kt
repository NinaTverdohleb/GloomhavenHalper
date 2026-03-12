package com.rumpilstilstkin.gloomhavenhelper.domain.usecase.characters

import com.rumpilstilstkin.gloomhavenhelper.data.CharacterRepository
import javax.inject.Inject

class DonateUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) {
    suspend operator fun invoke(characterId: Int) {
        characterRepository.getCharacterById(characterId)?.also { character ->
            characterRepository.updateGold(characterId, character.goldCount - 10)
        }
    }
}