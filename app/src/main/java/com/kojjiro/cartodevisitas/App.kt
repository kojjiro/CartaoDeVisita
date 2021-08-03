package com.kojjiro.cartodevisitas

import android.app.Application
import com.kojjiro.cartodevisitas.data.AppDatabase
import com.kojjiro.cartodevisitas.data.BusinessCardRepository

class App : Application() {

    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }

}