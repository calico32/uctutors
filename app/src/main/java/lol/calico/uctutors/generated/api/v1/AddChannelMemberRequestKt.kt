// Generated by the protocol buffer compiler. DO NOT EDIT!
// source: api/v1/messages.proto

// Generated files should ignore deprecation warnings
@file:Suppress("DEPRECATION")
package lol.calico.uctutors.generated.api.v1;

@kotlin.jvm.JvmName("-initializeaddChannelMemberRequest")
public inline fun addChannelMemberRequest(block: lol.calico.uctutors.generated.api.v1.AddChannelMemberRequestKt.Dsl.() -> kotlin.Unit): lol.calico.uctutors.generated.api.v1.AddChannelMemberRequest =
  lol.calico.uctutors.generated.api.v1.AddChannelMemberRequestKt.Dsl._create(lol.calico.uctutors.generated.api.v1.AddChannelMemberRequest.newBuilder()).apply { block() }._build()
/**
 * Protobuf type `api.v1.AddChannelMemberRequest`
 */
public object AddChannelMemberRequestKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: lol.calico.uctutors.generated.api.v1.AddChannelMemberRequest.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: lol.calico.uctutors.generated.api.v1.AddChannelMemberRequest.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): lol.calico.uctutors.generated.api.v1.AddChannelMemberRequest = _builder.build()

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

    /**
     * `string user_id = 2 [json_name = "userId"];`
     */
    public var userId: kotlin.String
      @JvmName("getUserId")
      get() = _builder.getUserId()
      @JvmName("setUserId")
      set(value) {
        _builder.setUserId(value)
      }
    /**
     * `string user_id = 2 [json_name = "userId"];`
     */
    public fun clearUserId() {
      _builder.clearUserId()
    }
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun lol.calico.uctutors.generated.api.v1.AddChannelMemberRequest.copy(block: `lol.calico.uctutors.generated.api.v1`.AddChannelMemberRequestKt.Dsl.() -> kotlin.Unit): lol.calico.uctutors.generated.api.v1.AddChannelMemberRequest =
  `lol.calico.uctutors.generated.api.v1`.AddChannelMemberRequestKt.Dsl._create(this.toBuilder()).apply { block() }._build()
