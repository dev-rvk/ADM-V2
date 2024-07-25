package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.selection.SelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.tokens.OutlinedTextFieldTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextFieldDefaults.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b)\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JS\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u009c\u0002\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!2\u0011\u0010\"\u001a\r\u0012\u0004\u0012\u00020\u00130#¢\u0006\u0002\b$2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0016\u001a\u00020\u00152\u0015\b\u0002\u0010(\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010#¢\u0006\u0002\b$2\u0015\b\u0002\u0010)\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010#¢\u0006\u0002\b$2\u0015\b\u0002\u0010*\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010#¢\u0006\u0002\b$2\u0015\b\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010#¢\u0006\u0002\b$2\u0015\b\u0002\u0010,\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010#¢\u0006\u0002\b$2\u0015\b\u0002\u0010-\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010#¢\u0006\u0002\b$2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0018\u00010#¢\u0006\u0002\b$2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010/\u001a\u0002002\u0013\b\u0002\u00101\u001a\r\u0012\u0004\u0012\u00020\u00130#¢\u0006\u0002\b$H\u0007¢\u0006\u0002\u00102JÃ\u0003\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002042\b\b\u0002\u00106\u001a\u0002042\b\b\u0002\u00107\u001a\u0002042\b\b\u0002\u00108\u001a\u0002042\b\b\u0002\u00109\u001a\u0002042\b\b\u0002\u0010:\u001a\u0002042\b\b\u0002\u0010;\u001a\u0002042\b\b\u0002\u0010<\u001a\u0002042\b\b\u0002\u0010=\u001a\u0002042\b\b\u0002\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u0002042\b\b\u0002\u0010A\u001a\u0002042\b\b\u0002\u0010B\u001a\u0002042\b\b\u0002\u0010C\u001a\u0002042\b\b\u0002\u0010D\u001a\u0002042\b\b\u0002\u0010E\u001a\u0002042\b\b\u0002\u0010F\u001a\u0002042\b\b\u0002\u0010G\u001a\u0002042\b\b\u0002\u0010H\u001a\u0002042\b\b\u0002\u0010I\u001a\u0002042\b\b\u0002\u0010J\u001a\u0002042\b\b\u0002\u0010K\u001a\u0002042\b\b\u0002\u0010L\u001a\u0002042\b\b\u0002\u0010M\u001a\u0002042\b\b\u0002\u0010N\u001a\u0002042\b\b\u0002\u0010O\u001a\u0002042\b\b\u0002\u0010P\u001a\u0002042\b\b\u0002\u0010Q\u001a\u0002042\b\b\u0002\u0010R\u001a\u0002042\b\b\u0002\u0010S\u001a\u0002042\b\b\u0002\u0010T\u001a\u0002042\b\b\u0002\u0010U\u001a\u0002042\b\b\u0002\u0010V\u001a\u0002042\b\b\u0002\u0010W\u001a\u0002042\b\b\u0002\u0010X\u001a\u0002042\b\b\u0002\u0010Y\u001a\u0002042\b\b\u0002\u0010Z\u001a\u0002042\b\b\u0002\u0010[\u001a\u0002042\b\b\u0002\u0010\\\u001a\u0002042\b\b\u0002\u0010]\u001a\u0002042\b\b\u0002\u0010^\u001a\u0002042\b\b\u0002\u0010_\u001a\u000204H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b`\u0010aJ;\u0010/\u001a\u0002002\b\b\u0002\u0010b\u001a\u00020\u00042\b\b\u0002\u0010c\u001a\u00020\u00042\b\b\u0002\u0010d\u001a\u00020\u00042\b\b\u0002\u0010e\u001a\u00020\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bf\u0010gR\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0011\u0010\u000e\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006h"}, d2 = {"Landroidx/compose/material3/OutlinedTextFieldDefaults;", "", "()V", "FocusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "getFocusedBorderThickness-D9Ej5fM", "()F", "F", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "ContainerBox", "", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "Landroidx/compose/material3/TextFieldColors;", "focusedBorderThickness", "unfocusedBorderThickness", "ContainerBox-nbWgWpA", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "DecorationBox", "value", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "container", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "focusedTextColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "colors-0hiis_0", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIIII)Landroidx/compose/material3/TextFieldColors;", "start", "top", "end", "bottom", "contentPadding-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class OutlinedTextFieldDefaults {
    public static final int $stable = 0;
    public static final OutlinedTextFieldDefaults INSTANCE = new OutlinedTextFieldDefaults();
    private static final float MinHeight = Dp.m5218constructorimpl(56);
    private static final float MinWidth = Dp.m5218constructorimpl(280);
    private static final float UnfocusedBorderThickness = Dp.m5218constructorimpl(1);
    private static final float FocusedBorderThickness = Dp.m5218constructorimpl(2);

    private OutlinedTextFieldDefaults() {
    }

    public final Shape getShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-1066756961);
        ComposerKt.sourceInformation($composer, "C1347@74442L9:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1066756961, $changed, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.<get-shape> (TextFieldDefaults.kt:1347)");
        }
        Shape shape = ShapesKt.toShape(OutlinedTextFieldTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }

    /* renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m1640getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m1641getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    /* renamed from: getUnfocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m1642getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }

    /* renamed from: getFocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m1639getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* renamed from: ContainerBox-nbWgWpA, reason: not valid java name */
    public final void m1636ContainerBoxnbWgWpA(final boolean enabled, final boolean isError, final InteractionSource interactionSource, final TextFieldColors colors, Shape shape, float focusedBorderThickness, float unfocusedBorderThickness, Composer $composer, final int $changed, final int i) {
        Shape shape2;
        float focusedBorderThickness2;
        float f;
        Shape shape3;
        Shape shape4;
        float focusedBorderThickness3;
        float unfocusedBorderThickness2;
        int $dirty;
        State borderStroke;
        float unfocusedBorderThickness3;
        float unfocusedBorderThickness4;
        Shape shape5;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Composer $composer2 = $composer.startRestartGroup(1461761386);
        ComposerKt.sourceInformation($composer2, "C(ContainerBox)P(1,4,3!1,5,2:c#ui.unit.Dp,6:c#ui.unit.Dp)1394@76327L9,1398@76498L203,1410@76843L51,1406@76710L199:TextFieldDefaults.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(enabled) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty2 |= $composer2.changed(isError) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer2.changed(interactionSource) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty2 |= $composer2.changed(colors) ? 2048 : 1024;
        }
        if (($changed & 57344) == 0) {
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
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0) {
                focusedBorderThickness2 = focusedBorderThickness;
                if ($composer2.changed(focusedBorderThickness2)) {
                    i3 = 131072;
                    $dirty2 |= i3;
                }
            } else {
                focusedBorderThickness2 = focusedBorderThickness;
            }
            i3 = 65536;
            $dirty2 |= i3;
        } else {
            focusedBorderThickness2 = focusedBorderThickness;
        }
        if ((3670016 & $changed) == 0) {
            if ((i & 64) == 0) {
                f = unfocusedBorderThickness;
                if ($composer2.changed(f)) {
                    i2 = 1048576;
                    $dirty2 |= i2;
                }
            } else {
                f = unfocusedBorderThickness;
            }
            i2 = 524288;
            $dirty2 |= i2;
        } else {
            f = unfocusedBorderThickness;
        }
        if ((i & 128) != 0) {
            $dirty2 |= 12582912;
        } else if ((29360128 & $changed) == 0) {
            $dirty2 |= $composer2.changed(this) ? 8388608 : 4194304;
        }
        if ((23967451 & $dirty2) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            shape5 = shape2;
            unfocusedBorderThickness4 = focusedBorderThickness2;
            unfocusedBorderThickness3 = f;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if ((i & 16) != 0) {
                    shape3 = ShapesKt.toShape(OutlinedTextFieldTokens.INSTANCE.getContainerShape(), $composer2, 6);
                    $dirty2 &= -57345;
                } else {
                    shape3 = shape2;
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                    focusedBorderThickness2 = FocusedBorderThickness;
                }
                if ((i & 64) != 0) {
                    $dirty = $dirty2 & (-3670017);
                    shape4 = shape3;
                    unfocusedBorderThickness2 = UnfocusedBorderThickness;
                    focusedBorderThickness3 = focusedBorderThickness2;
                } else {
                    shape4 = shape3;
                    focusedBorderThickness3 = focusedBorderThickness2;
                    unfocusedBorderThickness2 = f;
                    $dirty = $dirty2;
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
                    $dirty2 &= -3670017;
                }
                shape4 = shape2;
                focusedBorderThickness3 = focusedBorderThickness2;
                unfocusedBorderThickness2 = f;
                $dirty = $dirty2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1461761386, $dirty, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.ContainerBox (TextFieldDefaults.kt:1389)");
            }
            int $dirty3 = $dirty;
            Shape shape6 = shape4;
            borderStroke = TextFieldDefaultsKt.m1861animateBorderStrokeAsStateNuRrP5Q(enabled, isError, interactionSource, colors, focusedBorderThickness3, unfocusedBorderThickness2, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (($dirty >> 3) & 57344) | (($dirty >> 3) & 458752));
            BoxKt.Box(BackgroundKt.m162backgroundbw27NRU(BorderKt.border(Modifier.INSTANCE, (BorderStroke) borderStroke.getValue(), shape6), colors.containerColor$material3_release(enabled, isError, interactionSource, $composer2, ($dirty3 & 14) | ($dirty3 & 112) | ($dirty3 & 896) | ($dirty3 & 7168)).getValue().m2959unboximpl(), shape6), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            unfocusedBorderThickness3 = unfocusedBorderThickness2;
            unfocusedBorderThickness4 = focusedBorderThickness3;
            shape5 = shape6;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Shape shape7 = shape5;
        final float f2 = unfocusedBorderThickness4;
        final float f3 = unfocusedBorderThickness3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$ContainerBox$1
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

            public final void invoke(Composer composer, int i5) {
                OutlinedTextFieldDefaults.this.m1636ContainerBoxnbWgWpA(enabled, isError, interactionSource, colors, shape7, f2, f3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    /* renamed from: contentPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m1635contentPaddinga9UjIt4$default(OutlinedTextFieldDefaults outlinedTextFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return outlinedTextFieldDefaults.m1638contentPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: contentPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m1638contentPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m480PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* renamed from: colors-0hiis_0, reason: not valid java name */
    public final TextFieldColors m1637colors0hiis_0(long focusedTextColor, long unfocusedTextColor, long disabledTextColor, long errorTextColor, long focusedContainerColor, long unfocusedContainerColor, long disabledContainerColor, long errorContainerColor, long cursorColor, long errorCursorColor, SelectionColors selectionColors, long focusedBorderColor, long unfocusedBorderColor, long disabledBorderColor, long errorBorderColor, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long focusedPlaceholderColor, long unfocusedPlaceholderColor, long disabledPlaceholderColor, long errorPlaceholderColor, long focusedSupportingTextColor, long unfocusedSupportingTextColor, long disabledSupportingTextColor, long errorSupportingTextColor, long focusedPrefixColor, long unfocusedPrefixColor, long disabledPrefixColor, long errorPrefixColor, long focusedSuffixColor, long unfocusedSuffixColor, long disabledSuffixColor, long errorSuffixColor, Composer $composer, int $changed, int $changed1, int $changed2, int $changed3, int $changed4, int i, int i2) {
        long unfocusedTextColor2;
        long disabledTextColor2;
        long errorTextColor2;
        long focusedContainerColor2;
        long unfocusedContainerColor2;
        long disabledContainerColor2;
        long errorContainerColor2;
        long cursorColor2;
        long errorCursorColor2;
        SelectionColors selectionColors2;
        long focusedBorderColor2;
        long unfocusedBorderColor2;
        long disabledBorderColor2;
        long errorBorderColor2;
        long focusedLeadingIconColor2;
        long unfocusedLeadingIconColor2;
        long disabledLeadingIconColor2;
        long errorLeadingIconColor2;
        long focusedTrailingIconColor2;
        long unfocusedTrailingIconColor2;
        long disabledTrailingIconColor2;
        long errorTrailingIconColor2;
        long focusedLabelColor2;
        long unfocusedLabelColor2;
        long disabledLabelColor2;
        long errorLabelColor2;
        long focusedPlaceholderColor2;
        long unfocusedPlaceholderColor2;
        long disabledPlaceholderColor2;
        long errorPlaceholderColor2;
        long focusedSupportingTextColor2;
        long unfocusedSupportingTextColor2;
        long disabledSupportingTextColor2;
        long errorSupportingTextColor2;
        long focusedPrefixColor2;
        long unfocusedPrefixColor2;
        long disabledPrefixColor2;
        long errorPrefixColor2;
        long focusedSuffixColor2;
        long unfocusedSuffixColor2;
        long disabledSuffixColor2;
        long errorSuffixColor2;
        long m2947copywmQWz5c;
        long m2947copywmQWz5c2;
        long m2947copywmQWz5c3;
        long m2947copywmQWz5c4;
        long m2947copywmQWz5c5;
        long m2947copywmQWz5c6;
        long m2947copywmQWz5c7;
        long m2947copywmQWz5c8;
        long m2947copywmQWz5c9;
        $composer.startReplaceableGroup(1767617725);
        ComposerKt.sourceInformation($composer, "C(colors)P(30:c#ui.graphics.Color,41:c#ui.graphics.Color,9:c#ui.graphics.Color,20:c#ui.graphics.Color,23:c#ui.graphics.Color,34:c#ui.graphics.Color,2:c#ui.graphics.Color,12:c#ui.graphics.Color,0:c#ui.graphics.Color,13:c#ui.graphics.Color,32,22:c#ui.graphics.Color,33:c#ui.graphics.Color,1:c#ui.graphics.Color,11:c#ui.graphics.Color,25:c#ui.graphics.Color,36:c#ui.graphics.Color,4:c#ui.graphics.Color,15:c#ui.graphics.Color,31:c#ui.graphics.Color,42:c#ui.graphics.Color,10:c#ui.graphics.Color,21:c#ui.graphics.Color,24:c#ui.graphics.Color,35:c#ui.graphics.Color,3:c#ui.graphics.Color,14:c#ui.graphics.Color,26:c#ui.graphics.Color,37:c#ui.graphics.Color,5:c#ui.graphics.Color,16:c#ui.graphics.Color,29:c#ui.graphics.Color,40:c#ui.graphics.Color,8:c#ui.graphics.Color,19:c#ui.graphics.Color,27:c#ui.graphics.Color,38:c#ui.graphics.Color,6:c#ui.graphics.Color,17:c#ui.graphics.Color,28:c#ui.graphics.Color,39:c#ui.graphics.Color,7:c#ui.graphics.Color,18:c#ui.graphics.Color)1479@81602L9,1480@81684L9,1481@81773L9,1483@81928L9,1488@82236L9,1489@82326L9,1490@82409L7,1491@82496L9,1492@82582L9,1493@82675L9,1495@82836L9,1496@82934L9,1497@83029L9,1498@83131L9,1500@83305L9,1501@83405L9,1502@83502L9,1504@83619L9,1505@83783L9,1506@83869L9,1507@83952L9,1508@84042L9,1510@84198L9,1511@84296L9,1512@84396L9,1513@84492L9,1515@84660L9,1516@84760L9,1517@84857L9,1519@84974L9,1520@85136L9,1521@85224L9,1522@85314L9,1523@85403L9,1525@85561L9,1526@85649L9,1527@85739L9,1528@85828L9,1530@85986L9:TextFieldDefaults.kt#uh7d8r");
        long focusedTextColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getFocusInputColor(), $composer, 6) : focusedTextColor;
        if ((i & 2) == 0) {
            unfocusedTextColor2 = unfocusedTextColor;
        } else {
            unfocusedTextColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputColor(), $composer, 6);
        }
        if ((i & 4) != 0) {
            m2947copywmQWz5c9 = Color.m2947copywmQWz5c(r8, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r8) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r8) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r8) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor(), $composer, 6)) : 0.0f);
            disabledTextColor2 = m2947copywmQWz5c9;
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        if ((i & 8) == 0) {
            errorTextColor2 = errorTextColor;
        } else {
            errorTextColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getErrorInputColor(), $composer, 6);
        }
        if ((i & 16) == 0) {
            focusedContainerColor2 = focusedContainerColor;
        } else {
            focusedContainerColor2 = Color.INSTANCE.m2984getTransparent0d7_KjU();
        }
        if ((i & 32) == 0) {
            unfocusedContainerColor2 = unfocusedContainerColor;
        } else {
            unfocusedContainerColor2 = Color.INSTANCE.m2984getTransparent0d7_KjU();
        }
        if ((i & 64) == 0) {
            disabledContainerColor2 = disabledContainerColor;
        } else {
            disabledContainerColor2 = Color.INSTANCE.m2984getTransparent0d7_KjU();
        }
        if ((i & 128) == 0) {
            errorContainerColor2 = errorContainerColor;
        } else {
            errorContainerColor2 = Color.INSTANCE.m2984getTransparent0d7_KjU();
        }
        if ((i & 256) == 0) {
            cursorColor2 = cursorColor;
        } else {
            cursorColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getCaretColor(), $composer, 6);
        }
        if ((i & 512) == 0) {
            errorCursorColor2 = errorCursorColor;
        } else {
            errorCursorColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getErrorFocusCaretColor(), $composer, 6);
        }
        if ((i & 1024) == 0) {
            selectionColors2 = selectionColors;
        } else {
            ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd($composer);
            selectionColors2 = (SelectionColors) consume;
        }
        if ((i & 2048) != 0) {
            focusedBorderColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getFocusOutlineColor(), $composer, 6);
        } else {
            focusedBorderColor2 = focusedBorderColor;
        }
        if ((i & 4096) == 0) {
            unfocusedBorderColor2 = unfocusedBorderColor;
        } else {
            unfocusedBorderColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getOutlineColor(), $composer, 6);
        }
        if ((i & 8192) != 0) {
            m2947copywmQWz5c8 = Color.m2947copywmQWz5c(r8, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r8) : 0.12f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r8) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r8) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getDisabledOutlineColor(), $composer, 6)) : 0.0f);
            disabledBorderColor2 = m2947copywmQWz5c8;
        } else {
            disabledBorderColor2 = disabledBorderColor;
        }
        if ((i & 16384) == 0) {
            errorBorderColor2 = errorBorderColor;
        } else {
            errorBorderColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getErrorOutlineColor(), $composer, 6);
        }
        if ((32768 & i) == 0) {
            focusedLeadingIconColor2 = focusedLeadingIconColor;
        } else {
            focusedLeadingIconColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getFocusLeadingIconColor(), $composer, 6);
        }
        if ((65536 & i) == 0) {
            unfocusedLeadingIconColor2 = unfocusedLeadingIconColor;
        } else {
            unfocusedLeadingIconColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getLeadingIconColor(), $composer, 6);
        }
        if ((131072 & i) != 0) {
            m2947copywmQWz5c7 = Color.m2947copywmQWz5c(r8, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r8) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r8) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r8) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), $composer, 6)) : 0.0f);
            disabledLeadingIconColor2 = m2947copywmQWz5c7;
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        if ((262144 & i) == 0) {
            errorLeadingIconColor2 = errorLeadingIconColor;
        } else {
            errorLeadingIconColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getErrorLeadingIconColor(), $composer, 6);
        }
        if ((524288 & i) == 0) {
            focusedTrailingIconColor2 = focusedTrailingIconColor;
        } else {
            focusedTrailingIconColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getFocusTrailingIconColor(), $composer, 6);
        }
        if ((1048576 & i) == 0) {
            unfocusedTrailingIconColor2 = unfocusedTrailingIconColor;
        } else {
            unfocusedTrailingIconColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getTrailingIconColor(), $composer, 6);
        }
        if ((2097152 & i) != 0) {
            m2947copywmQWz5c6 = Color.m2947copywmQWz5c(r8, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r8) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r8) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r8) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), $composer, 6)) : 0.0f);
            disabledTrailingIconColor2 = m2947copywmQWz5c6;
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        if ((4194304 & i) == 0) {
            errorTrailingIconColor2 = errorTrailingIconColor;
        } else {
            errorTrailingIconColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getErrorTrailingIconColor(), $composer, 6);
        }
        if ((8388608 & i) == 0) {
            focusedLabelColor2 = focusedLabelColor;
        } else {
            focusedLabelColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getFocusLabelColor(), $composer, 6);
        }
        if ((16777216 & i) == 0) {
            unfocusedLabelColor2 = unfocusedLabelColor;
        } else {
            unfocusedLabelColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getLabelColor(), $composer, 6);
        }
        if ((33554432 & i) != 0) {
            m2947copywmQWz5c5 = Color.m2947copywmQWz5c(r8, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r8) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r8) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r8) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getDisabledLabelColor(), $composer, 6)) : 0.0f);
            disabledLabelColor2 = m2947copywmQWz5c5;
        } else {
            disabledLabelColor2 = disabledLabelColor;
        }
        if ((67108864 & i) == 0) {
            errorLabelColor2 = errorLabelColor;
        } else {
            errorLabelColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getErrorLabelColor(), $composer, 6);
        }
        if ((134217728 & i) == 0) {
            focusedPlaceholderColor2 = focusedPlaceholderColor;
        } else {
            focusedPlaceholderColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor(), $composer, 6);
        }
        if ((268435456 & i) == 0) {
            unfocusedPlaceholderColor2 = unfocusedPlaceholderColor;
        } else {
            unfocusedPlaceholderColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor(), $composer, 6);
        }
        if ((536870912 & i) != 0) {
            m2947copywmQWz5c4 = Color.m2947copywmQWz5c(r8, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r8) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r8) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r8) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor(), $composer, 6)) : 0.0f);
            disabledPlaceholderColor2 = m2947copywmQWz5c4;
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if ((i & BasicMeasure.EXACTLY) == 0) {
            errorPlaceholderColor2 = errorPlaceholderColor;
        } else {
            errorPlaceholderColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor(), $composer, 6);
        }
        if ((i2 & 1) == 0) {
            focusedSupportingTextColor2 = focusedSupportingTextColor;
        } else {
            focusedSupportingTextColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getFocusSupportingColor(), $composer, 6);
        }
        if ((i2 & 2) == 0) {
            unfocusedSupportingTextColor2 = unfocusedSupportingTextColor;
        } else {
            unfocusedSupportingTextColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getSupportingColor(), $composer, 6);
        }
        if ((i2 & 4) != 0) {
            m2947copywmQWz5c3 = Color.m2947copywmQWz5c(r8, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r8) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r8) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r8) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getDisabledSupportingColor(), $composer, 6)) : 0.0f);
            disabledSupportingTextColor2 = m2947copywmQWz5c3;
        } else {
            disabledSupportingTextColor2 = disabledSupportingTextColor;
        }
        if ((i2 & 8) == 0) {
            errorSupportingTextColor2 = errorSupportingTextColor;
        } else {
            errorSupportingTextColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getErrorSupportingColor(), $composer, 6);
        }
        if ((i2 & 16) == 0) {
            focusedPrefixColor2 = focusedPrefixColor;
        } else {
            focusedPrefixColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor(), $composer, 6);
        }
        if ((i2 & 32) == 0) {
            unfocusedPrefixColor2 = unfocusedPrefixColor;
        } else {
            unfocusedPrefixColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor(), $composer, 6);
        }
        if ((i2 & 64) != 0) {
            m2947copywmQWz5c2 = Color.m2947copywmQWz5c(r8, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r8) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r8) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r8) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor(), $composer, 6)) : 0.0f);
            disabledPrefixColor2 = m2947copywmQWz5c2;
        } else {
            disabledPrefixColor2 = disabledPrefixColor;
        }
        if ((i2 & 128) == 0) {
            errorPrefixColor2 = errorPrefixColor;
        } else {
            errorPrefixColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor(), $composer, 6);
        }
        if ((i2 & 256) == 0) {
            focusedSuffixColor2 = focusedSuffixColor;
        } else {
            focusedSuffixColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor(), $composer, 6);
        }
        if ((i2 & 512) == 0) {
            unfocusedSuffixColor2 = unfocusedSuffixColor;
        } else {
            unfocusedSuffixColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor(), $composer, 6);
        }
        if ((i2 & 1024) != 0) {
            m2947copywmQWz5c = Color.m2947copywmQWz5c(r8, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r8) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r8) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r8) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor(), $composer, 6)) : 0.0f);
            disabledSuffixColor2 = m2947copywmQWz5c;
        } else {
            disabledSuffixColor2 = disabledSuffixColor;
        }
        if ((i2 & 2048) == 0) {
            errorSuffixColor2 = errorSuffixColor;
        } else {
            errorSuffixColor2 = ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor(), $composer, 6);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1767617725, $changed, $changed1, "androidx.compose.material3.OutlinedTextFieldDefaults.colors (TextFieldDefaults.kt:1478)");
        }
        TextFieldColors textFieldColors = new TextFieldColors(focusedTextColor2, unfocusedTextColor2, disabledTextColor2, errorTextColor2, focusedContainerColor2, unfocusedContainerColor2, disabledContainerColor2, errorContainerColor2, cursorColor2, errorCursorColor2, selectionColors2, focusedBorderColor2, unfocusedBorderColor2, disabledBorderColor2, errorBorderColor2, focusedLeadingIconColor2, unfocusedLeadingIconColor2, disabledLeadingIconColor2, errorLeadingIconColor2, focusedTrailingIconColor2, unfocusedTrailingIconColor2, disabledTrailingIconColor2, errorTrailingIconColor2, focusedLabelColor2, unfocusedLabelColor2, disabledLabelColor2, errorLabelColor2, focusedPlaceholderColor2, unfocusedPlaceholderColor2, disabledPlaceholderColor2, errorPlaceholderColor2, focusedSupportingTextColor2, unfocusedSupportingTextColor2, disabledSupportingTextColor2, errorSupportingTextColor2, focusedPrefixColor2, unfocusedPrefixColor2, disabledPrefixColor2, errorPrefixColor2, focusedSuffixColor2, unfocusedSuffixColor2, disabledSuffixColor2, errorSuffixColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return textFieldColors;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x04ca  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x04c0  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void DecorationBox(final java.lang.String r117, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r118, final boolean r119, final boolean r120, final androidx.compose.ui.text.input.VisualTransformation r121, final androidx.compose.foundation.interaction.InteractionSource r122, boolean r123, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r124, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r125, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r126, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r127, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r128, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r129, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r130, androidx.compose.material3.TextFieldColors r131, androidx.compose.foundation.layout.PaddingValues r132, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r133, androidx.compose.runtime.Composer r134, final int r135, final int r136, final int r137) {
        /*
            Method dump skipped, instructions count: 1287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox(java.lang.String, kotlin.jvm.functions.Function2, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
