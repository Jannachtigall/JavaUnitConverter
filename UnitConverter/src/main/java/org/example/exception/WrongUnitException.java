package org.example.exception;

public class WrongUnitException extends Exception{
    public WrongUnitException(String category, String unit) {
        super("Ошибка: для категории " + category + " не определена единица измерения \'" + unit + "\'.");
    }
}
