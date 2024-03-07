/* 
*/

var GeoER = {
    /**
     * Constant: VERSION_NUMBER
     */
	VERSION_NUMBER: "1.0",
	
	/**
	 * Constant: GeoER.APIKey
	 * A single GeoER-API key is valid for a single domain; to be use when you wish to make request 
	 * to GeoER services (license manager, coordinate transformation service, geocoding, reverse geocoding, 
	 * download layers).
	 */
	APIKey : "",

    /**
     * Constant: singleFile
     */
    singleFile: true,

    /**
     * Method: _getScriptLocation
     * Return the path to this script. This is also implemented in
     * GeoER.js
     *
     * Returns:
     * {String} Path to this script
     */
    _getScriptLocation: (function() {
        var r = new RegExp("(^|(.*?\\/))(GeoER\.js)(\\?|$)"),
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
