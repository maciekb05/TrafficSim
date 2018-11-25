package sample;

import javafx.scene.shape.Line;

enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST
}

public class Street {
    private Street left;
    private Street right;
    private Street straight;
    private Integer speedLimit;
    private Point start;
    private Point end;
    private Line line;

    public Line getLine() {
        return line;
    }

    public Direction getDirection() {
        return direction;
    }

    private Direction direction;

    public Street(Point start, Point end, Direction direction) {
        this.start = start;
        this.end = end;
        this.line = new Line(start.getX(), start.getY(), end.getX(), end.getY());
        this.direction = direction;
    }

    public void setLeft(Street left) {
        this.left = left;
    }

    public void setRight(Street right) {
        this.right = right;
    }

    public void setStraight(Street straight) {
        this.straight = straight;
    }

    public void setSpeedLimit(Integer speedLimit) {
        this.speedLimit = speedLimit;
    }
}
