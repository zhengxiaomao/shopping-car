package com.example.shoppingcar.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Data
public class Goods {

    //商品id
    private Integer goodsId;
    //商品价格
    private BigDecimal goodsPrice;
    //商品图片
    private String picUrl;
    //商品描述信息
    private String goodsDescrption;


}
