package ru.antonc.fiftyshots.ui.base;

import android.os.Bundle;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import ru.antonc.fiftyshots.data.rest.ShotsService;

/**
 * Created by antonc on 21.02.2018.
 */

public abstract class BasePresenter<T extends IBaseView> implements IBasePresenter<T> {

    protected T mMvpView;

    protected CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @Inject
    protected ShotsService mShotsService;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        return;
    }

    @Override
    public void attachView(T mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void detachView() {
        undisposableAll();
        mMvpView = null;
    }

    public T getMvpView() {
        checkViewAttached();
        return mMvpView;
    }

    public void addDisposable(Disposable disposable) {
        mCompositeDisposable.add(disposable);
    }

    public void undisposable(Disposable disposable) {
        if (mCompositeDisposable.size() != 0) {
            if (!disposable.isDisposed()) {
                mCompositeDisposable.remove(disposable);
            }
        }
    }

    public void undisposableAll() {
        if (!mCompositeDisposable.isDisposed()) {
            mCompositeDisposable.clear();
            mCompositeDisposable.dispose();
        }
    }

    public void checkViewAttached() {
        if (mMvpView == null) throw new ViewNotAttachedException();
    }


    private static class ViewNotAttachedException extends RuntimeException {
        ViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }
}
