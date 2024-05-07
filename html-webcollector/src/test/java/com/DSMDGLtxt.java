package com;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.rocks.BreadthCrawler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeMap;

//都市之魔帝归来
public class DSMDGLtxt extends BreadthCrawler {

    public DSMDGLtxt(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
        this.addSeed("https://www.bbiquge.io/book_125536/");
        this.addRegex("https://www.bbiquge.io/book_125536/.*");
        this.addRegex("-.*\\.(jpg|png|gif).*");
        setThreads(10);
        //设置最大key数量，也就是最大网址数量
        getConf().setTopN(1700);
    }
    @Override
    public void visit(Page page, CrawlDatums next) {
        //获取地址
        String body = page.select("body").first().text();
        if(body.contains("加入书签")){

            String zj = "第"+body.split("第")[1].split("章")[0]+"章";
            String[] split = body.split(zj);
            String content = split[split.length-1];
            String trim = content.trim();
            int i = trim.indexOf(" ");
            String title = zj+" "+trim.substring(0,i );
            content = trim.split("推荐本书上一章")[0];
            content = content.substring(i,content.length()-1 );
            content =content.replace("作者：不可爱的萝卜酱返回目录加入书签推荐本书", "");
            content =content.replace("www.bbiquge.io，最快更新都市之魔帝归来","" );
            content =content.replace("推荐阅读：神印王座II皓月当空、龙王殿、重生之都市仙尊、财运天降、花娇、好想住你隔壁、特种奶爸俏老婆、妖夏、总裁爹地，妈咪9块9！、暖婚33天","" );
            content =content.replace("笔趣阁","" );
            content =content.replace("     ！ ","" );
            DemoAutoNewsCrawler.map.put(title,content);
        }
    }

    public static void main(String[] args) throws Exception {
        //参数是抓取器的id与是否解析网页true
        DSMDGLtxt crawler = new DSMDGLtxt("idTest", true);
        //深度
        crawler.start(2);
        try {
            FileWriter writer = new FileWriter("D:/DSMD.txt");
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
