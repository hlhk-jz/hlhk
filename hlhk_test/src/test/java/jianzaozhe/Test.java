package jianzaozhe;

public class Test {
    public static void main(String[] args){
        HomeData biud = new HomeImpi().biudA("电视")
                .biudB("洗衣机")
                .biudC("冰箱")
                .biud();
        System.out.println("产品为："+biud);
    }
}
