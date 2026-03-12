package com.rumpilstilstkin.gloomhavenhelper.domain.usecase.team

import javax.inject.Inject

class GetNextChurchValueUseCase @Inject constructor() {
    operator fun invoke(churchValue: Int): Int = when {
        churchValue < 150 -> 150
        churchValue < 200 -> 200
        churchValue < 250 -> 250
        churchValue < 300 -> 300
        churchValue < 350 -> 350
        churchValue < 400 -> 500
        churchValue < 500 -> 600
        churchValue < 600 -> 700
        churchValue < 700 -> 800
        churchValue < 800 -> 900
        churchValue < 900 -> 1000
        else -> -1
    }
}