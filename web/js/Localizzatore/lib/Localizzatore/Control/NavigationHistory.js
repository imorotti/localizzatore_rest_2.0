/* 
*/

/**
 * @requires GeoER/BaseTypes/Class.js
 * @requires OpenLayers/Control/NavigationHistory.js
 * @requires GeoER/Control.js
 */

/**
 * Class: GeoER.Control.NavigationHistory
 * A navigation history control.  This is a meta-control, that creates two
 *     dependent controls: <previous> and <next>.  Call the trigger method
 *     on the <previous> and <next> controls to restore previous and next
 *     history states.  The previous and next controls will become active
 *     when there are available states to restore and will become deactive
 *     when there are no states to restore.
 *
 * Inherits from:
 *  - <OpenLayers.Control.NavigationHistory>
 */
Localizzatore.Control.NavigationHistory = Localizzatore.Class(GeoER.Control.NavigationHistory, {

   CLASS_NAME: "Localizzatore.Control.NavigationHistory"
});

