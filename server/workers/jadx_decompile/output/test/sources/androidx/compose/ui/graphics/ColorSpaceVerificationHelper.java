package androidx.compose.ui.graphics;

import android.graphics.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.DoubleFunction;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.graphics.colorspace.TransferParameters;
import androidx.compose.ui.graphics.colorspace.WhitePoint;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.function.DoubleUnaryOperator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidColorSpace.android.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0007J\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/graphics/ColorSpaceVerificationHelper;", "", "()V", "androidColorSpace", "Landroid/graphics/ColorSpace;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "composeColorSpace", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class ColorSpaceVerificationHelper {
    public static final ColorSpaceVerificationHelper INSTANCE = new ColorSpaceVerificationHelper();

    private ColorSpaceVerificationHelper() {
    }

    @JvmStatic
    public static final ColorSpace androidColorSpace(androidx.compose.ui.graphics.colorspace.ColorSpace $this$androidColorSpace) {
        ColorSpace colorSpace;
        ColorSpace.Rgb.TransferParameters transferParameters;
        ColorSpace.Rgb rgb;
        Intrinsics.checkNotNullParameter($this$androidColorSpace, "<this>");
        if (Intrinsics.areEqual($this$androidColorSpace, ColorSpaces.INSTANCE.getSrgb())) {
            ColorSpace colorSpace2 = ColorSpace.get(ColorSpace.Named.SRGB);
            Intrinsics.checkNotNullExpressionValue(colorSpace2, "get(android.graphics.ColorSpace.Named.SRGB)");
            return colorSpace2;
        }
        if (Intrinsics.areEqual($this$androidColorSpace, ColorSpaces.INSTANCE.getAces())) {
            ColorSpace colorSpace3 = ColorSpace.get(ColorSpace.Named.ACES);
            Intrinsics.checkNotNullExpressionValue(colorSpace3, "get(android.graphics.ColorSpace.Named.ACES)");
            return colorSpace3;
        }
        if (Intrinsics.areEqual($this$androidColorSpace, ColorSpaces.INSTANCE.getAcescg())) {
            ColorSpace colorSpace4 = ColorSpace.get(ColorSpace.Named.ACESCG);
            Intrinsics.checkNotNullExpressionValue(colorSpace4, "get(android.graphics.ColorSpace.Named.ACESCG)");
            return colorSpace4;
        }
        if (Intrinsics.areEqual($this$androidColorSpace, ColorSpaces.INSTANCE.getAdobeRgb())) {
            ColorSpace colorSpace5 = ColorSpace.get(ColorSpace.Named.ADOBE_RGB);
            Intrinsics.checkNotNullExpressionValue(colorSpace5, "get(android.graphics.ColorSpace.Named.ADOBE_RGB)");
            return colorSpace5;
        }
        if (Intrinsics.areEqual($this$androidColorSpace, ColorSpaces.INSTANCE.getBt2020())) {
            ColorSpace colorSpace6 = ColorSpace.get(ColorSpace.Named.BT2020);
            Intrinsics.checkNotNullExpressionValue(colorSpace6, "get(android.graphics.ColorSpace.Named.BT2020)");
            return colorSpace6;
        }
        if (Intrinsics.areEqual($this$androidColorSpace, ColorSpaces.INSTANCE.getBt709())) {
            ColorSpace colorSpace7 = ColorSpace.get(ColorSpace.Named.BT709);
            Intrinsics.checkNotNullExpressionValue(colorSpace7, "get(android.graphics.ColorSpace.Named.BT709)");
            return colorSpace7;
        }
        if (Intrinsics.areEqual($this$androidColorSpace, ColorSpaces.INSTANCE.getCieLab())) {
            ColorSpace colorSpace8 = ColorSpace.get(ColorSpace.Named.CIE_LAB);
            Intrinsics.checkNotNullExpressionValue(colorSpace8, "get(android.graphics.ColorSpace.Named.CIE_LAB)");
            return colorSpace8;
        }
        if (Intrinsics.areEqual($this$androidColorSpace, ColorSpaces.INSTANCE.getCieXyz())) {
            ColorSpace colorSpace9 = ColorSpace.get(ColorSpace.Named.CIE_XYZ);
            Intrinsics.checkNotNullExpressionValue(colorSpace9, "get(android.graphics.ColorSpace.Named.CIE_XYZ)");
            return colorSpace9;
        }
        if (Intrinsics.areEqual($this$androidColorSpace, ColorSpaces.INSTANCE.getDciP3())) {
            ColorSpace colorSpace10 = ColorSpace.get(ColorSpace.Named.DCI_P3);
            Intrinsics.checkNotNullExpressionValue(colorSpace10, "get(android.graphics.ColorSpace.Named.DCI_P3)");
            return colorSpace10;
        }
        if (Intrinsics.areEqual($this$androidColorSpace, ColorSpaces.INSTANCE.getDisplayP3())) {
            ColorSpace colorSpace11 = ColorSpace.get(ColorSpace.Named.DISPLAY_P3);
            Intrinsics.checkNotNullExpressionValue(colorSpace11, "get(android.graphics.ColorSpace.Named.DISPLAY_P3)");
            return colorSpace11;
        }
        if (Intrinsics.areEqual($this$androidColorSpace, ColorSpaces.INSTANCE.getExtendedSrgb())) {
            ColorSpace colorSpace12 = ColorSpace.get(ColorSpace.Named.EXTENDED_SRGB);
            Intrinsics.checkNotNullExpressionValue(colorSpace12, "get(android.graphics.Col…pace.Named.EXTENDED_SRGB)");
            return colorSpace12;
        }
        if (Intrinsics.areEqual($this$androidColorSpace, ColorSpaces.INSTANCE.getLinearExtendedSrgb())) {
            ColorSpace colorSpace13 = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
            Intrinsics.checkNotNullExpressionValue(colorSpace13, "get(android.graphics.Col…med.LINEAR_EXTENDED_SRGB)");
            return colorSpace13;
        }
        if (Intrinsics.areEqual($this$androidColorSpace, ColorSpaces.INSTANCE.getLinearSrgb())) {
            ColorSpace colorSpace14 = ColorSpace.get(ColorSpace.Named.LINEAR_SRGB);
            Intrinsics.checkNotNullExpressionValue(colorSpace14, "get(android.graphics.ColorSpace.Named.LINEAR_SRGB)");
            return colorSpace14;
        }
        if (Intrinsics.areEqual($this$androidColorSpace, ColorSpaces.INSTANCE.getNtsc1953())) {
            ColorSpace colorSpace15 = ColorSpace.get(ColorSpace.Named.NTSC_1953);
            Intrinsics.checkNotNullExpressionValue(colorSpace15, "get(android.graphics.ColorSpace.Named.NTSC_1953)");
            return colorSpace15;
        }
        if (Intrinsics.areEqual($this$androidColorSpace, ColorSpaces.INSTANCE.getProPhotoRgb())) {
            ColorSpace colorSpace16 = ColorSpace.get(ColorSpace.Named.PRO_PHOTO_RGB);
            Intrinsics.checkNotNullExpressionValue(colorSpace16, "get(android.graphics.Col…pace.Named.PRO_PHOTO_RGB)");
            return colorSpace16;
        }
        if (Intrinsics.areEqual($this$androidColorSpace, ColorSpaces.INSTANCE.getSmpteC())) {
            ColorSpace colorSpace17 = ColorSpace.get(ColorSpace.Named.SMPTE_C);
            Intrinsics.checkNotNullExpressionValue(colorSpace17, "get(android.graphics.ColorSpace.Named.SMPTE_C)");
            return colorSpace17;
        }
        if ($this$androidColorSpace instanceof Rgb) {
            float[] whitePointArray = ((Rgb) $this$androidColorSpace).getWhitePoint().toXyz$ui_graphics_release();
            TransferParameters transferParams = ((Rgb) $this$androidColorSpace).getTransferParameters();
            if (transferParams != null) {
                transferParameters = new ColorSpace.Rgb.TransferParameters(transferParams.getA(), transferParams.getB(), transferParams.getC(), transferParams.getD(), transferParams.getE(), transferParams.getF(), transferParams.getGamma());
            } else {
                transferParameters = null;
            }
            ColorSpace.Rgb.TransferParameters androidTransferParams = transferParameters;
            if (androidTransferParams != null) {
                rgb = new ColorSpace.Rgb($this$androidColorSpace.getName(), ((Rgb) $this$androidColorSpace).getPrimaries(), whitePointArray, androidTransferParams);
            } else {
                String name = $this$androidColorSpace.getName();
                float[] primaries = ((Rgb) $this$androidColorSpace).getPrimaries();
                final Function1<Double, Double> oetf = ((Rgb) $this$androidColorSpace).getOetf();
                DoubleUnaryOperator doubleUnaryOperator = new DoubleUnaryOperator() { // from class: androidx.compose.ui.graphics.ColorSpaceVerificationHelper$$ExternalSyntheticLambda0
                    @Override // java.util.function.DoubleUnaryOperator
                    public final double applyAsDouble(double d) {
                        double androidColorSpace$lambda$0;
                        androidColorSpace$lambda$0 = ColorSpaceVerificationHelper.androidColorSpace$lambda$0(Function1.this, d);
                        return androidColorSpace$lambda$0;
                    }
                };
                final Function1<Double, Double> eotf = ((Rgb) $this$androidColorSpace).getEotf();
                rgb = new ColorSpace.Rgb(name, primaries, whitePointArray, doubleUnaryOperator, new DoubleUnaryOperator() { // from class: androidx.compose.ui.graphics.ColorSpaceVerificationHelper$$ExternalSyntheticLambda1
                    @Override // java.util.function.DoubleUnaryOperator
                    public final double applyAsDouble(double d) {
                        double androidColorSpace$lambda$1;
                        androidColorSpace$lambda$1 = ColorSpaceVerificationHelper.androidColorSpace$lambda$1(Function1.this, d);
                        return androidColorSpace$lambda$1;
                    }
                }, $this$androidColorSpace.getMinValue(0), $this$androidColorSpace.getMaxValue(0));
            }
            colorSpace = rgb;
        } else {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        Intrinsics.checkNotNullExpressionValue(colorSpace, "{\n                if (th…          }\n            }");
        return colorSpace;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double androidColorSpace$lambda$0(Function1 tmp0, double p0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(Double.valueOf(p0))).doubleValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double androidColorSpace$lambda$1(Function1 tmp0, double p0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(Double.valueOf(p0))).doubleValue();
    }

    @JvmStatic
    public static final androidx.compose.ui.graphics.colorspace.ColorSpace composeColorSpace(final ColorSpace $this$composeColorSpace) {
        Rgb srgb;
        WhitePoint whitePoint;
        WhitePoint whitePoint2;
        TransferParameters composeTransferParams;
        Intrinsics.checkNotNullParameter($this$composeColorSpace, "<this>");
        int id = $this$composeColorSpace.getId();
        if (id == ColorSpace.Named.SRGB.ordinal()) {
            return ColorSpaces.INSTANCE.getSrgb();
        }
        if (id == ColorSpace.Named.ACES.ordinal()) {
            return ColorSpaces.INSTANCE.getAces();
        }
        if (id == ColorSpace.Named.ACESCG.ordinal()) {
            return ColorSpaces.INSTANCE.getAcescg();
        }
        if (id == ColorSpace.Named.ADOBE_RGB.ordinal()) {
            return ColorSpaces.INSTANCE.getAdobeRgb();
        }
        if (id == ColorSpace.Named.BT2020.ordinal()) {
            return ColorSpaces.INSTANCE.getBt2020();
        }
        if (id == ColorSpace.Named.BT709.ordinal()) {
            return ColorSpaces.INSTANCE.getBt709();
        }
        if (id == ColorSpace.Named.CIE_LAB.ordinal()) {
            return ColorSpaces.INSTANCE.getCieLab();
        }
        if (id == ColorSpace.Named.CIE_XYZ.ordinal()) {
            return ColorSpaces.INSTANCE.getCieXyz();
        }
        if (id == ColorSpace.Named.DCI_P3.ordinal()) {
            return ColorSpaces.INSTANCE.getDciP3();
        }
        if (id == ColorSpace.Named.DISPLAY_P3.ordinal()) {
            return ColorSpaces.INSTANCE.getDisplayP3();
        }
        if (id == ColorSpace.Named.EXTENDED_SRGB.ordinal()) {
            return ColorSpaces.INSTANCE.getExtendedSrgb();
        }
        if (id == ColorSpace.Named.LINEAR_EXTENDED_SRGB.ordinal()) {
            return ColorSpaces.INSTANCE.getLinearExtendedSrgb();
        }
        if (id == ColorSpace.Named.LINEAR_SRGB.ordinal()) {
            return ColorSpaces.INSTANCE.getLinearSrgb();
        }
        if (id == ColorSpace.Named.NTSC_1953.ordinal()) {
            return ColorSpaces.INSTANCE.getNtsc1953();
        }
        if (id == ColorSpace.Named.PRO_PHOTO_RGB.ordinal()) {
            return ColorSpaces.INSTANCE.getProPhotoRgb();
        }
        if (id == ColorSpace.Named.SMPTE_C.ordinal()) {
            return ColorSpaces.INSTANCE.getSmpteC();
        }
        if ($this$composeColorSpace instanceof ColorSpace.Rgb) {
            ColorSpace.Rgb.TransferParameters transferParams = ((ColorSpace.Rgb) $this$composeColorSpace).getTransferParameters();
            if (((ColorSpace.Rgb) $this$composeColorSpace).getWhitePoint().length == 3) {
                whitePoint = new WhitePoint(((ColorSpace.Rgb) $this$composeColorSpace).getWhitePoint()[0], ((ColorSpace.Rgb) $this$composeColorSpace).getWhitePoint()[1], ((ColorSpace.Rgb) $this$composeColorSpace).getWhitePoint()[2]);
            } else {
                whitePoint = new WhitePoint(((ColorSpace.Rgb) $this$composeColorSpace).getWhitePoint()[0], ((ColorSpace.Rgb) $this$composeColorSpace).getWhitePoint()[1]);
            }
            if (transferParams != null) {
                whitePoint2 = whitePoint;
                composeTransferParams = new TransferParameters(transferParams.g, transferParams.a, transferParams.b, transferParams.c, transferParams.d, transferParams.e, transferParams.f);
            } else {
                whitePoint2 = whitePoint;
                composeTransferParams = null;
            }
            String name = ((ColorSpace.Rgb) $this$composeColorSpace).getName();
            Intrinsics.checkNotNullExpressionValue(name, "this.name");
            float[] primaries = ((ColorSpace.Rgb) $this$composeColorSpace).getPrimaries();
            Intrinsics.checkNotNullExpressionValue(primaries, "this.primaries");
            srgb = new Rgb(name, primaries, whitePoint2, ((ColorSpace.Rgb) $this$composeColorSpace).getTransform(), new DoubleFunction() { // from class: androidx.compose.ui.graphics.ColorSpaceVerificationHelper$$ExternalSyntheticLambda2
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double invoke(double d) {
                    double composeColorSpace$lambda$2;
                    composeColorSpace$lambda$2 = ColorSpaceVerificationHelper.composeColorSpace$lambda$2($this$composeColorSpace, d);
                    return composeColorSpace$lambda$2;
                }
            }, new DoubleFunction() { // from class: androidx.compose.ui.graphics.ColorSpaceVerificationHelper$$ExternalSyntheticLambda3
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double invoke(double d) {
                    double composeColorSpace$lambda$3;
                    composeColorSpace$lambda$3 = ColorSpaceVerificationHelper.composeColorSpace$lambda$3($this$composeColorSpace, d);
                    return composeColorSpace$lambda$3;
                }
            }, $this$composeColorSpace.getMinValue(0), $this$composeColorSpace.getMaxValue(0), composeTransferParams, ((ColorSpace.Rgb) $this$composeColorSpace).getId());
        } else {
            srgb = ColorSpaces.INSTANCE.getSrgb();
        }
        return srgb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double composeColorSpace$lambda$2(ColorSpace this_composeColorSpace, double x) {
        Intrinsics.checkNotNullParameter(this_composeColorSpace, "$this_composeColorSpace");
        return ((ColorSpace.Rgb) this_composeColorSpace).getOetf().applyAsDouble(x);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double composeColorSpace$lambda$3(ColorSpace this_composeColorSpace, double x) {
        Intrinsics.checkNotNullParameter(this_composeColorSpace, "$this_composeColorSpace");
        return ((ColorSpace.Rgb) this_composeColorSpace).getEotf().applyAsDouble(x);
    }
}
