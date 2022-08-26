package dev.nyon.reminder.app

import kotlinx.coroutines.launch

fun app() {
    databaseScope.launch { initMongoDbs() }
}