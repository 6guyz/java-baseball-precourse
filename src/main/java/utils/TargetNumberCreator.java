package utils;

public class TargetNumberCreator {
    private String targetNumber;

    public TargetNumberCreator() {
        setTargetNumber();
    }

    public String getTargetNumber() {
        return this.targetNumber;
    }

    private void setTargetNumber() {
        int _targetNumber = (int)(Math.random() * 889) + 111;
        String targetNumber = Integer.toString(_targetNumber);
        this.targetNumber = targetNumber;
    }
}
