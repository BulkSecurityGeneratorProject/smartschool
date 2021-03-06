package edu.smartschool.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Optionn.
 */
@Entity
@Table(name = "optionn")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "optionn")
public class Optionn implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "intitule", nullable = false)
    private String intitule;
    
    @OneToMany(mappedBy = "optionn")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<ClasseType> classeTypes = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }
    
    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Set<ClasseType> getClasseTypes() {
        return classeTypes;
    }

    public void setClasseTypes(Set<ClasseType> classeTypes) {
        this.classeTypes = classeTypes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Optionn optionn = (Optionn) o;
        if(optionn.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, optionn.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Optionn{" +
            "id=" + id +
            ", intitule='" + intitule + "'" +
            '}';
    }
}
