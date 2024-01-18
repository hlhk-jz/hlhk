package decorator;
/**具体构建角色*/
public class PeopleImpl implements People {
    @Override
    public void havingDinner() {
        System.out.println("基础功能：吃饭！！！");
    }
}
