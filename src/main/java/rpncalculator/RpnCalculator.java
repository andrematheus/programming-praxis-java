package rpncalculator;

import java.util.Deque;
import java.util.LinkedList;
import java.util.function.Function;

class RpnCalculator {
    private Deque<Double> stack = new LinkedList<>();

    void evaluate(String input) {
        for (String token : input.split(" ")) {
            evaluateToken(token);
        }
    }

    private void evaluateToken(String token) {
        if ("+".equals(token)) {
            takeAndApply(2, xs -> xs[1] + xs[0]);
        } else if ("-".equals(token)) {
            takeAndApply(2, xs -> xs[1] - xs[0]);
        } else if ("*".equals(token)) {
            takeAndApply(2, xs -> xs[1] * xs[0]);
        } else if ("/".equals(token)) {
            takeAndApply(2, xs -> xs[1] / xs[0]);
        } else {
            Double operand = Double.parseDouble(token);
            stack.push(operand);
        }
    }

    private void takeAndApply(int howMuch, Function<Double[], Double> operator) {
        Double[] arr = new Double[howMuch];
        for (int i = 0; i < howMuch; i++) {
            arr[i] = stack.pop();
        }
        Double result = operator.apply(arr);
        stack.push(result);
    }

    Double top() {
        return stack.peek();
    }
}
