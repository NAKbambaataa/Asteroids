package com.Asteroids.main;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject
{

    public Player(int x, int y, ID id)
    {
        super(x, y, id);

    }//end Player constructor

    public void tick()
    {
        x += velX;
        y += velY;

        if (x < 0)
        {
            x = Game.WIDTH;
        }//end if

        if (x > Game.WIDTH)
        {
            x = 0;
        }//end if

        if (y < 0)
        {
            y = Game.HEIGHT;
        }//end if

        if (y > Game.HEIGHT)
        {
            y = 0;
        }//end if

    }//end tick

    public void render(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 16, 16);

    }//end render

}//end class Player
