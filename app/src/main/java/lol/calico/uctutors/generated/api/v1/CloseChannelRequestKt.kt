// Generated by the protocol buffer compiler. DO NOT EDIT!
// source: api/v1/messages.proto

// Generated files should ignore deprecation warnings
@file:Suppress("DEPRECATION")
package lol.calico.uctutors.generated.api.v1;

@kotlin.jvm.JvmName("-initializecloseChannelRequest")
public inline fun closeChannelRequest(block: lol.calico.uctutors.generated.api.v1.CloseChannelRequestKt.Dsl.() -> kotlin.Unit): lol.calico.uctutors.generated.api.v1.CloseChannelRequest =
  lol.calico.uctutors.generated.api.v1.CloseChannelRequestKt.Dsl._create(lol.calico.uctutors.generated.api.v1.CloseChannelRequest.newBuilder()).apply { block() }._build()
/**
 * Protobuf type `api.v1.CloseChannelRequest`
 */
public object CloseChannelRequestKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: lol.calico.uctutors.generated.api.v1.CloseChannelRequest.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: lol.calico.uctutors.generated.api.v1.CloseChannelRequest.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): lol.calico.uctutors.generated.api.v1.CloseChannelRequest = _builder.build()

    /**
     * `string channel_id = 1 [json_name = "channelId"];`
     */
    public var channelId: kotlin.String
      @JvmName("getChannelId")
      get() = _builder.getChannelId()
      @JvmName("setChannelId")
      set(value) {
        _builder.setChannelId(value)
      }
    /**
     * `string channel_id = 1 [json_name = "channelId"];`
     */
    public fun clearChannelId() {
      _builder.clearChannelId()
    }
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun lol.calico.uctutors.generated.api.v1.CloseChannelRequest.copy(block: `lol.calico.uctutors.generated.api.v1`.CloseChannelRequestKt.Dsl.() -> kotlin.Unit): lol.calico.uctutors.generated.api.v1.CloseChannelRequest =
  `lol.calico.uctutors.generated.api.v1`.CloseChannelRequestKt.Dsl._create(this.toBuilder()).apply { block() }._build()

