package ch.zhaw.ads.solutions;

import ch.zhaw.ads.CommandExecutor;
import ch.zhaw.ads.Turtle;

public class SnowflakeServer implements CommandExecutor  {

    private double dist;
    private Turtle turtle;

    public SnowflakeServer() {
        this.dist = 0.7;
        this.turtle = new Turtle();
    }

    @Override
    public String execute(String command) {
        turtle.clear();
        snowflake(Integer.parseInt(command), dist);
        turtle.turn(90);
        snowflake(Integer.parseInt(command), dist);
        turtle.turn(90);
        snowflake(Integer.parseInt(command), dist);
        return turtle.getTrace();
    }

    private void snowflake(int stufe, double dist) {
        if (stufe == 0) {
            turtle.move(dist);
        } else {
            stufe --;
            dist = dist / 3;
            snowflake(stufe, dist);
            turtle.turn(60);
            snowflake(stufe, dist);
            turtle.turn(-120);
            snowflake(stufe, dist);
            turtle.turn(60);
            snowflake(stufe, dist);
        }

    }
}
