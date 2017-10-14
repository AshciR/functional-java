import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.groupingBy;

public class Main{

    private static List<Dish> menu = Arrays.asList (
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries",true, 530, Dish.Type.OTHER),
            new Dish("rice",true, 350, Dish.Type.OTHER),
            new Dish("season fruit",true, 120, Dish.Type.OTHER),
            new Dish("pizza",true, 550, Dish.Type.OTHER),
            new Dish("prawns",false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));

    public static void main(String[] args){
        Map<Dish.Type, List<Dish>> dishesByType = menu.stream()
                                                      .collect(groupingBy(Dish::getType));

        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream()
                                                                 .collect(groupingBy(calculateCaloricLevel()));

        System.out.println("-- Printing the Dishes by type --");
        printMapValues(dishesByType);

        System.out.println("\n-- Printing the Dishes by caloric level --");
        printMapValues(dishesByCaloricLevel);

    }

    private static <K,V> void printMapValues(Map<K,V> map){
        map.forEach((key, value) -> System.out.println("Key: " + key + " | " + "Value: " + value));
    }

    private static Function<Dish, CaloricLevel> calculateCaloricLevel(){
        return (dish) -> {
            if(dish.getCalories() <= 400) return CaloricLevel.DIET;
            else if(dish.getCalories() <= 700) return CaloricLevel.NORMAL;
            else return CaloricLevel.FAT;
        };
    }

    private enum CaloricLevel {DIET, NORMAL, FAT};

}
