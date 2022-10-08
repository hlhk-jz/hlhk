package com.test.zaxiang;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestZK {
    public static void main(String[] args){
        /*boolean b = rangeInDefined(1000000000, 1, 1000000000);
        log.info("========= "+b);*/
    }

    //只能判断正整数
    public static boolean rangeInDefined(int current, int min, int max) {
        return Math.max(min, current) == Math.min(current, max);
    }
}
