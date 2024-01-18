package decorator;

public class TestC {
    private DecorateBase decorateBase;
    public TestC(DecorateBase decorateBase){
        this.decorateBase = decorateBase;
    }

    public void show(){
        System.out.println("============");
        decorateBase.havingDinner();
    }
}
