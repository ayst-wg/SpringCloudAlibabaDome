package com.wanggang.alibaba.contorller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wanggang.alibaba.handler.CustomerBlockHandler;
import com.wanggang.alibaba.result.CommonResult;
import com.wanggang.alibaba.result.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : SentinelContorller
 * @Description : SentinelContorller
 * @Author : wanggang
 * @Date: 2020-10-08 19:00
 * @Version 1.0
 **/
@RestController
@Slf4j
public class SentinelContorller {

    @GetMapping(value = "/sentinel/testA")
    public CommonResult testA() {
        return new CommonResult("sentinelA", StatusCode.SUCCESS);
    }

    @GetMapping(value = "/sentinel/testB")
    public CommonResult testB() {
        return new CommonResult("sentinelB", StatusCode.SUCCESS);
    }

    @GetMapping("/hotkey/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "testHotKey_block")
    public CommonResult testHotKey(@RequestParam(value = "p1", required = false) String p1,
                                   @RequestParam(value = "p2", required = false) String p2) {
        return new CommonResult("testHotKey SUCCESS!", StatusCode.SUCCESS);
    }

    // HotKey回调处理方法
    public CommonResult testHotKey_block(String p1, String p2, BlockException exception) {
        return new CommonResult("testHotKey_block FAIL!", StatusCode.FAIL); // sentinel 默认提示：Blocked by sentinel (flow limiting)
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException1")
    public CommonResult customerBlockHandler() {
        return new CommonResult("customerBlockHandler 测试成功！",StatusCode.SUCCESS);
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return  new CommonResult(StatusCode.SUCCESS,"按照byUrl限流测试");
    }

}
