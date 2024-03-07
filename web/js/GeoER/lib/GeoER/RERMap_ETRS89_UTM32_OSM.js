/* 
 */

/**
 * @requires GeoER/BaseTypes/Class.js
 * @requires GeoER/Map.js
 * @requires GeoER/Lang.js
 */

/**
 * Class: GeoER.RERMap_ETRS89_UTM32_OSM
 * Instances of GeoER.RERMap_ETRS89_UTM32_OSM are interactive maps embedded in a web page.
 * Create a new map with the <GeoER.RERMap_ETRS89_UTM32_OSM> constructor.
 * Includes some layers such as ....
 * 
 * Inherits from:
 *  - <GeoER.Map>
 */
GeoER.RERMap_ETRS89_UTM32_OSM = GeoER.Class(GeoER.Map, {

	/**
	 * Property: VIEW_TYPES
	 * {Array(String)} Supported map views. ["satellite", "street", "osm"]
	 */
	VIEW_TYPES: ["satellite", "street", "osm"],

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
		wmsUrl: 'https://servizigis.regione.emilia-romagna.it/wms/agea2011_rgb?',
		wmsLayerName: 'Agea2011_RGB',
		title: 'DBTR'
	},

	/**
	 * Property: streetsLayerInfo
	 * {Object} Streets layer wms parameters (url, name and title)
	 */
	streetsLayerInfo: {
		wmsUrl: 'https://servizigis.regione.emilia-romagna.it/wms/dbtr_local?',
		wmsLayerName: 'NCV_Civico,TPS_Toponimo_stradale_comunale,STR_PA_Strada_percorso_analitico,LAM_Limite_amministrativo,COM_Comune',
		title: 'Stradario DBTR'
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
	 * @private
	 * Property: streetsLayer
	 * {new OpenLayers.Layer.ArcGISCache} 
	 */
	osmLayer: null,

	/**
	 * Constructor: GeoER.RERMap_ETRS89_UTM32
	 * Constructor for a new <GeoER.RERMap_ETRS89_UTM32> instance. There are several ways to call 
	 * the map constructor.  See the examples below.
	 *
	 * Parameters:
	 * options - {Object}
	 */
	initialize: function (div, options) {

		var newArguments = [];
		//newArguments.push(div, options);
		this.osmLayer = options.osmLayer;
		this.osmLayer.setVisibility(false);
		newArguments.push(div, {
			maxExtent: this.osmLayer.maxExtent,
            units: this.osmLayer.units,
            resolutions: this.osmLayer.resolutions,
            //numZoomLevels: baseLayer.numZoomLevels,
            restrictedExtent:this.osmLayer.maxExtent, // important to set this property so that  itles don't jump around
            tileSize: this.osmLayer.tileSize,
            displayProjection: this.osmLayer.displayProjection,
            startBounds: this.osmLayer.initialExtent});
		GeoER.Map.prototype.initialize.apply(this, newArguments);	

		this.satelliteLayerInfo.title = GeoER.i18n('satellite');
		this.satelliteLayer = new GeoER.Layer.WMS(
				this.satelliteLayerInfo.title,
				this.satelliteLayerInfo.wmsUrl,
				{layers: this.satelliteLayerInfo.wmsLayerName, transparent: true},
				{displayInLayerSwitcher: false, isBaseLayer: true, buffer: 0, singleTile: false, 
					transitionEffect: 'resize', 'tileSize': new OpenLayers.Size(256, 256)}
		);
		this.addLayer(this.satelliteLayer);

		this.streetsLayerInfo.title = GeoER.i18n('streets');
		this.streetsLayer = new GeoER.Layer.WMS(
				this.streetsLayerInfo.title,
				this.streetsLayerInfo.wmsUrl,
				{layers: this.streetsLayerInfo.wmsLayerName, transparent: true},
				{displayInLayerSwitcher: false, visibility: false, isBaseLayer: false, buffer: 0, singleTile: false, 
					transitionEffect: 'resize', 'tileSize': new OpenLayers.Size(256, 256)}
		);
		this.addLayer(this.streetsLayer);

		// add layers button
		this.displayClass = this.CLASS_NAME.replace(/\./g, "");
		var viewsdiv = OpenLayers.Util.createDiv('viewsdiv');
		viewsdiv.className = this.displayClass;
		viewsdiv.style.width = this.VIEW_TYPES.length*80 + "px";
		viewsdiv.style.right = "4px";
		viewsdiv.style.position = "absolute";
		viewsdiv.style.top = "14px";
		viewsdiv.style.zIndex = '10000';

		this.satellitebtn = document.createElement('input');
		this.satellitebtn.className = this.displayClass + 'ItemActive';
		this.satellitebtn.value = GeoER.i18n('satellite');
		this.satellitebtn.type = 'button';
		this.satellitebtn.title = GeoER.i18n('satellite');
		viewsdiv.appendChild(this.satellitebtn);
		OpenLayers.Event.observe(this.satellitebtn, "click", this.setView.bind({state: 'satellite', map: this}));

		this.streetbtn = document.createElement('input');
		this.streetbtn.className = this.displayClass + 'ItemInactive';
		this.streetbtn.value = GeoER.i18n('streets');
		this.streetbtn.type = 'button';
		this.streetbtn.title = GeoER.i18n('streets');
		viewsdiv.appendChild(this.streetbtn);
		OpenLayers.Event.observe(this.streetbtn, "click", this.setView.bind({state: 'street', map: this}));

		this.addLayer(this.osmLayer);
		this.osmbtn = document.createElement('input');
		this.osmbtn.className = this.displayClass + 'ItemInactive';
		this.osmbtn.value = 'OSM';
		this.osmbtn.type = 'button';
		this.osmbtn.title = 'OSM';
		viewsdiv.appendChild(this.osmbtn);
		OpenLayers.Event.observe(this.osmbtn, "click", this.setView.bind({state: 'osm', map: this}));
		this.viewPortDiv.appendChild(viewsdiv);
	},

/**
 * @private
 * Method: setView
 * Set map view (only satellite, only street or both)
 *
 */
setView: function(){
	if(this.map.osmbtn)
		this.map.osmbtn.className = this.map.displayClass + 'ItemInactive';
	if(this.map.streetbtn)
		this.map.streetbtn.className = this.map.displayClass + 'ItemInactive';
	if(this.map.satellitebtn)
		this.map.satellitebtn.className = this.map.displayClass + 'ItemInactive';
	if(this.state == 'satellite'){
		this.map.satellitebtn.className = this.map.displayClass + 'ItemActive';
		this.map.satelliteLayer.setVisibility(true);
		this.map.streetsLayer.setVisibility(false);
		this.map.osmLayer.setVisibility(false);
	}
	else if(this.state == 'street'){
		this.map.streetbtn.className = this.map.displayClass + 'ItemActive';
		this.map.satelliteLayer.setVisibility(false);
		this.map.streetsLayer.setVisibility(true);
		this.map.osmLayer.setVisibility(false);
	}
	else if(this.state == 'osm'){
		this.map.osmbtn.className = this.map.displayClass + 'ItemActive';
		this.map.satelliteLayer.setVisibility(false);
		this.map.streetsLayer.setVisibility(false);
		this.map.osmLayer.setVisibility(true);
	}

},

CLASS_NAME: "GeoER.RERMap_ETRS89_UTM32_OSM"
});
