package ru.antonc.fiftyshots.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import ru.antonc.fiftyshots.data.rest.ShotsService;
import ru.antonc.fiftyshots.di.module.ActivityModule;
import ru.antonc.fiftyshots.di.module.ApplicationModule;
import ru.antonc.fiftyshots.di.module.ApplicationModule_ProvideContextFactory;
import ru.antonc.fiftyshots.di.module.FragmentModule;
import ru.antonc.fiftyshots.di.module.NetModule;
import ru.antonc.fiftyshots.di.module.NetModule_ProvideOkHttpClientBuilderFactory;
import ru.antonc.fiftyshots.di.module.NetModule_ProvideShotServiceFactory;
import ru.antonc.fiftyshots.ui.base.BasePresenter_MembersInjector;
import ru.antonc.fiftyshots.ui.main.MainActivity;
import ru.antonc.fiftyshots.ui.main.MainFragment;
import ru.antonc.fiftyshots.ui.main.MainFragment_MembersInjector;
import ru.antonc.fiftyshots.ui.main.MainPresenter;
import ru.antonc.fiftyshots.ui.main.MainPresenter_Factory;
import ru.antonc.fiftyshots.ui.main.ShotsAdapter;
import ru.antonc.fiftyshots.ui.main.ShotsAdapter_Factory;
import ru.antonc.fiftyshots.ui.main.ShotsAdapter_MembersInjector;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerApplicationComponent implements ApplicationComponent {
  private ApplicationModule applicationModule;

  private Provider<OkHttpClient.Builder> provideOkHttpClientBuilderProvider;

  private Provider<ShotsService> provideShotServiceProvider;

  private DaggerApplicationComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.applicationModule = builder.applicationModule;
    this.provideOkHttpClientBuilderProvider =
        DoubleCheck.provider(NetModule_ProvideOkHttpClientBuilderFactory.create(builder.netModule));
    this.provideShotServiceProvider =
        DoubleCheck.provider(
            NetModule_ProvideShotServiceFactory.create(
                builder.netModule, provideOkHttpClientBuilderProvider));
  }

  @Override
  public ActivityComponent activityComponent(ActivityModule activityModule) {
    return new ActivityComponentImpl(activityModule);
  }

  @Override
  public FragmentComponent fragmentComponent(FragmentModule fragmentModule) {
    return new FragmentComponentImpl(fragmentModule);
  }

  public static final class Builder {
    private ApplicationModule applicationModule;

    private NetModule netModule;

    private Builder() {}

    public ApplicationComponent build() {
      if (applicationModule == null) {
        throw new IllegalStateException(
            ApplicationModule.class.getCanonicalName() + " must be set");
      }
      if (netModule == null) {
        this.netModule = new NetModule();
      }
      return new DaggerApplicationComponent(this);
    }

    public Builder applicationModule(ApplicationModule applicationModule) {
      this.applicationModule = Preconditions.checkNotNull(applicationModule);
      return this;
    }

    public Builder netModule(NetModule netModule) {
      this.netModule = Preconditions.checkNotNull(netModule);
      return this;
    }
  }

  private final class ActivityComponentImpl implements ActivityComponent {
    private final ActivityModule activityModule;

    private ActivityComponentImpl(ActivityModule activityModule) {
      this.activityModule = Preconditions.checkNotNull(activityModule);
    }

    @Override
    public void inject(MainActivity mainActivity) {}
  }

  private final class FragmentComponentImpl implements FragmentComponent {
    private final FragmentModule fragmentModule;

    private FragmentComponentImpl(FragmentModule fragmentModule) {
      this.fragmentModule = Preconditions.checkNotNull(fragmentModule);
    }

    private MainPresenter getMainPresenter() {
      return injectMainPresenter(
          MainPresenter_Factory.newMainPresenter(
              ApplicationModule_ProvideContextFactory.proxyProvideContext(
                  DaggerApplicationComponent.this.applicationModule)));
    }

    private ShotsAdapter getShotsAdapter() {
      return injectShotsAdapter(ShotsAdapter_Factory.newShotsAdapter());
    }

    @Override
    public void inject(MainFragment mainFragment) {
      injectMainFragment(mainFragment);
    }

    private MainPresenter injectMainPresenter(MainPresenter instance) {
      BasePresenter_MembersInjector.injectMShotsService(
          instance, DaggerApplicationComponent.this.provideShotServiceProvider.get());
      return instance;
    }

    private ShotsAdapter injectShotsAdapter(ShotsAdapter instance) {
      ShotsAdapter_MembersInjector.injectMContext(
          instance,
          ApplicationModule_ProvideContextFactory.proxyProvideContext(
              DaggerApplicationComponent.this.applicationModule));
      ShotsAdapter_MembersInjector.injectClient(
          instance, DaggerApplicationComponent.this.provideOkHttpClientBuilderProvider.get());
      return instance;
    }

    private MainFragment injectMainFragment(MainFragment instance) {
      MainFragment_MembersInjector.injectMPresenter(instance, getMainPresenter());
      MainFragment_MembersInjector.injectMAdapter(instance, getShotsAdapter());
      return instance;
    }
  }
}