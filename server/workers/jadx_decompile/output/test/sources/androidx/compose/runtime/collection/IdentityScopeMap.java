package androidx.compose.runtime.collection;

import androidx.autofill.HintConstants;
import androidx.compose.runtime.ActualJvm_jvmKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IdentityScopeMap.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001b\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00028\u0000¢\u0006\u0002\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u0011\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u0002H\u0086\u0002J\u0012\u0010\"\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00022\u0006\u0010%\u001a\u00020\fH\u0002J7\u0010&\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u00022!\u0010'\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001f0(H\u0086\bø\u0001\u0000J\u0016\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\u001b\u001a\u00020\u0002H\u0002J\u001b\u0010,\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00028\u0000¢\u0006\u0002\u0010\u001dJ\u0013\u0010-\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00028\u0000¢\u0006\u0002\u0010.J/\u0010/\u001a\u00020\u001f2!\u00100\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001a0(H\u0086\bø\u0001\u0000J#\u00101\u001a\u00020\u001f2\u0018\u00102\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0004\u0012\u00020\u001f0(H\u0082\bJ\u0016\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u00104\u001a\u00020\fH\u0002R<\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00060\u00052\u0014\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00060\u0005@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R0\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00065"}, d2 = {"Landroidx/compose/runtime/collection/IdentityScopeMap;", "T", "", "()V", "<set-?>", "", "Landroidx/compose/runtime/collection/IdentityArraySet;", "scopeSets", "getScopeSets", "()[Landroidx/compose/runtime/collection/IdentityArraySet;", "[Landroidx/compose/runtime/collection/IdentityArraySet;", "size", "", "getSize", "()I", "setSize", "(I)V", "", "valueOrder", "getValueOrder", "()[I", "values", "getValues", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "add", "", "value", "scope", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "clear", "", "contains", "element", "find", "findExactIndex", "midIndex", "valueHash", "forEachScopeOf", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "getOrCreateIdentitySet", "remove", "removeScope", "(Ljava/lang/Object;)V", "removeValueIf", "predicate", "removingScopes", "removalOperation", "scopeSetAt", "index", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class IdentityScopeMap<T> {
    private IdentityArraySet<T>[] scopeSets;
    private int size;
    private int[] valueOrder;
    private Object[] values;

    public IdentityScopeMap() {
        int[] iArr = new int[50];
        for (int i = 0; i < 50; i++) {
            iArr[i] = i;
        }
        this.valueOrder = iArr;
        this.values = new Object[50];
        this.scopeSets = new IdentityArraySet[50];
    }

    public static final /* synthetic */ int access$find(IdentityScopeMap $this, Object value) {
        return $this.find(value);
    }

    public static final /* synthetic */ IdentityArraySet access$scopeSetAt(IdentityScopeMap $this, int index) {
        return $this.scopeSetAt(index);
    }

    public final int[] getValueOrder() {
        return this.valueOrder;
    }

    public final Object[] getValues() {
        return this.values;
    }

    public final IdentityArraySet<T>[] getScopeSets() {
        return this.scopeSets;
    }

    public final int getSize() {
        return this.size;
    }

    public final void setSize(int i) {
        this.size = i;
    }

    public final IdentityArraySet<T> scopeSetAt(int index) {
        IdentityArraySet<T> identityArraySet = this.scopeSets[this.valueOrder[index]];
        Intrinsics.checkNotNull(identityArraySet);
        return identityArraySet;
    }

    public final boolean add(Object value, T scope) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IdentityArraySet valueSet = getOrCreateIdentitySet(value);
        return valueSet.add(scope);
    }

    public final boolean contains(Object element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return find(element) >= 0;
    }

    public final void forEachScopeOf(Object value, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(block, "block");
        int index = find(value);
        if (index >= 0) {
            IdentityArraySet this_$iv = scopeSetAt(index);
            Object[] values$iv = this_$iv.getValues();
            int size = this_$iv.size();
            for (int i$iv = 0; i$iv < size; i$iv++) {
                Object obj = values$iv[i$iv];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                block.invoke(obj);
            }
        }
    }

    private final IdentityArraySet<T> getOrCreateIdentitySet(Object value) {
        int index;
        int[] newKeyOrder;
        Object[] newValues;
        IdentityArraySet[] newScopeSets;
        int size = this.size;
        int[] valueOrder = this.valueOrder;
        Object[] values = this.values;
        IdentityArraySet[] scopeSets = this.scopeSets;
        if (size > 0) {
            int index2 = find(value);
            if (index2 < 0) {
                index = index2;
            } else {
                return scopeSetAt(index2);
            }
        } else {
            index = -1;
        }
        int insertIndex = -(index + 1);
        if (size < valueOrder.length) {
            int valueIndex = valueOrder[size];
            values[valueIndex] = value;
            IdentityArraySet it = scopeSets[valueIndex];
            if (it == null) {
                it = new IdentityArraySet();
                scopeSets[valueIndex] = it;
            }
            if (insertIndex < size) {
                ArraysKt.copyInto(valueOrder, valueOrder, insertIndex + 1, insertIndex, size);
            }
            valueOrder[insertIndex] = valueIndex;
            this.size++;
            return it;
        }
        int newSize = valueOrder.length * 2;
        Object[] copyOf = Arrays.copyOf(scopeSets, newSize);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        IdentityArraySet[] newScopeSets2 = (IdentityArraySet[]) copyOf;
        IdentityArraySet scopeSet = new IdentityArraySet();
        newScopeSets2[size] = scopeSet;
        Object[] newValues2 = Arrays.copyOf(values, newSize);
        Intrinsics.checkNotNullExpressionValue(newValues2, "copyOf(this, newSize)");
        newValues2[size] = value;
        int[] newKeyOrder2 = new int[newSize];
        for (int i = size + 1; i < newSize; i++) {
            newKeyOrder2[i] = i;
        }
        if (insertIndex < size) {
            ArraysKt.copyInto(valueOrder, newKeyOrder2, insertIndex + 1, insertIndex, size);
        }
        newKeyOrder2[insertIndex] = size;
        if (insertIndex > 0) {
            newKeyOrder = newKeyOrder2;
            newValues = newValues2;
            newScopeSets = newScopeSets2;
            ArraysKt.copyInto$default(valueOrder, newKeyOrder2, 0, 0, insertIndex, 6, (Object) null);
        } else {
            newKeyOrder = newKeyOrder2;
            newValues = newValues2;
            newScopeSets = newScopeSets2;
        }
        this.scopeSets = newScopeSets;
        this.values = newValues;
        this.valueOrder = newKeyOrder;
        this.size++;
        return scopeSet;
    }

    public final void clear() {
        IdentityArraySet[] scopeSets = this.scopeSets;
        int[] valueOrder = this.valueOrder;
        Object[] values = this.values;
        int length = scopeSets.length;
        for (int i = 0; i < length; i++) {
            IdentityArraySet identityArraySet = scopeSets[i];
            if (identityArraySet != null) {
                identityArraySet.clear();
            }
            valueOrder[i] = i;
            values[i] = null;
        }
        this.size = 0;
    }

    public final boolean remove(Object value, T scope) {
        int valueOrderIndex;
        IdentityArraySet set;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(scope, "scope");
        int index = find(value);
        int[] valueOrder = this.valueOrder;
        IdentityArraySet[] scopeSets = this.scopeSets;
        Object[] values = this.values;
        int size = this.size;
        if (index < 0 || (set = scopeSets[(valueOrderIndex = valueOrder[index])]) == null) {
            return false;
        }
        boolean removed = set.remove(scope);
        if (set.size() == 0) {
            int startIndex = index + 1;
            if (startIndex < size) {
                ArraysKt.copyInto(valueOrder, valueOrder, index, startIndex, size);
            }
            int newSize = size - 1;
            valueOrder[newSize] = valueOrderIndex;
            values[valueOrderIndex] = null;
            this.size = newSize;
        }
        return removed;
    }

    public final void removeValueIf(Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int $i$f$removeValueIf = 0;
        int $i$f$removingScopes = 0;
        int[] valueOrder$iv = getValueOrder();
        IdentityArraySet[] scopeSets$iv = getScopeSets();
        Object[] values$iv = getValues();
        int destinationIndex$iv = 0;
        int i$iv = 0;
        int size = getSize();
        while (i$iv < size) {
            int valueIndex$iv = valueOrder$iv[i$iv];
            IdentityArraySet set$iv = scopeSets$iv[valueIndex$iv];
            Intrinsics.checkNotNull(set$iv);
            Object[] values$iv2 = set$iv.getValues();
            int size$iv = set$iv.size();
            int $i$f$removeValueIf2 = $i$f$removeValueIf;
            int destinationIndex$iv2 = 0;
            int destinationIndex$iv3 = $i$f$removingScopes;
            int $i$f$removingScopes2 = 0;
            while ($i$f$removingScopes2 < size$iv) {
                IdentityArraySet[] scopeSets$iv2 = scopeSets$iv;
                Object item$iv = values$iv2[$i$f$removingScopes2];
                int i = size;
                Intrinsics.checkNotNull(item$iv, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                if (!predicate.invoke(item$iv).booleanValue()) {
                    if (destinationIndex$iv2 != $i$f$removingScopes2) {
                        values$iv2[destinationIndex$iv2] = item$iv;
                    }
                    destinationIndex$iv2++;
                }
                $i$f$removingScopes2++;
                scopeSets$iv = scopeSets$iv2;
                size = i;
            }
            IdentityArraySet[] scopeSets$iv3 = scopeSets$iv;
            int i2 = size;
            for (int i$iv2 = destinationIndex$iv2; i$iv2 < size$iv; i$iv2++) {
                values$iv2[i$iv2] = null;
            }
            set$iv.size = destinationIndex$iv2;
            if (set$iv.size() > 0) {
                if (destinationIndex$iv != i$iv) {
                    int destinationKeyOrder$iv = valueOrder$iv[destinationIndex$iv];
                    valueOrder$iv[destinationIndex$iv] = valueIndex$iv;
                    valueOrder$iv[i$iv] = destinationKeyOrder$iv;
                }
                destinationIndex$iv++;
            }
            i$iv++;
            $i$f$removingScopes = destinationIndex$iv3;
            scopeSets$iv = scopeSets$iv3;
            $i$f$removeValueIf = $i$f$removeValueIf2;
            size = i2;
        }
        int size2 = getSize();
        for (int i$iv3 = destinationIndex$iv; i$iv3 < size2; i$iv3++) {
            values$iv[valueOrder$iv[i$iv3]] = null;
        }
        setSize(destinationIndex$iv);
    }

    public final void removeScope(T scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        int[] valueOrder$iv = getValueOrder();
        IdentityArraySet[] scopeSets$iv = getScopeSets();
        Object[] values$iv = getValues();
        int destinationIndex$iv = 0;
        int size = getSize();
        for (int i$iv = 0; i$iv < size; i$iv++) {
            int valueIndex$iv = valueOrder$iv[i$iv];
            IdentityArraySet set$iv = scopeSets$iv[valueIndex$iv];
            Intrinsics.checkNotNull(set$iv);
            set$iv.remove(scope);
            if (set$iv.size() > 0) {
                if (destinationIndex$iv != i$iv) {
                    int destinationKeyOrder$iv = valueOrder$iv[destinationIndex$iv];
                    valueOrder$iv[destinationIndex$iv] = valueIndex$iv;
                    valueOrder$iv[i$iv] = destinationKeyOrder$iv;
                }
                destinationIndex$iv++;
            }
        }
        int size2 = getSize();
        for (int i$iv2 = destinationIndex$iv; i$iv2 < size2; i$iv2++) {
            values$iv[valueOrder$iv[i$iv2]] = null;
        }
        setSize(destinationIndex$iv);
    }

    private final void removingScopes(Function1<? super IdentityArraySet<T>, Unit> removalOperation) {
        int[] valueOrder = getValueOrder();
        IdentityArraySet[] scopeSets = getScopeSets();
        Object[] values = getValues();
        int destinationIndex = 0;
        int size = getSize();
        for (int i = 0; i < size; i++) {
            int valueIndex = valueOrder[i];
            IdentityArraySet set = scopeSets[valueIndex];
            Intrinsics.checkNotNull(set);
            removalOperation.invoke(set);
            if (set.size() > 0) {
                if (destinationIndex != i) {
                    int destinationKeyOrder = valueOrder[destinationIndex];
                    valueOrder[destinationIndex] = valueIndex;
                    valueOrder[i] = destinationKeyOrder;
                }
                destinationIndex++;
            }
        }
        int size2 = getSize();
        for (int i2 = destinationIndex; i2 < size2; i2++) {
            values[valueOrder[i2]] = null;
        }
        setSize(destinationIndex);
    }

    public final int find(Object value) {
        int valueIdentity = ActualJvm_jvmKt.identityHashCode(value);
        int low = 0;
        int high = this.size - 1;
        Object[] values = this.values;
        int[] valueOrder = this.valueOrder;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            Object midValue = values[valueOrder[mid]];
            int midValHash = ActualJvm_jvmKt.identityHashCode(midValue);
            if (midValHash < valueIdentity) {
                low = mid + 1;
            } else {
                if (midValHash <= valueIdentity) {
                    return value == midValue ? mid : findExactIndex(mid, value, valueIdentity);
                }
                high = mid - 1;
            }
        }
        return -(low + 1);
    }

    private final int findExactIndex(int midIndex, Object value, int valueHash) {
        Object[] values = this.values;
        int[] valueOrder = this.valueOrder;
        for (int i = midIndex - 1; -1 < i; i--) {
            Object v = values[valueOrder[i]];
            if (v == value) {
                return i;
            }
            if (ActualJvm_jvmKt.identityHashCode(v) != valueHash) {
                break;
            }
        }
        int i2 = this.size;
        for (int i3 = midIndex + 1; i3 < i2; i3++) {
            Object v2 = values[valueOrder[i3]];
            if (v2 == value) {
                return i3;
            }
            if (ActualJvm_jvmKt.identityHashCode(v2) != valueHash) {
                return -(i3 + 1);
            }
        }
        int i4 = this.size;
        return -(i4 + 1);
    }
}
