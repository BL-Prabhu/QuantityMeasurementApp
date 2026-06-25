package entity;

public class QuantityMeasurementEntity {

    private boolean result;
    private boolean error;
    private String message;

    public QuantityMeasurementEntity(boolean result, boolean error, String message) {
        this.result = result;
        this.error = error;
        this.message = message;
    }

    public boolean getResult() {
        return result;
    }

    public boolean hasError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}