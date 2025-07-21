package org.example.exception;

public class WrongCategoryException extends Exception{
    public WrongCategoryException(String category) {
        super("Ошибка: неизвестная категория \'" + category + "\'");
    }
}
