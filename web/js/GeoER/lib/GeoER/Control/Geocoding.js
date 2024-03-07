/* 
*/

/**
 * @requires GeoER/BaseTypes/Class.js
 * @requires GeoER/Control.js
 * @requires GeoER/Lang.js
 */

/**
 * Class: GeoER.Control.Geocoding
 * This class performs the process of converting addresses into geographic 
 * coordinates (like latitude and longitude), which you can use to place markers or position the map.
 * The geocoding service has to be compliant with the OpenGIS Open Location Services Interface Standard (OpenLS). 
 * 
 * Inherits from:
 *  - <GeoER.Control>
 * 
 */
GeoER.Control.Geocoding = GeoER.Class(GeoER.Control, {

	/** 
     * @private
     * Property: type 
     * {OpenLayers.Control.TYPES} Controls can have a 'type'. The type
     * determines the type of interactions which are possible with them when
     * they are placed into a toolbar. 
     */
    type: OpenLayers.Control.TYPE_TOGGLE,
    
    /**
     * @private 
	 * Property: id
	 * {String} Control identifier
	 */
    id: null,
    
    /**
  	 * Property: div
	 * {DOMElement} This div is used for showing the address field and results
	 */
    div: null,
    
    /**
	 * Property: geocodingUrl
	 * {String} Geocoding URL (compliant with OpenLS)
	 */
    geocodingUrl: null,
    
    /**
     * @private 
	 * Property: namespace_uri_openls
	 * {String} OpenLS namaspace URI
	 */
    namespace_uri_openls:'http://www.opengis.net/xls',
   
     /**
     * @private 
	 * Property: namespace_prefix_openls
	 * {String} OpenLS namaspace prefix
	 */
    namespace_prefix_openls:'xls',
  
    /**
     * @private 
	 * Property: namespace_uri_gml
	 * {String} GML namaspace URI
	 */
    namespace_uri_gml: 'http://www.opengis.net/gml',
   
    /**
     * @private 
	 * Property: namespace_prefix_gml
	 * {String} GML namaspace prefix
	 */
    namespace_prefix_gml:'gml',
    
    /**
     * @private 
	 * Property: markers
	 * {OpenLayers.Layer.Markers} Markers layer to show the results
	 */
    markers: null,
    
    /**
     * @private 
	 * Property: popup
	 * {OpenLayers.Popup} Popup marker
	 */
    popup: null,
    
    /**
     * Property: resultIcon
     * {GeoER.Icon} Icon for marker that shows the result of geocoding process
     */  
    resultIcon: null,

	/**
	 * Constructor: GeoER.Control.Geocoding
	 * Constructor for a new <GeoER.Control.Geocoding> instance.
	 *
	 * Parameters:
	 * options - {Object}
	 */
    initialize: function (options) {
    	    	  
       OpenLayers.Control.prototype.initialize.apply(this, [options]);		
       this.events.register("activate", this, this.onActivate);   
       this.events.register("deactivate", this, this.onDeactivate);
       
       // create a unique id string, built on the passed in prefix
       this.id = OpenLayers.Util.createUniqueID(this.CLASS_NAME + "_");	   
       
       this.markers = new OpenLayers.Layer.Markers( this.id + " Markers" );
       this.markers.displayInLayerSwitcher = false;
    },
    
    /**
     * @private
     * Method: onActivate
     * Observe the activate control event
     *
	 */
    onActivate: function(){
    	this.div.style.display = 'block';
    },
    
    /**
     * @private
     * Method: onDeactivate
     * Observe the deactivate control event
     *
	 */
    onDeactivate: function(){
    	this.div.style.display = 'none';
    	var divresults = document.getElementById('divresults');
		if(divresults){
			divresults.innerHTML = '';
		}
    	this.reset();
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
    	    this.div.style.display = 'none';
    	    
    	    var fieldset = document.createElement('fieldset');
    	    fieldset.style.width = "400px";
    	    this.div.appendChild(fieldset);  
    	    var legend = document.createElement('legend');
    	    fieldset.appendChild(legend);  
    	    var txt = document.createTextNode(GeoER.i18n('geocodingLegendText'));
    	    legend.appendChild(txt);
    	    
    	    var divinput = document.createElement('div');
	        divinput.id = 'input';
	        divinput.className = 'input';
	        fieldset.appendChild(divinput);  
	        
    	    var input = document.createElement('input');
	        input.id = 'address';
	        input.className = this.div.className + 'Text';
	        fieldset.appendChild(input);   
	        
	        var searchBtn = document.createElement('input');
	        searchBtn.className = 'inputButton';
	       
	        searchBtn.value = GeoER.i18n('geocodingSearch');
	        searchBtn.type = 'button';
	        searchBtn.title = GeoER.i18n('geocodingSearch');
	        searchBtn.className = this.div.className + 'Search';
	        fieldset.appendChild(searchBtn);
	        
	        var pex = document.createElement('p');
	        pex.appendChild(document.createTextNode(GeoER.i18n('geocodingTextExample')));
	        
	        fieldset.appendChild(pex);
	        
	        var context = {
	        	fieldAddress: input,
	        	geocodingObject: this
	        };
	        OpenLayers.Event.observe(searchBtn, "click", this.invokeGeocode.bind(context));	
    	   
	        this.divpanel = document.createElement('div');
	        this.divpanel.id = 'panel';
	        this.divpanel.className = 'panel';
	        fieldset.appendChild(this.divpanel);  	        
		}        
		return this.div;
    },

    /**
     * @private
     * Method: invokeGeocode
     * Performs the geocoding process
	 *
     * Parameters:
     * evt - {Object} Event
     * 
	 */
     invokeGeocode: function (evt) {
     	
    	if (this.geocodingObject.div==null) 
    		return;
    	
    	if(this.fieldAddress.value == ''){
    		alert(GeoER.i18n('noAddress'));
    		return;
    	}
    		
    	if (this.geocodingObject.map != null) {
    		if (this.geocodingObject.map.getLayer(this.geocodingObject.markers.id) == null) {
    			this.geocodingObject.map.addLayer(this.geocodingObject.markers);
    		}
    	}		
    	
		// loading xml request
		var xmlRequest = this.geocodingObject.createGeocodingXMLRequest(this.fieldAddress.value);
		var geocodingRequest = this.geocodingObject.geocodingUrl + "xmlrequest=" + xmlRequest;
		geocodingRequest += "&key=" + GeoER.APIKey;	
    	var successGeocodingFunc = this.geocodingObject.successGeocoding.bind(this.geocodingObject);
		var failureGeocodingFunc = this.geocodingObject.failureGeocoding.bind(this.geocodingObject);

		new OpenLayers.Ajax.Request(geocodingRequest,
                 {   method: 'get',
                     parameters:null,                             
                     onComplete: successGeocodingFunc,
                     onFailure: failureGeocodingFunc
                  }
        );
     },    	 
 
 	/**
      * @private 
      * Method: successGeocoding
      *
 	 * Parameters:
 	 * request - {} Ajax request
 	 */
 	successGeocoding: function (request) { 
 		
 		if (request.responseXML == null && request.responseText==null){
 	        return;
 	    }
 	    
 	    var xmlResponse = request.responseXML;
 	    if (!xmlResponse || request.fileType!="XML") { //for IE compatibility
 	        xmlResponse = OpenLayers.parseXMLString(request.responseText);       
 	    }	    	
 	    
    	this.markers.clearMarkers();
        if(this.popup != null)
        	this.map.removePopup(this.popup);

 	    var geocodedAddressList = OpenLayers.Ajax.getElementsByTagNameNS(xmlResponse, this.namespace_uri_openls, this.namespace_prefix_openls, 'GeocodedAddress');
	    if (geocodedAddressList!=null && geocodedAddressList.length > 0) {
	    		
    		var divresults = document.getElementById('divresults');
    		if(!divresults){
    			var divresults = document.createElement('div');
    			divresults.id = 'divresults';
    			divresults.className = 'divresults';
    		}
    		else {
    			divresults.innerHTML = '';
    		}
    	    
    		//if(geocodedAddressList.length > 1){
        	divresults.innerHTML = GeoER.i18n('geocodingResults') + '<br>';
    		//}
    		for (i=0;i<geocodedAddressList.length;i++) {
    			var pointx = null;
			    var pointy = null;
			    var pointMinx = null;
			    var pointMiny = null;
			    var pointMaxx = null;
			    var pointMaxy = null;
			    var address = null;
			    var geocodedAddress =  geocodedAddressList[i];
	       		var pointGeometry = OpenLayers.Ajax.getElementsByTagNameNS(geocodedAddress, this.namespace_uri_gml, this.namespace_prefix_gml, 'Point');
	       		if (pointGeometry!=null && pointGeometry.length>0) {		
			    	var posNode = OpenLayers.Ajax.getElementsByTagNameNS(pointGeometry[0], this.namespace_uri_gml, this.namespace_prefix_gml, 'pos')[0];
			        if (posNode!=null) {
			        	if (posNode.firstChild!=null) {
			        		var pos = posNode.firstChild.nodeValue;
			        		if (pos!='') {
			        			var index = pos.indexOf(' ');
			        			pointx = (new Number(pos.substring(0,index))).valueOf();
			        			pointy = (new Number(pos.substring(index+1))).valueOf();
			        		}
			        	}	    		
			        }
			    }   
	       		var addressNode = OpenLayers.Ajax.getElementsByTagNameNS(geocodedAddress, this.namespace_uri_openls, this.namespace_prefix_openls, "Address");
	       		if (addressNode!=null) {
    	 			var freeFormAddressNode = OpenLayers.Ajax.getElementsByTagNameNS(addressNode[0], this.namespace_uri_openls, this.namespace_prefix_openls, "freeFormAddress")[0];
    	 			address = freeFormAddressNode.firstChild.nodeValue;
	       		}
	       		
   		       	var link = document.createElement('a');
   		       	link.href = '#';
   		       	link.innerHTML = address;
   		       	divresults.appendChild(link);
 				var br = document.createElement('br');
 				divresults.appendChild(br);  
 				var context = {
 						x: pointx,
 						y: pointy,
 						address: address,
 						geocodingObject: this
 				};
 				OpenLayers.Event.observe(link, "click", this.showResult.bindAsEventListener(context));
    		}
    		this.divpanel.appendChild(divresults);
    	}		    			
	    else {
	    	alert(GeoER.i18n('geocodingNoResults'));
	    }
 	    
     },

 	/**
      * @private 
      * Method: failureGeocoding
      *
 	 * Parameters:
 	 * request - {} Ajax request
 	 */
 	failureGeocoding: function (request) {
 		alert(GeoER.i18n('geocodingError'));
    	return;
    },

 	/**
     * @private 
     * Method: showResult
     *
	 * Parameters:
	 */
    showResult: function(){
    	
		// clear markers layer
    	this.geocodingObject.markers.clearMarkers();
        if(this.geocodingObject.popup != null)
        	this.geocodingObject.map.removePopup(this.geocodingObject.popup);
	
		// add marker --------------
        
        AutoSizeFramedCloud = OpenLayers.Class(OpenLayers.Popup.FramedCloud, {
            'autoSize': true,
            'minSize': new OpenLayers.Size(200,130)                     
        });        
      	
		popupClass = AutoSizeFramedCloud;
		popupContentHTML = this.address;
		
		var feature = new OpenLayers.Feature(this.geocodingObject.markers, new OpenLayers.LonLat(this.x,this.y)); 
        feature.closeBox = true;
        feature.popupClass = popupClass;
        feature.data.popupContentHTML = popupContentHTML;
        feature.data.overflow = "hidden";
               
        feature.data.icon = this.geocodingObject.resultIcon;			                                                                                
        var marker = feature.createMarker();        

        this.geocodingObject.markers.addMarker(marker);
              
        if (marker.popup == null) {
            marker.popup = feature.createPopup(feature.closeBox);
            this.geocodingObject.popup = marker.popup;
            this.geocodingObject.map.addPopup(marker.popup);
        }
        marker.popup.hide();	
        var markerClick = function (evt) {   
        	this.popup.toggle();                
            OpenLayers.Event.stop(evt);
        };
        
        var context = {
		       	reverseGeocodingObject: this.geocodingObject  
		};
        marker.events.register("click", feature, markerClick);    
        
        marker.events.register('dblclick', feature, this.geocodingObject.stopevent);
    	marker.events.register('mousedown', feature, this.geocodingObject.stopevent);
	    	
    },
    
	/**
     * @private 
     * Method: reset
     * Clear markers and remove popups
     *
	 * Parameters:
	 */
    reset: function(){
        this.markers.clearMarkers();
        if(this.popup != null)
        	this.map.removePopup(this.popup);
        if (this.map.getLayer(this.markers.id) != null) {
			this.map.removeLayer(this.markers);
		}
    },
    
    /**
     * @private 
     * Method: stopevent
     * stop event
	 *
	 * Parameters:
	 * evt - {OpenLayers.Event} event object
     */
    stopevent: function(evt) {
    	OpenLayers.Event.stop(evt,true);
    },
    
    /**
     * @private 
     * Method:  createGeocodingXMLRequest
     *
     * Parameters:
     * freeFormAddress - {String} Address to convert
     * 
	 * Returns:
	 * request - {String} XML request for geocoding service
	 */
	createGeocodingXMLRequest: function(freeFormAddress) {
    		
    	var request = '<?xml version="1.0" encoding="UTF-8"?>'+
		                '<xls:XLS xmlns:xls="http://www.opengis.net/xls" xmlns:gml="http://www.opengis.net/gml" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" version="1.0">' +
							'<xls:RequestHeader/>' +
							'<xls:Request version="1.0" requestID="">' +
								'<xls:GeocodeRequest>' +
									'<xls:Address countryCode="IT">' +
										'<xls:freeFormAddress>' + freeFormAddress + '</xls:freeFormAddress>'+
									'</xls:Address>' +
								'</xls:GeocodeRequest>' + 
							'</xls:Request>' + 
						'</xls:XLS>';
		return request;

    },
    
    CLASS_NAME: "GeoER.Control.Geocoding"
});