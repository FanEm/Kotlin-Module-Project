package ui.screens

import model.Archive
import ui.Console
import ui.Screen

internal class ArchiveListScreen(private val console: Console) : Screen<Unit> {
    private val archives = mutableListOf<Archive>()
    private val createArchiveScreen = CreateArchiveScreen(console)

    override fun show() {
        console.runListMenu(
            title = "Список архивов:",
            items = archives,
            itemLabel = { archive -> archive.name },
            createLabel = "Создать архив",
            createScreen = createArchiveScreen,
            itemScreen = { archive -> NoteListScreen(console, archive) },
            backLabel = "Выход",
        )
    }
}
