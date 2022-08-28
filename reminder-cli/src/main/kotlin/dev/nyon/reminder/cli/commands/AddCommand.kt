package dev.nyon.reminder.cli.commands

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.mordant.rendering.TextColors.*
import dev.nyon.reminder.app.ReminderEntry
import dev.nyon.reminder.app.remindersCollection
import dev.nyon.reminder.cli.launchJob
import dev.nyon.reminder.cli.terminal
import org.litote.kmongo.eq

class AddCommand : CliktCommand(name = "add", help = "Creates a reminder") {

    private val name by argument("name", "Name for the reminder")
    private val description by argument("description", "Description for the reminder")

    override fun run() = launchJob {
        if (remindersCollection.findOne(ReminderEntry::name eq name) != null) {
            terminal.println(red("This reminder already exists!"))
            return@launchJob
        }
        remindersCollection.insertOne(ReminderEntry(name, description))
        terminal.println("${green("The reminder ")}${brightBlue(name)}${green(" was created successfully!")}")
    }

}