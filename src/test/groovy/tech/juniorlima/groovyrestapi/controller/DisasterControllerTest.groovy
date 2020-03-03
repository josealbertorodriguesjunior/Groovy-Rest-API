package tech.juniorlima.groovyrestapi.controller

import org.junit.Test
import org.junit.Before
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import tech.juniorlima.groovyrestapi.model.Disaster
import tech.juniorlima.groovyrestapi.model.Hero
import tech.juniorlima.groovyrestapi.services.DisasterService
import static org.mockito.Mockito.*

class DisasterControllerTest {
    @Mock
    DisasterService disasterService
    @InjectMocks
    DisasterController disasterController

    @Before
    void setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    void testFindAll() {
        when(disasterService.findAll()).thenReturn(["String"])

        List result = disasterController.findAll()
        assert result == ["String"]
    }

    @Test
    void testFindById() {
        when(disasterService.findById(anyLong())).thenReturn(new Disaster())

        Disaster result = disasterController.findById(0l)
        assert result == new Disaster()
    }

    @Test
    void testCreate() {
        when(disasterService.save(any())).thenReturn(new Disaster(isResolved: true))

        Disaster result = disasterController.create(new Disaster(isResolved: true))
        assert result == new Disaster(isResolved: true)
    }

    @Test
    void testUpdate() {
        when(disasterService.update(any(), anyLong())).thenReturn(new Disaster(title: "title", location: "location", time: new GregorianCalendar(2020, Calendar.MARCH, 3, 0, 10).getTime()))

        Disaster result = disasterController.update(new Disaster(title: "title", location: "location", time: new GregorianCalendar(2020, Calendar.MARCH, 3, 0, 10).getTime()), 0l)
        assert result == new Disaster(title: "title", location: "location", time: new GregorianCalendar(2020, Calendar.MARCH, 3, 0, 10).getTime())
    }

    @Test
    void testAssignHero() {
        when(disasterService.assignHero(anyLong(), anyLong())).thenReturn(new Disaster(heroes: [new Hero()] as Set<Hero>))

        Disaster result = disasterController.assignHero(0l, 0l)
        assert result == new Disaster(heroes: [new Hero()] as Set<Hero>)
    }

    @Test
    void testRemoveHero() {
        when(disasterService.removeHero(anyLong(), anyLong())).thenReturn(new Disaster(heroes: [new Hero()] as Set<Hero>))

        Disaster result = disasterController.removeHero(0l, 0l)
        assert result == new Disaster(heroes: [new Hero()] as Set<Hero>)
    }

    @Test
    void testResolve() {
        when(disasterService.resolve(anyLong())).thenReturn(new Disaster(isResolved: true))

        Disaster result = disasterController.resolve(0l)
        assert result == new Disaster(isResolved: true)
    }

    @Test
    void testDeleteById() {
        when(disasterService.deleteById(anyLong())).thenReturn(new Disaster())

        Disaster result = disasterController.deleteById(0l)
        assert result == new Disaster()
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme