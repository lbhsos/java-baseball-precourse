package baseball.status;

public enum ResultStatus {
    NOTHING("낫싱"),
    BOLL("볼"),
    STRIKE("스트라이크");

    private final String text;

    ResultStatus(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
