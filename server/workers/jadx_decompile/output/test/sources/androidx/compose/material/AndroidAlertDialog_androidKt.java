package androidx.compose.material;

import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.compose.ui.window.SecureFlagPolicy;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidAlertDialog.android.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u00ad\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0096\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"AlertDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "properties", "Landroidx/compose/ui/window/DialogProperties;", "AlertDialog-6oU6zVQ", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "buttons", "AlertDialog-wqdebIU", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidAlertDialog_androidKt {
    /* renamed from: AlertDialog-6oU6zVQ, reason: not valid java name */
    public static final void m959AlertDialog6oU6zVQ(final Function0<Unit> onDismissRequest, final Function2<? super Composer, ? super Integer, Unit> confirmButton, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, long backgroundColor, long contentColor, DialogProperties properties, Composer $composer, final int $changed, final int i) {
        Function2 function24;
        long contentColor2;
        CornerBasedShape shape2;
        int $dirty;
        Modifier modifier2;
        long backgroundColor2;
        Modifier modifier3;
        DialogProperties properties2;
        long backgroundColor3;
        final Function2 dismissButton;
        Function2 title;
        Function2 text;
        long contentColor3;
        Shape shape3;
        final int $dirty2;
        Function2 dismissButton2;
        Composer $composer2;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Intrinsics.checkNotNullParameter(confirmButton, "confirmButton");
        Composer $composer3 = $composer.startRestartGroup(-606536823);
        ComposerKt.sourceInformation($composer3, "C(AlertDialog)P(5,1,4,3,9,8,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color)70@3471L6,71@3529L6,72@3571L32,75@3667L735:AndroidAlertDialog.android.kt#jmzs0o");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer3.changedInstance(onDismissRequest) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty3 |= $composer3.changedInstance(confirmButton) ? 32 : 16;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty3 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty3 |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty3 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty3 |= $composer3.changedInstance(function2) ? 2048 : 1024;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty3 |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty3 |= $composer3.changedInstance(function22) ? 16384 : 8192;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function24 = function23;
        } else if (($changed & 458752) == 0) {
            function24 = function23;
            $dirty3 |= $composer3.changedInstance(function24) ? 131072 : 65536;
        } else {
            function24 = function23;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0 && $composer3.changed(shape)) {
                i4 = 1048576;
                $dirty3 |= i4;
            }
            i4 = 524288;
            $dirty3 |= i4;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0 && $composer3.changed(backgroundColor)) {
                i3 = 8388608;
                $dirty3 |= i3;
            }
            i3 = 4194304;
            $dirty3 |= i3;
        }
        if (($changed & 234881024) == 0) {
            if ((i & 256) == 0) {
                contentColor2 = contentColor;
                if ($composer3.changed(contentColor2)) {
                    i2 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                    $dirty3 |= i2;
                }
            } else {
                contentColor2 = contentColor;
            }
            i2 = 33554432;
            $dirty3 |= i2;
        } else {
            contentColor2 = contentColor;
        }
        int i9 = i & 512;
        if (i9 != 0) {
            $dirty3 |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty3 |= $composer3.changed(properties) ? 536870912 : 268435456;
        }
        if (($dirty3 & 1533916891) == 306783378 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier;
            dismissButton2 = function2;
            title = function22;
            shape3 = shape;
            backgroundColor3 = backgroundColor;
            properties2 = properties;
            contentColor3 = contentColor2;
            text = function24;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i5 != 0 ? Modifier.INSTANCE : modifier;
                Function2 dismissButton3 = i6 != 0 ? null : function2;
                Function2 title2 = i7 != 0 ? null : function22;
                Function2 text2 = i8 != 0 ? null : function24;
                if ((i & 64) != 0) {
                    shape2 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getMedium();
                    $dirty3 &= -3670017;
                } else {
                    shape2 = shape;
                }
                if ((i & 128) != 0) {
                    $dirty = $dirty3 & (-29360129);
                    modifier2 = modifier4;
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1040getSurface0d7_KjU();
                } else {
                    $dirty = $dirty3;
                    modifier2 = modifier4;
                    backgroundColor2 = backgroundColor;
                }
                if ((i & 256) != 0) {
                    contentColor2 = ColorsKt.m1054contentColorForek8zF_U(backgroundColor2, $composer3, ($dirty >> 21) & 14);
                    $dirty &= -234881025;
                }
                if (i9 != 0) {
                    modifier3 = modifier2;
                    properties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (DefaultConstructorMarker) null);
                    backgroundColor3 = backgroundColor2;
                    dismissButton = dismissButton3;
                    title = title2;
                    text = text2;
                    contentColor3 = contentColor2;
                    shape3 = shape2;
                    $dirty2 = $dirty;
                } else {
                    modifier3 = modifier2;
                    properties2 = properties;
                    backgroundColor3 = backgroundColor2;
                    dismissButton = dismissButton3;
                    title = title2;
                    text = text2;
                    contentColor3 = contentColor2;
                    shape3 = shape2;
                    $dirty2 = $dirty;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 64) != 0) {
                    $dirty3 &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty3 &= -29360129;
                }
                if ((i & 256) != 0) {
                    modifier3 = modifier;
                    title = function22;
                    shape3 = shape;
                    backgroundColor3 = backgroundColor;
                    properties2 = properties;
                    contentColor3 = contentColor2;
                    text = function24;
                    dismissButton = function2;
                    $dirty2 = (-234881025) & $dirty3;
                } else {
                    modifier3 = modifier;
                    title = function22;
                    shape3 = shape;
                    backgroundColor3 = backgroundColor;
                    properties2 = properties;
                    contentColor3 = contentColor2;
                    text = function24;
                    dismissButton = function2;
                    $dirty2 = $dirty3;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-606536823, $dirty2, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:63)");
            }
            dismissButton2 = dismissButton;
            $composer2 = $composer3;
            m960AlertDialogwqdebIU(onDismissRequest, ComposableLambdaKt.composableLambda($composer3, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
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

                /* JADX WARN: Removed duplicated region for block: B:24:0x01ac  */
                /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final void invoke(androidx.compose.runtime.Composer r29, int r30) {
                    /*
                        Method dump skipped, instructions count: 432
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1.invoke(androidx.compose.runtime.Composer, int):void");
                }
            }), modifier3, title, text, shape3, backgroundColor3, contentColor3, properties2, $composer3, ($dirty2 & 14) | 48 | ($dirty2 & 896) | (($dirty2 >> 3) & 7168) | (($dirty2 >> 3) & 57344) | (($dirty2 >> 3) & 458752) | (($dirty2 >> 3) & 3670016) | (($dirty2 >> 3) & 29360128) | (($dirty2 >> 3) & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        final Function2 function25 = dismissButton2;
        final Function2 function26 = title;
        final Function2 function27 = text;
        final Shape shape4 = shape3;
        final long j = backgroundColor3;
        final long j2 = contentColor3;
        final DialogProperties dialogProperties = properties2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$2
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

            public final void invoke(Composer composer, int i10) {
                AndroidAlertDialog_androidKt.m959AlertDialog6oU6zVQ(onDismissRequest, confirmButton, modifier5, function25, function26, function27, shape4, j, j2, dialogProperties, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    /* renamed from: AlertDialog-wqdebIU, reason: not valid java name */
    public static final void m960AlertDialogwqdebIU(final Function0<Unit> onDismissRequest, final Function2<? super Composer, ? super Integer, Unit> buttons, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Shape shape, long backgroundColor, long contentColor, DialogProperties properties, Composer $composer, final int $changed, final int i) {
        long backgroundColor2;
        long contentColor2;
        CornerBasedShape shape2;
        Modifier modifier2;
        Modifier modifier3;
        DialogProperties properties2;
        Function2 title;
        Function2 text;
        Shape shape3;
        long contentColor3;
        long backgroundColor3;
        final int $dirty;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Intrinsics.checkNotNullParameter(buttons, "buttons");
        Composer $composer2 = $composer.startRestartGroup(1035523925);
        ComposerKt.sourceInformation($composer2, "C(AlertDialog)P(4,1,3,8,7,6,0:c#ui.graphics.Color,2:c#ui.graphics.Color)131@6133L6,132@6191L6,133@6233L32,136@6329L366:AndroidAlertDialog.android.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changedInstance(onDismissRequest) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty2 |= $composer2.changedInstance(buttons) ? 32 : 16;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 256 : 128;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty2 |= 24576;
        } else if ((57344 & $changed) == 0) {
            $dirty2 |= $composer2.changedInstance(function22) ? 16384 : 8192;
        }
        if ((458752 & $changed) == 0) {
            if ((i & 32) == 0 && $composer2.changed(shape)) {
                i4 = 131072;
                $dirty2 |= i4;
            }
            i4 = 65536;
            $dirty2 |= i4;
        }
        if ((3670016 & $changed) == 0) {
            if ((i & 64) == 0) {
                backgroundColor2 = backgroundColor;
                if ($composer2.changed(backgroundColor2)) {
                    i3 = 1048576;
                    $dirty2 |= i3;
                }
            } else {
                backgroundColor2 = backgroundColor;
            }
            i3 = 524288;
            $dirty2 |= i3;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0) {
                contentColor2 = contentColor;
                if ($composer2.changed(contentColor2)) {
                    i2 = 8388608;
                    $dirty2 |= i2;
                }
            } else {
                contentColor2 = contentColor;
            }
            i2 = 4194304;
            $dirty2 |= i2;
        } else {
            contentColor2 = contentColor;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty2 |= $composer2.changed(properties) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty2 & 191739611) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            title = function2;
            text = function22;
            shape3 = shape;
            properties2 = properties;
            contentColor3 = contentColor2;
            backgroundColor3 = backgroundColor2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i5 != 0 ? Modifier.INSTANCE : modifier;
                Function2 title2 = i6 != 0 ? null : function2;
                Function2 text2 = i7 != 0 ? null : function22;
                if ((i & 32) != 0) {
                    shape2 = MaterialTheme.INSTANCE.getShapes($composer2, 6).getMedium();
                    $dirty2 &= -458753;
                } else {
                    shape2 = shape;
                }
                if ((i & 64) != 0) {
                    modifier2 = modifier4;
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1040getSurface0d7_KjU();
                    $dirty2 &= -3670017;
                } else {
                    modifier2 = modifier4;
                }
                if ((i & 128) != 0) {
                    contentColor2 = ColorsKt.m1054contentColorForek8zF_U(backgroundColor2, $composer2, ($dirty2 >> 18) & 14);
                    $dirty2 &= -29360129;
                }
                if (i8 != 0) {
                    modifier3 = modifier2;
                    properties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (DefaultConstructorMarker) null);
                    title = title2;
                    text = text2;
                    shape3 = shape2;
                    contentColor3 = contentColor2;
                    backgroundColor3 = backgroundColor2;
                    $dirty = $dirty2;
                } else {
                    modifier3 = modifier2;
                    properties2 = properties;
                    title = title2;
                    text = text2;
                    shape3 = shape2;
                    contentColor3 = contentColor2;
                    backgroundColor3 = backgroundColor2;
                    $dirty = $dirty2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty2 &= -3670017;
                }
                if ((i & 128) != 0) {
                    modifier3 = modifier;
                    title = function2;
                    text = function22;
                    shape3 = shape;
                    properties2 = properties;
                    contentColor3 = contentColor2;
                    backgroundColor3 = backgroundColor2;
                    $dirty = $dirty2 & (-29360129);
                } else {
                    modifier3 = modifier;
                    title = function2;
                    text = function22;
                    shape3 = shape;
                    properties2 = properties;
                    contentColor3 = contentColor2;
                    backgroundColor3 = backgroundColor2;
                    $dirty = $dirty2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1035523925, $dirty, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
            }
            final Modifier modifier5 = modifier3;
            final Function2 function23 = title;
            final Function2 function24 = text;
            final Shape shape4 = shape3;
            final long j = backgroundColor3;
            final long j2 = contentColor3;
            int $dirty3 = $dirty;
            AndroidDialog_androidKt.Dialog(onDismissRequest, properties2, ComposableLambdaKt.composableLambda($composer2, -1787418772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$3
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
                    ComposerKt.sourceInformation($composer3, "C140@6430L259:AndroidAlertDialog.android.kt#jmzs0o");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1787418772, $changed2, -1, "androidx.compose.material.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:139)");
                        }
                        AlertDialogKt.m957AlertDialogContentWMdw5o4(buttons, modifier5, function23, function24, shape4, j, j2, $composer3, (($dirty >> 3) & 14) | (($dirty >> 3) & 112) | (($dirty >> 3) & 896) | (($dirty >> 3) & 7168) | (($dirty >> 3) & 57344) | (($dirty >> 3) & 458752) | (($dirty >> 3) & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }), $composer2, ($dirty3 & 14) | 384 | (($dirty3 >> 21) & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier6 = modifier3;
        final Function2 function25 = title;
        final Function2 function26 = text;
        final Shape shape5 = shape3;
        final long j3 = backgroundColor3;
        final long j4 = contentColor3;
        final DialogProperties dialogProperties = properties2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$4
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
                AndroidAlertDialog_androidKt.m960AlertDialogwqdebIU(onDismissRequest, buttons, modifier6, function25, function26, shape5, j3, j4, dialogProperties, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }
}
