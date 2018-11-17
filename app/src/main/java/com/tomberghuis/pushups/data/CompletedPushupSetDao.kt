package com.tomberghuis.pushups.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface CompletedPushupSetDao {


    @Query("SELECT * FROM completed_pushup_sets order by id desc limit 1")
    // will this blend
    fun getLastPushupSet(): CompletedPushupSet

    @Insert
    fun insertPushupSet(pushupSet: CompletedPushupSet)

}
