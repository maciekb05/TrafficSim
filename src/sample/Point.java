package sample;

class Point {
    private Integer x;
    private Integer y;
    private Integer multiplayer = 25;

    Point(Integer x, Integer y) {
        this.x = x * this.multiplayer;
        this.y = y * this.multiplayer;
    }

    Integer getX() {
        return x;
    }

    Integer getY() {
        return y;
    }
}
