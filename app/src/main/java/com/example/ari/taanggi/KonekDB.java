package com.example.ari.taanggi;

/**
 * Created by user on 1/26/2017.
 */

public class KonekDB {
    public static final String URL_REG_GURU = "http://pstiubl.com/saida/reg_guru.php";



        //Keys that will be used to send the request to php scripts
        public static final String KEY_NBM = "nbm_nis";
        public static final String KEY_NAMA = "nama";
        public static final String KEY_Kelamin = "jenkel";
        public static final String KEY_Email = "email";

    public static final String KEY_EMP_NPM = "Id_StafAdmin";
    public static final String KEY_EMP_USER = "Username";
    public static final String KEY_EMP_MAIL = "Email";
    public static final String KEY_EMP_PASS = "Password";


    //JSON Tags
    public static final String TAG_JSON_ARRAYTANGIBLEP="result_tangibleP";
    public static final String TAG_IDTANGIBLEP = "Id_TangiblePPrimary";
    public static final String TAG_TANYATANGIBLEP= "Pertanyaan_TangibleP";
    public static final String TAG_JAWABTANGIBLEP= "Jawaban_TangibleP";
    public static final String TAG_PRODI_P1="Program StudiP";
    public static final String TAG_TA_P1="Tahun AjaranP";
    public static final String TAG_NPM_P1="Id_mhsP";

    //employee id to pass with intent
    public static final String OSM_IDTANGIBLE = "tg_id";


}