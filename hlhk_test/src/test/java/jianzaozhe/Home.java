package jianzaozhe;
//抽象建造者
public interface Home {
    Home biudA(String msg);
    Home biudB(String msg);
    Home biudC(String msg);
    Home biudD(String msg);
    HomeData biud();
}
