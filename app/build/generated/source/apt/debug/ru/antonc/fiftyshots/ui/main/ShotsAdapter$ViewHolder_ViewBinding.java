// Generated code from Butter Knife. Do not modify!
package ru.antonc.fiftyshots.ui.main;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import sev.com.fiftyshots.R;

public class ShotsAdapter$ViewHolder_ViewBinding implements Unbinder {
  private ShotsAdapter.ViewHolder target;

  private View view2131165221;

  @UiThread
  public ShotsAdapter$ViewHolder_ViewBinding(final ShotsAdapter.ViewHolder target, View source) {
    this.target = target;

    View view;
    target.mShotView = Utils.findRequiredViewAsType(source, R.id.image_shot, "field 'mShotView'", ImageView.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.tvDescription = Utils.findRequiredViewAsType(source, R.id.tv_description, "field 'tvDescription'", TextView.class);
    target.llSubstrate = Utils.findRequiredViewAsType(source, R.id.substrate, "field 'llSubstrate'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.card_shot, "method 'onClick'");
    view2131165221 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    ShotsAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mShotView = null;
    target.tvTitle = null;
    target.tvDescription = null;
    target.llSubstrate = null;

    view2131165221.setOnClickListener(null);
    view2131165221 = null;
  }
}
