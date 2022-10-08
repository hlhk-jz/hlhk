package cn.test;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
@Slf4j
public class Test2 {
    public static void main(String[] args){
        Persion persion = null;
        String aaaaa = Optional.ofNullable(persion).map(Persion::getCar)
                .map(Car::getName).orElse("aaaaa");
        log.info("====== "+aaaaa);
    }
}
@Data
class Persion{
    private Car car;
}
@Data
class Car{
    private String name;
}




