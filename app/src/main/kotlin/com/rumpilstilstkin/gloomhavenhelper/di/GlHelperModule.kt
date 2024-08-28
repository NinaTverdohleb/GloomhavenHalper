package com.rumpilstilstkin.gloomhavenhelper.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.rumpilstilstkin.gloomhavenhelper.bd.GlHelperDatabase
import com.rumpilstilstkin.gloomhavenhelper.bd.GlHelperDatabaseCallback
import com.rumpilstilstkin.gloomhavenhelper.bd.createGlHelperDatabase
import com.rumpilstilstkin.gloomhavenhelper.bd.dao.CharacterClassDao
import com.rumpilstilstkin.gloomhavenhelper.bd.dao.CharacterDao
import com.rumpilstilstkin.gloomhavenhelper.bd.dao.TeamDao
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GlHelperModule {

    @Provides
    fun providesSharedPreference(
        @ApplicationContext context: Context
    ): SharedPreferences =
        context.getSharedPreferences(
            "GlHelperPreferences", Context.MODE_PRIVATE
        )

    @Singleton
    @Provides
    fun provideYourDatabase(
        @ApplicationContext app: Context,
        databaseCallback: GlHelperDatabaseCallback
    ) = createGlHelperDatabase(app, databaseCallback)

    @Singleton
    @Provides
    fun provideCharacterDao(db: GlHelperDatabase): CharacterDao = db.characterDao()

    @Singleton
    @Provides
    fun provideTeamDao(db: GlHelperDatabase): TeamDao = db.TeamDao()

    @Singleton
    @Provides
    fun provideCharacterClassDao(db: GlHelperDatabase): CharacterClassDao = db.characterClassDao()
}