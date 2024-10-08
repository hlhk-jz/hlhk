package com.controller;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.pojo.VinPojo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class VinBjController {
    @PostMapping("/importExcel/vins")
    public void importExcel(@RequestParam("file") MultipartFile file,@RequestParam("file2") MultipartFile file2) {

        InputStream inputStream = null;
        InputStream inputStream2 = null;
        try {
            inputStream = file.getInputStream();
            inputStream2 = file2.getInputStream();
            ExcelReader reader1 = ExcelUtil.getReader(inputStream);
            ExcelReader reader2 = ExcelUtil.getReader(inputStream2);

            List<VinPojo> vinPojos = reader1.readAll(VinPojo.class);
            List<VinPojo> vinPojos2 = reader2.readAll(VinPojo.class);

            List<String> vins1 = vinPojos.stream().map(VinPojo::getVin).collect(Collectors.toList());
            List<String> vins2 = vinPojos2.stream().map(VinPojo::getVin).collect(Collectors.toList());

            List<String> vins3 = new ArrayList<>();
            for (String vin : vins2){
                if(!vins1.contains(vin)){
                    vins3.add(vin);
                }
            }

            ExcelWriter excelWriter = ExcelUtil.getWriter("D:/vins.xlsx");
            excelWriter.write(vins3,true);
            excelWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
