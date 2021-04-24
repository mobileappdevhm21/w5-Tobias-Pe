package edu.hm.cs.w5

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

data class ApodImage(
    val date: String = "",
    val explanation: String = "",
    val hdurl: String = "",
    val media_type: String = "",
    val service_version: String = "",
    val title: String = "",
    val url: String = "",
    val copyright: String? = ""
)

class ApodImages : ViewModel() {

    companion object {
        /* number APOD images that are requested */
        private val APOD_COUNT = 30
    }

    private val retrofit = Retrofit.Builder()
        /* add Gson */
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.nasa.gov/planetary/")
        .build()

    /* create new Retrofit Service instance */
    private val apodService: ApodService by lazy { retrofit.create(ApodService::class.java) }

    lateinit var apiKey: String // = context.getString(R.string.nasa_api_key)

    val imagesLiveData: LiveData<List<ApodImage>> = liveData(Dispatchers.IO) {
        val images = apodService.apod(apiKey, APOD_COUNT)
            .filter { im -> im.media_type == "image" }
        emit(images)
    }
}

interface ApodService {

    /**
     *  api call to get the current APOD image
     *  */
    @GET("apod")
    suspend fun apod(
        @Query("api_key") api_key: String?,
        @Query("count") count: Int?
    ): List<ApodImage>
}