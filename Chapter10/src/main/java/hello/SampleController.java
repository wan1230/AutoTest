package hello;

import org.springframework.boot.*;
import org.springframework.stereotype.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@Controller     //接口
@EnableAutoConfiguration  //将类托管到Spring的配置

public class SampleController {

    @RequestMapping("/")  //根目录，ip+端口号，直接回车。访问网页：localhost:8080/home
    @ResponseBody
    String home(){
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception{
        SpringApplication.run(SampleController.class, args);


    }


}
