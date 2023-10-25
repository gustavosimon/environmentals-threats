package br.com.simon.environmentthreats

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns._ID
import java.time.LocalDateTime
import java.util.Optional

const val TABLE_NAME: String = "environment_threats"
const val COLUMN_ADDRESS: String = "address"
const val COLUMN_DATE: String = "date"
const val COLUMN_DESCRIPTION: String = "description"

class EnvironmentThreatSQLiteDatabase {

    private val db: SQLiteDatabase

    constructor(context: Context) {
        db = EnvironmentThreatSQLiteDatabaseHelper(context).writableDatabase
    }

    fun addEnvironmentThreat(environmentThreat: EnvironmentThreat): Long {
        val contentValues: ContentValues = ContentValues()
        contentValues.put(COLUMN_ADDRESS, environmentThreat.address)
        contentValues.put(COLUMN_DATE, environmentThreat.date.toString())
        contentValues.put(COLUMN_DESCRIPTION, environmentThreat.description)
        return db.insert(TABLE_NAME, null, contentValues)
    }

    @SuppressLint("Range")
    fun getEnvironmentThreat(id: Long): Optional<EnvironmentThreat> {
        val columns = arrayOf<String>(
            _ID,
            COLUMN_ADDRESS,
            COLUMN_DATE,
            COLUMN_DESCRIPTION
        )
        val args = arrayOf<String>(
            id.toString()
        )

        val cursor: Cursor = db.query(TABLE_NAME, columns, "$_ID=?", args, null, null, _ID)

        if (cursor.count != 1) {
            return Optional.empty()
        }

        cursor.moveToNext()

        val id = cursor.getLong(cursor.getColumnIndex(_ID))
        val address = cursor.getString(cursor.getColumnIndex(COLUMN_ADDRESS))
        val date = LocalDateTime.parse(cursor.getString(cursor.getColumnIndex(COLUMN_DATE)))
        val description = cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION))

        return Optional.of(EnvironmentThreat(id, address, date, description))
    }

}

class EnvironmentThreatsTable {

    fun getSQL(): String {
        return "CREATE TABLE $TABLE_NAME ($_ID INTEGER PRIMARY KEY, $COLUMN_ADDRESS TEXT, $COLUMN_DATE TEXT, $COLUMN_DESCRIPTION TEXT)"
    }

}

class EnvironmentThreatSQLiteDatabaseHelper(private val context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(EnvironmentThreatsTable().getSQL())
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME");
        onCreate(db);
    }

    companion object {
        private const val DATABASE_NAME = "threats.db"
        private const val DATABASE_VERSION = 1
    }
}



