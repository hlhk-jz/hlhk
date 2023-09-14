package com;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.rocks.BreadthCrawler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DemoAutoNewsCrawler  extends BreadthCrawler{
    public DemoAutoNewsCrawler(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
    }
    public List<String > list = new ArrayList<>();

    @Override
    public void visit(Page page, CrawlDatums next) {
        File file = new File("D:/saoyang.txt");
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取地址
        String url = page.url();
        if(null != url && !"".equals(url)){
            //获取抓取页面的内容
            String body = page.select("body").first().text();
            if(body.contains("并刷新页面") && body.contains("『加入书签，方便阅读』")){
                String str =body;
                String str8=str.substring(0, str.indexOf("第"));
                String strtitle=str.substring(str8.length(), str.length());
                String title =  strtitle.split("字体")[0];
                String str1=str.substring(0, str.indexOf("并刷新页面。"));
                String str2=str.substring(str1.length()+6, str.length());
                String str3 = str2.substring(0,str2.indexOf("『加入书签，方便阅读』") );
                String str5 = str3.replace("　", "");
                String str6 = str5.replace("  ", "\r");
                test.list.add(title);
                test.list.add(str6);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        //参数是抓取器的id与是否解析网页true
        DemoAutoNewsCrawler crawler = new DemoAutoNewsCrawler("idTest", true);
        //设置抓取地址
        crawler.addSeed("http://www.xfuedu.org/bxwx/28340/");
        //设置抓取规则
        crawler.addRegex("http://www.xfuedu.org/bxwx/28340/.*");
        /*禁止爬取图片*/
        crawler.addRegex("-.*png.*");
        crawler.addRegex("-.*jpg.*");
        crawler.addRegex("-.*gif.*");
        crawler.addRegex("-.*js.*");
        crawler.addRegex("-.*css.*");
          /*断点续爬功能开启
        dc.setResumable(true);*/
        //同时启动多少个线程进行抓取
        crawler.setThreads(1);
        //启动爬虫,向下爬10层
        crawler.start(2);
        // 创建一个文件输出流
        try {
            FileWriter writer = new FileWriter("D:/saoyang.txt");
            // 将List的内容写入文件
            for (String item : test.list) {
                writer.write(item + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
