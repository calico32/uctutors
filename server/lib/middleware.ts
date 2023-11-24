import { logger } from '@/providers'
import { isAbortError } from 'abort-controller-x'
import { CallContext, ServerError, ServerMiddlewareCall, Status } from 'nice-grpc'
import { inspect } from 'util'

export async function* middleware<T, U>(call: ServerMiddlewareCall<T, U>, context: CallContext) {
  const { path } = call.method

  if (path.startsWith('/grpc.reflection')) {
    // Don't log reflection requests
    return yield* call.next(call.request, context)
  }

  logger.debug('🤙 %s %s', path, inspect(call.request, false, null, true))

  try {
    const result = yield* call.next(call.request, context)

    logger.debug('🤙 %s %s', path, 'end: OK')

    return result
  } catch (error) {
    if (error instanceof ServerError) {
      logger.debug('🤙 %s %s', path, `end: ${Status[error.code]}: ${error.details}`)
    } else if (isAbortError(error)) {
      logger.debug('🤙 %s %s', path, 'cancel')
    } else {
      logger.debug('🤙 %s %s', path, `error: ${(error as any)?.stack}`)
    }

    throw error
  }
}
