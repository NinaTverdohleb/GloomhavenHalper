package com.rumpilstilstkin.gloomhavenhelper.domain.usecase.characters

import com.rumpilstilstkin.gloomhavenhelper.data.CharacterRepository
import javax.inject.Inject

class LevelUpUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) {
    suspend operator fun invoke(characterId: Int) {
        val character = characterRepository.getCharacterById(characterId)
        characterRepository.updateLevel(characterId, character.level + 1)
    }
}