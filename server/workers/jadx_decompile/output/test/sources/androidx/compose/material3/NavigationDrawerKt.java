package androidx.compose.material3;

import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.tokens.NavigationDrawerTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: NavigationDrawer.kt */
@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ao\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001aQ\u0010\u001a\u001a\u00020\b2\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\b0\u001c¢\u0006\u0002\b\u00162\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\b0\u001c¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010!\u001am\u0010\"\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001ao\u0010%\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010\u0019\u001ac\u0010'\u001a\u00020\b2\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\b0\u001c¢\u0006\u0002\b\u00162\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010(\u001a\u00020\u000e2\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\b0\u001c¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a\u008c\u0001\u0010+\u001a\u00020\b2\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\b0\u001c¢\u0006\u0002\b\u00162\u0006\u0010-\u001a\u00020 2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\b0\u001c2\b\b\u0002\u0010\t\u001a\u00020\n2\u0015\b\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\u001c¢\u0006\u0002\b\u00162\u0015\b\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\u001c¢\u0006\u0002\b\u00162\b\b\u0002\u00101\u001a\u00020\f2\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u000205H\u0007¢\u0006\u0002\u00106\u001ao\u00107\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u0010\u0019\u001a=\u00109\u001a\u00020\b2\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\b0\u001c¢\u0006\u0002\b\u00162\b\b\u0002\u0010\t\u001a\u00020\n2\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\b0\u001c¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010:\u001aA\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020 2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\b0\u001c2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c2\u0006\u0010?\u001a\u00020\u000eH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001a \u0010B\u001a\u00020\u00022\u0006\u0010C\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\u0006\u0010E\u001a\u00020\u0002H\u0002\u001a+\u0010F\u001a\u00020\u001e2\u0006\u0010G\u001a\u00020H2\u0014\b\u0002\u0010I\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020 0\u0014H\u0007¢\u0006\u0002\u0010J\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0006\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006K"}, d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "DrawerVelocityThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "MinimumDrawerWidth", "DismissibleDrawerSheet", "", "modifier", "Landroidx/compose/ui/Modifier;", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerContainerColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "drawerTonalElevation", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DismissibleDrawerSheet-afqeVBk", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DismissibleNavigationDrawer", "drawerContent", "Lkotlin/Function0;", "drawerState", "Landroidx/compose/material3/DrawerState;", "gesturesEnabled", "", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DrawerState;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DrawerSheet", "DrawerSheet-vywBR7E", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ModalDrawerSheet", "ModalDrawerSheet-afqeVBk", "ModalNavigationDrawer", "scrimColor", "ModalNavigationDrawer-FHprtrg", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DrawerState;ZJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "NavigationDrawerItem", "label", "selected", "onClick", "icon", "badge", "shape", "colors", "Landroidx/compose/material3/NavigationDrawerItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/NavigationDrawerItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "PermanentDrawerSheet", "PermanentDrawerSheet-afqeVBk", "PermanentNavigationDrawer", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Scrim", "open", "onClose", "fraction", "color", "Scrim-Bx497Mc", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "calculateFraction", "a", "b", "pos", "rememberDrawerState", "initialValue", "Landroidx/compose/material3/DrawerValue;", "confirmStateChange", "(Landroidx/compose/material3/DrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DrawerState;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class NavigationDrawerKt {
    private static final float DrawerVelocityThreshold = Dp.m5218constructorimpl(400);
    private static final float MinimumDrawerWidth = Dp.m5218constructorimpl(240);
    private static final TweenSpec<Float> AnimationSpec = new TweenSpec<>(256, 0, null, 6, null);

    public static final DrawerState rememberDrawerState(final DrawerValue initialValue, final Function1<? super DrawerValue, Boolean> function1, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        $composer.startReplaceableGroup(2098699222);
        ComposerKt.sourceInformation($composer, "C(rememberDrawerState)P(1)227@8145L61,227@8081L125:NavigationDrawer.kt#uh7d8r");
        if ((i & 2) != 0) {
            Function1 confirmStateChange = new Function1<DrawerValue, Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$rememberDrawerState$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(DrawerValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return true;
                }
            };
            function1 = confirmStateChange;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2098699222, $changed, -1, "androidx.compose.material3.rememberDrawerState (NavigationDrawer.kt:223)");
        }
        Object[] objArr = new Object[0];
        Saver<DrawerState, DrawerValue> Saver = DrawerState.Companion.Saver(function1);
        int i2 = ($changed & 14) | ($changed & 112);
        $composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(initialValue) | $composer.changed(function1);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new Function0<DrawerState>() { // from class: androidx.compose.material3.NavigationDrawerKt$rememberDrawerState$2$1
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

    /* JADX WARN: Removed duplicated region for block: B:100:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x076d  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x054a  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x05b6  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0693  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x069f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0760  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x06a3  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x05c4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0560  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0317  */
    /* renamed from: ModalNavigationDrawer-FHprtrg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1621ModalNavigationDrawerFHprtrg(final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r67, androidx.compose.ui.Modifier r68, androidx.compose.material3.DrawerState r69, boolean r70, long r71, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r73, androidx.compose.runtime.Composer r74, final int r75, final int r76) {
        /*
            Method dump skipped, instructions count: 1928
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m1621ModalNavigationDrawerFHprtrg(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, androidx.compose.material3.DrawerState, boolean, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void DismissibleNavigationDrawer(final Function2<? super Composer, ? super Integer, Unit> drawerContent, Modifier modifier, DrawerState drawerState, boolean gesturesEnabled, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        DrawerState drawerState2;
        boolean gesturesEnabled2;
        Modifier.Companion modifier3;
        final DrawerState drawerState3;
        Object value$iv$iv$iv;
        Modifier modifier$iv;
        boolean gesturesEnabled3;
        Composer $composer2;
        DrawerState drawerState4;
        Modifier modifier4;
        int i2;
        Intrinsics.checkNotNullParameter(drawerContent, "drawerContent");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer3 = $composer.startRestartGroup(398812198);
        ComposerKt.sourceInformation($composer3, "C(DismissibleNavigationDrawer)P(1,4,2,3)347@12931L39,*352@13151L7,356@13256L24,357@13306L33,360@13464L7,361@13499L1566:NavigationDrawer.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer3.changedInstance(drawerContent) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                drawerState2 = drawerState;
                if ($composer3.changed(drawerState2)) {
                    i2 = 256;
                    $dirty |= i2;
                }
            } else {
                drawerState2 = drawerState;
            }
            i2 = 128;
            $dirty |= i2;
        } else {
            drawerState2 = drawerState;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            gesturesEnabled2 = gesturesEnabled;
        } else if (($changed & 7168) == 0) {
            gesturesEnabled2 = gesturesEnabled;
            $dirty |= $composer3.changed(gesturesEnabled2) ? 2048 : 1024;
        } else {
            gesturesEnabled2 = gesturesEnabled;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
        } else if ((57344 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(content) ? 16384 : 8192;
        }
        if ((46811 & $dirty) == 9362 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier4 = modifier2;
            drawerState4 = drawerState2;
            gesturesEnabled3 = gesturesEnabled2;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                modifier3 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    drawerState3 = rememberDrawerState(DrawerValue.Closed, null, $composer3, 6, 2);
                    $dirty &= -897;
                } else {
                    drawerState3 = drawerState2;
                }
                if (i4 != 0) {
                    gesturesEnabled2 = true;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier3 = modifier2;
                drawerState3 = drawerState2;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(398812198, $dirty, -1, "androidx.compose.material3.DismissibleNavigationDrawer (NavigationDrawer.kt:344)");
            }
            float drawerWidth = NavigationDrawerTokens.INSTANCE.m2290getContainerWidthD9Ej5fM();
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density $this$DismissibleNavigationDrawer_u24lambda_u247 = (Density) consume;
            float drawerWidthPx = $this$DismissibleNavigationDrawer_u24lambda_u247.mo329toPx0680j_4(drawerWidth);
            float minValue = -drawerWidthPx;
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
            final CoroutineScope scope = wrapper$iv.getCoroutineScope();
            $composer3.endReplaceableGroup();
            final String navigationMenu = Strings_androidKt.m1785getStringNWtq28(Strings.INSTANCE.m1765getNavigationMenuadMyvUU(), $composer3, 6);
            Map anchors = MapsKt.mapOf(TuplesKt.to(Float.valueOf(minValue), DrawerValue.Closed), TuplesKt.to(Float.valueOf(0.0f), DrawerValue.Open));
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer3.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            boolean isRtl = consume2 == LayoutDirection.Rtl;
            Modifier modifier5 = modifier3;
            modifier$iv = SwipeableKt.m1806swipeablepPrIpRY(modifier3, drawerState3.getSwipeableState$material3_release(), anchors, Orientation.Horizontal, (r26 & 8) != 0 ? true : gesturesEnabled2, (r26 & 16) != 0 ? false : isRtl, (r26 & 32) != 0 ? null : null, (r26 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : new Function2<DrawerValue, DrawerValue, ThresholdConfig>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$1
                @Override // kotlin.jvm.functions.Function2
                public final ThresholdConfig invoke(DrawerValue drawerValue, DrawerValue drawerValue2) {
                    Intrinsics.checkNotNullParameter(drawerValue, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(drawerValue2, "<anonymous parameter 1>");
                    return new FractionalThreshold(0.5f);
                }
            }, (r26 & 128) != 0 ? SwipeableDefaults.resistanceConfig$material3_release$default(SwipeableDefaults.INSTANCE, anchors.keySet(), 0.0f, 0.0f, 6, null) : null, (r26 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1805getVelocityThresholdD9Ej5fM$material3_release() : DrawerVelocityThreshold);
            $composer3.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            gesturesEnabled3 = gesturesEnabled2;
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer3.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv$iv = (Density) consume3;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = $composer3.consume(localLayoutDirection2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume4;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume5 = $composer3.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume5;
            Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
            int $changed$iv$iv$iv = ((((0 << 3) & 112) << 9) & 7168) | 6;
            int $dirty2 = $dirty;
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
            int i5 = ($changed$iv$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 973028062, "C373@13915L1144:NavigationDrawer.kt#uh7d8r");
            MeasurePolicy measurePolicy$iv2 = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$2
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* renamed from: measure-3p2s80s */
                public final MeasureResult mo15measure3p2s80s(MeasureScope Layout, List<? extends Measurable> measurables, long constraints) {
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                    final Placeable sheetPlaceable = measurables.get(0).mo4186measureBRTryo0(constraints);
                    final Placeable contentPlaceable = measurables.get(1).mo4186measureBRTryo0(constraints);
                    int width = contentPlaceable.getWidth();
                    int height = contentPlaceable.getHeight();
                    final DrawerState drawerState5 = DrawerState.this;
                    return MeasureScope.layout$default(Layout, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$2$measure$1
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
                            Placeable.PlacementScope.placeRelative$default(layout, Placeable.this, sheetPlaceable.getWidth() + MathKt.roundToInt(drawerState5.getOffset().getValue().floatValue()), 0, 0.0f, 4, null);
                            Placeable.PlacementScope.placeRelative$default(layout, sheetPlaceable, MathKt.roundToInt(drawerState5.getOffset().getValue().floatValue()), 0, 0.0f, 4, null);
                        }
                    }, 4, null);
                }
            };
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
            Modifier modifier$iv2 = Modifier.INSTANCE;
            ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume6 = $composer3.consume(localDensity3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv = (Density) consume6;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume7 = $composer3.consume(localLayoutDirection3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv = (LayoutDirection) consume7;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume8 = $composer3.consume(localViewConfiguration2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume8;
            Function0 factory$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv = LayoutKt.materializerOf(modifier$iv2);
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
            Updater.m2590setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2590setimpl($this$Layout_u24lambda_u240$iv, density$iv, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2590setimpl($this$Layout_u24lambda_u240$iv, layoutDirection$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2590setimpl($this$Layout_u24lambda_u240$iv, viewConfiguration$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            skippableUpdate$iv$iv.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int i7 = ($changed$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 94146718, "C374@13946L523,389@14482L45:NavigationDrawer.kt#uh7d8r");
            drawerState4 = drawerState3;
            Modifier modifier$iv3 = SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1
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
                    SemanticsPropertiesKt.setPaneTitle(semantics, navigationMenu);
                    if (drawerState3.isOpen()) {
                        final DrawerState drawerState5 = drawerState3;
                        final CoroutineScope coroutineScope = scope;
                        SemanticsPropertiesKt.dismiss$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                if (DrawerState.this.getSwipeableState$material3_release().getConfirmStateChange$material3_release().invoke(DrawerValue.Closed).booleanValue()) {
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C00491(DrawerState.this, null), 3, null);
                                }
                                return true;
                            }

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* compiled from: NavigationDrawer.kt */
                            @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                            @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1$1", f = "NavigationDrawer.kt", i = {}, l = {383}, m = "invokeSuspend", n = {}, s = {})
                            /* renamed from: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1$1, reason: invalid class name and collision with other inner class name */
                            /* loaded from: classes.dex */
                            public static final class C00491 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ DrawerState $drawerState;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                C00491(DrawerState drawerState, Continuation<? super C00491> continuation) {
                                    super(2, continuation);
                                    this.$drawerState = drawerState;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new C00491(this.$drawerState, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((C00491) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object $result) {
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch (this.label) {
                                        case 0:
                                            ResultKt.throwOnFailure($result);
                                            this.label = 1;
                                            if (this.$drawerState.close(this) != coroutine_suspended) {
                                                break;
                                            } else {
                                                return coroutine_suspended;
                                            }
                                        case 1:
                                            ResultKt.throwOnFailure($result);
                                            break;
                                        default:
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    return Unit.INSTANCE;
                                }
                            }
                        }, 1, null);
                    }
                }
            }, 1, null);
            $composer3.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
            int $i$f$Box = ((0 >> 3) & 14) | ((0 >> 3) & 112);
            MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer3, $i$f$Box);
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume9 = $composer3.consume(localDensity4);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv$iv2 = (Density) consume9;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection4 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume10 = $composer3.consume(localLayoutDirection4);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume10;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume11 = $composer3.consume(localViewConfiguration3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume11;
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
            int i8 = ($changed$iv$iv$iv2 >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            int i9 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -817267027, "C387@14440L15:NavigationDrawer.kt#uh7d8r");
            drawerContent.invoke($composer3, Integer.valueOf($dirty2 & 14));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endReplaceableGroup();
            $composer3.endNode();
            $composer3.endReplaceableGroup();
            $composer3.endReplaceableGroup();
            $composer3.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Modifier modifier$iv4 = Modifier.INSTANCE;
            Alignment contentAlignment$iv3 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv4 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv3, false, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume12 = $composer3.consume(localDensity5);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv$iv3 = (Density) consume12;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection5 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume13 = $composer3.consume(localLayoutDirection5);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv$iv3 = (LayoutDirection) consume13;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration4 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume14 = $composer3.consume(localViewConfiguration4);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv$iv3 = (ViewConfiguration) consume14;
            Function0 factory$iv$iv$iv3 = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv$iv3 = LayoutKt.materializerOf(modifier$iv4);
            int $changed$iv$iv$iv3 = ((((0 << 3) & 112) << 9) & 7168) | 6;
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
            int i10 = ($changed$iv$iv$iv3 >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            int i11 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -817266963, "C390@14504L9:NavigationDrawer.kt#uh7d8r");
            content.invoke($composer3, Integer.valueOf(($dirty2 >> 12) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endReplaceableGroup();
            $composer3.endNode();
            $composer3.endReplaceableGroup();
            $composer3.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endReplaceableGroup();
            $composer3.endNode();
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
            modifier4 = modifier5;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier6 = modifier4;
        final DrawerState drawerState5 = drawerState4;
        final boolean z = gesturesEnabled3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3
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

            public final void invoke(Composer composer, int i12) {
                NavigationDrawerKt.DismissibleNavigationDrawer(drawerContent, modifier6, drawerState5, z, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    public static final void PermanentNavigationDrawer(final Function2<? super Composer, ? super Integer, Unit> drawerContent, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(drawerContent, "drawerContent");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(-276843608);
        ComposerKt.sourceInformation($composer2, "C(PermanentNavigationDrawer)P(1,2)429@16096L105:NavigationDrawer.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changedInstance(drawerContent) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer2.changedInstance(content) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-276843608, $dirty2, -1, "androidx.compose.material3.PermanentNavigationDrawer (NavigationDrawer.kt:424)");
            }
            Modifier modifier$iv = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null);
            $composer2.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation($composer2, "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            Modifier modifier5 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv$iv = (Density) consume;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                $composer2.useNode();
            }
            $composer2.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2583constructorimpl($composer2);
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            $composer2.enableReusing();
            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            int i3 = ($changed$iv$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -326682283, "C80@4021L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1153996105, "C430@16134L15,431@16158L37:NavigationDrawer.kt#uh7d8r");
            drawerContent.invoke($composer2, Integer.valueOf($dirty2 & 14));
            $composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer2, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Modifier modifier$iv2 = Modifier.INSTANCE;
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            int $changed$iv = ((0 >> 3) & 14) | ((0 >> 3) & 112);
            MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, $changed$iv);
            int $changed$iv$iv2 = (0 << 3) & 112;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = $composer2.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv$iv2 = (Density) consume4;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume5 = $composer2.consume(localLayoutDirection2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume5;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume6 = $composer2.consume(localViewConfiguration2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume6;
            Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv2);
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(factory$iv$iv$iv2);
            } else {
                $composer2.useNode();
            }
            $composer2.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2583constructorimpl($composer2);
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            $composer2.enableReusing();
            skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            int i5 = ($changed$iv$iv$iv2 >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1146973058, "C432@16176L9:NavigationDrawer.kt#uh7d8r");
            content.invoke($composer2, Integer.valueOf(($dirty2 >> 6) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier6 = modifier3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$PermanentNavigationDrawer$2
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
                NavigationDrawerKt.PermanentNavigationDrawer(drawerContent, modifier6, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0152  */
    /* renamed from: ModalDrawerSheet-afqeVBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1620ModalDrawerSheetafqeVBk(androidx.compose.ui.Modifier r25, androidx.compose.ui.graphics.Shape r26, long r27, long r29, float r31, androidx.compose.foundation.layout.WindowInsets r32, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instructions count: 560
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m1620ModalDrawerSheetafqeVBk(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, float, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0153  */
    /* renamed from: DismissibleDrawerSheet-afqeVBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1618DismissibleDrawerSheetafqeVBk(androidx.compose.ui.Modifier r25, androidx.compose.ui.graphics.Shape r26, long r27, long r29, float r31, androidx.compose.foundation.layout.WindowInsets r32, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instructions count: 555
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m1618DismissibleDrawerSheetafqeVBk(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, float, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0153  */
    /* renamed from: PermanentDrawerSheet-afqeVBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1622PermanentDrawerSheetafqeVBk(androidx.compose.ui.Modifier r26, androidx.compose.ui.graphics.Shape r27, long r28, long r30, float r32, androidx.compose.foundation.layout.WindowInsets r33, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, androidx.compose.runtime.Composer r35, final int r36, final int r37) {
        /*
            Method dump skipped, instructions count: 628
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m1622PermanentDrawerSheetafqeVBk(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, float, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x012e  */
    /* renamed from: DrawerSheet-vywBR7E, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1619DrawerSheetvywBR7E(final androidx.compose.foundation.layout.WindowInsets r28, androidx.compose.ui.Modifier r29, androidx.compose.ui.graphics.Shape r30, long r31, long r33, float r35, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.runtime.Composer r37, final int r38, final int r39) {
        /*
            Method dump skipped, instructions count: 539
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m1619DrawerSheetvywBR7E(androidx.compose.foundation.layout.WindowInsets, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, float, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void NavigationDrawerItem(final Function2<? super Composer, ? super Integer, Unit> label, final boolean selected, final Function0<Unit> onClick, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Shape shape, NavigationDrawerItemColors colors, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int i) {
        Function2 icon;
        Shape shape2;
        MutableInteractionSource mutableInteractionSource;
        Modifier.Companion modifier2;
        Function2 badge;
        Shape shape3;
        NavigationDrawerItemColors colors2;
        int $dirty;
        MutableInteractionSource interactionSource2;
        NavigationDrawerItemColors colors3;
        Object value$iv$iv;
        NavigationDrawerItemColors colors4;
        MutableInteractionSource interactionSource3;
        Modifier modifier3;
        Function2 badge2;
        Shape shape4;
        Function2 icon2;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer $composer2 = $composer.startRestartGroup(-1304626543);
        ComposerKt.sourceInformation($composer2, "C(NavigationDrawerItem)P(4,7,6,5,2!1,8)657@25365L9,658@25446L8,659@25506L39,668@25818L24,661@25554L1233:NavigationDrawer.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changedInstance(label) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty2 |= $composer2.changed(selected) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer2.changedInstance(onClick) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 2048 : 1024;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= 24576;
            icon = function2;
        } else if (($changed & 57344) == 0) {
            icon = function2;
            $dirty2 |= $composer2.changedInstance(icon) ? 16384 : 8192;
        } else {
            icon = function2;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((458752 & $changed) == 0) {
            $dirty2 |= $composer2.changedInstance(function22) ? 131072 : 65536;
        }
        if ((3670016 & $changed) == 0) {
            if ((i & 64) == 0) {
                shape2 = shape;
                if ($composer2.changed(shape2)) {
                    i3 = 1048576;
                    $dirty2 |= i3;
                }
            } else {
                shape2 = shape;
            }
            i3 = 524288;
            $dirty2 |= i3;
        } else {
            shape2 = shape;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0 && $composer2.changed(colors)) {
                i2 = 8388608;
                $dirty2 |= i2;
            }
            i2 = 4194304;
            $dirty2 |= i2;
        }
        int i7 = i & 256;
        if (i7 != 0) {
            $dirty2 |= 100663296;
            mutableInteractionSource = interactionSource;
        } else if (($changed & 234881024) == 0) {
            mutableInteractionSource = interactionSource;
            $dirty2 |= $composer2.changed(mutableInteractionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            mutableInteractionSource = interactionSource;
        }
        if (($dirty2 & 191739611) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            colors4 = colors;
            interactionSource3 = mutableInteractionSource;
            shape4 = shape2;
            badge2 = function22;
            icon2 = icon;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i4 != 0 ? Modifier.INSTANCE : modifier;
                if (i5 != 0) {
                    icon = null;
                }
                badge = i6 != 0 ? null : function22;
                if ((i & 64) != 0) {
                    shape3 = ShapesKt.toShape(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), $composer2, 6);
                    $dirty2 &= -3670017;
                } else {
                    shape3 = shape2;
                }
                if ((i & 128) != 0) {
                    colors2 = NavigationDrawerItemDefaults.INSTANCE.m1617colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer2, 100663296, 255);
                    $dirty2 &= -29360129;
                } else {
                    colors2 = colors;
                }
                if (i7 != 0) {
                    $composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer2.rememberedValue();
                    int $dirty3 = $dirty2;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer2.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    $dirty = $dirty3;
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                    colors3 = colors2;
                } else {
                    $dirty = $dirty2;
                    interactionSource2 = interactionSource;
                    colors3 = colors2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 64) != 0) {
                    $dirty2 &= -3670017;
                }
                if ((i & 128) != 0) {
                    modifier2 = modifier;
                    badge = function22;
                    $dirty = $dirty2 & (-29360129);
                    interactionSource2 = mutableInteractionSource;
                    shape3 = shape2;
                    colors3 = colors;
                } else {
                    modifier2 = modifier;
                    badge = function22;
                    colors3 = colors;
                    $dirty = $dirty2;
                    interactionSource2 = mutableInteractionSource;
                    shape3 = shape2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1304626543, $dirty, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:650)");
            }
            final Function2 function23 = icon;
            final NavigationDrawerItemColors navigationDrawerItemColors = colors3;
            final int i8 = $dirty;
            final Function2 function24 = badge;
            SurfaceKt.m1795Surfaced85dljk(selected, onClick, SizeKt.fillMaxWidth$default(SizeKt.m517height3ABfNKs(SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semantics) {
                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                    SemanticsPropertiesKt.m4582setRolekuIjeqM(semantics, Role.INSTANCE.m4574getTabo7Vup1c());
                }
            }, 1, null), NavigationDrawerTokens.INSTANCE.m2288getActiveIndicatorHeightD9Ej5fM()), 0.0f, 1, null), false, shape3, colors3.containerColor(selected, $composer2, (($dirty >> 3) & 14) | (($dirty >> 18) & 112)).getValue().m2959unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, interactionSource2, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer2, 191488423, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$3
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
                    ComposerKt.sourceInformation($composer3, "C671@25913L868:NavigationDrawer.kt#uh7d8r");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(191488423, $changed2, -1, "androidx.compose.material3.NavigationDrawerItem.<anonymous> (NavigationDrawer.kt:670)");
                        }
                        Modifier modifier$iv = PaddingKt.m488paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m5218constructorimpl(16), 0.0f, Dp.m5218constructorimpl(24), 0.0f, 10, null);
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                        Function2<Composer, Integer, Unit> function25 = function23;
                        NavigationDrawerItemColors navigationDrawerItemColors2 = navigationDrawerItemColors;
                        boolean z = selected;
                        int i9 = i8;
                        Function2<Composer, Integer, Unit> function26 = function24;
                        Function2<Composer, Integer, Unit> function27 = label;
                        $composer3.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation($composer3, "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                        int $changed$iv$iv = (390 << 3) & 112;
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
                        int i10 = ($changed$iv$iv$iv >> 9) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -326682283, "C80@4021L9:Row.kt#2w3rfo");
                        int i11 = ((390 >> 6) & 112) | 6;
                        RowScope $this$invoke_u24lambda_u241 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1538531918, "C680@26311L203:NavigationDrawer.kt#uh7d8r");
                        $composer3.startReplaceableGroup(-1538531918);
                        ComposerKt.sourceInformation($composer3, "676@26118L19,677@26160L78,678@26255L29");
                        if (function25 != null) {
                            long iconColor = navigationDrawerItemColors2.iconColor(z, $composer3, ((i9 >> 3) & 14) | ((i9 >> 18) & 112)).getValue().m2959unboximpl();
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2939boximpl(iconColor))}, function25, $composer3, ((i9 >> 9) & 112) | 8);
                            SpacerKt.Spacer(SizeKt.m536width3ABfNKs(Modifier.INSTANCE, Dp.m5218constructorimpl(12)), $composer3, 6);
                        }
                        $composer3.endReplaceableGroup();
                        Modifier modifier$iv2 = RowScope.weight$default($this$invoke_u24lambda_u241, Modifier.INSTANCE, 1.0f, false, 2, null);
                        $composer3.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                        int $changed$iv = ((0 >> 3) & 14) | ((0 >> 3) & 112);
                        MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer3, $changed$iv);
                        int $changed$iv$iv2 = (0 << 3) & 112;
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
                        int i12 = ($changed$iv$iv$iv2 >> 9) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        int i13 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1694711418, "C681@26378L19,682@26420L80:NavigationDrawer.kt#uh7d8r");
                        int i14 = ((i9 >> 3) & 14) | ((i9 >> 18) & 112);
                        long labelColor = navigationDrawerItemColors2.textColor(z, $composer3, i14).getValue().m2959unboximpl();
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2939boximpl(labelColor))}, function27, $composer3, ((i9 << 3) & 112) | 8);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endReplaceableGroup();
                        $composer3.endNode();
                        $composer3.endReplaceableGroup();
                        $composer3.endReplaceableGroup();
                        $composer3.startReplaceableGroup(-533539227);
                        ComposerKt.sourceInformation($composer3, "685@26564L29,686@26634L20,687@26677L80");
                        if (function26 != null) {
                            SpacerKt.Spacer(SizeKt.m536width3ABfNKs(Modifier.INSTANCE, Dp.m5218constructorimpl(12)), $composer3, 6);
                            long badgeColor = navigationDrawerItemColors2.badgeColor(z, $composer3, i14).getValue().m2959unboximpl();
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2939boximpl(badgeColor))}, function26, $composer3, ((i9 >> 12) & 112) | 8);
                        }
                        $composer3.endReplaceableGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endReplaceableGroup();
                        $composer3.endNode();
                        $composer3.endReplaceableGroup();
                        $composer3.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }), $composer2, (($dirty >> 3) & 14) | (($dirty >> 3) & 112) | (($dirty >> 6) & 57344), (($dirty >> 24) & 14) | 48, 968);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            colors4 = colors3;
            interactionSource3 = interactionSource2;
            modifier3 = modifier2;
            badge2 = badge;
            shape4 = shape3;
            icon2 = icon;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier3;
        final Function2 function25 = icon2;
        final Function2 function26 = badge2;
        final Shape shape5 = shape4;
        final NavigationDrawerItemColors navigationDrawerItemColors2 = colors4;
        final MutableInteractionSource mutableInteractionSource2 = interactionSource3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$4
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
                NavigationDrawerKt.NavigationDrawerItem(label, selected, onClick, modifier4, function25, function26, shape5, navigationDrawerItemColors2, mutableInteractionSource2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculateFraction(float a, float b, float pos) {
        return RangesKt.coerceIn((pos - a) / (b - a), 0.0f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01a5  */
    /* renamed from: Scrim-Bx497Mc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1623ScrimBx497Mc(final boolean r22, final kotlin.jvm.functions.Function0<kotlin.Unit> r23, final kotlin.jvm.functions.Function0<java.lang.Float> r24, final long r25, androidx.compose.runtime.Composer r27, final int r28) {
        /*
            Method dump skipped, instructions count: 456
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m1623ScrimBx497Mc(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, long, androidx.compose.runtime.Composer, int):void");
    }
}
