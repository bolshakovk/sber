package org.example;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("Введи 3 числа:");
        Scanner scanner = new Scanner(System.in);
        Finder finder = new Finder();
        String key  = scanner.nextLine();
        System.out.println(finder.printAnswer(key));
    }
}
