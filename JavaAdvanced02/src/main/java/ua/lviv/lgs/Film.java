package ua.lviv.lgs;

import java.time.LocalDate;

 class Film {
    private int id;
    private String title;
    private String description;
    private LocalDate date;
    private int price;

    public Film(int id, String title, String description, LocalDate date, int price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.price = price;
    }

    public Film(String title, String description, LocalDate date, int price) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        if (id == 0)
            return "Фільм \"" + title + "\", " + description + ", Дата виходу: " + date + ", Вартість : "
                    + price / 100 + "." + String.format("%02d", price % 100) + " грн.";
        else
            return "ID# фільма " + id + ": Фільм \"" + title + "\", " + description + ", Дата виходу: " + date
                    + ", Вартість : " + price / 100 + "." + String.format("%02d", price % 100)
                    + " грн.";
    }
}