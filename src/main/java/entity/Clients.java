package entity;

public class Clients {
    private String clientName;
    private String clientId;

    public Clients() {
    }

    public Clients(String clientName, String clientId) {
        this.clientName = clientName;
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
