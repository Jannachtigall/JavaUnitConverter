package org.example.exception;

public class ConversionException extends Exception{
    public ConversionException(String category) {
        super("Ошибка: невозможно конвертировать отрицательное значение для категории " + category + "!");
    }
}
