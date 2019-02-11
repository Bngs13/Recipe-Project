package com.group.artifact.repository;

import com.group.artifact.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
//20190211, integration Test
@RunWith(SpringRunner.class)
@DataJpaTest //it will bring up an embedded db and configure Spring Data JPA
public class UnitOfMeasureRepositoryIT {

    // Spring is going to do dependency injection on this integration test.
    // So the Spring context will start up and we will get an instance of the UnitOfMeasureRepository, inject it into this.
   @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;


    @Before
    public void setUp() throws Exception {
    }

    @Test
    //@DirtiesContext //To restart spring context each time
    public void findByDescription(){
        Optional<UnitOfMeasure> uomOptional=unitOfMeasureRepository.findByDescription("Teaspoon");
        assertEquals("Teaspoon",uomOptional.get().getDescription());
    }
}