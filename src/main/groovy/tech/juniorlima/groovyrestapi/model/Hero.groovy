package tech.juniorlima.groovyrestapi.model

import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.Data
import org.hibernate.annotations.GenericGenerator

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.OneToMany

@Entity
@Data
class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id
    String name
    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = 'hero'
    )
    List<Ability> abilities
    @ManyToMany(mappedBy = 'heroes')
    @JsonIgnore
    Set<Disaster> disasters
}
