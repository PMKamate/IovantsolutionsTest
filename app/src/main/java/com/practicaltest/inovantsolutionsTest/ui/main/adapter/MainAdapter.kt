package com.practicaltest.inovantsolutionsTest.ui.main.adapter

import android.graphics.Outline
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.practicaltest.inovantsolutionsTest.R
import com.practicaltest.inovantsolutionsTest.model.AssociatedProduct
import kotlinx.android.synthetic.main.item_layout.view.*
import java.math.BigDecimal
import java.math.RoundingMode


class MainAdapter(private val users: ArrayList<AssociatedProduct>) :
    RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: AssociatedProduct) {
            itemView.apply {
                tv_name.text = user.brandName
                tv_desc.text = user.name
                Glide.with(ivProduct.context)
                    .load(user.image)
                    .into(ivProduct)
                tv_rg_pice.text =
                    BigDecimal(user.regularPrice).setScale(2, RoundingMode.HALF_EVEN).toString()
                tv_final_price.text =
                    user.currencyCode + " " + BigDecimal(user.finalPrice).setScale(
                        2,
                        RoundingMode.HALF_EVEN
                    )
                        .toString()

                val curveRadius = 20F

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ivProduct.outlineProvider = object : ViewOutlineProvider() {
                        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
                        override fun getOutline(view: View?, outline: Outline?) {
                            outline?.setRoundRect(
                                0,
                                0,
                                view!!.width,
                                (view.height + curveRadius).toInt(),
                                curveRadius
                            )
                        }
                    }

                    ivProduct.clipToOutline = true

                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        )

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(users[position])
    }

    fun addUsers(users: List<AssociatedProduct>) {
        this.users.apply {
            clear()
            addAll(users)
        }

    }

}
