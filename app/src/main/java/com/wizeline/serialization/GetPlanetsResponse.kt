package com.wizeline.serialization

import com.google.gson.annotations.SerializedName

data class GetPlanetsResponse(
    @SerializedName("count") val count: Int,
    @SerializedName("results") val results: List<PlanetResponse>
)

data class PlanetResponse(
    @SerializedName("name") val name: String,
    @SerializedName("population") val population: String,
    @SerializedName("terrain") val terrain: String
)

data class PlanetRequest(
    @SerializedName("name") val name: String,
    @SerializedName("terrain") val terrain: String
)
