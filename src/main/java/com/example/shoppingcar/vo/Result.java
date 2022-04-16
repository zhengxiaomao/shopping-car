package com.example.shoppingcar.vo;

public class Result {

    public static ResultReturn success(String code, String msg,Object data){
        return new ResultReturn(code,msg,data);
    }
}
