/* 
*/

/**
 * @requires GeoER/BaseTypes/Class.js
 */

/**
 * Class: GeoER.PloneLayer
 * This class is a descriptor for the layer published in Plone
 */
GeoER.PloneLayer = GeoER.Class({
	
	/**
	 * Property: id
	 * {String} Layer id in Plone (Geoportale)
	 */
	id: null,
	
	/**
	 * Property: title
	 * {String} Layer title
	 */
	title: null,
	
	/**
	 * Property: type
	 * {String} Layer type ('raster' or 'vector')
	 */
	type: null,
	
	/**
	 * Constructor: GeoER.PloneLayer
	 * Constructor for a new <GeoER.PloneLayer> instance.
	 *
	 * Parameters:
	 * id - {String} Layer id in Plone (Geoportale)
	 * title - {String} Layer title 
	 * type - {String} Layer type ('raster' or 'vector') 
	 */
	initialize: function(id, title, type) {
	
		this.id = id ? id : null;
		this.title = title ? title : null;
		this.type = type ? type : null;
	},

    CLASS_NAME: "GeoER.PloneLayer"
});
