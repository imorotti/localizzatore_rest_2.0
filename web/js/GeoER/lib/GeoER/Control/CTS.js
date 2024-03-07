/* 
*/

/**
 * @requires GeoER/BaseTypes/Class.js
 * @requires GeoER/Control.js
 * @requires GeoER/Lang.js
 */

/**
 * Class: GeoER.Control.CTS
 * This class performs coordinate transformation
 * 
 * Inherits from:
 *  - <GeoER.Control>
 * 
 */
GeoER.Control.CTS = GeoER.Class(GeoER.Control, {

    /**
     * @private 
	 * Property: id
	 * {String} Control identifier
	 */
    id: null,
    
    /**
  	 * Property: div
	 * {DOMElement} This div is used for showing coordinate transformation input/output fields.
	 */
    div: null,
    
    /**
	 * Property: ctsUrl
	 * {String} Coordinate Transformation Service URL 
	 */
    ctsUrl: null,
    
    /**
     * @private
	 * Property: srsList
	 * {Object} SRS list 
	 */
    srsList: '',
    
	/**
	 * Constructor: GeoER.Control.CTS
	 * Constructor for a new <GeoER.Control.CTS> instance.
	 *
	 * Parameters:
	 * options - {Object}
	 */
    initialize: function (options) {
    	    	  
       OpenLayers.Control.prototype.initialize.apply(this, [options]);		
       
       // create a unique id string, built on the passed in prefix
       this.id = OpenLayers.Util.createUniqueID(this.CLASS_NAME + "_");	   
       
       this.srsList = {
   		'WG84': GeoER.i18n('WG84'),
   		'WG84_UTM32': GeoER.i18n('WG84_UTM32'),
   		'WG84_UTM33': GeoER.i18n('WG84_UTM33'),
   		'UTMRER': GeoER.i18n('UTMRER'),
   		'UTMA': GeoER.i18n('UTMA'),
   		'MM_GREENWICH': GeoER.i18n('MM_GREENWICH'),
   		'MM_ITALY1': GeoER.i18n('MM_ITALY1'),
   		'MM_ITALY2': GeoER.i18n('MM_ITALY2'),
   		'MM_ROME': GeoER.i18n('MM_ROME'),
   		'ED50': GeoER.i18n('ED50'),
   		'ED50_UTM32': GeoER.i18n('ED50_UTM32'),
   		'ED50_UTM33': GeoER.i18n('ED50_UTM33'),
   		'ETRS89': GeoER.i18n('ETRS89'),
   		'ETRS89_UTM32': GeoER.i18n('ETRS89_UTM32'),
   		'ETRS89_UTM33': GeoER.i18n('ETRS89_UTM33')
   		};
    },
    
    /**
     * @private
     * Method: draw
     * Draws the control inside the div component
     *
     * Returns:
	 * {DOMElement}
	 */
    draw: function() {    
       
    	if (this.div!=null)	{
    		
			OpenLayers.Control.prototype.draw.apply(this, arguments);
			
			// assign a class to the panel object
    	    this.div.className = this.CLASS_NAME.replace(/\./g, "");		
    	    
    	    var fieldset = document.createElement('fieldset');
    	    fieldset.style.width = "400px";
    	    this.div.appendChild(fieldset);  
    	    var legend = document.createElement('legend');
    	    fieldset.appendChild(legend);  
    	    var txt = document.createTextNode(GeoER.i18n('ctsLegendText'));
    	    legend.appendChild(txt);
    	    
    	    var divsrschoose = document.createElement('div');
    	    divsrschoose.className = this.div.className + 'SRSChoose';
    	    var p = document.createElement('p');
    	    var txt = document.createTextNode(GeoER.i18n('convertFromText'));
    	    p.appendChild(txt);
    	    divsrschoose.appendChild(p);
    	    
    	    var selectFrom = document.createElement('select');
    	    selectFrom.id = 'select_conv_from';
    	    selectFrom.className = this.div.className + 'SRSFrom';
    	    for(var item in this.srsList){
    	    	var option = document.createElement("option");
        	    option.text = this.srsList[item];
        	    option.value = item;
        	    try {
        	    	selectFrom.add(option,null); // Standards compliant.
    		    } catch (e) {
    		    	selectFrom.add(option);      // IE only version.
    		    }
			}
    	    divsrschoose.appendChild(selectFrom);
    	    
    	    p = document.createElement('p');
    	    var txt = document.createTextNode(GeoER.i18n('convertToText'));
    	    p.appendChild(txt);
    	    divsrschoose.appendChild(p);
    	    
    	    var divsrsto = document.createElement('div');
    	    divsrsto.id = 'convToDiv';
    	    divsrsto.className = this.div.className + 'SRSTo';
    	    for(var item in this.srsList){
    	    	var span = document.createElement('span');
        	    var inputitem = document.createElement('input');
        	    inputitem.id = "check_" + item;
        	    inputitem.type = "checkbox";
        	    if(item == 'WG84')
        	    	inputitem.disabled = true;
        	    inputitem.name = item;
        	    span.appendChild(inputitem);
        	    var labelitem = document.createElement('label');
        	    txt = document.createTextNode(this.srsList[item]);
        	    labelitem.appendChild(txt);
        	    span.appendChild(labelitem);
        	    var br = document.createElement('br');
        	    span.appendChild(br);
        	    span.style.whiteSpace = "nowrap";
        	    divsrsto.appendChild(span);
			}
    	    divsrschoose.appendChild(divsrsto);
    	    fieldset.appendChild(divsrschoose);
    	    
    	    var divpoint = document.createElement('div');
    	    divpoint.className = this.div.className + 'Point';
    	    
    	    appdiv = document.createElement('div');
    	    appdiv.className = this.div.className + 'Radio';
    	    appinput = document.createElement('input');
    	    appinput.type = "radio";
    	    appinput.id = "sessadecimali";
    	    appinput.name = "pointstyle";
    	    appinput.value = GeoER.i18n('sessadecimal');
    	    appinput.checked = true;
    	    OpenLayers.Event.observe(appinput, "click", this.changeRadio.bind({element: appinput, cts: this}));
    	    appdiv.appendChild(appinput);
    	    var applabel = document.createElement('label');
    	    txt = document.createTextNode(GeoER.i18n('sessadecimal'));
    	    appdiv.appendChild(txt);
    	    
    	    appdiv.appendChild(document.createTextNode('   '));
    	    appinput = document.createElement('input');
    	    appinput.type = "radio";
    	    appinput.id = "sessagesimali";
    	    appinput.name = "pointstyle";
    	    appinput.value = GeoER.i18n('sessagesimal');
    	    OpenLayers.Event.observe(appinput, "click", this.changeRadio.bind({element: appinput, cts: this}));
    	    appdiv.appendChild(appinput);
    	    applabel = document.createElement('label');
    	    txt = document.createTextNode(GeoER.i18n('sessagesimal'));
    	    appdiv.appendChild(txt);
    	    divpoint.appendChild(appdiv);
    	    
    	    var table = document.createElement('table');
    	    table.className = this.div.className + 'Table';
    	    var tbody = document.createElement('tbody');
    	    var tr = document.createElement('tr');
    	    var td = document.createElement('td');
    	    var labellong = document.createElement('label');
    	    labellong.id = "xlabel";
    	    txt = document.createTextNode(GeoER.i18n('longitude'));
    	    labellong.appendChild(txt);
    	    td.appendChild(labellong);
    	    tr.appendChild(td);
    	    td = document.createElement('td');

    	    var appdiv = document.createElement('div');
    	    appdiv.id = "xvalsessadecimale";
    	    var appinput = document.createElement('input');
    	    appinput.type = "Text";
    	    appinput.id = "xvalue";
    	    appinput.name = "xvalue";
    	    appinput.value = "0.000";
    	    appdiv.appendChild(appinput);
    	    td.appendChild(appdiv);
    	    
    	    appdiv = document.createElement('div');
    	    appdiv.id = "xvalsessagesimale";
    	    appdiv.style.display = "none";
    	    appdiv.className = this.div.className + 'Sessag';
    	    appinput = document.createElement('input');
    	    appinput.type = "Text";
    	    appinput.id = "xvaluegradi";
    	    appinput.name = "xvaluegradi";
    	    appinput.value = "0";
    	    appdiv.appendChild(appinput);
    	    appdiv.appendChild(document.createTextNode('° '));
    	    appinput = document.createElement('input');
    	    appinput.type = "Text";
    	    appinput.id = "xvalueprimi";
    	    appinput.name = "xvalueprimi";
    	    appinput.value = "0";
    	    appdiv.appendChild(appinput);
    	    appdiv.appendChild(document.createTextNode('\' '));
    	    appinput = document.createElement('input');
    	    appinput.type = "Text";
    	    appinput.id = "xvaluesecondi";
    	    appinput.name = "xvaluesecondi";
    	    appinput.value = "0.000";
    	    appdiv.appendChild(appinput);
    	    appdiv.appendChild(document.createTextNode('\'\' '));
    	    td.appendChild(appdiv);
    	    tr.appendChild(td);
    	    tbody.appendChild(tr);
    	    
    	    tr = document.createElement('tr');
    	    td = document.createElement('td');
    	    var labellat = document.createElement('label');
    	    txt = document.createTextNode(GeoER.i18n('latitude'));
    	    labellat.id = "ylabel";
    	    labellat.appendChild(txt);
    	    td.appendChild(labellat);
    	    tr.appendChild(td);
    	    td = document.createElement('td');

    	    var appdiv = document.createElement('div');
    	    appdiv.id = "yvalsessadecimale";
    	    var appinput = document.createElement('input');
    	    appinput.type = "Text";
    	    appinput.id = "yvalue";
    	    appinput.name = "yvalue";
    	    appinput.value = "0.000";
    	    appdiv.appendChild(appinput);
    	    td.appendChild(appdiv);
    	    
    	    appdiv = document.createElement('div');
    	    appdiv.id = "yvalsessagesimale";
    	    appdiv.style.display = "none";
    	    appdiv.className = this.div.className + 'Sessag';
    	    appinput = document.createElement('input');
    	    appinput.type = "Text";
    	    appinput.id = "yvaluegradi";
    	    appinput.name = "yvaluegradi";
    	    appinput.value = "0";
    	    appdiv.appendChild(appinput);
    	    appdiv.appendChild(document.createTextNode('° '));
    	    appinput = document.createElement('input');
    	    appinput.type = "Text";
    	    appinput.id = "yvalueprimi";
    	    appinput.name = "yvalueprimi";
    	    appinput.value = "0";
    	    appdiv.appendChild(appinput);
    	    appdiv.appendChild(document.createTextNode('\' '));
    	    appinput = document.createElement('input');
    	    appinput.type = "Text";
    	    appinput.id = "yvaluesecondi";
    	    appinput.name = "yvaluesecondi";
    	    appinput.value = "0.000";
    	    appdiv.appendChild(appinput);
    	    appdiv.appendChild(document.createTextNode('\'\' '));
    	    td.appendChild(appdiv);
    	    tr.appendChild(td);
    	    tbody.appendChild(tr);
    	    
    	    tbody.appendChild(tr);
    	    table.appendChild(tbody);
    	    divpoint.appendChild(table);
    	    fieldset.appendChild(divpoint);
    	    
    	    appdiv = document.createElement('div');
    	    appdiv.className = this.div.className + 'Convert';
    	    var convertBtn = document.createElement('input');
    	    convertBtn.value = GeoER.i18n('transform');
    	    convertBtn.type = 'button';
    	    convertBtn.title = GeoER.i18n('transform');
    	    appdiv.appendChild(convertBtn);
	        fieldset.appendChild(appdiv);
	        OpenLayers.Event.observe(convertBtn, "click", this.invokeCTS.bind({cts: this}));
	        
    	    // results panel
	        this.divLoading = document.createElement('div');
	        this.divLoading.className = this.div.className + 'Loading';
	        this.divLoading.style.display = 'none';
	        var img = document.createElement('img');
	        img.src = GeoER.Util.getImagesLocation() + 'loading.gif';
	        this.divLoading.appendChild(img);
	        fieldset.appendChild(this.divLoading);
	        this.divResults = document.createElement('div');
	        this.divResults.className = this.div.className + 'Results';
	        this.divResults.style.display = 'none';
	        fieldset.appendChild(this.divResults);
	        
	        OpenLayers.Event.observe(selectFrom, "change", this.onChange.bind({selectFrom: selectFrom, divsrsto: divsrsto, cts: this}));
		}        
		return this.div;
    },

    /**
     * @private
     * Method: onChange
     * Observe onchange listener on select with input srs 
	 *
     * Parameters:
     * 
	 */
    onChange: function(){
    	
    	document.getElementById('xvalue').value = '0.000';
    	document.getElementById('yvalue').value = '0.000';
    	
    	var app = this.cts.getXYLabels(this.selectFrom.value);
    	
    	document.getElementById('xlabel').innerHTML = app[0] + ':';
    	document.getElementById('ylabel').innerHTML = app[1] + ':';

    	// disabilito il check del srs di output
    	var collection = this.divsrsto.getElementsByTagName('input');
    	for (var x=0; x<collection.length; x++) {
        	if (collection[x].type.toUpperCase() == 'CHECKBOX'){
			collection[x].checked = false;
        		collection[x].disabled = false;
        	}
    	}

    	document.getElementById('check_' + this.selectFrom.value).disabled = true;
    },
    
    /**
     * @private
     * Method: changeRadio
     * Observe onchange listener on radio button
	 *
     * Parameters:
	 */
    changeRadio: function (){
    	if(this.element.value == GeoER.i18n('sessadecimal')){
    		document.getElementById('xvalsessadecimale').style.display = 'inline';
    		document.getElementById('xvalsessagesimale').style.display = 'none';
    		document.getElementById('yvalsessadecimale').style.display = 'inline';
    		document.getElementById('yvalsessagesimale').style.display = 'none';
    		this.cts.convertToSessadecimali();
    	}
    	else if(this.element.value == GeoER.i18n('sessagesimal')){
    		document.getElementById('xvalsessadecimale').style.display = 'none';
    		document.getElementById('xvalsessagesimale').style.display = 'inline';
    		document.getElementById('yvalsessadecimale').style.display = 'none';
    		document.getElementById('yvalsessagesimale').style.display = 'inline';
    		this.cts.convertToSessagesimali();
    	}
    },

    /**
     * @private
     * Method: convertToSessadecimali
     * Converts from sessagesimal to sessadecimal
	 *
     * Parameters:
	 */
    convertToSessadecimali: function (){

    	var xvaluegradi = document.getElementById('xvaluegradi').value;
    	var xvalueprimi = document.getElementById('xvalueprimi').value;
    	var xvaluesecondi = document.getElementById('xvaluesecondi').value;
    	if(!OpenLayers.String.isNumeric(xvaluegradi) || !OpenLayers.String.isNumeric(xvalueprimi) || !OpenLayers.String.isNumeric(xvaluesecondi)){
    		document.getElementById('xvalue').value = '0.000';
    	}
    	else
    		document.getElementById('xvalue').value = this.formatCoordinates(document.getElementById('select_conv_from').value, GeoER.Util.degfromdms(xvaluegradi, xvalueprimi, xvaluesecondi));
    	
    	var yvaluegradi = document.getElementById('yvaluegradi').value;
    	var yvalueprimi = document.getElementById('yvalueprimi').value;
    	var yvaluesecondi = document.getElementById('yvaluesecondi').value;
    	if(!OpenLayers.String.isNumeric(yvaluegradi) || !OpenLayers.String.isNumeric(yvalueprimi) || !OpenLayers.String.isNumeric(yvaluesecondi)){
    		document.getElementById('yvalue').value = '0.000';
    	}
    	else
    		document.getElementById('yvalue').value = this.formatCoordinates(document.getElementById('select_conv_from').value, GeoER.Util.degfromdms(yvaluegradi, yvalueprimi, yvaluesecondi));

    },
    
    /**
     * @private
     * Method: convertToSessagesimali
     * Converts from sessadecimal to sessagesimal
	 *
     * Parameters:
	 */
    convertToSessagesimali: function (){

    	var xval = document.getElementById('xvalue').value;
    	var yval = document.getElementById('yvalue').value;
    	if(!OpenLayers.String.isNumeric(xval)){
    		document.getElementById('xvaluegradi').value = '0.000';
    		document.getElementById('xvalueprimi').value = '0';
    		document.getElementById('xvaluesecondi').value = '0';
    	}

    	if(!OpenLayers.String.isNumeric(yval)){
    		document.getElementById('yvaluegradi').value = '0.000';
    		document.getElementById('yvalueprimi').value = '0';
    		document.getElementById('yvaluesecondi').value = '0';
    	}

    	document.getElementById('xvaluegradi').value = GeoER.Util.ggfromdeg(xval);
    	document.getElementById('xvalueprimi').value = GeoER.Util.ppfromdeg(xval, document.getElementById('xvaluegradi').value);
    	document.getElementById('xvaluesecondi').value = GeoER.Util.ssfromdeg(xval, document.getElementById('xvaluegradi').value, document.getElementById('xvalueprimi').value);	

    	document.getElementById('yvaluegradi').value = GeoER.Util.ggfromdeg(yval);
    	document.getElementById('yvalueprimi').value = GeoER.Util.ppfromdeg(yval, document.getElementById('yvaluegradi').value);
    	document.getElementById('yvaluesecondi').value = GeoER.Util.ssfromdeg(yval, document.getElementById('yvaluegradi').value, document.getElementById('yvalueprimi').value);
    },
    
    /**
     * @private
     * Method: invokeCTS
     * Performs the coordinate transformation process
	 *
     * Parameters:
     * 
	 */
     invokeCTS: function () {
     	
    	var convfrom = document.getElementById('select_conv_from').value;

    	if(document.getElementById('sessagesimali').checked){
    		var xvaluegradi = document.getElementById('xvaluegradi').value;
    		var xvalueprimi = document.getElementById('xvalueprimi').value;
    		var xvaluesecondi = document.getElementById('xvaluesecondi').value;
    		if(!OpenLayers.String.isNumeric(xvaluegradi) || !OpenLayers.String.isNumeric(xvalueprimi) || !OpenLayers.String.isNumeric(xvaluesecondi)){
    			alert(GeoER.i18n('validNumber'));
    			return;
    		}
    		var yvaluegradi = document.getElementById('yvaluegradi').value;
    		var yvalueprimi = document.getElementById('yvalueprimi').value;
    		var yvaluesecondi = document.getElementById('yvaluesecondi').value;
    		if(!OpenLayers.String.isNumeric(yvaluegradi) || !OpenLayers.String.isNumeric(yvalueprimi) || !OpenLayers.String.isNumeric(yvaluesecondi)){
    			alert(GeoER.i18n('validNumber'));
    			return;
    		}
    		this.cts.convertToSessadecimali();
    	}

    	var xval = document.getElementById('xvalue').value;
    	var yval = document.getElementById('yvalue').value;
    	if(!OpenLayers.String.isNumeric(xval) || !OpenLayers.String.isNumeric(yval)){
    		alert(GeoER.i18n('validNumber'));
    		return;
    	}

    	var convto = '';
    	
    	var collection = document.getElementById('convToDiv').getElementsByTagName('input');
        for (var x=0; x<collection.length; x++) {
            if (collection[x].type.toUpperCase() == 'CHECKBOX'){
            	if(collection[x].checked){
            		convto += collection[x].name + ',';
            	}
            }
        }
        
        // tolgo l'ultima virgola
        if(convto == ''){
        	alert(GeoER.i18n('noSrsOut'));
        	return;
        }
        else 
        	convto = convto.substring(0, convto.length-1);
        
    	var urlRequest = this.cts.ctsUrl + "x=" + xval + "&y=" + yval + "&from=" + convfrom + "&to=" + convto;
    	urlRequest += "&key=" + GeoER.APIKey;
    	this.cts.divLoading.style.display = 'block';
    	this.cts.divResults.style.display = 'none';
    	
    	var successCTSFunc = this.cts.successCTS.bind(this.cts);
		var failureCTSFunc = this.cts.failureCTS.bind(this.cts);

		new OpenLayers.Ajax.Request(urlRequest,
                 {   method: 'get',
                     parameters: null,                             
                     onComplete: successCTSFunc,
                     onFailure: failureCTSFunc
                  }
        );
     },   
     
    /**
     * @private 
     * Method: successCTS
     *
 	 * Parameters:
 	 * request - {} Ajax request
 	 */
     successCTS: function (request) { 
    	 
 		 if (request.responseXML == null || request.responseText==null){
 			 return;
 	     }
 	    
 	     var xmlResponse = request.responseXML;
 	     if (!xmlResponse || request.fileType!="XML") { //for IE compatibility
 	         xmlResponse = OpenLayers.parseXMLString(request.responseText);       
 	     }	    	
 	    
	     var items = xmlResponse.getElementsByTagName("Result");
	     var responsehtml = '';
	     this.divLoading.style.display = 'none';
	     this.divResults.innerHTML = '';
    	 this.divResults.style.display = 'block';
	     if(items.length == 0){
	    	 var appdiv = document.createElement("div");
	    	 appdiv.className = this.div.className + 'ResultsError';
	    	 appdiv.appendChild(document.createTextNode(GeoER.i18n('ctsError')));
	    	 this.divResults.appendChild(appdiv);
	    	 return;
	     }
	     for (i = 0; i < items.length; i++) {
	         var item = items[i];
	         var resfrom = item.getAttribute('from');
	         var resto = item.getAttribute('to');
	         var res = '';
	         if (window.ActiveXObject)
	        	 res = item.childNodes[0].nodeValue;
	         else
	        	 res = item.textContent;
	         
	         var appdiv = document.createElement("div");
        	 appdiv.className = this.div.className + 'ResultsItem';
        	 appdiv.appendChild(document.createTextNode(this.srsList[resto]));
        	 this.divResults.appendChild(appdiv);
        	 appdiv = document.createElement("div");
        	 appdiv.className = this.div.className + 'ResultsItemValue';
        	 
	         var xylabels = this.getXYLabels(resto);
	         if(res.indexOf('Error') == -1){
	        	 var xy = res.split(' ');
	        	 appdiv.appendChild(document.createTextNode(xylabels[0] + ': ' + xy[0] + '   ' + xylabels[1] + ': ' + xy[1]));
	         }
	         else {
	        	 appdiv.appendChild(document.createTextNode(GeoER.i18n('ctsError')));
	         }
	         this.divResults.appendChild(appdiv);
	     }
 	    
     },

 	/**
     * @private 
     * Method: failureCTS
     *
 	 * Parameters:
 	 * request - {} Ajax request
 	 */
     failureCTS: function (request) {
    	 this.divLoading.style.display = 'none';
    	 this.divResults.innerHTML = '';
    	 this.divResults.style.display = 'block';
    	 var appdiv = document.createElement("div");
    	 appdiv.className = this.div.className + 'ResultsError';
    	 appdiv.appendChild(document.createTextNode(GeoER.i18n('ctsError')));
    	 this.divResults.appendChild(appdiv);
    	 return;
    },
     
    /**
     * @private
     * Method: getXYLabels
     * Returns label text according to srs code
 	 *
     * Parameters:
     * srscode - {String} srs code (contained in srsList)
     * 
 	 */
     getXYLabels: function (srscode){
    		
		if(srscode=='ETRS89_UTM32' || 
				srscode=='ETRS89_UTM33' ||
				srscode=='ED50_UTM32' ||
				srscode=='ED50_UTM33' ||
				srscode=='MM_ITALY1' ||
				srscode=='MM_ITALY2' ||
				srscode=='UTMA' ||
				srscode=='UTMRER' ||
				srscode=='WG84_UTM32' ||
				srscode=='WG84_UTM33'){
			return new Array(GeoER.i18n('eastLabel'), GeoER.i18n('northLabel'));
		}
		else {
			// cioè in questi casi: ETRS89, ED50, MM_ROME, MM_GREENWICH, WG84 
			return new Array(GeoER.i18n('longitudeLabel'), GeoER.i18n('latitudeLabel'));
		}
	},
	
	formatCoordinates: function (srscode, number){
		if(srscode=='ETRS89_UTM32' || 
				srscode=='ETRS89_UTM33' ||
				srscode=='ED50_UTM32' ||
				srscode=='ED50_UTM33' ||
				srscode=='MM_ITALY1' ||
				srscode=='MM_ITALY2' ||
				srscode=='UTMA' ||
				srscode=='UTMRER' ||
				srscode=='WG84_UTM32' ||
				srscode=='WG84_UTM33'){
			return number.toFixed(1);
		}
		else {
			// cioè in questi casi: ETRS89, ED50, MM_ROME, MM_GREENWICH, WG84 
			return number.toFixed(6);
		}
	},
     
    CLASS_NAME: "GeoER.Control.CTS"
});