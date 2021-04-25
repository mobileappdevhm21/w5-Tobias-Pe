package edu.hm.cs.w5

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val images by lazy { ViewModelProvider(this)[ApodImages::class.java] }
    private val adapter by lazy { ApodAdapter(listOf()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        images.apiKey = getString(R.string.nasa_api_key)

        recyclerView.adapter = adapter
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerView.layoutManager = GridLayoutManager(this,2)
        }else{
            recyclerView.layoutManager = GridLayoutManager(this,3)
        }

        images.imagesLiveData.observe(this, Observer {
            adapter.images = it
            adapter.notifyDataSetChanged()
        })
    }
}
