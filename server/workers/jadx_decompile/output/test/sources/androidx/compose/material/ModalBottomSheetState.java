package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.unit.Density;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModalBottomSheet.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0015\b\u0007\u0018\u0000 A2\u00020\u0001:\u0001AB1\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nB=\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\fJ%\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00032\b\b\u0002\u0010/\u001a\u00020\u0006H\u0080@ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u0013\u00102\u001a\u00020-H\u0080@ø\u0001\u0000¢\u0006\u0004\b3\u00104J\u0013\u00105\u001a\u00020-H\u0080@ø\u0001\u0000¢\u0006\u0004\b6\u00104J\u0011\u00107\u001a\u00020-H\u0086@ø\u0001\u0000¢\u0006\u0002\u00104J\b\u00108\u001a\u00020\u0017H\u0002J\r\u00109\u001a\u00020\u0006H\u0000¢\u0006\u0002\b:J\u0011\u0010;\u001a\u00020-H\u0086@ø\u0001\u0000¢\u0006\u0002\u00104J\u001b\u0010<\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0003H\u0080@ø\u0001\u0000¢\u0006\u0004\b=\u0010>J\u0015\u0010?\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u0003H\u0000¢\u0006\u0002\b@R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001eR\u0014\u0010\u000b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0011\u0010\"\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\"\u0010\u001eR\u0014\u0010#\u001a\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\b'\u0010(\u001a\u0004\b)\u0010%R\u0011\u0010*\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b+\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006B"}, d2 = {"Landroidx/compose/material/ModalBottomSheetState;", "", "initialValue", "Landroidx/compose/material/ModalBottomSheetValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "", "(Landroidx/compose/material/ModalBottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;)V", "isSkipHalfExpanded", "(Landroidx/compose/material/ModalBottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function1;)V", "anchoredDraggableState", "Landroidx/compose/material/AnchoredDraggableState;", "getAnchoredDraggableState$material_release", "()Landroidx/compose/material/AnchoredDraggableState;", "getAnimationSpec$material_release", "()Landroidx/compose/animation/core/AnimationSpec;", "currentValue", "getCurrentValue", "()Landroidx/compose/material/ModalBottomSheetValue;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity$material_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$material_release", "(Landroidx/compose/ui/unit/Density;)V", "hasHalfExpandedState", "getHasHalfExpandedState$material_release", "()Z", "isAnimationRunning", "isAnimationRunning$material_release", "isSkipHalfExpanded$material_release", "isVisible", "lastVelocity", "getLastVelocity$material_release", "()F", NotificationCompat.CATEGORY_PROGRESS, "getProgress$annotations", "()V", "getProgress", "targetValue", "getTargetValue", "animateTo", "", "target", "velocity", "animateTo$material_release", "(Landroidx/compose/material/ModalBottomSheetValue;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expand", "expand$material_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "halfExpand", "halfExpand$material_release", "hide", "requireDensity", "requireOffset", "requireOffset$material_release", "show", "snapTo", "snapTo$material_release", "(Landroidx/compose/material/ModalBottomSheetValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySnapTo", "trySnapTo$material_release", "Companion", "material_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ModalBottomSheetState {
    private final AnchoredDraggableState<ModalBottomSheetValue> anchoredDraggableState;
    private final AnimationSpec<Float> animationSpec;
    private Density density;
    private final boolean isSkipHalfExpanded;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public static /* synthetic */ void getProgress$annotations() {
    }

    @Deprecated(message = "This constructor is deprecated. confirmStateChange has been renamed to confirmValueChange.", replaceWith = @ReplaceWith(expression = "ModalBottomSheetState(initialValue, animationSpec, confirmStateChange, isSkipHalfExpanded)", imports = {}))
    public ModalBottomSheetState(ModalBottomSheetValue initialValue, AnimationSpec<Float> animationSpec, boolean isSkipHalfExpanded, Function1<? super ModalBottomSheetValue, Boolean> confirmStateChange) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
        this.animationSpec = animationSpec;
        this.isSkipHalfExpanded = isSkipHalfExpanded;
        this.anchoredDraggableState = new AnchoredDraggableState<>(initialValue, new Function1<Float, Float>() { // from class: androidx.compose.material.ModalBottomSheetState$anchoredDraggableState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Float invoke(Float f) {
                return invoke(f.floatValue());
            }

            public final Float invoke(float it) {
                Density $this$invoke_u24lambda_u240;
                $this$invoke_u24lambda_u240 = ModalBottomSheetState.this.requireDensity();
                return Float.valueOf($this$invoke_u24lambda_u240.mo329toPx0680j_4(ModalBottomSheetKt.access$getModalBottomSheetPositionalThreshold$p()));
            }
        }, new Function0<Float>() { // from class: androidx.compose.material.ModalBottomSheetState$anchoredDraggableState$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                Density $this$invoke_u24lambda_u240;
                $this$invoke_u24lambda_u240 = ModalBottomSheetState.this.requireDensity();
                return Float.valueOf($this$invoke_u24lambda_u240.mo329toPx0680j_4(ModalBottomSheetKt.access$getModalBottomSheetVelocityThreshold$p()));
            }
        }, this.animationSpec, confirmStateChange);
        if (!this.isSkipHalfExpanded) {
            return;
        }
        if (initialValue != ModalBottomSheetValue.HalfExpanded) {
        } else {
            throw new IllegalArgumentException("The initial value must not be set to HalfExpanded if skipHalfExpanded is set to true.".toString());
        }
    }

    public /* synthetic */ ModalBottomSheetState(ModalBottomSheetValue modalBottomSheetValue, SpringSpec<Float> springSpec, boolean z, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(modalBottomSheetValue, (i & 2) != 0 ? SwipeableDefaults.INSTANCE.getAnimationSpec() : springSpec, (i & 4) != 0 ? false : z, function1);
    }

    public final AnimationSpec<Float> getAnimationSpec$material_release() {
        return this.animationSpec;
    }

    /* renamed from: isSkipHalfExpanded$material_release, reason: from getter */
    public final boolean getIsSkipHalfExpanded() {
        return this.isSkipHalfExpanded;
    }

    public final AnchoredDraggableState<ModalBottomSheetValue> getAnchoredDraggableState$material_release() {
        return this.anchoredDraggableState;
    }

    public final ModalBottomSheetValue getCurrentValue() {
        return this.anchoredDraggableState.getCurrentValue();
    }

    public final ModalBottomSheetValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    public final float getProgress() {
        return this.anchoredDraggableState.getProgress();
    }

    public final boolean isVisible() {
        return this.anchoredDraggableState.getCurrentValue() != ModalBottomSheetValue.Hidden;
    }

    public final boolean getHasHalfExpandedState$material_release() {
        return this.anchoredDraggableState.hasAnchorForValue(ModalBottomSheetValue.HalfExpanded);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "This constructor is deprecated. confirmStateChange has been renamed to confirmValueChange.", replaceWith = @ReplaceWith(expression = "ModalBottomSheetState(initialValue, animationSpec, confirmStateChange, false)", imports = {}))
    public ModalBottomSheetState(ModalBottomSheetValue initialValue, AnimationSpec<Float> animationSpec, Function1<? super ModalBottomSheetValue, Boolean> confirmStateChange) {
        this(initialValue, animationSpec, false, confirmStateChange);
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
    }

    public final Object show(Continuation<? super Unit> continuation) {
        ModalBottomSheetValue targetValue = getHasHalfExpandedState$material_release() ? ModalBottomSheetValue.HalfExpanded : ModalBottomSheetValue.Expanded;
        Object animateTo$material_release$default = animateTo$material_release$default(this, targetValue, 0.0f, continuation, 2, null);
        return animateTo$material_release$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$material_release$default : Unit.INSTANCE;
    }

    public final Object halfExpand$material_release(Continuation<? super Unit> continuation) {
        if (!getHasHalfExpandedState$material_release()) {
            return Unit.INSTANCE;
        }
        Object animateTo$material_release$default = animateTo$material_release$default(this, ModalBottomSheetValue.HalfExpanded, 0.0f, continuation, 2, null);
        return animateTo$material_release$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$material_release$default : Unit.INSTANCE;
    }

    public final Object expand$material_release(Continuation<? super Unit> continuation) {
        if (!this.anchoredDraggableState.hasAnchorForValue(ModalBottomSheetValue.Expanded)) {
            return Unit.INSTANCE;
        }
        Object animateTo$material_release$default = animateTo$material_release$default(this, ModalBottomSheetValue.Expanded, 0.0f, continuation, 2, null);
        return animateTo$material_release$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$material_release$default : Unit.INSTANCE;
    }

    public final Object hide(Continuation<? super Unit> continuation) {
        Object animateTo$material_release$default = animateTo$material_release$default(this, ModalBottomSheetValue.Hidden, 0.0f, continuation, 2, null);
        return animateTo$material_release$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$material_release$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateTo$material_release$default(ModalBottomSheetState modalBottomSheetState, ModalBottomSheetValue modalBottomSheetValue, float f, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            f = modalBottomSheetState.anchoredDraggableState.getLastVelocity();
        }
        return modalBottomSheetState.animateTo$material_release(modalBottomSheetValue, f, continuation);
    }

    public final Object animateTo$material_release(ModalBottomSheetValue target, float velocity, Continuation<? super Unit> continuation) {
        Object animateTo = AnchoredDraggableKt.animateTo(this.anchoredDraggableState, target, velocity, continuation);
        return animateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo : Unit.INSTANCE;
    }

    public final Object snapTo$material_release(ModalBottomSheetValue target, Continuation<? super Unit> continuation) {
        Object snapTo = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, target, continuation);
        return snapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? snapTo : Unit.INSTANCE;
    }

    public final boolean trySnapTo$material_release(ModalBottomSheetValue target) {
        Intrinsics.checkNotNullParameter(target, "target");
        return this.anchoredDraggableState.trySnapTo$material_release(target);
    }

    public final float requireOffset$material_release() {
        return this.anchoredDraggableState.requireOffset();
    }

    public final float getLastVelocity$material_release() {
        return this.anchoredDraggableState.getLastVelocity();
    }

    public final boolean isAnimationRunning$material_release() {
        return this.anchoredDraggableState.isAnimationRunning();
    }

    /* renamed from: getDensity$material_release, reason: from getter */
    public final Density getDensity() {
        return this.density;
    }

    public final void setDensity$material_release(Density density) {
        this.density = density;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Density requireDensity() {
        Density density = this.density;
        if (density == null) {
            throw new IllegalArgumentException(("The density on ModalBottomSheetState (" + this + ") was not set. Did you use ModalBottomSheetState with the ModalBottomSheetLayout composable?").toString());
        }
        return density;
    }

    /* compiled from: ModalBottomSheet.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\r\u001a\u00020\fH\u0007JB\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fJ<\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\r\u001a\u00020\f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0007¨\u0006\u0011"}, d2 = {"Landroidx/compose/material/ModalBottomSheetState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/ModalBottomSheetState;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "Landroidx/compose/material/ModalBottomSheetValue;", "", "skipHalfExpanded", "density", "Landroidx/compose/ui/unit/Density;", "confirmStateChange", "material_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<ModalBottomSheetState, ?> Saver(final AnimationSpec<Float> animationSpec, final Function1<? super ModalBottomSheetValue, Boolean> confirmValueChange, final boolean skipHalfExpanded, final Density density) {
            Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
            Intrinsics.checkNotNullParameter(confirmValueChange, "confirmValueChange");
            Intrinsics.checkNotNullParameter(density, "density");
            return SaverKt.Saver(new Function2<SaverScope, ModalBottomSheetState, ModalBottomSheetValue>() { // from class: androidx.compose.material.ModalBottomSheetState$Companion$Saver$1
                @Override // kotlin.jvm.functions.Function2
                public final ModalBottomSheetValue invoke(SaverScope Saver, ModalBottomSheetState it) {
                    Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.getCurrentValue();
                }
            }, new Function1<ModalBottomSheetValue, ModalBottomSheetState>() { // from class: androidx.compose.material.ModalBottomSheetState$Companion$Saver$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final ModalBottomSheetState invoke(ModalBottomSheetValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ModalBottomSheetKt.ModalBottomSheetState(it, Density.this, animationSpec, confirmValueChange, skipHalfExpanded);
                }
            });
        }

        @Deprecated(message = "This function is deprecated. Please use the overload where Density is provided.", replaceWith = @ReplaceWith(expression = "Saver(animationSpec, confirmValueChange, density, skipHalfExpanded)", imports = {}))
        public final Saver<ModalBottomSheetState, ?> Saver(final AnimationSpec<Float> animationSpec, final Function1<? super ModalBottomSheetValue, Boolean> confirmValueChange, final boolean skipHalfExpanded) {
            Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
            Intrinsics.checkNotNullParameter(confirmValueChange, "confirmValueChange");
            return SaverKt.Saver(new Function2<SaverScope, ModalBottomSheetState, ModalBottomSheetValue>() { // from class: androidx.compose.material.ModalBottomSheetState$Companion$Saver$3
                @Override // kotlin.jvm.functions.Function2
                public final ModalBottomSheetValue invoke(SaverScope Saver, ModalBottomSheetState it) {
                    Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.getCurrentValue();
                }
            }, new Function1<ModalBottomSheetValue, ModalBottomSheetState>() { // from class: androidx.compose.material.ModalBottomSheetState$Companion$Saver$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final ModalBottomSheetState invoke(ModalBottomSheetValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ModalBottomSheetKt.ModalBottomSheetState(it, animationSpec, confirmValueChange, skipHalfExpanded);
                }
            });
        }

        @Deprecated(message = "This function is deprecated. confirmStateChange has been renamed to confirmValueChange.", replaceWith = @ReplaceWith(expression = "Saver(animationSpec, confirmStateChange, skipHalfExpanded)", imports = {}))
        public final Saver<ModalBottomSheetState, ?> Saver(AnimationSpec<Float> animationSpec, boolean skipHalfExpanded, Function1<? super ModalBottomSheetValue, Boolean> confirmStateChange) {
            Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
            Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
            return Saver(animationSpec, confirmStateChange, skipHalfExpanded);
        }
    }
}
