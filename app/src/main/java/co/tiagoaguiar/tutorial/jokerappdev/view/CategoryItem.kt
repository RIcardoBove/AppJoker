package co.tiagoaguiar.tutorial.jokerappdev.view

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import co.tiagoaguiar.tutorial.jokerappdev.R
import co.tiagoaguiar.tutorial.jokerappdev.model.Category
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

class CategoryItem(val category: Category): Item<CategoryItem.CategoryViewHolder>() {

    class CategoryViewHolder(itemView: View) : GroupieViewHolder(itemView)

    override fun createViewHolder(itemView: View): CategoryViewHolder =  CategoryViewHolder(itemView)

    override fun bind(viewHolder: CategoryViewHolder, position: Int) {
        viewHolder.itemView.findViewById<TextView>(R.id.txt_category).text = category.text
        viewHolder.itemView.findViewById<LinearLayout>(R.id.container_category).setBackgroundColor(category.bgColor.toInt())
    }

    override fun getLayout(): Int = R.layout.item_category

}