package com.springboot.auth.authentication.rest;

import com.springboot.auth.authentication.service.IAuthenticationService;
import com.springboot.cloud.core.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AuthenticationController {
    @Autowired
    IAuthenticationService authenticationService;

    @RequestMapping(method = RequestMethod.POST, value = "/auth/permission")
    public Result decide(@RequestParam String url, @RequestParam String method, HttpServletRequest request) {
        boolean decide = authenticationService.decide(new HttpServletRequestAuthWrapper(request, url, method));
        return Result.success(decide);
    }

}