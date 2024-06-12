package zk;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.util.*;

@Slf4j
public class Test {
    public static void main(String[] args)throws Exception{
        String path = "D:/NOTICE.txt";
        Map<String,String> strMap = new HashMap<>();
        //FileInputStream fileInputStream = new FileInputStream(new File(path+"\\notice_2.txt"));
        Map<String,List<String>> map =  getContent(path, "============================================================");

        //ul li
         Set<String> stringssss = map.keySet();
        for(String s:stringssss){
            List<String> list = map.get(s);
            for(String str : list){
                if(StringUtils.isNotBlank(str)){
                    if(str.contains("/system/")){
                        strMap.put(str, s);
                    }
                }
            }
        }
       List<String> ulList = new ArrayList<>();
        Set<String> stringSet = strMap.keySet();
        for (String s: stringSet){
            ulList.add("<li><a href='#"+strMap.get(s)+"'>"+s+"</a></li>");
        }
        try {
            FileWriter writer = new FileWriter("D:/ul.txt");
            for (String data : ulList) {
                writer.write(data + "\n");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Set<String> strings = map.keySet();
        FileWriter writer = new FileWriter("D:/body.txt");
        Map<String,List<String>> sysMap = new HashMap<>();
        for (String str: strings){
            List<String> strList = new ArrayList<>();
            for (String s:map.get(str)){
                if(s.contains("/system/")){
                    strList.add(s);
                }
            }
            sysMap.put(str,strList );
        }
        for (String str :strings){
            try {
                writer.write("<tr id='"+str+"'><td class='same-license'>"+ "\n");
                writer.write("    <div class='label'>Notices for file(s):</div>"+ "\n");
                writer.write("<div class='file-list'>");
                List<String> list = sysMap.get(str);
                if(!list.isEmpty()){
                    for (String strs: list){
                        writer.write(strs+"<br>");
                    }
                }
                writer.write("</div>");
                writer.write("<pre class='license-text'>");
                for (String data : map.get(str)) {
                    if(!data.contains("/system/")){
                        writer.write(data + "\n");
                    }
                }
                writer.write("</pre>");
                writer.write("</td></tr>");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Map<String,List<String> > getContent(String filePath, String specifiedContent) {
        List<String> result = new ArrayList<>();
        Map<String,List<String> > map = new TreeMap<>();
        int id = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (!line.equals(specifiedContent)) {
                    result.add(line);
                }else {
                    id ++;
                    //map.put("#id"+id,result );
                    map.put("id"+id,result );
                    result = new ArrayList<>();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

}
