/* 
 */

(function() {
        
	/**
     * Before creating the OpenLayers namespace, check to see if
     * GeoER.singleFile is true.  This occurs if the
     * GeoER/SingleFile.js script is included before this one
     */
    var singleFile = (typeof GeoER == "object" && GeoER.singleFile);
    
    /**
     * Relative path of this script.
     */
    var scriptName = (!singleFile) ? "lib/GeoER.js" : "GeoER.js";
    
    /**
     * Namespace: GeoER
     * The GeoER object provides a namespace for all things GeoER
     */
    window.GeoER = {
        /**
         * Method: _getScriptLocation
         * Return the path to this script. This is also implemented in
         * OpenLayers/SingleFile.js
         *
         * Returns:
         * {String} Path to this script
         */
        _getScriptLocation: (function() {
            var r = new RegExp("(^|(.*?\\/))(" + scriptName + ")(\\?|$)"),
                s = document.getElementsByTagName('script'),
                src, m, l = "";
            for(var i=0, len=s.length; i<len; i++) {
                src = s[i].getAttribute('src');
                if(src) {
                    var m = src.match(r);
                    if(m) {
                        l = m[1];
                        break;
                    }
                }
            }
            return (function() { return l; });
        })()
    };
    /**
     * OpenLayers.singleFile is a flag indicating this file is being included
     * in a Single File Library build of the OpenLayers Library.
     * 
     * When we are *not* part of a SFL build we dynamically include the
     * OpenLayers library code.
     * 
     * When we *are* part of a SFL build we do not dynamically include the 
     * OpenLayers library code as it will be appended at the end of this file.
     */
    if(!singleFile) {
	    var jsfiles = new Array(
	            "GeoER/Lang.js",
	            "GeoER/Lang/en.js",
	            "GeoER/Lang/it.js",
	    		"GeoER/BaseTypes/Class.js",
	    		"GeoER/BaseTypes.js",
	    		"GeoER/Map.js",
	    		"GeoER/RERMap.js",
	    		"GeoER/RERMap_ETRS89_UTM32.js",
	    		"GeoER/RERMap_Stradario_UTMA.js",
				"GeoER/LiguriaMap.js",
	    		"GeoER/PloneLayer.js",
	    		"GeoER/Control.js",
	    		"GeoER/Control/Panel.js",
	    		"GeoER/Control/Geocoding.js",
	    		"GeoER/Control/ReverseGeocoding.js",
	    		"GeoER/Control/MousePosition.js",
	    		"GeoER/Control/KeyboardDefaults.js",
	    		"GeoER/Control/OverviewMap.js",
	    		"GeoER/Control/ZoomBar.js",
	    		"GeoER/Control/LayerSwitcher.js",
	    		"GeoER/Control/ScaleBar.js",
	    		"GeoER/Control/Navigation.js",
	    		"GeoER/Control/ToolTips.js",
	    		"GeoER/Control/License.js",
	    		"GeoER/Control/CTS.js",
	    		"GeoER/Control/Download.js",
	    		"GeoER/Control/ZoomBox.js",
	    		"GeoER/Control/ZoomToMaxExtent.js",
	    		"GeoER/Control/NavigationHistory.js",
	    		"GeoER/Control/LoadingPanel.js",
	    		"GeoER/Layer.js",
	    		"GeoER/Layer/WMS.js",
	    		"GeoER/Layer/Markers.js",
	    		"GeoER/Util.js"
	    ); 
	
	    // use "parser-inserted scripts" for guaranteed execution order
	    // http://hsivonen.iki.fi/script-execution/
	    var allScriptTags = new Array(jsfiles.length);
	    var host = GeoER._getScriptLocation() + "lib/";    
	    for (var i=0, len=jsfiles.length; i<len; i++) {
	        allScriptTags[i] = "<script src='" + host + jsfiles[i] +
	                               "'></script>"; 
	    }
	    document.write(allScriptTags.join(""));
    }
    
})();

/**
 * Constant: VERSION_NUMBER
 */
GeoER.VERSION_NUMBER="1.0";

/**
 * Constant: GeoER.APIKey
 * A single GeoER-API key is valid for a single domain; to be use when you wish to make request 
 * to GeoER services (license manager, coordinate transformation service, geocoding, reverse geocoding, 
 * download layers).
 */
GeoER.APIKey = "";
