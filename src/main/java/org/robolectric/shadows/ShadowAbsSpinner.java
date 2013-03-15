package org.robolectric.shadows;

import android.widget.AbsSpinner;
import org.robolectric.internal.Implementation;
import org.robolectric.internal.Implements;
import org.robolectric.internal.RealObject;

import static org.robolectric.Robolectric.directlyOn;

@SuppressWarnings({"UnusedDeclaration"})
@Implements(value = AbsSpinner.class, callThroughByDefault = true)
public class ShadowAbsSpinner extends ShadowAdapterView {
    @RealObject AbsSpinner realAbsSpinner;
    private boolean animatedTransition;

//    @Implementation
//    public void setAdapter(SpinnerAdapter adapter) {
//        super.setAdapter(adapter);
//    }
//
//    @Override @Implementation
//    public SpinnerAdapter getAdapter() {
//        return (SpinnerAdapter) super.getAdapter();
//    }

    @Implementation
    public void setSelection(int position, boolean animate) {
        directlyOn(realAbsSpinner).setSelection(position);
        animatedTransition = animate;
    }

    // Non-implementation helper method
    public boolean isAnimatedTransition() {
        return animatedTransition;
    }
}
