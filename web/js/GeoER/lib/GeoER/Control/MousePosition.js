/* 
*/


/**
 * @requires GeoER/BaseTypes/Class.js
 * @requires OpenLayers/Control/MousePosition.js
 * @requires GeoER/Control.js
 */

/**
 * Class: GeoER.Control.MousePosition
 * The MousePosition control displays geographic coordinates of the mouse
 * pointer, as it is moved about the map.
 *
 * Inherits from:
 *  - <OpenLayers.Control.MousePosition>
 */
GeoER.Control.MousePosition = GeoER.Class(OpenLayers.Control.MousePosition, {
    
    /**
     * Constructor: GeoER.Control.MousePosition
     * 
     * Parameters:
     * options - {Object} Options for control.
     */
    initialize: function(options) {
        OpenLayers.Control.MousePosition.prototype.initialize.apply(this, arguments);
        this.displayClass = this.CLASS_NAME.replace(/\./g, "");
    },
    
    CLASS_NAME: "GeoER.Control.MousePosition"
});
