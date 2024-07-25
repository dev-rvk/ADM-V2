package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: BottomSheetScaffold.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0017\u001a\u0083\u0002\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\f2\u0015\b\u0002\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015¢\u0006\u0002\b\u00052\u0019\b\u0002\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00102\b\b\u0002\u0010\u001c\u001a\u00020\u00102\u0017\u0010\u001d\u001a\u0013\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 \u001aq\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020%26\u0010&\u001a2\u0012\u0013\u0012\u00110#¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110+¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u00010'2!\u0010-\u001a\u001d\u0012\u0013\u0012\u00110#¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00010\u0003H\u0003\u001aÃ\u0001\u0010.\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015¢\u0006\u0002\b\u00052&\u0010/\u001a\"\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052&\u00101\u001a\"\u0012\u0013\u0012\u001102¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u00052\u0006\u0010\u000b\u001a\u00020\f2\f\u00104\u001a\b\u0012\u0004\u0012\u00020+0\u00152\u0006\u00105\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0010H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b6\u00107\u001a\u0090\u0001\u00108\u001a\u00020\u00012\u0006\u0010$\u001a\u00020%2\u0006\u00109\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u00103\u001a\u00020+2\u0006\u0010:\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010;\u001a\u00020\f2\u0006\u0010<\u001a\u00020\f2\u0013\u0010=\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015¢\u0006\u0002\b\u00052\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b>\u0010?\u001a!\u0010@\u001a\u00020\n2\b\b\u0002\u0010A\u001a\u00020%2\b\b\u0002\u0010B\u001a\u00020\u001aH\u0007¢\u0006\u0002\u0010C\u001a7\u0010D\u001a\u00020%2\b\b\u0002\u0010E\u001a\u00020#2\u0014\b\u0002\u0010F\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00170\u00032\b\b\u0002\u0010G\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010H\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006I"}, d2 = {"BottomSheetScaffold", "", "sheetContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material3/BottomSheetScaffoldState;", "sheetPeekHeight", "Landroidx/compose/ui/unit/Dp;", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetContainerColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "sheetTonalElevation", "sheetShadowElevation", "sheetDragHandle", "Lkotlin/Function0;", "sheetSwipeEnabled", "", "topBar", "snackbarHost", "Landroidx/compose/material3/SnackbarHostState;", "containerColor", "contentColor", "content", "Landroidx/compose/foundation/layout/PaddingValues;", "BottomSheetScaffold-6cEcpDs", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/BottomSheetScaffoldState;FLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "BottomSheetScaffoldAnchorChangeHandler", "Landroidx/compose/material3/AnchorChangeHandler;", "Landroidx/compose/material3/SheetValue;", "state", "Landroidx/compose/material3/SheetState;", "animateTo", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "target", "", "velocity", "snapTo", "BottomSheetScaffoldLayout", "body", "innerPadding", "bottomSheet", "", "layoutHeight", "sheetOffset", "sheetState", "BottomSheetScaffoldLayout-PxNyym8", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;FLkotlin/jvm/functions/Function0;Landroidx/compose/material3/SheetState;JJLandroidx/compose/runtime/Composer;I)V", "StandardBottomSheet", "peekHeight", "shape", "tonalElevation", "shadowElevation", "dragHandle", "StandardBottomSheet-8oydGBM", "(Landroidx/compose/material3/SheetState;FZFLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rememberBottomSheetScaffoldState", "bottomSheetState", "snackbarHostState", "(Landroidx/compose/material3/SheetState;Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/BottomSheetScaffoldState;", "rememberStandardBottomSheetState", "initialValue", "confirmValueChange", "skipHiddenState", "(Landroidx/compose/material3/SheetValue;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class BottomSheetScaffoldKt {
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01d3, code lost:
    
        if (r10.changed(r62) != false) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01f4, code lost:
    
        if (r10.changed(r64) == false) goto L163;
     */
    /* JADX WARN: Removed duplicated region for block: B:119:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0454 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x04da  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x04dd  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0265  */
    /* renamed from: BottomSheetScaffold-6cEcpDs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1315BottomSheetScaffold6cEcpDs(final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, androidx.compose.ui.Modifier r48, androidx.compose.material3.BottomSheetScaffoldState r49, float r50, androidx.compose.ui.graphics.Shape r51, long r52, long r54, float r56, float r57, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r58, boolean r59, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r60, kotlin.jvm.functions.Function3<? super androidx.compose.material3.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r61, long r62, long r64, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.PaddingValues, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r66, androidx.compose.runtime.Composer r67, final int r68, final int r69, final int r70) {
        /*
            Method dump skipped, instructions count: 1304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.BottomSheetScaffoldKt.m1315BottomSheetScaffold6cEcpDs(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material3.BottomSheetScaffoldState, float, androidx.compose.ui.graphics.Shape, long, long, float, float, kotlin.jvm.functions.Function2, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(SheetState bottomSheetState, SnackbarHostState snackbarHostState, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Object value$iv$iv2;
        $composer.startReplaceableGroup(-1474606134);
        ComposerKt.sourceInformation($composer, "C(rememberBottomSheetScaffoldState)167@7874L34,168@7953L32,170@8027L196:BottomSheetScaffold.kt#uh7d8r");
        if ((i & 1) != 0) {
            bottomSheetState = rememberStandardBottomSheetState(null, null, false, $composer, 0, 7);
        }
        if ((i & 2) != 0) {
            $composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv2 = new SnackbarHostState();
                $composer.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) value$iv$iv2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1474606134, $changed, -1, "androidx.compose.material3.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:166)");
        }
        int i2 = ($changed & 14) | ($changed & 112);
        $composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(bottomSheetState) | $composer.changed(snackbarHostState);
        Object it$iv$iv2 = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new BottomSheetScaffoldState(bottomSheetState, snackbarHostState);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        BottomSheetScaffoldState bottomSheetScaffoldState = (BottomSheetScaffoldState) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return bottomSheetScaffoldState;
    }

    public static final SheetState rememberStandardBottomSheetState(SheetValue initialValue, Function1<? super SheetValue, Boolean> function1, boolean skipHiddenState, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(678511581);
        ComposerKt.sourceInformation($composer, "C(rememberStandardBottomSheetState)P(1)192@8853L76:BottomSheetScaffold.kt#uh7d8r");
        if ((i & 1) != 0) {
            initialValue = SheetValue.PartiallyExpanded;
        }
        if ((i & 2) != 0) {
            Function1 confirmValueChange = new Function1<SheetValue, Boolean>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$rememberStandardBottomSheetState$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(SheetValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return true;
                }
            };
            function1 = confirmValueChange;
        }
        if ((i & 4) != 0) {
            skipHiddenState = true;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(678511581, $changed, -1, "androidx.compose.material3.rememberStandardBottomSheetState (BottomSheetScaffold.kt:188)");
        }
        SheetState rememberSheetState = SheetDefaultsKt.rememberSheetState(false, function1, initialValue, skipHiddenState, $composer, ($changed & 112) | 6 | (($changed << 6) & 896) | (($changed << 3) & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberSheetState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0312 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x025a  */
    /* renamed from: StandardBottomSheet-8oydGBM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1317StandardBottomSheet8oydGBM(final androidx.compose.material3.SheetState r34, final float r35, final boolean r36, final float r37, final androidx.compose.ui.graphics.Shape r38, final long r39, final long r41, final float r43, final float r44, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, androidx.compose.runtime.Composer r47, final int r48, final int r49) {
        /*
            Method dump skipped, instructions count: 979
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.BottomSheetScaffoldKt.m1317StandardBottomSheet8oydGBM(androidx.compose.material3.SheetState, float, boolean, float, androidx.compose.ui.graphics.Shape, long, long, float, float, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: BottomSheetScaffoldLayout-PxNyym8, reason: not valid java name */
    public static final void m1316BottomSheetScaffoldLayoutPxNyym8(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function3<? super Integer, ? super Composer, ? super Integer, Unit> function32, final Function2<? super Composer, ? super Integer, Unit> function22, final float sheetPeekHeight, final Function0<Float> function0, final SheetState sheetState, final long containerColor, final long contentColor, Composer $composer, final int $changed) {
        Object value$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-1120561936);
        ComposerKt.sourceInformation($composer2, "C(BottomSheetScaffoldLayout)P(4,9!2,8,6:c#ui.unit.Dp,5,7,2:c#ui.graphics.Color,3:c#ui.graphics.Color)328@14299L1935,328@14282L1952:BottomSheetScaffold.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changedInstance(function32) ? 2048 : 1024;
        }
        if ((57344 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function22) ? 16384 : 8192;
        }
        if ((458752 & $changed) == 0) {
            $dirty |= $composer2.changed(sheetPeekHeight) ? 131072 : 65536;
        }
        if ((3670016 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 1048576 : 524288;
        }
        if ((29360128 & $changed) == 0) {
            $dirty |= $composer2.changed(sheetState) ? 8388608 : 4194304;
        }
        if ((234881024 & $changed) == 0) {
            $dirty |= $composer2.changed(containerColor) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((1879048192 & $changed) == 0) {
            $dirty |= $composer2.changed(contentColor) ? 536870912 : 268435456;
        }
        if (($dirty & 1533916891) != 306783378 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1120561936, $dirty, -1, "androidx.compose.material3.BottomSheetScaffoldLayout (BottomSheetScaffold.kt:316)");
            }
            Object[] keys$iv = {function32, function0, function2, modifier, Color.m2939boximpl(containerColor), Color.m2939boximpl(contentColor), function3, Dp.m5216boximpl(sheetPeekHeight), function22, sheetState};
            $composer2.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv = false;
            for (Object key$iv : keys$iv) {
                invalid$iv |= $composer2.changed(key$iv);
            }
            Object it$iv$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                final int i = $dirty;
                value$iv$iv = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1

                    /* compiled from: BottomSheetScaffold.kt */
                    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    /* loaded from: classes.dex */
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[SheetValue.values().length];
                            try {
                                iArr[SheetValue.PartiallyExpanded.ordinal()] = 1;
                            } catch (NoSuchFieldError e) {
                            }
                            try {
                                iArr[SheetValue.Expanded.ordinal()] = 2;
                            } catch (NoSuchFieldError e2) {
                            }
                            try {
                                iArr[SheetValue.Hidden.ordinal()] = 3;
                            } catch (NoSuchFieldError e3) {
                            }
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m1320invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m1320invoke0kLqBqw(SubcomposeMeasureScope SubcomposeLayout, long constraints) {
                        long looseConstraints;
                        Placeable placeable;
                        long bodyConstraints;
                        final int snackbarOffsetY;
                        Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                        int layoutWidth = Constraints.m5174getMaxWidthimpl(constraints);
                        final int layoutHeight = Constraints.m5173getMaxHeightimpl(constraints);
                        looseConstraints = Constraints.m5164copyZbe2FdA(constraints, (r12 & 1) != 0 ? Constraints.m5176getMinWidthimpl(constraints) : 0, (r12 & 2) != 0 ? Constraints.m5174getMaxWidthimpl(constraints) : 0, (r12 & 4) != 0 ? Constraints.m5175getMinHeightimpl(constraints) : 0, (r12 & 8) != 0 ? Constraints.m5173getMaxHeightimpl(constraints) : 0);
                        BottomSheetScaffoldLayoutSlot bottomSheetScaffoldLayoutSlot = BottomSheetScaffoldLayoutSlot.Sheet;
                        final Function3<Integer, Composer, Integer, Unit> function33 = function32;
                        final int i2 = i;
                        final Placeable sheetPlaceable = SubcomposeLayout.subcompose(bottomSheetScaffoldLayoutSlot, ComposableLambdaKt.composableLambdaInstance(-1192048628, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$sheetPlaceable$1
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
                                ComposerKt.sourceInformation($composer3, "C334@14581L25:BottomSheetScaffold.kt#uh7d8r");
                                if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                                    $composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1192048628, $changed2, -1, "androidx.compose.material3.BottomSheetScaffoldLayout.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:333)");
                                }
                                function33.invoke(Integer.valueOf(layoutHeight), $composer3, Integer.valueOf((i2 >> 6) & 112));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        })).get(0).mo4186measureBRTryo0(looseConstraints);
                        final int sheetOffsetY = MathKt.roundToInt(function0.invoke().floatValue());
                        final int sheetOffsetX = Integer.max(0, (layoutWidth - sheetPlaceable.getWidth()) / 2);
                        if (function2 != null) {
                            final Function2<Composer, Integer, Unit> function23 = function2;
                            final int i3 = i;
                            placeable = SubcomposeLayout.subcompose(BottomSheetScaffoldLayoutSlot.TopBar, ComposableLambdaKt.composableLambdaInstance(-873203005, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$topBarPlaceable$1$1
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
                                    ComposerKt.sourceInformation($composer3, "C340@14892L8:BottomSheetScaffold.kt#uh7d8r");
                                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                                        $composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-873203005, $changed2, -1, "androidx.compose.material3.BottomSheetScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:340)");
                                    }
                                    function23.invoke($composer3, Integer.valueOf((i3 >> 3) & 14));
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            })).get(0).mo4186measureBRTryo0(looseConstraints);
                        } else {
                            placeable = null;
                        }
                        final Placeable topBarPlaceable = placeable;
                        final int topBarHeight = topBarPlaceable != null ? topBarPlaceable.getHeight() : 0;
                        bodyConstraints = Constraints.m5164copyZbe2FdA(looseConstraints, (r12 & 1) != 0 ? Constraints.m5176getMinWidthimpl(looseConstraints) : 0, (r12 & 2) != 0 ? Constraints.m5174getMaxWidthimpl(looseConstraints) : 0, (r12 & 4) != 0 ? Constraints.m5175getMinHeightimpl(looseConstraints) : 0, (r12 & 8) != 0 ? Constraints.m5173getMaxHeightimpl(looseConstraints) : layoutHeight - topBarHeight);
                        BottomSheetScaffoldLayoutSlot bottomSheetScaffoldLayoutSlot2 = BottomSheetScaffoldLayoutSlot.Body;
                        final Modifier modifier2 = modifier;
                        final long j = containerColor;
                        final long j2 = contentColor;
                        final int sheetOffsetX2 = i;
                        final Function3<PaddingValues, Composer, Integer, Unit> function34 = function3;
                        final float f = sheetPeekHeight;
                        final Placeable bodyPlaceable = SubcomposeLayout.subcompose(bottomSheetScaffoldLayoutSlot2, ComposableLambdaKt.composableLambdaInstance(-1459220575, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$bodyPlaceable$1
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
                                ComposerKt.sourceInformation($composer3, "C347@15198L194:BottomSheetScaffold.kt#uh7d8r");
                                if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1459220575, $changed2, -1, "androidx.compose.material3.BottomSheetScaffoldLayout.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:346)");
                                    }
                                    Modifier modifier3 = Modifier.this;
                                    long j3 = j;
                                    long j4 = j2;
                                    final Function3<PaddingValues, Composer, Integer, Unit> function35 = function34;
                                    final float f2 = f;
                                    final int i4 = sheetOffsetX2;
                                    SurfaceKt.m1794SurfaceT9BRK9s(modifier3, null, j3, j4, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda($composer3, 1725620860, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$bodyPlaceable$1.1
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
                                            ComposerKt.sourceInformation($composer4, "C351@15345L45:BottomSheetScaffold.kt#uh7d8r");
                                            if (($changed3 & 11) == 2 && $composer4.getSkipping()) {
                                                $composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1725620860, $changed3, -1, "androidx.compose.material3.BottomSheetScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:351)");
                                            }
                                            function35.invoke(PaddingKt.m481PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, f2, 7, null), $composer4, Integer.valueOf((i4 >> 3) & 112));
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), $composer3, (sheetOffsetX2 & 14) | 12582912 | ((sheetOffsetX2 >> 18) & 896) | ((sheetOffsetX2 >> 18) & 7168), 114);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer3.skipToGroupEnd();
                            }
                        })).get(0).mo4186measureBRTryo0(bodyConstraints);
                        final Placeable snackbarPlaceable = SubcomposeLayout.subcompose(BottomSheetScaffoldLayoutSlot.Snackbar, function22).get(0).mo4186measureBRTryo0(looseConstraints);
                        final int snackbarOffsetX = (layoutWidth - snackbarPlaceable.getWidth()) / 2;
                        switch (WhenMappings.$EnumSwitchMapping$0[sheetState.getCurrentValue().ordinal()]) {
                            case 1:
                                snackbarOffsetY = sheetOffsetY - snackbarPlaceable.getHeight();
                                break;
                            case 2:
                            case 3:
                                snackbarOffsetY = layoutHeight - snackbarPlaceable.getHeight();
                                break;
                            default:
                                throw new NoWhenBranchMatchedException();
                        }
                        return MeasureScope.layout$default(SubcomposeLayout, layoutWidth, layoutHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1.1
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
                                Placeable.PlacementScope.placeRelative$default(layout, Placeable.this, 0, topBarHeight, 0.0f, 4, null);
                                Placeable placeable2 = topBarPlaceable;
                                if (placeable2 != null) {
                                    Placeable.PlacementScope.placeRelative$default(layout, placeable2, 0, 0, 0.0f, 4, null);
                                }
                                Placeable.PlacementScope.placeRelative$default(layout, sheetPlaceable, sheetOffsetX, sheetOffsetY, 0.0f, 4, null);
                                Placeable.PlacementScope.placeRelative$default(layout, snackbarPlaceable, snackbarOffsetX, snackbarOffsetY, 0.0f, 4, null);
                            }
                        }, 4, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(null, (Function2) value$iv$iv, $composer2, 0, 1);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2
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
                BottomSheetScaffoldKt.m1316BottomSheetScaffoldLayoutPxNyym8(Modifier.this, function2, function3, function32, function22, sheetPeekHeight, function0, sheetState, containerColor, contentColor, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnchorChangeHandler<SheetValue> BottomSheetScaffoldAnchorChangeHandler(final SheetState state, final Function2<? super SheetValue, ? super Float, Unit> function2, final Function1<? super SheetValue, Unit> function1) {
        return new AnchorChangeHandler<SheetValue>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldAnchorChangeHandler$1

            /* compiled from: BottomSheetScaffold.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            /* loaded from: classes.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[SheetValue.values().length];
                    try {
                        iArr[SheetValue.Hidden.ordinal()] = 1;
                    } catch (NoSuchFieldError e) {
                    }
                    try {
                        iArr[SheetValue.PartiallyExpanded.ordinal()] = 2;
                    } catch (NoSuchFieldError e2) {
                    }
                    try {
                        iArr[SheetValue.Expanded.ordinal()] = 3;
                    } catch (NoSuchFieldError e3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // androidx.compose.material3.AnchorChangeHandler
            public final void onAnchorsChanged(SheetValue previousTarget, Map<SheetValue, Float> previousAnchors, Map<SheetValue, Float> newAnchors) {
                SheetValue newTarget;
                Intrinsics.checkNotNullParameter(previousTarget, "previousTarget");
                Intrinsics.checkNotNullParameter(previousAnchors, "previousAnchors");
                Intrinsics.checkNotNullParameter(newAnchors, "newAnchors");
                Float previousTargetOffset = previousAnchors.get(previousTarget);
                switch (WhenMappings.$EnumSwitchMapping$0[previousTarget.ordinal()]) {
                    case 1:
                    case 2:
                        newTarget = SheetValue.PartiallyExpanded;
                        break;
                    case 3:
                        if (!newAnchors.containsKey(SheetValue.Expanded)) {
                            newTarget = SheetValue.PartiallyExpanded;
                            break;
                        } else {
                            newTarget = SheetValue.Expanded;
                            break;
                        }
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                float newTargetOffset = ((Number) MapsKt.getValue(newAnchors, newTarget)).floatValue();
                if (!Intrinsics.areEqual(newTargetOffset, previousTargetOffset)) {
                    if (SheetState.this.getSwipeableState$material3_release().isAnimationRunning()) {
                        function2.invoke(newTarget, Float.valueOf(SheetState.this.getSwipeableState$material3_release().getLastVelocity()));
                    } else {
                        function1.invoke(newTarget);
                    }
                }
            }
        };
    }
}
