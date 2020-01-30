package bot;

import commands.Command;
import commands.englishwords.EnglishWordCommandContext;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LanguageLernBot extends org.telegram.telegrambots.bots.TelegramLongPollingBot implements MessengerObserver {
    private Command currentCommand;
    private MessengerSingleton messengerSingleton;
    private String BOT_TOKEN;
    private String BOT_NAME;

    public LanguageLernBot() {
        currentCommand = null;
        messengerSingleton = MessengerSingleton.getInstance();
        messengerSingleton.attach(this);
        readProperties();
    }

    public void onUpdateReceived(Update update) {
        String command = update.getMessage().getText();
        setCommandByText(command);


        messengerSingleton.setChatId(update.getMessage().getChatId());


        if(currentCommand != null) {
            currentCommand.execute(update);
        }
    }

    private void setCommandByText(String commandString) {
        switch(commandString) {
            case Command.ENGLISH_WORD_CMD:
                currentCommand = new EnglishWordCommandContext();
                break;
            case Command.EXIT_CMD:
                currentCommand = null;
                break;
        }
    }



    private void readProperties() {
        try (InputStream input = LanguageLernBot.class.getClassLoader().getResourceAsStream("bot.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            setBotAttributes(prop);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void setBotAttributes(Properties prop) {
        BOT_TOKEN = prop.getProperty("token");
        BOT_NAME = prop.getProperty("name");
    }


    @Override
    public void update(SendMessage sendMessage) {
        try {
            execute(sendMessage);
        } catch (
                TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }
}
