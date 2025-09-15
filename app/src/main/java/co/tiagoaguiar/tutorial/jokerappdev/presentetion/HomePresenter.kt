package co.tiagoaguiar.tutorial.jokerappdev.presentetion

import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ProgressBar
import co.tiagoaguiar.tutorial.jokerappdev.R
import co.tiagoaguiar.tutorial.jokerappdev.fragments.HomeFragment
import co.tiagoaguiar.tutorial.jokerappdev.model.Category
import co.tiagoaguiar.tutorial.jokerappdev.view.CategoryItem

class HomePresenter(private val view: HomeFragment) {

    fun findAllCategory() {
        view.showProgressBar()
        fakeRequest()
    }

    fun onError(message: String) {
        view.showFailure(message)
    }

    fun onSuccess(response: List<String>) {
//        val categories = mutableListOf<CategoryItem>()
//        for (category in response) {
//            categories.add(CategoryItem(category))
//        }
        // val categories = response.map { CategoryItem(it) }

        view.showCategories(response.map { Category(it, 0xffff0000) })

    }

    fun onComplete() {
        view.hideProgress()
    }

    //Simular uma requisição
    private fun fakeRequest() {
        Handler(Looper.getMainLooper()).postDelayed({
            val response = arrayListOf(
                "Categoria 1",
                "Categoria 2",
                "Categoria 3",
                "Categoria 4"
            )
            onSuccess(response)
            //onError("Erro ao carregar categorias")

            onComplete()

        }, 2000)
    }
}