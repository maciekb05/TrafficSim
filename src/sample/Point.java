package sample;

class Point {
    private Integer x;
    private Integer y;
    private Integer multiplayer = 25;

    Point(Integer x, Integer y) {
        this.x = x * this.multiplayer;
        this.y = y * this.multiplayer;
    }
    Point(Integer x, Integer y, boolean withoutScaling) {
        this.x = x;
        this.y = y;
    }

    Integer getX() {
        return x;
    }

    Integer getY() {
        return y;
    }
}
