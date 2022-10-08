package com.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public class ReaderTest {
    public static void main(String[] args)throws Exception{
        String filePath = "D:/a.txt";
        FileInputStream fin = new FileInputStream(filePath);
        InputStreamReader reader = new InputStreamReader(fin);
        BufferedReader buffReader = new BufferedReader(reader);
        List<String> list = new ArrayList<>();
        String strTmp = "";
        Set<String> strings = new HashSet<>();
        while((strTmp = buffReader.readLine())!=null){
            if(!StringUtils.isEmpty(strTmp) && strTmp.contains(":")){
                strings.add(strTmp);
            }
        }
        buffReader.close();
        log.info("名称去重后 = "+strings);
        log.info("去重后数 = {} ",strings.size());
    }
}
