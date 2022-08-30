package edu.eci.arsw.highlandersim;

import java.util.List;
import java.util.Random;

public class Immortal extends Thread {

    private ImmortalUpdateReportCallback updateCallback = null;

    private int health;

    private int defaultDamageValue;

    private final List<Immortal> immortalsPopulation;

    private final String name;

    private final Random r = new Random(System.currentTimeMillis());

    private boolean pause=false;

    private boolean stop=false;


    public Immortal(String name, List<Immortal> immortalsPopulation, int health, int defaultDamageValue, ImmortalUpdateReportCallback ucb) {
        super(name);
        this.updateCallback = ucb;
        this.name = name;
        this.immortalsPopulation = immortalsPopulation;
        this.health = health;
        this.defaultDamageValue = defaultDamageValue;
    }

    public void run() {

        while (!stop) {
            synchronized (this) {
                while (pause) {
                    try {
                        this.wait();
                    } catch (InterruptedException ex) {
                        System.out.println("Error");
                    }

                }
            }

            Immortal im;

            synchronized (immortalsPopulation) {

                int myIndex = immortalsPopulation.indexOf(this);

                int nextFighterIndex = r.nextInt(immortalsPopulation.size());

                //avoid self-fight
                if (nextFighterIndex == myIndex) {
                    nextFighterIndex = ((nextFighterIndex + 1) % immortalsPopulation.size());
                }

                im = immortalsPopulation.get(nextFighterIndex);

                this.fight(im);

            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }



    }






    public void fight(Immortal i2) {
                   if (i2.getHealth() > 0) {
                           i2.changeHealth(i2.getHealth() - defaultDamageValue);
                           this.health += defaultDamageValue;
                           updateCallback.processReport("Fight: " + this + " vs " + i2 + "\n");
                   } else {
                       updateCallback.processReport(this + " says:" + i2 + " is already dead!\n");
                   }
    }

    public void changeHealth(int v) {
        health = v;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public String toString() {

        return name + "[" + health + "]";
    }

    public void pausar() {
        pause = true;
    }

    public void resumen() {
        setPause(false);
        synchronized (this){
            this.notifyAll();
        }
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }
}
