package com.wizeline.serialization

import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_planet.*

class PlanetActivity : AppCompatActivity(R.layout.activity_planet) {


    override fun onResume() {
        super.onResume()
        showPlanet(
            PlanetEntity(
                name = "Tatooine",
                population = 2000000,
                image = "https://lumiere-a.akamaihd.net/v1/images/Tatooine_36689d1b.jpeg"
            )
        )
    }

    fun showPlanet(planetEntity: PlanetEntity) {
        txtPlanet.text = planetEntity.name
        Picasso.get()
            .load(planetEntity.image)
            .into(imgPlanet)
    }
}
