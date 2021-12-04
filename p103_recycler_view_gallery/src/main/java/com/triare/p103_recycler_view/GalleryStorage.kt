package com.triare.p103_recycler_view

import android.content.Context
import com.triare.p103_recycler_view.ImageLine
import kotlin.random.Random
import com.slmyldz.random.Randoms

object GalleryStorage {

fun getRandom(context: Context) = MutableList(100) {
        ImageLine(
            it,
            Randoms.imageUrl(1024, 1024),
            Randoms.imageUrl(1024, 1024),
            Randoms.imageUrl(1024, 1024)
        )
    }
}