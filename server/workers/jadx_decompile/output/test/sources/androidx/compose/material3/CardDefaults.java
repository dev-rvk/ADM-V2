package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.ElevatedCardTokens;
import androidx.compose.material3.tokens.FilledCardTokens;
import androidx.compose.material3.tokens.OutlinedCardTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: Card.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J=\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000eH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013JQ\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00172\b\b\u0002\u0010\u001c\u001a\u00020\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ=\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000eH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010\u0013JQ\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00172\b\b\u0002\u0010\u001c\u001a\u00020\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010\u001eJ\u0017\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&H\u0007¢\u0006\u0002\u0010'J=\u0010(\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000eH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010\u0013JQ\u0010*\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00172\b\b\u0002\u0010\u001c\u001a\u00020\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010\u001eR\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006,"}, d2 = {"Landroidx/compose/material3/CardDefaults;", "", "()V", "elevatedShape", "Landroidx/compose/ui/graphics/Shape;", "getElevatedShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "outlinedShape", "getOutlinedShape", "shape", "getShape", "cardColors", "Landroidx/compose/material3/CardColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "cardColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/CardColors;", "cardElevation", "Landroidx/compose/material3/CardElevation;", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "cardElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/CardElevation;", "elevatedCardColors", "elevatedCardColors-ro_MJ88", "elevatedCardElevation", "elevatedCardElevation-aqJV_2Y", "outlinedCardBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "outlinedCardColors", "outlinedCardColors-ro_MJ88", "outlinedCardElevation", "outlinedCardElevation-aqJV_2Y", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class CardDefaults {
    public static final int $stable = 0;
    public static final CardDefaults INSTANCE = new CardDefaults();

    private CardDefaults() {
    }

    public final Shape getShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(1266660211);
        ComposerKt.sourceInformation($composer, "C354@16330L9:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1266660211, $changed, -1, "androidx.compose.material3.CardDefaults.<get-shape> (Card.kt:354)");
        }
        Shape shape = ShapesKt.toShape(FilledCardTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }

    public final Shape getElevatedShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-133496185);
        ComposerKt.sourceInformation($composer, "C357@16471L9:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-133496185, $changed, -1, "androidx.compose.material3.CardDefaults.<get-elevatedShape> (Card.kt:357)");
        }
        Shape shape = ShapesKt.toShape(ElevatedCardTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }

    public final Shape getOutlinedShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(1095404023);
        ComposerKt.sourceInformation($composer, "C360@16612L9:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1095404023, $changed, -1, "androidx.compose.material3.CardDefaults.<get-outlinedShape> (Card.kt:360)");
        }
        Shape shape = ShapesKt.toShape(OutlinedCardTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }

    /* renamed from: cardElevation-aqJV_2Y, reason: not valid java name */
    public final CardElevation m1335cardElevationaqJV_2Y(float defaultElevation, float pressedElevation, float focusedElevation, float hoveredElevation, float draggedElevation, float disabledElevation, Composer $composer, int $changed, int i) {
        float pressedElevation2;
        float focusedElevation2;
        float hoveredElevation2;
        float draggedElevation2;
        float disabledElevation2;
        $composer.startReplaceableGroup(-574898487);
        ComposerKt.sourceInformation($composer, "C(cardElevation)P(0:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,2:c#ui.unit.Dp,1:c#ui.unit.Dp):Card.kt#uh7d8r");
        float defaultElevation2 = (i & 1) != 0 ? FilledCardTokens.INSTANCE.m2212getContainerElevationD9Ej5fM() : defaultElevation;
        if ((i & 2) == 0) {
            pressedElevation2 = pressedElevation;
        } else {
            pressedElevation2 = FilledCardTokens.INSTANCE.m2218getPressedContainerElevationD9Ej5fM();
        }
        if ((i & 4) == 0) {
            focusedElevation2 = focusedElevation;
        } else {
            focusedElevation2 = FilledCardTokens.INSTANCE.m2215getFocusContainerElevationD9Ej5fM();
        }
        if ((i & 8) == 0) {
            hoveredElevation2 = hoveredElevation;
        } else {
            hoveredElevation2 = FilledCardTokens.INSTANCE.m2216getHoverContainerElevationD9Ej5fM();
        }
        if ((i & 16) == 0) {
            draggedElevation2 = draggedElevation;
        } else {
            draggedElevation2 = FilledCardTokens.INSTANCE.m2214getDraggedContainerElevationD9Ej5fM();
        }
        if ((i & 32) == 0) {
            disabledElevation2 = disabledElevation;
        } else {
            disabledElevation2 = FilledCardTokens.INSTANCE.m2213getDisabledContainerElevationD9Ej5fM();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-574898487, $changed, -1, "androidx.compose.material3.CardDefaults.cardElevation (Card.kt:373)");
        }
        CardElevation cardElevation = new CardElevation(defaultElevation2, pressedElevation2, focusedElevation2, hoveredElevation2, draggedElevation2, disabledElevation2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return cardElevation;
    }

    /* renamed from: elevatedCardElevation-aqJV_2Y, reason: not valid java name */
    public final CardElevation m1337elevatedCardElevationaqJV_2Y(float defaultElevation, float pressedElevation, float focusedElevation, float hoveredElevation, float draggedElevation, float disabledElevation, Composer $composer, int $changed, int i) {
        float pressedElevation2;
        float focusedElevation2;
        float hoveredElevation2;
        float draggedElevation2;
        float disabledElevation2;
        $composer.startReplaceableGroup(1154241939);
        ComposerKt.sourceInformation($composer, "C(elevatedCardElevation)P(0:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,2:c#ui.unit.Dp,1:c#ui.unit.Dp):Card.kt#uh7d8r");
        float defaultElevation2 = (i & 1) != 0 ? ElevatedCardTokens.INSTANCE.m2128getContainerElevationD9Ej5fM() : defaultElevation;
        if ((i & 2) == 0) {
            pressedElevation2 = pressedElevation;
        } else {
            pressedElevation2 = ElevatedCardTokens.INSTANCE.m2134getPressedContainerElevationD9Ej5fM();
        }
        if ((i & 4) == 0) {
            focusedElevation2 = focusedElevation;
        } else {
            focusedElevation2 = ElevatedCardTokens.INSTANCE.m2131getFocusContainerElevationD9Ej5fM();
        }
        if ((i & 8) == 0) {
            hoveredElevation2 = hoveredElevation;
        } else {
            hoveredElevation2 = ElevatedCardTokens.INSTANCE.m2132getHoverContainerElevationD9Ej5fM();
        }
        if ((i & 16) == 0) {
            draggedElevation2 = draggedElevation;
        } else {
            draggedElevation2 = ElevatedCardTokens.INSTANCE.m2130getDraggedContainerElevationD9Ej5fM();
        }
        if ((i & 32) == 0) {
            disabledElevation2 = disabledElevation;
        } else {
            disabledElevation2 = ElevatedCardTokens.INSTANCE.m2129getDisabledContainerElevationD9Ej5fM();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1154241939, $changed, -1, "androidx.compose.material3.CardDefaults.elevatedCardElevation (Card.kt:401)");
        }
        CardElevation cardElevation = new CardElevation(defaultElevation2, pressedElevation2, focusedElevation2, hoveredElevation2, draggedElevation2, disabledElevation2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return cardElevation;
    }

    /* renamed from: outlinedCardElevation-aqJV_2Y, reason: not valid java name */
    public final CardElevation m1339outlinedCardElevationaqJV_2Y(float defaultElevation, float pressedElevation, float focusedElevation, float hoveredElevation, float draggedElevation, float disabledElevation, Composer $composer, int $changed, int i) {
        float pressedElevation2;
        float focusedElevation2;
        float hoveredElevation2;
        float draggedElevation2;
        float disabledElevation2;
        $composer.startReplaceableGroup(-97678773);
        ComposerKt.sourceInformation($composer, "C(outlinedCardElevation)P(0:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,2:c#ui.unit.Dp,1:c#ui.unit.Dp):Card.kt#uh7d8r");
        float defaultElevation2 = (i & 1) != 0 ? OutlinedCardTokens.INSTANCE.m2314getContainerElevationD9Ej5fM() : defaultElevation;
        if ((i & 2) == 0) {
            pressedElevation2 = pressedElevation;
        } else {
            pressedElevation2 = defaultElevation2;
        }
        if ((i & 4) == 0) {
            focusedElevation2 = focusedElevation;
        } else {
            focusedElevation2 = defaultElevation2;
        }
        if ((i & 8) == 0) {
            hoveredElevation2 = hoveredElevation;
        } else {
            hoveredElevation2 = defaultElevation2;
        }
        if ((i & 16) == 0) {
            draggedElevation2 = draggedElevation;
        } else {
            draggedElevation2 = OutlinedCardTokens.INSTANCE.m2316getDraggedContainerElevationD9Ej5fM();
        }
        if ((i & 32) == 0) {
            disabledElevation2 = disabledElevation;
        } else {
            disabledElevation2 = OutlinedCardTokens.INSTANCE.m2315getDisabledContainerElevationD9Ej5fM();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-97678773, $changed, -1, "androidx.compose.material3.CardDefaults.outlinedCardElevation (Card.kt:429)");
        }
        CardElevation cardElevation = new CardElevation(defaultElevation2, pressedElevation2, focusedElevation2, hoveredElevation2, draggedElevation2, disabledElevation2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return cardElevation;
    }

    /* renamed from: cardColors-ro_MJ88, reason: not valid java name */
    public final CardColors m1334cardColorsro_MJ88(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, Composer $composer, int $changed, int i) {
        long contentColor2;
        long disabledContainerColor2;
        long disabledContentColor2;
        long m2947copywmQWz5c;
        long m2947copywmQWz5c2;
        $composer.startReplaceableGroup(-1589582123);
        ComposerKt.sourceInformation($composer, "C(cardColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)456@21362L9,457@21403L31,459@21528L9,462@21677L11,466@21861L31:Card.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(FilledCardTokens.INSTANCE.getContainerColor(), $composer, 6) : containerColor;
        if ((i & 2) == 0) {
            contentColor2 = contentColor;
        } else {
            contentColor2 = ColorSchemeKt.m1414contentColorForek8zF_U(containerColor2, $composer, $changed & 14);
        }
        if ((i & 4) != 0) {
            m2947copywmQWz5c2 = Color.m2947copywmQWz5c(r7, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r7) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r7) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r7) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledCardTokens.INSTANCE.getDisabledContainerColor(), $composer, 6)) : 0.0f);
            disabledContainerColor2 = ColorKt.m2994compositeOverOWjLjI(m2947copywmQWz5c2, ColorSchemeKt.m1419surfaceColorAtElevation3ABfNKs(MaterialTheme.INSTANCE.getColorScheme($composer, 6), FilledCardTokens.INSTANCE.m2213getDisabledContainerElevationD9Ej5fM()));
        } else {
            disabledContainerColor2 = disabledContainerColor;
        }
        if ((i & 8) != 0) {
            m2947copywmQWz5c = Color.m2947copywmQWz5c(r8, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r8) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r8) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r8) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.m1414contentColorForek8zF_U(containerColor2, $composer, $changed & 14)) : 0.0f);
            disabledContentColor2 = m2947copywmQWz5c;
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1589582123, $changed, -1, "androidx.compose.material3.CardDefaults.cardColors (Card.kt:455)");
        }
        CardColors cardColors = new CardColors(containerColor2, contentColor2, disabledContainerColor2, disabledContentColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return cardColors;
    }

    /* renamed from: elevatedCardColors-ro_MJ88, reason: not valid java name */
    public final CardColors m1336elevatedCardColorsro_MJ88(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, Composer $composer, int $changed, int i) {
        long contentColor2;
        long disabledContainerColor2;
        long disabledContentColor2;
        long m2947copywmQWz5c;
        long m2947copywmQWz5c2;
        $composer.startReplaceableGroup(139558303);
        ComposerKt.sourceInformation($composer, "C(elevatedCardColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)485@22754L9,486@22795L31,488@22922L9,491@23073L11:Card.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(ElevatedCardTokens.INSTANCE.getContainerColor(), $composer, 6) : containerColor;
        if ((i & 2) == 0) {
            contentColor2 = contentColor;
        } else {
            contentColor2 = ColorSchemeKt.m1414contentColorForek8zF_U(containerColor2, $composer, $changed & 14);
        }
        if ((i & 4) != 0) {
            m2947copywmQWz5c2 = Color.m2947copywmQWz5c(r7, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r7) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r7) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r7) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(ElevatedCardTokens.INSTANCE.getDisabledContainerColor(), $composer, 6)) : 0.0f);
            disabledContainerColor2 = ColorKt.m2994compositeOverOWjLjI(m2947copywmQWz5c2, ColorSchemeKt.m1419surfaceColorAtElevation3ABfNKs(MaterialTheme.INSTANCE.getColorScheme($composer, 6), ElevatedCardTokens.INSTANCE.m2129getDisabledContainerElevationD9Ej5fM()));
        } else {
            disabledContainerColor2 = disabledContainerColor;
        }
        if ((i & 8) != 0) {
            m2947copywmQWz5c = Color.m2947copywmQWz5c(r9, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r9) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r9) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r9) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(contentColor2) : 0.0f);
            disabledContentColor2 = m2947copywmQWz5c;
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(139558303, $changed, -1, "androidx.compose.material3.CardDefaults.elevatedCardColors (Card.kt:484)");
        }
        CardColors cardColors = new CardColors(containerColor2, contentColor2, disabledContainerColor2, disabledContentColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return cardColors;
    }

    /* renamed from: outlinedCardColors-ro_MJ88, reason: not valid java name */
    public final CardColors m1338outlinedCardColorsro_MJ88(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, Composer $composer, int $changed, int i) {
        long contentColor2;
        long disabledContainerColor2;
        long disabledContentColor2;
        long m2947copywmQWz5c;
        $composer.startReplaceableGroup(-1112362409);
        ComposerKt.sourceInformation($composer, "C(outlinedCardColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)515@24161L9,516@24202L31:Card.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(OutlinedCardTokens.INSTANCE.getContainerColor(), $composer, 6) : containerColor;
        if ((i & 2) == 0) {
            contentColor2 = contentColor;
        } else {
            contentColor2 = ColorSchemeKt.m1414contentColorForek8zF_U(containerColor2, $composer, $changed & 14);
        }
        if ((i & 4) == 0) {
            disabledContainerColor2 = disabledContainerColor;
        } else {
            disabledContainerColor2 = containerColor2;
        }
        if ((i & 8) != 0) {
            m2947copywmQWz5c = Color.m2947copywmQWz5c(r7, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r7) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r7) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r7) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(contentColor2) : 0.0f);
            disabledContentColor2 = m2947copywmQWz5c;
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1112362409, $changed, -1, "androidx.compose.material3.CardDefaults.outlinedCardColors (Card.kt:514)");
        }
        CardColors cardColors = new CardColors(containerColor2, contentColor2, disabledContainerColor2, disabledContentColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return cardColors;
    }

    public final BorderStroke outlinedCardBorder(boolean enabled, Composer $composer, int $changed, int i) {
        long m2947copywmQWz5c;
        long color;
        Object value$iv$iv;
        $composer.startReplaceableGroup(-392936593);
        ComposerKt.sourceInformation($composer, "C(outlinedCardBorder)545@25344L72:Card.kt#uh7d8r");
        if ((i & 1) != 0) {
            enabled = true;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-392936593, $changed, -1, "androidx.compose.material3.CardDefaults.outlinedCardBorder (Card.kt:533)");
        }
        if (enabled) {
            $composer.startReplaceableGroup(-31428837);
            ComposerKt.sourceInformation($composer, "535@24944L9");
            color = ColorSchemeKt.toColor(OutlinedCardTokens.INSTANCE.getOutlineColor(), $composer, 6);
            $composer.endReplaceableGroup();
        } else {
            $composer.startReplaceableGroup(-31428766);
            ComposerKt.sourceInformation($composer, "537@25023L9,540@25172L11");
            m2947copywmQWz5c = Color.m2947copywmQWz5c(r1, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r1) : 0.12f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r1) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r1) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedCardTokens.INSTANCE.getDisabledOutlineColor(), $composer, 6)) : 0.0f);
            color = ColorKt.m2994compositeOverOWjLjI(m2947copywmQWz5c, ColorSchemeKt.m1419surfaceColorAtElevation3ABfNKs(MaterialTheme.INSTANCE.getColorScheme($composer, 6), OutlinedCardTokens.INSTANCE.m2315getDisabledContainerElevationD9Ej5fM()));
            $composer.endReplaceableGroup();
        }
        Object key1$iv = Color.m2939boximpl(color);
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(key1$iv);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = BorderStrokeKt.m190BorderStrokecXLIe8U(OutlinedCardTokens.INSTANCE.m2320getOutlineWidthD9Ej5fM(), color);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        BorderStroke borderStroke = (BorderStroke) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return borderStroke;
    }
}
