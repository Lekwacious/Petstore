package com.petstore.service.pet;

import com.petstore.models.Pet;
import com.petstore.repository.PetRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class PetServiceTest {
    @Mock
    PetRepository petRepository;

    @InjectMocks
    PetService petService;
    Pet testPet;

    @BeforeEach
    void SetUp(){
        petService = new PetServiceImp();
        testPet = new Pet();
        MockitoAnnotations.initMocks(this);
    }

    @AfterEach
    void tearDown(){

    }

    @Test
    void save(){
        when(petService.save(testPet)).thenReturn(testPet);
        petService.save(testPet);

        verify(petRepository, times(1)).save(testPet);

    }
    @Test

    void findById(){
        when(petService.findById(1)).thenReturn(Optional.of(Pet.class));
        petService.findById(1);
        verify(petRepository, times(1)).save(testPet);
    }

}