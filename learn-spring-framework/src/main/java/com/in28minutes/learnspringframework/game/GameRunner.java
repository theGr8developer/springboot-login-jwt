package com.in28minutes.learnspringframework.game;
import com.in28minutes.learnspringframework.game.MarvinGame;
import java.lang.*;


public class GameRunner {
    MarvinGame game;
    public void run(MarvinGame game){

    this.game = game;

    game.up();
    game.down();
    game.right();
    game.left();




    }


    
}
