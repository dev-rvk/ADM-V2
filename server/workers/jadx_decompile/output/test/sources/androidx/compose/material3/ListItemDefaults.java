package androidx.compose.material3;

import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: ListItem.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jo\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010\u001a\u001a\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\tH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Landroidx/compose/material3/ListItemDefaults;", "", "()V", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM", "()F", "F", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "contentColor", "getContentColor", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/ListItemColors;", "headlineColor", "leadingIconColor", "overlineColor", "supportingColor", "trailingIconColor", "disabledHeadlineColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "colors-J08w3-E", "(JJJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ListItemColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ListItemDefaults {
    public static final int $stable = 0;
    public static final ListItemDefaults INSTANCE = new ListItemDefaults();
    private static final float Elevation = ListTokens.INSTANCE.m2266getListItemContainerElevationD9Ej5fM();

    private ListItemDefaults() {
    }

    /* renamed from: getElevation-D9Ej5fM, reason: not valid java name */
    public final float m1575getElevationD9Ej5fM() {
        return Elevation;
    }

    public final Shape getShape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -496871597, "C271@10392L9:ListItem.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-496871597, $changed, -1, "androidx.compose.material3.ListItemDefaults.<get-shape> (ListItem.kt:271)");
        }
        Shape shape = ShapesKt.toShape(ListTokens.INSTANCE.getListItemContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return shape;
    }

    public final long getContainerColor(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -1253579929, "C276@10569L9:ListItem.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1253579929, $changed, -1, "androidx.compose.material3.ListItemDefaults.<get-containerColor> (ListItem.kt:276)");
        }
        long color = ColorSchemeKt.toColor(ListTokens.INSTANCE.getListItemContainerColor(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return color;
    }

    public final long getContentColor(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1076068327, "C281@10742L9:ListItem.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1076068327, $changed, -1, "androidx.compose.material3.ListItemDefaults.<get-contentColor> (ListItem.kt:281)");
        }
        long color = ColorSchemeKt.toColor(ListTokens.INSTANCE.getListItemLabelTextColor(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return color;
    }

    /* renamed from: colors-J08w3-E, reason: not valid java name */
    public final ListItemColors m1574colorsJ08w3E(long containerColor, long headlineColor, long leadingIconColor, long overlineColor, long supportingColor, long trailingIconColor, long disabledHeadlineColor, long disabledLeadingIconColor, long disabledTrailingIconColor, Composer $composer, int $changed, int i) {
        long headlineColor2;
        long leadingIconColor2;
        long overlineColor2;
        long supportingColor2;
        long trailingIconColor2;
        long disabledHeadlineColor2;
        long disabledLeadingIconColor2;
        long disabledTrailingIconColor2;
        long m2947copywmQWz5c;
        long m2947copywmQWz5c2;
        $composer.startReplaceableGroup(-352515689);
        ComposerKt.sourceInformation($composer, "C(colors)P(0:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,8:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)302@11814L9,303@11890L9,304@11971L9,305@12046L9,306@12129L9,307@12212L9,308@12304L9,310@12472L9,312@12644L9:ListItem.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(ListTokens.INSTANCE.getListItemContainerColor(), $composer, 6) : containerColor;
        if ((i & 2) == 0) {
            headlineColor2 = headlineColor;
        } else {
            headlineColor2 = ColorSchemeKt.toColor(ListTokens.INSTANCE.getListItemLabelTextColor(), $composer, 6);
        }
        if ((i & 4) == 0) {
            leadingIconColor2 = leadingIconColor;
        } else {
            leadingIconColor2 = ColorSchemeKt.toColor(ListTokens.INSTANCE.getListItemLeadingIconColor(), $composer, 6);
        }
        if ((i & 8) == 0) {
            overlineColor2 = overlineColor;
        } else {
            overlineColor2 = ColorSchemeKt.toColor(ListTokens.INSTANCE.getListItemOverlineColor(), $composer, 6);
        }
        if ((i & 16) == 0) {
            supportingColor2 = supportingColor;
        } else {
            supportingColor2 = ColorSchemeKt.toColor(ListTokens.INSTANCE.getListItemSupportingTextColor(), $composer, 6);
        }
        if ((i & 32) == 0) {
            trailingIconColor2 = trailingIconColor;
        } else {
            trailingIconColor2 = ColorSchemeKt.toColor(ListTokens.INSTANCE.getListItemTrailingIconColor(), $composer, 6);
        }
        if ((i & 64) != 0) {
            m2947copywmQWz5c2 = Color.m2947copywmQWz5c(r7, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r7) : ListTokens.INSTANCE.getListItemDisabledLabelTextOpacity(), (r12 & 2) != 0 ? Color.m2955getRedimpl(r7) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r7) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(ListTokens.INSTANCE.getListItemDisabledLabelTextColor(), $composer, 6)) : 0.0f);
            disabledHeadlineColor2 = m2947copywmQWz5c2;
        } else {
            disabledHeadlineColor2 = disabledHeadlineColor;
        }
        if ((i & 128) != 0) {
            m2947copywmQWz5c = Color.m2947copywmQWz5c(r7, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r7) : ListTokens.INSTANCE.getListItemDisabledLeadingIconOpacity(), (r12 & 2) != 0 ? Color.m2955getRedimpl(r7) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r7) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(ListTokens.INSTANCE.getListItemDisabledLeadingIconColor(), $composer, 6)) : 0.0f);
            disabledLeadingIconColor2 = m2947copywmQWz5c;
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        if ((i & 256) != 0) {
            disabledTrailingIconColor2 = Color.m2947copywmQWz5c(r3, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r3) : ListTokens.INSTANCE.getListItemDisabledTrailingIconOpacity(), (r12 & 2) != 0 ? Color.m2955getRedimpl(r3) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r3) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(ListTokens.INSTANCE.getListItemDisabledTrailingIconColor(), $composer, 6)) : 0.0f);
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-352515689, $changed, -1, "androidx.compose.material3.ListItemDefaults.colors (ListItem.kt:301)");
        }
        ListItemColors listItemColors = new ListItemColors(containerColor2, headlineColor2, leadingIconColor2, overlineColor2, supportingColor2, trailingIconColor2, disabledHeadlineColor2, disabledLeadingIconColor2, disabledTrailingIconColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return listItemColors;
    }
}
