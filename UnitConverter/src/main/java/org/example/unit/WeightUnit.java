package org.example.unit;

import org.example.exception.WrongUnitException;

public enum WeightUnit {
    KILOGRAM("kilogram") {
        @Override
        public double getFactor(WeightUnit unit) {
            switch (unit) {
                case OUNCE -> {
                    return 35.27;
                }
                case POUND -> {
                    return 2.2;
                }
                default -> {
                    return 1;
                }
            }
        }
    },
    POUND("pound") {
        @Override
        public double getFactor(WeightUnit unit) {
            switch (unit) {
                case KILOGRAM -> {
                    return 0.453592;
                }
                case OUNCE -> {
                    return 16;
                }
                default -> {
                    return 1;
                }
            }
        }
    },
    OUNCE("ounce") {
        @Override
        public double getFactor(WeightUnit unit) {
            switch (unit) {
                case KILOGRAM -> {
                    return 0.02835;
                }
                case POUND -> {
                    return 0.0625;
                }
                default -> {
                    return 1;
                }
            }
        }
    };

    private String code;

    WeightUnit(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public abstract double getFactor(WeightUnit unit);

    public static WeightUnit getByCode(String code) throws WrongUnitException {
        for (WeightUnit val: WeightUnit.values()) {
            if (val.code.equals(code)) {
                return val;
            }
        }

        throw new WrongUnitException("weight", code);
    }

}
