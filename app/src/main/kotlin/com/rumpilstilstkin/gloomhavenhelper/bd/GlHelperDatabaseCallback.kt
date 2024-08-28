package com.rumpilstilstkin.gloomhavenhelper.bd

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.rumpilstilstkin.gloomhavenhelper.R
import com.rumpilstilstkin.gloomhavenhelper.bd.dao.CharacterClassDao
import com.rumpilstilstkin.gloomhavenhelper.bd.entity.CharacterClassBd
import com.rumpilstilstkin.gloomhavenhelper.di.ApplicationScope
import dagger.Lazy
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class GlHelperDatabaseCallback @Inject constructor(
    private val characterClassDao: Lazy<CharacterClassDao>,
    @ApplicationScope private val externalScope: CoroutineScope,
) : RoomDatabase.Callback() {
    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        externalScope.launch {
            characterClassDao.get().insertAll(
                CharacterClassBd(name = "Инокс, дикарь", image = R.drawable.br),
                CharacterClassBd(name = "Вермлинг, повелитель зверей", image = R.drawable.bt),
                CharacterClassBd(name = "Саввас, пустотелый ", image = R.drawable.ch),
                CharacterClassBd(name = "Орхид, обрекающий", image = R.drawable.ds),
                CharacterClassBd(name = "Саввас, элементалист", image = R.drawable.el),
                CharacterClassBd(name = "Куатрил,воспевающая", image = R.drawable.ss),
                CharacterClassBd(name = "Человек, костоправ", image = R.drawable.sb),
                CharacterClassBd(name = "Жнец, предвестник чумы", image = R.drawable.ph),
                CharacterClassBd(name = "Куатрил, изобретатель", image = R.drawable.ti),
                CharacterClassBd(name = "Эстер, покров ночи", image = R.drawable.ns),
                CharacterClassBd(name = "Орхид, плетущая чары", image = R.drawable.sw),
                CharacterClassBd(name = "Эстер, призывающая", image = R.drawable.su),
                CharacterClassBd(name = "Валрат, хранящая солнце", image = R.drawable.sk),
                CharacterClassBd(name = "Вермлинг, крадущая разум", image = R.drawable.mt),
                CharacterClassBd(name = "Валрат, хранящая солнце", image = R.drawable.sk),
                CharacterClassBd(name = "Человек, плутовка", image = R.drawable.sc),
                CharacterClassBd(name = "Валрат, интендант", image = R.drawable.qm),
                CharacterClassBd(name = "Эстрер, прорицательница", image = R.drawable.dr),
            )
        }
    }
}