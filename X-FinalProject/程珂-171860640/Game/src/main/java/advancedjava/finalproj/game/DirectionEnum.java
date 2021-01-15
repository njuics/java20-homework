package advancedjava.finalproj.game;

public enum DirectionEnum
{
    UP(0, -1),
    DOWN(0, 1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    private int moveOffsetX;
    private int moveOffsetY;

    DirectionEnum(int x, int y)
    {
        moveOffsetX = x;
        moveOffsetY = y;
    }

    public int getOffsetX()
    {
        return this.moveOffsetX;
    }

    public int getOffsetY()
    {
        return this.moveOffsetY;
    }
}