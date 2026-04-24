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
            val title = productItemExtras.getString("title") ?: ""
            val price = productItemExtras.getDouble("price")
            val category = productItemExtras.getString("category") ?: ""
            val image = productItemExtras.getInt("image")

            val productItem = ProductItem(title, price, category, image)
            setContent { ProductDetails(productItem) }
        }

    }

    companion object {
        fun newIntent(activity: MainActivity, productItem: ProductItem): Intent {
            val intent = Intent(activity, ProductActivity::class.java)
            intent.apply {
                putExtra("title", productItem.title)
                putExtra("price", productItem.price)
                putExtra("category", productItem.category)
                putExtra("image", productItem.image)
            }
            return intent
        }
    }
}