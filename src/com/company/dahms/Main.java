package com.company.dahms;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, ArrayList<Integer>> cityTemp = new TreeMap<>();

        userInput(cityTemp);

        /*
        Some things involved in this block of code are outside of my current understanding.
        As such, putting them in a method changes their behavior, so I have to leave the rest in main.
        */
        cityTemp.forEach((key, value) -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Please enter the high temperature for day " + (i + 1) + " in " + key);
                Integer g = input.nextInt();
                cityTemp.get(key).add(g);
            }
        });

        cityTemp.forEach((key, value) -> System.out.println(key + ": " + math(value)));


    }

    public static void userInput(Map cityTemp){
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("Please enter the name of a city. Type END to continue");
            String city = input.next();
            if (city.equals("END")){
                break;
            }else{
                cityTemp.put(city, new ArrayList<>());
            }
        }
    }



    public static double math(ArrayList<Integer> numbers) {
        OptionalDouble average = numbers
                .stream()
                .mapToDouble(a -> a)
                .average();
        return average.isPresent() ? average.getAsDouble() : 0;
    }

}
