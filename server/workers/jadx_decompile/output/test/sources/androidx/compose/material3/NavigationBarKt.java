package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: NavigationBar.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001ae\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00130\u001d¢\u0006\u0002\b\u001f¢\u0006\u0002\b H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001ak\u0010#\u001a\u00020\u00132\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020\u00130%¢\u0006\u0002\b\u001f2\u0011\u0010&\u001a\r\u0012\u0004\u0012\u00020\u00130%¢\u0006\u0002\b\u001f2\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00130%¢\u0006\u0002\b\u001f2\u0013\u0010(\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010%¢\u0006\u0002\b\u001f2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0003¢\u0006\u0002\u0010-\u001a\u0083\u0001\u0010.\u001a\u00020\u0013*\u00020\u001e2\u0006\u0010/\u001a\u00020*2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00130%2\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00130%¢\u0006\u0002\b\u001f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u00101\u001a\u00020*2\u0015\b\u0002\u0010(\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010%¢\u0006\u0002\b\u001f2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u000205H\u0007¢\u0006\u0002\u00106\u001a;\u00107\u001a\u000208*\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;2\b\u0010=\u001a\u0004\u0018\u00010;2\u0006\u0010>\u001a\u00020?H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001aS\u0010B\u001a\u000208*\u0002092\u0006\u0010C\u001a\u00020;2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;2\b\u0010=\u001a\u0004\u0018\u00010;2\u0006\u0010>\u001a\u00020?2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010E\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\f\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0019\u0010\r\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u000e\u0010\u000f\"\u0019\u0010\u0010\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0011\u0010\u000f\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006F"}, d2 = {"IconLayoutIdTag", "", "IndicatorHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "IndicatorLayoutIdTag", "IndicatorRippleLayoutIdTag", "IndicatorVerticalOffset", "IndicatorVerticalPadding", "ItemAnimationDurationMillis", "", "LabelLayoutIdTag", "NavigationBarHeight", "NavigationBarItemHorizontalPadding", "getNavigationBarItemHorizontalPadding", "()F", "NavigationBarItemVerticalPadding", "getNavigationBarItemVerticalPadding", "NavigationBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "NavigationBar-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationBarItemBaselineLayout", NavigationBarKt.IndicatorRippleLayoutIdTag, "Lkotlin/Function0;", NavigationBarKt.IndicatorLayoutIdTag, NavigationBarKt.IconLayoutIdTag, NavigationBarKt.LabelLayoutIdTag, "alwaysShowLabel", "", "animationProgress", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLandroidx/compose/runtime/Composer;I)V", "NavigationBarItem", "selected", "onClick", "enabled", "colors", "Landroidx/compose/material3/NavigationBarItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/layout/RowScope;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/NavigationBarItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "indicatorRipplePlaceable", "indicatorPlaceable", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-zUg2_y0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JZF)Landroidx/compose/ui/layout/MeasureResult;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class NavigationBarKt {
    private static final String IconLayoutIdTag = "icon";
    private static final float IndicatorHorizontalPadding;
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final float IndicatorVerticalOffset;
    private static final float IndicatorVerticalPadding;
    private static final int ItemAnimationDurationMillis = 100;
    private static final String LabelLayoutIdTag = "label";
    private static final float NavigationBarHeight = NavigationBarTokens.INSTANCE.m2286getContainerHeightD9Ej5fM();
    private static final float NavigationBarItemHorizontalPadding = Dp.m5218constructorimpl(8);
    private static final float NavigationBarItemVerticalPadding = Dp.m5218constructorimpl(16);

    /* JADX WARN: Removed duplicated region for block: B:42:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0111  */
    /* renamed from: NavigationBar-HsRjFd4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1611NavigationBarHsRjFd4(androidx.compose.ui.Modifier r26, long r27, long r29, float r31, androidx.compose.foundation.layout.WindowInsets r32, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instructions count: 467
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationBarKt.m1611NavigationBarHsRjFd4(androidx.compose.ui.Modifier, long, long, float, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x05d6  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0489  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0409  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void NavigationBarItem(final androidx.compose.foundation.layout.RowScope r50, final boolean r51, final kotlin.jvm.functions.Function0<kotlin.Unit> r52, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r53, androidx.compose.ui.Modifier r54, boolean r55, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r56, boolean r57, androidx.compose.material3.NavigationBarItemColors r58, androidx.compose.foundation.interaction.MutableInteractionSource r59, androidx.compose.runtime.Composer r60, final int r61, final int r62) {
        /*
            Method dump skipped, instructions count: 1558
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationBarKt.NavigationBarItem(androidx.compose.foundation.layout.RowScope, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, boolean, androidx.compose.material3.NavigationBarItemColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final int NavigationBarItem$lambda$3(MutableState<Integer> mutableState) {
        MutableState<Integer> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NavigationBarItem$lambda$4(MutableState<Integer> mutableState, int value) {
        mutableState.setValue(Integer.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float NavigationBarItem$lambda$9$lambda$6(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NavigationBarItemBaselineLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final boolean alwaysShowLabel, final float animationProgress, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(591111291);
        ComposerKt.sourceInformation($composer3, "C(NavigationBarItemBaselineLayout)P(4,3,2,5)434@18867L2465:NavigationBar.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer3.changedInstance(function22) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer3.changedInstance(function23) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer3.changedInstance(function24) ? 2048 : 1024;
        }
        if ((57344 & $changed) == 0) {
            $dirty |= $composer3.changed(alwaysShowLabel) ? 16384 : 8192;
        }
        if ((458752 & $changed) == 0) {
            $dirty |= $composer3.changed(animationProgress) ? 131072 : 65536;
        }
        int $dirty2 = $dirty;
        if ((374491 & $dirty2) != 74898 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(591111291, $dirty2, -1, "androidx.compose.material3.NavigationBarItemBaselineLayout (NavigationBar.kt:426)");
            }
            MeasurePolicy measurePolicy$iv = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItemBaselineLayout$2
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* renamed from: measure-3p2s80s */
                public final MeasureResult mo15measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> list, long constraints) {
                    float arg0$iv;
                    float arg0$iv2;
                    int totalIndicatorWidth;
                    Object element$iv;
                    Placeable labelPlaceable;
                    MeasureResult m1615placeLabelAndIconzUg2_y0;
                    MeasureResult m1614placeIconX9ElhV4;
                    long m5164copyZbe2FdA;
                    MeasureScope Layout = $this$Layout;
                    Iterable measurables = list;
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                    for (Object element$iv2 : measurables) {
                        Measurable it = (Measurable) element$iv2;
                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it), "icon")) {
                            Placeable iconPlaceable = ((Measurable) element$iv2).mo4186measureBRTryo0(constraints);
                            int width = iconPlaceable.getWidth();
                            arg0$iv = NavigationBarKt.IndicatorHorizontalPadding;
                            int totalIndicatorWidth2 = width + Layout.mo323roundToPx0680j_4(Dp.m5218constructorimpl(2 * arg0$iv));
                            int animatedIndicatorWidth = MathKt.roundToInt(totalIndicatorWidth2 * animationProgress);
                            int height = iconPlaceable.getHeight();
                            arg0$iv2 = NavigationBarKt.IndicatorVerticalPadding;
                            int indicatorHeight = height + Layout.mo323roundToPx0680j_4(Dp.m5218constructorimpl(2 * arg0$iv2));
                            Iterable $this$first$iv = measurables;
                            int $i$f$first = 0;
                            for (Object element$iv3 : $this$first$iv) {
                                Measurable it2 = (Measurable) element$iv3;
                                Iterable $this$first$iv2 = $this$first$iv;
                                int $i$f$first2 = $i$f$first;
                                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it2), "indicatorRipple")) {
                                    Placeable indicatorRipplePlaceable = ((Measurable) element$iv3).mo4186measureBRTryo0(Constraints.INSTANCE.m5182fixedJhjzzOo(totalIndicatorWidth2, indicatorHeight));
                                    Iterable $this$firstOrNull$iv = measurables;
                                    Iterator it3 = $this$firstOrNull$iv.iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            element$iv = it3.next();
                                            Measurable it4 = (Measurable) element$iv;
                                            totalIndicatorWidth = totalIndicatorWidth2;
                                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it4), "indicator")) {
                                                break;
                                            }
                                            totalIndicatorWidth2 = totalIndicatorWidth;
                                        } else {
                                            totalIndicatorWidth = totalIndicatorWidth2;
                                            element$iv = null;
                                            break;
                                        }
                                    }
                                    Measurable measurable = (Measurable) element$iv;
                                    Placeable indicatorPlaceable = measurable != null ? measurable.mo4186measureBRTryo0(Constraints.INSTANCE.m5182fixedJhjzzOo(animatedIndicatorWidth, indicatorHeight)) : null;
                                    Function2 it5 = function24;
                                    if (it5 != null) {
                                        Iterable $this$first$iv3 = measurables;
                                        for (Object element$iv4 : $this$first$iv3) {
                                            Measurable it6 = (Measurable) element$iv4;
                                            Function2 it7 = it5;
                                            Iterable $this$first$iv4 = $this$first$iv3;
                                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it6), "label")) {
                                                m5164copyZbe2FdA = Constraints.m5164copyZbe2FdA(constraints, (r12 & 1) != 0 ? Constraints.m5176getMinWidthimpl(constraints) : 0, (r12 & 2) != 0 ? Constraints.m5174getMaxWidthimpl(constraints) : 0, (r12 & 4) != 0 ? Constraints.m5175getMinHeightimpl(constraints) : 0, (r12 & 8) != 0 ? Constraints.m5173getMaxHeightimpl(constraints) : 0);
                                                labelPlaceable = ((Measurable) element$iv4).mo4186measureBRTryo0(m5164copyZbe2FdA);
                                            } else {
                                                it5 = it7;
                                                $this$first$iv3 = $this$first$iv4;
                                            }
                                        }
                                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                                    }
                                    labelPlaceable = null;
                                    if (function24 == null) {
                                        m1614placeIconX9ElhV4 = NavigationBarKt.m1614placeIconX9ElhV4($this$Layout, iconPlaceable, indicatorRipplePlaceable, indicatorPlaceable, constraints);
                                        return m1614placeIconX9ElhV4;
                                    }
                                    Intrinsics.checkNotNull(labelPlaceable);
                                    m1615placeLabelAndIconzUg2_y0 = NavigationBarKt.m1615placeLabelAndIconzUg2_y0($this$Layout, labelPlaceable, iconPlaceable, indicatorRipplePlaceable, indicatorPlaceable, constraints, alwaysShowLabel, animationProgress);
                                    return m1615placeLabelAndIconzUg2_y0;
                                }
                                measurables = list;
                                $this$first$iv = $this$first$iv2;
                                $i$f$first = $i$f$first2;
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                        Layout = $this$Layout;
                        measurables = list;
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
            };
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
            Modifier modifier$iv = Modifier.INSTANCE;
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv = (Density) consume;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer3.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv = (LayoutDirection) consume2;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer3.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume3;
            Function0 factory$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv = LayoutKt.materializerOf(modifier$iv);
            int $changed$iv$iv = ((0 << 9) & 7168) | 6;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.m2583constructorimpl($composer3);
            Updater.m2590setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2590setimpl($this$Layout_u24lambda_u240$iv, density$iv, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2590setimpl($this$Layout_u24lambda_u240$iv, layoutDirection$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2590setimpl($this$Layout_u24lambda_u240$iv, viewConfiguration$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            skippableUpdate$iv$iv.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int i = ($changed$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -311734425, "C435@18884L17,440@18982L50:NavigationBar.kt#uh7d8r");
            function2.invoke($composer3, Integer.valueOf($dirty2 & 14));
            $composer3.startReplaceableGroup(-311734399);
            ComposerKt.sourceInformation($composer3, "437@18951L11");
            if (animationProgress > 0.0f) {
                function22.invoke($composer3, Integer.valueOf(($dirty2 >> 3) & 14));
            }
            $composer3.endReplaceableGroup();
            Modifier modifier$iv2 = LayoutIdKt.layoutId(Modifier.INSTANCE, IconLayoutIdTag);
            $composer3.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = $composer3.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv$iv = (Density) consume4;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume5 = $composer3.consume(localLayoutDirection2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume5;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume6 = $composer3.consume(localViewConfiguration2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume6;
            Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv2);
            int $changed$iv$iv$iv = ((((6 << 3) & 112) << 9) & 7168) | 6;
            $composer2 = $composer3;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                $composer3.useNode();
            }
            $composer3.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2583constructorimpl($composer3);
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            $composer3.enableReusing();
            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int i2 = ($changed$iv$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i3 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1248851348, "C440@19024L6:NavigationBar.kt#uh7d8r");
            function23.invoke($composer3, Integer.valueOf(($dirty2 >> 6) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endReplaceableGroup();
            $composer3.endNode();
            $composer3.endReplaceableGroup();
            $composer3.endReplaceableGroup();
            $composer3.startReplaceableGroup(1204551908);
            ComposerKt.sourceInformation($composer3, "443@19075L260");
            if (function24 != null) {
                Modifier alpha = AlphaKt.alpha(LayoutIdKt.layoutId(Modifier.INSTANCE, LabelLayoutIdTag), alwaysShowLabel ? 1.0f : animationProgress);
                float arg0$iv = NavigationBarItemHorizontalPadding;
                Modifier modifier$iv3 = PaddingKt.m486paddingVpY3zN4$default(alpha, Dp.m5218constructorimpl(arg0$iv / 2), 0.0f, 2, null);
                $composer3.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                $composer3.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume7 = $composer3.consume(localDensity3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density density$iv$iv2 = (Density) consume7;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume8 = $composer3.consume(localLayoutDirection3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume8;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume9 = $composer3.consume(localViewConfiguration3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume9;
                Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv3);
                int $changed$iv$iv$iv2 = ((((0 << 3) & 112) << 9) & 7168) | 6;
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    $composer3.createNode(factory$iv$iv$iv2);
                } else {
                    $composer3.useNode();
                }
                $composer3.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2583constructorimpl($composer3);
                Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                $composer3.enableReusing();
                skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                $composer3.startReplaceableGroup(2058660585);
                int i4 = ($changed$iv$iv$iv2 >> 9) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                int i5 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 1248851650, "C448@19326L7:NavigationBar.kt#uh7d8r");
                function24.invoke($composer3, Integer.valueOf(($dirty2 >> 9) & 14));
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endReplaceableGroup();
                $composer3.endNode();
                $composer3.endReplaceableGroup();
                $composer3.endReplaceableGroup();
            }
            $composer3.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItemBaselineLayout$3
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

            public final void invoke(Composer composer, int i6) {
                NavigationBarKt.NavigationBarItemBaselineLayout(function2, function22, function23, function24, alwaysShowLabel, animationProgress, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: placeIcon-X9ElhV4, reason: not valid java name */
    public static final MeasureResult m1614placeIconX9ElhV4(MeasureScope $this$placeIcon_u2dX9ElhV4, final Placeable iconPlaceable, final Placeable indicatorRipplePlaceable, final Placeable indicatorPlaceable, long constraints) {
        final int width = Constraints.m5174getMaxWidthimpl(constraints);
        final int height = Constraints.m5173getMaxHeightimpl(constraints);
        final int iconX = (width - iconPlaceable.getWidth()) / 2;
        final int iconY = (height - iconPlaceable.getHeight()) / 2;
        final int rippleX = (width - indicatorRipplePlaceable.getWidth()) / 2;
        final int rippleY = (height - indicatorRipplePlaceable.getHeight()) / 2;
        return MeasureScope.layout$default($this$placeIcon_u2dX9ElhV4, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$placeIcon$1
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
                Placeable it = Placeable.this;
                if (it != null) {
                    int i = width;
                    int i2 = height;
                    int indicatorX = (i - it.getWidth()) / 2;
                    int indicatorY = (i2 - it.getHeight()) / 2;
                    Placeable.PlacementScope.placeRelative$default(layout, it, indicatorX, indicatorY, 0.0f, 4, null);
                }
                Placeable.PlacementScope.placeRelative$default(layout, iconPlaceable, iconX, iconY, 0.0f, 4, null);
                Placeable.PlacementScope.placeRelative$default(layout, indicatorRipplePlaceable, rippleX, rippleY, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: placeLabelAndIcon-zUg2_y0, reason: not valid java name */
    public static final MeasureResult m1615placeLabelAndIconzUg2_y0(final MeasureScope $this$placeLabelAndIcon_u2dzUg2_y0, final Placeable labelPlaceable, final Placeable iconPlaceable, final Placeable indicatorRipplePlaceable, final Placeable indicatorPlaceable, long constraints, final boolean alwaysShowLabel, final float animationProgress) {
        int height = Constraints.m5173getMaxHeightimpl(constraints);
        final int labelY = (height - labelPlaceable.getHeight()) - $this$placeLabelAndIcon_u2dzUg2_y0.mo323roundToPx0680j_4(NavigationBarItemVerticalPadding);
        final int selectedIconY = $this$placeLabelAndIcon_u2dzUg2_y0.mo323roundToPx0680j_4(NavigationBarItemVerticalPadding);
        int unselectedIconY = alwaysShowLabel ? selectedIconY : (height - iconPlaceable.getHeight()) / 2;
        int iconDistance = unselectedIconY - selectedIconY;
        final int offset = MathKt.roundToInt(iconDistance * (1 - animationProgress));
        final int containerWidth = Constraints.m5174getMaxWidthimpl(constraints);
        final int labelX = (containerWidth - labelPlaceable.getWidth()) / 2;
        final int iconX = (containerWidth - iconPlaceable.getWidth()) / 2;
        final int rippleX = (containerWidth - indicatorRipplePlaceable.getWidth()) / 2;
        final int rippleY = selectedIconY - $this$placeLabelAndIcon_u2dzUg2_y0.mo323roundToPx0680j_4(IndicatorVerticalPadding);
        return MeasureScope.layout$default($this$placeLabelAndIcon_u2dzUg2_y0, containerWidth, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$placeLabelAndIcon$1
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

            /* JADX WARN: Code restructure failed: missing block: B:9:0x003c, code lost:
            
                if ((r19 == 0.0f) == false) goto L12;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void invoke2(androidx.compose.ui.layout.Placeable.PlacementScope r11) {
                /*
                    r10 = this;
                    java.lang.String r0 = "$this$layout"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
                    androidx.compose.ui.layout.Placeable r2 = androidx.compose.ui.layout.Placeable.this
                    if (r2 == 0) goto L2e
                    int r0 = r30
                    int r1 = r26
                    androidx.compose.ui.layout.MeasureScope r3 = r31
                    int r4 = r23
                    r8 = 0
                    int r5 = r2.getWidth()
                    int r0 = r0 - r5
                    int r0 = r0 / 2
                    float r5 = androidx.compose.material3.NavigationBarKt.access$getIndicatorVerticalPadding$p()
                    int r3 = r3.mo323roundToPx0680j_4(r5)
                    int r9 = r1 - r3
                    int r4 = r4 + r9
                    r6 = 4
                    r7 = 0
                    r5 = 0
                    r1 = r11
                    r3 = r0
                    androidx.compose.ui.layout.Placeable.PlacementScope.placeRelative$default(r1, r2, r3, r4, r5, r6, r7)
                L2e:
                    boolean r0 = r18
                    if (r0 != 0) goto L3e
                    float r0 = r19
                    r1 = 0
                    int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                    if (r0 != 0) goto L3b
                    r0 = 1
                    goto L3c
                L3b:
                    r0 = 0
                L3c:
                    if (r0 != 0) goto L4f
                L3e:
                    androidx.compose.ui.layout.Placeable r2 = r20
                    int r3 = r21
                    int r0 = r22
                    int r1 = r23
                    int r4 = r0 + r1
                    r6 = 4
                    r7 = 0
                    r5 = 0
                    r1 = r11
                    androidx.compose.ui.layout.Placeable.PlacementScope.placeRelative$default(r1, r2, r3, r4, r5, r6, r7)
                L4f:
                    androidx.compose.ui.layout.Placeable r2 = r24
                    int r3 = r25
                    int r0 = r26
                    int r1 = r23
                    int r4 = r0 + r1
                    r6 = 4
                    r7 = 0
                    r5 = 0
                    r1 = r11
                    androidx.compose.ui.layout.Placeable.PlacementScope.placeRelative$default(r1, r2, r3, r4, r5, r6, r7)
                    androidx.compose.ui.layout.Placeable r2 = r27
                    int r3 = r28
                    int r0 = r29
                    int r1 = r23
                    int r4 = r0 + r1
                    r1 = r11
                    androidx.compose.ui.layout.Placeable.PlacementScope.placeRelative$default(r1, r2, r3, r4, r5, r6, r7)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationBarKt$placeLabelAndIcon$1.invoke2(androidx.compose.ui.layout.Placeable$PlacementScope):void");
            }
        }, 4, null);
    }

    static {
        float arg0$iv = NavigationBarTokens.INSTANCE.m2284getActiveIndicatorWidthD9Ej5fM();
        float other$iv = NavigationBarTokens.INSTANCE.m2287getIconSizeD9Ej5fM();
        IndicatorHorizontalPadding = Dp.m5218constructorimpl(Dp.m5218constructorimpl(arg0$iv - other$iv) / 2);
        float arg0$iv2 = NavigationBarTokens.INSTANCE.m2283getActiveIndicatorHeightD9Ej5fM();
        float other$iv2 = NavigationBarTokens.INSTANCE.m2287getIconSizeD9Ej5fM();
        IndicatorVerticalPadding = Dp.m5218constructorimpl(Dp.m5218constructorimpl(arg0$iv2 - other$iv2) / 2);
        IndicatorVerticalOffset = Dp.m5218constructorimpl(12);
    }

    public static final float getNavigationBarItemHorizontalPadding() {
        return NavigationBarItemHorizontalPadding;
    }

    public static final float getNavigationBarItemVerticalPadding() {
        return NavigationBarItemVerticalPadding;
    }
}
