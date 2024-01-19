package me.dungngminh.seenowcarouselplayground

import androidx.annotation.ColorInt
import java.util.UUID

data class Item(val id: String = UUID.randomUUID().toString())

sealed class Layout {
    data class TopTen(val items: List<Item>) : Layout()
    data class Others(val items: List<Item>) : Layout()
}