package org.cvm;

import org.cvm.app.App;
import org.cvm.app.Engine;
import org.cvm.input.KeyInput;
import org.cvm.net.NetClient;
import org.cvm.output.PlayFile;
import org.cvm.view.PlayView;
import org.cvm.view.ServerView;
import org.cvm.world.Team.CalabashbrotherTeam;
import org.cvm.world.Team.MonsterTeam;

public class Framework {

    public static App app;

    public static Engine engine;

    public static KeyInput keyInput;

    public static CalabashbrotherTeam calabashbrotherTeam;

    public static MonsterTeam monsterTeam;

    public static NetClient netClient;

    public static PlayView playView;

    public static ServerView serverView;

    public static PlayFile playFile;
}
