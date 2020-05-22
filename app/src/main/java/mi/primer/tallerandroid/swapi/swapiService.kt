package mi.primer.tallerandroid.swapi

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://swapi.dev/api/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()


interface SwapiService {
    //    obtiene los personajes
    @GET("people/")
    fun getPeople(): Deferred<String>

}

object Swapi {
    val retrofitService: SwapiService by lazy { retrofit.create(SwapiService::class.java) }
}