package com.example.hugecolorlist;

import android.graphics.Color;

/**
 * Utility class
 */
public class Util {

    /**
     * Convert item's position to corresponding color
     * @param position The item's position
     * @return The corresponding color
     */
    public static int positionToColor(int position) {
        if(position % 3 == 0 && position % 5 == 0) {
            return Color.YELLOW;
        }
        if(position % 3 == 0) {
            return Color.RED;
        }
        if(position % 5 == 0) {
            return Color.BLUE;
        }
        return Color.WHITE;
    }
}
