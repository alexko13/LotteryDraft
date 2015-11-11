package cc.lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hopper
{
    private List<Integer> balls;

    public Hopper ()
    {
        balls = new ArrayList<> ();

        for (int i = 1; i <= 42; i++)
        {
            balls.add (i);
        }
    }

    public Integer[] getWinner ()
    {
        Integer[] winningNums = new Integer[6];
        for (int i = 0; i < 6; i++)
        {
            Collections.shuffle (balls);
             winningNums[i] = balls.remove (0);
        }
        return winningNums;
    }
}