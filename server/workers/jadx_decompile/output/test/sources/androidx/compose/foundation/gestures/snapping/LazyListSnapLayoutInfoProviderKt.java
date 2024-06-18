package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.SplineBasedDecayKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListLayoutInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: LazyListSnapLayoutInfoProvider.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\u001a\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\r\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u000e"}, d2 = {"singleAxisViewportSize", "", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "getSingleAxisViewportSize", "(Landroidx/compose/foundation/lazy/LazyListLayoutInfo;)I", "SnapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "positionInLayout", "Landroidx/compose/foundation/gestures/snapping/SnapPositionInLayout;", "rememberSnapFlingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/FlingBehavior;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyListSnapLayoutInfoProviderKt {
    public static /* synthetic */ SnapLayoutInfoProvider SnapLayoutInfoProvider$default(LazyListState lazyListState, SnapPositionInLayout snapPositionInLayout, int i, Object obj) {
        if ((i & 2) != 0) {
            snapPositionInLayout = SnapPositionInLayout.INSTANCE.getCenterToCenter();
        }
        return SnapLayoutInfoProvider(lazyListState, snapPositionInLayout);
    }

    public static final SnapLayoutInfoProvider SnapLayoutInfoProvider(final LazyListState lazyListState, final SnapPositionInLayout positionInLayout) {
        Intrinsics.checkNotNullParameter(lazyListState, "lazyListState");
        Intrinsics.checkNotNullParameter(positionInLayout, "positionInLayout");
        return new SnapLayoutInfoProvider() { // from class: androidx.compose.foundation.gestures.snapping.LazyListSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$1
            private final LazyListLayoutInfo getLayoutInfo() {
                return LazyListState.this.getLayoutInfo();
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateApproachOffset(Density $this$calculateApproachOffset, float initialVelocity) {
                Intrinsics.checkNotNullParameter($this$calculateApproachOffset, "<this>");
                DecayAnimationSpec decayAnimationSpec = SplineBasedDecayKt.splineBasedDecay($this$calculateApproachOffset);
                float offset = Math.abs(DecayAnimationSpecKt.calculateTargetValue(decayAnimationSpec, 0.0f, initialVelocity));
                float finalDecayOffset = RangesKt.coerceAtLeast(offset - calculateSnapStepSize($this$calculateApproachOffset), 0.0f);
                if (finalDecayOffset == 0.0f) {
                    return finalDecayOffset;
                }
                return Math.signum(initialVelocity) * finalDecayOffset;
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateSnappingOffset(Density $this$calculateSnappingOffset, float currentVelocity) {
                Intrinsics.checkNotNullParameter($this$calculateSnappingOffset, "<this>");
                float lowerBoundOffset = Float.NEGATIVE_INFINITY;
                List $this$fastForEach$iv = getLayoutInfo().getVisibleItemsInfo();
                SnapPositionInLayout snapPositionInLayout = positionInLayout;
                int size = $this$fastForEach$iv.size();
                float upperBoundOffset = Float.POSITIVE_INFINITY;
                int index$iv = 0;
                while (index$iv < size) {
                    Object item$iv = $this$fastForEach$iv.get(index$iv);
                    LazyListItemInfo item = (LazyListItemInfo) item$iv;
                    int index$iv2 = index$iv;
                    float offset = SnapPositionInLayoutKt.calculateDistanceToDesiredSnapPosition($this$calculateSnappingOffset, LazyListSnapLayoutInfoProviderKt.getSingleAxisViewportSize(getLayoutInfo()), getLayoutInfo().getBeforeContentPadding(), getLayoutInfo().getAfterContentPadding(), item.getSize(), item.getOffset(), item.getIndex(), snapPositionInLayout);
                    if (offset <= 0.0f && offset > lowerBoundOffset) {
                        lowerBoundOffset = offset;
                    }
                    if (offset >= 0.0f && offset < upperBoundOffset) {
                        upperBoundOffset = offset;
                    }
                    index$iv = index$iv2 + 1;
                }
                return SnapFlingBehaviorKt.calculateFinalOffset(currentVelocity, lowerBoundOffset, upperBoundOffset);
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateSnapStepSize(Density $this$calculateSnapStepSize) {
                Intrinsics.checkNotNullParameter($this$calculateSnapStepSize, "<this>");
                LazyListLayoutInfo $this$calculateSnapStepSize_u24lambda_u242 = getLayoutInfo();
                if (!$this$calculateSnapStepSize_u24lambda_u242.getVisibleItemsInfo().isEmpty()) {
                    List $this$fastSumBy$iv = $this$calculateSnapStepSize_u24lambda_u242.getVisibleItemsInfo();
                    int sum$iv = 0;
                    int size = $this$fastSumBy$iv.size();
                    for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                        Object item$iv$iv = $this$fastSumBy$iv.get(index$iv$iv);
                        LazyListItemInfo it = (LazyListItemInfo) item$iv$iv;
                        sum$iv += it.getSize();
                    }
                    return sum$iv / $this$calculateSnapStepSize_u24lambda_u242.getVisibleItemsInfo().size();
                }
                return 0.0f;
            }
        };
    }

    public static final FlingBehavior rememberSnapFlingBehavior(LazyListState lazyListState, Composer $composer, int $changed) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(lazyListState, "lazyListState");
        $composer.startReplaceableGroup(1148456277);
        ComposerKt.sourceInformation($composer, "C(rememberSnapFlingBehavior)115@4630L65,116@4707L41:LazyListSnapLayoutInfoProvider.kt#ppz6w6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1148456277, $changed, -1, "androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior (LazyListSnapLayoutInfoProvider.kt:114)");
        }
        int i = $changed & 14;
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(lazyListState);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = SnapLayoutInfoProvider$default(lazyListState, null, 2, null);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        SnapLayoutInfoProvider snappingLayout = (SnapLayoutInfoProvider) value$iv$iv;
        SnapFlingBehavior rememberSnapFlingBehavior = SnapFlingBehaviorKt.rememberSnapFlingBehavior(snappingLayout, $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberSnapFlingBehavior;
    }

    public static final int getSingleAxisViewportSize(LazyListLayoutInfo $this$singleAxisViewportSize) {
        Intrinsics.checkNotNullParameter($this$singleAxisViewportSize, "<this>");
        return $this$singleAxisViewportSize.getOrientation() == Orientation.Vertical ? IntSize.m5377getHeightimpl($this$singleAxisViewportSize.mo587getViewportSizeYbymL2g()) : IntSize.m5378getWidthimpl($this$singleAxisViewportSize.mo587getViewportSizeYbymL2g());
    }
}
