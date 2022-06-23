package com.example.productgallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ProductGalleryActivity : AppCompatActivity() {
    companion object {
        var isProductListPage = false
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_gallery)
        if(savedInstanceState == null) {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            val categoriesFragment = CategoriesFragment()
            fragmentTransaction.add(R.id.fragment_container_gallery, categoriesFragment)
            fragmentTransaction.commit()
        }
    }

    override fun onBackPressed() {
        if(isProductListPage) {
            ProductListFragment.products.clear()
        }
        super.onBackPressed()
    }
}