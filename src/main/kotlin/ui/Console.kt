package ui

import java.util.Scanner

internal class Console(private val input: Scanner) {
    private val integerPattern = Regex("[+-]?[0-9]+")
    private var inputEnded = false

    fun <T : Any> runListMenu(
        title: String,
        items: MutableList<T>,
        itemLabel: (T) -> String,
        createLabel: String,
        createScreen: Screen<T?>,
        itemScreen: (T) -> Screen<Unit>,
        backLabel: String = "Назад",
    ) {
        runMenu(title, backLabel) { menuItems ->
            menuItems.add(MenuItem(createLabel) {
                createScreen.show()?.let { item -> items.add(item) }
            })
            for (item in items) {
                menuItems.add(MenuItem(itemLabel(item)) { itemScreen(item).show() })
            }
        }
    }

    fun runMenu(title: String, backLabel: String, addItems: (MutableList<MenuItem>) -> Unit) {
        while (!inputEnded) {
            val items = mutableListOf<MenuItem>()
            addItems(items)
            println(title)
            items.forEachIndexed { index, item -> println("$index. ${item.label}") }
            println("${items.size}. $backLabel")
            println("Введите номер пункта меню:")

            val line = readLine()?.trim() ?: return
            val number = line.toIntOrNull()
            when {
                number == items.size -> return
                number != null && number in items.indices -> items[number].action()
                number != null || integerPattern.matches(line) -> println("Пункта с таким номером нет.")
                else -> println("Введите число — номер пункта меню.")
            }
        }
    }

    fun readRequiredText(prompt: String): String? {
        while (true) {
            println("$prompt (/назад — отменить):")
            val line = readLine() ?: return null
            if (line == "/назад") return null
            if (line.isNotBlank()) return line
            println("Поле не может быть пустым.")
        }
    }

    private fun readLine(): String? {
        if (input.hasNextLine()) return input.nextLine()
        inputEnded = true
        return null
    }
}
