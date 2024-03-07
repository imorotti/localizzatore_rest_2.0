/* 
*/

/**
 * @requires GeoER/BaseTypes/Class.js
 * @requires GeoER/Control.js
 * @requires GeoER/Lang.js
 */

/**
 * Class: GeoER.Control.ReverseGeocoding
 * This class performs the process of translating a point into a human-readable address.
 * The reverse geocoding service has to be compliant with the OpenGIS Open Location Services Interface Standard (OpenLS).  
 * 
 * Inherits from:
 *  - <GeoER.Control>
 * 
 */
Localizzatore.Control.ReverseGeocoding = Localizzatore.Class(GeoER.Control.ReverseGeocoding, {
    CLASS_NAME: "Localizzatore.Control.ReverseGeocoding"
}) ;