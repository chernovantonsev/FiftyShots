package ru.antonc.fiftyshots.di.module;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityModule_ProvidesContextFactory implements Factory<Context> {
  private final ActivityModule module;

  public ActivityModule_ProvidesContextFactory(ActivityModule module) {
    this.module = module;
  }

  @Override
  public Context get() {
    return Preconditions.checkNotNull(
        module.providesContext(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ActivityModule_ProvidesContextFactory create(ActivityModule module) {
    return new ActivityModule_ProvidesContextFactory(module);
  }

  public static Context proxyProvidesContext(ActivityModule instance) {
    return Preconditions.checkNotNull(
        instance.providesContext(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
