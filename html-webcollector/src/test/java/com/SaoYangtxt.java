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

//邵阳
public class SaoYangtxt extends BreadthCrawler {

    public SaoYangtxt(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);

        this.addSeed("https://www.511wx4.com/wenxue/44437/");
        this.addRegex("https://www.511wx4.com/wenxue/44437/.*");
        this.addRegex("-.*\\.(jpg|png|gif).*");
        setThreads(1);
        //设置最大key数量，也就是最大网址数量
        getConf().setTopN(3000);
    }
    @Override
    public void visit(Page page, CrawlDatums next) {
        //获取地址
        String body = page.select("body").first().text();
        if(body.contains("加入书签")){
            String str8=body.substring(0, body.indexOf("第"));
            String strtitle=body.substring(str8.length(), body.length());
            String[] strs = strtitle.split("书签");
            String title =  strs[0].split(" 第")[0];
            String bodys = body.split("童养夫 　　")[1];
            bodys = bodys.split(" 　　…… 网页")[0];
            DemoAutoNewsCrawler.map.put(title,bodys);
        }
    }

    public static void main(String[] args) throws Exception {
        //参数是抓取器的id与是否解析网页true
        SaoYangtxt crawler = new SaoYangtxt("idTest", true);
        //深度
        crawler.start(2);
        try {
            FileWriter writer = new FileWriter("D:/saoyang.txt");
            // 将List的内容写入文件
            Set<String> strings = DemoAutoNewsCrawler.map.keySet();
            for (String str : strings){
                writer.write(str + "\n");
                String s = DemoAutoNewsCrawler.map.get(str);
                String[] s1 = s.split(" ");
                for(String sd:s1){
                    if(null != sd && !"".equals(sd.replace(" ","" ))){
                        writer.write( sd+ "\n");
                    }
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
