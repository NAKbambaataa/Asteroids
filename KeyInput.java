package com.Asteroids.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter
{
    private Handler handler;

    public KeyInput(Handler handler)
    {
        this.handler = handler;

    }//end KeyInput constructor

    public void keyPressed(KeyEvent e)
    {
        int key  = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++)
        {
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Player)
            {
                if(key == KeyEvent.VK_W)
                {
                    tempObject.setVely(-3);
                }//end if

                if(key == KeyEvent.VK_S)
                {
                    tempObject.setVely(3);
                }//end if

                if(key == KeyEvent.VK_D)
                {
                    tempObject.setVelX(3);
                }//end if

                if(key == KeyEvent.VK_A)
                {
                    tempObject.setVelX(-3);
                }//end if

            }//end if

        }//end for

    }//end keyPressed

    public void keyReleased(KeyEvent e)
    {
        int key  = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++)
        {
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Player)
            {
                if(key == KeyEvent.VK_W)
                {
                    tempObject.setVely(-1);
                }//end if

                if(key == KeyEvent.VK_S)
                {
                    tempObject.setVely(1);
                }//end if

                if(key == KeyEvent.VK_D)
                {
                    tempObject.setVelX(1);
                }//end if

                if(key == KeyEvent.VK_A)
                {
                    tempObject.setVelX(-1);
                }//end if

            }//end if

        }//end for



    }//end keyReleased

}//end class KeyInput
