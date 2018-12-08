package sample;

import javafx.scene.shape.Line;


public class Street {
    private Street left = null;
    private Street right = null;
    private Street straight = null;
    private Integer speedLimit;
    private Point start;
    private Point end;
    private Line line;
    private Direction direction;

    Street(Point start, Point end) {
        this.start = start;
        this.end = end;
        this.line = new Line(start.getX(), start.getY(), end.getX(), end.getY());
        this.direction = new Direction(this.start, this.end);
    }

    public Street getLeft() {
        return left;
    }

    public void setLeft(Street left) {
        this.left = left;
    }

    public Street getRight() {
        return right;
    }

    public void setRight(Street right) {
        this.right = right;
    }

    public Street getStraight() {
        return straight;
    }

    public void setStraight(Street straight) {
        this.straight = straight;
    }

    public Integer getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(Integer speedLimit) {
        this.speedLimit = speedLimit;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
