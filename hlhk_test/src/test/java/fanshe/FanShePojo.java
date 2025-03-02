package fanshe;

import lombok.Data;

@Data
public class FanShePojo {
    private String userName;
    private String home;
    private Integer age;

    public FanShePojo() {

    }

    public void show(){
        System.out.println("========");
    }
}
