package designpatternsudemycourse.creational;

class Point{
    private double x,y;

    public Point(double a, double b){
        this.x=a;
        this.y=b;
    }

    public static Point newCartesionPoint(double a, double b){
        return new Point(a,b);
    }

    public static Point newPolarPoints(double a, double b){
        return new Point(a*Math.cos(b) , a*Math.sin(b));
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }
}

class PointFactory{
    public static Point newCartesionPoint(double a, double b){
        return new Point(a,b);
    }

    public static Point newPolarPoints(double a, double b){
        return new Point(a*Math.cos(b) , a*Math.sin(b));
    }
}

class Demo {

    public static void main(String[] args) {
        Point cartesionPoint = Point.newCartesionPoint(4,5);
        Point polarPoints = Point.newPolarPoints(4,5);
        System.out.println(cartesionPoint);
        System.out.println(polarPoints);
    }
}