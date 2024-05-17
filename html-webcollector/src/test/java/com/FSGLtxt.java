package com;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.rocks.BreadthCrawler;
import util.NumBerUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

//废少归来归来
public class FSGLtxt extends BreadthCrawler {
    static Map<Integer, String> integerStringMap = new TreeMap<>();
    static StringBuilder str = new StringBuilder();

    public FSGLtxt(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
        this.addSeed("https://www.ahlock.org/lock/9214/");
        this.addRegex("https://www.ahlock.org/lock/9214/.*");
        this.addRegex("-.*\\.(jpg|png|gif).*");
        setThreads(1);
        //设置最大key数量，也就是最大网址数量
        getConf().setTopN(3000);
    }
    @Override
    public void visit(Page page, CrawlDatums next) {
        //next.add(page.url().substring(0,page.url().length()-5)+"_2.html");
        //获取地址
        String body = page.select("body").first().text();
        if(body.contains("加入书签")){
            int d = body.indexOf("第");
            int z = body.indexOf("章");
            int d1 = body.indexOf("第",d+1);
            String title = body.substring(z+1,d1);

            String substring = body.substring(d + 1, z);
            if(!Pattern.matches("\\d+", substring)){
                substring = NumBerUtils.getSectionNum(substring)+"";
            }

            String strBody = body.split("万相之王小说简介")[1];
            strBody = strBody.split("上一章")[0];
            strBody = strBody.replace("小说网..org，最快更新废少重生归来最新章节！","" );
            if(strBody.matches(".*[a-zA-Z].*")){
                str.append(substring+",");
            }
            DemoAutoNewsCrawler.map.put("第"+substring+"章 "+title,strBody);
        }
    }

    public static void main(String[] args) throws Exception {
        //参数是抓取器的id与是否解析网页true
        FSGLtxt crawler = new FSGLtxt("idTest", true);
        //深度
        crawler.start(3);

        System.out.println(""+str);
        try {
            FileWriter writer = new FileWriter("D:/FSGL.txt");
            //多线程章节混乱重新排序
            LinkedHashMap<String,String> map = new LinkedHashMap<>();
            TreeMap<Integer, String> m = new TreeMap();
            System.out.println(FSGLtxt.integerStringMap);
            for (String str: DemoAutoNewsCrawler.map.keySet()){
                try {
                    int s = str.indexOf("第");
                    int s1 = str.indexOf("章");
                    m.put(Integer.parseInt(str.substring(s+1,s1 )),str );
                } catch (Exception e) {
                    System.out.println("转换失败1："+str);
                }
            }
            for(Integer ir : m.keySet()){
                map.put(m.get(ir),DemoAutoNewsCrawler.map.get(m.get(ir)));
            }

            // 将List的内容写入文件
            Set<String> strings = map.keySet();
            for (String str : strings){
                writer.write(str + "\n");
                String s = map.get(str);
                if(!"".equals(s) || null != s){
                    String[] s1 = s.split(" ");
                    for(String sd:s1){
                        if(null != sd && !"".equals(sd.replace(" ","" ))){
                            writer.write( sd+ "\n");
                        }
                    }
                }else {
                    System.out.println("空标题："+str);
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
