package pers.xin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.xin.bean.User;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// api/下的请求进入
@Api("SwaggerController")
@RestController//@RestController @Controller后跟的不是url
@RequestMapping("SwaggerController")
public class SwaggerController {

	@PostMapping("showUser")
	@ApiOperation("showUser")
	public User showUser(@RequestBody User user) {
		return user;
	}

	@GetMapping("hello")
	@ApiOperation("hello")
	public String hello() {
		return "Hello, world!";
	}

}
