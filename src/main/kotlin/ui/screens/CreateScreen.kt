package ui.screens

import ui.Console
import ui.Screen

internal abstract class CreateScreen<T : Any>(
    protected val console: Console,
    private val namePrompt: String,
) : Screen<T?> {
    final override fun show(): T? {
        val name = console.readRequiredText(namePrompt)?.trim() ?: return null
        return create(name)
    }

    protected abstract fun create(name: String): T?
}
