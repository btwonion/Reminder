package dev.nyon.reminder.cli.commands

import com.github.ajalt.clikt.core.CliktCommand

class Reminder : CliktCommand(name = "Reminder", help = "The Reminder root command") {
    override fun run() = Unit
}