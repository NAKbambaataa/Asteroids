package com.Asteroids.main;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject
{
    Random r = new Random();

    public Player(int x, int y, ID id)
    {
        super(x, y, id);


    }//end Player constructor

    public void tick()
    {
        x += velX;
        y += velY;

    }//end tick

    public void render(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 32, 32);

    }//end render

}//end class Player
