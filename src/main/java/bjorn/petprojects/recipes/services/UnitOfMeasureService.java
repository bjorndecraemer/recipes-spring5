package bjorn.petprojects.recipes.services;

import bjorn.petprojects.recipes.commands.UnitOfMeasureCommand;

import java.util.Set;

public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();
}
