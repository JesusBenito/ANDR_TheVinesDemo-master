package com.vlim.deimos;

public class Config {
    static int VERSION_DB = 2;
    static String TAG = "";
    private static final String HOST = "http://54.183.159.116:8182/"; /* VLIM server */
    private static final String HOST_PUE = "http://201.139.97.155:8080/"; /* Country server */

    static int INTERVALO_ACTUALIZACION_BUFFER = 3000;   // 1 seg
    static int INTERVALO_MIN_ACTUALIZACION_BUFFER = 2000;


    // Servicios
    public static final String LOGIN_URL = HOST + "";
    public static final String VALIDA_CODIGO_QR = HOST + "";


    // FTP
    public static final String FTP_USER = "";
    public static final String FTP_PASS = "";
    public static final String FTP_URL = "";
    public static final String FTP_CARPETA = "";
    public static final String EMAIL ="";
    public static final String PASSWORD ="";
}
