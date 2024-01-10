package com;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.rocks.BreadthCrawler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

//绝世强龙
public class JSQLtxt  extends BreadthCrawler {

    public JSQLtxt(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
        /**
         * http://www.26ks.org/book/58872/
         * http://www.26ks.org/book/58872/60923520.html
         *
         * http://www.26ks.org/book/58872/60923516.html
         * http://www.26ks.org/book/58872/60923518.html
         *
         * https://www.xiaoshuocc.com/zcxs/30197/
         */
        this.addSeed("https://www.xiaoshuocc.com/zcxs/30197/");
        this.addRegex("https://www.xiaoshuocc.com/zcxs/30197/.*");
        this.addRegex("-.*\\.(jpg|png|gif).*");
        setThreads(10);
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
            String bodys = body.split("读无弹窗 ")[1];
            bodys = bodys.split(" 上一章")[0];
            DemoAutoNewsCrawler.map.put(title,bodys);
        }
    }

    public static void main(String[] args) throws Exception {
        //参数是抓取器的id与是否解析网页true
        JSQLtxt crawler = new JSQLtxt("idTest", true);
        //深度
        crawler.start(2);
        try {
            FileWriter writer = new FileWriter("D:/jsql.txt");
            //多线程章节混乱重新排序
            LinkedHashMap<String,String> map = new LinkedHashMap<>();
            TreeMap<Integer, String> m = new TreeMap();
            for (String str: DemoAutoNewsCrawler.map.keySet()){
                int s = str.indexOf("第");
                int s1 = str.indexOf("章");
                m.put(Integer.parseInt(str.substring(s+1,s1 )),str );
            }
            for(Integer ir : m.keySet()){
                map.put(m.get(ir),DemoAutoNewsCrawler.map.get(m.get(ir)));
            }

            // 将List的内容写入文件
            Set<String> strings = map.keySet();
            for (String str : strings){
                writer.write(str + "\n");
                String s = map.get(str);
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
