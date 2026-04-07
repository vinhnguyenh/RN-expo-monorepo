package expo.modules.datasyncnativekotlin.sdk.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sync_queue")
data class SyncQueueEntity(
    @PrimaryKey(autoGenerate = true) val queueId: Long = 0,
    val entityId: String,
    val eventId: String,
    val deviceId: String,
    val sessionId: String,
    val eventType: String,
    val occurredAt: String,
    val retryCount: Int = 0,
    // payload will contain object need to be sync.
//    val payload: Any? = null

)