package cn.edu.nju.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import cn.edu.nju.java.actor.GrandFather;
import cn.edu.nju.java.actor.CalabashBrother;

public class Story {
    private SortStrategy strategy;
    private GrandFather gfather;
    private List<CalabashBrother> queue;

    public Story() {
        // 故事开始爷爷出场
        gfather = new GrandFather();
        // 爷爷种葫芦，葫芦娃出场
        queue = Arrays.asList(gfather.plantCalabsh());
        // 葫芦娃随意站队
        Collections.shuffle(queue);
        echo("Init queue: ");
        
    }

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void start() {
        System.out.println();
        this.strategy.sort(queue);        
        echo("After sort: ");
    }

    private void echo(String preIntro) {
        System.out.println(preIntro);
        for (var brother : queue) {
            brother.reportName();
        }
        System.out.println();
    }

    public GrandFather getGrandFather() {
        return gfather;
    }

    public static void main(String[] args) {
        var story = new Story();
        StrategyFactory factory = new StrategyFactory(story);
        SortStrategy strategy = factory.getStrategyFromInput();
        story.setStrategy(strategy);
        story.start();
    }
}
