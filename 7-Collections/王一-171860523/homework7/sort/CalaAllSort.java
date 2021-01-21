package homework7.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import homework7.CalaBro;

public class CalaAllSort implements MySort{
    // 全体排序

    /**
     * 对所有葫芦娃排序
     * @param list 葫芦娃序列
     * @param mode -1代表逆序 0代表乱序 1代表正序
     */
    @Override
    public List sort(List list, int mode) throws Exception{
        List<CalaBro> newList = new ArrayList();
        newList.addAll(list);
        if(mode == -1) // 逆序
            Collections.sort(newList, (CalaBro cb1, CalaBro cb2) -> cb2.compareTo(cb1));
        else if(mode == 1) // 正序
            Collections.sort(newList, (CalaBro cb1, CalaBro cb2) -> cb1.compareTo(cb2));
        else if(mode == 0) // 乱序
            Collections.shuffle(newList);
        else // 其他非法情况
            throw new Exception("Class \"CalaAllSort\" Method \"sort\": invalid parameter: mode");
        return newList;
    }
}
