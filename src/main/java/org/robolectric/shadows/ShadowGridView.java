package org.robolectric.shadows;

import android.widget.GridView;
import org.robolectric.internal.Implements;

@SuppressWarnings({"UnusedDeclaration"})
@Implements(value = GridView.class, callThroughByDefault = true)
public class ShadowGridView extends ShadowAdapterView {
//    @RealObject private GridView realGridView;
//
//    @Implementation
//    public void setAdapter(ListAdapter adapter) {
//        super.setAdapter(adapter);
//    }
}
