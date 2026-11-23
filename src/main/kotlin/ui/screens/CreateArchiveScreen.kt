package ui.screens

import model.Archive
import ui.Console

internal class CreateArchiveScreen(console: Console) : CreateScreen<Archive>(console, "Введите название архива") {
    override fun create(name: String): Archive = Archive(name)
}
