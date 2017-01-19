package com.example.admin.machintestdemo;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by Admin on 1/3/2017.
 */

public interface Api {

    @FormUrlEncoded
    @POST("/Product/GetProductList")
    public void getProducts(@Field("SellerCode") String SellerCode,
                            @Field("CustomerMobileNumber") String CustomerMobileNumber,
                            @Field("ProductName") String ProductName,
                            Callback<String> callback);


    @GET("/Product/GetBusinessCategoryList")
    public void getAllCategory(Callback<String> response);
}
