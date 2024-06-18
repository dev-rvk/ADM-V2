package androidx.compose.foundation;

import android.content.Context;
import android.widget.EdgeEffect;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: AndroidOverscroll.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010-\u001a\u00020!H\u0002JE\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u0002002\"\u00101\u001a\u001e\b\u0001\u0012\u0004\u0012\u000200\u0012\n\u0012\b\u0012\u0004\u0012\u00020003\u0012\u0006\u0012\u0004\u0018\u00010402H\u0096@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b5\u00106J9\u00107\u001a\u00020%2\u0006\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020:2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%0\u001fH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010=J\b\u0010>\u001a\u00020!H\u0002J%\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020%H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010DJ%\u0010E\u001a\u00020@2\u0006\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020%H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bF\u0010DJ%\u0010G\u001a\u00020@2\u0006\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020%H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bH\u0010DJ%\u0010I\u001a\u00020@2\u0006\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020%H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bJ\u0010DJ\u001d\u0010K\u001a\u00020\u00142\u0006\u00108\u001a\u00020%H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bL\u0010MJ\b\u0010N\u001a\u00020\u0014H\u0002J \u0010O\u001a\u00020\u0014*\u00020P2\u0006\u0010Q\u001a\u00020\t2\n\u0010R\u001a\u00060Sj\u0002`TH\u0002J \u0010U\u001a\u00020\u0014*\u00020P2\u0006\u0010V\u001a\u00020\t2\n\u0010R\u001a\u00060Sj\u0002`TH\u0002J\n\u0010W\u001a\u00020!*\u00020PJ \u0010X\u001a\u00020\u0014*\u00020P2\u0006\u0010Y\u001a\u00020\t2\n\u0010R\u001a\u00060Sj\u0002`TH\u0002J \u0010Z\u001a\u00020\u0014*\u00020P2\u0006\u0010[\u001a\u00020\t2\n\u0010R\u001a\u00060Sj\u0002`TH\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\u00020\rX\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u00020\u00148\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0018R\u000e\u0010\u001c\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001fX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u0019\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020!0'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\\"}, d2 = {"Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "Landroidx/compose/foundation/OverscrollEffect;", "context", "Landroid/content/Context;", "overscrollConfig", "Landroidx/compose/foundation/OverscrollConfiguration;", "(Landroid/content/Context;Landroidx/compose/foundation/OverscrollConfiguration;)V", "allEffects", "", "Landroid/widget/EdgeEffect;", "bottomEffect", "bottomEffectNegation", "containerSize", "Landroidx/compose/ui/geometry/Size;", "J", "effectModifier", "Landroidx/compose/ui/Modifier;", "getEffectModifier", "()Landroidx/compose/ui/Modifier;", "invalidationEnabled", "", "getInvalidationEnabled$foundation_release$annotations", "()V", "getInvalidationEnabled$foundation_release", "()Z", "setInvalidationEnabled$foundation_release", "(Z)V", "isInProgress", "leftEffect", "leftEffectNegation", "onNewSize", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "redrawSignal", "Landroidx/compose/runtime/MutableState;", "rightEffect", "rightEffectNegation", "scrollCycleInProgress", "topEffect", "topEffectNegation", "animateToRelease", "applyToFling", "velocity", "Landroidx/compose/ui/unit/Velocity;", "performFling", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "applyToFling-BMRW4eQ", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyToScroll", "delta", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "performScroll", "applyToScroll-Rhakbz0", "(JILkotlin/jvm/functions/Function1;)J", "invalidateOverscroll", "pullBottom", "", "scroll", "displacement", "pullBottom-0a9Yr6o", "(JJ)F", "pullLeft", "pullLeft-0a9Yr6o", "pullRight", "pullRight-0a9Yr6o", "pullTop", "pullTop-0a9Yr6o", "releaseOppositeOverscroll", "releaseOppositeOverscroll-k-4lQ0M", "(J)Z", "stopOverscrollAnimation", "drawBottom", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "bottom", "canvas", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/NativeCanvas;", "drawLeft", "left", "drawOverscroll", "drawRight", "right", "drawTop", "top", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidEdgeEffectOverscrollEffect implements OverscrollEffect {
    private final List<EdgeEffect> allEffects;
    private final EdgeEffect bottomEffect;
    private final EdgeEffect bottomEffectNegation;
    private long containerSize;
    private final Modifier effectModifier;
    private boolean invalidationEnabled;
    private final EdgeEffect leftEffect;
    private final EdgeEffect leftEffectNegation;
    private final Function1<IntSize, Unit> onNewSize;
    private final OverscrollConfiguration overscrollConfig;
    private PointerId pointerId;
    private Offset pointerPosition;
    private final MutableState<Unit> redrawSignal;
    private final EdgeEffect rightEffect;
    private final EdgeEffect rightEffectNegation;
    private boolean scrollCycleInProgress;
    private final EdgeEffect topEffect;
    private final EdgeEffect topEffectNegation;

    public static /* synthetic */ void getInvalidationEnabled$foundation_release$annotations() {
    }

    public AndroidEdgeEffectOverscrollEffect(Context context, OverscrollConfiguration overscrollConfig) {
        Modifier modifier;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(overscrollConfig, "overscrollConfig");
        this.overscrollConfig = overscrollConfig;
        this.topEffect = EdgeEffectCompat.INSTANCE.create(context, null);
        this.bottomEffect = EdgeEffectCompat.INSTANCE.create(context, null);
        this.leftEffect = EdgeEffectCompat.INSTANCE.create(context, null);
        this.rightEffect = EdgeEffectCompat.INSTANCE.create(context, null);
        this.allEffects = CollectionsKt.listOf((Object[]) new EdgeEffect[]{this.leftEffect, this.topEffect, this.rightEffect, this.bottomEffect});
        this.topEffectNegation = EdgeEffectCompat.INSTANCE.create(context, null);
        this.bottomEffectNegation = EdgeEffectCompat.INSTANCE.create(context, null);
        this.leftEffectNegation = EdgeEffectCompat.INSTANCE.create(context, null);
        this.rightEffectNegation = EdgeEffectCompat.INSTANCE.create(context, null);
        List $this$fastForEach$iv = this.allEffects;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            EdgeEffect it = (EdgeEffect) item$iv;
            it.setColor(ColorKt.m3003toArgb8_81llA(this.overscrollConfig.getGlowColor()));
        }
        this.redrawSignal = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
        this.invalidationEnabled = true;
        this.containerSize = Size.INSTANCE.m2788getZeroNHjbRc();
        this.onNewSize = new Function1<IntSize, Unit>() { // from class: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$onNewSize$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                m159invokeozmzZPI(intSize.getPackedValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-ozmzZPI, reason: not valid java name */
            public final void m159invokeozmzZPI(long size2) {
                long j;
                EdgeEffect edgeEffect;
                EdgeEffect edgeEffect2;
                EdgeEffect edgeEffect3;
                EdgeEffect edgeEffect4;
                EdgeEffect edgeEffect5;
                EdgeEffect edgeEffect6;
                EdgeEffect edgeEffect7;
                EdgeEffect edgeEffect8;
                long m5388toSizeozmzZPI = IntSizeKt.m5388toSizeozmzZPI(size2);
                j = AndroidEdgeEffectOverscrollEffect.this.containerSize;
                boolean differentSize = !Size.m2775equalsimpl0(m5388toSizeozmzZPI, j);
                AndroidEdgeEffectOverscrollEffect.this.containerSize = IntSizeKt.m5388toSizeozmzZPI(size2);
                if (differentSize) {
                    edgeEffect = AndroidEdgeEffectOverscrollEffect.this.topEffect;
                    edgeEffect.setSize(IntSize.m5378getWidthimpl(size2), IntSize.m5377getHeightimpl(size2));
                    edgeEffect2 = AndroidEdgeEffectOverscrollEffect.this.bottomEffect;
                    edgeEffect2.setSize(IntSize.m5378getWidthimpl(size2), IntSize.m5377getHeightimpl(size2));
                    edgeEffect3 = AndroidEdgeEffectOverscrollEffect.this.leftEffect;
                    edgeEffect3.setSize(IntSize.m5377getHeightimpl(size2), IntSize.m5378getWidthimpl(size2));
                    edgeEffect4 = AndroidEdgeEffectOverscrollEffect.this.rightEffect;
                    edgeEffect4.setSize(IntSize.m5377getHeightimpl(size2), IntSize.m5378getWidthimpl(size2));
                    edgeEffect5 = AndroidEdgeEffectOverscrollEffect.this.topEffectNegation;
                    edgeEffect5.setSize(IntSize.m5378getWidthimpl(size2), IntSize.m5377getHeightimpl(size2));
                    edgeEffect6 = AndroidEdgeEffectOverscrollEffect.this.bottomEffectNegation;
                    edgeEffect6.setSize(IntSize.m5378getWidthimpl(size2), IntSize.m5377getHeightimpl(size2));
                    edgeEffect7 = AndroidEdgeEffectOverscrollEffect.this.leftEffectNegation;
                    edgeEffect7.setSize(IntSize.m5377getHeightimpl(size2), IntSize.m5378getWidthimpl(size2));
                    edgeEffect8 = AndroidEdgeEffectOverscrollEffect.this.rightEffectNegation;
                    edgeEffect8.setSize(IntSize.m5377getHeightimpl(size2), IntSize.m5378getWidthimpl(size2));
                }
                if (differentSize) {
                    AndroidEdgeEffectOverscrollEffect.this.invalidateOverscroll();
                    AndroidEdgeEffectOverscrollEffect.this.animateToRelease();
                }
            }
        };
        Modifier.Companion companion = Modifier.INSTANCE;
        modifier = AndroidOverscrollKt.StretchOverscrollNonClippingLayer;
        this.effectModifier = OnRemeasuredModifierKt.onSizeChanged(SuspendingPointerInputFilterKt.pointerInput(companion.then(modifier), Unit.INSTANCE, new AndroidEdgeEffectOverscrollEffect$effectModifier$1(this, null)), this.onNewSize).then(new DrawOverscrollModifier(this, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$special$$inlined$debugInspectorInfo$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                $this$null.setName("overscroll");
                $this$null.setValue(AndroidEdgeEffectOverscrollEffect.this);
            }
        } : InspectableValueKt.getNoInspectorInfo()));
    }

    /* renamed from: getInvalidationEnabled$foundation_release, reason: from getter */
    public final boolean getInvalidationEnabled() {
        return this.invalidationEnabled;
    }

    public final void setInvalidationEnabled$foundation_release(boolean z) {
        this.invalidationEnabled = z;
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    /* renamed from: applyToScroll-Rhakbz0, reason: not valid java name */
    public long mo158applyToScrollRhakbz0(long delta, int source, Function1<? super Offset, Offset> performScroll) {
        float consumedPixelsY;
        boolean appliedHorizontalOverscroll;
        boolean appliedVerticalOverscroll;
        Intrinsics.checkNotNullParameter(performScroll, "performScroll");
        if (Size.m2781isEmptyimpl(this.containerSize)) {
            return performScroll.invoke(Offset.m2699boximpl(delta)).getPackedValue();
        }
        if (!this.scrollCycleInProgress) {
            stopOverscrollAnimation();
            this.scrollCycleInProgress = true;
        }
        Offset offset = this.pointerPosition;
        long pointer = offset != null ? offset.getPackedValue() : SizeKt.m2789getCenteruvyYCjk(this.containerSize);
        float consumedPixelsX = 0.0f;
        if (Offset.m2711getYimpl(delta) == 0.0f) {
            consumedPixelsY = 0.0f;
        } else {
            if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect) == 0.0f) {
                if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect) == 0.0f)) {
                    consumedPixelsY = m152pullBottom0a9Yr6o(delta, pointer);
                    if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect) == 0.0f) {
                        this.bottomEffect.onRelease();
                    }
                } else {
                    consumedPixelsY = 0.0f;
                }
            } else {
                consumedPixelsY = m155pullTop0a9Yr6o(delta, pointer);
                if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect) == 0.0f) {
                    this.topEffect.onRelease();
                }
            }
        }
        if (!(Offset.m2710getXimpl(delta) == 0.0f)) {
            if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect) == 0.0f) {
                if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect) == 0.0f)) {
                    float m154pullRight0a9Yr6o = m154pullRight0a9Yr6o(delta, pointer);
                    if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect) == 0.0f) {
                        this.rightEffect.onRelease();
                    }
                    consumedPixelsX = m154pullRight0a9Yr6o;
                }
            } else {
                float m153pullLeft0a9Yr6o = m153pullLeft0a9Yr6o(delta, pointer);
                if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect) == 0.0f) {
                    this.leftEffect.onRelease();
                }
                consumedPixelsX = m153pullLeft0a9Yr6o;
            }
        }
        long consumedOffset = OffsetKt.Offset(consumedPixelsX, consumedPixelsY);
        if (!Offset.m2707equalsimpl0(consumedOffset, Offset.INSTANCE.m2726getZeroF1C5BW0())) {
            invalidateOverscroll();
        }
        long leftForDelta = Offset.m2714minusMKHz9U(delta, consumedOffset);
        long consumedByDelta = performScroll.invoke(Offset.m2699boximpl(leftForDelta)).getPackedValue();
        long leftForOverscroll = Offset.m2714minusMKHz9U(leftForDelta, consumedByDelta);
        boolean needsInvalidation = false;
        if (NestedScrollSource.m3960equalsimpl0(source, NestedScrollSource.INSTANCE.m3965getDragWNlRxjI())) {
            if (Offset.m2710getXimpl(leftForOverscroll) > 0.5f) {
                m153pullLeft0a9Yr6o(leftForOverscroll, pointer);
                appliedHorizontalOverscroll = true;
            } else if (Offset.m2710getXimpl(leftForOverscroll) < -0.5f) {
                m154pullRight0a9Yr6o(leftForOverscroll, pointer);
                appliedHorizontalOverscroll = true;
            } else {
                appliedHorizontalOverscroll = false;
            }
            if (Offset.m2711getYimpl(leftForOverscroll) > 0.5f) {
                m155pullTop0a9Yr6o(leftForOverscroll, pointer);
                appliedVerticalOverscroll = true;
            } else if (Offset.m2711getYimpl(leftForOverscroll) < -0.5f) {
                m152pullBottom0a9Yr6o(leftForOverscroll, pointer);
                appliedVerticalOverscroll = true;
            } else {
                appliedVerticalOverscroll = false;
            }
            needsInvalidation = appliedHorizontalOverscroll || appliedVerticalOverscroll;
        }
        boolean appliedHorizontalOverscroll2 = m156releaseOppositeOverscrollk4lQ0M(delta);
        boolean needsInvalidation2 = appliedHorizontalOverscroll2 || needsInvalidation;
        if (needsInvalidation2) {
            invalidateOverscroll();
        }
        return Offset.m2715plusMKHz9U(consumedOffset, consumedByDelta);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0024. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // androidx.compose.foundation.OverscrollEffect
    /* renamed from: applyToFling-BMRW4eQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo157applyToFlingBMRW4eQ(long r10, kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Velocity, ? super kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity>, ? extends java.lang.Object> r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            Method dump skipped, instructions count: 458
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.mo157applyToFlingBMRW4eQ(long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public boolean isInProgress() {
        List $this$fastAny$iv = this.allEffects;
        int index$iv$iv = 0;
        int size = $this$fastAny$iv.size();
        while (true) {
            if (index$iv$iv >= size) {
                return false;
            }
            Object item$iv$iv = $this$fastAny$iv.get(index$iv$iv);
            EdgeEffect it = (EdgeEffect) item$iv$iv;
            if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(it) == 0.0f)) {
                return true;
            }
            index$iv$iv++;
        }
    }

    private final boolean stopOverscrollAnimation() {
        boolean stopped = false;
        long fakeDisplacement = SizeKt.m2789getCenteruvyYCjk(this.containerSize);
        if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect) == 0.0f)) {
            m153pullLeft0a9Yr6o(Offset.INSTANCE.m2726getZeroF1C5BW0(), fakeDisplacement);
            stopped = true;
        }
        if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect) == 0.0f)) {
            m154pullRight0a9Yr6o(Offset.INSTANCE.m2726getZeroF1C5BW0(), fakeDisplacement);
            stopped = true;
        }
        if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect) == 0.0f)) {
            m155pullTop0a9Yr6o(Offset.INSTANCE.m2726getZeroF1C5BW0(), fakeDisplacement);
            stopped = true;
        }
        if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect) == 0.0f)) {
            m152pullBottom0a9Yr6o(Offset.INSTANCE.m2726getZeroF1C5BW0(), fakeDisplacement);
            return true;
        }
        return stopped;
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public Modifier getEffectModifier() {
        return this.effectModifier;
    }

    public final void drawOverscroll(DrawScope $this$drawOverscroll) {
        Intrinsics.checkNotNullParameter($this$drawOverscroll, "<this>");
        if (Size.m2781isEmptyimpl(this.containerSize)) {
            return;
        }
        Canvas it = $this$drawOverscroll.getDrawContext().getCanvas();
        this.redrawSignal.getValue();
        android.graphics.Canvas canvas = AndroidCanvas_androidKt.getNativeCanvas(it);
        boolean needsInvalidate = false;
        boolean z = true;
        if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffectNegation) == 0.0f)) {
            drawRight($this$drawOverscroll, this.leftEffectNegation, canvas);
            this.leftEffectNegation.finish();
        }
        if (!this.leftEffect.isFinished()) {
            needsInvalidate = drawLeft($this$drawOverscroll, this.leftEffect, canvas);
            EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.leftEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect), 0.0f);
        }
        if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffectNegation) == 0.0f)) {
            drawBottom($this$drawOverscroll, this.topEffectNegation, canvas);
            this.topEffectNegation.finish();
        }
        if (!this.topEffect.isFinished()) {
            needsInvalidate = drawTop($this$drawOverscroll, this.topEffect, canvas) || needsInvalidate;
            EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.topEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect), 0.0f);
        }
        if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffectNegation) == 0.0f)) {
            drawLeft($this$drawOverscroll, this.rightEffectNegation, canvas);
            this.rightEffectNegation.finish();
        }
        if (!this.rightEffect.isFinished()) {
            needsInvalidate = drawRight($this$drawOverscroll, this.rightEffect, canvas) || needsInvalidate;
            EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.rightEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect), 0.0f);
        }
        if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffectNegation) == 0.0f)) {
            drawTop($this$drawOverscroll, this.bottomEffectNegation, canvas);
            this.bottomEffectNegation.finish();
        }
        if (!this.bottomEffect.isFinished()) {
            if (!drawBottom($this$drawOverscroll, this.bottomEffect, canvas) && !needsInvalidate) {
                z = false;
            }
            needsInvalidate = z;
            EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.bottomEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect), 0.0f);
        }
        if (needsInvalidate) {
            invalidateOverscroll();
        }
    }

    private final boolean drawLeft(DrawScope $this$drawLeft, EdgeEffect left, android.graphics.Canvas canvas) {
        int restore = canvas.save();
        canvas.rotate(270.0f);
        canvas.translate(-Size.m2776getHeightimpl(this.containerSize), $this$drawLeft.mo329toPx0680j_4(this.overscrollConfig.getDrawPadding().mo435calculateLeftPaddingu2uoSUM($this$drawLeft.getLayoutDirection())));
        boolean needsInvalidate = left.draw(canvas);
        canvas.restoreToCount(restore);
        return needsInvalidate;
    }

    private final boolean drawTop(DrawScope $this$drawTop, EdgeEffect top, android.graphics.Canvas canvas) {
        int restore = canvas.save();
        canvas.translate(0.0f, $this$drawTop.mo329toPx0680j_4(this.overscrollConfig.getDrawPadding().getTop()));
        boolean needsInvalidate = top.draw(canvas);
        canvas.restoreToCount(restore);
        return needsInvalidate;
    }

    private final boolean drawRight(DrawScope $this$drawRight, EdgeEffect right, android.graphics.Canvas canvas) {
        int restore = canvas.save();
        int width = MathKt.roundToInt(Size.m2779getWidthimpl(this.containerSize));
        float rightPadding = this.overscrollConfig.getDrawPadding().mo436calculateRightPaddingu2uoSUM($this$drawRight.getLayoutDirection());
        canvas.rotate(90.0f);
        canvas.translate(0.0f, (-width) + $this$drawRight.mo329toPx0680j_4(rightPadding));
        boolean needsInvalidate = right.draw(canvas);
        canvas.restoreToCount(restore);
        return needsInvalidate;
    }

    private final boolean drawBottom(DrawScope $this$drawBottom, EdgeEffect bottom, android.graphics.Canvas canvas) {
        int restore = canvas.save();
        canvas.rotate(180.0f);
        float bottomPadding = $this$drawBottom.mo329toPx0680j_4(this.overscrollConfig.getDrawPadding().getBottom());
        canvas.translate(-Size.m2779getWidthimpl(this.containerSize), (-Size.m2776getHeightimpl(this.containerSize)) + bottomPadding);
        boolean needsInvalidate = bottom.draw(canvas);
        canvas.restoreToCount(restore);
        return needsInvalidate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateOverscroll() {
        if (this.invalidationEnabled) {
            this.redrawSignal.setValue(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void animateToRelease() {
        boolean needsInvalidation = false;
        List $this$fastForEach$iv = this.allEffects;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            EdgeEffect it = (EdgeEffect) item$iv;
            it.onRelease();
            needsInvalidation = it.isFinished() || needsInvalidation;
        }
        if (needsInvalidation) {
            invalidateOverscroll();
        }
    }

    /* renamed from: releaseOppositeOverscroll-k-4lQ0M, reason: not valid java name */
    private final boolean m156releaseOppositeOverscrollk4lQ0M(long delta) {
        boolean needsInvalidation = false;
        if (!this.leftEffect.isFinished() && Offset.m2710getXimpl(delta) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.leftEffect, Offset.m2710getXimpl(delta));
            needsInvalidation = this.leftEffect.isFinished();
        }
        if (!this.rightEffect.isFinished() && Offset.m2710getXimpl(delta) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.rightEffect, Offset.m2710getXimpl(delta));
            needsInvalidation = needsInvalidation || this.rightEffect.isFinished();
        }
        if (!this.topEffect.isFinished() && Offset.m2711getYimpl(delta) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.topEffect, Offset.m2711getYimpl(delta));
            needsInvalidation = needsInvalidation || this.topEffect.isFinished();
        }
        if (!this.bottomEffect.isFinished() && Offset.m2711getYimpl(delta) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.bottomEffect, Offset.m2711getYimpl(delta));
            return needsInvalidation || this.bottomEffect.isFinished();
        }
        return needsInvalidation;
    }

    /* renamed from: pullTop-0a9Yr6o, reason: not valid java name */
    private final float m155pullTop0a9Yr6o(long scroll, long displacement) {
        float displacementX = Offset.m2710getXimpl(displacement) / Size.m2779getWidthimpl(this.containerSize);
        float pullY = Offset.m2711getYimpl(scroll) / Size.m2776getHeightimpl(this.containerSize);
        float consumed = EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.topEffect, pullY, displacementX) * Size.m2776getHeightimpl(this.containerSize);
        if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect) == 0.0f)) {
            return Offset.m2711getYimpl(scroll);
        }
        return consumed;
    }

    /* renamed from: pullBottom-0a9Yr6o, reason: not valid java name */
    private final float m152pullBottom0a9Yr6o(long scroll, long displacement) {
        float displacementX = Offset.m2710getXimpl(displacement) / Size.m2779getWidthimpl(this.containerSize);
        float pullY = Offset.m2711getYimpl(scroll) / Size.m2776getHeightimpl(this.containerSize);
        float consumed = (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.bottomEffect, -pullY, 1 - displacementX)) * Size.m2776getHeightimpl(this.containerSize);
        if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect) == 0.0f)) {
            return Offset.m2711getYimpl(scroll);
        }
        return consumed;
    }

    /* renamed from: pullLeft-0a9Yr6o, reason: not valid java name */
    private final float m153pullLeft0a9Yr6o(long scroll, long displacement) {
        float displacementY = Offset.m2711getYimpl(displacement) / Size.m2776getHeightimpl(this.containerSize);
        float pullX = Offset.m2710getXimpl(scroll) / Size.m2779getWidthimpl(this.containerSize);
        float consumed = EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.leftEffect, pullX, 1 - displacementY) * Size.m2779getWidthimpl(this.containerSize);
        if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect) == 0.0f)) {
            return Offset.m2710getXimpl(scroll);
        }
        return consumed;
    }

    /* renamed from: pullRight-0a9Yr6o, reason: not valid java name */
    private final float m154pullRight0a9Yr6o(long scroll, long displacement) {
        float displacementY = Offset.m2711getYimpl(displacement) / Size.m2776getHeightimpl(this.containerSize);
        float pullX = Offset.m2710getXimpl(scroll) / Size.m2779getWidthimpl(this.containerSize);
        float consumed = (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.rightEffect, -pullX, displacementY)) * Size.m2779getWidthimpl(this.containerSize);
        if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect) == 0.0f)) {
            return Offset.m2710getXimpl(scroll);
        }
        return consumed;
    }
}
