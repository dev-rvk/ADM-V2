package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Swipeable.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "T", "anchors", "", ""}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SwipeableState$animateTo$2<T> implements FlowCollector<Map<Float, ? extends T>> {
    final /* synthetic */ AnimationSpec<Float> $anim;
    final /* synthetic */ T $targetValue;
    final /* synthetic */ SwipeableState<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SwipeableState$animateTo$2(T t, SwipeableState<T> swipeableState, AnimationSpec<Float> animationSpec) {
        this.$targetValue = t;
        this.this$0 = swipeableState;
        this.$anim = animationSpec;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
        return emit((Map) value, (Continuation<? super Unit>) $completion);
    }

    /* JADX WARN: Failed to calculate best type for var: r8v0 androidx.compose.material.SwipeableState$animateTo$2
    jadx.core.utils.exceptions.JadxRuntimeException: Can't change type for register without SSA variable: (r8 I:androidx.compose.material.SwipeableState$animateTo$2 A[D('this' androidx.compose.material.SwipeableState$animateTo$2)])
    	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:50)
    	at jadx.core.dex.visitors.typeinference.TypeUpdateInfo.lambda$applyUpdates$1(TypeUpdateInfo.java:49)
    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
    	at java.base/java.util.stream.SortedOps$SizedRefSortingSink.end(SortedOps.java:357)
    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:510)
    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:151)
    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:174)
    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:596)
    	at jadx.core.dex.visitors.typeinference.TypeUpdateInfo.applyUpdates(TypeUpdateInfo.java:49)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:95)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:56)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:145)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:123)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:101)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:101)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertCasts(FixTypesVisitor.java:363)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:91)
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x00e4: IGET (r9 I:androidx.compose.material.SwipeableState<T>) = 
      (r8 I:androidx.compose.material.SwipeableState$animateTo$2 A[D('this' androidx.compose.material.SwipeableState$animateTo$2)])
     androidx.compose.material.SwipeableState$animateTo$2.this$0 androidx.compose.material.SwipeableState, block:B:43:0x00e4 */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0030  */
    /* JADX WARN: Type inference failed for: r4v0, types: [int, java.util.Map] */
    /* JADX WARN: Type inference failed for: r9v0, types: [androidx.compose.material.SwipeableState<T>, androidx.compose.material.SwipeableState] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(java.util.Map<java.lang.Float, ? extends T> r17, kotlin.coroutines.Continuation<? super kotlin.Unit> r18) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeableState$animateTo$2.emit(java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
