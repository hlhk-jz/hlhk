package decorator;
/**装饰角色*/
public class DecorateBase {
    private People people;

    /**
     * 含有具体构建角色的引用，并且在本构造方法中为引用赋值
     * @param people
     */
    public DecorateBase(People people){
        this.people = people;
    }

    public void havingDinner() {
       this.people.havingDinner();
    }
}
