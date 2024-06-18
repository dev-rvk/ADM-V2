package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.layout.Measurable;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: LayoutNodeLayoutDelegate.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a9\u0010\u0002\u001a\u00020\u0003\"\b\b\u0000\u0010\u0004*\u00020\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00040\nH\u0082\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"MeasuredTwiceErrorMessage", "", "updateChildMeasurables", "", "T", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/node/LayoutNode;", "destination", "Landroidx/compose/runtime/collection/MutableVector;", "transform", "Lkotlin/Function1;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LayoutNodeLayoutDelegateKt {
    private static final String MeasuredTwiceErrorMessage = "measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()";

    private static final <T extends Measurable> void updateChildMeasurables(LayoutNode $this$updateChildMeasurables, MutableVector<T> mutableVector, Function1<? super LayoutNode, ? extends T> function1) {
        MutableVector this_$iv$iv = $this$updateChildMeasurables.get_children$ui_release();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv > 0) {
            int i$iv$iv = 0;
            Object[] content$iv$iv = this_$iv$iv.getContent();
            do {
                LayoutNode layoutNode = (LayoutNode) content$iv$iv[i$iv$iv];
                int i = i$iv$iv;
                if (mutableVector.getSize() <= i) {
                    mutableVector.add(function1.invoke(layoutNode));
                } else {
                    mutableVector.set(i, function1.invoke(layoutNode));
                }
                i$iv$iv++;
            } while (i$iv$iv < size$iv$iv);
        }
        mutableVector.removeRange($this$updateChildMeasurables.getChildren$ui_release().size(), mutableVector.getSize());
    }
}
