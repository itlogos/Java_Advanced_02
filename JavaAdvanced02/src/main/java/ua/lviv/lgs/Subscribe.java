package ua.lviv.lgs;

import java.time.LocalDate;

public class Subscribe {
    private int id;
    private int userID;
    private int filmID;
    private boolean subscribeStatus;
    private LocalDate subscribeDate;
    private int subscribePeriod;

    public Subscribe(int id, int userID, int magazineID, boolean subscribeStatus, LocalDate subscribeDate,
                     int subscribePeriod) {
        this.id = id;
        this.userID = userID;
        this.filmID = magazineID;
        this.subscribeStatus = subscribeStatus;
        this.subscribeDate = subscribeDate;
        this.subscribePeriod = subscribePeriod;
    }

    public Subscribe(int userID, int magazineID, boolean subscribeStatus, LocalDate subscribeDate,
                     int subscribePeriod) {
        this.userID = userID;
        this.filmID = magazineID;
        this.subscribeStatus = subscribeStatus;
        this.subscribeDate = subscribeDate;
        this.subscribePeriod = subscribePeriod;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getFilmID() {
        return filmID;
    }

    public void setFilmID(int magazineID) {
        this.filmID = magazineID;
    }

    public boolean getSubscribeStatus() {
        return subscribeStatus;
    }

    public void setSubscribeStatus(boolean subscribeStatus) {
        this.subscribeStatus = subscribeStatus;
    }

    public LocalDate getSubscribeDate() {
        return subscribeDate;
    }

    public void setSubscribeDate(LocalDate subscribeDate) {
        this.subscribeDate = subscribeDate;
    }

    public int getSubscribePeriod() {
        return subscribePeriod;
    }

    public void setSubscribePeriod(int subscribePeriod) {
        this.subscribePeriod = subscribePeriod;
    }

    @Override
    public String toString() {
        if (id == 0)
            return "userID#" + userID + ", filmID#" + filmID + ", Підписка оформлена: " + subscribeStatus
                    + ", Дата оформлення: " + subscribeDate + ", Резерв: " + subscribePeriod
                    + " мес.";
        else
            return "Subscribe ID#" + id + ": userID#" + userID + ", filmID#" + filmID
                    + ", Підписка оформлена: " + subscribeStatus + ", Дата оформлення: " + subscribeDate
                    + ", Резерв: " + subscribePeriod + " мес.";
    }
}