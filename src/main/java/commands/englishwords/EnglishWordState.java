package commands.englishwords;

import bot.MessengerSingleton;

public abstract class EnglishWordState {
    protected EnglishWordCommandContext context;
    protected MessengerSingleton messengerInstance = MessengerSingleton.getInstance();
    protected DictionarySingleton dictionaryInstance = DictionarySingleton.getInstance();

    public EnglishWordState(EnglishWordCommandContext context) {
        this.context = context;
    }


    abstract void onEntry();
    abstract void doAction();
}
