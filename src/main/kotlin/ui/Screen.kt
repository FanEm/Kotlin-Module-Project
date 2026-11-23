package ui

internal interface Screen<out T> {
    fun show(): T
}
