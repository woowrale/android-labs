package com.woowrale.kroomapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.woowrale.kroomapp.data.database.model.ContactEntity

@Database(entities = [ContactEntity::class], version = 1)
abstract class ContactDatabase : RoomDatabase() {

    companion object {
        fun build(context: Context) = Room.databaseBuilder(
                context,
                ContactDatabase::class.java,
                "contacts-db")
                .build()
    }

    abstract fun contactDao(): ContactDao
}