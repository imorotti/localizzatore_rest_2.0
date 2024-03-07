/* 
*/

/**
 * @requires GeoER/BaseTypes/Class.js
 * @requires OpenLayers/Control/ZoomToMaxExtent.js
 * @requires GeoER/Control.js
 */

/**
 * Class: GeoER.Control.ZoomToMaxExtent 
 * The ZoomToMaxExtent control is a styled (like RER Geoportal) button that zooms out to the maximum
 * extent of the map. It is designed to be used with a <GeoER.Control.Panel>.
 * 
 * Inherits from:
 *  - <OpenLayers.Control.ZoomToMaxExtent>
 */
Localizzatore.Control.ZoomToMaxExtent = Localizzatore.Class(GeoER.Control.ZoomToMaxExtent, {

    CLASS_NAME: "Localizzatore.Control.ZoomToMaxExtent"
});
