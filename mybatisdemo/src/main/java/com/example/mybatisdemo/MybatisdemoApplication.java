package com.example.mybatisdemo;
import java.util.Map;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@SpringBootApplication
@EnableAutoConfiguration
@MapperScan(basePackages = {"com.example.mybatisdemo"})
public class MybatisdemoApplication {
//	@RequestMapping("hello1")
//	@ResponseBody
//	public String hello(Map<String,Object> map){
//		return "hello1";
//	}
	public static void main(String[] args) {
		SpringApplication.run(MybatisdemoApplication.class, args);
	}

}
