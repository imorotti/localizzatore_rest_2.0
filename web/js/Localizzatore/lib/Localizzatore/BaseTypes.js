/* 
*/

/**
 * @requires GeoER/SingleFile.js
 */
 
/** 
 * Header: GeoER Base Types
 * GeoER custom functions.
 */


/**
 * Namespace: GeoER.Array
 * Contains convenience functions for array manipulation.
 */
Localizzatore.Array = {

    /**
     * APIMethod: contains
     * Provides the functionality of contains method
     *
     * Returns:
     * {Boolean} True if the array contains the element, false otherwise 
     */
    contains: function (array, element) {
    	for (var i = 0; i < array.length; i++) {
    		if (array[i] == element)
    			return true;
    	}
    	return false;
	}
    
};
