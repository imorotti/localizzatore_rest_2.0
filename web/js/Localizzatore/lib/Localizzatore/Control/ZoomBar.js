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
Localizzatore.Control.ZoomBar = Localizzatore.Class(OpenLayers.Control.PanZoomBar, {

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
    
    CLASS_NAME: "Localizzatore.Control.ZoomBar"
});
