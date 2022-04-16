package com.example.shoppingcar.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class CartItemDto{
    private static final long serialVersionUID = 1L;
    // 添加购物车的用户的id
    private Long userId;
    //用户选择购买的商品id
    private Long goodsId;
    //用户添加商品到购物车的时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addGoodsTime;
    //用户购买的商品数量
    private Integer goodsNum;
}

