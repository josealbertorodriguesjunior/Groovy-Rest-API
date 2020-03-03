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
import tech.juniorlima.groovyrestapi.model.Disaster
import tech.juniorlima.groovyrestapi.services.DisasterService

import javax.transaction.Transactional

@RestController
@RequestMapping('/api')
@Transactional
class DisasterController {
    @Autowired
    DisasterService disasterService

    @GetMapping('/disasters')
    List findAll() {
        disasterService.findAll()
    }

    @GetMapping('/disaster/{id}')
    Disaster findById(@PathVariable long id) {
        disasterService.findById(id)
    }

    @PostMapping('/disaster/create')
    Disaster create(@RequestBody Disaster disaster) {
        disasterService.save(disaster)
    }

    @PutMapping('/disaster/{id}/edit')
    Disaster update(@RequestBody Disaster disaster, @PathVariable long id) {
        disasterService.update(disaster, id)
    }

    @PostMapping('/disaster/{id}/assign/hero/{heroId}')
    Disaster assignHero(@PathVariable long id, @PathVariable long
            heroId) {
        disasterService.assignHero(id, heroId)
    }

    @DeleteMapping('/disaster/{id}/delete/hero/{heroId}')
    Disaster removeHero(@PathVariable long id, @PathVariable long heroId) {
        disasterService.removeHero(id, heroId)
    }

    @PostMapping('/disaster/resolve/{id}')
    Disaster resolve(@PathVariable long id) {
        disasterService.resolve(id)
    }

    @DeleteMapping('/disaster/{id}/delete')
    Disaster deleteById(@PathVariable long id) {
        disasterService.deleteById(id)
    }
}

