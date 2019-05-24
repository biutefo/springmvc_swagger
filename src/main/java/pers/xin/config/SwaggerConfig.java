package pers.xin.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*重要！如果你的项目引入junit测试，此处需要使用@WebAppConfiguration，如果没有使用junit使用@Configuration(很多的博客都没有注明这个问题，为此我花了非常多的时间解决问题)*/
//@WebAppConfiguration
@EnableSwagger2//重要！
@EnableWebMvc
@PropertySource("classpath:swagger.properties") // 新增对swagger.properties 的引入
public class SwaggerConfig {
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("pers.xin.controller"))
				//.paths(PathSelectors.any())
				.build();
	}
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Spring-MVC Swagger2")
				.description("——————————————————————————————")
				.termsOfServiceUrl("https://swagger.io/")
				.contact("xin")
				.version("1.0")
				.build();
	}


























	/*	@Bean
	public Docket customDocket() {
		*//**
		 * 设置参数token
		 *//*
		ParameterBuilder ticketPar = new ParameterBuilder();
		List<Parameter> pars = new ArrayList<Parameter>();
		ticketPar.name("token").description("令牌").modelRef(new ModelRef("string"))
				.parameterType("header")
				.required(false).build(); // header中的token参数非必填，传空也可以
		pars.add(ticketPar.build()); // 根据每个方法名也知道当前方法在设置什么参数

		*//**
		 * 这里有包含正则
		 *//*
		return new Docket(DocumentationType.SWAGGER_2).select().
				//apis(RequestHandlerSelectors.any()).
				apis(RequestHandlerSelectors.basePackage("pers.xin.controller")).
				*//**
				 * 这里有路径匹配包含正则，这里就是只要url里包括api，那么就生成文档
				 *//*
						paths(PathSelectors.regex(".*")).
						build()
				*//**
				 * 这里把token加进去了。
				 *//*
				.globalOperationParameters(pars).
						apiInfo(apiInfo());
	}

	*//**
	 * 这个是设置大标题小标题
	 * @return
	 *//*
	public ApiInfo apiInfo() {

		Contact contact = new Contact("xin.li","www.baidu.com","354010962@qq.com");
		return new ApiInfoBuilder()
				.title("swagger demo")
				.description("spring-mvc整合swagger demo")
				.version("0.1.0")
				.contact(contact)
				.build();

	}*/

}
