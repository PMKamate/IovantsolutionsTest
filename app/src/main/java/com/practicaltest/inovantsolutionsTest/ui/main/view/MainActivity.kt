package com.practicaltest.inovantsolutionsTest.ui.main.view

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.practicaltest.inovantsolutionsTest.R
import com.practicaltest.inovantsolutionsTest.data.api.ApiHelper
import com.practicaltest.inovantsolutionsTest.data.api.RetrofitBuilder
import com.practicaltest.inovantsolutionsTest.databinding.ActivityMainBinding
import com.practicaltest.inovantsolutionsTest.model.AssociatedProduct
import com.practicaltest.inovantsolutionsTest.ui.base.ViewModelFactory
import com.practicaltest.inovantsolutionsTest.ui.main.adapter.MainAdapter
import com.practicaltest.inovantsolutionsTest.ui.main.viewPager.ViewPagerAdapter
import com.practicaltest.inovantsolutionsTest.ui.main.viewmodel.MainViewModel
import com.practicaltest.inovantsolutionsTest.utils.Status.*
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal
import java.math.RoundingMode


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MainAdapter
    private lateinit var layoutManager: LinearLayoutManager

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(layout.activity_main)

        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_backbutton);
        supportActionBar?.setElevation(0F);

        supportActionBar?.title = ""
        binding = ActivityMainBinding.inflate(
            layoutInflater
        )
        setContentView(binding.root)
        setupViewModel()
        setupUI()
        setupObservers()
    }


    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(MainViewModel::class.java)
    }

    private fun setupUI() {
        adapter = MainAdapter(arrayListOf())
        layoutManager = LinearLayoutManager(
            this,
            RecyclerView.HORIZONTAL,
            false
        )
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    private fun setupObservers() {
        var regularPrice = "0.00"
        var code = ""
        var finalePrice = "0.00"
        viewModel.getDetails().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    SUCCESS -> {
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        resource.data?.let { products ->
                            Log.d("Test: success", "" + products.success.toString())
                            Log.d("Test: status", "" + products.status.toString())
                            Log.d("Test: data", "" + products.data.toString())
                            products.data?.let { data ->
                                data.images?.let { it1 -> setImage(it1) }
                                data.brandName?.let { it1 -> setTitleBrandName(it1) }
                                data.name?.let { it1 -> setTitleName(it1) }
                                data.regularPrice?.let {
                                    regularPrice = it
                                }
                                data.finalPrice?.let {
                                    finalePrice = it
                                }
                                data.currencyCode?.let {
                                    code = it
                                }
                                setBlock(data.shop.toString(), data.shopId.toString())

                                setPriceWithCurCode(code, finalePrice, regularPrice)
                            }

                            retrieveList(products.data?.associatedProducts)
                        }
                    }
                    ERROR -> {
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        Log.d("Test:error ", "" + it.message)
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    LOADING -> {
                        progressBar.visibility = View.VISIBLE
                        recyclerView.visibility = View.GONE
                    }
                }
            }
        })
    }

    //  @SuppressLint("SetTextI18n")
    @SuppressLint("SetTextI18n")
    private fun setPriceWithCurCode(code: String, finalePrice: String, regularPrice: String) {
        binding.tvRgPice.text =
            BigDecimal(regularPrice).setScale(2, RoundingMode.HALF_EVEN).toString()
        binding.tvFinalPrice.text = code + " " + BigDecimal(finalePrice).setScale(
            2,
            RoundingMode.HALF_EVEN
        ).toString()
    }

    private fun setTitleBrandName(brandName: String) {
        binding.tvBrandName.text = brandName
    }

    private fun setBlock(shop: String, shopId: String) {
        binding.tvBlock.text = "$shop: $shopId"
    }

    private fun setTitleName(name: String) {
        binding.tvName.text = name
    }

    private fun setImage(images: List<String>) {
        Log.d("Test: ", "img: " + images.size)
        binding.viewpagerLayout.adapter = ViewPagerAdapter(
            supportFragmentManager,
            images as ArrayList<String>
        )
        binding.tabslayout.setupWithViewPager(binding.viewpagerLayout, true)
    }

    fun retrieveList(associatedProducts: List<AssociatedProduct>?) {
        associatedProducts?.let {
            adapter.addUsers(it)
            adapter.notifyDataSetChanged()
            btn_addToBag.visibility = View.VISIBLE
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                super.onBackPressed()
            }

            else -> {
                return super.onOptionsItemSelected(item)
            }

        }
        return true
    }
}
