package com.tomberghuis.pushups.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity
data class CompletedPushupSet(@PrimaryKey(autoGenerate = true) var id: Int = 0,
                var numPushups: Int,
                              // will it blend
                var timestampCompletedAt: Long = System.currentTimeMillis())