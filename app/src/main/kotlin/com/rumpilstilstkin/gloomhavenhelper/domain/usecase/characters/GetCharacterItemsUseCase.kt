package com.rumpilstilstkin.gloomhavenhelper.domain.usecase.characters

import com.rumpilstilstkin.gloomhavenhelper.data.CharacterRepository
import javax.inject.Inject

class GetCharacterItemsUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) {

}