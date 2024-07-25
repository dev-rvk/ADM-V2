package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.AnchoredDraggableState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Drawer.kt */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0096\u0001\u0010\t\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a2\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\n0\u001e¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\u001e\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&H\u0002\u001a3\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u001a2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\n0\u001e2\u0006\u0010*\u001a\u00020\u0015H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a.\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u0002002\u0014\b\u0002\u00101\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00150\fH\u0007\u001a\u0014\u00102\u001a\u0002032\n\u0010$\u001a\u0006\u0012\u0002\b\u000304H\u0002\u001a\u0096\u0001\u00105\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u0002062\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a2\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\n0\u001e¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b7\u00108\u001aA\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020\u00152\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\n0\u001e2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e2\u0006\u0010(\u001a\u00020\u001aH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001a.\u0010?\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0006\u0012\u0004\u0018\u00010\u00020@2\u0006\u0010A\u001a\u00020\u00022\u0006\u0010B\u001a\u00020\u00022\u0006\u0010C\u001a\u00020\u0015H\u0002\u001a \u0010D\u001a\u00020\u00022\u0006\u0010E\u001a\u00020\u00022\u0006\u0010F\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\u0002H\u0002\u001a+\u0010H\u001a\u00020\u00132\u0006\u0010.\u001a\u00020#2\u0014\b\u0002\u00101\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00150\fH\u0007¢\u0006\u0002\u0010I\u001a+\u0010J\u001a\u0002062\u0006\u0010.\u001a\u00020K2\u0014\b\u0002\u00101\u001a\u000e\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020\u00150\fH\u0007¢\u0006\u0002\u0010L\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0004\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\u0007\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\b\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006M²\u0006\n\u0010N\u001a\u00020\u0002X\u008a\u0084\u0002"}, d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "BottomDrawerOpenFraction", "DrawerPositionalThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "DrawerVelocityThreshold", "EndDrawerPadding", "BottomDrawer", "", "drawerContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "drawerState", "Landroidx/compose/material/BottomDrawerState;", "gesturesEnabled", "", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerElevation", "drawerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "scrimColor", "content", "Lkotlin/Function0;", "BottomDrawer-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BottomDrawerState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "BottomDrawerAnchorChangeCallback", "Landroidx/compose/material/AnchoredDraggableState$AnchorChangedCallback;", "Landroidx/compose/material/BottomDrawerValue;", "state", "scope", "Lkotlinx/coroutines/CoroutineScope;", "BottomDrawerScrim", "color", "onDismiss", "visible", "BottomDrawerScrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "BottomDrawerState", "initialValue", "density", "Landroidx/compose/ui/unit/Density;", "confirmStateChange", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroidx/compose/material/AnchoredDraggableState;", "ModalDrawer", "Landroidx/compose/material/DrawerState;", "ModalDrawer-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/DrawerState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Scrim", "open", "onClose", "fraction", "Scrim-Bx497Mc", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "calculateAnchors", "", "fullHeight", "drawerHeight", "isLandscape", "calculateFraction", "a", "b", "pos", "rememberBottomDrawerState", "(Landroidx/compose/material/BottomDrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomDrawerState;", "rememberDrawerState", "Landroidx/compose/material/DrawerValue;", "(Landroidx/compose/material/DrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/DrawerState;", "material_release", "alpha"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DrawerKt {
    private static final float BottomDrawerOpenFraction = 0.5f;
    private static final float EndDrawerPadding = Dp.m5218constructorimpl(56);
    private static final float DrawerPositionalThreshold = Dp.m5218constructorimpl(56);
    private static final float DrawerVelocityThreshold = Dp.m5218constructorimpl(400);
    private static final TweenSpec<Float> AnimationSpec = new TweenSpec<>(256, 0, null, 6, null);

    public static /* synthetic */ BottomDrawerState BottomDrawerState$default(BottomDrawerValue bottomDrawerValue, Density density, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = new Function1<BottomDrawerValue, Boolean>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerState$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(BottomDrawerValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return true;
                }
            };
        }
        return BottomDrawerState(bottomDrawerValue, density, function1);
    }

    public static final BottomDrawerState BottomDrawerState(BottomDrawerValue initialValue, Density density, Function1<? super BottomDrawerValue, Boolean> confirmStateChange) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
        BottomDrawerState it = new BottomDrawerState(initialValue, confirmStateChange);
        it.setDensity$material_release(density);
        return it;
    }

    public static final DrawerState rememberDrawerState(final DrawerValue initialValue, final Function1<? super DrawerValue, Boolean> function1, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        $composer.startReplaceableGroup(-1435874229);
        ComposerKt.sourceInformation($composer, "C(rememberDrawerState)P(1)455@15934L61,455@15870L125:Drawer.kt#jmzs0o");
        if ((i & 2) != 0) {
            Function1 confirmStateChange = new Function1<DrawerValue, Boolean>() { // from class: androidx.compose.material.DrawerKt$rememberDrawerState$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(DrawerValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return true;
                }
            };
            function1 = confirmStateChange;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1435874229, $changed, -1, "androidx.compose.material.rememberDrawerState (Drawer.kt:451)");
        }
        Object[] objArr = new Object[0];
        Saver<DrawerState, DrawerValue> Saver = DrawerState.INSTANCE.Saver(function1);
        int i2 = ($changed & 14) | ($changed & 112);
        $composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(initialValue) | $composer.changed(function1);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new Function0<DrawerState>() { // from class: androidx.compose.material.DrawerKt$rememberDrawerState$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final DrawerState invoke() {
                    return new DrawerState(DrawerValue.this, function1);
                }
            };
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        DrawerState drawerState = (DrawerState) RememberSaveableKt.m2596rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) value$iv$iv, $composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return drawerState;
    }

    public static final BottomDrawerState rememberBottomDrawerState(final BottomDrawerValue initialValue, final Function1<? super BottomDrawerValue, Boolean> function1, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        $composer.startReplaceableGroup(-598115156);
        ComposerKt.sourceInformation($composer, "C(rememberBottomDrawerState)P(1)472@16436L7,473@16543L76,473@16455L164:Drawer.kt#jmzs0o");
        if ((i & 2) != 0) {
            Function1 confirmStateChange = new Function1<BottomDrawerValue, Boolean>() { // from class: androidx.compose.material.DrawerKt$rememberBottomDrawerState$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(BottomDrawerValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return true;
                }
            };
            function1 = confirmStateChange;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-598115156, $changed, -1, "androidx.compose.material.rememberBottomDrawerState (Drawer.kt:468)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer);
        final Density density = (Density) consume;
        Object[] objArr = {density};
        Saver<BottomDrawerState, BottomDrawerValue> Saver = BottomDrawerState.INSTANCE.Saver(density, function1);
        int i2 = ($changed & 14) | (($changed << 3) & 896);
        $composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(initialValue) | $composer.changed(density) | $composer.changed(function1);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new Function0<BottomDrawerState>() { // from class: androidx.compose.material.DrawerKt$rememberBottomDrawerState$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final BottomDrawerState invoke() {
                    return DrawerKt.BottomDrawerState(BottomDrawerValue.this, density, function1);
                }
            };
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        BottomDrawerState bottomDrawerState = (BottomDrawerState) RememberSaveableKt.m2596rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) value$iv$iv, $composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return bottomDrawerState;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02bb  */
    /* renamed from: ModalDrawer-Gs3lGvM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1079ModalDrawerGs3lGvM(final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.ui.Modifier r33, androidx.compose.material.DrawerState r34, boolean r35, androidx.compose.ui.graphics.Shape r36, float r37, long r38, long r40, long r42, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, androidx.compose.runtime.Composer r45, final int r46, final int r47) {
        /*
            Method dump skipped, instructions count: 853
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt.m1079ModalDrawerGs3lGvM(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material.DrawerState, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02df  */
    /* renamed from: BottomDrawer-Gs3lGvM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1077BottomDrawerGs3lGvM(final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.ui.Modifier r33, androidx.compose.material.BottomDrawerState r34, boolean r35, androidx.compose.ui.graphics.Shape r36, float r37, long r38, long r40, long r42, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, androidx.compose.runtime.Composer r45, final int r46, final int r47) {
        /*
            Method dump skipped, instructions count: 889
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt.m1077BottomDrawerGs3lGvM(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material.BottomDrawerState, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final Map<BottomDrawerValue, Float> calculateAnchors(float fullHeight, float drawerHeight, boolean isLandscape) {
        float peekHeight = 0.5f * fullHeight;
        float expandedHeight = Math.max(0.0f, fullHeight - drawerHeight);
        if (drawerHeight < peekHeight || isLandscape) {
            Pair[] pairArr = new Pair[2];
            pairArr[0] = TuplesKt.to(BottomDrawerValue.Closed, Float.valueOf(fullHeight));
            pairArr[1] = TuplesKt.to(BottomDrawerValue.Expanded, drawerHeight == 0.0f ? null : Float.valueOf(expandedHeight));
            return MapsKt.mapOf(pairArr);
        }
        Pair[] pairArr2 = new Pair[3];
        pairArr2[0] = TuplesKt.to(BottomDrawerValue.Closed, Float.valueOf(fullHeight));
        pairArr2[1] = TuplesKt.to(BottomDrawerValue.Open, Float.valueOf(peekHeight));
        pairArr2[2] = TuplesKt.to(BottomDrawerValue.Expanded, drawerHeight == 0.0f ? null : Float.valueOf(expandedHeight));
        return MapsKt.mapOf(pairArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculateFraction(float a, float b, float pos) {
        return RangesKt.coerceIn((pos - a) / (b - a), 0.0f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: BottomDrawerScrim-3J-VO9M, reason: not valid java name */
    public static final void m1078BottomDrawerScrim3JVO9M(final long color, final Function0<Unit> function0, final boolean visible, Composer $composer, final int $changed) {
        Modifier.Companion dismissModifier;
        Object value$iv$iv;
        Object value$iv$iv2;
        Composer $composer2 = $composer.startRestartGroup(-513067266);
        ComposerKt.sourceInformation($composer2, "C(BottomDrawerScrim)P(0:c#ui.graphics.Color)805@29975L121,809@30123L30,827@30676L62,823@30567L171:Drawer.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(color) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(visible) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-513067266, $dirty2, -1, "androidx.compose.material.BottomDrawerScrim (Drawer.kt:799)");
            }
            if (color != Color.INSTANCE.m2985getUnspecified0d7_KjU()) {
                final State alpha$delegate = AnimateAsStateKt.animateFloatAsState(visible ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, $composer2, 48, 28);
                final String closeDrawer = Strings_androidKt.m1196getString4foXLRw(Strings.INSTANCE.m1189getCloseDrawerUdPEhr4(), $composer2, 6);
                $composer2.startReplaceableGroup(-1298942364);
                ComposerKt.sourceInformation($composer2, "812@30261L73,815@30387L122");
                if (visible) {
                    Modifier.Companion companion = Modifier.INSTANCE;
                    int i = ($dirty2 >> 3) & 14;
                    $composer2.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
                    boolean invalid$iv$iv = $composer2.changed(function0);
                    Object it$iv$iv = $composer2.rememberedValue();
                    if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = new DrawerKt$BottomDrawerScrim$dismissModifier$1$1(function0, null);
                        $composer2.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, function0, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv$iv);
                    int i2 = $dirty2 & 112;
                    $composer2.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2):Composables.kt#9igjgp");
                    boolean invalid$iv$iv2 = $composer2.changed(closeDrawer) | $composer2.changed(function0);
                    Object it$iv$iv2 = $composer2.rememberedValue();
                    if (!invalid$iv$iv2 && it$iv$iv2 != Composer.INSTANCE.getEmpty()) {
                        value$iv$iv2 = it$iv$iv2;
                        $composer2.endReplaceableGroup();
                        dismissModifier = SemanticsModifierKt.semantics(pointerInput, true, (Function1) value$iv$iv2);
                    }
                    value$iv$iv2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerScrim$dismissModifier$2$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semantics) {
                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                            SemanticsPropertiesKt.setContentDescription(semantics, closeDrawer);
                            final Function0<Unit> function02 = function0;
                            SemanticsPropertiesKt.onClick$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerScrim$dismissModifier$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    function02.invoke();
                                    return true;
                                }
                            }, 1, null);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv$iv2);
                    $composer2.endReplaceableGroup();
                    dismissModifier = SemanticsModifierKt.semantics(pointerInput, true, (Function1) value$iv$iv2);
                } else {
                    dismissModifier = Modifier.INSTANCE;
                }
                $composer2.endReplaceableGroup();
                Modifier then = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(dismissModifier);
                Object key1$iv = Color.m2939boximpl(color);
                int i3 = $dirty2 & 14;
                $composer2.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2):Composables.kt#9igjgp");
                boolean invalid$iv$iv3 = $composer2.changed(key1$iv) | $composer2.changed(alpha$delegate);
                Object value$iv$iv3 = $composer2.rememberedValue();
                if (!invalid$iv$iv3) {
                    Object key1$iv2 = Composer.INSTANCE.getEmpty();
                    if (value$iv$iv3 != key1$iv2) {
                        $composer2.endReplaceableGroup();
                        CanvasKt.Canvas(then, (Function1) value$iv$iv3, $composer2, 0);
                    }
                }
                value$iv$iv3 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerScrim$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                        invoke2(drawScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DrawScope Canvas) {
                        float BottomDrawerScrim_3J_VO9M$lambda$3;
                        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                        long j = color;
                        BottomDrawerScrim_3J_VO9M$lambda$3 = DrawerKt.BottomDrawerScrim_3J_VO9M$lambda$3(alpha$delegate);
                        DrawScope.m3487drawRectnJ9OG0$default(Canvas, j, 0L, 0L, BottomDrawerScrim_3J_VO9M$lambda$3, null, null, 0, 118, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv3);
                $composer2.endReplaceableGroup();
                CanvasKt.Canvas(then, (Function1) value$iv$iv3, $composer2, 0);
            }
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerScrim$2
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

            public final void invoke(Composer composer, int i4) {
                DrawerKt.m1078BottomDrawerScrim3JVO9M(color, function0, visible, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float BottomDrawerScrim_3J_VO9M$lambda$3(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01a5  */
    /* renamed from: Scrim-Bx497Mc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1080ScrimBx497Mc(final boolean r22, final kotlin.jvm.functions.Function0<kotlin.Unit> r23, final kotlin.jvm.functions.Function0<java.lang.Float> r24, final long r25, androidx.compose.runtime.Composer r27, final int r28) {
        /*
            Method dump skipped, instructions count: 456
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt.m1080ScrimBx497Mc(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, long, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(AnchoredDraggableState<?> anchoredDraggableState) {
        return new DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1(anchoredDraggableState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnchoredDraggableState.AnchorChangedCallback<BottomDrawerValue> BottomDrawerAnchorChangeCallback(final BottomDrawerState state, final CoroutineScope scope) {
        return new AnchoredDraggableState.AnchorChangedCallback<BottomDrawerValue>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerAnchorChangeCallback$1

            /* compiled from: Drawer.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            /* loaded from: classes.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[BottomDrawerValue.values().length];
                    try {
                        iArr[BottomDrawerValue.Closed.ordinal()] = 1;
                    } catch (NoSuchFieldError e) {
                    }
                    try {
                        iArr[BottomDrawerValue.Open.ordinal()] = 2;
                    } catch (NoSuchFieldError e2) {
                    }
                    try {
                        iArr[BottomDrawerValue.Expanded.ordinal()] = 3;
                    } catch (NoSuchFieldError e3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // androidx.compose.material.AnchoredDraggableState.AnchorChangedCallback
            public final void onAnchorsChanged(BottomDrawerValue previousTarget, Map<BottomDrawerValue, Float> previousAnchors, Map<BottomDrawerValue, Float> newAnchors) {
                BottomDrawerValue bottomDrawerValue;
                Intrinsics.checkNotNullParameter(previousTarget, "previousTarget");
                Intrinsics.checkNotNullParameter(previousAnchors, "previousAnchors");
                Intrinsics.checkNotNullParameter(newAnchors, "newAnchors");
                Float previousTargetOffset = previousAnchors.get(previousTarget);
                switch (WhenMappings.$EnumSwitchMapping$0[previousTarget.ordinal()]) {
                    case 1:
                        bottomDrawerValue = BottomDrawerValue.Closed;
                        break;
                    case 2:
                    case 3:
                        boolean hasHalfExpandedState = newAnchors.containsKey(BottomDrawerValue.Open);
                        if (hasHalfExpandedState) {
                            bottomDrawerValue = BottomDrawerValue.Open;
                            break;
                        } else if (!newAnchors.containsKey(BottomDrawerValue.Expanded)) {
                            bottomDrawerValue = BottomDrawerValue.Closed;
                            break;
                        } else {
                            bottomDrawerValue = BottomDrawerValue.Expanded;
                            break;
                        }
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                BottomDrawerValue newTarget = bottomDrawerValue;
                float newTargetOffset = ((Number) MapsKt.getValue(newAnchors, newTarget)).floatValue();
                if (!Intrinsics.areEqual(newTargetOffset, previousTargetOffset)) {
                    if (BottomDrawerState.this.isAnimationRunning$material_release()) {
                        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new DrawerKt$BottomDrawerAnchorChangeCallback$1$onAnchorsChanged$1(BottomDrawerState.this, newTarget, null), 3, null);
                        return;
                    }
                    boolean didSnapSynchronously = BottomDrawerState.this.trySnapTo$material_release(newTarget);
                    if (!didSnapSynchronously) {
                        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new DrawerKt$BottomDrawerAnchorChangeCallback$1$onAnchorsChanged$2(BottomDrawerState.this, newTarget, null), 3, null);
                    }
                }
            }
        };
    }
}
