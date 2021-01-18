package BattleControl;
public interface BattleConfig {

    int CANVAS_WIDTH = 960;//Width和Height要成比例4:3
    int CANVAS_HEIGHT = 720;
    int SCENE_WIDTH = 500;
    int SCENE_HEIGHT = 300;

    int ROW_NUM = 12;//对应x
    int COLUMN_NUM = 16;//对应y
    int REFRESH_RATE = 100;

    int UNIT_SIZE = CANVAS_HEIGHT / ROW_NUM;//60*60
    int GRID_LINE_WIDTH = 1;

    double DEFAULT_HP = 100.0;
    double DEFAULT_DAMAGE = 1.0;
    double DEFAULT_DEFENSE = 1.0;

    double HULUWA1_HP=500.0;
    double HULUWA1_DAMAGE=100;
    double HULUWA1_DEFENSE=80;
    double HULUWA2_HP=300.0;
    double HULUWA2_DAMAGE=20;
    double HULUWA2_DEFENSE=20;
    double HULUWA3_HP=600.0;
    double HULUWA3_DAMAGE=100;
    double HULUWA3_DEFENSE=150;
    double HULUWA4_HP=400.0;
    double HULUWA4_DAMAGE=90;
    double HULUWA4_DEFENSE=80;
    double HULUWA5_HP=400.0;
    double HULUWA5_DAMAGE=90;
    double HULUWA5_DEFENSE=80;
    double HULUWA6_HP=300.0;
    double HULUWA6_DAMAGE=40;
    double HULUWA6_DEFENSE=50;
    double HULUWA7_HP=300.0;
    double HULUWA7_DAMAGE=100;
    double HULUWA7_DEFENSE=30;

    double SNAKE_HP=600;
    double SNAKE_DAMAGE=150;
    double SNAKE_DEFENSE=80;
    double SCORPION_HP=700;
    double SCORPION_DAMAGE=140;
    double SCORPION_DEFENSE=100;
    double CENTIPEDE_HP=200;
    double CENTIPEDE_DAMAGE=30;
    double CENTIPEDE_DEFENSE=30;


    int JUSTICE_CREATURE_NUM = 8;
    int EVIL_CREATURE_NUM = 12;

    //int otherPort = 8090;//对方端口
    //int receivePort = 8091;//本地端口
   // String otherIp = "114.212.132.208";//对方ip
    //Player player=Player.JUSTICEPLAYER;
}
