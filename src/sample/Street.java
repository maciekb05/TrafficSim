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

    Line getLine() {
        return line;
    }

    Direction getDirection() {
        return direction;
    }

    private Direction direction;

    Street(Point start, Point end, Direction direction) {
        this.start = start;
        this.end = end;
        this.line = new Line(start.getX(), start.getY(), end.getX(), end.getY());
        this.direction = direction;
    }

    void setLeft(Street left) {
        this.left = left;
    }

    void setRight(Street right) {
        this.right = right;
    }

    void setStraight(Street straight) {
        this.straight = straight;
    }

    public void setSpeedLimit(Integer speedLimit) {
        this.speedLimit = speedLimit;
    }
}
