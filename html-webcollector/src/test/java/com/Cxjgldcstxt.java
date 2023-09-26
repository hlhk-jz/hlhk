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
         * https://www.69shu.la/69shu/8/8924/
         * https://www.69shu.la/69shu/8/8924/4144560.html
         */
        this.addSeed("https://www.69shu.la/69shu/8/8924/");
        this.addRegex("https://www.69shu.la/69shu/8/8924/.*");
        this.addRegex("-.*\\.(jpg|png|gif).*");
        setThreads(1);
        //设置最大key数量，也就是最大网址数量
        getConf().setTopN(1000);
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
            String title =  strs[0].split(" 第")[0];
            strs = strs[1].split("热门推荐：");
            String bodys = strs[1].split(" 投推荐票")[0];
            bodys = bodys.replace("【千↑千△小↓說△網w ww.xqq xs.com】","" );
            bodys = bodys.replace("【千↑千△小↓说△网w ww.xqq xs.com】","" );
            bodys = bodys.replace("【<a href=\"https://www.\">千千小说</a>w w w.x q q x s.c o m】","" );
            bodys = bodys.replace("【千千小說w w w.x q q x s.c o m】","" );
            bodys = bodys.replace("【千△千△小△說△網ww w.xqqx s.com】","" );
            DemoAutoNewsCrawler.map.put(title,bodys);
        }
    }

    public static void main(String[] args) throws Exception {
        //参数是抓取器的id与是否解析网页true
        Cxjgldcstxt crawler = new Cxjgldcstxt("idTest", true);
        //深度
        crawler.start(2);
        try {
            FileWriter writer = new FileWriter("D:/xjgldcs.txt");
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
