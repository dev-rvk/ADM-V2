package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;

/* compiled from: TrieNode.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u0018\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a7\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\"\u0004\b\u0000\u0010\u000b*\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\f\u001a\u0002H\u000bH\u0002¢\u0006\u0002\u0010\r\u001aL\u0010\u000e\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00012\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00130\u0012H\u0082\b¢\u0006\u0002\u0010\u0014\u001a)\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t*\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\u0016\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"LOG_MAX_BRANCHING_FACTOR", "", "MAX_BRANCHING_FACTOR", "MAX_BRANCHING_FACTOR_MINUS_ONE", "MAX_SHIFT", "indexSegment", "index", "shift", "addElementAtIndex", "", "", "E", "element", "([Ljava/lang/Object;ILjava/lang/Object;)[Ljava/lang/Object;", "filterTo", "newArray", "newArrayOffset", "predicate", "Lkotlin/Function1;", "", "([Ljava/lang/Object;[Ljava/lang/Object;ILkotlin/jvm/functions/Function1;)I", "removeCellAtIndex", "cellIndex", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TrieNodeKt {
    public static final int LOG_MAX_BRANCHING_FACTOR = 5;
    public static final int MAX_BRANCHING_FACTOR = 32;
    public static final int MAX_BRANCHING_FACTOR_MINUS_ONE = 31;
    public static final int MAX_SHIFT = 30;

    public static final int indexSegment(int index, int shift) {
        return (index >> shift) & 31;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E> Object[] addElementAtIndex(Object[] $this$addElementAtIndex, int index, E e) {
        Object[] newBuffer = new Object[$this$addElementAtIndex.length + 1];
        ArraysKt.copyInto$default($this$addElementAtIndex, newBuffer, 0, 0, index, 6, (Object) null);
        ArraysKt.copyInto($this$addElementAtIndex, newBuffer, index + 1, index, $this$addElementAtIndex.length);
        newBuffer[index] = e;
        return newBuffer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object[] removeCellAtIndex(Object[] $this$removeCellAtIndex, int cellIndex) {
        Object[] newBuffer = new Object[$this$removeCellAtIndex.length - 1];
        ArraysKt.copyInto$default($this$removeCellAtIndex, newBuffer, 0, 0, cellIndex, 6, (Object) null);
        ArraysKt.copyInto($this$removeCellAtIndex, newBuffer, cellIndex, cellIndex + 1, $this$removeCellAtIndex.length);
        return newBuffer;
    }

    static /* synthetic */ int filterTo$default(Object[] $this$filterTo_u24default, Object[] newArray, int newArrayOffset, Function1 predicate, int i, Object obj) {
        if ((i & 2) != 0) {
            newArrayOffset = 0;
        }
        if ((i & 4) != 0) {
            Function1 predicate2 = new Function1<Object, Boolean>() { // from class: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNodeKt$filterTo$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Object it) {
                    return Boolean.valueOf(it != TrieNode.INSTANCE.getEMPTY$runtime_release());
                }
            };
            predicate = predicate2;
        }
        int i2 = 0;
        int j = 0;
        while (i2 < $this$filterTo_u24default.length) {
            CommonFunctionsKt.m2595assert(j <= i2);
            Object e = $this$filterTo_u24default[i2];
            if (((Boolean) predicate.invoke(e)).booleanValue()) {
                newArray[newArrayOffset + j] = $this$filterTo_u24default[i2];
                j++;
                CommonFunctionsKt.m2595assert(newArrayOffset + j <= newArray.length);
            }
            i2++;
        }
        return j;
    }

    private static final int filterTo(Object[] $this$filterTo, Object[] newArray, int newArrayOffset, Function1<Object, Boolean> function1) {
        int i = 0;
        int j = 0;
        while (i < $this$filterTo.length) {
            CommonFunctionsKt.m2595assert(j <= i);
            Object e = $this$filterTo[i];
            if (function1.invoke(e).booleanValue()) {
                newArray[newArrayOffset + j] = $this$filterTo[i];
                j++;
                CommonFunctionsKt.m2595assert(newArrayOffset + j <= newArray.length);
            }
            i++;
        }
        return j;
    }
}
