package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: Chip.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JQ\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 Jo\u0010!\u001a\u00020\"2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010#\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010$\u001a\u00020\u00192\b\b\u0002\u0010%\u001a\u00020\u00192\b\b\u0002\u0010&\u001a\u00020\u00192\b\b\u0002\u0010'\u001a\u00020\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010)JQ\u0010*\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010 Jo\u0010,\u001a\u00020\"2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010#\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010$\u001a\u00020\u00192\b\b\u0002\u0010%\u001a\u00020\u00192\b\b\u0002\u0010&\u001a\u00020\u00192\b\b\u0002\u0010'\u001a\u00020\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010)R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\tR\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0011\u0010\tR\u0011\u0010\u0012\u001a\u00020\u00138G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006."}, d2 = {"Landroidx/compose/material/ChipDefaults;", "", "()V", "ContentOpacity", "", "LeadingIconOpacity", "LeadingIconSize", "Landroidx/compose/ui/unit/Dp;", "getLeadingIconSize-D9Ej5fM", "()F", "F", "MinHeight", "getMinHeight-D9Ej5fM", "OutlinedBorderOpacity", "OutlinedBorderSize", "getOutlinedBorderSize-D9Ej5fM", "SelectedIconSize", "getSelectedIconSize-D9Ej5fM", "outlinedBorder", "Landroidx/compose/foundation/BorderStroke;", "getOutlinedBorder", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "chipColors", "Landroidx/compose/material/ChipColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "leadingIconContentColor", "disabledBackgroundColor", "disabledContentColor", "disabledLeadingIconContentColor", "chipColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ChipColors;", "filterChipColors", "Landroidx/compose/material/SelectableChipColors;", "leadingIconColor", "disabledLeadingIconColor", "selectedBackgroundColor", "selectedContentColor", "selectedLeadingIconColor", "filterChipColors-J08w3-E", "(JJJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/SelectableChipColors;", "outlinedChipColors", "outlinedChipColors-5tl4gsc", "outlinedFilterChipColors", "outlinedFilterChipColors-J08w3-E", "material_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ChipDefaults {
    public static final int $stable = 0;
    public static final float ContentOpacity = 0.87f;
    public static final float LeadingIconOpacity = 0.54f;
    public static final float OutlinedBorderOpacity = 0.12f;
    public static final ChipDefaults INSTANCE = new ChipDefaults();
    private static final float MinHeight = Dp.m5218constructorimpl(32);
    private static final float OutlinedBorderSize = Dp.m5218constructorimpl(1);
    private static final float LeadingIconSize = Dp.m5218constructorimpl(20);
    private static final float SelectedIconSize = Dp.m5218constructorimpl(18);

    private ChipDefaults() {
    }

    /* renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m1022getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: chipColors-5tl4gsc, reason: not valid java name */
    public final ChipColors m1019chipColors5tl4gsc(long backgroundColor, long contentColor, long leadingIconContentColor, long disabledBackgroundColor, long disabledContentColor, long disabledLeadingIconContentColor, Composer $composer, int $changed, int i) {
        long backgroundColor2;
        long contentColor2;
        long leadingIconContentColor2;
        long disabledBackgroundColor2;
        long disabledContentColor2;
        long disabledLeadingIconContentColor2;
        long m2947copywmQWz5c;
        long m2947copywmQWz5c2;
        long m2947copywmQWz5c3;
        long m2947copywmQWz5c4;
        long m2947copywmQWz5c5;
        $composer.startReplaceableGroup(1838505436);
        ComposerKt.sourceInformation($composer, "C(chipColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color)385@16874L6,386@16968L6,387@17029L6,390@17231L6,391@17291L8,392@17366L6,394@17473L8,397@17621L8:Chip.kt#jmzs0o");
        if ((i & 1) != 0) {
            m2947copywmQWz5c5 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.12f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1035getOnSurface0d7_KjU()) : 0.0f);
            backgroundColor2 = ColorKt.m2994compositeOverOWjLjI(m2947copywmQWz5c5, MaterialTheme.INSTANCE.getColors($composer, 6).m1040getSurface0d7_KjU());
        } else {
            backgroundColor2 = backgroundColor;
        }
        if ((i & 2) != 0) {
            m2947copywmQWz5c4 = Color.m2947copywmQWz5c(r6, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r6) : 0.87f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r6) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r6) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1035getOnSurface0d7_KjU()) : 0.0f);
            contentColor2 = m2947copywmQWz5c4;
        } else {
            contentColor2 = contentColor;
        }
        if ((i & 4) != 0) {
            m2947copywmQWz5c3 = Color.m2947copywmQWz5c(r8, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r8) : 0.54f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r8) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r8) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(contentColor2) : 0.0f);
            leadingIconContentColor2 = m2947copywmQWz5c3;
        } else {
            leadingIconContentColor2 = leadingIconContentColor;
        }
        if ((i & 8) != 0) {
            m2947copywmQWz5c2 = Color.m2947copywmQWz5c(r6, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r6) : 0.12f * ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2955getRedimpl(r6) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r6) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1035getOnSurface0d7_KjU()) : 0.0f);
            disabledBackgroundColor2 = ColorKt.m2994compositeOverOWjLjI(m2947copywmQWz5c2, MaterialTheme.INSTANCE.getColors($composer, 6).m1040getSurface0d7_KjU());
        } else {
            disabledBackgroundColor2 = disabledBackgroundColor;
        }
        if ((i & 16) != 0) {
            m2947copywmQWz5c = Color.m2947copywmQWz5c(r29, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r29) : ContentAlpha.INSTANCE.getDisabled($composer, 6) * 0.87f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r29) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r29) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(contentColor2) : 0.0f);
            disabledContentColor2 = m2947copywmQWz5c;
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if ((i & 32) != 0) {
            disabledLeadingIconContentColor2 = Color.m2947copywmQWz5c(r29, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r29) : ContentAlpha.INSTANCE.getDisabled($composer, 6) * 0.54f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r29) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r29) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(leadingIconContentColor2) : 0.0f);
        } else {
            disabledLeadingIconContentColor2 = disabledLeadingIconContentColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1838505436, $changed, -1, "androidx.compose.material.ChipDefaults.chipColors (Chip.kt:384)");
        }
        DefaultChipColors defaultChipColors = new DefaultChipColors(backgroundColor2, contentColor2, leadingIconContentColor2, disabledBackgroundColor2, disabledContentColor2, disabledLeadingIconContentColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultChipColors;
    }

    /* renamed from: outlinedChipColors-5tl4gsc, reason: not valid java name */
    public final ChipColors m1025outlinedChipColors5tl4gsc(long backgroundColor, long contentColor, long leadingIconContentColor, long disabledBackgroundColor, long disabledContentColor, long disabledLeadingIconContentColor, Composer $composer, int $changed, int i) {
        long contentColor2;
        long leadingIconContentColor2;
        long disabledBackgroundColor2;
        long disabledContentColor2;
        long disabledLeadingIconContentColor2;
        long m2947copywmQWz5c;
        long m2947copywmQWz5c2;
        long m2947copywmQWz5c3;
        long m2947copywmQWz5c4;
        $composer.startReplaceableGroup(-1763922662);
        ComposerKt.sourceInformation($composer, "C(outlinedChipColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color)421@18817L6,422@18877L6,426@19160L8,429@19308L8,430@19360L342:Chip.kt#jmzs0o");
        long backgroundColor2 = (i & 1) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1040getSurface0d7_KjU() : backgroundColor;
        if ((i & 2) != 0) {
            m2947copywmQWz5c4 = Color.m2947copywmQWz5c(r3, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r3) : 0.87f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r3) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r3) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1035getOnSurface0d7_KjU()) : 0.0f);
            contentColor2 = m2947copywmQWz5c4;
        } else {
            contentColor2 = contentColor;
        }
        if ((i & 4) != 0) {
            m2947copywmQWz5c3 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.54f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(contentColor2) : 0.0f);
            leadingIconContentColor2 = m2947copywmQWz5c3;
        } else {
            leadingIconContentColor2 = leadingIconContentColor;
        }
        if ((i & 8) == 0) {
            disabledBackgroundColor2 = disabledBackgroundColor;
        } else {
            disabledBackgroundColor2 = backgroundColor2;
        }
        if ((i & 16) != 0) {
            m2947copywmQWz5c2 = Color.m2947copywmQWz5c(r31, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r31) : ContentAlpha.INSTANCE.getDisabled($composer, 6) * 0.87f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r31) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r31) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(contentColor2) : 0.0f);
            disabledContentColor2 = m2947copywmQWz5c2;
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if ((i & 32) != 0) {
            m2947copywmQWz5c = Color.m2947copywmQWz5c(r31, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r31) : ContentAlpha.INSTANCE.getDisabled($composer, 6) * 0.54f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r31) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r31) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(leadingIconContentColor2) : 0.0f);
            disabledLeadingIconContentColor2 = m2947copywmQWz5c;
        } else {
            disabledLeadingIconContentColor2 = disabledLeadingIconContentColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1763922662, $changed, -1, "androidx.compose.material.ChipDefaults.outlinedChipColors (Chip.kt:420)");
        }
        ChipColors m1019chipColors5tl4gsc = m1019chipColors5tl4gsc(backgroundColor2, contentColor2, leadingIconContentColor2, disabledBackgroundColor2, disabledContentColor2, disabledLeadingIconContentColor2, $composer, ($changed & 14) | ($changed & 112) | ($changed & 896) | ($changed & 7168) | (57344 & $changed) | (458752 & $changed) | (3670016 & $changed), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return m1019chipColors5tl4gsc;
    }

    /* renamed from: filterChipColors-J08w3-E, reason: not valid java name */
    public final SelectableChipColors m1020filterChipColorsJ08w3E(long backgroundColor, long contentColor, long leadingIconColor, long disabledBackgroundColor, long disabledContentColor, long disabledLeadingIconColor, long selectedBackgroundColor, long selectedContentColor, long selectedLeadingIconColor, Composer $composer, int $changed, int i) {
        long backgroundColor2;
        long contentColor2;
        long leadingIconColor2;
        long disabledBackgroundColor2;
        long disabledContentColor2;
        long disabledLeadingIconColor2;
        long selectedBackgroundColor2;
        long selectedContentColor2;
        long selectedLeadingIconColor2;
        long m2947copywmQWz5c;
        long m2947copywmQWz5c2;
        long m2947copywmQWz5c3;
        long m2947copywmQWz5c4;
        long m2947copywmQWz5c5;
        long m2947copywmQWz5c6;
        long m2947copywmQWz5c7;
        long m2947copywmQWz5c8;
        $composer.startReplaceableGroup(830140629);
        ComposerKt.sourceInformation($composer, "C(filterChipColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,8:c#ui.graphics.Color)455@20699L6,456@20793L6,457@20854L6,460@21041L6,461@21101L8,462@21176L6,464@21283L8,467@21418L8,469@21514L6,472@21673L6,475@21834L6:Chip.kt#jmzs0o");
        if ((i & 1) != 0) {
            m2947copywmQWz5c8 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.12f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1035getOnSurface0d7_KjU()) : 0.0f);
            backgroundColor2 = ColorKt.m2994compositeOverOWjLjI(m2947copywmQWz5c8, MaterialTheme.INSTANCE.getColors($composer, 6).m1040getSurface0d7_KjU());
        } else {
            backgroundColor2 = backgroundColor;
        }
        if ((i & 2) != 0) {
            contentColor2 = Color.m2947copywmQWz5c(r7, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r7) : 0.87f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r7) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r7) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1035getOnSurface0d7_KjU()) : 0.0f);
        } else {
            contentColor2 = contentColor;
        }
        if ((i & 4) != 0) {
            m2947copywmQWz5c7 = Color.m2947copywmQWz5c(r9, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r9) : 0.54f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r9) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r9) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(contentColor2) : 0.0f);
            leadingIconColor2 = m2947copywmQWz5c7;
        } else {
            leadingIconColor2 = leadingIconColor;
        }
        if ((i & 8) != 0) {
            m2947copywmQWz5c6 = Color.m2947copywmQWz5c(r16, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r16) : ContentAlpha.INSTANCE.getDisabled($composer, 6) * 0.12f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r16) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r16) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1035getOnSurface0d7_KjU()) : 0.0f);
            disabledBackgroundColor2 = ColorKt.m2994compositeOverOWjLjI(m2947copywmQWz5c6, MaterialTheme.INSTANCE.getColors($composer, 6).m1040getSurface0d7_KjU());
        } else {
            disabledBackgroundColor2 = disabledBackgroundColor;
        }
        if ((i & 16) != 0) {
            m2947copywmQWz5c5 = Color.m2947copywmQWz5c(r42, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r42) : ContentAlpha.INSTANCE.getDisabled($composer, 6) * 0.87f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r42) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r42) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(contentColor2) : 0.0f);
            disabledContentColor2 = m2947copywmQWz5c5;
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if ((i & 32) != 0) {
            m2947copywmQWz5c4 = Color.m2947copywmQWz5c(r42, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r42) : ContentAlpha.INSTANCE.getDisabled($composer, 6) * 0.54f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r42) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r42) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(leadingIconColor2) : 0.0f);
            disabledLeadingIconColor2 = m2947copywmQWz5c4;
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        if ((i & 64) != 0) {
            m2947copywmQWz5c3 = Color.m2947copywmQWz5c(r9, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r9) : 0.12f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r9) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r9) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1035getOnSurface0d7_KjU()) : 0.0f);
            selectedBackgroundColor2 = ColorKt.m2994compositeOverOWjLjI(m2947copywmQWz5c3, backgroundColor2);
        } else {
            selectedBackgroundColor2 = selectedBackgroundColor;
        }
        if ((i & 128) != 0) {
            m2947copywmQWz5c2 = Color.m2947copywmQWz5c(r9, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r9) : 0.16f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r9) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r9) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1035getOnSurface0d7_KjU()) : 0.0f);
            selectedContentColor2 = ColorKt.m2994compositeOverOWjLjI(m2947copywmQWz5c2, contentColor2);
        } else {
            selectedContentColor2 = selectedContentColor;
        }
        if ((i & 256) != 0) {
            m2947copywmQWz5c = Color.m2947copywmQWz5c(r3, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r3) : 0.16f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r3) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r3) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1035getOnSurface0d7_KjU()) : 0.0f);
            selectedLeadingIconColor2 = ColorKt.m2994compositeOverOWjLjI(m2947copywmQWz5c, leadingIconColor2);
        } else {
            selectedLeadingIconColor2 = selectedLeadingIconColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(830140629, $changed, -1, "androidx.compose.material.ChipDefaults.filterChipColors (Chip.kt:454)");
        }
        long j = leadingIconColor2;
        long leadingIconColor3 = disabledBackgroundColor2;
        DefaultSelectableChipColors defaultSelectableChipColors = new DefaultSelectableChipColors(backgroundColor2, contentColor2, j, leadingIconColor3, disabledContentColor2, disabledLeadingIconColor2, selectedBackgroundColor2, selectedContentColor2, selectedLeadingIconColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultSelectableChipColors;
    }

    /* renamed from: outlinedFilterChipColors-J08w3-E, reason: not valid java name */
    public final SelectableChipColors m1026outlinedFilterChipColorsJ08w3E(long backgroundColor, long contentColor, long leadingIconColor, long disabledBackgroundColor, long disabledContentColor, long disabledLeadingIconColor, long selectedBackgroundColor, long selectedContentColor, long selectedLeadingIconColor, Composer $composer, int $changed, int i) {
        long contentColor2;
        long leadingIconColor2;
        long disabledBackgroundColor2;
        long disabledContentColor2;
        long disabledLeadingIconColor2;
        long selectedBackgroundColor2;
        long selectedContentColor2;
        long selectedLeadingIconColor2;
        long m2947copywmQWz5c;
        long m2947copywmQWz5c2;
        long m2947copywmQWz5c3;
        long m2947copywmQWz5c4;
        long m2947copywmQWz5c5;
        long m2947copywmQWz5c6;
        $composer.startReplaceableGroup(346878099);
        ComposerKt.sourceInformation($composer, "C(outlinedFilterChipColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,8:c#ui.graphics.Color)506@23484L6,507@23544L6,511@23804L8,514@23939L8,516@24035L6,519@24195L6,522@24356L6:Chip.kt#jmzs0o");
        long backgroundColor2 = (i & 1) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1040getSurface0d7_KjU() : backgroundColor;
        if ((i & 2) != 0) {
            contentColor2 = Color.m2947copywmQWz5c(r7, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r7) : 0.87f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r7) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r7) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1035getOnSurface0d7_KjU()) : 0.0f);
        } else {
            contentColor2 = contentColor;
        }
        if ((i & 4) != 0) {
            m2947copywmQWz5c6 = Color.m2947copywmQWz5c(r9, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r9) : 0.54f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r9) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r9) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(contentColor2) : 0.0f);
            leadingIconColor2 = m2947copywmQWz5c6;
        } else {
            leadingIconColor2 = leadingIconColor;
        }
        if ((i & 8) == 0) {
            disabledBackgroundColor2 = disabledBackgroundColor;
        } else {
            disabledBackgroundColor2 = backgroundColor2;
        }
        if ((i & 16) != 0) {
            m2947copywmQWz5c5 = Color.m2947copywmQWz5c(r42, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r42) : ContentAlpha.INSTANCE.getDisabled($composer, 6) * 0.87f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r42) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r42) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(contentColor2) : 0.0f);
            disabledContentColor2 = m2947copywmQWz5c5;
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if ((i & 32) != 0) {
            m2947copywmQWz5c4 = Color.m2947copywmQWz5c(r42, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r42) : ContentAlpha.INSTANCE.getDisabled($composer, 6) * 0.54f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r42) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r42) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(leadingIconColor2) : 0.0f);
            disabledLeadingIconColor2 = m2947copywmQWz5c4;
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        if ((i & 64) != 0) {
            m2947copywmQWz5c3 = Color.m2947copywmQWz5c(r9, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r9) : 0.16f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r9) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r9) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1035getOnSurface0d7_KjU()) : 0.0f);
            selectedBackgroundColor2 = ColorKt.m2994compositeOverOWjLjI(m2947copywmQWz5c3, backgroundColor2);
        } else {
            selectedBackgroundColor2 = selectedBackgroundColor;
        }
        if ((i & 128) != 0) {
            m2947copywmQWz5c2 = Color.m2947copywmQWz5c(r9, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r9) : 0.16f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r9) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r9) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1035getOnSurface0d7_KjU()) : 0.0f);
            selectedContentColor2 = ColorKt.m2994compositeOverOWjLjI(m2947copywmQWz5c2, contentColor2);
        } else {
            selectedContentColor2 = selectedContentColor;
        }
        if ((i & 256) != 0) {
            m2947copywmQWz5c = Color.m2947copywmQWz5c(r3, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r3) : 0.16f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r3) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r3) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1035getOnSurface0d7_KjU()) : 0.0f);
            selectedLeadingIconColor2 = ColorKt.m2994compositeOverOWjLjI(m2947copywmQWz5c, leadingIconColor2);
        } else {
            selectedLeadingIconColor2 = selectedLeadingIconColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(346878099, $changed, -1, "androidx.compose.material.ChipDefaults.outlinedFilterChipColors (Chip.kt:505)");
        }
        long j = leadingIconColor2;
        long leadingIconColor3 = disabledBackgroundColor2;
        DefaultSelectableChipColors defaultSelectableChipColors = new DefaultSelectableChipColors(backgroundColor2, contentColor2, j, leadingIconColor3, disabledContentColor2, disabledLeadingIconColor2, selectedBackgroundColor2, selectedContentColor2, selectedLeadingIconColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultSelectableChipColors;
    }

    public final BorderStroke getOutlinedBorder(Composer $composer, int $changed) {
        long m2947copywmQWz5c;
        $composer.startReplaceableGroup(-1650225597);
        ComposerKt.sourceInformation($composer, "C543@25203L6:Chip.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1650225597, $changed, -1, "androidx.compose.material.ChipDefaults.<get-outlinedBorder> (Chip.kt:542)");
        }
        float f = OutlinedBorderSize;
        m2947copywmQWz5c = Color.m2947copywmQWz5c(r2, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r2) : 0.12f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r2) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r2) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1035getOnSurface0d7_KjU()) : 0.0f);
        BorderStroke m190BorderStrokecXLIe8U = BorderStrokeKt.m190BorderStrokecXLIe8U(f, m2947copywmQWz5c);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return m190BorderStrokecXLIe8U;
    }

    /* renamed from: getOutlinedBorderSize-D9Ej5fM, reason: not valid java name */
    public final float m1023getOutlinedBorderSizeD9Ej5fM() {
        return OutlinedBorderSize;
    }

    /* renamed from: getLeadingIconSize-D9Ej5fM, reason: not valid java name */
    public final float m1021getLeadingIconSizeD9Ej5fM() {
        return LeadingIconSize;
    }

    /* renamed from: getSelectedIconSize-D9Ej5fM, reason: not valid java name */
    public final float m1024getSelectedIconSizeD9Ej5fM() {
        return SelectedIconSize;
    }
}
