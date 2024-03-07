var map = null;

//parametri di default del normalizzatore
var normalizzatoreUrl = "https://servizigis.regione.emilia-romagna.it/normalizzatore";
var localizzatoreUrl = "http://localhost:8080/localizzatore_rest";
var tipo_coord = 'UTMRER';
var rif_geo_civ = 'PCIV';
var idLRS = "percorsim";
var handle = null;
var normalizzatoreUser = null;
var normalizzatorePwd = null;
var normalizzatoreId = null;
var normalizzatoreSRID = "EPSG:5659";
var url = null;
var ricercaSemplice = false;

//layer per geoLocInversa
var layerCivici;
var layerToponimi;
var layerComuni;

//lista risultati ottenuti e risultato corrente
var results = [];
var currResult = null;

//comune e provincia preimpostati
var currComune;
var currProvincia;

//risultati ricerca libera
var resultsRicerca = null;

function init(map_id, localizzatore_panel_id, ricerca_panel_id, options) {   
    //definizione sistemi di riferimento
    proj4.defs("EPSG:5659","+proj=tmerc +lat_0=0 +lon_0=9 +k=0.9996 +x_0=500053 +y_0=-3999820 +ellps=intl +towgs84=-104.1,-49.1,-9.9,0.971,-2.917,0.714,-11.68 +units=m +no_defs");  //UTMRER
    proj4.defs("EPSG:3003","+proj=tmerc +lat_0=0 +lon_0=9 +k=0.9996 +x_0=1500000 +y_0=0 +ellps=intl +towgs84=-104.1,-49.1,-9.9,0.971,-2.917,0.714,-11.68 +units=m +no_defs");
    proj4.defs("EPSG:3004","+proj=tmerc +lat_0=0 +lon_0=15 +k=0.9996 +x_0=2520000 +y_0=0 +ellps=intl +towgs84=-104.1,-49.1,-9.9,0.971,-2.917,0.714,-11.68 +units=m +no_defs");
    proj4.defs("EPSG:4806","+proj=longlat +ellps=intl +towgs84=-104.1,-49.1,-9.9,0.971,-2.917,0.714,-11.68 +pm=rome +no_defs");
    proj4.defs("EPSG:4230","+proj=longlat +ellps=intl +towgs84=-87,-98,-121,0,0,0,0 +no_defs");
    proj4.defs("EPSG:23032","+proj=utm +zone=32 +ellps=intl +towgs84=-87,-98,-121,0,0,0,0 +units=m +no_defs");
    proj4.defs("EPSG:23033","+proj=utm +zone=33 +ellps=intl +towgs84=-87,-98,-121,0,0,0,0 +units=m +no_defs");
    proj4.defs("EPSG:4258","+proj=longlat +ellps=GRS80 +towgs84=0,0,0,0,0,0,0 +no_defs");
    proj4.defs("EPSG:25832","+proj=utm +zone=32 +ellps=GRS80 +towgs84=0,0,0,0,0,0,0 +units=m +no_defs");
    proj4.defs("EPSG:25833","+proj=utm +zone=33 +ellps=GRS80 +towgs84=0,0,0,0,0,0,0 +units=m +no_defs");
    proj4.defs("EPSG:32632","+proj=utm +zone=32 +datum=WGS84 +units=m +no_defs");
    proj4.defs("EPSG:32633","+proj=utm +zone=33 +datum=WGS84 +units=m +no_defs");
       
    if (ol.proj.proj4 != undefined)
        ol.proj.proj4.register(proj4);
    
    //gestione della storia
    var shouldSave = false;
    var historyArray = [];
    var currIndex = 0;
    var extentsList = [];
    var currExtentIndex = -1;
    
    //extent e center di default
    var defaultCenter = [1210572, 5530000];
    var defaultExtent = [1001144, 5400000, 1420000, 5660000];
    
    //applicazione delle options se presenti
    if (options) {
        if (options.localizzatoreUrl) {
            localizzatoreUrl = options.localizzatoreUrl;
        }
        if (options.normalizzatoreHandle) {
            handle = options.normalizzatoreHandle;
        }
        if (options.normalizzatoreUrl) {
            normalizzatoreUrl = options.normalizzatoreUrl;
        }
        if (options.normalizzatoreUser) {
            normalizzatoreUser = options.normalizzatoreUser;
        }
        if (options.normalizzatorePwd) {
            normalizzatorePwd = options.normalizzatorePwd;
        }
        if (options.normalizzatoreId) {
            normalizzatoreId = options.normalizzatoreId;
        }
        if (options.tipo_coord) {
            
            switch (options.tipo_coord) {
                case "UTMRER":
                    normalizzatoreSRID = 'EPSG:5659';
                    break;
                case "GBO":
                    normalizzatoreSRID = 'EPSG:3003';
                    break;
                case "GBE":
                    normalizzatoreSRID = 'EPSG:3004';
                    break;
                case "RM40":
                    normalizzatoreSRID = 'EPSG:4806';
                    break;
                case "ED50":
                    normalizzatoreSRID = 'EPSG:4230';
                    break;
                case "UTM32":
                    normalizzatoreSRID = 'EPSG:23032';
                    break;
                case "UTM33":
                    normalizzatoreSRID = 'EPSG:23033';
                    break;
                case "ETRS89":
                    normalizzatoreSRID = 'EPSG:4258';
                    break;
                case "ES32":
                    normalizzatoreSRID = 'EPSG:25832';
                    break;
                case "ES33":
                    normalizzatoreSRID = 'EPSG:25833';
                    break;
                case "WGS84":
                    normalizzatoreSRID = 'EPSG:4326';
                    break;
                case "WU32":
                    normalizzatoreSRID = 'EPSG:32632';
                    break;
                case "WU33":
                    normalizzatoreSRID = 'EPSG:32633';
                    break;
                default:
                    normalizzatoreSRID = 'UTMRER';
                    break;               
            }
        }
        if (options.tipo_coord) {
            tipo_coord = options.tipo_coord;
        }
        if (options.rif_geo_civ) {
            rif_geo_civ = options.rif_geo_civ;
        }
        if (options.ricercaSemplice) {
            ricercaSemplice = options.ricercaSemplice;
        }
    }
    
    //se l'handle non viene fornito, lo devo richiedere;
    //verifico se mi è stato fornito l'id dell'applicazione, altrimenti uso la connessione di default
    if (handle === null) {
        var successGetHandleFunc = successGetHandle.bind(this);
        if (normalizzatoreId !== null) {
            url = localizzatoreUrl + '/resources/initNormalizzatoreWithIdJson' + "?id=" + normalizzatoreId + "&callback=?";
            callJsonp(url, successGetHandleFunc);
        }
        //utilizzo parametri di defualt
        else {
            url = localizzatoreUrl + '/resources/initNormalizzatoreDefaultJson' + "?callback=?";
            callJsonp(url, successGetHandleFunc);
        }
    }
    
    //controlli di default
    var scaleLineControl = new ol.control.ScaleLine();
    var scaleControl = new ol.control.Scale({});
    scaleControl.formatScale = function (d) {
        if (d > 100) d = Math.round(d / 100) * 100;
        else d = Math.round(d);
        return '1:' + d;//d.toLocaleString();
    };
    
    var mousePositionControl = new ol.control.MousePosition({
        //coordinateFormat: ol.coordinate.createStringXY(2),
        coordinateFormat: function(coordinate) {
            var template = 'EPSG:3857, {x} {y})';
            return ol.coordinate.format(coordinate, template);
        },
        projection: 'EPSG:3857'
    });

    var layerSwitcherControl = new ol.control.LayerSwitcher({
        show_progress: true,
        extent: false,
        trash: false
    });
    
    map = new ol.Map({
        target: map_id,
        layers: [],
        view: new ol.View({
            center: defaultCenter,
            projection: 'EPSG:3857',
            resolutions: [2048, 1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1, 0.5, 0.25, 0.125],
            maxZoom: 14,
            minZoom: 0,
            zoom:2

        }),

        controls: ol.control.defaults().extend([scaleLineControl, scaleControl, mousePositionControl, layerSwitcherControl])
    });
    
    var zoomToExtentCtrl = new ol.control.Button(
    {
        html: '<i class="fa fa-arrows-alt"></i>',
        className: "select",
        title: "Zoom alla massima estensione",
        handleClick: function () {
            map.getView().fit(defaultExtent);
        }
    });

    var zoomPreviousCtrl = new ol.control.Button(
    {
        html: '<i class="fa fa-backward"></i>',
        className: "select",
        title: "Zoom all'estensione precedente",
        handleClick: function () {
            if (currIndex > 0) {
                currIndex -= 1;
                shouldSave = false;
                index = currIndex;
                map.getView().fit(historyArray[currIndex]);
            }
        }
    });

    var zoomNextCtrl = new ol.control.Button(
    {
        html: '<i class="fa fa-forward"></i>',
        className: "select",
        title: "Zoom all'estensione successiva",
        handleClick: function () {
            if (currIndex < historyArray.length - 1) {
                currIndex += 1;
                shouldSave = false;
                index = currIndex;
                map.getView().fit(historyArray[currIndex]);
            }
        }
    });
    
    var localizzatoreCtrl = new ol.control.Toggle(
    {
        html: '<i class="fa fa-map-marker"></i>',
        className: "select",
        title: "Localizzazione",
        active: true,
        onToggle: function (active) {
            map.getOverlays().clear();
            if (active) {
                destroyPanel(localizzatore_panel_id);
                buildPanelLocalizzatore(localizzatore_panel_id);
            }
            else {
                map.getOverlays().clear();
                destroyPanel(localizzatore_panel_id);
            }
        }
    });
    
    var ricercaCtrl = new ol.control.Toggle(
    {
        html: '<i class="fa fa-search"></i>',
        className: "select",
        title: "Ricerca semplice",
        active: false,
        onToggle: function (active) {
            map.getOverlays().clear();
            if (active) {
                destroyPanel(ricerca_panel_id);
                buildPanelRicerca(ricerca_panel_id);
            }
            else {
                map.getOverlays().clear();
                destroyPanel(ricerca_panel_id);
            }
        }
    });
    
    buildPanelLocalizzatore(localizzatore_panel_id);
    
    // Main control bar
    var mainbar = new ol.control.Bar();
    map.addControl(mainbar);
    /* Nested toobar with one control activated at once */
    var nested = new ol.control.Bar({ toggleOne: false, group: true });
    mainbar.addControl(nested);
    mainbar.setPosition("top-left");
    // Add selection tool (a toggle control with a select interaction)
    nested.addControl(zoomToExtentCtrl);
    nested.addControl(zoomPreviousCtrl);
    nested.addControl(zoomNextCtrl);
    nested.addControl(localizzatoreCtrl);
    if(ricercaSemplice)
        nested.addControl(ricercaCtrl);
    
    //elenco layers
    if (!options || !options.layers) {
        var OSM = new ol.layer.Tile({
            source: new ol.source.OSM(),
            title: "OSM",
            visible: false
        });
        
        var ortofoto_CGR_2018 = new ol.layer.Tile({
            source: new ol.source.TileWMS({
                crossOrigin: 'Anonymous',
                params: {
                    'LAYERS': 'cgr2018_rgb',
                    'FORMAT': 'image/png',
                    'VERSION': '1.1.1',
                    'SRS': 'EPSG:3857'
                },
                projection: 'EPSG:3857',
                url: 'https://servizigis.regione.emilia-romagna.it/wms/cgr2018_rgb'
            }),
            title: 'Ortofoto CGR 2018',
            visible: true
        });
        
        var ctr = new ol.layer.Tile({
            source: new ol.source.TileWMS({
                crossOrigin: 'Anonymous',
                params: {
                    'LAYERS': 'dbtr_ctrmultiscala',
                    'FORMAT': 'image/png',
                    'VERSION': '1.1.1',
                    'SRS': 'EPSG:3857'
                },
                projection: 'EPSG:3857',
                url: 'https://servizigis.regione.emilia-romagna.it/wms/dbtr_ctrmultiscala'
            }),
            title: 'CTR multiscala',
            visible: false
        });
        
        var dbtr_cache = new ol.layer.Tile({
            source: new ol.source.TileWMS({
                crossOrigin: 'Anonymous',
                params: {
                    'LAYERS': 'dbtr_cache',
                    'FORMAT': 'image/png',
                    'VERSION': '1.1.1',
                    'SRS': 'EPSG:3857'
                },
                projection: 'EPSG:3857',
                url: 'https://servizigis.regione.emilia-romagna.it/wms/dbtr_cache'
            }),
            title: 'DBTR Cache',
            visible: true
        });
        
        layerToponimi = new ol.layer.Tile({
            source: new ol.source.TileWMS({
                crossOrigin: 'Anonymous',
                params: {
                    'LAYERS': 'TPS_Toponimo_stradale_comunale',
                    'FORMAT': 'image/png',
                    'VERSION': '1.1.1',
                    'SRS': 'EPSG:3857'
                },
                projection: 'EPSG:3857',
                url: 'https://servizigis.regione.emilia-romagna.it/wms/dbtr'
            }),
            title: 'Toponimi stradali comunale',
            visible: false
        });
        
        layerCivici = new ol.layer.Tile({
            source: new ol.source.TileWMS({
                crossOrigin: 'Anonymous',
                params: {
                    'LAYERS': 'NCV_Civico',
                    'FORMAT': 'image/png',
                    'VERSION': '1.1.1',
                    'SRS': 'EPSG:3857'
                },
                projection: 'EPSG:3857',
                url: 'https://servizigis.regione.emilia-romagna.it/wms/dbtr'
            }),
            title: 'Numeri civici',
            visible: false
        });
        
        layerComuni = new ol.layer.Tile({
            source: new ol.source.TileWMS({
                crossOrigin: 'Anonymous',
                params: {
                    'LAYERS': 'COM_Comune',
                    'FORMAT': 'image/png',
                    'VERSION': '1.1.1',
                    'SRS': 'EPSG:3857'
                },
                projection: 'EPSG:3857',
                url: 'https://servizigis.regione.emilia-romagna.it/wms/dbtr'
            }),
            title: 'Comuni',
            visible: false
        });
        
        layerLimitiAmministrativi = new ol.layer.Tile({
            source: new ol.source.TileWMS({
                crossOrigin: 'Anonymous',
                params: {
                    'LAYERS': 'LAM_Limite_amministrativo',
                    'FORMAT': 'image/png',
                    'VERSION': '1.1.1',
                    'SRS': 'EPSG:3857'
                },
                projection: 'EPSG:3857',
                url: 'https://servizigis.regione.emilia-romagna.it/wms/dbtr'
            }),
            title: 'Limiti amministrativi',
            visible: true
        });
        
        map.getLayers().push(OSM);
        map.getLayers().push(ortofoto_CGR_2018);
        map.getLayers().push(dbtr_cache);
        map.getLayers().push(ctr);
        map.getLayers().push(layerLimitiAmministrativi);
        map.getLayers().push(layerToponimi);
        map.getLayers().push(layerCivici);
    }
    else {
        
    }
    
    //eventi sulla mappa
    map.on('movestart', function (e) {
        var currentExtent = map.getView().calculateExtent();
        extentsList.push(currentExtent);
        currExtentIndex += 1;
    });
    
    map.on('moveend', function (e) {
        //gestione storia
        if (shouldSave) {
            var view = map.getView();
            var currentExtent = view.calculateExtent();
            //historyArray.splice(currIndex + 1, historyArray.length - currIndex - 1);
            if (historyArray.length === 50) {
                historyArray.splice(0, 1);
            } else {
                currIndex += 1;
            }
            historyArray.push(currentExtent);
        } else {
            shouldSave = true;
            //primo render della mappa
            if (historyArray.length === 0) {
                var view = map.getView();
                var currentExtent = view.calculateExtent();
                historyArray.push(currentExtent);
            }
        }
    });
    
    map.on('click', function (e) {
        results = [];
        $('#divResults').html('');
        $("#progressBar").css("display", "block");
        var viewResolution = 2;
        var url;
        switch ($('#selecTipoLocalizzazione').val()) {
            case "1":
                url = layerCivici.getSource().getFeatureInfoUrl(e.coordinate, viewResolution, 'EPSG:3857', { 'INFO_FORMAT': 'application/json' }) + "&FEATURE_COUNT=10";
                break;
            case "2":
                url = layerToponimi.getSource().getFeatureInfoUrl(e.coordinate, viewResolution, 'EPSG:3857', { 'INFO_FORMAT': 'application/json' }) + "&FEATURE_COUNT=10";
                break;
            case "3":
                var coord = ol.proj.transform(e.coordinate, 'EPSG:3857',  'EPSG:5659');
                var url = localizzatoreUrl + '/resources/queryProgJson' + "?x=" + coord[0] + "&y=" + coord[1] +
                        "&asta=&p_idLrs=" + idLRS + "&callback=?"
                callJsonp(url, successLocalizzaChilometricaInversa);
                break;
            case "4":
                if ($('#txtToponimo').val().trim().length == 0) {
                    $("#progressBar").css("display", "none");
                    alert("Il campo toponimo non può essere vuoto.")
                    return;
                }
                var wgsCoord = ol.proj.transform(e.coordinate, 'EPSG:3857', 'EPSG:4326');
                $('#txtLon').val(wgsCoord[0].toFixed(6));
                $('#labelLon').addClass("active");
                $('#txtLat').val(wgsCoord[1].toFixed(6));
                $('#labelLat').addClass("active");
                url = layerComuni.getSource().getFeatureInfoUrl(e.coordinate, viewResolution, 'EPSG:3857', { 'INFO_FORMAT': 'application/json' }) + "&FEATURE_COUNT=1";
                break;
            default:
                break;
        }
        if (url) {
            fetch(url).then(function (response) {
                return response.text();
            }).then(function(res) {
                getInfo(res);
            });
        }
    });
    
    $('[class=" ol-scale ol-unselectable ol-control"]').css({ left: 8, bottom: 8});
    $('[class=" ol-scale ol-unselectable ol-control"]').addClass("topBar");
}

function getInfo(res) {
    if (res) {
        $("#progressBar").css("display", "block");
        switch ($('#selecTipoLocalizzazione').val()) {
            case "1":
                var xml = ol.xml.parse(res);
                var records = xml.getElementsByTagName("FIELDS");
                if (records && records.length && records.length > 0) {
                    var html = '<div class="link-list-wrapper">' + 
                    '<ul class="link-list">' +
                        '<li>' +
                            '<h3 id="heading-senza-link">Risultati</h3>' +
                        '</li>' +
                    '</ul>';
                    $('#divResults').html(html);
                    for (var i = 0; i < records.length; i++) {
                        var currRecord = records[i];
                        var toponimo = currRecord.attributes["Tp_nom"].value.concat(" ", currRecord.attributes["Nm_civ"].value, "/", currRecord.attributes["Sb_civ"].value);
                        url = localizzatoreUrl + "/resources/normIndirizzoJson" + "?handle=" + handle +
                        "&p_toponimo=" + toponimo +
                        "&p_comune=" + currRecord.attributes["Nome_c"].value +
                        "&p_provincia=" + currRecord.attributes["Nm_prv"].value +
                        "&p_tipo_coord=" + tipo_coord +
                        "&p_rif_geo_civ=" + rif_geo_civ +
                        "&callback=?";
                        callJsonp(url, successLocalizzaCivicoInverso);
                        
                    }
                }
                else {
                    $("#progressBar").css("display", "none");
                    var html = '<div class="alert alert-info" role="alert">' +
                            'Nessun risultato trovato.' +
                        '</div>';
                    $('#divResults').html(html);
                }
                break;
            case "2":
                var xml = ol.xml.parse(res);
                var records = xml.getElementsByTagName("FIELDS");
                if (records && records.length && records.length > 1) {
                    var html = '<div class="link-list-wrapper">' + 
                    '<ul class="link-list">' +
                        '<li>' +
                            '<h3 id="heading-senza-link">Risultati</h3>' +
                        '</li>' +
                    '</ul>';
                    $('#divResults').html(html);
                    for (var i = 1; i < records.length; i++) {
                        var toponimo1 = records[i - 1].attributes["Tp_dug"].value.concat(" ", records[i - 1].attributes["Tp_nom"].value);
                        var toponimo2 = records[i].attributes["Tp_dug"].value.concat(" ", records[i].attributes["Tp_nom"].value);
                        var com_prov1 = getComuneProvinciaFromIstat(records[i - 1].attributes["Istat_com"].value);
                        var com_prov2 = getComuneProvinciaFromIstat(records[i].attributes["Istat_com"].value);
                        url = localizzatoreUrl + "/resources/normIncrocioJson" + "?handle=" + handle +
                            "&p_toponimo1=" + toponimo1 +
                            "&p_comune1=" + com_prov1.comune +
                            "&p_provincia1=" + com_prov1.provincia +
                            "&p_toponimo2=" + toponimo2 +
                            "&p_comune2=" + com_prov2.comune +
                            "&p_provincia2=" + com_prov2.provincia +
                            "&p_tipo_coord=" + tipo_coord +
                            "&callback=?";
                        callJsonp(url, successLocalizzaIncrocioInverso);
                    }
                }
                else {
                    $("#progressBar").css("display", "none");
                    var html = '<div class="alert alert-info" role="alert">' +
                            'Nessun risultato trovato.' +
                        '</div>';
                    $('#divResults').html(html);
                }
                break;
            case "3":
                break;
            case "4":
                $("#progressBar").css("display", "none");
                var xml = ol.xml.parse(res);
                var records = xml.getElementsByTagName("FIELDS");
                if (records && records.length && records.length > 0) {
                    var currRecord = records[0];
                    var currIstat = currRecord.attributes["Istat"].value;
                    var comune = getComuneProvinciaFromIstat(currIstat);
                    var x = parseFloat($('#txtLon').val());
                    var y = parseFloat($('#txtLat').val());
                    var coord = ol.proj.transform([x, y], 'EPSG:4326', normalizzatoreSRID);
                    currResult = {
                        COMUNE: comune.comune.toUpperCase(), 
                        PROVINCIA: comune.provincia.toUpperCase(),
                        TOPONIMO: $('#txtToponimo').val().trim(),
                        X: coord[0],
                        Y: coord[1]
                    };
                    results.push(currResult);
            
                    var html = '<div class="link-list-wrapper">' + 
                            '<ul class="link-list">' +
                                '<li>' +
                                    '<h3 id="heading-senza-link">Risultati</h3>' +
                                '</li>';                  
                    html += '<li>' +
                                '<a class="list-item" href="#" onClick="showResult(' + i + ')"><span>' + $('#txtToponimo').val().trim() + '</span></a>' +
                            '</li>';
                    
                    html += '</ul>' +
                        '</div>';
                    showResult(0);
                }
                else {
                    $("#progressBar").css("display", "none");
                    var html = '<div class="alert alert-info" role="alert">' +
                            'Nessun risultato trovato.' +
                        '</div>';
                    $('#divResults').html(html);
                }
                break;
            default:
                break;
        }
    }
}

function checkComune(codIstat, coord) {
    var viewResolution = 2;
    var url = layerComuni.getSource().getFeatureInfoUrl(coord, viewResolution, 'EPSG:3857', { 'INFO_FORMAT': 'application/json' });

    const result = fetch(url).then(function (response) {
        return response.text();
    }).then(function(res) {
        var xml = ol.xml.parse(res);
        var records = xml.getElementsByTagName("FIELDS");
        if (records && records.length && records.length > 0) {
            for (var i = 0; i < records.length; i++) {
                var currRecord = records[i];
                var currIstat = currRecord.attributes["Istat"].value;
                if (currIstat === codIstat)
                    return true;
            }
            return false;
        }
        else {
            return false;
        }
    });

    return result;
}

function xxx(codIstat, coord) {
    var a = false;
    checkComune(codIstat, coord).then(function(res){
        a = res;
    });
    return a;
}

function isInComune(codIstat, coord) {
    var result = false;
    checkComune(codIstat, coord);
    alert(result);
}

function buildPanelLocalizzatore(panel_id) {
    var html = '<section>' + 
        '<div class="row mb-3">' +
            '<div class="col-12 headerPanel">' +
                '<h6>Localizzazione</h6>' +
            '</div>' +
        '</div>' +
        '<div class="form-row mt-4">' +
            '<div class="form-group col-md-4">' +
                '<div class="form-row">' +
                    '<div class="form-group col-md-1">' +
                    '</div>' +
                    '<div class="form-group col-md-11">' +
                        '<div class="bootstrap-select-wrapper w-75">' +
                            '<label id="labelTipoLocalizzazione" for="selecTipoLocalizzazione" >Modalità di localizzazione</label>' +
                            '<select id="selecTipoLocalizzazione" property="tipoLocalizzazione">' +
                                '<option value="-1">Seleziona</option>' +
                                '<option value="1">Civico</option>' +
                                '<option value="2">Incrocio</option>' +
                                '<option value="3">Chilometrica</option>' +
                                '<option value="4">Coordinate</option>' +
                                '<option value="5">Solo testo</option>' +
                            '</select>' +
                        '</div>' +
                    '</div>' +
                '</div>' +
            '</div>' +
            '<div id="divLocFields" class="col-md-8">' +  
            '</div>' +
        '</div>' +
        '<div class="form-row">' +
            '<div class="form-group col-md-1"></div>' +
            '<div class="form-group col-md-10">' +
                '<div id="progressBar" class="progress progress-indeterminate">' +
                    '<span class="sr-only">In elaborazione...</span>'   +
                    '<div class="progress-bar" role="progressbar"></div>' +
                '</div>' +
             '</div>' +
             '<div class="form-group col-md-1"></div>' +
        '</div>' +
        '<div class="form-row">' +
            '<div id="divResults" class="col-md-12">' +  
            '</div>' +
        '</div>' +
    '</section>';
    $("#" + panel_id).append(html);
    $('#selecTipoLocalizzazione').selectpicker();
    $('#selecTipoLocalizzazione').on("change", function (e) {
        $('#divLocFields').html('');
        //$("#esitoLocalizzazione").html('');
        switch ($('#selecTipoLocalizzazione').val()) {
            case "1":
                var html =
                        '<div class="form-row">' +
                            '<div class="form-group col-md-6">' +
                                '<input type="text" class="form-control w-100" id="txtProvincia">' +
                                '<label id="labelProvincia" for="txtProvincia">Provincia</label>' +
                            '</div>' +
                            '<div class="form-group col-md-6">' +
                                '<input type="text" class="form-control w-100" id="txtComune">' +
                                '<label id="labelComune" for="txtComune">Comune</label>' +
                            '</div>' +
                        '</div>' +
                        '<div class="form-row">' +
                            '<div class="form-group col-md-6">' +
                                '<input type="text" class="form-control w-100" id="txtToponimo">' +
                                '<label id="labelToponimo" for="txtToponimo">Indirizzo</label>' +
                            '</div>' +
                        '</div>' +
                        '<div class="form-row">' +
                            '<div class="col-md-1">' +
                                '<a href="#" data-toggle="tooltip" title="Inserisci Provincia, Comune e Indirizzo e premi Localizza per ottenere le coordinate corrispondenti, oppure ricava l\'indirizzo scegliendo il punto direttamente dalla mappa.">' +
                                '<span class="rounded-icon">' +
                                    '<svg class="icon icon-primary">' +
                                        '<use xlink:href="' + localizzatoreUrl + '/js/bootstrap-italia/svg/sprite.svg#it-info-circle"></use>' +
                                    '</svg>' +
                                '</span>' +
                                '</a>' +
                            '</div>' +
                            '<div class="col-md-1">' +    
                                '<button id="btnLocalizza" type="button" class="btn btn-secondary mt-3" disabled="disabled">Localizza</button>' +
                            '</div>' +
                        '</div>';
                $('#divLocFields').html(html);
                
                if(currComune) {
                    $('#txtComune').val(currComune);
                    $('#labelComune').addClass("active");
                }
                if(currProvincia) {
                    $('#txtProvincia').val(currProvincia);
                    $('#labelProvincia').addClass("active");
                }
                
                $('#txtProvincia').on('input', function(e){
                    if (e.delegateTarget.value.trim().length > 0) {
                        if (e.delegateTarget.value.trim().length > 0 && $('#txtToponimo').val().trim().length > 0 && $('#txtComune').val().trim().length > 0) {
                            $('#btnLocalizza').attr("disabled", false); 
                        }
                        else {
                            $('#btnLocalizza').attr("disabled", true); 
                        }
                    }
                    else {
                        $('#btnLocalizza').attr("disabled", true); 
                    }
                });
                $('#txtComune').on('input', function(e){
                    if (e.delegateTarget.value.trim().length > 0) {
                        if (e.delegateTarget.value.trim().length > 0 && $('#txtToponimo').val().trim().length > 0 && $('#txtProvincia').val().trim().length > 0) {
                            $('#btnLocalizza').attr("disabled", false); 
                        }
                        else {
                            $('#btnLocalizza').attr("disabled", true); 
                        }
                    }
                    else {
                        $('#btnLocalizza').attr("disabled", true); 
                    }
                });
                $('#txtToponimo').on('input', function(e){
                    if (e.delegateTarget.value.trim().length > 0) {
                        if (e.delegateTarget.value.trim().length > 0 && $('#txtProvincia').val().trim().length > 0 && $('#txtComune').val().trim().length > 0) {
                            $('#btnLocalizza').attr("disabled", false); 
                        }
                        else {
                            $('#btnLocalizza').attr("disabled", true); 
                        }
                    }
                    else {
                        $('#btnLocalizza').attr("disabled", true); 
                    }
                });
                $('#txtToponimo').keydown(keyPressed);
                /*if ($('#localizzazioneHidden').val().trim().length > 0) {
                    $('#txtToponimo').val($('#localizzazioneHidden').val());
                    $('#labelToponimo').addClass("active");
                    $('#btnLocalizza').attr("disabled", false); 
                }*/
                $('#btnLocalizza').on("click", localizza);
                break;
            case "2":
                var html =
                        '<div class="form-row">' +
                            '<div class="form-group col-md-6">' +
                                '<input type="text" class="form-control w-100" id="txtProvincia1">' +
                                '<label id="labelProvincia1" for="txtProvincia1">Provincia primo toponimo</label>' +
                            '</div>' +
                            '<div class="form-group col-md-6">' +
                                '<input type="text" class="form-control w-100" id="txtComune1">' +
                                '<label id="labelComune1" for="txtComune1">Comune primo toponimo</label>' +
                            '</div>' +
                        '</div>' +
                        '<div class="form-row">' +
                            '<div class="form-group col-md-6">' +
                                '<input type="text" class="form-control w-100" id="txtProvincia2">' +
                                '<label id="labelProvincia2" for="txtProvincia2">Provincia secondo toponimo</label>' +
                            '</div>' +
                            '<div class="form-group col-md-6">' +
                                '<input type="text" class="form-control w-100" id="txtComune2">' +
                                '<label id="labelComune2" for="txtComune2">Comune secondo toponimo</label>' +
                            '</div>' +
                        '</div>' +
                        '<div class="form-row">' +
                            '<div class="form-group col-md-6">' +
                                '<input type="text" class="form-control w-100" id="txtToponimo1">' +
                                '<label id="labelToponimo1" for="txtToponimo1">Primo toponimo</label>' +
                            '</div>' +
                            '<div class="form-group col-md-6">' +
                                '<input type="text" class="form-control w-100" id="txtToponimo2">' +
                                '<label id="labelToponimo2" for="txtToponimo2">Secondo toponimo</label>' +
                            '</div>' +
                        '</div>' +
                        '<div class="form-row">' +
                            '<div class="col-md-1">' +
                                '<a href="#" data-toggle="tooltip" title="Inserisci Provincia, Comune e Toponimi e premi Localizza per ottenere le coordinate corrispondenti, oppure ricava l\'incrocio scegliendo il punto direttamente dalla mappa.">' +
                                '<span class="rounded-icon">' +
                                    '<svg class="icon icon-primary">' +
                                        '<use xlink:href="' + localizzatoreUrl + '/js/bootstrap-italia/svg/sprite.svg#it-info-circle"></use>' +
                                    '</svg>' +
                                '</span>' +
                                '</a>' +
                            '</div>' +
                            '<div class="col-md-1">' +    
                                '<button id="btnLocalizza" type="button" class="btn btn-secondary mt-3" disabled="disabled">Localizza</button>' +
                            '</div>' +
                        '</div>';
                $('#divLocFields').html(html);
                if(currComune) {
                    $('#txtComune1').val(currComune);
                    $('#labelComune1').addClass("active");
                    $('#txtComune2').val(currComune);
                    $('#labelComune2').addClass("active");
                }
                if(currProvincia) {
                    $('#txtProvincia1').val(currProvincia);
                    $('#labelProvincia1').addClass("active");
                    $('#txtProvincia2').val(currProvincia);
                    $('#labelProvincia2').addClass("active");
                }
                $('#txtProvincia1').on('input', function(e){
                    if (e.delegateTarget.value.trim().length > 0) {
                        if (e.delegateTarget.value.trim().length > 0 && $('#txtToponimo1').val().trim().length > 0 && $('#txtComune1').val().trim().length > 0
                                && $('#txtToponimo2').val().trim().length > 0 && $('#txtComune2').val().trim().length > 0 && $('#txtProvincia2').val().trim().length > 0) {
                            $('#btnLocalizza').attr("disabled", false); 
                        }
                        else {
                            $('#btnLocalizza').attr("disabled", true); 
                        }
                    }
                    else {
                        $('#btnLocalizza').attr("disabled", true); 
                    }
                });
                $('#txtComune1').on('input', function(e){
                    if (e.delegateTarget.value.trim().length > 0) {
                        if (e.delegateTarget.value.trim().length > 0 && $('#txtToponimo1').val().trim().length > 0 && $('#txtProvincia1').val().trim().length > 0
                                && $('#txtToponimo2').val().trim().length > 0 && $('#txtComune2').val().trim().length > 0 && $('#txtProvincia2').val().trim().length > 0) {
                            $('#btnLocalizza').attr("disabled", false); 
                        }
                        else {
                            $('#btnLocalizza').attr("disabled", true); 
                        }
                    }
                    else {
                        $('#btnLocalizza').attr("disabled", true); 
                    }
                });
                $('#txtToponimo1').on('input', function(e){
                    if (e.delegateTarget.value.trim().length > 0) {
                        if (e.delegateTarget.value.trim().length > 0 && $('#txtComune1').val().trim().length > 0 && $('#txtProvincia1').val().trim().length > 0
                                && $('#txtToponimo2').val().trim().length > 0 && $('#txtComune2').val().trim().length > 0 && $('#txtProvincia2').val().trim().length > 0) {
                            $('#btnLocalizza').attr("disabled", false); 
                        }
                        else {
                            $('#btnLocalizza').attr("disabled", true); 
                        }
                    }
                    else {
                        $('#btnLocalizza').attr("disabled", true); 
                    }
                });
                $('#txtProvincia2').on('input', function(e){
                    if (e.delegateTarget.value.trim().length > 0) {
                        if (e.delegateTarget.value.trim().length > 0 && $('#txtToponimo1').val().trim().length > 0 && $('#txtComune1').val().trim().length > 0
                                && $('#txtToponimo2').val().trim().length > 0 && $('#txtComune2').val().trim().length > 0 && $('#txtProvincia1').val().trim().length > 0) {
                            $('#btnLocalizza').attr("disabled", false); 
                        }
                        else {
                            $('#btnLocalizza').attr("disabled", true); 
                        }
                    }
                    else {
                        $('#btnLocalizza').attr("disabled", true); 
                    }
                });
                $('#txtComune2').on('input', function(e){
                    if (e.delegateTarget.value.trim().length > 0) {
                        if (e.delegateTarget.value.trim().length > 0 && $('#txtToponimo1').val().trim().length > 0 && $('#txtProvincia1').val().trim().length > 0
                                && $('#txtToponimo2').val().trim().length > 0 && $('#txtComune1').val().trim().length > 0 && $('#txtProvincia2').val().trim().length > 0) {
                            $('#btnLocalizza').attr("disabled", false); 
                        }
                        else {
                            $('#btnLocalizza').attr("disabled", true); 
                        }
                    }
                    else {
                        $('#btnLocalizza').attr("disabled", true); 
                    }
                });
                $('#txtToponimo2').on('input', function(e){
                    if (e.delegateTarget.value.trim().length > 0) {
                        if (e.delegateTarget.value.trim().length > 0 && $('#txtComune1').val().trim().length > 0 && $('#txtProvincia1').val().trim().length > 0
                                && $('#txtToponimo1').val().trim().length > 0 && $('#txtComune2').val().trim().length > 0 && $('#txtProvincia2').val().trim().length > 0) {
                            $('#btnLocalizza').attr("disabled", false); 
                        }
                        else {
                            $('#btnLocalizza').attr("disabled", true); 
                        }
                    }
                    else {
                        $('#btnLocalizza').attr("disabled", true); 
                    }
                });
                $('#btnLocalizza').on("click", localizza);
                break
            case "3":
                var html =
                    '<div class="form-row">' +
                        '<div class="form-group col-md-6">' +
                            '<input type="text" class="form-control w-100" id="txtProvincia">' +
                            '<label id="labelProvincia" for="txtProvincia">Provincia</label>' +
                        '</div>' +
                        '<div class="form-group col-md-3">' +
                            '<div class="bootstrap-select-wrapper w-75">' +
                                '<label id="labelClAmm" for="selectClAmm">Cl. amm.</label>' +
                                '<select id="selectClAmm">' +
                                    '<option value="Seleziona">Seleziona</option>' +
                                    '<option value="SP">SP</option>' +
                                    '<option value="SS">SS</option>' +
                                    '<option value="SP">AA</option>' +
                                    '<option value="SP">TG</option>' +
                                '</select>' +
                            '</div>' +
                        '</div>' +
                        '<div class="form-group col-md-3">' +
                            '<input type="text" class="form-control w-100" id="txtNStrada">' +
                            '<label id="labelNStrada" for="txtNStrada">Numero strada</label>' +
                        '</div>' +
                    '</div>' +
                    '<div class="form-row">' +
                        '<div class="form-group col-md-9">' +
                            '<input type="text" class="form-control w-100" id="txtToponimo">' +
                            '<label id="labelToponimo1" for="txtToponimo1">Nome strada</label>' +
                        '</div>' +
                        '<div class="form-group col-md-1">' +
                            '<input type="text" class="form-control w-100" id="txtKm">' +
                            '<label id="labelKm" for="txtKm">Km</label>' +
                        '</div>' +
                        '<div class="form-group col-md-1">' +
                            '<label>+</label>' +
                        '</div>' +
                        '<div class="form-group col-md-1">' +
                            '<input type="text" class="form-control w-100" id="txtHm">' +
                            '<label id="labelHm" for="txtHm">m</label>' +
                        '</div>' +
                    '</div>' +
                    '<div class="form-row">' +
                        '<div class="col-md-1">' +
                            '<a href="#" data-toggle="tooltip" title="Inserisci Provincia, Classifica amministrativa, chilometrica e numero strada o nome strada e premi Localizza per ottenere le coordinate corrispondenti, oppure ricava la progressiva scegliendo il punto direttamente dalla mappa.">' +
                            '<span class="rounded-icon">' +
                                '<svg class="icon icon-primary">' +
                                    '<use xlink:href="' + localizzatoreUrl + '/js/bootstrap-italia/svg/sprite.svg#it-info-circle"></use>' +
                                '</svg>' +
                            '</span>' +
                            '</a>' +
                        '</div>' +
                        '<div class="col-md-1">' +    
                            '<button id="btnLocalizza" type="button" class="btn btn-secondary mt-3" disabled="disabled">Localizza</button>' +
                        '</div>' +
                    '</div>';
                $('#divLocFields').html(html);
                if(currProvincia) {
                    $('#txtProvincia').val(currProvincia);
                    $('#labelProvincia').addClass("active");
                }
                $('#txtProvincia').on('input', function(e){
                    if (e.delegateTarget.value.trim().length > 0) {
                        if (e.delegateTarget.value.trim().length > 0 && $('#selectClAmm').val().trim() !== 'Seleziona' && 
                                ($('#txtKm').val().trim().length > 0 || $('#txtHm').val().trim().length > 0) &&
                                ($('#txtNStrada').val().trim().length > 0 || $('#txtToponimo').val().trim().length > 0)) {
                            $('#btnLocalizza').attr("disabled", false); 
                        }
                        else {
                            $('#btnLocalizza').attr("disabled", true); 
                        }
                    }
                    else {
                        $('#btnLocalizza').attr("disabled", true); 
                    }
                });
                $('#txtKm').on('input', function(e){
                    if (e.delegateTarget.value.trim().length > 0) {
                        if (e.delegateTarget.value.trim().length > 0 && $('#selectClAmm').val().trim() !== 'Seleziona' && 
                                $('#txtProvincia').val().trim().length > 0 &&
                                ($('#txtKm').val().trim().length > 0 || $('#txtHm').val().trim().length > 0) &&
                                ($('#txtNStrada').val().trim().length > 0 || $('#txtToponimo').val().trim().length > 0)) {
                            $('#btnLocalizza').attr("disabled", false); 
                        }
                        else {
                            $('#btnLocalizza').attr("disabled", true); 
                        }
                    }
                    else {
                        $('#btnLocalizza').attr("disabled", true); 
                    }
                });
                $('#txtHm').on('input', function(e){
                    if (e.delegateTarget.value.trim().length > 0) {
                        if (e.delegateTarget.value.trim().length > 0 && $('#selectClAmm').val().trim() !== 'Seleziona' && 
                                $('#txtProvincia').val().trim().length > 0 &&
                                ($('#txtKm').val().trim().length > 0 || $('#txtHm').val().trim().length > 0) &&
                                ($('#txtNStrada').val().trim().length > 0 || $('#txtToponimo').val().trim().length > 0)) {
                            $('#btnLocalizza').attr("disabled", false); 
                        }
                        else {
                            $('#btnLocalizza').attr("disabled", true); 
                        }
                    }
                    else {
                        $('#btnLocalizza').attr("disabled", true); 
                    }
                });
                $('#txtNStrada').on('input', function(e){
                    if (e.delegateTarget.value.trim().length > 0) {
                        if (e.delegateTarget.value.trim().length > 0 && $('#selectClAmm').val().trim() !== 'Seleziona' && 
                                $('#txtProvincia').val().trim().length > 0 &&
                                ($('#txtKm').val().trim().length > 0 || $('#txtHm').val().trim().length > 0) &&
                                ($('#txtNStrada').val().trim().length > 0 || $('#txtToponimo').val().trim().length > 0)) {
                            $('#btnLocalizza').attr("disabled", false); 
                        }
                        else {
                            $('#btnLocalizza').attr("disabled", true); 
                        }
                    }
                    else {
                        $('#btnLocalizza').attr("disabled", true); 
                    }
                });
                $('#txtToponimo').on('input', function(e){
                    if (e.delegateTarget.value.trim().length > 0) {
                        if (e.delegateTarget.value.trim().length > 0 && $('#selectClAmm').val().trim() !== 'Seleziona' && 
                                $('#txtProvincia').val().trim().length > 0 &&
                                ($('#txtKm').val().trim().length > 0 || $('#txtHm').val().trim().length > 0) &&
                                ($('#txtNStrada').val().trim().length > 0 || $('#txtToponimo').val().trim().length > 0)) {
                            $('#btnLocalizza').attr("disabled", false); 
                        }
                        else {
                            $('#btnLocalizza').attr("disabled", true); 
                        }
                    }
                    else {
                        $('#btnLocalizza').attr("disabled", true); 
                    }
                });
                $('#selectClAmm').selectpicker();
                $('#btnLocalizza').on("click", localizza);
                break;
            case "4":
                var html =
                        '<div class="form-row">' +
                            '<div class="form-group col-md-6">' +
                                '<input type="text" class="form-control w-100" id="txtToponimo">' +
                                '<label id="labelToponimo" for="txtToponimo">Toponimo</label>' +
                            '</div>' +
                            '<div class="form-group col-md-3">' +
                                '<input type="text" class="form-control number locCoord w-100" id="txtLon">' +
                                '<label id="labelLon" for="txtLon">Lon (WGS84)</label>' +
                            '</div>' +
                            '<div class="form-group col-md-3">' +
                                '<input type="text" class="form-control number locCoord w-100" id="txtLat">' +
                                '<label id="labelLat" for="txtLat">Lat (WGS84)</label>' +
                            '</div>' +
                        '</div>'+
                        '<div class="form-row">' +
                            '<div class="form-group col-md-1">' +
                                '<a href="#" data-toggle="tooltip" title="Inserisci la stringa di localizzazione e premi sulla mappa per ottenere le coordinate, oppure inserisci la stringa di localizzazione e le coordinate in WGS84 e premi Localizza.">' +
                                '<span class="rounded-icon">' +
                                    '<svg class="icon icon-primary">' +
                                        '<use xlink:href="' + localizzatoreUrl + '/js/bootstrap-italia/svg/sprite.svg#it-info-circle"></use>' +
                                    '</svg>' +
                                '</span>' +
                                '</a>' +
                            '</div>' +
                            '<div class="col-md-1">' +    
                                '<button id="btnLocalizza" type="button" class="btn btn-secondary mt-3" disabled="disabled">Localizza</button>' +
                            '</div>' +
                        '</div>';                        
                $('#divLocFields').html(html);
                $('#txtToponimo').on('input', function(e){
                    if (e.delegateTarget.value.trim().length > 0 && $('#txtLon').val().trim().length > 0 && $('#txtLat').val().trim().length > 0) {
                        $('#btnLocalizza').attr("disabled", false); 
                    }
                    else {
                        $('#btnLocalizza').attr("disabled", true); 
                    }
                });
                $('#txtLat').on('input', function(e){
                    if (e.delegateTarget.value.trim().length > 0 && $('#txtLon').val().trim().length > 0 && $('#txtToponimo').val().trim().length > 0) {
                        $('#btnLocalizza').attr("disabled", false); 
                    }
                    else {
                        $('#btnLocalizza').attr("disabled", true); 
                    }
                });
                $('#txtLon').on('input', function(e){
                    if (e.delegateTarget.value.trim().length > 0 && $('#txtLat').val().trim().length > 0 && $('#txtToponimo').val().trim().length > 0) {
                        $('#btnLocalizza').attr("disabled", false); 
                    }
                    else {
                        $('#btnLocalizza').attr("disabled", true); 
                    }
                });
                $('#btnLocalizza').on("click", localizza);
                $("input.number").on("keydown", validateNumbers);
                $("input.locCoord").keydown(function(e) {
                    if (e.keyCode == 13) {
                        e.preventDefault();
                        if($('#btnLocalizza') && $('#btnLocalizza').prop("disabled") == false) {
                            localizza();
                        }
                    }
                });
                break;
            case "5":
                var html =
                        '<div class="form-row">' +
                            '<div class="form-group col-md-1">' +
                                '<a href="#" data-toggle="tooltip" title="Inserisci la stringa di localizzazione e premi Localizza.">' +
                                '<span class="rounded-icon">' +
                                    '<svg class="icon icon-primary">' +
                                        '<use xlink:href="' + localizzatoreUrl + '/js/bootstrap-italia/svg/sprite.svg#it-info-circle"></use>' +
                                    '</svg>' +
                                '</span>' +
                                '</a>' +
                            '</div>' +
                            '<div class="form-group col-md-8">' +
                                '<input type="text" class="form-control w-100" id="txtToponimo">' +
                                '<label id="labelToponimo" for="txtToponimo">Stringa di localizzazione</label>' +
                            '</div>' +
                            '<div class="form-group col-md-1">' +    
                                '<button id="btnLocalizza" type="button" class="btn btn-secondary mt-3" disabled="disabled">Localizza</button>' +
                                '</div>' +
                            '</div>' +
                        '</div>';
                $('#divLocFields').html(html);
                $('#txtToponimo').on('input', function(e){
                    if (e.delegateTarget.value.trim().length > 0) {
                        $('#btnLocalizza').attr("disabled", false); 
                    }
                    else {
                        $('#btnLocalizza').attr("disabled", true); 
                    }
                });
                $('#txtToponimo').keydown(keyPressed);
                if ($('#localizzazioneHidden').val().trim().length > 0) {
                    $('#txtToponimo').val($('#localizzazioneHidden').val());
                    $('#labelToponimo').addClass("active");
                    $('#btnLocalizza').attr("disabled", false); 
                }
                $('#btnLocalizza').on("click", localizza);
                break;
            default:
                break;
        }
    }).trigger('change');
}

function buildPanelRicerca(panel_id) {
    var html = '<section>' + 
        '<div class="row mb-3">' +
            '<div class="col-12 headerPanelRicerca">' +
                '<h6>Ricerca semplice</h6>' +
            '</div>' +
        '</div>' +
        '<div class="form-row mt-4">' +
            '<div id="divLocFieldsRicerca" class="col-md-12">' +  
                '<div class="form-row">' +
                    '<div class="form-group col-md-1 text-center">' +
                        '<a href="#" data-toggle="tooltip" title="Inserisci Provincia, Comune e Indirizzo e premi Ricerca semplice per ottenere le coordinate corrispondenti.">' +
                            '<span class="rounded-icon">' +
                                '<svg class="icon icon-primary">' +
                                    '<use xlink:href="' + localizzatoreUrl + '/js/bootstrap-italia/svg/sprite.svg#it-info-circle"></use>' +
                                '</svg>' +
                            '</span>' +
                        '</a>' +
                    '</div>' +
                    '<div class="form-group col-md-2">' +
                        '<input type="text" class="form-control w-100" id="txtProvinciaRicerca">' +
                        '<label id="labelProvinciaRicerca" for="txtProvinciaRicerca">Provincia</label>' +
                    '</div>' +
                    '<div class="form-group col-md-2">' +
                        '<input type="text" class="form-control w-100" id="txtComuneRicerca">' +
                        '<label id="labelComuneRicerca" for="txtComuneRicerca">Comune</label>' +
                    '</div>' +
                    '<div class="form-group col-md-4">' +
                        '<input type="text" class="form-control w-100" id="txtToponimoRicerca">' +
                        '<label id="labelToponimoRicerca" for="txtToponimoRicerca">Indirizzo</label>' +
                    '</div>' +
                    '<div class="col-md-2">' +    
                        '<button id="btnRicerca" type="button" class="btn btn-secondary mt-3" disabled="disabled">Ricerca semplice</button>' +
                    '</div>' +
                '</div>' +
            '</div>' +
        '</div>' +
        '<div class="form-row">' +
            '<div class="form-group col-md-1"></div>' +
            '<div class="form-group col-md-10">' +
                '<div id="progressBarRicerca" class="progress progress-indeterminate">' +
                    '<span class="sr-only">In elaborazione...</span>'   +
                    '<div class="progress-bar" role="progressbar"></div>' +
                '</div>' +
             '</div>' +
             '<div class="form-group col-md-1"></div>' +
        '</div>' +
        '<div class="form-row">' +
            '<div id="divResultsRicerca" class="col-md-12">' +  
            '</div>' +
        '</div>' + 
    '</section>';
    $("#" + panel_id).append(html);           

    $('#txtProvinciaRicerca').on('input', function(e){
        if (e.delegateTarget.value.trim().length > 0) {
            if (e.delegateTarget.value.trim().length > 0 && $('#txtToponimoRicerca').val().trim().length > 0 && $('#txtComuneRicerca').val().trim().length > 0) {
                $('#btnRicerca').attr("disabled", false); 
            }
            else {
                $('#btnRicerca').attr("disabled", true); 
            }
        }
        else {
            $('#btnRicerca').attr("disabled", true); 
        }
    });
    $('#txtComuneRicerca').on('input', function(e){
        if (e.delegateTarget.value.trim().length > 0) {
            if (e.delegateTarget.value.trim().length > 0 && $('#txtToponimoRicerca').val().trim().length > 0 && $('#txtProvinciaRicerca').val().trim().length > 0) {
                $('#btnRicerca').attr("disabled", false); 
            }
            else {
                $('#btnRicerca').attr("disabled", true); 
            }
        }
        else {
            $('#btnRicerca').attr("disabled", true); 
        }
    });
    $('#txtToponimoRicerca').on('input', function(e){
        if (e.delegateTarget.value.trim().length > 0) {
            if (e.delegateTarget.value.trim().length > 0 && $('#txtProvinciaRicerca').val().trim().length > 0 && $('#txtComuneRicerca').val().trim().length > 0) {
                $('#btnRicerca').attr("disabled", false); 
            }
            else {
                $('#btnRicerca').attr("disabled", true); 
            }
        }
        else {
            $('#btnRicerca').attr("disabled", true); 
        }
    });
    $('#btnRicerca').keydown(keyPressed);
    /*if ($('#localizzazioneHidden').val().trim().length > 0) {
        $('#txtToponimo').val($('#localizzazioneHidden').val());
        $('#labelToponimo').addClass("active");
        $('#btnLocalizza').attr("disabled", false); 
    }*/
    $('#btnRicerca').on("click", localizzaRicerca);          
}

function destroyPanel(panel_id) {
    $('#' + panel_id).html("");
}

function keyPressed(event) {
    if (event.keyCode == 13) {
        event.preventDefault();
        if($('#btnLocalizza') && $('#btnLocalizza').prop("disabled") == false) {
            //localizza();
        }
    }
}

function validateNumbers(e) {
    // allow function keys and decimal separators
    if (
        // backspace, delete, tab, escape, enter, comma and .
        $.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 188, 190]) !== -1 ||
        // Ctrl/cmd+A, Ctrl/cmd+C, Ctrl/cmd+X
        ($.inArray(e.keyCode, [65, 67, 86, 88]) !== -1 && (e.ctrlKey === true || e.metaKey === true)) ||
        // home, end, left, right
        (e.keyCode >= 35 && e.keyCode <= 39)) {
        return;
    }
    // block any non-number
    if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
        e.preventDefault();
    }
}

function localizza() {
    results = [];
    currResult = null;
    
    $('#divResults').html('');
    $("#progressBar").css("display", "block");
    
    //indirizzo
    if ($('#selecTipoLocalizzazione').val() == "1") {
        url = localizzatoreUrl + "/resources/normIndirizzoJson" + "?handle=" + handle +
            "&p_toponimo=" + $('#txtToponimo').val().trim() +
            "&p_comune=" + $('#txtComune').val().trim() +
            "&p_provincia=" + $('#txtProvincia').val().trim() +
            "&p_tipo_coord=" + tipo_coord +
            "&p_rif_geo_civ=" + rif_geo_civ +
            "&callback=?";
        callJsonp(url, successLocalizzaCivico);
    }
    
    //incrocio
    else if ($('#selecTipoLocalizzazione').val() == "2") {
        url = localizzatoreUrl + "/resources/normIncrocioJson" + "?handle=" + handle +
            "&p_toponimo1=" + $('#txtToponimo1').val().trim() +
            "&p_comune1=" + $('#txtComune1').val().trim() +
            "&p_provincia1=" + $('#txtProvincia1').val().trim() +
            "&p_toponimo2=" + $('#txtToponimo2').val().trim() +
            "&p_comune2=" + $('#txtComune2').val().trim() +
            "&p_provincia2=" + $('#txtProvincia2').val().trim() +
            "&p_tipo_coord=" + tipo_coord +
            "&callback=?";
        callJsonp(url, successLocalizzaIncrocio);
    }
    
    //progressiva
    else if ($('#selecTipoLocalizzazione').val() == "3") {
        var toponimo = $('#txtToponimo').val().trim();
        var km = 0;
        var hm = 0;
        if ($('#txtNStrada').val().trim().length > 0) {
            toponimo = $('#selectClAmm').val().trim() + $('#txtNStrada').val().trim();
        }
        if ($('#txtKm').val().trim().length > 0) {
            km = parseInt($('#txtKm').val().trim());
        }
        if ($('#txtHm').val().trim().length > 0) {
            hm = parseInt($('#txtHm').val().trim());
        }
        var m = km * 1000 + hm;
        var url = localizzatoreUrl + "/resources/normChilometricaJson" + "?handle=" + handle +
            "&idlrs=" + idLRS +
            "&p_toponimo=" + toponimo +
            "&p_km=" + m +
            "&p_comune=" + 'Comune Generico' +
            "&p_provincia=" + $('#txtProvincia').val().trim() +
            "&p_desc_uff=" + 'S' +
            "&p_tipo_strada=" + $('#selectClAmm').val() +
            "&p_tipo_coord=" + tipo_coord +
            "&callback=?";
        callJsonp(url, successLocalizzaChilometrica);
    }
    
    //coordinate
    else if ($('#selecTipoLocalizzazione').val() == "4" || $('#selecTipoLocalizzazione').val() == "4") {
        var wgsCoord = [parseFloat($('#txtLon').val()), parseFloat($('#txtLat').val())];
        var coord = ol.proj.transform(wgsCoord, 'EPSG:4326', 'EPSG:3857');
        url = layerComuni.getSource().getFeatureInfoUrl(coord, 2, 'EPSG:3857', { 'INFO_FORMAT': 'application/json' }) + "&FEATURE_COUNT=1";
        fetch(url).then(function (response) {
            return response.text();
        }).then(function(res) {
            getInfo(res);
        });
    }
    
    //solo testo
    else if ($('#selecTipoLocalizzazione').val() == "4" || $('#selecTipoLocalizzazione').val() == "5") { 
        map.getOverlays().clear();
        currResult = {
            TOPONIMO: $('#txtToponimo').val().trim()
        };
        results.push(currResult);
              
        $("#progressBar").css("display", "none");
        var html = '<div class="link-list-wrapper">' + 
            '<ul class="link-list">' +
                '<li>' +
                    '<h3 id="heading-senza-link">Risultati</h3>' +
                '</li>'+
                '<li>' +
                    '<a class="list-item" href="#" onClick="showResult(-1)"><span>' + $('#txtToponimo').val().trim() + '</span></a>' +
                '</li>' +
            '</ul>' +
        '</div>';
        $('#divResults').html(html);
        showResult(0);
    }
}

function localizzaRicerca() {
    resultsRicerca = null;
    
    $('#divResultsRicerca').html('');
    $("#progressBarRicerca").css("display", "block");
    
    url = localizzatoreUrl + "/resources/normIndirizzoJson" + "?handle=" + handle +
        "&p_toponimo=" + $('#txtToponimoRicerca').val().trim() +
        "&p_comune=" + $('#txtComuneRicerca').val().trim() +
        "&p_provincia=" + $('#txtProvinciaRicerca').val().trim() +
        "&p_tipo_coord=" + tipo_coord +
        "&p_rif_geo_civ=" + rif_geo_civ +
        "&callback=?";
    callJsonp(url, successLocalizzaCivicoRicerca);
}

//chiamata alle funzioni jsonp con un certo url e la funzione f di callback in caso di successo
function callJsonp(url, f) {
    //return $.getJSON(url, {}, f).fail(function (jqXHR, textStatus, errorThrown) {
    //    alert("fail " + errorThrown + "; " + jqXHR + textStatus);
    //});
    return $.ajax({
        dataType: "jsonp",
        url: url, //.replace("&callback=?", ""),
        success: f
    }).fail(function (jqXHR, textStatus, errorThrown) {
        alert("fail " + errorThrown + "; " + jqXHR + textStatus);
    });
}

function successGetHandle(result) {
    handle = result.handle;
    if (result.handle === null || result.handle.includes("Errore"))
    {
        alert("Normalizzatore non inizializzato; impossibile effettuare localizzazioni");
        return;
    }
}

function successLocalizzaCivico(result) {
    $("#progressBar").css("display", "none");
    
    if (result && result.records) 
    {
        //nessun risultato
        if (result.records.length === 0) {           
            var html = '<div class="alert alert-info" role="alert">' +
                    'Nessun risultato trovato.' +
                '</div>';
            $('#divResults').html(html);
        }
        //nessun risultato
        else if (result.records.length === 1 && Object.keys(result.records[0]).length === 0) {
            var html = '<div class="alert alert-info" role="alert">' +
                    'Nessun risultato trovato.' +
                '</div>';
            $('#divResults').html(html);
        }
        //risultati ottenuto
        else if (result.records.length > 0 && Object.keys(result.records[0]).length > 0) {
            results = result.records;
            
            var html = '<div class="link-list-wrapper">' + 
                    '<ul class="link-list">' +
                        '<li>' +
                            '<h3 id="heading-senza-link">Risultati</h3>' +
                        '</li>';
            for (var i = 0; i < result.records.length; i++) {
                var currRecord = result.records[i];
                var indirizzo = "";
                if(currRecord.DUG)
                    indirizzo = currRecord.DUG.concat(" ", currRecord.DENOMINAZIONE);
                else 
                    indirizzo = currRecord.DENOMINAZIONE;
                if (currRecord.DESCRIZIONE_CIVICO)
                    indirizzo = indirizzo.concat(", ", currRecord.DESCRIZIONE_CIVICO);
                html += '<li>' +
                            '<a class="list-item" href="#" onClick="showResult(' + i + ')"><span>' + indirizzo + '</span></a>' +
                        '</li>';
            }
            html += '</ul>' +
                '</div>';
            $('#divResults').html(html);
            if (result.records.length == 1) {
                showResult(0);
            }
        }
    }
    else {
        //nessun risultato
        var html = '<div class="alert alert-info" role="alert">' +
                'Nessun risultato trovato.' +
            '</div>';
        $('#divResults').html(html);
    }
}

function successLocalizzaCivicoInverso(result) {
    $("#progressBar").css("display", "none");
    if (result && result.records) 
    {
        //risultati ottenuto
        if (result.records.length > 0 && Object.keys(result.records[0]).length > 0) {
            var html = "";
            for (var i = 0; i < result.records.length; i++) {
                var currRecord = result.records[i];
                var indirizzo = "";
                if(currRecord.DUG)
                    indirizzo = currRecord.DUG.concat(" ", currRecord.DENOMINAZIONE);
                else 
                    indirizzo = currRecord.DENOMINAZIONE;
                if (currRecord.DESCRIZIONE_CIVICO)
                    indirizzo = indirizzo.concat(", ", currRecord.DESCRIZIONE_CIVICO);
                html += '<li>' +
                            '<a class="list-item" href="#" onClick="showResult(' + (results.length + i) + ')"><span>' + indirizzo + '</span></a>' +
                        '</li>';
                $('.link-list').append(html);
                results.push(currRecord);
            }
            if (result.records.length == 1) {
                showResult(0);
            }
        }
    }
}

function successLocalizzaCivicoRicerca(result) {
    $('#divResultsRicerca').html('');
    $("#progressBarRicerca").css("display", "none");
        
    if (result && result.records) 
    {
        //nessun risultato
        if (result.records.length === 0) {           
            var html = '<div class="alert alert-info" role="alert">' +
                    'Nessun risultato trovato.' +
                '</div>';
            $('#divResultsRicerca').html(html);
        }
        //nessun risultato
        else if (result.records.length === 1 && Object.keys(result.records[0]).length === 0) {
            var html = '<div class="alert alert-info" role="alert">' +
                    'Nessun risultato trovato.' +
                '</div>';
            $('#divResultsRicerca').html(html);
        }
        //risultati ottenuto
        else if (result.records.length > 0 && Object.keys(result.records[0]).length > 0) {       
            resultsRicerca = result.records;
            var html = '<div class="link-list-wrapper">' + 
                    '<ul class="link-list">' +
                        '<li>' +
                            '<h3 id="heading-senza-link">Risultati</h3>' +
                        '</li>';
            for (var i = 0; i < result.records.length; i++) {
                var currRecord = result.records[i];
                var indirizzo = "";
                if(currRecord.DUG)
                    indirizzo = currRecord.DUG.concat(" ", currRecord.DENOMINAZIONE);
                else 
                    indirizzo = currRecord.DENOMINAZIONE;
                if (currRecord.DESCRIZIONE_CIVICO)
                    indirizzo = indirizzo.concat(", ", currRecord.DESCRIZIONE_CIVICO);
                html += '<li>' +
                            '<a class="list-item" href="#" onClick="showResultRicerca(' + i + ')"><span>' + indirizzo + '</span></a>' +
                        '</li>';
            }
            html += '</ul>' +
                '</div>';
            $('#divResultsRicerca').html(html);
            if (result.records.length == 1) {
                showResultRicerca(0);
            }
        }
    }
    else {
        //nessun risultato
        var html = '<div class="alert alert-info" role="alert">' +
                'Nessun risultato trovato.' +
            '</div>';
        $('#divResultsRicerca').html(html);
    }
}

function successLocalizzaIncrocio(result) {
    $("#progressBar").css("display", "none");
        
    if (result && result.records) 
    {
        //nessun risultato
        if (result.records.length === 0) {           
            var html = '<div class="alert alert-info" role="alert">' +
                    'Nessun risultato trovato.' +
                '</div>';
            $('#divResults').html(html);
        }
        //nessun risultato
        else if (result.records.length === 1 && Object.keys(result.records[0]).length === 0) {
            var html = '<div class="alert alert-info" role="alert">' +
                    'Nessun risultato trovato.' +
                '</div>';
            $('#divResults').html(html);
        }
        //risultati ottenuto
        else if (result.records.length > 0 && Object.keys(result.records[0]).length > 0) {
            results = result.records;
            
            var html = '<div class="link-list-wrapper">' + 
                    '<ul class="link-list">' +
                        '<li>' +
                            '<h3 id="heading-senza-link">Risultati</h3>' +
                        '</li>';
            for (var i = 0; i < result.records.length; i++) {
                var currRecord = result.records[i];
                
                var toponimo1 = "";
                if(currRecord.DUG1)
                    toponimo1 = currRecord.DUG1.concat(" ", currRecord.DENOMINAZIONE1);
                else 
                    toponimo1 = currRecord.DENOMINAZIONE1;
                
                var toponimo2 = "";
                if(currRecord.DUG2)
                    toponimo2 = currRecord.DUG2.concat(" ", currRecord.DENOMINAZIONE2);
                else 
                    toponimo2 = currRecord.DENOMINAZIONE2;
                            
                var incrocio = toponimo1.concat(" incrocio ", toponimo2);
                
                html += '<li>' +
                            '<a class="list-item" href="#" onClick="showResult(' + i + ')"><span>' + incrocio + '</span></a>' +
                        '</li>';
            }
            html += '</ul>' +
                '</div>';
            $('#divResults').html(html);
            if (result.records.length == 1) {
                showResult(0);
            }
        }
    }
    else {
        //nessun risultato
        var html = '<div class="alert alert-info" role="alert">' +
                'Nessun risultato trovato.' +
            '</div>';
        $('#divResults').html(html);
    }
}

function successLocalizzaIncrocioInverso(result) {
    $("#progressBar").css("display", "none");
    
    if (result && result.records) 
    {
        //risultati ottenuto
        if (result.records.length > 0 && Object.keys(result.records[0]).length > 0) {
            var html = "";
            for (var i = 0; i < result.records.length; i++) {
                var currRecord = result.records[i];
                
                var toponimo1 = "";
                if(currRecord.DUG1)
                    toponimo1 = currRecord.DUG1.concat(" ", currRecord.DENOMINAZIONE1);
                else 
                    toponimo1 = currRecord.DENOMINAZIONE1;
                
                var toponimo2 = "";
                if(currRecord.DUG2)
                    toponimo2 = currRecord.DUG2.concat(" ", currRecord.DENOMINAZIONE2);
                else 
                    toponimo2 = currRecord.DENOMINAZIONE2;
                            
                var incrocio = toponimo1.concat(" incrocio ", toponimo2);
                
                html += '<li>' +
                    '<a class="list-item" href="#" onClick="showResult(' + i + ')"><span>' + incrocio + '</span></a>' +
                '</li>';
                $('.link-list').append(html);
                results.push(currRecord);
            }
            if (result.records.length == 1) {
                showResult(0);
            }
        }
    }
}

function successLocalizzaChilometrica(result) {
    $("#progressBar").css("display", "none");
        
    if (result && result.records) 
    {
        //nessun risultato
        if (result.records.length === 0) {           
            var html = '<div class="alert alert-info" role="alert">' +
                    'Nessun risultato trovato.' +
                '</div>';
            $('#divResults').html(html);
        }
        //nessun risultato
        else if (result.records.length === 1 && Object.keys(result.records[0]).length === 0) {
            var html = '<div class="alert alert-info" role="alert">' +
                    'Nessun risultato trovato.' +
                '</div>';
            $('#divResults').html(html);
        }
        //risultati ottenuto
        else if (result.records.length > 0 && Object.keys(result.records[0]).length > 0) {
            results = result.records;
            
            var html = '<div class="link-list-wrapper">' + 
                    '<ul class="link-list">' +
                        '<li>' +
                            '<h3 id="heading-senza-link">Risultati</h3>' +
                        '</li>';
            for (var i = 0; i < result.records.length; i++) {
                var currRecord = result.records[i];
                var m = currRecord.KM % 1000;
                var km = (currRecord.KM - m) / 1000;
                var progressiva = currRecord.DENOMINAZIONE.concat(", Km ", km, "+", m);
                html += '<li>' +
                            '<a class="list-item" href="#" onClick="showResult(' + i + ')"><span>' + progressiva + '</span></a>' +
                        '</li>';
            }
            html += '</ul>' +
                '</div>';
            $('#divResults').html(html);
            if (result.records.length == 1) {
                showResult(0);
            }
        }
    }
    else {
        //nessun risultato
        var html = '<div class="alert alert-info" role="alert">' +
                'Nessun risultato trovato.' +
            '</div>';
        $('#divResults').html(html);
    }
}

function successLocalizzaChilometricaInversa(result) {
    $('#divResults').html('');
    if (result && result.road_id) 
    {
        url = localizzatoreUrl + "/resources/queryXYJson" + "?m=" + result.m +
            "&asta=" + result.road_id +
            "&p_provincia1=" + com_prov1.provincia +
            "&p_toponimo2=" + toponimo2 +
            "&p_comune2=" + com_prov2.comune +
            "&p_provincia2=" + com_prov2.provincia +
            "&p_tipo_coord=" + tipo_coord +
            "&callback=?";
        callJsonp(url, successLocalizzaIncrocio);
    }
    else {
        //nessun risultato
        var html = '<div class="alert alert-info" role="alert">' +
                'Nessun risultato trovato.' +
            '</div>';
        $('#divResults').html(html);
    }
}
                                                                                                                        
function showResult(index) {
    currResult = results[index];    
    if ($('#selecTipoLocalizzazione').val() === '1') {
        //ho ricavato il civico
        currResult.tipoLocalizzazione = 1;
        if (currResult.ENTITA_CIVICO_ID) {
            if (currResult.CIVICO_X && currResult.CIVICO_Y) {
                var coord = ol.proj.transform([currResult.CIVICO_X, currResult.CIVICO_Y], normalizzatoreSRID,  'EPSG:3857');
                setPlacemark(coord[0], coord[1], '#C00', 'pushpin', true);
            }
            else {
                var html = '<div class="alert alert-warning" role="alert">' +
                    'Civico individuato, ma coordinate associate non presenti.' +
                '</div>';
                $('#divResults').html(html);
            }
        }
        //zoom sul centroide del toponimo
        else {
            if (currResult.CENTR_X && currResult.CENTR_Y) {
                var coord = ol.proj.transform([currResult.CENTR_X, currResult.CENTR_Y], normalizzatoreSRID,  'EPSG:3857');
                setPlacemark(coord[0], coord[1], '#00C', 'pushpin', true);
            }
            else {
                var html = '<div class="alert alert-warning" role="alert">' +
                    'Toponimo individuato, ma coordinate del centroide non presenti.' +
                '</div>';
                $('#divResults').html(html);
            }
        }
        window.dispatchEvent(new CustomEvent('locChanged', {detail: currResult}));
    }
    else if ($('#selecTipoLocalizzazione').val() === '2') {
        currResult.tipoLocalizzazione = 2;
        if (currResult.INC_X && currResult.INC_Y) {
            var coord = ol.proj.transform([currResult.INC_X, currResult.INC_Y], normalizzatoreSRID,  'EPSG:3857');
            setPlacemark(coord[0], coord[1], '#C00', 'pushpin', true);
        }
        else {
            var html = '<div class="alert alert-warning" role="alert">' +
                'Incrocio individuato, ma coordinate associate non presenti.' +
            '</div>';
            $('#divResults').html(html);
        }
        window.dispatchEvent(new CustomEvent('locChanged', {detail: currResult}));
    }
    else if ($('#selecTipoLocalizzazione').val() === '3') {
        currResult.tipoLocalizzazione = 3;      
        if (currResult.KM_X && currResult.KM_Y) {
            var coord = ol.proj.transform([currResult.KM_X, currResult.KM_Y], normalizzatoreSRID,  'EPSG:3857');
            setPlacemark(coord[0], coord[1], '#C00', 'pushpin', true);
            var url = layerComuni.getSource().getFeatureInfoUrl(coord, 2, 'EPSG:3857', { 'INFO_FORMAT': 'application/json' }) + "&FEATURE_COUNT=1";
            fetch(url).then(function (response) {
                return response.text();
            }).then(function(res) {
                var xml = ol.xml.parse(res);
                var records = xml.getElementsByTagName("FIELDS");
                if (records && records.length && records.length > 0) {
                    var currRecord = records[0];
                    var currIstat = currRecord.attributes["Istat"].value;
                    var comune = getComuneProvinciaFromIstat(currIstat);
                    currResult.COMUNE = comune.comune.toUpperCase();
                    currResult.PROVINCIA = comune.provincia.toUpperCase();
                    currResult.CODISTAT = currIstat;
                }            
                window.dispatchEvent(new CustomEvent('locChanged', {detail: currResult}));
            });      
        }
        else {
            var html = '<div class="alert alert-warning" role="alert">' +
                'Chilometrica individuata, ma coordinate associate non presenti.' +
            '</div>';
            $('#divResults').html(html);
            window.dispatchEvent(new CustomEvent('locChanged', {detail: currResult}));
        }
    }
    else if ($('#selecTipoLocalizzazione').val() === '4') {
        currResult.tipoLocalizzazione = 4;
        var coord = ol.proj.transform([currResult.X, currResult.Y], normalizzatoreSRID,  'EPSG:3857');
        setPlacemark(coord[0], coord[1], '#C00', 'pushpin', true);
        window.dispatchEvent(new CustomEvent('locChanged', {detail: currResult}));
    }  
    else if ($('#selecTipoLocalizzazione').val() === '5') {
        currResult.tipoLocalizzazione = 5;
        window.dispatchEvent(new CustomEvent('locChanged', {detail: currResult}));
    }  
}

function showResultRicerca(index) {
    var currResultRicerca = resultsRicerca[index];
    if (currResultRicerca.ENTITA_CIVICO_ID) {
        if (currResultRicerca.CIVICO_X && currResultRicerca.CIVICO_Y) {
            var coord = ol.proj.transform([currResultRicerca.CIVICO_X, currResultRicerca.CIVICO_Y], normalizzatoreSRID,  'EPSG:3857');
            setPlacemark(coord[0], coord[1], '#080', 'default', true);
        }
        else {
            var html = '<div class="alert alert-warning" role="alert">' +
                'Civico individuato, ma coordinate associate non presenti.' +
            '</div>';
            $('#divResultsRicerca').html(html);
        }
    }
    //zoom sul centroide del toponimo
    else {
        if (currResultRicerca.CENTR_X && currResultRicerca.CENTR_Y) {
            var coord = ol.proj.transform([currResultRicerca.CENTR_X, currResultRicerca.CENTR_Y], normalizzatoreSRID,  'EPSG:3857');
            setPlacemark(coord[0], coord[1], '#080', 'default', true);
        }
        else {
            var html = '<div class="alert alert-warning" role="alert">' +
                'Toponimo individuato, ma coordinate del centroide non presenti.' +
            '</div>';
            $('#divResultsRicerca').html(html);
        }
    }
}

function setPlacemark(x, y, color, className, doZoom) {
    var coord = [x, y];
    map.getOverlays().clear();
    var placemark = new ol.Overlay.Placemark({
        autoPan: true,
        autoPanAnimation: { duration: 250 }
    });
    placemark.setClassName(className);
    placemark.setColor(color);
    map.getOverlays().push(placemark);
    placemark.show(coord);
    if (doZoom) {
        map.getView().fit([coord[0] - 1, coord[1] - 1, coord[0] + 1, coord[1] +1]);
        map.getView().setZoom(11.5);
    }
}

function getResults() {
    return results;
}

function getCurrentResult() {
    return currResult;
}

function getComuneProvinciaFromIstat(codice_istat) {
    var comune = null;
    var provincia = null;
    var x_min = null;
    var y_min = null;
    var x_max = null;
    var y_max = null;
    
    for (var i = 0; i < codici_istat.length; i++) {
        if (codici_istat[i].codistat === codice_istat) {
            comune = codici_istat[i].nome_comune;
            x_min = codici_istat[i].x_min;
            y_min = codici_istat[i].y_min;
            x_max = codici_istat[i].x_max;
            y_max = codici_istat[i].y_max;
            break;
        }
    }
    if (comune) {
        if (codice_istat.startsWith("033"))
            provincia = "Piacenza";
        else if (codice_istat.startsWith("034"))
            provincia = "Parma";
        else if (codice_istat.startsWith("035"))
            provincia = "Reggio Emilia";
        else if (codice_istat.startsWith("036"))
            provincia = "Modena";
        else if (codice_istat.startsWith("037"))
            provincia = "Bologna";
        else if (codice_istat.startsWith("038"))
            provincia = "Ferrara";
        else if (codice_istat.startsWith("039"))
            provincia = "Ravenna";
        else if (codice_istat.startsWith("040"))
            provincia = "Forlì-Cesena";
        else if (codice_istat.startsWith("099"))
            provincia = "Rimini";
        return {"comune": comune, "provincia": provincia, "x_min": x_min, "y_min": y_min, "x_max": x_max, "y_max": y_max};
    }
    else
        return null;
}

function zoomComune(codistat) {
    var comune = getComuneProvinciaFromIstat(codistat);
    map.getView().fit([comune.x_min, comune.y_min, comune.x_max, comune.y_max]);
}

function setComune(comune) {
    currComune = comune;
}

function setProvincia(provincia) {
    currProvincia = provincia;
}

var codici_istat = [
{"codistat":"037048", "nome_comune":"PIEVE DI CENTO", "x_min":1255403.2525747304, "y_min":5574311.988754661, "x_max":1267747.9179835878, "y_max":5587006.181846209},
{"codistat":"035009", "nome_comune":"CAMPAGNOLA EMILIA", "x_min":1193400.0514412688, "y_min":5591112.290387306, "x_max":1202010.6874938433, "y_max":5605767.821283633},
{"codistat":"035015", "nome_comune":"CASTELNOVO DI SOTTO", "x_min":1172138.5161965624, "y_min":5588495.880694751, "x_max":1183113.950480474, "y_max":5601457.3380736},
{"codistat":"040012", "nome_comune":"FORLI'", "x_min":1327120.0129606654, "y_min":5484961.427334234, "x_max":1359353.6961349072, "y_max":5516814.479932535},
{"codistat":"040043", "nome_comune":"SANTA SOFIA", "x_min":1303310.8737978472, "y_min":5441480.949154473, "x_max":1341653.5255351167, "y_max":5462502.753353679},
{"codistat":"040044", "nome_comune":"SARSINA", "x_min":1339300.2288127786, "y_min":5441804.167696611, "x_max":1355309.674714212, "y_max":5469199.276948983},
{"codistat":"035008", "nome_comune":"CADELBOSCO DI SOPRA", "x_min":1175026.1995095739, "y_min":5581662.027016002, "x_max":1186907.439845759, "y_max":5599544.742272785},
{"codistat":"036006", "nome_comune":"CASTELFRANCO EMILIA", "x_min":1222483.5886013415, "y_min":5546615.374558489, "x_max":1241531.8078747697, "y_max":5568491.986379222},
{"codistat":"099009", "nome_comune":"MONTEGRIDOLFO", "x_min":1411705.982228162, "y_min":5442510.830167802, "x_max":1417553.817067345, "y_max":5447229.963602443},
{"codistat":"099017", "nome_comune":"SAN GIOVANNI IN MARIGNANO", "x_min":1410587.9950109331, "y_min":5451330.347844053, "x_max":1418319.5553076668, "y_max":5459802.570668709},
{"codistat":"038003", "nome_comune":"BONDENO", "x_min":1250624.4347540953, "y_min":5594985.276153055, "x_max":1279510.2349314129, "y_max":5615706.653047047},
{"codistat":"033021", "nome_comune":"FIORENZUOLA D'ARDA", "x_min":1095749.16991808, "y_min":5604563.372449617, "x_max":1110538.4338641015, "y_max":5619026.700252879},
{"codistat":"033049", "nome_comune":"ALTA VAL TIDONE", "x_min":1032730.4663155512, "y_min":5593635.5905146515, "x_max":1051928.947384681, "y_max":5617177.394979026},
{"codistat":"036022", "nome_comune":"MIRANDOLA", "x_min":1224135.532084357, "y_min":5596921.750519306, "x_max":1253516.5779587622, "y_max":5615692.171962193},
{"codistat":"036001", "nome_comune":"BASTIGLIA", "x_min":1220712.9648132017, "y_min":5574514.809815527, "x_max":1227244.7844139955, "y_max":5580219.185168399},
{"codistat":"035012", "nome_comune":"CASALGRANDE", "x_min":1191646.099923405, "y_min":5549479.683948164, "x_max":1200773.9341307632, "y_max":5564682.401580968},
{"codistat":"035024", "nome_comune":"GUASTALLA", "x_min":1183189.3878350141, "y_min":5598277.245969338, "x_max":1196927.0401209437, "y_max":5613362.810524814},
{"codistat":"033047", "nome_comune":"ZERBA", "x_min":1023937.4480399105, "y_min":5565653.1966259265, "x_max":1036212.7873171663, "y_max":5576632.166147486},
{"codistat":"033032", "nome_comune":"PIACENZA", "x_min":1068665.9097737134, "y_min":5620286.26919638, "x_max":1093603.3506093775, "y_max":5639398.502356731},
{"codistat":"037039", "nome_comune":"MOLINELLA", "x_min":1289332.5199102405, "y_min":5549160.300612512, "x_max":1314281.1934091786, "y_max":5570177.351691494},
{"codistat":"037019", "nome_comune":"CASTEL MAGGIORE", "x_min":1258814.8165876993, "y_min":5549858.281834688, "x_max":1270668.3429078264, "y_max":5559830.306737655},
{"codistat":"037055", "nome_comune":"SAN PIETRO IN CASALE", "x_min":1260754.4793387756, "y_min":5569408.969104586, "x_max":1278313.255845444, "y_max":5582713.993584156},
{"codistat":"034003", "nome_comune":"BEDONIA", "x_min":1056468.7620937715, "y_min":5533867.907694517, "x_max":1076396.033370065, "y_max":5560675.383967611},
{"codistat":"038007", "nome_comune":"COPPARO", "x_min":1306641.3036672133, "y_min":5593936.374237577, "x_max":1336243.1708983947, "y_max":5615105.663030558},
{"codistat":"034012", "nome_comune":"CORNIGLIO", "x_min":1109712.688623212, "y_min":5523327.785608856, "x_max":1134579.314858274, "y_max":5554403.722600897},
{"codistat":"036024", "nome_comune":"MONTECRETO", "x_min":1189127.684752067, "y_min":5496192.82434763, "x_max":1201376.1003179606, "y_max":5511877.321573614},
{"codistat":"036009", "nome_comune":"CAVEZZO", "x_min":1219528.7620075226, "y_min":5591623.891649074, "x_max":1229740.4922976787, "y_max":5601436.464118011},
{"codistat":"034020", "nome_comune":"MEDESANO", "x_min":1111212.5896463366, "y_min":5573039.488383818, "x_max":1133479.2725239175, "y_max":5587358.622299869},
{"codistat":"033020", "nome_comune":"FERRIERE", "x_min":1044747.669901944, "y_min":5551830.186718799, "x_max":1069260.5241426274, "y_max":5574413.053783639},
{"codistat":"038022", "nome_comune":"VIGARANO MAINARDA", "x_min":1273726.2760234813, "y_min":5590136.323449128, "x_max":1285205.7894599845, "y_max":5607299.50457978},
{"codistat":"033026", "nome_comune":"LUGAGNANO VAL D'ARDA", "x_min":1079487.5210559797, "y_min":5584319.063717101, "x_max":1096309.9952203257, "y_max":5600766.389478176},
{"codistat":"099002", "nome_comune":"CATTOLICA", "x_min":1414832.130923615, "y_min":5456165.421821722, "x_max":1419969.6689446298, "y_max":5461166.098503378},
{"codistat":"035039", "nome_comune":"SANT'ILARIO D'ENZA", "x_min":1160488.2709746705, "y_min":5579018.558501225, "x_max":1170721.6109729544, "y_max":5585975.407593074},
{"codistat":"035018", "nome_comune":"CANOSSA", "x_min":1152273.11073171, "y_min":5542888.070534348, "x_max":1166431.2956799357, "y_max":5561258.368553021},
{"codistat":"037014", "nome_comune":"CASTEL DEL RIO", "x_min":1271477.994423889, "y_min":5489513.410425109, "x_max":1287097.709586912, "y_max":5504286.162803056},
{"codistat":"040050", "nome_comune":"VERGHERETO", "x_min":1330313.2872420033, "y_min":5425285.276260171, "x_max":1352642.9498007754, "y_max":5445741.248864884},
{"codistat":"034028", "nome_comune":"PELLEGRINO PARMENSE", "x_min":1094495.3199888181, "y_min":5574325.1027119355, "x_max":1111884.6943258736, "y_max":5591240.111439521},
{"codistat":"034032", "nome_comune":"SALSOMAGGIORE TERME", "x_min":1102067.6681120815, "y_min":5582278.714313434, "x_max":1119057.5389360178, "y_max":5598666.266910904},
{"codistat":"035021", "nome_comune":"FABBRICO", "x_min":1199226.448411415, "y_min":5597957.714775391, "x_max":1208112.0948901959, "y_max":5606252.735920284},
{"codistat":"040049", "nome_comune":"TREDOZIO", "x_min":1300458.65436963, "y_min":5467324.845686735, "x_max":1316614.79437776, "y_max":5484047.8174204035},
{"codistat":"037024", "nome_comune":"CREVALCORE", "x_min":1236244.4455411027, "y_min":5572654.202846995, "x_max":1257155.3307233811, "y_max":5590925.900183618},
{"codistat":"099006", "nome_comune":"MONDAINO", "x_min":1403810.582314994, "y_min":5437766.130684013, "x_max":1411998.5279042555, "y_max":5446546.730697449},
{"codistat":"036036", "nome_comune":"SAN CESARIO SUL PANARO", "x_min":1223167.9938781357, "y_min":5547190.369041369, "x_max":1230876.7991313955, "y_max":5563780.006604435},
{"codistat":"036008", "nome_comune":"CASTELVETRO DI MODENA", "x_min":1210781.1480296461, "y_min":5536045.307061069, "x_max":1223511.4200227645, "y_max":5549967.978514573},
{"codistat":"036029", "nome_comune":"PALAGANO", "x_min":1178095.234056935, "y_min":5503260.597356754, "x_max":1190837.5082102388, "y_max":5528693.475777845},
{"codistat":"038019", "nome_comune":"PORTOMAGGIORE", "x_min":1305840.1202772057, "y_min":5566399.935728231, "x_max":1333242.9126128235, "y_max":5583657.074083391},
{"codistat":"040028", "nome_comune":"MONTIANO", "x_min":1366240.7157008608, "y_min":5473632.903430256, "x_max":1371112.0873641532, "y_max":5480626.927835519},
{"codistat":"033010", "nome_comune":"CAORSO", "x_min":1090445.2691382656, "y_min":5624610.367346192, "x_max":1103303.7555290135, "y_max":5636773.739375751},
{"codistat":"037007", "nome_comune":"BORGO TOSSIGNANO", "x_min":1286395.9520023346, "y_min":5502420.230024868, "x_max":1298643.850103797, "y_max":5512500.890138305},
{"codistat":"033038", "nome_comune":"RIVERGARO", "x_min":1064027.766688313, "y_min":5598807.995290056, "x_max":1075235.3246873952, "y_max":5616916.329588739},
{"codistat":"040032", "nome_comune":"PREDAPPIO", "x_min":1323320.1722141206, "y_min":5469815.4414191535, "x_max":1337231.4192989077, "y_max":5490219.504088685},
{"codistat":"035003", "nome_comune":"BAISO", "x_min":1176239.4304369332, "y_min":5528414.368066153, "x_max":1187903.971778862, "y_max":5550324.558188603},
{"codistat":"039010", "nome_comune":"FAENZA", "x_min":1309230.1318546878, "y_min":5498018.697543462, "x_max":1339242.5424937492, "y_max":5524445.725137858},
{"codistat":"099025", "nome_comune":"SAN LEO", "x_min":1370925.620840887, "y_min":5445438.696878497, "x_max":1383983.413462843, "y_max":5459689.251697834},
{"codistat":"040003", "nome_comune":"BERTINORO", "x_min":1344817.432493747, "y_min":5481324.932683236, "x_max":1359578.3073294875, "y_max":5501149.059489121},
{"codistat":"035040", "nome_comune":"SCANDIANO", "x_min":1183854.7509830433, "y_min":5549134.450057202, "x_max":1197513.0081864414, "y_max":5566097.573310689},
{"codistat":"033028", "nome_comune":"MORFASSO", "x_min":1074549.7615485666, "y_min":5569922.611424372, "x_max":1090716.1548454356, "y_max":5588075.583183008},
{"codistat":"037016", "nome_comune":"CASTEL GUELFO DI BOLOGNA", "x_min":1291859.3775357013, "y_min":5530739.247493514, "x_max":1306036.6806834708, "y_max":5541067.195923698},
{"codistat":"035030", "nome_comune":"QUATTRO CASTELLA", "x_min":1163591.7847187943, "y_min":5557556.373143075, "x_max":1178621.839844149, "y_max":5567535.329575555},
{"codistat":"099004", "nome_comune":"GEMMANO", "x_min":1394807.5294604949, "y_min":5444448.84882897, "x_max":1402894.1206725254, "y_max":5452975.258313099},
{"codistat":"037025", "nome_comune":"DOZZA", "x_min":1290279.1865749517, "y_min":5518873.974488931, "x_max":1299824.2212409617, "y_max":5531939.6941142315},
{"codistat":"037010", "nome_comune":"CAMUGNANO", "x_min":1227760.4727434379, "y_min":5479265.941668158, "x_max":1244431.7910482911, "y_max":5498712.827329148},
{"codistat":"037020", "nome_comune":"CASTEL SAN PIETRO TERME", "x_min":1275127.303086835, "y_min":5513091.701231369, "x_max":1295662.5817302507, "y_max":5539973.9412878435},
{"codistat":"034023", "nome_comune":"MONTECHIARUGOLO", "x_min":1150061.452309074, "y_min":5569099.3237684155, "x_max":1163015.894264148, "y_max":5582066.009747507},
{"codistat":"034030", "nome_comune":"ROCCABIANCA", "x_min":1131950.6292053664, "y_min":5615523.780857533, "x_max":1142832.163907468, "y_max":5626777.614330704},
{"codistat":"036038", "nome_comune":"SAN POSSIDONIO", "x_min":1219836.8574550187, "y_min":5598576.700937042, "x_max":1228703.0846007727, "y_max":5607353.575901204},
{"codistat":"033008", "nome_comune":"CALENDASCO", "x_min":1061550.154293713, "y_min":5630373.119094984, "x_max":1077287.4667549254, "y_max":5642624.018536823},
{"codistat":"040046", "nome_comune":"SOGLIANO AL RUBICONE", "x_min":1354746.224044668, "y_min":5451185.650188029, "x_max":1375209.991073309, "y_max":5470459.830336934},
{"codistat":"040011", "nome_comune":"DOVADOLA", "x_min":1317111.934216072, "y_min":5477162.703875091, "x_max":1326403.3108922462, "y_max":5491822.809535449},
{"codistat":"033037", "nome_comune":"PONTENURE", "x_min":1085801.7302604003, "y_min":5611980.814681075, "x_max":1095511.926914168, "y_max":5627054.588531899},
{"codistat":"034035", "nome_comune":"SOLIGNANO", "x_min":1100688.280047505, "y_min":5556656.015764037, "x_max":1123242.9159926216, "y_max":5572944.589249788},
{"codistat":"036045", "nome_comune":"SPILAMBERTO", "x_min":1219683.307794924, "y_min":5543754.496106125, "x_max":1228988.39843289, "y_max":5555570.948487887},
{"codistat":"034011", "nome_comune":"COMPIANO", "x_min":1073143.4701027083, "y_min":5539224.912630662, "x_max":1080427.1182309038, "y_max":5557155.446190295},
{"codistat":"033025", "nome_comune":"GROPPARELLO", "x_min":1074313.2059380964, "y_min":5580657.822453722, "x_max":1087712.1360753097, "y_max":5601888.680070211},
{"codistat":"036037", "nome_comune":"SAN FELICE SUL PANARO", "x_min":1234047.6993560176, "y_min":5590666.110727688, "x_max":1249454.3137401443, "y_max":5603716.889799434},
{"codistat":"034015", "nome_comune":"FONTANELLATO", "x_min":1124415.1464173286, "y_min":5596167.696779748, "x_max":1140668.1672457985, "y_max":5609318.553860645},
{"codistat":"033044", "nome_comune":"VERNASCA", "x_min":1086371.9815389658, "y_min":5575928.382224856, "x_max":1107558.9358712465, "y_max":5599264.06343878},
{"codistat":"033035", "nome_comune":"PODENZANO", "x_min":1073867.8807345233, "y_min":5610199.905378754, "x_max":1086535.2764792158, "y_max":5622634.815788244},
{"codistat":"034046", "nome_comune":"VARSI", "x_min":1083926.190047756, "y_min":5558558.378291901, "x_max":1105948.122280312, "y_max":5573259.836423621},
{"codistat":"035027", "nome_comune":"MONTECCHIO EMILIA", "x_min":1159779.8839437044, "y_min":5570343.660030136, "x_max":1169168.849893623, "y_max":5581165.516819981},
{"codistat":"034031", "nome_comune":"SALA BAGANZA", "x_min":1131409.8190086773, "y_min":5565004.957713455, "x_max":1140405.445441548, "y_max":5580116.475097146},
{"codistat":"037027", "nome_comune":"GAGGIO MONTANO", "x_min":1214191.7635692323, "y_min":5492545.51425817, "x_max":1230273.5598369965, "y_max":5507502.461357365},
{"codistat":"033036", "nome_comune":"PONTE DELL'OLIO", "x_min":1069806.8714987251, "y_min":5593188.631588944, "x_max":1081929.9806414994, "y_max":5606977.851873904},
{"codistat":"035005", "nome_comune":"BORETTO", "x_min":1171719.446456307, "y_min":5602148.648498017, "x_max":1179614.707322604, "y_max":5608488.288966258},
{"codistat":"033017", "nome_comune":"CORTE BRUGNATELLA", "x_min":1034207.6867822997, "y_min":5569929.736542017, "x_max":1051913.5898278884, "y_max":5581111.699520176},
{"codistat":"038010", "nome_comune":"JOLANDA DI SAVOIA", "x_min":1323720.933133092, "y_min":5591392.845021826, "x_max":1344089.6584730793, "y_max":5614215.616757095},
{"codistat":"037015", "nome_comune":"CASTEL DI CASIO", "x_min":1221648.6882326705, "y_min":5480410.894957075, "x_max":1231831.510368528, "y_max":5497751.000034395},
{"codistat":"099013", "nome_comune":"RICCIONE", "x_min":1402817.4880334616, "y_min":5461393.90275854, "x_max":1412505.4262793546, "y_max":5469341.865249502},
{"codistat":"038008", "nome_comune":"FERRARA", "x_min":1276050.8498806886, "y_min":5570419.062906878, "x_max":1322163.6643593232, "y_max":5611710.400253355},
{"codistat":"033023", "nome_comune":"GOSSOLENGO", "x_min":1067508.0951018466, "y_min":5614485.621927134, "x_max":1077019.7598339843, "y_max":5626286.843130055},
{"codistat":"037041", "nome_comune":"MONTERENZIO", "x_min":1264985.2536020447, "y_min":5498377.39771402, "x_max":1278996.2703219152, "y_max":5524305.05673985},
{"codistat":"034040", "nome_comune":"TORNOLO", "x_min":1050667.782684622, "y_min":5529188.38845029, "x_max":1075480.0935754688, "y_max":5541886.605300078},
{"codistat":"034013", "nome_comune":"FELINO", "x_min":1133062.7367149456, "y_min":5564503.698592639, "x_max":1146382.6105154187, "y_max":5578138.748297983},
{"codistat":"033041", "nome_comune":"SAN PIETRO IN CERRO", "x_min":1099985.010043419, "y_min":5622220.550913359, "x_max":1111535.0330790048, "y_max":5631495.504400672},
{"codistat":"036021", "nome_comune":"MEDOLLA", "x_min":1228085.651022955, "y_min":5591178.0076656435, "x_max":1237251.6843125168, "y_max":5601786.0074793855},
{"codistat":"033043", "nome_comune":"TRAVO", "x_min":1051928.947384681, "y_min":5589419.367046877, "x_max":1068068.9792427807, "y_max":5609186.075107981},
{"codistat":"038014", "nome_comune":"MESOLA", "x_min":1346889.5988075554, "y_min":5593829.0775003685, "x_max":1368650.4019775928, "y_max":5615508.232212903},
{"codistat":"033006", "nome_comune":"BORGONOVO VAL TIDONE", "x_min":1046474.4678322106, "y_min":5614080.124145649, "x_max":1061382.0579652563, "y_max":5628878.872182243},
{"codistat":"034045", "nome_comune":"VARANO DE'MELEGARI", "x_min":1099323.6006718255, "y_min":5567770.641985629, "x_max":1123299.6368802218, "y_max":5578685.986372929},
{"codistat":"038025", "nome_comune":"GORO", "x_min":1363826.920141298, "y_min":5587383.222029166, "x_max":1380275.3798092438, "y_max":5604824.780228915},
{"codistat":"037011", "nome_comune":"CASALECCHIO DI RENO", "x_min":1250382.283586244, "y_min":5535183.23038196, "x_max":1257560.8525665225, "y_max":5542237.295692713},
{"codistat":"037030", "nome_comune":"GRANAROLO DELL'EMILIA", "x_min":1266929.113817307, "y_min":5546403.620553485, "x_max":1277535.3403113326, "y_max":5559122.934712608},
{"codistat":"036032", "nome_comune":"POLINAGO", "x_min":1187570.9447347564, "y_min":5514612.309946593, "x_max":1198849.2249530586, "y_max":5531717.407428658},
{"codistat":"099020", "nome_comune":"VERUCCHIO", "x_min":1379079.0083011566, "y_min":5448570.89670041, "x_max":1387363.3472790439, "y_max":5470455.560037863},
{"codistat":"039009", "nome_comune":"COTIGNOLA", "x_min":1319484.030365112, "y_min":5518864.392111266, "x_max":1334033.4821712647, "y_max":5528871.419996442},
{"codistat":"036033", "nome_comune":"PRIGNANO SULLA SECCHIA", "x_min":1182232.7068544007, "y_min":5526617.284828838, "x_max":1201587.6888799279, "y_max":5543500.115344928},
{"codistat":"035010", "nome_comune":"CAMPEGINE", "x_min":1166949.727902586, "y_min":5583294.963587582, "x_max":1177356.0056253204, "y_max":5590100.803737042},
{"codistat":"036039", "nome_comune":"SAN PROSPERO", "x_min":1222615.019930275, "y_min":5582071.737492686, "x_max":1234177.3194614023, "y_max":5593886.121628015},
{"codistat":"040036", "nome_comune":"ROCCA SAN CASCIANO", "x_min":1312224.0480475598, "y_min":5467396.6556141935, "x_max":1325987.6313928547, "y_max":5482949.03359855},
{"codistat":"037035", "nome_comune":"MALALBERGO", "x_min":1274732.6513895344, "y_min":5562208.844529724, "x_max":1289430.1293177463, "y_max":5579657.904941194},
{"codistat":"099001", "nome_comune":"BELLARIA-IGEA MARINA", "x_min":1383471.0142694074, "y_min":5482158.874481943, "x_max":1391902.0327149227, "y_max":5490561.351314169},
{"codistat":"040016", "nome_comune":"GATTEO", "x_min":1376367.4208148452, "y_min":5480953.344891603, "x_max":1385350.9045998533, "y_max":5492409.7626567865},
{"codistat":"040018", "nome_comune":"LONGIANO", "x_min":1370327.3746764706, "y_min":5473631.329108188, "x_max":1377416.6980901062, "y_max":5482600.2532341685},
{"codistat":"036023", "nome_comune":"MODENA", "x_min":1200255.267052618, "y_min":5552960.660607197, "x_max":1225822.3143063458, "y_max":5578525.855406235},
{"codistat":"037002", "nome_comune":"ARGELATO", "x_min":1256601.8418394988, "y_min":5555526.261580945, "x_max":1267780.6389050651, "y_max":5570445.18612168},
{"codistat":"034026", "nome_comune":"PALANZANO", "x_min":1127697.995795733, "y_min":5524547.482745954, "x_max":1146965.8399658455, "y_max":5541879.80925996},
{"codistat":"038029", "nome_comune":"RIVA DEL PO", "x_min":1304997.3440261048, "y_min":5604747.771968546, "x_max":1348515.4063490937, "y_max":5619457.253948162},
{"codistat":"036046", "nome_comune":"VIGNOLA", "x_min":1219025.4794680746, "y_min":5536602.378530481, "x_max":1228922.0545985487, "y_max":5544816.276151687},
{"codistat":"036020", "nome_comune":"MARANO SUL PANARO", "x_min":1208979.019114132, "y_min":5525265.646099927, "x_max":1223297.6465939265, "y_max":5540332.755610823},
{"codistat":"037026", "nome_comune":"FONTANELICE", "x_min":1279415.97191385, "y_min":5499061.8481372185, "x_max":1291449.9696949043, "y_max":5511291.520520479},
{"codistat":"035011", "nome_comune":"CARPINETI", "x_min":1163965.5172739236, "y_min":5528153.4041389795, "x_max":1180478.7539100049, "y_max":5543682.593351471},
{"codistat":"036031", "nome_comune":"PIEVEPELAGO", "x_min":1169992.3223918083, "y_min":5483126.756734855, "x_max":1183603.2740170928, "y_max":5502927.692627121},
{"codistat":"099021", "nome_comune":"CASTELDELCI", "x_min":1346477.5443799205, "y_min":5423872.602159456, "x_max":1358071.5044257764, "y_max":5439769.646697611},
{"codistat":"036002", "nome_comune":"BOMPORTO", "x_min":1222848.7245216472, "y_min":5572032.009870425, "x_max":1237535.0722528591, "y_max":5591178.0076656435},
{"codistat":"035002", "nome_comune":"BAGNOLO IN PIANO", "x_min":1185536.589932612, "y_min":5582207.672559788, "x_max":1194805.9541034242, "y_max":5593163.68208678},
{"codistat":"099003", "nome_comune":"CORIANO", "x_min":1392155.8613079176, "y_min":5455992.283510996, "x_max":1407485.059478346, "y_max":5464936.255643723},
{"codistat":"037034", "nome_comune":"LOIANO", "x_min":1255522.041469015, "y_min":5501939.143513603, "x_max":1266144.7842563593, "y_max":5516823.262141023},
{"codistat":"034051", "nome_comune":"SORBOLO MEZZANI", "x_min":1155913.590696427, "y_min":5593116.026310356, "x_max":1169061.5408613894, "y_max":5615312.017825099},
{"codistat":"034033", "nome_comune":"SAN SECONDO PARMENSE", "x_min":1130364.5069040582, "y_min":5604156.744798245, "x_max":1142106.8097330702, "y_max":5617057.78448177},
{"codistat":"033013", "nome_comune":"CASTEL SAN GIOVANNI", "x_min":1042900.5929186144, "y_min":5624423.584234276, "x_max":1056246.3590223305, "y_max":5637467.632846416},
{"codistat":"034014", "nome_comune":"FIDENZA", "x_min":1111362.9435345607, "y_min":5585643.289966171, "x_max":1125396.7425238653, "y_max":5611920.544100048},
{"codistat":"034001", "nome_comune":"ALBARETO", "x_min":1071007.23776697, "y_min":5521678.619811519, "x_max":1086871.4052904544, "y_max":5545208.929247159},
{"codistat":"037038", "nome_comune":"MINERBIO", "x_min":1272318.55822615, "y_min":5556444.284476223, "x_max":1288587.2726056245, "y_max":5566438.143596538},
{"codistat":"033039", "nome_comune":"ROTTOFRENO", "x_min":1060630.0186169157, "y_min":5625689.084239302, "x_max":1072382.1368569077, "y_max":5641124.721882462},
{"codistat":"039017", "nome_comune":"SANT'AGATA SUL SANTERNO", "x_min":1317860.823367954, "y_min":5531470.216356499, "x_max":1322952.4395675894, "y_max":5538483.093831171},
{"codistat":"036034", "nome_comune":"RAVARINO", "x_min":1229185.0574882824, "y_min":5576008.952216156, "x_max":1238981.576412683, "y_max":5587391.382969573},
{"codistat":"034038", "nome_comune":"TERENZO", "x_min":1110767.3170081237, "y_min":5552896.205848296, "x_max":1132532.979705683, "y_max":5567085.406206365},
{"codistat":"033003", "nome_comune":"BESENZONE", "x_min":1105257.1429899705, "y_min":5611426.085038181, "x_max":1116698.8322037347, "y_max":5621699.114429203},
{"codistat":"035037", "nome_comune":"SAN MARTINO IN RIO", "x_min":1195604.61470744, "y_min":5571422.87916889, "x_max":1204655.1849125256, "y_max":5581422.453708298},
{"codistat":"038011", "nome_comune":"LAGOSANTO", "x_min":1346747.3472274097, "y_min":5579665.461562182, "x_max":1355974.6973369224, "y_max":5591638.356742013},
{"codistat":"036044", "nome_comune":"SOLIERA", "x_min":1212056.2961383187, "y_min":5575152.625376083, "x_max":1224152.7392000174, "y_max":5589145.335085314},
{"codistat":"036042", "nome_comune":"SERRAMAZZONI", "x_min":1195508.8387138706, "y_min":5523947.017665608, "x_max":1211809.5462006717, "y_max":5542286.970267823},
{"codistat":"099016", "nome_comune":"SAN CLEMENTE", "x_min":1402494.3746055365, "y_min":5450544.795592929, "x_max":1411442.031533169, "y_max":5459009.026519294},
{"codistat":"033033", "nome_comune":"PIANELLO VAL TIDONE", "x_min":1041523.7192440133, "y_min":5602550.155856565, "x_max":1053045.4980992973, "y_max":5617955.162120528},
{"codistat":"035029", "nome_comune":"POVIGLIO", "x_min":1165002.400525796, "y_min":5592749.416563432, "x_max":1178228.4606113683, "y_max":5603053.707075235},
{"codistat":"035017", "nome_comune":"CAVRIAGO", "x_min":1168478.8621629463, "y_min":5570360.433713392, "x_max":1176052.0604549597, "y_max":5578401.370742187},
{"codistat":"037008", "nome_comune":"BUDRIO", "x_min":1275623.6401430753, "y_min":5540364.0907787895, "x_max":1294731.5164780864, "y_max":5565998.201183358},
{"codistat":"034039", "nome_comune":"TIZZANO VAL PARMA", "x_min":1127046.7204181757, "y_min":5537337.763184716, "x_max":1144023.554435762, "y_max":5553114.482681333},
{"codistat":"035044", "nome_comune":"VIANO", "x_min":1173039.4741502986, "y_min":5543146.915532289, "x_max":1187667.1166070239, "y_max":5557567.393743273},
{"codistat":"036043", "nome_comune":"SESTOLA", "x_min":1191170.6255464246, "y_min":5495014.35066937, "x_max":1210489.9272374786, "y_max":5511552.991817133},
{"codistat":"034010", "nome_comune":"COLORNO", "x_min":1148941.1014296596, "y_min":5605519.910579019, "x_max":1161063.7567318182, "y_max":5618821.007817567},
{"codistat":"039011", "nome_comune":"FUSIGNANO", "x_min":1327500.2977441272, "y_min":5535743.736110273, "x_max":1341178.130139339, "y_max":5544316.005018534},
{"codistat":"037050", "nome_comune":"SALA BOLOGNESE", "x_min":1249407.3772690182, "y_min":5554978.622997172, "x_max":1260478.013509115, "y_max":5571834.138311809},
{"codistat":"040045", "nome_comune":"SAVIGNANO SUL RUBICONE", "x_min":1376159.0900326099, "y_min":5475239.334201743, "x_max":1385396.36817369, "y_max":5491772.344520679},
{"codistat":"036025", "nome_comune":"MONTEFIORINO", "x_min":1171783.116524407, "y_min":5511295.711047328, "x_max":1185486.9233909019, "y_max":5524733.431754346},
{"codistat":"037006", "nome_comune":"BOLOGNA", "x_min":1250075.7678147769, "y_min":5530842.130049581, "x_max":1272788.6762547821, "y_max":5551913.895632596},
{"codistat":"034041", "nome_comune":"TORRILE", "x_min":1145465.6983624974, "y_min":5601086.854424937, "x_max":1158935.2565958016, "y_max":5613296.492288935},
{"codistat":"034009", "nome_comune":"COLLECCHIO", "x_min":1126675.405208972, "y_min":5572848.010528867, "x_max":1145131.0741413767, "y_max":5590926.72760977},
{"codistat":"033001", "nome_comune":"AGAZZANO", "x_min":1052559.1014563295, "y_min":5610184.039751048, "x_max":1062939.2316124628, "y_max":5623251.715789573},
{"codistat":"039016", "nome_comune":"RUSSI", "x_min":1334568.2775653123, "y_min":5516357.195322683, "x_max":1347591.292246663, "y_max":5529412.489881162},
{"codistat":"039001", "nome_comune":"ALFONSINE", "x_min":1322941.4724988323, "y_min":5542052.948776751, "x_max":1348654.192990264, "y_max":5558776.828247938},
{"codistat":"037056", "nome_comune":"SANT'AGATA BOLOGNESE", "x_min":1233191.5472415653, "y_min":5563225.0391911315, "x_max":1244916.5698246788, "y_max":5574781.316831381},
{"codistat":"033002", "nome_comune":"ALSENO", "x_min":1100843.3332695996, "y_min":5595782.538459088, "x_max":1114597.4278435926, "y_max":5614055.111891599},
{"codistat":"037045", "nome_comune":"MORDANO", "x_min":1308586.7408118316, "y_min":5524843.371896209, "x_max":1318256.0958815701, "y_max":5533233.673038489},
{"codistat":"040020", "nome_comune":"MERCATO SARACENO", "x_min":1344250.7948539318, "y_min":5451378.4891738, "x_max":1365931.3210099302, "y_max":5473581.00429189},
{"codistat":"033007", "nome_comune":"CADEO", "x_min":1091900.3999781345, "y_min":5611017.039961669, "x_max":1102084.400485901, "y_max":5624131.387885224},
{"codistat":"037059", "nome_comune":"VERGATO", "x_min":1228022.9478028035, "y_min":5500759.525526032, "x_max":1242428.8514016606, "y_max":5518628.2660245355},
{"codistat":"039014", "nome_comune":"RAVENNA", "x_min":1338986.429149854, "y_min":5498485.21656734, "x_max":1374518.5746449362, "y_max":5563171.4912869185},
{"codistat":"040005", "nome_comune":"CASTROCARO TERME E TERRA DEL SOLE", "x_min":1323425.2349305195, "y_min":5485635.043427601, "x_max":1334243.812372822, "y_max":5498099.345133685},
{"codistat":"034016", "nome_comune":"FONTEVIVO", "x_min":1130825.505869292, "y_min":5593636.167521708, "x_max":1140618.2225337797, "y_max":5601304.632318433},
{"codistat":"034024", "nome_comune":"NEVIANO DEGLI ARDUINI", "x_min":1138810.1422506645, "y_min":5538502.044947736, "x_max":1158105.0073727495, "y_max":5559386.501277125},
{"codistat":"037013", "nome_comune":"CASTEL D'AIANO", "x_min":1218831.59481507, "y_min":5503617.962537173, "x_max":1234211.9684504424, "y_max":5515619.80776309},
{"codistat":"037051", "nome_comune":"SAN BENEDETTO VAL DI SAMBRO", "x_min":1244806.4403016989, "y_min":5488688.329169173, "x_max":1258160.1408705022, "y_max":5504545.765570649},
{"codistat":"039007", "nome_comune":"CERVIA", "x_min":1361215.0957825151, "y_min":5494983.830670014, "x_max":1378574.3517717146, "y_max":5513283.5665158965},
{"codistat":"038006", "nome_comune":"COMACCHIO", "x_min":1331192.8625251548, "y_min":5550857.646273062, "x_max":1367732.4696757514, "y_max":5593356.720353435},
{"codistat":"033011", "nome_comune":"CARPANETO PIACENTINO", "x_min":1083374.18560832, "y_min":5594913.353887098, "x_max":1096614.5506456462, "y_max":5615432.779848951},
{"codistat":"033004", "nome_comune":"BETTOLA", "x_min":1057101.2188182708, "y_min":5577103.45984741, "x_max":1078069.90830318, "y_max":5596134.871919684},
{"codistat":"036010", "nome_comune":"CONCORDIA SULLA SECCHIA", "x_min":1218441.4384466289, "y_min":5602542.652708873, "x_max":1231602.2226600267, "y_max":5614446.638294449},
{"codistat":"037037", "nome_comune":"MEDICINA", "x_min":1283642.8064628919, "y_min":5534511.599918571, "x_max":1310807.2261953815, "y_max":5556333.619022883},
{"codistat":"099005", "nome_comune":"MISANO ADRIATICO", "x_min":1406411.3503980092, "y_min":5455110.588973024, "x_max":1416267.803351171, "y_max":5463496.194760334},
{"codistat":"036019", "nome_comune":"MARANELLO", "x_min":1204509.6443804805, "y_min":5536757.026694146, "x_max":1214883.5498410896, "y_max":5550540.183039745},
{"codistat":"040033", "nome_comune":"PREMILCUORE", "x_min":1300539.3545435208, "y_min":5449810.428170903, "x_max":1321389.9422153994, "y_max":5471215.0754267555},
{"codistat":"034004", "nome_comune":"BERCETO", "x_min":1100514.2500915292, "y_min":5537421.631308114, "x_max":1121178.0358068733, "y_max":5559717.226586573},
{"codistat":"035020", "nome_comune":"CORREGGIO", "x_min":1191373.9718274393, "y_min":5573648.346189683, "x_max":1206920.6467781214, "y_max":5592666.578271142},
{"codistat":"037032", "nome_comune":"IMOLA", "x_min":1289525.248814224, "y_min":5509322.316261759, "x_max":1314663.9407628688, "y_max":5553853.323516052},
{"codistat":"099024", "nome_comune":"PENNABILLI", "x_min":1357413.9115996065, "y_min":5425744.249587283, "x_max":1374585.733331077, "y_max":5444835.831576563},
{"codistat":"040041", "nome_comune":"SAN MAURO PASCOLI", "x_min":1380969.5999659884, "y_min":5478846.706155498, "x_max":1386788.3092506053, "y_max":5491309.500910685},
{"codistat":"037021", "nome_comune":"CASTENASO", "x_min":1270963.7052132068, "y_min":5539625.04219749, "x_max":1281956.3943834521, "y_max":5550457.218182787},
{"codistat":"037031", "nome_comune":"GRIZZANA MORANDI", "x_min":1227309.9537649802, "y_min":5496302.978660766, "x_max":1246392.1264256, "y_max":5514097.403253156},
{"codistat":"099014", "nome_comune":"RIMINI", "x_min":1384597.1002951795, "y_min":5460689.346991332, "x_max":1406233.326427677, "y_max":5483351.288841037},
{"codistat":"033027", "nome_comune":"MONTICELLI D'ONGINA", "x_min":1099277.0773759335, "y_min":5627499.321806289, "x_max":1112123.2153106527, "y_max":5643447.577087289},
{"codistat":"033014", "nome_comune":"CASTELVETRO PIACENTINO", "x_min":1107722.5136350943, "y_min":5629840.674452572, "x_max":1117683.6257876041, "y_max":5642689.258614936},
{"codistat":"036041", "nome_comune":"SAVIGNANO SUL PANARO", "x_min":1218140.9818175652, "y_min":5533682.061313691, "x_max":1231791.1533215684, "y_max":5547546.02482664},
{"codistat":"036040", "nome_comune":"SASSUOLO", "x_min":1193473.3005251482, "y_min":5541072.323248838, "x_max":1203915.6180323872, "y_max":5559856.119887887},
{"codistat":"040001", "nome_comune":"BAGNO DI ROMAGNA", "x_min":1312286.1767977385, "y_min":5432566.663024891, "x_max":1348289.013519429, "y_max":5457834.602672971},
{"codistat":"033018", "nome_comune":"CORTEMAGGIORE", "x_min":1094627.2248630552, "y_min":5615024.587795984, "x_max":1112935.5893971827, "y_max":5626715.479513997},
{"codistat":"035043", "nome_comune":"VEZZANO SUL CROSTOLO", "x_min":1165567.328242083, "y_min":5548649.679414179, "x_max":1176838.794155197, "y_max":5560927.393442787},
{"codistat":"038005", "nome_comune":"CODIGORO", "x_min":1336419.369212052, "y_min":5587213.102983875, "x_max":1366851.3269832144, "y_max":5610739.91955849},
{"codistat":"035041", "nome_comune":"TOANO", "x_min":1165611.503431862, "y_min":5518627.394637223, "x_max":1182708.9568112816, "y_max":5530706.147426578},
{"codistat":"099027", "nome_comune":"TALAMELLO", "x_min":1363933.8643029565, "y_min":5449096.832806317, "x_max":1370299.6484350853, "y_max":5454796.079266081},
{"codistat":"099026", "nome_comune":"SANT'AGATA FELTRIA", "x_min":1351191.861094621, "y_min":5434940.052170688, "x_max":1365174.2293422983, "y_max":5454002.768777771},
{"codistat":"033046", "nome_comune":"VILLANOVA SULL'ARDA", "x_min":1109490.3449608712, "y_min":5618984.012506634, "x_max":1122400.586475951, "y_max":5631632.490287072},
{"codistat":"039018", "nome_comune":"SOLAROLO", "x_min":1312868.676638316, "y_min":5515793.972007074, "x_max":1322190.5476638798, "y_max":5525312.342540169},
{"codistat":"034042", "nome_comune":"TRAVERSETOLO", "x_min":1148905.185378279, "y_min":5556547.761813714, "x_max":1159616.6525855702, "y_max":5571982.743670616},
{"codistat":"037046", "nome_comune":"OZZANO DELL'EMILIA", "x_min":1269288.264970941, "y_min":5521011.143129372, "x_max":1285893.5645424325, "y_max":5542408.616402901},
{"codistat":"040031", "nome_comune":"PORTICO E SAN BENEDETTO", "x_min":1296321.346876733, "y_min":5458218.825795793, "x_max":1313375.800564421, "y_max":5473667.055980907},
{"codistat":"034005", "nome_comune":"BORE", "x_min":1086527.5501516673, "y_min":5570571.807232805, "x_max":1100217.2695398598, "y_max":5584367.855813138},
{"codistat":"035022", "nome_comune":"GATTATICO", "x_min":1160224.2099229428, "y_min":5581835.571469773, "x_max":1173132.2850689748, "y_max":5595688.88147322},
{"codistat":"033019", "nome_comune":"FARINI", "x_min":1053257.2724723953, "y_min":5563439.148999117, "x_max":1077111.5082704742, "y_max":5583538.493442084},
{"codistat":"037042", "nome_comune":"MONTE SAN PIETRO", "x_min":1234358.5074707675, "y_min":5519461.603779038, "x_max":1246852.8647087647, "y_max":5544582.48387134},
{"codistat":"099015", "nome_comune":"SALUDECIO", "x_min":1404371.7449004678, "y_min":5440208.293128717, "x_max":1417531.6579871045, "y_max":5452527.847783012},
{"codistat":"037028", "nome_comune":"GALLIERA", "x_min":1263463.4260700091, "y_min":5577922.483627483, "x_max":1282214.9952229653, "y_max":5586735.095755311},
{"codistat":"037005", "nome_comune":"BENTIVOGLIO", "x_min":1265547.7843587142, "y_min":5556149.804138471, "x_max":1278628.2480736873, "y_max":5572410.981730509},
{"codistat":"038030", "nome_comune":"TRESIGNANA", "x_min":1316855.710321505, "y_min":5586458.675774212, "x_max":1330805.6478223389, "y_max":5600940.8761902535},
{"codistat":"039005", "nome_comune":"CASOLA VALSENIO", "x_min":1282957.2119623295, "y_min":5489045.426195472, "x_max":1302052.8993120682, "y_max":5505468.28074535},
{"codistat":"037001", "nome_comune":"ANZOLA DELL'EMILIA", "x_min":1238671.8285862438, "y_min":5546745.928291283, "x_max":1250838.77622812, "y_max":5561352.597418215},
{"codistat":"036004", "nome_comune":"CAMPOSANTO", "x_min":1234177.3194614023, "y_min":5585581.576811116, "x_max":1249218.0687918484, "y_max":5594255.185770563},
{"codistat":"037017", "nome_comune":"CASTELLO D'ARGILE", "x_min":1252024.4765688342, "y_min":5563512.015406293, "x_max":1264373.2598728293, "y_max":5576385.015073538},
{"codistat":"035001", "nome_comune":"ALBINEA", "x_min":1175959.8039277447, "y_min":5553997.798513361, "x_max":1186953.5268776412, "y_max":5566019.088609258},
{"codistat":"099011", "nome_comune":"MORCIANO DI ROMAGNA", "x_min":1404685.320394477, "y_min":5449720.775897602, "x_max":1411545.0043040817, "y_max":5454590.156015055},
{"codistat":"033022", "nome_comune":"GAZZOLA", "x_min":1056827.4387098958, "y_min":5603084.467559725, "x_max":1068469.9371716266, "y_max":5619630.371821704},
{"codistat":"035045", "nome_comune":"VILLA MINOZZO", "x_min":1150614.519734186, "y_min":5500400.73707996, "x_max":1171871.7164380043, "y_max":5528468.805954054},
{"codistat":"036014", "nome_comune":"FIUMALBO", "x_min":1180060.523832413, "y_min":5483762.90791227, "x_max":1192477.1232083205, "y_max":5496861.377469686},
{"codistat":"037040", "nome_comune":"MONGHIDORO", "x_min":1254612.9200792625, "y_min":5491841.019747486, "x_max":1267842.8515825116, "y_max":5505113.232947367},
{"codistat":"036018", "nome_comune":"LAMA MOCOGNO", "x_min":1183941.0659850703, "y_min":5503310.553789167, "x_max":1200266.0749023347, "y_max":5522326.824619435},
{"codistat":"037047", "nome_comune":"PIANORO", "x_min":1255250.4078558153, "y_min":5513206.3216242315, "x_max":1272080.972371256, "y_max":5534851.469254441},
{"codistat":"040015", "nome_comune":"GAMBETTOLA", "x_min":1371703.788151436, "y_min":5481569.535193813, "x_max":1377106.8996372677, "y_max":5486037.65323795},
{"codistat":"036027", "nome_comune":"NONANTOLA", "x_min":1223451.559778317, "y_min":5565399.678679707, "x_max":1237545.3191952948, "y_max":5578753.4025021205},
{"codistat":"037036", "nome_comune":"MARZABOTTO", "x_min":1238281.4397618414, "y_min":5509142.443778868, "x_max":1255943.7124767571, "y_max":5525427.088849707},
{"codistat":"037044", "nome_comune":"MONZUNO", "x_min":1245261.146052142, "y_min":5500943.566112326, "x_max":1260180.3055191503, "y_max":5519530.87780713},
{"codistat":"033034", "nome_comune":"PIOZZANO", "x_min":1047684.7785767718, "y_min":5599046.888286455, "x_max":1058851.557718111, "y_max":5615374.1489194045},
{"codistat":"038012", "nome_comune":"MASI TORELLO", "x_min":1308269.6776994427, "y_min":5582686.747556364, "x_max":1317362.361410062, "y_max":5591943.372365968},
{"codistat":"033024", "nome_comune":"GRAGNANO TREBBIENSE", "x_min":1058626.5777741014, "y_min":5618188.065023866, "x_max":1070398.1109995833, "y_max":5628324.639653557},
{"codistat":"036047", "nome_comune":"ZOCCA", "x_min":1216077.8170620026, "y_min":5511477.891296085, "x_max":1230021.04702491, "y_max":5532268.8785414},
{"codistat":"034036", "nome_comune":"SORAGNA", "x_min":1121434.5808252753, "y_min":5603278.631793696, "x_max":1135883.5116697464, "y_max":5619208.582337149},
{"codistat":"037012", "nome_comune":"CASALFIUMANESE", "x_min":1272446.8451988434, "y_min":5499648.7209374765, "x_max":1295789.9347096432, "y_max":5521209.191177723},
{"codistat":"038017", "nome_comune":"OSTELLATO", "x_min":1315892.6129638785, "y_min":5569249.960202133, "x_max":1349404.155977246, "y_max":5588405.544012049},
{"codistat":"035033", "nome_comune":"REGGIO NELL'EMILIA", "x_min":1167858.6659404142, "y_min":5562564.838219685, "x_max":1199288.6607077816, "y_max":5586088.605412654},
{"codistat":"035034", "nome_comune":"RIO SALICETO", "x_min":1197926.4197537294, "y_min":5589463.438849967, "x_max":1207464.8507470258, "y_max":5599828.791157204},
{"codistat":"036030", "nome_comune":"PAVULLO NEL FRIGNANO", "x_min":1197627.633496475, "y_min":5506833.165070471, "x_max":1216842.9127983616, "y_max":5528812.075801486},
{"codistat":"036013", "nome_comune":"FIORANO MODENESE", "x_min":1201016.6864472607, "y_min":5541737.045096322, "x_max":1209592.7816853116, "y_max":5553843.886968752},
{"codistat":"040013", "nome_comune":"FORLIMPOPOLI", "x_min":1345571.3334874136, "y_min":5489846.307288937, "x_max":1354765.1721089217, "y_max":5499107.846430531},
{"codistat":"035038", "nome_comune":"SAN POLO D'ENZA", "x_min":1157994.2830664571, "y_min":5554778.895804052, "x_max":1167409.7436036952, "y_max":5570653.006041692},
{"codistat":"039002", "nome_comune":"BAGNACAVALLO", "x_min":1329048.449136857, "y_min":5524036.96572444, "x_max":1344916.084347516, "y_max":5542671.371534893},
{"codistat":"039015", "nome_comune":"RIOLO TERME", "x_min":1294554.2522348708, "y_min":5503116.621311927, "x_max":1309830.6467523442, "y_max":5514613.08841131},
{"codistat":"033048", "nome_comune":"ZIANO PIACENTINO", "x_min":1039136.9913741742, "y_min":5614398.705665838, "x_max":1049267.0103425947, "y_max":5625786.1043123845},
{"codistat":"033042", "nome_comune":"SARMATO", "x_min":1053033.521668909, "y_min":5626558.300728636, "x_max":1061352.4696310677, "y_max":5637733.76663198},
{"codistat":"037057", "nome_comune":"SASSO MARCONI", "x_min":1242232.8813517343, "y_min":5517411.197789449, "x_max":1261610.1818164224, "y_max":5537112.874944808},
{"codistat":"099018", "nome_comune":"SANTARCANGELO DI ROMAGNA", "x_min":1375819.8907714712, "y_min":5467151.555322502, "x_max":1391459.6297899294, "y_max":5479173.560289119},
{"codistat":"035036", "nome_comune":"RUBIERA", "x_min":1197384.7876681667, "y_min":5563293.6436188845, "x_max":1204638.3162730823, "y_max":5575280.604243686},
{"codistat":"036015", "nome_comune":"FORMIGINE", "x_min":1200458.9551743348, "y_min":5549058.073430005, "x_max":1215837.62228436, "y_max":5563226.340692904},
{"codistat":"035013", "nome_comune":"CASINA", "x_min":1159286.3641360893, "y_min":5540565.52720112, "x_max":1176112.4186740352, "y_max":5554677.587253692},
{"codistat":"099008", "nome_comune":"MONTEFIORE CONCA", "x_min":1401420.6236251406, "y_min":5441522.970469859, "x_max":1408642.0791266267, "y_max":5451863.040273709},
{"codistat":"036011", "nome_comune":"FANANO", "x_min":1191163.49956613, "y_min":5483322.814907772, "x_max":1209021.4799539852, "y_max":5504347.069445569},
{"codistat":"036028", "nome_comune":"NOVI DI MODENA", "x_min":1210754.4765524692, "y_min":5589834.743778287, "x_max":1221332.2890482384, "y_max":5610165.605136534},
{"codistat":"040007", "nome_comune":"CESENA", "x_min":1346351.600586385, "y_min":5468585.932727422, "x_max":1376153.9173605554, "y_max":5501601.78598529},
{"codistat":"039004", "nome_comune":"BRISIGHELLA", "x_min":1289550.514843956, "y_min":5480782.830252611, "x_max":1327871.3853946396, "y_max":5508543.400151803},
{"codistat":"099022", "nome_comune":"MAIOLO", "x_min":1366616.5270562803, "y_min":5441574.167247692, "x_max":1375100.890621214, "y_max":5452525.0226257155},
{"codistat":"036007", "nome_comune":"CASTELNUOVO RANGONE", "x_min":1211066.071244766, "y_min":5548398.669470848, "x_max":1221634.3808539084, "y_max":5557121.740035739},
{"codistat":"036005", "nome_comune":"CARPI", "x_min":1203919.4346527301, "y_min":5576514.529483898, "x_max":1225411.355355566, "y_max":5604267.479844657},
{"codistat":"037060", "nome_comune":"ZOLA PREDOSA", "x_min":1242865.8031502257, "y_min":5536415.183052251, "x_max":1253119.6667959502, "y_max":5548272.784019456},
{"codistat":"035014", "nome_comune":"CASTELLARANO", "x_min":1185948.777243273, "y_min":5538183.317456447, "x_max":1198349.6563943273, "y_max":5554215.903669797},
{"codistat":"034022", "nome_comune":"MONCHIO DELLE CORTI", "x_min":1119154.457618065, "y_min":5519143.4703301685, "x_max":1132909.5900353738, "y_max":5535919.379918743},
{"codistat":"040009", "nome_comune":"CIVITELLA DI ROMAGNA", "x_min":1326888.603750117, "y_min":5456732.176352683, "x_max":1346967.7727609526, "y_max":5478253.104034751},
{"codistat":"040019", "nome_comune":"MELDOLA", "x_min":1335430.4708183268, "y_min":5470728.262662226, "x_max":1350862.4539100465, "y_max":5488905.691361793},
{"codistat":"037033", "nome_comune":"LIZZANO IN BELVEDERE", "x_min":1202654.8408860993, "y_min":5480596.468191387, "x_max":1217442.7600947528, "y_max":5501429.024940781},
{"codistat":"036003", "nome_comune":"CAMPOGALLIANO", "x_min":1202958.3101141013, "y_min":5567765.534717058, "x_max":1211780.7885024454, "y_max":5581573.8798084995},
{"codistat":"036035", "nome_comune":"RIOLUNATO", "x_min":1178238.9477712829, "y_min":5495451.871748218, "x_max":1192654.6070543511, "y_max":5508062.166727908},
{"codistat":"038001", "nome_comune":"ARGENTA", "x_min":1292934.4072029858, "y_min":5550281.420251548, "x_max":1353155.8715930986, "y_max":5578828.988565106},
{"codistat":"037009", "nome_comune":"CALDERARA DI RENO", "x_min":1248463.7114980752, "y_min":5547683.232055723, "x_max":1260454.94320318, "y_max":5560134.14313807},
{"codistat":"033040", "nome_comune":"SAN GIORGIO PIACENTINO", "x_min":1078619.093465986, "y_min":5600796.313882392, "x_max":1089922.1083219934, "y_max":5618118.9358869735},
{"codistat":"033016", "nome_comune":"COLI", "x_min":1046074.5012496542, "y_min":5573248.354154358, "x_max":1059363.0895984054, "y_max":5593690.675279797},
{"codistat":"040014", "nome_comune":"GALEATA", "x_min":1319078.9070391073, "y_min":5454601.384058973, "x_max":1335222.7971024076, "y_max":5474371.883084038},
{"codistat":"037003", "nome_comune":"BARICELLA", "x_min":1280112.438228924, "y_min":5564202.018468356, "x_max":1294920.0352736907, "y_max":5576238.146433132},
{"codistat":"035016", "nome_comune":"CASTELNOVO NE'MONTI", "x_min":1149669.8971885385, "y_min":5525081.912584203, "x_max":1167191.5186564338, "y_max":5547493.327483833},
{"codistat":"034044", "nome_comune":"VALMOZZOLA", "x_min":1090928.755807224, "y_min":5547655.823341562, "x_max":1107325.5239819705, "y_max":5562676.50975352},
{"codistat":"035006", "nome_comune":"BRESCELLO", "x_min":1163417.763237275, "y_min":5595169.000259002, "x_max":1172855.7347593128, "y_max":5609224.580082794},
{"codistat":"033045", "nome_comune":"VIGOLZONE", "x_min":1065081.7269409504, "y_min":5595021.274708099, "x_max":1081430.7970266342, "y_max":5613351.524602569},
{"codistat":"035004", "nome_comune":"BIBBIANO", "x_min":1161699.1024525221, "y_min":5564382.50702441, "x_max":1171156.664665649, "y_max":5578876.6043013},
{"codistat":"034027", "nome_comune":"PARMA", "x_min":1137106.6109048834, "y_min":5568519.453315384, "x_max":1162581.8613339956, "y_max":5605918.886567224},
{"codistat":"036012", "nome_comune":"FINALE EMILIA", "x_min":1243887.8240321316, "y_min":5589248.391790542, "x_max":1265579.6130279812, "y_max":5606671.177744257},
{"codistat":"034019", "nome_comune":"LESIGNANO DE'BAGNI", "x_min":1139788.0307052943, "y_min":5553368.275817903, "x_max":1151527.5181314372, "y_max":5569919.583777211},
{"codistat":"035023", "nome_comune":"GUALTIERI", "x_min":1177549.92803683, "y_min":5595817.554939166, "x_max":1185467.4766750587, "y_max":5609455.905409758},
{"codistat":"039012", "nome_comune":"LUGO", "x_min":1317613.5903284072, "y_min":5526541.741327532, "x_max":1334379.2996929295, "y_max":5552397.443363978},
{"codistat":"039006", "nome_comune":"CASTEL BOLOGNESE", "x_min":1306434.4009052871, "y_min":5509831.746041961, "x_max":1318964.0458575294, "y_max":5522063.622105324},
{"codistat":"034006", "nome_comune":"BORGO VAL DI TARO", "x_min":1079509.9464566612, "y_min":5528668.290112114, "x_max":1103206.371146477, "y_max":5553465.477507608},
{"codistat":"038004", "nome_comune":"CENTO", "x_min":1251901.1381960756, "y_min":5575284.825680125, "x_max":1267601.7699868972, "y_max":5596121.860832577},
{"codistat":"035026", "nome_comune":"LUZZARA", "x_min":1185425.0486553223, "y_min":5609253.108874647, "x_max":1198991.4603441306, "y_max":5620271.712837692},
{"codistat":"037054", "nome_comune":"SAN LAZZARO DI SAVENA", "x_min":1264394.119781638, "y_min":5528453.757408494, "x_max":1278638.6051273795, "y_max":5541697.913044003},
{"codistat":"035035", "nome_comune":"ROLO", "x_min":1206785.8582178277, "y_min":5600304.427741991, "x_max":1213200.369319862, "y_max":5609243.311104222},
{"codistat":"037053", "nome_comune":"SAN GIOVANNI IN PERSICETO", "x_min":1237682.515610935, "y_min":5553859.954477229, "x_max":1255179.1302823152, "y_max":5583559.317324447},
{"codistat":"033005", "nome_comune":"BOBBIO", "x_min":1033399.1032707082, "y_min":5578253.8121264465, "x_max":1055420.2748429512, "y_max":5599107.873363771},
{"codistat":"034007", "nome_comune":"BUSSETO", "x_min":1111781.5931722082, "y_min":5603895.780208546, "x_max":1129445.5112254855, "y_max":5623337.243382969},
{"codistat":"039003", "nome_comune":"BAGNARA DI ROMAGNA", "x_min":1314621.4980051222, "y_min":5523655.899563708, "x_max":1320380.4510020155, "y_max":5529719.148701617},
{"codistat":"033012", "nome_comune":"CASTELL'ARQUATO", "x_min":1092686.4015577184, "y_min":5593407.484119435, "x_max":1104768.173821108, "y_max":5607258.413307864},
{"codistat":"040004", "nome_comune":"BORGHI", "x_min":1370748.8502576535, "y_min":5463184.654644833, "x_max":1379899.2874478162, "y_max":5473917.007735023},
{"codistat":"099023", "nome_comune":"NOVAFELTRIA", "x_min":1358344.2629862046, "y_min":5440831.803767997, "x_max":1375503.6147543935, "y_max":5459664.537670631},
{"codistat":"036017", "nome_comune":"GUIGLIA", "x_min":1214826.793490359, "y_min":5520048.658807943, "x_max":1225103.219398998, "y_max":5534404.2263482595},
{"codistat":"037052", "nome_comune":"SAN GIORGIO DI PIANO", "x_min":1262886.4083310578, "y_min":5560262.995527261, "x_max":1271216.2130010896, "y_max":5574753.374781249},
{"codistat":"036026", "nome_comune":"MONTESE", "x_min":1208519.956590165, "y_min":5497290.544537779, "x_max":1225251.9429498876, "y_max":5516007.830332372},
{"codistat":"040037", "nome_comune":"RONCOFREDDO", "x_min":1357534.2414466718, "y_min":5466796.378164804, "x_max":1375649.172426031, "y_max":5479120.146124941},
{"codistat":"033030", "nome_comune":"OTTONE", "x_min":1023958.8238346776, "y_min":5555125.803229741, "x_max":1047040.6425536573, "y_max":5570238.233987795},
{"codistat":"040008", "nome_comune":"CESENATICO", "x_min":1372881.6427201908, "y_min":5485441.936596583, "x_max":1384519.1837640344, "y_max":5500340.139870438},
{"codistat":"034017", "nome_comune":"FORNOVO DI TARO", "x_min":1115429.909827565, "y_min":5562075.693151702, "x_max":1133995.7529828013, "y_max":5576505.018699443},
{"codistat":"034002", "nome_comune":"BARDI", "x_min":1063120.8400739096, "y_min":5550072.880103721, "x_max":1094658.0987013285, "y_max":5572432.075735714},
{"codistat":"038018", "nome_comune":"POGGIO RENATICO", "x_min":1268812.1318146943, "y_min":5575547.878896426, "x_max":1290535.887490245, "y_max":5593352.8104121685},
{"codistat":"035028", "nome_comune":"NOVELLARA", "x_min":1185845.4113144397, "y_min":5588934.012692534, "x_max":1199836.9057924403, "y_max":5605386.750972306},
{"codistat":"039013", "nome_comune":"MASSA LOMBARDA", "x_min":1307981.985732409, "y_min":5530303.049478839, "x_max":1320787.8219108405, "y_max":5544761.189751068},
{"codistat":"039008", "nome_comune":"CONSELICE", "x_min":1311210.6860713235, "y_min":5538259.859586662, "x_max":1326455.1063325338, "y_max":5555526.701592154},
{"codistat":"034025", "nome_comune":"NOCETO", "x_min":1117486.3299309693, "y_min":5583347.932565645, "x_max":1138182.8299557902, "y_max":5598656.064555785},
{"codistat":"033015", "nome_comune":"CERIGNALE", "x_min":1035132.7703152014, "y_min":5561382.454508225, "x_max":1047111.1129620156, "y_max":5573356.819423017},
{"codistat":"036016", "nome_comune":"FRASSINORO", "x_min":1165555.1406492565, "y_min":5494383.840900439, "x_max":1180485.4138335784, "y_max":5519090.595574564},
{"codistat":"038023", "nome_comune":"VOGHIERA", "x_min":1301793.928820938, "y_min":5576836.460360257, "x_max":1312495.438036925, "y_max":5590875.185196668},
{"codistat":"034008", "nome_comune":"CALESTANO", "x_min":1118190.911990933, "y_min":5549567.376912089, "x_max":1136718.448705703, "y_max":5565732.3724757265},
{"codistat":"035032", "nome_comune":"REGGIOLO", "x_min":1193760.316573571, "y_min":5602901.556714538, "x_max":1210829.939097006, "y_max":5612724.720113368},
{"codistat":"037022", "nome_comune":"CASTIGLIONE DEI PEPOLI", "x_min":1238706.8763046064, "y_min":5480461.3733660495, "x_max":1253877.286475123, "y_max":5502009.153641974},
{"codistat":"034018", "nome_comune":"LANGHIRANO", "x_min":1131775.8580085523, "y_min":5551656.967020978, "x_max":1147563.1886135554, "y_max":5573053.478213078},
{"codistat":"040022", "nome_comune":"MODIGLIANA", "x_min":1304153.7454262949, "y_min":5478215.043115346, "x_max":1323460.7362191647, "y_max":5496440.760983244},
{"codistat":"035042", "nome_comune":"VETTO", "x_min":1145103.2042584675, "y_min":5531870.136391843, "x_max":1160113.8905413062, "y_max":5547697.343673711},
{"codistat":"037061", "nome_comune":"VALSAMOGGIA", "x_min":1223420.9185960933, "y_min":5513787.597674894, "x_max":1244932.412358571, "y_max":5553672.3753686575},
{"codistat":"038027", "nome_comune":"FISCAGLIA", "x_min":1323484.9317671566, "y_min":5581668.712019825, "x_max":1348463.668240676, "y_max":5595827.870738359},
{"codistat":"099028", "nome_comune":"POGGIO TORRIANA", "x_min":1371562.8130309328, "y_min":5457564.762511854, "x_max":1383522.7811844714, "y_max":5474064.37868926},
{"codistat":"034049", "nome_comune":"SISSA TRECASALI", "x_min":1138814.4102751815, "y_min":5601938.237757287, "x_max":1152843.7627054765, "y_max":5622147.196062926},
{"codistat":"035046", "nome_comune":"VENTASSO", "x_min":1129047.758569682, "y_min":5504106.018698706, "x_max":1159974.3928843932, "y_max":5536898.169294378},
{"codistat":"099029", "nome_comune":"MONTESCUDO - MONTE COLOMBO", "x_min":1390651.565054533, "y_min":5449685.831579814, "x_max":1403637.0423999643, "y_max":5458022.899843306},
{"codistat":"034050", "nome_comune":"POLESINE ZIBELLO", "x_min":1117484.3110224619, "y_min":5618554.590108684, "x_max":1133440.0226865693, "y_max":5628497.029427628},
{"codistat":"037062", "nome_comune":"ALTO RENO TERME", "x_min":1210993.9826668322, "y_min":5475063.235559409, "x_max":1225353.213075252, "y_max":5494168.657501945},
{"codistat":"038028", "nome_comune":"TERRE DEL RENO", "x_min":1261182.724687342, "y_min":5583562.097773713, "x_max":1278821.167255589, "y_max":5596515.124971347},

{"codistat":"033", "nome_comune":"PIACENZA", "x_min":1008893, "y_min":5548324, "x_max":1125670, "y_max":5650175},
{"codistat":"034", "nome_comune":"PARMA", "x_min":1035233, "y_min":5512033, "x_max":1176303, "y_max":5634371},
{"codistat":"035", "nome_comune":"REGGIO EMILIA", "x_min":1114256, "y_min":5497399, "x_max":1216399, "y_max":5624127},
{"codistat":"036", "nome_comune":"MODENA", "x_min":1155815, "y_min":5477497, "x_max":1268788, "y_max":5624127},
{"codistat":"037", "nome_comune":"BOLOGNA", "x_min":1191814, "y_min":5471644, "x_max":1321469, "y_max":5593982},
{"codistat":"038", "nome_comune":"FERRARA", "x_min":1237472, "y_min":5548910, "x_max":1383224, "y_max":5623542},
{"codistat":"039", "nome_comune":"RAVENNA", "x_min":1272885, "y_min":5477497, "x_max":1385565, "y_max":5569690},
{"codistat":"O40", "nome_comune":"FORLI'-CESENA", "x_min":1283422, "y_min":5420718, "x_max":1393760, "y_max":5522569},
{"codistat":"099", "nome_comune":"RIMINI", "x_min":1341079, "y_min":5419547, "x_max":1426247, "y_max":5497106}
]
