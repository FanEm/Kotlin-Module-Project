package ui.screens

import model.Archive
import ui.Console
import ui.Screen

internal class NoteListScreen(
    private val console: Console,
    private val archive: Archive,
) : Screen<Unit> {
    private val createNoteScreen = CreateNoteScreen(console)

    override fun show() {
        console.runListMenu(
            title = "Список заметок в архиве «${archive.name}»:",
            items = archive.notes,
            itemLabel = { note -> note.name },
            createLabel = "Создать заметку",
            createScreen = createNoteScreen,
            itemScreen = { note -> NoteScreen(console, note) },
        )
    }
}
