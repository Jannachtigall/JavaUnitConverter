package org.example;

import org.example.converter.LengthConverter;
import org.example.converter.TemperatureConverter;
import org.example.converter.WeightConverter;
import org.example.exception.ConversionException;
import org.example.exception.WrongCategoryException;
import org.example.exception.WrongUnitException;
import org.example.unit.LengthUnit;
import org.example.unit.TemperatureUnit;
import org.example.unit.WeightUnit;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    static Scanner scanner;
    static LengthConverter lengthConverter;
    static TemperatureConverter temperatureConverter;
    static WeightConverter weightConverter;

    static {
        scanner = new Scanner(System.in);
        lengthConverter = new LengthConverter();
        temperatureConverter = new TemperatureConverter();
        weightConverter = new WeightConverter();
    }

    public static void main(String[] args) {
        System.out.println("Пожалуйста, введите строку из четырёх слов с маленькой буквы на английском языке: категория, вещественное число, единица измерения числа, единица измерения для конвертации.");
        System.out.println("Чтобы выйти напечатайте \'exit\':");
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                System.out.println("До свидания!");
                break;
            }
            convertData(input);
        }
    }

    static void convertData(String data) {
        String[] dataArray = data.split("\\s");

        if (dataArray.length != 4) {
            throw new RuntimeException();
        }

        String category = dataArray[0];

        double value;
        try {
            value = Double.parseDouble(dataArray[1]);
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат числа!\n");
            return;
        }

        double result;

        switch (category) {
            case "length" -> {
                try {
                    LengthUnit firstUnit = LengthUnit.getByCode(dataArray[2]);
                    LengthUnit secondUnit = LengthUnit.getByCode(dataArray[3]);
                    result = lengthConverter.convert(value, firstUnit, secondUnit);
                    System.out.println(getAnswer(value, result, firstUnit, secondUnit));
                } catch (WrongUnitException | ConversionException e) {
                    System.out.println(e.getMessage() + '\n');
                }
            }
            case "temperature" -> {
                try {
                    TemperatureUnit firstUnit = TemperatureUnit.getByCode(dataArray[2]);
                    TemperatureUnit secondUnit = TemperatureUnit.getByCode(dataArray[3]);
                    result = temperatureConverter.convert(value, firstUnit, secondUnit);
                    System.out.println(getAnswer(value, result, firstUnit, secondUnit));
                } catch (WrongUnitException e) {
                    System.out.println(e.getMessage() + '\n');
                }
            }
            case "weight" -> {
                try {
                    WeightUnit firstUnit = WeightUnit.getByCode(dataArray[2]);
                    WeightUnit secondUnit = WeightUnit.getByCode(dataArray[3]);
                    result = weightConverter.convert(value, firstUnit, secondUnit);
                    System.out.println(getAnswer(value, result, firstUnit, secondUnit));
                } catch (WrongUnitException | ConversionException e) {
                    System.out.println(e.getMessage() + '\n');
                }
            }
            default -> {
                try {
                    throw new WrongCategoryException(category);
                } catch (WrongCategoryException e) {
                    System.out.println(e.getMessage() + '\n');
                }
            }
        }
    }

    static String getAnswer(double value,
                            double result,
                            Enum firstUnit,
                            Enum secondUnit) {
        return String.format(Locale.US, "%.2f", value) + " "
                + firstUnit.name() + " = "
                + String.format(Locale.US, "%.2f", result) + " "
                + secondUnit.name() + '\n';
    }
}