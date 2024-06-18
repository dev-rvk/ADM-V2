package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AlertDialog.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a~\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a8\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\fH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a;\u0010\u001e\u001a\u00020\t*\u00020\u001f2\u0013\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\fH\u0001¢\u0006\u0002\u0010 \"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0006\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"TextBaselineDistanceFromTitle", "Landroidx/compose/ui/unit/TextUnit;", "J", "TextBaselineDistanceFromTop", "TextPadding", "Landroidx/compose/ui/Modifier;", "TitleBaselineDistanceFromTop", "TitlePadding", "AlertDialogContent", "", "buttons", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "AlertDialogContent-WMdw5o4", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/runtime/Composer;II)V", "AlertDialogFlowRow", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "content", "AlertDialogFlowRow-ixp7dh8", "(FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "AlertDialogBaselineLayout", "Landroidx/compose/foundation/layout/ColumnScope;", "(Landroidx/compose/foundation/layout/ColumnScope;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AlertDialogKt {
    private static final Modifier TitlePadding = PaddingKt.m488paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m5218constructorimpl(24), 0.0f, Dp.m5218constructorimpl(24), 0.0f, 10, null);
    private static final Modifier TextPadding = PaddingKt.m488paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m5218constructorimpl(24), 0.0f, Dp.m5218constructorimpl(24), Dp.m5218constructorimpl(28), 2, null);
    private static final long TitleBaselineDistanceFromTop = TextUnitKt.getSp(40);
    private static final long TextBaselineDistanceFromTitle = TextUnitKt.getSp(36);
    private static final long TextBaselineDistanceFromTop = TextUnitKt.getSp(38);

    /* renamed from: AlertDialogContent-WMdw5o4, reason: not valid java name */
    public static final void m957AlertDialogContentWMdw5o4(final Function2<? super Composer, ? super Integer, Unit> buttons, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Shape shape, long backgroundColor, long contentColor, Composer $composer, final int $changed, final int i) {
        final Function2 title;
        final Function2 text;
        Shape shape2;
        long backgroundColor2;
        long j;
        Modifier.Companion modifier2;
        final int $dirty;
        long contentColor2;
        Modifier modifier3;
        long contentColor3;
        Function2 title2;
        Function2 text2;
        Shape shape3;
        long backgroundColor3;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(buttons, "buttons");
        Composer $composer2 = $composer.startRestartGroup(-453679601);
        ComposerKt.sourceInformation($composer2, "C(AlertDialogContent)P(1,3,6,5,4,0:c#ui.graphics.Color,2:c#ui.graphics.Color)48@1896L6,49@1954L6,50@1996L32,52@2038L1047:AlertDialog.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changedInstance(buttons) ? 4 : 2;
        }
        int i5 = i & 2;
        if (i5 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i6 = i & 4;
        if (i6 != 0) {
            $dirty2 |= 384;
            title = function2;
        } else if (($changed & 896) == 0) {
            title = function2;
            $dirty2 |= $composer2.changedInstance(title) ? 256 : 128;
        } else {
            title = function2;
        }
        int i7 = i & 8;
        if (i7 != 0) {
            $dirty2 |= 3072;
            text = function22;
        } else if (($changed & 7168) == 0) {
            text = function22;
            $dirty2 |= $composer2.changedInstance(text) ? 2048 : 1024;
        } else {
            text = function22;
        }
        if ((57344 & $changed) == 0) {
            if ((i & 16) == 0) {
                shape2 = shape;
                if ($composer2.changed(shape2)) {
                    i4 = 16384;
                    $dirty2 |= i4;
                }
            } else {
                shape2 = shape;
            }
            i4 = 8192;
            $dirty2 |= i4;
        } else {
            shape2 = shape;
        }
        if ((458752 & $changed) == 0) {
            if ((i & 32) == 0) {
                backgroundColor2 = backgroundColor;
                if ($composer2.changed(backgroundColor2)) {
                    i3 = 131072;
                    $dirty2 |= i3;
                }
            } else {
                backgroundColor2 = backgroundColor;
            }
            i3 = 65536;
            $dirty2 |= i3;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if ((3670016 & $changed) == 0) {
            if ((i & 64) == 0) {
                j = contentColor;
                if ($composer2.changed(j)) {
                    i2 = 1048576;
                    $dirty2 |= i2;
                }
            } else {
                j = contentColor;
            }
            i2 = 524288;
            $dirty2 |= i2;
        } else {
            j = contentColor;
        }
        if (($dirty2 & 2995931) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            text2 = text;
            shape3 = shape2;
            backgroundColor3 = backgroundColor2;
            contentColor3 = j;
            modifier3 = modifier;
            title2 = title;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i5 != 0 ? Modifier.INSTANCE : modifier;
                if (i6 != 0) {
                    title = null;
                }
                if (i7 != 0) {
                    text = null;
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                    shape2 = MaterialTheme.INSTANCE.getShapes($composer2, 6).getMedium();
                }
                if ((i & 32) != 0) {
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1040getSurface0d7_KjU();
                    $dirty2 &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty = $dirty2 & (-3670017);
                    contentColor2 = ColorsKt.m1054contentColorForek8zF_U(backgroundColor2, $composer2, ($dirty2 >> 15) & 14);
                } else {
                    $dirty = $dirty2;
                    contentColor2 = j;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty = $dirty2 & (-3670017);
                    contentColor2 = j;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    $dirty = $dirty2;
                    contentColor2 = j;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-453679601, $dirty, -1, "androidx.compose.material.AlertDialogContent (AlertDialog.kt:43)");
            }
            SurfaceKt.m1198SurfaceFjzlyU(modifier2, shape2, backgroundColor2, contentColor2, null, 0.0f, ComposableLambdaKt.composableLambda($composer2, 629950291, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1
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

                /* JADX WARN: Removed duplicated region for block: B:24:0x0158  */
                /* JADX WARN: Removed duplicated region for block: B:26:0x016e  */
                /* JADX WARN: Removed duplicated region for block: B:29:0x01b0  */
                /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:32:0x0184  */
                /* JADX WARN: Removed duplicated region for block: B:33:0x016b  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final void invoke(androidx.compose.runtime.Composer r31, int r32) {
                    /*
                        Method dump skipped, instructions count: 436
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AlertDialogKt$AlertDialogContent$1.invoke(androidx.compose.runtime.Composer, int):void");
                }
            }), $composer2, (($dirty >> 3) & 14) | 1572864 | (($dirty >> 9) & 112) | (($dirty >> 9) & 896) | (($dirty >> 9) & 7168), 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            contentColor3 = contentColor2;
            title2 = title;
            text2 = text;
            shape3 = shape2;
            backgroundColor3 = backgroundColor2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier3;
        final Function2 function23 = title2;
        final Function2 function24 = text2;
        final Shape shape4 = shape3;
        final long j2 = backgroundColor3;
        final long j3 = contentColor3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$2
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
                AlertDialogKt.m957AlertDialogContentWMdw5o4(buttons, modifier4, function23, function24, shape4, j2, j3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x043d  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0166  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void AlertDialogBaselineLayout(final androidx.compose.foundation.layout.ColumnScope r52, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r53, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r54, androidx.compose.runtime.Composer r55, final int r56) {
        /*
            Method dump skipped, instructions count: 1106
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AlertDialogKt.AlertDialogBaselineLayout(androidx.compose.foundation.layout.ColumnScope, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x014e  */
    /* renamed from: AlertDialogFlowRow-ixp7dh8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m958AlertDialogFlowRowixp7dh8(final float r23, final float r24, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r25, androidx.compose.runtime.Composer r26, final int r27) {
        /*
            Method dump skipped, instructions count: 355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AlertDialogKt.m958AlertDialogFlowRowixp7dh8(float, float, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }
}
