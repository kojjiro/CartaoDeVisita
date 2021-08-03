package com.kojjiro.cartodevisitas.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BusinessCardRepository(private val dao: BusinessCardDao) {

    fun insert (BusinesCard: BusinessCard) = runBlocking {
        launch(Dispatchers.IO) {
            dao.insert(BusinesCard)
        }
    }

    fun getAll()=dao.getAll()

}