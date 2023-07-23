package util;

public enum Grade {
    A("A", 4),
    B("B", 3),
    C("C", 2),
    D("D", 1),
    F("F", 0);

    private final String stringValue;
    private final int numericValue;

    Grade(String stringValue, int numericValue) {
        this.stringValue = stringValue;
        this.numericValue = numericValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public int getNumericValue() {
        return numericValue;
    }

    @Override
    public String toString() {
        return "Grade " + stringValue + " corresponds to numeric grade " + numericValue;
    }

    public static Grade getGradeByNumericValue(int numericValue) {
        for (Grade grade : values()) {
            if (grade.numericValue == numericValue) {
                return grade;
            }
        }
        return Grade.F;
    }

}
