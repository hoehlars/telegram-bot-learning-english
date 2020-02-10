package ch.commands.conditionals;

import ch.bot.MessengerSingleton;
import ch.commands.exerciseSingletons.ConditionalTaskSingleton;

public abstract class ConditionalState {
    protected ConditionalsCommandContext context;
    protected MessengerSingleton messengerInstance = MessengerSingleton.getInstance();
    protected ConditionalTaskSingleton conditionalTaskSingleton = ConditionalTaskSingleton.getInstance();

    public ConditionalState(ConditionalsCommandContext context) {
        this.context = context;
    }

    public abstract void onEntry();
    public abstract void doAction();
}
