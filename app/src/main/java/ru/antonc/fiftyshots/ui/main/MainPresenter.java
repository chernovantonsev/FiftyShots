package ru.antonc.fiftyshots.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import sev.com.fiftyshots.R;
import ru.antonc.fiftyshots.data.db.ShotsDatabase;
import ru.antonc.fiftyshots.data.domain.Shot;
import ru.antonc.fiftyshots.di.qualifier.ApplicationContext;
import ru.antonc.fiftyshots.ui.base.BasePresenter;

import static ru.antonc.fiftyshots.app.Constants.NUMBER_OF_PAGES;
import static ru.antonc.fiftyshots.app.Constants.SHOTS_PER_PAGE;
import static ru.antonc.fiftyshots.app.Constants.SORT_RECENT;

/**
 * Created by antonc on 21.02.2018.
 */

public class MainPresenter extends BasePresenter<IMainContract.View> implements IMainContract.Presenter {

    private Context mContext;

    @Inject
    public MainPresenter(@ApplicationContext Context context) {
        this.mContext = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            getMvpView().initView();
        }

        getData();
    }

    @Override
    public void getData() {
        Disposable getShotsDisposable =
                mShotsService.fetchShots(NUMBER_OF_PAGES, SHOTS_PER_PAGE, SORT_RECENT)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(shotsList -> {

                                    saveShots(shotsList);
                                    getMvpView().setVisibilityPlaceholder(View.GONE);
                                    getMvpView().updateListShots(shotsList);
                                }
                                , error -> {
                                    List<Shot> shotsList = getShots();
                                    if (shotsList == null || shotsList.size() == 0)
                                        getMvpView().setVisibilityPlaceholder(View.VISIBLE);

                                    getMvpView().updateListShots(shotsList);

                                    Toast.makeText(mContext, mContext.getString(R.string.text_no_connection), Toast.LENGTH_LONG).show();

                                }
                        );
        addDisposable(getShotsDisposable);
    }


    private void saveShots(List<Shot> shots) {
        ShotsDatabase.getInstance(mContext).saveListOfShots(shots);
    }


    private List<Shot> getShots() {
        return ShotsDatabase.getInstance(mContext).getListOfShots();
    }
}
