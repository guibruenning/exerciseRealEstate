package com.enums;

public enum Origin {
    FACEBOOK(0), INSTAGRAM(1), GOOGLE(2), SITE(3), OTHER(4);

    private int value;

    Origin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
