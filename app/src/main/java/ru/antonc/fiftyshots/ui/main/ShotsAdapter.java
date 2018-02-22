package ru.antonc.fiftyshots.ui.main;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import ru.antonc.fiftyshots.data.domain.Shot;
import ru.antonc.fiftyshots.di.qualifier.ApplicationContext;
import sev.com.fiftyshots.R;

import static ru.antonc.fiftyshots.app.Constants.ANIMATION_DELAY;
import static ru.antonc.fiftyshots.app.Constants.ANIMATION_DURATION;

public class ShotsAdapter extends RecyclerView.Adapter<ShotsAdapter.ViewHolder> {

    @Inject
    @ApplicationContext
    Context mContext;

    @Inject
    OkHttpClient.Builder client;

    private Picasso picasso;
    private List<Shot> mList;

    @Inject
    public ShotsAdapter() {
        mList = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shot, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Shot shot = mList.get(position);

        if (Build.VERSION.SDK_INT < 22)
            getPicasso().load(shot.getImage().getHidpi() == null ? shot.getImage().getNormal() : shot.getImage().getHidpi()).into(holder.mShotView);
        else
            Picasso.with(mContext).load(shot.getImage().getHidpi() == null ? shot.getImage().getNormal() : shot.getImage().getHidpi()).into(holder.mShotView);


        String title = shot.getTitle();
        holder.tvTitle.setText(title == null ? mContext.getString(R.string.text_title) : title);

        String description = shot.getDescription();
        if (description != null) {
            holder.tvDescription.setVisibility(View.VISIBLE);
            holder.tvDescription.setText(Html.fromHtml(description));
        } else holder.tvDescription.setVisibility(View.INVISIBLE);
    }


    public void setList(List<Shot> shots) {
        mList = shots;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_shot)
        ImageView mShotView;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_description)
        TextView tvDescription;
        @BindView(R.id.substrate)
        LinearLayout llSubstrate;

        @OnClick(R.id.card_shot)
        void onClick() {
            ViewPropertyAnimator animSubstrate = llSubstrate.animate().translationY((float) (llSubstrate.getHeight() * 1.2)).setDuration(ANIMATION_DURATION);
            animSubstrate.withEndAction(() -> llSubstrate.animate().translationY(0).setDuration(ANIMATION_DURATION).setStartDelay(ANIMATION_DELAY).start());
            animSubstrate.start();
        }


        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private Picasso getPicasso() {
        if (picasso == null)
            picasso = new Picasso.Builder(mContext)
                    .downloader(new OkHttp3Downloader(client.build()))
                    .build();
        return picasso;
    }
}
