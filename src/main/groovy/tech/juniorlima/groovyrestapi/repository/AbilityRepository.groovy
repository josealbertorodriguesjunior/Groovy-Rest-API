package tech.juniorlima.groovyrestapi.repository

import org.springframework.data.repository.CrudRepository
import tech.juniorlima.groovyrestapi.model.Ability

interface AbilityRepository extends CrudRepository<Ability,Long> {}