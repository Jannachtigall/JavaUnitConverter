package org.example.unit;

import org.example.exception.WrongUnitException;

public enum TemperatureUnit {
    CELSIUS("celsius") {
        @Override
        public double getAction(double value, TemperatureUnit unit) {
            switch (unit) {
                case KELVIN -> {
                    return value + 273.15;
                }
                case FAHRENHEIT -> {
                    return value * 1.8 + 32;
                }
                default -> {
                    return value;
                }
            }
        }
    },
    FAHRENHEIT("farenheit") {
        @Override
        public double getAction(double value, TemperatureUnit unit) {
            switch (unit) {
                case CELSIUS -> {
                    return (value - 32) / 1.8;
                }
                case KELVIN -> {
                    return (value + 459.67) / 1.8;
                }
                default -> {
                    return 1;
                }
            }
        }
    },
    KELVIN("kelvin") {
        @Override
        public double getAction(double value, TemperatureUnit unit) {
            switch (unit) {
                case CELSIUS -> {
                    return value - 273.15;
                }
                case FAHRENHEIT -> {
                    return value * 1.8 - 459.67;
                }
                default -> {
                    return 1;
                }
            }
        }
    };

    private String code;

    TemperatureUnit(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public abstract double getAction(double value, TemperatureUnit unit);

    public static TemperatureUnit getByCode(String code) throws WrongUnitException {
        for (TemperatureUnit val: TemperatureUnit.values()) {
            if (val.code.equals(code)) {
                return val;
            }
        }

        throw new WrongUnitException("temperature", code);
    }
}
