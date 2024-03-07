/**
 * @requires GeoER/Lang.js
 */

/**
 * Namespace: GeoER.Lang["en"]
 * Dictionary for English.  Keys for entries are used in calls to
 *     <GeoER.Lang.translate>.  Entry bodies are normal strings or
 *     strings formatted for use with <OpenLayers.String.format> calls.
 */
GeoER.Lang.en = {
		
		// Dictionary for GeoER/RERMap.js
		'satellite': "Satellite", 
		'streets': "Streets", 
		'both' : "Both",
		
		// Dictionary for GeoER/Control/CTS.js
		'WG84': 'WGS 1984, EPSG:4326',
		'WG84_UTM32': 'WGS 1984 UTM Zone 32N, EPSG:32632',
		'WG84_UTM33': 'WGS 1984 UTM Zone 33N, EPSG:32633',
		'UTMRER': 'UTMRER',
		'UTMA': 'UTMA',
		'MM_GREENWICH': 'Monte Mario, EPSG:4265',
		'MM_ITALY1': 'Monte Mario Italy 1, EPSG:3003',
		'MM_ITALY2': 'Monte Mario Italy 2, EPSG:3004',
		'MM_ROME': 'Monte Mario (Rome), EPSG:4806',
		'ED50': 'European Datum 1950, EPSG:4230',
		'ED50_UTM32': 'European Datum 1950 UTM Zone 32N, EPSG:23032',
		'ED50_UTM33': 'European Datum 1950 UTM Zone 33N, EPSG:23033',
		'ETRS89': 'ETRS 1989, EPSG:4258',
		'ETRS89_UTM32': 'ETRS 1989 UTM Zone 32N, EPSG:25832',
		'ETRS89_UTM33': 'ETRS 1989 UTM Zone 33N, EPSG:25833',
		'ctsLegendText': 'Coordinate Transformation Service',
		'convertFromText': 'Convert from:',
		'convertToText': 'Convert to:',
		'sessadecimal': 'Sessadecimal',
		'sessagesimal': 'Sessagesimal',
		'longitude': 'Longitude:',
		'latitude': 'Latitude:',
		'transform': 'Transform',
		'validNumber' : 'Insert a valid number (eg: 122.02)',
		'noSrsOut' : 'Select almost one output spatial reference system',
		'ctsError': 'Error while performing the request',
		'longitudeLabel': 'Longitude',
		'latitudeLabel': 'Latitude',
		'eastLabel': 'East',
		'northLabel': 'Nord',
		
		// Dictionary for GeoER/Control/Geocoding.js
		'geocodingLegendText': "Geocoding",
		'geocodingSearch': "Search",
		'noAddress': 'Insert an address to search',
		'geocodingResults': 'Results:',
		'geocodingNoResults': 'No results found',
		'geocodingError': 'Error while performing the request',
		'geocodingTextExample': 'i.e.: Viale Silvani 4/3, bologna, bo',
		
		// Dictionary for GeoER/Control/ReverseGeocoding.js
		'reversegeocodingLegendText': "Reverse Geocoding",
		'reversegeocodingSelect': "Select the point on the map",
		'reversegeocodingError': 'Error while performing the request',
		'reversegeocodingNoResults': 'No results found',
		
		// Dictionary for GeoER/Control/LayerSwitcher.js
		'baseLayer': "Base Layer",
		'overlays': "Overlays",
		
		// Dictionary for GeoER/Control/License.js
		'license': "Licenses",
		'licenseNoLayers': 'No layers (with license associated) available',
		
		// Dictionary for GeoER/Control/Download.js
		'download': "Download Layers",
		'downloadNoLayers': 'No layers available to download',
		'downloadTextLayers': 'Select Layers',
		'downloadTextArea': 'Select Area',
		'downloadTextSRSChoose': 'Select Output SRS',
		'downloadTextDownload': 'Download',
		'downloadTextVectorLayers': 'Vector',
		'downloadTextRasterLayers': 'Raster',
		'selectArea': 'Select from list',
		'drawArea': 'Draw custom polygon',
		'downloadTextSelectProvince': 'Select province area:',
		'downloadTextSelectMunicipality': 'Select municipality area:',
		'downloadTextEmail': 'E-Mail: ',
		'downloadNoSelection': 'No selection',
		'downloadAllProvince': 'All province',
		'downloadLabelPolygonType': 'Select polygon type:',
		'downloadRegularPolygon': 'Regular',
		'downloadIrregularPolygon': 'Irregular',
		'downloadLabelPolygonShape': 'Select polygon shape:',
		'downloadShapeCircle': 'Circle',
		'downloadShapeHexagon': 'Hexagon',
		'downloadShapePentagon': 'Pentagon',
		'downloadShapeSquare': 'Square',
		'downloadShapeTriangle': 'Triangle',
		'downloadExecute': 'Download',
		'downloadNotImplemented': 'Service not implemented yet',
		'downloadNoArea': 'No valid area selected',
		'downloadNoOutputSRS': 'No output SRS selected',
		'downloadNoValidEmail': 'No valid email address',
		'downloadBadResolution': 'No valid resolution',
		'downloadError': 'Error while performing the request',
		'downloadSuccess': 'Request successfully sent...You will receive an email at the end of the process',
		
		// Dictionary for GeoER/Control/LoadingPanel.js
		'loadingPanelLabel': 'Loading...'
};
