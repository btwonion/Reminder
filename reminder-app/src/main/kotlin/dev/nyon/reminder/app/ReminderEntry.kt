package dev.nyon.reminder.app

import kotlinx.serialization.Serializable

@Serializable
data class ReminderEntry(val name: String, val description: String)