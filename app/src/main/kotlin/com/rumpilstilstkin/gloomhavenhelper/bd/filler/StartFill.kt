package com.rumpilstilstkin.gloomhavenhelper.bd.filler

import com.rumpilstilstkin.gloomhavenhelper.bd.dao.GameLevelInfoDao
import com.rumpilstilstkin.gloomhavenhelper.bd.entity.GameLevelInfoBd

object GameLevelInfoFiller {

    suspend fun fill_v1(
        gameLevelInfoDao: GameLevelInfoDao
    ) {
        gameLevelInfoDao.insertAll(
            GameLevelInfoBd(
                level = 0,
                monsterLevel = 0,
                goldCount = 2,
                trapDamage = 2,
                experience = 4
            ),
            GameLevelInfoBd(
                level = 1,
                monsterLevel = 1,
                goldCount = 2,
                trapDamage = 3,
                experience = 6
            ),
            GameLevelInfoBd(
                level = 2,
                monsterLevel = 2,
                goldCount = 3,
                trapDamage = 4,
                experience = 8
            ),
            GameLevelInfoBd(
                level = 3,
                monsterLevel = 3,
                goldCount = 3,
                trapDamage = 5,
                experience = 10
            ),
            GameLevelInfoBd(
                level = 4,
                monsterLevel = 4,
                goldCount = 4,
                trapDamage = 6,
                experience = 12
            ),
            GameLevelInfoBd(
                level = 5,
                monsterLevel = 5,
                goldCount = 4,
                trapDamage = 7,
                experience = 14
            ),
            GameLevelInfoBd(
                level = 6,
                monsterLevel = 6,
                goldCount = 5,
                trapDamage = 8,
                experience = 16
            ),
            GameLevelInfoBd(
                level = 7,
                monsterLevel = 7,
                goldCount = 6,
                trapDamage = 9,
                experience = 18
            )
        )

    }

}