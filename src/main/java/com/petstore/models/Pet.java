package com.petstore.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pet_animals")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(nullable = false, length = 50)
    private String name;

    private String breed;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Petsex sex;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PetType types;

    @Column(nullable = false)
    private Integer age;

    private Date birthDate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "petStore")
    private Store petStore;


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Petsex getSex() {
        return sex;
    }

    public void setSex(Petsex sex) {
        this.sex = sex;
    }

    public PetType getTypes() {
        return types;
    }

    public void setTypes(PetType types) {
        this.types = types;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Store getPetStore() {
        return petStore;
    }

    public void setPetStore(Store petStore) {
        this.petStore = petStore;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pet{");
        sb.append("Id=").append(Id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", breed='").append(breed).append('\'');
        sb.append(", sex=").append(sex);
        sb.append(", types=").append(types);
        sb.append(", age=").append(age);
        sb.append(", birthDate=").append(birthDate);
        sb.append('}');
        return sb.toString();
    }
}
