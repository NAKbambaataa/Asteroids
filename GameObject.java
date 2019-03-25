package com.Asteroids.main;

import java.awt.Graphics;

public abstract class GameObject
{
    protected int x, y;
    protected ID id;
    protected int velX, velY;

    public GameObject(int x, int y, ID id)
    {
        this.x = x;
        this.y = y;
        this.id = id;
    }//end GameObject constructor

    public abstract void tick();
    public abstract void render(Graphics g);

    public void setX(int x)
    {
        this.x = x;
    }//end setX

    public void setY(int y)
    {
        this.y = y;
    }//end setY

    public void setId(ID id)
    {
        this.id = id;
    }//end setId

    public void setVelX(int velX)
    {
        this.velX = velX;
    }//end setVelX

    public void setVelY(int velY)
    {
        this.velY = velY;
    }//end setVelY

    public int getY()
    {
        return y;
    }//end getY

    public ID getId()
    {
        return id;
    }//end getId

    public int getVelX()
    {
        return velX;
    }

    public float getVely()
    {
        return velY;
    }

}//end GameObject
