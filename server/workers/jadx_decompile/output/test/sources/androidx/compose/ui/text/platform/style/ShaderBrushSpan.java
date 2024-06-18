package androidx.compose.ui.text.platform.style;

import android.graphics.Shader;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.text.platform.AndroidTextPaint_androidKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShaderBrushSpan.android.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0082\u000eø\u0001\u0000¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR%\u0010\u0010\u001a\u00020\fX\u0086\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/text/platform/style/ShaderBrushSpan;", "Landroid/text/style/CharacterStyle;", "Landroid/text/style/UpdateAppearance;", "shaderBrush", "Landroidx/compose/ui/graphics/ShaderBrush;", "alpha", "", "(Landroidx/compose/ui/graphics/ShaderBrush;F)V", "getAlpha", "()F", "cachedShader", "Lkotlin/Pair;", "Landroidx/compose/ui/geometry/Size;", "Landroid/graphics/Shader;", "getShaderBrush", "()Landroidx/compose/ui/graphics/ShaderBrush;", "size", "getSize-NH-jbRc", "()J", "setSize-uvyYCjk", "(J)V", "J", "updateDrawState", "", "textPaint", "Landroid/text/TextPaint;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ShaderBrushSpan extends CharacterStyle implements UpdateAppearance {
    private final float alpha;
    private Pair<Size, ? extends Shader> cachedShader;
    private final ShaderBrush shaderBrush;
    private long size;

    public final ShaderBrush getShaderBrush() {
        return this.shaderBrush;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public ShaderBrushSpan(ShaderBrush shaderBrush, float alpha) {
        Intrinsics.checkNotNullParameter(shaderBrush, "shaderBrush");
        this.shaderBrush = shaderBrush;
        this.alpha = alpha;
        this.size = Size.INSTANCE.m2787getUnspecifiedNHjbRc();
    }

    /* renamed from: getSize-NH-jbRc, reason: not valid java name and from getter */
    public final long getSize() {
        return this.size;
    }

    /* renamed from: setSize-uvyYCjk, reason: not valid java name */
    public final void m4982setSizeuvyYCjk(long j) {
        this.size = j;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        Shader shader;
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        AndroidTextPaint_androidKt.setAlpha(textPaint, this.alpha);
        long $this$isUnspecified$iv = this.size;
        if ($this$isUnspecified$iv == Size.INSTANCE.m2787getUnspecifiedNHjbRc()) {
            return;
        }
        Pair finalCachedShader = this.cachedShader;
        if (finalCachedShader == null || !Size.m2775equalsimpl0(finalCachedShader.getFirst().getPackedValue(), this.size)) {
            shader = this.shaderBrush.mo2918createShaderuvyYCjk(this.size);
        } else {
            shader = finalCachedShader.getSecond();
        }
        textPaint.setShader(shader);
        this.cachedShader = TuplesKt.to(Size.m2767boximpl(this.size), shader);
    }
}