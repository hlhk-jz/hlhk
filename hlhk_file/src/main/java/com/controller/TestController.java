package com.controller;
import cn.hutool.json.JSONObject;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.mapper.TestMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
@Slf4j
@RestController
public class TestController {
    @Autowired
    private TestMapper mapper;
    @RequestMapping("/test")
    public String test(HttpServletRequest request){
        try {
            List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
            //获取表名
            String tableName = files.get(0).getOriginalFilename().split("\\.")[0];
            MultipartFile multipartFile = files.get(0);
            InputStream inputStream = multipartFile.getInputStream();
            ExcelReader reader = ExcelUtil.getReader(inputStream);
            List<Map<String, Object>> maps = reader.readAll();
            log.info("上传数量：{}，表名：{}",maps.size() ,tableName);
            for(Map<String, Object> map:maps){
                mapper.insert(map,tableName);
            }
        } catch (IOException e) {
            log.error("上传失败：{}",e );
        }
        return "上传完成！";
    }
}
