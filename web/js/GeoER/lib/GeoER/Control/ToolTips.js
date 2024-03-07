/* 
 */


/**
 * @requires GeoER/BaseTypes/Class.js
 * @requires OpenLayers/Control.js
 * @requires GeoER/Control.js
 * @requires GeoER/Lang.js
 */

/**
 * Class: GeoER.Control.ToolTips
 *
 * Inherits from:
 *  - <OpenLayers.Control>
 */
GeoER.Control.ToolTips = GeoER.Class(OpenLayers.Control, {

	/**
	 * Property: element
	 * {DOMElement} The DOM element that contains the toolTips Element
	 */
	element: null,

	/** 
	 * Property: lastXy
	 * {<OpenLayers.LonLat>}
	 */
	lastXy: null,

	/**
	 * Constructor: OpenLayers.Control.MousePosition
	 * 
	 * Parameters:
	 * options - {DOMElement} Options for control.
	 */
	initialize: function(options) {
		//Extend with new arguments 
		var newArguments = [];
		OpenLayers.Util.extend(this, options);
		OpenLayers.Control.prototype.initialize.apply(this, arguments);
		this.displayClass = this.CLASS_NAME.replace(/\./g, "");
	},

	/**
	 * Method: destroy
	 */
	destroy: function() {
		if (this.map) {
			this.map.events.unregister('mousemove', this, this.redraw);
		}
		OpenLayers.Control.prototype.destroy.apply(this, arguments);
	},	

	/**
	 * Method: draw
	 * Used with the mapadd.Control
	 * {DOMElement}
	 */    
	draw: function() {
		
		OpenLayers.Control.prototype.draw.apply(this, arguments);
		
		// Create the Div in the DOM
		// Div background
		this.divBgTtips = document.createElement("div");
		this.divBgTtips.id = OpenLayers.Util.createUniqueID("divBgTtips");
		this.divBgTtips.className = this.displayClass + 'Background';
		this.divBgTtips.style.display = "none";
		this.divBgTtips.style.zIndex = "100000";
		this.divBgTtipsTx = document.createElement("span");
		this.divBgTtips.appendChild(this.divBgTtipsTx);		
		this.map.div.appendChild(this.divBgTtips);		

		this.divTxTtips = document.createElement("div");
		this.divTxTtips.id = OpenLayers.Util.createUniqueID("divTxTtips");
		this.divTxTtips.className = this.displayClass + 'Text';
		this.divTxTtips.style.color = this.textColor;						
		this.divTxTtips.style.display = "none";
		this.divTxTtips.style.zIndex = "100001";
		this.map.div.appendChild(this.divTxTtips); 
		this.map.events.register('mousemove', this, this.redraw);
	},

	/**
	 * Method: show
	 * Show the tooltips on the map
	 */ 
	show : function(valueHTML){	
		this.divBgTtipsTx.innerHTML = valueHTML.html;
		this.divBgTtipsTx.style.visibility = "hidden";
		this.divTxTtips.innerHTML = valueHTML.html;
		this.divTxTtips.style.display = "block";
		this.divBgTtips.style.display = "block";
	},

	/**
	 * Method: hide
	 * hide the tooltips on the map   
	 */ 
	hide : function(){
		this.divBgTtips.style.display = "none";		
		this.divTxTtips.style.display = "none";		
	},

	/**
	 * Method: findXYmap
	 * To Know the position of the map in the HTML  
	 */ 
	findXYMap : function(obj){
		var x=0,y=0;
		while (obj!=null){
			x+=obj.offsetLeft-obj.scrollLeft;
			y+=obj.offsetTop-obj.scrollTop;
			obj=obj.offsetParent;
		}
		return {x:x,y:y};
	},	

	/**
	 * Method: redraw the div
	 * with new position params
	 */
	redraw: function(evt) {	
		marginPos = this.findXYMap(document.getElementById(this.map.div.id));
		this.divBgTtips.style.left = ((evt.xy.x+marginPos.x)+22)+"px";
		this.divBgTtips.style.top = ((evt.xy.y+marginPos.y)-12)+"px";	
		this.divTxTtips.style.left = ((evt.xy.x+marginPos.x)+22)+"px";
		this.divTxTtips.style.top = ((evt.xy.y+marginPos.y)-12)+"px";
	},  

	CLASS_NAME: "GeoER.Control.ToolTips"
});
