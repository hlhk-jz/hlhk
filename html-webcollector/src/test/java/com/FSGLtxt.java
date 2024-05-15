//package com;
//
//import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
//import cn.edu.hfut.dmic.webcollector.model.Page;
//import cn.edu.hfut.dmic.webcollector.plugin.rocks.BreadthCrawler;
//import util.NumBerUtils;
//
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.*;
//import java.util.regex.Pattern;
//
////废少归来归来
//public class FSGLtxt extends BreadthCrawler {
//    public static Map<String,String> bodyMap = new HashMap<>();
//
//    public FSGLtxt(String crawlPath, boolean autoParse) {
//        super(crawlPath, autoParse);
//        this.addSeed("https://m.yexiashuge.xyz/book/1040698/chapter/");
//        this.addRegex("https://m.yexiashuge.xyz/book/1040698/chapter/.*");
//        this.addRegex("-.*\\.(jpg|png|gif).*");
//        setThreads(10);
//        //设置最大key数量，也就是最大网址数量
//        getConf().setTopN(3000);
//    }
//    @Override
//    public void visit(Page page, CrawlDatums next) {
//        next.add(page.url().substring(0,page.url().length()-5)+"_2.html");
//        //获取地址
//        String body = page.select("body").first().text();
//        if(body.contains("下一章")){
//            String title = body.split("阅读记录")[0];
//            if(page.url().contains("_2")){
//                DemoAutoNewsCrawler.urlMap.put(, );
//            }else {
//                DemoAutoNewsCrawler.map.put(page.url(),"test");
//            }
//            FSGLtxt.bodyMap.put(, );
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//        //参数是抓取器的id与是否解析网页true
//        FSGLtxt crawler = new FSGLtxt("idTest", true);
//        //深度
//        crawler.start(3);
//
//        try {
//            FileWriter writer = new FileWriter("D:/FSGL.txt");
//            //多线程章节混乱重新排序
//            LinkedHashMap<String,String> map = new LinkedHashMap<>();
//            TreeMap<Integer, String> m = new TreeMap();
//            for (String str: DemoAutoNewsCrawler.map.keySet()){
//                try {
//                    int s = str.indexOf("第");
//                    int s1 = str.indexOf("章");
//                    m.put(Integer.parseInt(str.substring(s+1,s1 )),str );
//                } catch (NumberFormatException e) {
//                    System.out.println("转换失败1："+str);
//                }
//            }
//            for(Integer ir : m.keySet()){
//                map.put(m.get(ir),DemoAutoNewsCrawler.map.get(m.get(ir)));
//            }
//
//            // 将List的内容写入文件
//          /*  Set<String> strings = map.keySet();
//            for (String str : strings){
//                writer.write(str + "\n");
//                String s = map.get(str);
//                if(!"".equals(s) || null != s){
//                    String[] s1 = s.split(" ");
//                    for(String sd:s1){
//                        if(null != sd && !"".equals(sd.replace(" ","" ))){
//                            writer.write( sd+ "\n");
//                        }
//                    }
//                }else {
//                    System.out.println("空标题："+str);
//                }
//            }*/
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
