package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;
public class Main {
    public static Map<Integer, String> getData(File file) {
        FileInputStream fis;
        try {
            fis = new FileInputStream(new File(file.toURI()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Workbook workbook;
        try {
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Sheet sheet = workbook.getSheetAt(0);
        var data = new HashMap<Integer, String>();
        int i = 0;
        for (Row row : sheet) {i++;
            for (Cell cell : row) {
                data.put(i, String.valueOf(cell));
            }
        }
        return  data;
    }
    public static void isFound(String str) {
        boolean isHere = false;
        Map<Integer, String> map =  getData(new File("src/main/resources/name_java.xlsx"));
        for (String key : map.values()){
            if (key.contains(str)){
                isHere = true;
                break;
            }
        }
        if (isHere) {
            System.out.println("Номер найден");
        }else {
            System.out.println("Номер не найден");
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter 3 digit below:");
        Scanner scanner = new Scanner(System.in);
        String key  = scanner.nextLine();
        isFound(key);
    }
}
