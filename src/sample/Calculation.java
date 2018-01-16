package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Calculation {
    static Double deltaValue, deltaAlfaValue, deltaBetaValue, alfa, beta;

    private static Double sumSquareElements(List<Double> elements) {
        Double sum = 0.0;
        Double valSquare;
        for (Double val : elements
                ) {
            valSquare = Math.pow(val, 2);
            sum += valSquare;
        }
        return sum;
    }

    public static Double sumElements(List<Double> elements) {
        Double sum = 0.0;
        for (Double val : elements) {
            sum += val;
        }
        return sum;
    }

    public static Double sumMultipliedPair(List<Double> xValues, List<Double> yValues) {
        Double result = 0.0;
        Double[] xArray = xValues.toArray(new Double[xValues.size()]);
        Double[] yArray = yValues.toArray(new Double[yValues.size()]);
        for (int i = 0; i < xArray.length; i++)
            result += xArray[i] * yArray[i];
        return result;
    }

    public static List<Double> retriveInputData(String values) {
        List<Double> parsedList = new ArrayList<>();
        List<String> parsedStringList = Arrays.asList(values.split(", "));
        Double currentValue;

        for (String s : parsedStringList) {
            currentValue = Double.valueOf(s);
            parsedList.add(currentValue);
        }
        return parsedList;
    }

    static boolean isListOfDouble(String values) {
        List<String> parsedStringList = Arrays.asList(values.split(", "));

        for (String s : parsedStringList) {
            try {
                Double.parseDouble(s);
            } catch (NumberFormatException e) {

                return false;
            }
        }
        return true;
    }

    static Double delta(List<Double> values) {
        return values.size() * sumSquareElements(values) - Math.pow(sumElements(values), 2);
    }

    static void LinearCalculate(String x, String y) {
        List<Double> xValues = retriveInputData(x);
        List<Double> yValues = retriveInputData(y);
        Double sumSquareX = sumSquareElements(xValues);
        Double sumY = sumElements(yValues);
        Double sumX = sumElements(xValues);
        Double sumPair = sumMultipliedPair(xValues, yValues);
        deltaValue = delta(xValues);
        deltaAlfaValue = sumSquareX*sumY-sumX*sumPair;
        deltaBetaValue = xValues.size()*sumPair-sumX*sumY;
        alfa = deltaAlfaValue/deltaValue;
        beta = deltaBetaValue/deltaValue;
    }

    private static TreeSet getSort (List<Double> list){
        TreeSet set = new TreeSet(list);
        return set;
    }
    public static void fillCorellationTable(String x, String y) {
        TreeSet<Double> xx = getSort(retriveInputData(x));
        TreeSet<Double> yy = getSort(retriveInputData(y));


    }

    static void regressionCalculate() {

    }

}
