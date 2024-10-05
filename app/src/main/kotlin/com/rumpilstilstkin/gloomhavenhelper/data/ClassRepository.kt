package com.rumpilstilstkin.gloomhavenhelper.data

import com.rumpilstilstkin.gloomhavenhelper.bd.dao.CharacterClassDao
import com.rumpilstilstkin.gloomhavenhelper.data.mappers.toDomain
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.CharacterClass
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.CharacterClassType
import javax.inject.Inject

class ClassRepository @Inject constructor(
    private val characterClassDao: CharacterClassDao
) {
    suspend fun getClassByType(type: CharacterClassType): CharacterClass = characterClassDao.findByType(type.name).toDomain()

    suspend fun getAllClasses(): List<CharacterClass> =
        characterClassDao.getAll().map { it.toDomain() }

}