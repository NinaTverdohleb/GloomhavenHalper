package com.rumpilstilstkin.gloomhavenhelper.bd

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.rumpilstilstkin.gloomhavenhelper.bd.dao.CharacterClassDao
import com.rumpilstilstkin.gloomhavenhelper.bd.dao.CharacterDao
import com.rumpilstilstkin.gloomhavenhelper.bd.dao.TeamDao
import com.rumpilstilstkin.gloomhavenhelper.bd.entity.CharacterBd
import com.rumpilstilstkin.gloomhavenhelper.bd.entity.CharacterClassBd
import com.rumpilstilstkin.gloomhavenhelper.bd.entity.TeamBd

@Database(
    entities = [
        TeamBd::class,
        CharacterClassBd::class,
        CharacterBd::class
    ],
    version = 1
)
abstract class GlHelperDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
    abstract fun characterClassDao(): CharacterClassDao
    abstract fun TeamDao(): TeamDao
}

fun createGlHelperDatabase(
    context: Context,
    databaseCallback: GlHelperDatabaseCallback
): GlHelperDatabase {
    val database =  Room.databaseBuilder(
        context,
        GlHelperDatabase::class.java,
        DATABASE_NAME
    ).addCallback(databaseCallback).build()

    return database
}

private const val DATABASE_NAME = "glHelperDatabase"

