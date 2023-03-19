package com.company;

public class MoveLeft implements ICommand{

    private  Player player;
    public MoveLeft(Player player) {
        this.player=player;
    }
    @Override
    public void Execute() {
        player.TurnLeft();
    }
}
