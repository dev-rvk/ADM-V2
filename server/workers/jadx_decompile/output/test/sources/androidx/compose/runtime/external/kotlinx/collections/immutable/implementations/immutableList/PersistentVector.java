package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: PersistentVector.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010*\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B5\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u001b\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0011J#\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u001d\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0016J\u0016\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\tH\u0096\u0002¢\u0006\u0002\u0010\u0019JG\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\u001dH\u0002¢\u0006\u0002\u0010\u001eJ5\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010 \u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010!J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010\u0012\u001a\u00020\tH\u0016J?\u0010$\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u001dH\u0002¢\u0006\u0002\u0010&J3\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010(\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tH\u0002¢\u0006\u0002\u0010)JC\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0002¢\u0006\u0002\u0010-J?\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\u0006\u0010\u001b\u001a\u00020\t2\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0002¢\u0006\u0002\u0010/J\"\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020302H\u0016J\u0016\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0012\u001a\u00020\tH\u0016J=\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u001dH\u0002¢\u0006\u0002\u0010&J;\u00106\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010(\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0002\u00107J\b\u0010(\u001a\u00020\tH\u0002J#\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J?\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\b\u0010:\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010;R\u0018\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006<"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVector;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractPersistentList;", "root", "", "", "tail", "size", "", "rootShift", "([Ljava/lang/Object;[Ljava/lang/Object;II)V", "[Ljava/lang/Object;", "getSize", "()I", "add", "element", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "index", "(ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "bufferFor", "(I)[Ljava/lang/Object;", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorBuilder;", "get", "(I)Ljava/lang/Object;", "insertIntoRoot", "shift", "elementCarry", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;", "([Ljava/lang/Object;IILjava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)[Ljava/lang/Object;", "insertIntoTail", "tailIndex", "([Ljava/lang/Object;ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVector;", "listIterator", "", "pullLastBuffer", "tailCarry", "([Ljava/lang/Object;IILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)[Ljava/lang/Object;", "pullLastBufferFromRoot", "rootSize", "([Ljava/lang/Object;II)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "pushFilledTail", "filledTail", "newTail", "([Ljava/lang/Object;[Ljava/lang/Object;[Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVector;", "pushTail", "([Ljava/lang/Object;I[Ljava/lang/Object;)[Ljava/lang/Object;", "removeAll", "predicate", "Lkotlin/Function1;", "", "removeAt", "removeFromRootAt", "removeFromTailAt", "([Ljava/lang/Object;III)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "set", "setInRoot", "e", "([Ljava/lang/Object;IILjava/lang/Object;)[Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PersistentVector<E> extends AbstractPersistentList<E> implements PersistentList<E> {
    private final Object[] root;
    private final int rootShift;
    private final int size;
    private final Object[] tail;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    public /* bridge */ /* synthetic */ PersistentCollection add(Object obj) {
        return add((PersistentVector<E>) obj);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.size;
    }

    public PersistentVector(Object[] root, Object[] tail, int size, int rootShift) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(tail, "tail");
        this.root = root;
        this.tail = tail;
        this.size = size;
        this.rootShift = rootShift;
        if (!(size() > 32)) {
            throw new IllegalArgumentException(("Trie-based persistent vector should have at least 33 elements, got " + size()).toString());
        }
        CommonFunctionsKt.m2595assert(size() - UtilsKt.rootSize(size()) <= RangesKt.coerceAtMost(this.tail.length, 32));
    }

    private final int rootSize() {
        return UtilsKt.rootSize(size());
    }

    @Override // java.util.Collection, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    public PersistentList<E> add(E element) {
        int tailSize = size() - rootSize();
        if (tailSize < 32) {
            Object[] newTail = Arrays.copyOf(this.tail, 32);
            Intrinsics.checkNotNullExpressionValue(newTail, "copyOf(this, newSize)");
            newTail[tailSize] = element;
            return new PersistentVector(this.root, newTail, size() + 1, this.rootShift);
        }
        return pushFilledTail(this.root, this.tail, UtilsKt.presizedBufferWith(element));
    }

    private final PersistentVector<E> pushFilledTail(Object[] root, Object[] filledTail, Object[] newTail) {
        if ((size() >> 5) > (1 << this.rootShift)) {
            Object[] newRoot = UtilsKt.presizedBufferWith(root);
            int newRootShift = this.rootShift + 5;
            return new PersistentVector<>(pushTail(newRoot, newRootShift, filledTail), newTail, size() + 1, newRootShift);
        }
        Object[] newRoot2 = pushTail(root, this.rootShift, filledTail);
        return new PersistentVector<>(newRoot2, newTail, size() + 1, this.rootShift);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0017, code lost:
    
        if (r2 == null) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object[] pushTail(java.lang.Object[] r5, int r6, java.lang.Object[] r7) {
        /*
            r4 = this;
            int r0 = r4.size()
            int r0 = r0 + (-1)
            int r0 = androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.UtilsKt.indexSegment(r0, r6)
            r1 = 32
            if (r5 == 0) goto L19
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r5, r1)
            java.lang.String r3 = "copyOf(this, newSize)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            if (r2 != 0) goto L1b
        L19:
            java.lang.Object[] r2 = new java.lang.Object[r1]
        L1b:
            r1 = r2
            r2 = 5
            if (r6 != r2) goto L22
            r1[r0] = r7
            goto L2e
        L22:
            r2 = r1[r0]
            java.lang.Object[] r2 = (java.lang.Object[]) r2
            int r3 = r6 + (-5)
            java.lang.Object[] r2 = r4.pushTail(r2, r3, r7)
            r1[r0] = r2
        L2e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.PersistentVector.pushTail(java.lang.Object[], int, java.lang.Object[]):java.lang.Object[]");
    }

    @Override // java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public PersistentList<E> add(int index, E element) {
        ListImplementation.checkPositionIndex$runtime_release(index, size());
        if (index == size()) {
            return add((PersistentVector<E>) element);
        }
        int rootSize = rootSize();
        if (index >= rootSize) {
            return insertIntoTail(this.root, index - rootSize, element);
        }
        ObjectRef elementCarry = new ObjectRef(null);
        Object[] newRoot = insertIntoRoot(this.root, this.rootShift, index, element, elementCarry);
        return insertIntoTail(newRoot, 0, elementCarry.getValue());
    }

    private final PersistentVector<E> insertIntoTail(Object[] root, int tailIndex, Object element) {
        int tailSize = size() - rootSize();
        Object[] newTail = Arrays.copyOf(this.tail, 32);
        Intrinsics.checkNotNullExpressionValue(newTail, "copyOf(this, newSize)");
        if (tailSize < 32) {
            ArraysKt.copyInto(this.tail, newTail, tailIndex + 1, tailIndex, tailSize);
            newTail[tailIndex] = element;
            return new PersistentVector<>(root, newTail, size() + 1, this.rootShift);
        }
        Object lastElement = this.tail[31];
        ArraysKt.copyInto(this.tail, newTail, tailIndex + 1, tailIndex, tailSize - 1);
        newTail[tailIndex] = element;
        return pushFilledTail(root, newTail, UtilsKt.presizedBufferWith(lastElement));
    }

    private final Object[] insertIntoRoot(Object[] root, int shift, int index, Object element, ObjectRef elementCarry) {
        Object[] newRoot;
        int bufferIndex = UtilsKt.indexSegment(index, shift);
        if (shift != 0) {
            Object[] newRoot2 = Arrays.copyOf(root, 32);
            Intrinsics.checkNotNullExpressionValue(newRoot2, "copyOf(this, newSize)");
            int lowerLevelShift = shift - 5;
            Object obj = root[bufferIndex];
            String str = "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>";
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            newRoot2[bufferIndex] = insertIntoRoot((Object[]) obj, lowerLevelShift, index, element, elementCarry);
            int i = bufferIndex + 1;
            while (i < 32 && newRoot2[i] != null) {
                Object obj2 = root[i];
                Intrinsics.checkNotNull(obj2, str);
                newRoot2[i] = insertIntoRoot((Object[]) obj2, lowerLevelShift, 0, elementCarry.getValue(), elementCarry);
                i++;
                str = str;
            }
            return newRoot2;
        }
        if (bufferIndex == 0) {
            newRoot = new Object[32];
        } else {
            Object[] copyOf = Arrays.copyOf(root, 32);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            newRoot = copyOf;
        }
        ArraysKt.copyInto(root, newRoot, bufferIndex + 1, bufferIndex, 31);
        elementCarry.setValue(root[31]);
        newRoot[bufferIndex] = element;
        return newRoot;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public PersistentList<E> removeAt(int index) {
        ListImplementation.checkElementIndex$runtime_release(index, size());
        int rootSize = rootSize();
        if (index >= rootSize) {
            return removeFromTailAt(this.root, rootSize, this.rootShift, index - rootSize);
        }
        Object[] newRoot = removeFromRootAt(this.root, this.rootShift, index, new ObjectRef(this.tail[0]));
        return removeFromTailAt(newRoot, rootSize, this.rootShift, 0);
    }

    private final PersistentList<E> removeFromTailAt(Object[] root, int rootSize, int shift, int index) {
        int tailSize = size() - rootSize;
        CommonFunctionsKt.m2595assert(index < tailSize);
        if (tailSize == 1) {
            return pullLastBufferFromRoot(root, rootSize, shift);
        }
        Object[] newTail = Arrays.copyOf(this.tail, 32);
        Intrinsics.checkNotNullExpressionValue(newTail, "copyOf(this, newSize)");
        if (index < tailSize - 1) {
            ArraysKt.copyInto(this.tail, newTail, index, index + 1, tailSize);
        }
        newTail[tailSize - 1] = null;
        return new PersistentVector(root, newTail, (rootSize + tailSize) - 1, shift);
    }

    private final PersistentList<E> pullLastBufferFromRoot(Object[] root, int rootSize, int shift) {
        Object[] buffer;
        if (shift == 0) {
            if (root.length == 33) {
                buffer = Arrays.copyOf(root, 32);
                Intrinsics.checkNotNullExpressionValue(buffer, "copyOf(this, newSize)");
            } else {
                buffer = root;
            }
            return new SmallPersistentVector(buffer);
        }
        ObjectRef tailCarry = new ObjectRef(null);
        Object[] newRoot = pullLastBuffer(root, shift, rootSize - 1, tailCarry);
        Intrinsics.checkNotNull(newRoot);
        Object value = tailCarry.getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] newTail = (Object[]) value;
        if (newRoot[1] == null) {
            Object obj = newRoot[0];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            Object[] lowerLevelRoot = (Object[]) obj;
            return new PersistentVector(lowerLevelRoot, newTail, rootSize, shift - 5);
        }
        return new PersistentVector(newRoot, newTail, rootSize, shift);
    }

    private final Object[] pullLastBuffer(Object[] root, int shift, int index, ObjectRef tailCarry) {
        Object[] newBufferAtIndex;
        int bufferIndex = UtilsKt.indexSegment(index, shift);
        if (shift == 5) {
            tailCarry.setValue(root[bufferIndex]);
            newBufferAtIndex = null;
        } else {
            Object obj = root[bufferIndex];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            newBufferAtIndex = pullLastBuffer((Object[]) obj, shift - 5, index, tailCarry);
        }
        if (newBufferAtIndex == null && bufferIndex == 0) {
            return null;
        }
        Object[] newRoot = Arrays.copyOf(root, 32);
        Intrinsics.checkNotNullExpressionValue(newRoot, "copyOf(this, newSize)");
        newRoot[bufferIndex] = newBufferAtIndex;
        return newRoot;
    }

    private final Object[] removeFromRootAt(Object[] root, int shift, int index, ObjectRef tailCarry) {
        Object[] newRoot;
        int bufferIndex = UtilsKt.indexSegment(index, shift);
        if (shift == 0) {
            if (bufferIndex == 0) {
                newRoot = new Object[32];
            } else {
                Object[] copyOf = Arrays.copyOf(root, 32);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                newRoot = copyOf;
            }
            ArraysKt.copyInto(root, newRoot, bufferIndex, bufferIndex + 1, 32);
            newRoot[31] = tailCarry.getValue();
            tailCarry.setValue(root[bufferIndex]);
            return newRoot;
        }
        int bufferLastIndex = 31;
        if (root[31] == null) {
            bufferLastIndex = UtilsKt.indexSegment(rootSize() - 1, shift);
        }
        Object[] newRoot2 = Arrays.copyOf(root, 32);
        Intrinsics.checkNotNullExpressionValue(newRoot2, "copyOf(this, newSize)");
        int lowerLevelShift = shift - 5;
        int i = bufferLastIndex;
        int i2 = bufferIndex + 1;
        if (i2 <= i) {
            while (true) {
                Object obj = newRoot2[i];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                newRoot2[i] = removeFromRootAt((Object[]) obj, lowerLevelShift, 0, tailCarry);
                if (i == i2) {
                    break;
                }
                i--;
            }
        }
        Object obj2 = newRoot2[bufferIndex];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        newRoot2[bufferIndex] = removeFromRootAt((Object[]) obj2, lowerLevelShift, index, tailCarry);
        return newRoot2;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    public PersistentList<E> removeAll(Function1<? super E, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        PersistentVectorBuilder it = builder();
        it.removeAllWithPredicate(predicate);
        return it.build();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    public PersistentVectorBuilder<E> builder() {
        return new PersistentVectorBuilder<>(this, this.root, this.tail, this.rootShift);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public ListIterator<E> listIterator(int index) {
        ListImplementation.checkPositionIndex$runtime_release(index, size());
        return new PersistentVectorIterator(this.root, this.tail, index, size(), (this.rootShift / 5) + 1);
    }

    private final Object[] bufferFor(int index) {
        if (rootSize() <= index) {
            return this.tail;
        }
        Object[] buffer = this.root;
        for (int shift = this.rootShift; shift > 0; shift -= 5) {
            Object obj = buffer[UtilsKt.indexSegment(index, shift)];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            buffer = (Object[]) obj;
        }
        return buffer;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public E get(int index) {
        ListImplementation.checkElementIndex$runtime_release(index, size());
        return (E) bufferFor(index)[index & 31];
    }

    @Override // kotlin.collections.AbstractList, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public PersistentList<E> set(int index, E element) {
        ListImplementation.checkElementIndex$runtime_release(index, size());
        if (rootSize() <= index) {
            Object[] newTail = Arrays.copyOf(this.tail, 32);
            Intrinsics.checkNotNullExpressionValue(newTail, "copyOf(this, newSize)");
            newTail[index & 31] = element;
            return new PersistentVector(this.root, newTail, size(), this.rootShift);
        }
        Object[] newRoot = setInRoot(this.root, this.rootShift, index, element);
        return new PersistentVector(newRoot, this.tail, size(), this.rootShift);
    }

    private final Object[] setInRoot(Object[] root, int shift, int index, Object e) {
        int bufferIndex = UtilsKt.indexSegment(index, shift);
        Object[] newRoot = Arrays.copyOf(root, 32);
        Intrinsics.checkNotNullExpressionValue(newRoot, "copyOf(this, newSize)");
        if (shift == 0) {
            newRoot[bufferIndex] = e;
        } else {
            Object obj = newRoot[bufferIndex];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            newRoot[bufferIndex] = setInRoot((Object[]) obj, shift - 5, index, e);
        }
        return newRoot;
    }
}
