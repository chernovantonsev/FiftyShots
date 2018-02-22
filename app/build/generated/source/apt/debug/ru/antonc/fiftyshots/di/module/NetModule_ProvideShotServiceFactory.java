package ru.antonc.fiftyshots.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import ru.antonc.fiftyshots.data.rest.ShotsService;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NetModule_ProvideShotServiceFactory implements Factory<ShotsService> {
  private final NetModule module;

  private final Provider<OkHttpClient.Builder> okHttpClientBuilderProvider;

  public NetModule_ProvideShotServiceFactory(
      NetModule module, Provider<OkHttpClient.Builder> okHttpClientBuilderProvider) {
    this.module = module;
    this.okHttpClientBuilderProvider = okHttpClientBuilderProvider;
  }

  @Override
  public ShotsService get() {
    return Preconditions.checkNotNull(
        module.provideShotService(okHttpClientBuilderProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static NetModule_ProvideShotServiceFactory create(
      NetModule module, Provider<OkHttpClient.Builder> okHttpClientBuilderProvider) {
    return new NetModule_ProvideShotServiceFactory(module, okHttpClientBuilderProvider);
  }

  public static ShotsService proxyProvideShotService(
      NetModule instance, OkHttpClient.Builder okHttpClientBuilder) {
    return Preconditions.checkNotNull(
        instance.provideShotService(okHttpClientBuilder),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
