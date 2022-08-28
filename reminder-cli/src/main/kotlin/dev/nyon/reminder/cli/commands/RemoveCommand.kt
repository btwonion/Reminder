package dev.nyon.reminder.cli.commands

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.mordant.rendering.TextColors.red
import dev.nyon.reminder.app.ReminderEntry
import dev.nyon.reminder.app.remindersCollection
import dev.nyon.reminder.cli.launchJob
import dev.nyon.reminder.cli.terminal
import org.litote.kmongo.eq

class RemoveCommand : CliktCommand(name = "remove", help = "Removes an existing reminder") {

    private val name by argument("name", "Name of the reminder")

    override fun run() = launchJob {
        if (remindersCollection.findOne(ReminderEntry::name eq name) == null) {
            terminal.println(red("This reminder cannot be found!"))
            return@launchJob
        }
        remindersCollection.deleteOne(ReminderEntry::name eq name)
    }

}