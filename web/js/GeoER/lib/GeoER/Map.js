/* 
*/

/**
 * @requires GeoER/BaseTypes/Class.js
 * @requires OpenLayers/Map.js
 * @requires GeoER/Lang.js
 */

/**
 * Class: GeoER.Map
 * Instances of GeoER.Map are interactive maps embedded in a web page.
 * Create a new map with the <GeoER.Map> constructor.
 * 
 * Inherits from:
 *  - <OpenLayers.Map>
 */
GeoER.Map = GeoER.Class(OpenLayers.Map, {
	
    /**
     * Constructor: GeoER.Map
     * Constructor for a <new GeoER.Map> instance. 
     * If controls are not provided in the map options at construction, the map will
     * be given the following controls by default:
     *  - <GeoER.Control.Navigation>
     *  - <GeoER.Control.ZoomBar>
     *  - <OpenLayers.Control.ArgParser>
     *  - <OpenLayers.Control.Attribution>
     *
     * Parameters:
     * div - {DOMElement|String}  The element or id of an element in your page
     *     that will contain the map.  May be omitted if the <div> option is
     *     provided or if you intend to call the <render> method later.
     * options - {Object} Optional object with properties to tag onto the map.
     * 
     *
     */    
    initialize: function (div, options) {
        
		if (this.controls == null) {
	        if (OpenLayers.Control != null) { // running full or lite?
	            this.controls = [ new GeoER.Control.Navigation(),
	                              //new GeoER.Control.ZoomBar(),
                                      new OpenLayers.Control.PanZoomBar(),
	                              new OpenLayers.Control.ArgParser(),
	                              new OpenLayers.Control.Attribution()
	                            ];
	        } else {
	            this.controls = [];
	        }
	    }
	
		var newArguments = [];
		newArguments.push(div, options);
		OpenLayers.Map.prototype.initialize.apply(this, newArguments);	
    },
    
    CLASS_NAME: "GeoER.Map"
});
