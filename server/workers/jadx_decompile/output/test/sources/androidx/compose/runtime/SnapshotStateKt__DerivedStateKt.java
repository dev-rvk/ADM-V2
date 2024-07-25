package androidx.compose.runtime;

import androidx.compose.runtime.collection.MutableVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DerivedState.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000\u001a\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\u0007\u001a0\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\u0007\u001a0\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0082\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a(\u0010\u0014\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u0016\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0080\bø\u0001\u0000\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0017"}, d2 = {"calculationBlockNestedLevel", "Landroidx/compose/runtime/SnapshotThreadLocal;", "", "derivedStateObservers", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/runtime/DerivedStateObserver;", "derivedStateOf", "Landroidx/compose/runtime/State;", "T", "calculation", "Lkotlin/Function0;", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "notifyObservers", "R", "derivedState", "Landroidx/compose/runtime/DerivedState;", "block", "notifyObservers$SnapshotStateKt__DerivedStateKt", "(Landroidx/compose/runtime/DerivedState;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "observeDerivedStateRecalculations", "", "observer", "runtime_release"}, k = 5, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE, xs = "androidx/compose/runtime/SnapshotStateKt")
/* loaded from: classes.dex */
public final /* synthetic */ class SnapshotStateKt__DerivedStateKt {
    private static final SnapshotThreadLocal<Integer> calculationBlockNestedLevel = new SnapshotThreadLocal<>();
    private static final SnapshotThreadLocal<MutableVector<DerivedStateObserver>> derivedStateObservers = new SnapshotThreadLocal<>();

    public static final <T> State<T> derivedStateOf(Function0<? extends T> calculation) {
        Intrinsics.checkNotNullParameter(calculation, "calculation");
        return new DerivedSnapshotState(calculation, null);
    }

    public static final <T> State<T> derivedStateOf(SnapshotMutationPolicy<T> policy, Function0<? extends T> calculation) {
        Intrinsics.checkNotNullParameter(policy, "policy");
        Intrinsics.checkNotNullParameter(calculation, "calculation");
        return new DerivedSnapshotState(calculation, policy);
    }

    public static final MutableVector<DerivedStateObserver> derivedStateObservers() {
        MutableVector<DerivedStateObserver> mutableVector = derivedStateObservers.get();
        if (mutableVector != null) {
            return mutableVector;
        }
        MutableVector it = new MutableVector(new DerivedStateObserver[0], 0);
        derivedStateObservers.set(it);
        return it;
    }

    private static final <R> R notifyObservers$SnapshotStateKt__DerivedStateKt(DerivedState<?> derivedState, Function0<? extends R> function0) {
        MutableVector observers = SnapshotStateKt.derivedStateObservers();
        int size$iv = observers.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = observers.getContent();
            do {
                DerivedStateObserver it = (DerivedStateObserver) content$iv[i$iv];
                it.start(derivedState);
                i$iv++;
            } while (i$iv < size$iv);
        }
        try {
            R invoke = function0.invoke();
            InlineMarker.finallyStart(1);
            int size$iv2 = observers.getSize();
            if (size$iv2 > 0) {
                int i$iv2 = 0;
                Object[] content$iv2 = observers.getContent();
                do {
                    DerivedStateObserver it2 = (DerivedStateObserver) content$iv2[i$iv2];
                    it2.done(derivedState);
                    i$iv2++;
                } while (i$iv2 < size$iv2);
            }
            InlineMarker.finallyEnd(1);
            return invoke;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            int size$iv3 = observers.getSize();
            if (size$iv3 > 0) {
                int i$iv3 = 0;
                Object[] content$iv3 = observers.getContent();
                do {
                    DerivedStateObserver it3 = (DerivedStateObserver) content$iv3[i$iv3];
                    it3.done(derivedState);
                    i$iv3++;
                } while (i$iv3 < size$iv3);
            }
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    public static final <R> void observeDerivedStateRecalculations(DerivedStateObserver observer, Function0<? extends R> block) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        Intrinsics.checkNotNullParameter(block, "block");
        MutableVector observers = SnapshotStateKt.derivedStateObservers();
        try {
            observers.add(observer);
            block.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            observers.removeAt(observers.getSize() - 1);
            InlineMarker.finallyEnd(1);
        }
    }
}
