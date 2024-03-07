/* 
 */

(function() {
        
	/**
     * Before creating the OpenLayers namespace, check to see if
     * Localizzatore.singleFile is true.  This occurs if the
     * Localizzatore/SingleFile.js script is included before this one
     */
    var singleFile = (typeof Localizzatore == "object" && Localizzatore.singleFile);
    
    /**
     * Relative path of this script.
     */
    var scriptName = (!singleFile) ? "lib/Localizzatore.js" : "Localizzatore.js";
    
    /**
     * Namespace: Localizzatore
     * The Localizzatore object provides a namespace for all things Localizzatore
     */
    window.Localizzatore = {
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
	            "Localizzatore/Lang.js",
	            "Localizzatore/Lang/en.js",
	            "Localizzatore/Lang/it.js",
	    		"Localizzatore/BaseTypes/Class.js",
	    		"Localizzatore/BaseTypes.js",
	    		"Localizzatore/Map.js",
	    		"Localizzatore/RERMap.js",
				"Localizzatore/LiguriaMap.js",
	    		"Localizzatore/RERMap_ETRS89_UTM32.js",
	    		"Localizzatore/RERMap_Stradario_UTMA.js",
	    		"Localizzatore/PloneLayer.js",
	    		"Localizzatore/Control.js",
	    		"Localizzatore/Control/Panel.js",
	    		"Localizzatore/Control/Geocoding.js",
	    		"Localizzatore/Control/ReverseGeocoding.js",
	    		"Localizzatore/Control/MousePosition.js",
	    		"Localizzatore/Control/KeyboardDefaults.js",
	    		"Localizzatore/Control/OverviewMap.js",
	    		"Localizzatore/Control/ZoomBar.js",
	    		"Localizzatore/Control/LayerSwitcher.js",
	    		"Localizzatore/Control/ScaleBar.js",
	    		"Localizzatore/Control/Navigation.js",
	    		"Localizzatore/Control/ToolTips.js",
	    		"Localizzatore/Control/License.js",
	    		"Localizzatore/Control/CTS.js",
	    		"Localizzatore/Control/Download.js",
	    		"Localizzatore/Control/ZoomBox.js",
	    		"Localizzatore/Control/ZoomToMaxExtent.js",
	    		"Localizzatore/Control/NavigationHistory.js",
	    		"Localizzatore/Control/LoadingPanel.js",
	    		"Localizzatore/Layer.js",
	    		"Localizzatore/Layer/WMS.js",
	    		"Localizzatore/Layer/Markers.js",
	    		"Localizzatore/Util.js"
	    ); 
	
	    // use "parser-inserted scripts" for guaranteed execution order
	    // http://hsivonen.iki.fi/script-execution/
	    var allScriptTags = new Array(jsfiles.length);
	    var host = Localizzatore._getScriptLocation() + "lib/";
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
Localizzatore.VERSION_NUMBER="1.0";

/**
 * Constant: Localizzatore.APIKey
 * A single Localizzatore-API key is valid for a single domain; to be use when you wish to make request
 * to Localizzatore services (license manager, coordinate transformation service, geocoding, reverse geocoding,
 * download layers).
 */
Localizzatore.APIKey = "";
