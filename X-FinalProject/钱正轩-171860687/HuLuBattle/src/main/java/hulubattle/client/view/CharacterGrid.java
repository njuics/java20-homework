package hulubattle.client.view;

import hulubattle.client.controller.MainViewController;
import hulubattle.game.data.AbstractCharacterData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * 代表角色的 UI 控件，本质是一个 VBox 中有一个 Button 和一个 ProgressBar，前者触发点击事件，后者表示生命值
 */
public class CharacterGrid {
    private VBox box = new VBox();
    private Button button = new Button();
    private ImageView image;
    private ProgressBar hpBar;

    private int id;
    private int dataId;
    private int camp;
    private int maxHp;
    private int x = 0;
    private int y = 0;

    /**
     * 构造器
     *
     * @param id   角色的 id
     * @param data 角色的数据
     * @param camp 角色的阵营
     */
    public CharacterGrid(int id, AbstractCharacterData data, int camp) {
        this.id = id;
        this.camp = camp;
        this.dataId = data.getId();
        this.maxHp = data.getHp();

        box.setMaxSize(MainViewController.GRID_WIDTH, MainViewController.GRID_HEIGHT);
        box.setMinSize(MainViewController.GRID_WIDTH, MainViewController.GRID_HEIGHT);
        box.setAlignment(Pos.CENTER);

        button.setMinSize(MainViewController.GRID_WIDTH, MainViewController.GRID_HEIGHT - 10);
        button.setMaxSize(MainViewController.GRID_WIDTH, MainViewController.GRID_HEIGHT - 10);
        button.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");

        image = new ImageView(
                getClass().getClassLoader().getResource(String.format("image/%d%d.png", camp, dataId)).toString());
        image.setFitHeight(MainViewController.GRID_HEIGHT - 10.0);
        image.setFitWidth(MainViewController.GRID_WIDTH - 10.0);
        image.setPreserveRatio(true);
        image.setCache(true);

        button.setGraphic(image);
        button.setTooltip(new Tooltip(String.format("最大生命值：%d%n防御力：%d", data.getHp(), data.getDef())));

        hpBar = new ProgressBar();
        hpBar.setMinSize(MainViewController.GRID_WIDTH - 15.0, 10.0);
        hpBar.setMaxSize(MainViewController.GRID_WIDTH - 15.0, 10.0);
        hpBar.setStyle("-fx-accent: green;");

        box.getChildren().addAll(button, hpBar);
    }

    /**
     * 移动至地图指定位置
     *
     * @param x 横坐标
     * @param y 纵坐标
     */
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
        AnchorPane.setLeftAnchor(box, x * MainViewController.GRID_WIDTH);
        AnchorPane.setTopAnchor(box, y * MainViewController.GRID_HEIGHT);
    }

    /**
     * 设置角色的生命值
     *
     * @param hp 生命值
     */
    public void setHp(int hp) {
        hpBar.setProgress((double) hp / maxHp);
    }

    /**
     * 将角色添加到一个 AnchorPane
     *
     * @param pane 待添加的 AnchorPane
     */
    public void appendTo(AnchorPane pane) {
        pane.getChildren().add(box);
    }

    /**
     * 将角色从 Pane 删除
     *
     * @param pane 待删除的 Pane
     */
    public void removeFrom(AnchorPane pane) {
        pane.getChildren().remove(this.box);
    }

    /**
     * @return the dataId
     */
    public int getDataId() {
        return dataId;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the camp
     */
    public int getCamp() {
        return camp;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param value handler
     * @see javafx.scene.control.ButtonBase#setOnAction(javafx.event.EventHandler)
     */

    public final void setOnAction(EventHandler<ActionEvent> value) {
        button.setOnAction(value);
    }

    /**
     * @param value isDisabled
     * @see javafx.scene.Node#setDisable(boolean)
     */

    public final void setDisable(boolean value) {
        button.setDisable(value);
    }
}
