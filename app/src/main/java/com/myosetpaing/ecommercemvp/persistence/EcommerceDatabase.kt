package com.myosetpaing.ecommercemvp.persistence

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import android.content.Context
import com.myosetpaing.ecommercemvp.data.vos.CategoryVO
import com.myosetpaing.ecommercemvp.data.vos.LoginUserVO
import com.myosetpaing.ecommercemvp.data.vos.ProductVO
import com.myosetpaing.ecommercemvp.persistence.dao.CategoryDao
import com.myosetpaing.ecommercemvp.persistence.dao.HistoryDao
import com.myosetpaing.ecommercemvp.persistence.dao.LoginDao
import com.myosetpaing.ecommercemvp.persistence.dao.ProductDao
import com.myosetpaing.ecommercemvp.persistence.entities.HistoryTable
import com.myosetpaing.ecommercemvp.persistence.entities.ProductTable
import com.myosetpaing.ecommercemvp.persistence.typeconverters.CategoryListConverter
import com.myosetpaing.ecommercemvp.persistence.typeconverters.DateConverter
import com.myosetpaing.ecommercemvp.persistence.typeconverters.ProductImageUrlTypeConverter


@Database(
    entities = [ProductVO::class, CategoryVO::class, LoginUserVO::class, HistoryTable::class, ProductTable::class],
    version = 5,
    exportSchema = false
)
@TypeConverters(CategoryListConverter::class, ProductImageUrlTypeConverter::class, DateConverter::class)
abstract class EcommerceDatabase : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao
    abstract fun productDao(): ProductDao
    abstract fun loginDao(): LoginDao
    abstract fun historyDao(): HistoryDao

    companion object {
        private val DB_NAME = "EcommerceMVP.DB"
        private lateinit var INSTANCE: EcommerceDatabase
        fun getDatabase(context: Context): EcommerceDatabase {
            INSTANCE = Room.databaseBuilder(context, EcommerceDatabase::class.java, DB_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()// Remove this after testing. Access to DB should always be from background thread.
                .build()
            return INSTANCE
        }
    }

    fun isCategoryAvailable(): Boolean {
        val count = categoryDao().getCategoryCount()
        if (count > 0) {
            return true
        }
        return false
    }

    fun isUserLogin(): Boolean {

        val count = loginDao().getUserCount()
        if (count > 0) {
            return true
        }
        return false
    }
}