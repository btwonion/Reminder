package dev.nyon.reminder.cli.commands

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.mordant.rendering.TextColors.*
import dev.nyon.reminder.app.remindersCollection
import dev.nyon.reminder.cli.launchJob
import dev.nyon.reminder.cli.terminal

class ListCommand : CliktCommand(name = "list", help = "Lists all of your reminders") {
    override fun run() = launchJob {
        terminal.println(cyan("Here are your reminders: "))
        remindersCollection.find().toFlow().collect {
            terminal.println("${gray(" - ")}${blue(it.name)}  ${white(it.description)}")
        }
    }
}