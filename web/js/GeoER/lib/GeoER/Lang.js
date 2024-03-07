/* 
*/

/**
 * @requires OpenLayers/BaseTypes.js
 */

/**
 * Namespace: GeoER.Lang
 * Internationalization namespace.  Contains dictionaries in various languages
 *     and methods to set and get the current language.
 */
GeoER.Lang = {
    
    /** 
     * Property: code
     * {String}  Current language code to use in GeoER.  Use the
     *     <setCode> method to set this value and the <getCode> method to
     *     retrieve it.
     */
    code: null,

    /** 
     * APIProperty: defaultCode
     * {String} Default language to use when a specific language can't be
     *     found.  Default is "en".
     */
    defaultCode: "en",
        
    /**
     * APIFunction: getCode
     * Get the current language code.
     *
     * Returns:
     * The current language code.
     */
    getCode: function() {
        if(!GeoER.Lang.code) {
        	GeoER.Lang.setCode();
        }
        return GeoER.Lang.code;
    },
    
    /**
     * APIFunction: setCode
     * Set the language code for string translation.  This code is used by
     *     the <GeoER.Lang.translate> method.
     *
     * Parameters-
     * code - {String} These codes follow the IETF recommendations at
     *     http://www.ietf.org/rfc/rfc3066.txt.  If no value is set, the
     *     browser's language setting will be tested.  If no <GeoER.Lang>
     *     dictionary exists for the code, the <GeoER.String.defaultLang>
     *     will be used.
     */
    setCode: function(code) {
        var lang;
        if(!code) {
            /*code = (OpenLayers.BROWSER_NAME == "msie") ?
                navigator.userLanguage : navigator.language;*/
        	code = this.defaultCode;
        }
        var parts = code.split('-');
        parts[0] = parts[0].toLowerCase();
        if(typeof GeoER.Lang[parts[0]] == "object") {
            lang = parts[0];
        }

        // check for regional extensions
        if(parts[1]) {
            var testLang = parts[0] + '-' + parts[1].toUpperCase();
            if(typeof GeoER.Lang[testLang] == "object") {
                lang = testLang;
            }
        }
        if(!lang) {
            OpenLayers.Console.warn(
                'Failed to find OpenLayers.Lang.' + parts.join("-") +
                ' dictionary, falling back to default language'
            );
            lang = GeoER.Lang.defaultCode;
        }
        
        GeoER.Lang.code = lang;
    },

    /**
     * APIMethod: translate
     * Looks up a key from a dictionary based on the current language string.
     *     The value of <getCode> will be used to determine the appropriate
     *     dictionary.  Dictionaries are stored in <GeoER.Lang>.
     *
     * Parameters:
     * key - {String} The key for an i18n string value in the dictionary.
     * context - {Object} Optional context to be used with
     *     <OpenLayers.String.format>.
     * 
     * Returns:
     * {String} A internationalized string.
     */
    translate: function(key, context) {
        var dictionary = GeoER.Lang[GeoER.Lang.getCode()];
        var message = dictionary && dictionary[key];
        if(!message) {
            // Message not found, fall back to message key
            message = key;
        }
        if(context) {
            message = OpenLayers.String.format(message, context);
        }
        return message;
    }
    
};


/**
 * APIMethod: GeoER.i18n
 * Alias for <GeoER.Lang.translate>.  Looks up a key from a dictionary
 *     based on the current language string. The value of
 *     <GeoER.Lang.getCode> will be used to determine the appropriate
 *     dictionary.  Dictionaries are stored in <GeoER.Lang>.
 *
 * Parameters:
 * key - {String} The key for an i18n string value in the dictionary.
 * context - {Object} Optional context to be used with
 *     <OpenLayers.String.format>.
 * 
 * Returns:
 * {String} A internationalized string.
 */
GeoER.i18n = GeoER.Lang.translate;
