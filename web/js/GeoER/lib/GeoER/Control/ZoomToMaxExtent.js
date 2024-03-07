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
GeoER.Control.ZoomToMaxExtent = GeoER.Class(OpenLayers.Control.ZoomToMaxExtent, {

    CLASS_NAME: "GeoER.Control.ZoomToMaxExtent"
});
