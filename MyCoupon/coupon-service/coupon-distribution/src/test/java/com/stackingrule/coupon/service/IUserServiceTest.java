package com.stackingrule.coupon.service;

import com.alibaba.fastjson.JSON;
import com.stackingrule.coupon.constant.CouponCategory;
import com.stackingrule.coupon.constant.DistributeTarget;
import com.stackingrule.coupon.constant.PeriodType;
import com.stackingrule.coupon.constant.ProductLine;
import com.stackingrule.coupon.exception.CouponException;
import com.stackingrule.coupon.feign.TemplateClient;
import com.stackingrule.coupon.vo.AcquireTemplateRequest;
import com.stackingrule.coupon.vo.CouponTemplateSDK;
import com.stackingrule.coupon.vo.TemplateRule;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class IUserServiceTest {

    @Autowired
    IUserService userService;


    @Test
    public void findCouponByStatus() throws CouponException {
        userService.findCouponByStatus(11111l,2);

    }

    @Test
    public void findAvailableTemplate() {
    }

    @Test
    public void acquireTemplate() throws CouponException {


        TemplateRule rule = new TemplateRule();
        rule.setExpiration(new TemplateRule.Expiration(
                PeriodType.SHIFT.getCode(),
                1, DateUtils.addDays(new Date(), 60).getTime()
        ));
        rule.setDiscount(new TemplateRule.Discount(5, 1));
        rule.setLimitation(1);
        rule.setUsage(new TemplateRule.Usage(
                "安徽省", "桐城市",
                JSON.toJSONString(Arrays.asList("文娱", "家居"))
        ));
        rule.setWeight(JSON.toJSONString(Collections.EMPTY_LIST));

        CouponTemplateSDK couponTemplateSDK=new CouponTemplateSDK();
        couponTemplateSDK.setId(1);
        couponTemplateSDK.setName("优惠券01");
        couponTemplateSDK.setLogo("http://www.imooc.com");
        couponTemplateSDK.setProductLine(1);
        couponTemplateSDK.setDesc("这是一张优惠券模板");
        couponTemplateSDK.setCategory("满减券");
        couponTemplateSDK.setKey("1001202005190016");
        couponTemplateSDK.setRule(rule);

        AcquireTemplateRequest request = new AcquireTemplateRequest
                (11111l, couponTemplateSDK);

        userService.acquireTemplate(request);
    }

    @Test
    public void settlement() {

    }
}