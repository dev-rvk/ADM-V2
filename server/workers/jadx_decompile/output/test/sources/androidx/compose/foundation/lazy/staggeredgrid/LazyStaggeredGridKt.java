package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.ClipScrollableContainerKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyStaggeredGrid.kt */
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a£\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001d\u0010\u0006\u001a\u0019\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\u0019¢\u0006\u0002\b\u000bH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a#\u0010\u001d\u001a\u00020\u00012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010!\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\""}, d2 = {"LazyStaggeredGrid", "", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "slots", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "LazyStaggeredGrid-LJWHXA8", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/FlingBehavior;ZFFLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "ScrollPositionUpdater", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/runtime/Composer;I)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyStaggeredGridKt {
    /* renamed from: LazyStaggeredGrid-LJWHXA8, reason: not valid java name */
    public static final void m660LazyStaggeredGridLJWHXA8(final LazyStaggeredGridState state, final Orientation orientation, final Function2<? super Density, ? super Constraints, LazyStaggeredGridSlots> slots, Modifier modifier, PaddingValues contentPadding, boolean reverseLayout, FlingBehavior flingBehavior, boolean userScrollEnabled, float mainAxisSpacing, float crossAxisSpacing, final Function1<? super LazyStaggeredGridScope, Unit> content, Composer $composer, final int $changed, final int $changed1, final int i) {
        FlingBehavior flingBehavior2;
        int $dirty;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(slots, "slots");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(1320541636);
        ComposerKt.sourceInformation($composer2, "C(LazyStaggeredGrid)P(9,6,8,5,1,7,3,10,4:c#ui.unit.Dp,2:c#ui.unit.Dp)53@2453L15,63@2869L18,65@2918L55,66@2998L218,76@3241L60,78@3307L48,84@3506L277,92@3847L172,101@4243L7,80@3361L1366:LazyStaggeredGrid.kt#fzvcnm");
        Modifier modifier2 = (i & 8) != 0 ? Modifier.INSTANCE : modifier;
        PaddingValues contentPadding2 = (i & 16) != 0 ? PaddingKt.m477PaddingValues0680j_4(Dp.m5218constructorimpl(0)) : contentPadding;
        boolean reverseLayout2 = (i & 32) != 0 ? false : reverseLayout;
        if ((i & 64) != 0) {
            FlingBehavior flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior($composer2, 6);
            int $dirty2 = $changed & (-3670017);
            $dirty = $dirty2;
            flingBehavior2 = flingBehavior3;
        } else {
            flingBehavior2 = flingBehavior;
            $dirty = $changed;
        }
        int $dirty3 = i & 128;
        boolean userScrollEnabled2 = $dirty3 != 0 ? true : userScrollEnabled;
        float mainAxisSpacing2 = (i & 256) != 0 ? Dp.m5218constructorimpl(0) : mainAxisSpacing;
        float crossAxisSpacing2 = (i & 512) != 0 ? Dp.m5218constructorimpl(0) : crossAxisSpacing;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1320541636, $dirty, $changed1, "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGrid (LazyStaggeredGrid.kt:39)");
        }
        OverscrollEffect overscrollEffect = ScrollableDefaults.INSTANCE.overscrollEffect($composer2, 6);
        Function0 itemProviderLambda = LazyStaggeredGridItemProviderKt.rememberStaggeredGridItemProviderLambda(state, content, $composer2, (($changed1 << 3) & 112) | 8);
        int $dirty4 = $dirty;
        final boolean reverseLayout3 = reverseLayout2;
        final Modifier modifier3 = modifier2;
        Function2 measurePolicy = LazyStaggeredGridMeasurePolicyKt.m669rememberStaggeredGridMeasurePolicynbWgWpA(state, itemProviderLambda, contentPadding2, reverseLayout2, orientation, mainAxisSpacing2, crossAxisSpacing2, slots, $composer2, (($dirty >> 6) & 896) | 8 | (($dirty >> 6) & 7168) | (($dirty << 9) & 57344) | (($dirty >> 9) & 458752) | (($dirty >> 9) & 3670016) | (($dirty << 15) & 29360128));
        LazyLayoutSemanticState semanticState = LazyStaggeredGridSemanticsKt.rememberLazyStaggeredGridSemanticState(state, reverseLayout3, $composer2, (($dirty4 >> 12) & 112) | 8);
        ScrollPositionUpdater(itemProviderLambda, state, $composer2, 64);
        Modifier overscroll = OverscrollKt.overscroll(LazyStaggeredGridBeyondBoundsModifierKt.lazyStaggeredGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier3.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), itemProviderLambda, semanticState, orientation, userScrollEnabled2, reverseLayout3, $composer2, (($dirty4 << 6) & 7168) | (($dirty4 >> 9) & 57344) | ($dirty4 & 458752)), orientation), state, reverseLayout3, orientation, $composer2, (($dirty4 >> 9) & 896) | 64 | (($dirty4 << 6) & 7168)), overscrollEffect);
        ScrollableDefaults scrollableDefaults = ScrollableDefaults.INSTANCE;
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer2.consume(localLayoutDirection);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        LazyLayoutKt.LazyLayout((Function0<? extends LazyLayoutItemProvider>) itemProviderLambda, ScrollableKt.scrollable(overscroll, state, orientation, overscrollEffect, userScrollEnabled2, scrollableDefaults.reverseDirection((LayoutDirection) consume, orientation, reverseLayout3), flingBehavior2, state.getMutableInteractionSource()), state.getPrefetchState(), (Function2<? super LazyLayoutMeasureScope, ? super Constraints, ? extends MeasureResult>) measurePolicy, $composer2, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final PaddingValues paddingValues = contentPadding2;
        final FlingBehavior flingBehavior4 = flingBehavior2;
        final boolean z = userScrollEnabled2;
        final float f = mainAxisSpacing2;
        final float f2 = crossAxisSpacing2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt$LazyStaggeredGrid$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i2) {
                LazyStaggeredGridKt.m660LazyStaggeredGridLJWHXA8(LazyStaggeredGridState.this, orientation, slots, modifier3, paddingValues, reverseLayout3, flingBehavior4, z, f, f2, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ScrollPositionUpdater(final Function0<? extends LazyLayoutItemProvider> function0, final LazyStaggeredGridState state, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(661612410);
        ComposerKt.sourceInformation($composer2, "C(ScrollPositionUpdater):LazyStaggeredGrid.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(661612410, $changed, -1, "androidx.compose.foundation.lazy.staggeredgrid.ScrollPositionUpdater (LazyStaggeredGrid.kt:120)");
        }
        LazyLayoutItemProvider itemProvider = function0.invoke();
        if (itemProvider.getItemCount() > 0) {
            LazyStaggeredGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release$default(state, itemProvider, null, 2, null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt$ScrollPositionUpdater$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                LazyStaggeredGridKt.ScrollPositionUpdater(function0, state, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }
}
