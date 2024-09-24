package com.rumpilstilstkin.gloomhavenhelper.domain.usecase.characters

import com.rumpilstilstkin.gloomhavenhelper.data.CharacterRepository
import javax.inject.Inject

class GetCharacterPerksUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) {

}