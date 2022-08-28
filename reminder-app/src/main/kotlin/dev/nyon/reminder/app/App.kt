package dev.nyon.reminder.app

import kotlinx.coroutines.launch

suspend fun app() {
    initMongoDbs()
}