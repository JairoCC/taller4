package com.keycode.demo.util.enums;

public enum RolEnum {

    ADMIN(1), USER(2);

    private int idRol;

    RolEnum(int idRol) {
        this.idRol = idRol;
    }

    public Long getIdRol() {
        return (long) idRol;
    }
}
