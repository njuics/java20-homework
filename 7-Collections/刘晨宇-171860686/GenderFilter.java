import java.util.ArrayList;
import java.util.List;

/**
 * 性别过滤器，用来生成不同性别葫芦娃的子队列
 */
public class GenderFilter {
    static List<CalabashBrother> filter(List<CalabashBrother> list, CalabashBrother.Gender gender) {
        ArrayList<CalabashBrother> subList = new ArrayList<>();
        for(CalabashBrother brother: list) {
            if(brother.getGender() == gender) {
                subList.add(brother);
            }
        }
        return subList;
    }
}
