package cn.java8;

import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Slf4j
public class Test1 {
    public static void main(String[] args)throws Exception{
        /*Optional<Object> empty = Optional.empty();
        Student student = new Student();
        String str = "";
        Optional<Integer> integer = Optional.ofNullable(student).map(st -> st.getAge());*/

    /* Optional<Integer> integer = Optional.ofNullable(5).filter(st -> st > 6);
        log.info(integer.get()+"=========");*/

        /*Optional<Integer> integer = Optional.ofNullable(5).flatMap(st -> Optional.ofNullable(st));
        Integer integer1 = integer.map(s -> s + 2).get();*/

       /* Integer s = 2;
        Integer integer = Optional.ofNullable(s).orElse(5);
        log.info("======= "+integer);*/

        /*Optional<Integer> integer = Optional.ofNullable(null);
        Integer integer1 = integer.orElseGet(Test3::get);
        log.info("========= "+integer1);*/

     /*   Optional<Object> o = Optional.ofNullable(null);
        o.orElseThrow(()->new ExceptionTest(""));*/
        TreeSet<Integer> treeSet = new TreeSet<>();

        List<String> list = new ArrayList<>();
        for(int i = 1;i<20;i++){

            list.add(RandomUtil.randomInt(100)+"");
        }
        // Stream<T> limit(long maxSize)
       // List<String> collect = list.stream().limit(2).collect(Collectors.toList());

        // Stream<T> skip(long n)
        //List<String> collect = list.stream().skip(5).collect(Collectors.toList());

        //log.info("前："+list);
        // <R> Stream<R> map(Function<? super T, ? extends R> mapper)
       // List<String> collect = list.stream().map(str -> str.substring(1)).collect(Collectors.toList());

        //IntStream intStream = list.stream().mapToInt(Integer::parseInt);

        /*int[] ints = list.stream().mapToInt(Integer::parseInt).toArray();
        log.info(""+ints);*/

       // List<String> collect = list.stream().sorted().collect(Collectors.toList());
        //List<String> co   llect = list.stream().sorted().collect(Collectors.toList());
        log.info("== "+list);
        //Integer::compare 最大
        //Optional<Integer> max = list.stream().map(Integer::parseInt).min(Integer::compare);
       /* Optional<Integer> reduce = list.stream().map(Integer::parseInt).reduce((x, y) -> x + y);
        Integer reduce1 = list.stream().map(Integer::parseInt).reduce(3, (x, y) -> x + y);
        log.info("========="+reduce.get());
        log.info("======= "+reduce1);*/
        Double collect = list.stream().collect(Collectors.averagingInt(Integer::parseInt));
        log.info(""+collect);
    }
}

