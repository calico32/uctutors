package lol.calico.uctutors.util

import android.util.Log
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.coroutines.binding.SuspendableResultBinding
import com.github.michaelbull.result.getOrElse
import com.github.michaelbull.result.runCatching

suspend fun <V, E> SuspendableResultBinding<E>.expect(
  error: (Throwable) -> E,
  block: suspend SuspendableResultBinding<E>.() -> V,
): V {
  return runCatching {
    block()
  }.getOrElse {
    Log.d("expect", "Error: ${it.message}")
    Err(error(it)).bind<V>()
  }
}

suspend fun <V> SuspendableResultBinding<Unit>.expect(
  block: suspend SuspendableResultBinding<Unit>.() -> V,
): V {
  return runCatching {
    block()
  }.getOrElse {
    Log.d("expect", "Error: ${it.message}")
    Err(Unit).bind<V>()
  }
}