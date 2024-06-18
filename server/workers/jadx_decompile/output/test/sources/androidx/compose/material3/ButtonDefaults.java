package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.ElevatedButtonTokens;
import androidx.compose.material3.tokens.FilledButtonTokens;
import androidx.compose.material3.tokens.FilledTonalButtonTokens;
import androidx.compose.material3.tokens.OutlinedButtonTokens;
import androidx.compose.material3.tokens.TextButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: Button.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J=\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u0002002\b\b\u0002\u00102\u001a\u0002002\b\b\u0002\u00103\u001a\u000200H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00105JG\u00106\u001a\u0002072\b\b\u0002\u00108\u001a\u00020\u00042\b\b\u0002\u00109\u001a\u00020\u00042\b\b\u0002\u0010:\u001a\u00020\u00042\b\b\u0002\u0010;\u001a\u00020\u00042\b\b\u0002\u0010<\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010>J=\u0010?\u001a\u00020.2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u0002002\b\b\u0002\u00102\u001a\u0002002\b\b\u0002\u00103\u001a\u000200H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b@\u00105JG\u0010A\u001a\u0002072\b\b\u0002\u00108\u001a\u00020\u00042\b\b\u0002\u00109\u001a\u00020\u00042\b\b\u0002\u0010:\u001a\u00020\u00042\b\b\u0002\u0010;\u001a\u00020\u00042\b\b\u0002\u0010<\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bB\u0010>J=\u0010C\u001a\u00020.2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u0002002\b\b\u0002\u00102\u001a\u0002002\b\b\u0002\u00103\u001a\u000200H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u00105JG\u0010E\u001a\u0002072\b\b\u0002\u00108\u001a\u00020\u00042\b\b\u0002\u00109\u001a\u00020\u00042\b\b\u0002\u0010:\u001a\u00020\u00042\b\b\u0002\u0010;\u001a\u00020\u00042\b\b\u0002\u0010<\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bF\u0010>J=\u0010G\u001a\u00020.2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u0002002\b\b\u0002\u00102\u001a\u0002002\b\b\u0002\u00103\u001a\u000200H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bH\u00105J=\u0010I\u001a\u00020.2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u0002002\b\b\u0002\u00102\u001a\u0002002\b\b\u0002\u00103\u001a\u000200H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bJ\u00105R\u0019\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0006\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u000b\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u001c\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0013\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0014\u0010\u0010R\u001c\u0010\u0015\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u0017\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\nR\u0019\u0010\u0019\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\u001a\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\nR\u0019\u0010\u001c\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\u001d\u001a\u00020\u001e8G¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u001e8G¢\u0006\u0006\u001a\u0004\b\"\u0010 R\u0011\u0010#\u001a\u00020$8G¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\u001e8G¢\u0006\u0006\u001a\u0004\b(\u0010 R\u0011\u0010)\u001a\u00020\u001e8G¢\u0006\u0006\u001a\u0004\b*\u0010 R\u0011\u0010+\u001a\u00020\u001e8G¢\u0006\u0006\u001a\u0004\b,\u0010 \u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006K"}, d2 = {"Landroidx/compose/material3/ButtonDefaults;", "", "()V", "ButtonHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ButtonVerticalPadding", "ButtonWithIconContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getButtonWithIconContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "ButtonWithIconHorizontalStartPadding", "ContentPadding", "getContentPadding", "IconSize", "getIconSize-D9Ej5fM", "()F", "IconSpacing", "getIconSpacing-D9Ej5fM", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "TextButtonContentPadding", "getTextButtonContentPadding", "TextButtonHorizontalPadding", "TextButtonWithIconContentPadding", "getTextButtonWithIconContentPadding", "TextButtonWithIconHorizontalEndPadding", "elevatedShape", "Landroidx/compose/ui/graphics/Shape;", "getElevatedShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "filledTonalShape", "getFilledTonalShape", "outlinedButtonBorder", "Landroidx/compose/foundation/BorderStroke;", "getOutlinedButtonBorder", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "outlinedShape", "getOutlinedShape", "shape", "getShape", "textShape", "getTextShape", "buttonColors", "Landroidx/compose/material3/ButtonColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "buttonColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ButtonColors;", "buttonElevation", "Landroidx/compose/material3/ButtonElevation;", "defaultElevation", "pressedElevation", "focusedElevation", "hoveredElevation", "disabledElevation", "buttonElevation-R_JCAzs", "(FFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ButtonElevation;", "elevatedButtonColors", "elevatedButtonColors-ro_MJ88", "elevatedButtonElevation", "elevatedButtonElevation-R_JCAzs", "filledTonalButtonColors", "filledTonalButtonColors-ro_MJ88", "filledTonalButtonElevation", "filledTonalButtonElevation-R_JCAzs", "outlinedButtonColors", "outlinedButtonColors-ro_MJ88", "textButtonColors", "textButtonColors-ro_MJ88", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ButtonDefaults {
    public static final int $stable = 0;
    public static final ButtonDefaults INSTANCE = new ButtonDefaults();
    private static final float ButtonHorizontalPadding = Dp.m5218constructorimpl(24);
    private static final float ButtonVerticalPadding = Dp.m5218constructorimpl(8);
    private static final PaddingValues ContentPadding = PaddingKt.m480PaddingValuesa9UjIt4(ButtonHorizontalPadding, ButtonVerticalPadding, ButtonHorizontalPadding, ButtonVerticalPadding);
    private static final float ButtonWithIconHorizontalStartPadding = Dp.m5218constructorimpl(16);
    private static final PaddingValues ButtonWithIconContentPadding = PaddingKt.m480PaddingValuesa9UjIt4(ButtonWithIconHorizontalStartPadding, ButtonVerticalPadding, ButtonHorizontalPadding, ButtonVerticalPadding);
    private static final float TextButtonHorizontalPadding = Dp.m5218constructorimpl(12);
    private static final PaddingValues TextButtonContentPadding = PaddingKt.m480PaddingValuesa9UjIt4(TextButtonHorizontalPadding, ContentPadding.getTop(), TextButtonHorizontalPadding, ContentPadding.getBottom());
    private static final float TextButtonWithIconHorizontalEndPadding = Dp.m5218constructorimpl(16);
    private static final PaddingValues TextButtonWithIconContentPadding = PaddingKt.m480PaddingValuesa9UjIt4(TextButtonHorizontalPadding, ContentPadding.getTop(), TextButtonWithIconHorizontalEndPadding, ContentPadding.getBottom());
    private static final float MinWidth = Dp.m5218constructorimpl(58);
    private static final float MinHeight = Dp.m5218constructorimpl(40);
    private static final float IconSize = FilledButtonTokens.INSTANCE.m2210getIconSizeD9Ej5fM();
    private static final float IconSpacing = Dp.m5218constructorimpl(8);

    private ButtonDefaults() {
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    public final PaddingValues getButtonWithIconContentPadding() {
        return ButtonWithIconContentPadding;
    }

    public final PaddingValues getTextButtonContentPadding() {
        return TextButtonContentPadding;
    }

    public final PaddingValues getTextButtonWithIconContentPadding() {
        return TextButtonWithIconContentPadding;
    }

    /* renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m1331getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    /* renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m1330getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m1328getIconSizeD9Ej5fM() {
        return IconSize;
    }

    /* renamed from: getIconSpacing-D9Ej5fM, reason: not valid java name */
    public final float m1329getIconSpacingD9Ej5fM() {
        return IconSpacing;
    }

    public final Shape getShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-1234923021);
        ComposerKt.sourceInformation($composer, "C528@25540L9:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1234923021, $changed, -1, "androidx.compose.material3.ButtonDefaults.<get-shape> (Button.kt:528)");
        }
        Shape shape = ShapesKt.toShape(FilledButtonTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }

    public final Shape getElevatedShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(2143958791);
        ComposerKt.sourceInformation($composer, "C531@25685L9:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2143958791, $changed, -1, "androidx.compose.material3.ButtonDefaults.<get-elevatedShape> (Button.kt:531)");
        }
        Shape shape = ShapesKt.toShape(ElevatedButtonTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }

    public final Shape getFilledTonalShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-886584987);
        ComposerKt.sourceInformation($composer, "C534@25839L9:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-886584987, $changed, -1, "androidx.compose.material3.ButtonDefaults.<get-filledTonalShape> (Button.kt:534)");
        }
        Shape shape = ShapesKt.toShape(FilledTonalButtonTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }

    public final Shape getOutlinedShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-2045213065);
        ComposerKt.sourceInformation($composer, "C537@25984L9:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2045213065, $changed, -1, "androidx.compose.material3.ButtonDefaults.<get-outlinedShape> (Button.kt:537)");
        }
        Shape shape = ShapesKt.toShape(OutlinedButtonTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }

    public final Shape getTextShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-349121587);
        ComposerKt.sourceInformation($composer, "C540@26116L9:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-349121587, $changed, -1, "androidx.compose.material3.ButtonDefaults.<get-textShape> (Button.kt:540)");
        }
        Shape shape = ShapesKt.toShape(TextButtonTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }

    /* renamed from: buttonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m1322buttonColorsro_MJ88(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, Composer $composer, int $changed, int i) {
        long contentColor2;
        long disabledContainerColor2;
        long disabledContentColor2;
        long m2947copywmQWz5c;
        $composer.startReplaceableGroup(-339300779);
        ComposerKt.sourceInformation($composer, "C(buttonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)553@26706L9,554@26781L9,556@26886L9,558@27052L9:Button.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(FilledButtonTokens.INSTANCE.getContainerColor(), $composer, 6) : containerColor;
        if ((i & 2) == 0) {
            contentColor2 = contentColor;
        } else {
            contentColor2 = ColorSchemeKt.toColor(FilledButtonTokens.INSTANCE.getLabelTextColor(), $composer, 6);
        }
        if ((i & 4) != 0) {
            m2947copywmQWz5c = Color.m2947copywmQWz5c(r6, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r6) : 0.12f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r6) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r6) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledButtonTokens.INSTANCE.getDisabledContainerColor(), $composer, 6)) : 0.0f);
            disabledContainerColor2 = m2947copywmQWz5c;
        } else {
            disabledContainerColor2 = disabledContainerColor;
        }
        if ((i & 8) != 0) {
            disabledContentColor2 = Color.m2947copywmQWz5c(r6, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r6) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r6) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r6) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledButtonTokens.INSTANCE.getDisabledLabelTextColor(), $composer, 6)) : 0.0f);
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-339300779, $changed, -1, "androidx.compose.material3.ButtonDefaults.buttonColors (Button.kt:552)");
        }
        ButtonColors buttonColors = new ButtonColors(containerColor2, contentColor2, disabledContainerColor2, disabledContentColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return buttonColors;
    }

    /* renamed from: elevatedButtonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m1324elevatedButtonColorsro_MJ88(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, Composer $composer, int $changed, int i) {
        long contentColor2;
        long disabledContainerColor2;
        long disabledContentColor2;
        long m2947copywmQWz5c;
        $composer.startReplaceableGroup(1507908383);
        ComposerKt.sourceInformation($composer, "C(elevatedButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)578@27990L9,579@28067L9,581@28175L9,584@28354L9:Button.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(ElevatedButtonTokens.INSTANCE.getContainerColor(), $composer, 6) : containerColor;
        if ((i & 2) == 0) {
            contentColor2 = contentColor;
        } else {
            contentColor2 = ColorSchemeKt.toColor(ElevatedButtonTokens.INSTANCE.getLabelTextColor(), $composer, 6);
        }
        if ((i & 4) != 0) {
            m2947copywmQWz5c = Color.m2947copywmQWz5c(r6, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r6) : 0.12f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r6) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r6) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(ElevatedButtonTokens.INSTANCE.getDisabledContainerColor(), $composer, 6)) : 0.0f);
            disabledContainerColor2 = m2947copywmQWz5c;
        } else {
            disabledContainerColor2 = disabledContainerColor;
        }
        if ((i & 8) != 0) {
            disabledContentColor2 = Color.m2947copywmQWz5c(r6, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r6) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r6) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r6) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(ElevatedButtonTokens.INSTANCE.getDisabledLabelTextColor(), $composer, 6)) : 0.0f);
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1507908383, $changed, -1, "androidx.compose.material3.ButtonDefaults.elevatedButtonColors (Button.kt:577)");
        }
        ButtonColors buttonColors = new ButtonColors(containerColor2, contentColor2, disabledContainerColor2, disabledContentColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return buttonColors;
    }

    /* renamed from: filledTonalButtonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m1326filledTonalButtonColorsro_MJ88(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, Composer $composer, int $changed, int i) {
        long contentColor2;
        long disabledContainerColor2;
        long disabledContentColor2;
        long m2947copywmQWz5c;
        $composer.startReplaceableGroup(1670757653);
        ComposerKt.sourceInformation($composer, "C(filledTonalButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)604@29315L9,605@29395L9,607@29506L9,610@29691L9:Button.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(FilledTonalButtonTokens.INSTANCE.getContainerColor(), $composer, 6) : containerColor;
        if ((i & 2) == 0) {
            contentColor2 = contentColor;
        } else {
            contentColor2 = ColorSchemeKt.toColor(FilledTonalButtonTokens.INSTANCE.getLabelTextColor(), $composer, 6);
        }
        if ((i & 4) != 0) {
            m2947copywmQWz5c = Color.m2947copywmQWz5c(r6, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r6) : 0.12f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r6) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r6) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTonalButtonTokens.INSTANCE.getDisabledContainerColor(), $composer, 6)) : 0.0f);
            disabledContainerColor2 = m2947copywmQWz5c;
        } else {
            disabledContainerColor2 = disabledContainerColor;
        }
        if ((i & 8) != 0) {
            disabledContentColor2 = Color.m2947copywmQWz5c(r6, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r6) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r6) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r6) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTonalButtonTokens.INSTANCE.getDisabledLabelTextColor(), $composer, 6)) : 0.0f);
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1670757653, $changed, -1, "androidx.compose.material3.ButtonDefaults.filledTonalButtonColors (Button.kt:603)");
        }
        ButtonColors buttonColors = new ButtonColors(containerColor2, contentColor2, disabledContainerColor2, disabledContentColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return buttonColors;
    }

    /* renamed from: outlinedButtonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m1332outlinedButtonColorsro_MJ88(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, Composer $composer, int $changed, int i) {
        long contentColor2;
        long disabledContainerColor2;
        long disabledContentColor2;
        long m2947copywmQWz5c;
        $composer.startReplaceableGroup(-1778526249);
        ComposerKt.sourceInformation($composer, "C(outlinedButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)631@30683L9,634@30848L9:Button.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? Color.INSTANCE.m2984getTransparent0d7_KjU() : containerColor;
        if ((i & 2) == 0) {
            contentColor2 = contentColor;
        } else {
            contentColor2 = ColorSchemeKt.toColor(OutlinedButtonTokens.INSTANCE.getLabelTextColor(), $composer, 6);
        }
        if ((i & 4) == 0) {
            disabledContainerColor2 = disabledContainerColor;
        } else {
            disabledContainerColor2 = Color.INSTANCE.m2984getTransparent0d7_KjU();
        }
        if ((i & 8) != 0) {
            m2947copywmQWz5c = Color.m2947copywmQWz5c(r6, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r6) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r6) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r6) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedButtonTokens.INSTANCE.getDisabledLabelTextColor(), $composer, 6)) : 0.0f);
            disabledContentColor2 = m2947copywmQWz5c;
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1778526249, $changed, -1, "androidx.compose.material3.ButtonDefaults.outlinedButtonColors (Button.kt:629)");
        }
        ButtonColors buttonColors = new ButtonColors(containerColor2, contentColor2, disabledContainerColor2, disabledContentColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return buttonColors;
    }

    /* renamed from: textButtonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m1333textButtonColorsro_MJ88(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, Composer $composer, int $changed, int i) {
        long contentColor2;
        long disabledContainerColor2;
        long disabledContentColor2;
        long m2947copywmQWz5c;
        $composer.startReplaceableGroup(-1402274782);
        ComposerKt.sourceInformation($composer, "C(textButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)655@31808L9,658@31969L9:Button.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? Color.INSTANCE.m2984getTransparent0d7_KjU() : containerColor;
        if ((i & 2) == 0) {
            contentColor2 = contentColor;
        } else {
            contentColor2 = ColorSchemeKt.toColor(TextButtonTokens.INSTANCE.getLabelTextColor(), $composer, 6);
        }
        if ((i & 4) == 0) {
            disabledContainerColor2 = disabledContainerColor;
        } else {
            disabledContainerColor2 = Color.INSTANCE.m2984getTransparent0d7_KjU();
        }
        if ((i & 8) != 0) {
            m2947copywmQWz5c = Color.m2947copywmQWz5c(r6, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r6) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r6) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r6) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(TextButtonTokens.INSTANCE.getDisabledLabelTextColor(), $composer, 6)) : 0.0f);
            disabledContentColor2 = m2947copywmQWz5c;
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1402274782, $changed, -1, "androidx.compose.material3.ButtonDefaults.textButtonColors (Button.kt:653)");
        }
        ButtonColors buttonColors = new ButtonColors(containerColor2, contentColor2, disabledContainerColor2, disabledContentColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return buttonColors;
    }

    /* renamed from: buttonElevation-R_JCAzs, reason: not valid java name */
    public final ButtonElevation m1323buttonElevationR_JCAzs(float defaultElevation, float pressedElevation, float focusedElevation, float hoveredElevation, float disabledElevation, Composer $composer, int $changed, int i) {
        float pressedElevation2;
        float focusedElevation2;
        float hoveredElevation2;
        float disabledElevation2;
        $composer.startReplaceableGroup(1827791191);
        ComposerKt.sourceInformation($composer, "C(buttonElevation)P(0:c#ui.unit.Dp,4:c#ui.unit.Dp,2:c#ui.unit.Dp,3:c#ui.unit.Dp,1:c#ui.unit.Dp):Button.kt#uh7d8r");
        float defaultElevation2 = (i & 1) != 0 ? FilledButtonTokens.INSTANCE.m2205getContainerElevationD9Ej5fM() : defaultElevation;
        if ((i & 2) == 0) {
            pressedElevation2 = pressedElevation;
        } else {
            pressedElevation2 = FilledButtonTokens.INSTANCE.m2211getPressedContainerElevationD9Ej5fM();
        }
        if ((i & 4) == 0) {
            focusedElevation2 = focusedElevation;
        } else {
            focusedElevation2 = FilledButtonTokens.INSTANCE.m2208getFocusContainerElevationD9Ej5fM();
        }
        if ((i & 8) == 0) {
            hoveredElevation2 = hoveredElevation;
        } else {
            hoveredElevation2 = FilledButtonTokens.INSTANCE.m2209getHoverContainerElevationD9Ej5fM();
        }
        if ((i & 16) == 0) {
            disabledElevation2 = disabledElevation;
        } else {
            disabledElevation2 = FilledButtonTokens.INSTANCE.m2207getDisabledContainerElevationD9Ej5fM();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1827791191, $changed, -1, "androidx.compose.material3.ButtonDefaults.buttonElevation (Button.kt:679)");
        }
        ButtonElevation buttonElevation = new ButtonElevation(defaultElevation2, pressedElevation2, focusedElevation2, hoveredElevation2, disabledElevation2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return buttonElevation;
    }

    /* renamed from: elevatedButtonElevation-R_JCAzs, reason: not valid java name */
    public final ButtonElevation m1325elevatedButtonElevationR_JCAzs(float defaultElevation, float pressedElevation, float focusedElevation, float hoveredElevation, float disabledElevation, Composer $composer, int $changed, int i) {
        float pressedElevation2;
        float focusedElevation2;
        float hoveredElevation2;
        float disabledElevation2;
        $composer.startReplaceableGroup(1065482445);
        ComposerKt.sourceInformation($composer, "C(elevatedButtonElevation)P(0:c#ui.unit.Dp,4:c#ui.unit.Dp,2:c#ui.unit.Dp,3:c#ui.unit.Dp,1:c#ui.unit.Dp):Button.kt#uh7d8r");
        float defaultElevation2 = (i & 1) != 0 ? ElevatedButtonTokens.INSTANCE.m2121getContainerElevationD9Ej5fM() : defaultElevation;
        if ((i & 2) == 0) {
            pressedElevation2 = pressedElevation;
        } else {
            pressedElevation2 = ElevatedButtonTokens.INSTANCE.m2127getPressedContainerElevationD9Ej5fM();
        }
        if ((i & 4) == 0) {
            focusedElevation2 = focusedElevation;
        } else {
            focusedElevation2 = ElevatedButtonTokens.INSTANCE.m2124getFocusContainerElevationD9Ej5fM();
        }
        if ((i & 8) == 0) {
            hoveredElevation2 = hoveredElevation;
        } else {
            hoveredElevation2 = ElevatedButtonTokens.INSTANCE.m2125getHoverContainerElevationD9Ej5fM();
        }
        if ((i & 16) == 0) {
            disabledElevation2 = disabledElevation;
        } else {
            disabledElevation2 = ElevatedButtonTokens.INSTANCE.m2123getDisabledContainerElevationD9Ej5fM();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1065482445, $changed, -1, "androidx.compose.material3.ButtonDefaults.elevatedButtonElevation (Button.kt:705)");
        }
        ButtonElevation buttonElevation = new ButtonElevation(defaultElevation2, pressedElevation2, focusedElevation2, hoveredElevation2, disabledElevation2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return buttonElevation;
    }

    /* renamed from: filledTonalButtonElevation-R_JCAzs, reason: not valid java name */
    public final ButtonElevation m1327filledTonalButtonElevationR_JCAzs(float defaultElevation, float pressedElevation, float focusedElevation, float hoveredElevation, float disabledElevation, Composer $composer, int $changed, int i) {
        float pressedElevation2;
        float focusedElevation2;
        float hoveredElevation2;
        float disabledElevation2;
        $composer.startReplaceableGroup(5982871);
        ComposerKt.sourceInformation($composer, "C(filledTonalButtonElevation)P(0:c#ui.unit.Dp,4:c#ui.unit.Dp,2:c#ui.unit.Dp,3:c#ui.unit.Dp,1:c#ui.unit.Dp):Button.kt#uh7d8r");
        float defaultElevation2 = (i & 1) != 0 ? FilledTonalButtonTokens.INSTANCE.m2228getContainerElevationD9Ej5fM() : defaultElevation;
        if ((i & 2) == 0) {
            pressedElevation2 = pressedElevation;
        } else {
            pressedElevation2 = FilledTonalButtonTokens.INSTANCE.m2234getPressedContainerElevationD9Ej5fM();
        }
        if ((i & 4) == 0) {
            focusedElevation2 = focusedElevation;
        } else {
            focusedElevation2 = FilledTonalButtonTokens.INSTANCE.m2231getFocusContainerElevationD9Ej5fM();
        }
        if ((i & 8) == 0) {
            hoveredElevation2 = hoveredElevation;
        } else {
            hoveredElevation2 = FilledTonalButtonTokens.INSTANCE.m2232getHoverContainerElevationD9Ej5fM();
        }
        if ((i & 16) == 0) {
            disabledElevation2 = disabledElevation;
        } else {
            disabledElevation2 = Dp.m5218constructorimpl(0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(5982871, $changed, -1, "androidx.compose.material3.ButtonDefaults.filledTonalButtonElevation (Button.kt:732)");
        }
        ButtonElevation buttonElevation = new ButtonElevation(defaultElevation2, pressedElevation2, focusedElevation2, hoveredElevation2, disabledElevation2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return buttonElevation;
    }

    public final BorderStroke getOutlinedButtonBorder(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-563957672);
        ComposerKt.sourceInformation($composer, "C751@36696L9:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-563957672, $changed, -1, "androidx.compose.material3.ButtonDefaults.<get-outlinedButtonBorder> (Button.kt:749)");
        }
        BorderStroke m190BorderStrokecXLIe8U = BorderStrokeKt.m190BorderStrokecXLIe8U(OutlinedButtonTokens.INSTANCE.m2313getOutlineWidthD9Ej5fM(), ColorSchemeKt.toColor(OutlinedButtonTokens.INSTANCE.getOutlineColor(), $composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return m190BorderStrokecXLIe8U;
    }
}
