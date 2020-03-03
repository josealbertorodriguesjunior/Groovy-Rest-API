package tech.juniorlima.groovyrestapi.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tech.juniorlima.groovyrestapi.model.Hero
import tech.juniorlima.groovyrestapi.services.HeroService

import javax.transaction.Transactional

@RestController
@RequestMapping('/api')
@Transactional
class HeroController {
    @Autowired
    HeroService heroService

    @GetMapping('/heroes')
    List findAll() {
        heroService.findAll()
    }

    @GetMapping('/hero/{id}')
    Hero findOne(@PathVariable long id) {
        heroService.findById(id)
    }

    @PostMapping('/hero/create')
    Hero save(@RequestBody Hero hero) {
        heroService.save(hero)
    }

    @PutMapping('hero/{id}/edit')
    Hero update(@RequestBody Hero hero, @PathVariable long id) {
        heroService.update(hero, id)
    }

    @DeleteMapping('/hero/{id}/delete')
    Hero deleteById(@PathVariable long id) {
        heroService.deleteById(id)
    }
}