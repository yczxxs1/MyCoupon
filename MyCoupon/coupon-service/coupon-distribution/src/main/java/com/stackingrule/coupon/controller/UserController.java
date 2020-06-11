package com.stackingrule.coupon.controller;

import com.stackingrule.coupon.entity.Coupon;
import com.stackingrule.coupon.exception.CouponException;
import com.stackingrule.coupon.service.IUserService;
import com.stackingrule.coupon.vo.AcquireTemplateRequest;
import com.stackingrule.coupon.vo.CouponTemplateSDK;
import com.stackingrule.coupon.vo.SettlementInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/coupon")
    public void getCoupon(@RequestBody AcquireTemplateRequest acquireTemplateRequest) throws CouponException {
        userService.acquireTemplate(acquireTemplateRequest);
    }

    @GetMapping("/coupon/byStatus")
    public List<Coupon> getCouponByStatus(@RequestParam Long userId, @RequestParam Integer status) throws CouponException {
        return userService.findCouponByStatus(userId,status);
    }

    @GetMapping("/coupon/template")
    public List<CouponTemplateSDK> getTemplate(@RequestParam Long userId) throws CouponException {
        return userService.findAvailableTemplate(userId);
    }

    @PostMapping("/coupon/settlement")
    public void settlement(@RequestBody SettlementInfo settlementInfo) throws CouponException {
        userService.settlement(settlementInfo);
    }
}
