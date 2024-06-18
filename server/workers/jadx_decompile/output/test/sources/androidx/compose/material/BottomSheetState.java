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

/* compiled from: BottomSheetScaffold.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 92\u00020\u0001:\u00019B5\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ%\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\u0006H\u0080@ø\u0001\u0000¢\u0006\u0004\b-\u0010.J\u0011\u0010/\u001a\u00020*H\u0086@ø\u0001\u0000¢\u0006\u0002\u00100J\u0011\u00101\u001a\u00020*H\u0086@ø\u0001\u0000¢\u0006\u0002\u00100J\b\u00102\u001a\u00020\u0013H\u0002J\u0006\u00103\u001a\u00020\u0006J\u001b\u00104\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0003H\u0080@ø\u0001\u0000¢\u0006\u0004\b5\u00106J\u0015\u00107\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0003H\u0000¢\u0006\u0002\b8R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u001c\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u001fR\u001a\u0010$\u001a\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\"\u001a\u0004\b&\u0010\u001fR\u0011\u0010'\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b(\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006:"}, d2 = {"Landroidx/compose/material/BottomSheetState;", "", "initialValue", "Landroidx/compose/material/BottomSheetValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "", "(Landroidx/compose/material/BottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;)V", "anchoredDraggableState", "Landroidx/compose/material/AnchoredDraggableState;", "getAnchoredDraggableState$material_release", "()Landroidx/compose/material/AnchoredDraggableState;", "currentValue", "getCurrentValue", "()Landroidx/compose/material/BottomSheetValue;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity$material_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$material_release", "(Landroidx/compose/ui/unit/Density;)V", "isAnimationRunning", "isAnimationRunning$material_release", "()Z", "isCollapsed", "isExpanded", "lastVelocity", "getLastVelocity$material_release", "()F", "offset", "getOffset$annotations", "()V", "getOffset", NotificationCompat.CATEGORY_PROGRESS, "getProgress$annotations", "getProgress", "targetValue", "getTargetValue", "animateTo", "", "target", "velocity", "animateTo$material_release", "(Landroidx/compose/material/BottomSheetValue;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collapse", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expand", "requireDensity", "requireOffset", "snapTo", "snapTo$material_release", "(Landroidx/compose/material/BottomSheetValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySnapTo", "trySnapTo$material_release", "Companion", "material_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class BottomSheetState {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AnchoredDraggableState<BottomSheetValue> anchoredDraggableState;
    private Density density;

    @Deprecated(message = "Use requireOffset() to access the offset.", replaceWith = @ReplaceWith(expression = "requireOffset()", imports = {}))
    public static /* synthetic */ void getOffset$annotations() {
    }

    public static /* synthetic */ void getProgress$annotations() {
    }

    @Deprecated(message = "This constructor is deprecated. Density must be provided by the component. Please use the constructor that provides a [Density].", replaceWith = @ReplaceWith(expression = "\n            BottomSheetState(\n                initialValue = initialValue,\n                density = LocalDensity.current,\n                animationSpec = animationSpec,\n                confirmValueChange = confirmValueChange\n            )\n            ", imports = {}))
    public BottomSheetState(BottomSheetValue initialValue, AnimationSpec<Float> animationSpec, Function1<? super BottomSheetValue, Boolean> confirmValueChange) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(confirmValueChange, "confirmValueChange");
        this.anchoredDraggableState = new AnchoredDraggableState<>(initialValue, new Function1<Float, Float>() { // from class: androidx.compose.material.BottomSheetState$anchoredDraggableState$1
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
                $this$invoke_u24lambda_u240 = BottomSheetState.this.requireDensity();
                return Float.valueOf($this$invoke_u24lambda_u240.mo329toPx0680j_4(BottomSheetScaffoldKt.access$getBottomSheetScaffoldPositionalThreshold$p()));
            }
        }, new Function0<Float>() { // from class: androidx.compose.material.BottomSheetState$anchoredDraggableState$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                Density $this$invoke_u24lambda_u240;
                $this$invoke_u24lambda_u240 = BottomSheetState.this.requireDensity();
                return Float.valueOf($this$invoke_u24lambda_u240.mo329toPx0680j_4(BottomSheetScaffoldKt.access$getBottomSheetScaffoldVelocityThreshold$p()));
            }
        }, animationSpec, confirmValueChange);
    }

    public /* synthetic */ BottomSheetState(BottomSheetValue bottomSheetValue, SpringSpec<Float> springSpec, AnonymousClass1 anonymousClass1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bottomSheetValue, (i & 2) != 0 ? SwipeableDefaults.INSTANCE.getAnimationSpec() : springSpec, (i & 4) != 0 ? new Function1<BottomSheetValue, Boolean>() { // from class: androidx.compose.material.BottomSheetState.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(BottomSheetValue it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return true;
            }
        } : anonymousClass1);
    }

    public final AnchoredDraggableState<BottomSheetValue> getAnchoredDraggableState$material_release() {
        return this.anchoredDraggableState;
    }

    public final BottomSheetValue getCurrentValue() {
        return this.anchoredDraggableState.getCurrentValue();
    }

    public final BottomSheetValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    public final boolean isExpanded() {
        return this.anchoredDraggableState.getCurrentValue() == BottomSheetValue.Expanded;
    }

    public final boolean isCollapsed() {
        return this.anchoredDraggableState.getCurrentValue() == BottomSheetValue.Collapsed;
    }

    public final float getProgress() {
        return this.anchoredDraggableState.getProgress();
    }

    public final Object expand(Continuation<? super Unit> continuation) {
        BottomSheetValue target = this.anchoredDraggableState.hasAnchorForValue(BottomSheetValue.Expanded) ? BottomSheetValue.Expanded : BottomSheetValue.Collapsed;
        Object animateTo$default = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, target, 0.0f, continuation, 2, null);
        return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }

    public final Object collapse(Continuation<? super Unit> continuation) {
        Object animateTo$default = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, BottomSheetValue.Collapsed, 0.0f, continuation, 2, null);
        return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }

    public final float getOffset() {
        throw new IllegalStateException("Use requireOffset() to access the offset.".toString());
    }

    public final float requireOffset() {
        return this.anchoredDraggableState.requireOffset();
    }

    public static /* synthetic */ Object animateTo$material_release$default(BottomSheetState bottomSheetState, BottomSheetValue bottomSheetValue, float f, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            f = bottomSheetState.anchoredDraggableState.getLastVelocity();
        }
        return bottomSheetState.animateTo$material_release(bottomSheetValue, f, continuation);
    }

    public final Object animateTo$material_release(BottomSheetValue target, float velocity, Continuation<? super Unit> continuation) {
        Object animateTo = AnchoredDraggableKt.animateTo(this.anchoredDraggableState, target, velocity, continuation);
        return animateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo : Unit.INSTANCE;
    }

    public final Object snapTo$material_release(BottomSheetValue target, Continuation<? super Unit> continuation) {
        Object snapTo = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, target, continuation);
        return snapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? snapTo : Unit.INSTANCE;
    }

    public final boolean trySnapTo$material_release(BottomSheetValue target) {
        Intrinsics.checkNotNullParameter(target, "target");
        return this.anchoredDraggableState.trySnapTo$material_release(target);
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
            throw new IllegalArgumentException(("The density on BottomSheetState (" + this + ") was not set. Did you use BottomSheetState with the BottomSheetScaffold composable?").toString());
        }
        return density;
    }

    public final float getLastVelocity$material_release() {
        return this.anchoredDraggableState.getLastVelocity();
    }

    /* compiled from: BottomSheetScaffold.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0007J:\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/material/BottomSheetState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/BottomSheetState;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "Landroidx/compose/material/BottomSheetValue;", "", "density", "Landroidx/compose/ui/unit/Density;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<BottomSheetState, ?> Saver(final AnimationSpec<Float> animationSpec, final Function1<? super BottomSheetValue, Boolean> confirmStateChange, final Density density) {
            Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
            Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
            Intrinsics.checkNotNullParameter(density, "density");
            return SaverKt.Saver(new Function2<SaverScope, BottomSheetState, BottomSheetValue>() { // from class: androidx.compose.material.BottomSheetState$Companion$Saver$1
                @Override // kotlin.jvm.functions.Function2
                public final BottomSheetValue invoke(SaverScope Saver, BottomSheetState it) {
                    Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.getAnchoredDraggableState$material_release().getCurrentValue();
                }
            }, new Function1<BottomSheetValue, BottomSheetState>() { // from class: androidx.compose.material.BottomSheetState$Companion$Saver$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final BottomSheetState invoke(BottomSheetValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return BottomSheetScaffoldKt.BottomSheetState(it, Density.this, animationSpec, confirmStateChange);
                }
            });
        }

        @Deprecated(message = "This function is deprecated. Please use the overload where Density is provided.", replaceWith = @ReplaceWith(expression = "Saver(animationSpec, confirmStateChange, density)", imports = {}))
        public final Saver<BottomSheetState, ?> Saver(final AnimationSpec<Float> animationSpec, final Function1<? super BottomSheetValue, Boolean> confirmStateChange) {
            Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
            Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
            return SaverKt.Saver(new Function2<SaverScope, BottomSheetState, BottomSheetValue>() { // from class: androidx.compose.material.BottomSheetState$Companion$Saver$3
                @Override // kotlin.jvm.functions.Function2
                public final BottomSheetValue invoke(SaverScope Saver, BottomSheetState it) {
                    Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.getAnchoredDraggableState$material_release().getCurrentValue();
                }
            }, new Function1<BottomSheetValue, BottomSheetState>() { // from class: androidx.compose.material.BottomSheetState$Companion$Saver$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final BottomSheetState invoke(BottomSheetValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new BottomSheetState(it, animationSpec, confirmStateChange);
                }
            });
        }
    }
}
