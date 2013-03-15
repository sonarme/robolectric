package org.robolectric.shadows;

import android.widget.RelativeLayout;
import org.robolectric.internal.Implements;

@Implements(value = RelativeLayout.class, callThroughByDefault = true)
public class ShadowRelativeLayout extends ShadowViewGroup {
}
