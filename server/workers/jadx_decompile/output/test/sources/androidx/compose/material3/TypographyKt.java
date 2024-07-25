package androidx.compose.material3;

import androidx.compose.material3.tokens.TypographyKeyTokens;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.text.TextStyle;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Typography.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0000\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\t"}, d2 = {"LocalTypography", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/Typography;", "getLocalTypography", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "fromToken", "Landroidx/compose/ui/text/TextStyle;", "value", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TypographyKt {
    private static final ProvidableCompositionLocal<Typography> LocalTypography = CompositionLocalKt.staticCompositionLocalOf(new Function0<Typography>() { // from class: androidx.compose.material3.TypographyKt$LocalTypography$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Typography invoke() {
            return new Typography(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
        }
    });

    /* compiled from: Typography.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TypographyKeyTokens.values().length];
            try {
                iArr[TypographyKeyTokens.DisplayLarge.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[TypographyKeyTokens.DisplayMedium.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[TypographyKeyTokens.DisplaySmall.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[TypographyKeyTokens.HeadlineLarge.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[TypographyKeyTokens.HeadlineMedium.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[TypographyKeyTokens.HeadlineSmall.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[TypographyKeyTokens.TitleLarge.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[TypographyKeyTokens.TitleMedium.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[TypographyKeyTokens.TitleSmall.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[TypographyKeyTokens.BodyLarge.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[TypographyKeyTokens.BodyMedium.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[TypographyKeyTokens.BodySmall.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr[TypographyKeyTokens.LabelLarge.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                iArr[TypographyKeyTokens.LabelMedium.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                iArr[TypographyKeyTokens.LabelSmall.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final TextStyle fromToken(Typography $this$fromToken, TypographyKeyTokens value) {
        Intrinsics.checkNotNullParameter($this$fromToken, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        switch (WhenMappings.$EnumSwitchMapping$0[value.ordinal()]) {
            case 1:
                return $this$fromToken.getDisplayLarge();
            case 2:
                return $this$fromToken.getDisplayMedium();
            case 3:
                return $this$fromToken.getDisplaySmall();
            case 4:
                return $this$fromToken.getHeadlineLarge();
            case 5:
                return $this$fromToken.getHeadlineMedium();
            case 6:
                return $this$fromToken.getHeadlineSmall();
            case 7:
                return $this$fromToken.getTitleLarge();
            case 8:
                return $this$fromToken.getTitleMedium();
            case 9:
                return $this$fromToken.getTitleSmall();
            case 10:
                return $this$fromToken.getBodyLarge();
            case 11:
                return $this$fromToken.getBodyMedium();
            case 12:
                return $this$fromToken.getBodySmall();
            case 13:
                return $this$fromToken.getLabelLarge();
            case 14:
                return $this$fromToken.getLabelMedium();
            case 15:
                return $this$fromToken.getLabelSmall();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final ProvidableCompositionLocal<Typography> getLocalTypography() {
        return LocalTypography;
    }
}
