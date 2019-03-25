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
    private HUD hud;

    public static void main(String args[])
    {
        new Game();

    }//end main

    public Game()
    {
        handler = new Handler();

        this.addKeyListener(new KeyInput(handler));

        new Window(WIDTH, HEIGHT, "Asteroids", this);

        hud = new HUD();

        r = new Random();

        handler.addObject(new Player(WIDTH/2 - 16, HEIGHT/2 - 16, ID.Player));

        for (int i = 0; i < r.nextInt(8) + 1; i++)
        {
            handler.addObject(new SmallAsteroid(r.nextInt(WIDTH - 1) + 1, r.nextInt(HEIGHT - 1) + 1, ID.SmallAsteroid));

        }//end for

        for (int i = 0; i < r.nextInt(5) + 1; i++)
        {
            handler.addObject(new MediumAsteroid(r.nextInt(WIDTH - 1) + 1, r.nextInt(HEIGHT - 1) + 1, ID.MediumAsteroid));

        }//end for

        for (int i = 0; i < r.nextInt(3) + 1; i++)
        {
            handler.addObject(new LargeAsteroid(r.nextInt(WIDTH - 1) + 1, r.nextInt(HEIGHT - 1) + 1, ID.LargeAsteroid));

        }//end for

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
        hud.tick();

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
        hud.render(g);

        g.dispose();
        bs.show();

    }//end render

    public static int clamp (int var, int min, int max)
    {
        if (var >= max)
        {
            return var = max;
        }else if (var <= min)
        {
            return var = min;
        }//end if

        return var;

    }//end clamp

}//end Class Game