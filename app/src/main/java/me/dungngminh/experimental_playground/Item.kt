package me.dungngminh.experimental_playground

import java.util.UUID

data class Item(val id: String = UUID.randomUUID().toString())

sealed class Layout {
    data class TinderCardSwiper(val items: List<Item>) : Layout()
    data class Others(val items: List<Item>) : Layout()
}