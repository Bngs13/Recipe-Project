package com.group.artifact.service.UnitOfMeasure;

import com.group.artifact.domain.UnitOfMeasure;
import com.group.artifact.repository.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class UOMServiceImpl implements UOMService {

    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public UOMServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public Set<UnitOfMeasure> findAll() {
        Set<UnitOfMeasure> set = new HashSet<>();

        for (UnitOfMeasure u : unitOfMeasureRepository.findAll())
            set.add(u);

        return set;
    }
}
