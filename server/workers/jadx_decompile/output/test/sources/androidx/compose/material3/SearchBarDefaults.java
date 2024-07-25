package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.text.selection.SelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.tokens.FilledTextFieldTokens;
import androidx.compose.material3.tokens.SearchBarTokens;
import androidx.compose.material3.tokens.SearchViewTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

/* compiled from: SearchBar.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J3\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u008d\u0001\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001f\u001a\u00020\u00192\b\b\u0002\u0010 \u001a\u00020\u00192\b\b\u0002\u0010!\u001a\u00020\u00192\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u00192\b\b\u0002\u0010%\u001a\u00020\u00192\b\b\u0002\u0010&\u001a\u00020\u00192\b\b\u0002\u0010'\u001a\u00020\u00192\b\b\u0002\u0010(\u001a\u00020\u00192\b\b\u0002\u0010)\u001a\u00020\u00192\b\b\u0002\u0010*\u001a\u00020\u00192\b\b\u0002\u0010+\u001a\u00020\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010-J¡\u0001\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010.\u001a\u00020\u00192\b\b\u0002\u0010/\u001a\u00020\u00192\b\b\u0002\u0010 \u001a\u00020\u00192\b\b\u0002\u0010!\u001a\u00020\u00192\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u00192\b\b\u0002\u0010%\u001a\u00020\u00192\b\b\u0002\u0010&\u001a\u00020\u00192\b\b\u0002\u0010'\u001a\u00020\u00192\b\b\u0002\u0010(\u001a\u00020\u00192\b\b\u0002\u0010)\u001a\u00020\u00192\b\b\u0002\u00100\u001a\u00020\u00192\b\b\u0002\u00101\u001a\u00020\u00192\b\b\u0002\u0010+\u001a\u00020\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u00103R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0012\u001a\u00020\u00138G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00064"}, d2 = {"Landroidx/compose/material3/SearchBarDefaults;", "", "()V", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM", "()F", "F", "InputFieldHeight", "getInputFieldHeight-D9Ej5fM", "dockedShape", "Landroidx/compose/ui/graphics/Shape;", "getDockedShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "fullScreenShape", "getFullScreenShape", "inputFieldShape", "getInputFieldShape", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "colors", "Landroidx/compose/material3/SearchBarColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "dividerColor", "inputFieldColors", "Landroidx/compose/material3/TextFieldColors;", "colors-Klgx-Pg", "(JJLandroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SearchBarColors;", "textColor", "disabledTextColor", "cursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "placeholderColor", "disabledPlaceholderColor", "inputFieldColors--u-KgnY", "(JJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "unfocusedTextColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "inputFieldColors-ITpI4ow", "(JJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/TextFieldColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SearchBarDefaults {
    public static final int $stable = 0;
    public static final SearchBarDefaults INSTANCE = new SearchBarDefaults();
    private static final float Elevation = SearchBarTokens.INSTANCE.m2422getContainerElevationD9Ej5fM();
    private static final float InputFieldHeight = SearchBarTokens.INSTANCE.m2423getContainerHeightD9Ej5fM();

    private SearchBarDefaults() {
    }

    /* renamed from: getElevation-D9Ej5fM, reason: not valid java name */
    public final float m1683getElevationD9Ej5fM() {
        return Elevation;
    }

    /* renamed from: getInputFieldHeight-D9Ej5fM, reason: not valid java name */
    public final float m1684getInputFieldHeightD9Ej5fM() {
        return InputFieldHeight;
    }

    public final Shape getInputFieldShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-1770571533);
        ComposerKt.sourceInformation($composer, "C504@23164L9:SearchBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1770571533, $changed, -1, "androidx.compose.material3.SearchBarDefaults.<get-inputFieldShape> (SearchBar.kt:504)");
        }
        Shape shape = ShapesKt.toShape(SearchBarTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }

    public final Shape getFullScreenShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-2009956471);
        ComposerKt.sourceInformation($composer, "C508@23340L9:SearchBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2009956471, $changed, -1, "androidx.compose.material3.SearchBarDefaults.<get-fullScreenShape> (SearchBar.kt:508)");
        }
        Shape shape = ShapesKt.toShape(SearchViewTokens.INSTANCE.getFullScreenContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }

    public final Shape getDockedShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-1447354121);
        ComposerKt.sourceInformation($composer, "C511@23486L9:SearchBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1447354121, $changed, -1, "androidx.compose.material3.SearchBarDefaults.<get-dockedShape> (SearchBar.kt:511)");
        }
        Shape shape = ShapesKt.toShape(SearchViewTokens.INSTANCE.getDockedContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }

    public final WindowInsets getWindowInsets(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-1795925906);
        ComposerKt.sourceInformation($composer, "C514@23617L10:SearchBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1795925906, $changed, -1, "androidx.compose.material3.SearchBarDefaults.<get-windowInsets> (SearchBar.kt:514)");
        }
        WindowInsets statusBars = WindowInsets_androidKt.getStatusBars(WindowInsets.INSTANCE, $composer, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return statusBars;
    }

    /* renamed from: colors-Klgx-Pg, reason: not valid java name */
    public final SearchBarColors m1682colorsKlgxPg(long containerColor, long dividerColor, TextFieldColors inputFieldColors, Composer $composer, int $changed, int i) {
        long dividerColor2;
        TextFieldColors inputFieldColors2;
        $composer.startReplaceableGroup(701925149);
        ComposerKt.sourceInformation($composer, "C(colors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color)526@24106L9,527@24177L9,528@24232L18:SearchBar.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(SearchBarTokens.INSTANCE.getContainerColor(), $composer, 6) : containerColor;
        if ((i & 2) == 0) {
            dividerColor2 = dividerColor;
        } else {
            dividerColor2 = ColorSchemeKt.toColor(SearchViewTokens.INSTANCE.getDividerColor(), $composer, 6);
        }
        if ((i & 4) == 0) {
            inputFieldColors2 = inputFieldColors;
        } else {
            inputFieldColors2 = m1686inputFieldColorsITpI4ow(0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer, 0, ($changed << 3) & 57344, 16383);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(701925149, $changed, -1, "androidx.compose.material3.SearchBarDefaults.colors (SearchBar.kt:525)");
        }
        SearchBarColors searchBarColors = new SearchBarColors(containerColor2, dividerColor2, inputFieldColors2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return searchBarColors;
    }

    /* renamed from: inputFieldColors-ITpI4ow, reason: not valid java name */
    public final TextFieldColors m1686inputFieldColorsITpI4ow(long focusedTextColor, long unfocusedTextColor, long disabledTextColor, long cursorColor, SelectionColors selectionColors, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long focusedPlaceholderColor, long unfocusedPlaceholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int i) {
        long unfocusedTextColor2;
        long disabledTextColor2;
        long cursorColor2;
        SelectionColors selectionColors2;
        long focusedLeadingIconColor2;
        long unfocusedLeadingIconColor2;
        long disabledLeadingIconColor2;
        long focusedTrailingIconColor2;
        long unfocusedTrailingIconColor2;
        long disabledTrailingIconColor2;
        long focusedPlaceholderColor2;
        long unfocusedPlaceholderColor2;
        long disabledPlaceholderColor2;
        long m2947copywmQWz5c;
        long m2947copywmQWz5c2;
        long m2947copywmQWz5c3;
        long m2947copywmQWz5c4;
        $composer.startReplaceableGroup(-2048506052);
        ComposerKt.sourceInformation($composer, "C(inputFieldColors)P(7:c#ui.graphics.Color,12:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color,9,5:c#ui.graphics.Color,10:c#ui.graphics.Color,1:c#ui.graphics.Color,8:c#ui.graphics.Color,13:c#ui.graphics.Color,4:c#ui.graphics.Color,6:c#ui.graphics.Color,11:c#ui.graphics.Color,2:c#ui.graphics.Color)561@26199L9,562@26277L9,563@26364L9,565@26507L9,566@26590L7,567@26673L9,568@26760L9,570@26873L9,571@27023L9,572@27112L9,574@27227L9,575@27379L9,576@27469L9,577@27563L9,580@27695L847:SearchBar.kt#uh7d8r");
        long focusedTextColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(SearchBarTokens.INSTANCE.getInputTextColor(), $composer, 6) : focusedTextColor;
        if ((i & 2) == 0) {
            unfocusedTextColor2 = unfocusedTextColor;
        } else {
            unfocusedTextColor2 = ColorSchemeKt.toColor(SearchBarTokens.INSTANCE.getInputTextColor(), $composer, 6);
        }
        if ((i & 4) != 0) {
            m2947copywmQWz5c4 = Color.m2947copywmQWz5c(r7, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r7) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r7) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r7) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), $composer, 6)) : 0.0f);
            disabledTextColor2 = m2947copywmQWz5c4;
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        if ((i & 8) == 0) {
            cursorColor2 = cursorColor;
        } else {
            cursorColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getCaretColor(), $composer, 6);
        }
        if ((i & 16) == 0) {
            selectionColors2 = selectionColors;
        } else {
            ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd($composer);
            selectionColors2 = (SelectionColors) consume;
        }
        if ((i & 32) != 0) {
            focusedLeadingIconColor2 = ColorSchemeKt.toColor(SearchBarTokens.INSTANCE.getLeadingIconColor(), $composer, 6);
        } else {
            focusedLeadingIconColor2 = focusedLeadingIconColor;
        }
        if ((i & 64) == 0) {
            unfocusedLeadingIconColor2 = unfocusedLeadingIconColor;
        } else {
            unfocusedLeadingIconColor2 = ColorSchemeKt.toColor(SearchBarTokens.INSTANCE.getLeadingIconColor(), $composer, 6);
        }
        if ((i & 128) != 0) {
            m2947copywmQWz5c3 = Color.m2947copywmQWz5c(r7, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r7) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r7) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r7) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), $composer, 6)) : 0.0f);
            disabledLeadingIconColor2 = m2947copywmQWz5c3;
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        if ((i & 256) == 0) {
            focusedTrailingIconColor2 = focusedTrailingIconColor;
        } else {
            focusedTrailingIconColor2 = ColorSchemeKt.toColor(SearchBarTokens.INSTANCE.getTrailingIconColor(), $composer, 6);
        }
        if ((i & 512) == 0) {
            unfocusedTrailingIconColor2 = unfocusedTrailingIconColor;
        } else {
            unfocusedTrailingIconColor2 = ColorSchemeKt.toColor(SearchBarTokens.INSTANCE.getTrailingIconColor(), $composer, 6);
        }
        if ((i & 1024) != 0) {
            m2947copywmQWz5c2 = Color.m2947copywmQWz5c(r7, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r7) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r7) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r7) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), $composer, 6)) : 0.0f);
            disabledTrailingIconColor2 = m2947copywmQWz5c2;
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        if ((i & 2048) == 0) {
            focusedPlaceholderColor2 = focusedPlaceholderColor;
        } else {
            focusedPlaceholderColor2 = ColorSchemeKt.toColor(SearchBarTokens.INSTANCE.getSupportingTextColor(), $composer, 6);
        }
        if ((i & 4096) == 0) {
            unfocusedPlaceholderColor2 = unfocusedPlaceholderColor;
        } else {
            unfocusedPlaceholderColor2 = ColorSchemeKt.toColor(SearchBarTokens.INSTANCE.getSupportingTextColor(), $composer, 6);
        }
        if ((i & 8192) != 0) {
            m2947copywmQWz5c = Color.m2947copywmQWz5c(r7, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r7) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r7) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r7) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), $composer, 6)) : 0.0f);
            disabledPlaceholderColor2 = m2947copywmQWz5c;
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2048506052, $changed, $changed1, "androidx.compose.material3.SearchBarDefaults.inputFieldColors (SearchBar.kt:560)");
        }
        TextFieldColors m1842colors0hiis_0 = TextFieldDefaults.INSTANCE.m1842colors0hiis_0(focusedTextColor2, unfocusedTextColor2, disabledTextColor2, 0L, 0L, 0L, 0L, 0L, cursorColor2, 0L, selectionColors2, 0L, 0L, 0L, 0L, focusedLeadingIconColor2, unfocusedLeadingIconColor2, disabledLeadingIconColor2, 0L, focusedTrailingIconColor2, unfocusedTrailingIconColor2, disabledTrailingIconColor2, 0L, 0L, 0L, 0L, 0L, focusedPlaceholderColor2, unfocusedPlaceholderColor2, disabledPlaceholderColor2, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer, ($changed & 14) | ($changed & 112) | ($changed & 896) | (($changed << 15) & 234881024), (($changed >> 12) & 14) | (458752 & $changed) | (3670016 & $changed) | ($changed & 29360128) | (($changed << 3) & 1879048192), (($changed >> 27) & 14) | (($changed1 << 3) & 112) | (29360128 & ($changed1 << 18)) | (($changed1 << 18) & 234881024) | (($changed1 << 18) & 1879048192), 0, 3072, 1204058872, 4095);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return m1842colors0hiis_0;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: inputFieldColors--u-KgnY, reason: not valid java name */
    public final /* synthetic */ TextFieldColors m1685inputFieldColorsuKgnY(long textColor, long disabledTextColor, long cursorColor, SelectionColors selectionColors, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long placeholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int i) {
        long disabledTextColor2;
        long cursorColor2;
        SelectionColors selectionColors2;
        long focusedLeadingIconColor2;
        long unfocusedLeadingIconColor2;
        long disabledLeadingIconColor2;
        long focusedTrailingIconColor2;
        long unfocusedTrailingIconColor2;
        long disabledTrailingIconColor2;
        long placeholderColor2;
        long disabledPlaceholderColor2;
        long m2947copywmQWz5c;
        long m2947copywmQWz5c2;
        long m2947copywmQWz5c3;
        long m2947copywmQWz5c4;
        $composer.startReplaceableGroup(1842555178);
        ComposerKt.sourceInformation($composer, "C(inputFieldColors)P(9:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color,8,5:c#ui.graphics.Color,10:c#ui.graphics.Color,1:c#ui.graphics.Color,6:c#ui.graphics.Color,11:c#ui.graphics.Color,4:c#ui.graphics.Color,7:c#ui.graphics.Color,2:c#ui.graphics.Color)600@28732L9,601@28819L9,603@28962L9,604@29045L7,605@29128L9,606@29215L9,608@29328L9,609@29478L9,610@29567L9,612@29682L9,613@29827L9,614@29921L9,616@30010L765:SearchBar.kt#uh7d8r");
        long textColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(SearchBarTokens.INSTANCE.getInputTextColor(), $composer, 6) : textColor;
        if ((i & 2) != 0) {
            m2947copywmQWz5c4 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), $composer, 6)) : 0.0f);
            disabledTextColor2 = m2947copywmQWz5c4;
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        if ((i & 4) == 0) {
            cursorColor2 = cursorColor;
        } else {
            cursorColor2 = ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getCaretColor(), $composer, 6);
        }
        if ((i & 8) == 0) {
            selectionColors2 = selectionColors;
        } else {
            ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd($composer);
            selectionColors2 = (SelectionColors) consume;
        }
        if ((i & 16) != 0) {
            focusedLeadingIconColor2 = ColorSchemeKt.toColor(SearchBarTokens.INSTANCE.getLeadingIconColor(), $composer, 6);
        } else {
            focusedLeadingIconColor2 = focusedLeadingIconColor;
        }
        if ((i & 32) == 0) {
            unfocusedLeadingIconColor2 = unfocusedLeadingIconColor;
        } else {
            unfocusedLeadingIconColor2 = ColorSchemeKt.toColor(SearchBarTokens.INSTANCE.getLeadingIconColor(), $composer, 6);
        }
        if ((i & 64) != 0) {
            m2947copywmQWz5c3 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), $composer, 6)) : 0.0f);
            disabledLeadingIconColor2 = m2947copywmQWz5c3;
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        if ((i & 128) == 0) {
            focusedTrailingIconColor2 = focusedTrailingIconColor;
        } else {
            focusedTrailingIconColor2 = ColorSchemeKt.toColor(SearchBarTokens.INSTANCE.getTrailingIconColor(), $composer, 6);
        }
        if ((i & 256) == 0) {
            unfocusedTrailingIconColor2 = unfocusedTrailingIconColor;
        } else {
            unfocusedTrailingIconColor2 = ColorSchemeKt.toColor(SearchBarTokens.INSTANCE.getTrailingIconColor(), $composer, 6);
        }
        if ((i & 512) != 0) {
            m2947copywmQWz5c2 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), $composer, 6)) : 0.0f);
            disabledTrailingIconColor2 = m2947copywmQWz5c2;
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        if ((i & 1024) == 0) {
            placeholderColor2 = placeholderColor;
        } else {
            placeholderColor2 = ColorSchemeKt.toColor(SearchBarTokens.INSTANCE.getSupportingTextColor(), $composer, 6);
        }
        if ((i & 2048) != 0) {
            m2947copywmQWz5c = Color.m2947copywmQWz5c(r2, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r2) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r2) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r2) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), $composer, 6)) : 0.0f);
            disabledPlaceholderColor2 = m2947copywmQWz5c;
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1842555178, $changed, $changed1, "androidx.compose.material3.SearchBarDefaults.inputFieldColors (SearchBar.kt:599)");
        }
        TextFieldColors m1686inputFieldColorsITpI4ow = m1686inputFieldColorsITpI4ow(textColor2, textColor2, disabledTextColor2, cursorColor2, selectionColors2, focusedLeadingIconColor2, unfocusedLeadingIconColor2, disabledLeadingIconColor2, focusedTrailingIconColor2, unfocusedTrailingIconColor2, disabledTrailingIconColor2, placeholderColor2, placeholderColor2, disabledPlaceholderColor2, $composer, ($changed & 14) | (($changed << 3) & 112) | (($changed << 3) & 896) | (($changed << 3) & 7168) | (($changed << 3) & 57344) | (($changed << 3) & 458752) | (($changed << 3) & 3670016) | (($changed << 3) & 29360128) | (($changed << 3) & 234881024) | (($changed << 3) & 1879048192), (($changed >> 27) & 14) | (($changed1 << 3) & 112) | (($changed1 << 6) & 896) | (($changed1 << 6) & 7168) | (($changed1 << 6) & 57344), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return m1686inputFieldColorsITpI4ow;
    }
}
