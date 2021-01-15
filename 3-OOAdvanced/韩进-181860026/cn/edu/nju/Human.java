package cn.edu.nju;

public class Human
{
    String name;

    Human(String name)
    {
        this.name = name;
    }

    public void reportName()
    {
        System.out.print(this.name + " ");
    }
}
