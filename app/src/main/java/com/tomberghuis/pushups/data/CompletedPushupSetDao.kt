package com.tomberghuis.pushups.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface CompletedPushupSetDao {


    // will this blend
    @Query("SELECT * FROM completed_pushup_sets order by id desc limit 1")
    //fun getLastPushupSet(): CompletedPushupSet?
    fun getLastPushupSet(): CompletedPushupSet

    @Insert
    fun insertPushupSet(pushupSet: CompletedPushupSet)

}
