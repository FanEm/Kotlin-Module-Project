package ui.screens

import model.Note
import ui.Console

internal class CreateNoteScreen(console: Console) : CreateScreen<Note>(console, "Введите название заметки") {
    override fun create(name: String): Note? {
        val text = console.readRequiredText("Введите текст заметки") ?: return null
        return Note(name, text)
    }
}
