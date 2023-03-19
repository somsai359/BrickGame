package com.company;

public class MoveRight implements ICommand{

    private  Player player;
    public MoveRight(Player player) {
        this.player=player;
    }
    @Override
    public void Execute() {
        player.TurnRight();
    }
}