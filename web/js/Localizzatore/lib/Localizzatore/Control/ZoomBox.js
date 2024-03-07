/* 
*/

/**
 * @requires GeoER/BaseTypes/Class.js
 * @requires OpenLayers/Control/ZoomBox.js
 * @requires GeoER/Control.js
 */

/**
 * Class: GeoER.Control.ZoomBox
 * The ZoomBox control enables zooming directly to a given extent, by drawing 
 * a box on the map. The box is drawn by holding down shift, whilst dragging 
 * the mouse. 
 *
 * Inherits from:
 *  - <OpenLayers.Control.ZoomBox>
 */
Localizzatore.Control.ZoomBox = Localizzatore.Class(GeoER.Control.ZoomBox, {
    CLASS_NAME: "Localizzatore.Control.ZoomBox"
});
