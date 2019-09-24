package com.wizeline.serialization

import retrofit2.http.*

interface PlanetService {

    @GET("api/planets")
    suspend fun getPlanets(): GetPlanetsResponse

    @GET("api/planets/{id}")
    suspend fun getPlanet(@Path("id") planetId: String): PlanetResponse

    @POST("api/planets")
    suspend fun createPlanet(
        @Header("Authorization") authToken: String,
        @Body planetRequest: PlanetRequest
    ): PlanetResponse

    @FormUrlEncoded
    @POST("api/planets")
    suspend fun createPlanetUrlEncoded(
        @Header("Authorization") authToken: String,
        @Field("name") planetName: String,
        @Field("terrain") planetTerrain: String
    ): PlanetResponse
}
