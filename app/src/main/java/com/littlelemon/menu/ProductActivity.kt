package com.littlelemon.menu

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class ProductActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val productItemExtras = intent.extras
        if (productItemExtras != null) {
            val title = productItemExtras.getString(KEY_TITLE) ?: ""
            val price = productItemExtras.getDouble(KEY_PRICE)
            val category = productItemExtras.getString(KEY_CATEGORY) ?: ""
            val image = productItemExtras.getInt(KEY_IMAGE)

            val productItem = ProductItem(title, price, category, image)
            setContent { ProductDetails(productItem) }
        }

    }

    companion object {
        const val KEY_TITLE = "title"
        const val KEY_PRICE = "price"
        const val KEY_IMAGE = "image"
        const val KEY_CATEGORY = "category"

        fun newIntent(activity: MainActivity, productItem: ProductItem): Intent {
            val intent = Intent(activity, ProductActivity::class.java)
            intent.apply {
                putExtra(KEY_TITLE, productItem.title)
                putExtra(KEY_PRICE, productItem.price)
                putExtra(KEY_CATEGORY, productItem.category)
                putExtra(KEY_IMAGE, productItem.image)
            }
            return intent
        }
    }
}