package tech.juniorlima.groovyrestapi.repository

import org.springframework.data.repository.PagingAndSortingRepository
import tech.juniorlima.groovyrestapi.model.Disaster

interface DisasterRepository extends PagingAndSortingRepository<Disaster,Long>{}