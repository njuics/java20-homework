package org.cvm.view;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import org.cvm.app.View;
import org.cvm.input.Key;
import org.cvm.net.ATTACK_MSG;
import org.cvm.net.FINISH_MSG;
import org.cvm.net.MOVE_MSG;
import org.cvm.net.Msg;
import org.cvm.world.Team.CalabashbrotherTeam;

import java.util.List;

import static org.cvm.Framework.*;

public class PlayView extends View {

    Button finish_btn;

    VBox playInfo = new VBox();
    ScrollPane scrollPane;

    Alert gameOverAlert;

    ImageView turn1_img = new ImageView(new Image(getClass().getResourceAsStream("turn1.png")));
    ImageView turn2_img = new ImageView(new Image(getClass().getResourceAsStream("turn2.png")));
    VBox turn_vbox = new VBox(turn2_img);

    int teamSkillNumber;
    int teamActionnumber;
    Text action_text = new Text();
    Text skill_text = new Text();
    Text your_team = new Text();

    VBox sidebar_info;
    VBox vbox;
    VBox[] blocks;
    ProgressBar[] bloods_T1;
    ProgressBar[] bloods_T2;
    int[] pos_T1;
    int[] pos_T2;
    int selected_id = -1;
    int selected_block = -1;
    int selected_team = -1;
    boolean myturn = false;

    public PlayView() {
        super();
    }

    public void set_inform(int team, int action, int skill) {
        if (team == selected_team) {
            teamActionnumber = action;
            teamSkillNumber = skill;
            action_text.setText(String.valueOf(teamActionnumber));
            skill_text.setText(String.valueOf(teamSkillNumber));
        }
    }

    public void game_over(int team, boolean youwin){
        if (youwin) {
            playFile.addStatement("END " + team);
            playFile.save_file("win.log");
            gameOverAlert.setContentText("恭喜你获胜！");
        }
        else {
            int op_team = (team == 1 ? 2 : 1);
            playFile.addStatement("END " + op_team);
            playFile.save_file("lose.log");
            gameOverAlert.setContentText("很遗憾你输了。");
        }
        gameOverAlert.show();
    }

    public void set_team(int team) {
        if (team == 1) {
            your_team.setText("你的阵营：葫芦");
            selected_team = 1;
        }
        else {
            your_team.setText("你的阵营：妖怪");
            selected_team = 2;
        }
    }

    public void start_turn(int team) {
        if (team == 1) {
            add_playinfo("新的回合开始：葫芦队");
        }
        else {
            add_playinfo("新的回合开始：妖怪队");
        }
        if (team == selected_team) {
            finish_btn.setVisible(true);
            selected_block = -1;
            selected_id = -1;
            myturn = true;
            turn_vbox.getChildren().remove(0);
            turn_vbox.getChildren().add(turn1_img);
        }
        else {
            finish_btn.setVisible(false);
        }
    }

    public void finish_turn(int team) {
        if (team == selected_team) {
            myturn = false;
            Msg msg = new FINISH_MSG(selected_team);
            netClient.send(msg);
            turn_vbox.getChildren().remove(0);
            turn_vbox.getChildren().add(turn2_img);
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

        gameOverAlert = new Alert(Alert.AlertType.INFORMATION);
        gameOverAlert.setTitle("游戏结束");
        gameOverAlert.setHeaderText(null);
        gameOverAlert.setContentText("Something");
        gameOverAlert.setOnCloseRequest(e -> app.exit());

        teamSkillNumber = CalabashbrotherTeam.getMaxTeamSkillNumber();
        teamActionnumber = CalabashbrotherTeam.getMaxTeamAcitonNumber();

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

        for(int i = 0; i < 45; i++) {
            int finalI = i;
            blocks[i].addEventHandler(MouseEvent.MOUSE_CLICKED,(e) -> solve_clicked(finalI));
        }

        Text action = new Text("行动力: ");
        Text skill = new Text("技能值: ");
        action_text = new Text(String.valueOf(teamActionnumber));
        skill_text = new Text(String.valueOf(teamSkillNumber));
        action.setFont(Font.font(30));
        skill.setFont(Font.font(30));
        action_text.setFont(Font.font(30));
        skill_text.setFont(Font.font(30));
        your_team.setFont(Font.font(30));
        your_team.setText("");
        HBox action_hbox = new HBox(action,action_text);
        HBox skill_hbox = new HBox(skill,skill_text);
        VBox action_skill_vbox = new VBox(your_team,action_hbox,skill_hbox);

        sidebar_info = new VBox();
        for (int i = 0; i < 6; i++) {
            sidebar_info.getChildren().add(new Text(""));
        }

        ImageView img_finish = new ImageView(new Image(getClass().getResourceAsStream("finish.png")));
        finish_btn = new Button("",img_finish);
        finish_btn.setOnAction((e) -> {
            if(myturn)
                finish_turn(selected_team);
        });

        scrollPane = new ScrollPane(playInfo);
        scrollPane.setPrefHeight(220);
        scrollPane.setPrefWidth(200);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        AnchorPane anchorPane = new AnchorPane();

        anchorPane.getChildren().add(finish_btn);
        AnchorPane.setTopAnchor(finish_btn,60.0);
        AnchorPane.setRightAnchor(finish_btn,300.0);

        anchorPane.getChildren().add(scrollPane);
        AnchorPane.setBottomAnchor(scrollPane,20.0);
        AnchorPane.setLeftAnchor(scrollPane,20.0);

        anchorPane.getChildren().add(sidebar_info);
        AnchorPane.setTopAnchor(sidebar_info,200.0);
        AnchorPane.setLeftAnchor(sidebar_info,20.0);

        anchorPane.getChildren().add(action_skill_vbox);
        AnchorPane.setRightAnchor(action_skill_vbox, 60.0);
        AnchorPane.setTopAnchor(action_skill_vbox, 60.0);

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
    public void onUpdate(double time) {
        if (keyInput.isReleased(Key.A)) {
            if (selected_block != -1 && myturn) {
                Msg msg = new MOVE_MSG(selected_team,selected_id,3);
                netClient.send(msg);
            }
        }
        if (keyInput.isReleased(Key.D)) {
            if (selected_block != -1 && myturn) {
                Msg msg = new MOVE_MSG(selected_team,selected_id,4);
                netClient.send(msg);
            }
        }
        if (keyInput.isReleased(Key.W)) {
            if (selected_block != -1 && myturn) {
                Msg msg = new MOVE_MSG(selected_team,selected_id,1);
                netClient.send(msg);
            }
        }
        if (keyInput.isReleased(Key.S)) {
            if (selected_block != -1 && myturn) {
                Msg msg = new MOVE_MSG(selected_team,selected_id,2);
                netClient.send(msg);
            }
        }
        if (keyInput.isReleased(Key.NUM1)) {
            if (selected_block != -1 && myturn) {
                Msg msg = new ATTACK_MSG(selected_team,selected_id,false);
                netClient.send(msg);
            }
        }
        if (keyInput.isReleased(Key.NUM2)) {
            if (selected_block != -1 && myturn) {
                Msg msg = new ATTACK_MSG(selected_team,selected_id,true);
                netClient.send(msg);
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

    public int getNo(int team, int k) {
        if (team == 1) {
            for (int i = 0; i < 7; i++) {
                if (pos_T1[i] == k) {
                    return i + 1;
                }
            }
        }
        else {
            for (int i = 0; i < 7; i++) {
                if (pos_T2[i] == k) {
                    return i + 1;
                }
            }
        }
        return -1;
    }

    public void set_sidebar_info(int team, int id) {
        if (team == 1) {
            sidebar_info.getChildren().remove(0,6);
            List<String> list = calabashbrotherTeam.getinformation(id);
            for (String s : list) {
                Text text = new Text(s);
                text.setWrappingWidth(200);
                sidebar_info.getChildren().add(text);
            }
        }
        else {
            sidebar_info.getChildren().remove(0,6);
            List<String> list = monsterTeam.getinformation(id);
            for (String s : list) {
                Text text = new Text(s);
                text.setWrappingWidth(200);
                sidebar_info.getChildren().add(text);
            }
        }
    }

    public void solve_clicked(int k) {
        int x = getNo(1, k);
        int y = getNo(2, k);
        if (selected_team == 1) {
            if (x != -1) {
                selected_id = x;
                selected_block = k;
                set_sidebar_info(1,x);
            }
            else if (y != -1) {
                selected_id = -1;
                selected_block = -1;
                set_sidebar_info(2,y);
            }
        }
        else {
            if (y != -1) {
                selected_id = y;
                selected_block = k;
                set_sidebar_info(2,y);
            }
            else if (x != -1) {
                selected_id = -1;
                selected_block = -1;
                set_sidebar_info(1,x);
            }
        }
    }
}
