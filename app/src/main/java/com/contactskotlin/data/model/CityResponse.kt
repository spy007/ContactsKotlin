package com.contactskotlin.data.model

import com.contactskotlin.data.dto.Geoname

/**
 * Created by mbruns on 20.05.17.
 * The response wrapper for GSON to be able to parse the JSON response into our models
 */

class CityResponse {

    var geonames: List<Geoname>? = null
}
