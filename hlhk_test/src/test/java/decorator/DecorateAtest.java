package decorator;
/**具体装饰角色1*/
public class DecorateAtest extends DecorateBase {
    /**
     * 含有具体构建角色的引用，并且在本构造方法中为引用赋值
     *
     * @param people
     */
    public DecorateAtest(People people) {
        super(people);
    }

    @Override
    public void havingDinner() {
        super.havingDinner();
        havingDinnerOutera();
    }
    private void havingDinnerOutera() {
        System.out.println("扩展功能1：喝点酒！！！");
    }
}
