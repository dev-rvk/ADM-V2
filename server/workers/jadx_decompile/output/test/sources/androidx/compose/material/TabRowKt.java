package androidx.compose.material;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TabRow.kt */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a¬\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u000123\b\u0002\u0010\u0010\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00070\u0011¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001a¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001a¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a¢\u0001\u0010\u001e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r23\b\u0002\u0010\u0010\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00070\u0011¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001a¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001a¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"ScrollableTabRowMinimumTabWidth", "Landroidx/compose/ui/unit/Dp;", "F", "ScrollableTabRowScrollSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "ScrollableTabRow", "", "selectedTabIndex", "", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "edgePadding", "indicator", "Lkotlin/Function1;", "", "Landroidx/compose/material/TabPosition;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "tabPositions", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "divider", "Lkotlin/Function0;", "tabs", "ScrollableTabRow-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TabRow", "TabRow-pAZo6Ak", "(ILandroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TabRowKt {
    private static final float ScrollableTabRowMinimumTabWidth = Dp.m5218constructorimpl(90);
    private static final AnimationSpec<Float> ScrollableTabRowScrollSpec = AnimationSpecKt.tween$default(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 0, EasingKt.getFastOutSlowInEasing(), 2, null);

    /* renamed from: TabRow-pAZo6Ak, reason: not valid java name */
    public static final void m1228TabRowpAZo6Ak(final int selectedTabIndex, Modifier modifier, long backgroundColor, long contentColor, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> tabs, Composer $composer, final int $changed, final int i) {
        long backgroundColor2;
        long contentColor2;
        final Function3 indicator;
        Function2 function22;
        Modifier.Companion modifier2;
        final Function2 divider;
        Modifier modifier3;
        Function2 divider2;
        long backgroundColor3;
        long contentColor3;
        Function3 indicator2;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(tabs, "tabs");
        Composer $composer2 = $composer.startRestartGroup(-249175289);
        ComposerKt.sourceInformation($composer2, "C(TabRow)P(5,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)131@6500L6,132@6549L32,145@7006L1504:TabRow.kt#jmzs0o");
        final int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(selectedTabIndex) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                backgroundColor2 = backgroundColor;
                if ($composer2.changed(backgroundColor2)) {
                    i3 = 256;
                    $dirty |= i3;
                }
            } else {
                backgroundColor2 = backgroundColor;
            }
            i3 = 128;
            $dirty |= i3;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if (($changed & 7168) == 0) {
            if ((i & 8) == 0) {
                contentColor2 = contentColor;
                if ($composer2.changed(contentColor2)) {
                    i2 = 2048;
                    $dirty |= i2;
                }
            } else {
                contentColor2 = contentColor;
            }
            i2 = 1024;
            $dirty |= i2;
        } else {
            contentColor2 = contentColor;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= 24576;
            indicator = function3;
        } else if ((57344 & $changed) == 0) {
            indicator = function3;
            $dirty |= $composer2.changedInstance(indicator) ? 16384 : 8192;
        } else {
            indicator = function3;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function22 = function2;
        } else if ((458752 & $changed) == 0) {
            function22 = function2;
            $dirty |= $composer2.changedInstance(function22) ? 131072 : 65536;
        } else {
            function22 = function2;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty |= $composer2.changedInstance(tabs) ? 1048576 : 524288;
        }
        if (($dirty & 2995931) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            backgroundColor3 = backgroundColor2;
            contentColor3 = contentColor2;
            indicator2 = indicator;
            divider2 = function22;
            modifier3 = modifier;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i4 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 4) != 0) {
                    $dirty &= -897;
                    backgroundColor2 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors($composer2, 6));
                }
                if ((i & 8) != 0) {
                    long contentColor4 = ColorsKt.m1054contentColorForek8zF_U(backgroundColor2, $composer2, ($dirty >> 6) & 14);
                    $dirty &= -7169;
                    contentColor2 = contentColor4;
                }
                if (i5 != 0) {
                    indicator = ComposableLambdaKt.composableLambda($composer2, -553782708, true, new Function3<List<? extends TabPosition>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt$TabRow$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(List<? extends TabPosition> list, Composer composer, Integer num) {
                            invoke((List<TabPosition>) list, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(List<TabPosition> tabPositions, Composer $composer3, int $changed2) {
                            Intrinsics.checkNotNullParameter(tabPositions, "tabPositions");
                            ComposerKt.sourceInformation($composer3, "C135@6729L92:TabRow.kt#jmzs0o");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-553782708, $changed2, -1, "androidx.compose.material.TabRow.<anonymous> (TabRow.kt:134)");
                            }
                            TabRowDefaults.INSTANCE.m1223Indicator9IZ8Weo(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.INSTANCE, tabPositions.get(selectedTabIndex)), 0.0f, 0L, $composer3, 3072, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    });
                }
                divider = i6 != 0 ? ComposableSingletons$TabRowKt.INSTANCE.m1067getLambda1$material_release() : function22;
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    divider = function22;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    divider = function22;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-249175289, $dirty, -1, "androidx.compose.material.TabRow (TabRow.kt:128)");
            }
            SurfaceKt.m1198SurfaceFjzlyU(SelectableGroupKt.selectableGroup(modifier2), null, backgroundColor2, contentColor2, null, 0.0f, ComposableLambdaKt.composableLambda($composer2, -1961746365, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt$TabRow$2
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

                public final void invoke(Composer $composer3, int $changed2) {
                    Object value$iv$iv;
                    ComposerKt.sourceInformation($composer3, "C150@7189L1315,150@7147L1357:TabRow.kt#jmzs0o");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1961746365, $changed2, -1, "androidx.compose.material.TabRow.<anonymous> (TabRow.kt:149)");
                    }
                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Object key1$iv = tabs;
                    Object key2$iv = divider;
                    Object key3$iv = indicator;
                    final Function2<Composer, Integer, Unit> function23 = tabs;
                    final Function2<Composer, Integer, Unit> function24 = divider;
                    final Function3<List<TabPosition>, Composer, Integer, Unit> function32 = indicator;
                    final int i7 = $dirty;
                    int i8 = (($dirty >> 18) & 14) | (($dirty >> 12) & 112) | (($dirty >> 6) & 896);
                    $composer3.startReplaceableGroup(1618982084);
                    ComposerKt.sourceInformation($composer3, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
                    boolean invalid$iv$iv = $composer3.changed(key1$iv) | $composer3.changed(key2$iv) | $composer3.changed(key3$iv);
                    Object it$iv$iv = $composer3.rememberedValue();
                    if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.TabRowKt$TabRow$2$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                return m1230invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                            }

                            /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m1230invoke0kLqBqw(final SubcomposeMeasureScope SubcomposeLayout, final long constraints) {
                                Object maxElem$iv;
                                long m5164copyZbe2FdA;
                                Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                                final int tabRowWidth = Constraints.m5174getMaxWidthimpl(constraints);
                                List tabMeasurables = SubcomposeLayout.subcompose(TabSlots.Tabs, function23);
                                int tabCount = tabMeasurables.size();
                                final int tabWidth = tabRowWidth / tabCount;
                                List $this$map$iv = tabMeasurables;
                                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                for (Object item$iv$iv : $this$map$iv) {
                                    Measurable it = (Measurable) item$iv$iv;
                                    m5164copyZbe2FdA = Constraints.m5164copyZbe2FdA(constraints, (r12 & 1) != 0 ? Constraints.m5176getMinWidthimpl(constraints) : tabWidth, (r12 & 2) != 0 ? Constraints.m5174getMaxWidthimpl(constraints) : tabWidth, (r12 & 4) != 0 ? Constraints.m5175getMinHeightimpl(constraints) : 0, (r12 & 8) != 0 ? Constraints.m5173getMaxHeightimpl(constraints) : 0);
                                    destination$iv$iv.add(it.mo4186measureBRTryo0(m5164copyZbe2FdA));
                                    $this$map$iv = $this$map$iv;
                                }
                                final List tabPlaceables = (List) destination$iv$iv;
                                List $this$maxByOrNull$iv = tabPlaceables;
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
                                final int tabRowHeight = placeable != null ? placeable.getHeight() : 0;
                                ArrayList arrayList = new ArrayList(tabCount);
                                for (int i9 = 0; i9 < tabCount; i9++) {
                                    int index = i9;
                                    float arg0$iv = SubcomposeLayout.mo326toDpu2uoSUM(tabWidth);
                                    arrayList.add(new TabPosition(Dp.m5218constructorimpl(index * arg0$iv), SubcomposeLayout.mo326toDpu2uoSUM(tabWidth), null));
                                }
                                final ArrayList tabPositions = arrayList;
                                final Function2<Composer, Integer, Unit> function25 = function24;
                                final Function3<List<TabPosition>, Composer, Integer, Unit> function33 = function32;
                                final int i10 = i7;
                                return MeasureScope.layout$default(SubcomposeLayout, tabRowWidth, tabRowHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.TabRowKt$TabRow$2$1$1.1
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
                                        Iterator it4;
                                        long m5164copyZbe2FdA2;
                                        Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                        Iterable $this$forEachIndexed$iv = tabPlaceables;
                                        int i11 = tabWidth;
                                        int index$iv = 0;
                                        for (Object item$iv : $this$forEachIndexed$iv) {
                                            int index$iv2 = index$iv + 1;
                                            if (index$iv < 0) {
                                                CollectionsKt.throwIndexOverflow();
                                            }
                                            int index2 = index$iv;
                                            Placeable.PlacementScope.placeRelative$default(layout, (Placeable) item$iv, index2 * i11, 0, 0.0f, 4, null);
                                            index$iv = index$iv2;
                                        }
                                        Iterable $this$forEach$iv = SubcomposeLayout.subcompose(TabSlots.Divider, function25);
                                        long j = constraints;
                                        int i12 = tabRowHeight;
                                        for (Object element$iv : $this$forEach$iv) {
                                            Measurable it5 = (Measurable) element$iv;
                                            m5164copyZbe2FdA2 = Constraints.m5164copyZbe2FdA(r10, (r12 & 1) != 0 ? Constraints.m5176getMinWidthimpl(r10) : 0, (r12 & 2) != 0 ? Constraints.m5174getMaxWidthimpl(r10) : 0, (r12 & 4) != 0 ? Constraints.m5175getMinHeightimpl(r10) : 0, (r12 & 8) != 0 ? Constraints.m5173getMaxHeightimpl(j) : 0);
                                            Placeable placeable2 = it5.mo4186measureBRTryo0(m5164copyZbe2FdA2);
                                            Placeable.PlacementScope.placeRelative$default(layout, placeable2, 0, i12 - placeable2.getHeight(), 0.0f, 4, null);
                                            i12 = i12;
                                            j = j;
                                        }
                                        SubcomposeMeasureScope subcomposeMeasureScope = SubcomposeLayout;
                                        TabSlots tabSlots = TabSlots.Indicator;
                                        final Function3<List<TabPosition>, Composer, Integer, Unit> function34 = function33;
                                        final List<TabPosition> list = tabPositions;
                                        final int i13 = i10;
                                        Iterable $this$forEach$iv2 = subcomposeMeasureScope.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(-1341594997, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt.TabRow.2.1.1.1.3
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

                                            public final void invoke(Composer $composer4, int $changed3) {
                                                ComposerKt.sourceInformation($composer4, "C176@8314L23:TabRow.kt#jmzs0o");
                                                if (($changed3 & 11) == 2 && $composer4.getSkipping()) {
                                                    $composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1341594997, $changed3, -1, "androidx.compose.material.TabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:175)");
                                                }
                                                function34.invoke(list, $composer4, Integer.valueOf(((i13 >> 9) & 112) | 8));
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }));
                                        int i14 = tabRowWidth;
                                        int i15 = tabRowHeight;
                                        for (Object element$iv2 : $this$forEach$iv2) {
                                            Measurable it6 = (Measurable) element$iv2;
                                            Placeable.PlacementScope.placeRelative$default(layout, it6.mo4186measureBRTryo0(Constraints.INSTANCE.m5182fixedJhjzzOo(i14, i15)), 0, 0, 0.0f, 4, null);
                                        }
                                    }
                                }, 4, null);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    SubcomposeLayoutKt.SubcomposeLayout(fillMaxWidth$default, (Function2) value$iv$iv, $composer3, 6, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), $composer2, ($dirty & 896) | 1572864 | ($dirty & 7168), 50);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            divider2 = divider;
            backgroundColor3 = backgroundColor2;
            contentColor3 = contentColor2;
            indicator2 = indicator;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier3;
        final long j = backgroundColor3;
        final long j2 = contentColor3;
        final Function3 function32 = indicator2;
        final Function2 function23 = divider2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt$TabRow$3
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

            public final void invoke(Composer composer, int i7) {
                TabRowKt.m1228TabRowpAZo6Ak(selectedTabIndex, modifier4, j, j2, function32, function23, tabs, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x015c  */
    /* renamed from: ScrollableTabRow-sKfQg0A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1227ScrollableTabRowsKfQg0A(final int r28, androidx.compose.ui.Modifier r29, long r30, long r32, float r34, kotlin.jvm.functions.Function3<? super java.util.List<androidx.compose.material.TabPosition>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, final int r39, final int r40) {
        /*
            Method dump skipped, instructions count: 577
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TabRowKt.m1227ScrollableTabRowsKfQg0A(int, androidx.compose.ui.Modifier, long, long, float, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }
}
