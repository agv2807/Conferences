package com.vazdautsan.conferences.domain.helper

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val helperModule = module {
    factoryOf(::AndroidMonthNamesProvider) {
        bind<MonthNamesProvider>()
    }
    factoryOf(::AndroidDaysPluralProvider) {
        bind<DaysPluralProvider>()
    }
    factoryOf(::AndroidConferencePositionHelper) {
        bind<ConferencePositionHelper>()
    }
}