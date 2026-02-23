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
 * Example migration from version 1 to 2.
 * This is a placeholder for the first migration that will be needed in the future.
 * Uncomment and modify when needed.
 */
/*
val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        // Example migration operations:
        // - Add a new column: database.execSQL("ALTER TABLE TableName ADD COLUMN column_name TEXT NOT NULL DEFAULT ''")
        // - Create a new table: database.execSQL("CREATE TABLE IF NOT EXISTS NewTable (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL)")
        // - Rename a table: database.execSQL("ALTER TABLE OldTableName RENAME TO NewTableName")
        // - Delete a table: database.execSQL("DROP TABLE IF EXISTS TableName")
    }
}
*/

/**
 * List of all migrations to be applied to the database.
 * Add new migrations to this list as they are created.
 */
val ALL_MIGRATIONS = arrayOf<Migration>(
    // Add migrations here as they are created
    // MIGRATION_1_2,
    // MIGRATION_2_3,
    // etc.
)