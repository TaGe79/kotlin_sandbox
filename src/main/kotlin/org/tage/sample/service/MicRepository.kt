package org.tage.sample.service

import org.tage.sample.model.Country

/**
 *
 */
interface MicRepository {
    fun countries() : Set<Country>
    fun persist()
}
