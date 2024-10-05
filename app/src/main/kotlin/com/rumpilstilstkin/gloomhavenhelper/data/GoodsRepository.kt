package com.rumpilstilstkin.gloomhavenhelper.data

import com.rumpilstilstkin.gloomhavenhelper.bd.dao.GoodsDao
import com.rumpilstilstkin.gloomhavenhelper.data.mappers.toDomain
import javax.inject.Inject

class GoodsRepository @Inject constructor(
    private val goodsDao: GoodsDao
) {
    suspend fun getGoods() = goodsDao.getAll().map { it.toDomain() }

    suspend fun getGoodByIds(ids: List<Int>) = goodsDao.getGoodsByIds(ids)
}