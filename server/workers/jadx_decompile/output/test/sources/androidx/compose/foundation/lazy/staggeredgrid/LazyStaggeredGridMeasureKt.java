package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: LazyStaggeredGridMeasure.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0017\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0082\b\u001a5\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\n0\u000e¢\u0006\u0002\b\u000fH\u0083\b¢\u0006\u0002\u0010\u0010\u001aJ\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012*\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u000e2!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u000eH\u0083\b\u001a;\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012*\u00020\u00142\u0012\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010!\u001a\u001d\u0010\"\u001a\u00020\b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u001d0\u001cH\u0002¢\u0006\u0002\u0010#\u001a\u001c\u0010$\u001a\u00020\u0005*\u00020\u00142\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u0003H\u0002\u001a\u001c\u0010'\u001a\u00020\u0003*\u00020\u00142\u0006\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0003H\u0002\u001a.\u0010*\u001a\u00020\u0005*\u00020+2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000eH\u0082\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-\u001a\f\u0010.\u001a\u00020\u0003*\u00020\u001fH\u0002\u001a2\u0010/\u001a\u00020\u0003\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u001c2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00030\u000eH\u0082\b¢\u0006\u0002\u00100\u001a\u0016\u00101\u001a\u00020\u0003*\u00020\u001f2\b\b\u0002\u00102\u001a\u00020\u0003H\u0000\u001a!\u00103\u001a\u00020\u0003*\u00020\u001f2\u0006\u00104\u001a\u00020+H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u00106\u001a,\u00107\u001a\u000208*\u00020\u00142\u0006\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020\u0001H\u0003\u001a\u007f\u0010=\u001a\u000208*\u00020\f2\u0006\u0010>\u001a\u00020?2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00012\u0006\u0010H\u001a\u00020\u00012\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u00032\u0006\u0010L\u001a\u00020\u00032\u0006\u0010M\u001a\u00020\u00032\u0006\u0010N\u001a\u00020\u0003H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bO\u0010P\u001a\u0014\u0010Q\u001a\u00020\u0005*\u00020\u001f2\u0006\u0010R\u001a\u00020\u0003H\u0002\u001a!\u0010S\u001a\u00020\u001f*\u00020\u001f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000eH\u0082\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006T"}, d2 = {"DebugLoggingEnabled", "", "Unset", "", "debugLog", "", "message", "Lkotlin/Function0;", "", "withDebugLogging", "T", "scope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "calculateExtraItems", "", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "position", "filter", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "itemIndex", "calculateVisibleItems", "measuredItems", "", "Lkotlin/collections/ArrayDeque;", "itemScrollOffsets", "", "mainAxisLayoutSize", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;[Lkotlin/collections/ArrayDeque;[II)Ljava/util/List;", "debugRender", "([Lkotlin/collections/ArrayDeque;)Ljava/lang/String;", "ensureIndicesInRange", "indices", "itemCount", "findPreviousItemIndex", "item", "lane", "forEach", "Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "forEach-nIS5qE8", "(JLkotlin/jvm/functions/Function1;)V", "indexOfMaxValue", "indexOfMinBy", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "indexOfMinValue", "minBound", "maxInRange", "indexRange", "maxInRange-jy6DScQ", "([IJ)I", "measure", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "initialScrollDelta", "initialItemIndices", "initialItemOffsets", "canRestartMeasure", "measureStaggeredGrid", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "pinnedItems", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "resolvedSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "reverseLayout", "contentOffset", "Landroidx/compose/ui/unit/IntOffset;", "mainAxisAvailableSize", "mainAxisSpacing", "beforeContentPadding", "afterContentPadding", "measureStaggeredGrid-dSVRQoE", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Ljava/util/List;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;JZZJIIII)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "offsetBy", "delta", "transform", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyStaggeredGridMeasureKt {
    private static final boolean DebugLoggingEnabled = false;
    private static final int Unset = Integer.MIN_VALUE;

    private static final <T> T withDebugLogging(LazyLayoutMeasureScope scope, Function1<? super LazyLayoutMeasureScope, ? extends T> function1) {
        return function1.invoke(scope);
    }

    private static final String debugRender(ArrayDeque<LazyStaggeredGridMeasuredItem>[] arrayDequeArr) {
        return "";
    }

    private static final void debugLog(Function0<String> function0) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [int[]] */
    /* JADX WARN: Type inference failed for: r0v23, types: [T] */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r11v4, types: [int[]] */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v9, types: [T] */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* renamed from: measureStaggeredGrid-dSVRQoE, reason: not valid java name */
    public static final LazyStaggeredGridMeasureResult m668measureStaggeredGriddSVRQoE(LazyLayoutMeasureScope measureStaggeredGrid, LazyStaggeredGridState state, List<Integer> pinnedItems, LazyStaggeredGridItemProvider itemProvider, LazyStaggeredGridSlots resolvedSlots, long j, boolean z, boolean z2, long j2, int i, int i2, int i3, int i4) {
        Snapshot.Companion companion;
        int i5;
        int i6;
        int[] iArr;
        ?? r13;
        ?? r0;
        ?? r15;
        Intrinsics.checkNotNullParameter(measureStaggeredGrid, "$this$measureStaggeredGrid");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(pinnedItems, "pinnedItems");
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(resolvedSlots, "resolvedSlots");
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext = new LazyStaggeredGridMeasureContext(state, pinnedItems, itemProvider, resolvedSlots, j, z, measureStaggeredGrid, i, j2, i3, i4, z2, i2, null);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Snapshot.Companion companion2 = Snapshot.INSTANCE;
        int i7 = 0;
        Snapshot createNonObservableSnapshot = companion2.createNonObservableSnapshot();
        try {
            Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
            try {
                try {
                    int[] updateScrollPositionIfTheFirstItemWasMoved$foundation_release = state.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(itemProvider, state.getScrollPosition().getIndices());
                    ?? offsets = state.getScrollPosition().getOffsets();
                    if (updateScrollPositionIfTheFirstItemWasMoved$foundation_release.length == lazyStaggeredGridMeasureContext.getLaneCount()) {
                        r13 = updateScrollPositionIfTheFirstItemWasMoved$foundation_release;
                        companion = null;
                    } else {
                        lazyStaggeredGridMeasureContext.getLaneInfo().reset();
                        int[] iArr2 = new int[lazyStaggeredGridMeasureContext.getLaneCount()];
                        int length = iArr2.length;
                        int i8 = 0;
                        int[] iArr3 = iArr2;
                        while (i8 < length) {
                            Snapshot.Companion companion3 = companion2;
                            try {
                                if (i8 < updateScrollPositionIfTheFirstItemWasMoved$foundation_release.length) {
                                    i5 = i7;
                                    if (updateScrollPositionIfTheFirstItemWasMoved$foundation_release[i8] != -1) {
                                        try {
                                            i6 = updateScrollPositionIfTheFirstItemWasMoved$foundation_release[i8];
                                            iArr = iArr3;
                                            iArr2[i8] = i6;
                                            lazyStaggeredGridMeasureContext.getLaneInfo().setLane(iArr2[i8], i8);
                                            i8++;
                                            iArr3 = iArr;
                                            companion2 = companion3;
                                            i7 = i5;
                                        } catch (Throwable th) {
                                            th = th;
                                            createNonObservableSnapshot.restoreCurrent(makeCurrent);
                                            throw th;
                                        }
                                    }
                                } else {
                                    i5 = i7;
                                }
                                if (i8 == 0) {
                                    iArr = iArr3;
                                    i6 = 0;
                                } else {
                                    iArr = iArr3;
                                    i6 = m667maxInRangejy6DScQ(iArr2, SpanRange.m677constructorimpl(0, i8)) + 1;
                                }
                                iArr2[i8] = i6;
                                lazyStaggeredGridMeasureContext.getLaneInfo().setLane(iArr2[i8], i8);
                                i8++;
                                iArr3 = iArr;
                                companion2 = companion3;
                                i7 = i5;
                            } catch (Throwable th2) {
                                th = th2;
                                createNonObservableSnapshot.restoreCurrent(makeCurrent);
                                throw th;
                            }
                        }
                        companion = null;
                        r13 = iArr3;
                    }
                    objectRef.element = r13;
                    if (offsets.length == lazyStaggeredGridMeasureContext.getLaneCount()) {
                        r0 = offsets;
                    } else {
                        r0 = new int[lazyStaggeredGridMeasureContext.getLaneCount()];
                        int i9 = 0;
                        int length2 = r0.length;
                        while (i9 < length2) {
                            if (i9 < offsets.length) {
                                r15 = offsets[i9];
                            } else {
                                r15 = i9 == 0 ? companion : r0[i9 - 1];
                            }
                            r0[i9] = r15;
                            i9++;
                        }
                    }
                    objectRef2.element = r0;
                    Unit unit = Unit.INSTANCE;
                    createNonObservableSnapshot.restoreCurrent(makeCurrent);
                    createNonObservableSnapshot.dispose();
                    return measure(lazyStaggeredGridMeasureContext, MathKt.roundToInt(state.getScrollToBeConsumed()), (int[]) objectRef.element, (int[]) objectRef2.element, true);
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                createNonObservableSnapshot.dispose();
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    private static final LazyStaggeredGridMeasureResult measure(final LazyStaggeredGridMeasureContext $this$measure, int initialScrollDelta, int[] initialItemIndices, int[] initialItemOffsets, boolean canRestartMeasure) {
        int itemCount;
        int itemCount2;
        boolean z;
        int itemCount3;
        int[] iArr;
        boolean z2;
        boolean z3;
        int[] currentItemOffsets;
        int maxOffset;
        int[] firstItemIndices;
        int itemCount4;
        int[] currentItemIndices;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext;
        int toScrollBack;
        boolean z4;
        boolean canScrollForward;
        boolean z5;
        List $this$fastForEach$iv$iv;
        ArrayDeque[] measuredItems;
        int itemCount5;
        boolean z6;
        int[] firstItemOffsets;
        int[] currentItemOffsets2;
        int layoutHeight;
        boolean z7;
        int[] firstItemIndices2;
        int scrollDelta;
        int maxOffsetLane;
        boolean gapDetected;
        int maxOffsetLane2;
        int[] currentItemOffsets3;
        int scrollDelta2;
        boolean gapDetected2;
        boolean gapDetected3;
        int initialLaneToMeasure;
        boolean z8;
        int scrollDelta3;
        int minOffset;
        int[] firstItemIndices3;
        String str;
        int laneToCheckForGaps;
        int initialLaneToMeasure2;
        int initialItemsMeasured;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext2 = $this$measure;
        LazyLayoutMeasureScope scope$iv = $this$measure.getMeasureScope();
        int itemCount6 = $this$measure.getItemProvider().getItemCount();
        if (itemCount6 <= 0) {
            itemCount = itemCount6;
        } else {
            if ($this$measure.getLaneCount() != 0) {
                int scrollDelta4 = initialScrollDelta;
                int[] firstItemIndices4 = Arrays.copyOf(initialItemIndices, initialItemIndices.length);
                String str2 = "copyOf(this, size)";
                Intrinsics.checkNotNullExpressionValue(firstItemIndices4, "copyOf(this, size)");
                int[] firstItemOffsets2 = Arrays.copyOf(initialItemOffsets, initialItemOffsets.length);
                Intrinsics.checkNotNullExpressionValue(firstItemOffsets2, "copyOf(this, size)");
                ensureIndicesInRange(lazyStaggeredGridMeasureContext2, firstItemIndices4, itemCount6);
                offsetBy(firstItemOffsets2, -scrollDelta4);
                int laneCount = $this$measure.getLaneCount();
                ArrayDeque[] arrayDequeArr = new ArrayDeque[laneCount];
                for (int i = 0; i < laneCount; i++) {
                    arrayDequeArr[i] = new ArrayDeque(16);
                }
                ArrayDeque[] measuredItems2 = arrayDequeArr;
                offsetBy(firstItemOffsets2, -$this$measure.getBeforeContentPadding());
                int laneToCheckForGaps2 = -1;
                while (true) {
                    if (!measure$lambda$38$hasSpaceBeforeFirst(firstItemIndices4, firstItemOffsets2, lazyStaggeredGridMeasureContext2)) {
                        itemCount2 = itemCount6;
                        break;
                    }
                    int laneIndex = indexOfMaxValue(firstItemIndices4);
                    int itemIndex = firstItemIndices4[laneIndex];
                    int length = firstItemOffsets2.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (firstItemIndices4[i2] != firstItemIndices4[laneIndex] && firstItemOffsets2[i2] < firstItemOffsets2[laneIndex]) {
                            firstItemOffsets2[i2] = firstItemOffsets2[laneIndex];
                        }
                    }
                    int previousItemIndex = findPreviousItemIndex(lazyStaggeredGridMeasureContext2, itemIndex, laneIndex);
                    if (previousItemIndex < 0) {
                        laneToCheckForGaps2 = laneIndex;
                        itemCount2 = itemCount6;
                        break;
                    }
                    long spanRange = lazyStaggeredGridMeasureContext2.m664getSpanRangelOCCd4c($this$measure.getItemProvider(), previousItemIndex, laneIndex);
                    int laneToCheckForGaps3 = laneToCheckForGaps2;
                    int itemCount7 = itemCount6;
                    $this$measure.getLaneInfo().setLane(previousItemIndex, ((int) (spanRange & 4294967295L)) - ((int) (spanRange >> 32)) != 1 ? -2 : (int) (spanRange >> 32));
                    LazyStaggeredGridMeasuredItem measuredItem = $this$measure.getMeasuredItemProvider().m672getAndMeasurejy6DScQ(previousItemIndex, spanRange);
                    int offset = m667maxInRangejy6DScQ(firstItemOffsets2, spanRange);
                    long $this$isFullSpan$iv = spanRange >> 32;
                    int[] gaps = ((int) (spanRange & 4294967295L)) - ((int) $this$isFullSpan$iv) != 1 ? $this$measure.getLaneInfo().getGaps(previousItemIndex) : null;
                    long $this$forEach_u2dnIS5qE8$iv = spanRange & 4294967295L;
                    int i3 = (int) $this$forEach_u2dnIS5qE8$iv;
                    for (int i$iv = (int) (spanRange >> 32); i$iv < i3; i$iv++) {
                        int lane = i$iv;
                        firstItemIndices4[lane] = previousItemIndex;
                        int gap = gaps == null ? 0 : gaps[lane];
                        firstItemOffsets2[lane] = offset + measuredItem.getSizeWithSpacings() + gap;
                    }
                    laneToCheckForGaps2 = laneToCheckForGaps3;
                    itemCount6 = itemCount7;
                }
                int $i$f$debugLog = $this$measure.getBeforeContentPadding();
                int minOffset2 = -$i$f$debugLog;
                if (firstItemOffsets2[0] < minOffset2) {
                    scrollDelta4 += firstItemOffsets2[0];
                    offsetBy(firstItemOffsets2, minOffset2 - firstItemOffsets2[0]);
                }
                int $i$f$debugLog2 = $this$measure.getBeforeContentPadding();
                offsetBy(firstItemOffsets2, $i$f$debugLog2);
                int i4 = -1;
                int laneToCheckForGaps4 = laneToCheckForGaps2 == -1 ? ArraysKt.indexOf(firstItemIndices4, 0) : laneToCheckForGaps2;
                if (laneToCheckForGaps4 != -1 && measure$lambda$38$misalignedStart(firstItemIndices4, lazyStaggeredGridMeasureContext2, firstItemOffsets2, laneToCheckForGaps4) && canRestartMeasure) {
                    $this$measure.getLaneInfo().reset();
                    int length2 = firstItemIndices4.length;
                    int[] iArr2 = new int[length2];
                    for (int i5 = 0; i5 < length2; i5++) {
                        iArr2[i5] = -1;
                    }
                    int length3 = firstItemOffsets2.length;
                    int[] iArr3 = new int[length3];
                    for (int i6 = 0; i6 < length3; i6++) {
                        iArr3[i6] = firstItemOffsets2[laneToCheckForGaps4];
                    }
                    return measure(lazyStaggeredGridMeasureContext2, scrollDelta4, iArr2, iArr3, false);
                }
                int[] currentItemIndices2 = Arrays.copyOf(firstItemIndices4, firstItemIndices4.length);
                Intrinsics.checkNotNullExpressionValue(currentItemIndices2, "copyOf(this, size)");
                int length4 = firstItemOffsets2.length;
                int[] iArr4 = new int[length4];
                for (int i7 = 0; i7 < length4; i7++) {
                    iArr4[i7] = -firstItemOffsets2[i7];
                }
                int[] currentItemOffsets4 = iArr4;
                int maxOffset2 = RangesKt.coerceAtLeast($this$measure.getMainAxisAvailableSize() + $this$measure.getAfterContentPadding(), 0);
                int initialItemsMeasured2 = 0;
                int initialLaneToMeasure3 = indexOfMinValue$default(currentItemIndices2, 0, 1, null);
                while (initialLaneToMeasure3 != i4 && initialItemsMeasured2 < $this$measure.getLaneCount()) {
                    int itemIndex2 = currentItemIndices2[initialLaneToMeasure3];
                    int laneIndex2 = initialLaneToMeasure3;
                    int initialLaneToMeasure4 = indexOfMinValue(currentItemIndices2, itemIndex2);
                    int initialItemsMeasured3 = initialItemsMeasured2 + 1;
                    if (itemIndex2 >= 0) {
                        initialLaneToMeasure2 = initialLaneToMeasure4;
                        initialItemsMeasured = initialItemsMeasured3;
                        long spanRange2 = lazyStaggeredGridMeasureContext2.m664getSpanRangelOCCd4c($this$measure.getItemProvider(), itemIndex2, laneIndex2);
                        LazyStaggeredGridMeasuredItem measuredItem2 = $this$measure.getMeasuredItemProvider().m672getAndMeasurejy6DScQ(itemIndex2, spanRange2);
                        laneToCheckForGaps = laneToCheckForGaps4;
                        scrollDelta3 = scrollDelta4;
                        firstItemIndices3 = firstItemIndices4;
                        str = str2;
                        $this$measure.getLaneInfo().setLane(itemIndex2, ((int) (spanRange2 & 4294967295L)) - ((int) (spanRange2 >> 32)) != 1 ? -2 : (int) (spanRange2 >> 32));
                        int offset2 = m667maxInRangejy6DScQ(currentItemOffsets4, spanRange2) + measuredItem2.getSizeWithSpacings();
                        minOffset = minOffset2;
                        int i$iv2 = (int) (spanRange2 >> 32);
                        int i8 = (int) (spanRange2 & 4294967295L);
                        int i$iv3 = i$iv2;
                        while (i$iv3 < i8) {
                            int lane2 = i$iv3;
                            currentItemOffsets4[lane2] = offset2;
                            currentItemIndices2[lane2] = itemIndex2;
                            measuredItems2[lane2].addLast(measuredItem2);
                            i$iv3++;
                            offset2 = offset2;
                        }
                        if (currentItemOffsets4[(int) (spanRange2 >> 32)] <= minOffset + $this$measure.getMainAxisSpacing()) {
                            measuredItem2.setVisible(false);
                        }
                        long $this$isFullSpan$iv2 = spanRange2 >> 32;
                        if (((int) (spanRange2 & 4294967295L)) - ((int) $this$isFullSpan$iv2) != 1) {
                            initialItemsMeasured2 = $this$measure.getLaneCount();
                            lazyStaggeredGridMeasureContext2 = $this$measure;
                            initialLaneToMeasure3 = initialLaneToMeasure2;
                            laneToCheckForGaps4 = laneToCheckForGaps;
                            minOffset2 = minOffset;
                            firstItemIndices4 = firstItemIndices3;
                            scrollDelta4 = scrollDelta3;
                            str2 = str;
                            i4 = -1;
                        }
                    } else {
                        scrollDelta3 = scrollDelta4;
                        minOffset = minOffset2;
                        firstItemIndices3 = firstItemIndices4;
                        str = str2;
                        laneToCheckForGaps = laneToCheckForGaps4;
                        initialLaneToMeasure2 = initialLaneToMeasure4;
                        initialItemsMeasured = initialItemsMeasured3;
                    }
                    lazyStaggeredGridMeasureContext2 = $this$measure;
                    initialLaneToMeasure3 = initialLaneToMeasure2;
                    initialItemsMeasured2 = initialItemsMeasured;
                    laneToCheckForGaps4 = laneToCheckForGaps;
                    minOffset2 = minOffset;
                    firstItemIndices4 = firstItemIndices3;
                    scrollDelta4 = scrollDelta3;
                    str2 = str;
                    i4 = -1;
                }
                int scrollDelta5 = scrollDelta4;
                int minOffset3 = minOffset2;
                int[] firstItemIndices5 = firstItemIndices4;
                String str3 = str2;
                while (true) {
                    int[] $this$any$iv = currentItemOffsets4;
                    int length5 = $this$any$iv.length;
                    int i9 = 0;
                    while (true) {
                        if (i9 >= length5) {
                            z = false;
                            break;
                        }
                        int element$iv = $this$any$iv[i9];
                        if (element$iv < maxOffset2 || element$iv <= 0) {
                            z = true;
                            break;
                        }
                        i9++;
                    }
                    if (!z) {
                        ArrayDeque[] arrayDequeArr2 = measuredItems2;
                        int length6 = arrayDequeArr2.length;
                        int i10 = 0;
                        while (true) {
                            if (i10 >= length6) {
                                z8 = true;
                                break;
                            }
                            if (!arrayDequeArr2[i10].isEmpty()) {
                                z8 = false;
                                break;
                            }
                            i10++;
                        }
                        if (!z8) {
                            itemCount3 = itemCount2;
                            break;
                        }
                    }
                    int currentLaneIndex = indexOfMinValue$default(currentItemOffsets4, 0, 1, null);
                    int itemIndex3 = ArraysKt.maxOrThrow(currentItemIndices2) + 1;
                    itemCount3 = itemCount2;
                    if (itemIndex3 >= itemCount3) {
                        break;
                    }
                    int[] firstItemOffsets3 = firstItemOffsets2;
                    int[] currentItemOffsets5 = currentItemOffsets4;
                    int maxOffset3 = maxOffset2;
                    int initialLaneToMeasure5 = initialLaneToMeasure3;
                    int[] firstItemIndices6 = firstItemIndices5;
                    int scrollDelta6 = scrollDelta5;
                    ArrayDeque[] measuredItems3 = measuredItems2;
                    int[] currentItemIndices3 = currentItemIndices2;
                    String str4 = str3;
                    int initialItemsMeasured4 = initialItemsMeasured2;
                    long spanRange3 = $this$measure.m664getSpanRangelOCCd4c($this$measure.getItemProvider(), itemIndex3, currentLaneIndex);
                    $this$measure.getLaneInfo().setLane(itemIndex3, ((int) (spanRange3 & 4294967295L)) - ((int) (spanRange3 >> 32)) != 1 ? -2 : (int) (spanRange3 >> 32));
                    LazyStaggeredGridMeasuredItem measuredItem3 = $this$measure.getMeasuredItemProvider().m672getAndMeasurejy6DScQ(itemIndex3, spanRange3);
                    int offset3 = m667maxInRangejy6DScQ(currentItemOffsets5, spanRange3);
                    long $this$isFullSpan$iv3 = spanRange3 >> 32;
                    if (((int) (spanRange3 & 4294967295L)) - ((int) $this$isFullSpan$iv3) != 1) {
                        iArr = $this$measure.getLaneInfo().getGaps(itemIndex3);
                        if (iArr == null) {
                            iArr = new int[$this$measure.getLaneCount()];
                        }
                    } else {
                        iArr = null;
                    }
                    int[] gaps2 = iArr;
                    int i$iv4 = (int) (spanRange3 >> 32);
                    int i11 = (int) (spanRange3 & 4294967295L);
                    for (int i$iv5 = i$iv4; i$iv5 < i11; i$iv5++) {
                        int lane3 = i$iv5;
                        if (gaps2 != null) {
                            gaps2[lane3] = offset3 - currentItemOffsets5[lane3];
                        }
                        currentItemIndices3[lane3] = itemIndex3;
                        currentItemOffsets5[lane3] = measuredItem3.getSizeWithSpacings() + offset3;
                        measuredItems3[lane3].addLast(measuredItem3);
                    }
                    $this$measure.getLaneInfo().setGaps(itemIndex3, gaps2);
                    if (currentItemOffsets5[(int) (spanRange3 >> 32)] <= minOffset3 + $this$measure.getMainAxisSpacing()) {
                        measuredItem3.setVisible(false);
                        currentItemOffsets4 = currentItemOffsets5;
                        initialLaneToMeasure3 = initialLaneToMeasure5;
                        measuredItems2 = measuredItems3;
                        initialItemsMeasured2 = initialItemsMeasured4;
                        firstItemOffsets2 = firstItemOffsets3;
                        maxOffset2 = maxOffset3;
                        itemCount2 = itemCount3;
                        str3 = str4;
                        firstItemIndices5 = firstItemIndices6;
                        currentItemIndices2 = currentItemIndices3;
                        scrollDelta5 = scrollDelta6;
                    } else {
                        currentItemOffsets4 = currentItemOffsets5;
                        initialLaneToMeasure3 = initialLaneToMeasure5;
                        measuredItems2 = measuredItems3;
                        initialItemsMeasured2 = initialItemsMeasured4;
                        firstItemOffsets2 = firstItemOffsets3;
                        maxOffset2 = maxOffset3;
                        itemCount2 = itemCount3;
                        str3 = str4;
                        firstItemIndices5 = firstItemIndices6;
                        currentItemIndices2 = currentItemIndices3;
                        scrollDelta5 = scrollDelta6;
                    }
                }
                int length7 = measuredItems2.length;
                for (int laneIndex3 = 0; laneIndex3 < length7; laneIndex3++) {
                    ArrayDeque laneItems = measuredItems2[laneIndex3];
                    while (laneItems.size() > 1 && !((LazyStaggeredGridMeasuredItem) laneItems.first()).getIsVisible()) {
                        LazyStaggeredGridMeasuredItem item = (LazyStaggeredGridMeasuredItem) laneItems.removeFirst();
                        int[] gaps3 = item.getSpan() != 1 ? $this$measure.getLaneInfo().getGaps(item.getIndex()) : null;
                        firstItemOffsets2[laneIndex3] = firstItemOffsets2[laneIndex3] - (item.getSizeWithSpacings() + (gaps3 == null ? 0 : gaps3[laneIndex3]));
                    }
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem = (LazyStaggeredGridMeasuredItem) laneItems.firstOrNull();
                    firstItemIndices5[laneIndex3] = lazyStaggeredGridMeasuredItem != null ? lazyStaggeredGridMeasuredItem.getIndex() : -1;
                }
                int[] $this$any$iv2 = currentItemIndices2;
                int length8 = $this$any$iv2.length;
                int i12 = 0;
                while (true) {
                    if (i12 >= length8) {
                        z2 = false;
                        break;
                    }
                    int element$iv2 = $this$any$iv2[i12];
                    int it = element$iv2 == itemCount3 + (-1) ? 1 : 0;
                    if (it != 0) {
                        z2 = true;
                        break;
                    }
                    i12++;
                }
                if (z2) {
                    offsetBy(currentItemOffsets4, -$this$measure.getMainAxisSpacing());
                }
                int[] $this$all$iv = currentItemOffsets4;
                int length9 = $this$all$iv.length;
                int i13 = 0;
                while (true) {
                    if (i13 >= length9) {
                        z3 = true;
                        break;
                    }
                    int element$iv3 = $this$all$iv[i13];
                    int it2 = element$iv3 < $this$measure.getMainAxisAvailableSize() ? 1 : 0;
                    if (it2 == 0) {
                        z3 = false;
                        break;
                    }
                    i13++;
                }
                if (z3) {
                    int maxOffsetLane3 = indexOfMaxValue(currentItemOffsets4);
                    int toScrollBack2 = $this$measure.getMainAxisAvailableSize() - currentItemOffsets4[maxOffsetLane3];
                    offsetBy(firstItemOffsets2, -toScrollBack2);
                    offsetBy(currentItemOffsets4, toScrollBack2);
                    boolean gapDetected4 = false;
                    while (true) {
                        int[] $this$any$iv3 = firstItemOffsets2;
                        int length10 = $this$any$iv3.length;
                        int i14 = 0;
                        while (true) {
                            if (i14 >= length10) {
                                maxOffsetLane = maxOffsetLane3;
                                gapDetected = gapDetected4;
                                maxOffsetLane2 = 0;
                                break;
                            }
                            int element$iv4 = $this$any$iv3[i14];
                            maxOffsetLane = maxOffsetLane3;
                            gapDetected = gapDetected4;
                            if (element$iv4 < $this$measure.getBeforeContentPadding()) {
                                maxOffsetLane2 = 1;
                                break;
                            }
                            i14++;
                            maxOffsetLane3 = maxOffsetLane;
                            gapDetected4 = gapDetected;
                        }
                        if (maxOffsetLane2 == 0) {
                            currentItemOffsets3 = currentItemOffsets4;
                            maxOffset = maxOffset2;
                            firstItemIndices = firstItemIndices5;
                            scrollDelta2 = scrollDelta5;
                            itemCount4 = itemCount3;
                            currentItemIndices = currentItemIndices2;
                            gapDetected2 = gapDetected;
                            break;
                        }
                        int laneIndex4 = indexOfMinValue$default(firstItemOffsets2, 0, 1, null);
                        boolean gapDetected5 = laneIndex4 != indexOfMaxValue(firstItemIndices5) ? true : gapDetected;
                        int currentIndex = firstItemIndices5[laneIndex4] == -1 ? itemCount3 : firstItemIndices5[laneIndex4];
                        int previousIndex = findPreviousItemIndex($this$measure, currentIndex, laneIndex4);
                        if (previousIndex < 0) {
                            if (gapDetected5) {
                                firstItemIndices = firstItemIndices5;
                            } else {
                                firstItemIndices = firstItemIndices5;
                                if (!measure$lambda$38$misalignedStart(firstItemIndices, $this$measure, firstItemOffsets2, laneIndex4)) {
                                    gapDetected3 = gapDetected5;
                                    initialLaneToMeasure = scrollDelta5;
                                    itemCount4 = itemCount3;
                                    currentItemIndices = currentItemIndices2;
                                    currentItemOffsets3 = currentItemOffsets4;
                                    maxOffset = maxOffset2;
                                    scrollDelta2 = initialLaneToMeasure;
                                    gapDetected2 = gapDetected3;
                                }
                            }
                            if (canRestartMeasure) {
                                $this$measure.getLaneInfo().reset();
                                int length11 = firstItemIndices.length;
                                int[] iArr5 = new int[length11];
                                for (int i15 = 0; i15 < length11; i15++) {
                                    iArr5[i15] = -1;
                                }
                                int length12 = firstItemOffsets2.length;
                                int[] iArr6 = new int[length12];
                                for (int initialLaneToMeasure6 = 0; initialLaneToMeasure6 < length12; initialLaneToMeasure6++) {
                                    iArr6[initialLaneToMeasure6] = firstItemOffsets2[laneIndex4];
                                }
                                return measure($this$measure, scrollDelta5, iArr5, iArr6, false);
                            }
                            gapDetected3 = gapDetected5;
                            initialLaneToMeasure = scrollDelta5;
                            itemCount4 = itemCount3;
                            currentItemIndices = currentItemIndices2;
                            currentItemOffsets3 = currentItemOffsets4;
                            maxOffset = maxOffset2;
                            scrollDelta2 = initialLaneToMeasure;
                            gapDetected2 = gapDetected3;
                        } else {
                            boolean gapDetected6 = gapDetected5;
                            int initialLaneToMeasure7 = initialLaneToMeasure3;
                            int[] firstItemIndices7 = firstItemIndices5;
                            int initialLaneToMeasure8 = scrollDelta5;
                            int itemCount8 = itemCount3;
                            long spanRange4 = $this$measure.m664getSpanRangelOCCd4c($this$measure.getItemProvider(), previousIndex, laneIndex4);
                            int[] currentItemIndices4 = currentItemIndices2;
                            int[] currentItemOffsets6 = currentItemOffsets4;
                            int maxOffset4 = maxOffset2;
                            $this$measure.getLaneInfo().setLane(previousIndex, ((int) (spanRange4 & 4294967295L)) - ((int) (spanRange4 >> 32)) != 1 ? -2 : (int) (spanRange4 >> 32));
                            LazyStaggeredGridMeasuredItem measuredItem4 = $this$measure.getMeasuredItemProvider().m672getAndMeasurejy6DScQ(previousIndex, spanRange4);
                            int offset4 = m667maxInRangejy6DScQ(firstItemOffsets2, spanRange4);
                            long $this$isFullSpan$iv4 = spanRange4 >> 32;
                            int[] gaps4 = ((int) (spanRange4 & 4294967295L)) - ((int) $this$isFullSpan$iv4) != 1 ? $this$measure.getLaneInfo().getGaps(previousIndex) : null;
                            int i$iv6 = (int) (spanRange4 >> 32);
                            int i$iv7 = i$iv6;
                            int i16 = (int) (spanRange4 & 4294967295L);
                            gapDetected4 = gapDetected6;
                            while (i$iv7 < i16) {
                                int lane4 = i$iv7;
                                int i17 = i16;
                                if (firstItemOffsets2[lane4] != offset4) {
                                    gapDetected4 = true;
                                }
                                measuredItems2[lane4].addFirst(measuredItem4);
                                firstItemIndices7[lane4] = previousIndex;
                                int gap2 = gaps4 == null ? 0 : gaps4[lane4];
                                firstItemOffsets2[lane4] = offset4 + measuredItem4.getSizeWithSpacings() + gap2;
                                i$iv7++;
                                i16 = i17;
                            }
                            maxOffsetLane3 = maxOffsetLane;
                            initialLaneToMeasure3 = initialLaneToMeasure7;
                            itemCount3 = itemCount8;
                            currentItemIndices2 = currentItemIndices4;
                            maxOffset2 = maxOffset4;
                            currentItemOffsets4 = currentItemOffsets6;
                            firstItemIndices5 = firstItemIndices7;
                            scrollDelta5 = initialLaneToMeasure8;
                        }
                    }
                    if (gapDetected2 && canRestartMeasure) {
                        $this$measure.getLaneInfo().reset();
                        return measure($this$measure, scrollDelta2, firstItemIndices, firstItemOffsets2, false);
                    }
                    lazyStaggeredGridMeasureContext = $this$measure;
                    int scrollDelta7 = scrollDelta2 + toScrollBack2;
                    int minOffsetLane = indexOfMinValue$default(firstItemOffsets2, 0, 1, null);
                    if (firstItemOffsets2[minOffsetLane] < 0) {
                        int offsetValue = firstItemOffsets2[minOffsetLane];
                        currentItemOffsets = currentItemOffsets3;
                        offsetBy(currentItemOffsets, offsetValue);
                        offsetBy(firstItemOffsets2, -offsetValue);
                        toScrollBack = scrollDelta7 + offsetValue;
                    } else {
                        currentItemOffsets = currentItemOffsets3;
                        toScrollBack = scrollDelta7;
                    }
                } else {
                    currentItemOffsets = currentItemOffsets4;
                    maxOffset = maxOffset2;
                    firstItemIndices = firstItemIndices5;
                    int scrollDelta8 = scrollDelta5;
                    itemCount4 = itemCount3;
                    currentItemIndices = currentItemIndices2;
                    lazyStaggeredGridMeasureContext = $this$measure;
                    toScrollBack = scrollDelta8;
                }
                float consumedScroll = (MathKt.getSign(MathKt.roundToInt($this$measure.getState().getScrollToBeConsumed())) != MathKt.getSign(toScrollBack) || Math.abs(MathKt.roundToInt($this$measure.getState().getScrollToBeConsumed())) < Math.abs(toScrollBack)) ? $this$measure.getState().getScrollToBeConsumed() : toScrollBack;
                int[] $this$transform$iv = Arrays.copyOf(firstItemOffsets2, firstItemOffsets2.length);
                Intrinsics.checkNotNullExpressionValue($this$transform$iv, str3);
                int length13 = $this$transform$iv.length;
                for (int i$iv8 = 0; i$iv8 < length13; i$iv8++) {
                    int it3 = $this$transform$iv[i$iv8];
                    $this$transform$iv[i$iv8] = -it3;
                }
                int $i$f$debugLog3 = $this$measure.getBeforeContentPadding();
                if ($i$f$debugLog3 > $this$measure.getMainAxisSpacing()) {
                    int laneIndex5 = 0;
                    int length14 = measuredItems2.length;
                    while (laneIndex5 < length14) {
                        ArrayDeque laneItems2 = measuredItems2[laneIndex5];
                        int i18 = 0;
                        int size = laneItems2.size();
                        while (true) {
                            if (i18 >= size) {
                                scrollDelta = toScrollBack;
                                break;
                            }
                            LazyStaggeredGridMeasuredItem item2 = (LazyStaggeredGridMeasuredItem) laneItems2.get(i18);
                            scrollDelta = toScrollBack;
                            int[] gaps5 = $this$measure.getLaneInfo().getGaps(item2.getIndex());
                            int size2 = item2.getSizeWithSpacings() + (gaps5 == null ? 0 : gaps5[laneIndex5]);
                            if (i18 != CollectionsKt.getLastIndex(laneItems2) && firstItemOffsets2[laneIndex5] != 0 && firstItemOffsets2[laneIndex5] >= size2) {
                                firstItemOffsets2[laneIndex5] = firstItemOffsets2[laneIndex5] - size2;
                                firstItemIndices[laneIndex5] = ((LazyStaggeredGridMeasuredItem) laneItems2.get(i18 + 1)).getIndex();
                                i18++;
                                toScrollBack = scrollDelta;
                            }
                        }
                        laneIndex5++;
                        toScrollBack = scrollDelta;
                    }
                }
                int $i$f$debugLog4 = $this$measure.getBeforeContentPadding();
                int contentPadding = $i$f$debugLog4 + $this$measure.getAfterContentPadding();
                int layoutWidth = $this$measure.getIsVertical() ? Constraints.m5174getMaxWidthimpl($this$measure.getConstraints()) : ConstraintsKt.m5188constrainWidthK40F9xA($this$measure.getConstraints(), ArraysKt.maxOrThrow(currentItemOffsets) + contentPadding);
                int layoutHeight2 = $this$measure.getIsVertical() ? ConstraintsKt.m5187constrainHeightK40F9xA($this$measure.getConstraints(), ArraysKt.maxOrThrow(currentItemOffsets) + contentPadding) : Constraints.m5173getMaxHeightimpl($this$measure.getConstraints());
                int it4 = Math.min($this$measure.getIsVertical() ? layoutHeight2 : layoutWidth, $this$measure.getMainAxisAvailableSize());
                int mainAxisLayoutSize = (it4 - $this$measure.getBeforeContentPadding()) + $this$measure.getAfterContentPadding();
                int extraItemOffset = $this$transform$iv[0];
                List list = null;
                List $this$fastForEach$iv$iv2 = $this$measure.getPinnedItems();
                int extraItemOffset2 = extraItemOffset;
                int extraItemOffset3 = $this$fastForEach$iv$iv2.size();
                int $i$f$calculateExtraItems = 0;
                while ($i$f$calculateExtraItems < extraItemOffset3) {
                    Object item$iv$iv = $this$fastForEach$iv$iv2.get($i$f$calculateExtraItems);
                    List $this$fastForEach$iv$iv3 = $this$fastForEach$iv$iv2;
                    int index$iv = ((Number) item$iv$iv).intValue();
                    int i19 = extraItemOffset3;
                    int initialItemsMeasured5 = initialItemsMeasured2;
                    int lane5 = $this$measure.getLaneInfo().getLane(index$iv);
                    switch (lane5) {
                        case -2:
                        case -1:
                            int[] $this$all$iv2 = firstItemIndices;
                            firstItemOffsets = firstItemOffsets2;
                            currentItemOffsets2 = currentItemOffsets;
                            int length15 = $this$all$iv2.length;
                            layoutHeight = layoutHeight2;
                            int layoutHeight3 = 0;
                            while (true) {
                                if (layoutHeight3 >= length15) {
                                    z7 = true;
                                    break;
                                } else {
                                    int element$iv5 = $this$all$iv2[layoutHeight3];
                                    int i20 = length15;
                                    int it5 = element$iv5 > index$iv ? 1 : 0;
                                    if (it5 == 0) {
                                        z7 = false;
                                        break;
                                    } else {
                                        layoutHeight3++;
                                        length15 = i20;
                                    }
                                }
                            }
                        default:
                            layoutHeight = layoutHeight2;
                            firstItemOffsets = firstItemOffsets2;
                            currentItemOffsets2 = currentItemOffsets;
                            if (firstItemIndices[lane5] > index$iv) {
                                z7 = true;
                                break;
                            } else {
                                z7 = false;
                                break;
                            }
                    }
                    if (z7) {
                        firstItemIndices2 = firstItemIndices;
                        long spanRange$iv = $this$measure.m664getSpanRangelOCCd4c($this$measure.getItemProvider(), index$iv, 0);
                        if (list == null) {
                            Object result$iv = new ArrayList();
                            list = (List) result$iv;
                        }
                        LazyStaggeredGridMeasuredItem measuredItem$iv = $this$measure.getMeasuredItemProvider().m672getAndMeasurejy6DScQ(index$iv, spanRange$iv);
                        int index$iv2 = extraItemOffset2 - measuredItem$iv.getSizeWithSpacings();
                        measuredItem$iv.position(index$iv2, 0, mainAxisLayoutSize);
                        list.add(measuredItem$iv);
                        extraItemOffset2 = index$iv2;
                    } else {
                        firstItemIndices2 = firstItemIndices;
                    }
                    $i$f$calculateExtraItems++;
                    firstItemIndices = firstItemIndices2;
                    $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv3;
                    extraItemOffset3 = i19;
                    initialItemsMeasured2 = initialItemsMeasured5;
                    firstItemOffsets2 = firstItemOffsets;
                    currentItemOffsets = currentItemOffsets2;
                    layoutHeight2 = layoutHeight;
                }
                int layoutHeight4 = layoutHeight2;
                int[] firstItemOffsets4 = firstItemOffsets2;
                int[] currentItemOffsets7 = currentItemOffsets;
                int[] currentItemOffsets8 = firstItemIndices;
                if (list == null) {
                    list = CollectionsKt.emptyList();
                }
                List extraItemsBefore = list;
                List visibleItems = calculateVisibleItems(lazyStaggeredGridMeasureContext, measuredItems2, $this$transform$iv, mainAxisLayoutSize);
                int extraItemOffset4 = $this$transform$iv[0];
                int $i$f$calculateExtraItems2 = 0;
                List list2 = null;
                List $this$fastForEach$iv$iv4 = $this$measure.getPinnedItems();
                int $i$f$fastForEach = 0;
                int index$iv$iv = 0;
                int size3 = $this$fastForEach$iv$iv4.size();
                while (index$iv$iv < size3) {
                    Object item$iv$iv2 = $this$fastForEach$iv$iv4.get(index$iv$iv);
                    int i21 = size3;
                    int index$iv3 = ((Number) item$iv$iv2).intValue();
                    int $i$f$fastForEach2 = $i$f$fastForEach;
                    int $i$f$fastForEach3 = itemCount4;
                    int itemIndex4 = $i$f$calculateExtraItems2;
                    if (index$iv3 < $i$f$fastForEach3) {
                        $this$fastForEach$iv$iv = $this$fastForEach$iv$iv4;
                        int lane6 = $this$measure.getLaneInfo().getLane(index$iv3);
                        switch (lane6) {
                            case -2:
                            case -1:
                                int[] $this$all$iv3 = currentItemIndices;
                                measuredItems = measuredItems2;
                                int length16 = $this$all$iv3.length;
                                itemCount5 = $i$f$fastForEach3;
                                int itemCount9 = 0;
                                while (true) {
                                    if (itemCount9 >= length16) {
                                        z6 = true;
                                        break;
                                    } else {
                                        int element$iv6 = $this$all$iv3[itemCount9];
                                        int i22 = length16;
                                        int it6 = element$iv6 < index$iv3 ? 1 : 0;
                                        if (it6 == 0) {
                                            z6 = false;
                                            break;
                                        } else {
                                            itemCount9++;
                                            length16 = i22;
                                        }
                                    }
                                }
                            default:
                                measuredItems = measuredItems2;
                                itemCount5 = $i$f$fastForEach3;
                                if (currentItemIndices[lane6] < index$iv3) {
                                    z6 = true;
                                    break;
                                } else {
                                    z6 = false;
                                    break;
                                }
                        }
                    } else {
                        measuredItems = measuredItems2;
                        $this$fastForEach$iv$iv = $this$fastForEach$iv$iv4;
                        itemCount5 = $i$f$fastForEach3;
                        z6 = false;
                    }
                    if (z6) {
                        long spanRange$iv2 = $this$measure.m664getSpanRangelOCCd4c($this$measure.getItemProvider(), index$iv3, 0);
                        if (list2 == null) {
                            Object result$iv2 = new ArrayList();
                            list2 = (List) result$iv2;
                        }
                        LazyStaggeredGridMeasuredItem measuredItem$iv2 = $this$measure.getMeasuredItemProvider().m672getAndMeasurejy6DScQ(index$iv3, spanRange$iv2);
                        measuredItem$iv2.position(extraItemOffset4, 0, mainAxisLayoutSize);
                        extraItemOffset4 += measuredItem$iv2.getSizeWithSpacings();
                        list2.add(measuredItem$iv2);
                    }
                    index$iv$iv++;
                    size3 = i21;
                    $i$f$calculateExtraItems2 = itemIndex4;
                    $i$f$fastForEach = $i$f$fastForEach2;
                    $this$fastForEach$iv$iv4 = $this$fastForEach$iv$iv;
                    measuredItems2 = measuredItems;
                    itemCount4 = itemCount5;
                }
                int itemCount10 = itemCount4;
                if (list2 == null) {
                    list2 = CollectionsKt.emptyList();
                }
                List extraItemsAfter = list2;
                final List positionedItems = new ArrayList();
                positionedItems.addAll(extraItemsBefore);
                positionedItems.addAll(visibleItems);
                positionedItems.addAll(extraItemsAfter);
                $this$measure.getState().getPlacementAnimator().onMeasured((int) consumedScroll, layoutWidth, layoutHeight4, positionedItems, $this$measure.getMeasuredItemProvider(), $this$measure.getIsVertical(), $this$measure.getLaneCount());
                boolean canScrollBackward = currentItemOffsets8[0] != 0 || firstItemOffsets4[0] > 0;
                int length17 = currentItemOffsets7.length;
                int i23 = 0;
                while (true) {
                    if (i23 < length17) {
                        int element$iv7 = currentItemOffsets7[i23];
                        List extraItemsBefore2 = extraItemsBefore;
                        if (element$iv7 > $this$measure.getMainAxisAvailableSize()) {
                            z4 = true;
                        } else {
                            i23++;
                            extraItemsBefore = extraItemsBefore2;
                        }
                    } else {
                        z4 = false;
                    }
                }
                if (!z4) {
                    int[] $this$all$iv4 = currentItemIndices;
                    int length18 = $this$all$iv4.length;
                    int i24 = 0;
                    while (true) {
                        if (i24 < length18) {
                            int element$iv8 = $this$all$iv4[i24];
                            int it7 = element$iv8 < itemCount10 + (-1) ? 1 : 0;
                            if (it7 == 0) {
                                z5 = false;
                            } else {
                                i24++;
                            }
                        } else {
                            z5 = true;
                        }
                    }
                    if (!z5) {
                        canScrollForward = false;
                        return new LazyStaggeredGridMeasureResult(currentItemOffsets8, firstItemOffsets4, consumedScroll, MeasureScope.layout$default(scope$iv, layoutWidth, layoutHeight4, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$measure$1$29
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope layout) {
                                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                List $this$fastForEach$iv = positionedItems;
                                LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext3 = $this$measure;
                                int size4 = $this$fastForEach$iv.size();
                                for (int index$iv4 = 0; index$iv4 < size4; index$iv4++) {
                                    Object item$iv = $this$fastForEach$iv.get(index$iv4);
                                    LazyStaggeredGridMeasuredItem item3 = (LazyStaggeredGridMeasuredItem) item$iv;
                                    item3.place(layout, lazyStaggeredGridMeasureContext3);
                                }
                            }
                        }, 4, null), canScrollForward, canScrollBackward, $this$measure.getIsVertical(), itemCount10, visibleItems, IntSizeKt.IntSize(layoutWidth, layoutHeight4), minOffset3, maxOffset, $this$measure.getBeforeContentPadding(), $this$measure.getAfterContentPadding(), $this$measure.getMainAxisSpacing(), null);
                    }
                }
                canScrollForward = true;
                return new LazyStaggeredGridMeasureResult(currentItemOffsets8, firstItemOffsets4, consumedScroll, MeasureScope.layout$default(scope$iv, layoutWidth, layoutHeight4, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$measure$1$29
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                        invoke2(placementScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Placeable.PlacementScope layout) {
                        Intrinsics.checkNotNullParameter(layout, "$this$layout");
                        List $this$fastForEach$iv = positionedItems;
                        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext3 = $this$measure;
                        int size4 = $this$fastForEach$iv.size();
                        for (int index$iv4 = 0; index$iv4 < size4; index$iv4++) {
                            Object item$iv = $this$fastForEach$iv.get(index$iv4);
                            LazyStaggeredGridMeasuredItem item3 = (LazyStaggeredGridMeasuredItem) item$iv;
                            item3.place(layout, lazyStaggeredGridMeasureContext3);
                        }
                    }
                }, 4, null), canScrollForward, canScrollBackward, $this$measure.getIsVertical(), itemCount10, visibleItems, IntSizeKt.IntSize(layoutWidth, layoutHeight4), minOffset3, maxOffset, $this$measure.getBeforeContentPadding(), $this$measure.getAfterContentPadding(), $this$measure.getMainAxisSpacing(), null);
            }
            itemCount = itemCount6;
        }
        return new LazyStaggeredGridMeasureResult(initialItemIndices, initialItemOffsets, 0.0f, MeasureScope.layout$default(scope$iv, Constraints.m5176getMinWidthimpl($this$measure.getConstraints()), Constraints.m5175getMinHeightimpl($this$measure.getConstraints()), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$measure$1$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope layout) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
            }
        }, 4, null), false, false, $this$measure.getIsVertical(), itemCount, CollectionsKt.emptyList(), IntSizeKt.IntSize(Constraints.m5176getMinWidthimpl($this$measure.getConstraints()), Constraints.m5175getMinHeightimpl($this$measure.getConstraints())), -$this$measure.getBeforeContentPadding(), $this$measure.getMainAxisAvailableSize() + $this$measure.getAfterContentPadding(), $this$measure.getBeforeContentPadding(), $this$measure.getAfterContentPadding(), $this$measure.getMainAxisSpacing(), null);
    }

    private static final boolean measure$lambda$38$hasSpaceBeforeFirst(int[] firstItemIndices, int[] firstItemOffsets, LazyStaggeredGridMeasureContext $this_measure) {
        int length = firstItemIndices.length;
        for (int lane = 0; lane < length; lane++) {
            int itemIndex = firstItemIndices[lane];
            int itemOffset = firstItemOffsets[lane];
            if (itemOffset < Math.max(-$this_measure.getMainAxisSpacing(), 0) && itemIndex > 0) {
                return true;
            }
        }
        return false;
    }

    private static final boolean measure$lambda$38$misalignedStart(int[] firstItemIndices, LazyStaggeredGridMeasureContext $this_measure, int[] firstItemOffsets, int referenceLane) {
        int lane = 0;
        int length = firstItemIndices.length;
        while (true) {
            boolean z = false;
            if (lane < length) {
                if (findPreviousItemIndex($this_measure, firstItemIndices[lane], lane) == -1 && firstItemOffsets[lane] != firstItemOffsets[referenceLane]) {
                    z = true;
                }
                boolean misalignedOffsets = z;
                if (misalignedOffsets) {
                    return true;
                }
                lane++;
            } else {
                int length2 = firstItemIndices.length;
                for (int lane2 = 0; lane2 < length2; lane2++) {
                    boolean moreItemsInOtherLanes = findPreviousItemIndex($this_measure, firstItemIndices[lane2], lane2) != -1 && firstItemOffsets[lane2] >= firstItemOffsets[referenceLane];
                    if (moreItemsInOtherLanes) {
                        return true;
                    }
                }
                int firstItemLane = $this_measure.getLaneInfo().getLane(0);
                return (firstItemLane == 0 || firstItemLane == -1 || firstItemLane == -2) ? false : true;
            }
        }
    }

    private static final List<LazyStaggeredGridMeasuredItem> calculateVisibleItems(LazyStaggeredGridMeasureContext $this$calculateVisibleItems, ArrayDeque<LazyStaggeredGridMeasuredItem>[] arrayDequeArr, int[] itemScrollOffsets, int mainAxisLayoutSize) {
        boolean z;
        int i = 0;
        for (ArrayDeque<LazyStaggeredGridMeasuredItem> arrayDeque : arrayDequeArr) {
            i += arrayDeque.size();
        }
        ArrayList positionedItems = new ArrayList(i);
        while (true) {
            int length = arrayDequeArr.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    z = true;
                    if (!arrayDequeArr[i2].isEmpty()) {
                        break;
                    }
                    i2++;
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                return positionedItems;
            }
            int result$iv = -1;
            int min$iv = Integer.MAX_VALUE;
            int length2 = arrayDequeArr.length;
            for (int i$iv = 0; i$iv < length2; i$iv++) {
                LazyStaggeredGridMeasuredItem firstOrNull = arrayDequeArr[i$iv].firstOrNull();
                int value$iv = firstOrNull != null ? firstOrNull.getIndex() : Integer.MAX_VALUE;
                if (min$iv > value$iv) {
                    min$iv = value$iv;
                    result$iv = i$iv;
                }
            }
            int laneIndex = result$iv;
            LazyStaggeredGridMeasuredItem item = arrayDequeArr[laneIndex].removeFirst();
            if (item.getLane() == laneIndex) {
                long spanRange = SpanRange.m677constructorimpl(item.getLane(), item.getSpan());
                int mainAxisOffset = m667maxInRangejy6DScQ(itemScrollOffsets, spanRange);
                int crossAxisOffset = $this$calculateVisibleItems.getResolvedSlots().getPositions()[laneIndex];
                if (item.getPlaceablesCount() != 0) {
                    item.position(mainAxisOffset, crossAxisOffset, mainAxisLayoutSize);
                    positionedItems.add(item);
                    int i$iv2 = (int) (spanRange >> 32);
                    int i3 = (int) (spanRange & 4294967295L);
                    for (int i$iv3 = i$iv2; i$iv3 < i3; i$iv3++) {
                        int lane = i$iv3;
                        itemScrollOffsets[lane] = mainAxisOffset + item.getSizeWithSpacings();
                    }
                }
            }
        }
    }

    private static final List<LazyStaggeredGridMeasuredItem> calculateExtraItems(LazyStaggeredGridMeasureContext $this$calculateExtraItems, Function1<? super LazyStaggeredGridMeasuredItem, Unit> function1, Function1<? super Integer, Boolean> function12) {
        ArrayList arrayList = null;
        List $this$fastForEach$iv = $this$calculateExtraItems.getPinnedItems();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            int index = ((Number) item$iv).intValue();
            if (function12.invoke(Integer.valueOf(index)).booleanValue()) {
                long spanRange = $this$calculateExtraItems.m664getSpanRangelOCCd4c($this$calculateExtraItems.getItemProvider(), index, 0);
                if (arrayList == null) {
                    Object result = new ArrayList();
                    arrayList = (List) result;
                }
                LazyStaggeredGridMeasuredItem measuredItem = $this$calculateExtraItems.getMeasuredItemProvider().m672getAndMeasurejy6DScQ(index, spanRange);
                function1.invoke(measuredItem);
                arrayList.add(measuredItem);
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    /* renamed from: forEach-nIS5qE8, reason: not valid java name */
    private static final void m666forEachnIS5qE8(long $this$forEach_u2dnIS5qE8, Function1<? super Integer, Unit> function1) {
        int i = (int) (4294967295L & $this$forEach_u2dnIS5qE8);
        for (int i2 = (int) ($this$forEach_u2dnIS5qE8 >> 32); i2 < i; i2++) {
            function1.invoke(Integer.valueOf(i2));
        }
    }

    private static final void offsetBy(int[] $this$offsetBy, int delta) {
        int length = $this$offsetBy.length;
        for (int i = 0; i < length; i++) {
            $this$offsetBy[i] = $this$offsetBy[i] + delta;
        }
    }

    /* renamed from: maxInRange-jy6DScQ, reason: not valid java name */
    private static final int m667maxInRangejy6DScQ(int[] $this$maxInRange_u2djy6DScQ, long indexRange) {
        int max = Integer.MIN_VALUE;
        int i = (int) (4294967295L & indexRange);
        for (int i$iv = (int) (indexRange >> 32); i$iv < i; i$iv++) {
            int it = i$iv;
            max = Math.max(max, $this$maxInRange_u2djy6DScQ[it]);
        }
        return max;
    }

    public static /* synthetic */ int indexOfMinValue$default(int[] iArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Integer.MIN_VALUE;
        }
        return indexOfMinValue(iArr, i);
    }

    public static final int indexOfMinValue(int[] $this$indexOfMinValue, int minBound) {
        Intrinsics.checkNotNullParameter($this$indexOfMinValue, "<this>");
        int result = -1;
        int min = Integer.MAX_VALUE;
        int length = $this$indexOfMinValue.length;
        for (int i = 0; i < length; i++) {
            int i2 = minBound + 1;
            int i3 = $this$indexOfMinValue[i];
            boolean z = false;
            if (i2 <= i3 && i3 < min) {
                z = true;
            }
            if (z) {
                min = $this$indexOfMinValue[i];
                result = i;
            }
        }
        return result;
    }

    private static final <T> int indexOfMinBy(T[] tArr, Function1<? super T, Integer> function1) {
        int result = -1;
        int min = Integer.MAX_VALUE;
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            int value = function1.invoke(tArr[i]).intValue();
            if (min > value) {
                min = value;
                result = i;
            }
        }
        return result;
    }

    private static final int indexOfMaxValue(int[] $this$indexOfMaxValue) {
        int result = -1;
        int max = Integer.MIN_VALUE;
        int length = $this$indexOfMaxValue.length;
        for (int i = 0; i < length; i++) {
            if (max < $this$indexOfMaxValue[i]) {
                max = $this$indexOfMaxValue[i];
                result = i;
            }
        }
        return result;
    }

    private static final int[] transform(int[] $this$transform, Function1<? super Integer, Integer> function1) {
        int length = $this$transform.length;
        for (int i = 0; i < length; i++) {
            $this$transform[i] = function1.invoke(Integer.valueOf($this$transform[i])).intValue();
        }
        return $this$transform;
    }

    private static final void ensureIndicesInRange(LazyStaggeredGridMeasureContext $this$ensureIndicesInRange, int[] indices, int itemCount) {
        int length = indices.length - 1;
        if (length < 0) {
            return;
        }
        do {
            int i = length;
            length--;
            while (true) {
                if (indices[i] < itemCount && $this$ensureIndicesInRange.getLaneInfo().assignedToLane(indices[i], i)) {
                    break;
                } else {
                    indices[i] = findPreviousItemIndex($this$ensureIndicesInRange, indices[i], i);
                }
            }
            if (indices[i] >= 0 && !$this$ensureIndicesInRange.isFullSpan($this$ensureIndicesInRange.getItemProvider(), indices[i])) {
                $this$ensureIndicesInRange.getLaneInfo().setLane(indices[i], i);
            }
        } while (length >= 0);
    }

    private static final int findPreviousItemIndex(LazyStaggeredGridMeasureContext $this$findPreviousItemIndex, int item, int lane) {
        return $this$findPreviousItemIndex.getLaneInfo().findPreviousItemIndex(item, lane);
    }
}
