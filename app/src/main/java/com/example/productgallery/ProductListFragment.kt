package com.example.productgallery

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProductListFragment : Fragment(), RecyclerViewInterface {
    companion object {
        var products: ArrayList<Product> = arrayListOf()
    }
    lateinit var productAdapter: ProductAdapter
    lateinit var productCategory: ProductCategory
    var men_fashion_images = arrayListOf(R.drawable.shirt1,
        R.drawable.shirt2,
        R.drawable.shirt3,
        R.drawable.shirt4,
        R.drawable.shirt5,
        R.drawable.shirt6,
        R.drawable.shirt7,
        R.drawable.shirt8,
        R.drawable.shirt9,
        R.drawable.shirt10)
    var women_fashion_images = arrayListOf(R.drawable.women1, R.drawable.women2, R.drawable.women2, R.drawable.women4, R.drawable.women5, R.drawable.women6, R.drawable.women7, R.drawable.women8, R.drawable.women9, R.drawable.women10)
    var kids_fashion_images = arrayListOf(R.drawable.kids1,R.drawable.kids2, R.drawable.kids3, R.drawable.kids4, R.drawable.kids5, R.drawable.kids6, R.drawable.kids7, R.drawable.kids8, R.drawable.kids9, R.drawable.kids10)
    var cosmetics = arrayListOf(R.drawable.cos1, R.drawable.cos2,R.drawable.cos3,R.drawable.cos4,R.drawable.cos5,R.drawable.cos6,R.drawable.cos7,R.drawable.cos8,R.drawable.cos9)
    var jewels = arrayListOf(R.drawable.jew1, R.drawable.jew2, R.drawable.jew3, R.drawable.jew4, R.drawable.jew5, R.drawable.jew6, R.drawable.jew7, R.drawable.jew8, R.drawable.jew9, R.drawable.jew10)
    var electronics = arrayListOf(R.drawable.ele1, R.drawable.ele2, R.drawable.ele3, R.drawable.ele4, R.drawable.ele5, R.drawable.ele6, R.drawable.ele7, R.drawable.ele8, R.drawable.ele9, R.drawable.ele10)
    var home_needs = arrayListOf(R.drawable.home1, R.drawable.home2, R.drawable.home3, R.drawable.home4, R.drawable.home5)
    var leathers = arrayListOf(R.drawable.lea1, R.drawable.lea2, R.drawable.lea3, R.drawable.lea4, R.drawable.lea5)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        ProductGalleryActivity.isProductListPage = true
        productCategory = ProductCategory.valueOf(arguments?.getString("category").toString())
        var view = inflater.inflate(R.layout.fragment_product_list, container, false)
        var recyclerView: RecyclerView = view.findViewById(R.id.product_list_recyclerView)
        setProducts()
        productAdapter = ProductAdapter(products, this)
        recyclerView.adapter = productAdapter
        recyclerView.layoutManager = GridLayoutManager(activity,2)
        productAdapter.notifyDataSetChanged()
        return view
    }

    override fun onItemClick(position: Int) {
        val clickedValue: Int = products.get(position).productNumber
        passProduct(clickedValue)
    }
    private fun setProducts() {
        val resolver = requireActivity().contentResolver.query(DatabaseProvider.CONTENT_URI,
            arrayOf(DatabaseProvider.ID,
                DatabaseProvider.PRODUCT_NAME,
                DatabaseProvider.PRODUCT_BRAND,
                DatabaseProvider.PRODUCT_PRICE,
                DatabaseProvider.PRODUCT_QUANTITY,
                DatabaseProvider.PRODUCT_DESCRIPTION,
                DatabaseProvider.PRODUCT_DISCOUNT,
                DatabaseProvider.PRODUCT_CATEGORY),
            "CATEGORY = '$productCategory'",
            null,
            null)
        var item = 0
        if (productCategory == ProductCategory.MEN_FASHION) {
            while (item < 10) {
                if (resolver?.moveToNext()!!) {
                    products.add(Product(resolver.getString(0).toInt(),
                        resolver.getString(1),
                        resolver.getString(2),
                        resolver.getString(3).toDouble(),
                        resolver.getString(4).toInt(),
                        resolver.getString(5),
                        resolver.getString(6).toInt(),
                        resolver.getString(7),
                        men_fashion_images[item]))
                }
                item++
            }
        }

        if (productCategory == ProductCategory.WOMEN_FASHION) {
            while (item < 10) {
                if (resolver?.moveToNext()!!) {
                    products.add(Product(resolver.getString(0).toInt(),
                        resolver.getString(1),
                        resolver.getString(2),
                        resolver.getString(3).toDouble(),
                        resolver.getString(4).toInt(),
                        resolver.getString(5),
                        resolver.getString(6).toInt(),
                        resolver.getString(7),
                        women_fashion_images[item]))
                }
                item++
            }
        }

        if (productCategory == ProductCategory.KIDS_FASHION) {
            while (item < 10) {
                if (resolver?.moveToNext()!!) {
                    products.add(Product(resolver.getString(0).toInt(),
                        resolver.getString(1),
                        resolver.getString(2),
                        resolver.getString(3).toDouble(),
                        resolver.getString(4).toInt(),
                        resolver.getString(5),
                        resolver.getString(6).toInt(),
                        resolver.getString(7),
                        kids_fashion_images[item]))
                }
                item++
            }
        }

        if (productCategory == ProductCategory.COSMETICS) {
            while (item < 10) {
                if (resolver?.moveToNext()!!) {
                    products.add(Product(resolver.getString(0).toInt(),
                        resolver.getString(1),
                        resolver.getString(2),
                        resolver.getString(3).toDouble(),
                        resolver.getString(4).toInt(),
                        resolver.getString(5),
                        resolver.getString(6).toInt(),
                        resolver.getString(7),
                        cosmetics[item]))
                }
                item++
            }
        }

        if (productCategory == ProductCategory.ELECTRONICS) {
            while (item < 10) {
                if (resolver?.moveToNext()!!) {
                    products.add(Product(resolver.getString(0).toInt(),
                        resolver.getString(1),
                        resolver.getString(2),
                        resolver.getString(3).toDouble(),
                        resolver.getString(4).toInt(),
                        resolver.getString(5),
                        resolver.getString(6).toInt(),
                        resolver.getString(7),
                        electronics[item]))
                }
                item++
            }
        }

        if (productCategory == ProductCategory.JEWELS) {
            while (item < 10) {
                if (resolver?.moveToNext()!!) {
                    products.add(Product(resolver.getString(0).toInt(),
                        resolver.getString(1),
                        resolver.getString(2),
                        resolver.getString(3).toDouble(),
                        resolver.getString(4).toInt(),
                        resolver.getString(5),
                        resolver.getString(6).toInt(),
                        resolver.getString(7),
                        jewels[item]))
                }
                item++
            }
        }

        if (productCategory == ProductCategory.LEATHER) {
            while (item < 5) {
                if (resolver?.moveToNext()!!) {
                    products.add(Product(resolver.getString(0).toInt(),
                        resolver.getString(1),
                        resolver.getString(2),
                        resolver.getString(3).toDouble(),
                        resolver.getString(4).toInt(),
                        resolver.getString(5),
                        resolver.getString(6).toInt(),
                        resolver.getString(7),
                        leathers[item]))
                }
                item++
            }
        }

        if (productCategory == ProductCategory.HOME_NEEDS) {
            while (item < 5) {
                if (resolver?.moveToNext()!!) {
                    products.add(Product(resolver.getString(0).toInt(),
                        resolver.getString(1),
                        resolver.getString(2),
                        resolver.getString(3).toDouble(),
                        resolver.getString(4).toInt(),
                        resolver.getString(5),
                        resolver.getString(6).toInt(),
                        resolver.getString(7),
                        home_needs[item]))
                }
                item++
            }
        }


    }
    fun passProduct(productNumber: Int) {
        val bundle = Bundle()
        bundle.putInt("productNumber", productNumber)
        val transaction = parentFragmentManager.beginTransaction()
        val productDescriptionFragment = ProductDescriptionFragment()
        productDescriptionFragment.arguments = bundle
        transaction.replace(R.id.fragment_container_gallery, productDescriptionFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}