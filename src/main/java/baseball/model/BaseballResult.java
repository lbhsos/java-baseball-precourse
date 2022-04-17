package baseball.model;

import baseball.status.ResultStatus;

public class BaseballResult {

    private int strikeCount;
    private int ballCount;

    private static final int BASEBALL_NUM = 3;

    public BaseballResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public boolean isAnswer() {
        if (this.strikeCount == BASEBALL_NUM) {
            return true;
        }
        return false;
    }

    public String getResultText() {
        StringBuilder sb = new StringBuilder();
        if (strikeCount == 0 && ballCount == 0) {
            ResultStatus nothing = ResultStatus.NOTHING;
            sb.append(nothing.getText());
            return sb.toString();
        }
        appendBollResult(sb);
        appendStrikeResult(sb);
        return sb.toString();
    }

    private void appendBollResult(StringBuilder sb) {
        if (strikeCount == 3) {
            return;
        }
        ResultStatus ball = ResultStatus.BALL;
        sb.append(ballCount + ball.getText());
        sb.append(" ");
    }

    private void appendStrikeResult(StringBuilder sb) {
        if (ballCount == 3) {
            return;
        }
        ResultStatus strike = ResultStatus.STRIKE;
        sb.append(strikeCount + strike.getText());
    }
}
