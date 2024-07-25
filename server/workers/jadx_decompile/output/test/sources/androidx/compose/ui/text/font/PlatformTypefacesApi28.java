package androidx.compose.ui.text.font;

import android.content.Context;
import androidx.autofill.HintConstants;
import androidx.compose.ui.text.font.FontVariation;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PlatformTypefaces.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\fJ?\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 \u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006!"}, d2 = {"Landroidx/compose/ui/text/font/PlatformTypefacesApi28;", "Landroidx/compose/ui/text/font/PlatformTypefaces;", "()V", "createAndroidTypefaceApi28", "Landroid/graphics/Typeface;", "genericFontFamily", "", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "createAndroidTypefaceApi28-RetOiIg", "(Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;I)Landroid/graphics/Typeface;", "createDefault", "createDefault-FO1MlWM", "(Landroidx/compose/ui/text/font/FontWeight;I)Landroid/graphics/Typeface;", "createNamed", HintConstants.AUTOFILL_HINT_NAME, "Landroidx/compose/ui/text/font/GenericFontFamily;", "createNamed-RetOiIg", "(Landroidx/compose/ui/text/font/GenericFontFamily;Landroidx/compose/ui/text/font/FontWeight;I)Landroid/graphics/Typeface;", "loadNamedFromTypefaceCacheOrNull", "familyName", "weight", "style", "loadNamedFromTypefaceCacheOrNull-RetOiIg", "optionalOnDeviceFontFamilyByName", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "context", "Landroid/content/Context;", "optionalOnDeviceFontFamilyByName-78DK7lM", "(Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;Landroid/content/Context;)Landroid/graphics/Typeface;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PlatformTypefacesApi28 implements PlatformTypefaces {
    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    /* renamed from: optionalOnDeviceFontFamilyByName-78DK7lM */
    public android.graphics.Typeface mo4848optionalOnDeviceFontFamilyByName78DK7lM(String familyName, FontWeight weight, int style, FontVariation.Settings variationSettings, Context context) {
        android.graphics.Typeface result;
        Intrinsics.checkNotNullParameter(familyName, "familyName");
        Intrinsics.checkNotNullParameter(weight, "weight");
        Intrinsics.checkNotNullParameter(variationSettings, "variationSettings");
        Intrinsics.checkNotNullParameter(context, "context");
        if (Intrinsics.areEqual(familyName, FontFamily.INSTANCE.getSansSerif().getName())) {
            result = mo4847createNamedRetOiIg(FontFamily.INSTANCE.getSansSerif(), weight, style);
        } else if (Intrinsics.areEqual(familyName, FontFamily.INSTANCE.getSerif().getName())) {
            result = mo4847createNamedRetOiIg(FontFamily.INSTANCE.getSerif(), weight, style);
        } else if (Intrinsics.areEqual(familyName, FontFamily.INSTANCE.getMonospace().getName())) {
            result = mo4847createNamedRetOiIg(FontFamily.INSTANCE.getMonospace(), weight, style);
        } else {
            result = Intrinsics.areEqual(familyName, FontFamily.INSTANCE.getCursive().getName()) ? mo4847createNamedRetOiIg(FontFamily.INSTANCE.getCursive(), weight, style) : m4854loadNamedFromTypefaceCacheOrNullRetOiIg(familyName, weight, style);
        }
        return PlatformTypefacesKt.setFontVariationSettings(result, variationSettings, context);
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    /* renamed from: createDefault-FO1MlWM */
    public android.graphics.Typeface mo4846createDefaultFO1MlWM(FontWeight fontWeight, int fontStyle) {
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        return m4852createAndroidTypefaceApi28RetOiIg(null, fontWeight, fontStyle);
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    /* renamed from: createNamed-RetOiIg */
    public android.graphics.Typeface mo4847createNamedRetOiIg(GenericFontFamily name, FontWeight fontWeight, int fontStyle) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        return m4852createAndroidTypefaceApi28RetOiIg(name.getName(), fontWeight, fontStyle);
    }

    /* renamed from: loadNamedFromTypefaceCacheOrNull-RetOiIg, reason: not valid java name */
    private final android.graphics.Typeface m4854loadNamedFromTypefaceCacheOrNullRetOiIg(String familyName, FontWeight weight, int style) {
        if (familyName.length() == 0) {
            return null;
        }
        android.graphics.Typeface typeface = m4852createAndroidTypefaceApi28RetOiIg(familyName, weight, style);
        boolean isItalic = FontStyle.m4821equalsimpl0(style, FontStyle.INSTANCE.m4825getItalic_LCdwA());
        TypefaceHelperMethodsApi28 typefaceHelperMethodsApi28 = TypefaceHelperMethodsApi28.INSTANCE;
        android.graphics.Typeface DEFAULT = android.graphics.Typeface.DEFAULT;
        Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
        if ((Intrinsics.areEqual(typeface, typefaceHelperMethodsApi28.create(DEFAULT, weight.getWeight(), isItalic)) || Intrinsics.areEqual(typeface, m4852createAndroidTypefaceApi28RetOiIg(null, weight, style))) ? false : true) {
            return typeface;
        }
        return null;
    }

    /* renamed from: createAndroidTypefaceApi28-RetOiIg$default, reason: not valid java name */
    static /* synthetic */ android.graphics.Typeface m4853createAndroidTypefaceApi28RetOiIg$default(PlatformTypefacesApi28 platformTypefacesApi28, String str, FontWeight fontWeight, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        return platformTypefacesApi28.m4852createAndroidTypefaceApi28RetOiIg(str, fontWeight, i);
    }

    /* renamed from: createAndroidTypefaceApi28-RetOiIg, reason: not valid java name */
    private final android.graphics.Typeface m4852createAndroidTypefaceApi28RetOiIg(String genericFontFamily, FontWeight fontWeight, int fontStyle) {
        android.graphics.Typeface familyTypeface;
        if (FontStyle.m4821equalsimpl0(fontStyle, FontStyle.INSTANCE.m4826getNormal_LCdwA()) && Intrinsics.areEqual(fontWeight, FontWeight.INSTANCE.getNormal())) {
            String str = genericFontFamily;
            if (str == null || str.length() == 0) {
                android.graphics.Typeface DEFAULT = android.graphics.Typeface.DEFAULT;
                Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
                return DEFAULT;
            }
        }
        if (genericFontFamily == null) {
            familyTypeface = android.graphics.Typeface.DEFAULT;
        } else {
            familyTypeface = android.graphics.Typeface.create(genericFontFamily, 0);
        }
        android.graphics.Typeface create = android.graphics.Typeface.create(familyTypeface, fontWeight.getWeight(), FontStyle.m4821equalsimpl0(fontStyle, FontStyle.INSTANCE.m4825getItalic_LCdwA()));
        Intrinsics.checkNotNullExpressionValue(create, "create(\n            fami…ontStyle.Italic\n        )");
        return create;
    }
}
