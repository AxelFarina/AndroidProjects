package com.cursosandroidant.stores

interface MainAux {
    fun hideFab(isVisible: Boolean = false)
    fun addStore(storeEntity: StoreEntity)
    fun updateStore(storeEntity: StoreEntity)
}