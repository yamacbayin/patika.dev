package com.yamacbayin.erp.model;

public enum OrderStatusEnum {
    CANCELLED(0, "Cancelled"),
    AWAITING_CONFIRMATION(1, "Awaiting confirmation"),
    CONFIRMED(2, "Confirmed"),
    SHIPPED(3, "Shipped"),
    COMPLETED(4, "Completed");

    private int value;
    private String text;

    OrderStatusEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    /**
     * Gets the numeric value of the order status.
     *
     * @return The numeric value.
     */
    public int getValue() {
        return value;
    }

    /**
     * Gets the human-readable text of the order status.
     *
     * @return The text representation.
     */
    public String getText() {
        return text;
    }

    /**
     * Finds an OrderStatusEnum based on its numeric value.
     *
     * @param value The numeric value to search for.
     * @return The matching OrderStatusEnum, or null if not found.
     */
    public static OrderStatusEnum fromValue(int value) {
        for (OrderStatusEnum status : values()) {
            if (status.value == value) {
                return status;
            }
        }
        return null;
    }

}
