package com.Asteroids.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

//Go to class
public class Game extends Canvas implements Runnable
{
    private static final long serialVersionUID = 1506086849956288419L;
    public static final int WIDTH = 640, HEIGHT = (WIDTH / 12) * 9;
    private Thread thread;
    private boolean running = false;
    private Random r;
    private Handler handler;

    public static void main(String args[])
    {
        new Game();

    }//end main

    public Game()
    {
        handler = new Handler();

        this.addKeyListener(new KeyInput(handler));

        new Window(WIDTH, HEIGHT, "Asteroids", this);
        r = new Random();

        handler.addObject(new Player(WIDTH/2 - 32, HEIGHT/2 - 32, ID.Player));

    }//end Game constructor

    public synchronized void start()
    {
        thread = new Thread(this);
        thread.start();
        running = true;

    }//end start

    public synchronized void stop()
    {
       try{
           thread.join();
           running = false;
       }catch(Exception e){
           e.printStackTrace();

       }//end try&catch

    }//end stop

    public void run()
    {
       long lastTime = System.nanoTime();
       double amountOfTicks = 60.0;
       double ns = 1000000000 / amountOfTicks;
       double delta = 0;
       long timer = System.currentTimeMillis();
       int frames = 0;

       while (running)
       {
           long now = System.nanoTime();
           delta += (now - lastTime) / ns;
           lastTime = now;

           while (delta >= 1)
           {
               tick();
               delta--;

           }//end while

           if (running)
           {
               render();

           }//end if

           frames++;

           if(System.currentTimeMillis() - timer > 1000)
           {
               timer += 1000;
               //System.out.println(("FPS: " + frames));
               frames = 0;

           }//end if

       }//end while

       stop();

    }//end run

    private void tick()
    {
        handler.tick();

    }//end tick

    private void render()
    {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null)
        {
            this.createBufferStrategy(3);
            return;

        }//end if

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0,0, WIDTH, HEIGHT);

        handler.render(g);

        g.dispose();
        bs.show();

    }//end render

}//end Class Game