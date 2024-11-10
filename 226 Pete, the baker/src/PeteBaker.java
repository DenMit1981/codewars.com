//Pete loves to bake cakes. He has several recipes and ingredients. Unfortunately, he is not good at math.
//Can you help him find out how many cakes he can bake using his recipes?
//Write a function cakes() that takes a recipe (an object) and available ingredients (also an object) and returns the
//maximum number of cakes Pete can bake (an integer). To keep things simple, there are no units of measurement
//(e.g. 1 pound of flour or 200 grams of sugar is just 1 or 200). Ingredients that are not in the objects can be treated as 0.
//Examples:
////should return 2
//cakes({flour: 500, sugar: 200, eggs: 1}, {flour: 1200, sugar: 1200, eggs: 5, milk: 200});
//// should return 0
//cakes({apples: 3, flour: 300, sugar: 150, milk: 100, butter: 100}, {sugar: 500, flour: 2000, milk: 2000});

import java.util.*;
import java.util.stream.Collectors;

public class PeteBaker {
    public static void main(String[] args) {
        System.out.println(cakes(Map.of(
                        "flour", 500,
                        "sugar", 200,
                        "eggs", 1),
                Map.of(
                        "flour", 1200,
                        "sugar", 1200,
                        "eggs", 5,
                        "milk", 200)));

        System.out.println(cakes(Map.of(
                        "flour", 500,
                        "sugar", 200,
                        "eggs", 1,
                        "cinnamon", 300),
                Map.of(
                        "flour", 200,
                        "sugar", 1200,
                        "eggs", 5,
                        "milk", 200)));

        System.out.println(cakes(Map.of(),
                Map.of(
                        "flour", 1200,
                        "sugar", 1200,
                        "eggs", 5,
                        "milk", 200)));
    }

    public static int cakes(Map<String, Integer> recipe, Map<String, Integer> available) {
        if (recipe.isEmpty() || available.isEmpty()) {
            return 0;
        }

        String[] recipeArr = getListFromMap(recipe).split(" ");
        String[] availableArr = getListFromMap(available).split(" ");

        System.out.println(Arrays.stream(recipeArr)
                .map(el -> String.valueOf(getNumberOfOneIngredient(el, availableArr)))
                .collect(Collectors.joining(", ")));

        return Arrays.stream(recipeArr)
                .map(el -> getNumberOfOneIngredient(el, availableArr))
                .min(Integer::compare)
                .get();
    }

    private static String getListFromMap(Map<String, Integer> map) {
        TreeMap<String, Integer> sortMap = new TreeMap<>(map);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> pair : sortMap.entrySet()) {
            sb.append(pair.getKey()).append("-").append(pair.getValue()).append(" ");
        }
        return sb.toString();
    }

    private static int getNumberOfOneIngredient(String product, String[] products) {
        if (!isRecipeContainsProduct(product, products)) {
            return 0;
        }
        return Integer.parseInt(Arrays.stream(products).filter(el -> getPartOfWord(el).equals(getPartOfWord(product)))
                .map(el -> getQuantityInWord(el) >= getQuantityInWord(product) ?
                        String.valueOf(getQuantityInWord(el) / getQuantityInWord(product)) : "0")
                .collect(Collectors.joining()));
    }

    private static boolean isRecipeContainsProduct(String product, String[] products) {
        return Arrays.stream(products).anyMatch(el -> getPartOfWord(el).equals(getPartOfWord(product)));
    }

    private static Integer getQuantityInWord(String word) {
        return Integer.parseInt(word.substring(word.indexOf('-') + 1));
    }

    private static String getPartOfWord(String word) {
        return word.substring(0, word.indexOf('-'));
    }
}
