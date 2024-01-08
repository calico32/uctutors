package lol.calico.uctutors.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import lol.calico.uctutors.data.common.GrpcNetworkConnection
import lol.calico.uctutors.data.common.newHttpClient
import lol.calico.uctutors.data.storage.TokenStorage
import lol.calico.uctutors.domain.AccountHandler
import okhttp3.OkHttpClient

@Module
@InstallIn(ActivityComponent::class)
object ApplicationModule {
  @Provides
  fun provideAccountHandler(
    @ActivityContext context: Context,
    grpc: GrpcNetworkConnection,
    tokenStorage: TokenStorage,
  ): AccountHandler {
    return AccountHandler(context, grpc, tokenStorage)
  }

  @Provides
  fun provideTokenStorage(
    @ActivityContext context: Context,
    grpc: GrpcNetworkConnection,
  ): TokenStorage {
    return TokenStorage(context, grpc)
  }

  @Provides
  fun provideHttpClient(
    @ActivityContext context: Context,
  ): OkHttpClient {
    return newHttpClient(context)
  }
}
