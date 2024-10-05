package com.rumpilstilstkin.gloomhavenhelper.domain.usecase.goods

import com.rumpilstilstkin.gloomhavenhelper.data.CharacterRepository
import com.rumpilstilstkin.gloomhavenhelper.data.GoodsRepository
import com.rumpilstilstkin.gloomhavenhelper.data.mappers.toDomain
import javax.inject.Inject

class GetAllGoodsUseCase @Inject constructor(
    private val goodsRepository: GoodsRepository
) {

    suspend operator fun invoke() = goodsRepository.getGoods()

}