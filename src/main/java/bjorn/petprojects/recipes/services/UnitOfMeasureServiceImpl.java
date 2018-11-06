package bjorn.petprojects.recipes.services;

import bjorn.petprojects.recipes.commands.UnitOfMeasureCommand;
import bjorn.petprojects.recipes.converters.UnitOfMeasureToUnitOfMeasureCommand;
import bjorn.petprojects.recipes.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private final UnitOfMeasureRepository unitOfmeasureRepository;
    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfmeasureRepository, UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
        this.unitOfmeasureRepository = unitOfmeasureRepository;
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
    }

    @Override
    public Set<UnitOfMeasureCommand> listAllUoms() {
        return StreamSupport.stream(unitOfmeasureRepository.findAll()
        .spliterator(), false)
                .map(unitOfMeasureToUnitOfMeasureCommand :: convert)
                .collect(Collectors.toSet());
    }
}
