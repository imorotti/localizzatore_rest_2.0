/**
 * NormalizzatoreBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Aug 08, 2005 (11:49:10 PDT) WSDL2Java emitter.
 */

package e_SOAPDispenser.Normalizzatore;

public class NormalizzatoreBindingStub extends org.apache.axis.client.Stub implements e_SOAPDispenser.Normalizzatore.NormalizzatoreSoapPort {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[17];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetHandle");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "GetHandleSoapInElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">GetHandleSoapInElement"), e_SOAPDispenser.Normalizzatore.GetHandleSoapInElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">GetHandleSoapOutElement"));
        oper.setReturnClass(e_SOAPDispenser.Normalizzatore.GetHandleSoapOutElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "GetHandleSoapOutElement"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Get_Civ_geom");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Civ_geomSoapInElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Get_Civ_geomSoapInElement"), e_SOAPDispenser.Normalizzatore.Get_Civ_geomSoapInElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Get_Civ_geomSoapOutElement"));
        oper.setReturnClass(e_SOAPDispenser.Normalizzatore.Get_Civ_geomSoapOutElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Civ_geomSoapOutElement"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Get_Tipo_Coord");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Tipo_CoordSoapInElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Get_Tipo_CoordSoapInElement"), e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordSoapInElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Get_Tipo_CoordSoapOutElement"));
        oper.setReturnClass(e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordSoapOutElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Tipo_CoordSoapOutElement"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Norm_Edificio");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_EdificioSoapInElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_EdificioSoapInElement"), e_SOAPDispenser.Normalizzatore.Norm_EdificioSoapInElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_EdificioSoapOutElement"));
        oper.setReturnClass(e_SOAPDispenser.Normalizzatore.Norm_EdificioSoapOutElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_EdificioSoapOutElement"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Norm_Provincia");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_ProvinciaSoapInElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_ProvinciaSoapInElement"), e_SOAPDispenser.Normalizzatore.Norm_ProvinciaSoapInElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_ProvinciaSoapOutElement"));
        oper.setReturnClass(e_SOAPDispenser.Normalizzatore.Norm_ProvinciaSoapOutElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_ProvinciaSoapOutElement"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Norm_Indirizzo1");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo1SoapInElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Indirizzo1SoapInElement"), e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1SoapInElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Indirizzo1SoapOutElement"));
        oper.setReturnClass(e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1SoapOutElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo1SoapOutElement"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Norm_Indirizzo2");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo2SoapInElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Indirizzo2SoapInElement"), e_SOAPDispenser.Normalizzatore.Norm_Indirizzo2SoapInElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Indirizzo2SoapOutElement"));
        oper.setReturnClass(e_SOAPDispenser.Normalizzatore.Norm_Indirizzo2SoapOutElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo2SoapOutElement"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Get_Str_Geom");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Str_GeomSoapInElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Get_Str_GeomSoapInElement"), e_SOAPDispenser.Normalizzatore.Get_Str_GeomSoapInElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Get_Str_GeomSoapOutElement"));
        oper.setReturnClass(e_SOAPDispenser.Normalizzatore.Get_Str_GeomSoapOutElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Str_GeomSoapOutElement"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Info_Entita_Stradario");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Info_Entita_StradarioSoapInElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Info_Entita_StradarioSoapInElement"), e_SOAPDispenser.Normalizzatore.Info_Entita_StradarioSoapInElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Info_Entita_StradarioSoapOutElement"));
        oper.setReturnClass(e_SOAPDispenser.Normalizzatore.Info_Entita_StradarioSoapOutElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Info_Entita_StradarioSoapOutElement"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Norm_Comune2");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Comune2SoapInElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Comune2SoapInElement"), e_SOAPDispenser.Normalizzatore.Norm_Comune2SoapInElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Comune2SoapOutElement"));
        oper.setReturnClass(e_SOAPDispenser.Normalizzatore.Norm_Comune2SoapOutElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Comune2SoapOutElement"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Norm_Incrocio");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IncrocioSoapInElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_IncrocioSoapInElement"), e_SOAPDispenser.Normalizzatore.Norm_IncrocioSoapInElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_IncrocioSoapOutElement"));
        oper.setReturnClass(e_SOAPDispenser.Normalizzatore.Norm_IncrocioSoapOutElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IncrocioSoapOutElement"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Norm_Luoghi_Notevoli");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Luoghi_NotevoliSoapInElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Luoghi_NotevoliSoapInElement"), e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliSoapInElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Luoghi_NotevoliSoapOutElement"));
        oper.setReturnClass(e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliSoapOutElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Luoghi_NotevoliSoapOutElement"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Norm_Stradario");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_StradarioSoapInElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_StradarioSoapInElement"), e_SOAPDispenser.Normalizzatore.Norm_StradarioSoapInElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_StradarioSoapOutElement"));
        oper.setReturnClass(e_SOAPDispenser.Normalizzatore.Norm_StradarioSoapOutElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_StradarioSoapOutElement"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Norm_Indirizzo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IndirizzoSoapInElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_IndirizzoSoapInElement"), e_SOAPDispenser.Normalizzatore.Norm_IndirizzoSoapInElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_IndirizzoSoapOutElement"));
        oper.setReturnClass(e_SOAPDispenser.Normalizzatore.Norm_IndirizzoSoapOutElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IndirizzoSoapOutElement"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Norm_Indirizzo_multi");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_multiSoapInElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Indirizzo_multiSoapInElement"), e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiSoapInElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Indirizzo_multiSoapOutElement"));
        oper.setReturnClass(e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiSoapOutElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_multiSoapOutElement"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Norm_Comune1");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Comune1SoapInElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Comune1SoapInElement"), e_SOAPDispenser.Normalizzatore.Norm_Comune1SoapInElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Comune1SoapOutElement"));
        oper.setReturnClass(e_SOAPDispenser.Normalizzatore.Norm_Comune1SoapOutElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Comune1SoapOutElement"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Norm_Indirizzo_Unico");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_UnicoSoapInElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Indirizzo_UnicoSoapInElement"), e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoSoapInElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Indirizzo_UnicoSoapOutElement"));
        oper.setReturnClass(e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoSoapOutElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_UnicoSoapOutElement"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[16] = oper;

    }

    public NormalizzatoreBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public NormalizzatoreBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public NormalizzatoreBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
        addBindings0();
        addBindings1();
    }

    private void addBindings0() {
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Get_Civ_geomSoapInElement");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Get_Civ_geomSoapInElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Get_Civ_geomSoapOutElement");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Get_Civ_geomSoapOutElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Get_Str_GeomSoapInElement");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Get_Str_GeomSoapInElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Get_Str_GeomSoapOutElement");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Get_Str_GeomSoapOutElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Get_Tipo_CoordSoapInElement");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordSoapInElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Get_Tipo_CoordSoapOutElement");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordSoapOutElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">GetHandleSoapInElement");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.GetHandleSoapInElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">GetHandleSoapOutElement");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.GetHandleSoapOutElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Info_Entita_StradarioSoapInElement");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Info_Entita_StradarioSoapInElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Info_Entita_StradarioSoapOutElement");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Info_Entita_StradarioSoapOutElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Comune1SoapInElement");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Comune1SoapInElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Comune1SoapOutElement");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Comune1SoapOutElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Comune2SoapInElement");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Comune2SoapInElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Comune2SoapOutElement");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Comune2SoapOutElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_EdificioSoapInElement");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_EdificioSoapInElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_EdificioSoapOutElement");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_EdificioSoapOutElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_IncrocioSoapInElement");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_IncrocioSoapInElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_IncrocioSoapOutElement");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_IncrocioSoapOutElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Indirizzo1SoapInElement");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1SoapInElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Indirizzo1SoapOutElement");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1SoapOutElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Indirizzo2SoapInElement");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Indirizzo2SoapInElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Indirizzo2SoapOutElement");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Indirizzo2SoapOutElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Indirizzo_multiSoapInElement");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiSoapInElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Indirizzo_multiSoapOutElement");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiSoapOutElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Indirizzo_UnicoSoapInElement");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoSoapInElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Indirizzo_UnicoSoapOutElement");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoSoapOutElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_IndirizzoSoapInElement");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_IndirizzoSoapInElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_IndirizzoSoapOutElement");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_IndirizzoSoapOutElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Luoghi_NotevoliSoapInElement");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliSoapInElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_Luoghi_NotevoliSoapOutElement");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliSoapOutElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_ProvinciaSoapInElement");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_ProvinciaSoapInElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_ProvinciaSoapOutElement");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_ProvinciaSoapOutElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_StradarioSoapInElement");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_StradarioSoapInElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", ">Norm_StradarioSoapOutElement");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_StradarioSoapOutElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Civ_geomInput");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Get_Civ_geomInput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Civ_geomInputParams");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Get_Civ_geomInputParams.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Civ_geomOutput");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Get_Civ_geomOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Civ_geomOutputParams");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Get_Civ_geomOutputParams.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Str_GeomInput");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Get_Str_GeomInput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Str_GeomInputParams");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Get_Str_GeomInputParams.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Str_GeomOutput");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Get_Str_GeomOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Str_GeomOutputParams");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Get_Str_GeomOutputParams.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Tipo_CoordInput");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordInput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Tipo_CoordInputParams");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordInputParams.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Tipo_CoordOutput");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Tipo_CoordOutputParams");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordOutputParams.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Tipo_CoordOutputRecordset");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordOutputRecordset.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Get_Tipo_CoordOutputRecordsetArray");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordOutputRecordsetArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "GetHandleInput");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.GetHandleInput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "GetHandleInputParams");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.GetHandleInputParams.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "GetHandleOutput");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.GetHandleOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "GetHandleOutputParams");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.GetHandleOutputParams.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Info_Entita_StradarioInput");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Info_Entita_StradarioInput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Info_Entita_StradarioInputParams");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Info_Entita_StradarioInputParams.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Info_Entita_StradarioOutput");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Info_Entita_StradarioOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Info_Entita_StradarioOutputParams");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Info_Entita_StradarioOutputParams.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Info_Entita_StradarioOutputRecordset");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Info_Entita_StradarioOutputRecordset.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Info_Entita_StradarioOutputRecordsetArray");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Info_Entita_StradarioOutputRecordsetArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "InputFilter");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.InputFilter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Comune1Input");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Comune1Input.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Comune1InputParams");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Comune1InputParams.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Comune1Output");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Comune1Output.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Comune1OutputParams");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Comune1OutputParams.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Comune1OutputRecordset");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Comune1OutputRecordset.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Comune1OutputRecordsetArray");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Comune1OutputRecordsetArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Comune2Input");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Comune2Input.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Comune2InputParams");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Comune2InputParams.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Comune2Output");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Comune2Output.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Comune2OutputParams");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Comune2OutputParams.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Comune2OutputRecordset");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Comune2OutputRecordset.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Comune2OutputRecordsetArray");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Comune2OutputRecordsetArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_EdificioInput");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_EdificioInput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_EdificioInputParams");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_EdificioInputParams.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_EdificioOutput");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_EdificioOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_EdificioOutputParams");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_EdificioOutputParams.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_EdificioOutputRecordset");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_EdificioOutputRecordset.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_EdificioOutputRecordsetArray");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_EdificioOutputRecordsetArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IncrocioInput");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_IncrocioInput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IncrocioInputParams");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_IncrocioInputParams.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IncrocioOutput");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_IncrocioOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IncrocioOutputParams");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_IncrocioOutputParams.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IncrocioOutputRecordset");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_IncrocioOutputRecordset.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IncrocioOutputRecordsetArray");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_IncrocioOutputRecordsetArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo1Input");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1Input.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo1InputParams");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1InputParams.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo1Output");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1Output.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo1OutputParams");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1OutputParams.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo1OutputRecordset");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1OutputRecordset.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo1OutputRecordsetArray");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1OutputRecordsetArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo2Input");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Indirizzo2Input.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo2InputParams");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Indirizzo2InputParams.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo2Output");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Indirizzo2Output.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo2OutputParams");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Indirizzo2OutputParams.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo2OutputRecordset");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Indirizzo2OutputRecordset.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo2OutputRecordsetArray");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Indirizzo2OutputRecordsetArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_multiInput");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiInput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_multiInputParams");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiInputParams.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_multiOutput");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_multiOutputParams");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiOutputParams.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_multiOutputRecordset");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiOutputRecordset.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }
    private void addBindings1() {
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_multiOutputRecordsetArray");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiOutputRecordsetArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_UnicoInput");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoInput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_UnicoInputParams");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoInputParams.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_UnicoOutput");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_UnicoOutputParams");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoOutputParams.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_UnicoOutputRecordset");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoOutputRecordset.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Indirizzo_UnicoOutputRecordsetArray");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoOutputRecordsetArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IndirizzoInput");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_IndirizzoInput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IndirizzoInputParams");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_IndirizzoInputParams.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IndirizzoOutput");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_IndirizzoOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IndirizzoOutputParams");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_IndirizzoOutputParams.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IndirizzoOutputRecordset");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_IndirizzoOutputRecordset.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_IndirizzoOutputRecordsetArray");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_IndirizzoOutputRecordsetArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Luoghi_NotevoliInput");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliInput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Luoghi_NotevoliInputParams");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliInputParams.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Luoghi_NotevoliOutput");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Luoghi_NotevoliOutputParams");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliOutputParams.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Luoghi_NotevoliOutputRecordset");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliOutputRecordset.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_Luoghi_NotevoliOutputRecordsetArray");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliOutputRecordsetArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_ProvinciaInput");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_ProvinciaInput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_ProvinciaInputParams");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_ProvinciaInputParams.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_ProvinciaOutput");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_ProvinciaOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_ProvinciaOutputParams");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_ProvinciaOutputParams.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_ProvinciaOutputRecordset");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_ProvinciaOutputRecordset.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_ProvinciaOutputRecordsetArray");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_ProvinciaOutputRecordsetArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_StradarioInput");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_StradarioInput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_StradarioInputParams");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_StradarioInputParams.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_StradarioOutput");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_StradarioOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_StradarioOutputParams");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_StradarioOutputParams.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_StradarioOutputRecordset");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_StradarioOutputRecordset.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "Norm_StradarioOutputRecordsetArray");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.Norm_StradarioOutputRecordsetArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://e-SOAPDispenser/Normalizzatore", "OutputInfo");
            cachedSerQNames.add(qName);
            cls = e_SOAPDispenser.Normalizzatore.OutputInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public e_SOAPDispenser.Normalizzatore.GetHandleSoapOutElement getHandle(e_SOAPDispenser.Normalizzatore.GetHandleSoapInElement parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://localhost:8080/normalizzatore/eGeoCoding?serviceType=DBServices&serviceName=Normalizzatore&message=GetHandle");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetHandle"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (e_SOAPDispenser.Normalizzatore.GetHandleSoapOutElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (e_SOAPDispenser.Normalizzatore.GetHandleSoapOutElement) org.apache.axis.utils.JavaUtils.convert(_resp, e_SOAPDispenser.Normalizzatore.GetHandleSoapOutElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public e_SOAPDispenser.Normalizzatore.Get_Civ_geomSoapOutElement get_Civ_geom(e_SOAPDispenser.Normalizzatore.Get_Civ_geomSoapInElement parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://localhost:8080/normalizzatore/eGeoCoding?serviceType=DBServices&serviceName=Normalizzatore&message=Get_Civ_geom");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "Get_Civ_geom"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (e_SOAPDispenser.Normalizzatore.Get_Civ_geomSoapOutElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (e_SOAPDispenser.Normalizzatore.Get_Civ_geomSoapOutElement) org.apache.axis.utils.JavaUtils.convert(_resp, e_SOAPDispenser.Normalizzatore.Get_Civ_geomSoapOutElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordSoapOutElement get_Tipo_Coord(e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordSoapInElement parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://localhost:8080/normalizzatore/eGeoCoding?serviceType=DBServices&serviceName=Normalizzatore&message=Get_Tipo_Coord");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "Get_Tipo_Coord"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordSoapOutElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordSoapOutElement) org.apache.axis.utils.JavaUtils.convert(_resp, e_SOAPDispenser.Normalizzatore.Get_Tipo_CoordSoapOutElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public e_SOAPDispenser.Normalizzatore.Norm_EdificioSoapOutElement norm_Edificio(e_SOAPDispenser.Normalizzatore.Norm_EdificioSoapInElement parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://localhost:8080/normalizzatore/eGeoCoding?serviceType=DBServices&serviceName=Normalizzatore&message=Norm_Edificio");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "Norm_Edificio"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (e_SOAPDispenser.Normalizzatore.Norm_EdificioSoapOutElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (e_SOAPDispenser.Normalizzatore.Norm_EdificioSoapOutElement) org.apache.axis.utils.JavaUtils.convert(_resp, e_SOAPDispenser.Normalizzatore.Norm_EdificioSoapOutElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public e_SOAPDispenser.Normalizzatore.Norm_ProvinciaSoapOutElement norm_Provincia(e_SOAPDispenser.Normalizzatore.Norm_ProvinciaSoapInElement parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://localhost:8080/normalizzatore/eGeoCoding?serviceType=DBServices&serviceName=Normalizzatore&message=Norm_Provincia");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "Norm_Provincia"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (e_SOAPDispenser.Normalizzatore.Norm_ProvinciaSoapOutElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (e_SOAPDispenser.Normalizzatore.Norm_ProvinciaSoapOutElement) org.apache.axis.utils.JavaUtils.convert(_resp, e_SOAPDispenser.Normalizzatore.Norm_ProvinciaSoapOutElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1SoapOutElement norm_Indirizzo1(e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1SoapInElement parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://localhost:8080/normalizzatore/eGeoCoding?serviceType=DBServices&serviceName=Normalizzatore&message=Norm_Indirizzo1");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "Norm_Indirizzo1"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1SoapOutElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1SoapOutElement) org.apache.axis.utils.JavaUtils.convert(_resp, e_SOAPDispenser.Normalizzatore.Norm_Indirizzo1SoapOutElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public e_SOAPDispenser.Normalizzatore.Norm_Indirizzo2SoapOutElement norm_Indirizzo2(e_SOAPDispenser.Normalizzatore.Norm_Indirizzo2SoapInElement parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://localhost:8080/normalizzatore/eGeoCoding?serviceType=DBServices&serviceName=Normalizzatore&message=Norm_Indirizzo2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "Norm_Indirizzo2"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (e_SOAPDispenser.Normalizzatore.Norm_Indirizzo2SoapOutElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (e_SOAPDispenser.Normalizzatore.Norm_Indirizzo2SoapOutElement) org.apache.axis.utils.JavaUtils.convert(_resp, e_SOAPDispenser.Normalizzatore.Norm_Indirizzo2SoapOutElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public e_SOAPDispenser.Normalizzatore.Get_Str_GeomSoapOutElement get_Str_Geom(e_SOAPDispenser.Normalizzatore.Get_Str_GeomSoapInElement parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://localhost:8080/normalizzatore/eGeoCoding?serviceType=DBServices&serviceName=Normalizzatore&message=Get_Str_Geom");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "Get_Str_Geom"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (e_SOAPDispenser.Normalizzatore.Get_Str_GeomSoapOutElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (e_SOAPDispenser.Normalizzatore.Get_Str_GeomSoapOutElement) org.apache.axis.utils.JavaUtils.convert(_resp, e_SOAPDispenser.Normalizzatore.Get_Str_GeomSoapOutElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public e_SOAPDispenser.Normalizzatore.Info_Entita_StradarioSoapOutElement info_Entita_Stradario(e_SOAPDispenser.Normalizzatore.Info_Entita_StradarioSoapInElement parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://localhost:8080/normalizzatore/eGeoCoding?serviceType=DBServices&serviceName=Normalizzatore&message=Info_Entita_Stradario");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "Info_Entita_Stradario"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (e_SOAPDispenser.Normalizzatore.Info_Entita_StradarioSoapOutElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (e_SOAPDispenser.Normalizzatore.Info_Entita_StradarioSoapOutElement) org.apache.axis.utils.JavaUtils.convert(_resp, e_SOAPDispenser.Normalizzatore.Info_Entita_StradarioSoapOutElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public e_SOAPDispenser.Normalizzatore.Norm_Comune2SoapOutElement norm_Comune2(e_SOAPDispenser.Normalizzatore.Norm_Comune2SoapInElement parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://localhost:8080/normalizzatore/eGeoCoding?serviceType=DBServices&serviceName=Normalizzatore&message=Norm_Comune2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "Norm_Comune2"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (e_SOAPDispenser.Normalizzatore.Norm_Comune2SoapOutElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (e_SOAPDispenser.Normalizzatore.Norm_Comune2SoapOutElement) org.apache.axis.utils.JavaUtils.convert(_resp, e_SOAPDispenser.Normalizzatore.Norm_Comune2SoapOutElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public e_SOAPDispenser.Normalizzatore.Norm_IncrocioSoapOutElement norm_Incrocio(e_SOAPDispenser.Normalizzatore.Norm_IncrocioSoapInElement parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://localhost:8080/normalizzatore/eGeoCoding?serviceType=DBServices&serviceName=Normalizzatore&message=Norm_Incrocio");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "Norm_Incrocio"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (e_SOAPDispenser.Normalizzatore.Norm_IncrocioSoapOutElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (e_SOAPDispenser.Normalizzatore.Norm_IncrocioSoapOutElement) org.apache.axis.utils.JavaUtils.convert(_resp, e_SOAPDispenser.Normalizzatore.Norm_IncrocioSoapOutElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliSoapOutElement norm_Luoghi_Notevoli(e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliSoapInElement parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://localhost:8080/normalizzatore/eGeoCoding?serviceType=DBServices&serviceName=Normalizzatore&message=Norm_Luoghi_Notevoli");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "Norm_Luoghi_Notevoli"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliSoapOutElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliSoapOutElement) org.apache.axis.utils.JavaUtils.convert(_resp, e_SOAPDispenser.Normalizzatore.Norm_Luoghi_NotevoliSoapOutElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public e_SOAPDispenser.Normalizzatore.Norm_StradarioSoapOutElement norm_Stradario(e_SOAPDispenser.Normalizzatore.Norm_StradarioSoapInElement parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://localhost:8080/normalizzatore/eGeoCoding?serviceType=DBServices&serviceName=Normalizzatore&message=Norm_Stradario");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "Norm_Stradario"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (e_SOAPDispenser.Normalizzatore.Norm_StradarioSoapOutElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (e_SOAPDispenser.Normalizzatore.Norm_StradarioSoapOutElement) org.apache.axis.utils.JavaUtils.convert(_resp, e_SOAPDispenser.Normalizzatore.Norm_StradarioSoapOutElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public e_SOAPDispenser.Normalizzatore.Norm_IndirizzoSoapOutElement norm_Indirizzo(e_SOAPDispenser.Normalizzatore.Norm_IndirizzoSoapInElement parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://localhost:8080/normalizzatore/eGeoCoding?serviceType=DBServices&serviceName=Normalizzatore&message=Norm_Indirizzo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "Norm_Indirizzo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (e_SOAPDispenser.Normalizzatore.Norm_IndirizzoSoapOutElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (e_SOAPDispenser.Normalizzatore.Norm_IndirizzoSoapOutElement) org.apache.axis.utils.JavaUtils.convert(_resp, e_SOAPDispenser.Normalizzatore.Norm_IndirizzoSoapOutElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiSoapOutElement norm_Indirizzo_multi(e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiSoapInElement parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://localhost:8080/normalizzatore/eGeoCoding?serviceType=DBServices&serviceName=Normalizzatore&message=Norm_Indirizzo_multi");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "Norm_Indirizzo_multi"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiSoapOutElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiSoapOutElement) org.apache.axis.utils.JavaUtils.convert(_resp, e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_multiSoapOutElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public e_SOAPDispenser.Normalizzatore.Norm_Comune1SoapOutElement norm_Comune1(e_SOAPDispenser.Normalizzatore.Norm_Comune1SoapInElement parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://localhost:8080/normalizzatore/eGeoCoding?serviceType=DBServices&serviceName=Normalizzatore&message=Norm_Comune1");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "Norm_Comune1"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (e_SOAPDispenser.Normalizzatore.Norm_Comune1SoapOutElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (e_SOAPDispenser.Normalizzatore.Norm_Comune1SoapOutElement) org.apache.axis.utils.JavaUtils.convert(_resp, e_SOAPDispenser.Normalizzatore.Norm_Comune1SoapOutElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoSoapOutElement norm_Indirizzo_Unico(e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoSoapInElement parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://localhost:8080/normalizzatore/eGeoCoding?serviceType=DBServices&serviceName=Normalizzatore&message=Norm_Indirizzo_Unico");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "Norm_Indirizzo_Unico"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoSoapOutElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoSoapOutElement) org.apache.axis.utils.JavaUtils.convert(_resp, e_SOAPDispenser.Normalizzatore.Norm_Indirizzo_UnicoSoapOutElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
