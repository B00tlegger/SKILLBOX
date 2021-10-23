public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius) {
        double s;
        double radiusabs = Math.abs(radius);
        s = Math.PI * Math.pow(radiusabs , 2);
        return s;
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius) {
        double v;
        double radiusabs = Math.abs(radius);
        v = (4 * Math.PI * Math.pow(radiusabs , 3)) / 3;
        return v;
    }

    public static boolean isTrianglePossible(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTrianglePossible, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {
        if( isTrianglePossible(a, b, c)) {
            double s;
            double p = (a + b + c) / 2;
            s = Math.sqrt(p * (p - a) * (p - c) * (p - b));
            return s;
        } else {
            return -1.0;
        }
    }
}
