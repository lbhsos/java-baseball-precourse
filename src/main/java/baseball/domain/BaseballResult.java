package baseball.domain;

public class BaseballResult {

    private int strikeCount;
    private int bollCount;

    private static final int BASEBALL_NUM = 3;

    public BaseballResult(int strikeCount, int bollCount) {
        this.strikeCount = strikeCount;
        this.bollCount = bollCount;
    }

    boolean isAnswer() {
        if (this.strikeCount == BASEBALL_NUM) {
            return true;
        }
        return false;
    }

    String printResult() {
        StringBuilder sb = new StringBuilder();
        if (strikeCount == 0 && bollCount == 0) {
            ResultStatus nothing = ResultStatus.NOTHING;
            sb.append(nothing.getText());
            return sb.toString();
        }
        ResultStatus boll = ResultStatus.BOLL;
        sb.append(bollCount + boll.getText());
        sb.append(" ");
        ResultStatus strike = ResultStatus.STRIKE;
        sb.append(strikeCount + strike.getText());
        return sb.toString();
    }
}
