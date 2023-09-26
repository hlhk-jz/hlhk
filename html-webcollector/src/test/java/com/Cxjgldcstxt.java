package com;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.rocks.BreadthCrawler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

//从仙界归来的厨神
public class Cxjgldcstxt extends BreadthCrawler {
    public static Map<String,String> urlMap = new HashMap<>();
    public static Map<String,String> map = new LinkedHashMap<>();

    public Cxjgldcstxt(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
        /**
         * http://www.26ks.org/book/58872/
         * http://www.26ks.org/book/58872/60923520.html
         */
        this.addSeed("http://www.26ks.org/book/58872/");
        this.addRegex("http://www.26ks.org/book/58872/.*");
        this.addRegex("-.*\\.(jpg|png|gif).*");
        setThreads(1);
        //设置最大key数量，也就是最大网址数量
        getConf().setTopN(3000);
    }
    @Override
    public void visit(Page page, CrawlDatums next) {
        //获取地址
        String url = page.url();
        String body = page.select("body").first().text();
        if(body.contains("加入书签")){
            String str8=body.substring(0, body.indexOf("第"));
            String strtitle=body.substring(str8.length(), body.length());
            String[] strs = strtitle.split("书签");
            String bodys = strs[2].split("广告！")[1];
            bodys = bodys.substring(0,bodys.length()-2 );
            String title =  strs[0].split(" 第")[0];
            bodys = bodys.replace("一秒记住ｈｔｔｐ://ｍ．26ks.org ","" );
            bodys = bodys.replace(" 首发网址htTp://m.26ks.org ","" );
            DemoAutoNewsCrawler.map.put(title,bodys);
        }
    }

    public static void main(String[] args) throws Exception {
        //参数是抓取器的id与是否解析网页true
        Cxjgldcstxt crawler = new Cxjgldcstxt("idTest", true);
        //深度
        crawler.start(2);
        try {
            FileWriter writer = new FileWriter("D:/jsql.txt");
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
