package co.tiagoaguiar.tutorial.jokerappdev.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.tiagoaguiar.tutorial.jokerappdev.R
import co.tiagoaguiar.tutorial.jokerappdev.model.Category
import co.tiagoaguiar.tutorial.jokerappdev.view.CategoryItem
import com.xwray.groupie.GroupieAdapter

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_main)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val adapter = GroupieAdapter()
        recyclerView.adapter = adapter

        adapter.add(CategoryItem(Category("Categoria 1", 0xff9e9e9e)))
        adapter.add(CategoryItem(Category("Categoria 2", 0xf12711)))
        adapter.add(CategoryItem(Category("Categoria 3", 0xf5af19)))
        adapter.add(CategoryItem(Category("Categoria 4", 0xff9e9e9e)))

        adapter.notifyDataSetChanged()
    }

}