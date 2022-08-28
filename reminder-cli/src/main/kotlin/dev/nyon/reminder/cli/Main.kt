package dev.nyon.reminder.cli

import com.github.ajalt.clikt.core.subcommands
import com.github.ajalt.mordant.rendering.Theme
import com.github.ajalt.mordant.terminal.Terminal
import dev.nyon.reminder.app.app
import dev.nyon.reminder.cli.commands.AddCommand
import dev.nyon.reminder.cli.commands.ListCommand
import dev.nyon.reminder.cli.commands.Reminder
import dev.nyon.reminder.cli.commands.RemoveCommand
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.system.exitProcess

lateinit var mainScope: CoroutineScope
val terminal = Terminal(theme = Theme.PlainAscii)
suspend fun main(args: Array<String>) = coroutineScope {
    mainScope = this
    try {
        app()
        Reminder().subcommands(ListCommand(), AddCommand(), RemoveCommand()).main(args)
    } catch (exc: Exception) {
        exc.printStackTrace()
    } finally {
        exitProcess(0)
    }
}

fun launchJob(
    block: suspend CoroutineScope.() -> Unit
) {
    mainScope.launch(block = block)
}