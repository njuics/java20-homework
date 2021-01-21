package homework7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import homework7.sort.*;

public class CalaBro {
    static List<CalaBro> calaBroList;
    static {
        calaBroList = new ArrayList<>();
    }

    String name;
    String sex;

    CalaBro() {
        Random random = new Random();
        name = randomName(random.nextInt(8) + 3); // 生成3~10个字母组成的随机姓名
        sex = (random.nextInt(100) > 49) ? "Male" : "Female"; // 生成0~99随机数，如果[0,49]就是男性，否则是女性，可能性均为50%
        calaBroList.add(this);
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getName() {
        return this.name;
    }
    public String getSex() {
        return this.sex;
    }

    private String randomName(int length) {
        String letterChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(letterChar.charAt(random.nextInt(letterChar.length())));
        }
        return sb.toString();
    }

    public int compareTo(CalaBro cb) {
        return this.name.compareTo(cb.name);
    }

    /**
     * 对葫芦娃进行六种排序并输出
     */
    public void sortPrint() {
        System.out.println("======全体排序======");
        MySort allSort = new CalaAllSort();
        System.out.println("  ====正序====");
        try {
            printAll(allSort.sort(calaBroList, 1));
        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("  ====逆序====");
        try {
            printAll(allSort.sort(calaBroList, -1));
        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("  ====乱序====");
        try {
            printAll(allSort.sort(calaBroList, 0));
        } catch(Exception e) {
            e.printStackTrace();
        }


        System.out.println("======性别排序======");
        MySort sexSort = new CalaSexSort();
        List<CalaBro> maleList;
        List<CalaBro> femaleList;
        System.out.println("  ====正序====");
        try {
            List<CalaBro> list = sexSort.sort(calaBroList, 1);
            maleList = list.stream()
                    .filter((CalaBro cb) -> cb.getSex().equals("Male"))
                    .collect(Collectors.toList());
            femaleList = list.stream()
                    .filter((CalaBro cb) -> cb.getSex().equals("Female"))
                    .collect(Collectors.toList());
            printAll(maleList);
            printAll(femaleList);
        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("  ====逆序====");
        try {
            List<CalaBro> list = sexSort.sort(calaBroList, -1);
            maleList = list.stream()
                    .filter((CalaBro cb) -> cb.getSex().equals("Male"))
                    .collect(Collectors.toList());
            femaleList = list.stream()
                    .filter((CalaBro cb) -> cb.getSex().equals("Female"))
                    .collect(Collectors.toList());
            printAll(maleList);
            printAll(femaleList);
        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("  ====乱序====");
        try {
            List<CalaBro> list = sexSort.sort(calaBroList, 0);
            maleList = list.stream()
                    .filter((CalaBro cb) -> cb.getSex().equals("Male"))
                    .collect(Collectors.toList());
            femaleList = list.stream()
                    .filter((CalaBro cb) -> cb.getSex().equals("Female"))
                    .collect(Collectors.toList());
            printAll(maleList);
            printAll(femaleList);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void printAll(List<CalaBro> list) {
        System.out.print("  ");
        for(CalaBro cb : list)
            System.out.print(cb.name + "(" + cb.sex + ")" + " ");
        System.out.println();
    }
}
