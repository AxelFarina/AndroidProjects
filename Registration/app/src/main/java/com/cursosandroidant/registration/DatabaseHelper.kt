package com.cursosandroidant.registration

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context): SQLiteOpenHelper(context,Constants.DATABASE_NAME,
    null,Constants.DATABASE_VERSION ) {

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE ${Constants.ENTITY_REGISTER}(" +
                "${Constants.PROPERTY_ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "${Constants.PROPERTY_NAME} VARCHAR(50)," +
                "${Constants.PROPERTY_USERNAME} VARCHAR(50)," +
                "${Constants.PROPERTY_DATE} DATE," +
                "${Constants.PROPERTY_PHONE} VARCHAR(20)," +
                "${Constants.PROPERTY_PASSWORD} VARCHAR(30))"

        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insertRegister(register: Register): Long{

        val database = this.writableDatabase
        val contentValues = ContentValues().apply {
            put(Constants.PROPERTY_NAME, register.name)
            put(Constants.PROPERTY_NAME, register.username)
            put(Constants.PROPERTY_NAME, register.date)
            put(Constants.PROPERTY_NAME, register.phone)
            put(Constants.PROPERTY_NAME, register.password)
        }

        val resultId = database.insert(Constants.ENTITY_REGISTER, null, contentValues)
        return resultId
    }
}