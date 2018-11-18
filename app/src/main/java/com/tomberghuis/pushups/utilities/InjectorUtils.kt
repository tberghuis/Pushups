package com.tomberghuis.pushups.utilities

import android.content.Context
import com.tomberghuis.pushups.data.AppDatabase
import com.tomberghuis.pushups.data.PushupSetRepository
import com.tomberghuis.pushups.viewmodels.MainViewModelFactory

object InjectorUtils {

    private fun getPushupSetRepository(context: Context): PushupSetRepository {
        return PushupSetRepository.getInstance(AppDatabase.getInstance(context).completedPushupSetDao())
    }
//
//    private fun getGardenPlantingRepository(context: Context): GardenPlantingRepository {
//        return GardenPlantingRepository.getInstance(
//            AppDatabase.getInstance(context).gardenPlantingDao())
//    }
//
//    fun provideGardenPlantingListViewModelFactory(
//        context: Context
//    ): GardenPlantingListViewModelFactory {
//        val repository = getGardenPlantingRepository(context)
//        return GardenPlantingListViewModelFactory(repository)
//    }
//
//    fun providePlantListViewModelFactory(context: Context): PlantListViewModelFactory {
//        val repository = getPlantRepository(context)
//        return PlantListViewModelFactory(repository)
//    }

    fun provideMainViewModelFactory(
        context: Context
    ): MainViewModelFactory {
        return MainViewModelFactory(getPushupSetRepository(context))
    }
}
