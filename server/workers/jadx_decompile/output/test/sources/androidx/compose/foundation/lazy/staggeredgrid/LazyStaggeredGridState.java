package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: LazyStaggeredGridState.kt */
@Metadata(d1 = {"\u0000\u0080\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 ¨\u00012\u00020\u0001:\u0002¨\u0001B\u001b\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u0017\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ(\u0010\u0081\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u0083\u0001\u001a\u00020\u00032\t\b\u0002\u0010\u0084\u0001\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010\u0085\u0001J\u001a\u0010\u0086\u0001\u001a\u00030\u0082\u00012\b\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0000¢\u0006\u0003\b\u0089\u0001J\u0013\u0010\u008a\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u008b\u0001\u001a\u00020AH\u0002J\u001a\u0010\u008c\u0001\u001a\u00030\u0082\u00012\u000e\u0010\u008d\u0001\u001a\t\u0012\u0004\u0012\u00020\u00030\u008e\u0001H\u0002J\u0012\u0010\u008f\u0001\u001a\u00020p2\u0007\u0010\u0090\u0001\u001a\u00020pH\u0016J\u001a\u0010\u0091\u0001\u001a\u00020\u00072\u0007\u0010\u0092\u0001\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0003H\u0002J\u0013\u0010\u0093\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u0090\u0001\u001a\u00020pH\u0002J\u0012\u0010\u0094\u0001\u001a\u00020p2\u0007\u0010\u0095\u0001\u001a\u00020pH\u0002JN\u0010\u0096\u0001\u001a\u00030\u0082\u00012\b\u0010\u0097\u0001\u001a\u00030\u0098\u00012.\u0010\u0099\u0001\u001a)\b\u0001\u0012\u0005\u0012\u00030\u009b\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u0082\u00010\u009c\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u009d\u00010\u009a\u0001¢\u0006\u0003\b\u009e\u0001H\u0096@ø\u0001\u0000¢\u0006\u0003\u0010\u009f\u0001J(\u0010 \u0001\u001a\u00030\u0082\u00012\u0007\u0010\u0083\u0001\u001a\u00020\u00032\t\b\u0002\u0010\u0084\u0001\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010\u0085\u0001J$\u0010¡\u0001\u001a\u00020\u00072\b\u0010¢\u0001\u001a\u00030£\u00012\t\b\u0002\u0010¤\u0001\u001a\u00020\u0007H\u0000¢\u0006\u0003\b¥\u0001J'\u0010¦\u0001\u001a\u00030\u0082\u0001*\u00030\u009b\u00012\u0007\u0010\u0083\u0001\u001a\u00020\u00032\u0007\u0010\u0084\u0001\u001a\u00020\u0003H\u0000¢\u0006\u0003\b§\u0001R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR+\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010\u001c\u001a\u0004\b\u001e\u0010\u0018\"\u0004\b\u001f\u0010\u001aR\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020#0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020%X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001b\u0010*\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b+\u0010,R\u001b\u0010/\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b1\u0010.\u001a\u0004\b0\u0010,R\u0011\u00102\u001a\u0002038F¢\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u00106\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u0018R\u001a\u00107\u001a\u00020\u0015X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0018\"\u0004\b9\u0010\u001aR\u0014\u0010:\u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b;\u0010,R\u0014\u0010<\u001a\u00020=X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0011\u0010@\u001a\u00020A8F¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0014\u0010D\u001a\b\u0012\u0004\u0012\u00020A0EX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010F\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010,\"\u0004\bH\u0010IR\u0014\u0010J\u001a\u00020KX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u001b\u0010N\u001a\u00020O8@X\u0080\u0084\u0002¢\u0006\f\u001a\u0004\bR\u0010S*\u0004\bP\u0010QR\u0014\u0010T\u001a\u00020UX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0014\u0010X\u001a\u00020YX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u000e\u0010\\\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010]\u001a\u00020^X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010`R\u001a\u0010a\u001a\u00020\u0015X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u0018\"\u0004\bc\u0010\u001aR\"\u0010e\u001a\u0004\u0018\u00010d2\b\u0010\u0014\u001a\u0004\u0018\u00010d@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bf\u0010gR\u0014\u0010h\u001a\u00020iX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010kR\u0014\u0010l\u001a\u00020mX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bn\u0010oR\u001e\u0010q\u001a\u00020p2\u0006\u0010\u0014\u001a\u00020p@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\br\u0010sR\u000e\u0010t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010u\u001a\u0004\u0018\u00010vX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\u001d\u0010{\u001a\u0004\u0018\u00010|X\u0080\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006©\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "initialFirstVisibleItemIndex", "", "initialFirstVisibleItemOffset", "(II)V", "initialFirstVisibleItems", "", "initialFirstVisibleOffsets", "([I[I)V", "animateScrollScope", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridAnimateScrollScope;", "awaitLayoutModifier", "Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "getAwaitLayoutModifier$foundation_release", "()Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "getBeyondBoundsInfo$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "<set-?>", "", "canScrollBackward", "getCanScrollBackward", "()Z", "setCanScrollBackward", "(Z)V", "canScrollBackward$delegate", "Landroidx/compose/runtime/MutableState;", "canScrollForward", "getCanScrollForward", "setCanScrollForward", "canScrollForward$delegate", "currentItemPrefetchHandles", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity$foundation_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$foundation_release", "(Landroidx/compose/ui/unit/Density;)V", "firstVisibleItemIndex", "getFirstVisibleItemIndex", "()I", "firstVisibleItemIndex$delegate", "Landroidx/compose/runtime/State;", "firstVisibleItemScrollOffset", "getFirstVisibleItemScrollOffset", "firstVisibleItemScrollOffset$delegate", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "isScrollInProgress", "isVertical", "isVertical$foundation_release", "setVertical$foundation_release", "laneCount", "getLaneCount$foundation_release", "laneInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo;", "getLaneInfo$foundation_release", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo;", "layoutInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "layoutInfoState", "Landroidx/compose/runtime/MutableState;", "measurePassCount", "getMeasurePassCount$foundation_release", "setMeasurePassCount$foundation_release", "(I)V", "mutableInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getMutableInteractionSource$foundation_release", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "nearestRange", "Lkotlin/ranges/IntRange;", "getNearestRange$foundation_release$delegate", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;)Ljava/lang/Object;", "getNearestRange$foundation_release", "()Lkotlin/ranges/IntRange;", "pinnedItems", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "getPinnedItems$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "placementAnimator", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemPlacementAnimator;", "getPlacementAnimator$foundation_release", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemPlacementAnimator;", "prefetchBaseIndex", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "getPrefetchState$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "prefetchingEnabled", "getPrefetchingEnabled$foundation_release", "setPrefetchingEnabled$foundation_release", "Landroidx/compose/ui/layout/Remeasurement;", "remeasurement", "getRemeasurement$foundation_release", "()Landroidx/compose/ui/layout/Remeasurement;", "remeasurementModifier", "Landroidx/compose/ui/layout/RemeasurementModifier;", "getRemeasurementModifier$foundation_release", "()Landroidx/compose/ui/layout/RemeasurementModifier;", "scrollPosition", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScrollPosition;", "getScrollPosition$foundation_release", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScrollPosition;", "", "scrollToBeConsumed", "getScrollToBeConsumed$foundation_release", "()F", "scrollableState", "slots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "getSlots$foundation_release", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "setSlots$foundation_release", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;)V", "spanProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpanProvider;", "getSpanProvider$foundation_release", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpanProvider;", "setSpanProvider$foundation_release", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpanProvider;)V", "animateScrollToItem", "", "index", "scrollOffset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyMeasureResult", "result", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "applyMeasureResult$foundation_release", "cancelPrefetchIfVisibleItemsChanged", "info", "clearLeftoverPrefetchHandles", "prefetchHandlesUsed", "", "dispatchRawDelta", "delta", "fillNearestIndices", "itemIndex", "notifyPrefetch", "onScroll", "distance", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollToItem", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "firstItemIndex", "updateScrollPositionIfTheFirstItemWasMoved$foundation_release", "snapToItemInternal", "snapToItemInternal$foundation_release", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyStaggeredGridState implements ScrollableState {
    private final LazyStaggeredGridAnimateScrollScope animateScrollScope;
    private final AwaitFirstLayoutModifier awaitLayoutModifier;
    private final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;

    /* renamed from: canScrollBackward$delegate, reason: from kotlin metadata */
    private final MutableState canScrollBackward;

    /* renamed from: canScrollForward$delegate, reason: from kotlin metadata */
    private final MutableState canScrollForward;
    private final Map<Integer, LazyLayoutPrefetchState.PrefetchHandle> currentItemPrefetchHandles;
    private Density density;

    /* renamed from: firstVisibleItemIndex$delegate, reason: from kotlin metadata */
    private final State firstVisibleItemIndex;

    /* renamed from: firstVisibleItemScrollOffset$delegate, reason: from kotlin metadata */
    private final State firstVisibleItemScrollOffset;
    private boolean isVertical;
    private final LazyStaggeredGridLaneInfo laneInfo;
    private final MutableState<LazyStaggeredGridLayoutInfo> layoutInfoState;
    private int measurePassCount;
    private final MutableInteractionSource mutableInteractionSource;
    private final LazyLayoutPinnedItemList pinnedItems;
    private final LazyStaggeredGridItemPlacementAnimator placementAnimator;
    private int prefetchBaseIndex;
    private final LazyLayoutPrefetchState prefetchState;
    private boolean prefetchingEnabled;
    private Remeasurement remeasurement;
    private final RemeasurementModifier remeasurementModifier;
    private final LazyStaggeredGridScrollPosition scrollPosition;
    private float scrollToBeConsumed;
    private final ScrollableState scrollableState;
    private LazyStaggeredGridSlots slots;
    private LazyStaggeredGridSpanProvider spanProvider;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Saver<LazyStaggeredGridState, Object> Saver = ListSaverKt.listSaver(new Function2<SaverScope, LazyStaggeredGridState, List<? extends int[]>>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        public final List<int[]> invoke(SaverScope listSaver, LazyStaggeredGridState state) {
            Intrinsics.checkNotNullParameter(listSaver, "$this$listSaver");
            Intrinsics.checkNotNullParameter(state, "state");
            return CollectionsKt.listOf((Object[]) new int[][]{state.getScrollPosition().getIndices(), state.getScrollPosition().getOffsets()});
        }
    }, new Function1<List<? extends int[]>, LazyStaggeredGridState>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$Companion$Saver$2
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ LazyStaggeredGridState invoke(List<? extends int[]> list) {
            return invoke2((List<int[]>) list);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final LazyStaggeredGridState invoke2(List<int[]> it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new LazyStaggeredGridState(it.get(0), it.get(1), null);
        }
    });

    public /* synthetic */ LazyStaggeredGridState(int[] iArr, int[] iArr2, DefaultConstructorMarker defaultConstructorMarker) {
        this(iArr, iArr2);
    }

    private LazyStaggeredGridState(int[] initialFirstVisibleItems, int[] initialFirstVisibleOffsets) {
        MutableState<LazyStaggeredGridLayoutInfo> mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        this.firstVisibleItemIndex = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<Integer>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$firstVisibleItemIndex$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.collections.IntIterator] */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                Integer num;
                int[] indices = LazyStaggeredGridState.this.getScrollPosition().getIndices();
                if (indices.length == 0) {
                    num = null;
                } else {
                    int it = indices[0];
                    if (it == -1) {
                        it = 0;
                    }
                    Integer valueOf = Integer.valueOf(it);
                    ?? it2 = new IntRange(1, ArraysKt.getLastIndex(indices)).iterator();
                    while (it2.hasNext()) {
                        int it3 = indices[it2.nextInt()];
                        if (it3 == -1) {
                            it3 = 0;
                        }
                        Integer valueOf2 = Integer.valueOf(it3);
                        if (valueOf.compareTo(valueOf2) > 0) {
                            valueOf = valueOf2;
                        }
                    }
                    num = valueOf;
                }
                Integer num2 = num;
                return Integer.valueOf(num2 != null ? num2.intValue() : 0);
            }
        });
        this.firstVisibleItemScrollOffset = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<Integer>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$firstVisibleItemScrollOffset$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                int[] offsets = LazyStaggeredGridState.this.getScrollPosition().getOffsets();
                LazyStaggeredGridState lazyStaggeredGridState = LazyStaggeredGridState.this;
                int firstVisibleIndex = lazyStaggeredGridState.getFirstVisibleItemIndex();
                int[] indices = lazyStaggeredGridState.getScrollPosition().getIndices();
                int minOffset = Integer.MAX_VALUE;
                int length = offsets.length;
                for (int lane = 0; lane < length; lane++) {
                    if (indices[lane] == firstVisibleIndex) {
                        minOffset = Math.min(minOffset, offsets[lane]);
                    }
                }
                if (minOffset == Integer.MAX_VALUE) {
                    minOffset = 0;
                }
                return Integer.valueOf(minOffset);
            }
        });
        this.scrollPosition = new LazyStaggeredGridScrollPosition(initialFirstVisibleItems, initialFirstVisibleOffsets, new LazyStaggeredGridState$scrollPosition$1(this));
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(EmptyLazyStaggeredGridLayoutInfo.INSTANCE, null, 2, null);
        this.layoutInfoState = mutableStateOf$default;
        this.laneInfo = new LazyStaggeredGridLaneInfo();
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.canScrollForward = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.canScrollBackward = mutableStateOf$default3;
        this.animateScrollScope = new LazyStaggeredGridAnimateScrollScope(this);
        this.remeasurementModifier = new RemeasurementModifier() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$remeasurementModifier$1
            @Override // androidx.compose.ui.layout.RemeasurementModifier
            public void onRemeasurementAvailable(Remeasurement remeasurement) {
                Intrinsics.checkNotNullParameter(remeasurement, "remeasurement");
                LazyStaggeredGridState.this.remeasurement = remeasurement;
            }
        };
        this.awaitLayoutModifier = new AwaitFirstLayoutModifier();
        this.beyondBoundsInfo = new LazyLayoutBeyondBoundsInfo();
        this.prefetchingEnabled = true;
        this.prefetchState = new LazyLayoutPrefetchState();
        this.scrollableState = ScrollableStateKt.ScrollableState(new Function1<Float, Float>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$scrollableState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final Float invoke(float it) {
                float onScroll;
                onScroll = LazyStaggeredGridState.this.onScroll(-it);
                return Float.valueOf(-onScroll);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Float invoke(Float f) {
                return invoke(f.floatValue());
            }
        });
        this.prefetchBaseIndex = -1;
        this.currentItemPrefetchHandles = new LinkedHashMap();
        this.density = DensityKt.Density(1.0f, 1.0f);
        this.mutableInteractionSource = InteractionSourceKt.MutableInteractionSource();
        this.pinnedItems = new LazyLayoutPinnedItemList();
        this.placementAnimator = new LazyStaggeredGridItemPlacementAnimator();
        this.scrollPosition.getNearestRangeState();
    }

    public /* synthetic */ LazyStaggeredGridState(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public LazyStaggeredGridState(int initialFirstVisibleItemIndex, int initialFirstVisibleItemOffset) {
        this(new int[]{initialFirstVisibleItemIndex}, new int[]{initialFirstVisibleItemOffset});
    }

    public final int getFirstVisibleItemIndex() {
        State $this$getValue$iv = this.firstVisibleItemIndex;
        return ((Number) $this$getValue$iv.getValue()).intValue();
    }

    public final int getFirstVisibleItemScrollOffset() {
        State $this$getValue$iv = this.firstVisibleItemScrollOffset;
        return ((Number) $this$getValue$iv.getValue()).intValue();
    }

    /* renamed from: getScrollPosition$foundation_release, reason: from getter */
    public final LazyStaggeredGridScrollPosition getScrollPosition() {
        return this.scrollPosition;
    }

    public final LazyStaggeredGridLayoutInfo getLayoutInfo() {
        return this.layoutInfoState.getValue();
    }

    /* renamed from: getLaneInfo$foundation_release, reason: from getter */
    public final LazyStaggeredGridLaneInfo getLaneInfo() {
        return this.laneInfo;
    }

    private void setCanScrollForward(boolean z) {
        MutableState $this$setValue$iv = this.canScrollForward;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getCanScrollForward() {
        State $this$getValue$iv = this.canScrollForward;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private void setCanScrollBackward(boolean z) {
        MutableState $this$setValue$iv = this.canScrollBackward;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getCanScrollBackward() {
        State $this$getValue$iv = this.canScrollBackward;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* renamed from: getRemeasurement$foundation_release, reason: from getter */
    public final Remeasurement getRemeasurement() {
        return this.remeasurement;
    }

    /* renamed from: getRemeasurementModifier$foundation_release, reason: from getter */
    public final RemeasurementModifier getRemeasurementModifier() {
        return this.remeasurementModifier;
    }

    /* renamed from: getAwaitLayoutModifier$foundation_release, reason: from getter */
    public final AwaitFirstLayoutModifier getAwaitLayoutModifier() {
        return this.awaitLayoutModifier;
    }

    /* renamed from: getBeyondBoundsInfo$foundation_release, reason: from getter */
    public final LazyLayoutBeyondBoundsInfo getBeyondBoundsInfo() {
        return this.beyondBoundsInfo;
    }

    /* renamed from: getPrefetchingEnabled$foundation_release, reason: from getter */
    public final boolean getPrefetchingEnabled() {
        return this.prefetchingEnabled;
    }

    public final void setPrefetchingEnabled$foundation_release(boolean z) {
        this.prefetchingEnabled = z;
    }

    /* renamed from: getPrefetchState$foundation_release, reason: from getter */
    public final LazyLayoutPrefetchState getPrefetchState() {
        return this.prefetchState;
    }

    /* renamed from: getScrollToBeConsumed$foundation_release, reason: from getter */
    public final float getScrollToBeConsumed() {
        return this.scrollToBeConsumed;
    }

    /* renamed from: getMeasurePassCount$foundation_release, reason: from getter */
    public final int getMeasurePassCount() {
        return this.measurePassCount;
    }

    public final void setMeasurePassCount$foundation_release(int i) {
        this.measurePassCount = i;
    }

    /* renamed from: isVertical$foundation_release, reason: from getter */
    public final boolean getIsVertical() {
        return this.isVertical;
    }

    public final void setVertical$foundation_release(boolean z) {
        this.isVertical = z;
    }

    /* renamed from: getSlots$foundation_release, reason: from getter */
    public final LazyStaggeredGridSlots getSlots() {
        return this.slots;
    }

    public final void setSlots$foundation_release(LazyStaggeredGridSlots lazyStaggeredGridSlots) {
        this.slots = lazyStaggeredGridSlots;
    }

    /* renamed from: getSpanProvider$foundation_release, reason: from getter */
    public final LazyStaggeredGridSpanProvider getSpanProvider() {
        return this.spanProvider;
    }

    public final void setSpanProvider$foundation_release(LazyStaggeredGridSpanProvider lazyStaggeredGridSpanProvider) {
        this.spanProvider = lazyStaggeredGridSpanProvider;
    }

    /* renamed from: getDensity$foundation_release, reason: from getter */
    public final Density getDensity() {
        return this.density;
    }

    public final void setDensity$foundation_release(Density density) {
        Intrinsics.checkNotNullParameter(density, "<set-?>");
        this.density = density;
    }

    public final int getLaneCount$foundation_release() {
        int[] sizes;
        LazyStaggeredGridSlots lazyStaggeredGridSlots = this.slots;
        if (lazyStaggeredGridSlots == null || (sizes = lazyStaggeredGridSlots.getSizes()) == null) {
            return 0;
        }
        return sizes.length;
    }

    public final InteractionSource getInteractionSource() {
        return this.mutableInteractionSource;
    }

    /* renamed from: getMutableInteractionSource$foundation_release, reason: from getter */
    public final MutableInteractionSource getMutableInteractionSource() {
        return this.mutableInteractionSource;
    }

    /* renamed from: getPinnedItems$foundation_release, reason: from getter */
    public final LazyLayoutPinnedItemList getPinnedItems() {
        return this.pinnedItems;
    }

    /* renamed from: getPlacementAnimator$foundation_release, reason: from getter */
    public final LazyStaggeredGridItemPlacementAnimator getPlacementAnimator() {
        return this.placementAnimator;
    }

    public final IntRange getNearestRange$foundation_release() {
        State $this$getValue$iv = this.scrollPosition.getNearestRangeState();
        return $this$getValue$iv.getValue();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0022. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // androidx.compose.foundation.gestures.ScrollableState
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object scroll(androidx.compose.foundation.MutatePriority r7, kotlin.jvm.functions.Function2<? super androidx.compose.foundation.gestures.ScrollScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$scroll$1
            if (r0 == 0) goto L14
            r0 = r9
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$scroll$1 r0 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$scroll$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$scroll$1 r0 = new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$scroll$1
            r0.<init>(r6, r9)
        L19:
            r9 = r0
            java.lang.Object r0 = r9.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r9.label
            switch(r2) {
                case 0: goto L41;
                case 1: goto L31;
                case 2: goto L2d;
                default: goto L25;
            }
        L25:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L2d:
            kotlin.ResultKt.throwOnFailure(r0)
            goto L6d
        L31:
            java.lang.Object r7 = r9.L$2
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r8 = r9.L$1
            androidx.compose.foundation.MutatePriority r8 = (androidx.compose.foundation.MutatePriority) r8
            java.lang.Object r2 = r9.L$0
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r2 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState) r2
            kotlin.ResultKt.throwOnFailure(r0)
            goto L5a
        L41:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r6
            androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier r3 = r2.awaitLayoutModifier
            r9.L$0 = r2
            r9.L$1 = r7
            r9.L$2 = r8
            r4 = 1
            r9.label = r4
            java.lang.Object r3 = r3.waitForFirstLayout(r9)
            if (r3 != r1) goto L57
            return r1
        L57:
            r5 = r8
            r8 = r7
            r7 = r5
        L5a:
            androidx.compose.foundation.gestures.ScrollableState r3 = r2.scrollableState
            r4 = 0
            r9.L$0 = r4
            r9.L$1 = r4
            r9.L$2 = r4
            r4 = 2
            r9.label = r4
            java.lang.Object r7 = r3.scroll(r8, r7, r9)
            if (r7 != r1) goto L6d
            return r1
        L6d:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState.scroll(androidx.compose.foundation.MutatePriority, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float onScroll(float distance) {
        if ((distance < 0.0f && !getCanScrollForward()) || (distance > 0.0f && !getCanScrollBackward())) {
            return 0.0f;
        }
        if (!(Math.abs(this.scrollToBeConsumed) <= 0.5f)) {
            throw new IllegalStateException(("entered drag with non-zero pending scroll: " + this.scrollToBeConsumed).toString());
        }
        this.scrollToBeConsumed += distance;
        if (Math.abs(this.scrollToBeConsumed) > 0.5f) {
            float preScrollToBeConsumed = this.scrollToBeConsumed;
            Remeasurement remeasurement = this.remeasurement;
            if (remeasurement != null) {
                remeasurement.forceRemeasure();
            }
            if (this.prefetchingEnabled) {
                notifyPrefetch(preScrollToBeConsumed - this.scrollToBeConsumed);
            }
        }
        float preScrollToBeConsumed2 = this.scrollToBeConsumed;
        if (Math.abs(preScrollToBeConsumed2) <= 0.5f) {
            return distance;
        }
        float scrollConsumed = distance - this.scrollToBeConsumed;
        this.scrollToBeConsumed = 0.0f;
        return scrollConsumed;
    }

    public static /* synthetic */ Object scrollToItem$default(LazyStaggeredGridState lazyStaggeredGridState, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return lazyStaggeredGridState.scrollToItem(i, i2, continuation);
    }

    public final Object scrollToItem(int index, int scrollOffset, Continuation<? super Unit> continuation) {
        Object scroll$default = ScrollableState.scroll$default(this, null, new LazyStaggeredGridState$scrollToItem$2(this, index, scrollOffset, null), continuation, 1, null);
        return scroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateScrollToItem$default(LazyStaggeredGridState lazyStaggeredGridState, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return lazyStaggeredGridState.animateScrollToItem(i, i2, continuation);
    }

    public final Object animateScrollToItem(int index, int scrollOffset, Continuation<? super Unit> continuation) {
        Object animateScrollToItem = LazyAnimateScrollKt.animateScrollToItem(this.animateScrollScope, index, scrollOffset, continuation);
        return animateScrollToItem == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollToItem : Unit.INSTANCE;
    }

    public final void snapToItemInternal$foundation_release(ScrollScope $this$snapToItemInternal, int index, int scrollOffset) {
        Intrinsics.checkNotNullParameter($this$snapToItemInternal, "<this>");
        LazyStaggeredGridItemInfo visibleItem = LazyStaggeredGridMeasureResultKt.findVisibleItem(getLayoutInfo(), index);
        if (visibleItem != null) {
            int currentOffset = this.isVertical ? IntOffset.m5337getYimpl(visibleItem.getOffset()) : IntOffset.m5336getXimpl(visibleItem.getOffset());
            int delta = currentOffset + scrollOffset;
            $this$snapToItemInternal.scrollBy(delta);
        } else {
            this.scrollPosition.requestPosition(index, scrollOffset);
            Remeasurement remeasurement = this.remeasurement;
            if (remeasurement != null) {
                remeasurement.forceRemeasure();
            }
        }
    }

    public static /* synthetic */ int[] updateScrollPositionIfTheFirstItemWasMoved$foundation_release$default(LazyStaggeredGridState lazyStaggeredGridState, LazyLayoutItemProvider lazyLayoutItemProvider, int[] iArr, int i, Object obj) {
        if ((i & 2) != 0) {
            Snapshot.Companion this_$iv = Snapshot.INSTANCE;
            Snapshot snapshot$iv = this_$iv.createNonObservableSnapshot();
            try {
                Snapshot previous$iv$iv = snapshot$iv.makeCurrent();
                try {
                    int[] indices = lazyStaggeredGridState.scrollPosition.getIndices();
                    snapshot$iv.dispose();
                    iArr = indices;
                } finally {
                    snapshot$iv.restoreCurrent(previous$iv$iv);
                }
            } catch (Throwable th) {
                snapshot$iv.dispose();
                throw th;
            }
        }
        return lazyStaggeredGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyLayoutItemProvider, iArr);
    }

    public final int[] updateScrollPositionIfTheFirstItemWasMoved$foundation_release(LazyLayoutItemProvider itemProvider, int[] firstItemIndex) {
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(firstItemIndex, "firstItemIndex");
        return this.scrollPosition.updateScrollPositionIfTheFirstItemWasMoved(itemProvider, firstItemIndex);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float dispatchRawDelta(float delta) {
        return this.scrollableState.dispatchRawDelta(delta);
    }

    private final void notifyPrefetch(float delta) {
        int prefetchIndex;
        int findPreviousItemIndex;
        int start;
        long m5183fixedHeightOenEA2s;
        LazyStaggeredGridLayoutInfo info;
        int i;
        LazyStaggeredGridLayoutInfo info2 = this.layoutInfoState.getValue();
        int i2 = 1;
        if (!info2.getVisibleItemsInfo().isEmpty()) {
            boolean scrollingForward = delta < 0.0f;
            if (scrollingForward) {
                prefetchIndex = ((LazyStaggeredGridItemInfo) CollectionsKt.last((List) info2.getVisibleItemsInfo())).getIndex();
            } else {
                prefetchIndex = ((LazyStaggeredGridItemInfo) CollectionsKt.first((List) info2.getVisibleItemsInfo())).getIndex();
            }
            if (prefetchIndex == this.prefetchBaseIndex) {
                return;
            }
            this.prefetchBaseIndex = prefetchIndex;
            Set prefetchHandlesUsed = new LinkedHashSet();
            int targetIndex = prefetchIndex;
            int lane = 0;
            int laneCount$foundation_release = getLaneCount$foundation_release();
            while (lane < laneCount$foundation_release) {
                int previousIndex = targetIndex;
                if (scrollingForward) {
                    findPreviousItemIndex = this.laneInfo.findNextItemIndex(previousIndex, lane);
                } else {
                    findPreviousItemIndex = this.laneInfo.findPreviousItemIndex(previousIndex, lane);
                }
                targetIndex = findPreviousItemIndex;
                if (((targetIndex < 0 || targetIndex >= info2.getTotalItemsCount()) ? 0 : i2) != 0 && !prefetchHandlesUsed.contains(Integer.valueOf(targetIndex))) {
                    prefetchHandlesUsed.add(Integer.valueOf(targetIndex));
                    if (this.currentItemPrefetchHandles.containsKey(Integer.valueOf(targetIndex))) {
                        info = info2;
                        i = laneCount$foundation_release;
                    } else {
                        LazyStaggeredGridSpanProvider lazyStaggeredGridSpanProvider = this.spanProvider;
                        int i3 = (lazyStaggeredGridSpanProvider == null || lazyStaggeredGridSpanProvider.isFullSpan(targetIndex) != i2) ? 0 : i2;
                        int slot = i3 != 0 ? 0 : lane;
                        int span = i3 != 0 ? getLaneCount$foundation_release() : i2;
                        LazyStaggeredGridSlots slots = this.slots;
                        if (slots == null) {
                            start = 0;
                        } else if (span == i2) {
                            start = slots.getSizes()[slot];
                        } else {
                            int start2 = slots.getPositions()[slot];
                            int endSlot = (slot + span) - 1;
                            int end = slots.getPositions()[endSlot] + slots.getSizes()[endSlot];
                            start = end - start2;
                        }
                        if (this.isVertical) {
                            m5183fixedHeightOenEA2s = Constraints.INSTANCE.m5184fixedWidthOenEA2s(start);
                        } else {
                            m5183fixedHeightOenEA2s = Constraints.INSTANCE.m5183fixedHeightOenEA2s(start);
                        }
                        long constraints = m5183fixedHeightOenEA2s;
                        info = info2;
                        i = laneCount$foundation_release;
                        this.currentItemPrefetchHandles.put(Integer.valueOf(targetIndex), this.prefetchState.m643schedulePrefetch0kLqBqw(targetIndex, constraints));
                    }
                    lane++;
                    info2 = info;
                    laneCount$foundation_release = i;
                    i2 = 1;
                }
            }
            clearLeftoverPrefetchHandles(prefetchHandlesUsed);
        }
    }

    private final void clearLeftoverPrefetchHandles(Set<Integer> prefetchHandlesUsed) {
        Iterator iterator = this.currentItemPrefetchHandles.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, LazyLayoutPrefetchState.PrefetchHandle> entry = iterator.next();
            if (!prefetchHandlesUsed.contains(entry.getKey())) {
                entry.getValue().cancel();
                iterator.remove();
            }
        }
    }

    private final void cancelPrefetchIfVisibleItemsChanged(LazyStaggeredGridLayoutInfo info) {
        List items = info.getVisibleItemsInfo();
        if (this.prefetchBaseIndex != -1) {
            if (!items.isEmpty()) {
                int index = ((LazyStaggeredGridItemInfo) CollectionsKt.first(items)).getIndex();
                int index2 = ((LazyStaggeredGridItemInfo) CollectionsKt.last(items)).getIndex();
                int i = this.prefetchBaseIndex;
                if (!(index <= i && i <= index2)) {
                    this.prefetchBaseIndex = -1;
                    Iterable $this$forEach$iv = this.currentItemPrefetchHandles.values();
                    for (Object element$iv : $this$forEach$iv) {
                        LazyLayoutPrefetchState.PrefetchHandle it = (LazyLayoutPrefetchState.PrefetchHandle) element$iv;
                        it.cancel();
                    }
                    this.currentItemPrefetchHandles.clear();
                }
            }
        }
    }

    public final void applyMeasureResult$foundation_release(LazyStaggeredGridMeasureResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.scrollToBeConsumed -= result.getConsumedScroll();
        setCanScrollBackward(result.getCanScrollBackward());
        setCanScrollForward(result.getCanScrollForward());
        this.layoutInfoState.setValue(result);
        cancelPrefetchIfVisibleItemsChanged(result);
        this.scrollPosition.updateFromMeasureResult(result);
        this.measurePassCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000c, code lost:
    
        if (r0.isFullSpan(r12) == true) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int[] fillNearestIndices(int r12, int r13) {
        /*
            r11 = this;
            int[] r6 = new int[r13]
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSpanProvider r0 = r11.spanProvider
            r1 = 0
            if (r0 == 0) goto Lf
            boolean r0 = r0.isFullSpan(r12)
            r2 = 1
            if (r0 != r2) goto Lf
            goto L10
        Lf:
            r2 = r1
        L10:
            if (r2 == 0) goto L1c
            r4 = 6
            r5 = 0
            r2 = 0
            r3 = 0
            r0 = r6
            r1 = r12
            kotlin.collections.ArraysKt.fill$default(r0, r1, r2, r3, r4, r5)
            return r6
        L1c:
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r0 = r11.laneInfo
            int r2 = r12 + r13
            r0.ensureValidIndex(r2)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r0 = r11.laneInfo
            int r7 = r0.getLane(r12)
            r0 = -1
            if (r7 != r0) goto L2d
            goto L31
        L2d:
            int r1 = java.lang.Math.min(r7, r13)
        L31:
            r8 = r1
            r1 = r12
            int r2 = r8 + (-1)
            r9 = r1
            r10 = r2
        L37:
            if (r0 >= r10) goto L54
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r1 = r11.laneInfo
            int r1 = r1.findPreviousItemIndex(r9, r10)
            r6[r10] = r1
            r1 = r6[r10]
            if (r1 != r0) goto L4f
            r4 = 2
            r5 = 0
            r1 = -1
            r2 = 0
            r0 = r6
            r3 = r10
            kotlin.collections.ArraysKt.fill$default(r0, r1, r2, r3, r4, r5)
            goto L54
        L4f:
            r9 = r6[r10]
            int r10 = r10 + (-1)
            goto L37
        L54:
            r6[r8] = r12
            r0 = r12
            int r1 = r8 + 1
        L59:
            if (r1 >= r13) goto L68
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r2 = r11.laneInfo
            int r2 = r2.findNextItemIndex(r0, r1)
            r6[r1] = r2
            r0 = r6[r1]
            int r1 = r1 + 1
            goto L59
        L68:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState.fillNearestIndices(int, int):int[]");
    }

    /* compiled from: LazyStaggeredGridState.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<LazyStaggeredGridState, Object> getSaver() {
            return LazyStaggeredGridState.Saver;
        }
    }
}
