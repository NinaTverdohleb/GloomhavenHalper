package com.rumpilstilstkin.gloomhavenhelper.bd.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.rumpilstilstkin.gloomhavenhelper.bd.entity.CharacterGoodDetailsBd
import com.rumpilstilstkin.gloomhavenhelper.bd.entity.GoodBd
import com.rumpilstilstkin.gloomhavenhelper.bd.entity.PerkBd

@Dao
interface PerksDao {

    @Insert
    suspend fun insertAll(vararg users: PerkBd)

    @Transaction
    @Query("SELECT * FROM PerkBd WHERE characterType LIKE :characterType")
    suspend fun getPerksByCharacterClass(characterType: String): List<PerkBd>

}