package kg.varis.lovecalculator.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import kg.varis.lovecalculator.model.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun dao(): LoveDao
}