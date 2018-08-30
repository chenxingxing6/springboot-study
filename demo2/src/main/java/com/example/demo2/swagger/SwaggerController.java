package com.example.demo2.swagger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author lanxinghua
 * @date 2018/08/29 22:56
 * @description
 */
@Api(value = "swagger2测试", tags = {"测试接口"})
@Controller
@RequestMapping("/swagger2")
public class SwaggerController {

    @ApiOperation(value = "获取用户信息",notes = "根据id获取用户信息")
    @ApiImplicitParam(name = "id",value = "用户id",dataType = "Long",required = true,paramType = "path")
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public String get(@PathVariable(name = "id") Long id){
        return "test"+id;
    }
}