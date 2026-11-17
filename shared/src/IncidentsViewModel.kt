package com.example.incident_list_demo_kmp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Instant

class IncidentsViewModel : ViewModel() {

    val incidents: StateFlow<List<Incident>>
        field = MutableStateFlow<List<Incident>>(emptyList())

    init {
        loadIncidents()
    }

    fun removeIncident(id: Int) {
        incidents.update { currentList ->
            currentList.filter { it.id != id }
        }
    }

    fun updateIncidentStatus(id: Int, newStatus: String) {
        incidents.update { currentList ->
            currentList.map { incident ->
                if (incident.id == id) {
                    incident.copy(status = newStatus)
                } else {
                    incident
                }
            }
        }
    }

    private fun loadIncidents() {
        val now: Instant = Clock.System.now()
        val tz: TimeZone = TimeZone.currentSystemDefault()

        incidents.update { currentList ->
            currentList + listOf(
                Incident(
                    id = 1,
                    category = "Vandalisme",
                    description = "Zijruit van bushalte ingegooid",
                    priority = Priority.HIGH,
                    status = "In Progress",
                    reportedAt = (now - 2.hours).toLocalDateTime(tz)
                ),
                Incident(
                    id = 2,
                    category = "Afval",
                    description = "Vuilniszakken op straat gedumpt",
                    priority = Priority.MEDIUM,
                    status = "Reported",
                    reportedAt = (now - 2.hours).toLocalDateTime(tz)
                ),
                Incident(
                    id = 3,
                    category = "Gladheid",
                    description = "IJsplaat op fietspad Hoofdstraat",
                    priority = Priority.HIGH,
                    status = "Reported",
                    reportedAt = (now - 45.minutes).toLocalDateTime(tz)
                ),
                Incident(
                    id = 4,
                    category = "Verlichting",
                    description = "Straatlantaarn defect bij park",
                    priority = Priority.LOW,
                    status = "Resolved",
                    reportedAt = (now - 1.days).toLocalDateTime(tz)
                ),
                Incident(
                    id = 5,
                    category = "Geluidsoverlast",
                    description = "Bouwwerkzaamheden na 20:00",
                    priority = Priority.MEDIUM,
                    status = "In Progress",
                    reportedAt = (now - 8.hours).toLocalDateTime(tz)
                ),
                Incident(
                    id = 6,
                    category = "Graffiti",
                    description = "Tags op gemeentelijk gebouw",
                    priority = Priority.LOW,
                    status = "Reported",
                    reportedAt = (now - 2.days).toLocalDateTime(tz)
                ),
                Incident(
                    id = 7,
                    category = "Wegdek",
                    description = "Groot gat in de weg bij rotonde",
                    priority = Priority.HIGH,
                    status = "Reported",
                    reportedAt = (now - 3.hours).toLocalDateTime(tz)
                ),
                Incident(
                    id = 8,
                    category = "Park",
                    description = "Omgevallen boom blokkeert wandelpad",
                    priority = Priority.MEDIUM,
                    status = "In Progress",
                    reportedAt = (now - 6.hours).toLocalDateTime(tz)
                ),
                Incident(
                    id = 9,
                    category = "Verkeer",
                    description = "Verkeerslicht knippert continu oranje",
                    priority = Priority.LOW,
                    status = "Reported",
                    reportedAt = (now - 12.hours).toLocalDateTime(tz)
                ),
                Incident(
                    id = 10,
                    category = "Geluidsoverlast",
                    description = "Luidruchtig feest in de nacht",
                    priority = Priority.HIGH,
                    status = "Reported",
                    reportedAt = (now - 1.days).toLocalDateTime(tz)
                ),
                Incident(
                    id = 11,
                    category = "Dierenwelzijn",
                    description = "Gewonde zwaan in vijver stadspark",
                    priority = Priority.MEDIUM,
                    status = "In Progress",
                    reportedAt = (now - 30.minutes).toLocalDateTime(tz)
                ),
                Incident(
                    id = 12,
                    category = "Openbaar vervoer",
                    description = "Bushaltebord ontbreekt",
                    priority = Priority.LOW,
                    status = "Reported",
                    reportedAt = (now - 3.days).toLocalDateTime(tz)
                ),
                Incident(
                    id = 13,
                    category = "Vuilnis",
                    description = "Prullenbak overvol bij winkelcentrum",
                    priority = Priority.LOW,
                    status = "Resolved",
                    reportedAt = (now - 18.hours).toLocalDateTime(tz)
                ),
                Incident(
                    id = 14,
                    category = "Stoep",
                    description = "Losliggende stoeptegel gevaarlijk voor voetgangers",
                    priority = Priority.MEDIUM,
                    status = "Reported",
                    reportedAt = (now - 4.hours).toLocalDateTime(tz)
                ),
                Incident(
                    id = 15,
                    category = "Verlichting",
                    description = "Donker steegje – meerdere lampen kapot",
                    priority = Priority.HIGH,
                    status = "In Progress",
                    reportedAt = (now - 5.days).toLocalDateTime(tz)
                )
            )
        }
    }
}
