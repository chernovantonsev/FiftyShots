package ru.antonc.fiftyshots.ui.base;

import android.os.Bundle;

public interface IBasePresenter<V extends IBaseView> {

    void attachView(V view);

    void detachView();

    void onCreate(Bundle savedInstanceState);
}
