package com.cursosant.android.stores.mainModule.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.cursosant.android.stores.StoreApplication
import com.cursosant.android.stores.common.entities.StoreEntity
import com.cursosant.android.stores.common.utils.StoresException
import com.cursosant.android.stores.common.utils.TypeError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

/****
 * Project: Stores
 * From: com.cursosant.android.stores.mainModule.model
 * Created by Alain Nicolás Tello on 2/4/21 at 12:06 PM
 * Course: Android Practical with Kotlin from zero.
 * Only on: https://www.udemy.com/course/kotlin-intensivo/
 * All rights reserved 2021.
 *
 * All my Courses(Only on Udemy):
 * https://www.udemy.com/user/alain-nicolas-tello/
 ***/
class MainInteractor {
    // Como mejora, se ha implementado este método que nos facilitará el cambio de base de datos
    // de forma rápida mientras estamos desarrollando, así una vez mas el ViewModel y View no se ven
    // afectados, solo es el Model quien cambia para lo relacionado con los datos.
    /*fun getStores(callback: (MutableList<StoreEntity>) -> Unit){
        // isLocal nos ayuda a cambiar la fuente de donde consultemos los datos
        val isLocal = true
        if (isLocal){ // isLocal = true? Room
            getStoresRoom { storeList -> callback(storeList) }
        } else { // isLocal = false? API REST
            getStoresAPI { storeList -> callback(storeList) }
        }
    }*/

    /*fun getStoresAPI(callback: (MutableList<StoreEntity>) -> Unit){
        val url = Constants.STORES_URL + Constants.GET_ALL_PATH

        var storeList = mutableListOf<StoreEntity>()

        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null, { response ->

            val status = response.optInt(Constants.STATUS_PROPERTY, Constants.ERROR)
            Log.i("status", status.toString())

            if (status == Constants.SUCCESS){

                val jsonList = response.optJSONArray(Constants.STORES_PROPERTY)?.toString()
                if (jsonList != null) {
                    val mutableListType = object : TypeToken<MutableList<StoreEntity>>() {}.type
                    storeList = Gson().fromJson(jsonList, mutableListType)

                    callback(storeList)
                    return@JsonObjectRequest
                }
            }
            callback(storeList)
        },{
            it.printStackTrace()
            callback(storeList)
        })

        StoreApplication.storeAPI.addToRequestQueue(jsonObjectRequest)
    }*/

    /*fun getStoresRoom(callback: (MutableList<StoreEntity>) -> Unit){
        doAsync {
            val storeList = StoreApplication.database.storeDao().getAllStores()
            uiThread {
                val json = Gson().toJson(storeList)
                Log.i("Gson", json)
                callback(storeList)
            }
        }
    }*/

    val stores: LiveData<MutableList<StoreEntity>> = liveData {
        delay(1_000)
       val storesLivedata = StoreApplication.database.storeDao().getAllStores()
        emitSource(storesLivedata.map { stores ->
            stores.sortedBy { it.name }.toMutableList()
        })

    }

   suspend fun deleteStore(storeEntity: StoreEntity) = withContext(Dispatchers.IO){
       delay(1_500)
       //storeEntity.id = -1
       val result = StoreApplication.database.storeDao().deleteStore(storeEntity)
       if(result == 0) throw StoresException(TypeError.DELETE)

    }

    suspend fun updateStore(storeEntity: StoreEntity) =  withContext(Dispatchers.IO){
        delay(1_300)
        //storeEntity.id = -1
        val result = StoreApplication.database.storeDao().updateStore(storeEntity)
        if(result == 0) throw StoresException(TypeError.UPDATE)
    }
}