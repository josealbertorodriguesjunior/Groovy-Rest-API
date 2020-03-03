package tech.juniorlima.groovyrestapi.model

import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.Data
import org.hibernate.annotations.GeneratorType
import org.hibernate.annotations.GenericGenerator

import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
@Data
class Ability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id
    String name
    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JsonIgnore
    Hero hero
}
