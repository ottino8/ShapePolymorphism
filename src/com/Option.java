package com;

import java.util.HashMap;

public enum Option {
    CREATE(1),
    COORDS(2),
    AREA(3),
    VOLUME(4),
    INFOS(5),
    LAST(6),
    EXIT(7);

    private int optCode;

    private static final HashMap<Integer, Option> codeMap = new HashMap<>();

    static {
        for (Option option : values()) {
            codeMap.put(option.optCode, option);
        }
    }

    private Option(int opt) {
        optCode = opt;
    }

    public static Option fromCode(int opt) {
        return codeMap.get(opt);
    }
}
