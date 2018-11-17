package com.tomberghuis.pushups.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "completed_pushup_sets")
data class CompletedPushupSet(
    // do i need default val = 0
    // should i use val instead of var?
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name = "num_pushups") var numPushups: Int,
                              // will it blend
    @ColumnInfo(name = "timestamp_completed_at") var timestampCompletedAt: Long = System.currentTimeMillis())


