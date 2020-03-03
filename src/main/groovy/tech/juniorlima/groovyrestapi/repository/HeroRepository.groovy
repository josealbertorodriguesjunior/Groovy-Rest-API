package tech.juniorlima.groovyrestapi.repository

import org.springframework.data.repository.PagingAndSortingRepository
import tech.juniorlima.groovyrestapi.model.Hero

interface HeroRepository extends PagingAndSortingRepository<Hero,Long>{}