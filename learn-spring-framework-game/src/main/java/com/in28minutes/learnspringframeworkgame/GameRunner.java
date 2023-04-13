package com.in28minutes.learnspringframeworkgame;
import com.in28minutes.learnspringframeworkgame.game.*;

public class GameRunner extends MarioGame{
    
    

    public void run(){
        // var game = new MarioGame();
        var game = new Pacman();
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
