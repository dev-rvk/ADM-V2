package androidx.compose.material3;

import androidx.compose.material3.tokens.FilterChipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: Chip.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u008d\u0001\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00112\b\b\u0002\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u0011H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJQ\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020\u00042\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u00042\b\b\u0002\u0010&\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(JQ\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020\u00112\b\b\u0002\u0010,\u001a\u00020\u00112\b\b\u0002\u0010-\u001a\u00020\u00112\b\b\u0002\u0010.\u001a\u00020\u00112\b\b\u0002\u0010/\u001a\u00020\u00042\b\b\u0002\u00100\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102J\u008d\u0001\u00103\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00112\b\b\u0002\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u0011H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u0010\u001eJQ\u00105\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020\u00042\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u00042\b\b\u0002\u0010&\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u0010(R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00067"}, d2 = {"Landroidx/compose/material3/FilterChipDefaults;", "", "()V", "Height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM", "()F", "F", "IconSize", "getIconSize-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "elevatedFilterChipColors", "Landroidx/compose/material3/SelectableChipColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "labelColor", "iconColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "selectedContainerColor", "disabledSelectedContainerColor", "selectedLabelColor", "selectedLeadingIconColor", "selectedTrailingIconColor", "elevatedFilterChipColors-XqyqHi0", "(JJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SelectableChipColors;", "elevatedFilterChipElevation", "Landroidx/compose/material3/SelectableChipElevation;", "elevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "elevatedFilterChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SelectableChipElevation;", "filterChipBorder", "Landroidx/compose/material3/SelectableChipBorder;", "borderColor", "selectedBorderColor", "disabledBorderColor", "disabledSelectedBorderColor", "borderWidth", "selectedBorderWidth", "filterChipBorder-gHcDVlo", "(JJJJFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SelectableChipBorder;", "filterChipColors", "filterChipColors-XqyqHi0", "filterChipElevation", "filterChipElevation-aqJV_2Y", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class FilterChipDefaults {
    public static final int $stable = 0;
    public static final FilterChipDefaults INSTANCE = new FilterChipDefaults();
    private static final float Height = FilterChipTokens.INSTANCE.m2237getContainerHeightD9Ej5fM();
    private static final float IconSize = FilterChipTokens.INSTANCE.m2253getIconSizeD9Ej5fM();

    private FilterChipDefaults() {
    }

    /* renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public final float m1531getHeightD9Ej5fM() {
        return Height;
    }

    /* renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m1532getIconSizeD9Ej5fM() {
        return IconSize;
    }

    /* renamed from: filterChipColors-XqyqHi0, reason: not valid java name */
    public final SelectableChipColors m1529filterChipColorsXqyqHi0(long containerColor, long labelColor, long iconColor, long disabledContainerColor, long disabledLabelColor, long disabledLeadingIconColor, long disabledTrailingIconColor, long selectedContainerColor, long disabledSelectedContainerColor, long selectedLabelColor, long selectedLeadingIconColor, long selectedTrailingIconColor, Composer $composer, int $changed, int $changed1, int i) {
        long labelColor2;
        long iconColor2;
        long disabledContainerColor2;
        long disabledLabelColor2;
        long disabledLeadingIconColor2;
        long disabledTrailingIconColor2;
        long selectedContainerColor2;
        long disabledSelectedContainerColor2;
        long selectedLabelColor2;
        long selectedLeadingIconColor2;
        long selectedTrailingIconColor2;
        long m2947copywmQWz5c;
        long m2947copywmQWz5c2;
        long m2947copywmQWz5c3;
        $composer.startReplaceableGroup(-1831479801);
        ComposerKt.sourceInformation($composer, "C(filterChipColors)P(0:c#ui.graphics.Color,7:c#ui.graphics.Color,6:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,5:c#ui.graphics.Color,8:c#ui.graphics.Color,4:c#ui.graphics.Color,9:c#ui.graphics.Color,10:c#ui.graphics.Color,11:c#ui.graphics.Color)822@41024L9,823@41106L9,825@41252L9,827@41416L9,830@41651L9,832@41774L9,834@41946L9,835@42041L9:Chip.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? Color.INSTANCE.m2984getTransparent0d7_KjU() : containerColor;
        if ((i & 2) == 0) {
            labelColor2 = labelColor;
        } else {
            labelColor2 = ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getUnselectedLabelTextColor(), $composer, 6);
        }
        if ((i & 4) == 0) {
            iconColor2 = iconColor;
        } else {
            iconColor2 = ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getLeadingIconUnselectedColor(), $composer, 6);
        }
        if ((i & 8) == 0) {
            disabledContainerColor2 = disabledContainerColor;
        } else {
            disabledContainerColor2 = Color.INSTANCE.m2984getTransparent0d7_KjU();
        }
        if ((i & 16) != 0) {
            m2947copywmQWz5c3 = Color.m2947copywmQWz5c(r7, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r7) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r7) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r7) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getDisabledLabelTextColor(), $composer, 6)) : 0.0f);
            disabledLabelColor2 = m2947copywmQWz5c3;
        } else {
            disabledLabelColor2 = disabledLabelColor;
        }
        if ((i & 32) != 0) {
            m2947copywmQWz5c2 = Color.m2947copywmQWz5c(r7, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r7) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r7) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r7) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getDisabledLeadingIconColor(), $composer, 6)) : 0.0f);
            disabledLeadingIconColor2 = m2947copywmQWz5c2;
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        if ((i & 64) == 0) {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        } else {
            disabledTrailingIconColor2 = disabledLeadingIconColor2;
        }
        if ((i & 128) == 0) {
            selectedContainerColor2 = selectedContainerColor;
        } else {
            selectedContainerColor2 = ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getFlatSelectedContainerColor(), $composer, 6);
        }
        if ((i & 256) != 0) {
            m2947copywmQWz5c = Color.m2947copywmQWz5c(r7, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r7) : 0.12f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r7) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r7) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getFlatDisabledSelectedContainerColor(), $composer, 6)) : 0.0f);
            disabledSelectedContainerColor2 = m2947copywmQWz5c;
        } else {
            disabledSelectedContainerColor2 = disabledSelectedContainerColor;
        }
        if ((i & 512) == 0) {
            selectedLabelColor2 = selectedLabelColor;
        } else {
            selectedLabelColor2 = ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getSelectedLabelTextColor(), $composer, 6);
        }
        if ((i & 1024) == 0) {
            selectedLeadingIconColor2 = selectedLeadingIconColor;
        } else {
            selectedLeadingIconColor2 = ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getSelectedLeadingIconColor(), $composer, 6);
        }
        if ((i & 2048) == 0) {
            selectedTrailingIconColor2 = selectedTrailingIconColor;
        } else {
            selectedTrailingIconColor2 = selectedLeadingIconColor2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1831479801, $changed, $changed1, "androidx.compose.material3.FilterChipDefaults.filterChipColors (Chip.kt:820)");
        }
        SelectableChipColors selectableChipColors = new SelectableChipColors(containerColor2, labelColor2, iconColor2, iconColor2, disabledContainerColor2, disabledLabelColor2, disabledLeadingIconColor2, disabledTrailingIconColor2, selectedContainerColor2, disabledSelectedContainerColor2, selectedLabelColor2, selectedLeadingIconColor2, selectedTrailingIconColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return selectableChipColors;
    }

    /* renamed from: filterChipElevation-aqJV_2Y, reason: not valid java name */
    public final SelectableChipElevation m1530filterChipElevationaqJV_2Y(float elevation, float pressedElevation, float focusedElevation, float hoveredElevation, float draggedElevation, float disabledElevation, Composer $composer, int $changed, int i) {
        float pressedElevation2;
        float focusedElevation2;
        float hoveredElevation2;
        float draggedElevation2;
        float disabledElevation2;
        $composer.startReplaceableGroup(-757972185);
        ComposerKt.sourceInformation($composer, "C(filterChipElevation)P(2:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,1:c#ui.unit.Dp,0:c#ui.unit.Dp):Chip.kt#uh7d8r");
        float elevation2 = (i & 1) != 0 ? FilterChipTokens.INSTANCE.m2244getFlatContainerElevationD9Ej5fM() : elevation;
        if ((i & 2) == 0) {
            pressedElevation2 = pressedElevation;
        } else {
            pressedElevation2 = FilterChipTokens.INSTANCE.m2248getFlatSelectedPressedContainerElevationD9Ej5fM();
        }
        if ((i & 4) == 0) {
            focusedElevation2 = focusedElevation;
        } else {
            focusedElevation2 = FilterChipTokens.INSTANCE.m2245getFlatSelectedFocusContainerElevationD9Ej5fM();
        }
        if ((i & 8) == 0) {
            hoveredElevation2 = hoveredElevation;
        } else {
            hoveredElevation2 = FilterChipTokens.INSTANCE.m2246getFlatSelectedHoverContainerElevationD9Ej5fM();
        }
        if ((i & 16) == 0) {
            draggedElevation2 = draggedElevation;
        } else {
            draggedElevation2 = FilterChipTokens.INSTANCE.m2238getDraggedContainerElevationD9Ej5fM();
        }
        if ((i & 32) == 0) {
            disabledElevation2 = disabledElevation;
        } else {
            disabledElevation2 = elevation2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-757972185, $changed, -1, "androidx.compose.material3.FilterChipDefaults.filterChipElevation (Chip.kt:866)");
        }
        SelectableChipElevation selectableChipElevation = new SelectableChipElevation(elevation2, pressedElevation2, focusedElevation2, hoveredElevation2, draggedElevation2, disabledElevation2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return selectableChipElevation;
    }

    /* renamed from: filterChipBorder-gHcDVlo, reason: not valid java name */
    public final SelectableChipBorder m1528filterChipBordergHcDVlo(long borderColor, long selectedBorderColor, long disabledBorderColor, long disabledSelectedBorderColor, float borderWidth, float selectedBorderWidth, Composer $composer, int $changed, int i) {
        long selectedBorderColor2;
        long disabledBorderColor2;
        long disabledSelectedBorderColor2;
        float borderWidth2;
        float selectedBorderWidth2;
        $composer.startReplaceableGroup(-1884534961);
        ComposerKt.sourceInformation($composer, "C(filterChipBorder)P(0:c#ui.graphics.Color,4:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,1:c#ui.unit.Dp,5:c#ui.unit.Dp)897@45140L9,899@45296L9:Chip.kt#uh7d8r");
        long borderColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getFlatUnselectedOutlineColor(), $composer, 6) : borderColor;
        if ((i & 2) == 0) {
            selectedBorderColor2 = selectedBorderColor;
        } else {
            selectedBorderColor2 = Color.INSTANCE.m2984getTransparent0d7_KjU();
        }
        if ((i & 4) != 0) {
            disabledBorderColor2 = Color.m2947copywmQWz5c(r6, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r6) : 0.12f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r6) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r6) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getFlatDisabledUnselectedOutlineColor(), $composer, 6)) : 0.0f);
        } else {
            disabledBorderColor2 = disabledBorderColor;
        }
        if ((i & 8) == 0) {
            disabledSelectedBorderColor2 = disabledSelectedBorderColor;
        } else {
            disabledSelectedBorderColor2 = Color.INSTANCE.m2984getTransparent0d7_KjU();
        }
        if ((i & 16) == 0) {
            borderWidth2 = borderWidth;
        } else {
            borderWidth2 = FilterChipTokens.INSTANCE.m2251getFlatUnselectedOutlineWidthD9Ej5fM();
        }
        if ((i & 32) == 0) {
            selectedBorderWidth2 = selectedBorderWidth;
        } else {
            selectedBorderWidth2 = FilterChipTokens.INSTANCE.m2247getFlatSelectedOutlineWidthD9Ej5fM();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1884534961, $changed, -1, "androidx.compose.material3.FilterChipDefaults.filterChipBorder (Chip.kt:896)");
        }
        SelectableChipBorder selectableChipBorder = new SelectableChipBorder(borderColor2, selectedBorderColor2, disabledBorderColor2, disabledSelectedBorderColor2, borderWidth2, selectedBorderWidth2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return selectableChipBorder;
    }

    /* renamed from: elevatedFilterChipColors-XqyqHi0, reason: not valid java name */
    public final SelectableChipColors m1526elevatedFilterChipColorsXqyqHi0(long containerColor, long labelColor, long iconColor, long disabledContainerColor, long disabledLabelColor, long disabledLeadingIconColor, long disabledTrailingIconColor, long selectedContainerColor, long disabledSelectedContainerColor, long selectedLabelColor, long selectedLeadingIconColor, long selectedTrailingIconColor, Composer $composer, int $changed, int $changed1, int i) {
        long labelColor2;
        long iconColor2;
        long disabledContainerColor2;
        long disabledLabelColor2;
        long disabledLeadingIconColor2;
        long disabledTrailingIconColor2;
        long selectedContainerColor2;
        long disabledSelectedContainerColor2;
        long selectedLabelColor2;
        long selectedLeadingIconColor2;
        long selectedTrailingIconColor2;
        long m2947copywmQWz5c;
        long m2947copywmQWz5c2;
        long m2947copywmQWz5c3;
        $composer.startReplaceableGroup(-915841711);
        ComposerKt.sourceInformation($composer, "C(elevatedFilterChipColors)P(0:c#ui.graphics.Color,7:c#ui.graphics.Color,6:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,5:c#ui.graphics.Color,8:c#ui.graphics.Color,4:c#ui.graphics.Color,9:c#ui.graphics.Color,10:c#ui.graphics.Color,11:c#ui.graphics.Color)933@47266L9,934@47347L9,935@47429L9,936@47528L9,938@47692L9,940@47856L9,943@48095L9,945@48254L9,946@48349L9:Chip.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getElevatedUnselectedContainerColor(), $composer, 6) : containerColor;
        if ((i & 2) == 0) {
            labelColor2 = labelColor;
        } else {
            labelColor2 = ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getUnselectedLabelTextColor(), $composer, 6);
        }
        if ((i & 4) == 0) {
            iconColor2 = iconColor;
        } else {
            iconColor2 = ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getLeadingIconUnselectedColor(), $composer, 6);
        }
        if ((i & 8) != 0) {
            m2947copywmQWz5c3 = Color.m2947copywmQWz5c(r7, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r7) : 0.12f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r7) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r7) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getElevatedDisabledContainerColor(), $composer, 6)) : 0.0f);
            disabledContainerColor2 = m2947copywmQWz5c3;
        } else {
            disabledContainerColor2 = disabledContainerColor;
        }
        if ((i & 16) != 0) {
            m2947copywmQWz5c2 = Color.m2947copywmQWz5c(r7, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r7) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r7) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r7) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getDisabledLabelTextColor(), $composer, 6)) : 0.0f);
            disabledLabelColor2 = m2947copywmQWz5c2;
        } else {
            disabledLabelColor2 = disabledLabelColor;
        }
        if ((i & 32) != 0) {
            m2947copywmQWz5c = Color.m2947copywmQWz5c(r7, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r7) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r7) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r7) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getDisabledLeadingIconColor(), $composer, 6)) : 0.0f);
            disabledLeadingIconColor2 = m2947copywmQWz5c;
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        if ((i & 64) == 0) {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        } else {
            disabledTrailingIconColor2 = disabledLeadingIconColor2;
        }
        if ((i & 128) == 0) {
            selectedContainerColor2 = selectedContainerColor;
        } else {
            selectedContainerColor2 = ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getElevatedSelectedContainerColor(), $composer, 6);
        }
        if ((i & 256) == 0) {
            disabledSelectedContainerColor2 = disabledSelectedContainerColor;
        } else {
            disabledSelectedContainerColor2 = disabledContainerColor2;
        }
        if ((i & 512) == 0) {
            selectedLabelColor2 = selectedLabelColor;
        } else {
            selectedLabelColor2 = ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getSelectedLabelTextColor(), $composer, 6);
        }
        if ((i & 1024) == 0) {
            selectedLeadingIconColor2 = selectedLeadingIconColor;
        } else {
            selectedLeadingIconColor2 = ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getSelectedLeadingIconColor(), $composer, 6);
        }
        if ((i & 2048) == 0) {
            selectedTrailingIconColor2 = selectedTrailingIconColor;
        } else {
            selectedTrailingIconColor2 = selectedLeadingIconColor2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-915841711, $changed, $changed1, "androidx.compose.material3.FilterChipDefaults.elevatedFilterChipColors (Chip.kt:932)");
        }
        SelectableChipColors selectableChipColors = new SelectableChipColors(containerColor2, labelColor2, iconColor2, iconColor2, disabledContainerColor2, disabledLabelColor2, disabledLeadingIconColor2, disabledTrailingIconColor2, selectedContainerColor2, disabledSelectedContainerColor2, selectedLabelColor2, selectedLeadingIconColor2, selectedTrailingIconColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return selectableChipColors;
    }

    /* renamed from: elevatedFilterChipElevation-aqJV_2Y, reason: not valid java name */
    public final SelectableChipElevation m1527elevatedFilterChipElevationaqJV_2Y(float elevation, float pressedElevation, float focusedElevation, float hoveredElevation, float draggedElevation, float disabledElevation, Composer $composer, int $changed, int i) {
        float pressedElevation2;
        float focusedElevation2;
        float hoveredElevation2;
        float draggedElevation2;
        float disabledElevation2;
        $composer.startReplaceableGroup(684803697);
        ComposerKt.sourceInformation($composer, "C(elevatedFilterChipElevation)P(2:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,1:c#ui.unit.Dp,0:c#ui.unit.Dp):Chip.kt#uh7d8r");
        float elevation2 = (i & 1) != 0 ? FilterChipTokens.INSTANCE.m2239getElevatedContainerElevationD9Ej5fM() : elevation;
        if ((i & 2) == 0) {
            pressedElevation2 = pressedElevation;
        } else {
            pressedElevation2 = FilterChipTokens.INSTANCE.m2243getElevatedPressedContainerElevationD9Ej5fM();
        }
        if ((i & 4) == 0) {
            focusedElevation2 = focusedElevation;
        } else {
            focusedElevation2 = FilterChipTokens.INSTANCE.m2241getElevatedFocusContainerElevationD9Ej5fM();
        }
        if ((i & 8) == 0) {
            hoveredElevation2 = hoveredElevation;
        } else {
            hoveredElevation2 = FilterChipTokens.INSTANCE.m2242getElevatedHoverContainerElevationD9Ej5fM();
        }
        if ((i & 16) == 0) {
            draggedElevation2 = draggedElevation;
        } else {
            draggedElevation2 = FilterChipTokens.INSTANCE.m2238getDraggedContainerElevationD9Ej5fM();
        }
        if ((i & 32) == 0) {
            disabledElevation2 = disabledElevation;
        } else {
            disabledElevation2 = FilterChipTokens.INSTANCE.m2240getElevatedDisabledContainerElevationD9Ej5fM();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(684803697, $changed, -1, "androidx.compose.material3.FilterChipDefaults.elevatedFilterChipElevation (Chip.kt:977)");
        }
        SelectableChipElevation selectableChipElevation = new SelectableChipElevation(elevation2, pressedElevation2, focusedElevation2, hoveredElevation2, draggedElevation2, disabledElevation2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return selectableChipElevation;
    }

    public final Shape getShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-1598643637);
        ComposerKt.sourceInformation($composer, "C994@50798L9:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1598643637, $changed, -1, "androidx.compose.material3.FilterChipDefaults.<get-shape> (Chip.kt:994)");
        }
        Shape shape = ShapesKt.toShape(FilterChipTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }
}
