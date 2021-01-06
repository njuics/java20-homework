package homework9.sort;

import homework9.CalaBro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CalaSexSort implements MySort<CalaBro> {
    // 按照性别排序

    /**
     * 对所有葫芦娃排序
     * @param list 葫芦娃序列
     * @param mode -1代表逆序 1代表正序 其他代表乱序
     */
    @Override
    public List<CalaBro> sort(List<CalaBro> list, int mode) {
        List<CalaBro> maleList = list.stream().filter((CalaBro cb) -> cb.getSex().equals("Male")).collect(Collectors.toList());
        List<CalaBro> femaleList = list.stream().filter((CalaBro cb) -> cb.getSex().equals("Female")).collect(Collectors.toList());
        List<CalaBro> newList = new ArrayList();
        if(mode == -1) { // 逆序
            Collections.sort(maleList, (CalaBro cb1, CalaBro cb2) -> cb2.compareTo(cb1));
            Collections.sort(femaleList, (CalaBro cb1, CalaBro cb2) -> cb2.compareTo(cb1));
        } else if(mode == 1) { // 正序
            Collections.sort(maleList, (CalaBro cb1, CalaBro cb2) -> cb1.compareTo(cb2));
            Collections.sort(femaleList, (CalaBro cb1, CalaBro cb2) -> cb1.compareTo(cb2));
        } else { // 乱序
            Collections.shuffle(maleList);
            Collections.shuffle(femaleList);
        }
        newList.addAll(maleList);
        newList.addAll(femaleList);
        return newList;
    }
}
