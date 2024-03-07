/* 
*/

/**
 * @requires GeoER/BaseTypes/Class.js
 * @requires GeoER/Control.js
 * @requires GeoER/Lang.js
 */

/**
 * Class: GeoER.Control.ReverseGeocoding
 * This class performs the process of translating a point into a human-readable address.
 * The reverse geocoding service has to be compliant with the OpenGIS Open Location Services Interface Standard (OpenLS).  
 * 
 * Inherits from:
 *  - <GeoER.Control>
 * 
 */
GeoER.Control.ReverseGeocoding = GeoER.Class(GeoER.Control, {
    
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
	 * {DOMElement} This div is used for showing the reverse geocoding results
	 */
    div: null,
    
    /**
	 * Property: reverseGeocodingUrl
	 * {String} Reverse geocoding URL (compliant with OpenLS)
	 */
    reverseGeocodingUrl: null,
    
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
	 * Property: lonlat
	 * {OpenLayers.LonLat} Point to translate
	 */
    lonlat: null,
    
    /**
     * Property: srs
     * {String} Point srs
     */  
    srs: 'EPSG:4326',
    
    /**
     * Property: searchIcon
     * {GeoER.Icon} Icon for marker that shows the point to translate
     */  
    searchIcon: null,
    
    /**
     * Property: resultIcon
     * {GeoER.Icon} Icon for marker that shows the result of reverse geocoding process
     */  
    resultIcon: null,
    
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
     * Constant: defaultHandlerOptions
     * {Object} Hashtable of default Handler settings
     */
    defaultHandlerOptions: {
        'single': true,
        'double': false,
        'pixelTolerance': 0,
        'stopSingle': false,
        'stopDouble': false
    },
    
	/**
	 * Constructor: GeoER.Control.ReverseGeocoding
	 * Constructor for a new <GeoER.Control.ReverseGeocoding> instance.
	 *
	 * Parameters:
	 * options - {Object}
	 */
    initialize: function (options) {
    	    	  
       this.handlerOptions = OpenLayers.Util.extend(
            {}, this.defaultHandlerOptions
       );
       OpenLayers.Control.prototype.initialize.apply(this, [options]);		
        
       this.handler = new OpenLayers.Handler.Click(
	        this, {
	            'click': this.onClick
	        }, this.handlerOptions
        );							  
       // create a unique id string, built on the passed in prefix
       this.id = OpenLayers.Util.createUniqueID(this.CLASS_NAME + "_");	   
       
       this.markers = new OpenLayers.Layer.Markers( this.id + " Markers" );
       this.markers.displayInLayerSwitcher = false;
       
       this.events.register("activate", this, this.onActivate);   
       this.events.register("deactivate", this, this.onDeactivate);
    },
    
    /**
     * @private
     * Method: onActivate
     * Observe the activate control event
     *
	 */
    onActivate: function(){
    	//this.div.style.display = 'block';
    },
    
    /**
     * @private
     * Method: onDeactivate
     * Observe the deactivate control event
     *
	 */
    onDeactivate: function(){
    	this.div.style.display = 'none';
    	this.reset();
    },
    
    /**
     * @private
     * Method: onClick
     * Notify the onclick mouse event
     */
    onClick: function(e) {
        var lonlat = this.map.getLonLatFromPixel(e.xy);
        this.lonlat = lonlat;
        this.invokeReverseGeocoding(lonlat);      
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
       
    	if (this.div!=null){
    		
			OpenLayers.Control.prototype.draw.apply(this, arguments);
			
			// assign a class to the panel object
    	    this.div.className = this.CLASS_NAME.replace(/\./g, "");	
    	    
    	    var fieldset = document.createElement('fieldset');
    	    fieldset.style.width = "400px";
    	    this.div.appendChild(fieldset);  
    	    var legend = document.createElement('legend');
    	    fieldset.appendChild(legend);  
    	    var txt = document.createTextNode(GeoER.i18n('reversegeocodingLegendText'));
    	    legend.appendChild(txt);
    	    
	        this.divpanel = document.createElement('div');
	        this.divpanel.id = 'panel';
	        this.divpanel.className = 'panel';
	        fieldset.appendChild(this.divpanel);  	     
	        this.div.style.display = 'none';
		}        
		return this.div;
    },
    
  
	/**
     * Method: invokeReverseGeocoding
     * Performs the reverse geocoding process
	 *
     * Parameters:
     * lonlat - {<OpenLayers.LonLat>} Point to translate
     * 
	 */
    invokeReverseGeocoding: function (lonlat) {

    	if (this.div!=null) {
    	 	this.divpanel.style.display = 'none';
			this.divpanel.innerHTML = '';			    		
    	}
    	
    	if (lonlat==null || lonlat.lon==null || lonlat.lat==null) {
	 	 	alert(GeoER.i18n('reversegeocodingSelect'));
	 	 	return;
	 	}  
	 	
    	if (this.map != null) {
    		if (this.map.getLayer(this.markers.id) == null) {
		    	this.map.addLayer(this.markers);
    		}
    	}		
    	
    	// clear markers layer
    	this.reset();
    	
        // add marker to lonlat position 
        this.markers.addMarker(new OpenLayers.Marker(lonlat,this.searchIcon));
    	
		// loading xml request
		var xmlRequest = this.createReverseGeocodingXMLRequest(lonlat);
		var reverseGeocodingRequest = this.reverseGeocodingUrl + "xmlrequest=" + xmlRequest;
		reverseGeocodingRequest += "&key=" + GeoER.APIKey;			
		var context = {
				reverseGeocodingObject:this
		};
		var successReverseGeocodingFunc = this.successReverseGeocoding.bind(context);
		var failureReverseGeocodingFunc = this.failureReverseGeocoding.bind(context);

		new OpenLayers.Ajax.Request(reverseGeocodingRequest,
                 {   method: 'get',
                     parameters:null,                             
                     onComplete: successReverseGeocodingFunc,
                     onFailure: failureReverseGeocodingFunc
                  }
        );
 
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
        this.divpanel.innerHTML = '';
    },
    
	/**
     * @private 
     * Method: showPopup
     *
	 * Parameters:
	 * evt - {Object} Show popup after onvlick event on div result
	 */
    showPopup: function (evt) { 
    	this.reverseGeocodingObject.popup.show();
    },
    
	/**
     * @private 
     * Method: successReverseGeocoding
     *
	 * Parameters:
	 * request - {} Ajax request
	 */
	successReverseGeocoding: function (request) { 
		
		if (request.responseXML == null && request.responseText==null){
	        return;
	    }
	    
	    var xmlResponse = request.responseXML;
	    if (!xmlResponse || request.fileType!="XML") { //for IE compatibility
	        xmlResponse = OpenLayers.parseXMLString(request.responseText);       
	    }	    	    

	    var reverseGeocodedLocation = OpenLayers.Ajax.getElementsByTagNameNS(xmlResponse, this.reverseGeocodingObject.namespace_uri_openls, this.reverseGeocodingObject.namespace_prefix_openls, 'ReverseGeocodedLocation');
	    if (reverseGeocodedLocation!=null && reverseGeocodedLocation.length>0) {
	    	
		    for (i=0;i<reverseGeocodedLocation.length;i++) {
		    	var pointx = null;
			    var pointy = null;
			    var freeFormAddress = null;
		    	var reverseGeocoded =  reverseGeocodedLocation[i];
		       	var pointGeometry = OpenLayers.Ajax.getElementsByTagNameNS(reverseGeocoded, this.reverseGeocodingObject.namespace_uri_gml, this.reverseGeocodingObject.namespace_prefix_gml, 'Point');
	 			if (pointGeometry!=null && pointGeometry.length>0) {				    	
			    	var pointNodo = pointGeometry[0];
			    	var posNode = OpenLayers.Ajax.getElementsByTagNameNS(pointNodo, this.reverseGeocodingObject.namespace_uri_gml, this.reverseGeocodingObject.namespace_prefix_gml, 'pos')[0];
			       
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
	 			var geocodedAddress = OpenLayers.Ajax.getElementsByTagNameNS(reverseGeocoded, this.reverseGeocodingObject.namespace_uri_openls, this.reverseGeocodingObject.namespace_prefix_openls, "Address");
	 			if (geocodedAddress!=null) {
    	 			var address = geocodedAddress[0];
    	 			if (address!=null) {
	 					var freeFormAddressNode = OpenLayers.Ajax.getElementsByTagNameNS(address, this.reverseGeocodingObject.namespace_uri_openls, this.reverseGeocodingObject.namespace_prefix_openls, "freeFormAddress")[0];
 					    if (freeFormAddressNode!=null && freeFormAddressNode.firstChild!=null) {
 					  		freeFormAddress = freeFormAddressNode.firstChild.nodeValue;
 					    }						       
    	 			}	
	 			}
	 			
	 			// add marker --------------
	 	        
	 	        AutoSizeFramedCloud = OpenLayers.Class(OpenLayers.Popup.FramedCloud, {
	 	            'autoSize': true,
	 	            'minSize': new OpenLayers.Size(200,130)                     
	 	        });        
	 	      	
	 			popupClass = AutoSizeFramedCloud;
	 			popupContentHTML = freeFormAddress;
	 			
	 			var feature = new OpenLayers.Feature(this.reverseGeocodingObject.markers, new OpenLayers.LonLat(pointx,pointy)); 
	 	        feature.closeBox = true;
	 	        feature.popupClass = popupClass;
	 	        feature.data.popupContentHTML = popupContentHTML;
	 	        feature.data.overflow = "hidden";
	 	               
	 	        feature.data.icon = this.reverseGeocodingObject.resultIcon;			                                                                                
	 	        var marker = feature.createMarker();        

	 	        this.reverseGeocodingObject.markers.addMarker(marker);
	 	              
	 	        if (marker.popup == null) {
	 	            marker.popup = feature.createPopup(feature.closeBox);
	 	            this.reverseGeocodingObject.popup = marker.popup;
	 	            this.reverseGeocodingObject.map.addPopup(marker.popup);
	 	        }
	 	        marker.popup.hide();	
	 	        var markerClick = function (evt) {   
	 	        	this.popup.toggle();                
	 	            OpenLayers.Event.stop(evt);
	 	        };
	 	        
	 	        var context = {
 				       	reverseGeocodingObject: this.reverseGeocodingObject  
 				};
	 	        marker.events.register("click", feature, markerClick);    
	 	        
	 	        marker.events.register('dblclick', feature, this.reverseGeocodingObject.stopevent);
	 	    	marker.events.register('mousedown', feature, this.reverseGeocodingObject.stopevent);
	 	    	
	 	    	if (this.reverseGeocodingObject.div!=null) { 		
	 	    		
	 	    		this.reverseGeocodingObject.div.style.display = 'block';
	 	    		var divHref = document.createElement('a');
	 				divHref.href = '#';
	 				divHref.innerHTML = freeFormAddress;
	 				this.reverseGeocodingObject.divpanel.style.display = 'block';
	 				this.reverseGeocodingObject.divpanel.appendChild(divHref);
	 				var br = document.createElement('br');
	 				this.reverseGeocodingObject.divpanel.appendChild(br);  
	 				
	 				OpenLayers.Event.observe(divHref, "click", this.reverseGeocodingObject.showPopup.bindAsEventListener(context));
	 				
	 			}
	 	    	
	 	    	// ------------------------
	    	}		    			
	    }	       
	    else {
	    	alert(GeoER.i18n('reversegeocodingNoResults'));
	    }
	    
    },

	/**
     * @private 
     * Method: failureReverseGeocoding
     *
	 * Parameters:
	 * request - {} Ajax request
	 */
	failureReverseGeocoding: function (request) {
    	alert(GeoER.i18n('reversegeocodingError'));
   		return;
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
     * Method:  createReverseGeocodingXMLRequest
     *
     * Parameters:
     * lonlat - {<OpenLayers.LonLat>} Point to translate
     * 
	 * Returns:
	 * request - {String} XML request for reverse geocoding service
	 */
    createReverseGeocodingXMLRequest:function(lonlat) {
    		
    	var request = '<?xml version="1.0" encoding="UTF-8"?>'+
		                '<xls:XLS xmlns:xls="http://www.opengis.net/xls" xmlns:gml="http://www.opengis.net/gml" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" version="1.0">' +
							'<xls:RequestHeader/>' +
							'<xls:Request version="1.0" requestID="">' +
								'<xls:ReverseGeocodeRequest>' +
									'<xls:Position>' +
										'<gml:Point srsName="' + this.srs + '">'+
											'<gml:pos>' + lonlat.lon + ' ' + lonlat.lat + '</gml:pos>' +
										'</gml:Point>' +
									'</xls:Position>' +
									'<xls:ReverseGeocodePreference>StreetAddress</xls:ReverseGeocodePreference>' +
								'</xls:ReverseGeocodeRequest>' + 
							'</xls:Request>' + 
						'</xls:XLS>';
		return request;

    },

    CLASS_NAME: "GeoER.Control.ReverseGeocoding"
}) ;