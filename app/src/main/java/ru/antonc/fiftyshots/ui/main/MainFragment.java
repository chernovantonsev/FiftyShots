package ru.antonc.fiftyshots.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import sev.com.fiftyshots.R;
import ru.antonc.fiftyshots.data.domain.Shot;
import ru.antonc.fiftyshots.di.component.FragmentComponent;
import ru.antonc.fiftyshots.ui.base.BaseFragment;

/**
 * Created by antonc on 21.02.2018.
 */

public class MainFragment extends BaseFragment implements IMainContract.View {

    @Inject
    IMainContract.Presenter mPresenter;

    @Inject
    ShotsAdapter mAdapter;

    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;

    @BindView(R.id.placeholder_no_connection)
    View mPlaceholderNoConnection;

    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.recyclerView_shots)
    RecyclerView mRecyclerView;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.onCreate(savedInstanceState);

        initAdapters();

        mSwipeRefreshLayout.setOnRefreshListener(() -> mPresenter.getData());
    }

    @Override
    protected void inject(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Override
    protected void attachView() {
        mPresenter.attachView(this);
    }

    @Override
    protected void detachPresenter() {
        mPresenter.detachView();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_main;
    }

    @Override
    public void initView() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    private void initAdapters() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecyclerView.setAdapter(mAdapter);
    }


    @Override
    public void updateListShots(List<Shot> shots) {
        if (shots != null)
            mAdapter.setList(shots);

        mSwipeRefreshLayout.setRefreshing(false);
        mProgressBar.setVisibility(View.GONE);
    }


    @Override
    public void setVisibilityPlaceholder(int visibility) {
        mPlaceholderNoConnection.setVisibility(visibility);
        mRecyclerView.setVisibility(visibility == View.VISIBLE ? View.INVISIBLE : View.VISIBLE);
    }


}
