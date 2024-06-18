package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HitPathTracker.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J7\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tH\u0016ø\u0001\u0000J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0006\u0010\u0015\u001a\u00020\u0014J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J7\u0010\u0018\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tH\u0016ø\u0001\u0000J\u0006\u0010\u0019\u001a\u00020\u0014R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/input/pointer/NodeParent;", "", "()V", "children", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/input/pointer/Node;", "getChildren", "()Landroidx/compose/runtime/collection/MutableVector;", "buildCache", "", "changes", "", "Landroidx/compose/ui/input/pointer/PointerId;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "parentCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "cleanUpHits", "", "clear", "dispatchCancel", "dispatchFinalEventPass", "dispatchMainEventPass", "removeDetachedPointerInputFilters", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public class NodeParent {
    private final MutableVector<Node> children = new MutableVector<>(new Node[16], 0);

    public final MutableVector<Node> getChildren() {
        return this.children;
    }

    public boolean buildCache(Map<PointerId, PointerInputChange> changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        Intrinsics.checkNotNullParameter(changes, "changes");
        Intrinsics.checkNotNullParameter(parentCoordinates, "parentCoordinates");
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        boolean changed = false;
        MutableVector this_$iv = this.children;
        int size$iv = this_$iv.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            do {
                Node it = (Node) content$iv[i$iv];
                changed = it.buildCache(changes, parentCoordinates, internalPointerEvent, isInBounds) || changed;
                i$iv++;
            } while (i$iv < size$iv);
        }
        return changed;
    }

    public boolean dispatchMainEventPass(Map<PointerId, PointerInputChange> changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        Intrinsics.checkNotNullParameter(changes, "changes");
        Intrinsics.checkNotNullParameter(parentCoordinates, "parentCoordinates");
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        boolean dispatched = false;
        MutableVector this_$iv = this.children;
        int size$iv = this_$iv.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            do {
                Node it = (Node) content$iv[i$iv];
                dispatched = it.dispatchMainEventPass(changes, parentCoordinates, internalPointerEvent, isInBounds) || dispatched;
                i$iv++;
            } while (i$iv < size$iv);
        }
        return dispatched;
    }

    public boolean dispatchFinalEventPass(InternalPointerEvent internalPointerEvent) {
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        boolean dispatched = false;
        MutableVector this_$iv = this.children;
        int size$iv = this_$iv.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            do {
                Node it = (Node) content$iv[i$iv];
                dispatched = it.dispatchFinalEventPass(internalPointerEvent) || dispatched;
                i$iv++;
            } while (i$iv < size$iv);
        }
        cleanUpHits(internalPointerEvent);
        return dispatched;
    }

    public void dispatchCancel() {
        MutableVector this_$iv = this.children;
        int size$iv = this_$iv.getSize();
        if (size$iv <= 0) {
            return;
        }
        int i$iv = 0;
        Object[] content$iv = this_$iv.getContent();
        do {
            Node it = (Node) content$iv[i$iv];
            it.dispatchCancel();
            i$iv++;
        } while (i$iv < size$iv);
    }

    public final void clear() {
        this.children.clear();
    }

    public final void removeDetachedPointerInputFilters() {
        int index = 0;
        while (index < this.children.getSize()) {
            MutableVector this_$iv = this.children;
            Node child = this_$iv.getContent()[index];
            if (!child.getPointerInputFilter().getIsAttached()) {
                this.children.removeAt(index);
                child.dispatchCancel();
            } else {
                index++;
                child.removeDetachedPointerInputFilters();
            }
        }
    }

    public void cleanUpHits(InternalPointerEvent internalPointerEvent) {
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        MutableVector this_$iv = this.children;
        for (int i = this_$iv.getSize() - 1; -1 < i; i--) {
            MutableVector this_$iv2 = this.children;
            Node child = this_$iv2.getContent()[i];
            if (child.getPointerIds().isEmpty()) {
                this.children.removeAt(i);
            }
        }
    }
}
