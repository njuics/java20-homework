package org.cvm.view;

import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import org.cvm.app.View;
import org.cvm.input.Key;
import org.cvm.world.Team.CalabashbrotherTeam;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.cvm.Framework.*;

public class FilePlayView extends View {

    boolean isThreadOn = true;

    VBox playInfo = new VBox();
    ScrollPane scrollPane;

    List<String> list = new ArrayList<>();

    ImageView turn1_img = new ImageView(new Image(getClass().getResourceAsStream("turn_b.png")));
    ImageView turn2_img = new ImageView(new Image(getClass().getResourceAsStream("turn_m.png")));
    VBox turn_vbox = new VBox(turn1_img);

    int team1Skill;
    int team1Action;
    int team2Skill;
    int team2Action;
    Text action1_text = new Text();
    Text skill1_text = new Text();
    Text action2_text = new Text();
    Text skill2_text = new Text();

    VBox sidebar_info;

    private File file;
    VBox vbox;
    VBox[] blocks;
    ProgressBar[] bloods_T1;
    ProgressBar[] bloods_T2;
    int[] pos_T1;
    int[] pos_T2;

    public FilePlayView() {
        super();
        file = null;
    }

    public void set_inform(int team, int action, int skill) {
        if (team == 1) {
            team1Action = action;
            team1Skill = skill;
            action1_text.setText(String.valueOf(team1Action));
            skill1_text.setText(String.valueOf(team1Skill));
        }
        else {
            team2Action = action;
            team2Skill = skill;
            action2_text.setText(String.valueOf(team2Action));
            skill2_text.setText(String.valueOf(team2Skill));
        }
    }

    public void setPos(int team, int id, int src, int dst) {
        if (team == 1) {
            assert(pos_T1[id-1] == src);
            pos_T1[id-1] = dst;
        }
        else {
            assert(pos_T2[id-1] == src);
            pos_T2[id-1] = dst;
        }
        swap_block(src,dst);
    }

    public void add_playinfo(String s) {
        Text text = new Text(s);
        text.setFont(Font.font(10));
        text.setWrappingWidth(200);
        playInfo.getChildren().add(text);
        scrollPane.setVvalue(1);
    }

    public void delete_creature(int team, int id) {
        VBox vbox_figure = new VBox();
        ImageView img_figure = new ImageView();
        img_figure.setFitWidth(70);
        img_figure.setFitHeight(86);
        vbox_figure.getChildren().add(img_figure);
        int x;
        if (team == 1) {
            x = pos_T1[id-1];
            pos_T1[id-1] = -1;
            bloods_T1[id-1] = null;
        }
        else {
            x = pos_T2[id-1];
            pos_T2[id-1] = -1;
            bloods_T2[id-1] = null;
        }
        blocks[x].getChildren().remove(0);
        blocks[x].getChildren().add(vbox_figure);
    }

    @Override
    public void onLaunch() {

        team1Skill = CalabashbrotherTeam.getMaxTeamSkillNumber();
        team1Action = CalabashbrotherTeam.getMaxTeamAcitonNumber();
        team2Skill = CalabashbrotherTeam.getMaxTeamSkillNumber();
        team2Action = CalabashbrotherTeam.getMaxTeamAcitonNumber();

        pos_T1 = calabashbrotherTeam.getallpostion();
        pos_T2 = monsterTeam.getallpostion();

        Group group = new Group();
        Image img_play_bg = new Image(getClass().getResourceAsStream("play_bg.png"));
        ImageView img_play_bg_view = new ImageView(img_play_bg);
        group.getChildren().add(img_play_bg_view);

        vbox = new VBox();
        vbox.setSpacing(10);
        blocks = new VBox[5 * 9];
        bloods_T1 = new ProgressBar[7];
        bloods_T2 = new ProgressBar[7];

        for(int i = 0; i < 5; i++) {
            HBox hbox = new HBox();
            hbox.setSpacing(10);
            for(int j = 0; j < 9; j++) {
                VBox vbox_figure = new VBox();
                ImageView img_figure = new ImageView();
                img_figure.setFitWidth(70);
                img_figure.setFitHeight(86);
                vbox_figure.getChildren().add(img_figure);
                VBox vbox_figure_outside = new VBox(vbox_figure);
                hbox.getChildren().add(vbox_figure_outside);
                blocks[9 * i + j] = vbox_figure_outside;
            }
            vbox.getChildren().add(hbox);
        }
        for (int i = 0; i < 7; i++) {
            int x = pos_T1[i];
            VBox vbox_figure = new VBox();
            ImageView img_figure = new ImageView(new Image(getClass().getResourceAsStream("b" + (i + 1) + "_right.png")));
            ProgressBar blood = new ProgressBar();
            blood.setPrefWidth(70);
            blood.setStyle("-fx-accent: red;");
            blood.setProgress(1);
            bloods_T1[i] = blood;
            img_figure.setFitWidth(70);
            img_figure.setFitHeight(66);
            vbox_figure.getChildren().add(blood);
            vbox_figure.getChildren().add(img_figure);
            blocks[x].getChildren().remove(0);
            blocks[x].getChildren().add(vbox_figure);
        }

        for (int i = 0; i < 7; i++) {
            int x = pos_T2[i];
            VBox vbox_figure = new VBox();
            ImageView img_figure = new ImageView(new Image(getClass().getResourceAsStream("m" + (i + 1) + "_left.png")));
            ProgressBar blood = new ProgressBar();
            blood.setPrefWidth(70);
            blood.setStyle("-fx-accent: red;");
            blood.setProgress(1);
            bloods_T2[i] = blood;
            img_figure.setFitWidth(70);
            img_figure.setFitHeight(66);
            vbox_figure.getChildren().add(blood);
            vbox_figure.getChildren().add(img_figure);
            blocks[x].getChildren().remove(0);
            blocks[x].getChildren().add(vbox_figure);
        }

        Text action1 = new Text("行动力: 葫芦队");
        Text skill1 = new Text("技能值: 葫芦队");
        Text action2 = new Text(" 妖怪队");
        Text skill2 = new Text(" 妖怪队");
        action1_text = new Text(String.valueOf(team1Action));
        skill1_text = new Text(String.valueOf(team1Skill));
        action2_text = new Text(String.valueOf(team2Action));
        skill2_text = new Text(String.valueOf(team2Skill));
        action1.setFont(Font.font(30));
        skill1.setFont(Font.font(30));
        action2.setFont(Font.font(30));
        skill2.setFont(Font.font(30));
        action1_text.setFont(Font.font(30));
        skill1_text.setFont(Font.font(30));
        action2_text.setFont(Font.font(30));
        skill2_text.setFont(Font.font(30));
        HBox action1_hbox = new HBox(action1,action1_text);
        HBox skill1_hbox = new HBox(skill1,skill1_text);
        VBox action_skill1_vbox = new VBox(action1_hbox,skill1_hbox);
        HBox action2_hbox = new HBox(action2,action2_text);
        HBox skill2_hbox = new HBox(skill2,skill2_text);
        VBox action_skill2_vbox = new VBox(action2_hbox,skill2_hbox);
        HBox action_skill_hbox = new HBox(action_skill1_vbox,action_skill2_vbox);

        sidebar_info = new VBox();
        for (int i = 0; i < 6; i++) {
            sidebar_info.getChildren().add(new Text(""));
        }

        scrollPane = new ScrollPane(playInfo);
        scrollPane.setPrefHeight(220);
        scrollPane.setPrefWidth(200);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        AnchorPane anchorPane = new AnchorPane();

        anchorPane.getChildren().add(scrollPane);
        AnchorPane.setBottomAnchor(scrollPane,20.0);
        AnchorPane.setLeftAnchor(scrollPane,20.0);

        anchorPane.getChildren().add(sidebar_info);
        AnchorPane.setTopAnchor(sidebar_info,200.0);
        AnchorPane.setLeftAnchor(sidebar_info,20.0);

        anchorPane.getChildren().add(action_skill_hbox);
        AnchorPane.setRightAnchor(action_skill_hbox, 60.0);
        AnchorPane.setTopAnchor(action_skill_hbox, 60.0);

        anchorPane.getChildren().add(turn_vbox);
        AnchorPane.setLeftAnchor(turn_vbox, 10.0);
        AnchorPane.setTopAnchor(turn_vbox, 10.0);

        anchorPane.getChildren().add(vbox);
        AnchorPane.setBottomAnchor(vbox, 60.0);
        AnchorPane.setRightAnchor(vbox, 60.0);
        getChildren().add(group);
        getChildren().add(anchorPane);
    }


    @Override
    public void onEnter() {
        if(app.getFile() != null) {
            file = app.getFile();
            System.out.println(file);
            playBack();
            file = null;
            app.setFile(null);
            isThreadOn = true;
            int size = playInfo.getChildren().size();
            playInfo.getChildren().remove(0,size);
            new Thread(new ControlThread()).start();
        }
        else {
            System.out.println("No file");
        }
    }

    @Override
    public void onUpdate(double time) {
        if (keyInput.isReleased(Key.SPACE)) {
            System.out.println("pause");
        }
        if (keyInput.isReleased(Key.ESCAPE)) {
            isThreadOn = false;
            app.gotoView("Home");
        }
    }

    private class ControlThread implements Runnable{

        @Override
        public void run() {
            for (String s : list) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    System.out.println("ControlThread exception");
                }
                Platform.setImplicitExit(false);
                Platform.runLater(() -> ControlPlay(s));
                if (!isThreadOn) {
                    break;
                }
            }
        }
    }

    public void ControlPlay(String s) {
        String[] l = s.split(" ");
        if (l.length > 0) {
            switch(l[0]) {
                case "MOVE":{
                    if (l.length == 5) {
                        int team = Integer.parseInt(l[1]);
                        int id = Integer.parseInt(l[2]);
                        int src = Integer.parseInt(l[3]);
                        int dst = Integer.parseInt(l[4]);
                        setPos(team,id,src,dst);
                        System.out.println(s);
                    }
                    break;
                }
                case "START":{
                    if (l.length == 2) {
                        int team = Integer.parseInt(l[1]);
                        turn_vbox.getChildren().remove(0);
                        if (team == 1) {
                            turn_vbox.getChildren().add(turn1_img);
                            add_playinfo("新的回合开始：葫芦队");
                        }
                        else {
                            turn_vbox.getChildren().add(turn2_img);
                            add_playinfo("新的回合开始：妖怪队");
                        }
                        System.out.println("START " + team);
                    }
                    break;
                }
                case "FINISH":{
                    if (l.length == 2) {
                        int team = Integer.parseInt(l[1]);
                        System.out.println("FINISH " + team);
                        set_inform(1, CalabashbrotherTeam.getMaxTeamAcitonNumber(),CalabashbrotherTeam.getMaxTeamSkillNumber());
                        set_inform(2, CalabashbrotherTeam.getMaxTeamAcitonNumber(),CalabashbrotherTeam.getMaxTeamSkillNumber());
                        add_playinfo("本回合结束");
                    }
                    break;
                }
                case "BLOOD":{
                    if (l.length == 6) {
                        int team = Integer.parseInt(l[1]);
                        int id = Integer.parseInt(l[2]);
                        int damage = Integer.parseInt(l[3]);
                        int current_blood = Integer.parseInt(l[4]);
                        int max_blood = Integer.parseInt(l[5]);
                        double blood = (double)current_blood / (double)max_blood;
                        set_blood(team,id,blood);
                        if (current_blood == 0) {
                            delete_creature(team,id);
                        }
                        String team_str = (team == 1 ? "葫芦队" : "妖怪队");
                        String id_str = (team == 1 ? calabashbrotherTeam.getSkillName(id) :monsterTeam.getSkillName(id));
                        String isdead_str = (current_blood <= 0 ? "后死亡" : "");
                        add_playinfo(team_str + "的" + id_str + "受到了" + damage + "点伤害" + isdead_str);
                        System.out.println(s);
                    }
                    break;
                }
                case "INFORM":{
                    if (l.length == 4) {
                        int team = Integer.parseInt(l[1]);
                        int action = Integer.parseInt(l[2]);
                        int skill = Integer.parseInt(l[3]);
                        set_inform(team,action,skill);
                        System.out.println(s);
                    }
                    break;
                }
                case "END": {
                    if (l.length == 2) {
                        int team = Integer.parseInt(l[1]);
                        String team_str = (team == 1 ? "葫芦队" : "妖怪队");
                        add_playinfo("游戏结束，" + team_str + "获胜");
                        System.out.println(s);
                    }
                    break;
                }
                default:break;
            }
        }
    }

    public void swap_block(int src,int dst) {
        Node s = blocks[src].getChildren().get(0);
        blocks[src].getChildren().remove(0);
        Node t = blocks[dst].getChildren().get(0);
        blocks[dst].getChildren().remove(0);
        blocks[dst].getChildren().add(s);
        blocks[src].getChildren().add(t);
    }

    public void set_blood(int team, int id, double blood) {
        if (team == 1) {
            bloods_T1[id-1].setProgress(blood);
        }
        else {
            bloods_T2[id-1].setProgress(blood);
        }
    }

    private void playBack() {
        // do something
        System.out.println("in playBack");
        String content = readFileContent(file);
        String[] s = content.split("\n");
        Collections.addAll(list, s);
    }

    public static String readFileContent(File file) {
        BufferedReader reader = null;
        StringBuilder sbf = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                sbf.append(tempStr);
                sbf.append('\n');
            }
            reader.close();
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }
}
