package com.example.ttbback.entity;


public enum Note {
    ZERO(0),
    UN(1),
    DEUX(2),
    TROIS(3),
    QUATRE(4),
    CINQ(5),
    ;
    private final int value;

     Note(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Note parse(int valeur) {
        Note note = null; // Default
        for (Note stars : Note.values()) {
            if (stars.getValue()==valeur) {
                note = stars;
                break;
            }
        }
        return note;
    }

}
