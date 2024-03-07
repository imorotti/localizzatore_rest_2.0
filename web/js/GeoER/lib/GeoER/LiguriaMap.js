/* 
*/

/**
 * @requires GeoER/BaseTypes/Class.js
 * @requires GeoER/Map.js
 * @requires GeoER/Lang.js
 */

/**
 * Class: GeoER.RERMap
 * Instances of GeoER.RERMap are interactive maps embedded in a web page.
 * Create a new map with the <GeoER.RERMap> constructor.
 * Includes some layers such as ....
 * 
 * Inherits from:
 *  - <GeoER.Map>
 */
GeoER.LiguriaMap = GeoER.Class(GeoER.Map, {

	/**
     * APIProperty: minResolution
     * {Float}
     */
	minResolution: 0.000006,
	
	/**
     * APIProperty: maxResolution
     * {Float}
     */	
	maxResolution: 0.006,

    /**
     * APIProperty: numZoomLevels
     * {Integer} Number of zoom levels for the RER map.  Defaults to 10.  Set a
     *           different value in the map options if needed.
     */
	numZoomLevels: 10,
	
	/**
     * Property: VIEW_TYPES
     * {Array(String)} Supported map views. ["satellite", "street", "both"]
	 */
	VIEW_TYPES: null,
	
	/**
	 * @private
	 * Property: mapStatus
	 * {String} 
	 */
	mapStatus: null,
	
	/**
	 * Property: rerExtent
	 * {OpenLayers.Bounds} RER max extent. Set a
     *           different value in the map options if needed.
	 */
	rerExtent: new OpenLayers.Bounds(1344761,4816242,1590315,4978891),
	
	/**
	 * Property: satelliteLayerInfo
	 * {Object} Satellite layer wms parameters (url, name and title)
	 */
	satelliteLayerInfo: {
		wmsUrl: 'http://www.cartografiarl.regione.liguria.it/mapfiles/repertoriocartografico/ORTOFOTO/1505.asp?service=WMS&request=getCapabilities?',
		wmsLayerName: '0',
		title: ''
	},
	
	/**
	 * Property: streetsLayerInfo
	 * {Object} Streets layer wms parameters (url, name and title)
	 */
	streetsLayerInfo: {
		wmsUrl: 'http://servizigis.regione.emilia-romagna.it/wms/dbtr2008_map?',
		wmsLayerName: '27,28,38,39,40',
		title: ''
	},
	
	/**
	 * @private
	 * Property: satelliteLayer
	 * {GeoER.Layer.WMS} 
	 */
	satelliteLayer: null,
	
	/**
	 * @private
	 * Property: streetsLayer
	 * {GeoER.Layer.WMS} 
	 */
	streetsLayer: null,
	
	/**
	 * Constructor: GeoER.RERMap
	 * Constructor for a new <GeoER.RERMap> instance. There are several ways to call 
	 * the map constructor.  See the examples below.
	 *
	 * Parameters:
	 * options - {Object}
	 */
	initialize: function (div, options) {

	 	var newArguments = [];
	 	newArguments.push(div, options);
		GeoER.Map.prototype.initialize.apply(this, newArguments);	
		
		this.satelliteLayerInfo.title = GeoER.i18n('satellite');
		this.streetsLayerInfo.title = GeoER.i18n('streets');
		
		if(!this.VIEW_TYPES || this.VIEW_TYPES.length == 0){
			this.VIEW_TYPES = ['satellite'];
		}
		
		if(GeoER.Array.contains(this.VIEW_TYPES, 'satellite') ||
				GeoER.Array.contains(this.VIEW_TYPES, 'both')){
			this.satelliteLayer = new GeoER.Layer.WMS(
		            this.satelliteLayerInfo.title,
		            this.satelliteLayerInfo.wmsUrl,
		            {layers: this.satelliteLayerInfo.wmsLayerName, transparent: true},
		            {displayInLayerSwitcher: true, isBaseLayer: false, buffer: 0, singleTile: true}
		        );
			this.addLayer(this.satelliteLayer);
		}
		
		if(GeoER.Array.contains(this.VIEW_TYPES, 'street') ||
				GeoER.Array.contains(this.VIEW_TYPES, 'both')){
			this.streetsLayer = new GeoER.Layer.WMS(
		            this.streetsLayerInfo.title,
		            this.streetsLayerInfo.wmsUrl,
		            {layers: this.streetsLayerInfo.wmsLayerName, transparent: true},
		            {displayInLayerSwitcher: false, isBaseLayer: false, buffer: 0, singleTile: true}
		        );
			if(this.satelliteLayer == null){
				this.streetsLayer['isBaseLayer'] = true;
			}
			else {
				if(!GeoER.Array.contains(this.VIEW_TYPES, 'satellite')){
					this.streetsLayer['visibility'] = true;
					if(GeoER.Array.contains(this.VIEW_TYPES, 'both') && this.VIEW_TYPES.length!=1)						
						this.satelliteLayer['visibility'] = false;
				}
				else
					this.streetsLayer['visibility'] = false;
			}
			this.addLayer(this.streetsLayer);
		}
		
		this.zoomToExtent(this.rerExtent);
		this.maxExtent = this.rerExtent;
		this.restrictedExtent = this.rerExtent;
	    
	    // add layers button
		if(this.VIEW_TYPES.length > 1){
			
			this.displayClass = this.CLASS_NAME.replace(/\./g, "");
			var viewsdiv = OpenLayers.Util.createDiv('viewsdiv');
		    viewsdiv.className = this.displayClass;
		    viewsdiv.style.width = this.VIEW_TYPES.length*80 + "px";
		    viewsdiv.style.right = "4px";
		    viewsdiv.style.position = "absolute";
		    viewsdiv.style.top = "14px";
		    viewsdiv.style.zIndex = '10000';
		    
		    if(GeoER.Array.contains(this.VIEW_TYPES, 'satellite')){
		    	 this.satellitebtn = document.createElement('input');
		    	 this.satellitebtn.className = this.displayClass + 'ItemActive';
		    	 this.satellitebtn.value = GeoER.i18n('satellite');
		    	 this.satellitebtn.type = 'button';
		    	 this.satellitebtn.title = GeoER.i18n('satellite');
			     viewsdiv.appendChild(this.satellitebtn);
			     OpenLayers.Event.observe(this.satellitebtn, "click", this.setView.bind({state: 'satellite', map: this}));
		    }
		    
		    if(GeoER.Array.contains(this.VIEW_TYPES, 'street')){
		    	this.streetbtn = document.createElement('input');
		    	if(this.satelliteLayer == null)
		    		this.streetbtn.className = this.displayClass + 'ItemActive';
		    	else {
		    		if(GeoER.Array.contains(this.VIEW_TYPES, 'both') && 
		    				!GeoER.Array.contains(this.VIEW_TYPES, 'satellite'))
		    			this.streetbtn.className = this.displayClass + 'ItemActive';
		    		else
		    			this.streetbtn.className = this.displayClass + 'ItemInactive';
		    	}
		    	this.streetbtn.value = GeoER.i18n('streets');
		    	this.streetbtn.type = 'button';
		    	this.streetbtn.title = GeoER.i18n('streets');
		        viewsdiv.appendChild(this.streetbtn);
		        OpenLayers.Event.observe(this.streetbtn, "click", this.setView.bind({state: 'street', map: this}));
		    }
	       
		    if(GeoER.Array.contains(this.VIEW_TYPES, 'both')){
		    	this.bothbtn = document.createElement('input');
		        this.bothbtn.className = this.displayClass + 'ItemInactive';
		        this.bothbtn.value = GeoER.i18n('both');
		        this.bothbtn.type = 'button';
		        this.bothbtn.title = GeoER.i18n('both');
		        viewsdiv.appendChild(this.bothbtn);
		        OpenLayers.Event.observe(this.bothbtn, "click", this.setView.bind({state: 'both', map: this}));
		        if(this.satellitebtn)
		        	this.satellitebtn.className = this.displayClass + 'ItemActive';
		    }
		    this.viewPortDiv.appendChild(viewsdiv);
		}
    },
    
    /**
     * @private
     * Method: setView
     * Set map view (only satellite, only street or both)
     *
	 */
    setView: function(){
    	if(this.map.bothbtn)
    		this.map.bothbtn.className = this.map.displayClass + 'ItemInactive';
    	if(this.map.streetbtn)
    		this.map.streetbtn.className = this.map.displayClass + 'ItemInactive';
    	if(this.map.satellitebtn)
    		this.map.satellitebtn.className = this.map.displayClass + 'ItemInactive';
    	if(this.state == 'satellite'){
    		this.map.satellitebtn.className = this.map.displayClass + 'ItemActive';
    		this.map.satelliteLayer.setVisibility(true);
    		this.map.streetsLayer.setVisibility(false);
    	}
    	else if(this.state == 'street'){
    		this.map.streetbtn.className = this.map.displayClass + 'ItemActive';
    		this.map.satelliteLayer.setVisibility(false);
    		this.map.streetsLayer.setVisibility(true);
    	}
    	else if(this.state == 'both'){
    		this.map.bothbtn.className = this.map.displayClass + 'ItemActive';
    		this.map.satelliteLayer.setVisibility(true);
    		this.map.streetsLayer.setVisibility(true);
    	}
    		
    },
	
    CLASS_NAME: "GeoER.LiguriaMap"
});
