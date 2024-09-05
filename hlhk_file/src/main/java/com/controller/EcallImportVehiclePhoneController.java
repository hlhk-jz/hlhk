package com.controller;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.config.HttpFirstRecordUtil;
import com.pojo.Ecall;
import com.pojo.EcallPhone;
import com.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.InputStream;
import java.util.List;

//导入VIN和车机电话备案
@Slf4j
@RestController
public class EcallImportVehiclePhoneController {
    @PostMapping("/importExcel/phone")
    public Object importExcel(@RequestParam("file") MultipartFile file) {
        StringBuilder str = new StringBuilder();
        int i = 0;
        try {
            InputStream inputStream = file.getInputStream();
            ExcelReader reader = ExcelUtil.getReader(inputStream);
            List<EcallPhone> ecalls = reader.readAll(EcallPhone.class);

            if(!ecalls.isEmpty() && 0 != ecalls.size()){
                log.info("读取文件数据：{} 条",ecalls.size());
                for (EcallPhone ecall : ecalls){
                    int code = HttpFirstRecordUtil.firstRecord(ecall.getVin(), ecall.getPhone());
                    if(code != 200){
                        str.append(ecall.getVin()+",");
                    }
                }
                if(!StringUtils.isEmpty(str+"")){
                    log.info("错误VIN：{}",str.toString() );
                    return "错误VIN："+str.toString();
                }else {
                    i++;
                }
            }
        }catch (Exception e){
            log.error("{}",e );
        }
        log.info("一次备案成功数量：{} 条",i );
        return "OK";
    }
}
