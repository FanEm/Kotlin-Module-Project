import java.util.Scanner
import ui.Console
import ui.screens.ArchiveListScreen

fun main() {
    Scanner(System.`in`).use { input ->
        ArchiveListScreen(Console(input)).show()
    }
}
