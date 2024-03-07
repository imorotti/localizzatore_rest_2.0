/* 
 * */

/**
 * @requires GeoER/BaseTypes/Class.js
 * @requires OpenLayers/Control/KeyboardDefaults.js
 * @requires GeoER/Control.js
 */

/**
 * Class: GeoER.Control.KeyboardDefaults
 * The KeyboardDefaults control adds panning and zooming functions, controlled
 * with the keyboard. By default arrow keys pan, +/- keys zoom & Page Up/Page
 * Down/Home/End scroll by three quarters of a page.
 * 
 * This control has no visible appearance.
 *
 * Inherits from:
 *  - <OpenLayers.Control.KeyboardDefaults>
 */
GeoER.Control.KeyboardDefaults = GeoER.Class(OpenLayers.Control.KeyboardDefaults, {

    CLASS_NAME: "GeoER.Control.KeyboardDefaults"
});
