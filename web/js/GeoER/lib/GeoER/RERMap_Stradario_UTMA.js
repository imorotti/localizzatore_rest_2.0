/* 
*/

/**
 * @requires GeoER/BaseTypes/Class.js
 * @requires GeoER/Map.js
 * @requires GeoER/Lang.js
 */

/**
 * Class: GeoER.RERMap_Stradario_UTMA
 * Instances of GeoER.RERMap_Stradario_UTMA are interactive maps embedded in a web page.
 * Create a new map with the <GeoER.RERMap_Stradario_UTMA> constructor.
 * Includes some layers such as ....
 * 
 * Inherits from:
 *  - <GeoER.Map>
 */
GeoER.RERMap_Stradario_UTMA = GeoER.Class(GeoER.Map, {

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
	 * Property: satelliteLayerInfo
	 * {Object} Satellite layer wms parameters (url, name and title)
	 */
	satelliteLayerInfo: {
		wmsUrl: 'http://servizigis.regione.emilia-romagna.it/wms/agea2008_rgb?',
		wmsLayerName: 'Agea2008_RGB',
		title: ''
	},
	
	/**
	 * Property: streetsLayerInfo
	 * {Object} Streets layer wms parameters (url, name and title)
	 */
	streetsLayerInfo: {
		wmsUrl: 'http://servizigis.regione.emilia-romagna.it/arcgis/portale/osm/MapServer/WMSServer?',
		wmsLayerName: '217,215,213,211,209,208,206,204,202,200,198,197,195,194,193,192,191,190,188,187,186,184,182,181,180,179,178,176,175,174,173,172,171,169,167,165,164,163,162,160,158,157,156,155,154,152,151,149,148,146,145,144,143,142,141,140,139,137,136,135,133,132,131,130,128,126,125,124,123,122,120,119,118,117,115,114,113,112,110,109,108,107,105,104,103,102,101,100,99,98,97,96,95,94,92,91,89,88,87,86,85,84,83,82,81,337,336,335,334,333,332,331,330,328,327,326,325,324,323,322,321,319,318,317,316,315,314,313,312,309,308,307,306,305,304,303,302,300,299,298,297,296,295,294,293,291,290,289,288,287,286,285,284,282,281,280,279,278,277,276,275,273,272,271,270,269,268,267,266,263,262,261,260,258,257,256,255,254,253,252,251,250,249,248,247,246,245,244,243,242,241,240,239,238,237,236,234,233,232,231,230,229,228,227,226,225,224,223,222,221,220',
		title: 'WSM'
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
	 * Constructor: GeoER.RERMap_Stradario_UTMA
	 * Constructor for a new <RERMap_Stradario_UTMA> instance. There are several ways to call 
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
		            {displayInLayerSwitcher: false, isBaseLayer: true, buffer: 0, singleTile: true}
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
	
    CLASS_NAME: "GeoER.RERMap_Stradario_UTMA"
});
