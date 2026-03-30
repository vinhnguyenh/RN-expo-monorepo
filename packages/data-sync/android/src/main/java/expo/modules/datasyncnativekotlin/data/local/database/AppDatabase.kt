package expo.modules.datasyncnativekotlin.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import expo.modules.datasyncnativekotlin.data.local.SyncQueueDao
import expo.modules.datasyncnativekotlin.data.local.SyncQueueEntity
import expo.modules.datasyncnativekotlin.data.local.dao.UserDao
import expo.modules.datasyncnativekotlin.data.local.entities.UserEntity

@Database(entities = [UserEntity::class, SyncQueueEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun syncQueueDao(): SyncQueueDao
//
//    companion object {
//        fun build(context: Context, passphrase: ByteArray): AppDatabase {
//            val factory = SupportOpenHelperFactory(passphrase)
//            return Room.databaseBuilder(context, AppDatabase::class.java, "baby_secure.db")
//                .openHelperFactory(factory)
//                .build()
//        }
//    }
}