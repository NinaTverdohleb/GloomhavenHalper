package com.rumpilstilstkin.gloomhavenhelper.domain.usecase.characters

import com.rumpilstilstkin.gloomhavenhelper.data.CharacterRepository
import javax.inject.Inject

class CheckedChangeUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) {
    suspend operator fun invoke(characterId: Int, isChecked: Boolean) {
        val character = characterRepository.getCharacterById(characterId)
        val newCheckedMarkCount = if (isChecked) {
            if (character.checkMarks < 18) character.checkMarks + 1 else 18
        } else {
            if (character.checkMarks != 0) character.checkMarks - 1 else 0
        }
        characterRepository.updateCheckMarks(characterId, newCheckedMarkCount)
    }
}