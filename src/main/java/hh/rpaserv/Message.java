package hh.rpaserv;

public class Message {
    private String id;
    private String botip;
    private String message;
    private String botuser;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBotip() {
        return botip;
    }

    public void setBotip(String from) {
        this.botip = from;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBotuser() {
        return botuser;
    }

    public void setBotuser(String botuser) {
        this.botuser = botuser;
    }

    @Override
    public String toString() {
        return "Message [id = " + id + ", botip = " + botip + ", botuser = " + botuser + ", message=" + message + "]";
    }
}
