package com.rumpilstilstkin.gloomhavenhelper.data

import com.rumpilstilstkin.gloomhavenhelper.bd.dao.CharacterClassDao
import com.rumpilstilstkin.gloomhavenhelper.bd.dao.CharacterDao
import com.rumpilstilstkin.gloomhavenhelper.bd.dao.CharacterGoodsDao
import com.rumpilstilstkin.gloomhavenhelper.bd.dao.GoodsDao
import javax.inject.Inject

class GoodsRepository@Inject constructor(
    private val goodsDao: GoodsDao
) {
    suspend fun getGoods() = goodsDao.getAll()
}