package ru.antonc.fiftyshots.ui.main;

import java.util.List;

import ru.antonc.fiftyshots.data.domain.Shot;
import ru.antonc.fiftyshots.ui.base.IBasePresenter;
import ru.antonc.fiftyshots.ui.base.IBaseView;

/**
 * Created by antonc on 21.02.2018.
 */

public interface IMainContract {

    interface View extends IBaseView {

        void initView();

        void updateListShots(List<Shot> shots);

        void setVisibilityPlaceholder(int visibility);

    }

    interface Presenter extends IBasePresenter<View> {
        void getData();
    }
}
