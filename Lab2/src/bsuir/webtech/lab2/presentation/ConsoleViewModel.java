package bsuir.webtech.lab2.presentation;

public abstract class ConsoleViewModel {

    /**
     * Get ViewModel data
     * @return
     */
    public abstract String getText();

    /**
     * Process input, return next {@link ConsoleViewModel}
     * <p>
     * Throw {@link java.lang.IllegalArgumentException} on wrong input argument
     * @param input
     * @return ConsoleViewModel
     * @throws IllegalArgumentException
     */
    public abstract ConsoleViewModel processInput(String input);
}
