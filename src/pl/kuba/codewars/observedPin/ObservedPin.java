package pl.kuba.codewars.observedPin;

import java.util.*;

public class ObservedPin {
    private static final Map<String, List<String>> neighbours = new HashMap<>() {
        {
            put("0", Arrays.asList("8"));
            put("1", Arrays.asList("2", "4"));
            put("2", Arrays.asList("1", "3", "5"));
            put("3", Arrays.asList("2", "6"));
            put("4", Arrays.asList("1", "5", "7"));
            put("5", Arrays.asList("2", "4", "6", "8"));
            put("6", Arrays.asList("3", "5", "9"));
            put("7", Arrays.asList("4", "8"));
            put("8", Arrays.asList("5", "7", "9", "0"));
            put("9", Arrays.asList("6", "8"));
        }
    };

    public static List<String> getPINs(String observed) {
        Set<String> result = new HashSet<>(variate(new HashSet<>(Collections.singletonList(observed)), 0));
        return new ArrayList<>(result);
    }

    private static Set<String> variate(Set<String> pins, int index) {
        int size = 0;
        Set<String> result = new HashSet<>();
        for (String pin : pins) {
            result.add(pin);
            size = pin.length();
            List<String> neighbour = neighbours.get(String.valueOf(pin.charAt(index)));
            for (String s : neighbour) {
                StringBuilder a = new StringBuilder(pin);
                result.add(a.replace(index, index + 1, s).toString());
            }
        }

        return index == size - 1 ? result : variate(result, index + 1);
    }

}
