package commands.conditionals;

import bot.MessengerSingleton;

public interface ConditionalState {
    void onEntry();
    void doAction();
}
