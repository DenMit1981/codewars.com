//You are writing code to control traffic lights in your city. You need a function to handle each change from
//green to yellow to red and then back to green.
//Complete a function that takes a string as an argument representing the current state of the light,
//and returns a string representing the state the light should change to.
//For example, when the input is green, the output should be yellow.

public class TrafficLights {
    public static void main(String[] args) {
        System.out.println(updateLight("red"));
        System.out.println(updateLight("green"));
        System.out.println(updateLight("yellow"));
    }

    public static String updateLight(String current) {
        switch (current) {
            case "red":
                return "green";
            case "green":
                return "yellow";
            case "yellow":
                return "red";
        }
        return "";
    }
}
