package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Snackbar.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a3\u0010\u000b\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000fH\u0003¢\u0006\u0002\u0010\u0011\u001a3\u0010\u0012\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000fH\u0003¢\u0006\u0002\u0010\u0011\u001ac\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u0001H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a{\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e¢\u0006\u0002\b\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u00012\u0011\u0010#\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000fH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001a \u0010&\u001a\u00020\f2\u0011\u0010#\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000fH\u0003¢\u0006\u0002\u0010'\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0006\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0007\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\b\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\t\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\n\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006("}, d2 = {"HeightToFirstLine", "Landroidx/compose/ui/unit/Dp;", "F", "HorizontalSpacing", "HorizontalSpacingButtonSide", "LongButtonVerticalOffset", "SeparateButtonExtraY", "SnackbarMinHeightOneLine", "SnackbarMinHeightTwoLines", "SnackbarVerticalPadding", "TextEndExtraSpacing", "NewLineButtonSnackbar", "", "text", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "action", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "OneRowSnackbar", "Snackbar", "snackbarData", "Landroidx/compose/material/SnackbarData;", "modifier", "Landroidx/compose/ui/Modifier;", "actionOnNewLine", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "actionColor", "elevation", "Snackbar-sPrSdHI", "(Landroidx/compose/material/SnackbarData;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJJFLandroidx/compose/runtime/Composer;II)V", "content", "Snackbar-7zSek6w", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/graphics/Shape;JJFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TextOnlySnackbar", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SnackbarKt {
    private static final float HeightToFirstLine = Dp.m5218constructorimpl(30);
    private static final float HorizontalSpacing = Dp.m5218constructorimpl(16);
    private static final float HorizontalSpacingButtonSide = Dp.m5218constructorimpl(8);
    private static final float SeparateButtonExtraY = Dp.m5218constructorimpl(2);
    private static final float SnackbarVerticalPadding = Dp.m5218constructorimpl(6);
    private static final float TextEndExtraSpacing = Dp.m5218constructorimpl(8);
    private static final float LongButtonVerticalOffset = Dp.m5218constructorimpl(12);
    private static final float SnackbarMinHeightOneLine = Dp.m5218constructorimpl(48);
    private static final float SnackbarMinHeightTwoLines = Dp.m5218constructorimpl(68);

    /* JADX WARN: Removed duplicated region for block: B:48:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x016b  */
    /* renamed from: Snackbar-7zSek6w, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1180Snackbar7zSek6w(androidx.compose.ui.Modifier r27, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, boolean r29, androidx.compose.ui.graphics.Shape r30, long r31, long r33, float r35, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.runtime.Composer r37, final int r38, final int r39) {
        /*
            Method dump skipped, instructions count: 595
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SnackbarKt.m1180Snackbar7zSek6w(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.graphics.Shape, long, long, float, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: Snackbar-sPrSdHI, reason: not valid java name */
    public static final void m1181SnackbarsPrSdHI(final SnackbarData snackbarData, Modifier modifier, boolean actionOnNewLine, Shape shape, long backgroundColor, long contentColor, long actionColor, float elevation, Composer $composer, final int $changed, final int i) {
        boolean z;
        Shape shape2;
        long contentColor2;
        long actionColor2;
        Modifier.Companion modifier2;
        boolean actionOnNewLine2;
        CornerBasedShape shape3;
        long backgroundColor2;
        long actionColor3;
        float elevation2;
        long actionColor4;
        long actionColor5;
        Function2 actionComposable;
        long actionColor6;
        Modifier modifier3;
        boolean actionOnNewLine3;
        float elevation3;
        Shape shape4;
        long backgroundColor3;
        long contentColor3;
        int i2;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(snackbarData, "snackbarData");
        Composer $composer2 = $composer.startRestartGroup(258660814);
        ComposerKt.sourceInformation($composer2, "C(Snackbar)P(7,5,1,6,2:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color,4:c#ui.unit.Dp)155@7132L6,156@7192L15,157@7249L6,158@7307L18,173@7784L320:Snackbar.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(snackbarData) ? 4 : 2;
        }
        int i6 = i & 2;
        if (i6 != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i7 = i & 4;
        if (i7 != 0) {
            $dirty |= 384;
            z = actionOnNewLine;
        } else if (($changed & 896) == 0) {
            z = actionOnNewLine;
            $dirty |= $composer2.changed(z) ? 256 : 128;
        } else {
            z = actionOnNewLine;
        }
        if (($changed & 7168) == 0) {
            if ((i & 8) == 0) {
                shape2 = shape;
                if ($composer2.changed(shape2)) {
                    i5 = 2048;
                    $dirty |= i5;
                }
            } else {
                shape2 = shape;
            }
            i5 = 1024;
            $dirty |= i5;
        } else {
            shape2 = shape;
        }
        if (($changed & 57344) == 0) {
            if ((i & 16) == 0 && $composer2.changed(backgroundColor)) {
                i4 = 16384;
                $dirty |= i4;
            }
            i4 = 8192;
            $dirty |= i4;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0) {
                contentColor2 = contentColor;
                if ($composer2.changed(contentColor2)) {
                    i3 = 131072;
                    $dirty |= i3;
                }
            } else {
                contentColor2 = contentColor;
            }
            i3 = 65536;
            $dirty |= i3;
        } else {
            contentColor2 = contentColor;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0) {
                actionColor2 = actionColor;
                if ($composer2.changed(actionColor2)) {
                    i2 = 1048576;
                    $dirty |= i2;
                }
            } else {
                actionColor2 = actionColor;
            }
            i2 = 524288;
            $dirty |= i2;
        } else {
            actionColor2 = actionColor;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty |= $composer2.changed(elevation) ? 8388608 : 4194304;
        }
        if (($dirty & 23967451) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            backgroundColor3 = backgroundColor;
            elevation3 = elevation;
            actionOnNewLine3 = z;
            shape4 = shape2;
            actionColor6 = actionColor2;
            contentColor3 = contentColor2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i6 != 0 ? Modifier.INSTANCE : modifier;
                actionOnNewLine2 = i7 != 0 ? false : z;
                if ((i & 8) != 0) {
                    shape3 = MaterialTheme.INSTANCE.getShapes($composer2, 6).getSmall();
                    $dirty &= -7169;
                } else {
                    shape3 = shape2;
                }
                if ((i & 16) != 0) {
                    backgroundColor2 = SnackbarDefaults.INSTANCE.getBackgroundColor($composer2, 6);
                    $dirty &= -57345;
                } else {
                    backgroundColor2 = backgroundColor;
                }
                if ((i & 32) != 0) {
                    contentColor2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1040getSurface0d7_KjU();
                    $dirty &= -458753;
                }
                if ((i & 64) != 0) {
                    actionColor3 = SnackbarDefaults.INSTANCE.getPrimaryActionColor($composer2, 6);
                    $dirty &= -3670017;
                } else {
                    actionColor3 = actionColor2;
                }
                if (i8 != 0) {
                    elevation2 = Dp.m5218constructorimpl(6);
                    actionColor2 = actionColor3;
                    actionColor4 = backgroundColor2;
                } else {
                    elevation2 = elevation;
                    actionColor2 = actionColor3;
                    actionColor4 = backgroundColor2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i & 64) != 0) {
                    elevation2 = elevation;
                    $dirty &= -3670017;
                    actionOnNewLine2 = z;
                    shape3 = shape2;
                    modifier2 = modifier;
                    actionColor4 = backgroundColor;
                } else {
                    modifier2 = modifier;
                    elevation2 = elevation;
                    actionOnNewLine2 = z;
                    shape3 = shape2;
                    actionColor4 = backgroundColor;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(258660814, $dirty, -1, "androidx.compose.material.Snackbar (Snackbar.kt:151)");
            }
            final String actionLabel = snackbarData.getActionLabel();
            if (actionLabel != null) {
                final long j = actionColor2;
                final int i9 = $dirty;
                actionColor5 = actionColor2;
                actionComposable = ComposableLambdaKt.composableLambda($composer2, 1843479216, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1
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
                        ComposerKt.sourceInformation($composer3, "C165@7570L44,164@7518L219:Snackbar.kt#jmzs0o");
                        if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                            $composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1843479216, $changed2, -1, "androidx.compose.material.Snackbar.<anonymous> (Snackbar.kt:163)");
                        }
                        ButtonColors m1010textButtonColorsRGew2ao = ButtonDefaults.INSTANCE.m1010textButtonColorsRGew2ao(0L, j, 0L, $composer3, ((i9 >> 15) & 112) | 3072, 5);
                        final SnackbarData snackbarData2 = snackbarData;
                        Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1.1
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
                        final String str = actionLabel;
                        ButtonKt.TextButton(function0, null, false, null, null, null, null, m1010textButtonColorsRGew2ao, null, ComposableLambdaKt.composableLambda($composer3, -929149933, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1.2
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
                                ComposerKt.sourceInformation($composer4, "C167@7704L17:Snackbar.kt#jmzs0o");
                                if (($changed3 & 81) == 16 && $composer4.getSkipping()) {
                                    $composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-929149933, $changed3, -1, "androidx.compose.material.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:167)");
                                }
                                TextKt.m1258Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 131070);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), $composer3, 805306368, 382);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                });
            } else {
                actionColor5 = actionColor2;
                actionComposable = null;
            }
            m1180Snackbar7zSek6w(PaddingKt.m484padding3ABfNKs(modifier2, Dp.m5218constructorimpl(12)), actionComposable, actionOnNewLine2, shape3, actionColor4, contentColor2, elevation2, ComposableLambdaKt.composableLambda($composer2, -261845785, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$3
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
                    ComposerKt.sourceInformation($composer3, "C175@7858L26:Snackbar.kt#jmzs0o");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-261845785, $changed2, -1, "androidx.compose.material.Snackbar.<anonymous> (Snackbar.kt:175)");
                    }
                    TextKt.m1258Text4IGK_g(SnackbarData.this.getMessage(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), $composer2, ($dirty & 896) | 12582912 | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (($dirty >> 3) & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            actionColor6 = actionColor5;
            modifier3 = modifier2;
            actionOnNewLine3 = actionOnNewLine2;
            elevation3 = elevation2;
            shape4 = shape3;
            backgroundColor3 = actionColor4;
            contentColor3 = contentColor2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier3;
        final boolean z2 = actionOnNewLine3;
        final Shape shape5 = shape4;
        final long j2 = backgroundColor3;
        final long j3 = contentColor3;
        final long j4 = actionColor6;
        final float f = elevation3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$4
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

            public final void invoke(Composer composer, int i10) {
                SnackbarKt.m1181SnackbarsPrSdHI(SnackbarData.this, modifier4, z2, shape5, j2, j3, j4, f, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0195  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void TextOnlySnackbar(final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, androidx.compose.runtime.Composer r41, final int r42) {
        /*
            Method dump skipped, instructions count: 653
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SnackbarKt.TextOnlySnackbar(kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x03bc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0228  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void NewLineButtonSnackbar(final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r57, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r58, androidx.compose.runtime.Composer r59, final int r60) {
        /*
            Method dump skipped, instructions count: 1137
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SnackbarKt.NewLineButtonSnackbar(kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x035e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void OneRowSnackbar(final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r50, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, androidx.compose.runtime.Composer r52, final int r53) {
        /*
            Method dump skipped, instructions count: 1034
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SnackbarKt.OneRowSnackbar(kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }
}
