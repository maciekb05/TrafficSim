package sample;

public class Direction {
    private Double x;
    private Double y;

    public Direction(Point start, Point end){
        double a = (double) end.getX() - start.getX();
        double b = (double) end.getY() - start.getY();

        double x = Math.sqrt(1/((Math.pow(a,2)+Math.pow(b,2))));

        this.x = a*x;
        this.y = b*x;

    }

    public Double getX(){
        return this.x;
    }
    public Double getY(){
        return this.y;
    }
}
