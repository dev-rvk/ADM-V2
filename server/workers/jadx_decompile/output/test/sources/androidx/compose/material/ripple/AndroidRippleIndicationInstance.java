package androidx.compose.material.ripple;

import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Ripple.android.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B<\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b\u0012\u0006\u0010\f\u001a\u00020\rø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0018\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020\u0019H\u0002J\b\u0010-\u001a\u00020\u0019H\u0016J\b\u0010.\u001a\u00020\u0019H\u0016J\b\u0010/\u001a\u00020\u0019H\u0016J\u0010\u00100\u001a\u00020\u00192\u0006\u0010(\u001a\u00020)H\u0016J\u0006\u00101\u001a\u00020\u0019J\f\u00102\u001a\u00020\u0019*\u000203H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R+\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00048B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\u00020\u0006X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001aR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u001b8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b!\u0010\u0016\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010$\u001a\u00020%X\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010&\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00064"}, d2 = {"Landroidx/compose/material/ripple/AndroidRippleIndicationInstance;", "Landroidx/compose/material/ripple/RippleIndicationInstance;", "Landroidx/compose/runtime/RememberObserver;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "rippleContainer", "Landroidx/compose/material/ripple/RippleContainer;", "(ZFLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroidx/compose/material/ripple/RippleContainer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "invalidateTick", "getInvalidateTick", "()Z", "setInvalidateTick", "(Z)V", "invalidateTick$delegate", "Landroidx/compose/runtime/MutableState;", "onInvalidateRipple", "Lkotlin/Function0;", "", "F", "Landroidx/compose/material/ripple/RippleHostView;", "rippleHostView", "getRippleHostView", "()Landroidx/compose/material/ripple/RippleHostView;", "setRippleHostView", "(Landroidx/compose/material/ripple/RippleHostView;)V", "rippleHostView$delegate", "rippleRadius", "", "rippleSize", "Landroidx/compose/ui/geometry/Size;", "J", "addRipple", "interaction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "dispose", "onAbandoned", "onForgotten", "onRemembered", "removeRipple", "resetHostView", "drawIndication", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidRippleIndicationInstance extends RippleIndicationInstance implements RememberObserver {
    private final boolean bounded;
    private final State<Color> color;

    /* renamed from: invalidateTick$delegate, reason: from kotlin metadata */
    private final MutableState invalidateTick;
    private final Function0<Unit> onInvalidateRipple;
    private final float radius;
    private final State<RippleAlpha> rippleAlpha;
    private final RippleContainer rippleContainer;

    /* renamed from: rippleHostView$delegate, reason: from kotlin metadata */
    private final MutableState rippleHostView;
    private int rippleRadius;
    private long rippleSize;

    public /* synthetic */ AndroidRippleIndicationInstance(boolean z, float f, State state, State state2, RippleContainer rippleContainer, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, f, state, state2, rippleContainer);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private AndroidRippleIndicationInstance(boolean bounded, float radius, State<Color> color, State<RippleAlpha> rippleAlpha, RippleContainer rippleContainer) {
        super(bounded, rippleAlpha);
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(rippleAlpha, "rippleAlpha");
        Intrinsics.checkNotNullParameter(rippleContainer, "rippleContainer");
        this.bounded = bounded;
        this.radius = radius;
        this.color = color;
        this.rippleAlpha = rippleAlpha;
        this.rippleContainer = rippleContainer;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.rippleHostView = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
        this.invalidateTick = mutableStateOf$default2;
        this.rippleSize = Size.INSTANCE.m2788getZeroNHjbRc();
        this.rippleRadius = -1;
        this.onInvalidateRipple = new Function0<Unit>() { // from class: androidx.compose.material.ripple.AndroidRippleIndicationInstance$onInvalidateRipple$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                boolean invalidateTick;
                AndroidRippleIndicationInstance androidRippleIndicationInstance = AndroidRippleIndicationInstance.this;
                invalidateTick = AndroidRippleIndicationInstance.this.getInvalidateTick();
                androidRippleIndicationInstance.setInvalidateTick(!invalidateTick);
            }
        };
    }

    private final RippleHostView getRippleHostView() {
        State $this$getValue$iv = this.rippleHostView;
        return (RippleHostView) $this$getValue$iv.getValue();
    }

    private final void setRippleHostView(RippleHostView rippleHostView) {
        MutableState $this$setValue$iv = this.rippleHostView;
        $this$setValue$iv.setValue(rippleHostView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getInvalidateTick() {
        State $this$getValue$iv = this.invalidateTick;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setInvalidateTick(boolean z) {
        MutableState $this$setValue$iv = this.invalidateTick;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    @Override // androidx.compose.foundation.IndicationInstance
    public void drawIndication(ContentDrawScope $this$drawIndication) {
        int i;
        Intrinsics.checkNotNullParameter($this$drawIndication, "<this>");
        this.rippleSize = $this$drawIndication.mo3492getSizeNHjbRc();
        float $this$isUnspecified$iv = this.radius;
        if (Float.isNaN($this$isUnspecified$iv)) {
            i = MathKt.roundToInt(RippleAnimationKt.m1280getRippleEndRadiuscSwnlzA($this$drawIndication, this.bounded, $this$drawIndication.mo3492getSizeNHjbRc()));
        } else {
            i = $this$drawIndication.mo323roundToPx0680j_4(this.radius);
        }
        this.rippleRadius = i;
        long color = this.color.getValue().m2959unboximpl();
        float alpha = this.rippleAlpha.getValue().getPressedAlpha();
        $this$drawIndication.drawContent();
        m1285drawStateLayerH2RKhps($this$drawIndication, this.radius, color);
        ContentDrawScope $this$drawIntoCanvas$iv = $this$drawIndication;
        Canvas canvas = $this$drawIntoCanvas$iv.getDrawContext().getCanvas();
        getInvalidateTick();
        RippleHostView $this$drawIndication_u24lambda_u241_u24lambda_u240 = getRippleHostView();
        if ($this$drawIndication_u24lambda_u241_u24lambda_u240 != null) {
            $this$drawIndication_u24lambda_u241_u24lambda_u240.m1284updateRipplePropertiesbiQXAtU($this$drawIndication.mo3492getSizeNHjbRc(), this.rippleRadius, color, alpha);
            $this$drawIndication_u24lambda_u241_u24lambda_u240.draw(AndroidCanvas_androidKt.getNativeCanvas(canvas));
        }
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void addRipple(PressInteraction.Press interaction, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        Intrinsics.checkNotNullParameter(scope, "scope");
        RippleContainer $this$addRipple_u24lambda_u243 = this.rippleContainer;
        RippleHostView $this$addRipple_u24lambda_u243_u24lambda_u242 = $this$addRipple_u24lambda_u243.getRippleHostView(this);
        $this$addRipple_u24lambda_u243_u24lambda_u242.m1283addRippleKOepWvA(interaction, this.bounded, this.rippleSize, this.rippleRadius, this.color.getValue().m2959unboximpl(), this.rippleAlpha.getValue().getPressedAlpha(), this.onInvalidateRipple);
        setRippleHostView($this$addRipple_u24lambda_u243_u24lambda_u242);
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void removeRipple(PressInteraction.Press interaction) {
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        RippleHostView rippleHostView = getRippleHostView();
        if (rippleHostView != null) {
            rippleHostView.removeRipple();
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        dispose();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
        dispose();
    }

    private final void dispose() {
        RippleContainer $this$dispose_u24lambda_u244 = this.rippleContainer;
        $this$dispose_u24lambda_u244.disposeRippleIfNeeded(this);
    }

    public final void resetHostView() {
        setRippleHostView(null);
    }
}
