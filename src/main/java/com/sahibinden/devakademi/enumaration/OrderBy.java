package com.sahibinden.devakademi.enumaration;

public enum OrderBy  {

    TITLE("title"),
    DESCRIPTION("description"),
    PRICE("price"),
    HAS_PROMOTION("has_promotion"),
    VIEW_COUNT("view_count"),
    CITY("city"),
    TOWN("town"),
    C0("c0"),
    C1("c1"),
    C2("c2"),
    C3("c3"),
    C4("c4"),
    C5("c5"),
    C6("c6");

    private String orderByCode;

    private OrderBy(String orderBy) {
        this.orderByCode = orderBy;
    }

    public String getOrderByCode() {
        return this.orderByCode;
    }
}