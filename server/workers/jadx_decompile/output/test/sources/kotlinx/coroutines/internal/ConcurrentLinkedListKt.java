package kotlinx.coroutines.internal;

import androidx.autofill.HintConstants;
import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ChannelSegment$$ExternalSyntheticBackportWithForwarding0;

/* compiled from: ConcurrentLinkedList.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a8\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00050\tH\u0082\b\u001a!\u0010\r\u001a\u0002H\u000e\"\u000e\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u000f*\u0002H\u000eH\u0000¢\u0006\u0002\u0010\u0010\u001av\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0012\"\u000e\b\u0000\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u0014*\b\u0012\u0004\u0012\u0002H\u00130\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u0002H\u001328\b\b\u0010\u0019\u001a2\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u0011H\u0013¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u0002H\u00130\u001aH\u0080\bø\u0001\u0000\u001aj\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0012\"\u000e\b\u0000\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u0014*\u0002H\u00132\u0006\u0010\u0016\u001a\u00020\u001726\u0010\u0019\u001a2\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u0011H\u0013¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u0002H\u00130\u001aH\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u001d\u001a+\u0010\u001e\u001a\u00020\u0005\"\u000e\b\u0000\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u0014*\b\u0012\u0004\u0012\u0002H\u00130\u00152\u0006\u0010\u001f\u001a\u0002H\u0013H\u0080\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"CLOSED", "Lkotlinx/coroutines/internal/Symbol;", "POINTERS_SHIFT", "", "addConditionally", "", "Lkotlinx/atomicfu/AtomicInt;", "delta", "condition", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "cur", "close", "N", "Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "findSegmentAndMoveForward", "Lkotlinx/coroutines/internal/SegmentOrClosed;", "S", "Lkotlinx/coroutines/internal/Segment;", "Lkotlinx/atomicfu/AtomicRef;", "id", "", "startFrom", "createNewSegment", "Lkotlin/Function2;", "prev", "findSegmentInternal", "(Lkotlinx/coroutines/internal/Segment;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "moveForward", "to", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class ConcurrentLinkedListKt {
    private static final Symbol CLOSED = new Symbol("CLOSED");
    private static final int POINTERS_SHIFT = 16;

    public static final /* synthetic */ Symbol access$getCLOSED$p() {
        return CLOSED;
    }

    public static final <S extends Segment<S>> Object findSegmentInternal(S s, long id, Function2<? super Long, ? super S, ? extends S> function2) {
        Segment cur = s;
        while (true) {
            if (cur.id < id || cur.isRemoved()) {
                ConcurrentLinkedListNode this_$iv = cur;
                Object it$iv = this_$iv.getNextOrClosed();
                if (it$iv == CLOSED) {
                    return SegmentOrClosed.m7175constructorimpl(CLOSED);
                }
                Segment next = (Segment) ((ConcurrentLinkedListNode) it$iv);
                if (next != null) {
                    cur = next;
                } else {
                    Segment newTail = function2.invoke(Long.valueOf(cur.id + 1), cur);
                    if (cur.trySetNext(newTail)) {
                        if (cur.isRemoved()) {
                            cur.remove();
                        }
                        cur = newTail;
                    }
                }
            } else {
                return SegmentOrClosed.m7175constructorimpl(cur);
            }
        }
    }

    public static final boolean moveForward$atomicfu(Object atomicfu$dispatchReceiver, AtomicReferenceFieldUpdater atomicfu$handler, Segment to) {
        while (true) {
            Segment cur = (Segment) atomicfu$handler.get(atomicfu$dispatchReceiver);
            if (cur.id >= to.id) {
                return true;
            }
            if (!to.tryIncPointers$kotlinx_coroutines_core()) {
                return false;
            }
            if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicfu$handler, atomicfu$dispatchReceiver, cur, to)) {
                if (cur.decPointers$kotlinx_coroutines_core()) {
                    cur.remove();
                }
                return true;
            }
            if (to.decPointers$kotlinx_coroutines_core()) {
                to.remove();
            }
        }
    }

    public static final boolean moveForward$atomicfu$array(Object atomicfu$dispatchReceiver, AtomicReferenceArray atomicfu$handler, int atomicfu$index, Segment to) {
        while (true) {
            Segment cur = (Segment) atomicfu$handler.get(atomicfu$index);
            if (cur.id >= to.id) {
                return true;
            }
            if (!to.tryIncPointers$kotlinx_coroutines_core()) {
                return false;
            }
            if (ChannelSegment$$ExternalSyntheticBackportWithForwarding0.m(atomicfu$handler, atomicfu$index, cur, to)) {
                if (cur.decPointers$kotlinx_coroutines_core()) {
                    cur.remove();
                }
                return true;
            }
            if (to.decPointers$kotlinx_coroutines_core()) {
                to.remove();
            }
        }
    }

    public static final Object findSegmentAndMoveForward$atomicfu(Object atomicfu$dispatchReceiver, AtomicReferenceFieldUpdater atomicfu$handler, long id, Segment startFrom, Function2 createNewSegment) {
        Object s;
        int $i$f$findSegmentAndMoveForward$atomicfu;
        boolean z;
        int $i$f$findSegmentAndMoveForward$atomicfu2 = 0;
        while (true) {
            s = findSegmentInternal(startFrom, id, createNewSegment);
            if (SegmentOrClosed.m7180isClosedimpl(s)) {
                break;
            }
            Segment to$iv = SegmentOrClosed.m7178getSegmentimpl(s);
            while (true) {
                Segment cur$iv = (Segment) atomicfu$handler.get(atomicfu$dispatchReceiver);
                $i$f$findSegmentAndMoveForward$atomicfu = $i$f$findSegmentAndMoveForward$atomicfu2;
                z = true;
                if (cur$iv.id >= to$iv.id) {
                    break;
                }
                if (!to$iv.tryIncPointers$kotlinx_coroutines_core()) {
                    z = false;
                    break;
                }
                if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicfu$handler, atomicfu$dispatchReceiver, cur$iv, to$iv)) {
                    if (cur$iv.decPointers$kotlinx_coroutines_core()) {
                        cur$iv.remove();
                    }
                } else {
                    if (to$iv.decPointers$kotlinx_coroutines_core()) {
                        to$iv.remove();
                    }
                    $i$f$findSegmentAndMoveForward$atomicfu2 = $i$f$findSegmentAndMoveForward$atomicfu;
                }
            }
            if (z) {
                break;
            }
            $i$f$findSegmentAndMoveForward$atomicfu2 = $i$f$findSegmentAndMoveForward$atomicfu;
        }
        return s;
    }

    public static final Object findSegmentAndMoveForward$atomicfu$array(Object atomicfu$dispatchReceiver, AtomicReferenceArray atomicfu$handler, int atomicfu$index, long id, Segment startFrom, Function2 createNewSegment) {
        Object s;
        boolean z;
        do {
            s = findSegmentInternal(startFrom, id, createNewSegment);
            if (!SegmentOrClosed.m7180isClosedimpl(s)) {
                Segment to$iv = SegmentOrClosed.m7178getSegmentimpl(s);
                while (true) {
                    Segment cur$iv = (Segment) atomicfu$handler.get(atomicfu$index);
                    z = true;
                    if (cur$iv.id >= to$iv.id) {
                        break;
                    }
                    if (!to$iv.tryIncPointers$kotlinx_coroutines_core()) {
                        z = false;
                        break;
                    }
                    if (ChannelSegment$$ExternalSyntheticBackportWithForwarding0.m(atomicfu$handler, atomicfu$index, cur$iv, to$iv)) {
                        if (cur$iv.decPointers$kotlinx_coroutines_core()) {
                            cur$iv.remove();
                        }
                    } else if (to$iv.decPointers$kotlinx_coroutines_core()) {
                        to$iv.remove();
                    }
                }
            } else {
                break;
            }
        } while (!z);
        return s;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [kotlinx.coroutines.internal.ConcurrentLinkedListNode] */
    public static final <N extends ConcurrentLinkedListNode<N>> N close(N n) {
        N n2 = n;
        while (true) {
            ConcurrentLinkedListNode this_$iv = n2;
            Object it$iv = this_$iv.getNextOrClosed();
            if (it$iv == CLOSED) {
                return n2;
            }
            ?? r5 = (ConcurrentLinkedListNode) it$iv;
            if (r5 == 0) {
                if (n2.markAsClosed()) {
                    return n2;
                }
            } else {
                n2 = r5;
            }
        }
    }

    private static final boolean addConditionally$atomicfu(Object atomicfu$dispatchReceiver, AtomicIntegerFieldUpdater atomicfu$handler, int delta, Function1<? super Integer, Boolean> function1) {
        int cur;
        do {
            cur = atomicfu$handler.get(atomicfu$dispatchReceiver);
            if (!function1.invoke(Integer.valueOf(cur)).booleanValue()) {
                return false;
            }
        } while (!atomicfu$handler.compareAndSet(atomicfu$dispatchReceiver, cur, cur + delta));
        return true;
    }

    private static final boolean addConditionally$atomicfu$array(Object atomicfu$dispatchReceiver, AtomicIntegerArray atomicfu$handler, int atomicfu$index, int delta, Function1<? super Integer, Boolean> function1) {
        int cur;
        do {
            cur = atomicfu$handler.get(atomicfu$index);
            if (!function1.invoke(Integer.valueOf(cur)).booleanValue()) {
                return false;
            }
        } while (!atomicfu$handler.compareAndSet(atomicfu$index, cur, cur + delta));
        return true;
    }
}
