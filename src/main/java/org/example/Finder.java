package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Finder {
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
        for (Row row : sheet) {
            i++;
            for (Cell cell : row) {
                data.put(i, String.valueOf(cell));
            }
        }
        return  data;
    }

    //Поиск строки по стринге
    public boolean isFound(String str) {
        Map<Integer, String> map =  getData(new File("src/main/resources/name_java.xlsx"));
        for (String key : map.values()){
            if (key.contains(str)){
                return true;
            }
        }
        return false;
    }

    // Печать ответа
    public String printAnswer(String str) {
        if (str.length() != 3){
            return "Инвалидная строка";
        }
        String stringToSearch = str.replace(" ", ""); // Если захочется поискать через пробелы
        if (isFound(stringToSearch)){
            return ("номер найден");
        }
       return ("номер не найден");
    }
}
