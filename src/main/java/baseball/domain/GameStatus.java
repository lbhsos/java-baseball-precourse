package baseball.domain;

public enum GameStatus {
    CONTINUE(1),
    EXIT(2);

    private final int value;

    GameStatus(int value) { this.value = value; }

    public int getValue() {return value;}
}
