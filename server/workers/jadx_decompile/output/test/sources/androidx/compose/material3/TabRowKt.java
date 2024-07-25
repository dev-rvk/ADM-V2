package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
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
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TabRow.kt */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u009d\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00012.\b\u0002\u0010\u0011\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\b0\u0012¢\u0006\u0002\b\u00182\u0013\b\u0002\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\b0\u001a¢\u0006\u0002\b\u00182\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\b0\u001a¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0093\u0001\u0010\u001e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2.\b\u0002\u0010\u0011\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\b0\u0012¢\u0006\u0002\b\u00182\u0013\b\u0002\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\b0\u001a¢\u0006\u0002\b\u00182\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\b0\u001a¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"ScrollableTabRowMinimumTabWidth", "Landroidx/compose/ui/unit/Dp;", "F", "ScrollableTabRowPadding", "ScrollableTabRowScrollSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "ScrollableTabRow", "", "selectedTabIndex", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "edgePadding", "indicator", "Lkotlin/Function1;", "", "Landroidx/compose/material3/TabPosition;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "tabPositions", "Landroidx/compose/runtime/Composable;", "divider", "Lkotlin/Function0;", "tabs", "ScrollableTabRow-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TabRow", "TabRow-pAZo6Ak", "(ILandroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TabRowKt {
    private static final float ScrollableTabRowMinimumTabWidth = Dp.m5218constructorimpl(90);
    private static final float ScrollableTabRowPadding = Dp.m5218constructorimpl(52);
    private static final AnimationSpec<Float> ScrollableTabRowScrollSpec = AnimationSpecKt.tween$default(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 0, EasingKt.getFastOutSlowInEasing(), 2, null);

    /* JADX WARN: Removed duplicated region for block: B:40:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0130  */
    /* renamed from: TabRow-pAZo6Ak, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1829TabRowpAZo6Ak(final int r28, androidx.compose.ui.Modifier r29, long r30, long r32, kotlin.jvm.functions.Function3<? super java.util.List<androidx.compose.material3.TabPosition>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.runtime.Composer r37, final int r38, final int r39) {
        /*
            Method dump skipped, instructions count: 493
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.m1829TabRowpAZo6Ak(int, androidx.compose.ui.Modifier, long, long, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: ScrollableTabRow-sKfQg0A, reason: not valid java name */
    public static final void m1828ScrollableTabRowsKfQg0A(final int selectedTabIndex, Modifier modifier, long containerColor, long contentColor, float edgePadding, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> tabs, Composer $composer, final int $changed, final int i) {
        long containerColor2;
        long contentColor2;
        float edgePadding2;
        Modifier.Companion modifier2;
        Function3 indicator;
        Function2 divider;
        Modifier modifier3;
        Function3 indicator2;
        Function2 divider2;
        long containerColor3;
        long contentColor3;
        float edgePadding3;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(tabs, "tabs");
        Composer $composer2 = $composer.startRestartGroup(-497821003);
        ComposerKt.sourceInformation($composer2, "C(ScrollableTabRow)P(6,5,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,4)230@11025L14,231@11082L12,243@11485L3289:TabRow.kt#uh7d8r");
        int $dirty = $changed;
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
                containerColor2 = containerColor;
                if ($composer2.changed(containerColor2)) {
                    i3 = 256;
                    $dirty |= i3;
                }
            } else {
                containerColor2 = containerColor;
            }
            i3 = 128;
            $dirty |= i3;
        } else {
            containerColor2 = containerColor;
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
            edgePadding2 = edgePadding;
        } else if ((57344 & $changed) == 0) {
            edgePadding2 = edgePadding;
            $dirty |= $composer2.changed(edgePadding2) ? 16384 : 8192;
        } else {
            edgePadding2 = edgePadding;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed & 458752) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 131072 : 65536;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 1048576 : 524288;
        }
        if ((i & 128) != 0) {
            $dirty |= 12582912;
        } else if ((29360128 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(tabs) ? 8388608 : 4194304;
        }
        if ((23967451 & $dirty) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            indicator2 = function3;
            divider2 = function2;
            containerColor3 = containerColor2;
            contentColor3 = contentColor2;
            edgePadding3 = edgePadding2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i4 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 4) != 0) {
                    containerColor2 = TabRowDefaults.INSTANCE.getContainerColor($composer2, 6);
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    contentColor2 = TabRowDefaults.INSTANCE.getContentColor($composer2, 6);
                }
                if (i5 != 0) {
                    edgePadding2 = ScrollableTabRowPadding;
                }
                indicator = i6 != 0 ? ComposableLambdaKt.composableLambda($composer2, -913748678, true, new Function3<List<? extends TabPosition>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRow$1
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
                        ComposerKt.sourceInformation($composer3, "C234@11267L92:TabRow.kt#uh7d8r");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-913748678, $changed2, -1, "androidx.compose.material3.ScrollableTabRow.<anonymous> (TabRow.kt:233)");
                        }
                        TabRowDefaults.INSTANCE.m1827Indicator9IZ8Weo(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.INSTANCE, tabPositions.get(selectedTabIndex)), 0.0f, 0L, $composer3, 3072, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }) : function3;
                divider = i7 != 0 ? ComposableSingletons$TabRowKt.INSTANCE.m1448getLambda2$material3_release() : function2;
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    indicator = function3;
                    divider = function2;
                    $dirty &= -7169;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    indicator = function3;
                    divider = function2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-497821003, $dirty, -1, "androidx.compose.material3.ScrollableTabRow (TabRow.kt:227)");
            }
            final float f = edgePadding2;
            final Function2 function22 = divider;
            final Function3 function32 = indicator;
            final int i8 = $dirty;
            SurfaceKt.m1794SurfaceT9BRK9s(modifier2, null, containerColor2, contentColor2, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda($composer2, 286469328, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRow$2
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
                    Object value$iv$iv$iv;
                    Object value$iv$iv;
                    ComposerKt.sourceInformation($composer3, "C248@11625L21,249@11676L24,250@11733L185,256@11927L2841:TabRow.kt#uh7d8r");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(286469328, $changed2, -1, "androidx.compose.material3.ScrollableTabRow.<anonymous> (TabRow.kt:247)");
                        }
                        ScrollState scrollState = ScrollKt.rememberScrollState(0, $composer3, 0, 1);
                        $composer3.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation($composer3, "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
                        $composer3.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                        Object it$iv$iv$iv = $composer3.rememberedValue();
                        if (it$iv$iv$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3));
                            $composer3.updateRememberedValue(value$iv$iv$iv);
                        } else {
                            value$iv$iv$iv = it$iv$iv$iv;
                        }
                        $composer3.endReplaceableGroup();
                        CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
                        CoroutineScope coroutineScope = wrapper$iv.getCoroutineScope();
                        $composer3.endReplaceableGroup();
                        $composer3.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation($composer3, "CC(remember)P(1,2):Composables.kt#9igjgp");
                        boolean invalid$iv$iv = $composer3.changed(scrollState) | $composer3.changed(coroutineScope);
                        Object it$iv$iv = $composer3.rememberedValue();
                        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv = new ScrollableTabData(scrollState, coroutineScope);
                            $composer3.updateRememberedValue(value$iv$iv);
                        } else {
                            value$iv$iv = it$iv$iv;
                        }
                        $composer3.endReplaceableGroup();
                        final ScrollableTabData scrollableTabData = (ScrollableTabData) value$iv$iv;
                        Modifier clipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), scrollState, false, null, false, 14, null)));
                        final float f2 = f;
                        final Function2<Composer, Integer, Unit> function23 = tabs;
                        final Function2<Composer, Integer, Unit> function24 = function22;
                        final int i9 = selectedTabIndex;
                        final Function3<List<TabPosition>, Composer, Integer, Unit> function33 = function32;
                        final int i10 = i8;
                        SubcomposeLayoutKt.SubcomposeLayout(clipToBounds, new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRow$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                return m1830invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                            }

                            /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m1830invoke0kLqBqw(final SubcomposeMeasureScope SubcomposeLayout, final long constraints) {
                                float f3;
                                long tabConstraints;
                                Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                                f3 = TabRowKt.ScrollableTabRowMinimumTabWidth;
                                int minTabWidth = SubcomposeLayout.mo323roundToPx0680j_4(f3);
                                final int padding = SubcomposeLayout.mo323roundToPx0680j_4(f2);
                                Iterable tabMeasurables = SubcomposeLayout.subcompose(TabSlots.Tabs, function23);
                                Iterable $this$fold$iv = tabMeasurables;
                                int accumulator$iv = 0;
                                for (Object element$iv : $this$fold$iv) {
                                    Measurable measurable = (Measurable) element$iv;
                                    int curr = accumulator$iv;
                                    accumulator$iv = Math.max(curr, measurable.maxIntrinsicHeight(Integer.MAX_VALUE));
                                }
                                tabConstraints = Constraints.m5164copyZbe2FdA(constraints, (r12 & 1) != 0 ? Constraints.m5176getMinWidthimpl(constraints) : minTabWidth, (r12 & 2) != 0 ? Constraints.m5174getMaxWidthimpl(constraints) : 0, (r12 & 4) != 0 ? Constraints.m5175getMinHeightimpl(constraints) : accumulator$iv, (r12 & 8) != 0 ? Constraints.m5173getMaxHeightimpl(constraints) : accumulator$iv);
                                Iterable $this$map$iv = tabMeasurables;
                                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                for (Object item$iv$iv : $this$map$iv) {
                                    Measurable it = (Measurable) item$iv$iv;
                                    destination$iv$iv.add(it.mo4186measureBRTryo0(tabConstraints));
                                }
                                final List tabPlaceables = (List) destination$iv$iv;
                                List $this$fold$iv2 = tabPlaceables;
                                int initial$iv = padding * 2;
                                final int accumulator$iv2 = initial$iv;
                                for (Object element$iv2 : $this$fold$iv2) {
                                    Placeable measurable2 = (Placeable) element$iv2;
                                    int curr2 = accumulator$iv2;
                                    accumulator$iv2 = curr2 + measurable2.getWidth();
                                }
                                final Function2<Composer, Integer, Unit> function25 = function24;
                                final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                final int i11 = i9;
                                final Function3<List<TabPosition>, Composer, Integer, Unit> function34 = function33;
                                final int i12 = i10;
                                final int i13 = accumulator$iv;
                                return MeasureScope.layout$default(SubcomposeLayout, accumulator$iv2, accumulator$iv, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt.ScrollableTabRow.2.1.1
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
                                        long m5164copyZbe2FdA;
                                        Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                        final List tabPositions = new ArrayList();
                                        int left = padding;
                                        Iterable $this$forEach$iv = tabPlaceables;
                                        SubcomposeMeasureScope subcomposeMeasureScope = SubcomposeLayout;
                                        int left2 = left;
                                        for (Object element$iv3 : $this$forEach$iv) {
                                            Placeable it2 = (Placeable) element$iv3;
                                            Placeable.PlacementScope.placeRelative$default(layout, it2, left2, 0, 0.0f, 4, null);
                                            tabPositions.add(new TabPosition(subcomposeMeasureScope.mo326toDpu2uoSUM(left2), subcomposeMeasureScope.mo326toDpu2uoSUM(it2.getWidth()), null));
                                            left2 += it2.getWidth();
                                        }
                                        Iterable $this$forEach$iv2 = SubcomposeLayout.subcompose(TabSlots.Divider, function25);
                                        long j = constraints;
                                        int i14 = accumulator$iv2;
                                        int i15 = i13;
                                        for (Object element$iv4 : $this$forEach$iv2) {
                                            Measurable it3 = (Measurable) element$iv4;
                                            m5164copyZbe2FdA = Constraints.m5164copyZbe2FdA(j, (r12 & 1) != 0 ? Constraints.m5176getMinWidthimpl(j) : i14, (r12 & 2) != 0 ? Constraints.m5174getMaxWidthimpl(j) : i14, (r12 & 4) != 0 ? Constraints.m5175getMinHeightimpl(j) : 0, (r12 & 8) != 0 ? Constraints.m5173getMaxHeightimpl(j) : 0);
                                            Placeable placeable = it3.mo4186measureBRTryo0(m5164copyZbe2FdA);
                                            Placeable.PlacementScope.placeRelative$default(layout, placeable, 0, i15 - placeable.getHeight(), 0.0f, 4, null);
                                            i15 = i15;
                                        }
                                        SubcomposeMeasureScope subcomposeMeasureScope2 = SubcomposeLayout;
                                        TabSlots tabSlots = TabSlots.Indicator;
                                        final Function3<List<TabPosition>, Composer, Integer, Unit> function35 = function34;
                                        final int i16 = i12;
                                        Iterable $this$forEach$iv3 = subcomposeMeasureScope2.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(963343607, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.ScrollableTabRow.2.1.1.3
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
                                                ComposerKt.sourceInformation($composer4, "C312@14319L23:TabRow.kt#uh7d8r");
                                                if (($changed3 & 11) == 2 && $composer4.getSkipping()) {
                                                    $composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(963343607, $changed3, -1, "androidx.compose.material3.ScrollableTabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:311)");
                                                }
                                                function35.invoke(tabPositions, $composer4, Integer.valueOf(((i16 >> 12) & 112) | 8));
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }));
                                        int i17 = accumulator$iv2;
                                        int i18 = i13;
                                        for (Object element$iv5 : $this$forEach$iv3) {
                                            Measurable it4 = (Measurable) element$iv5;
                                            Placeable.PlacementScope.placeRelative$default(layout, it4.mo4186measureBRTryo0(Constraints.INSTANCE.m5182fixedJhjzzOo(i17, i18)), 0, 0, 0.0f, 4, null);
                                        }
                                        scrollableTabData2.onLaidOut(SubcomposeLayout, padding, tabPositions, i11);
                                    }
                                }, 4, null);
                            }
                        }, $composer3, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }), $composer2, (($dirty >> 3) & 14) | 12582912 | ($dirty & 896) | ($dirty & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            indicator2 = indicator;
            divider2 = divider;
            containerColor3 = containerColor2;
            contentColor3 = contentColor2;
            edgePadding3 = edgePadding2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier3;
        final long j = containerColor3;
        final long j2 = contentColor3;
        final float f2 = edgePadding3;
        final Function3 function33 = indicator2;
        final Function2 function23 = divider2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRow$3
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

            public final void invoke(Composer composer, int i9) {
                TabRowKt.m1828ScrollableTabRowsKfQg0A(selectedTabIndex, modifier4, j, j2, f2, function33, function23, tabs, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }
}
