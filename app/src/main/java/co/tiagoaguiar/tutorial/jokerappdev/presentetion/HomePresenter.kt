package co.tiagoaguiar.tutorial.jokerappdev.presentetion

import android.graphics.Color
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ProgressBar
import co.tiagoaguiar.tutorial.jokerappdev.R
import co.tiagoaguiar.tutorial.jokerappdev.data.CategoryRemoteDataSource
import co.tiagoaguiar.tutorial.jokerappdev.data.ListCategoryCallback
import co.tiagoaguiar.tutorial.jokerappdev.fragments.HomeFragment
import co.tiagoaguiar.tutorial.jokerappdev.model.Category
import co.tiagoaguiar.tutorial.jokerappdev.view.CategoryItem

class HomePresenter(
    private val view: HomeFragment,
    private val dataSource: CategoryRemoteDataSource = CategoryRemoteDataSource()
) : ListCategoryCallback {

    fun findAllCategory() {
        view.showProgressBar()
        dataSource.findAllCategories(this)
    }

    override fun onError(message: String) {
        view.showFailure(message)
    }

    override fun onSuccess(response: List<String>) {

        val start = 40 // H - Matiz
        val end = 190 //H - Matiz
        val diff = (end - start) / response.size

        val categories = response.mapIndexed { index, s ->
            val hsv = floatArrayOf(
                start + (diff * index).toFloat(),
                100.0f,
                100.0f
            )
            Category(s, Color.HSVToColor(hsv).toLong())
        }
        view.showCategories(categories)

    }

    override fun onComplete() {
        view.hideProgress()
    }

}