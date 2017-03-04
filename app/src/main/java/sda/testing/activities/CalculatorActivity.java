package sda.testing.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.grantland.widget.AutofitHelper;
import sda.testing.Config;
import sda.testing.Constants;
import sda.testing.R;
import sda.testing.mvpview.CalculatorMvpView;
import sda.testing.presenter.CalculatorPresenter;

public class CalculatorActivity extends AppCompatActivity implements CalculatorMvpView {

    @BindView(R.id.result)
    TextView result;
    @BindView(R.id.formula)
    TextView formula;

    CalculatorPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        AutofitHelper.create(result);
        AutofitHelper.create(formula);

        presenter = new CalculatorPresenter();
        presenter.attachView(this);
        presenter.handleReset();
    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        Config.newInstance(getApplicationContext()).setIsFirstRun(false);
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                startActivity(new Intent(this, AboutActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @OnClick(R.id.btn_plus)
    public void plusClicked() {
        presenter.handleOperation(Constants.PLUS);
    }

    @OnClick(R.id.btn_minus)
    public void minusClicked() {
        presenter.handleOperation(Constants.MINUS);
    }

    @OnClick(R.id.btn_multiply)
    public void multiplyClicked() {
        presenter.handleOperation(Constants.MULTIPLY);
    }

    @OnClick(R.id.btn_divide)
    public void divideClicked() {
        presenter.handleOperation(Constants.DIVIDE);
    }

    @OnClick(R.id.btn_modulo)
    public void moduloClicked() {
        presenter.handleOperation(Constants.MODULO);
    }

    @OnClick(R.id.btn_power)
    public void powerClicked() {
        presenter.handleOperation(Constants.POWER);
    }

    @OnClick(R.id.btn_root)
    public void rootClicked() {
        presenter.handleOperation(Constants.ROOT);
    }

    @OnClick(R.id.btn_reset)
    public void clearLongClicked() {
        presenter.handleReset();
    }

    @OnClick(R.id.btn_equals)
    public void equalsClicked() {
        presenter.handleEquals();
    }

    @OnClick({R.id.btn_decimal, R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8,
            R.id.btn_9})
    public void numpadClick(View view) {
        presenter.numpadClicked(view.getId());
    }

    @Override
    public void setValue(String value) {
        result.setText(value);
    }

    @Override
    public void setFormula(String value) {
        formula.setText(value);
    }

    @Override
    public Context getMyContext() {
        return this;
    }
}
