package com.littlelemon.menu

import org.junit.Test

class FilterHelperTest {

    private val sampleProductsList = mutableListOf(
        ProductItem(title = "Black tea", price = 3.00, category = "Drinks", R.drawable.black_tea),
        ProductItem(title = "Croissant", price = 7.00, category = "Dessert", R.drawable.croissant),
        ProductItem(title = "Bouillabaisse", price = 20.00, category = "Food", R.drawable.bouillabaisse)
    )

    @Test
    fun filterProducts_filterTypeDessert_croissantReturned() {
        val filteredList = FilterHelper().filterProducts(FilterType.Dessert, sampleProductsList)
        assert(filteredList.size == 1)
        assert(filteredList[0].title == "Croissant")
    }

    private val sampleProductsList2 = listOf(
        ProductItem("Black tea", 3.00, "Drinks", R.drawable.black_tea),
        ProductItem("Green tea", 3.00, "Drinks", R.drawable.green_tea),
        ProductItem("Espresso", 5.00, "Drinks", R.drawable.espresso),
        ProductItem("Cappuccino", 8.00, "Drinks", R.drawable.cappuccino),
        ProductItem("Latte", 8.00, "Drinks", R.drawable.latte),

        ProductItem("Boeuf bourguignon", 15.00, "Food", R.drawable.boeuf_bourguignon),
        ProductItem("Bouillabaisse", 20.00, "Food", R.drawable.bouillabaisse),
        ProductItem("Lasagna", 15.00, "Food", R.drawable.lasagna),
        ProductItem("Onion soup", 12.00, "Food", R.drawable.onion_soup),
        ProductItem("Salmon en papillote", 25.00, "Food", R.drawable.salmon_en_papillote),

        ProductItem("Quiche Lorraine", 17.00, "Dessert", R.drawable.quiche_lorraine),
        ProductItem("Custard tart", 14.00, "Dessert", R.drawable.custard_tart),
        ProductItem("Croissant", 7.00, "Dessert", R.drawable.croissant),
    )

    @Test
    fun filterProductsByAll(): Unit {
        val filteredList = FilterHelper().filterProducts(FilterType.All, sampleProductsList2)
        assert(filteredList == sampleProductsList2)
    }

    @Test
    fun filterProductsByDessert() {
        val filteredList = FilterHelper().filterProducts(FilterType.Dessert, sampleProductsList2)
        assert(filteredList.size == 3)
    }

    @Test
    fun filterProductsByDrinks() {
        val filteredList = FilterHelper().filterProducts(FilterType.Drinks, sampleProductsList2)
        assert(filteredList.size == 5)
    }

    @Test
    fun filterProductsByFood() {
        val filteredList = FilterHelper().filterProducts(FilterType.Food, sampleProductsList2)
        assert(filteredList.size == 5)
    }

    @Test
    fun filterProductsOnEmptyList() {
        val filteredList = FilterHelper().filterProducts(FilterType.All, emptyList())
        assert(filteredList.isEmpty())
    }
}