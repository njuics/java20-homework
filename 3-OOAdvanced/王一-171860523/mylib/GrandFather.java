package homework3.mylib;

public class GrandFather extends Human{
    public GrandFather(int id) {
        super(id);
        position = 0;
        humanQueue[position] = this;
    }

    /**
     * 爷爷帮助葫芦娃排序
     */
    public void compareExchange() {
        Human human;
        for(int i = 1; i <= 7; ++i) {
            int calaBroId = humanQueue[i].getId();
            if(calaBroId != i) { //说明当前位置的葫芦娃序号不对，爷爷将其和对应位置上的葫芦娃交换位置
                human = humanQueue[i];
                //交换位置
                humanQueue[i] = humanQueue[calaBroId];
                humanQueue[calaBroId] = human;
                //修改position参数
                humanQueue[i].setPosition(i);
                humanQueue[calaBroId].setPosition(calaBroId);
                //如果交换过，就仍然判断当前位置的葫芦娃
                i--;
            }
        }
    }
}
