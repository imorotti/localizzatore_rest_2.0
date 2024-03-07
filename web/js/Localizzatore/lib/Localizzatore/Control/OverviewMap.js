/*
 */

/** 
 * @requires GeoER/BaseTypes/Class.js
 * @requires OpenLayers/Control/OverviewMap.js
 * @requires GeoER/Control.js
 * @requires GeoER/Lang.js
 */

/**
 * Class: OpenLayers.Control.OverviewMap
 * The OverMap control creates a small overview map, useful to display the 
 * extent of a zoomed map and your main map and provide additional 
 * navigation options to the User.  By default the overview map is drawn in
 * the lower right corner of the main map. Create a new overview map with the
 * <GeoER.Control.OverviewMap> constructor.
 *
 * Inerits from:
 *  - <OpenLayers.Control.OverviewMap>
 */
Localizzatore.Control.OverviewMap = Localizzatore.Class(GeoER.Control.OverviewMap, {
    CLASS_NAME: 'Localizzatore.Control.OverviewMap'
});
