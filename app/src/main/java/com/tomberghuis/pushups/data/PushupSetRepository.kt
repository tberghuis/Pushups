package com.tomberghuis.pushups.data

import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread

class PushupSetRepository private constructor(private val pushupSetDao: CompletedPushupSetDao) {


    fun saveCompletedPushupSet(numPushups: Int) {
        thread {
            // wil it blend
            val pushupSet = CompletedPushupSet(numPushups = numPushups)
            pushupSetDao.insertPushupSet(pushupSet)
        }
    }

    suspend fun getLastPushupSet() = withContext(IO) {
        pushupSetDao.getLastPushupSet()
    }

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: PushupSetRepository? = null

        fun getInstance(pushupSetDao: CompletedPushupSetDao) =
            instance ?: synchronized(this) {
                instance ?: PushupSetRepository(pushupSetDao).also { instance = it }
            }
    }
}
