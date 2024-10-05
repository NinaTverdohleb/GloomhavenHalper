package com.rumpilstilstkin.gloomhavenhelper.domain.usecase.characters.perks

import com.rumpilstilstkin.gloomhavenhelper.data.CharacterRepository
import com.rumpilstilstkin.gloomhavenhelper.data.PerksRepository
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.Perk
import javax.inject.Inject

class GetAvaliableCharacterPerksUseCase @Inject constructor(
    private val characterRepository: CharacterRepository,
    private val perksRepository: PerksRepository,
) {

    suspend operator fun invoke(characterId: Int, characterPerks: List<Perk>): List<Perk> {
        val character = characterRepository.getCharacterById(characterId)
        return perksRepository.getPerksForCharacterClass(character.characterType)
            .filter { perk -> perk.id !in characterPerks.map { it.id } }
    }
}