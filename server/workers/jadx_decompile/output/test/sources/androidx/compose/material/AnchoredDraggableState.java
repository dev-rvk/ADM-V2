package androidx.compose.material;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: AnchoredDraggable.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 u*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002tuBs\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\r\u0012#\b\u0002\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u0005¢\u0006\u0002\u0010\u0011Jm\u0010S\u001a\u00020T2\u0006\u0010N\u001a\u00028\u00002\b\b\u0002\u0010U\u001a\u00020V2H\u0010W\u001aD\b\u0001\u0012\u0004\u0012\u00020\u0013\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0015¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020T0Y\u0012\u0006\u0012\u0004\u0018\u00010\u00020X¢\u0006\u0002\bZH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010[Je\u0010S\u001a\u00020T2\b\b\u0002\u0010U\u001a\u00020V2H\u0010W\u001aD\b\u0001\u0012\u0004\u0012\u00020\u0013\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0015¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020T0Y\u0012\u0006\u0012\u0004\u0018\u00010\u00020X¢\u0006\u0002\bZH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\\J%\u0010]\u001a\u00028\u00002\u0006\u0010D\u001a\u00020\u00062\u0006\u0010+\u001a\u00028\u00002\u0006\u0010^\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010_J\u001d\u0010`\u001a\u00028\u00002\u0006\u0010D\u001a\u00020\u00062\u0006\u0010+\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010aJ\u000e\u0010b\u001a\u00020\u00062\u0006\u0010c\u001a\u00020\u0006Jm\u0010d\u001a\u00020T2\b\u0010N\u001a\u0004\u0018\u00018\u00002\u0006\u0010U\u001a\u00020V2H\u0010W\u001aD\b\u0001\u0012\u0004\u0012\u00020\u0013\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0015¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020T0Y\u0012\u0006\u0012\u0004\u0018\u00010\u00020X¢\u0006\u0002\bZH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010[J\u0013\u0010e\u001a\u00020\u00102\u0006\u0010f\u001a\u00028\u0000¢\u0006\u0002\u0010gJ\u0015\u0010h\u001a\u00020\u00062\u0006\u0010c\u001a\u00020\u0006H\u0000¢\u0006\u0002\biJ\u0006\u0010j\u001a\u00020\u0006J\u0019\u0010k\u001a\u00020T2\u0006\u0010^\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010lJ\u0017\u0010m\u001a\u00020\u00102\u0006\u0010N\u001a\u00028\u0000H\u0000¢\u0006\u0004\bn\u0010gJ3\u0010o\u001a\u00020T2\u0012\u0010p\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u00152\u0010\b\u0002\u0010q\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010rH\u0000¢\u0006\u0002\bsR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000RC\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u00152\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u00158@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR/\u0010\u001f\u001a\u0004\u0018\u00018\u00002\b\u0010\u0014\u001a\u0004\u0018\u00018\u00008B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b$\u0010\u001c\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001b\u0010%\u001a\u00028\u00008@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b&\u0010!R/\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R+\u0010+\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010\u001c\u001a\u0004\b,\u0010!\"\u0004\b-\u0010#R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u000202X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u00105\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b5\u00106R+\u00107\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00068F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001b\u0010>\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b@\u0010(\u001a\u0004\b?\u00109R\u001b\u0010A\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bC\u0010(\u001a\u0004\bB\u00109R1\u0010D\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00068F@BX\u0086\u008e\u0002¢\u0006\u0018\n\u0004\bI\u0010\u001c\u0012\u0004\bE\u0010F\u001a\u0004\bG\u00109\"\u0004\bH\u0010;R/\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010*R\u001b\u0010K\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bM\u0010(\u001a\u0004\bL\u00109R\u001b\u0010N\u001a\u00028\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bP\u0010(\u001a\u0004\bO\u0010!R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010R\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006v"}, d2 = {"Landroidx/compose/material/AnchoredDraggableState;", "T", "", "initialValue", "positionalThreshold", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "totalDistance", "velocityThreshold", "Lkotlin/Function0;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmValueChange", "newValue", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;)V", "anchoredDragScope", "Landroidx/compose/material/AnchoredDragScope;", "<set-?>", "", "anchors", "getAnchors$material_release", "()Ljava/util/Map;", "setAnchors$material_release", "(Ljava/util/Map;)V", "anchors$delegate", "Landroidx/compose/runtime/MutableState;", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "animationTarget", "getAnimationTarget", "()Ljava/lang/Object;", "setAnimationTarget", "(Ljava/lang/Object;)V", "animationTarget$delegate", "closestValue", "getClosestValue$material_release", "closestValue$delegate", "Landroidx/compose/runtime/State;", "getConfirmValueChange$material_release", "()Lkotlin/jvm/functions/Function1;", "currentValue", "getCurrentValue", "setCurrentValue", "currentValue$delegate", "dragMutex", "Landroidx/compose/material/InternalMutatorMutex;", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "getDraggableState$material_release", "()Landroidx/compose/foundation/gestures/DraggableState;", "isAnimationRunning", "()Z", "lastVelocity", "getLastVelocity", "()F", "setLastVelocity", "(F)V", "lastVelocity$delegate", "Landroidx/compose/runtime/MutableFloatState;", "maxOffset", "getMaxOffset", "maxOffset$delegate", "minOffset", "getMinOffset", "minOffset$delegate", "offset", "getOffset$annotations", "()V", "getOffset", "setOffset", "offset$delegate", "getPositionalThreshold$material_release", NotificationCompat.CATEGORY_PROGRESS, "getProgress", "progress$delegate", "targetValue", "getTargetValue", "targetValue$delegate", "getVelocityThreshold$material_release", "()Lkotlin/jvm/functions/Function0;", "anchoredDrag", "", "dragPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "computeTarget", "velocity", "(FLjava/lang/Object;F)Ljava/lang/Object;", "computeTargetWithoutThresholds", "(FLjava/lang/Object;)Ljava/lang/Object;", "dispatchRawDelta", "delta", "doAnchoredDrag", "hasAnchorForValue", "value", "(Ljava/lang/Object;)Z", "newOffsetForDelta", "newOffsetForDelta$material_release", "requireOffset", "settle", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySnapTo", "trySnapTo$material_release", "updateAnchors", "newAnchors", "onAnchorsChanged", "Landroidx/compose/material/AnchoredDraggableState$AnchorChangedCallback;", "updateAnchors$material_release", "AnchorChangedCallback", "Companion", "material_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AnchoredDraggableState<T> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AnchoredDragScope anchoredDragScope;

    /* renamed from: anchors$delegate, reason: from kotlin metadata */
    private final MutableState anchors;
    private final AnimationSpec<Float> animationSpec;

    /* renamed from: animationTarget$delegate, reason: from kotlin metadata */
    private final MutableState animationTarget;

    /* renamed from: closestValue$delegate, reason: from kotlin metadata */
    private final State closestValue;
    private final Function1<T, Boolean> confirmValueChange;

    /* renamed from: currentValue$delegate, reason: from kotlin metadata */
    private final MutableState currentValue;
    private final InternalMutatorMutex dragMutex;
    private final DraggableState draggableState;

    /* renamed from: lastVelocity$delegate, reason: from kotlin metadata */
    private final MutableFloatState lastVelocity;

    /* renamed from: maxOffset$delegate, reason: from kotlin metadata */
    private final State maxOffset;

    /* renamed from: minOffset$delegate, reason: from kotlin metadata */
    private final State minOffset;

    /* renamed from: offset$delegate, reason: from kotlin metadata */
    private final MutableState offset;
    private final Function1<Float, Float> positionalThreshold;

    /* renamed from: progress$delegate, reason: from kotlin metadata */
    private final State progress;

    /* renamed from: targetValue$delegate, reason: from kotlin metadata */
    private final State targetValue;
    private final Function0<Float> velocityThreshold;

    /* compiled from: AnchoredDraggable.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0002\b\u0003\bç\u0080\u0001\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002J=\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\b0\u0007H&¢\u0006\u0002\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/material/AnchoredDraggableState$AnchorChangedCallback;", "T", "", "onAnchorsChanged", "", "previousTargetValue", "previousAnchors", "", "", "newAnchors", "(Ljava/lang/Object;Ljava/util/Map;Ljava/util/Map;)V", "material_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public interface AnchorChangedCallback<T> {
        void onAnchorsChanged(T previousTargetValue, Map<T, Float> previousAnchors, Map<T, Float> newAnchors);
    }

    public static /* synthetic */ void getOffset$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnchoredDraggableState(T t, Function1<? super Float, Float> positionalThreshold, Function0<Float> velocityThreshold, AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> confirmValueChange) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        Intrinsics.checkNotNullParameter(positionalThreshold, "positionalThreshold");
        Intrinsics.checkNotNullParameter(velocityThreshold, "velocityThreshold");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(confirmValueChange, "confirmValueChange");
        this.positionalThreshold = positionalThreshold;
        this.velocityThreshold = velocityThreshold;
        this.animationSpec = animationSpec;
        this.confirmValueChange = confirmValueChange;
        this.dragMutex = new InternalMutatorMutex();
        this.draggableState = new AnchoredDraggableState$draggableState$1(this);
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
        this.currentValue = mutableStateOf$default;
        this.targetValue = SnapshotStateKt.derivedStateOf(new Function0<T>(this) { // from class: androidx.compose.material.AnchoredDraggableState$targetValue$2
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                T t2;
                Object computeTarget;
                Object animationTarget;
                animationTarget = this.this$0.getAnimationTarget();
                T t3 = (T) animationTarget;
                if (t3 != null) {
                    return t3;
                }
                AnchoredDraggableState<T> anchoredDraggableState = this.this$0;
                float offset = anchoredDraggableState.getOffset();
                if (!Float.isNaN(offset)) {
                    computeTarget = anchoredDraggableState.computeTarget(offset, anchoredDraggableState.getCurrentValue(), 0.0f);
                    t2 = computeTarget;
                } else {
                    t2 = anchoredDraggableState.getCurrentValue();
                }
                return t2;
            }
        });
        this.closestValue = SnapshotStateKt.derivedStateOf(new Function0<T>(this) { // from class: androidx.compose.material.AnchoredDraggableState$closestValue$2
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                T t2;
                Object computeTargetWithoutThresholds;
                Object animationTarget;
                animationTarget = this.this$0.getAnimationTarget();
                T t3 = (T) animationTarget;
                if (t3 != null) {
                    return t3;
                }
                AnchoredDraggableState<T> anchoredDraggableState = this.this$0;
                float offset = anchoredDraggableState.getOffset();
                if (!Float.isNaN(offset)) {
                    computeTargetWithoutThresholds = anchoredDraggableState.computeTargetWithoutThresholds(offset, anchoredDraggableState.getCurrentValue());
                    t2 = computeTargetWithoutThresholds;
                } else {
                    t2 = anchoredDraggableState.getCurrentValue();
                }
                return t2;
            }
        });
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(Float.NaN), null, 2, null);
        this.offset = mutableStateOf$default2;
        this.progress = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<Float>(this) { // from class: androidx.compose.material.AnchoredDraggableState$progress$2
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                Float f = (Float) this.this$0.getAnchors$material_release().get(this.this$0.getCurrentValue());
                float f2 = 0.0f;
                float a = f != null ? f.floatValue() : 0.0f;
                Float f3 = (Float) this.this$0.getAnchors$material_release().get(this.this$0.getClosestValue$material_release());
                float b = f3 != null ? f3.floatValue() : 0.0f;
                float distance = Math.abs(b - a);
                if (distance > 1.0E-6f) {
                    float progress = (this.this$0.requireOffset() - a) / (b - a);
                    if (progress >= 1.0E-6f) {
                        f2 = progress > 0.999999f ? 1.0f : progress;
                    }
                } else {
                    f2 = 1.0f;
                }
                return Float.valueOf(f2);
            }
        });
        this.lastVelocity = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.minOffset = SnapshotStateKt.derivedStateOf(new Function0<Float>(this) { // from class: androidx.compose.material.AnchoredDraggableState$minOffset$2
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                Float minOrNull;
                minOrNull = AnchoredDraggableKt.minOrNull(this.this$0.getAnchors$material_release());
                return Float.valueOf(minOrNull != null ? minOrNull.floatValue() : Float.NEGATIVE_INFINITY);
            }
        });
        this.maxOffset = SnapshotStateKt.derivedStateOf(new Function0<Float>(this) { // from class: androidx.compose.material.AnchoredDraggableState$maxOffset$2
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                Float maxOrNull;
                maxOrNull = AnchoredDraggableKt.maxOrNull(this.this$0.getAnchors$material_release());
                return Float.valueOf(maxOrNull != null ? maxOrNull.floatValue() : Float.POSITIVE_INFINITY);
            }
        });
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.animationTarget = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(MapsKt.emptyMap(), null, 2, null);
        this.anchors = mutableStateOf$default4;
        this.anchoredDragScope = new AnchoredDragScope(this) { // from class: androidx.compose.material.AnchoredDraggableState$anchoredDragScope$1
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            @Override // androidx.compose.material.AnchoredDragScope
            public void dragTo(float newOffset, float lastKnownVelocity) {
                this.this$0.setOffset(newOffset);
                this.this$0.setLastVelocity(lastKnownVelocity);
            }
        };
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ AnchoredDraggableState(java.lang.Object r7, kotlin.jvm.functions.Function1 r8, kotlin.jvm.functions.Function0 r9, androidx.compose.animation.core.AnimationSpec r10, kotlin.jvm.functions.Function1 r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r6 = this;
            r13 = r12 & 8
            if (r13 == 0) goto Le
            androidx.compose.material.AnchoredDraggableDefaults r10 = androidx.compose.material.AnchoredDraggableDefaults.INSTANCE
            androidx.compose.animation.core.SpringSpec r10 = r10.getAnimationSpec()
            androidx.compose.animation.core.AnimationSpec r10 = (androidx.compose.animation.core.AnimationSpec) r10
            r4 = r10
            goto Lf
        Le:
            r4 = r10
        Lf:
            r10 = r12 & 16
            if (r10 == 0) goto L1a
            androidx.compose.material.AnchoredDraggableState$1 r10 = new kotlin.jvm.functions.Function1<T, java.lang.Boolean>() { // from class: androidx.compose.material.AnchoredDraggableState.1
                static {
                    /*
                        androidx.compose.material.AnchoredDraggableState$1 r0 = new androidx.compose.material.AnchoredDraggableState$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:androidx.compose.material.AnchoredDraggableState$1) androidx.compose.material.AnchoredDraggableState.1.INSTANCE androidx.compose.material.AnchoredDraggableState$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AnchoredDraggableState.AnonymousClass1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AnchoredDraggableState.AnonymousClass1.<init>():void");
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                public final java.lang.Boolean invoke(T r2) {
                    /*
                        r1 = this;
                        r0 = 1
                        java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AnchoredDraggableState.AnonymousClass1.invoke(java.lang.Object):java.lang.Boolean");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ java.lang.Boolean invoke(java.lang.Object r2) {
                    /*
                        r1 = this;
                        java.lang.Boolean r0 = r1.invoke(r2)
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AnchoredDraggableState.AnonymousClass1.invoke(java.lang.Object):java.lang.Object");
                }
            }
            r11 = r10
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            r5 = r11
            goto L1b
        L1a:
            r5 = r11
        L1b:
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AnchoredDraggableState.<init>(java.lang.Object, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.animation.core.AnimationSpec, kotlin.jvm.functions.Function1, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Function1<Float, Float> getPositionalThreshold$material_release() {
        return this.positionalThreshold;
    }

    public final Function0<Float> getVelocityThreshold$material_release() {
        return this.velocityThreshold;
    }

    public final AnimationSpec<Float> getAnimationSpec() {
        return this.animationSpec;
    }

    public final Function1<T, Boolean> getConfirmValueChange$material_release() {
        return this.confirmValueChange;
    }

    /* renamed from: getDraggableState$material_release, reason: from getter */
    public final DraggableState getDraggableState() {
        return this.draggableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCurrentValue(T t) {
        MutableState $this$setValue$iv = this.currentValue;
        $this$setValue$iv.setValue(t);
    }

    public final T getCurrentValue() {
        State $this$getValue$iv = this.currentValue;
        return $this$getValue$iv.getValue();
    }

    public final T getTargetValue() {
        return (T) this.targetValue.getValue();
    }

    public final T getClosestValue$material_release() {
        return (T) this.closestValue.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setOffset(float f) {
        MutableState $this$setValue$iv = this.offset;
        $this$setValue$iv.setValue(Float.valueOf(f));
    }

    public final float getOffset() {
        State $this$getValue$iv = this.offset;
        return ((Number) $this$getValue$iv.getValue()).floatValue();
    }

    public final float requireOffset() {
        if (!(!Float.isNaN(getOffset()))) {
            throw new IllegalStateException("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?".toString());
        }
        return getOffset();
    }

    public final boolean isAnimationRunning() {
        return getAnimationTarget() != null;
    }

    public final float getProgress() {
        State $this$getValue$iv = this.progress;
        return ((Number) $this$getValue$iv.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setLastVelocity(float f) {
        MutableFloatState $this$setValue$iv = this.lastVelocity;
        $this$setValue$iv.setFloatValue(f);
    }

    public final float getLastVelocity() {
        FloatState $this$getValue$iv = this.lastVelocity;
        return $this$getValue$iv.getFloatValue();
    }

    public final float getMinOffset() {
        State $this$getValue$iv = this.minOffset;
        return ((Number) $this$getValue$iv.getValue()).floatValue();
    }

    public final float getMaxOffset() {
        State $this$getValue$iv = this.maxOffset;
        return ((Number) $this$getValue$iv.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final T getAnimationTarget() {
        State $this$getValue$iv = this.animationTarget;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAnimationTarget(T t) {
        MutableState $this$setValue$iv = this.animationTarget;
        $this$setValue$iv.setValue(t);
    }

    public final Map<T, Float> getAnchors$material_release() {
        State $this$getValue$iv = this.anchors;
        return (Map) $this$getValue$iv.getValue();
    }

    public final void setAnchors$material_release(Map<T, Float> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        MutableState $this$setValue$iv = this.anchors;
        $this$setValue$iv.setValue(map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateAnchors$material_release$default(AnchoredDraggableState anchoredDraggableState, Map map, AnchorChangedCallback anchorChangedCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            anchorChangedCallback = null;
        }
        anchoredDraggableState.updateAnchors$material_release(map, anchorChangedCallback);
    }

    public final void updateAnchors$material_release(Map<T, Float> newAnchors, AnchorChangedCallback<T> onAnchorsChanged) {
        Intrinsics.checkNotNullParameter(newAnchors, "newAnchors");
        if (!Intrinsics.areEqual(getAnchors$material_release(), newAnchors)) {
            Map previousAnchors = getAnchors$material_release();
            T targetValue = getTargetValue();
            boolean previousAnchorsEmpty = getAnchors$material_release().isEmpty();
            setAnchors$material_release(newAnchors);
            boolean currentValueHasAnchor = getAnchors$material_release().get(getCurrentValue()) != null;
            if (previousAnchorsEmpty && currentValueHasAnchor) {
                trySnapTo$material_release(getCurrentValue());
            } else if (onAnchorsChanged != null) {
                onAnchorsChanged.onAnchorsChanged(targetValue, previousAnchors, newAnchors);
            }
        }
    }

    public final boolean hasAnchorForValue(T value) {
        return getAnchors$material_release().containsKey(value);
    }

    public final Object settle(float velocity, Continuation<? super Unit> continuation) {
        T currentValue = getCurrentValue();
        T computeTarget = computeTarget(requireOffset(), currentValue, velocity);
        if (this.confirmValueChange.invoke(computeTarget).booleanValue()) {
            Object animateTo = AnchoredDraggableKt.animateTo(this, computeTarget, velocity, continuation);
            return animateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo : Unit.INSTANCE;
        }
        Object animateTo2 = AnchoredDraggableKt.animateTo(this, currentValue, velocity, continuation);
        return animateTo2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo2 : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final T computeTarget(float offset, T currentValue, float velocity) {
        Map<T, Float> anchors$material_release = getAnchors$material_release();
        Float f = anchors$material_release.get(currentValue);
        float floatValue = this.velocityThreshold.invoke().floatValue();
        if (!Intrinsics.areEqual(f, offset) && f != null) {
            if (f.floatValue() < offset) {
                if (velocity >= floatValue) {
                    return (T) AnchoredDraggableKt.access$closestAnchor(anchors$material_release, offset, true);
                }
                T t = (T) AnchoredDraggableKt.access$closestAnchor(anchors$material_release, offset, true);
                if (offset >= Math.abs(f.floatValue() + Math.abs(this.positionalThreshold.invoke(Float.valueOf(Math.abs(((Number) MapsKt.getValue(anchors$material_release, t)).floatValue() - f.floatValue()))).floatValue()))) {
                    return t;
                }
            } else {
                if (velocity <= (-floatValue)) {
                    return (T) AnchoredDraggableKt.access$closestAnchor(anchors$material_release, offset, false);
                }
                T t2 = (T) AnchoredDraggableKt.access$closestAnchor(anchors$material_release, offset, false);
                float abs = Math.abs(f.floatValue() - Math.abs(this.positionalThreshold.invoke(Float.valueOf(Math.abs(f.floatValue() - ((Number) MapsKt.getValue(anchors$material_release, t2)).floatValue()))).floatValue()));
                if (offset < 0.0f) {
                    if (Math.abs(offset) >= abs) {
                        return t2;
                    }
                } else if (offset <= abs) {
                    return t2;
                }
            }
        }
        return currentValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final T computeTargetWithoutThresholds(float offset, T currentValue) {
        Map<T, Float> anchors$material_release = getAnchors$material_release();
        Float f = anchors$material_release.get(currentValue);
        if (Intrinsics.areEqual(f, offset) || f == null) {
            return currentValue;
        }
        if (f.floatValue() < offset) {
            return (T) AnchoredDraggableKt.access$closestAnchor(anchors$material_release, offset, true);
        }
        return (T) AnchoredDraggableKt.access$closestAnchor(anchors$material_release, offset, false);
    }

    public static /* synthetic */ Object anchoredDrag$default(AnchoredDraggableState anchoredDraggableState, MutatePriority mutatePriority, Function3 function3, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return anchoredDraggableState.anchoredDrag(mutatePriority, function3, continuation);
    }

    public final Object anchoredDrag(MutatePriority dragPriority, Function3<? super AnchoredDragScope, ? super Map<T, Float>, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object doAnchoredDrag = doAnchoredDrag(null, dragPriority, function3, continuation);
        return doAnchoredDrag == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? doAnchoredDrag : Unit.INSTANCE;
    }

    public static /* synthetic */ Object anchoredDrag$default(AnchoredDraggableState anchoredDraggableState, Object obj, MutatePriority mutatePriority, Function3 function3, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return anchoredDraggableState.anchoredDrag(obj, mutatePriority, function3, continuation);
    }

    public final Object anchoredDrag(T t, MutatePriority dragPriority, Function3<? super AnchoredDragScope, ? super Map<T, Float>, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object doAnchoredDrag = doAnchoredDrag(t, dragPriority, function3, continuation);
        return doAnchoredDrag == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? doAnchoredDrag : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object doAnchoredDrag(T t, MutatePriority dragPriority, Function3<? super AnchoredDragScope, ? super Map<T, Float>, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new AnchoredDraggableState$doAnchoredDrag$2(t, this, dragPriority, function3, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    public final float newOffsetForDelta$material_release(float delta) {
        return RangesKt.coerceIn((Float.isNaN(getOffset()) ? 0.0f : getOffset()) + delta, getMinOffset(), getMaxOffset());
    }

    public final float dispatchRawDelta(float delta) {
        float newOffset = newOffsetForDelta$material_release(delta);
        float oldOffset = Float.isNaN(getOffset()) ? 0.0f : getOffset();
        setOffset(newOffset);
        return newOffset - oldOffset;
    }

    public final boolean trySnapTo$material_release(final T targetValue) {
        return this.dragMutex.tryMutate(new Function0<Unit>(this) { // from class: androidx.compose.material.AnchoredDraggableState$trySnapTo$1
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnchoredDragScope $this$invoke_u24lambda_u240;
                $this$invoke_u24lambda_u240 = ((AnchoredDraggableState) this.this$0).anchoredDragScope;
                AnchoredDraggableState<T> anchoredDraggableState = this.this$0;
                Object obj = targetValue;
                Float targetOffset = (Float) anchoredDraggableState.getAnchors$material_release().get(obj);
                if (targetOffset != null) {
                    AnchoredDragScope.dragTo$default($this$invoke_u24lambda_u240, targetOffset.floatValue(), 0.0f, 2, null);
                    anchoredDraggableState.setAnimationTarget(null);
                }
                anchoredDraggableState.setCurrentValue(obj);
            }
        });
    }

    /* compiled from: AnchoredDraggable.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jw\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\b\b\u0001\u0010\u0006*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\f0\u000b2!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\t0\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0012H\u0007¨\u0006\u0013"}, d2 = {"Landroidx/compose/material/AnchoredDraggableState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/AnchoredDraggableState;", "T", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "", "positionalThreshold", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "distance", "velocityThreshold", "Lkotlin/Function0;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T> Saver<AnchoredDraggableState<T>, T> Saver(final AnimationSpec<Float> animationSpec, final Function1<? super T, Boolean> confirmValueChange, final Function1<? super Float, Float> positionalThreshold, final Function0<Float> velocityThreshold) {
            Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
            Intrinsics.checkNotNullParameter(confirmValueChange, "confirmValueChange");
            Intrinsics.checkNotNullParameter(positionalThreshold, "positionalThreshold");
            Intrinsics.checkNotNullParameter(velocityThreshold, "velocityThreshold");
            return SaverKt.Saver(new Function2<SaverScope, AnchoredDraggableState<T>, T>() { // from class: androidx.compose.material.AnchoredDraggableState$Companion$Saver$1
                @Override // kotlin.jvm.functions.Function2
                public final T invoke(SaverScope Saver, AnchoredDraggableState<T> it) {
                    Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.getCurrentValue();
                }
            }, new Function1<T, AnchoredDraggableState<T>>() { // from class: androidx.compose.material.AnchoredDraggableState$Companion$Saver$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke((AnchoredDraggableState$Companion$Saver$2<T>) obj);
                }

                @Override // kotlin.jvm.functions.Function1
                public final AnchoredDraggableState<T> invoke(T it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new AnchoredDraggableState<>(it, positionalThreshold, velocityThreshold, animationSpec, confirmValueChange);
                }
            });
        }
    }
}
