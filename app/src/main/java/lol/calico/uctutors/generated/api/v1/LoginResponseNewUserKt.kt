// Generated by the protocol buffer compiler. DO NOT EDIT!
// source: api/v1/auth.proto

// Generated files should ignore deprecation warnings
@file:Suppress("DEPRECATION")
package lol.calico.uctutors.generated.api.v1;

@kotlin.jvm.JvmName("-initializeloginResponseNewUser")
public inline fun loginResponseNewUser(block: lol.calico.uctutors.generated.api.v1.LoginResponseNewUserKt.Dsl.() -> kotlin.Unit): lol.calico.uctutors.generated.api.v1.LoginResponseNewUser =
  lol.calico.uctutors.generated.api.v1.LoginResponseNewUserKt.Dsl._create(lol.calico.uctutors.generated.api.v1.LoginResponseNewUser.newBuilder()).apply { block() }._build()
/**
 * Protobuf type `api.v1.LoginResponseNewUser`
 */
public object LoginResponseNewUserKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: lol.calico.uctutors.generated.api.v1.LoginResponseNewUser.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: lol.calico.uctutors.generated.api.v1.LoginResponseNewUser.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): lol.calico.uctutors.generated.api.v1.LoginResponseNewUser = _builder.build()

    /**
     * `string user_id = 1 [json_name = "userId"];`
     */
    public var userId: kotlin.String
      @JvmName("getUserId")
      get() = _builder.getUserId()
      @JvmName("setUserId")
      set(value) {
        _builder.setUserId(value)
      }
    /**
     * `string user_id = 1 [json_name = "userId"];`
     */
    public fun clearUserId() {
      _builder.clearUserId()
    }

    /**
     * `string token = 2 [json_name = "token"];`
     */
    public var token: kotlin.String
      @JvmName("getToken")
      get() = _builder.getToken()
      @JvmName("setToken")
      set(value) {
        _builder.setToken(value)
      }
    /**
     * `string token = 2 [json_name = "token"];`
     */
    public fun clearToken() {
      _builder.clearToken()
    }
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun lol.calico.uctutors.generated.api.v1.LoginResponseNewUser.copy(block: `lol.calico.uctutors.generated.api.v1`.LoginResponseNewUserKt.Dsl.() -> kotlin.Unit): lol.calico.uctutors.generated.api.v1.LoginResponseNewUser =
  `lol.calico.uctutors.generated.api.v1`.LoginResponseNewUserKt.Dsl._create(this.toBuilder()).apply { block() }._build()
