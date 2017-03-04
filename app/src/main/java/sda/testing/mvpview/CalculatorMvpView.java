package sda.testing.mvpview;

@SuppressWarnings("DefaultFileTemplate")
public interface CalculatorMvpView extends AbstractMvpView {
    void setValue(String value);

    void setFormula(String value);
}
