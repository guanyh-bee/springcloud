package com.atlmm.springcloud.alibaba.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atlmm.springcloud.entities.CommonResult;

/**
 * @author gyh
 * @create 2020-10-30 16:38
 */
public class  CustomerBlockHandler {
    public static CommonResult handlerException1(BlockException exception){
        return new CommonResult(4444,"客户自定义1");
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(4444,"客户自定义2");
    }
}
