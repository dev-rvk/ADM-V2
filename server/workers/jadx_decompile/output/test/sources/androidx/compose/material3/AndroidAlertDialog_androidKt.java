package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.compose.ui.window.SecureFlagPolicy;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidAlertDialog.android.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aâ\u0001\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\b\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0015\b\u0002\u0010\f\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\b\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001aB\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\u001d\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"ButtonsCrossAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "ButtonsMainAxisSpacing", "AlertDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "icon", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "iconContentColor", "titleContentColor", "textContentColor", "tonalElevation", "properties", "Landroidx/compose/ui/window/DialogProperties;", "AlertDialog-Oix01E0", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJJJFLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;III)V", "content", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidAlertDialog_androidKt {
    private static final float ButtonsMainAxisSpacing = Dp.m5218constructorimpl(8);
    private static final float ButtonsCrossAxisSpacing = Dp.m5218constructorimpl(12);

    /* renamed from: AlertDialog-Oix01E0, reason: not valid java name */
    public static final void m1295AlertDialogOix01E0(final Function0<Unit> onDismissRequest, final Function2<? super Composer, ? super Integer, Unit> confirmButton, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Shape shape, long containerColor, long iconContentColor, long titleContentColor, long textContentColor, float tonalElevation, DialogProperties properties, Composer $composer, final int $changed, final int $changed1, final int i) {
        Function2 title;
        Function2 text;
        Shape shape2;
        Function2 dismissButton;
        long containerColor2;
        long iconContentColor2;
        long titleContentColor2;
        long textContentColor2;
        DialogProperties properties2;
        float tonalElevation2;
        int $dirty;
        int $dirty1;
        Function2 icon;
        long containerColor3;
        long iconContentColor3;
        long titleContentColor3;
        long textContentColor3;
        Modifier modifier2;
        Function2 icon2;
        Modifier modifier3;
        long containerColor4;
        Function2 dismissButton2;
        long iconContentColor4;
        Function2 title2;
        Function2 text2;
        Shape shape3;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Intrinsics.checkNotNullParameter(confirmButton, "confirmButton");
        Composer $composer2 = $composer.startRestartGroup(-2081346864);
        ComposerKt.sourceInformation($composer2, "C(AlertDialog)P(6!1,5,2,3,11,9,8,1:c#ui.graphics.Color,4:c#ui.graphics.Color,12:c#ui.graphics.Color,10:c#ui.graphics.Color,13:c#ui.unit.Dp)84@4214L5,85@4269L14,86@4335L16,87@4404L17,88@4473L16,91@4610L1104:AndroidAlertDialog.android.kt#uh7d8r");
        int $dirty2 = $changed;
        int $dirty12 = $changed1;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changedInstance(onDismissRequest) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty2 |= $composer2.changedInstance(confirmButton) ? 32 : 16;
        }
        int i7 = i & 4;
        if (i7 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 256 : 128;
        }
        int i8 = i & 8;
        if (i8 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        int i9 = i & 16;
        if (i9 != 0) {
            $dirty2 |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty2 |= $composer2.changedInstance(function22) ? 16384 : 8192;
        }
        int i10 = i & 32;
        if (i10 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            title = function23;
        } else if (($changed & 458752) == 0) {
            title = function23;
            $dirty2 |= $composer2.changedInstance(title) ? 131072 : 65536;
        } else {
            title = function23;
        }
        int i11 = i & 64;
        if (i11 != 0) {
            $dirty2 |= 1572864;
            text = function24;
        } else if (($changed & 3670016) == 0) {
            text = function24;
            $dirty2 |= $composer2.changedInstance(text) ? 1048576 : 524288;
        } else {
            text = function24;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0) {
                shape2 = shape;
                if ($composer2.changed(shape2)) {
                    i6 = 8388608;
                    $dirty2 |= i6;
                }
            } else {
                shape2 = shape;
            }
            i6 = 4194304;
            $dirty2 |= i6;
        } else {
            shape2 = shape;
        }
        if (($changed & 234881024) == 0) {
            if ((i & 256) == 0 && $composer2.changed(containerColor)) {
                i5 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                $dirty2 |= i5;
            }
            i5 = 33554432;
            $dirty2 |= i5;
        }
        if ((1879048192 & $changed) == 0) {
            if ((i & 512) == 0 && $composer2.changed(iconContentColor)) {
                i4 = 536870912;
                $dirty2 |= i4;
            }
            i4 = 268435456;
            $dirty2 |= i4;
        }
        if (($changed1 & 14) == 0) {
            if ((i & 1024) == 0 && $composer2.changed(titleContentColor)) {
                i3 = 4;
                $dirty12 |= i3;
            }
            i3 = 2;
            $dirty12 |= i3;
        }
        if (($changed1 & 112) == 0) {
            if ((i & 2048) == 0 && $composer2.changed(textContentColor)) {
                i2 = 32;
                $dirty12 |= i2;
            }
            i2 = 16;
            $dirty12 |= i2;
        }
        int i12 = i & 4096;
        if (i12 != 0) {
            $dirty12 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty12 |= $composer2.changed(tonalElevation) ? 256 : 128;
        }
        int i13 = i & 8192;
        if (i13 != 0) {
            $dirty12 |= 3072;
        } else if (($changed1 & 7168) == 0) {
            $dirty12 |= $composer2.changed(properties) ? 2048 : 1024;
        }
        if (($dirty2 & 1533916891) == 306783378 && ($dirty12 & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            dismissButton2 = function2;
            icon2 = function22;
            containerColor4 = containerColor;
            iconContentColor4 = iconContentColor;
            titleContentColor3 = titleContentColor;
            textContentColor3 = textContentColor;
            tonalElevation2 = tonalElevation;
            properties2 = properties;
            title2 = title;
            text2 = text;
            shape3 = shape2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i7 != 0 ? Modifier.INSTANCE : modifier;
                dismissButton = i8 != 0 ? null : function2;
                Function2 icon3 = i9 != 0 ? null : function22;
                if (i10 != 0) {
                    title = null;
                }
                if (i11 != 0) {
                    text = null;
                }
                Modifier modifier5 = modifier4;
                if ((i & 128) != 0) {
                    $dirty2 &= -29360129;
                    shape2 = AlertDialogDefaults.INSTANCE.getShape($composer2, 6);
                }
                if ((i & 256) != 0) {
                    containerColor2 = AlertDialogDefaults.INSTANCE.getContainerColor($composer2, 6);
                    $dirty2 &= -234881025;
                } else {
                    containerColor2 = containerColor;
                }
                if ((i & 512) != 0) {
                    iconContentColor2 = AlertDialogDefaults.INSTANCE.getIconContentColor($composer2, 6);
                    $dirty2 &= -1879048193;
                } else {
                    iconContentColor2 = iconContentColor;
                }
                if ((i & 1024) != 0) {
                    titleContentColor2 = AlertDialogDefaults.INSTANCE.getTitleContentColor($composer2, 6);
                    $dirty12 &= -15;
                } else {
                    titleContentColor2 = titleContentColor;
                }
                if ((i & 2048) != 0) {
                    textContentColor2 = AlertDialogDefaults.INSTANCE.getTextContentColor($composer2, 6);
                    $dirty12 &= -113;
                } else {
                    textContentColor2 = textContentColor;
                }
                float tonalElevation3 = i12 != 0 ? AlertDialogDefaults.INSTANCE.m1292getTonalElevationD9Ej5fM() : tonalElevation;
                if (i13 != 0) {
                    tonalElevation2 = tonalElevation3;
                    $dirty = $dirty2;
                    $dirty1 = $dirty12;
                    properties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (DefaultConstructorMarker) null);
                    icon = icon3;
                    containerColor3 = containerColor2;
                    iconContentColor3 = iconContentColor2;
                    titleContentColor3 = titleContentColor2;
                    textContentColor3 = textContentColor2;
                    modifier2 = modifier5;
                } else {
                    properties2 = properties;
                    tonalElevation2 = tonalElevation3;
                    $dirty = $dirty2;
                    $dirty1 = $dirty12;
                    icon = icon3;
                    containerColor3 = containerColor2;
                    iconContentColor3 = iconContentColor2;
                    titleContentColor3 = titleContentColor2;
                    textContentColor3 = textContentColor2;
                    modifier2 = modifier5;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 128) != 0) {
                    $dirty2 &= -29360129;
                }
                if ((i & 256) != 0) {
                    $dirty2 &= -234881025;
                }
                if ((i & 512) != 0) {
                    $dirty2 &= -1879048193;
                }
                if ((i & 1024) != 0) {
                    $dirty12 &= -15;
                }
                if ((i & 2048) != 0) {
                    int i14 = $dirty12 & (-113);
                    dismissButton = function2;
                    containerColor3 = containerColor;
                    iconContentColor3 = iconContentColor;
                    titleContentColor3 = titleContentColor;
                    textContentColor3 = textContentColor;
                    tonalElevation2 = tonalElevation;
                    properties2 = properties;
                    $dirty1 = i14;
                    $dirty = $dirty2;
                    modifier2 = modifier;
                    icon = function22;
                } else {
                    modifier2 = modifier;
                    dismissButton = function2;
                    iconContentColor3 = iconContentColor;
                    titleContentColor3 = titleContentColor;
                    textContentColor3 = textContentColor;
                    tonalElevation2 = tonalElevation;
                    properties2 = properties;
                    $dirty = $dirty2;
                    $dirty1 = $dirty12;
                    icon = function22;
                    containerColor3 = containerColor;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2081346864, $dirty, $dirty1, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:76)");
            }
            final Function2 function25 = icon;
            final Function2 function26 = title;
            final Function2 function27 = text;
            final Shape shape4 = shape2;
            final long j = containerColor3;
            final float f = tonalElevation2;
            final long j2 = iconContentColor3;
            final long j3 = titleContentColor3;
            final long j4 = textContentColor3;
            final int i15 = $dirty;
            final int i16 = $dirty1;
            final Function2 function28 = dismissButton;
            Function2 icon4 = icon;
            AlertDialog(onDismissRequest, modifier2, properties2, ComposableLambdaKt.composableLambda($composer2, 741647174, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1
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
                    ComposerKt.sourceInformation($composer3, "C112@5559L9,92@4711L1001:AndroidAlertDialog.android.kt#uh7d8r");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(741647174, $changed2, -1, "androidx.compose.material3.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:91)");
                        }
                        final Function2<Composer, Integer, Unit> function29 = function28;
                        final int i17 = i15;
                        final Function2<Composer, Integer, Unit> function210 = confirmButton;
                        AlertDialogKt.m1293AlertDialogContent4hvqGtA(ComposableLambdaKt.composableLambda($composer3, -1873210524, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1.1
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
                                float f2;
                                float f3;
                                ComposerKt.sourceInformation($composer4, "C94@4763L238:AndroidAlertDialog.android.kt#uh7d8r");
                                if (($changed3 & 11) != 2 || !$composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1873210524, $changed3, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:93)");
                                    }
                                    f2 = AndroidAlertDialog_androidKt.ButtonsMainAxisSpacing;
                                    f3 = AndroidAlertDialog_androidKt.ButtonsCrossAxisSpacing;
                                    final Function2<Composer, Integer, Unit> function211 = function29;
                                    final int i18 = i17;
                                    final Function2<Composer, Integer, Unit> function212 = function210;
                                    AlertDialogKt.m1294AlertDialogFlowRowixp7dh8(f2, f3, ComposableLambdaKt.composableLambda($composer4, 628285581, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt.AlertDialog.1.1.1
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

                                        public final void invoke(Composer $composer5, int $changed4) {
                                            ComposerKt.sourceInformation($composer5, "C99@4972L15:AndroidAlertDialog.android.kt#uh7d8r");
                                            if (($changed4 & 11) != 2 || !$composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(628285581, $changed4, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:97)");
                                                }
                                                Function2<Composer, Integer, Unit> function213 = function211;
                                                $composer5.startReplaceableGroup(-1969500715);
                                                ComposerKt.sourceInformation($composer5, "98@4947L8");
                                                if (function213 != null) {
                                                    function213.invoke($composer5, Integer.valueOf((i18 >> 9) & 14));
                                                    Unit unit = Unit.INSTANCE;
                                                }
                                                $composer5.endReplaceableGroup();
                                                function212.invoke($composer5, Integer.valueOf((i18 >> 3) & 14));
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer5.skipToGroupEnd();
                                        }
                                    }), $composer4, 438);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer4.skipToGroupEnd();
                            }
                        }), null, function25, function26, function27, shape4, j, f, ColorSchemeKt.toColor(DialogTokens.INSTANCE.getActionLabelTextColor(), $composer3, 6), j2, j3, j4, $composer3, ((i15 >> 6) & 896) | 6 | ((i15 >> 6) & 7168) | ((i15 >> 6) & 57344) | ((i15 >> 6) & 458752) | ((i15 >> 6) & 3670016) | ((i16 << 15) & 29360128) | (1879048192 & i15), (i16 & 14) | (i16 & 112), 2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }), $composer2, ($dirty & 14) | 3072 | (($dirty >> 3) & 112) | (($dirty1 >> 3) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            icon2 = icon4;
            modifier3 = modifier2;
            containerColor4 = containerColor3;
            dismissButton2 = dismissButton;
            iconContentColor4 = iconContentColor3;
            title2 = title;
            text2 = text;
            shape3 = shape2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier6 = modifier3;
        final Function2 function29 = dismissButton2;
        final Function2 function210 = icon2;
        final Function2 function211 = title2;
        final Function2 function212 = text2;
        final Shape shape5 = shape3;
        final long j5 = containerColor4;
        final long j6 = iconContentColor4;
        final long j7 = titleContentColor3;
        final long j8 = textContentColor3;
        final float f2 = tonalElevation2;
        final DialogProperties dialogProperties = properties2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$2
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

            public final void invoke(Composer composer, int i17) {
                AndroidAlertDialog_androidKt.m1295AlertDialogOix01E0(onDismissRequest, confirmButton, modifier6, function29, function210, function211, function212, shape5, j5, j6, j7, j8, f2, dialogProperties, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    public static final void AlertDialog(final Function0<Unit> onDismissRequest, Modifier modifier, DialogProperties properties, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        DialogProperties dialogProperties;
        DialogProperties properties2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(63450171);
        ComposerKt.sourceInformation($composer2, "C(AlertDialog)P(2,1,3)150@7189L452:AndroidAlertDialog.android.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changedInstance(onDismissRequest) ? 4 : 2;
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
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            dialogProperties = properties;
        } else if (($changed & 896) == 0) {
            dialogProperties = properties;
            $dirty |= $composer2.changed(dialogProperties) ? 256 : 128;
        } else {
            dialogProperties = properties;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer2.changedInstance(content) ? 2048 : 1024;
        }
        final int $dirty2 = $dirty;
        if (($dirty2 & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            properties2 = dialogProperties;
        } else {
            final Modifier modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            DialogProperties properties3 = i3 != 0 ? new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (DefaultConstructorMarker) null) : dialogProperties;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(63450171, $dirty2, -1, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:144)");
            }
            AndroidDialog_androidKt.Dialog(onDismissRequest, properties3, ComposableLambdaKt.composableLambda($composer2, 823217604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$3
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
                    ComposerKt.sourceInformation($composer3, "C154@7319L25,158@7509L37,155@7353L282:AndroidAlertDialog.android.kt#uh7d8r");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(823217604, $changed2, -1, "androidx.compose.material3.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:153)");
                        }
                        final String dialogPaneDescription = Strings_androidKt.m1785getStringNWtq28(Strings.INSTANCE.m1761getDialogadMyvUU(), $composer3, 6);
                        Modifier m535sizeInqDBjuR0$default = SizeKt.m535sizeInqDBjuR0$default(Modifier.this, AlertDialogKt.getDialogMinWidth(), 0.0f, AlertDialogKt.getDialogMaxWidth(), 0.0f, 10, null);
                        Modifier.Companion companion = Modifier.INSTANCE;
                        $composer3.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation($composer3, "CC(remember)P(1):Composables.kt#9igjgp");
                        boolean invalid$iv$iv = $composer3.changed(dialogPaneDescription);
                        Object it$iv$iv = $composer3.rememberedValue();
                        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$3$1$1
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
                                    SemanticsPropertiesKt.setPaneTitle(semantics, dialogPaneDescription);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv$iv);
                        } else {
                            value$iv$iv = it$iv$iv;
                        }
                        $composer3.endReplaceableGroup();
                        Modifier modifier$iv = m535sizeInqDBjuR0$default.then(SemanticsModifierKt.semantics$default(companion, false, (Function1) value$iv$iv, 1, null));
                        Function2<Composer, Integer, Unit> function2 = content;
                        int i4 = $dirty2;
                        $composer3.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, true, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                        int $changed$iv$iv = (384 << 3) & 112;
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
                        int i5 = ($changed$iv$iv$iv >> 9) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        int i6 = ((384 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 297115553, "C161@7616L9:AndroidAlertDialog.android.kt#uh7d8r");
                        function2.invoke($composer3, Integer.valueOf((i4 >> 9) & 14));
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
            }), $composer2, ($dirty2 & 14) | 384 | (($dirty2 >> 3) & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            properties2 = properties3;
            modifier3 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        final DialogProperties dialogProperties2 = properties2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$4
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

            public final void invoke(Composer composer, int i4) {
                AndroidAlertDialog_androidKt.AlertDialog(onDismissRequest, modifier5, dialogProperties2, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }
}
