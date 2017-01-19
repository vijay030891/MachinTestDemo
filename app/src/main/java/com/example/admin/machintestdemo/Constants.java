package com.example.admin.machintestdemo;

import android.os.Environment;

/**
 * Created by Admin on 1/19/2017.
 */

public class Constants {


//    http://www.saviraj.com/GrowciaWebApi/api/Product/GetBusinessCategoryList
    public static final int DATABASE_VERSION = 1;
    public static final String DATABSE_NAME = "eMessnager.db";
    public static final String DATABSE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/eMessanger/";
    public static final String ROOT_PATH = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static final String TABLE_USER_DETAILS = "USER_DETAILS";

    /* ================== Table details ======================= */

    public static final String TABLE_PRODUCT_DETAILS = "PRODUCT_DETAILS";

    public static final String COLUMN_PRODUCT_ID = "PRODUCT_ID";
    public static final String COLUMN_PRODUCT_NAME = "PRODUCT_NAME";
    public static final String COLUMN_PRODUCT_PRICE = "PRODUCT_PRICE";
    public static final String COLUMN_PRODUCT_QUANTITY = "PRODUCT_QUANTITY";

}
