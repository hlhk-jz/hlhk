package com.aspect;
import com.aspect.test.Files;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/demo")
@RestController
@AllArgsConstructor
public class TestController2 {
    @RequestMapping("/ssg")
    @Files(biaoti = "保存学生记录")
    public String show(@RequestBody Student student){
        Integer insert = 1;
        return insert==1?"成功":"失败";
    }
}
