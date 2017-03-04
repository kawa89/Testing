package sda.testing.presenter;

@SuppressWarnings("DefaultFileTemplate")
public interface AbstractPresenter<T> {

    void attachView(T view);

    void detachView();
}
