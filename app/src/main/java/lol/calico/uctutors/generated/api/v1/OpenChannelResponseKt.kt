// Generated by the protocol buffer compiler. DO NOT EDIT!
// source: api/v1/messages.proto

// Generated files should ignore deprecation warnings
@file:Suppress("DEPRECATION")
package lol.calico.uctutors.generated.api.v1;

@kotlin.jvm.JvmName("-initializeopenChannelResponse")
public inline fun openChannelResponse(block: lol.calico.uctutors.generated.api.v1.OpenChannelResponseKt.Dsl.() -> kotlin.Unit): lol.calico.uctutors.generated.api.v1.OpenChannelResponse =
  lol.calico.uctutors.generated.api.v1.OpenChannelResponseKt.Dsl._create(lol.calico.uctutors.generated.api.v1.OpenChannelResponse.newBuilder()).apply { block() }._build()
/**
 * Protobuf type `api.v1.OpenChannelResponse`
 */
public object OpenChannelResponseKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: lol.calico.uctutors.generated.api.v1.OpenChannelResponse.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: lol.calico.uctutors.generated.api.v1.OpenChannelResponse.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): lol.calico.uctutors.generated.api.v1.OpenChannelResponse = _builder.build()

    /**
     * `.api.v1.MessageList message_list = 1 [json_name = "messageList"];`
     */
    public var messageList: lol.calico.uctutors.generated.api.v1.MessageList
      @JvmName("getMessageList")
      get() = _builder.getMessageList()
      @JvmName("setMessageList")
      set(value) {
        _builder.setMessageList(value)
      }
    /**
     * `.api.v1.MessageList message_list = 1 [json_name = "messageList"];`
     */
    public fun clearMessageList() {
      _builder.clearMessageList()
    }
    /**
     * `.api.v1.MessageList message_list = 1 [json_name = "messageList"];`
     * @return Whether the messageList field is set.
     */
    public fun hasMessageList(): kotlin.Boolean {
      return _builder.hasMessageList()
    }

    /**
     * `.api.v1.Message message = 2 [json_name = "message"];`
     */
    public var message: lol.calico.uctutors.generated.api.v1.Message
      @JvmName("getMessage")
      get() = _builder.getMessage()
      @JvmName("setMessage")
      set(value) {
        _builder.setMessage(value)
      }
    /**
     * `.api.v1.Message message = 2 [json_name = "message"];`
     */
    public fun clearMessage() {
      _builder.clearMessage()
    }
    /**
     * `.api.v1.Message message = 2 [json_name = "message"];`
     * @return Whether the message field is set.
     */
    public fun hasMessage(): kotlin.Boolean {
      return _builder.hasMessage()
    }

    /**
     * `.api.v1.ChannelMemberUpdate members = 3 [json_name = "members"];`
     */
    public var members: lol.calico.uctutors.generated.api.v1.ChannelMemberUpdate
      @JvmName("getMembers")
      get() = _builder.getMembers()
      @JvmName("setMembers")
      set(value) {
        _builder.setMembers(value)
      }
    /**
     * `.api.v1.ChannelMemberUpdate members = 3 [json_name = "members"];`
     */
    public fun clearMembers() {
      _builder.clearMembers()
    }
    /**
     * `.api.v1.ChannelMemberUpdate members = 3 [json_name = "members"];`
     * @return Whether the members field is set.
     */
    public fun hasMembers(): kotlin.Boolean {
      return _builder.hasMembers()
    }
    public val eventCase: lol.calico.uctutors.generated.api.v1.OpenChannelResponse.EventCase
      @JvmName("getEventCase")
      get() = _builder.getEventCase()

    public fun clearEvent() {
      _builder.clearEvent()
    }
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun lol.calico.uctutors.generated.api.v1.OpenChannelResponse.copy(block: `lol.calico.uctutors.generated.api.v1`.OpenChannelResponseKt.Dsl.() -> kotlin.Unit): lol.calico.uctutors.generated.api.v1.OpenChannelResponse =
  `lol.calico.uctutors.generated.api.v1`.OpenChannelResponseKt.Dsl._create(this.toBuilder()).apply { block() }._build()

public val lol.calico.uctutors.generated.api.v1.OpenChannelResponseOrBuilder.messageListOrNull: lol.calico.uctutors.generated.api.v1.MessageList?
  get() = if (hasMessageList()) getMessageList() else null

public val lol.calico.uctutors.generated.api.v1.OpenChannelResponseOrBuilder.messageOrNull: lol.calico.uctutors.generated.api.v1.Message?
  get() = if (hasMessage()) getMessage() else null

public val lol.calico.uctutors.generated.api.v1.OpenChannelResponseOrBuilder.membersOrNull: lol.calico.uctutors.generated.api.v1.ChannelMemberUpdate?
  get() = if (hasMembers()) getMembers() else null
