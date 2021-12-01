package com.triare.p101_recycler_view

import android.content.Context
import com.triare.p101_recycler_view.Chat
import com.slmyldz.random.Randoms
import kotlin.random.Random

object ChatStorage {

    fun random(context: Context) = MutableList(10000) {
        Chat(
            it,
            Randoms.imageUrl(1024, 1024),
            DummyNameStorage.random(),
            Randoms.sentence(context),
            "10:45 PM",
            Random.nextBoolean()
        )
    }

}