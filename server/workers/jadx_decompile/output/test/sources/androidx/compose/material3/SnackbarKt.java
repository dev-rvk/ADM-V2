package androidx.compose.material3;

import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.SnackbarTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
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
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
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
import kotlin.ranges.RangesKt;

/* compiled from: Snackbar.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001ah\u0010\n\u001a\u00020\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001aj\u0010\u0018\u001a\u00020\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0014H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0017\u001am\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u00142\b\b\u0002\u0010&\u001a\u00020\u00142\b\b\u0002\u0010'\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a\u009c\u0001\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020 2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u00142\b\b\u0002\u0010&\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0006\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0007\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\b\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\t\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"ContainerMaxWidth", "Landroidx/compose/ui/unit/Dp;", "F", "HeightToFirstLine", "HorizontalSpacing", "HorizontalSpacingButtonSide", "LongButtonVerticalOffset", "SeparateButtonExtraY", "SnackbarVerticalPadding", "TextEndExtraSpacing", "NewLineButtonSnackbar", "", "text", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "action", "dismissAction", "actionTextStyle", "Landroidx/compose/ui/text/TextStyle;", "actionContentColor", "Landroidx/compose/ui/graphics/Color;", "dismissActionContentColor", "NewLineButtonSnackbar-kKq0p4A", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JJLandroidx/compose/runtime/Composer;I)V", "OneRowSnackbar", "actionTextColor", "dismissActionColor", "OneRowSnackbar-kKq0p4A", "Snackbar", "snackbarData", "Landroidx/compose/material3/SnackbarData;", "modifier", "Landroidx/compose/ui/Modifier;", "actionOnNewLine", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "contentColor", "actionColor", "Snackbar-sDKtq54", "(Landroidx/compose/material3/SnackbarData;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJJJJLandroidx/compose/runtime/Composer;II)V", "content", "Snackbar-eQBnUkQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/graphics/Shape;JJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SnackbarKt {
    private static final float ContainerMaxWidth = Dp.m5218constructorimpl(600);
    private static final float HeightToFirstLine = Dp.m5218constructorimpl(30);
    private static final float HorizontalSpacing = Dp.m5218constructorimpl(16);
    private static final float HorizontalSpacingButtonSide = Dp.m5218constructorimpl(8);
    private static final float SeparateButtonExtraY = Dp.m5218constructorimpl(2);
    private static final float SnackbarVerticalPadding = Dp.m5218constructorimpl(6);
    private static final float TextEndExtraSpacing = Dp.m5218constructorimpl(8);
    private static final float LongButtonVerticalOffset = Dp.m5218constructorimpl(12);

    /* JADX WARN: Removed duplicated region for block: B:101:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01dd  */
    /* renamed from: Snackbar-eQBnUkQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1709SnackbareQBnUkQ(androidx.compose.ui.Modifier r34, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, boolean r37, androidx.compose.ui.graphics.Shape r38, long r39, long r41, long r43, long r45, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, androidx.compose.runtime.Composer r48, final int r49, final int r50) {
        /*
            Method dump skipped, instructions count: 764
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnackbarKt.m1709SnackbareQBnUkQ(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.graphics.Shape, long, long, long, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: Snackbar-sDKtq54, reason: not valid java name */
    public static final void m1710SnackbarsDKtq54(final SnackbarData snackbarData, Modifier modifier, boolean actionOnNewLine, Shape shape, long containerColor, long contentColor, long actionColor, long actionContentColor, long dismissActionContentColor, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        Shape shape2;
        long contentColor2;
        long actionColor2;
        int $dirty;
        Modifier.Companion modifier3;
        boolean actionOnNewLine2;
        Shape shape3;
        long containerColor2;
        long actionContentColor2;
        long dismissActionContentColor2;
        long actionContentColor3;
        Function2 actionComposable;
        Modifier modifier4;
        boolean actionOnNewLine3;
        Shape shape4;
        long containerColor3;
        long contentColor3;
        long actionColor3;
        int i2;
        int $dirty2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Intrinsics.checkNotNullParameter(snackbarData, "snackbarData");
        Composer $composer2 = $composer.startRestartGroup(274621471);
        ComposerKt.sourceInformation($composer2, "C(Snackbar)P(8,6,2,7,3:c#ui.graphics.Color,4:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color)201@9465L5,202@9517L5,203@9567L12,204@9623L11,205@9685L18,206@9761L25,236@10774L456:Snackbar.kt#uh7d8r");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer2.changed(snackbarData) ? 4 : 2;
        }
        int i8 = i & 2;
        if (i8 != 0) {
            $dirty3 |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i9 = i & 4;
        if (i9 != 0) {
            $dirty3 |= 384;
            z = actionOnNewLine;
        } else if (($changed & 896) == 0) {
            z = actionOnNewLine;
            $dirty3 |= $composer2.changed(z) ? 256 : 128;
        } else {
            z = actionOnNewLine;
        }
        if (($changed & 7168) == 0) {
            if ((i & 8) == 0) {
                shape2 = shape;
                if ($composer2.changed(shape2)) {
                    i7 = 2048;
                    $dirty3 |= i7;
                }
            } else {
                shape2 = shape;
            }
            i7 = 1024;
            $dirty3 |= i7;
        } else {
            shape2 = shape;
        }
        if (($changed & 57344) == 0) {
            if ((i & 16) == 0 && $composer2.changed(containerColor)) {
                i6 = 16384;
                $dirty3 |= i6;
            }
            i6 = 8192;
            $dirty3 |= i6;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0) {
                contentColor2 = contentColor;
                if ($composer2.changed(contentColor2)) {
                    i5 = 131072;
                    $dirty3 |= i5;
                }
            } else {
                contentColor2 = contentColor;
            }
            i5 = 65536;
            $dirty3 |= i5;
        } else {
            contentColor2 = contentColor;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0) {
                actionColor2 = actionColor;
                if ($composer2.changed(actionColor2)) {
                    i4 = 1048576;
                    $dirty3 |= i4;
                }
            } else {
                actionColor2 = actionColor;
            }
            i4 = 524288;
            $dirty3 |= i4;
        } else {
            actionColor2 = actionColor;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0) {
                $dirty2 = $dirty3;
                if ($composer2.changed(actionContentColor)) {
                    i3 = 8388608;
                    $dirty = $dirty2 | i3;
                }
            } else {
                $dirty2 = $dirty3;
            }
            i3 = 4194304;
            $dirty = $dirty2 | i3;
        } else {
            $dirty = $dirty3;
        }
        if (($changed & 234881024) == 0) {
            if ((i & 256) == 0 && $composer2.changed(dismissActionContentColor)) {
                i2 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                $dirty |= i2;
            }
            i2 = 33554432;
            $dirty |= i2;
        }
        final int $dirty4 = $dirty;
        if (($dirty4 & 191739611) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            containerColor3 = containerColor;
            actionContentColor3 = actionContentColor;
            dismissActionContentColor2 = dismissActionContentColor;
            modifier4 = modifier2;
            actionOnNewLine3 = z;
            shape4 = shape2;
            contentColor3 = contentColor2;
            actionColor3 = actionColor2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i8 != 0 ? Modifier.INSTANCE : modifier2;
                actionOnNewLine2 = i9 != 0 ? false : z;
                if ((i & 8) != 0) {
                    shape3 = SnackbarDefaults.INSTANCE.getShape($composer2, 6);
                    $dirty4 &= -7169;
                } else {
                    shape3 = shape2;
                }
                if ((i & 16) != 0) {
                    containerColor2 = SnackbarDefaults.INSTANCE.getColor($composer2, 6);
                    $dirty4 &= -57345;
                } else {
                    containerColor2 = containerColor;
                }
                if ((i & 32) != 0) {
                    contentColor2 = SnackbarDefaults.INSTANCE.getContentColor($composer2, 6);
                    $dirty4 &= -458753;
                }
                if ((i & 64) != 0) {
                    actionColor2 = SnackbarDefaults.INSTANCE.getActionColor($composer2, 6);
                    $dirty4 &= -3670017;
                }
                if ((i & 128) != 0) {
                    actionContentColor2 = SnackbarDefaults.INSTANCE.getActionContentColor($composer2, 6);
                    $dirty4 &= -29360129;
                } else {
                    actionContentColor2 = actionContentColor;
                }
                if ((i & 256) != 0) {
                    $dirty4 = (-234881025) & $dirty4;
                    actionContentColor3 = actionContentColor2;
                    dismissActionContentColor2 = SnackbarDefaults.INSTANCE.getDismissActionContentColor($composer2, 6);
                } else {
                    dismissActionContentColor2 = dismissActionContentColor;
                    actionContentColor3 = actionContentColor2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty4 &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty4 &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty4 &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty4 &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty4 &= -29360129;
                }
                if ((i & 256) != 0) {
                    actionContentColor3 = actionContentColor;
                    dismissActionContentColor2 = dismissActionContentColor;
                    $dirty4 = (-234881025) & $dirty4;
                    modifier3 = modifier2;
                    actionOnNewLine2 = z;
                    shape3 = shape2;
                    containerColor2 = containerColor;
                } else {
                    actionContentColor3 = actionContentColor;
                    dismissActionContentColor2 = dismissActionContentColor;
                    modifier3 = modifier2;
                    actionOnNewLine2 = z;
                    shape3 = shape2;
                    containerColor2 = containerColor;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(274621471, $dirty4, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:197)");
            }
            final String actionLabel = snackbarData.getVisuals().getActionLabel();
            if (actionLabel != null) {
                final long j = actionColor2;
                final int i10 = $dirty4;
                actionComposable = ComposableLambdaKt.composableLambda($composer2, -1378313599, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        ComposerKt.sourceInformation($composer3, "C212@10014L44,213@10086L32,211@9962L219:Snackbar.kt#uh7d8r");
                        if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1378313599, $changed2, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:210)");
                            }
                            ButtonColors m1333textButtonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1333textButtonColorsro_MJ88(0L, j, 0L, 0L, $composer3, ((i10 >> 15) & 112) | 24576, 13);
                            Object key1$iv = snackbarData;
                            final SnackbarData snackbarData2 = snackbarData;
                            int i11 = i10 & 14;
                            $composer3.startReplaceableGroup(1157296644);
                            ComposerKt.sourceInformation($composer3, "CC(remember)P(1):Composables.kt#9igjgp");
                            boolean invalid$iv$iv = $composer3.changed(key1$iv);
                            Object it$iv$iv = $composer3.rememberedValue();
                            if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                                value$iv$iv = new Function0<Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        SnackbarData.this.performAction();
                                    }
                                };
                                $composer3.updateRememberedValue(value$iv$iv);
                            } else {
                                value$iv$iv = it$iv$iv;
                            }
                            $composer3.endReplaceableGroup();
                            Object key1$iv2 = value$iv$iv;
                            final String str = actionLabel;
                            ButtonKt.TextButton((Function0) key1$iv2, null, false, null, m1333textButtonColorsro_MJ88, null, null, null, null, ComposableLambdaKt.composableLambda($composer3, 521110564, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                                    invoke(rowScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(RowScope TextButton, Composer $composer4, int $changed3) {
                                    Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                                    ComposerKt.sourceInformation($composer4, "C214@10148L17:Snackbar.kt#uh7d8r");
                                    if (($changed3 & 81) == 16 && $composer4.getSkipping()) {
                                        $composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(521110564, $changed3, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:214)");
                                    }
                                    TextKt.m1872Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 131070);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), $composer3, 805306368, 494);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                });
            } else {
                actionComposable = null;
            }
            Function2 dismissActionComposable = snackbarData.getVisuals().getWithDismissAction() ? ComposableLambdaKt.composableLambda($composer2, -1812633777, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$dismissActionComposable$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    ComposerKt.sourceInformation($composer3, "C224@10423L26,223@10381L330:Snackbar.kt#uh7d8r");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1812633777, $changed2, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:222)");
                        }
                        Object key1$iv = SnackbarData.this;
                        final SnackbarData snackbarData2 = SnackbarData.this;
                        int i11 = $dirty4 & 14;
                        $composer3.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation($composer3, "CC(remember)P(1):Composables.kt#9igjgp");
                        boolean invalid$iv$iv = $composer3.changed(key1$iv);
                        Object it$iv$iv = $composer3.rememberedValue();
                        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv = new Function0<Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$dismissActionComposable$1$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    SnackbarData.this.dismiss();
                                }
                            };
                            $composer3.updateRememberedValue(value$iv$iv);
                        } else {
                            value$iv$iv = it$iv$iv;
                        }
                        $composer3.endReplaceableGroup();
                        Object key1$iv2 = value$iv$iv;
                        IconButtonKt.IconButton((Function0) key1$iv2, null, false, null, null, ComposableSingletons$SnackbarKt.INSTANCE.m1446getLambda1$material3_release(), $composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }) : null;
            m1709SnackbareQBnUkQ(PaddingKt.m484padding3ABfNKs(modifier3, Dp.m5218constructorimpl(12)), actionComposable, dismissActionComposable, actionOnNewLine2, shape3, containerColor2, contentColor2, actionContentColor3, dismissActionContentColor2, ComposableLambdaKt.composableLambda($composer2, -1266389126, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C246@11188L34:Snackbar.kt#uh7d8r");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1266389126, $changed2, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:246)");
                    }
                    TextKt.m1872Text4IGK_g(SnackbarData.this.getVisuals().getMessage(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), $composer2, (($dirty4 << 3) & 7168) | 805306368 | (($dirty4 << 3) & 57344) | (($dirty4 << 3) & 458752) | (($dirty4 << 3) & 3670016) | ($dirty4 & 29360128) | ($dirty4 & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            actionOnNewLine3 = actionOnNewLine2;
            shape4 = shape3;
            containerColor3 = containerColor2;
            contentColor3 = contentColor2;
            actionColor3 = actionColor2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier4;
        final boolean z2 = actionOnNewLine3;
        final Shape shape5 = shape4;
        final long j2 = containerColor3;
        final long j3 = contentColor3;
        final long j4 = actionColor3;
        final long j5 = actionContentColor3;
        final long j6 = dismissActionContentColor2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i11) {
                SnackbarKt.m1710SnackbarsDKtq54(SnackbarData.this, modifier5, z2, shape5, j2, j3, j4, j5, j6, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: NewLineButtonSnackbar-kKq0p4A, reason: not valid java name */
    public static final void m1707NewLineButtonSnackbarkKq0p4A(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final TextStyle actionTextStyle, final long actionContentColor, final long dismissActionContentColor, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-1332496681);
        ComposerKt.sourceInformation($composer3, "C(NewLineButtonSnackbar)P(5!1,3,2,1:c#ui.graphics.Color,4:c#ui.graphics.Color)259@11505L1173:Snackbar.kt#uh7d8r");
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
            $dirty |= $composer3.changed(actionTextStyle) ? 2048 : 1024;
        }
        if ((57344 & $changed) == 0) {
            $dirty |= $composer3.changed(actionContentColor) ? 16384 : 8192;
        }
        if ((458752 & $changed) == 0) {
            $dirty |= $composer3.changed(dismissActionContentColor) ? 131072 : 65536;
        }
        int $dirty2 = $dirty;
        if ((374491 & $dirty2) != 74898 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1332496681, $dirty2, -1, "androidx.compose.material3.NewLineButtonSnackbar (Snackbar.kt:251)");
            }
            Modifier modifier$iv = PaddingKt.m488paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.m538widthInVpY3zN4$default(Modifier.INSTANCE, 0.0f, ContainerMaxWidth, 1, null), 0.0f, 1, null), HorizontalSpacing, 0.0f, 0.0f, SeparateButtonExtraY, 6, null);
            $composer3.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation($composer3, "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
            int $i$f$Column = ((6 >> 3) & 14) | ((6 >> 3) & 112);
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, $i$f$Column);
            int $changed$iv$iv = (6 << 3) & 112;
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv$iv = (Density) consume;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer3.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer3.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
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
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            $composer3.enableReusing();
            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int i = ($changed$iv$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 276693704, "C79@4027L9:Column.kt#2w3rfo");
            int i2 = ((6 >> 6) & 112) | 6;
            ColumnScope $this$NewLineButtonSnackbar_kKq0p4A_u24lambda_u243 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -916592099, "C269@11812L171,274@11993L679:Snackbar.kt#uh7d8r");
            Modifier modifier$iv2 = PaddingKt.m488paddingqDBjuR0$default(AlignmentLineKt.m369paddingFromBaselineVpY3zN4(Modifier.INSTANCE, HeightToFirstLine, LongButtonVerticalOffset), 0.0f, 0.0f, HorizontalSpacingButtonSide, 0.0f, 11, null);
            $composer3.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            $composer2 = $composer3;
            MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv2 = (6 << 3) & 112;
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = $composer3.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv$iv2 = (Density) consume4;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume5 = $composer3.consume(localLayoutDirection2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume5;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume6 = $composer3.consume(localViewConfiguration2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume6;
            Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv2);
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
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
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            $composer3.enableReusing();
            skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int i3 = ($changed$iv$iv$iv2 >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i4 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 302366561, "C272@11975L6:Snackbar.kt#uh7d8r");
            function2.invoke($composer3, Integer.valueOf($dirty2 & 14));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endReplaceableGroup();
            $composer3.endNode();
            $composer3.endReplaceableGroup();
            $composer3.endReplaceableGroup();
            Modifier modifier$iv3 = PaddingKt.m488paddingqDBjuR0$default($this$NewLineButtonSnackbar_kKq0p4A_u24lambda_u243.align(Modifier.INSTANCE, Alignment.INSTANCE.getEnd()), 0.0f, 0.0f, function23 == null ? HorizontalSpacingButtonSide : Dp.m5218constructorimpl(0), 0.0f, 11, null);
            $composer3.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv3 = (0 << 3) & 112;
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume7 = $composer3.consume(localDensity3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv$iv3 = (Density) consume7;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume8 = $composer3.consume(localLayoutDirection3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv$iv3 = (LayoutDirection) consume8;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume9 = $composer3.consume(localViewConfiguration3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv$iv3 = (ViewConfiguration) consume9;
            Function0 factory$iv$iv$iv3 = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv$iv3 = LayoutKt.materializerOf(modifier$iv3);
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 9) & 7168) | 6;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv3);
            } else {
                $composer3.useNode();
            }
            $composer3.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv3 = Updater.m2583constructorimpl($composer3);
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv3, density$iv$iv3, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv3, layoutDirection$iv$iv3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv3, viewConfiguration$iv$iv3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            $composer3.enableReusing();
            skippableUpdate$iv$iv$iv3.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv3 >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int i5 = ($changed$iv$iv$iv3 >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 302366747, "C278@12161L501:Snackbar.kt#uh7d8r");
            $composer3.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation($composer3, "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
            Modifier modifier$iv4 = Modifier.INSTANCE;
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
            int $changed$iv = ((0 >> 3) & 14) | ((0 >> 3) & 112);
            MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, $changed$iv);
            int $changed$iv$iv4 = (0 << 3) & 112;
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume10 = $composer3.consume(localDensity4);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv$iv4 = (Density) consume10;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection4 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume11 = $composer3.consume(localLayoutDirection4);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv$iv4 = (LayoutDirection) consume11;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration4 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume12 = $composer3.consume(localViewConfiguration4);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv$iv4 = (ViewConfiguration) consume12;
            Function0 factory$iv$iv$iv4 = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv$iv4 = LayoutKt.materializerOf(modifier$iv4);
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 9) & 7168) | 6;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv4);
            } else {
                $composer3.useNode();
            }
            $composer3.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv4 = Updater.m2583constructorimpl($composer3);
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv4, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv4, density$iv$iv4, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv4, layoutDirection$iv$iv4, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv4, viewConfiguration$iv$iv4, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            $composer3.enableReusing();
            skippableUpdate$iv$iv$iv4.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv4 >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int i7 = ($changed$iv$iv$iv4 >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -326682283, "C80@4021L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            int i8 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 435596114, "C279@12183L208:Snackbar.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2939boximpl(actionContentColor)), TextKt.getLocalTextStyle().provides(actionTextStyle)}, function22, $composer3, ($dirty2 & 112) | 8);
            $composer3.startReplaceableGroup(302366994);
            ComposerKt.sourceInformation($composer3, "285@12457L173");
            if (function23 != null) {
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2939boximpl(dismissActionContentColor))}, function23, $composer3, (($dirty2 >> 3) & 112) | 8);
            }
            $composer3.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endReplaceableGroup();
            $composer3.endNode();
            $composer3.endReplaceableGroup();
            $composer3.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endReplaceableGroup();
            $composer3.endNode();
            $composer3.endReplaceableGroup();
            $composer3.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$NewLineButtonSnackbar$2
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
                SnackbarKt.m1707NewLineButtonSnackbarkKq0p4A(function2, function22, function23, actionTextStyle, actionContentColor, dismissActionContentColor, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OneRowSnackbar-kKq0p4A, reason: not valid java name */
    public static final void m1708OneRowSnackbarkKq0p4A(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final TextStyle actionTextStyle, final long actionTextColor, final long dismissActionColor, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-903235475);
        ComposerKt.sourceInformation($composer3, "C(OneRowSnackbar)P(5!1,3,2,1:c#ui.graphics.Color,4:c#ui.graphics.Color)307@13036L4435:Snackbar.kt#uh7d8r");
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
            $dirty |= $composer3.changed(actionTextStyle) ? 2048 : 1024;
        }
        if ((57344 & $changed) == 0) {
            $dirty |= $composer3.changed(actionTextColor) ? 16384 : 8192;
        }
        if ((458752 & $changed) == 0) {
            $dirty |= $composer3.changed(dismissActionColor) ? 131072 : 65536;
        }
        int $dirty2 = $dirty;
        if ((374491 & $dirty2) != 74898 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-903235475, $dirty2, -1, "androidx.compose.material3.OneRowSnackbar (Snackbar.kt:296)");
            }
            final String textTag = "text";
            final String actionTag = "action";
            final String dismissActionTag = "dismissAction";
            Modifier modifier$iv = PaddingKt.m488paddingqDBjuR0$default(Modifier.INSTANCE, HorizontalSpacing, 0.0f, function23 == null ? HorizontalSpacingButtonSide : Dp.m5218constructorimpl(0), 0.0f, 10, null);
            MeasurePolicy measurePolicy$iv = new MeasurePolicy() { // from class: androidx.compose.material3.SnackbarKt$OneRowSnackbar$2
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* renamed from: measure-3p2s80s */
                public final MeasureResult mo15measure3p2s80s(MeasureScope Layout, List<? extends Measurable> measurables, long constraints) {
                    float f;
                    Object element$iv;
                    Object element$iv2;
                    int i;
                    Iterator it;
                    long m5164copyZbe2FdA;
                    float f2;
                    int containerHeight;
                    int i2;
                    int baselineOffset;
                    int textPlaceY;
                    final int dismissButtonPlaceY;
                    float f3;
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                    int m5174getMaxWidthimpl = Constraints.m5174getMaxWidthimpl(constraints);
                    f = SnackbarKt.ContainerMaxWidth;
                    int containerWidth = Math.min(m5174getMaxWidthimpl, Layout.mo323roundToPx0680j_4(f));
                    List<? extends Measurable> $this$firstOrNull$iv = measurables;
                    String str = actionTag;
                    Iterator it2 = $this$firstOrNull$iv.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            element$iv = it2.next();
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) element$iv), str)) {
                                break;
                            }
                        } else {
                            element$iv = null;
                            break;
                        }
                    }
                    Measurable measurable = (Measurable) element$iv;
                    final Placeable actionButtonPlaceable = measurable != null ? measurable.mo4186measureBRTryo0(constraints) : null;
                    List<? extends Measurable> $this$firstOrNull$iv2 = measurables;
                    String str2 = dismissActionTag;
                    Iterator it3 = $this$firstOrNull$iv2.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            element$iv2 = it3.next();
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) element$iv2), str2)) {
                                break;
                            }
                        } else {
                            element$iv2 = null;
                            break;
                        }
                    }
                    Measurable measurable2 = (Measurable) element$iv2;
                    final Placeable dismissButtonPlaceable = measurable2 != null ? measurable2.mo4186measureBRTryo0(constraints) : null;
                    int actionButtonWidth = actionButtonPlaceable != null ? actionButtonPlaceable.getWidth() : 0;
                    int actionButtonHeight = actionButtonPlaceable != null ? actionButtonPlaceable.getHeight() : 0;
                    int dismissButtonWidth = dismissButtonPlaceable != null ? dismissButtonPlaceable.getWidth() : 0;
                    int dismissButtonHeight = dismissButtonPlaceable != null ? dismissButtonPlaceable.getHeight() : 0;
                    if (dismissButtonWidth == 0) {
                        f3 = SnackbarKt.TextEndExtraSpacing;
                        i = Layout.mo323roundToPx0680j_4(f3);
                    } else {
                        i = 0;
                    }
                    int extraSpacingWidth = i;
                    int textMaxWidth = RangesKt.coerceAtLeast(((containerWidth - actionButtonWidth) - dismissButtonWidth) - extraSpacingWidth, Constraints.m5176getMinWidthimpl(constraints));
                    List<? extends Measurable> $this$first$iv = measurables;
                    String str3 = textTag;
                    for (Object element$iv3 : $this$first$iv) {
                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) element$iv3), str3)) {
                            m5164copyZbe2FdA = Constraints.m5164copyZbe2FdA(constraints, (r12 & 1) != 0 ? Constraints.m5176getMinWidthimpl(constraints) : 0, (r12 & 2) != 0 ? Constraints.m5174getMaxWidthimpl(constraints) : textMaxWidth, (r12 & 4) != 0 ? Constraints.m5175getMinHeightimpl(constraints) : 0, (r12 & 8) != 0 ? Constraints.m5173getMaxHeightimpl(constraints) : 0);
                            final Placeable textPlaceable = ((Measurable) element$iv3).mo4186measureBRTryo0(m5164copyZbe2FdA);
                            int firstTextBaseline = textPlaceable.get(androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline());
                            if (!(firstTextBaseline != Integer.MIN_VALUE)) {
                                throw new IllegalArgumentException("No baselines for text".toString());
                            }
                            int lastTextBaseline = textPlaceable.get(androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline());
                            if (!(lastTextBaseline != Integer.MIN_VALUE)) {
                                throw new IllegalArgumentException("No baselines for text".toString());
                            }
                            boolean isOneLine = firstTextBaseline == lastTextBaseline;
                            final int dismissButtonPlaceX = containerWidth - dismissButtonWidth;
                            final int actionButtonPlaceX = dismissButtonPlaceX - actionButtonWidth;
                            if (!isOneLine) {
                                f2 = SnackbarKt.HeightToFirstLine;
                                int baselineOffset2 = Layout.mo323roundToPx0680j_4(f2);
                                int textPlaceY2 = baselineOffset2 - firstTextBaseline;
                                int minContainerHeight = Layout.mo323roundToPx0680j_4(SnackbarTokens.INSTANCE.m2446getTwoLinesContainerHeightD9Ej5fM());
                                int contentHeight = textPlaceY2 + textPlaceable.getHeight();
                                containerHeight = Math.max(minContainerHeight, contentHeight);
                                if (actionButtonPlaceable != null) {
                                    i2 = (containerHeight - actionButtonPlaceable.getHeight()) / 2;
                                } else {
                                    i2 = 0;
                                }
                                int actionButtonPlaceY = i2;
                                baselineOffset = actionButtonPlaceY;
                                textPlaceY = textPlaceY2;
                            } else {
                                int minContainerHeight2 = Layout.mo323roundToPx0680j_4(SnackbarTokens.INSTANCE.m2445getSingleLineContainerHeightD9Ej5fM());
                                int contentHeight2 = Math.max(actionButtonHeight, dismissButtonHeight);
                                containerHeight = Math.max(minContainerHeight2, contentHeight2);
                                int textPlaceY3 = (containerHeight - textPlaceable.getHeight()) / 2;
                                if (actionButtonPlaceable != null) {
                                    int it4 = actionButtonPlaceable.get(androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline());
                                    if (it4 != Integer.MIN_VALUE) {
                                        baselineOffset = (textPlaceY3 + firstTextBaseline) - it4;
                                    } else {
                                        baselineOffset = 0;
                                    }
                                } else {
                                    baselineOffset = 0;
                                }
                                textPlaceY = textPlaceY3;
                            }
                            if (dismissButtonPlaceable != null) {
                                dismissButtonPlaceY = (containerHeight - dismissButtonPlaceable.getHeight()) / 2;
                            } else {
                                dismissButtonPlaceY = 0;
                            }
                            final int i3 = textPlaceY;
                            final int i4 = baselineOffset;
                            int dismissButtonHeight2 = containerHeight;
                            return MeasureScope.layout$default(Layout, containerWidth, dismissButtonHeight2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SnackbarKt$OneRowSnackbar$2$measure$4
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
                                    Placeable.PlacementScope.placeRelative$default(layout, Placeable.this, 0, i3, 0.0f, 4, null);
                                    Placeable placeable = dismissButtonPlaceable;
                                    if (placeable != null) {
                                        Placeable.PlacementScope.placeRelative$default(layout, placeable, dismissButtonPlaceX, dismissButtonPlaceY, 0.0f, 4, null);
                                    }
                                    Placeable placeable2 = actionButtonPlaceable;
                                    if (placeable2 != null) {
                                        Placeable.PlacementScope.placeRelative$default(layout, placeable2, actionButtonPlaceX, i4, 0.0f, 4, null);
                                    }
                                }
                            }, 4, null);
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
            };
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
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
            ComposerKt.sourceInformationMarkerStart($composer3, -167734449, "C309@13066L86:Snackbar.kt#uh7d8r");
            Modifier modifier$iv2 = PaddingKt.m486paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "text"), 0.0f, SnackbarVerticalPadding, 1, null);
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
            $composer2 = $composer3;
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
            ComposerKt.sourceInformationMarkerStart($composer3, 448288318, "C309@13144L6:Snackbar.kt#uh7d8r");
            function2.invoke($composer3, Integer.valueOf($dirty2 & 14));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endReplaceableGroup();
            $composer3.endNode();
            $composer3.endReplaceableGroup();
            $composer3.endReplaceableGroup();
            $composer3.startReplaceableGroup(-167734350);
            ComposerKt.sourceInformation($composer3, "311@13203L295");
            if (function22 != null) {
                Modifier modifier$iv3 = LayoutIdKt.layoutId(Modifier.INSTANCE, "action");
                $composer3.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
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
                int $changed$iv$iv$iv2 = ((((6 << 3) & 112) << 9) & 7168) | 6;
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
                int i5 = ((6 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 448288433, "C312@13259L221:Snackbar.kt#uh7d8r");
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2939boximpl(actionTextColor)), TextKt.getLocalTextStyle().provides(actionTextStyle)}, function22, $composer3, ($dirty2 & 112) | 8);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endReplaceableGroup();
                $composer3.endNode();
                $composer3.endReplaceableGroup();
                $composer3.endReplaceableGroup();
            }
            $composer3.endReplaceableGroup();
            $composer3.startReplaceableGroup(44738809);
            ComposerKt.sourceInformation($composer3, "320@13570L247");
            if (function23 != null) {
                Modifier modifier$iv4 = LayoutIdKt.layoutId(Modifier.INSTANCE, "dismissAction");
                $composer3.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv3 = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv4 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv3, false, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                $composer3.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume10 = $composer3.consume(localDensity4);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density density$iv$iv3 = (Density) consume10;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection4 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume11 = $composer3.consume(localLayoutDirection4);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                LayoutDirection layoutDirection$iv$iv3 = (LayoutDirection) consume11;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration4 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume12 = $composer3.consume(localViewConfiguration4);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ViewConfiguration viewConfiguration$iv$iv3 = (ViewConfiguration) consume12;
                Function0 factory$iv$iv$iv3 = ComposeUiNode.INSTANCE.getConstructor();
                Function3 skippableUpdate$iv$iv$iv3 = LayoutKt.materializerOf(modifier$iv4);
                int $changed$iv$iv$iv3 = ((((6 << 3) & 112) << 9) & 7168) | 6;
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    $composer3.createNode(factory$iv$iv$iv3);
                } else {
                    $composer3.useNode();
                }
                $composer3.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv3 = Updater.m2583constructorimpl($composer3);
                Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv3, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv3, density$iv$iv3, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv3, layoutDirection$iv$iv3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv3, viewConfiguration$iv$iv3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                $composer3.enableReusing();
                skippableUpdate$iv$iv$iv3.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv3 >> 3) & 112));
                $composer3.startReplaceableGroup(2058660585);
                int i6 = ($changed$iv$iv$iv3 >> 9) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                int i7 = ((6 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 448288807, "C321@13633L166:Snackbar.kt#uh7d8r");
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2939boximpl(dismissActionColor))}, function23, $composer3, (($dirty2 >> 3) & 112) | 8);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$OneRowSnackbar$3
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

            public final void invoke(Composer composer, int i8) {
                SnackbarKt.m1708OneRowSnackbarkKq0p4A(function2, function22, function23, actionTextStyle, actionTextColor, dismissActionColor, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }
}
