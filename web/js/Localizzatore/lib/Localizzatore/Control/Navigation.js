/* 
*/

/**
 * @requires GeoER/BaseTypes/Class.js
 * @requires OpenLayers/Control/Navigation.js
 * @requires GeoER/Control.js
 */

/**
 * Class: GeoER.Control.Navigation
 * The navigation control handles map browsing with mouse events (dragging,
 *     double-clicking, and scrolling the wheel).  Create a new navigation 
 *     control with the <GeoER.Control.Navigation> control.  
 * 
 *     Note that this control is added to the map by default (if no controls 
 *     array is sent in the options object to the <GeoER.Map> 
 *     constructor).
 * 
 * Inherits:
 *  - <OpenLayers.Control.Navigation>
 */
Localizzatore.Control.Navigation = Localizzatore.Class(GeoER.Control.Navigation, {

    CLASS_NAME: "Localizzatore.Control.Navigation"
});
