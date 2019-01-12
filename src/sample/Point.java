package sample;

//punkt na podstawie ktorego rozrozniamy miejsca na panelu
class Point {
    private Integer x;
    private Integer y;

    Point(Integer x, Integer y) {
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
