package com.rumpilstilstkin.gloomhavenhelper.bd.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.rumpilstilstkin.gloomhavenhelper.bd.entity.CharacterGoodBd
import com.rumpilstilstkin.gloomhavenhelper.bd.entity.CharacterGoodDetailsBd
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterGoodsDao {
    @Transaction
    @Query("SELECT * FROM CharacterGoodBd WHERE characterId LIKE :characterId")
    fun getCharacterGoodsFlow(characterId: Int): Flow<List<CharacterGoodDetailsBd>>

    @Transaction
    @Query("SELECT * FROM CharacterGoodBd WHERE characterId LIKE :characterId")
    suspend fun getCharacterGoods(characterId: Int): List<CharacterGoodDetailsBd>

    @Transaction
    @Query("SELECT goodId FROM CharacterGoodBd WHERE characterId IN (:characterIds)")
    fun getCharactersGoodIds(characterIds: List<Int>): Flow<List<Int>>

    @Transaction
    @Query("SELECT * FROM CharacterGoodBd WHERE id LIKE :characterGoodId")
    suspend fun getCharacterGoodById(characterGoodId: Int): CharacterGoodDetailsBd

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(characterGood: CharacterGoodBd)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(characterGoods: List<CharacterGoodBd>)

    @Delete
    suspend fun delete(characterGood: CharacterGoodBd)

    @Query("DELETE FROM CharacterGoodBd WHERE characterId = :characterId AND goodId = :goodId")
    suspend fun delete(characterId: Int, goodId: Int)

    @Query("DELETE FROM CharacterGoodBd WHERE characterId = :characterId")
    suspend fun deleteCharacterGoods(characterId: Int)
}