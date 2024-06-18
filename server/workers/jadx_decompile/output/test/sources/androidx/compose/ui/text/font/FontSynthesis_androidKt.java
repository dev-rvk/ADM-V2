package androidx.compose.ui.text.font;

import android.os.Build;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FontSynthesis.android.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\f"}, d2 = {"synthesizeTypeface", "", "Landroidx/compose/ui/text/font/FontSynthesis;", "typeface", "font", "Landroidx/compose/ui/text/font/Font;", "requestedWeight", "Landroidx/compose/ui/text/font/FontWeight;", "requestedStyle", "Landroidx/compose/ui/text/font/FontStyle;", "synthesizeTypeface-FxwP2eA", "(ILjava/lang/Object;Landroidx/compose/ui/text/font/Font;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/lang/Object;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class FontSynthesis_androidKt {
    /* renamed from: synthesizeTypeface-FxwP2eA, reason: not valid java name */
    public static final Object m4840synthesizeTypefaceFxwP2eA(int $this$synthesizeTypeface_u2dFxwP2eA, Object typeface, Font font, FontWeight requestedWeight, int requestedStyle) {
        int finalFontWeight;
        boolean finalFontStyle;
        android.graphics.Typeface create;
        Intrinsics.checkNotNullParameter(typeface, "typeface");
        Intrinsics.checkNotNullParameter(font, "font");
        Intrinsics.checkNotNullParameter(requestedWeight, "requestedWeight");
        if (!(typeface instanceof android.graphics.Typeface)) {
            return typeface;
        }
        boolean synthesizeWeight = FontSynthesis.m4833isWeightOnimpl$ui_text_release($this$synthesizeTypeface_u2dFxwP2eA) && !Intrinsics.areEqual(font.getWeight(), requestedWeight) && requestedWeight.compareTo(AndroidFontUtils_androidKt.getAndroidBold(FontWeight.INSTANCE)) >= 0 && font.getWeight().compareTo(AndroidFontUtils_androidKt.getAndroidBold(FontWeight.INSTANCE)) < 0;
        boolean synthesizeStyle = FontSynthesis.m4832isStyleOnimpl$ui_text_release($this$synthesizeTypeface_u2dFxwP2eA) && !FontStyle.m4821equalsimpl0(requestedStyle, font.getStyle());
        if (!synthesizeStyle && !synthesizeWeight) {
            return typeface;
        }
        if (Build.VERSION.SDK_INT < 28) {
            int targetStyle = AndroidFontUtils_androidKt.getAndroidTypefaceStyle(synthesizeWeight, synthesizeStyle && FontStyle.m4821equalsimpl0(requestedStyle, FontStyle.INSTANCE.m4825getItalic_LCdwA()));
            create = android.graphics.Typeface.create((android.graphics.Typeface) typeface, targetStyle);
        } else {
            if (synthesizeWeight) {
                finalFontWeight = requestedWeight.getWeight();
            } else {
                finalFontWeight = font.getWeight().getWeight();
            }
            if (synthesizeStyle) {
                finalFontStyle = FontStyle.m4821equalsimpl0(requestedStyle, FontStyle.INSTANCE.m4825getItalic_LCdwA());
            } else {
                finalFontStyle = FontStyle.m4821equalsimpl0(font.getStyle(), FontStyle.INSTANCE.m4825getItalic_LCdwA());
            }
            create = TypefaceHelperMethodsApi28.INSTANCE.create((android.graphics.Typeface) typeface, finalFontWeight, finalFontStyle);
        }
        Intrinsics.checkNotNullExpressionValue(create, "if (Build.VERSION.SDK_IN…ht, finalFontStyle)\n    }");
        return create;
    }
}
