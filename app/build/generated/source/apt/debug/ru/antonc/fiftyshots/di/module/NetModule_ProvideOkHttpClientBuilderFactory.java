package ru.antonc.fiftyshots.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import okhttp3.OkHttpClient;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NetModule_ProvideOkHttpClientBuilderFactory
    implements Factory<OkHttpClient.Builder> {
  private final NetModule module;

  public NetModule_ProvideOkHttpClientBuilderFactory(NetModule module) {
    this.module = module;
  }

  @Override
  public OkHttpClient.Builder get() {
    return Preconditions.checkNotNull(
        module.provideOkHttpClientBuilder(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static NetModule_ProvideOkHttpClientBuilderFactory create(NetModule module) {
    return new NetModule_ProvideOkHttpClientBuilderFactory(module);
  }

  public static OkHttpClient.Builder proxyProvideOkHttpClientBuilder(NetModule instance) {
    return Preconditions.checkNotNull(
        instance.provideOkHttpClientBuilder(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
