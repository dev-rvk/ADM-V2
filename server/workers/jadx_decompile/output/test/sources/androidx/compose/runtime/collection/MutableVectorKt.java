package androidx.compose.runtime.collection;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MutableVector.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0002\b\u0005\u001a!\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0086\b\u001aC\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0014\b\b\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00020\u0007H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002\u001a\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\u0086\b\u001a0\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\n\"\u0002H\u0002H\u0086\b¢\u0006\u0002\u0010\u000b\u001a\u0018\u0010\f\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0002\u001a \u0010\u0010\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2 = {"MutableVector", "Landroidx/compose/runtime/collection/MutableVector;", "T", "capacity", "", "size", "init", "Lkotlin/Function1;", "mutableVectorOf", "elements", "", "([Ljava/lang/Object;)Landroidx/compose/runtime/collection/MutableVector;", "checkIndex", "", "", "index", "checkSubIndex", "fromIndex", "toIndex", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class MutableVectorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkIndex(List<?> list, int index) {
        int size = list.size();
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds. The list has " + size + " elements.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkSubIndex(List<?> list, int fromIndex, int toIndex) {
        int size = list.size();
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException("Indices are out of order. fromIndex (" + fromIndex + ") is greater than toIndex (" + toIndex + ").");
        }
        if (fromIndex < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + fromIndex + ") is less than 0.");
        }
        if (toIndex > size) {
            throw new IndexOutOfBoundsException("toIndex (" + toIndex + ") is more than than the list size (" + size + ')');
        }
    }

    public static /* synthetic */ MutableVector MutableVector$default(int capacity, int i, Object obj) {
        if ((i & 1) != 0) {
            capacity = 16;
        }
        Intrinsics.reifiedOperationMarker(0, "T?");
        return new MutableVector(new Object[capacity], 0);
    }

    public static final /* synthetic */ <T> MutableVector<T> MutableVector(int capacity) {
        Intrinsics.reifiedOperationMarker(0, "T?");
        return new MutableVector<>(new Object[capacity], 0);
    }

    public static final /* synthetic */ <T> MutableVector<T> MutableVector(int size, Function1<? super Integer, ? extends T> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        Intrinsics.reifiedOperationMarker(0, "T");
        Object[] arr = new Object[size];
        for (int i = 0; i < size; i++) {
            arr[i] = init.invoke(Integer.valueOf(i));
        }
        return new MutableVector<>(arr, size);
    }

    public static final /* synthetic */ <T> MutableVector<T> mutableVectorOf() {
        Intrinsics.reifiedOperationMarker(0, "T?");
        return new MutableVector<>(new Object[16], 0);
    }

    public static final /* synthetic */ <T> MutableVector<T> mutableVectorOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return new MutableVector<>(elements, elements.length);
    }
}
