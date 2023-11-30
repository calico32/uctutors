package lol.calico.uctutors.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import lol.calico.uctutors.data.common.GrpcConnection
import lol.calico.uctutors.data.storage.TokenStorage
import lol.calico.uctutors.domain.AccountHandler

@Module
@InstallIn(ActivityComponent::class)
object ApplicationModule {
  @Provides
  fun provideAccountHandler(
    @ActivityContext context: Context,
    grpc: GrpcConnection,
    tokenStorage: TokenStorage,
  ): AccountHandler {
    return AccountHandler(context, grpc, tokenStorage)
  }

  @Provides
  fun provideTokenStorage(
    @ActivityContext context: Context,
    grpc: GrpcConnection,
  ): TokenStorage {
    return TokenStorage(context, grpc)
  }
}