//In John's car, the GPS records the distance traveled from the starting point every s seconds (distances are measured
//in arbitrary but consistent units). For example, below is the part of the record with s = 15:
//x = [0.0, 0.19, 0.5, 0.75, 1.0, 1.25, 1.5, 1.75, 2.0, 2.25]
//Partitions:
//0.0-0.19, 0.19-0.5, 0.5-0.75, 0.75-1.0, 1.0-1.25, 1.25-1.50, 1.5-1.75, 1.75-2.0, 2.0-2.25
//We can calculate John's average hourly rate on each section, and we get:
//[45.6, 74.4, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0]
//Given s and x the task is to return as an integer the *half* of the maximum average speed per hour obtained on
//sections x. If the length of x is less than or equal to 1, return 0 since the car was not moving.
//Example:
//with the above data, your gps(s, x) function should return 74
//Note
//With floats, it may happen that the results depend on the order of operations. To calculate the hourly speed, you can use:
//(3600 * delta_distance) / s.

public class GpsSpeed {
    public static void main(String[] args) {
        System.out.println(gps(15, new double[]{0.0, 0.19, 0.5, 0.75, 1.0, 1.25, 1.5, 1.75, 2.0, 2.25})); //74
        System.out.println((gps(20, new double[]{0.0, 0.23, 0.46, 0.69, 0.92, 1.15, 1.38, 1.61}))); //41
        System.out.println((gps(12, new double[]{0.0, 0.11, 0.22, 0.33, 0.44, 0.65, 1.08, 1.26, 1.68, 1.89, 2.1, 2.31, 2.52, 3.25}))); //219
        System.out.println((gps(20, new double[]{0.0, 0.18, 0.36, 0.54, 0.72, 1.05, 1.26, 1.47, 1.92, 2.16, 2.4, 2.64, 2.88, 3.12, 3.36, 3.6, 3.84}))); //80
    }

    public static int gps(int s, double[] x) {
        if (x.length <= 1) {
            return 0;
        }

        double[] avg_speeds = new double[x.length - 1];
        int max_avg_speed = 0;
        int j = 0;

        for (int i = 0; i < x.length - 1; i++) {
            double delta_distance = x[i + 1] - x[i];
            avg_speeds[j] = (3600 * delta_distance) / s;
            j++;
        }

        for (double avg_speed : avg_speeds) {
            if (avg_speed > max_avg_speed) {
                max_avg_speed = (int) avg_speed;
            }
        }
        return max_avg_speed;
    }
}
