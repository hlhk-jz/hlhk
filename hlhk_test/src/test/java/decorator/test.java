package decorator;

public class test {
    public static void main(String[] args){
        TestC testC = new TestC(new DecorateBase(new PeopleImpl()));
        testC.show();
       /* People people = new DecorateBtest(new DecorateAtest(new DecorateBase(new PeopleImpl())));
        people.havingDinner();*/
    }
}
