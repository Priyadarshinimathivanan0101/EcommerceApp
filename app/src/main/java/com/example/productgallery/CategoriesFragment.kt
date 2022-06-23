package com.example.productgallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.productgallery.databinding.FragmentCategoriesBinding

class CategoriesFragment : Fragment() {
    private var _binding: FragmentCategoriesBinding? = null
    private val binding get()= _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        binding.menFashionButton.setOnClickListener {
            passCategory(ProductCategory.MEN_FASHION)
        }
        binding.womenFashionButton.setOnClickListener {
            passCategory(ProductCategory.WOMEN_FASHION)
        }
        binding.kidsFashionButton.setOnClickListener {
            passCategory((ProductCategory.KIDS_FASHION))
        }
        binding.cosmeticsButton.setOnClickListener {
            passCategory(ProductCategory.COSMETICS)
        }
        binding.electronicsButton.setOnClickListener {
            passCategory(ProductCategory.ELECTRONICS)
        }
        binding.jewelsButton.setOnClickListener {
            passCategory(ProductCategory.JEWELS)
        }
        binding.leatherButton.setOnClickListener {
            passCategory(ProductCategory.LEATHER)
        }
        binding.homeNeedButton.setOnClickListener {
            passCategory(ProductCategory.HOME_NEEDS)
        }
        return binding.root
    }
    fun passCategory(category: ProductCategory) {

        val bundle = Bundle()
        bundle.putString("category", category.toString())
        val transaction = parentFragmentManager.beginTransaction()
        val productListFragment = ProductListFragment()
        productListFragment.arguments = bundle
        transaction.replace(R.id.fragment_container_gallery, productListFragment )
        transaction.addToBackStack(null)
        transaction.commit()
    }

}