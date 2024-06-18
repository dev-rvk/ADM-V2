package androidx.compose.ui.graphics;

import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.os.Build;
import androidx.compose.ui.geometry.Offset;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidShader.android.kt */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u001aO\u0010\n\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u0006H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001aO\u0010\u0016\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00122\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u0006H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001a?\u0010\u001b\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0017\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000fH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0019\u0010\u001e\u001a\u00020\u001f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0001ø\u0001\u0001\u001a!\u0010 \u001a\u00020!2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\"\u001a\u00020\u001fH\u0001ø\u0001\u0001\u001a3\u0010#\u001a\u0004\u0018\u00010$2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\"\u001a\u00020\u001fH\u0001ø\u0001\u0001\u001a)\u0010&\u001a\u00020'2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000fH\u0002ø\u0001\u0001*\n\u0010(\"\u00020\u00012\u00020\u0001\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006)"}, d2 = {"ActualImageShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "tileModeX", "Landroidx/compose/ui/graphics/TileMode;", "tileModeY", "ActualImageShader-F49vj9s", "(Landroidx/compose/ui/graphics/ImageBitmap;II)Landroid/graphics/Shader;", "ActualLinearGradientShader", "from", "Landroidx/compose/ui/geometry/Offset;", "to", "colors", "", "Landroidx/compose/ui/graphics/Color;", "colorStops", "", "tileMode", "ActualLinearGradientShader-VjE6UOU", "(JJLjava/util/List;Ljava/util/List;I)Landroid/graphics/Shader;", "ActualRadialGradientShader", "center", "radius", "ActualRadialGradientShader-8uybcMk", "(JFLjava/util/List;Ljava/util/List;I)Landroid/graphics/Shader;", "ActualSweepGradientShader", "ActualSweepGradientShader-9KIMszo", "(JLjava/util/List;Ljava/util/List;)Landroid/graphics/Shader;", "countTransparentColors", "", "makeTransparentColors", "", "numTransparentColors", "makeTransparentStops", "", "stops", "validateColorStops", "", "Shader", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidShader_androidKt {
    /* renamed from: ActualLinearGradientShader-VjE6UOU, reason: not valid java name */
    public static final Shader m2852ActualLinearGradientShaderVjE6UOU(long from, long to, List<Color> colors, List<Float> list, int tileMode) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        validateColorStops(colors, list);
        int numTransparentColors = countTransparentColors(colors);
        return new android.graphics.LinearGradient(Offset.m2710getXimpl(from), Offset.m2711getYimpl(from), Offset.m2710getXimpl(to), Offset.m2711getYimpl(to), makeTransparentColors(colors, numTransparentColors), makeTransparentStops(list, colors, numTransparentColors), AndroidTileMode_androidKt.m2856toAndroidTileMode0vamqd0(tileMode));
    }

    /* renamed from: ActualRadialGradientShader-8uybcMk, reason: not valid java name */
    public static final Shader m2853ActualRadialGradientShader8uybcMk(long center, float radius, List<Color> colors, List<Float> list, int tileMode) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        validateColorStops(colors, list);
        int numTransparentColors = countTransparentColors(colors);
        return new android.graphics.RadialGradient(Offset.m2710getXimpl(center), Offset.m2711getYimpl(center), radius, makeTransparentColors(colors, numTransparentColors), makeTransparentStops(list, colors, numTransparentColors), AndroidTileMode_androidKt.m2856toAndroidTileMode0vamqd0(tileMode));
    }

    /* renamed from: ActualSweepGradientShader-9KIMszo, reason: not valid java name */
    public static final Shader m2854ActualSweepGradientShader9KIMszo(long center, List<Color> colors, List<Float> list) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        validateColorStops(colors, list);
        int numTransparentColors = countTransparentColors(colors);
        return new android.graphics.SweepGradient(Offset.m2710getXimpl(center), Offset.m2711getYimpl(center), makeTransparentColors(colors, numTransparentColors), makeTransparentStops(list, colors, numTransparentColors));
    }

    /* renamed from: ActualImageShader-F49vj9s, reason: not valid java name */
    public static final Shader m2851ActualImageShaderF49vj9s(ImageBitmap image, int tileModeX, int tileModeY) {
        Intrinsics.checkNotNullParameter(image, "image");
        return new BitmapShader(AndroidImageBitmap_androidKt.asAndroidBitmap(image), AndroidTileMode_androidKt.m2856toAndroidTileMode0vamqd0(tileModeX), AndroidTileMode_androidKt.m2856toAndroidTileMode0vamqd0(tileModeY));
    }

    public static final int countTransparentColors(List<Color> colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        if (Build.VERSION.SDK_INT >= 26) {
            return 0;
        }
        int numTransparentColors = 0;
        int lastIndex = CollectionsKt.getLastIndex(colors);
        for (int i = 1; i < lastIndex; i++) {
            if (Color.m2951getAlphaimpl(colors.get(i).m2959unboximpl()) == 0.0f) {
                numTransparentColors++;
            }
        }
        return numTransparentColors;
    }

    public static final int[] makeTransparentColors(List<Color> colors, int numTransparentColors) {
        long m2947copywmQWz5c;
        long m2947copywmQWz5c2;
        long m2947copywmQWz5c3;
        long m2947copywmQWz5c4;
        Intrinsics.checkNotNullParameter(colors, "colors");
        if (Build.VERSION.SDK_INT >= 26) {
            int size = colors.size();
            int[] iArr = new int[size];
            for (int i = 0; i < size; i++) {
                iArr[i] = ColorKt.m3003toArgb8_81llA(colors.get(i).m2959unboximpl());
            }
            return iArr;
        }
        int[] values = new int[colors.size() + numTransparentColors];
        int valuesIndex = 0;
        int lastIndex = CollectionsKt.getLastIndex(colors);
        int size2 = colors.size();
        for (int index$iv = 0; index$iv < size2; index$iv++) {
            Object item$iv = colors.get(index$iv);
            long color = ((Color) item$iv).m2959unboximpl();
            int index = index$iv;
            if (Color.m2951getAlphaimpl(color) == 0.0f) {
                if (index != 0) {
                    if (index != lastIndex) {
                        int valuesIndex2 = index - 1;
                        long previousColor = colors.get(valuesIndex2).m2959unboximpl();
                        int valuesIndex3 = valuesIndex + 1;
                        m2947copywmQWz5c = Color.m2947copywmQWz5c(previousColor, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(previousColor) : 0.0f, (r12 & 2) != 0 ? Color.m2955getRedimpl(previousColor) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(previousColor) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(previousColor) : 0.0f);
                        values[valuesIndex] = ColorKt.m3003toArgb8_81llA(m2947copywmQWz5c);
                        long nextColor = colors.get(index + 1).m2959unboximpl();
                        valuesIndex = valuesIndex3 + 1;
                        m2947copywmQWz5c2 = Color.m2947copywmQWz5c(nextColor, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(nextColor) : 0.0f, (r12 & 2) != 0 ? Color.m2955getRedimpl(nextColor) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(nextColor) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(nextColor) : 0.0f);
                        values[valuesIndex3] = ColorKt.m3003toArgb8_81llA(m2947copywmQWz5c2);
                    } else {
                        m2947copywmQWz5c3 = Color.m2947copywmQWz5c(r16, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r16) : 0.0f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r16) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r16) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(colors.get(index - 1).m2959unboximpl()) : 0.0f);
                        values[valuesIndex] = ColorKt.m3003toArgb8_81llA(m2947copywmQWz5c3);
                        valuesIndex++;
                    }
                } else {
                    m2947copywmQWz5c4 = Color.m2947copywmQWz5c(r16, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r16) : 0.0f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r16) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r16) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(colors.get(1).m2959unboximpl()) : 0.0f);
                    values[valuesIndex] = ColorKt.m3003toArgb8_81llA(m2947copywmQWz5c4);
                    valuesIndex++;
                }
            } else {
                values[valuesIndex] = ColorKt.m3003toArgb8_81llA(color);
                valuesIndex++;
            }
        }
        return values;
    }

    public static final float[] makeTransparentStops(List<Float> list, List<Color> colors, int numTransparentColors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        if (numTransparentColors == 0) {
            if (list != null) {
                return CollectionsKt.toFloatArray(list);
            }
            return null;
        }
        float[] newStops = new float[colors.size() + numTransparentColors];
        newStops[0] = list != null ? list.get(0).floatValue() : 0.0f;
        int newStopsIndex = 1;
        int lastIndex = CollectionsKt.getLastIndex(colors);
        for (int i = 1; i < lastIndex; i++) {
            long color = colors.get(i).m2959unboximpl();
            float stop = list != null ? list.get(i).floatValue() : i / CollectionsKt.getLastIndex(colors);
            int newStopsIndex2 = newStopsIndex + 1;
            newStops[newStopsIndex] = stop;
            if (!(Color.m2951getAlphaimpl(color) == 0.0f)) {
                newStopsIndex = newStopsIndex2;
            } else {
                newStopsIndex = newStopsIndex2 + 1;
                newStops[newStopsIndex2] = stop;
            }
        }
        newStops[newStopsIndex] = list != null ? list.get(CollectionsKt.getLastIndex(colors)).floatValue() : 1.0f;
        return newStops;
    }

    private static final void validateColorStops(List<Color> list, List<Float> list2) {
        if (list2 == null) {
            if (list.size() < 2) {
                throw new IllegalArgumentException("colors must have length of at least 2 if colorStops is omitted.");
            }
        } else if (list.size() != list2.size()) {
            throw new IllegalArgumentException("colors and colorStops arguments must have equal length.");
        }
    }
}
