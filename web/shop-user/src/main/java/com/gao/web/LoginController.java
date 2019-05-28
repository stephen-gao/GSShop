package com.gao.web;

import com.gao.base.result.Result;
import com.gao.base.result.ResultEnum;
import com.gao.base.result.ResultFactory;
import com.gao.entity.User;
import com.gao.service.ILoginService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


/**
 * @Author gs
 * @Date created time 2019/5/28 11:33
 * @Description
 */
@RestController
public class LoginController {
    private Logger logger = LogManager.getLogger(LoginController.class);

    @Autowired
    private ILoginService loginService;

    @PostMapping("/login")
    public Result login(@RequestBody User po){
        logger.info(po.getUsername() +" " + po.getPassword());
        return loginService.login(po);
    }

    @GetMapping("/logout")
    @ResponseBody
    public Result logout(HttpServletRequest request){
        String token = request.getHeader("token");
        return loginService.logout(token);
    }

    @PostMapping("/register")
    public Result register(@RequestBody User po){
        logger.info(po.getUsername() +" " + po.getPassword());
        return loginService.register(po);
    }

}
