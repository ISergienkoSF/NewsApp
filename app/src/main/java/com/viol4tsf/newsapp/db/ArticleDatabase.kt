package com.viol4tsf.newsapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.viol4tsf.newsapp.models.Article

@Database(
    entities = [Article::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class ArticleDatabase : RoomDatabase() {

    abstract fun getArticleDao(): ArticleDao

    companion object{
        //для синглтона БД
        @Volatile
        private var instance: ArticleDatabase? = null
        //переменная блокировки
        private val LOCK = Any()

        //функция, вызываемая при создании экземпляра БД
        //код внутри не может быть доступен другим потокам одновременно
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance = it}
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDatabase::class.java,
                "article-db.db"
            ).build()
    }
}