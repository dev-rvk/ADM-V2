package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.unit.Density;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: SwipeableV2.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b5\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u0000 s*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001sB\u007f\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012#\b\u0002\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\b\u0012.\b\u0002\u0010\r\u001a(\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00060\u000e¢\u0006\u0002\b\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000¢\u0006\u0002\u0010\u0014J#\u0010V\u001a\u00020W2\u0006\u0010Q\u001a\u00028\u00002\b\b\u0002\u0010X\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010YJ%\u0010Z\u001a\u00028\u00002\u0006\u0010@\u001a\u00020\u00062\u0006\u0010(\u001a\u00028\u00002\u0006\u0010X\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010[J\u000e\u0010\\\u001a\u00020\u00062\u0006\u0010]\u001a\u00020\u0006J\u0013\u0010^\u001a\u00020\f2\u0006\u0010_\u001a\u00028\u0000¢\u0006\u0002\u0010`J\b\u0010a\u001a\u00020\u000fH\u0002J\u0006\u0010b\u001a\u00020\u0006J\u0019\u0010c\u001a\u00020W2\u0006\u0010X\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010dJ\u0015\u0010e\u001a\u00020W2\u0006\u0010Q\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010$J\u0019\u0010f\u001a\u00020W2\u0006\u0010Q\u001a\u00028\u0000H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010gJ9\u0010h\u001a\u00020W2\b\b\u0002\u0010i\u001a\u00020j2\u001c\u0010k\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020W0l\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010mJ\u0017\u0010n\u001a\u00020\f2\u0006\u0010Q\u001a\u00028\u0000H\u0000¢\u0006\u0004\bo\u0010`J!\u0010p\u001a\u00020\f2\u0012\u0010q\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0016H\u0000¢\u0006\u0002\brRC\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u00162\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u00168@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR/\u0010 \u001a\u0004\u0018\u00018\u00002\b\u0010\u0015\u001a\u0004\u0018\u00018\u00008B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010\u001d\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R/\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R+\u0010(\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010\u001d\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\u001c\u0010,\u001a\u0004\u0018\u00010\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0011\u00101\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b1\u00102R+\u00103\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00068F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b8\u0010\u001d\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001b\u00109\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b:\u00105R\u001b\u0010=\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u0010<\u001a\u0004\b>\u00105R/\u0010@\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00068F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bE\u0010\u001d\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR:\u0010\r\u001a(\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00060\u000e¢\u0006\u0002\b\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u001b\u0010H\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010<\u001a\u0004\bI\u00105R\u0014\u0010K\u001a\u00020LX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u000e\u0010O\u001a\u00020PX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010Q\u001a\u00028\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bS\u0010<\u001a\u0004\bR\u0010\"R\u001f\u0010\u0012\u001a\u00020\u0013X\u0080\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010U\u001a\u0004\bT\u00105\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006t"}, d2 = {"Landroidx/compose/material3/SwipeableV2State;", "T", "", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "newValue", "", "positionalThreshold", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "totalDistance", "Lkotlin/ExtensionFunctionType;", "velocityThreshold", "Landroidx/compose/ui/unit/Dp;", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "", "anchors", "getAnchors$material3_release", "()Ljava/util/Map;", "setAnchors$material3_release", "(Ljava/util/Map;)V", "anchors$delegate", "Landroidx/compose/runtime/MutableState;", "getAnimationSpec$material3_release", "()Landroidx/compose/animation/core/AnimationSpec;", "animationTarget", "getAnimationTarget", "()Ljava/lang/Object;", "setAnimationTarget", "(Ljava/lang/Object;)V", "animationTarget$delegate", "getConfirmValueChange$material3_release", "()Lkotlin/jvm/functions/Function1;", "currentValue", "getCurrentValue", "setCurrentValue", "currentValue$delegate", "density", "getDensity$material3_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$material3_release", "(Landroidx/compose/ui/unit/Density;)V", "isAnimationRunning", "()Z", "lastVelocity", "getLastVelocity", "()F", "setLastVelocity", "(F)V", "lastVelocity$delegate", "maxOffset", "getMaxOffset", "maxOffset$delegate", "Landroidx/compose/runtime/State;", "minOffset", "getMinOffset", "minOffset$delegate", "offset", "getOffset", "()Ljava/lang/Float;", "setOffset", "(Ljava/lang/Float;)V", "offset$delegate", "getPositionalThreshold$material3_release", "()Lkotlin/jvm/functions/Function2;", NotificationCompat.CATEGORY_PROGRESS, "getProgress", "progress$delegate", "swipeDraggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "getSwipeDraggableState$material3_release", "()Landroidx/compose/foundation/gestures/DraggableState;", "swipeMutex", "Landroidx/compose/material3/InternalMutatorMutex;", "targetValue", "getTargetValue", "targetValue$delegate", "getVelocityThreshold-D9Ej5fM$material3_release", "F", "animateTo", "", "velocity", "(Ljava/lang/Object;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "computeTarget", "(FLjava/lang/Object;F)Ljava/lang/Object;", "dispatchRawDelta", "delta", "hasAnchorForValue", "value", "(Ljava/lang/Object;)Z", "requireDensity", "requireOffset", "settle", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snap", "snapTo", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "swipe", "swipePriority", "Landroidx/compose/foundation/MutatePriority;", "action", "Lkotlin/coroutines/Continuation;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySnapTo", "trySnapTo$material3_release", "updateAnchors", "newAnchors", "updateAnchors$material3_release", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SwipeableV2State<T> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: anchors$delegate, reason: from kotlin metadata */
    private final MutableState anchors;
    private final AnimationSpec<Float> animationSpec;

    /* renamed from: animationTarget$delegate, reason: from kotlin metadata */
    private final MutableState animationTarget;
    private final Function1<T, Boolean> confirmValueChange;

    /* renamed from: currentValue$delegate, reason: from kotlin metadata */
    private final MutableState currentValue;
    private Density density;

    /* renamed from: lastVelocity$delegate, reason: from kotlin metadata */
    private final MutableState lastVelocity;

    /* renamed from: maxOffset$delegate, reason: from kotlin metadata */
    private final State maxOffset;

    /* renamed from: minOffset$delegate, reason: from kotlin metadata */
    private final State minOffset;

    /* renamed from: offset$delegate, reason: from kotlin metadata */
    private final MutableState offset;
    private final Function2<Density, Float, Float> positionalThreshold;

    /* renamed from: progress$delegate, reason: from kotlin metadata */
    private final State progress;
    private final DraggableState swipeDraggableState;
    private final InternalMutatorMutex swipeMutex;

    /* renamed from: targetValue$delegate, reason: from kotlin metadata */
    private final State targetValue;
    private final float velocityThreshold;

    public /* synthetic */ SwipeableV2State(Object obj, AnimationSpec animationSpec, Function1 function1, Function2 function2, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, animationSpec, function1, function2, f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SwipeableV2State(T t, AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> confirmValueChange, Function2<? super Density, ? super Float, Float> positionalThreshold, float velocityThreshold) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        MutableState mutableStateOf$default5;
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(confirmValueChange, "confirmValueChange");
        Intrinsics.checkNotNullParameter(positionalThreshold, "positionalThreshold");
        this.animationSpec = animationSpec;
        this.confirmValueChange = confirmValueChange;
        this.positionalThreshold = positionalThreshold;
        this.velocityThreshold = velocityThreshold;
        this.swipeMutex = new InternalMutatorMutex();
        this.swipeDraggableState = new SwipeableV2State$swipeDraggableState$1(this);
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
        this.currentValue = mutableStateOf$default;
        this.targetValue = SnapshotStateKt.derivedStateOf(new Function0<T>(this) { // from class: androidx.compose.material3.SwipeableV2State$targetValue$2
            final /* synthetic */ SwipeableV2State<T> this$0;

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
                SwipeableV2State<T> swipeableV2State = this.this$0;
                Float offset = swipeableV2State.getOffset();
                if (offset != null) {
                    computeTarget = swipeableV2State.computeTarget(offset.floatValue(), swipeableV2State.getCurrentValue(), 0.0f);
                    t2 = computeTarget;
                } else {
                    t2 = swipeableV2State.getCurrentValue();
                }
                return t2;
            }
        });
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.offset = mutableStateOf$default2;
        this.progress = SnapshotStateKt.derivedStateOf(new Function0<Float>(this) { // from class: androidx.compose.material3.SwipeableV2State$progress$2
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                Float f = (Float) this.this$0.getAnchors$material3_release().get(this.this$0.getCurrentValue());
                float f2 = 0.0f;
                float a = f != null ? f.floatValue() : 0.0f;
                Float f3 = (Float) this.this$0.getAnchors$material3_release().get(this.this$0.getTargetValue());
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
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
        this.lastVelocity = mutableStateOf$default3;
        this.minOffset = SnapshotStateKt.derivedStateOf(new Function0<Float>(this) { // from class: androidx.compose.material3.SwipeableV2State$minOffset$2
            final /* synthetic */ SwipeableV2State<T> this$0;

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
                minOrNull = SwipeableV2Kt.minOrNull(this.this$0.getAnchors$material3_release());
                return Float.valueOf(minOrNull != null ? minOrNull.floatValue() : Float.NEGATIVE_INFINITY);
            }
        });
        this.maxOffset = SnapshotStateKt.derivedStateOf(new Function0<Float>(this) { // from class: androidx.compose.material3.SwipeableV2State$maxOffset$2
            final /* synthetic */ SwipeableV2State<T> this$0;

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
                maxOrNull = SwipeableV2Kt.maxOrNull(this.this$0.getAnchors$material3_release());
                return Float.valueOf(maxOrNull != null ? maxOrNull.floatValue() : Float.POSITIVE_INFINITY);
            }
        });
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.animationTarget = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(MapsKt.emptyMap(), null, 2, null);
        this.anchors = mutableStateOf$default5;
    }

    public /* synthetic */ SwipeableV2State(Object obj, AnimationSpec animationSpec, Function1 function1, Function2 function2, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? SwipeableV2Defaults.INSTANCE.getAnimationSpec() : animationSpec, (i & 4) != 0 ? new Function1<T, Boolean>() { // from class: androidx.compose.material3.SwipeableV2State.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(T t) {
                return true;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Object p1) {
                return invoke((AnonymousClass1) p1);
            }
        } : function1, (i & 8) != 0 ? SwipeableV2Defaults.INSTANCE.getPositionalThreshold() : function2, (i & 16) != 0 ? SwipeableV2Defaults.INSTANCE.m1809getVelocityThresholdD9Ej5fM() : f, null);
    }

    public final AnimationSpec<Float> getAnimationSpec$material3_release() {
        return this.animationSpec;
    }

    public final Function1<T, Boolean> getConfirmValueChange$material3_release() {
        return this.confirmValueChange;
    }

    public final Function2<Density, Float, Float> getPositionalThreshold$material3_release() {
        return this.positionalThreshold;
    }

    /* renamed from: getVelocityThreshold-D9Ej5fM$material3_release, reason: not valid java name and from getter */
    public final float getVelocityThreshold() {
        return this.velocityThreshold;
    }

    /* renamed from: getSwipeDraggableState$material3_release, reason: from getter */
    public final DraggableState getSwipeDraggableState() {
        return this.swipeDraggableState;
    }

    private final void setCurrentValue(T t) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void setOffset(Float f) {
        MutableState $this$setValue$iv = this.offset;
        $this$setValue$iv.setValue(f);
    }

    public final Float getOffset() {
        State $this$getValue$iv = this.offset;
        return (Float) $this$getValue$iv.getValue();
    }

    public final float requireOffset() {
        Float offset = getOffset();
        if (offset != null) {
            return offset.floatValue();
        }
        throw new IllegalStateException("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?".toString());
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
        MutableState $this$setValue$iv = this.lastVelocity;
        $this$setValue$iv.setValue(Float.valueOf(f));
    }

    public final float getLastVelocity() {
        State $this$getValue$iv = this.lastVelocity;
        return ((Number) $this$getValue$iv.getValue()).floatValue();
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

    public final Map<T, Float> getAnchors$material3_release() {
        State $this$getValue$iv = this.anchors;
        return (Map) $this$getValue$iv.getValue();
    }

    public final void setAnchors$material3_release(Map<T, Float> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        MutableState $this$setValue$iv = this.anchors;
        $this$setValue$iv.setValue(map);
    }

    /* renamed from: getDensity$material3_release, reason: from getter */
    public final Density getDensity() {
        return this.density;
    }

    public final void setDensity$material3_release(Density density) {
        this.density = density;
    }

    public final boolean updateAnchors$material3_release(Map<T, Float> newAnchors) {
        boolean initialValueHasAnchor;
        Intrinsics.checkNotNullParameter(newAnchors, "newAnchors");
        boolean previousAnchorsEmpty = getAnchors$material3_release().isEmpty();
        setAnchors$material3_release(newAnchors);
        if (previousAnchorsEmpty) {
            T currentValue = getCurrentValue();
            Float initialValueAnchor = getAnchors$material3_release().get(currentValue);
            initialValueHasAnchor = initialValueAnchor != null;
            if (initialValueHasAnchor) {
                trySnapTo$material3_release(currentValue);
            }
        } else {
            initialValueHasAnchor = true;
        }
        return (initialValueHasAnchor && previousAnchorsEmpty) ? false : true;
    }

    public final boolean hasAnchorForValue(T value) {
        return getAnchors$material3_release().containsKey(value);
    }

    public final Object snapTo(T t, Continuation<? super Unit> continuation) {
        Object swipe$default = swipe$default(this, null, new SwipeableV2State$snapTo$2(this, t, null), continuation, 1, null);
        return swipe$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? swipe$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateTo$default(SwipeableV2State swipeableV2State, Object obj, float f, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            f = swipeableV2State.getLastVelocity();
        }
        return swipeableV2State.animateTo(obj, f, continuation);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x002d. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x011a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object animateTo(T r22, float r23, kotlin.coroutines.Continuation<? super kotlin.Unit> r24) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SwipeableV2State.animateTo(java.lang.Object, float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object settle(float velocity, Continuation<? super Unit> continuation) {
        T currentValue = getCurrentValue();
        T computeTarget = computeTarget(requireOffset(), currentValue, velocity);
        if (this.confirmValueChange.invoke(computeTarget).booleanValue()) {
            Object animateTo = animateTo(computeTarget, velocity, continuation);
            return animateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo : Unit.INSTANCE;
        }
        Object animateTo2 = animateTo(currentValue, velocity, continuation);
        return animateTo2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo2 : Unit.INSTANCE;
    }

    public final float dispatchRawDelta(float delta) {
        Float offset = getOffset();
        float currentDragPosition = offset != null ? offset.floatValue() : 0.0f;
        float potentiallyConsumed = currentDragPosition + delta;
        float clamped = RangesKt.coerceIn(potentiallyConsumed, getMinOffset(), getMaxOffset());
        float deltaToConsume = clamped - currentDragPosition;
        if (Math.abs(deltaToConsume) >= 0.0f) {
            Float offset2 = getOffset();
            setOffset(Float.valueOf(RangesKt.coerceIn((offset2 != null ? offset2.floatValue() : 0.0f) + deltaToConsume, getMinOffset(), getMaxOffset())));
        }
        return deltaToConsume;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final T computeTarget(float offset, T currentValue, float velocity) {
        Map<T, Float> anchors$material3_release = getAnchors$material3_release();
        Float f = anchors$material3_release.get(currentValue);
        Density requireDensity = requireDensity();
        float mo329toPx0680j_4 = requireDensity.mo329toPx0680j_4(this.velocityThreshold);
        if (!Intrinsics.areEqual(f, offset) && f != null) {
            if (f.floatValue() < offset) {
                if (velocity >= mo329toPx0680j_4) {
                    return (T) SwipeableV2Kt.access$closestAnchor(anchors$material3_release, offset, true);
                }
                T t = (T) SwipeableV2Kt.access$closestAnchor(anchors$material3_release, offset, true);
                if (offset >= Math.abs(f.floatValue() + Math.abs(this.positionalThreshold.invoke(requireDensity, Float.valueOf(Math.abs(((Number) MapsKt.getValue(anchors$material3_release, t)).floatValue() - f.floatValue()))).floatValue()))) {
                    return t;
                }
            } else {
                if (velocity <= (-mo329toPx0680j_4)) {
                    return (T) SwipeableV2Kt.access$closestAnchor(anchors$material3_release, offset, false);
                }
                T t2 = (T) SwipeableV2Kt.access$closestAnchor(anchors$material3_release, offset, false);
                float abs = Math.abs(f.floatValue() - Math.abs(this.positionalThreshold.invoke(requireDensity, Float.valueOf(Math.abs(f.floatValue() - ((Number) MapsKt.getValue(anchors$material3_release, t2)).floatValue()))).floatValue()));
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

    private final Density requireDensity() {
        Density density = this.density;
        if (density == null) {
            throw new IllegalArgumentException(("SwipeableState did not have a density attached. Are you using Modifier.swipeable with this=" + this + " SwipeableState?").toString());
        }
        return density;
    }

    static /* synthetic */ Object swipe$default(SwipeableV2State swipeableV2State, MutatePriority mutatePriority, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return swipeableV2State.swipe(mutatePriority, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object swipe(MutatePriority swipePriority, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new SwipeableV2State$swipe$2(this, swipePriority, function1, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    public final boolean trySnapTo$material3_release(final T targetValue) {
        return this.swipeMutex.tryMutate(new Function0<Unit>(this) { // from class: androidx.compose.material3.SwipeableV2State$trySnapTo$1
            final /* synthetic */ SwipeableV2State<T> this$0;

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
                this.this$0.snap(targetValue);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void snap(T targetValue) {
        Float targetOffset = getAnchors$material3_release().get(targetValue);
        if (targetOffset != null) {
            float floatValue = targetOffset.floatValue();
            Float offset = getOffset();
            dispatchRawDelta(floatValue - (offset != null ? offset.floatValue() : 0.0f));
            setCurrentValue(targetValue);
            setAnimationTarget(null);
            return;
        }
        setCurrentValue(targetValue);
    }

    /* compiled from: SwipeableV2.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0089\u0001\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\b\b\u0001\u0010\u0006*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\f0\u000b2,\u0010\r\u001a(\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\u0002\b\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Landroidx/compose/material3/SwipeableV2State$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/SwipeableV2State;", "T", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "", "positionalThreshold", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "distance", "Lkotlin/ExtensionFunctionType;", "velocityThreshold", "Landroidx/compose/ui/unit/Dp;", "Saver-eqLRuRQ", "(Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;F)Landroidx/compose/runtime/saveable/Saver;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: Saver-eqLRuRQ, reason: not valid java name */
        public final <T> Saver<SwipeableV2State<T>, T> m1813SavereqLRuRQ(final AnimationSpec<Float> animationSpec, final Function1<? super T, Boolean> confirmValueChange, final Function2<? super Density, ? super Float, Float> positionalThreshold, final float velocityThreshold) {
            Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
            Intrinsics.checkNotNullParameter(confirmValueChange, "confirmValueChange");
            Intrinsics.checkNotNullParameter(positionalThreshold, "positionalThreshold");
            return SaverKt.Saver(new Function2<SaverScope, SwipeableV2State<T>, T>() { // from class: androidx.compose.material3.SwipeableV2State$Companion$Saver$1
                @Override // kotlin.jvm.functions.Function2
                public final T invoke(SaverScope Saver, SwipeableV2State<T> it) {
                    Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.getCurrentValue();
                }
            }, new Function1<T, SwipeableV2State<T>>() { // from class: androidx.compose.material3.SwipeableV2State$Companion$Saver$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke((SwipeableV2State$Companion$Saver$2<T>) obj);
                }

                @Override // kotlin.jvm.functions.Function1
                public final SwipeableV2State<T> invoke(T it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new SwipeableV2State<>(it, animationSpec, confirmValueChange, positionalThreshold, velocityThreshold, null);
                }
            });
        }
    }
}
