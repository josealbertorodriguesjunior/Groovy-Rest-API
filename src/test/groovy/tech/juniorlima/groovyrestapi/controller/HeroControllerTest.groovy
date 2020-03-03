package tech.juniorlima.groovyrestapi.controller

import org.junit.Test
import org.junit.Before
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import tech.juniorlima.groovyrestapi.model.Ability
import tech.juniorlima.groovyrestapi.model.Hero
import tech.juniorlima.groovyrestapi.services.HeroService
import static org.mockito.Mockito.*

class HeroControllerTest {
    @Mock
    HeroService heroService
    @InjectMocks
    HeroController heroController

    @Before
    void setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    void testFindAll() {
        when(heroService.findAll()).thenReturn(["String"])

        List result = heroController.findAll()
        assert result == ["String"]
    }

    @Test
    void testFindOne() {
        when(heroService.findById(anyLong())).thenReturn(new Hero())

        Hero result = heroController.findOne(0l)
        assert result == new Hero()
    }

    @Test
    void testSave() {
        when(heroService.save(any())).thenReturn(new Hero(abilities: [new Ability(hero: null)]))

        Hero result = heroController.save(new Hero(abilities: [new Ability(hero: null)]))
        assert result == new Hero(abilities: [new Ability(hero: null)])
    }

    @Test
    void testUpdate() {
        when(heroService.update(any(), anyLong())).thenReturn(new Hero(name: "name", abilities: [new Ability(id: 1l, name: "name", hero: null)]))

        Hero result = heroController.update(new Hero(name: "name", abilities: [new Ability(id: 1l, name: "name", hero: null)]), 0l)
        assert result == new Hero(name: "name", abilities: [new Ability(id: 1l, name: "name", hero: null)])
    }

    @Test
    void testDeleteById() {
        when(heroService.deleteById(anyLong())).thenReturn(new Hero())

        Hero result = heroController.deleteById(0l)
        assert result == new Hero()
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme