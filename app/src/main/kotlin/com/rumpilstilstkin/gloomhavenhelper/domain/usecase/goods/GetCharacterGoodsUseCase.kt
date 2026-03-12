package com.rumpilstilstkin.gloomhavenhelper.domain.usecase.goods

import com.rumpilstilstkin.gloomhavenhelper.data.GoodsRepository
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.Good
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharacterGoodsUseCase @Inject constructor(
    private val goodsRepository: GoodsRepository
) {

    operator fun invoke(characterId: Int): Flow<List<Good>> {
        return goodsRepository.getCharacterGoods(characterId)
    }
}