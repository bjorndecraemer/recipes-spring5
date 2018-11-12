package bjorn.petprojects.recipes.controllers;

import bjorn.petprojects.recipes.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception exception){
        return GenerateModelAndViewForExceptions(exception, "Handling not found exception", "404error");
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView handleNumberFormatException(Exception exception){
        return GenerateModelAndViewForExceptions(exception, "Handling NumberFormatException", "400error");
    }

    /*
     *Helper method to Generate a @ModelAndView for exceptions
     */
    private ModelAndView GenerateModelAndViewForExceptions(Exception exception, String s, String s2) {
        log.error(s);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(s2);
        modelAndView.addObject("exception", exception);

        return modelAndView;
    }
}
