package com.Asteroids.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD
{
    public static int HEALTH = 100;

    public void tick()
    {

    }//end tick

    public void render(Graphics g)
    {
        g.setColor(Color.GRAY);
        g.fillRect(15, 15, 200, 32);

    }//end render

}//end class HUD
