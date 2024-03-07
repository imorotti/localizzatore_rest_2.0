/* 
*/

/**
 * @requires GeoER/BaseTypes/Class.js
 * @requires GeoER/Control.js
 * @requires GeoER/Lang.js
 */

/**
 * Class: GeoER.Control.Geocoding
 * This class performs the process of converting addresses into geographic 
 * coordinates (like latitude and longitude), which you can use to place markers or position the map.
 * The geocoding service has to be compliant with the OpenGIS Open Location Services Interface Standard (OpenLS). 
 * 
 * Inherits from:
 *  - <GeoER.Control>
 * 
 */
Localizzatore.Control.Geocoding = Localizzatore.Class(GeoER.Control.Geocoding, {
    CLASS_NAME: "Localizzatore.Control.Geocoding"
});