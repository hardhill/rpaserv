package hh.rpaserv;

import java.util.Date;

public class BotMessage {
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getBotIp() {
        return BotIp;
    }

    public void setBotIp(String botIp) {
        BotIp = botIp;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }


    private String Id;
    private String BotIp;
    private String Message;


    @Override
    public String toString() {
        return "BotMessage{" +
                "Id='" + Id + '\'' +
                ", BotIp='" + BotIp + '\'' +
                ", Message='" + Message + '\'' +
                '}';
    }
}
