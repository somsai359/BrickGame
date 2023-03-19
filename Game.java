package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JPanel implements KeyListener, ActionListener {

    private  boolean play;

    private int totalBrick;
    private int brickRowSize;
    private int brickColSize;

    private Timer timer;
    private  int delay;

    private  Graphics g;
    private  MapGenerator mapGenerator;
    private  Player player;
    private  Ball ball;
    private  Map map;
    private  Inscription gameOverWin;
    private  Inscription gameOverLose;
    private  Inscription enter;
    private  Inscription score;
    private  Brick brick;

    private  JFrame obj;

    private ICommand moveRight;
    private ICommand moveLeft;

    public Game(JFrame obj)
    {
        Init();
        this.obj=obj;
        mapGenerator= new MapGenerator(brickRowSize, brickColSize, obj);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer= new Timer(delay, this);
        timer.start();
        player = new Player(obj);
        ball= new Ball(obj);
        map= new Map(obj);
        gameOverWin =new Inscription("You won", obj, 30, 40);
        gameOverLose=new Inscription("Game over", obj, 30, 40);
        enter= new Inscription("press enter to restart", obj, 30, 50);
        score=new Inscription("score ", obj, 80, 5);
        brick=new Brick(obj);
        moveRight = new MoveRight(player);
        moveLeft = new MoveLeft(player);
    }

    private void Init()
    {
        play=false;
        brickRowSize=5;
        brickColSize=7;
        totalBrick=brickRowSize*brickColSize;
        delay=8;
    }

    private  void DrawBall()//
    {
        ball.Draw(g);
        if(PlayerWon())
            GameOver(g, gameOverWin.getText());
        if(ball.Escape())
            GameOver(g, gameOverLose.getText());
        g.dispose();
    }
    private boolean PlayerWon()
    {
        return totalBrick<=0;
    }
    public void paint(Graphics g)
    {
        this.g=g;
        map.getBackGround().Draw(g, map);
        mapGenerator.draw((Graphics2D) g);
        score.Draw(g, player);
        player.Draw(g);
        DrawBall();
    }
    private  void GameOver(Graphics g, String gameState)
    {
        play=false;
        ball.Stop();

        g.setColor(Color.RED);
        g.setFont(new Font("serif", Font.BOLD, gameOverWin.getSize()));
        g.drawString(gameState, gameOverWin.getWidth(), gameOverWin.getHeight());

        g.setFont(new Font("serif", Font.BOLD, gameOverWin.getSize()));
        g.drawString(enter.getText(), enter.getWidth(), enter.getHeight());
    }
    private boolean BallTouchPlayer()
    {
        int ballCollisionPlayerHeight=20;//
        int ballCollisionPlayerWidth=20;//
        return new Rectangle(ball.getPosX(), ball.getPosY(), ballCollisionPlayerWidth, ballCollisionPlayerHeight).
                intersects(new Rectangle(player.getPosX(), player.getPosY(), player.getWidth(), player.getHeight()));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if(play) {
            BallLogic();

            ball.Move();
            ball.MoveDirX();
            ball.MoveDirY();
            if (BallTouchesAWall())
                ball.XDirReverse();
        }
        repaint();
    }
    private  boolean BallTouchesAWall()
    {
        return ball.getPosX() >= map.getBorderRight().getPosX();
    }
    private  void BallLogic()
    {
        if(BallTouchPlayer())
            ball.YDirReverse();
        BallTouchABrick();
    }

    private  void BallTouchABrick() {
        int posXBallFix = 19;
        int widthBallFix = 1;
        A:
        for (int a = 0; a < mapGenerator.map.length; a++) {
            for (int b = 0; b < mapGenerator.map[0].length; b++)
                if (mapGenerator.map[a][b] > 0) {
                    Rectangle rectangle = new Rectangle(b * mapGenerator.brick.getWidth() + brick.getPosX(),
                            a * mapGenerator.brick.getHeight() + brick.getPosY(), mapGenerator.brick.getWidth(), mapGenerator.brick.getHeight());
                    Rectangle ballRect = new Rectangle(ball.getPosX(), ball.getPosY(), ball.getWidth(), ball.getHeight());
                    Rectangle brickRect = rectangle;
                    if (ballRect.intersects(brickRect)) {
                        mapGenerator.setBrickValue(0, a, b);
                        totalBrick--;
                        player.AddPoint();
                        if (ball.getPosX() + posXBallFix <= brickRect.x || ball.getPosX() + widthBallFix >= brickRect.x + brickRect.width)
                            ball.XDirReverse();
                        else
                            ball.YDirReverse();
                        break A;
                    }
                }
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            play=true;
            if(player.IsTouchingRightWall())
                player.BlockRightMove();
            else
                moveRight();
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT)
        {
            play=true;
            if(player.IsTouchingLeftWall())
                player.BlockLeftMove();
            else
                moveLeft();
        }
        if(e.getKeyCode()==KeyEvent.VK_ENTER)
        {
            if(!play)
            {
                ResetGame();
                repaint();
            }
        }
    }

    private  void ResetGame()
    {
        play=true;
        ball.Reset();
        player.Reset();
        mapGenerator= new MapGenerator(brickRowSize, brickColSize, obj);
        totalBrick=brickRowSize*brickColSize;
    }
    private void moveLeft() {
        moveLeft.Execute();
    }

    private void moveRight() {
        moveRight.Execute();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
