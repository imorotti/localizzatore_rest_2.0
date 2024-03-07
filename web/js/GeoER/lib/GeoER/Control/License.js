/* 
*/

/**
 * @requires GeoER/BaseTypes/Class.js
 * @requires GeoER/Control.js
 * @requires GeoER/Lang.js
 */

/**
 * Class: GeoER.Control.License
 * This class performs the process of requiring licenses for layers published in Plone 
 * 
 * Inherits from:
 *  - <GeoER.Control>
 * 
 */
GeoER.Control.License = GeoER.Class(GeoER.Control, {

    /**
     * @private 
	 * Property: id
	 * {String} Control identifier
	 */
    id: null,
    
    /**
  	 * Property: div
	 * {DOMElement} This div is used for showing the list of the layers with a license associated.
	 */
    div: null,
    
    /**
	 * Property: licenseUrl
	 * {String} Licenses service URL 
	 */
    licenseUrl: null,
    
    /**
	 * Property: layers
	 * {Array(<GeoER.PloneLayer>)} Descriptors for layers with a license associated.
	 */
    layers: null,
    
    /**
	 * Property: licenseLanguage
	 * {String} Language of the required license
	 */
    licenseLanguage: null,
    
	/**
	 * Constructor: GeoER.Control.License
	 * Constructor for a new <GeoER.Control.License> instance.
	 *
	 * Parameters:
	 * options - {Object}
	 */
    initialize: function (options) {
    	    	  
       OpenLayers.Control.prototype.initialize.apply(this, [options]);		
       
       // create a unique id string, built on the passed in prefix
       this.id = OpenLayers.Util.createUniqueID(this.CLASS_NAME + "_");	   
       if(!this.licenseLanguage || this.licenseLanguage == ''){
    	   this.licenseLanguage = GeoER.Lang.getCode();
       }
    },
    
    /**
     * @private
     * Method: draw
     * Draws the control inside the div component
     *
     * Returns:
	 * {DOMElement}
	 */
    draw: function() {    
       
    	if (this.div!=null)	{
    		
			OpenLayers.Control.prototype.draw.apply(this, arguments);
			
			// assign a class to the panel object
    	    this.div.className = this.CLASS_NAME.replace(/\./g, "");		
    	    
    	    var fieldset = document.createElement('fieldset');
    	    fieldset.style.width = "400px";
    	    this.div.appendChild(fieldset);  
    	    var legend = document.createElement('legend');
    	    fieldset.appendChild(legend);  
    	    var txt = document.createTextNode(GeoER.i18n('license'));
    	    legend.appendChild(txt);
    	    
	    	if(!this.layers || this.layers.length == 0){
	    		var appdiv = document.createElement("div");
	    		appdiv.className = this.div.className + 'NoLayers';
	    		appdiv.appendChild(document.createTextNode(GeoER.i18n('licenseNoLayers')));
	    		fieldset.appendChild(appdiv);
	    	}
	    	else{
    	    	for(var i=0; i<this.layers.length; i++){
    	    		var link = document.createElement('a');
    	    		link.setAttribute('href', '#');
    	    		link.innerHTML= this.layers[i].title;
    	    		fieldset.appendChild(link);
    	    		OpenLayers.Event.observe(link, "click", this.invokeLicensesService.bind({
    	    			layer: this.layers[i], 
    	    			licenseUrl: this.licenseUrl, 
    	    			licenseLanguage: this.licenseLanguage}));
    	    		fieldset.appendChild(document.createElement("br"));
        	    }
	    	}
    	    
		}        
		return this.div;
    },

    /**
     * @private
     * Method: invokeLicensesService
     * Performs the process of requiring license from layer definition
	 *
     * Parameters:
     * evt - {Object} Event
     * 
	 */
     invokeLicensesService: function (evt) {
     	
    	var urlRequest = this.licenseUrl + 'layerId=' + this.layer.id + 
    				'&layerTitle=' + this.layer.title + '&language=' + this.licenseLanguage;
    	urlRequest += "&key=" + GeoER.APIKey;
    	window.open(urlRequest);
     },    	 
 
    CLASS_NAME: "GeoER.Control.License"
});