/* 
*/

/** 
 * @requires GeoER/BaseTypes/Class.js
 * @requires OpenLayers/Control/LayerSwitcher.js
 * @requires GeoER/Control.js
 * @requires GeoER/Lang.js
 */

/**
 * Class: GeoER.Control.LayerSwitcher
 * The LayerSwitcher control displays a table of contents for the map. This 
 * allows the user interface to switch between BaseLasyers and to show or hide
 * Overlays. By default the switcher is shown minimized on the right edge of 
 * the map, the user may expand it by clicking on the handle.
 *
 * To create the LayerSwitcher outside of the map, pass the Id of a html div 
 * as the first argument to the constructor.
 * 
 * Inherits from:
 *  - <OpenLayers.Control.LayerSwitcher>
 */
Localizzatore.Control.LayerSwitcher = Localizzatore.Class(GeoER.Control.LayerSwitcher, {
    CLASS_NAME: "Localizzatore.Control.LayerSwitcher"
});
