package com.Asteroids.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler
{
    LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick()
    {
        for (int i = 0; i < object.size(); i++)
        {
            GameObject tempObject = object.get(i);
            tempObject.tick();

        }//end for

    }//end tick

    public void render(Graphics g)
    {
        for (int i = 0; i < object.size(); i++)
        {
            GameObject tempObject = object.get(i);
            tempObject.render(g);

        }//end for

    }//end render

    public void addObject(GameObject object)
    {
        this.object.add(object);

    }//end addObject

    public void removeObject(GameObject object)
    {
        this.object.remove(object);

    }//end removeObject

}//end Handler
