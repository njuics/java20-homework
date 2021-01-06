package advancedjava.finalproj.game;

import advancedjava.finalproj.Pair;

public class Location extends Pair<Integer>
{
    public Location(int x, int y)
    {
        super(x, y);
    }

    public void setLocation(int x, int y)
    {
        this.first = x;
        this.second = y;
    }

    public int getX()
    {
        return this.first;
    }

    public int getY()
    {
        return this.second;
    }
}