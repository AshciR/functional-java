import java.util.function.DoubleUnaryOperator;

public class CurryExamples{
    public static void main(String[] args){
        DoubleUnaryOperator convertCtoF = curriedConverter(9.0 / 5, 32);
        DoubleUnaryOperator convertUSDtoGBP = curriedConverter(0.6, 0);
        DoubleUnaryOperator convertKmToMi = curriedConverter(0.6214, 0);

        System.out.println("100 degrees C = " + convertCtoF.applyAsDouble(100) + " degrees F");
        System.out.println("100 USD = " + convertUSDtoGBP.applyAsDouble(100) + " pounds");
        System.out.println("100 kilometers = " + convertKmToMi.applyAsDouble(100) + " miles");

    }

    private static double converter(double x, double f, double b){
        return x * f + b;
    }

    private static DoubleUnaryOperator curriedConverter(double f, double b){
        return (double x) ->  x * f + b;
    }
}
