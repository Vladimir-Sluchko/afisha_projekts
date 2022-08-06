package by.itacademy.classifier_service.service.dto.error;

public class FieldErrorForMultiple {
    private String message;
    private String field;

    public FieldErrorForMultiple(String field, String message) {
        this.message = message;
        this.field = field;
    }

    public FieldErrorForMultiple() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
