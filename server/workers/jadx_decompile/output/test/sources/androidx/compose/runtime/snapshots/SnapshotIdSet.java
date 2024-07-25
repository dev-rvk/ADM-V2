package androidx.compose.runtime.snapshots;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;

/* compiled from: SnapshotIdSet.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB)\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002J \u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u0012H\u0086\bø\u0001\u0000J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u0002J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0096\u0002J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001e"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "", "", "upperSet", "", "lowerSet", "lowerBound", "belowBound", "", "(JJI[I)V", "and", "bits", "andNot", "clear", "bit", "fastForEach", "", "block", "Lkotlin/Function1;", "get", "", "iterator", "", "lowest", "default", "or", "set", "toString", "", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SnapshotIdSet implements Iterable<Integer>, KMappedMarker {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SnapshotIdSet EMPTY = new SnapshotIdSet(0, 0, 0, null);
    private final int[] belowBound;
    private final int lowerBound;
    private final long lowerSet;
    private final long upperSet;

    private SnapshotIdSet(long upperSet, long lowerSet, int lowerBound, int[] belowBound) {
        this.upperSet = upperSet;
        this.lowerSet = lowerSet;
        this.lowerBound = lowerBound;
        this.belowBound = belowBound;
    }

    public final boolean get(int bit) {
        int[] it;
        int offset = bit - this.lowerBound;
        if (offset >= 0 && offset < 64) {
            return ((1 << offset) & this.lowerSet) != 0;
        }
        if (offset >= 64 && offset < 128) {
            return ((1 << (offset + (-64))) & this.upperSet) != 0;
        }
        if (offset <= 0 && (it = this.belowBound) != null) {
            return SnapshotIdSetKt.binarySearch(it, bit) >= 0;
        }
        return false;
    }

    public final SnapshotIdSet set(int bit) {
        int[] iArr;
        int offset;
        char c;
        long j;
        int offset2 = bit - this.lowerBound;
        long j2 = 1;
        long j3 = 0;
        char c2 = '@';
        if (offset2 >= 0 && offset2 < 64) {
            long mask = 1 << offset2;
            if ((this.lowerSet & mask) == 0) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet | mask, this.lowerBound, this.belowBound);
            }
        } else if (offset2 >= 64 && offset2 < 128) {
            long mask2 = 1 << (offset2 - 64);
            if ((this.upperSet & mask2) == 0) {
                return new SnapshotIdSet(this.upperSet | mask2, this.lowerSet, this.lowerBound, this.belowBound);
            }
        } else if (offset2 < 128) {
            int[] array = this.belowBound;
            if (array == null) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, new int[]{bit});
            }
            int location = SnapshotIdSetKt.binarySearch(array, bit);
            if (location < 0) {
                int insertLocation = -(location + 1);
                int newSize = array.length + 1;
                int[] newBelowBound = new int[newSize];
                ArraysKt.copyInto(array, newBelowBound, 0, 0, insertLocation);
                ArraysKt.copyInto(array, newBelowBound, insertLocation + 1, insertLocation, newSize - 1);
                newBelowBound[insertLocation] = bit;
                return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, newBelowBound);
            }
        } else if (!get(bit)) {
            long newUpperSet = this.upperSet;
            long newLowerSet = this.lowerSet;
            int newLowerBound = this.lowerBound;
            List list = null;
            int targetLowerBound = ((bit + 1) / 64) * 64;
            while (true) {
                if (newLowerBound >= targetLowerBound) {
                    break;
                }
                if (newLowerSet == j3) {
                    offset = offset2;
                    long j4 = j2;
                    c = c2;
                    j = j4;
                } else {
                    if (list != null) {
                        offset = offset2;
                    } else {
                        List $this$set_u24lambda_u243 = new ArrayList();
                        int[] it = this.belowBound;
                        if (it == null) {
                            offset = offset2;
                        } else {
                            int length = it.length;
                            int i = 0;
                            while (i < length) {
                                int element$iv = it[i];
                                $this$set_u24lambda_u243.add(Integer.valueOf(element$iv));
                                i++;
                                offset2 = offset2;
                            }
                            offset = offset2;
                        }
                        list = $this$set_u24lambda_u243;
                    }
                    int offset3 = 0;
                    while (true) {
                        c = '@';
                        if (offset3 >= 64) {
                            break;
                        }
                        int bitOffset = offset3;
                        if ((newLowerSet & (1 << bitOffset)) != 0) {
                            list.add(Integer.valueOf(bitOffset + newLowerBound));
                        }
                        offset3++;
                    }
                    j = 1;
                }
                if (newUpperSet == 0) {
                    newLowerBound = targetLowerBound;
                    newLowerSet = 0;
                    break;
                }
                newLowerSet = newUpperSet;
                newUpperSet = 0;
                newLowerBound += 64;
                offset2 = offset;
                c2 = c;
                j3 = 0;
                j2 = j;
            }
            if (list == null || (iArr = CollectionsKt.toIntArray(list)) == null) {
                iArr = this.belowBound;
            }
            return new SnapshotIdSet(newUpperSet, newLowerSet, newLowerBound, iArr).set(bit);
        }
        return this;
    }

    public final SnapshotIdSet clear(int bit) {
        int[] array;
        int location;
        int offset = bit - this.lowerBound;
        if (offset >= 0 && offset < 64) {
            long mask = 1 << offset;
            if ((this.lowerSet & mask) != 0) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet & (~mask), this.lowerBound, this.belowBound);
            }
        } else if (offset >= 64 && offset < 128) {
            long mask2 = 1 << (offset - 64);
            if ((this.upperSet & mask2) != 0) {
                return new SnapshotIdSet(this.upperSet & (~mask2), this.lowerSet, this.lowerBound, this.belowBound);
            }
        } else if (offset < 0 && (array = this.belowBound) != null && (location = SnapshotIdSetKt.binarySearch(array, bit)) >= 0) {
            int newSize = array.length - 1;
            if (newSize == 0) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, null);
            }
            int[] newBelowBound = new int[newSize];
            if (location > 0) {
                ArraysKt.copyInto(array, newBelowBound, 0, 0, location);
            }
            if (location < newSize) {
                ArraysKt.copyInto(array, newBelowBound, location, location + 1, newSize + 1);
            }
            return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, newBelowBound);
        }
        return this;
    }

    public final SnapshotIdSet andNot(SnapshotIdSet bits) {
        Intrinsics.checkNotNullParameter(bits, "bits");
        if (bits == EMPTY) {
            return this;
        }
        if (this == EMPTY) {
            return EMPTY;
        }
        if (bits.lowerBound == this.lowerBound && bits.belowBound == this.belowBound) {
            return new SnapshotIdSet((~bits.upperSet) & this.upperSet, (~bits.lowerSet) & this.lowerSet, this.lowerBound, this.belowBound);
        }
        SnapshotIdSet $this$fold$iv = bits;
        Object accumulator$iv = this;
        for (Object element$iv : $this$fold$iv) {
            int index = ((Number) element$iv).intValue();
            SnapshotIdSet previous = (SnapshotIdSet) accumulator$iv;
            accumulator$iv = previous.clear(index);
        }
        Object $this$fold$iv2 = accumulator$iv;
        return (SnapshotIdSet) $this$fold$iv2;
    }

    public final SnapshotIdSet and(SnapshotIdSet bits) {
        Intrinsics.checkNotNullParameter(bits, "bits");
        if (!Intrinsics.areEqual(bits, EMPTY) && !Intrinsics.areEqual(this, EMPTY)) {
            if (bits.lowerBound == this.lowerBound && bits.belowBound == this.belowBound) {
                long newUpper = this.upperSet & bits.upperSet;
                long newLower = this.lowerSet & bits.lowerSet;
                if (newUpper == 0 && newLower == 0 && this.belowBound == null) {
                    return EMPTY;
                }
                return new SnapshotIdSet(this.upperSet & bits.upperSet, this.lowerSet & bits.lowerSet, this.lowerBound, this.belowBound);
            }
            if (this.belowBound == null) {
                SnapshotIdSet $this$fold$iv = this;
                SnapshotIdSet snapshotIdSet = EMPTY;
                for (Object element$iv : $this$fold$iv) {
                    int index = ((Number) element$iv).intValue();
                    SnapshotIdSet previous = snapshotIdSet;
                    if (bits.get(index)) {
                        previous = previous.set(index);
                    }
                    snapshotIdSet = previous;
                }
                return snapshotIdSet;
            }
            SnapshotIdSet $this$fold$iv2 = bits;
            SnapshotIdSet snapshotIdSet2 = EMPTY;
            for (Object element$iv2 : $this$fold$iv2) {
                int index2 = ((Number) element$iv2).intValue();
                SnapshotIdSet previous2 = snapshotIdSet2;
                if (get(index2)) {
                    previous2 = previous2.set(index2);
                }
                snapshotIdSet2 = previous2;
            }
            return snapshotIdSet2;
        }
        return EMPTY;
    }

    public final SnapshotIdSet or(SnapshotIdSet bits) {
        Intrinsics.checkNotNullParameter(bits, "bits");
        if (bits == EMPTY) {
            return this;
        }
        if (this == EMPTY) {
            return bits;
        }
        if (bits.lowerBound == this.lowerBound && bits.belowBound == this.belowBound) {
            return new SnapshotIdSet(bits.upperSet | this.upperSet, bits.lowerSet | this.lowerSet, this.lowerBound, this.belowBound);
        }
        if (this.belowBound == null) {
            SnapshotIdSet $this$fold$iv = this;
            SnapshotIdSet snapshotIdSet = bits;
            for (Object element$iv : $this$fold$iv) {
                int index = ((Number) element$iv).intValue();
                SnapshotIdSet previous = snapshotIdSet;
                snapshotIdSet = previous.set(index);
            }
            return snapshotIdSet;
        }
        SnapshotIdSet $this$fold$iv2 = bits;
        Object accumulator$iv = this;
        for (Object element$iv2 : $this$fold$iv2) {
            int index2 = ((Number) element$iv2).intValue();
            SnapshotIdSet previous2 = (SnapshotIdSet) accumulator$iv;
            accumulator$iv = previous2.set(index2);
        }
        Object $this$fold$iv3 = accumulator$iv;
        return (SnapshotIdSet) $this$fold$iv3;
    }

    @Override // java.lang.Iterable
    public Iterator<Integer> iterator() {
        return SequencesKt.sequence(new SnapshotIdSet$iterator$1(this, null)).iterator();
    }

    public final void fastForEach(Function1<? super Integer, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        int[] belowBound = this.belowBound;
        if (belowBound != null) {
            for (int element : belowBound) {
                block.invoke(Integer.valueOf(element));
            }
        }
        if (this.lowerSet != 0) {
            for (int index = 0; index < 64; index++) {
                if ((this.lowerSet & (1 << index)) != 0) {
                    block.invoke(Integer.valueOf(this.lowerBound + index));
                }
            }
        }
        if (this.upperSet != 0) {
            for (int index2 = 0; index2 < 64; index2++) {
                if ((this.upperSet & (1 << index2)) != 0) {
                    block.invoke(Integer.valueOf(index2 + 64 + this.lowerBound));
                }
            }
        }
    }

    public final int lowest(int r6) {
        int lowestBitOf;
        int lowestBitOf2;
        int[] belowBound = this.belowBound;
        if (belowBound != null) {
            return belowBound[0];
        }
        if (this.lowerSet != 0) {
            int i = this.lowerBound;
            lowestBitOf2 = SnapshotIdSetKt.lowestBitOf(this.lowerSet);
            return i + lowestBitOf2;
        }
        if (this.upperSet != 0) {
            int i2 = this.lowerBound + 64;
            lowestBitOf = SnapshotIdSetKt.lowestBitOf(this.upperSet);
            return i2 + lowestBitOf;
        }
        return r6;
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append(super.toString()).append(" [");
        SnapshotIdSet $this$map$iv = this;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            int it = ((Number) item$iv$iv).intValue();
            destination$iv$iv.add(String.valueOf(it));
        }
        return append.append(ListUtilsKt.fastJoinToString$default((List) destination$iv$iv, null, null, null, 0, null, null, 63, null)).append(']').toString();
    }

    /* compiled from: SnapshotIdSet.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet$Companion;", "", "()V", "EMPTY", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "getEMPTY", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SnapshotIdSet getEMPTY() {
            return SnapshotIdSet.EMPTY;
        }
    }
}
