package com;

import org.sikuli.script.Match;
import org.sikuli.script.Region;

//检查宝宝是否挂了
public class BaoBao {
   /* public static void main(String[] args)throws Exception{
        Region region = new Region(0, 0,1200,800);
        region.setThrowException(false);
        baobao(region);
    }*/

    public static void baobao(Region region)throws Exception{
        Match match = region.find("D:/software/sikulix/image/baobao.PNG");
        if(null == match){
             match = region.find("D:/software/sikulix/image/baobao.PNG");
             if(null == match){
                 match = region.find("D:/software/sikulix/image/bbzh.PNG");
                 if(null == match){
                     match = region.find("D:/software/sikulix/image/bbzh.PNG");
                 }
                 match.click();
             }
        }
    }
}