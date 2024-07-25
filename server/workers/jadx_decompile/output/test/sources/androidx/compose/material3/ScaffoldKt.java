package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Scaffold.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a´\u0001\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0013\b\u0002\u0010\f\u001a\r\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0002\b\u000e2\u0013\b\u0002\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0002\b\u000e2\u0013\b\u0002\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0002\b\u000e2\u0013\b\u0002\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0017\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\t0\u001a¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u008a\u0001\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u00132\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0002\b\u000e2\u0017\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\t0\u001a¢\u0006\u0002\b\u000e2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0002\b\u000e2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0002\b\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0002\b\u000eH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u001c\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"FabSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "LocalFabPlacement", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/FabPlacement;", "getLocalFabPlacement", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "Scaffold", "", "modifier", "Landroidx/compose/ui/Modifier;", "topBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "bottomBar", "snackbarHost", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material3/FabPosition;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/PaddingValues;", "Scaffold-TvnljyQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;IJJLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ScaffoldLayout", "fabPosition", "snackbar", "fab", "ScaffoldLayout-FMILGgc", "(ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ScaffoldKt {
    private static final ProvidableCompositionLocal<FabPlacement> LocalFabPlacement = CompositionLocalKt.staticCompositionLocalOf(new Function0<FabPlacement>() { // from class: androidx.compose.material3.ScaffoldKt$LocalFabPlacement$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FabPlacement invoke() {
            return null;
        }
    });
    private static final float FabSpacing = Dp.m5218constructorimpl(16);

    /* JADX WARN: Removed duplicated region for block: B:100:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x021c  */
    /* renamed from: Scaffold-TvnljyQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1676ScaffoldTvnljyQ(androidx.compose.ui.Modifier r29, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, int r34, long r35, long r37, androidx.compose.foundation.layout.WindowInsets r39, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.PaddingValues, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, androidx.compose.runtime.Composer r41, final int r42, final int r43) {
        /*
            Method dump skipped, instructions count: 749
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ScaffoldKt.m1676ScaffoldTvnljyQ(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, int, long, long, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ScaffoldLayout-FMILGgc, reason: not valid java name */
    public static final void m1677ScaffoldLayoutFMILGgc(final int fabPosition, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final WindowInsets contentWindowInsets, final Function2<? super Composer, ? super Integer, Unit> function24, Composer $composer, final int $changed) {
        int i;
        Composer $composer2 = $composer.startRestartGroup(-975511942);
        ComposerKt.sourceInformation($composer2, "C(ScaffoldLayout)P(4:c#material3.FabPosition,6,1,5,3,2)121@5603L6544,121@5586L6561:Scaffold.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(fabPosition) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changedInstance(function22) ? 2048 : 1024;
        }
        if ((57344 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function23) ? 16384 : 8192;
        }
        if ((458752 & $changed) == 0) {
            $dirty |= $composer2.changed(contentWindowInsets) ? 131072 : 65536;
        }
        if ((3670016 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function24) ? 1048576 : 524288;
        }
        if ((2995931 & $dirty) != 599186 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-975511942, $dirty, -1, "androidx.compose.material3.ScaffoldLayout (Scaffold.kt:111)");
            }
            Object[] keys$iv = {function2, function22, contentWindowInsets, function23, FabPosition.m1517boximpl(fabPosition), function24, function3};
            $composer2.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv = false;
            for (Object key$iv : keys$iv) {
                invalid$iv |= $composer2.changed(key$iv);
            }
            Object value$iv$iv = $composer2.rememberedValue();
            if (invalid$iv || value$iv$iv == Composer.INSTANCE.getEmpty()) {
                i = 0;
                final int i2 = $dirty;
                value$iv$iv = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m1679invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m1679invoke0kLqBqw(final SubcomposeMeasureScope SubcomposeLayout, long constraints) {
                        final long looseConstraints;
                        final int i3;
                        Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                        final int layoutWidth = Constraints.m5174getMaxWidthimpl(constraints);
                        final int layoutHeight = Constraints.m5173getMaxHeightimpl(constraints);
                        looseConstraints = Constraints.m5164copyZbe2FdA(constraints, (r12 & 1) != 0 ? Constraints.m5176getMinWidthimpl(constraints) : 0, (r12 & 2) != 0 ? Constraints.m5174getMaxWidthimpl(constraints) : 0, (r12 & 4) != 0 ? Constraints.m5175getMinHeightimpl(constraints) : 0, (r12 & 8) != 0 ? Constraints.m5173getMaxHeightimpl(constraints) : 0);
                        final Function2<Composer, Integer, Unit> function25 = function2;
                        final Function2<Composer, Integer, Unit> function26 = function22;
                        final Function2<Composer, Integer, Unit> function27 = function23;
                        final int i4 = fabPosition;
                        final WindowInsets windowInsets = contentWindowInsets;
                        final Function2<Composer, Integer, Unit> function28 = function24;
                        i3 = i2;
                        final Function3<PaddingValues, Composer, Integer, Unit> function32 = function3;
                        return MeasureScope.layout$default(SubcomposeLayout, layoutWidth, layoutHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
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
                                Object maxElem$iv;
                                Object maxElem$iv2;
                                Object maxElem$iv3;
                                FabPlacement fabPlacement;
                                Object maxElem$iv4;
                                Integer num;
                                float f;
                                int i5;
                                float f2;
                                Object maxElem$iv5;
                                Object maxElem$iv6;
                                int fabLeftOffset;
                                float f3;
                                float f4;
                                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                Iterable $this$map$iv = SubcomposeMeasureScope.this.subcompose(ScaffoldLayoutContent.TopBar, function25);
                                long j = looseConstraints;
                                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                for (Object item$iv$iv : $this$map$iv) {
                                    Measurable it = (Measurable) item$iv$iv;
                                    destination$iv$iv.add(it.mo4186measureBRTryo0(j));
                                }
                                final List topBarPlaceables = (List) destination$iv$iv;
                                List $this$maxByOrNull$iv = topBarPlaceables;
                                Iterator iterator$iv = $this$maxByOrNull$iv.iterator();
                                if (iterator$iv.hasNext()) {
                                    maxElem$iv = iterator$iv.next();
                                    if (iterator$iv.hasNext()) {
                                        Placeable it2 = (Placeable) maxElem$iv;
                                        int maxValue$iv = it2.getHeight();
                                        do {
                                            Object e$iv = iterator$iv.next();
                                            Placeable it3 = (Placeable) e$iv;
                                            int v$iv = it3.getHeight();
                                            if (maxValue$iv < v$iv) {
                                                maxElem$iv = e$iv;
                                                maxValue$iv = v$iv;
                                            }
                                        } while (iterator$iv.hasNext());
                                    }
                                } else {
                                    maxElem$iv = null;
                                }
                                Placeable placeable = (Placeable) maxElem$iv;
                                final int topBarHeight = placeable != null ? placeable.getHeight() : 0;
                                Iterable $this$map$iv2 = SubcomposeMeasureScope.this.subcompose(ScaffoldLayoutContent.Snackbar, function26);
                                WindowInsets windowInsets2 = windowInsets;
                                SubcomposeMeasureScope subcomposeMeasureScope = SubcomposeMeasureScope.this;
                                long j2 = looseConstraints;
                                int $i$f$map = 0;
                                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                                for (Object item$iv$iv2 : $this$map$iv2) {
                                    Measurable it4 = (Measurable) item$iv$iv2;
                                    SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                    Iterable $this$map$iv3 = $this$map$iv2;
                                    int leftInset = windowInsets2.getLeft(subcomposeMeasureScope2, subcomposeMeasureScope.getLayoutDirection());
                                    int $i$f$map2 = $i$f$map;
                                    int rightInset = windowInsets2.getRight(subcomposeMeasureScope2, subcomposeMeasureScope.getLayoutDirection());
                                    int bottomInset = windowInsets2.getBottom(subcomposeMeasureScope2);
                                    WindowInsets windowInsets3 = windowInsets2;
                                    int i6 = (-leftInset) - rightInset;
                                    int leftInset2 = -bottomInset;
                                    destination$iv$iv2.add(it4.mo4186measureBRTryo0(ConstraintsKt.m5190offsetNN6EwU(j2, i6, leftInset2)));
                                    $this$map$iv2 = $this$map$iv3;
                                    $i$f$map = $i$f$map2;
                                    windowInsets2 = windowInsets3;
                                }
                                Iterable snackbarPlaceables = (List) destination$iv$iv2;
                                Iterable $this$maxByOrNull$iv2 = snackbarPlaceables;
                                Iterator iterator$iv2 = $this$maxByOrNull$iv2.iterator();
                                if (iterator$iv2.hasNext()) {
                                    maxElem$iv2 = iterator$iv2.next();
                                    if (iterator$iv2.hasNext()) {
                                        Placeable it5 = (Placeable) maxElem$iv2;
                                        int maxValue$iv2 = it5.getHeight();
                                        do {
                                            Object e$iv2 = iterator$iv2.next();
                                            Placeable it6 = (Placeable) e$iv2;
                                            int v$iv2 = it6.getHeight();
                                            if (maxValue$iv2 < v$iv2) {
                                                maxElem$iv2 = e$iv2;
                                                maxValue$iv2 = v$iv2;
                                            }
                                        } while (iterator$iv2.hasNext());
                                    }
                                } else {
                                    maxElem$iv2 = null;
                                }
                                Placeable placeable2 = (Placeable) maxElem$iv2;
                                int snackbarHeight = placeable2 != null ? placeable2.getHeight() : 0;
                                Iterable $this$maxByOrNull$iv3 = snackbarPlaceables;
                                Iterator iterator$iv3 = $this$maxByOrNull$iv3.iterator();
                                if (iterator$iv3.hasNext()) {
                                    maxElem$iv3 = iterator$iv3.next();
                                    if (iterator$iv3.hasNext()) {
                                        Placeable it7 = (Placeable) maxElem$iv3;
                                        int maxValue$iv3 = it7.getWidth();
                                        do {
                                            Object e$iv3 = iterator$iv3.next();
                                            Placeable it8 = (Placeable) e$iv3;
                                            int v$iv3 = it8.getWidth();
                                            if (maxValue$iv3 < v$iv3) {
                                                maxElem$iv3 = e$iv3;
                                                maxValue$iv3 = v$iv3;
                                            }
                                        } while (iterator$iv3.hasNext());
                                    }
                                } else {
                                    maxElem$iv3 = null;
                                }
                                Placeable placeable3 = (Placeable) maxElem$iv3;
                                int snackbarWidth = placeable3 != null ? placeable3.getWidth() : 0;
                                Iterable $this$mapNotNull$iv = SubcomposeMeasureScope.this.subcompose(ScaffoldLayoutContent.Fab, function27);
                                WindowInsets windowInsets4 = windowInsets;
                                SubcomposeMeasureScope subcomposeMeasureScope3 = SubcomposeMeasureScope.this;
                                long j3 = looseConstraints;
                                int $i$f$mapNotNull = 0;
                                Collection destination$iv$iv3 = new ArrayList();
                                Iterable $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv;
                                Iterator it9 = $this$mapNotNullTo$iv$iv.iterator();
                                while (true) {
                                    Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                                    if (!it9.hasNext()) {
                                        break;
                                    }
                                    Object element$iv$iv$iv = it9.next();
                                    Measurable measurable = (Measurable) element$iv$iv$iv;
                                    int $i$f$mapNotNull2 = $i$f$mapNotNull;
                                    SubcomposeMeasureScope subcomposeMeasureScope4 = subcomposeMeasureScope3;
                                    int leftInset3 = windowInsets4.getLeft(subcomposeMeasureScope4, subcomposeMeasureScope3.getLayoutDirection());
                                    Iterable $this$mapNotNullTo$iv$iv2 = $this$mapNotNullTo$iv$iv;
                                    int rightInset2 = windowInsets4.getRight(subcomposeMeasureScope4, subcomposeMeasureScope3.getLayoutDirection());
                                    int bottomInset2 = windowInsets4.getBottom(subcomposeMeasureScope4);
                                    WindowInsets windowInsets5 = windowInsets4;
                                    SubcomposeMeasureScope subcomposeMeasureScope5 = subcomposeMeasureScope3;
                                    Placeable it10 = measurable.mo4186measureBRTryo0(ConstraintsKt.m5190offsetNN6EwU(j3, (-leftInset3) - rightInset2, -bottomInset2));
                                    if (!((it10.getHeight() == 0 || it10.getWidth() == 0) ? false : true)) {
                                        it10 = null;
                                    }
                                    if (it10 != null) {
                                        destination$iv$iv3.add(it10);
                                    }
                                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                                    $i$f$mapNotNull = $i$f$mapNotNull2;
                                    $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv2;
                                    windowInsets4 = windowInsets5;
                                    subcomposeMeasureScope3 = subcomposeMeasureScope5;
                                }
                                Iterable fabPlaceables = (List) destination$iv$iv3;
                                if (!((Collection) fabPlaceables).isEmpty()) {
                                    Iterable $this$maxByOrNull$iv4 = fabPlaceables;
                                    Iterator iterator$iv4 = $this$maxByOrNull$iv4.iterator();
                                    if (iterator$iv4.hasNext()) {
                                        maxElem$iv5 = iterator$iv4.next();
                                        if (iterator$iv4.hasNext()) {
                                            Placeable it11 = (Placeable) maxElem$iv5;
                                            int maxValue$iv4 = it11.getWidth();
                                            do {
                                                Object e$iv4 = iterator$iv4.next();
                                                Placeable it12 = (Placeable) e$iv4;
                                                int v$iv4 = it12.getWidth();
                                                if (maxValue$iv4 < v$iv4) {
                                                    maxElem$iv5 = e$iv4;
                                                    maxValue$iv4 = v$iv4;
                                                }
                                            } while (iterator$iv4.hasNext());
                                        }
                                    } else {
                                        maxElem$iv5 = null;
                                    }
                                    Intrinsics.checkNotNull(maxElem$iv5);
                                    int fabWidth = ((Placeable) maxElem$iv5).getWidth();
                                    Iterable $this$maxByOrNull$iv5 = fabPlaceables;
                                    Iterator iterator$iv5 = $this$maxByOrNull$iv5.iterator();
                                    if (iterator$iv5.hasNext()) {
                                        maxElem$iv6 = iterator$iv5.next();
                                        if (iterator$iv5.hasNext()) {
                                            Placeable it13 = (Placeable) maxElem$iv6;
                                            int maxValue$iv5 = it13.getHeight();
                                            do {
                                                Object e$iv5 = iterator$iv5.next();
                                                Placeable it14 = (Placeable) e$iv5;
                                                int v$iv5 = it14.getHeight();
                                                if (maxValue$iv5 < v$iv5) {
                                                    maxElem$iv6 = e$iv5;
                                                    maxValue$iv5 = v$iv5;
                                                }
                                            } while (iterator$iv5.hasNext());
                                        }
                                    } else {
                                        maxElem$iv6 = null;
                                    }
                                    Intrinsics.checkNotNull(maxElem$iv6);
                                    int fabHeight = ((Placeable) maxElem$iv6).getHeight();
                                    if (!FabPosition.m1520equalsimpl0(i4, FabPosition.INSTANCE.m1525getEndERTFSPs())) {
                                        fabLeftOffset = (layoutWidth - fabWidth) / 2;
                                    } else if (SubcomposeMeasureScope.this.getLayoutDirection() == LayoutDirection.Ltr) {
                                        int i7 = layoutWidth;
                                        SubcomposeMeasureScope subcomposeMeasureScope6 = SubcomposeMeasureScope.this;
                                        f4 = ScaffoldKt.FabSpacing;
                                        fabLeftOffset = (i7 - subcomposeMeasureScope6.mo323roundToPx0680j_4(f4)) - fabWidth;
                                    } else {
                                        SubcomposeMeasureScope subcomposeMeasureScope7 = SubcomposeMeasureScope.this;
                                        f3 = ScaffoldKt.FabSpacing;
                                        fabLeftOffset = subcomposeMeasureScope7.mo323roundToPx0680j_4(f3);
                                    }
                                    fabPlacement = new FabPlacement(fabLeftOffset, fabWidth, fabHeight);
                                } else {
                                    fabPlacement = null;
                                }
                                final FabPlacement fabPlacement2 = fabPlacement;
                                SubcomposeMeasureScope subcomposeMeasureScope8 = SubcomposeMeasureScope.this;
                                ScaffoldLayoutContent scaffoldLayoutContent = ScaffoldLayoutContent.BottomBar;
                                final Function2<Composer, Integer, Unit> function29 = function28;
                                final int i8 = i3;
                                Iterable $this$map$iv4 = subcomposeMeasureScope8.subcompose(scaffoldLayoutContent, ComposableLambdaKt.composableLambdaInstance(-1455477816, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1$1$bottomBarPlaceables$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num2) {
                                        invoke(composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer $composer3, int $changed2) {
                                        ComposerKt.sourceInformation($composer3, "C194@8951L144:Scaffold.kt#uh7d8r");
                                        if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1455477816, $changed2, -1, "androidx.compose.material3.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:193)");
                                            }
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ScaffoldKt.getLocalFabPlacement().provides(FabPlacement.this)}, function29, $composer3, ((i8 >> 15) & 112) | 8);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer3.skipToGroupEnd();
                                    }
                                }));
                                long j4 = looseConstraints;
                                Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
                                for (Object item$iv$iv3 : $this$map$iv4) {
                                    Measurable it15 = (Measurable) item$iv$iv3;
                                    destination$iv$iv4.add(it15.mo4186measureBRTryo0(j4));
                                }
                                final List bottomBarPlaceables = (List) destination$iv$iv4;
                                List $this$maxByOrNull$iv6 = bottomBarPlaceables;
                                Iterator iterator$iv6 = $this$maxByOrNull$iv6.iterator();
                                if (iterator$iv6.hasNext()) {
                                    maxElem$iv4 = iterator$iv6.next();
                                    if (iterator$iv6.hasNext()) {
                                        Placeable it16 = (Placeable) maxElem$iv4;
                                        int maxValue$iv6 = it16.getHeight();
                                        do {
                                            Object e$iv6 = iterator$iv6.next();
                                            Placeable it17 = (Placeable) e$iv6;
                                            int v$iv6 = it17.getHeight();
                                            if (maxValue$iv6 < v$iv6) {
                                                maxElem$iv4 = e$iv6;
                                                maxValue$iv6 = v$iv6;
                                            }
                                        } while (iterator$iv6.hasNext());
                                    }
                                } else {
                                    maxElem$iv4 = null;
                                }
                                Placeable placeable4 = (Placeable) maxElem$iv4;
                                final Integer bottomBarHeight = placeable4 != null ? Integer.valueOf(placeable4.getHeight()) : null;
                                if (fabPlacement2 != null) {
                                    SubcomposeMeasureScope subcomposeMeasureScope9 = SubcomposeMeasureScope.this;
                                    WindowInsets windowInsets6 = windowInsets;
                                    if (bottomBarHeight == null) {
                                        int height = fabPlacement2.getHeight();
                                        f2 = ScaffoldKt.FabSpacing;
                                        i5 = height + subcomposeMeasureScope9.mo323roundToPx0680j_4(f2) + windowInsets6.getBottom(subcomposeMeasureScope9);
                                    } else {
                                        int intValue = bottomBarHeight.intValue() + fabPlacement2.getHeight();
                                        f = ScaffoldKt.FabSpacing;
                                        i5 = intValue + subcomposeMeasureScope9.mo323roundToPx0680j_4(f);
                                    }
                                    num = Integer.valueOf(i5);
                                } else {
                                    num = null;
                                }
                                Integer fabOffsetFromBottom = num;
                                int snackbarOffsetFromBottom = snackbarHeight != 0 ? snackbarHeight + (fabOffsetFromBottom != null ? fabOffsetFromBottom.intValue() : bottomBarHeight != null ? bottomBarHeight.intValue() : windowInsets.getBottom(SubcomposeMeasureScope.this)) : 0;
                                SubcomposeMeasureScope subcomposeMeasureScope10 = SubcomposeMeasureScope.this;
                                ScaffoldLayoutContent scaffoldLayoutContent2 = ScaffoldLayoutContent.MainContent;
                                final WindowInsets windowInsets7 = windowInsets;
                                final SubcomposeMeasureScope subcomposeMeasureScope11 = SubcomposeMeasureScope.this;
                                final Function3<PaddingValues, Composer, Integer, Unit> function33 = function32;
                                final int i9 = i3;
                                Iterable $this$map$iv5 = subcomposeMeasureScope10.subcompose(scaffoldLayoutContent2, ComposableLambdaKt.composableLambdaInstance(1643221465, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1$1$bodyContentPlaceables$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num2) {
                                        invoke(composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer $composer3, int $changed2) {
                                        float f5;
                                        float bottom;
                                        ComposerKt.sourceInformation($composer3, "C238@10996L21:Scaffold.kt#uh7d8r");
                                        if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1643221465, $changed2, -1, "androidx.compose.material3.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:220)");
                                            }
                                            PaddingValues insets = WindowInsetsKt.asPaddingValues(WindowInsets.this, subcomposeMeasureScope11);
                                            if (topBarPlaceables.isEmpty()) {
                                                f5 = insets.getTop();
                                            } else {
                                                f5 = subcomposeMeasureScope11.mo326toDpu2uoSUM(topBarHeight);
                                            }
                                            if (bottomBarPlaceables.isEmpty() || bottomBarHeight == null) {
                                                bottom = insets.getBottom();
                                            } else {
                                                bottom = subcomposeMeasureScope11.mo326toDpu2uoSUM(bottomBarHeight.intValue());
                                            }
                                            PaddingValues innerPadding = PaddingKt.m480PaddingValuesa9UjIt4(PaddingKt.calculateStartPadding(insets, subcomposeMeasureScope11.getLayoutDirection()), f5, PaddingKt.calculateEndPadding(insets, subcomposeMeasureScope11.getLayoutDirection()), bottom);
                                            function33.invoke(innerPadding, $composer3, Integer.valueOf((i9 >> 3) & 112));
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer3.skipToGroupEnd();
                                    }
                                }));
                                long j5 = looseConstraints;
                                Collection destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv5, 10));
                                for (Object item$iv$iv4 : $this$map$iv5) {
                                    Measurable it18 = (Measurable) item$iv$iv4;
                                    destination$iv$iv5.add(it18.mo4186measureBRTryo0(j5));
                                }
                                Iterable bodyContentPlaceables = (List) destination$iv$iv5;
                                Iterable $this$forEach$iv = bodyContentPlaceables;
                                for (Object element$iv : $this$forEach$iv) {
                                    Placeable it19 = (Placeable) element$iv;
                                    Placeable.PlacementScope.place$default(layout, it19, 0, 0, 0.0f, 4, null);
                                    fabPlacement2 = fabPlacement2;
                                }
                                FabPlacement fabPlacement3 = fabPlacement2;
                                List $this$forEach$iv2 = topBarPlaceables;
                                for (Object element$iv2 : $this$forEach$iv2) {
                                    Placeable it20 = (Placeable) element$iv2;
                                    Placeable.PlacementScope.place$default(layout, it20, 0, 0, 0.0f, 4, null);
                                }
                                Iterable $this$forEach$iv3 = snackbarPlaceables;
                                int i10 = layoutWidth;
                                WindowInsets windowInsets8 = windowInsets;
                                SubcomposeMeasureScope subcomposeMeasureScope12 = SubcomposeMeasureScope.this;
                                int i11 = layoutHeight;
                                for (Object element$iv3 : $this$forEach$iv3) {
                                    Placeable it21 = (Placeable) element$iv3;
                                    Placeable.PlacementScope.place$default(layout, it21, ((i10 - snackbarWidth) / 2) + windowInsets8.getLeft(subcomposeMeasureScope12, subcomposeMeasureScope12.getLayoutDirection()), i11 - snackbarOffsetFromBottom, 0.0f, 4, null);
                                    i11 = i11;
                                }
                                List $this$forEach$iv4 = bottomBarPlaceables;
                                int i12 = layoutHeight;
                                for (Object element$iv4 : $this$forEach$iv4) {
                                    Placeable it22 = (Placeable) element$iv4;
                                    Placeable.PlacementScope.place$default(layout, it22, 0, i12 - (bottomBarHeight != null ? bottomBarHeight.intValue() : 0), 0.0f, 4, null);
                                }
                                if (fabPlacement3 != null) {
                                    int i13 = layoutHeight;
                                    Iterable $this$forEach$iv5 = fabPlaceables;
                                    for (Object element$iv5 : $this$forEach$iv5) {
                                        Placeable it23 = (Placeable) element$iv5;
                                        int left = fabPlacement3.getLeft();
                                        Intrinsics.checkNotNull(fabOffsetFromBottom);
                                        Placeable.PlacementScope.place$default(layout, it23, left, i13 - fabOffsetFromBottom.intValue(), 0.0f, 4, null);
                                    }
                                    Unit unit = Unit.INSTANCE;
                                    Unit unit2 = Unit.INSTANCE;
                                }
                            }
                        }, 4, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                i = 0;
            }
            $composer2.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(null, (Function2) value$iv$iv, $composer2, i, 1);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$2
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

            public final void invoke(Composer composer, int i3) {
                ScaffoldKt.m1677ScaffoldLayoutFMILGgc(fabPosition, function2, function3, function22, function23, contentWindowInsets, function24, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    public static final ProvidableCompositionLocal<FabPlacement> getLocalFabPlacement() {
        return LocalFabPlacement;
    }
}
