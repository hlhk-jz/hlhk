package decorator;
/**具体装饰角色2*/
public class DecorateBtest extends DecorateBase {
    public DecorateBtest(People people) {
        super(people);
    }
    @Override
    public void havingDinner() {
        super.havingDinner();
        havingDinnerOuterb();
    }
    private void havingDinnerOuterb() {
        System.out.println("扩展功能2：吃口鱼！！！");
    }
}
