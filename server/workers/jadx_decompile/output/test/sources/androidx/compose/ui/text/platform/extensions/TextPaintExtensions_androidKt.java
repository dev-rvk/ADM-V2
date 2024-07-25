package androidx.compose.ui.text.platform.extensions;

import android.graphics.Typeface;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextPaintExtensions.android.kt */
@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a9\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000e\u001aS\u0010\u000f\u001a\u0004\u0018\u00010\u0004*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042&\u0010\u0012\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000ø\u0001\u0001\u001a\f\u0010\u001b\u001a\u00020\b*\u00020\u0004H\u0000\u001a\u0016\u0010\u001c\u001a\u00020\u001d*\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"correctBlurRadius", "", "blurRadius", "generateFallbackSpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "letterSpacing", "Landroidx/compose/ui/unit/TextUnit;", "requiresLetterSpacing", "", "background", "Landroidx/compose/ui/graphics/Color;", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "generateFallbackSpanStyle-62GTOB8", "(JZJLandroidx/compose/ui/text/style/BaselineShift;)Landroidx/compose/ui/text/SpanStyle;", "applySpanStyle", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "style", "resolveTypeface", "Lkotlin/Function4;", "Landroidx/compose/ui/text/font/FontFamily;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "Landroidx/compose/ui/text/font/FontSynthesis;", "Landroid/graphics/Typeface;", "density", "Landroidx/compose/ui/unit/Density;", "hasFontAttributes", "setTextMotion", "", "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextPaintExtensions_androidKt {
    public static /* synthetic */ SpanStyle applySpanStyle$default(AndroidTextPaint androidTextPaint, SpanStyle spanStyle, Function4 function4, Density density, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return applySpanStyle(androidTextPaint, spanStyle, function4, density, z);
    }

    public static final SpanStyle applySpanStyle(AndroidTextPaint $this$applySpanStyle, SpanStyle style, Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> resolveTypeface, Density density, boolean requiresLetterSpacing) {
        Intrinsics.checkNotNullParameter($this$applySpanStyle, "<this>");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(resolveTypeface, "resolveTypeface");
        Intrinsics.checkNotNullParameter(density, "density");
        long m5398getTypeUIouoOA = TextUnit.m5398getTypeUIouoOA(style.getFontSize());
        if (TextUnitType.m5427equalsimpl0(m5398getTypeUIouoOA, TextUnitType.INSTANCE.m5432getSpUIouoOA())) {
            $this$applySpanStyle.setTextSize(density.mo328toPxR2X_6o(style.getFontSize()));
        } else if (TextUnitType.m5427equalsimpl0(m5398getTypeUIouoOA, TextUnitType.INSTANCE.m5431getEmUIouoOA())) {
            $this$applySpanStyle.setTextSize($this$applySpanStyle.getTextSize() * TextUnit.m5399getValueimpl(style.getFontSize()));
        }
        if (hasFontAttributes(style)) {
            FontFamily fontFamily = style.getFontFamily();
            FontWeight fontWeight = style.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.INSTANCE.getNormal();
            }
            FontStyle fontStyle = style.getFontStyle();
            FontStyle m4818boximpl = FontStyle.m4818boximpl(fontStyle != null ? fontStyle.m4824unboximpl() : FontStyle.INSTANCE.m4826getNormal_LCdwA());
            FontSynthesis fontSynthesis = style.getFontSynthesis();
            $this$applySpanStyle.setTypeface(resolveTypeface.invoke(fontFamily, fontWeight, m4818boximpl, FontSynthesis.m4827boximpl(fontSynthesis != null ? fontSynthesis.getValue() : FontSynthesis.INSTANCE.m4836getAllGVVA2EU())));
        }
        if (style.getLocaleList() != null && !Intrinsics.areEqual(style.getLocaleList(), LocaleList.INSTANCE.getCurrent())) {
            LocaleListHelperMethods.INSTANCE.setTextLocales($this$applySpanStyle, style.getLocaleList());
        }
        if (style.getFontFeatureSettings() != null && !Intrinsics.areEqual(style.getFontFeatureSettings(), "")) {
            $this$applySpanStyle.setFontFeatureSettings(style.getFontFeatureSettings());
        }
        if (style.getTextGeometricTransform() != null && !Intrinsics.areEqual(style.getTextGeometricTransform(), TextGeometricTransform.INSTANCE.getNone$ui_text_release())) {
            $this$applySpanStyle.setTextScaleX($this$applySpanStyle.getTextScaleX() * style.getTextGeometricTransform().getScaleX());
            $this$applySpanStyle.setTextSkewX($this$applySpanStyle.getTextSkewX() + style.getTextGeometricTransform().getSkewX());
        }
        $this$applySpanStyle.m4964setColor8_81llA(style.m4685getColor0d7_KjU());
        $this$applySpanStyle.m4963setBrush12SF9DM(style.getBrush(), Size.INSTANCE.m2787getUnspecifiedNHjbRc(), style.getAlpha());
        $this$applySpanStyle.setShadow(style.getShadow());
        $this$applySpanStyle.setTextDecoration(style.getTextDecoration());
        $this$applySpanStyle.setDrawStyle(style.getDrawStyle());
        if (TextUnitType.m5427equalsimpl0(TextUnit.m5398getTypeUIouoOA(style.getLetterSpacing()), TextUnitType.INSTANCE.m5432getSpUIouoOA())) {
            if (!(TextUnit.m5399getValueimpl(style.getLetterSpacing()) == 0.0f)) {
                float emWidth = $this$applySpanStyle.getTextSize() * $this$applySpanStyle.getTextScaleX();
                float letterSpacingPx = density.mo328toPxR2X_6o(style.getLetterSpacing());
                if (!(emWidth == 0.0f)) {
                    $this$applySpanStyle.setLetterSpacing(letterSpacingPx / emWidth);
                }
                return m4978generateFallbackSpanStyle62GTOB8(style.getLetterSpacing(), requiresLetterSpacing, style.getBackground(), style.getBaselineShift());
            }
        }
        if (TextUnitType.m5427equalsimpl0(TextUnit.m5398getTypeUIouoOA(style.getLetterSpacing()), TextUnitType.INSTANCE.m5431getEmUIouoOA())) {
            $this$applySpanStyle.setLetterSpacing(TextUnit.m5399getValueimpl(style.getLetterSpacing()));
        }
        return m4978generateFallbackSpanStyle62GTOB8(style.getLetterSpacing(), requiresLetterSpacing, style.getBackground(), style.getBaselineShift());
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0053, code lost:
    
        if (androidx.compose.ui.text.style.BaselineShift.m4986equalsimpl0(r36.m4989unboximpl(), androidx.compose.ui.text.style.BaselineShift.INSTANCE.m4993getNoney9eOQZs()) == false) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0064  */
    /* renamed from: generateFallbackSpanStyle-62GTOB8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final androidx.compose.ui.text.SpanStyle m4978generateFallbackSpanStyle62GTOB8(long r31, boolean r33, long r34, androidx.compose.ui.text.style.BaselineShift r36) {
        /*
            r0 = r34
            r2 = 1
            r3 = 0
            if (r33 == 0) goto L26
            long r4 = androidx.compose.ui.unit.TextUnit.m5398getTypeUIouoOA(r31)
            androidx.compose.ui.unit.TextUnitType$Companion r6 = androidx.compose.ui.unit.TextUnitType.INSTANCE
            long r6 = r6.m5432getSpUIouoOA()
            boolean r4 = androidx.compose.ui.unit.TextUnitType.m5427equalsimpl0(r4, r6)
            if (r4 == 0) goto L26
            float r4 = androidx.compose.ui.unit.TextUnit.m5399getValueimpl(r31)
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 != 0) goto L21
            r4 = r2
            goto L22
        L21:
            r4 = r3
        L22:
            if (r4 != 0) goto L26
            r4 = r2
            goto L27
        L26:
            r4 = r3
        L27:
            androidx.compose.ui.graphics.Color$Companion r5 = androidx.compose.ui.graphics.Color.INSTANCE
            long r5 = r5.m2985getUnspecified0d7_KjU()
            boolean r5 = androidx.compose.ui.graphics.Color.m2950equalsimpl0(r0, r5)
            if (r5 != 0) goto L42
            androidx.compose.ui.graphics.Color$Companion r5 = androidx.compose.ui.graphics.Color.INSTANCE
            long r5 = r5.m2984getTransparent0d7_KjU()
            boolean r5 = androidx.compose.ui.graphics.Color.m2950equalsimpl0(r0, r5)
            if (r5 != 0) goto L42
            r5 = r2
            goto L43
        L42:
            r5 = r3
        L43:
            if (r36 == 0) goto L56
            androidx.compose.ui.text.style.BaselineShift$Companion r6 = androidx.compose.ui.text.style.BaselineShift.INSTANCE
            float r6 = r6.m4993getNoney9eOQZs()
            float r7 = r36.m4989unboximpl()
            boolean r6 = androidx.compose.ui.text.style.BaselineShift.m4986equalsimpl0(r7, r6)
            if (r6 != 0) goto L56
            goto L57
        L56:
            r2 = r3
        L57:
            r3 = 0
            if (r4 != 0) goto L5f
            if (r5 != 0) goto L5f
            if (r2 != 0) goto L5f
            goto La6
        L5f:
            if (r4 == 0) goto L64
            r18 = r31
            goto L6c
        L64:
            androidx.compose.ui.unit.TextUnit$Companion r6 = androidx.compose.ui.unit.TextUnit.INSTANCE
            long r6 = r6.m5410getUnspecifiedXSAIIZE()
            r18 = r6
        L6c:
            if (r5 == 0) goto L71
            r23 = r0
            goto L79
        L71:
            androidx.compose.ui.graphics.Color$Companion r6 = androidx.compose.ui.graphics.Color.INSTANCE
            long r6 = r6.m2985getUnspecified0d7_KjU()
            r23 = r6
        L79:
            if (r2 == 0) goto L7e
            r20 = r36
            goto L80
        L7e:
            r20 = r3
        L80:
            androidx.compose.ui.text.SpanStyle r3 = new androidx.compose.ui.text.SpanStyle
            r8 = r3
            r29 = 63103(0xf67f, float:8.8426E-41)
            r30 = 0
            r9 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r21 = 0
            r22 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r8.<init>(r9, r11, r13, r14, r15, r16, r17, r18, r20, r21, r22, r23, r25, r26, r27, r28, r29, r30)
        La6:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.extensions.TextPaintExtensions_androidKt.m4978generateFallbackSpanStyle62GTOB8(long, boolean, long, androidx.compose.ui.text.style.BaselineShift):androidx.compose.ui.text.SpanStyle");
    }

    public static final void setTextMotion(AndroidTextPaint $this$setTextMotion, TextMotion textMotion) {
        int flags;
        Intrinsics.checkNotNullParameter($this$setTextMotion, "<this>");
        TextMotion finalTextMotion = textMotion == null ? TextMotion.INSTANCE.getStatic() : textMotion;
        if (finalTextMotion.getSubpixelTextPositioning()) {
            flags = $this$setTextMotion.getFlags() | 128;
        } else {
            flags = $this$setTextMotion.getFlags() & (-129);
        }
        $this$setTextMotion.setFlags(flags);
        int linearity = finalTextMotion.getLinearity();
        if (TextMotion.Linearity.m5120equalsimpl0(linearity, TextMotion.Linearity.INSTANCE.m5125getLinear4e0Vf04())) {
            $this$setTextMotion.setFlags($this$setTextMotion.getFlags() | 64);
            $this$setTextMotion.setHinting(0);
        } else if (TextMotion.Linearity.m5120equalsimpl0(linearity, TextMotion.Linearity.INSTANCE.m5124getFontHinting4e0Vf04())) {
            $this$setTextMotion.getFlags();
            $this$setTextMotion.setHinting(1);
        } else if (TextMotion.Linearity.m5120equalsimpl0(linearity, TextMotion.Linearity.INSTANCE.m5126getNone4e0Vf04())) {
            $this$setTextMotion.getFlags();
            $this$setTextMotion.setHinting(0);
        } else {
            $this$setTextMotion.getFlags();
        }
    }

    public static final boolean hasFontAttributes(SpanStyle $this$hasFontAttributes) {
        Intrinsics.checkNotNullParameter($this$hasFontAttributes, "<this>");
        return ($this$hasFontAttributes.getFontFamily() == null && $this$hasFontAttributes.getFontStyle() == null && $this$hasFontAttributes.getFontWeight() == null) ? false : true;
    }

    public static final float correctBlurRadius(float blurRadius) {
        if (blurRadius == 0.0f) {
            return Float.MIN_VALUE;
        }
        return blurRadius;
    }
}
