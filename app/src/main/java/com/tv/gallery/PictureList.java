package com.tv.gallery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PictureList {


    static final String PICTURE_NAMES[] = {
            "picture1",
            "picture2",
            "picture3",
            "picture4",
            "picture5",
    };

    private static List<String> list;

    public static List<String> getList() {
        if (list == null) {
            list = setupPictures();
        }
        return list;
    }

    static List<String> setupPictures() {
        list = new ArrayList<>(Arrays.asList(PICTURE_NAMES));
        return list;
    }

}
