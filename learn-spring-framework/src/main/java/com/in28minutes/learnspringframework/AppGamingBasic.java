package com.in28minutes.learnspringframework;
import com.in28minutes.learnspringframework.game.*;


public class AppGamingBasic{

    public static void main(String args[]){


        System.out.println("project started .....");
        var game = new MarvinGame();
        var gamerun = new GameRunner();
        gamerun.run(game);

    }

}