package com.example.productgallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.productgallery.databinding.FragmentProductDescriptionBinding

class ProductDescriptionFragment : Fragment() {
    private var _binding: FragmentProductDescriptionBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        var product: Product
        _binding = FragmentProductDescriptionBinding.inflate(inflater, container, false)
        var productId = (arguments?.getInt("productNumber"))
        binding.name.setText("$productId")
        if (productId != null) {
            for(product in ProductListFragment.products) {
                if (product.productNumber == productId) {
                    binding.name.setText(product.productName)
                    binding.brand.setText(product.productBrand)
                    binding.image.setImageResource(product.image)
                    binding.description.setText(product.productDescription)
                    binding.price.setText("Rs. ${product.productPrice.toString()}")
                    binding.discount.setText("${product.productDiscount.toString()} % offer")
                    binding.availability.setText(" ${product.productQuantity.toString()} stocks left")
                }
            }
        }
        return binding.root
    }

}