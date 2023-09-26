package com;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.rocks.BreadthCrawler;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
//邵阳
public class DemoAutoNewsCrawler  extends BreadthCrawler{
    public static Map<String,String> urlMap = new HashMap<>();
    public static Map<String,String> map = new LinkedHashMap<>();

    public DemoAutoNewsCrawler(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
    }
    @Override
    public void visit(Page page, CrawlDatums next) {
        //获取地址
        String url = page.url().replace("#", "");
        if(null != url && !"".equals(url)){
            //获取抓取页面的内容
            String body = page.select("body").first().text();
            if(body.contains("并刷新页面") && body.contains("『加入书签，方便阅读』") && !body.contains("番外")
                    && body.contains("第") && body.contains("字体")  ){
                String str =body;
                String str8=str.substring(0, str.indexOf("第"));
                String strtitle=str.substring(str8.length(), str.length());
                String title =  strtitle.split("字体")[0];
                String str1=str.substring(0, str.indexOf("并刷新页面。"));
                String str2=str.substring(str1.length()+6, str.length());
                String str3 = str2.substring(0,str2.indexOf("『加入书签，方便阅读』") );
                String str5 = str3.replace("　", "");
                String str6 = str5.replace("  ", "\r");

                String mUrl = DemoAutoNewsCrawler.urlMap.get(title);
                //如果是新的存入
                if(null == mUrl || "".equals(mUrl)){
                    DemoAutoNewsCrawler.urlMap.put(title,url);
                    DemoAutoNewsCrawler.map.put(title, str6);
                }else {
                    //如果是旧的并且是第二页
                    if(!url.equals(mUrl)){
                      /*  System.out.println(url);
                        System.out.println(mUrl);
                        System.out.println(DemoAutoNewsCrawler.map.get(title));
                        System.out.println(str6);*/
                        DemoAutoNewsCrawler.map.put(title, DemoAutoNewsCrawler.map.get(title)+str6);
                    }
                }
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
        crawler.start(3);
        // 创建一个文件输出流
        try {
            FileWriter writer = new FileWriter("D:/saoyang.txt");
            // 将List的内容写入文件
            Set<String> strings = DemoAutoNewsCrawler.map.keySet();
            for (String str : strings){
                writer.write(str + "\n");
                writer.write( DemoAutoNewsCrawler.map.get(str) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
