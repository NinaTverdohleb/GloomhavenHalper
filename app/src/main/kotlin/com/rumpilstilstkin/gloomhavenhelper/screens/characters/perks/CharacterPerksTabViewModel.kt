package com.rumpilstilstkin.gloomhavenhelper.screens.characters.perks

import androidx.lifecycle.ViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel(assistedFactory = CharacterPerksTabViewModel.Factory::class)
class CharacterPerksTabViewModel(
    @Assisted val id: Int,
) : ViewModel() {

    @AssistedFactory
    interface Factory {
        fun create(id: Int): CharacterPerksTabViewModel
    }
}