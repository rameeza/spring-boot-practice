package com.rameez.spring_boot_practice.enums;

public enum PATHS {

    ;

    private String path;

    private PATHS(String p) {
        this.path = p;
    }

    public String getValue() {
        return path;
    }
}
