package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
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
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
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
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a¢\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u00102\u0013\b\u0002\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u00102\u0019\b\u0002\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\u0002\b\u00102\u0013\b\u0002\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192 \b\u0002\u0010\u001a\u001a\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u00012\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"2\b\b\u0002\u0010&\u001a\u00020\"2\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\u0002\b\u0010H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a£\u0001\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u00172\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b.2\u001c\u0010'\u001a\u0018\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b.2\u0016\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b.2\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b.2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b.H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a!\u00103\u001a\u00020\r2\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u00020\u0014H\u0007¢\u0006\u0002\u00107\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u001c\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00068"}, d2 = {"FabSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "LocalFabPlacement", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/FabPlacement;", "getLocalFabPlacement", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "Scaffold", "", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material/ScaffoldState;", "topBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "bottomBar", "snackbarHost", "Lkotlin/Function1;", "Landroidx/compose/material/SnackbarHostState;", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material/FabPosition;", "isFloatingActionButtonDocked", "", "drawerContent", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "drawerGesturesEnabled", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerElevation", "drawerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "drawerScrimColor", "backgroundColor", "contentColor", "content", "Landroidx/compose/foundation/layout/PaddingValues;", "Scaffold-27mzLpw", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/ScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ScaffoldLayout", "isFabDocked", "fabPosition", "Landroidx/compose/ui/UiComposable;", "snackbar", "fab", "ScaffoldLayout-MDYNRJg", "(ZILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "rememberScaffoldState", "drawerState", "Landroidx/compose/material/DrawerState;", "snackbarHostState", "(Landroidx/compose/material/DrawerState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/ScaffoldState;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ScaffoldKt {
    private static final ProvidableCompositionLocal<FabPlacement> LocalFabPlacement = CompositionLocalKt.staticCompositionLocalOf(new Function0<FabPlacement>() { // from class: androidx.compose.material.ScaffoldKt$LocalFabPlacement$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FabPlacement invoke() {
            return null;
        }
    });
    private static final float FabSpacing = Dp.m5218constructorimpl(16);

    public static final ScaffoldState rememberScaffoldState(DrawerState drawerState, SnackbarHostState snackbarHostState, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Object value$iv$iv2;
        $composer.startReplaceableGroup(1569641925);
        ComposerKt.sourceInformation($composer, "C(rememberScaffoldState)63@2263L39,64@2347L32,65@2399L62:Scaffold.kt#jmzs0o");
        if ((i & 1) != 0) {
            drawerState = DrawerKt.rememberDrawerState(DrawerValue.Closed, null, $composer, 6, 2);
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
            ComposerKt.traceEventStart(1569641925, $changed, -1, "androidx.compose.material.rememberScaffoldState (Scaffold.kt:62)");
        }
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
        Object it$iv$iv2 = $composer.rememberedValue();
        if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new ScaffoldState(drawerState, snackbarHostState);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        ScaffoldState scaffoldState = (ScaffoldState) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return scaffoldState;
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x01d6, code lost:
    
        if (r11.changed(r68) != false) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01f0, code lost:
    
        if (r11.changed(r70) != false) goto L164;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x051f  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0522  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0454  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x04f0  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x04cd  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0305  */
    /* renamed from: Scaffold-27mzLpw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1169Scaffold27mzLpw(androidx.compose.ui.Modifier r54, androidx.compose.material.ScaffoldState r55, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r56, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r57, kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r58, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r59, int r60, boolean r61, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r62, boolean r63, androidx.compose.ui.graphics.Shape r64, float r65, long r66, long r68, long r70, long r72, long r74, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.PaddingValues, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r76, androidx.compose.runtime.Composer r77, final int r78, final int r79, final int r80) {
        /*
            Method dump skipped, instructions count: 1377
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ScaffoldKt.m1169Scaffold27mzLpw(androidx.compose.ui.Modifier, androidx.compose.material.ScaffoldState, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, int, boolean, kotlin.jvm.functions.Function3, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ScaffoldLayout-MDYNRJg, reason: not valid java name */
    public static final void m1170ScaffoldLayoutMDYNRJg(final boolean isFabDocked, final int fabPosition, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, Composer $composer, final int $changed) {
        int i;
        Composer $composer2 = $composer.startRestartGroup(-1401632215);
        ComposerKt.sourceInformation($composer2, "C(ScaffoldLayout)P(4,3:c#material.FabPosition,6,1,5,2)236@10234L4586,236@10217L4603:Scaffold.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(isFabDocked) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(fabPosition) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 2048 : 1024;
        }
        if ((57344 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function22) ? 16384 : 8192;
        }
        if ((458752 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function23) ? 131072 : 65536;
        }
        if ((3670016 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function24) ? 1048576 : 524288;
        }
        if ((2995931 & $dirty) != 599186 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1401632215, $dirty, -1, "androidx.compose.material.ScaffoldLayout (Scaffold.kt:227)");
            }
            Object[] keys$iv = {function2, function22, function23, FabPosition.m1099boximpl(fabPosition), Boolean.valueOf(isFabDocked), function24, function3};
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
                value$iv$iv = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m1172invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m1172invoke0kLqBqw(final SubcomposeMeasureScope SubcomposeLayout, long constraints) {
                        final long looseConstraints;
                        final Function2<Composer, Integer, Unit> function25;
                        Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                        final int layoutWidth = Constraints.m5174getMaxWidthimpl(constraints);
                        final int layoutHeight = Constraints.m5173getMaxHeightimpl(constraints);
                        looseConstraints = Constraints.m5164copyZbe2FdA(constraints, (r12 & 1) != 0 ? Constraints.m5176getMinWidthimpl(constraints) : 0, (r12 & 2) != 0 ? Constraints.m5174getMaxWidthimpl(constraints) : 0, (r12 & 4) != 0 ? Constraints.m5175getMinHeightimpl(constraints) : 0, (r12 & 8) != 0 ? Constraints.m5173getMaxHeightimpl(constraints) : 0);
                        final Function2<Composer, Integer, Unit> function26 = function2;
                        final Function2<Composer, Integer, Unit> function27 = function22;
                        final Function2<Composer, Integer, Unit> function28 = function23;
                        final int i3 = fabPosition;
                        final boolean z = isFabDocked;
                        function25 = function24;
                        final int i4 = i2;
                        final Function3<PaddingValues, Composer, Integer, Unit> function32 = function3;
                        return MeasureScope.layout$default(SubcomposeLayout, layoutWidth, layoutHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1.1
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
                                FabPlacement fabPlacement;
                                Object maxElem$iv3;
                                Integer num;
                                long m5164copyZbe2FdA;
                                float f;
                                int i5;
                                float f2;
                                Object maxElem$iv4;
                                Object maxElem$iv5;
                                int fabLeftOffset;
                                float f3;
                                float f4;
                                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                List $this$fastMap$iv = SubcomposeMeasureScope.this.subcompose(ScaffoldLayoutContent.TopBar, function26);
                                long j = looseConstraints;
                                List target$iv = new ArrayList($this$fastMap$iv.size());
                                int size = $this$fastMap$iv.size();
                                for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                                    Object item$iv$iv = $this$fastMap$iv.get(index$iv$iv);
                                    Measurable it = (Measurable) item$iv$iv;
                                    target$iv.add(it.mo4186measureBRTryo0(j));
                                }
                                List topBarPlaceables = target$iv;
                                if (topBarPlaceables.isEmpty()) {
                                    maxElem$iv = null;
                                } else {
                                    maxElem$iv = topBarPlaceables.get(0);
                                    Placeable it2 = (Placeable) maxElem$iv;
                                    int maxValue$iv = it2.getHeight();
                                    int i$iv = 1;
                                    int lastIndex = CollectionsKt.getLastIndex(topBarPlaceables);
                                    if (1 <= lastIndex) {
                                        while (true) {
                                            Object e$iv = topBarPlaceables.get(i$iv);
                                            Placeable it3 = (Placeable) e$iv;
                                            int v$iv = it3.getHeight();
                                            if (maxValue$iv < v$iv) {
                                                maxElem$iv = e$iv;
                                                maxValue$iv = v$iv;
                                            }
                                            if (i$iv == lastIndex) {
                                                break;
                                            } else {
                                                i$iv++;
                                            }
                                        }
                                    }
                                }
                                Placeable placeable = (Placeable) maxElem$iv;
                                int topBarHeight = placeable != null ? placeable.getHeight() : 0;
                                List $this$fastMap$iv2 = SubcomposeMeasureScope.this.subcompose(ScaffoldLayoutContent.Snackbar, function27);
                                long j2 = looseConstraints;
                                List target$iv2 = new ArrayList($this$fastMap$iv2.size());
                                int size2 = $this$fastMap$iv2.size();
                                for (int index$iv$iv2 = 0; index$iv$iv2 < size2; index$iv$iv2++) {
                                    Object item$iv$iv2 = $this$fastMap$iv2.get(index$iv$iv2);
                                    Measurable it4 = (Measurable) item$iv$iv2;
                                    target$iv2.add(it4.mo4186measureBRTryo0(j2));
                                }
                                List $this$fastMaxBy$iv = target$iv2;
                                if ($this$fastMaxBy$iv.isEmpty()) {
                                    maxElem$iv2 = null;
                                } else {
                                    maxElem$iv2 = $this$fastMaxBy$iv.get(0);
                                    Placeable it5 = (Placeable) maxElem$iv2;
                                    int maxValue$iv2 = it5.getHeight();
                                    int i$iv2 = 1;
                                    int lastIndex2 = CollectionsKt.getLastIndex($this$fastMaxBy$iv);
                                    if (1 <= lastIndex2) {
                                        while (true) {
                                            Object e$iv2 = $this$fastMaxBy$iv.get(i$iv2);
                                            Placeable it6 = (Placeable) e$iv2;
                                            int v$iv2 = it6.getHeight();
                                            if (maxValue$iv2 < v$iv2) {
                                                maxElem$iv2 = e$iv2;
                                                maxValue$iv2 = v$iv2;
                                            }
                                            if (i$iv2 == lastIndex2) {
                                                break;
                                            } else {
                                                i$iv2++;
                                            }
                                        }
                                    }
                                }
                                Placeable placeable2 = (Placeable) maxElem$iv2;
                                int snackbarHeight = placeable2 != null ? placeable2.getHeight() : 0;
                                List $this$fastMap$iv3 = SubcomposeMeasureScope.this.subcompose(ScaffoldLayoutContent.Fab, function28);
                                long j3 = looseConstraints;
                                int $i$f$fastMap = 0;
                                List target$iv3 = new ArrayList($this$fastMap$iv3.size());
                                int index$iv$iv3 = 0;
                                int size3 = $this$fastMap$iv3.size();
                                while (index$iv$iv3 < size3) {
                                    Object item$iv$iv3 = $this$fastMap$iv3.get(index$iv$iv3);
                                    int $i$f$fastMap2 = $i$f$fastMap;
                                    Measurable measurable = (Measurable) item$iv$iv3;
                                    target$iv3.add(measurable.mo4186measureBRTryo0(j3));
                                    index$iv$iv3++;
                                    $this$fastMap$iv3 = $this$fastMap$iv3;
                                    $i$f$fastMap = $i$f$fastMap2;
                                }
                                List fabPlaceables = target$iv3;
                                if (!fabPlaceables.isEmpty()) {
                                    if (fabPlaceables.isEmpty()) {
                                        maxElem$iv4 = null;
                                    } else {
                                        maxElem$iv4 = fabPlaceables.get(0);
                                        Placeable it7 = (Placeable) maxElem$iv4;
                                        int maxValue$iv3 = it7.getWidth();
                                        int i$iv3 = 1;
                                        int lastIndex3 = CollectionsKt.getLastIndex(fabPlaceables);
                                        if (1 <= lastIndex3) {
                                            while (true) {
                                                Object e$iv3 = fabPlaceables.get(i$iv3);
                                                Placeable it8 = (Placeable) e$iv3;
                                                int v$iv3 = it8.getWidth();
                                                if (maxValue$iv3 < v$iv3) {
                                                    maxElem$iv4 = e$iv3;
                                                    maxValue$iv3 = v$iv3;
                                                }
                                                if (i$iv3 == lastIndex3) {
                                                    break;
                                                } else {
                                                    i$iv3++;
                                                }
                                            }
                                        }
                                    }
                                    Placeable placeable3 = (Placeable) maxElem$iv4;
                                    int fabWidth = placeable3 != null ? placeable3.getWidth() : 0;
                                    if (fabPlaceables.isEmpty()) {
                                        maxElem$iv5 = null;
                                    } else {
                                        maxElem$iv5 = fabPlaceables.get(0);
                                        Placeable it9 = (Placeable) maxElem$iv5;
                                        int maxValue$iv4 = it9.getHeight();
                                        int i$iv4 = 1;
                                        int lastIndex4 = CollectionsKt.getLastIndex(fabPlaceables);
                                        if (1 <= lastIndex4) {
                                            while (true) {
                                                Object e$iv4 = fabPlaceables.get(i$iv4);
                                                Placeable it10 = (Placeable) e$iv4;
                                                int height = it10.getHeight();
                                                if (maxValue$iv4 < height) {
                                                    maxElem$iv5 = e$iv4;
                                                    maxValue$iv4 = height;
                                                }
                                                if (i$iv4 == lastIndex4) {
                                                    break;
                                                } else {
                                                    i$iv4++;
                                                }
                                            }
                                        }
                                    }
                                    Placeable placeable4 = (Placeable) maxElem$iv5;
                                    int fabHeight = placeable4 != null ? placeable4.getHeight() : 0;
                                    if (fabWidth == 0 || fabHeight == 0) {
                                        fabPlacement = null;
                                    } else {
                                        if (!FabPosition.m1102equalsimpl0(i3, FabPosition.INSTANCE.m1107getEnd5ygKITE())) {
                                            fabLeftOffset = (layoutWidth - fabWidth) / 2;
                                        } else if (SubcomposeMeasureScope.this.getLayoutDirection() == LayoutDirection.Ltr) {
                                            int i6 = layoutWidth;
                                            SubcomposeMeasureScope subcomposeMeasureScope = SubcomposeMeasureScope.this;
                                            f4 = ScaffoldKt.FabSpacing;
                                            fabLeftOffset = (i6 - subcomposeMeasureScope.mo323roundToPx0680j_4(f4)) - fabWidth;
                                        } else {
                                            SubcomposeMeasureScope subcomposeMeasureScope2 = SubcomposeMeasureScope.this;
                                            f3 = ScaffoldKt.FabSpacing;
                                            fabLeftOffset = subcomposeMeasureScope2.mo323roundToPx0680j_4(f3);
                                        }
                                        fabPlacement = new FabPlacement(z, fabLeftOffset, fabWidth, fabHeight);
                                    }
                                } else {
                                    fabPlacement = null;
                                }
                                final FabPlacement fabPlacement2 = fabPlacement;
                                SubcomposeMeasureScope subcomposeMeasureScope3 = SubcomposeMeasureScope.this;
                                ScaffoldLayoutContent scaffoldLayoutContent = ScaffoldLayoutContent.BottomBar;
                                final Function2<Composer, Integer, Unit> function29 = function25;
                                final int i7 = i4;
                                List $this$fastMap$iv4 = subcomposeMeasureScope3.subcompose(scaffoldLayoutContent, ComposableLambdaKt.composableLambdaInstance(1529070963, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1$1$bottomBarPlaceables$1
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
                                        ComposerKt.sourceInformation($composer3, "C289@12424L144:Scaffold.kt#jmzs0o");
                                        if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1529070963, $changed2, -1, "androidx.compose.material.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:288)");
                                            }
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ScaffoldKt.getLocalFabPlacement().provides(FabPlacement.this)}, function29, $composer3, ((i7 >> 15) & 112) | 8);
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
                                int $i$f$fastMap3 = 0;
                                List target$iv4 = new ArrayList($this$fastMap$iv4.size());
                                int index$iv$iv4 = 0;
                                int size4 = $this$fastMap$iv4.size();
                                while (index$iv$iv4 < size4) {
                                    Object item$iv$iv4 = $this$fastMap$iv4.get(index$iv$iv4);
                                    int $i$f$fastMap4 = $i$f$fastMap3;
                                    Measurable it11 = (Measurable) item$iv$iv4;
                                    target$iv4.add(it11.mo4186measureBRTryo0(j4));
                                    index$iv$iv4++;
                                    size4 = size4;
                                    $i$f$fastMap3 = $i$f$fastMap4;
                                }
                                List $this$fastMaxBy$iv2 = target$iv4;
                                if ($this$fastMaxBy$iv2.isEmpty()) {
                                    maxElem$iv3 = null;
                                } else {
                                    maxElem$iv3 = $this$fastMaxBy$iv2.get(0);
                                    Placeable it12 = (Placeable) maxElem$iv3;
                                    int maxValue$iv5 = it12.getHeight();
                                    int i$iv5 = 1;
                                    int lastIndex5 = CollectionsKt.getLastIndex($this$fastMaxBy$iv2);
                                    if (1 <= lastIndex5) {
                                        while (true) {
                                            Object e$iv5 = $this$fastMaxBy$iv2.get(i$iv5);
                                            Placeable it13 = (Placeable) e$iv5;
                                            int height2 = it13.getHeight();
                                            if (maxValue$iv5 < height2) {
                                                maxElem$iv3 = e$iv5;
                                                maxValue$iv5 = height2;
                                            }
                                            if (i$iv5 == lastIndex5) {
                                                break;
                                            } else {
                                                i$iv5++;
                                            }
                                        }
                                    }
                                }
                                Placeable placeable5 = (Placeable) maxElem$iv3;
                                final int bottomBarHeight = placeable5 != null ? placeable5.getHeight() : 0;
                                if (fabPlacement2 != null) {
                                    SubcomposeMeasureScope subcomposeMeasureScope4 = SubcomposeMeasureScope.this;
                                    boolean z2 = z;
                                    if (bottomBarHeight == 0) {
                                        int height3 = fabPlacement2.getHeight();
                                        f2 = ScaffoldKt.FabSpacing;
                                        i5 = height3 + subcomposeMeasureScope4.mo323roundToPx0680j_4(f2);
                                    } else if (z2) {
                                        i5 = bottomBarHeight + (fabPlacement2.getHeight() / 2);
                                    } else {
                                        int height4 = fabPlacement2.getHeight() + bottomBarHeight;
                                        f = ScaffoldKt.FabSpacing;
                                        i5 = height4 + subcomposeMeasureScope4.mo323roundToPx0680j_4(f);
                                    }
                                    num = Integer.valueOf(i5);
                                } else {
                                    num = null;
                                }
                                Integer fabOffsetFromBottom = num;
                                int snackbarOffsetFromBottom = snackbarHeight != 0 ? snackbarHeight + (fabOffsetFromBottom != null ? fabOffsetFromBottom.intValue() : bottomBarHeight) : 0;
                                int bodyContentHeight = layoutHeight - topBarHeight;
                                SubcomposeMeasureScope subcomposeMeasureScope5 = SubcomposeMeasureScope.this;
                                ScaffoldLayoutContent scaffoldLayoutContent2 = ScaffoldLayoutContent.MainContent;
                                final SubcomposeMeasureScope subcomposeMeasureScope6 = SubcomposeMeasureScope.this;
                                final Function3<PaddingValues, Composer, Integer, Unit> function33 = function32;
                                final int i8 = i4;
                                List $this$fastMap$iv5 = subcomposeMeasureScope5.subcompose(scaffoldLayoutContent2, ComposableLambdaKt.composableLambdaInstance(-1132241596, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1$1$bodyContentPlaceables$1
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
                                        ComposerKt.sourceInformation($composer3, "C321@13846L21:Scaffold.kt#jmzs0o");
                                        if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1132241596, $changed2, -1, "androidx.compose.material.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:319)");
                                            }
                                            PaddingValues innerPadding = PaddingKt.m481PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, SubcomposeMeasureScope.this.mo326toDpu2uoSUM(bottomBarHeight), 7, null);
                                            function33.invoke(innerPadding, $composer3, Integer.valueOf((i8 >> 6) & 112));
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
                                List target$iv5 = new ArrayList($this$fastMap$iv5.size());
                                List $this$fastForEach$iv$iv = $this$fastMap$iv5;
                                int size5 = $this$fastForEach$iv$iv.size();
                                int $i$f$fastMap5 = 0;
                                while ($i$f$fastMap5 < size5) {
                                    Object item$iv$iv5 = $this$fastForEach$iv$iv.get($i$f$fastMap5);
                                    List $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv;
                                    Measurable it14 = (Measurable) item$iv$iv5;
                                    long j6 = j5;
                                    m5164copyZbe2FdA = Constraints.m5164copyZbe2FdA(r20, (r12 & 1) != 0 ? Constraints.m5176getMinWidthimpl(r20) : 0, (r12 & 2) != 0 ? Constraints.m5174getMaxWidthimpl(r20) : 0, (r12 & 4) != 0 ? Constraints.m5175getMinHeightimpl(r20) : 0, (r12 & 8) != 0 ? Constraints.m5173getMaxHeightimpl(j5) : bodyContentHeight);
                                    target$iv5.add(it14.mo4186measureBRTryo0(m5164copyZbe2FdA));
                                    $i$f$fastMap5++;
                                    size5 = size5;
                                    $this$fastForEach$iv$iv = $this$fastForEach$iv$iv2;
                                    j5 = j6;
                                }
                                List bodyContentPlaceables = target$iv5;
                                List $this$fastForEach$iv = bodyContentPlaceables;
                                int index$iv = 0;
                                for (int size6 = $this$fastForEach$iv.size(); index$iv < size6; size6 = size6) {
                                    Object item$iv = $this$fastForEach$iv.get(index$iv);
                                    Placeable it15 = (Placeable) item$iv;
                                    Placeable.PlacementScope.place$default(layout, it15, 0, topBarHeight, 0.0f, 4, null);
                                    index$iv++;
                                    bottomBarHeight = bottomBarHeight;
                                    $this$fastForEach$iv = $this$fastForEach$iv;
                                }
                                int bottomBarHeight2 = bottomBarHeight;
                                List $this$fastForEach$iv2 = topBarPlaceables;
                                int index$iv2 = 0;
                                for (int size7 = $this$fastForEach$iv2.size(); index$iv2 < size7; size7 = size7) {
                                    Object item$iv2 = $this$fastForEach$iv2.get(index$iv2);
                                    Placeable it16 = (Placeable) item$iv2;
                                    Placeable.PlacementScope.place$default(layout, it16, 0, 0, 0.0f, 4, null);
                                    index$iv2++;
                                    $this$fastForEach$iv2 = $this$fastForEach$iv2;
                                }
                                int i9 = layoutHeight;
                                List $this$fastForEach$iv3 = $this$fastMaxBy$iv;
                                int size8 = $this$fastForEach$iv3.size();
                                int index$iv3 = 0;
                                while (index$iv3 < size8) {
                                    Object item$iv3 = $this$fastForEach$iv3.get(index$iv3);
                                    Placeable it17 = (Placeable) item$iv3;
                                    Placeable.PlacementScope.place$default(layout, it17, 0, i9 - snackbarOffsetFromBottom, 0.0f, 4, null);
                                    index$iv3++;
                                    size8 = size8;
                                    i9 = i9;
                                    $this$fastForEach$iv3 = $this$fastForEach$iv3;
                                }
                                int i10 = layoutHeight;
                                List $this$fastForEach$iv4 = $this$fastMaxBy$iv2;
                                int size9 = $this$fastForEach$iv4.size();
                                int index$iv4 = 0;
                                while (index$iv4 < size9) {
                                    Object item$iv4 = $this$fastForEach$iv4.get(index$iv4);
                                    Placeable it18 = (Placeable) item$iv4;
                                    Placeable.PlacementScope.place$default(layout, it18, 0, i10 - bottomBarHeight2, 0.0f, 4, null);
                                    index$iv4++;
                                    size9 = size9;
                                    i10 = i10;
                                    $this$fastForEach$iv4 = $this$fastForEach$iv4;
                                }
                                int i11 = layoutHeight;
                                List $this$fastForEach$iv5 = fabPlaceables;
                                int size10 = $this$fastForEach$iv5.size();
                                int index$iv5 = 0;
                                while (index$iv5 < size10) {
                                    Object item$iv5 = $this$fastForEach$iv5.get(index$iv5);
                                    Placeable it19 = (Placeable) item$iv5;
                                    Placeable.PlacementScope.place$default(layout, it19, fabPlacement2 != null ? fabPlacement2.getLeft() : 0, i11 - (fabOffsetFromBottom != null ? fabOffsetFromBottom.intValue() : 0), 0.0f, 4, null);
                                    index$iv5++;
                                    size10 = size10;
                                    i11 = i11;
                                    $this$fastForEach$iv5 = $this$fastForEach$iv5;
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$2
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
                ScaffoldKt.m1170ScaffoldLayoutMDYNRJg(isFabDocked, fabPosition, function2, function3, function22, function23, function24, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    public static final ProvidableCompositionLocal<FabPlacement> getLocalFabPlacement() {
        return LocalFabPlacement;
    }
}
