// Generated by the protocol buffer compiler. DO NOT EDIT!
// source: api/v1/auth.proto

// Generated files should ignore deprecation warnings
@file:Suppress("DEPRECATION")
package lol.calico.uctutors.generated.api.v1;

@kotlin.jvm.JvmName("-initializeregisterRequest")
public inline fun registerRequest(block: lol.calico.uctutors.generated.api.v1.RegisterRequestKt.Dsl.() -> kotlin.Unit): lol.calico.uctutors.generated.api.v1.RegisterRequest =
  lol.calico.uctutors.generated.api.v1.RegisterRequestKt.Dsl._create(lol.calico.uctutors.generated.api.v1.RegisterRequest.newBuilder()).apply { block() }._build()
/**
 * Protobuf type `api.v1.RegisterRequest`
 */
public object RegisterRequestKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: lol.calico.uctutors.generated.api.v1.RegisterRequest.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: lol.calico.uctutors.generated.api.v1.RegisterRequest.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): lol.calico.uctutors.generated.api.v1.RegisterRequest = _builder.build()

    /**
     * `.api.v1.RegisterData data = 1 [json_name = "data"];`
     */
    public var data: lol.calico.uctutors.generated.api.v1.RegisterData
      @JvmName("getData")
      get() = _builder.getData()
      @JvmName("setData")
      set(value) {
        _builder.setData(value)
      }
    /**
     * `.api.v1.RegisterData data = 1 [json_name = "data"];`
     */
    public fun clearData() {
      _builder.clearData()
    }
    /**
     * `.api.v1.RegisterData data = 1 [json_name = "data"];`
     * @return Whether the data field is set.
     */
    public fun hasData(): kotlin.Boolean {
      return _builder.hasData()
    }
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun lol.calico.uctutors.generated.api.v1.RegisterRequest.copy(block: `lol.calico.uctutors.generated.api.v1`.RegisterRequestKt.Dsl.() -> kotlin.Unit): lol.calico.uctutors.generated.api.v1.RegisterRequest =
  `lol.calico.uctutors.generated.api.v1`.RegisterRequestKt.Dsl._create(this.toBuilder()).apply { block() }._build()

public val lol.calico.uctutors.generated.api.v1.RegisterRequestOrBuilder.dataOrNull: lol.calico.uctutors.generated.api.v1.RegisterData?
  get() = if (hasData()) getData() else null

