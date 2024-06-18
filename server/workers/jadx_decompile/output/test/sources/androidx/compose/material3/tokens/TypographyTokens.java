package androidx.compose.material3.tokens;

import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: TypographyTokens.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0011\u0010\u0017\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0011\u0010\u0019\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0011\u0010\u001b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0011\u0010\u001d\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0011\u0010\u001f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0011\u0010!\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006¨\u0006#"}, d2 = {"Landroidx/compose/material3/tokens/TypographyTokens;", "", "()V", "BodyLarge", "Landroidx/compose/ui/text/TextStyle;", "getBodyLarge", "()Landroidx/compose/ui/text/TextStyle;", "BodyMedium", "getBodyMedium", "BodySmall", "getBodySmall", "DisplayLarge", "getDisplayLarge", "DisplayMedium", "getDisplayMedium", "DisplaySmall", "getDisplaySmall", "HeadlineLarge", "getHeadlineLarge", "HeadlineMedium", "getHeadlineMedium", "HeadlineSmall", "getHeadlineSmall", "LabelLarge", "getLabelLarge", "LabelMedium", "getLabelMedium", "LabelSmall", "getLabelSmall", "TitleLarge", "getTitleLarge", "TitleMedium", "getTitleMedium", "TitleSmall", "getTitleSmall", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TypographyTokens {
    private static final TextStyle BodyLarge;
    private static final TextStyle BodyMedium;
    private static final TextStyle BodySmall;
    private static final TextStyle DisplayLarge;
    private static final TextStyle DisplayMedium;
    private static final TextStyle DisplaySmall;
    private static final TextStyle HeadlineLarge;
    private static final TextStyle HeadlineMedium;
    private static final TextStyle HeadlineSmall;
    public static final TypographyTokens INSTANCE = new TypographyTokens();
    private static final TextStyle LabelLarge;
    private static final TextStyle LabelMedium;
    private static final TextStyle LabelSmall;
    private static final TextStyle TitleLarge;
    private static final TextStyle TitleMedium;
    private static final TextStyle TitleSmall;

    private TypographyTokens() {
    }

    public final TextStyle getBodyLarge() {
        return BodyLarge;
    }

    static {
        TextStyle defaultTextStyle = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily bodyLargeFont = TypeScaleTokens.INSTANCE.getBodyLargeFont();
        BodyLarge = TextStyle.m4734copyCXVQc50$default(defaultTextStyle, 0L, TypeScaleTokens.INSTANCE.m2513getBodyLargeSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getBodyLargeWeight(), null, null, bodyLargeFont, null, TypeScaleTokens.INSTANCE.m2514getBodyLargeTrackingXSAIIZE(), null, null, null, 0L, null, null, null, null, TypeScaleTokens.INSTANCE.m2512getBodyLargeLineHeightXSAIIZE(), null, null, null, null, null, 4128601, null);
        TextStyle defaultTextStyle2 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily bodyMediumFont = TypeScaleTokens.INSTANCE.getBodyMediumFont();
        BodyMedium = TextStyle.m4734copyCXVQc50$default(defaultTextStyle2, 0L, TypeScaleTokens.INSTANCE.m2516getBodyMediumSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getBodyMediumWeight(), null, null, bodyMediumFont, null, TypeScaleTokens.INSTANCE.m2517getBodyMediumTrackingXSAIIZE(), null, null, null, 0L, null, null, null, null, TypeScaleTokens.INSTANCE.m2515getBodyMediumLineHeightXSAIIZE(), null, null, null, null, null, 4128601, null);
        TextStyle defaultTextStyle3 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily bodySmallFont = TypeScaleTokens.INSTANCE.getBodySmallFont();
        BodySmall = TextStyle.m4734copyCXVQc50$default(defaultTextStyle3, 0L, TypeScaleTokens.INSTANCE.m2519getBodySmallSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getBodySmallWeight(), null, null, bodySmallFont, null, TypeScaleTokens.INSTANCE.m2520getBodySmallTrackingXSAIIZE(), null, null, null, 0L, null, null, null, null, TypeScaleTokens.INSTANCE.m2518getBodySmallLineHeightXSAIIZE(), null, null, null, null, null, 4128601, null);
        TextStyle defaultTextStyle4 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily displayLargeFont = TypeScaleTokens.INSTANCE.getDisplayLargeFont();
        DisplayLarge = TextStyle.m4734copyCXVQc50$default(defaultTextStyle4, 0L, TypeScaleTokens.INSTANCE.m2522getDisplayLargeSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getDisplayLargeWeight(), null, null, displayLargeFont, null, TypeScaleTokens.INSTANCE.m2523getDisplayLargeTrackingXSAIIZE(), null, null, null, 0L, null, null, null, null, TypeScaleTokens.INSTANCE.m2521getDisplayLargeLineHeightXSAIIZE(), null, null, null, null, null, 4128601, null);
        TextStyle defaultTextStyle5 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily displayMediumFont = TypeScaleTokens.INSTANCE.getDisplayMediumFont();
        DisplayMedium = TextStyle.m4734copyCXVQc50$default(defaultTextStyle5, 0L, TypeScaleTokens.INSTANCE.m2525getDisplayMediumSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getDisplayMediumWeight(), null, null, displayMediumFont, null, TypeScaleTokens.INSTANCE.m2526getDisplayMediumTrackingXSAIIZE(), null, null, null, 0L, null, null, null, null, TypeScaleTokens.INSTANCE.m2524getDisplayMediumLineHeightXSAIIZE(), null, null, null, null, null, 4128601, null);
        TextStyle defaultTextStyle6 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily displaySmallFont = TypeScaleTokens.INSTANCE.getDisplaySmallFont();
        DisplaySmall = TextStyle.m4734copyCXVQc50$default(defaultTextStyle6, 0L, TypeScaleTokens.INSTANCE.m2528getDisplaySmallSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getDisplaySmallWeight(), null, null, displaySmallFont, null, TypeScaleTokens.INSTANCE.m2529getDisplaySmallTrackingXSAIIZE(), null, null, null, 0L, null, null, null, null, TypeScaleTokens.INSTANCE.m2527getDisplaySmallLineHeightXSAIIZE(), null, null, null, null, null, 4128601, null);
        TextStyle defaultTextStyle7 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily headlineLargeFont = TypeScaleTokens.INSTANCE.getHeadlineLargeFont();
        HeadlineLarge = TextStyle.m4734copyCXVQc50$default(defaultTextStyle7, 0L, TypeScaleTokens.INSTANCE.m2531getHeadlineLargeSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getHeadlineLargeWeight(), null, null, headlineLargeFont, null, TypeScaleTokens.INSTANCE.m2532getHeadlineLargeTrackingXSAIIZE(), null, null, null, 0L, null, null, null, null, TypeScaleTokens.INSTANCE.m2530getHeadlineLargeLineHeightXSAIIZE(), null, null, null, null, null, 4128601, null);
        TextStyle defaultTextStyle8 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily headlineMediumFont = TypeScaleTokens.INSTANCE.getHeadlineMediumFont();
        HeadlineMedium = TextStyle.m4734copyCXVQc50$default(defaultTextStyle8, 0L, TypeScaleTokens.INSTANCE.m2534getHeadlineMediumSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getHeadlineMediumWeight(), null, null, headlineMediumFont, null, TypeScaleTokens.INSTANCE.m2535getHeadlineMediumTrackingXSAIIZE(), null, null, null, 0L, null, null, null, null, TypeScaleTokens.INSTANCE.m2533getHeadlineMediumLineHeightXSAIIZE(), null, null, null, null, null, 4128601, null);
        TextStyle defaultTextStyle9 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily headlineSmallFont = TypeScaleTokens.INSTANCE.getHeadlineSmallFont();
        HeadlineSmall = TextStyle.m4734copyCXVQc50$default(defaultTextStyle9, 0L, TypeScaleTokens.INSTANCE.m2537getHeadlineSmallSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getHeadlineSmallWeight(), null, null, headlineSmallFont, null, TypeScaleTokens.INSTANCE.m2538getHeadlineSmallTrackingXSAIIZE(), null, null, null, 0L, null, null, null, null, TypeScaleTokens.INSTANCE.m2536getHeadlineSmallLineHeightXSAIIZE(), null, null, null, null, null, 4128601, null);
        TextStyle defaultTextStyle10 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily labelLargeFont = TypeScaleTokens.INSTANCE.getLabelLargeFont();
        LabelLarge = TextStyle.m4734copyCXVQc50$default(defaultTextStyle10, 0L, TypeScaleTokens.INSTANCE.m2540getLabelLargeSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getLabelLargeWeight(), null, null, labelLargeFont, null, TypeScaleTokens.INSTANCE.m2541getLabelLargeTrackingXSAIIZE(), null, null, null, 0L, null, null, null, null, TypeScaleTokens.INSTANCE.m2539getLabelLargeLineHeightXSAIIZE(), null, null, null, null, null, 4128601, null);
        TextStyle defaultTextStyle11 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily labelMediumFont = TypeScaleTokens.INSTANCE.getLabelMediumFont();
        LabelMedium = TextStyle.m4734copyCXVQc50$default(defaultTextStyle11, 0L, TypeScaleTokens.INSTANCE.m2543getLabelMediumSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getLabelMediumWeight(), null, null, labelMediumFont, null, TypeScaleTokens.INSTANCE.m2544getLabelMediumTrackingXSAIIZE(), null, null, null, 0L, null, null, null, null, TypeScaleTokens.INSTANCE.m2542getLabelMediumLineHeightXSAIIZE(), null, null, null, null, null, 4128601, null);
        TextStyle defaultTextStyle12 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily labelSmallFont = TypeScaleTokens.INSTANCE.getLabelSmallFont();
        LabelSmall = TextStyle.m4734copyCXVQc50$default(defaultTextStyle12, 0L, TypeScaleTokens.INSTANCE.m2546getLabelSmallSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getLabelSmallWeight(), null, null, labelSmallFont, null, TypeScaleTokens.INSTANCE.m2547getLabelSmallTrackingXSAIIZE(), null, null, null, 0L, null, null, null, null, TypeScaleTokens.INSTANCE.m2545getLabelSmallLineHeightXSAIIZE(), null, null, null, null, null, 4128601, null);
        TextStyle defaultTextStyle13 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily titleLargeFont = TypeScaleTokens.INSTANCE.getTitleLargeFont();
        TitleLarge = TextStyle.m4734copyCXVQc50$default(defaultTextStyle13, 0L, TypeScaleTokens.INSTANCE.m2549getTitleLargeSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getTitleLargeWeight(), null, null, titleLargeFont, null, TypeScaleTokens.INSTANCE.m2550getTitleLargeTrackingXSAIIZE(), null, null, null, 0L, null, null, null, null, TypeScaleTokens.INSTANCE.m2548getTitleLargeLineHeightXSAIIZE(), null, null, null, null, null, 4128601, null);
        TextStyle defaultTextStyle14 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily titleMediumFont = TypeScaleTokens.INSTANCE.getTitleMediumFont();
        TitleMedium = TextStyle.m4734copyCXVQc50$default(defaultTextStyle14, 0L, TypeScaleTokens.INSTANCE.m2552getTitleMediumSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getTitleMediumWeight(), null, null, titleMediumFont, null, TypeScaleTokens.INSTANCE.m2553getTitleMediumTrackingXSAIIZE(), null, null, null, 0L, null, null, null, null, TypeScaleTokens.INSTANCE.m2551getTitleMediumLineHeightXSAIIZE(), null, null, null, null, null, 4128601, null);
        TextStyle defaultTextStyle15 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily titleSmallFont = TypeScaleTokens.INSTANCE.getTitleSmallFont();
        TitleSmall = TextStyle.m4734copyCXVQc50$default(defaultTextStyle15, 0L, TypeScaleTokens.INSTANCE.m2555getTitleSmallSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getTitleSmallWeight(), null, null, titleSmallFont, null, TypeScaleTokens.INSTANCE.m2556getTitleSmallTrackingXSAIIZE(), null, null, null, 0L, null, null, null, null, TypeScaleTokens.INSTANCE.m2554getTitleSmallLineHeightXSAIIZE(), null, null, null, null, null, 4128601, null);
    }

    public final TextStyle getBodyMedium() {
        return BodyMedium;
    }

    public final TextStyle getBodySmall() {
        return BodySmall;
    }

    public final TextStyle getDisplayLarge() {
        return DisplayLarge;
    }

    public final TextStyle getDisplayMedium() {
        return DisplayMedium;
    }

    public final TextStyle getDisplaySmall() {
        return DisplaySmall;
    }

    public final TextStyle getHeadlineLarge() {
        return HeadlineLarge;
    }

    public final TextStyle getHeadlineMedium() {
        return HeadlineMedium;
    }

    public final TextStyle getHeadlineSmall() {
        return HeadlineSmall;
    }

    public final TextStyle getLabelLarge() {
        return LabelLarge;
    }

    public final TextStyle getLabelMedium() {
        return LabelMedium;
    }

    public final TextStyle getLabelSmall() {
        return LabelSmall;
    }

    public final TextStyle getTitleLarge() {
        return TitleLarge;
    }

    public final TextStyle getTitleMedium() {
        return TitleMedium;
    }

    public final TextStyle getTitleSmall() {
        return TitleSmall;
    }
}
