/**
 * @requires GeoER/Lang.js
 */

/**
 * Namespace: GeoER.Lang["it"]
 * Dictionary for Italian.  Keys for entries are used in calls to
 *     <GeoER.Lang.translate>.  Entry bodies are normal strings or
 *     strings formatted for use with <OpenLayers.String.format> calls.
 */
GeoER.Lang.it = {

		// Dictionary for GeoER/RERMap.js
		'satellite': "Satellite", 
		'streets': "Stradario", 
		'both' : "Mista",
		
		// Dictionary for GeoER/Control/CTS.js
		'WG84': 'WGS 1984, EPSG:4326',
		'WG84_UTM32': 'WGS 1984 UTM Zona 32N, EPSG:32632',
		'WG84_UTM33': 'WGS 1984 UTM Zona 33N, EPSG:32633',
		'UTMRER': 'UTMRER',
		'UTMA': 'UTMA',
		'MM_GREENWICH': 'Monte Mario, EPSG:4265',
		'MM_ITALY1': 'Monte Mario Italia 1, EPSG:3003',
		'MM_ITALY2': 'Monte Mario Italia 2, EPSG:3004',
		'MM_ROME': 'Monte Mario (Roma), EPSG:4806',
		'ED50': 'Datum Europeo 1950, EPSG:4230',
		'ED50_UTM32': 'Datum Europeo 1950 UTM Zona 32N, EPSG:23032',
		'ED50_UTM33': 'Datum Europeo 1950 UTM Zona 33N, EPSG:23033',
		'ETRS89': 'ETRS 1989, EPSG:4258',
		'ETRS89_UTM32': 'ETRS 1989 UTM Zona 32N, EPSG:25832',
		'ETRS89_UTM33': 'ETRS 1989 UTM Zona 33N, EPSG:25833',
		'ctsLegendText': 'Servizio di Conversione delle Coordinate',
		'convertFromText': 'Converti da:',
		'convertToText': 'Converti in:',
		'sessadecimal': 'Sessadecimali',
		'sessagesimal': 'Sessagesimali',
		'longitude': 'Longitudine:',
		'latitude': 'Latitudine:',
		'transform': 'Trasforma',
		'validNumber' : 'Inserire valori numerici validi (es: 122.02)',
		'noSrsOut' : 'Selezionare un sistema di riferimento di output',
		'ctsError': 'Errore durante l\'elaborazione della richiesta',
		'longitudeLabel': 'Longitudine',
		'latitudeLabel': 'Latitudine',
		'eastLabel': 'Est',
		'northLabel': 'Nord',
		
		// Dictionary for GeoER/Control/Geocoding.js
		'geocodingLegendText': "Geocodifica",
		'geocodingSearch': "Cerca",
		'noAddress': 'Inserire un indirizzo da ricercare',
		'geocodingResults': 'Risultati:',
		'geocodingNoResults': 'La ricerca non ha prodotto nessun risultato',
		'geocodingError': 'Errore durante l\'elaborazione della richiesta',
		'geocodingTextExample': 'esempio: Viale Silvani 4/3, bologna, bo',
		
		// Dictionary for GeoER/Control/ReverseGeocoding.js
		'reversegeocodingLegendText': "Geocodifica Inversa",
		'reversegeocodingSelect': "Cliccare un punto sulla mappa",
		'reversegeocodingError': 'Errore durante l\'elaborazione della richiesta',
		'reversegeocodingNoResults': 'La ricerca non ha prodotto nessun risultato',
		
		// Dictionary for GeoER/Control/LayerSwitcher.js
		'baseLayer': "Strati di Base",
		'overlays': "Altri Strati",
		
		// Dictionary for GeoER/Control/License.js
		'license': "Licenze",
		'licenseNoLayers': 'Non ci sono strati cartografici con licenza disponibile',
		
		// Dictionary for GeoER/Control/Download.js
		'download': "Download Strati Cartografici",
		'downloadNoLayers': 'Non ci sono strati cartografici da scaricare',
		'downloadTextLayers': 'Selezione Strati Cartografici',
		'downloadTextArea': 'Selezione Area',
		'downloadTextSRSChoose': 'Selezione Sistema di Riferimento di Output',
		'downloadTextDownload': 'Download',
		'downloadTextVectorLayers': 'Vettoriali',
		'downloadTextRasterLayers': 'Raster',
		'selectArea': 'Scegli area predefinita',
		'drawArea': 'Disegna area personalizzata',
		'downloadTextSelectProvince': 'Seleziona una provincia:',
		'downloadTextSelectMunicipality': 'Seleziona un comune:',
		'downloadTextEmail': 'E-Mail: ',
		'downloadNoSelection': 'Nessuna selezione',
		'downloadAllProvince': 'Tutte le province',
		'downloadLabelPolygonType': 'Seleziona il tipo di poligono:',
		'downloadRegularPolygon': 'Regolare',
		'downloadIrregularPolygon': 'Irregolare',
		'downloadLabelPolygonShape': 'Seleziona la forma:',
		'downloadShapeCircle': 'Cerchio',
		'downloadShapeHexagon': 'Esagono',
		'downloadShapePentagon': 'Pentagono',
		'downloadShapeSquare': 'Quadrato',
		'downloadShapeTriangle': 'Triangolo',
		'downloadExecute': 'Avvia Download',
		'downloadNotImplemented': 'Servizio non ancora supportato',
		'downloadNoArea': 'Selezionare l\'area da scaricare',
		'downloadNoOutputSRS': 'Selezionare un sistema di riferimento di output',
		'downloadNoValidEmail': 'Inserire un indirizzo email corretto',
		'downloadBadResolution': 'Inserire valori di risoluzione corretti',
		'downloadError': 'Errore durante l\'elaborazione della richiesta',
		'downloadSuccess': 'Trasformazione avviata correttamente...Al termine riceverai una email.',
		
		// Dictionary for GeoER/Control/LoadingPanel.js
		'loadingPanelLabel': 'Attendere...'
    
};