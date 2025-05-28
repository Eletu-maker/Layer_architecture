package data.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AccessCode {
    private String token;
    private long id;
    private LocalDate creationDate;
    private LocalDate usedDate;
    private LocalDate expirationDate;
    private boolean active;
    private Visitor visitor;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreationDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return creationDate.format(formatter) ;
    }

    public void setCreationDate() {
        this.creationDate = LocalDate.now();
        this.setExpirationDate();
    }

    public String getUsedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return usedDate.format(formatter);
    }

    public void setUsedDate(LocalDate usedDate) {
        this.usedDate = LocalDate.now();
    }

    public String getExpirationDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return expirationDate.format(formatter);
    }

    public void setExpirationDate() {
        this.expirationDate = this.creationDate.plusDays(3);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }
}
