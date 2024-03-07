/* 
*/

/**
 * 
 */

/**
 * Namespace: GeoER.Util
 */
GeoER.Util = GeoER.Util || {};

/**
 * Property: ImgPath
 * {String} Default is ''.
 */
GeoER.ImgPath = '';

/** 
 * Function: getImagesLocation
 * 
 * Returns:
 * {String} The fully formatted image location string
 */
GeoER.Util.getImagesLocation = function() {
    return GeoER.ImgPath || (GeoER._getScriptLocation() + "img/");
};

GeoER.Util.degfromdms = function (gg, pp, ss) {		
	if (gg > 360) { return '0.000' }				
	if (pp > 60) { return ('0.000') }				
	if (ss > 60) { return ('0.000') }				
   	dd=eval(gg)+eval(pp/60)+eval(ss/3600);
	return (dd);	
};	

GeoER.Util.ggfromdeg = function (dd) {		
	gg = Math.floor(dd);
	if (gg > 360) 
		return ('0');		
	return (gg);	
};

GeoER.Util.ppfromdeg = function (dd, gg) {		
	pp = eval(dd) - eval(gg);
	pp = Math.floor(pp*60);
	return (pp);	
};

GeoER.Util.ssfromdeg = function (dd, gg, pp) {		
	pp = eval(dd) - eval(gg);
	pp = Math.floor(pp*60);
	ss = eval(dd) - eval(gg) - pp/60;
	ss = Math.floor(ss*3600);
	return (ss);	
};
