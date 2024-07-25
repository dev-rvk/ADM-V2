package androidx.compose.material;

import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
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

/* compiled from: Drawer.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0014\b\u0007\u0018\u0000 A2\u00020\u0001:\u0001AB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J%\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00032\b\b\u0002\u00100\u001a\u00020\u001dH\u0080@ø\u0001\u0000¢\u0006\u0004\b1\u00102J\u0011\u00103\u001a\u00020.H\u0086@ø\u0001\u0000¢\u0006\u0002\u00104J\u0015\u0010\u0004\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u0003H\u0000¢\u0006\u0002\b6J\u0011\u00107\u001a\u00020.H\u0086@ø\u0001\u0000¢\u0006\u0002\u00104J\u0011\u00108\u001a\u00020.H\u0086@ø\u0001\u0000¢\u0006\u0002\u00104J\b\u00109\u001a\u00020\u0010H\u0002J\r\u0010:\u001a\u00020\u001dH\u0000¢\u0006\u0002\b;J\u001b\u0010<\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0003H\u0080@ø\u0001\u0000¢\u0006\u0004\b=\u0010>J\u0015\u0010?\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0003H\u0000¢\u0006\u0002\b@R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0019\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u001a\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u001d8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0017\u0010$\u001a\u00020\u001d8F¢\u0006\f\u0012\u0004\b%\u0010&\u001a\u0004\b'\u0010\u001fR\u001a\u0010(\u001a\u00020\u001d8FX\u0087\u0004¢\u0006\f\u0012\u0004\b)\u0010&\u001a\u0004\b*\u0010\u001fR\u0011\u0010+\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b,\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006B"}, d2 = {"Landroidx/compose/material/BottomDrawerState;", "", "initialValue", "Landroidx/compose/material/BottomDrawerValue;", "confirmStateChange", "Lkotlin/Function1;", "", "(Landroidx/compose/material/BottomDrawerValue;Lkotlin/jvm/functions/Function1;)V", "anchoredDraggableState", "Landroidx/compose/material/AnchoredDraggableState;", "getAnchoredDraggableState$material_release", "()Landroidx/compose/material/AnchoredDraggableState;", "currentValue", "getCurrentValue", "()Landroidx/compose/material/BottomDrawerValue;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity$material_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$material_release", "(Landroidx/compose/ui/unit/Density;)V", "isAnimationRunning", "isAnimationRunning$material_release", "()Z", "isClosed", "isExpanded", "isOpen", "isOpenEnabled", "lastVelocity", "", "getLastVelocity$material_release", "()F", "nestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getNestedScrollConnection$material_release", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "offset", "getOffset$annotations", "()V", "getOffset", NotificationCompat.CATEGORY_PROGRESS, "getProgress$annotations", "getProgress", "targetValue", "getTargetValue", "animateTo", "", "target", "velocity", "animateTo$material_release", "(Landroidx/compose/material/BottomDrawerValue;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "value", "confirmStateChange$material_release", "expand", "open", "requireDensity", "requireOffset", "requireOffset$material_release", "snapTo", "snapTo$material_release", "(Landroidx/compose/material/BottomDrawerValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySnapTo", "trySnapTo$material_release", "Companion", "material_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class BottomDrawerState {
    private final AnchoredDraggableState<BottomDrawerValue> anchoredDraggableState;
    private Density density;
    private final NestedScrollConnection nestedScrollConnection;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public static /* synthetic */ void getOffset$annotations() {
    }

    public static /* synthetic */ void getProgress$annotations() {
    }

    @Deprecated(message = "This constructor is deprecated. Density must be provided by the component. Please use the constructor that provides a [Density].", replaceWith = @ReplaceWith(expression = "\n            BottomDrawerState(\n                initialValue = initialValue,\n                density =,\n                confirmStateChange = confirmStateChange\n            )\n            ", imports = {}))
    public BottomDrawerState(BottomDrawerValue initialValue, Function1<? super BottomDrawerValue, Boolean> confirmStateChange) {
        TweenSpec tweenSpec;
        NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection;
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
        tweenSpec = DrawerKt.AnimationSpec;
        this.anchoredDraggableState = new AnchoredDraggableState<>(initialValue, new Function1<Float, Float>() { // from class: androidx.compose.material.BottomDrawerState$anchoredDraggableState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final Float invoke(float it) {
                Density $this$invoke_u24lambda_u240;
                float f;
                $this$invoke_u24lambda_u240 = BottomDrawerState.this.requireDensity();
                f = DrawerKt.DrawerPositionalThreshold;
                return Float.valueOf($this$invoke_u24lambda_u240.mo329toPx0680j_4(f));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Float invoke(Float f) {
                return invoke(f.floatValue());
            }
        }, new Function0<Float>() { // from class: androidx.compose.material.BottomDrawerState$anchoredDraggableState$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                Density $this$invoke_u24lambda_u240;
                float f;
                $this$invoke_u24lambda_u240 = BottomDrawerState.this.requireDensity();
                f = DrawerKt.DrawerVelocityThreshold;
                return Float.valueOf($this$invoke_u24lambda_u240.mo329toPx0680j_4(f));
            }
        }, tweenSpec, confirmStateChange);
        ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection = DrawerKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(this.anchoredDraggableState);
        this.nestedScrollConnection = ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection;
    }

    public /* synthetic */ BottomDrawerState(BottomDrawerValue bottomDrawerValue, AnonymousClass1 anonymousClass1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bottomDrawerValue, (i & 2) != 0 ? new Function1<BottomDrawerValue, Boolean>() { // from class: androidx.compose.material.BottomDrawerState.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(BottomDrawerValue it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return true;
            }
        } : anonymousClass1);
    }

    public final AnchoredDraggableState<BottomDrawerValue> getAnchoredDraggableState$material_release() {
        return this.anchoredDraggableState;
    }

    public final BottomDrawerValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    public final float getOffset() {
        return this.anchoredDraggableState.getOffset();
    }

    public final float requireOffset$material_release() {
        return this.anchoredDraggableState.requireOffset();
    }

    public final BottomDrawerValue getCurrentValue() {
        return this.anchoredDraggableState.getCurrentValue();
    }

    public final float getProgress() {
        return this.anchoredDraggableState.getProgress();
    }

    public final boolean isOpen() {
        return this.anchoredDraggableState.getCurrentValue() != BottomDrawerValue.Closed;
    }

    public final boolean isClosed() {
        return this.anchoredDraggableState.getCurrentValue() == BottomDrawerValue.Closed;
    }

    public final boolean isExpanded() {
        return this.anchoredDraggableState.getCurrentValue() == BottomDrawerValue.Expanded;
    }

    public final Object open(Continuation<? super Unit> continuation) {
        BottomDrawerValue targetValue = isOpenEnabled() ? BottomDrawerValue.Open : BottomDrawerValue.Expanded;
        Object animateTo$default = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, targetValue, 0.0f, continuation, 2, null);
        return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }

    public final Object close(Continuation<? super Unit> continuation) {
        Object animateTo$default = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, BottomDrawerValue.Closed, 0.0f, continuation, 2, null);
        return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }

    public final Object expand(Continuation<? super Unit> continuation) {
        Object animateTo$default = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, BottomDrawerValue.Expanded, 0.0f, continuation, 2, null);
        return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateTo$material_release$default(BottomDrawerState bottomDrawerState, BottomDrawerValue bottomDrawerValue, float f, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            f = bottomDrawerState.anchoredDraggableState.getLastVelocity();
        }
        return bottomDrawerState.animateTo$material_release(bottomDrawerValue, f, continuation);
    }

    public final Object animateTo$material_release(BottomDrawerValue target, float velocity, Continuation<? super Unit> continuation) {
        Object animateTo = AnchoredDraggableKt.animateTo(this.anchoredDraggableState, target, velocity, continuation);
        return animateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo : Unit.INSTANCE;
    }

    public final Object snapTo$material_release(BottomDrawerValue target, Continuation<? super Unit> continuation) {
        Object snapTo = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, target, continuation);
        return snapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? snapTo : Unit.INSTANCE;
    }

    public final boolean trySnapTo$material_release(BottomDrawerValue target) {
        Intrinsics.checkNotNullParameter(target, "target");
        return this.anchoredDraggableState.trySnapTo$material_release(target);
    }

    public final boolean confirmStateChange$material_release(BottomDrawerValue value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return this.anchoredDraggableState.getConfirmValueChange$material_release().invoke(value).booleanValue();
    }

    private final boolean isOpenEnabled() {
        return this.anchoredDraggableState.hasAnchorForValue(BottomDrawerValue.Open);
    }

    /* renamed from: getNestedScrollConnection$material_release, reason: from getter */
    public final NestedScrollConnection getNestedScrollConnection() {
        return this.nestedScrollConnection;
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
            throw new IllegalArgumentException(("The density on BottomDrawerState (" + this + ") was not set. Did you use BottomDrawer with the BottomDrawer composable?").toString());
        }
        return density;
    }

    public final boolean isAnimationRunning$material_release() {
        return this.anchoredDraggableState.isAnimationRunning();
    }

    public final float getLastVelocity$material_release() {
        return this.anchoredDraggableState.getLastVelocity();
    }

    /* compiled from: Drawer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bH\u0007J.\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b¨\u0006\f"}, d2 = {"Landroidx/compose/material/BottomDrawerState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/BottomDrawerState;", "Landroidx/compose/material/BottomDrawerValue;", "confirmStateChange", "Lkotlin/Function1;", "", "density", "Landroidx/compose/ui/unit/Density;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<BottomDrawerState, BottomDrawerValue> Saver(final Density density, final Function1<? super BottomDrawerValue, Boolean> confirmStateChange) {
            Intrinsics.checkNotNullParameter(density, "density");
            Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
            return SaverKt.Saver(new Function2<SaverScope, BottomDrawerState, BottomDrawerValue>() { // from class: androidx.compose.material.BottomDrawerState$Companion$Saver$1
                @Override // kotlin.jvm.functions.Function2
                public final BottomDrawerValue invoke(SaverScope Saver, BottomDrawerState it) {
                    Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.getAnchoredDraggableState$material_release().getCurrentValue();
                }
            }, new Function1<BottomDrawerValue, BottomDrawerState>() { // from class: androidx.compose.material.BottomDrawerState$Companion$Saver$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final BottomDrawerState invoke(BottomDrawerValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return DrawerKt.BottomDrawerState(it, Density.this, confirmStateChange);
                }
            });
        }

        @Deprecated(message = "This function is deprecated. Please use the overload where Density is provided.", replaceWith = @ReplaceWith(expression = "Saver(density, confirmValueChange)", imports = {}))
        public final Saver<BottomDrawerState, BottomDrawerValue> Saver(final Function1<? super BottomDrawerValue, Boolean> confirmStateChange) {
            Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
            return SaverKt.Saver(new Function2<SaverScope, BottomDrawerState, BottomDrawerValue>() { // from class: androidx.compose.material.BottomDrawerState$Companion$Saver$3
                @Override // kotlin.jvm.functions.Function2
                public final BottomDrawerValue invoke(SaverScope Saver, BottomDrawerState it) {
                    Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.getAnchoredDraggableState$material_release().getCurrentValue();
                }
            }, new Function1<BottomDrawerValue, BottomDrawerState>() { // from class: androidx.compose.material.BottomDrawerState$Companion$Saver$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final BottomDrawerState invoke(BottomDrawerValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new BottomDrawerState(it, confirmStateChange);
                }
            });
        }
    }
}
