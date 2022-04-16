package com.example.shoppingcar.controller;


import com.example.shoppingcar.entity.CartItemDto;
import com.example.shoppingcar.entity.Goods;
import com.example.shoppingcar.util.RedisUtils;
import com.example.shoppingcar.vo.Result;
import com.example.shoppingcar.vo.ResultReturn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Map;


@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private Goods goods;

    @Autowired
    private RedisUtils redisUtils;

    // 增加
    // 选用设备添加到购物车
    @ApiOperation(value = "选用设备添加到购物车")
    @PostMapping("/addEquipmentToCart")
    @ResponseBody
    public ResultReturn addEquipmentToCart(@RequestBody CartItemDto cartItemDto){
        boolean hsetSuccessStatus = redisUtils.hset(cartItemDto.getUserId().toString(), cartItemDto.getGoodsId().toString(), cartItemDto);
        System.out.println(cartItemDto);
        return Result.success("1000","添加购物车成功","");
    }

    // 查取用户对应redis中全部数据
    // 从购物车缓存中取数据
    @ApiOperation(value = "从购物车缓存中取数据")
    @GetMapping("/getEquipmentInCartByUserId")
    @ResponseBody
    public void getEquipmentInCartByUserId(@RequestParam String userId){
        // 创建一个CartItemDto的空对象 ，目的是用来接从redis取到的数据
        CartItemDto cartItemDto;
        // 从redis中根据用户Id获取到购物车里的数据
        Map<Object, Object> userCartItems = redisUtils.hgetall(userId.toString());
        // 创建一个数组将所有的Vo对象都接出来返回到前端
        ArrayList<Goods> cartItemVos = new ArrayList<>();
        //遍历map中的值 每一个value都是一个CarItemDto对象
        for (Object value : userCartItems.values()) {

            System.out.println(value);

        }

    }

    // 修改
    // 设备添加到购物车
    @ApiOperation(value = "修改购物车数据")
    @PostMapping("/updateEquipmentToCart")
    @ResponseBody
    public ResultReturn updateEquipmentToCart(@RequestBody CartItemDto cartItemDto){
        /* 修改的操作和增加的操作是一样的
         *  由于我们目前存放购物车数据的方式是 hset userId:传入的userId 设备Id 购物车项Dto对象
         *  我们对应redis中的东西来看就是    hset key:xx field value
         *  我们重新hset一个相同key的相同field的值 ， 那么它的value会变 也就是覆盖掉了
         * */
        redisUtils.hset(cartItemDto.getUserId().toString(),cartItemDto.getGoodsId().toString(),cartItemDto);
        System.out.println(cartItemDto);
        return Result.success("1001","修改成功","");
    }

    // 删除
    // 选用设备从购物车删除
    @ApiOperation(value = "选用设备从购物车删除")
    @GetMapping("/del/{userId}/{goodsId}")
    @ResponseBody
    public ResultReturn DeleteEquipmentFromCart(@PathVariable String userId , @PathVariable String goodsId){
        redisUtils.hdel(userId.toString(),goodsId.toString());
        return Result.success("1002","删除商品成功","");
    }
}
