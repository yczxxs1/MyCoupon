package com.stackingrule.coupon.service;

import com.alibaba.fastjson.JSON;
import com.stackingrule.coupon.exception.CouponException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * <h1>构建优惠券模板基础测试</h1>
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TemplateBaseTest {

    @Autowired
    private ITemplateBaseService baseService;

    @Test
    public void testBuildTemplateInfo() throws CouponException {
        System.out.println(JSON.toJSONString(baseService.buildTemplateInfo(1)));
        System.out.println(JSON.toJSONString(baseService.buildTemplateInfo(1000)));

    }

    @Test
    public void testFindAllUsableTemplate() {
        System.out.println(JSON.toJSONString(baseService.findAllUsableTemplate()));
    }

    @Test
    public void testFindIds2TemplateSDK() {
        System.out.println(JSON.toJSONString(
                baseService.findIds2TemplateSDK(Arrays.asList(1, 2, 3))
        ));
    }

}
