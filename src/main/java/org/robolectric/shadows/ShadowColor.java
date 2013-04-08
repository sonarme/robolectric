package org.robolectric.shadows;

import android.graphics.Color;
import org.robolectric.bytecode.RobolectricInternals;
import org.robolectric.internal.Implementation;
import org.robolectric.internal.Implements;

import static org.fest.reflect.core.Reflection.method;

@Implements(Color.class)
public class ShadowColor {
    @Implementation
    public static int rgb(int red, int green, int blue) {
        return argb(0xff, red, green, blue);
    }

    @Implementation
    public static int argb(int alpha, int red, int green, int blue) {
        return (alpha << 24) | (red << 16) | (green << 8) | blue;
    }

    @Implementation
    public static int parseColor(String colorString) {
        if (colorString.charAt(0) == '#' && colorString.length() == 4 || colorString.length() == 5) {
            StringBuilder buf = new StringBuilder();
            buf.append('#');
            for (int i = 1; i < colorString.length(); i++) {
                buf.append(colorString.charAt(i));
                buf.append(colorString.charAt(i));
            }
            colorString = buf.toString();
        }
        return method(RobolectricInternals.directMethodName(Color.class.getName(), "parseColor"))
                .withReturnType(int.class)
                .withParameterTypes(String.class)
                .in(Color.class)
                .invoke(colorString);
    }
}