package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyGrid.kt */
@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0098\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001d\u0010\u0006\u001a\u0019\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\u0019¢\u0006\u0002\b\u000bH\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001b\u001a#\u0010\u001c\u001a\u00020\u00012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010 \u001a\u008c\u0001\u0010!\u001a\u0019\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020#0\u0007¢\u0006\u0002\b\u000b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\u0004\u001a\u00020\u00052\u001d\u0010\u0006\u001a\u0019\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\b\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0003ø\u0001\u0000¢\u0006\u0002\u0010$\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"LazyGrid", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "slots", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/foundation/lazy/grid/LazyGridSlots;", "Lkotlin/ExtensionFunctionType;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "ScrollPositionUpdater", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/runtime/Composer;I)V", "rememberLazyGridMeasurePolicy", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/layout/MeasureResult;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/grid/LazyGridState;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyGridKt {
    /* JADX WARN: Removed duplicated region for block: B:105:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0131  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LazyGrid(androidx.compose.ui.Modifier r36, final androidx.compose.foundation.lazy.grid.LazyGridState r37, final kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Density, ? super androidx.compose.ui.unit.Constraints, androidx.compose.foundation.lazy.grid.LazyGridSlots> r38, androidx.compose.foundation.layout.PaddingValues r39, boolean r40, final boolean r41, androidx.compose.foundation.gestures.FlingBehavior r42, final boolean r43, final androidx.compose.foundation.layout.Arrangement.Vertical r44, final androidx.compose.foundation.layout.Arrangement.Horizontal r45, final kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.grid.LazyGridScope, kotlin.Unit> r46, androidx.compose.runtime.Composer r47, final int r48, final int r49, final int r50) {
        /*
            Method dump skipped, instructions count: 886
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.grid.LazyGridState, kotlin.jvm.functions.Function2, androidx.compose.foundation.layout.PaddingValues, boolean, boolean, androidx.compose.foundation.gestures.FlingBehavior, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ScrollPositionUpdater(final Function0<? extends LazyGridItemProvider> function0, final LazyGridState state, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-649335720);
        ComposerKt.sourceInformation($composer2, "C(ScrollPositionUpdater):LazyGrid.kt#7791vq");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(state) ? 32 : 16;
        }
        if (($dirty & 91) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-649335720, $changed, -1, "androidx.compose.foundation.lazy.grid.ScrollPositionUpdater (LazyGrid.kt:138)");
            }
            LazyGridItemProvider itemProvider = function0.invoke();
            if (itemProvider.getItemCount() > 0) {
                LazyGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release$default(state, itemProvider, 0, 2, null);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$ScrollPositionUpdater$1
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
                LazyGridKt.ScrollPositionUpdater(function0, state, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    private static final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyGridMeasurePolicy(final Function0<? extends LazyGridItemProvider> function0, final LazyGridState state, final Function2<? super Density, ? super Constraints, LazyGridSlots> function2, final PaddingValues contentPadding, final boolean reverseLayout, final boolean isVertical, Arrangement.Horizontal horizontalArrangement, Arrangement.Vertical verticalArrangement, Composer $composer, int $changed, int i) {
        Arrangement.Vertical verticalArrangement2;
        $composer.startReplaceableGroup(1292704639);
        ComposerKt.sourceInformation($composer, "C(rememberLazyGridMeasurePolicy)P(3,6,5!1,4,2)173@6918L8458:LazyGrid.kt#7791vq");
        Arrangement.Horizontal horizontalArrangement2 = (i & 64) != 0 ? null : horizontalArrangement;
        if ((i & 128) == 0) {
            verticalArrangement2 = verticalArrangement;
        } else {
            verticalArrangement2 = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1292704639, $changed, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridMeasurePolicy (LazyGrid.kt:156)");
        }
        Object[] keys$iv = {state, function2, contentPadding, Boolean.valueOf(reverseLayout), Boolean.valueOf(isVertical), horizontalArrangement2, verticalArrangement2};
        $composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv = false;
        for (Object key$iv : keys$iv) {
            invalid$iv |= $composer.changed(key$iv);
        }
        Object value$iv$iv = $composer.rememberedValue();
        if (invalid$iv || value$iv$iv == Composer.INSTANCE.getEmpty()) {
            final Arrangement.Vertical vertical = verticalArrangement2;
            final Arrangement.Horizontal horizontal = horizontalArrangement2;
            value$iv$iv = new Function2<LazyLayoutMeasureScope, Constraints, LazyGridMeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyGridMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                    return m618invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                }

                /* JADX WARN: Type inference failed for: r0v48, types: [androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1] */
                /* JADX WARN: Type inference failed for: r0v49, types: [androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1] */
                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final LazyGridMeasureResult m618invoke0kLqBqw(final LazyLayoutMeasureScope $this$null, final long containerConstraints) {
                    int i2;
                    int i3;
                    int i4;
                    float spacing;
                    int m5174getMaxWidthimpl;
                    final long visualItemOffset;
                    Snapshot previous$iv$iv;
                    Snapshot this_$iv$iv;
                    Snapshot previous$iv$iv2;
                    int firstVisibleLineIndex;
                    int firstVisibleLineScrollOffset;
                    Intrinsics.checkNotNullParameter($this$null, "$this$null");
                    CheckScrollableContainerConstraintsKt.m191checkScrollableContainerConstraintsK40F9xA(containerConstraints, isVertical ? Orientation.Vertical : Orientation.Horizontal);
                    if (isVertical) {
                        i2 = $this$null.mo323roundToPx0680j_4(contentPadding.mo435calculateLeftPaddingu2uoSUM($this$null.getLayoutDirection()));
                    } else {
                        i2 = $this$null.mo323roundToPx0680j_4(PaddingKt.calculateStartPadding(contentPadding, $this$null.getLayoutDirection()));
                    }
                    int startPadding = i2;
                    if (isVertical) {
                        i3 = $this$null.mo323roundToPx0680j_4(contentPadding.mo436calculateRightPaddingu2uoSUM($this$null.getLayoutDirection()));
                    } else {
                        i3 = $this$null.mo323roundToPx0680j_4(PaddingKt.calculateEndPadding(contentPadding, $this$null.getLayoutDirection()));
                    }
                    int endPadding = i3;
                    int topPadding = $this$null.mo323roundToPx0680j_4(contentPadding.getTop());
                    int bottomPadding = $this$null.mo323roundToPx0680j_4(contentPadding.getBottom());
                    final int totalVerticalPadding = topPadding + bottomPadding;
                    final int totalHorizontalPadding = startPadding + endPadding;
                    int totalMainAxisPadding = isVertical ? totalVerticalPadding : totalHorizontalPadding;
                    if (isVertical && !reverseLayout) {
                        i4 = topPadding;
                    } else if (isVertical && reverseLayout) {
                        i4 = bottomPadding;
                    } else {
                        i4 = (isVertical || reverseLayout) ? endPadding : startPadding;
                    }
                    final int beforeContentPadding = i4;
                    final int afterContentPadding = totalMainAxisPadding - beforeContentPadding;
                    long contentConstraints = ConstraintsKt.m5190offsetNN6EwU(containerConstraints, -totalHorizontalPadding, -totalVerticalPadding);
                    final LazyGridItemProvider itemProvider = function0.invoke();
                    final LazyGridSpanLayoutProvider spanLayoutProvider = itemProvider.getSpanLayoutProvider();
                    final LazyGridSlots resolvedSlots = function2.invoke($this$null, Constraints.m5162boximpl(containerConstraints));
                    int slotsPerLine = resolvedSlots.getSizes().length;
                    spanLayoutProvider.setSlotsPerLine(slotsPerLine);
                    state.setDensity$foundation_release($this$null);
                    state.setSlotsPerLine$foundation_release(slotsPerLine);
                    if (isVertical) {
                        Arrangement.Vertical vertical2 = vertical;
                        if (vertical2 == null) {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        spacing = vertical2.getSpacing();
                    } else {
                        Arrangement.Horizontal horizontal2 = horizontal;
                        if (horizontal2 == null) {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        spacing = horizontal2.getSpacing();
                    }
                    float spaceBetweenLinesDp = spacing;
                    final int spaceBetweenLines = $this$null.mo323roundToPx0680j_4(spaceBetweenLinesDp);
                    final int itemsCount = itemProvider.getItemCount();
                    if (isVertical) {
                        m5174getMaxWidthimpl = Constraints.m5173getMaxHeightimpl(containerConstraints) - totalVerticalPadding;
                    } else {
                        m5174getMaxWidthimpl = Constraints.m5174getMaxWidthimpl(containerConstraints) - totalHorizontalPadding;
                    }
                    int mainAxisAvailableSize = m5174getMaxWidthimpl;
                    if (!reverseLayout || mainAxisAvailableSize > 0) {
                        visualItemOffset = IntOffsetKt.IntOffset(startPadding, topPadding);
                    } else {
                        visualItemOffset = IntOffsetKt.IntOffset(isVertical ? startPadding : startPadding + mainAxisAvailableSize, isVertical ? topPadding + mainAxisAvailableSize : topPadding);
                    }
                    final boolean z = isVertical;
                    final boolean z2 = reverseLayout;
                    final ?? r0 = new LazyGridMeasuredItemProvider(itemProvider, $this$null, spaceBetweenLines, z, z2, beforeContentPadding, afterContentPadding, visualItemOffset) { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1
                        final /* synthetic */ int $afterContentPadding;
                        final /* synthetic */ int $beforeContentPadding;
                        final /* synthetic */ boolean $isVertical;
                        final /* synthetic */ boolean $reverseLayout;
                        final /* synthetic */ LazyLayoutMeasureScope $this_null;
                        final /* synthetic */ long $visualItemOffset;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.$this_null = $this$null;
                            this.$isVertical = z;
                            this.$reverseLayout = z2;
                            this.$beforeContentPadding = beforeContentPadding;
                            this.$afterContentPadding = afterContentPadding;
                            this.$visualItemOffset = visualItemOffset;
                        }

                        @Override // androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider
                        public LazyGridMeasuredItem createItem(int index, Object key, Object contentType, int crossAxisSize, int mainAxisSpacing, List<? extends Placeable> placeables) {
                            Intrinsics.checkNotNullParameter(key, "key");
                            Intrinsics.checkNotNullParameter(placeables, "placeables");
                            return new LazyGridMeasuredItem(index, key, this.$isVertical, crossAxisSize, mainAxisSpacing, this.$reverseLayout, this.$this_null.getLayoutDirection(), this.$beforeContentPadding, this.$afterContentPadding, placeables, this.$visualItemOffset, contentType, null);
                        }
                    };
                    final boolean z3 = isVertical;
                    final ?? r02 = new LazyGridMeasuredLineProvider(z3, resolvedSlots, itemsCount, spaceBetweenLines, r0, spanLayoutProvider) { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1
                        final /* synthetic */ boolean $isVertical;
                        final /* synthetic */ LazyGridSlots $resolvedSlots;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(z3, resolvedSlots, itemsCount, spaceBetweenLines, r0, spanLayoutProvider);
                            this.$isVertical = z3;
                            this.$resolvedSlots = resolvedSlots;
                        }

                        @Override // androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider
                        public LazyGridMeasuredLine createLine(int index, LazyGridMeasuredItem[] items, List<GridItemSpan> spans, int mainAxisSpacing) {
                            Intrinsics.checkNotNullParameter(items, "items");
                            Intrinsics.checkNotNullParameter(spans, "spans");
                            return new LazyGridMeasuredLine(index, items, this.$resolvedSlots, spans, this.$isVertical, mainAxisSpacing);
                        }
                    };
                    state.setPrefetchInfoRetriever$foundation_release(new Function1<Integer, ArrayList<Pair<? extends Integer, ? extends Constraints>>>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ ArrayList<Pair<? extends Integer, ? extends Constraints>> invoke(Integer num) {
                            return invoke(num.intValue());
                        }

                        public final ArrayList<Pair<Integer, Constraints>> invoke(int line) {
                            LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = LazyGridSpanLayoutProvider.this.getLineConfiguration(line);
                            int index = lineConfiguration.getFirstItemIndex();
                            int slot = 0;
                            ArrayList result = new ArrayList(lineConfiguration.getSpans().size());
                            List $this$fastForEach$iv = lineConfiguration.getSpans();
                            LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 = r02;
                            int index$iv = 0;
                            int size = $this$fastForEach$iv.size();
                            while (index$iv < size) {
                                Object item$iv = $this$fastForEach$iv.get(index$iv);
                                long it = ((GridItemSpan) item$iv).getPackedValue();
                                int span = GridItemSpan.m603getCurrentLineSpanimpl(it);
                                result.add(TuplesKt.to(Integer.valueOf(index), Constraints.m5162boximpl(lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1.m624childConstraintsJhjzzOo$foundation_release(slot, span))));
                                index++;
                                slot += span;
                                index$iv++;
                                lineConfiguration = lineConfiguration;
                            }
                            return result;
                        }
                    });
                    Snapshot.Companion this_$iv = Snapshot.INSTANCE;
                    LazyGridState lazyGridState = state;
                    Snapshot snapshot$iv = this_$iv.createNonObservableSnapshot();
                    try {
                        previous$iv$iv = snapshot$iv.makeCurrent();
                        int firstVisibleLineIndex2 = 0;
                        try {
                            int index = lazyGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(itemProvider, lazyGridState.getFirstVisibleItemIndex());
                            if (index < itemsCount || itemsCount <= 0) {
                                try {
                                    firstVisibleLineIndex = spanLayoutProvider.getLineIndexOfItem(index);
                                } catch (Throwable th) {
                                    th = th;
                                    this_$iv$iv = snapshot$iv;
                                    previous$iv$iv2 = previous$iv$iv;
                                }
                                try {
                                    firstVisibleLineScrollOffset = lazyGridState.getFirstVisibleItemScrollOffset();
                                } catch (Throwable th2) {
                                    th = th2;
                                    this_$iv$iv = snapshot$iv;
                                    previous$iv$iv2 = previous$iv$iv;
                                    firstVisibleLineIndex2 = firstVisibleLineIndex;
                                    try {
                                        this_$iv$iv.restoreCurrent(previous$iv$iv2);
                                        throw th;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        snapshot$iv.dispose();
                                        throw th;
                                    }
                                }
                            } else {
                                try {
                                    firstVisibleLineIndex = spanLayoutProvider.getLineIndexOfItem(itemsCount - 1);
                                    firstVisibleLineScrollOffset = 0;
                                } catch (Throwable th4) {
                                    th = th4;
                                    this_$iv$iv = snapshot$iv;
                                    previous$iv$iv2 = previous$iv$iv;
                                    this_$iv$iv.restoreCurrent(previous$iv$iv2);
                                    throw th;
                                }
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            this_$iv$iv = snapshot$iv;
                            previous$iv$iv2 = previous$iv$iv;
                        }
                        try {
                            Unit unit = Unit.INSTANCE;
                        } catch (Throwable th6) {
                            th = th6;
                            this_$iv$iv = snapshot$iv;
                            previous$iv$iv2 = previous$iv$iv;
                            firstVisibleLineIndex2 = firstVisibleLineIndex;
                            this_$iv$iv.restoreCurrent(previous$iv$iv2);
                            throw th;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                    }
                    try {
                        snapshot$iv.restoreCurrent(previous$iv$iv);
                        snapshot$iv.dispose();
                        List pinnedItems = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(itemProvider, state.getPinnedItems(), state.getBeyondBoundsInfo());
                        LazyGridMeasureResult it = LazyGridMeasureKt.m619measureLazyGridZRKPzZ8(itemsCount, (LazyGridMeasuredLineProvider) r02, (LazyGridMeasuredItemProvider) r0, mainAxisAvailableSize, beforeContentPadding, afterContentPadding, spaceBetweenLines, firstVisibleLineIndex, firstVisibleLineScrollOffset, state.getScrollToBeConsumed(), contentConstraints, isVertical, vertical, horizontal, reverseLayout, $this$null, state.getPlacementAnimator(), spanLayoutProvider, pinnedItems, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                            }

                            public final MeasureResult invoke(int width, int height, Function1<? super Placeable.PlacementScope, Unit> placement) {
                                Intrinsics.checkNotNullParameter(placement, "placement");
                                return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m5188constrainWidthK40F9xA(containerConstraints, totalHorizontalPadding + width), ConstraintsKt.m5187constrainHeightK40F9xA(containerConstraints, totalVerticalPadding + height), MapsKt.emptyMap(), placement);
                            }
                        });
                        state.applyMeasureResult$foundation_release(it);
                        return it;
                    } catch (Throwable th8) {
                        th = th8;
                        snapshot$iv.dispose();
                        throw th;
                    }
                }
            };
            $composer.updateRememberedValue(value$iv$iv);
        }
        $composer.endReplaceableGroup();
        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function22 = (Function2) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return function22;
    }
}
