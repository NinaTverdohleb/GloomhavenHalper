package com.rumpilstilstkin.gloomhavenhelper.bd.migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

/**
 * This file contains all database migrations for the GlHelperDatabase.
 * 
 * When adding a new migration:
 * 1. Increment the database version in GlHelperDatabase.kt
 * 2. Create a new Migration object (e.g., MIGRATION_2_3 for migrating from version 2 to 3)
 * 3. Implement the migration logic in the migrate() method
 * 4. Add the new migration to the ALL_MIGRATIONS list
 * 5. Export the schema for the new version by building the project
 * 6. Test the migration thoroughly
 */

/**
 * Migration from version 1 to 2.
 * Adds monster management tables: MonsterBd, MonsterStatsBd, MonsterAbilityCardBd, ScenarioMonsterBd
 * Note: MonsterAbilityCardBd uses deckName to reference ability card decks.
 * Multiple monsters can share the same deck by having the same deckName.
 */
val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(db: SupportSQLiteDatabase) {
        // Create MonsterBd table with deckName for referencing ability card deck
        db.execSQL("""
            CREATE TABLE IF NOT EXISTS MonsterBd (
                monsterId INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                name TEXT NOT NULL,
                deckName TEXT NOT NULL
            )
        """)

        // Create MonsterStatsBd table
        db.execSQL("""
            CREATE TABLE IF NOT EXISTS MonsterStatsBd (
                monsterId INTEGER NOT NULL,
                scenarioLevel INTEGER NOT NULL,
                life INTEGER NOT NULL,
                isElite INTEGER NOT NULL,
                stats TEXT NOT NULL,
                PRIMARY KEY (monsterId, scenarioLevel, isElite),
                FOREIGN KEY (monsterId) REFERENCES MonsterBd(monsterId) ON DELETE CASCADE
            )
        """)
        db.execSQL("CREATE INDEX IF NOT EXISTS index_MonsterStatsBd_monsterId ON MonsterStatsBd(monsterId)")

        // Create MonsterAbilityCardBd table with deckName (no FK - multiple monsters can share same deck)
        db.execSQL("""
            CREATE TABLE IF NOT EXISTS MonsterAbilityCardBd (
                cardId INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                deckName TEXT NOT NULL,
                initiative INTEGER NOT NULL,
                actions TEXT NOT NULL,
                needsShuffle INTEGER NOT NULL DEFAULT 0
            )
        """)
        db.execSQL("CREATE INDEX IF NOT EXISTS index_MonsterAbilityCardBd_deckName ON MonsterAbilityCardBd(deckName)")

        // Create ScenarioMonsterBd table
        db.execSQL("""
            CREATE TABLE IF NOT EXISTS ScenarioMonsterBd (
                id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                scenarioNumber INTEGER NOT NULL,
                monsterId INTEGER NOT NULL,
                FOREIGN KEY (scenarioNumber) REFERENCES ScenarioBd(scenarioNumber) ON DELETE CASCADE,
                FOREIGN KEY (monsterId) REFERENCES MonsterBd(monsterId) ON DELETE CASCADE
            )
        """)
        db.execSQL("CREATE INDEX IF NOT EXISTS index_ScenarioMonsterBd_scenarioNumber ON ScenarioMonsterBd(scenarioNumber)")
        db.execSQL("CREATE INDEX IF NOT EXISTS index_ScenarioMonsterBd_monsterId ON ScenarioMonsterBd(monsterId)")
    }
}

/**
 * Migration from version 2 to 3.
 * Changes MonsterAbilityCardBd to use deckName instead of monsterId.
 * Adds deckName column to MonsterBd.
 * This allows multiple monsters to share the same ability card deck.
 */
val MIGRATION_2_3 = object : Migration(2, 3) {
    override fun migrate(db: SupportSQLiteDatabase) {
        // Add deckName column to MonsterBd (default to monster name as deck name)
        db.execSQL("ALTER TABLE MonsterBd ADD COLUMN deckName TEXT NOT NULL DEFAULT ''")
        db.execSQL("UPDATE MonsterBd SET deckName = name")

        // Recreate MonsterAbilityCardBd with deckName instead of monsterId
        // 1. Create new table
        db.execSQL("""
            CREATE TABLE IF NOT EXISTS MonsterAbilityCardBd_new (
                cardId INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                deckName TEXT NOT NULL,
                initiative INTEGER NOT NULL,
                actions TEXT NOT NULL,
                needsShuffle INTEGER NOT NULL DEFAULT 0
            )
        """)

        // 2. Copy data with deckName from MonsterBd
        db.execSQL("""
            INSERT INTO MonsterAbilityCardBd_new (cardId, deckName, initiative, actions, needsShuffle)
            SELECT c.cardId, m.name, c.initiative, c.actions, c.needsShuffle
            FROM MonsterAbilityCardBd c
            INNER JOIN MonsterBd m ON c.monsterId = m.monsterId
        """)

        // 3. Drop old table and rename new one
        db.execSQL("DROP TABLE MonsterAbilityCardBd")
        db.execSQL("ALTER TABLE MonsterAbilityCardBd_new RENAME TO MonsterAbilityCardBd")

        // 4. Create index on deckName
        db.execSQL("CREATE INDEX IF NOT EXISTS index_MonsterAbilityCardBd_deckName ON MonsterAbilityCardBd(deckName)")
    }
}

/**
 * List of all migrations to be applied to the database.
 * Add new migrations to this list as they are created.
 */
val ALL_MIGRATIONS = arrayOf<Migration>(
    MIGRATION_1_2,
    MIGRATION_2_3,
)