package jianzaozhe;
//具体建造者
public class HomeImpi implements Home {
    private HomeData homeData;
    public HomeImpi(){
        homeData = new HomeData();
    }
    @Override
    public Home biudA(String msg) {
        homeData.setBiudA(msg);
        return this;
    }

    @Override
    public Home biudB(String msg) {
        homeData.setBiudB(msg);
        return this;
    }

    @Override
    public Home biudC(String msg) {
        homeData.setBiudC(msg);
        return this;
    }

    @Override
    public Home biudD(String msg) {
        homeData.setBiudD(msg);
        return this;
    }

    @Override
    public HomeData biud() {
        return homeData;
    }
}
