// Generated by the protocol buffer compiler. DO NOT EDIT!
// source: api/v1/status.proto

// Generated files should ignore deprecation warnings
@file:Suppress("DEPRECATION")
package lol.calico.uctutors.generated.api.v1;

@kotlin.jvm.JvmName("-initializeauthInfo")
public inline fun authInfo(block: lol.calico.uctutors.generated.api.v1.AuthInfoKt.Dsl.() -> kotlin.Unit): lol.calico.uctutors.generated.api.v1.AuthInfo =
  lol.calico.uctutors.generated.api.v1.AuthInfoKt.Dsl._create(lol.calico.uctutors.generated.api.v1.AuthInfo.newBuilder()).apply { block() }._build()
/**
 * Protobuf type `api.v1.AuthInfo`
 */
public object AuthInfoKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: lol.calico.uctutors.generated.api.v1.AuthInfo.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: lol.calico.uctutors.generated.api.v1.AuthInfo.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): lol.calico.uctutors.generated.api.v1.AuthInfo = _builder.build()

    /**
     * `bool authenticated = 1 [json_name = "authenticated"];`
     */
    public var authenticated: kotlin.Boolean
      @JvmName("getAuthenticated")
      get() = _builder.getAuthenticated()
      @JvmName("setAuthenticated")
      set(value) {
        _builder.setAuthenticated(value)
      }
    /**
     * `bool authenticated = 1 [json_name = "authenticated"];`
     */
    public fun clearAuthenticated() {
      _builder.clearAuthenticated()
    }
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun lol.calico.uctutors.generated.api.v1.AuthInfo.copy(block: `lol.calico.uctutors.generated.api.v1`.AuthInfoKt.Dsl.() -> kotlin.Unit): lol.calico.uctutors.generated.api.v1.AuthInfo =
  `lol.calico.uctutors.generated.api.v1`.AuthInfoKt.Dsl._create(this.toBuilder()).apply { block() }._build()

