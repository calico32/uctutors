// Generated by the protocol buffer compiler. DO NOT EDIT!
// source: api/v1/error.proto

// Generated files should ignore deprecation warnings
@file:Suppress("DEPRECATION")
package lol.calico.uctutors.generated.api.v1;

@kotlin.jvm.JvmName("-initializeerror")
public inline fun error(block: lol.calico.uctutors.generated.api.v1.ErrorKt.Dsl.() -> kotlin.Unit): lol.calico.uctutors.generated.api.v1.Error =
  lol.calico.uctutors.generated.api.v1.ErrorKt.Dsl._create(lol.calico.uctutors.generated.api.v1.Error.newBuilder()).apply { block() }._build()
/**
 * Protobuf type `api.v1.Error`
 */
public object ErrorKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: lol.calico.uctutors.generated.api.v1.Error.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: lol.calico.uctutors.generated.api.v1.Error.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): lol.calico.uctutors.generated.api.v1.Error = _builder.build()

    /**
     * `string message = 1 [json_name = "message"];`
     */
    public var message: kotlin.String
      @JvmName("getMessage")
      get() = _builder.getMessage()
      @JvmName("setMessage")
      set(value) {
        _builder.setMessage(value)
      }
    /**
     * `string message = 1 [json_name = "message"];`
     */
    public fun clearMessage() {
      _builder.clearMessage()
    }
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun lol.calico.uctutors.generated.api.v1.Error.copy(block: `lol.calico.uctutors.generated.api.v1`.ErrorKt.Dsl.() -> kotlin.Unit): lol.calico.uctutors.generated.api.v1.Error =
  `lol.calico.uctutors.generated.api.v1`.ErrorKt.Dsl._create(this.toBuilder()).apply { block() }._build()

