package com.example.wallpaper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wallpaper.APIClient.Companion.getAPIClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class MainActivity : AppCompatActivity() {

    lateinit var rvWallpaper : RecyclerView
    var imageModel:ImageModel?=null
    lateinit var imgSearch :ImageView
    lateinit var edtSearch : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvWallpaper=findViewById<RecyclerView>(R.id.rvWallpaper)
        edtSearch=findViewById<EditText>(R.id.edtSearch)
        imgSearch=findViewById<ImageView>(R.id.imgSearch)

    getSearchImageApi("flower")

        imgSearch.setOnClickListener {
            var searchData = edtSearch.text.toString()
            getSearchImageApi(searchData)
        }


    }

    fun setRv(){
        var adapter = WallpaperAdapter(this@MainActivity,imageModel!!.hits)
        var lm = GridLayoutManager(this,2,)
        rvWallpaper.layoutManager = lm
        rvWallpaper.adapter = adapter
    }

    fun getSearchImageApi(q:String) {
        var apiInterface = getAPIClient()!!.create(APIInterface::class.java)
        apiInterface.searchImageAPI("41626448-dc177bdab9c7d049689854042",q,"all").enqueue(object : Callback<ImageModel>{
            override fun onResponse(call: Call<ImageModel>?, response: Response<ImageModel>?) {
                if(response!!.code() == 200)
                {
                    imageModel = response.body()
                    setRv()
                }
            }

            override fun onFailure(call: Call<ImageModel>?, t: Throwable?) {
                Log.e("TAG", "onFailure: ${t!!.message}" )
            }
        })
    }


}


