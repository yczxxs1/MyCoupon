package com.stackingrule.coupon.service.impl;

import com.stackingrule.coupon.entity.Coupon;
import com.stackingrule.coupon.service.IRedisService;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class RedisServiceImplTest extends TestCase {

    @Autowired
    IRedisService redisService;

    @Test
    public void testGetCachedCoupons() {
        List<Coupon> coupons = redisService.getCachedCoupons(11111l,2);
        log.info(coupons.get(0).getCouponCode());
    }


    @Test
    public void testTryToAcquireCouponCodeFromCache() {
        redisService.tryToAcquireCouponCodeFromCache(17);
    }

    public void testAddCouponToCache() {
    }
}