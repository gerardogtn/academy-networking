package com.wizeline.serialization

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.json.JSONObject
import org.junit.Test

class GetPlanetsJsonObjectMapperTest {

    val aldereaanJson = """
        {
            "count": 61,
            "next": "https://swapi.co/api/planets/?page=2",
            "previous": null,
            "results": [
                {
                    "name": "Alderaan",
                    "rotation_period": "24",
                    "orbital_period": "364",
                    "diameter": "12500",
                    "climate": "temperate",
                    "gravity": "1 standard",
                    "terrain": "grasslands, mountains",
                    "surface_water": "40",
                    "population": "2000000000",
                    "residents": [
                        "https://swapi.co/api/people/5/",
                        "https://swapi.co/api/people/68/",
                        "https://swapi.co/api/people/81/"
                    ],
                    "films": [
                        "https://swapi.co/api/films/6/",
                        "https://swapi.co/api/films/1/"
                    ],
                    "created": "2014-12-10T11:35:48.479000Z",
                    "edited": "2014-12-20T20:58:18.420000Z",
                    "url": "https://swapi.co/api/planets/2/"
                }
            ]
        }
    """.trimIndent()

    @Test
    fun mapAlderaan() {
        val jsonObject = JSONObject(aldereaanJson)
        val planetResponseMapper = PlanetResponseMapper()
        val mapper = GetPlanetsJsonObjectMapper(planetResponseMapper)

        val mapped = mapper.map(jsonObject)

        assertThat(
            mapped, equalTo(
                GetPlanetsResponse(
                    count = 61,
                    results = listOf(
                        PlanetResponse(
                            name = "Alderaan",
                            population = "2000000000",
                            terrain = "grasslands, mountains"
                        )
                    )
                )
            )
        )
    }

    @Test
    fun map2Alderaan() {
        val jsonObject = JSONObject(aldereaanJson)
        val planetResponseMapper = PlanetResponseMapper()
        val mapper = GetPlanetsJsonObjectMapper(planetResponseMapper)

        val mapped = mapper.map2(jsonObject)

        assertThat(
            mapped, equalTo(
                GetPlanetsResponse(
                    count = 61,
                    results = listOf(
                        PlanetResponse(
                            name = "Alderaan",
                            population = "2000000000",
                            terrain = "grasslands, mountains"
                        )
                    )
                )
            )
        )
    }

    @Test
    fun map3Alderaan() {
        val jsonObject = JSONObject(aldereaanJson)
        val planetResponseMapper = PlanetResponseMapper()
        val mapper = GetPlanetsJsonObjectMapper(planetResponseMapper)

        val mapped = mapper.map3(jsonObject)

        assertThat(
            mapped, equalTo(
                GetPlanetsResponse(
                    count = 61,
                    results = listOf(
                        PlanetResponse(
                            name = "Alderaan",
                            population = "2000000000",
                            terrain = "grasslands, mountains"
                        )
                    )
                )
            )
        )
    }

    @Test
    fun map4Alderaan() {
        val jsonObject = JSONObject(aldereaanJson)
        val planetResponseMapper = PlanetResponseMapper()
        val mapper = GetPlanetsJsonObjectMapper(planetResponseMapper)

        val mapped = mapper.map4(jsonObject)

        assertThat(
            mapped, equalTo(
                GetPlanetsResponse(
                    count = 61,
                    results = listOf(
                        PlanetResponse(
                            name = "Alderaan",
                            population = "2000000000",
                            terrain = "grasslands, mountains"
                        )
                    )
                )
            )
        )
    }

    @Test
    fun map5Alderaan() {
        val jsonObject = JSONObject(aldereaanJson)
        val planetResponseMapper = PlanetResponseMapper()
        val mapper = GetPlanetsJsonObjectMapper(planetResponseMapper)

        val mapped = mapper.map5(jsonObject)

        assertThat(
            mapped, equalTo(
                GetPlanetsResponse(
                    count = 61,
                    results = listOf(
                        PlanetResponse(
                            name = "Alderaan",
                            population = "2000000000",
                            terrain = "grasslands, mountains"
                        )
                    )
                )
            )
        )
    }
}