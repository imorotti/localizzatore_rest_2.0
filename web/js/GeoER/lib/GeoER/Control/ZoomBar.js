/* 
*/


/**
 * @requires GeoER/BaseTypes/Class.js
 * @requires OpenLayers/Control/PanZoomBar.js
 * @requires GeoER/Control.js
 * @requires GeoER/Lang.js
 */

/**
 * Class: GeoER.Control.ZoomBar
 * The ZoomBar is a visible control composed of a <OpenLayers.Control.ZoomBar>.
 *
 * Inherits from:
 *  - <OpenLayers.Control.PanZoomBar>
 */
GeoER.Control.ZoomBar = GeoER.Class(OpenLayers.Control.PanZoomBar, {

    /** 
     * APIProperty: zoomStopWidth
     */
    zoomStopWidth: 28,

    /** 
     * APIProperty: zoomStopHeight
     */
    zoomStopHeight: 16,

    /**
    * Method: draw 
    *
    * Parameters:
    * px - {<OpenLayers.Pixel>} 
    */
    draw: function(px) {
        // initialize our internal div
        OpenLayers.Control.prototype.draw.apply(this, arguments);
        px = this.position.clone();
        // place the controls
        this.buttons = [];

        var sz = new OpenLayers.Size(28,25);
        var centered = new OpenLayers.Pixel(2, 26);
        var wposition = sz.w;
        
        px.y = centered.y+sz.h;

        this._addButton("zoomin", "zoomin.png", centered.add(0, 0), sz);
        centered = this._addZoomBar(centered.add(0, 25));
        var sz = new OpenLayers.Size(28,26);
        this._addButton("zoomout", "zoomout.png", new OpenLayers.Pixel(2, 206), sz);
        return this.div;
    },

    /** 
    * Method: _addZoomBar
    * 
    * Parameters:
    * location - {<OpenLayers.Pixel>} where zoombar drawing is to start.
    */
    _addZoomBar:function(centered) {
    	
        var imgLocation = GeoER.Util.getImagesLocation();
        var id = this.id + "_" + this.map.id;
        var zoomsToEnd = this.map.getNumZoomLevels() - 1 - this.map.getZoom();
        var slider = OpenLayers.Util.createAlphaImageDiv(id,
              centered.add(5, zoomsToEnd * this.zoomStopHeight), 
              new OpenLayers.Size(18,18), 
              imgLocation + "slider.png",
              "absolute");
        this.slider = slider;
        this.slider.style.zIndex=700;

        this.sliderEvents = new OpenLayers.Events(this, slider, null, true,
                 {includeXY: true});
        this.sliderEvents.on({
         "mousedown": this.zoomBarDown,
         "mousemove": this.zoomBarDrag,
         "mouseup": this.zoomBarUp,
         "dblclick": this.doubleClick,
         "click": this.doubleClick
        });
        
        var sz = new OpenLayers.Size();
        //sz.h = this.zoomStopHeight * this.map.getNumZoomLevels();
        sz.h=155;
        sz.w = this.zoomStopWidth;
        var div = null;
        
        if (OpenLayers.Util.alphaHack()) {
         var id = this.id + "_" + this.map.id;
         div = OpenLayers.Util.createAlphaImageDiv(id, centered,
                 new OpenLayers.Size(sz.w, 
                 sz.h),
                 imgLocation + "zoombar.png", 
                 "absolute", null, "crop");
         div.style.height = sz.h + "px";
        } else {
         div = OpenLayers.Util.createDiv(
            'OpenLayers_Control_PanZoomBar_Zoombar' + this.map.id,
            centered,
            sz,
            imgLocation+"zoombar.png");
        }
        
        this.zoombarDiv = div;
        
        this.divEvents = new OpenLayers.Events(this, div, null, true, 
                  {includeXY: true});
        this.divEvents.on({
         "mousedown": this.divClick,
         "mousemove": this.passEventToSlider,
         "dblclick": this.doubleClick,
         "click": this.doubleClick
        });
        
        this.div.appendChild(div);

        this.startTop = parseInt(div.style.top);
        this.div.appendChild(slider);

        this.map.events.register("zoomend", this, this.moveZoomBar);

        centered = centered.add(0, 
         this.zoomStopHeight * this.map.getNumZoomLevels());
        return centered; 
    },
    
    /**
     * Method: _addButton
     * 
     * Parameters:
     * id - {String} 
     * img - {String} 
     * xy - {<OpenLayers.Pixel>} 
     * sz - {<OpenLayers.Size>} 
     * 
     * Returns:
     * {DOMElement} A Div (an alphaImageDiv, to be precise) that contains the
     *     image of the button, and has all the proper event handlers set.
     */
    _addButton:function(id, img, xy, sz) {
        var imgLocation = GeoER.Util.getImagesLocation() + img;
        var btn = OpenLayers.Util.createAlphaImageDiv(
                                    this.id + "_" + id, 
                                    xy, sz, imgLocation, "absolute");

        //we want to add the outer div
        this.div.appendChild(btn);

        OpenLayers.Event.observe(btn, "mousedown", 
            OpenLayers.Function.bindAsEventListener(this.buttonDown, btn));
        OpenLayers.Event.observe(btn, "dblclick", 
            OpenLayers.Function.bindAsEventListener(this.doubleClick, btn));
        OpenLayers.Event.observe(btn, "click", 
            OpenLayers.Function.bindAsEventListener(this.doubleClick, btn));
        btn.action = id;
        btn.map = this.map;
    
        if(!this.slideRatio){
            var slideFactorPixels = this.slideFactor;
            var getSlideFactor = function() {
                return slideFactorPixels;
            };
        } else {
            var slideRatio = this.slideRatio;
            var getSlideFactor = function(dim) {
                return this.map.getSize()[dim] * slideRatio;
            };
        }

        btn.getSlideFactor = getSlideFactor;

        //we want to remember/reference the outer div
        this.buttons.push(btn);
        return btn;
    },
    
    CLASS_NAME: "GeoER.Control.ZoomBar"
});
