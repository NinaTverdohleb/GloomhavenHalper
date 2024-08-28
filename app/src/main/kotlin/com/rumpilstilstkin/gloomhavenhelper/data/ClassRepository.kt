package com.rumpilstilstkin.gloomhavenhelper.data

import com.rumpilstilstkin.gloomhavenhelper.bd.dao.CharacterClassDao
import com.rumpilstilstkin.gloomhavenhelper.data.mappers.toDomain
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.CharacterClass
import javax.inject.Inject

class ClassRepository @Inject constructor(
    private val characterClassDao: CharacterClassDao
) {
    suspend fun getClassById(id: Int): CharacterClass = characterClassDao.findById(id).toDomain()

    suspend fun getAllClasses(): List<CharacterClass> =
        characterClassDao.getAll().map { it.toDomain() }

}