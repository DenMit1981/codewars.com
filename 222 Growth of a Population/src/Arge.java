//In a small town, the population at the beginning of the year is p0 = 1000 people. The population regularly increases
//by 2 percent per year, moreover, more than 50 new residents come to the town every year. How many years will it take
//for the town to have a population greater than or equal to p = 1200 residents?
//At the end of the first year there will be:
//1000 + 1000 * 0.02 + 50 => 1070 residents
//At the end of the 2nd year there will be:
//1070 + 1070 * 0.02 + 50 => 1141 residents (** the number of residents is an integer **)
//At the end of the 3rd year there will be:
//1141 + 1141 * 0.02 + 50 => 1213
//This will take a whole 3 years.
//More common parameters:
//p0, percent, aug (residents moving in or out each year), p (population equal to or greater than)
//the nb_year function should return the n integer years needed to get a population greater than or equal to p.
//aug is an integer, percent is a positive or zero floating point number, p0 and p are positive integers (> 0)
//Examples:
//nb_year(1500, 5, 100, 5000) -> 15
//nb_year(1500000, 2.5, 10000, 2000000) -> 10
//Note:
//Remember to convert the percent parameter to a percentage value in the body of your function: if the percent parameter
//is 2, you need to convert it to 0.02.
//There are no fractions of people. At the end of each year, the population is a whole number: 252.8 people rounded up
//to 252 people.

public class Arge {
    public static void main(String[] args) {
        System.out.println(nbYear(1000, 2, 50, 1200)); //3
        System.out.println(nbYear(1500, 5, 100, 5000)); //15
        System.out.println(nbYear(1500000, 2.5, 10000, 2000000)); //10
        System.out.println(nbYear(1500000, 0.25, 1000, 2000000)); //94

        System.out.println(getFirstYearPopulation(1000, 2, 50)); //1070
    }

    public static int nbYear(int p0, double percent, int aug, int p) {
        int count = 1;
        int population = getFirstYearPopulation(p0, percent, aug);

        while (population < p) {
            population = getFirstYearPopulation(population, percent, aug);
            count++;
        }

        return count;
    }

    private static int getFirstYearPopulation(int p0, double percent, int aug) {
        return (int) (p0 + p0 * (percent / 100) + aug);
    }
}
