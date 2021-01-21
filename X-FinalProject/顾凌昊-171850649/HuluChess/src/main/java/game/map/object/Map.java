package game.map.object;

import com.sun.javafx.geom.Vec2d;
import game.Settings;
import game.character.data.CharacterData;
import game.character.object.Chess;
import game.map.data.CellData;
import game.template.GameObject;
import game.utils.Vec2Int;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Map extends GameObject {

    public int row, column;

    public CellData[][] cells;
    public CellObject[][] cellObjects;

    public int cellSize;

    public Chess[][] chessObjects;

    public Map(int w, int h){
        super(w,h);

        generate();
    }

    public void generate(){
        generateMap(Settings.MAP_ROW, Settings.MAP_COLUMN, Settings.CELL_SIZE);
        generateChess(Settings.MAP_ROW, Settings.MAP_COLUMN, Settings.CELL_SIZE);
    }

    private void generateMap(int _row, int _column, int _size){

        row = _row;
        column = _column;
        cellSize = _size;

        cells = new CellData[column][row];
        cellObjects = new CellObject[column][row];

        for(int i = 0 ;i<column;i++){
            for(int j = 0 ;j<row;j++){
                cells[i][j] = new CellData();

                cellObjects[i][j] = new CellObject(_size,_size);
                cellObjects[i][j].location = new Vec2Int(i,j);

                this.addChild(cellObjects[i][j]);

                cellObjects[i][j].setLocalPosition(new Vec2d(i*_size, j*_size));
            }
        }
    }

    private void generateChess(int _row, int _column, int _size){
        chessObjects = new Chess[_column][_row];

        for(int i = 0 ;i<3;i++){
            for(int j = 0 ;j<row;j++){

                chessObjects[i][j] = new Chess(_size, _size);

                int status = (i+j)%2;
                chessObjects[i][j].init(CharacterData.Grandpa, status);

                chessObjects[i][j].location = new Vec2Int(i,j);

                this.addChild(chessObjects[i][j]);

                chessObjects[i][j].setLocalPosition(new Vec2d(i*_size, j*_size));
            }
        }

        for(int i = column-1 ;i>=column-3;i--){
            for(int j = 0 ;j<row;j++){

                chessObjects[i][j] = new Chess(_size, _size);

                int status = (i+j)%2;
                chessObjects[i][j].init(CharacterData.Monster, status);

                chessObjects[i][j].location = new Vec2Int(i,j);

                this.addChild(chessObjects[i][j]);

                chessObjects[i][j].setLocalPosition(new Vec2d(i*_size, j*_size));
            }
        }


    }

    public void draw(GraphicsContext gc) {

        gc.save();

        gc.setFill(Color.LIGHTGRAY);

        Vec2d position = this.getWorldPosition();
        gc.fillRect(position.x, position.y, width,height);

        gc.restore();

        for(GameObject obj : getChildren()){
            obj.draw(gc);
        }
    }

    public void update() {
        for(int i = 0 ;i<column;i++){
            for(int j = 0 ;j <row;j++){
                cellObjects[i][j].update();
            }
        }
    }

    public void moveChess(Chess c, Vec2Int pos1){

        if(chessObjects[pos1.x][pos1.y]!= null) return;

        chessObjects[c.location.x][c.location.y] = null;
        chessObjects[pos1.x][pos1.y] = c;

        c.location = pos1;

        c.setLocalPosition(locationToLocalPosition(pos1));

        c.status = 1-c.status;
    }


    public void moveChess(Vec2Int pos0, Vec2Int pos1){
        Chess c = chessObjects[pos0.x][pos0.y];
        if(c == null) return;

        moveChess(c, pos1);
    }

    /**
    <returns>
     0：尚未有人获胜
     1：葫芦娃获胜
     -1：妖精获胜
    </returns>
     */
    public int checkWin(){
        int c = 0;
        for(int i = 0 ;i<3;i++){
            for(int j = 0;j<Settings.MAP_ROW;j++){
                if(chessObjects[i][j] == null || chessObjects[i][j].fraction== CharacterData.Fraction.Huluwa){
                    break;
                }else{
                    c++;
                }
            }
        }
        if(c == 3*Settings.MAP_ROW) return -1;

        c=0;
        for(int i = Settings.MAP_COLUMN-1; i>= Settings.MAP_COLUMN-3;i--){
            for(int j = 0;j<Settings.MAP_ROW;j++){
                if(chessObjects[i][j] == null || chessObjects[i][j].fraction== CharacterData.Fraction.Monster){
                    break;
                }else{
                    c++;
                }
            }
        }
        if(c == 3*Settings.MAP_ROW) return 1;

        return 0;
    }



    public Vec2d locationToLocalPosition(Vec2Int loc){
        return new Vec2d(loc.x*cellSize, loc.y*cellSize);
    }

    public Vec2Int worldToLocation(Vec2d wPos){

        Vec2d lPos = new Vec2d(wPos.x - getWorldPosition().x, wPos.y - getWorldPosition().y);

        return new Vec2Int((int)(lPos.x/cellSize), (int)(lPos.y/cellSize));
    }

    public Chess getChessObject(Vec2Int loc){

        if(loc.x >= Settings.MAP_COLUMN || loc.x<0 || loc.y >= Settings.MAP_ROW || loc.y <0) return null;

        return chessObjects[loc.x][loc.y];
    }

    public boolean canMoveTo(Chess c, Vec2Int pos1){


        if(pos1.x >= Settings.MAP_COLUMN || pos1.x<0 || pos1.y >= Settings.MAP_ROW || pos1.y <0) return false;

        boolean hasChess = chessObjects[pos1.x][pos1.y] != null;

        if(hasChess ) return false;


        if(c.status == 0){

            if(Math.abs(pos1.x- c.location.x)>1||Math.abs(pos1.y- c.location.y)>1) return false;

        }else{


            //x相等，y不等
            if(c.location.x == pos1.x){

                if(Math.abs(c.location.y - pos1.y) <2) return false;



                int min = Math.min(c.location.y, pos1.y);
                int max = Math.max(c.location.y, pos1.y);

                for(int j = min+1;j<max;j++){
                    if(getChessObject(new Vec2Int(pos1.x, j))== null){
                        return false;
                    }
                }

            }else if(c.location.y== pos1.y){

                if(Math.abs(c.location.x - pos1.x) <2) return false;


                int min = Math.min(c.location.x, pos1.x);
                int max = Math.max(c.location.x, pos1.x);

                for(int i = min+1;i<max;i++){
                    if(getChessObject(new Vec2Int(i, pos1.y))== null){
                        return false;
                    }
                }

            }else{

                if(Math.abs(c.location.x - pos1.x) != Math.abs(c.location.y - pos1.y)) return false;
                if(Math.abs(c.location.x - pos1.x) <2) return false;


                int minX = Math.min(c.location.x, pos1.x);
                int maxX = Math.max(c.location.x, pos1.x);

                int minY = Math.min(c.location.y, pos1.y);
                int maxY = Math.max(c.location.y, pos1.y);

                for(int i = minX+1;i<maxX;i++){
                    for(int j = minY+1;j<maxY;j++){
                        if(getChessObject(new Vec2Int(i, pos1.y))== null){
                            return false;
                        }
                    }
                }

            }

        }

        return true;
    }

}
