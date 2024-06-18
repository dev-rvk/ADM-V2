package androidx.compose.ui.graphics.colorspace;

import androidx.autofill.HintConstants;
import androidx.compose.ui.graphics.ColorKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: Oklab.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001#B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J%\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0010¢\u0006\u0002\b\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J%\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0010¢\u0006\u0002\b\u0019J@\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u0001H\u0010ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b!\u0010\"R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\t\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006$"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Oklab;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", HintConstants.AUTOFILL_HINT_NAME, "", "id", "", "(Ljava/lang/String;I)V", "isWideGamut", "", "()Z", "fromXyz", "", "v", "getMaxValue", "", "component", "getMinValue", "toXy", "", "v0", "v1", "v2", "toXy$ui_graphics_release", "toXyz", "toZ", "toZ$ui_graphics_release", "xyzaToColor", "Landroidx/compose/ui/graphics/Color;", "x", "y", "z", "a", "colorSpace", "xyzaToColor-JlNiLsg$ui_graphics_release", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class Oklab extends ColorSpace {
    private static final float[] M1 = ColorSpaceKt.mul3x3(new float[]{0.818933f, 0.032984544f, 0.0482003f, 0.36186674f, 0.9293119f, 0.26436627f, -0.12885971f, 0.03614564f, 0.6338517f}, ColorSpaceKt.chromaticAdaptation(Adaptation.INSTANCE.getBradford().getTransform(), Illuminant.INSTANCE.getD50().toXyz$ui_graphics_release(), Illuminant.INSTANCE.getD65().toXyz$ui_graphics_release()));
    private static final float[] M2 = {0.21045426f, 1.9779985f, 0.025904037f, 0.7936178f, -2.4285922f, 0.78277177f, -0.004072047f, 0.4505937f, -0.80867577f};
    private static final float[] InverseM1 = ColorSpaceKt.inverse3x3(M1);
    private static final float[] InverseM2 = ColorSpaceKt.inverse3x3(M2);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Oklab(String name, int id) {
        super(name, ColorModel.INSTANCE.m3355getLabxdoWZVw(), id, null);
        Intrinsics.checkNotNullParameter(name, "name");
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* renamed from: isWideGamut */
    public boolean getIsWideGamut() {
        return true;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMinValue(int component) {
        return component == 0 ? 0.0f : -0.5f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int component) {
        return component == 0 ? 1.0f : 0.5f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] toXyz(float[] v) {
        Intrinsics.checkNotNullParameter(v, "v");
        v[0] = RangesKt.coerceIn(v[0], 0.0f, 1.0f);
        v[1] = RangesKt.coerceIn(v[1], -0.5f, 0.5f);
        v[2] = RangesKt.coerceIn(v[2], -0.5f, 0.5f);
        ColorSpaceKt.mul3x3Float3(InverseM2, v);
        v[0] = v[0] * v[0] * v[0];
        v[1] = v[1] * v[1] * v[1];
        v[2] = v[2] * v[2] * v[2];
        ColorSpaceKt.mul3x3Float3(InverseM1, v);
        return v;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long toXy$ui_graphics_release(float v0, float v1, float v2) {
        float v00 = RangesKt.coerceIn(v0, 0.0f, 1.0f);
        float v10 = RangesKt.coerceIn(v1, -0.5f, 0.5f);
        float v20 = RangesKt.coerceIn(v2, -0.5f, 0.5f);
        float v01 = ColorSpaceKt.mul3x3Float3_0(InverseM2, v00, v10, v20);
        float v11 = ColorSpaceKt.mul3x3Float3_1(InverseM2, v00, v10, v20);
        float v21 = ColorSpaceKt.mul3x3Float3_2(InverseM2, v00, v10, v20);
        float v02 = v01 * v01 * v01;
        float v12 = v11 * v11 * v11;
        float v22 = v21 * v21 * v21;
        float v03 = ColorSpaceKt.mul3x3Float3_0(InverseM1, v02, v12, v22);
        float v13 = ColorSpaceKt.mul3x3Float3_1(InverseM1, v02, v12, v22);
        long v1$iv = Float.floatToIntBits(v03);
        long v2$iv = Float.floatToIntBits(v13);
        return (v1$iv << 32) | (v2$iv & 4294967295L);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float toZ$ui_graphics_release(float v0, float v1, float v2) {
        float v00 = RangesKt.coerceIn(v0, 0.0f, 1.0f);
        float v10 = RangesKt.coerceIn(v1, -0.5f, 0.5f);
        float v20 = RangesKt.coerceIn(v2, -0.5f, 0.5f);
        float v01 = ColorSpaceKt.mul3x3Float3_0(InverseM2, v00, v10, v20);
        float v11 = ColorSpaceKt.mul3x3Float3_1(InverseM2, v00, v10, v20);
        float v21 = ColorSpaceKt.mul3x3Float3_2(InverseM2, v00, v10, v20);
        float v02 = v01 * v01 * v01;
        float v12 = v11 * v11 * v11;
        float v22 = v21 * v21 * v21;
        float v23 = ColorSpaceKt.mul3x3Float3_2(InverseM1, v02, v12, v22);
        return v23;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* renamed from: xyzaToColor-JlNiLsg$ui_graphics_release */
    public long mo3359xyzaToColorJlNiLsg$ui_graphics_release(float x, float y, float z, float a, ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        float v0 = ColorSpaceKt.mul3x3Float3_0(M1, x, y, z);
        float v1 = ColorSpaceKt.mul3x3Float3_1(M1, x, y, z);
        float v2 = ColorSpaceKt.mul3x3Float3_2(M1, x, y, z);
        double d = 0.33333334f;
        float v02 = Math.signum(v0) * ((float) Math.pow(Math.abs(v0), d));
        float v12 = Math.signum(v1) * ((float) Math.pow(Math.abs(v1), d));
        float v22 = Math.signum(v2) * ((float) Math.pow(Math.abs(v2), d));
        float v01 = ColorSpaceKt.mul3x3Float3_0(M2, v02, v12, v22);
        float v11 = ColorSpaceKt.mul3x3Float3_1(M2, v02, v12, v22);
        float v21 = ColorSpaceKt.mul3x3Float3_2(M2, v02, v12, v22);
        return ColorKt.Color(v01, v11, v21, a, colorSpace);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] fromXyz(float[] v) {
        Intrinsics.checkNotNullParameter(v, "v");
        ColorSpaceKt.mul3x3Float3(M1, v);
        double d = 0.33333334f;
        v[0] = Math.signum(v[0]) * ((float) Math.pow(Math.abs(v[0]), d));
        v[1] = Math.signum(v[1]) * ((float) Math.pow(Math.abs(v[1]), d));
        v[2] = Math.signum(v[2]) * ((float) Math.pow(Math.abs(v[2]), d));
        ColorSpaceKt.mul3x3Float3(M2, v);
        return v;
    }
}
