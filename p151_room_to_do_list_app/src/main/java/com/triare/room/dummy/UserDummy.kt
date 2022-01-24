package com.triare.room.dummy

import com.triare.room.data.db.model.UserDbo
import kotlin.random.Random

object UserDummy {

    fun randomUser(): UserDbo {
        return UserDbo(
            firstName = "Джейк" + Random.nextInt(100),
            lastName = "Джилленгол" + Random.nextInt(100),
            age = Random.nextInt(80),
            phone = "+380975217" + Random.nextInt(100, 300)
        )
    }
}