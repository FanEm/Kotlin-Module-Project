package ui.screens

import model.Note
import ui.Console
import ui.MenuItem
import ui.Screen

internal class NoteScreen(
    private val console: Console,
    private val note: Note,
) : Screen<Unit> {
    override fun show() {
        console.runMenu("Заметка «${note.name}»", "Назад") { menuItems ->
            menuItems.add(MenuItem("Показать текст заметки") { println(note.text) })
        }
    }
}
