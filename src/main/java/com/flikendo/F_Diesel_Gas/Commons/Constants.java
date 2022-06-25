/**
 * Date: 03-17-2022
 * Author: Flikendo
 * <p>
 * Constants class which contains all constants variables
 */
package com.flikendo.F_Diesel_Gas.Commons;

import java.util.regex.Pattern;

public class Constants {
    /**
     * //////////
     * // URLs //
     * //////////
     */
    public final static String DEFAULT_URL = "https://www.dieselogasolina.com/";
    public final static String SEARCH_URL = "https://www.dieselogasolina.com/Buscador/Busqueda";
    public final static String TERUEL_URL = "https://www.dieselogasolina.com/gasolineras-en-teruel.html";
    public final static String ALCANIZ_URL = "https://www.dieselogasolina.com/gasolineras-en-teruel-localidad-alcaniz.html";

    /**
     * /////////////////////////////
     * // Comments of Exceptions  //
     * /////////////////////////////
     */
    public final static String EXCEPTION_NO_INFO = "No info about fuel stations exists";

    /**
     * ////////////////////////
     * // Regular Expessions //
     * ////////////////////////
     */
    // gasolineras.push({id:7191,lat:'41.043972',lon:'-0.130056',direccion:'AVENIDAMAESTRAZGO,4',margen:'I',
    // localidad:'ALCAñIZ',provincia:'TERUEL',horario:'L-D:07:00-22:45',empresa:'CEPSA',tipo_venta:'P',
    // fecha_actualizacion:'1651442400',precio:'1.899',logo:'cepsa',precios:'{\"1\":{\"combustible_corto\":\"SP95\",

    // \"precio\":1.899,\"fecha\":1651442400}'});
    private final static String REG_FULL_EXP = "gasolineras\\.push.*";
    private final static String REG_EXP_END = "\\}'\\}\\);";

    // "id:[0-9]*,"
    private final static String REG_EXP_ID = "id:";
    public final static Pattern  REG_EXP_PATTERN_ID = Pattern.compile("[0-9]+");

    // "lat:'[-]*[0-9.]*',"
    private final static String REG_EXP_LAT = "lat:'";
    public final static Pattern REG_EXP_PATTERN_LAT = Pattern.compile("[-]*[0-9.]+");

    // "lon:'[-]*[0-9.]*',"
    private final static String REG_EXP_LONG = "lon:'";
    public final static Pattern REG_EXP_PATTER_LON =  Pattern.compile("[-]*[0-9.]+");

    // "direccion:'[a-zA-Z.,\\/0-9ñÑáéíóúÁÉÍÓÚ-]+',"
    private final static String REG_EXP_ADDR = "direccion:'";
    public final static Pattern REG_EXP_PATTERN_ADDR = Pattern.compile("[a-zA-Z.,\\/0-9ñÑáéíóúÁÉÍÓÚ-]+");

    // "margen:'[0-9a-zA-Z]*',"
    private final static String REG_EXP_MARG = "margen:'";
    public final static Pattern REG_EXP_PATTERN_MARG = Pattern.compile("[0-9a-zA-Z]+");

    // "localidad:'.*',"
    private final static String REG_EXP_LOC = "localidad:'";
    public final static Pattern REG_EXP_PATTERN_LOC = Pattern.compile("[.A-Z]+");

    // "provincia:'[a-zA-Z]+',"
    private final static String REG_EXP_PROV = "provincia:'";
    public final static Pattern REG_EXP_PATTERN_PROV = Pattern.compile("[a-zA-Z]+");

    // "horario:'L-D:([[0-9]{2}:[0-9]{2}-[0-9]{2}:[0-9]{2}]*|[0-9H]+)',"
    private final static String REG_EXP_TIME = "horario:'";
    public final static Pattern REG_EXP_PATTERN_TIME = Pattern.compile("L-D:([[0-9]{2}:[0-9]{2}-[0-9]{2}:[0-9]{2}]*|[0-9H]+)");

    // "empresa:'[a-zA-Z0-9]+',"
    private final static String REG_EXP_COMP = "empresa:'";
    public final static Pattern REG_EXP_PATTERN_COMP = Pattern.compile("[a-zA-Z0-9]+");

    // "tipo_venta:'([P]|[R])',"
    private final static String REG_EXP_KIND_SALE = "tipo_venta:'";
    public final static Pattern REG_EXP_PATTERN_KIND_SALE = Pattern.compile("([P]|[R])");

    // "fecha_actualizacion:'[0-9]{10}',"
    private final static String REG_EXP_UPD_DATE = "fecha_actualizacion:'";
    public final static Pattern REG_EXP_PATTERN_UPD_DATE = Pattern.compile("[0-9]+");

    // "precio:'[0-9.]*[0-9]*',"
    private final static String REG_EXP_PRICE = "precio:'";
    public final static Pattern REG_EXP_PATTERN_PRICE = Pattern.compile("[0-9.]+");

    // "logo:'[a-zA-Z]*',"
    private final static String REG_EXP_LOGO = "logo:'";
    public final static Pattern REG_EXP_PATTER_LOGO = Pattern.compile("[a-zA-Z]+");

    private final static String REG_EXP_START_PRICES = "precios:'\\{";

    // "\"[0-9]*\":\\{\"combustible_corto\":\"(SP95|SP98|GA|GA+|GB|GLP)\","
//    public final static Pattern REG_EXP_PATTERN_FUEL = Pattern.compile("\"combustible_corto\":\"(SP95|SP98|GA|GA\\+|GB|GLP)\",");
    public final static String REG_EXP_FUEL = "combustible_corto\":\"";
    public final static String REG_EXP_PATTERN_FUEL = "(SP95|SP98|GA|GA\\+|GB|GLP)";

    // "\"precio\":[0-9.]S*[0-9]{3},"
//    private final static Pattern REG_EXP_PATTERN_PRICES = Pattern.compile("[0-9\\.]+");
    private final static String REG_EXP_PRICES = "\"precio\":";
    public final static String REG_EXP_PATTERN_PRICES = "[0-9\\.]+";

    public final static Pattern FULL_INFO = Pattern.compile(REG_FULL_EXP + REG_EXP_END);
    public final static Pattern PRICES = Pattern.compile(REG_EXP_FUEL + REG_EXP_PATTERN_FUEL + "\"," + REG_EXP_PRICES + REG_EXP_PATTERN_PRICES);

}
