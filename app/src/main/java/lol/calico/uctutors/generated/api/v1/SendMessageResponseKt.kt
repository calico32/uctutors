// Generated by the protocol buffer compiler. DO NOT EDIT!
// source: api/v1/messages.proto

// Generated files should ignore deprecation warnings
@file:Suppress("DEPRECATION")
package lol.calico.uctutors.generated.api.v1;

@kotlin.jvm.JvmName("-initializesendMessageResponse")
public inline fun sendMessageResponse(block: lol.calico.uctutors.generated.api.v1.SendMessageResponseKt.Dsl.() -> kotlin.Unit): lol.calico.uctutors.generated.api.v1.SendMessageResponse =
  lol.calico.uctutors.generated.api.v1.SendMessageResponseKt.Dsl._create(lol.calico.uctutors.generated.api.v1.SendMessageResponse.newBuilder()).apply { block() }._build()
/**
 * Protobuf type `api.v1.SendMessageResponse`
 */
public object SendMessageResponseKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: lol.calico.uctutors.generated.api.v1.SendMessageResponse.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: lol.calico.uctutors.generated.api.v1.SendMessageResponse.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): lol.calico.uctutors.generated.api.v1.SendMessageResponse = _builder.build()

    /**
     * `.api.v1.Message message = 1 [json_name = "message"];`
     */
    public var message: lol.calico.uctutors.generated.api.v1.Message
      @JvmName("getMessage")
      get() = _builder.getMessage()
      @JvmName("setMessage")
      set(value) {
        _builder.setMessage(value)
      }
    /**
     * `.api.v1.Message message = 1 [json_name = "message"];`
     */
    public fun clearMessage() {
      _builder.clearMessage()
    }
    /**
     * `.api.v1.Message message = 1 [json_name = "message"];`
     * @return Whether the message field is set.
     */
    public fun hasMessage(): kotlin.Boolean {
      return _builder.hasMessage()
    }
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun lol.calico.uctutors.generated.api.v1.SendMessageResponse.copy(block: `lol.calico.uctutors.generated.api.v1`.SendMessageResponseKt.Dsl.() -> kotlin.Unit): lol.calico.uctutors.generated.api.v1.SendMessageResponse =
  `lol.calico.uctutors.generated.api.v1`.SendMessageResponseKt.Dsl._create(this.toBuilder()).apply { block() }._build()

public val lol.calico.uctutors.generated.api.v1.SendMessageResponseOrBuilder.messageOrNull: lol.calico.uctutors.generated.api.v1.Message?
  get() = if (hasMessage()) getMessage() else null
