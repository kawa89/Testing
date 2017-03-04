package sda.testing.presenter;

import sda.testing.Constants;
import sda.testing.Formatter;
import sda.testing.R;
import sda.testing.mvpview.CalculatorMvpView;

@SuppressWarnings("DefaultFileTemplate")
public class CalculatorPresenter implements AbstractPresenter<CalculatorMvpView> {

    private CalculatorMvpView calculatorMvpView;

    private String displayedValue;
    private String lastKey;
    private String lastOperation;

    private boolean isFirstOperation;
    private boolean resetValue;
    private double baseValue;
    private double secondValue;

    private void resetValueIfNeeded() {
        if (resetValue) {
            displayedValue = "0";
        }

        resetValue = false;
    }

    public void handleReset() {
        baseValue = 0;
        secondValue = 0;
        resetValue = false;
        lastKey = "";
        lastOperation = "";
        displayedValue = "";
        isFirstOperation = true;

        setValue("0");
        calculatorMvpView.setFormula("");
    }

    public void setValue(String value) {
        calculatorMvpView.setValue(value);
        displayedValue = value;
    }

    String getFormula() {
        final String first = Formatter.doubleToString(baseValue);
        final String second = Formatter.doubleToString(secondValue);
        final String sign = getSign(lastOperation);

        if (sign.equals("√")) {
            return (sign + first);
        } else if (!sign.isEmpty()) {
            return (first + sign + second);
        }
        return first;
    }

    void addDigit(int number) {
        final String newValue = formatString(getDisplayedNumber() + number);
        setValue(newValue);
    }

    private String formatString(String str) {
        if (str.contains(".")) {
            return str;
        }

        final double doubleValue = Formatter.stringToDouble(str);
        return Formatter.doubleToString(doubleValue);
    }

    private void updateResult(double value) {
        setValue(Formatter.doubleToString(value));
        baseValue = value;
    }

    String getDisplayedNumber() {
        return displayedValue;
    }

    private double getDisplayedNumberAsDouble() {
        return Formatter.stringToDouble(getDisplayedNumber());
    }

    void handleResult() {
        secondValue = getDisplayedNumberAsDouble();
        calculateResult();
        baseValue = getDisplayedNumberAsDouble();
    }

    private void calculateResult() {
        if (!isFirstOperation) {
            calculatorMvpView.setFormula(getFormula());
        }

        switch (lastOperation) {
            case Constants.PLUS:
                updateResult(baseValue + secondValue);
                break;
            case Constants.MINUS:
                updateResult(baseValue - secondValue);
                break;
            case Constants.MULTIPLY:
                updateResult(baseValue * secondValue);
                break;
            case Constants.DIVIDE:
                divideNumbers();
                break;
            case Constants.MODULO:
                moduloNumbers();
                break;
            case Constants.POWER:
                powerNumbers();
                break;
            case Constants.ROOT:
                updateResult(Math.sqrt(baseValue));
                break;
            default:
                break;
        }
        isFirstOperation = false;
    }

    private void divideNumbers() {
        double resultValue = 0;
        if (secondValue != 0) {
            resultValue = baseValue / secondValue;
        }

        updateResult(resultValue);
    }

    private void moduloNumbers() {
        double resultValue = 0;
        if (secondValue != 0) {
            resultValue = baseValue % secondValue;
        }

        updateResult(resultValue);
    }

    private void powerNumbers() {
        double resultValue = Math.pow(baseValue, secondValue);
        if (Double.isInfinite(resultValue) || Double.isNaN(resultValue)) {
            resultValue = 0;
        }
        updateResult(resultValue);
    }

    public void handleOperation(String operation) {
        if (lastKey.equals(Constants.DIGIT)) {
            handleResult();
        }

        resetValue = true;
        lastKey = operation;
        lastOperation = operation;

        if (operation.equals(Constants.ROOT)) {
            calculateResult();
        }
    }

    public void handleEquals() {
        if (lastKey.equals(Constants.EQUALS))
            calculateResult();

        if (!lastKey.equals(Constants.DIGIT))
            return;

        secondValue = getDisplayedNumberAsDouble();
        calculateResult();
        lastKey = Constants.EQUALS;
    }

    private void decimalClicked() {
        String value = getDisplayedNumber();
        if (!value.contains(".")) {
            value += ".";
        }
        setValue(value);
    }

    private void zeroClicked() {
        String value = getDisplayedNumber();
        if (!value.equals("0")) {
            addDigit(0);
        }
    }

    private String getSign(String operation) {
        switch (operation) {
            case Constants.PLUS:
                return "+";
            case Constants.MINUS:
                return "-";
            case Constants.MULTIPLY:
                return "*";
            case Constants.DIVIDE:
                return "/";
            case Constants.MODULO:
                return "%";
            case Constants.POWER:
                return "^";
            case Constants.ROOT:
                return "√";
        }
        return "";
    }

    public void numpadClicked(int id) {
        if (lastKey.equals(Constants.EQUALS)) {
            lastOperation = Constants.EQUALS;
        }
        lastKey = Constants.DIGIT;
        resetValueIfNeeded();

        switch (id) {
            case R.id.btn_decimal:
                decimalClicked();
                break;
            case R.id.btn_0:
                zeroClicked();
                break;
            case R.id.btn_1:
                addDigit(1);
                break;
            case R.id.btn_2:
                addDigit(2);
                break;
            case R.id.btn_3:
                addDigit(3);
                break;
            case R.id.btn_4:
                addDigit(4);
                break;
            case R.id.btn_5:
                addDigit(5);
                break;
            case R.id.btn_6:
                addDigit(6);
                break;
            case R.id.btn_7:
                addDigit(7);
                break;
            case R.id.btn_8:
                addDigit(8);
                break;
            case R.id.btn_9:
                addDigit(9);
                break;
            default:
                break;
        }
    }

    @Override
    public void attachView(CalculatorMvpView view) {
        this.calculatorMvpView = view;
    }

    @Override
    public void detachView() {
        this.calculatorMvpView = null;
    }
}
