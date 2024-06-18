package androidx.compose.runtime.collection;

import androidx.autofill.HintConstants;
import androidx.compose.runtime.ActualJvm_jvmKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IdentityArrayMap.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u0017J\u0012\u0010\u0018\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\u0005H\u0002JD\u0010\u001c\u001a\u00020\u001326\u0010\u001d\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00130\u001eH\u0086\bø\u0001\u0000J\u0018\u0010\"\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0016\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010#J\u0006\u0010$\u001a\u00020\u0015J\u0006\u0010%\u001a\u00020\u0015J\u0015\u0010&\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0016\u001a\u00028\u0000¢\u0006\u0002\u0010#JD\u0010'\u001a\u00020\u001326\u0010\u001d\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00150\u001eH\u0086\bø\u0001\u0000J/\u0010(\u001a\u00020\u00132!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00150)H\u0086\bø\u0001\u0000J\u001e\u0010*\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010!\u001a\u00028\u0001H\u0086\u0002¢\u0006\u0002\u0010+R0\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR0\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006,"}, d2 = {"Landroidx/compose/runtime/collection/IdentityArrayMap;", "Key", "", "Value", "capacity", "", "(I)V", "<set-?>", "", "keys", "getKeys", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "size", "getSize", "()I", "values", "getValues", "clear", "", "contains", "", "key", "(Ljava/lang/Object;)Z", "find", "findExactIndex", "midIndex", "keyHash", "forEach", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "value", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "isEmpty", "isNotEmpty", "remove", "removeIf", "removeValueIf", "Lkotlin/Function1;", "set", "(Ljava/lang/Object;Ljava/lang/Object;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class IdentityArrayMap<Key, Value> {
    private Object[] keys;
    private int size;
    private Object[] values;

    public IdentityArrayMap() {
        this(0, 1, null);
    }

    public IdentityArrayMap(int capacity) {
        this.keys = new Object[capacity];
        this.values = new Object[capacity];
    }

    public /* synthetic */ IdentityArrayMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 16 : i);
    }

    public final Object[] getKeys() {
        return this.keys;
    }

    public final Object[] getValues() {
        return this.values;
    }

    public final int getSize() {
        return this.size;
    }

    public final boolean isEmpty() {
        return this.size == 0;
    }

    public final boolean isNotEmpty() {
        return this.size > 0;
    }

    public final boolean contains(Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return find(key) >= 0;
    }

    public final Value get(Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int find = find(key);
        if (find >= 0) {
            return (Value) this.values[find];
        }
        return null;
    }

    public final void set(Key key, Value value) {
        Object[] objArr;
        Object[] destKeys;
        Object[] objArr2;
        Object[] destValues;
        Intrinsics.checkNotNullParameter(key, "key");
        Object[] keys = this.keys;
        Object[] values = this.values;
        int size = this.size;
        int index = find(key);
        if (index >= 0) {
            values[index] = value;
            return;
        }
        int insertIndex = -(index + 1);
        boolean resize = size == keys.length;
        if (resize) {
            objArr = new Object[size * 2];
        } else {
            objArr = keys;
        }
        Object[] destKeys2 = objArr;
        ArraysKt.copyInto(keys, destKeys2, insertIndex + 1, insertIndex, size);
        if (!resize) {
            destKeys = destKeys2;
        } else {
            destKeys = destKeys2;
            ArraysKt.copyInto$default(keys, destKeys2, 0, 0, insertIndex, 6, (Object) null);
        }
        destKeys[insertIndex] = key;
        this.keys = destKeys;
        if (resize) {
            objArr2 = new Object[size * 2];
        } else {
            objArr2 = values;
        }
        Object[] destValues2 = objArr2;
        ArraysKt.copyInto(values, destValues2, insertIndex + 1, insertIndex, size);
        if (!resize) {
            destValues = destValues2;
        } else {
            destValues = destValues2;
            ArraysKt.copyInto$default(values, destValues2, 0, 0, insertIndex, 6, (Object) null);
        }
        destValues[insertIndex] = value;
        this.values = destValues;
        this.size++;
    }

    public final Value remove(Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int find = find(key);
        if (find < 0) {
            return null;
        }
        Value value = (Value) this.values[find];
        int i = this.size;
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        ArraysKt.copyInto(objArr, objArr, find, find + 1, i);
        ArraysKt.copyInto(objArr2, objArr2, find, find + 1, i);
        int i2 = i - 1;
        objArr[i2] = null;
        objArr2[i2] = null;
        this.size = i2;
        return value;
    }

    public final void clear() {
        this.size = 0;
        ArraysKt.fill$default(this.keys, (Object) null, 0, 0, 6, (Object) null);
        ArraysKt.fill$default(this.values, (Object) null, 0, 0, 6, (Object) null);
    }

    public final void removeIf(Function2<? super Key, ? super Value, Boolean> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        int current = 0;
        int size = getSize();
        for (int index = 0; index < size; index++) {
            Object key = getKeys()[index];
            Intrinsics.checkNotNull(key, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
            Object value = getValues()[index];
            if (!block.invoke(key, value).booleanValue()) {
                if (current != index) {
                    getKeys()[current] = key;
                    getValues()[current] = getValues()[index];
                }
                current++;
            }
        }
        int index2 = getSize();
        if (index2 > current) {
            int size2 = getSize();
            for (int index3 = current; index3 < size2; index3++) {
                getKeys()[index3] = null;
                getValues()[index3] = null;
            }
            this.size = current;
        }
    }

    public final void removeValueIf(Function1<? super Value, Boolean> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        int current$iv = 0;
        int size = getSize();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object key$iv = getKeys()[index$iv];
            Intrinsics.checkNotNull(key$iv, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
            Object value$iv = getValues()[index$iv];
            if (!block.invoke(value$iv).booleanValue()) {
                if (current$iv != index$iv) {
                    getKeys()[current$iv] = key$iv;
                    getValues()[current$iv] = getValues()[index$iv];
                }
                current$iv++;
            }
        }
        int index$iv2 = getSize();
        if (index$iv2 <= current$iv) {
            return;
        }
        int size2 = getSize();
        for (int index$iv3 = current$iv; index$iv3 < size2; index$iv3++) {
            getKeys()[index$iv3] = null;
            getValues()[index$iv3] = null;
        }
        this.size = current$iv;
    }

    public final void forEach(Function2<? super Key, ? super Value, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        int size = getSize();
        for (int index = 0; index < size; index++) {
            Object obj = getKeys()[index];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
            block.invoke(obj, getValues()[index]);
        }
    }

    private final int find(Object key) {
        int keyIdentity = ActualJvm_jvmKt.identityHashCode(key);
        int low = 0;
        int high = this.size - 1;
        Object[] keys = this.keys;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            Object midKey = keys[mid];
            int midKeyHash = ActualJvm_jvmKt.identityHashCode(midKey);
            if (midKeyHash < keyIdentity) {
                low = mid + 1;
            } else {
                if (midKeyHash <= keyIdentity) {
                    return key == midKey ? mid : findExactIndex(mid, key, keyIdentity);
                }
                high = mid - 1;
            }
        }
        return -(low + 1);
    }

    private final int findExactIndex(int midIndex, Object key, int keyHash) {
        Object[] keys = this.keys;
        int size = this.size;
        for (int i = midIndex - 1; -1 < i; i--) {
            Object k = keys[i];
            if (k == key) {
                return i;
            }
            if (ActualJvm_jvmKt.identityHashCode(k) != keyHash) {
                break;
            }
        }
        for (int i2 = midIndex + 1; i2 < size; i2++) {
            Object k2 = keys[i2];
            if (k2 == key) {
                return i2;
            }
            if (ActualJvm_jvmKt.identityHashCode(k2) != keyHash) {
                return -(i2 + 1);
            }
        }
        int i3 = size + 1;
        return -i3;
    }
}
