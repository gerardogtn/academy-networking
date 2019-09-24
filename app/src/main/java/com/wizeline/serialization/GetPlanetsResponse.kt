package com.wizeline.serialization

data class GetPlanetsResponse(
    val count: Int,
    val results: List<PlanetResponse>
)

data class PlanetResponse(
    val name: String,
    val population: String,
    val terrain: String
)

data class PlanetRequest(
    val name: String,
    val terrain: String
)
