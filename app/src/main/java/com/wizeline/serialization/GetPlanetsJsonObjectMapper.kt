package com.wizeline.serialization

import org.json.JSONArray
import org.json.JSONObject


class GetPlanetsJsonObjectMapper(
    val planetResponseMapper: PlanetResponseMapper
) {

    fun map(jsonObject: JSONObject): GetPlanetsResponse {
        val results = jsonObject.getJSONArray("results")

        val planets = mutableListOf<PlanetResponse>()
        for (i in 0 until results.length()) {
            val planetObject = results.getJSONObject(i)
            planets.add(
                PlanetResponse(
                    name = planetObject.getString("name"),
                    population = planetObject.getString("population"),
                    terrain = planetObject.getString("terrain")
                )
            )
        }
        return GetPlanetsResponse(
            count = jsonObject.getInt("count"),
            results = planets
        )
    }

    fun map2(jsonObject: JSONObject): GetPlanetsResponse {
        val results = jsonObject.getJSONArray("results")

        return GetPlanetsResponse(
            count = jsonObject.getInt("count"),
            results = (0 until results.length()).map { i ->
                results.getJSONObject(i)
            }.map { planetObject ->
                PlanetResponse(
                    name = planetObject.getString("name"),
                    population = planetObject.getString("population"),
                    terrain = planetObject.getString("terrain")
                )
            }
        )
    }

    fun map3(jsonObject: JSONObject): GetPlanetsResponse {
        val results = jsonObject.getJSONArray("results")

        return GetPlanetsResponse(
            count = jsonObject.getInt("count"),
            results = (0 until results.length()).map { i ->
                results.getJSONObject(i)
            }.map { planetObject ->
                planetResponseMapper.map(planetObject)
            }
        )
    }

    fun map4(jsonObject: JSONObject): GetPlanetsResponse {
        val results = jsonObject.getJSONArray("results")

        return GetPlanetsResponse(
            count = jsonObject.getInt("count"),
            results = results.iterator().map { planetObject ->
                planetResponseMapper.map(planetObject)
            }
        )
    }

    fun map5(jsonObject: JSONObject): GetPlanetsResponse {
        val results = jsonObject.getJSONArray("results")

        return GetPlanetsResponse(
            count = jsonObject.getInt("count"),
            results = results.map { planetObject ->
                planetResponseMapper.map(planetObject)
            }
        )
    }
}

fun JSONArray.iterator(): Iterator<JSONObject> = object : Iterator<JSONObject> {
    var index: Int = 0

    override fun hasNext(): Boolean = index < length()

    override fun next(): JSONObject {
        if (!hasNext()) throw NoSuchElementException()
        return getJSONObject(index++)
    }
}

inline fun <T, R> Iterator<T>.map(transform: (T) -> R): List<R> {
    val list = mutableListOf<R>()
    for (element in this) {
        list.add(transform(element))
    }
    return list
}

fun <R> JSONArray.map(transform: (JSONObject) -> R) = iterator().map(transform)

class PlanetResponseMapper {
    fun map(jsonObject: JSONObject): PlanetResponse {
        return PlanetResponse(
            name = jsonObject.getString("name"),
            population = jsonObject.getString("population"),
            terrain = jsonObject.getString("terrain")
        )
    }
}
