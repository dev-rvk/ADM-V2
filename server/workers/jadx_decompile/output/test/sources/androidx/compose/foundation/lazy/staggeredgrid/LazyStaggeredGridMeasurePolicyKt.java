package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyStaggeredGridMeasurePolicy.kt */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0089\u0001\u0010\u0000\u001a\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\u0002\b\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u001d\u0010\u0014\u001a\u0019\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00160\u0001¢\u0006\u0002\b\u0005H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001a,\u0010\u0019\u001a\u00020\u0012*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002ø\u0001\u0001¢\u0006\u0002\u0010\u001c\u001a,\u0010\u001d\u001a\u00020\u0012*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002ø\u0001\u0001¢\u0006\u0002\u0010\u001c\u001a$\u0010\u001e\u001a\u00020\u0012*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0002ø\u0001\u0001¢\u0006\u0002\u0010\u001f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"rememberStaggeredGridMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "Lkotlin/ExtensionFunctionType;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "slots", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "rememberStaggeredGridMeasurePolicy-nbWgWpA", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "afterPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/ui/unit/LayoutDirection;)F", "beforePadding", "startPadding", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/unit/LayoutDirection;)F", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyStaggeredGridMeasurePolicyKt {

    /* compiled from: LazyStaggeredGridMeasurePolicy.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.Vertical.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Orientation.Horizontal.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: rememberStaggeredGridMeasurePolicy-nbWgWpA, reason: not valid java name */
    public static final Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> m669rememberStaggeredGridMeasurePolicynbWgWpA(final LazyStaggeredGridState state, final Function0<? extends LazyStaggeredGridItemProvider> itemProviderLambda, final PaddingValues contentPadding, final boolean reverseLayout, final Orientation orientation, final float mainAxisSpacing, float crossAxisSpacing, final Function2<? super Density, ? super Constraints, LazyStaggeredGridSlots> slots, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(itemProviderLambda, "itemProviderLambda");
        Intrinsics.checkNotNullParameter(contentPadding, "contentPadding");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(slots, "slots");
        $composer.startReplaceableGroup(-2134671531);
        ComposerKt.sourceInformation($composer, "C(rememberStaggeredGridMeasurePolicy)P(7,2!1,5,4,3:c#ui.unit.Dp,1:c#ui.unit.Dp)47@2059L2713:LazyStaggeredGridMeasurePolicy.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2134671531, $changed, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberStaggeredGridMeasurePolicy (LazyStaggeredGridMeasurePolicy.kt:38)");
        }
        Object[] keys$iv = {state, itemProviderLambda, contentPadding, Boolean.valueOf(reverseLayout), orientation, Dp.m5216boximpl(mainAxisSpacing), Dp.m5216boximpl(crossAxisSpacing), slots};
        $composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv = false;
        for (Object key$iv : keys$iv) {
            invalid$iv |= $composer.changed(key$iv);
        }
        Object value$iv$iv = $composer.rememberedValue();
        if (invalid$iv || value$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasurePolicyKt$rememberStaggeredGridMeasurePolicy$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyStaggeredGridMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                    return m670invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                }

                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final LazyStaggeredGridMeasureResult m670invoke0kLqBqw(LazyLayoutMeasureScope $this$null, long constraints) {
                    float beforePadding;
                    float afterPadding;
                    float startPadding;
                    long contentOffset;
                    long m5164copyZbe2FdA;
                    Intrinsics.checkNotNullParameter($this$null, "$this$null");
                    CheckScrollableContainerConstraintsKt.m191checkScrollableContainerConstraintsK40F9xA(constraints, Orientation.this);
                    LazyStaggeredGridSlots resolvedSlots = slots.invoke($this$null, Constraints.m5162boximpl(constraints));
                    boolean isVertical = Orientation.this == Orientation.Vertical;
                    LazyStaggeredGridItemProvider itemProvider = itemProviderLambda.invoke();
                    state.setSlots$foundation_release(resolvedSlots);
                    state.setVertical$foundation_release(isVertical);
                    state.setSpanProvider$foundation_release(itemProvider.getSpanProvider());
                    beforePadding = LazyStaggeredGridMeasurePolicyKt.beforePadding(contentPadding, Orientation.this, reverseLayout, $this$null.getLayoutDirection());
                    int beforeContentPadding = $this$null.mo323roundToPx0680j_4(beforePadding);
                    afterPadding = LazyStaggeredGridMeasurePolicyKt.afterPadding(contentPadding, Orientation.this, reverseLayout, $this$null.getLayoutDirection());
                    int afterContentPadding = $this$null.mo323roundToPx0680j_4(afterPadding);
                    startPadding = LazyStaggeredGridMeasurePolicyKt.startPadding(contentPadding, Orientation.this, $this$null.getLayoutDirection());
                    int startContentPadding = $this$null.mo323roundToPx0680j_4(startPadding);
                    int maxMainAxisSize = isVertical ? Constraints.m5173getMaxHeightimpl(constraints) : Constraints.m5174getMaxWidthimpl(constraints);
                    int mainAxisAvailableSize = (maxMainAxisSize - beforeContentPadding) - afterContentPadding;
                    if (isVertical) {
                        contentOffset = IntOffsetKt.IntOffset(startContentPadding, beforeContentPadding);
                    } else {
                        contentOffset = IntOffsetKt.IntOffset(beforeContentPadding, startContentPadding);
                    }
                    PaddingValues $this$invoke_0kLqBqw_u24lambda_u240 = contentPadding;
                    float arg0$iv = PaddingKt.calculateStartPadding($this$invoke_0kLqBqw_u24lambda_u240, $this$null.getLayoutDirection());
                    float other$iv = PaddingKt.calculateEndPadding($this$invoke_0kLqBqw_u24lambda_u240, $this$null.getLayoutDirection());
                    int horizontalPadding = $this$null.mo323roundToPx0680j_4(Dp.m5218constructorimpl(arg0$iv + other$iv));
                    PaddingValues $this$invoke_0kLqBqw_u24lambda_u241 = contentPadding;
                    float arg0$iv2 = $this$invoke_0kLqBqw_u24lambda_u241.getTop();
                    float other$iv2 = $this$invoke_0kLqBqw_u24lambda_u241.getBottom();
                    int verticalPadding = $this$null.mo323roundToPx0680j_4(Dp.m5218constructorimpl(arg0$iv2 + other$iv2));
                    List pinnedItems = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(itemProvider, state.getPinnedItems(), state.getBeyondBoundsInfo());
                    int m5188constrainWidthK40F9xA = ConstraintsKt.m5188constrainWidthK40F9xA(constraints, horizontalPadding);
                    int horizontalPadding2 = ConstraintsKt.m5187constrainHeightK40F9xA(constraints, verticalPadding);
                    m5164copyZbe2FdA = Constraints.m5164copyZbe2FdA(constraints, (r12 & 1) != 0 ? Constraints.m5176getMinWidthimpl(constraints) : m5188constrainWidthK40F9xA, (r12 & 2) != 0 ? Constraints.m5174getMaxWidthimpl(constraints) : 0, (r12 & 4) != 0 ? Constraints.m5175getMinHeightimpl(constraints) : horizontalPadding2, (r12 & 8) != 0 ? Constraints.m5173getMaxHeightimpl(constraints) : 0);
                    LazyStaggeredGridMeasureResult it = LazyStaggeredGridMeasureKt.m668measureStaggeredGriddSVRQoE($this$null, state, pinnedItems, itemProvider, resolvedSlots, m5164copyZbe2FdA, isVertical, reverseLayout, contentOffset, mainAxisAvailableSize, $this$null.mo323roundToPx0680j_4(mainAxisSpacing), beforeContentPadding, afterContentPadding);
                    state.applyMeasureResult$foundation_release(it);
                    return it;
                }
            };
            $composer.updateRememberedValue(value$iv$iv);
        }
        $composer.endReplaceableGroup();
        Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> function2 = (Function2) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float startPadding(PaddingValues $this$startPadding, Orientation orientation, LayoutDirection layoutDirection) {
        switch (WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()]) {
            case 1:
                return PaddingKt.calculateStartPadding($this$startPadding, layoutDirection);
            case 2:
                return $this$startPadding.getTop();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float beforePadding(PaddingValues $this$beforePadding, Orientation orientation, boolean reverseLayout, LayoutDirection layoutDirection) {
        switch (WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()]) {
            case 1:
                return reverseLayout ? $this$beforePadding.getBottom() : $this$beforePadding.getTop();
            case 2:
                if (reverseLayout) {
                    return PaddingKt.calculateEndPadding($this$beforePadding, layoutDirection);
                }
                return PaddingKt.calculateStartPadding($this$beforePadding, layoutDirection);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float afterPadding(PaddingValues $this$afterPadding, Orientation orientation, boolean reverseLayout, LayoutDirection layoutDirection) {
        switch (WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()]) {
            case 1:
                return reverseLayout ? $this$afterPadding.getTop() : $this$afterPadding.getBottom();
            case 2:
                if (reverseLayout) {
                    return PaddingKt.calculateStartPadding($this$afterPadding, layoutDirection);
                }
                return PaddingKt.calculateEndPadding($this$afterPadding, layoutDirection);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
