package com.wizeline.serialization

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import kotlinx.coroutines.runBlocking
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkTest {

    @Test
    fun getPlanet() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://swapi.co/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(PlanetService::class.java)

        runBlocking {
            val planet = service.getPlanet("1")

            assertThat(
                planet, equalTo(
                    PlanetResponse(
                        name = "Tatooine",
                        population = "200000",
                        terrain = "desert"
                    )
                )
            )
        }
    }
}
