package androidx.compose.ui.text.platform;

import android.text.TextPaint;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.text.platform.extensions.TextPaintExtensions_androidKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidTextPaint.android.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J/\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u0005ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&J\u001b\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u001f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0010\u0010-\u001a\u00020\u001f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0010\u0010.\u001a\u00020\u001f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dR4\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f*\u0004\b\n\u0010\u000bR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0014\u001a\u00020\u00158\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006/"}, d2 = {"Landroidx/compose/ui/text/platform/AndroidTextPaint;", "Landroid/text/TextPaint;", "flags", "", "density", "", "(IF)V", "<set-?>", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "getBlendMode-0nO6VwU$delegate", "(Landroidx/compose/ui/text/platform/AndroidTextPaint;)Ljava/lang/Object;", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "composePaint", "Landroidx/compose/ui/graphics/Paint;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "getShadow$ui_text_release$annotations", "()V", "getShadow$ui_text_release", "()Landroidx/compose/ui/graphics/Shadow;", "setShadow$ui_text_release", "(Landroidx/compose/ui/graphics/Shadow;)V", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "setBrush", "", "brush", "Landroidx/compose/ui/graphics/Brush;", "size", "Landroidx/compose/ui/geometry/Size;", "alpha", "setBrush-12SF9DM", "(Landroidx/compose/ui/graphics/Brush;JF)V", "setColor", "color", "Landroidx/compose/ui/graphics/Color;", "setColor-8_81llA", "(J)V", "setDrawStyle", "setShadow", "setTextDecoration", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidTextPaint extends TextPaint {
    private final Paint composePaint;
    private DrawStyle drawStyle;
    private Shadow shadow;
    private TextDecoration textDecoration;

    public static /* synthetic */ void getShadow$ui_text_release$annotations() {
    }

    public AndroidTextPaint(int flags, float density) {
        super(flags);
        this.density = density;
        this.composePaint = AndroidPaint_androidKt.asComposePaint(this);
        this.textDecoration = TextDecoration.INSTANCE.getNone();
        this.shadow = Shadow.INSTANCE.getNone();
    }

    /* renamed from: getShadow$ui_text_release, reason: from getter */
    public final Shadow getShadow() {
        return this.shadow;
    }

    public final void setShadow$ui_text_release(Shadow shadow) {
        Intrinsics.checkNotNullParameter(shadow, "<set-?>");
        this.shadow = shadow;
    }

    public final void setTextDecoration(TextDecoration textDecoration) {
        if (textDecoration != null && !Intrinsics.areEqual(this.textDecoration, textDecoration)) {
            this.textDecoration = textDecoration;
            setUnderlineText(this.textDecoration.contains(TextDecoration.INSTANCE.getUnderline()));
            setStrikeThruText(this.textDecoration.contains(TextDecoration.INSTANCE.getLineThrough()));
        }
    }

    public final void setShadow(Shadow shadow) {
        if (shadow != null && !Intrinsics.areEqual(this.shadow, shadow)) {
            this.shadow = shadow;
            if (Intrinsics.areEqual(this.shadow, Shadow.INSTANCE.getNone())) {
                clearShadowLayer();
            } else {
                setShadowLayer(TextPaintExtensions_androidKt.correctBlurRadius(this.shadow.getBlurRadius()), Offset.m2710getXimpl(this.shadow.getOffset()), Offset.m2711getYimpl(this.shadow.getOffset()), ColorKt.m3003toArgb8_81llA(this.shadow.getColor()));
            }
        }
    }

    /* renamed from: setColor-8_81llA, reason: not valid java name */
    public final void m4964setColor8_81llA(long color) {
        if (color != Color.INSTANCE.m2985getUnspecified0d7_KjU()) {
            this.composePaint.mo2830setColor8_81llA(color);
            this.composePaint.setShader(null);
        }
    }

    /* renamed from: setBrush-12SF9DM$default, reason: not valid java name */
    public static /* synthetic */ void m4960setBrush12SF9DM$default(AndroidTextPaint androidTextPaint, Brush brush, long j, float f, int i, Object obj) {
        if ((i & 4) != 0) {
            f = Float.NaN;
        }
        androidTextPaint.m4963setBrush12SF9DM(brush, j, f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0049, code lost:
    
        r8.mo2896applyToPq9zytI(r9, r0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
    
        r1 = kotlin.ranges.RangesKt.coerceIn(r11, 0.0f, 1.0f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002f, code lost:
    
        if ((r9 != androidx.compose.ui.geometry.Size.INSTANCE.m2787getUnspecifiedNHjbRc()) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
    
        if ((r3 != androidx.compose.ui.graphics.Color.INSTANCE.m2985getUnspecified0d7_KjU() ? 1 : 0) == 0) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0033, code lost:
    
        r0 = r7.composePaint;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0039, code lost:
    
        if (java.lang.Float.isNaN(r11) == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x003b, code lost:
    
        r1 = r7.composePaint.getAlpha();
     */
    /* renamed from: setBrush-12SF9DM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m4963setBrush12SF9DM(androidx.compose.ui.graphics.Brush r8, long r9, float r11) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.compose.ui.graphics.SolidColor
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L1d
            r0 = r8
            androidx.compose.ui.graphics.SolidColor r0 = (androidx.compose.ui.graphics.SolidColor) r0
            long r3 = r0.getValue()
            r0 = 0
            androidx.compose.ui.graphics.Color$Companion r5 = androidx.compose.ui.graphics.Color.INSTANCE
            long r5 = r5.m2985getUnspecified0d7_KjU()
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 == 0) goto L1a
            r0 = r1
            goto L1b
        L1a:
            r0 = r2
        L1b:
            if (r0 != 0) goto L31
        L1d:
            boolean r0 = r8 instanceof androidx.compose.ui.graphics.ShaderBrush
            if (r0 == 0) goto L4d
            r3 = r9
            r0 = 0
            androidx.compose.ui.geometry.Size$Companion r5 = androidx.compose.ui.geometry.Size.INSTANCE
            long r5 = r5.m2787getUnspecifiedNHjbRc()
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 == 0) goto L2e
            goto L2f
        L2e:
            r1 = r2
        L2f:
            if (r1 == 0) goto L4d
        L31:
        L33:
            androidx.compose.ui.graphics.Paint r0 = r7.composePaint
            boolean r1 = java.lang.Float.isNaN(r11)
            if (r1 == 0) goto L42
            androidx.compose.ui.graphics.Paint r1 = r7.composePaint
            float r1 = r1.getAlpha()
            goto L49
        L42:
            r1 = 0
            r2 = 1065353216(0x3f800000, float:1.0)
            float r1 = kotlin.ranges.RangesKt.coerceIn(r11, r1, r2)
        L49:
            r8.mo2896applyToPq9zytI(r9, r0, r1)
            goto L55
        L4d:
            if (r8 != 0) goto L55
            androidx.compose.ui.graphics.Paint r0 = r7.composePaint
            r1 = 0
            r0.setShader(r1)
        L55:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.AndroidTextPaint.m4963setBrush12SF9DM(androidx.compose.ui.graphics.Brush, long, float):void");
    }

    public final void setDrawStyle(DrawStyle drawStyle) {
        if (drawStyle != null && !Intrinsics.areEqual(this.drawStyle, drawStyle)) {
            this.drawStyle = drawStyle;
            if (Intrinsics.areEqual(drawStyle, Fill.INSTANCE)) {
                this.composePaint.mo2834setStylek9PVt8s(PaintingStyle.INSTANCE.m3210getFillTiuSbCo());
                return;
            }
            if (drawStyle instanceof Stroke) {
                this.composePaint.mo2834setStylek9PVt8s(PaintingStyle.INSTANCE.m3211getStrokeTiuSbCo());
                this.composePaint.setStrokeWidth(((Stroke) drawStyle).getWidth());
                this.composePaint.setStrokeMiterLimit(((Stroke) drawStyle).getMiter());
                this.composePaint.mo2833setStrokeJoinWw9F2mQ(((Stroke) drawStyle).getJoin());
                this.composePaint.mo2832setStrokeCapBeK7IIE(((Stroke) drawStyle).getCap());
                this.composePaint.setPathEffect(((Stroke) drawStyle).getPathEffect());
            }
        }
    }

    /* renamed from: getBlendMode-0nO6VwU, reason: not valid java name */
    public final int m4961getBlendMode0nO6VwU() {
        return this.composePaint.get_blendMode();
    }

    /* renamed from: setBlendMode-s9anfk8, reason: not valid java name */
    public final void m4962setBlendModes9anfk8(int i) {
        this.composePaint.mo2829setBlendModes9anfk8(i);
    }
}
