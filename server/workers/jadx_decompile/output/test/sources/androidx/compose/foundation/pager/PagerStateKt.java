package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPositionInLayout;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PagerState.kt */
@Metadata(d1 = {"\u0000M\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0018\u001a\u0017\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0082\b\u001a!\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00102\b\b\u0002\u0010\"\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010#\u001a/\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00102\b\b\u0002\u0010\"\u001a\u00020\u000e2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00100\u001dH\u0007¢\u0006\u0002\u0010%\u001a\u0015\u0010&\u001a\u00020\u001b*\u00020 H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010'\u001a\u0015\u0010(\u001a\u00020\u001b*\u00020 H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010'\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0019\u0010\u0002\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u001a\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0012\u001a\u00020\u0013X\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\u0016\"\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"DEBUG", "", "DefaultPositionThreshold", "Landroidx/compose/ui/unit/Dp;", "getDefaultPositionThreshold", "()F", "F", "EmptyLayoutInfo", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "getEmptyLayoutInfo$annotations", "()V", "getEmptyLayoutInfo", "()Landroidx/compose/foundation/pager/PagerLayoutInfo;", "MaxPageOffset", "", "MaxPagesForAnimateScroll", "", "MinPageOffset", "SnapAlignmentStartToStart", "Landroidx/compose/foundation/gestures/snapping/SnapPositionInLayout;", "getSnapAlignmentStartToStart$annotations", "getSnapAlignmentStartToStart", "()Landroidx/compose/foundation/gestures/snapping/SnapPositionInLayout;", "UnitDensity", "androidx/compose/foundation/pager/PagerStateKt$UnitDensity$1", "Landroidx/compose/foundation/pager/PagerStateKt$UnitDensity$1;", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "rememberPagerState", "Landroidx/compose/foundation/pager/PagerState;", "initialPage", "initialPageOffsetFraction", "(IFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/pager/PagerState;", "pageCount", "(IFLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/pager/PagerState;", "animateToNextPage", "(Landroidx/compose/foundation/pager/PagerState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateToPreviousPage", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PagerStateKt {
    private static final boolean DEBUG = false;
    private static final float MaxPageOffset = 0.5f;
    private static final int MaxPagesForAnimateScroll = 3;
    private static final float MinPageOffset = -0.5f;
    private static final float DefaultPositionThreshold = Dp.m5218constructorimpl(56);
    private static final PagerLayoutInfo EmptyLayoutInfo = new PagerLayoutInfo() { // from class: androidx.compose.foundation.pager.PagerStateKt$EmptyLayoutInfo$1
        private final int afterContentPadding;
        private final int beforeContentPadding;
        private final PageInfo closestPageToSnapPosition;
        private final int pageSize;
        private final int pageSpacing;
        private final int pagesCount;
        private final boolean reverseLayout;
        private final int viewportEndOffset;
        private final int viewportStartOffset;
        private final List<PageInfo> visiblePagesInfo = CollectionsKt.emptyList();
        private final long viewportSize = IntSize.INSTANCE.m5383getZeroYbymL2g();
        private final Orientation orientation = Orientation.Horizontal;

        @Override // androidx.compose.foundation.pager.PagerLayoutInfo
        public List<PageInfo> getVisiblePagesInfo() {
            return this.visiblePagesInfo;
        }

        @Override // androidx.compose.foundation.pager.PagerLayoutInfo
        public PageInfo getClosestPageToSnapPosition() {
            return this.closestPageToSnapPosition;
        }

        @Override // androidx.compose.foundation.pager.PagerLayoutInfo
        public int getPagesCount() {
            return this.pagesCount;
        }

        @Override // androidx.compose.foundation.pager.PagerLayoutInfo
        public int getPageSize() {
            return this.pageSize;
        }

        @Override // androidx.compose.foundation.pager.PagerLayoutInfo
        public int getPageSpacing() {
            return this.pageSpacing;
        }

        @Override // androidx.compose.foundation.pager.PagerLayoutInfo
        public int getBeforeContentPadding() {
            return this.beforeContentPadding;
        }

        @Override // androidx.compose.foundation.pager.PagerLayoutInfo
        public int getAfterContentPadding() {
            return this.afterContentPadding;
        }

        @Override // androidx.compose.foundation.pager.PagerLayoutInfo
        /* renamed from: getViewportSize-YbymL2g, reason: from getter */
        public long getViewportSize() {
            return this.viewportSize;
        }

        @Override // androidx.compose.foundation.pager.PagerLayoutInfo
        public Orientation getOrientation() {
            return this.orientation;
        }

        @Override // androidx.compose.foundation.pager.PagerLayoutInfo
        public int getViewportStartOffset() {
            return this.viewportStartOffset;
        }

        @Override // androidx.compose.foundation.pager.PagerLayoutInfo
        public int getViewportEndOffset() {
            return this.viewportEndOffset;
        }

        @Override // androidx.compose.foundation.pager.PagerLayoutInfo
        public boolean getReverseLayout() {
            return this.reverseLayout;
        }
    };
    private static final PagerStateKt$UnitDensity$1 UnitDensity = new Density() { // from class: androidx.compose.foundation.pager.PagerStateKt$UnitDensity$1
        private final float density = 1.0f;
        private final float fontScale = 1.0f;

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return this.density;
        }

        @Override // androidx.compose.ui.unit.Density
        public float getFontScale() {
            return this.fontScale;
        }
    };
    private static final SnapPositionInLayout SnapAlignmentStartToStart = new SnapPositionInLayout() { // from class: androidx.compose.foundation.pager.PagerStateKt$SnapAlignmentStartToStart$1
        @Override // androidx.compose.foundation.gestures.snapping.SnapPositionInLayout
        public final int position(Density SnapPositionInLayout, int i, int i2, int i3) {
            Intrinsics.checkNotNullParameter(SnapPositionInLayout, "$this$SnapPositionInLayout");
            return 0;
        }
    };

    public static /* synthetic */ void getEmptyLayoutInfo$annotations() {
    }

    public static /* synthetic */ void getSnapAlignmentStartToStart$annotations() {
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.foundation.pager.PagerState rememberPagerState(int r17, float r18, final kotlin.jvm.functions.Function0<java.lang.Integer> r19, androidx.compose.runtime.Composer r20, int r21, int r22) {
        /*
            r0 = r19
            r8 = r20
            r9 = r21
            java.lang.String r1 = "pageCount"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r1 = -1210768637(0xffffffffb7d52303, float:-2.5407882E-5)
            r8.startReplaceableGroup(r1)
            java.lang.String r2 = "C(rememberPagerState)*78@3520L127,78@3473L174:PagerState.kt#g6yjnt"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r2)
            r2 = r22 & 1
            if (r2 == 0) goto L1e
            r2 = 0
            r10 = r2
            goto L20
        L1e:
            r10 = r17
        L20:
            r2 = r22 & 2
            if (r2 == 0) goto L27
            r2 = 0
            r11 = r2
            goto L29
        L27:
            r11 = r18
        L29:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L35
            r2 = -1
            java.lang.String r3 = "androidx.compose.foundation.pager.rememberPagerState (PagerState.kt:73)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r9, r2, r3)
        L35:
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            androidx.compose.foundation.pager.PagerStateImpl$Companion r2 = androidx.compose.foundation.pager.PagerStateImpl.INSTANCE
            androidx.compose.runtime.saveable.Saver r2 = r2.getSaver()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r10)
            java.lang.Float r4 = java.lang.Float.valueOf(r11)
            r5 = r9 & 14
            r6 = r9 & 112(0x70, float:1.57E-43)
            r5 = r5 | r6
            r6 = r9 & 896(0x380, float:1.256E-42)
            r5 = r5 | r6
            r6 = 0
            r7 = 1618982084(0x607fb4c4, float:7.370227E19)
            r8.startReplaceableGroup(r7)
            java.lang.String r7 = "CC(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r7)
            boolean r7 = r8.changed(r3)
            boolean r12 = r8.changed(r4)
            r7 = r7 | r12
            boolean r12 = r8.changed(r0)
            r7 = r7 | r12
            r12 = r20
            r13 = 0
            java.lang.Object r14 = r12.rememberedValue()
            r15 = 0
            if (r7 != 0) goto L80
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.INSTANCE
            r17 = r3
            java.lang.Object r3 = r16.getEmpty()
            if (r14 != r3) goto L7e
            goto L82
        L7e:
            r3 = r14
            goto L91
        L80:
            r17 = r3
        L82:
            r3 = 0
            r18 = r3
            androidx.compose.foundation.pager.PagerStateKt$rememberPagerState$1$1 r3 = new androidx.compose.foundation.pager.PagerStateKt$rememberPagerState$1$1
            r3.<init>()
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r12.updateRememberedValue(r3)
        L91:
            r20.endReplaceableGroup()
            r4 = r3
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r3 = 0
            r6 = 72
            r7 = 4
            r5 = r20
            java.lang.Object r1 = androidx.compose.runtime.saveable.RememberSaveableKt.m2596rememberSaveable(r1, r2, r3, r4, r5, r6, r7)
            r2 = r1
            androidx.compose.foundation.pager.PagerStateImpl r2 = (androidx.compose.foundation.pager.PagerStateImpl) r2
            r3 = 0
            androidx.compose.runtime.MutableState r4 = r2.getPageCountState()
            r4.setValue(r0)
            androidx.compose.foundation.pager.PagerStateImpl r1 = (androidx.compose.foundation.pager.PagerStateImpl) r1
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto Lba
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        Lba:
            r20.endReplaceableGroup()
            androidx.compose.foundation.pager.PagerState r1 = (androidx.compose.foundation.pager.PagerState) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerStateKt.rememberPagerState(int, float, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):androidx.compose.foundation.pager.PagerState");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Please use the overload where you can provide a source of truth for the pageCount.", replaceWith = @ReplaceWith(expression = "rememberPagerState(\n                initialPage = initialPage,\n                initialPageOffsetFraction = initialPageOffsetFraction\n            ){\n                // provide pageCount\n            }", imports = {}))
    public static final PagerState rememberPagerState(int initialPage, float initialPageOffsetFraction, Composer $composer, int $changed, int i) {
        final float initialPageOffsetFraction2;
        Object key1$iv;
        $composer.startReplaceableGroup(144687223);
        ComposerKt.sourceInformation($composer, "C(rememberPagerState)117@4766L152,117@4719L199:PagerState.kt#g6yjnt");
        final int initialPage2 = (i & 1) != 0 ? 0 : initialPage;
        if ((i & 2) == 0) {
            initialPageOffsetFraction2 = initialPageOffsetFraction;
        } else {
            initialPageOffsetFraction2 = 0.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(144687223, $changed, -1, "androidx.compose.foundation.pager.rememberPagerState (PagerState.kt:113)");
        }
        Object[] objArr = new Object[0];
        Saver<PagerStateImpl, ?> saver = PagerStateImpl.INSTANCE.getSaver();
        Object key1$iv2 = Integer.valueOf(initialPage2);
        Object key2$iv = Float.valueOf(initialPageOffsetFraction2);
        int i2 = ($changed & 14) | ($changed & 112);
        $composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(key1$iv2) | $composer.changed(key2$iv);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            key1$iv = (Function0) new Function0<PagerStateImpl>() { // from class: androidx.compose.foundation.pager.PagerStateKt$rememberPagerState$3$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final PagerStateImpl invoke() {
                    return new PagerStateImpl(initialPage2, initialPageOffsetFraction2, new Function0<Integer>() { // from class: androidx.compose.foundation.pager.PagerStateKt$rememberPagerState$3$1.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Integer invoke() {
                            return 0;
                        }
                    });
                }
            };
            $composer.updateRememberedValue(key1$iv);
        } else {
            key1$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Object key2$iv2 = key1$iv;
        PagerStateImpl pagerStateImpl = (PagerStateImpl) RememberSaveableKt.m2596rememberSaveable(objArr, (Saver) saver, (String) null, (Function0) key2$iv2, $composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return pagerStateImpl;
    }

    public static final Object animateToNextPage(PagerState $this$animateToNextPage, Continuation<? super Unit> continuation) {
        Object animateScrollToPage$default;
        return ($this$animateToNextPage.getCurrentPage() + 1 >= $this$animateToNextPage.getPageCount() || (animateScrollToPage$default = PagerState.animateScrollToPage$default($this$animateToNextPage, $this$animateToNextPage.getCurrentPage() + 1, 0.0f, null, continuation, 6, null)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? Unit.INSTANCE : animateScrollToPage$default;
    }

    public static final Object animateToPreviousPage(PagerState $this$animateToPreviousPage, Continuation<? super Unit> continuation) {
        Object animateScrollToPage$default;
        return ($this$animateToPreviousPage.getCurrentPage() + (-1) < 0 || (animateScrollToPage$default = PagerState.animateScrollToPage$default($this$animateToPreviousPage, $this$animateToPreviousPage.getCurrentPage() + (-1), 0.0f, null, continuation, 6, null)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? Unit.INSTANCE : animateScrollToPage$default;
    }

    public static final float getDefaultPositionThreshold() {
        return DefaultPositionThreshold;
    }

    public static final PagerLayoutInfo getEmptyLayoutInfo() {
        return EmptyLayoutInfo;
    }

    public static final SnapPositionInLayout getSnapAlignmentStartToStart() {
        return SnapAlignmentStartToStart;
    }

    private static final void debugLog(Function0<String> function0) {
    }
}
