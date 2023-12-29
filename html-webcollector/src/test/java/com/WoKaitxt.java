package com;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.rocks.BreadthCrawler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WoKaitxt extends BreadthCrawler {
    public WoKaitxt(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);

        this.addSeed("http://www.xswang.org/book/63273/");
        this.addRegex("http://www.xswang.org/book/63273/.*");
        this.addRegex("-.*\\.(jpg|png|gif).*");
        setThreads(1);
        //设置最大key数量，也就是最大网址数量
        getConf().setTopN(1200);


    }
    @Override
    public void visit(Page page, CrawlDatums next) {
        //获取地址
        String body = page.select("body").first().text();
        if(body.contains("上一章")){
            if(body.contains("第")){
                String title = "第"+body.split("第")[1];
                if(body.contains("最快更新！无广告！")){
                    String str = body.split("最快更新！无广告！")[1];
                    if(str.contains("加入书签")){
                        String str1 = str.split("加入书签")[0];
                        DemoAutoNewsCrawler.map.put(title,str1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        //参数是抓取器的id与是否解析网页true
        WoKaitxt crawler = new WoKaitxt("idTest", true);
        //深度
        crawler.start(2);
        try {
            Set<String> stringss = DemoAutoNewsCrawler.map.keySet();
            List<Integer> list = new ArrayList<>();
            for (String str: stringss){
                list.add(Integer.parseInt(str.split("第")[1].split("章")[0].replace(" ","" )));
            }

            for(int i = 1;i<996;i++){
                 if(!list.contains(i)){
                     System.out.println("========"+i);
                 }
            }

            FileWriter writer = new FileWriter("D:/dushi.txt");
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
