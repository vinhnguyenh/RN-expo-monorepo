package expo.modules.datasyncnativekotlin.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import expo.modules.datasyncnativekotlin.data.local.entities.UserEntity

@Dao
interface UserDao: BaseDao<UserEntity> {
    @Query("SELECT * FROM users LIMIT 1")
    suspend fun getCurrentUser(): UserEntity?
}

