// Generated by Dagger (https://google.github.io/dagger).
package ru.antonc.fiftyshots.di.module;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class FragmentModule_ProvidesContextFactory implements Factory<Context> {
  private final FragmentModule module;

  public FragmentModule_ProvidesContextFactory(FragmentModule module) {
    this.module = module;
  }

  @Override
  public Context get() {
    return Preconditions.checkNotNull(
        module.providesContext(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static FragmentModule_ProvidesContextFactory create(FragmentModule module) {
    return new FragmentModule_ProvidesContextFactory(module);
  }

  public static Context proxyProvidesContext(FragmentModule instance) {
    return Preconditions.checkNotNull(
        instance.providesContext(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
