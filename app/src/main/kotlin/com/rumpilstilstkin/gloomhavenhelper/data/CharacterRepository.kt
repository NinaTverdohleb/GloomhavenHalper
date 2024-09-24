package com.rumpilstilstkin.gloomhavenhelper.data

import com.rumpilstilstkin.gloomhavenhelper.bd.dao.CharacterClassDao
import com.rumpilstilstkin.gloomhavenhelper.bd.dao.CharacterDao
import com.rumpilstilstkin.gloomhavenhelper.data.mappers.toBd
import com.rumpilstilstkin.gloomhavenhelper.data.mappers.toDomain
import com.rumpilstilstkin.gloomhavenhelper.data.mappers.toShortDomain
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.CharacterForSave
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.CharacterInfo
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.CharacterShortInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val characterDao: CharacterDao,
    private val classDao: CharacterClassDao
) {
    fun getCharacterByTeamId(teamId: Int): Flow<List<CharacterInfo>> =
        characterDao.findByTeamIdFlow(teamId).map { list ->
            list.map {
                val classBd = classDao.findById(it.classId)
                it.toDomain(classBd)
            }
        }

    fun getCharacterByIdFlow(id: Int): Flow<CharacterInfo> =
        characterDao.getCharacterByIdFlow(id).map { it.toDomain(classDao.findById(it.classId)) }

    suspend fun getCharacterById(id: Int): CharacterShortInfo = characterDao.getCharacterById(id).toShortDomain()

    suspend fun addCharacter(character: CharacterForSave, teamId: Int? = null) {
        characterDao.insert(character.toBd(teamId))
    }

    suspend fun deleteCharacter(id: Int) {
        characterDao.deleteById(id)
    }

    suspend fun updateLevel(id: Int, level: Int) {
        characterDao.getCharacterById(id).let {
            characterDao.update(it.copy(level = level))
        }
    }

    suspend fun updateNotes(id: Int, notes: String) {
        characterDao.getCharacterById(id).let {
            characterDao.update(it.copy(notes = notes))
        }
    }

    suspend fun updateCheckMarks(id: Int, checkMarks: Int) {
        characterDao.getCharacterById(id).let {
            characterDao.update(it.copy(checkMarkCount = checkMarks))
        }
    }

    suspend fun updateExperience(id: Int, experience: Int) {
        characterDao.getCharacterById(id).let {
            characterDao.update(it.copy(experience = experience))
        }
    }

    suspend fun updateGold(id: Int, gold: Int) {
        characterDao.getCharacterById(id).let {
            characterDao.update(it.copy(goldCount = gold))
        }
    }

    suspend fun leaveCharacter(id: Int) {
        characterDao.getCharacterById(id).let {
            characterDao.update(it.copy(isAlive = false))
        }
    }

    fun getAllCharacters(): Flow<List<CharacterInfo>> =
        characterDao.getAllCharacters().map { list ->
            list.map {
                val classBd = classDao.findById(it.classId)
                it.toDomain(classBd)
            }
        }
}