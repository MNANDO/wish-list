package com.example.wishlist

class ListFetcher {
    companion object {
        var listItems: MutableList<Item> = ArrayList()
        var testItem = Item("Robot", 0.99, "abc")

        fun getItems(): MutableList<Item> {
            return listItems
        }

        fun addItem(item: Item) {
            listItems.add(item)
        }
    }
}