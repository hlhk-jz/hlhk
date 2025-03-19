package com;

import lombok.extern.slf4j.Slf4j;

import java.util.Set;
import java.util.TreeSet;
@Slf4j
public class SetDemo {
    public static void main(String[] args){
    Set<String> stringSet = new TreeSet<>();
    stringSet.add("22");
    stringSet.add("444");
        stringSet.add("aaa");
        stringSet.add("ddd");
        stringSet.add("ss");
        stringSet.add("dfs");
        stringSet.add("23333");

      log.info("{}",stringSet);
    }
}
